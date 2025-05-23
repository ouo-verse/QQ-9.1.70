package com.tencent.imcore.message;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.f;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ej;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes7.dex */
public class MsgProxyCallback implements f.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f116427a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66096);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            f116427a = 1;
        }
    }

    public MsgProxyCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean B(MessageRecord messageRecord) {
        int i3;
        com.tencent.mobileqq.graytip.g gVar;
        int i16;
        if (messageRecord == null) {
            return false;
        }
        if ((!(messageRecord instanceof MessageForUniteGrayTip) || (gVar = ((MessageForUniteGrayTip) messageRecord).tipParam) == null || ((i16 = gVar.f213685h) != 3211265 && i16 != 655392 && i16 != 4194307)) && (i3 = messageRecord.msgtype) != -4021 && i3 != -7012 && i3 != -7015) {
            return false;
        }
        return true;
    }

    private void C(AppRuntime appRuntime) {
        com.tencent.mobileqq.managers.g gVar = (com.tencent.mobileqq.managers.g) appRuntime.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
        gVar.C = null;
        gVar.D = null;
    }

    private void D(String str, MessageRecord messageRecord, List<MessageRecord> list) {
        if (str.equals(AppConstants.SYSTEM_MSG_UIN)) {
            list.add(0, messageRecord);
        } else if (B(messageRecord)) {
            ad.o(list, messageRecord, true);
        } else {
            list.add(messageRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void F(AppRuntime appRuntime, String str, int i3, StatisticCollector.ReportContext reportContext, long j3) {
        if (TextUtils.equals(reportContext.optsceneTag, "launch")) {
            long nanoTime = (System.nanoTime() - j3) / 1000;
            long j16 = reportContext.opttotalcostTag + nanoTime;
            reportContext.opttotalcostTag = j16;
            int i16 = reportContext.optcountTag + 1;
            reportContext.optcountTag = i16;
            reportContext.optmsgcountTag++;
            reportContext.optonecostTag = j16 / i16;
            if (StatisticCollector.NEEDCOUNTTRANS && QLog.isColorLevel() && ad.E(str, i3)) {
                QLog.d("Q.msg.MsgProxy", 2, "SQLCost|" + appRuntime.getAccount() + "|select|launch|1|" + (nanoTime / 1000) + "|" + str);
                return;
            }
            return;
        }
        if (TextUtils.equals(reportContext.optsceneTag, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO)) {
            long nanoTime2 = (System.nanoTime() - j3) / 1000;
            reportContext.opttotalcostTag = nanoTime2;
            reportContext.optcountTag = 1;
            reportContext.optmsgcountTag = 1;
            reportContext.optonecostTag = nanoTime2 / 1;
            if (StatisticCollector.NEEDCOUNTTRANS && QLog.isColorLevel() && ad.E(str, i3)) {
                QLog.d("Q.msg.MsgProxy", 2, "SQLCost|" + appRuntime.getAccount() + "|select|AIO|1|" + (nanoTime2 / 1000) + "|" + str);
                return;
            }
            return;
        }
        long nanoTime3 = (System.nanoTime() - j3) / 1000;
        if ((Looper.myLooper() == Looper.getMainLooper()) && StatisticCollector.sqlite3Optimizereport() && StatisticCollector.getSqliteSwitchBySample(2)) {
            reportContext.mainthreadTag = 1;
            reportContext.opttypeTag = "select";
            reportContext.optsceneTag = "mainThread";
            reportContext.opttotalcostTag = nanoTime3;
            reportContext.optcountTag = 1;
            reportContext.optmsgcountTag = 1;
            reportContext.optonecostTag = nanoTime3 / 1;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(StatisticCollector.SqliteOptCostInfo.MAINTHREAD_TAG, String.valueOf(reportContext.mainthreadTag));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTYPE_TAG, reportContext.opttypeTag);
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTTOTALCOST_TAG, String.valueOf(reportContext.opttotalcostTag));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTCOUNT_TAG, String.valueOf(reportContext.optcountTag));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTMSGCOUNT_TAG, String.valueOf(reportContext.optmsgcountTag));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTONECOST_TAG, String.valueOf(reportContext.optonecostTag));
            hashMap.put(StatisticCollector.SqliteOptCostInfo.OPTSCENE_TAG, reportContext.optsceneTag);
            hashMap.put(StatisticCollector.SqliteOptCostInfo.WALSWITCH_TAG, String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.SQLITE_OPERATE_COST, true, reportContext.optmsgcountTag, 0L, hashMap, (String) null, false);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void A(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), list, list2, appRuntime);
            return;
        }
        for (MessageRecord messageRecord : list) {
            if (messageRecord instanceof MessageForPoke) {
                MessageForPoke messageForPoke = (MessageForPoke) messageRecord;
                if (!messageForPoke.isPlayed) {
                    messageForPoke.setPlayed((QQAppInterface) appRuntime);
                }
            }
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        if (com.tencent.mobileqq.managers.g.g(qQAppInterface, i3, str)) {
            r.a(qQAppInterface.getMessageFacade().F(i3), qQAppInterface, list, list, true, false);
        }
        if (i3 == 0 && list2.size() > 0 && com.tencent.mobileqq.graytip.f.e(list2.get(0))) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ad.o(list2, list.get(size), true);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "onAddAIOMessageLocked insertToList friend. list size: ", Integer.valueOf(list.size()));
                return;
            }
            return;
        }
        int size2 = list.size();
        for (int i16 = 0; i16 < size2; i16++) {
            ad.o(list2, list.get(i16), true);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "onAddAIOMessageLocked insertToList other. list size: ", Integer.valueOf(list.size()));
        }
    }

    protected void E(String str, String str2, List<MessageRecord> list, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, str, str2, list, Long.valueOf(j3));
            return;
        }
        if (ej.a()) {
            e.c cVar = com.tencent.mobileqq.service.message.e.U0.get(str2);
            if (cVar == null) {
                cVar = new e.c();
            }
            cVar.f286248a = str;
            cVar.f286249b = false;
            cVar.f286250c = !list.isEmpty();
            cVar.f286251d = (System.nanoTime() - j3) / 1000000;
            com.tencent.mobileqq.service.message.e.U0.put(str2, cVar);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void a(y yVar, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) yVar, (Object) appRuntime);
            return;
        }
        String[] allTableNameFromCache = yVar.P1().getAllTableNameFromCache();
        if (allTableNameFromCache == null) {
            return;
        }
        QSlowTableManager qSlowTableManager = (QSlowTableManager) appRuntime.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
        for (String str : allTableNameFromCache) {
            if (qSlowTableManager != null) {
                qSlowTableManager.b(str, null, null);
            }
        }
        ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onClearAllMsg(appRuntime.getCurrentUin());
    }

    @Override // com.tencent.imcore.message.f.a
    public void b(AppRuntime appRuntime, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, Integer.valueOf(i3));
        } else if (appRuntime instanceof QQAppInterface) {
            com.tencent.mobileqq.app.message.j.d((QQAppInterface) appRuntime, str, i3);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public List<MessageRecord> c(String str, String[] strArr, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, this, str, strArr, fVar);
        }
        return ((com.tencent.mobileqq.persistence.g) fVar.D()).e(str, strArr);
    }

    @Override // com.tencent.imcore.message.f.a
    public void d(String str, int i3, String str2, List<MessageRecord> list, long j3, y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, Integer.valueOf(i3), str2, list, Long.valueOf(j3), yVar);
            return;
        }
        E(str, str2, list, j3);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getMsgList1 uin ");
            sb5.append(str);
            sb5.append(" , type = ");
            sb5.append(i3);
            sb5.append(" itemList size=");
            sb5.append(list.size());
            int i16 = f116427a;
            if (i16 % 20 == 0 && i16 > 100) {
                sb5.append("\n");
                sb5.append(QLog.getStackTraceString(new Throwable("MsgProxy_getMsgList1")));
            }
            QLog.d("Q.msg.MsgProxy", 2, sb5.toString());
            f116427a++;
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void e(String str, int i3, boolean z16, y yVar, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), yVar, appRuntime);
            return;
        }
        if (!z16) {
            return;
        }
        ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onClearHistory(str, i3);
        QSlowTableManager qSlowTableManager = (QSlowTableManager) appRuntime.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.post(new Runnable(qSlowTableManager, yVar, str, i3) { // from class: com.tencent.imcore.message.MsgProxyCallback.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QSlowTableManager f116428d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ y f116429e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f116430f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f116431h;

                {
                    this.f116428d = qSlowTableManager;
                    this.f116429e = yVar;
                    this.f116430f = str;
                    this.f116431h = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MsgProxyCallback.this, qSlowTableManager, yVar, str, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        QSlowTableManager qSlowTableManager2 = this.f116428d;
                        if (qSlowTableManager2 != null) {
                            qSlowTableManager2.b(this.f116429e.N1(this.f116430f, this.f116431h), null, null);
                        }
                    } catch (RuntimeException e16) {
                        QLog.e("Q.msg.MsgProxy", 1, "delete slowtable excep :", e16);
                    }
                }
            }, 10, null, false);
        } else if (qSlowTableManager != null) {
            qSlowTableManager.b(yVar.N1(str, i3), null, null);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void f(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), list);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public List<MessageRecord> g(String str, int i3, long j3, int i16, String str2, String[] strArr, y yVar, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), str2, strArr, yVar, appRuntime);
        }
        QSlowTableManager qSlowTableManager = (QSlowTableManager) appRuntime.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
        if (qSlowTableManager != null) {
            List<MessageRecord> e16 = qSlowTableManager.e().e(str2 + i16, strArr);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("queryBeforeHistoryByShmsgseq list2.size=");
                if (e16 != null) {
                    i17 = e16.size();
                }
                sb5.append(i17);
                QLog.d("Q.msg.MsgProxy", 2, sb5.toString());
            }
            return e16;
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f.a
    public EntityManager h(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EntityManager) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        if (appRuntime instanceof QQAppInterface) {
            return (com.tencent.mobileqq.persistence.g) ((QQAppInterface) appRuntime).getEntityManagerFactory().a();
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f.a
    public SQLiteDatabase i(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime);
        }
        return ((QQAppInterface) appRuntime).getWritableDatabase();
    }

    @Override // com.tencent.imcore.message.f.a
    public void j(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) appRuntime);
        } else {
            C(appRuntime);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void k(String str, MessageRecord messageRecord, List<MessageRecord> list, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, str, messageRecord, list, fVar);
        } else {
            D(str, messageRecord, list);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public boolean l(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return ad.B(messageRecord);
    }

    @Override // com.tencent.imcore.message.f.a
    public void m(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), list);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public Object n(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
        }
        return ((QQAppInterface) appRuntime).getProxyManager().transSaveLock;
    }

    @Override // com.tencent.imcore.message.f.a
    public boolean o(String str, int i3, String str2, y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), str2, yVar)).booleanValue();
        }
        boolean isSessionOrderSending = ((IOrderMediaMsgService) yVar.m1().getRuntimeService(IOrderMediaMsgService.class, "")).isSessionOrderSending(str);
        if (!yVar.l1().containsKey(str2) && isSessionOrderSending) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.f.a
    public boolean p(AppRuntime appRuntime, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) appRuntime, (Object) messageRecord)).booleanValue();
        }
        if (appRuntime instanceof QQAppInterface) {
            return ((QQAppInterface) appRuntime).getMsgCache().t1(messageRecord);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.imcore.message.f.a
    public void q(AppRuntime appRuntime, EntityManager entityManager, ah ahVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, appRuntime, entityManager, ahVar);
        } else {
            ahVar.f116520g = com.tencent.mobileqq.app.fms.c.a((QQAppInterface) appRuntime, entityManager, ahVar.f116519f, ahVar.f116514a, ahVar.f116515b, ahVar.f116516c, (com.tencent.mobileqq.app.fms.b) ahVar.f116518e);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public SQLiteDatabase r(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 13, (Object) this, (Object) appRuntime);
        }
        return ((QQAppInterface) appRuntime).getReadableDatabase();
    }

    @Override // com.tencent.imcore.message.f.a
    public void s(String str, int i3, long j3, long j16, MessageRecord messageRecord, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), messageRecord, appRuntime);
        } else if (messageRecord.msgtype == -2005) {
            ((QQAppInterface) appRuntime).getFileManagerDataCenter().g0(messageRecord.uniseq, messageRecord.frienduin, messageRecord.istroop, j16);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void t(List<MessageRecord> list, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, list, messageRecord, Boolean.valueOf(z16));
        } else {
            ad.o(list, messageRecord, z16);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public int u(String str, int i3, long j3, int i16, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), appRuntime)).intValue();
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(str)) {
            int B3 = ((DataLineHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).B3();
            int i17 = i16 + B3;
            QLog.i("Q.msg.MsgProxy<FileAssistant>", 1, "get Old Msg Unread count : " + B3);
            return i17;
        }
        return i16;
    }

    @Override // com.tencent.imcore.message.f.a
    public void v(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) messageRecord);
            return;
        }
        try {
            ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onMsgAdd(Collections.singletonList(messageRecord));
        } catch (Exception e16) {
            QLog.e("Q.msg.MsgProxy", 1, "onMessageAddToDB", e16);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void w(List<MessageRecord> list, y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) list, (Object) yVar);
            return;
        }
        if (QLog.isColorLevel() && ej.a()) {
            StringBuilder sb5 = new StringBuilder((list.size() * 48) + 28);
            sb5.append("getAIOMsgList, msgInfoList: ");
            for (MessageRecord messageRecord : list) {
                sb5.append("(");
                sb5.append(messageRecord.time);
                sb5.append(",");
                sb5.append(messageRecord.shmsgseq);
                sb5.append(",");
                sb5.append(messageRecord.msgtype);
                sb5.append(") ");
            }
            QLog.d("Q.msg.MsgProxy", 2, sb5.toString());
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public Pair<Long, Long> x(String str, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) appRuntime);
        }
        return ((QQAppInterface) appRuntime).getMsgCache().m0(str);
    }

    @Override // com.tencent.imcore.message.f.a
    public void y(String str, int i3, long j3, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), Long.valueOf(j3), appRuntime);
        } else {
            ((QQAppInterface) appRuntime).getMsgCache().A(str, i3, j3);
        }
    }

    @Override // com.tencent.imcore.message.f.a
    public void z(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), list, list2, appRuntime);
            return;
        }
        for (MessageRecord messageRecord : list) {
            if (messageRecord instanceof MessageForPoke) {
                MessageForPoke messageForPoke = (MessageForPoke) messageRecord;
                if (!messageForPoke.isPlayed) {
                    messageForPoke.setPlayed((QQAppInterface) appRuntime);
                }
            }
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        if (com.tencent.mobileqq.managers.g.g(qQAppInterface, i3, str)) {
            r.a(qQAppInterface.getMessageFacade().F(i3), qQAppInterface, list, list, true, false);
        }
        if (i3 == 0 && list2.size() > 0 && com.tencent.mobileqq.graytip.f.e(list2.get(0))) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ad.o(list2, list.get(size), true);
            }
            return;
        }
        list2.addAll(0, list);
    }
}
