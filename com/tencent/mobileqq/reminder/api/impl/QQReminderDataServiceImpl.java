package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import Wallet.AcsPullMsgRsp;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.OnDeleteReminderFailListener;
import com.tencent.mobileqq.reminder.api.IQQActivateFriendService;
import com.tencent.mobileqq.reminder.api.IQQReminderAlarmService;
import com.tencent.mobileqq.reminder.api.IQQReminderChats;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.ReminderEntity;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.reminder.util.QQNotifyNTUtil;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQReminderDataServiceImpl implements IQQReminderDataService {
    static IPatchRedirector $redirector_ = null;
    private static final int CACHE_ADD = 1;
    private static final int CACHE_CLEAR_TIME = 3;
    private static final int CACHE_DELETE = 0;
    private static final int CACHE_UPDATE = 2;
    private static final String QQ_EID = "qq_eid";
    private static final String SP_KEY_CACHE_LIST_TIME = "sp_key_cache_list_time";
    private static final String SP_KEY_FETCH_REMINDER_LIST_TIME = "sp_key_new_fetch_reminder_list_time";
    public static final String TAG = "ReminderDataManagerNew";
    private volatile AtomicBoolean initFlag;
    private AppRuntime mApp;
    private EntityManager mEntityManager;
    private IQQReminderAlarmService mNotificationAlarmManager;
    private bm2.c mQQNotifyListener;
    private SharedPreferences mSharedPreferences;
    private volatile ConcurrentHashMap<String, ReminderEntity> todayReminderCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements bm2.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f280915a;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        class C8503a implements BusinessObserver {
            static IPatchRedirector $redirector_;

            C8503a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                } else if (i3 == 2004 && z16 && QLog.isColorLevel()) {
                    QLog.d(QQReminderDataServiceImpl.TAG, 2, "acs msg succ");
                }
            }
        }

        a(String str, d dVar) {
            this.f280915a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQReminderDataServiceImpl.this, str, dVar);
            }
        }

        @Override // bm2.b
        public void a(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            try {
                if (QLog.isColorLevel()) {
                    QLog.i(QQReminderDataServiceImpl.TAG, 2, "getReminderListByday onProcessReminderList isSucc : " + z16);
                }
                if (z16) {
                    QQReminderDataServiceImpl.this.mSharedPreferences.edit().putString(QQReminderDataServiceImpl.SP_KEY_FETCH_REMINDER_LIST_TIME, this.f280915a).apply();
                    AcsPullMsgRsp acsPullMsgRsp = (AcsPullMsgRsp) bundle.getSerializable("rsp");
                    if (acsPullMsgRsp != null) {
                        ArrayList<AcsMsg> arrayList = acsPullMsgRsp.msgs;
                        QQReminderDataServiceImpl.this.processMsgList(arrayList, "server", true);
                        if (arrayList != null && !arrayList.isEmpty()) {
                            QQReminderDataServiceImpl.this.saveReminderMsgList(arrayList);
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            Iterator<AcsMsg> it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(it.next().msg_id);
                            }
                            IQQReminderService iQQReminderService = (IQQReminderService) QQReminderDataServiceImpl.this.mApp.getRuntimeService(IQQReminderService.class, "");
                            if (iQQReminderService != null) {
                                iQQReminderService.sendAckMsgs(arrayList2, new C8503a());
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                QLog.e(QQReminderDataServiceImpl.TAG, 1, "checkTodayReminder throw an exception: " + th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ bm2.b f280918d;

        b(bm2.b bVar) {
            this.f280918d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQReminderDataServiceImpl.this, (Object) bVar);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            bm2.b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            } else if (i3 == 2003 && (bVar = this.f280918d) != null) {
                bVar.a(z16, bundle);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements bm2.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQReminderDataServiceImpl.this);
            }
        }

        @Override // bm2.a
        public void a(List<AcsMsg> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQReminderDataServiceImpl.this.processMsgList(list, "dbAsync", true);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
    }

    public QQReminderDataServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.initFlag = new AtomicBoolean(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addReminderMsg(AcsMsg acsMsg) {
        ReminderEntity reminderEntity = new ReminderEntity();
        reminderEntity.setAcsMsg(acsMsg);
        this.mEntityManager.persistOrReplace(reminderEntity);
        if (!containMsg(QQReminderUtil.p(acsMsg))) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "save Reminder Msg cache not contain, need save, msgId: ", acsMsg.msg_id);
            }
            updateCache(acsMsg, 1);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "save Reminder Msg cache contain, do not save, msgId: ", acsMsg.msg_id);
            }
            updateCache(acsMsg, 2);
        }
    }

    private void addToMessageFacade(String str, String str2, @NonNull String str3) {
        IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(this.mApp);
        if (a16 == null) {
            return;
        }
        com.tencent.mobileqq.reminder.db.b constructMessageForText = a16.constructMessageForText(str, str2, QQConstants.ACTIVATE_FRIENDS_UIN, 9002);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "---doNotifaction---" + str2 + "_" + this.mApp.getAccount());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(constructMessageForText);
        a16.addMessage(arrayList, this.mApp.getAccount(), Boolean.valueOf(this.mApp.isBackgroundStop));
        a16.handleReceivedMessage(1, true, true);
        ((IAppBadgeService) this.mApp.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        QQNotifyNTUtil.f281102a.m(this.mApp);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "do report : QQnotice.list.show");
        }
        ReportController.o(this.mApp, "dc00898", "", "", "0X800C232", "0X800C232", 0, 0, "", "", str2, "");
        ((IQQReminderChats) QRoute.api(IQQReminderChats.class)).reportDTMsgList("qq_imp", str3);
    }

    private void addToMsgTab(String str, String str2) {
        ReminderEntity reminderEntity = this.todayReminderCache.get(str2);
        String str3 = "";
        if (reminderEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "addToMsgTab, not found msgId");
            }
            addToMessageFacade(str, str2, "");
            return;
        }
        if (reminderEntity.getAcsMsg().type == 0) {
            if (this.mSharedPreferences.getBoolean(str2 + this.mApp.getAccount(), false)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "msgId: ", str2, " have Reminded!");
                    return;
                }
                return;
            }
        }
        if (reminderEntity.getAcsMsg().type == 0) {
            this.mSharedPreferences.edit().putBoolean(str2 + this.mApp.getAccount(), true).apply();
        }
        AcsMsg acsMsg = reminderEntity.getAcsMsg();
        if (acsMsg != null && !TextUtils.isEmpty(acsMsg.busi_id)) {
            str3 = acsMsg.busi_id;
        }
        addToMessageFacade(str, QQReminderUtil.p(reminderEntity.getAcsMsg()), str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int deleteExpiredReminderMsg(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "delete expired reminder msg -> time: ", Long.valueOf(j3));
        }
        AcsMsg acsMsg = new AcsMsg();
        acsMsg.notice_time = j3 - 1;
        updateCache(acsMsg, 3);
        return this.mEntityManager.delete(ReminderEntity.class.getSimpleName(), "mReminderTime < ?", new String[]{String.valueOf(j3)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deleteReminderMsg(String str, @Nullable AcsMsg acsMsg) {
        boolean z16;
        int delete = this.mEntityManager.delete(ReminderEntity.class.getSimpleName(), "mMsgId = ?", new String[]{str});
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "deleteReminderMsg msgId: ", str, " count: ", Integer.valueOf(delete));
        }
        if (delete > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (acsMsg != null && z16 && containMsg(QQReminderUtil.p(acsMsg))) {
            updateCache(acsMsg, 0);
        }
        if (delete > 0) {
            return true;
        }
        return false;
    }

    private void dumpAcsMsg(StringBuilder sb5, AcsMsg acsMsg) {
        if (sb5 != null && acsMsg != null) {
            sb5.append("{ title: ");
            sb5.append(acsMsg.title);
            sb5.append(", type: ");
            sb5.append(acsMsg.type);
            sb5.append(", id: ");
            sb5.append(acsMsg.msg_id);
            sb5.append(", id_hash: ");
            sb5.append(acsMsg.msg_id.hashCode());
            sb5.append(", time: ");
            sb5.append(acsMsg.notice_time);
            sb5.append(" }\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ReminderEntity> getReminderListByTime(long j3) {
        return queryReminderEntity("mReminderTime >= ? and mReminderTime < ?", new String[]{String.valueOf((j3 - 86400000) / 1000), String.valueOf(((j3 - ((Calendar.getInstance().getTimeZone().getRawOffset() + j3) % 86400000)) + 86400000) / 1000)}, "mReminderTime");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAlterDeleteFileOrException(AcsMsg acsMsg) {
        if (this.mApp != null && acsMsg != null) {
            String p16 = QQReminderUtil.p(acsMsg);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "handleAlterDeleteFileOrException msgId: ", p16);
            }
            if (this.mNotificationAlarmManager == null) {
                this.mNotificationAlarmManager = (IQQReminderAlarmService) this.mApp.getRuntimeService(IQQReminderAlarmService.class, "");
            }
            if (this.mNotificationAlarmManager != null) {
                this.mSharedPreferences.edit().remove(p16 + this.mApp.getAccount()).apply();
                this.mNotificationAlarmManager.cancelAlarmById(p16.hashCode());
            } else {
                QQReminderUtil.i(acsMsg);
            }
            IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(this.mApp);
            if (a16 != null) {
                a16.removeMsgByUniseq(QQConstants.ACTIVATE_FRIENDS_UIN, 9002, p16.hashCode());
                IAppBadgeService iAppBadgeService = (IAppBadgeService) this.mApp.getRuntimeService(IAppBadgeService.class, "");
                if (iAppBadgeService != null) {
                    iAppBadgeService.refreshAppBadge();
                }
                QQNotifyNTUtil.f281102a.m(this.mApp);
                return;
            }
            QQReminderUtil.E(acsMsg);
        }
    }

    private void init(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        this.mNotificationAlarmManager = (IQQReminderAlarmService) appRuntime.getRuntimeService(IQQReminderAlarmService.class, "");
        this.mEntityManager = getEntityManager();
        this.mSharedPreferences = getSharePref();
        initCache();
    }

    private void initCache() {
        if (this.todayReminderCache == null) {
            this.todayReminderCache = new ConcurrentHashMap<>(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Boolean lambda$processMsgList$0(com.tencent.mobileqq.reminder.db.b bVar, Object obj) {
        return Boolean.valueOf(((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).isMessageForText((MessageRecord) bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMsgList(List<AcsMsg> list, String str, boolean z16) {
        boolean z17;
        boolean switchValue;
        int i3 = 0;
        if (list != null && !list.isEmpty()) {
            IQQReminderAlarmService iQQReminderAlarmService = (IQQReminderAlarmService) this.mApp.getRuntimeService(IQQReminderAlarmService.class, "");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("processMsgList from = ");
            sb5.append(str);
            sb5.append(" msgs = [\n");
            for (AcsMsg acsMsg : list) {
                dumpAcsMsg(sb5, acsMsg);
                if (acsMsg.notice_time > NetConnInfoCenter.getServerTime()) {
                    if (iQQReminderAlarmService != null) {
                        iQQReminderAlarmService.setAlarmTimer(acsMsg);
                    }
                } else {
                    if (!this.mSharedPreferences.getBoolean(acsMsg.msg_id + this.mApp.getAccount(), false) && acsMsg.type != 1 && QQReminderUtil.z(acsMsg.notice_time * 1000)) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, " has notifaction: " + z17 + " key: " + acsMsg.msg_id + "_" + this.mApp.getAccount());
                    }
                    IQQActivateFriendService iQQActivateFriendService = (IQQActivateFriendService) this.mApp.getRuntimeService(IQQActivateFriendService.class, "");
                    if (iQQActivateFriendService == null) {
                        switchValue = false;
                    } else {
                        switchValue = iQQActivateFriendService.getSwitchValue(z16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, " isSettingOpen: " + switchValue);
                    }
                    if (!z17 && switchValue) {
                        doNotifaction(acsMsg.title, QQReminderUtil.p(acsMsg));
                    } else if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "the msg " + acsMsg.title + " has notifaction!!!");
                    }
                    z16 = false;
                }
            }
            sb5.append("]");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, sb5.toString());
                return;
            }
            return;
        }
        IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(this.mApp);
        if (a16 != null) {
            List<com.tencent.mobileqq.reminder.db.b> msgList = a16.getMsgList(QQConstants.ACTIVATE_FRIENDS_UIN, 9002);
            if (msgList != null) {
                i3 = msgList.size();
            }
            if (msgList != null && !msgList.isEmpty()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("origin size = ");
                sb6.append(i3);
                sb6.append(" from = ");
                sb6.append(str);
                sb6.append(" msgs: [\n");
                for (final com.tencent.mobileqq.reminder.db.b bVar : msgList) {
                    if (a16.checkIsMessageForText(bVar, new Function1() { // from class: com.tencent.mobileqq.reminder.api.impl.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Boolean lambda$processMsgList$0;
                            lambda$processMsgList$0 = QQReminderDataServiceImpl.this.lambda$processMsgList$0(bVar, obj);
                            return lambda$processMsgList$0;
                        }
                    }) && !containMsg(a16.getMsgUinSeq(bVar))) {
                        a16.removeMsgByMessageRecord(bVar, true);
                        i3--;
                        sb6.append("remove: ");
                    } else {
                        sb6.append("reserve: ");
                    }
                    printMessageRecord(sb6, bVar);
                }
                sb6.append("]");
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, sb6.toString());
                }
            }
            updateTab(i3);
        }
    }

    private void pullTodayMsgList(boolean z16, d dVar) {
        long j3;
        try {
            String o16 = QQReminderUtil.o(NetConnInfoCenter.getServerTimeMillis(), DateUtil.DATE_FORMAT_8);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "pullTodayMsgList currenDayTimeStapStr: " + o16);
            }
            String string = this.mSharedPreferences.getString(SP_KEY_FETCH_REMINDER_LIST_TIME, "");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "pullTodayMsgList cacheCurrenDayTimeStapStr: " + string);
            }
            try {
                j3 = (Long.parseLong(this.mApp.getAccount()) % 3600) * 1000;
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "pullTodayMsgList delay: " + j3);
                }
            } catch (Exception unused) {
                j3 = 0;
            }
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            long s16 = QQReminderUtil.s(NetConnInfoCenter.getServerTimeMillis()) + j3;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "pullTodayMsgList currentDelayTs: " + QQReminderUtil.o(s16, "yyyy-MM-dd HH:mm:ss"));
            }
            if (!z16 && (o16.equals(string) || serverTimeMillis < s16)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "already fetch today's data");
                    return;
                }
                return;
            }
            getReminderListByday(o16, new a(o16, dVar));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "checkTodayReminder throw an exception: " + th5);
        }
    }

    private List queryReminderEntity(String str, String[] strArr, String str2) {
        return this.mEntityManager.query(ReminderEntity.class, ReminderEntity.class.getSimpleName(), false, str, strArr, (String) null, (String) null, str2, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetCache() {
        List<com.tencent.mobileqq.reminder.db.b> list;
        String o16 = QQReminderUtil.o(NetConnInfoCenter.getServerTimeMillis(), DateUtil.DATE_FORMAT_8);
        String string = this.mSharedPreferences.getString(SP_KEY_CACHE_LIST_TIME, "");
        long serverTime = NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "cur: ", o16, " cache: ", string);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ReminderEntity> entry : this.todayReminderCache.entrySet()) {
            AcsMsg acsMsg = entry.getValue().getAcsMsg();
            int i3 = acsMsg.type;
            if (i3 == 0) {
                if (!QQReminderUtil.z(acsMsg.notice_time * 1000)) {
                    arrayList.add(entry.getKey());
                }
            } else if (i3 == 1 && serverTime - acsMsg.notice_time > 86400) {
                arrayList.add(entry.getKey());
            }
        }
        IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(this.mApp);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.todayReminderCache.remove((String) it.next());
            if (a16 != null) {
                a16.removeMsgByUniseq(QQConstants.ACTIVATE_FRIENDS_UIN, 9002, r7.hashCode());
            }
        }
        if (a16 != null) {
            list = a16.getMsgList(QQConstants.ACTIVATE_FRIENDS_UIN, 9002);
        } else {
            list = null;
        }
        if (list != null) {
            StringBuilder sb5 = new StringBuilder("resetCache msgs:[\n");
            Iterator<com.tencent.mobileqq.reminder.db.b> it5 = list.iterator();
            while (it5.hasNext()) {
                printMessageRecord(sb5, it5.next());
            }
            sb5.append("]");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, sb5.toString());
            }
            updateTab(list.size());
        }
        if (!o16.equals(string)) {
            this.mSharedPreferences.edit().putString(SP_KEY_CACHE_LIST_TIME, QQReminderUtil.o(NetConnInfoCenter.getServerTimeMillis(), DateUtil.DATE_FORMAT_8)).apply();
            this.initFlag.set(false);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runAtOtherThread(new Runnable() { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQReminderDataServiceImpl.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            QQReminderDataServiceImpl.this.deleteExpiredReminderMsg(NetConnInfoCenter.getServerTime() - 86400);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                });
            } else {
                deleteExpiredReminderMsg(NetConnInfoCenter.getServerTime() - 86400);
            }
        }
    }

    private void runAtOtherThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(runnable, 32, null, true);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCache(AcsMsg acsMsg, int i3) {
        if ((acsMsg.type == 0 && !QQReminderUtil.z(acsMsg.notice_time * 1000)) || (acsMsg.type == 1 && acsMsg.notice_time - NetConnInfoCenter.getServerTime() > 86400)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "updateCache msg notice time is not today: ", Long.valueOf(acsMsg.notice_time));
                return;
            }
            return;
        }
        String p16 = QQReminderUtil.p(acsMsg);
        if (this.todayReminderCache != null && p16 != null) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            for (Map.Entry<String, ReminderEntity> entry : this.todayReminderCache.entrySet()) {
                                if (entry.getValue().mReminderTime <= acsMsg.notice_time) {
                                    this.todayReminderCache.remove(entry.getKey());
                                }
                            }
                            return;
                        }
                        return;
                    }
                    if (this.todayReminderCache.containsKey(p16)) {
                        ReminderEntity reminderEntity = this.todayReminderCache.get(p16);
                        if (reminderEntity != null) {
                            reminderEntity.setAcsMsg(acsMsg);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 1, "CACHE_UPDATE: cache do not contain key: ", p16);
                        return;
                    }
                    return;
                }
                if (this.todayReminderCache.containsKey(p16)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 1, "CACHE_ADD: cache contain key: ", p16);
                        return;
                    }
                    return;
                } else {
                    ReminderEntity reminderEntity2 = new ReminderEntity();
                    reminderEntity2.setAcsMsg(acsMsg);
                    this.todayReminderCache.put(p16, reminderEntity2);
                    return;
                }
            }
            if (this.todayReminderCache.containsKey(p16)) {
                IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(this.mApp);
                if (a16 != null) {
                    a16.removeMsgByUniseq(QQConstants.ACTIVATE_FRIENDS_UIN, 9002, p16.hashCode());
                }
                this.todayReminderCache.remove(p16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "CACHE_DELETE: cache do not contain key: ", p16);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "updateCache fail -> msgId: ", p16);
        }
    }

    private void updateTab(int i3) {
        List<com.tencent.mobileqq.reminder.db.b> msgList;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "updateTab size: ", Integer.valueOf(i3));
            QLog.d(TAG, 1, "stack: ", new Throwable("updateTab"));
        }
        if (i3 <= 0) {
            IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(this.mApp);
            if (a16 != null && (msgList = a16.getMsgList(QQConstants.ACTIVATE_FRIENDS_UIN, 9002)) != null && msgList.size() <= 0) {
                QQNotifyNTUtil.f281102a.h();
                return;
            }
            return;
        }
        QQNotifyNTUtil.f281102a.m(this.mApp);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public void checkTodayReminder() {
        List<AcsMsg> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (!((IQQActivateFriendService) this.mApp.getRuntimeService(IQQActivateFriendService.class, "")).getSwitchValue(true)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkTodayReminder: setting is close");
                return;
            }
            return;
        }
        if (this.todayReminderCache != null) {
            resetCache();
        }
        if (this.todayReminderCache != null && this.initFlag.get()) {
            list = getTodayReminderMsgFromCache();
            processMsgList(list, "cache", false);
        } else {
            list = null;
        }
        if (list == null) {
            getTodayReminderMsgFromDBAsync(new c());
        }
        pullTodayMsgList(false, null);
    }

    public boolean containMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        if (this.todayReminderCache != null) {
            return this.todayReminderCache.containsKey(str);
        }
        return false;
    }

    public void deleteAllReminder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            runAtOtherThread(new Runnable() { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQReminderDataServiceImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        int deleteExpiredReminderMsg = QQReminderDataServiceImpl.this.deleteExpiredReminderMsg(9223372036854775806L);
                        if (QLog.isColorLevel()) {
                            QLog.d(QQReminderDataServiceImpl.TAG, 1, "delete reminder list count: ", Integer.valueOf(deleteExpiredReminderMsg));
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public void deleteReminderByMsgId(String str, OnDeleteReminderFailListener onDeleteReminderFailListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) onDeleteReminderFailListener);
        } else {
            runAtOtherThread(new Runnable(str, onDeleteReminderFailListener) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f280913d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ OnDeleteReminderFailListener f280914e;

                {
                    this.f280913d = str;
                    this.f280914e = onDeleteReminderFailListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQReminderDataServiceImpl.this, str, onDeleteReminderFailListener);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!QQReminderDataServiceImpl.this.todayReminderCache.containsKey(this.f280913d)) {
                        return;
                    }
                    AcsMsg acsMsg = ((ReminderEntity) QQReminderDataServiceImpl.this.todayReminderCache.get(this.f280913d)).getAcsMsg();
                    if (QQReminderDataServiceImpl.this.deleteReminderMsg(this.f280913d, acsMsg)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(QQReminderDataServiceImpl.TAG, 1, "deleteReminderByMsgId MsgId: ", this.f280913d, " success, remove reminder...");
                        }
                        QQReminderDataServiceImpl.this.handleAlterDeleteFileOrException(acsMsg);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(QQReminderDataServiceImpl.TAG, 1, "deleteReminderByMsgId MsgId: ", this.f280913d, " failed!!");
                        }
                        OnDeleteReminderFailListener onDeleteReminderFailListener2 = this.f280914e;
                        if (onDeleteReminderFailListener2 != null) {
                            onDeleteReminderFailListener2.onReminderDeleteFail();
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public void doNotifaction(String str, String str2) {
        boolean switchValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) str2);
            return;
        }
        try {
            IQQActivateFriendService iQQActivateFriendService = (IQQActivateFriendService) this.mApp.getRuntimeService(IQQActivateFriendService.class, "");
            if (iQQActivateFriendService == null) {
                switchValue = false;
            } else {
                switchValue = iQQActivateFriendService.getSwitchValue(true);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, " isSettingOpen: " + switchValue);
            }
            if (!switchValue) {
                return;
            }
            addToMsgTab(str, str2);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "doNotifaction throw an exception: " + th5);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public void doNotifyByPush(AcsMsg acsMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) acsMsg);
            return;
        }
        saveReminderMsg(acsMsg);
        updateCache(acsMsg, 1);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("doNotifyByPush msg:\n");
            dumpAcsMsg(sb5, acsMsg);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (acsMsg.type == 0 && acsMsg.notice_time > NetConnInfoCenter.getServerTime()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "has not arrive noticetime, set AlarmMangaer first!");
            }
            IQQReminderAlarmService iQQReminderAlarmService = (IQQReminderAlarmService) this.mApp.getRuntimeService(IQQReminderAlarmService.class, "");
            if (iQQReminderAlarmService != null) {
                iQQReminderAlarmService.setAlarmTimer(acsMsg);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "has arrive noticetime, doNotifaction!");
        }
        if (acsMsg.type == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[notify][push] multiple doNotifyByPush.");
            }
            bm2.c cVar = this.mQQNotifyListener;
            if (cVar != null) {
                cVar.a(acsMsg);
            }
        }
        doNotifaction(acsMsg.title, QQReminderUtil.p(acsMsg));
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public List<String> getCacheKeyList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (List) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return new ArrayList(this.todayReminderCache.keySet());
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public com.tencent.mobileqq.reminder.biz.entity.a getEntityByKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (com.tencent.mobileqq.reminder.biz.entity.a) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        }
        return this.todayReminderCache.get(str);
    }

    protected EntityManager getEntityManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EntityManager) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AppRuntime appRuntime = this.mApp;
        return appRuntime.getEntityManagerFactory(appRuntime.getAccount()).createEntityManager();
    }

    public List<com.tencent.mobileqq.reminder.biz.entity.a> getReminderListById(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return queryReminderEntity("mMsgId = ?", new String[]{str}, "mReminderTime");
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public void getReminderListByday(String str, bm2.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) bVar);
            return;
        }
        try {
            IQQReminderService iQQReminderService = (IQQReminderService) this.mApp.getRuntimeService(IQQReminderService.class, "");
            if (iQQReminderService != null) {
                iQQReminderService.sendReminderListByDay(str, new b(bVar));
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    protected SharedPreferences getSharePref() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mApp.getApplicationContext().getSharedPreferences(QQConstants.PREF_ACTIVATE_FRIENDS + this.mApp.getAccount(), 0);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public boolean getSwitchHideNowReminder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return ((IFeatureRuntimeService) this.mApp.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("switch_hide_now_reminder");
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public void getTodayReminderMsgAsync(bm2.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, aVar, Boolean.valueOf(z16));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "getTodayReminderMsgAsync...");
        }
        runAtOtherThread(new Runnable(z16, arrayList, aVar) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f280910d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ List f280911e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ bm2.a f280912f;

            {
                this.f280910d = z16;
                this.f280911e = arrayList;
                this.f280912f = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QQReminderDataServiceImpl.this, Boolean.valueOf(z16), arrayList, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQReminderDataServiceImpl.this.resetCache();
                    if (QQReminderDataServiceImpl.this.todayReminderCache == null || !QQReminderDataServiceImpl.this.initFlag.get() || this.f280910d) {
                        List reminderListByTime = QQReminderDataServiceImpl.this.getReminderListByTime(NetConnInfoCenter.getServerTimeMillis());
                        if (reminderListByTime == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(QQReminderDataServiceImpl.TAG, 1, "async from db, msg list is null");
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d(QQReminderDataServiceImpl.TAG, 1, "async from db, msg count: ", Integer.valueOf(reminderListByTime.size()));
                            }
                            Iterator it = reminderListByTime.iterator();
                            while (it.hasNext()) {
                                AcsMsg acsMsg = ((ReminderEntity) it.next()).getAcsMsg();
                                if (acsMsg != null && QQReminderUtil.z(acsMsg.notice_time * 1000)) {
                                    this.f280911e.add(acsMsg);
                                }
                            }
                        }
                        if (!QQReminderDataServiceImpl.this.initFlag.get() || this.f280910d) {
                            Iterator it5 = this.f280911e.iterator();
                            while (it5.hasNext()) {
                                QQReminderDataServiceImpl.this.updateCache((AcsMsg) it5.next(), 1);
                            }
                            QQReminderDataServiceImpl.this.initFlag.set(true);
                            QQReminderDataServiceImpl.this.mSharedPreferences.edit().putString(QQReminderDataServiceImpl.SP_KEY_CACHE_LIST_TIME, QQReminderUtil.o(NetConnInfoCenter.getServerTimeMillis(), DateUtil.DATE_FORMAT_8)).apply();
                        }
                    } else {
                        ArrayList arrayList2 = new ArrayList(QQReminderDataServiceImpl.this.todayReminderCache.values());
                        if (QLog.isColorLevel()) {
                            QLog.d(QQReminderDataServiceImpl.TAG, 1, "async from cache, msg count: ", Integer.valueOf(arrayList2.size()));
                        }
                        Iterator it6 = arrayList2.iterator();
                        while (it6.hasNext()) {
                            this.f280911e.add(((ReminderEntity) it6.next()).getAcsMsg());
                        }
                    }
                    QQReminderDataServiceImpl.this.refineListAtStudyMode(this.f280911e, ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch(), QQReminderDataServiceImpl.this.getSwitchHideNowReminder());
                    this.f280912f.a(this.f280911e);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    public List<AcsMsg> getTodayReminderMsgFromCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.todayReminderCache != null) {
            resetCache();
        }
        if (this.todayReminderCache != null && this.initFlag.get()) {
            ArrayList arrayList = new ArrayList(this.todayReminderCache.values());
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ReminderEntity) it.next()).getAcsMsg());
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "getTodayReminderMsgFromCache, msg count: ", Integer.valueOf(arrayList2.size()));
            }
            return arrayList2;
        }
        return null;
    }

    public void getTodayReminderMsgFromDBAsync(bm2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            runAtOtherThread(new Runnable(aVar) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ bm2.a f280909d;

                {
                    this.f280909d = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQReminderDataServiceImpl.this, (Object) aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    QQReminderDataServiceImpl.this.resetCache();
                    List reminderListByTime = QQReminderDataServiceImpl.this.getReminderListByTime(NetConnInfoCenter.getServerTimeMillis());
                    if (reminderListByTime == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(QQReminderDataServiceImpl.TAG, 1, "async from db, msg list is null");
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(QQReminderDataServiceImpl.TAG, 1, "async from db, msg count: ", Integer.valueOf(reminderListByTime.size()));
                        }
                        Iterator it = reminderListByTime.iterator();
                        while (it.hasNext()) {
                            AcsMsg acsMsg = ((ReminderEntity) it.next()).getAcsMsg();
                            if (acsMsg != null && QQReminderUtil.z(acsMsg.notice_time * 1000)) {
                                arrayList.add(acsMsg);
                            }
                        }
                    }
                    if (!QQReminderDataServiceImpl.this.initFlag.get()) {
                        Iterator it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            QQReminderDataServiceImpl.this.updateCache((AcsMsg) it5.next(), 1);
                        }
                        QQReminderDataServiceImpl.this.initFlag.set(true);
                        QQReminderDataServiceImpl.this.mSharedPreferences.edit().putString(QQReminderDataServiceImpl.SP_KEY_CACHE_LIST_TIME, QQReminderUtil.o(NetConnInfoCenter.getServerTimeMillis(), DateUtil.DATE_FORMAT_8)).apply();
                    }
                    this.f280909d.a(arrayList);
                }
            });
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) appRuntime);
        } else {
            init(appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @VisibleForTesting
    public void refineListAtStudyMode(List<AcsMsg> list, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, list, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (z16 && z17) {
            Iterator<AcsMsg> it = list.iterator();
            while (it.hasNext()) {
                if (IQQReminderDataService.QQ_REMINDER_MSG_ID_NOW_LIVE.equals(it.next().msg_id)) {
                    it.remove();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public void saveReminderMsg(AcsMsg acsMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) acsMsg);
        } else {
            runAtOtherThread(new Runnable(acsMsg) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AcsMsg f280907d;

                {
                    this.f280907d = acsMsg;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQReminderDataServiceImpl.this, (Object) acsMsg);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f280907d == null) {
                        return;
                    }
                    if (QQReminderDataServiceImpl.this.mNotificationAlarmManager == null) {
                        QQReminderDataServiceImpl qQReminderDataServiceImpl = QQReminderDataServiceImpl.this;
                        qQReminderDataServiceImpl.mNotificationAlarmManager = (IQQReminderAlarmService) qQReminderDataServiceImpl.mApp.getRuntimeService(IQQReminderAlarmService.class, "");
                    }
                    if (this.f280907d.type == 0) {
                        if (QQReminderDataServiceImpl.this.mNotificationAlarmManager != null) {
                            QQReminderDataServiceImpl.this.mNotificationAlarmManager.setAlarmTimer(this.f280907d);
                        } else {
                            QQReminderUtil.I(this.f280907d);
                        }
                    }
                    QQReminderDataServiceImpl.this.addReminderMsg(this.f280907d);
                }
            });
        }
    }

    public void saveReminderMsgList(List<AcsMsg> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            runAtOtherThread(new Runnable(list) { // from class: com.tencent.mobileqq.reminder.api.impl.QQReminderDataServiceImpl.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f280908d;

                {
                    this.f280908d = list;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQReminderDataServiceImpl.this, (Object) list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    List list2 = this.f280908d;
                    if (list2 != null && !list2.isEmpty()) {
                        Iterator it = this.f280908d.iterator();
                        while (it.hasNext()) {
                            QQReminderDataServiceImpl.this.addReminderMsg((AcsMsg) it.next());
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(QQReminderDataServiceImpl.TAG, 1, "save reminder msg list is null or empty!");
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public void setMsgRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            QQNotifyNTUtil.f281102a.j(this.mApp);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderDataService
    public void setQQNotifyListener(bm2.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) cVar);
        } else {
            this.mQQNotifyListener = cVar;
        }
    }

    private boolean containMsg(long j3) {
        if (this.todayReminderCache == null) {
            return false;
        }
        Iterator<String> it = this.todayReminderCache.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().hashCode() == j3) {
                return true;
            }
        }
        return false;
    }

    private void printMessageRecord(StringBuilder sb5, com.tencent.mobileqq.reminder.db.b bVar) {
    }
}
