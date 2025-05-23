package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import qqcircle.QQCircleCountergroup$GetGroupCountRsp;

/* loaded from: classes19.dex */
public class QCircleMsgProcessor extends com.tencent.mobileqq.troop.shortcutbar.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a f298704a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.a f298705b;

    /* renamed from: c, reason: collision with root package name */
    private long f298706c;

    /* renamed from: d, reason: collision with root package name */
    private Activity f298707d;

    /* renamed from: e, reason: collision with root package name */
    private AppRuntime f298708e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class QCircleMsgTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Context> f298709d;

        /* renamed from: e, reason: collision with root package name */
        private long f298710e;

        QCircleMsgTask(Context context, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QCircleMsgProcessor.this, context, Long.valueOf(j3));
            } else {
                this.f298709d = new WeakReference<>(context);
                this.f298710e = j3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            WeakReference<Context> weakReference = this.f298709d;
            if (weakReference != null && weakReference.get() != null) {
                VSNetworkHelper.getInstance().sendRequest(this.f298709d.get(), ((IQCircleClassApi) QRoute.api(IQCircleClassApi.class)).getQQCircleGetGroupCountRequest(this.f298710e), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor.QCircleMsgTask.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QCircleMsgTask.this);
                        }
                    }

                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, this, baseRequest, Boolean.valueOf(z16), Long.valueOf(j3), str, obj);
                        } else {
                            ThreadManager.getUIHandler().post(new Runnable(z16, obj, j3, str) { // from class: com.tencent.mobileqq.troop.shortcutbar.importantmsg.QCircleMsgProcessor.QCircleMsgTask.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ boolean f298712d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ Object f298713e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ long f298714f;

                                /* renamed from: h, reason: collision with root package name */
                                final /* synthetic */ String f298715h;

                                {
                                    this.f298712d = z16;
                                    this.f298713e = obj;
                                    this.f298714f = j3;
                                    this.f298715h = str;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Boolean.valueOf(z16), obj, Long.valueOf(j3), str);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    if (this.f298712d) {
                                        Object obj2 = this.f298713e;
                                        if (obj2 instanceof QQCircleCountergroup$GetGroupCountRsp) {
                                            QQCircleCountergroup$GetGroupCountRsp qQCircleCountergroup$GetGroupCountRsp = (QQCircleCountergroup$GetGroupCountRsp) obj2;
                                            if (QLog.isColorLevel()) {
                                                QLog.d("QCircleMsgProcessor", 2, String.format(Locale.getDefault(), "rsp.content=%s,rsp.count=%d, rsp.hasMore=%d, rsp.iconUrl=%s, rsp.latestFeedTime=%s, rsp.timeInterval=%s", qQCircleCountergroup$GetGroupCountRsp.content.get(), Integer.valueOf(qQCircleCountergroup$GetGroupCountRsp.count.get()), Integer.valueOf(qQCircleCountergroup$GetGroupCountRsp.hasMore.get()), qQCircleCountergroup$GetGroupCountRsp.iconUrl.get(), Integer.valueOf(qQCircleCountergroup$GetGroupCountRsp.latestFeedTime.get()), Integer.valueOf(qQCircleCountergroup$GetGroupCountRsp.timeInterval.get())));
                                            }
                                            if (qQCircleCountergroup$GetGroupCountRsp.count.get() >= 1 && !TextUtils.isEmpty(qQCircleCountergroup$GetGroupCountRsp.content.get())) {
                                                QCircleMsgProcessor.this.v(qQCircleCountergroup$GetGroupCountRsp);
                                                QCircleMsgProcessor.this.r(NetConnInfoCenter.getServerTimeMillis() / 1000);
                                                QCircleMsgProcessor.this.s(qQCircleCountergroup$GetGroupCountRsp.timeInterval.get());
                                                ReportController.o(null, "dc00898", "", String.valueOf(QCircleMsgTask.this.f298710e), "0X800B24E", "0X800B24E", 0, 0, "", "", "", "");
                                                return;
                                            }
                                            QLog.d("QCircleMsgProcessor", 2, "rsp.count.get() < 1 || TextUtils.isEmpty(rsp.content.get())");
                                            return;
                                        }
                                    }
                                    QLog.e("QCircleMsgProcessor", 2, "retCode:" + this.f298714f + ", errMsg:" + this.f298715h);
                                }
                            });
                        }
                    }
                });
            } else {
                QLog.e("QCircleMsgProcessor", 2, "mContextRef == null || mContextRef.get() == null");
            }
        }
    }

    public QCircleMsgProcessor(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, com.tencent.mobileqq.troop.shortcutbar.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) aVar2);
            return;
        }
        this.f298704a = aVar;
        this.f298705b = aVar2;
        this.f298707d = aVar.c();
        try {
            this.f298706c = Long.parseLong(this.f298704a.f());
        } catch (Exception unused) {
        }
    }

    private long j() {
        return m(QZoneHelper.Constants.KEY_LAST_CLOSE_TROOP_QCIRCLE_MSG_TIME, 0L);
    }

    private long k() {
        return m(QZoneHelper.Constants.KEY_LAST_REQUEST_TROOP_QCIRCLE_MSG_TIME, 0L);
    }

    private long l() {
        return m(QZoneHelper.Constants.KEY_REQUEST_TROOP_QCIRCLE_MSG_TIME_INTERVAL, 1200L);
    }

    private long m(String str, long j3) {
        AppRuntime appRuntime = this.f298708e;
        if (appRuntime != null && appRuntime.getApp() != null) {
            QQAppInterface qQAppInterface = (QQAppInterface) this.f298708e;
            return qQAppInterface.getApp().getSharedPreferences(QZoneHelper.Constants.QZONE_SP_NAME_IN_QQ, 0).getLong(str + "_" + qQAppInterface.getCurrentUin() + "_" + this.f298706c, j3);
        }
        if (QZLog.isColorLevel()) {
            QLog.e("QCircleMsgProcessor", 2, "getTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
            return 0L;
        }
        return 0L;
    }

    private void n() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key_troop_uin", String.valueOf(this.f298706c));
        hashMap.put("key_jump_from", "24");
        com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeAction(BaseApplication.getContext(), QCircleScheme.Q_CIRCLE_ACTION_OPEN_AGGREGATION, hashMap);
    }

    private boolean o() {
        boolean z16;
        boolean z17;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        long j3 = j();
        long k3 = k();
        long l3 = l();
        if (QLog.isColorLevel()) {
            QLog.i("QCircleMsgProcessor", 2, String.format("iSInCoolingTime: curTime=%ss, lastCloseTime=%ss, lastRequestTime=%ss, reqIntervalTime=%ss, \nclose gap=%ss, request gap=%ss", Long.valueOf(serverTimeMillis), Long.valueOf(j3), Long.valueOf(k3), Long.valueOf(l3), Long.valueOf(serverTimeMillis - j3), Long.valueOf(serverTimeMillis - k3)));
        }
        if (serverTimeMillis - j3 < 86400) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (serverTimeMillis - k3 < l3) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QCircleMsgProcessor", 2, String.format("iSInCoolingTime: isInCloseCoolingTime=%b, isInRequestCoolingTime=%b", Boolean.valueOf(z16), Boolean.valueOf(z17)));
        }
        if (z16 || z17) {
            return true;
        }
        return false;
    }

    private void p() {
        if (!uq3.c.C6()) {
            QLog.i("QCircleMsgProcessoronInit", 2, "QzoneConfig.isQQCircleShowTroopToolBarEntrance()==false");
        } else {
            if (o()) {
                if (QLog.isColorLevel()) {
                    QLog.i("QCircleMsgProcessor", 2, "onInit: \u51b7\u5374\u65f6\u95f4\u4e0d\u53d1\u5c0f\u4e16\u754c\u5feb\u6377\u6d88\u606f\u8bf7\u6c42");
                    return;
                }
                return;
            }
            ThreadManagerV2.excute(new QCircleMsgTask(this.f298707d, this.f298706c), 128, null, false);
        }
    }

    private void q() {
        t(QZoneHelper.Constants.KEY_LAST_CLOSE_TROOP_QCIRCLE_MSG_TIME, NetConnInfoCenter.getServerTimeMillis() / 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(long j3) {
        t(QZoneHelper.Constants.KEY_LAST_REQUEST_TROOP_QCIRCLE_MSG_TIME, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j3) {
        t(QZoneHelper.Constants.KEY_REQUEST_TROOP_QCIRCLE_MSG_TIME_INTERVAL, j3);
    }

    private void t(String str, long j3) {
        AppRuntime appRuntime = this.f298708e;
        if (appRuntime != null && appRuntime.getApp() != null) {
            QQAppInterface qQAppInterface = (QQAppInterface) this.f298708e;
            qQAppInterface.getApp().getSharedPreferences(QZoneHelper.Constants.QZONE_SP_NAME_IN_QQ, 0).edit().putLong(str + "_" + qQAppInterface.getCurrentUin() + "_" + this.f298706c, j3).apply();
            return;
        }
        if (QZLog.isColorLevel()) {
            QLog.e("QCircleMsgProcessor", 2, "setTime: mChatPie == null || mChatPie.app == null || mChatPie.app.getApp() == null");
        }
    }

    private void u(ArrayList<ShortcutBarInfo> arrayList) {
        com.tencent.mobileqq.troop.shortcutbar.a aVar = this.f298705b;
        if (aVar != null) {
            aVar.h(3, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(QQCircleCountergroup$GetGroupCountRsp qQCircleCountergroup$GetGroupCountRsp) {
        QCircleMsgInfo qCircleMsgInfo = new QCircleMsgInfo();
        qCircleMsgInfo.setIconUrl(qQCircleCountergroup$GetGroupCountRsp.iconUrl.get());
        qCircleMsgInfo.setMsgSummary(qQCircleCountergroup$GetGroupCountRsp.content.get());
        qCircleMsgInfo.setShowFrame(0);
        qCircleMsgInfo.setMsgTime(qQCircleCountergroup$GetGroupCountRsp.latestFeedTime.get());
        ArrayList<ShortcutBarInfo> arrayList = new ArrayList<>();
        arrayList.add(qCircleMsgInfo);
        u(arrayList);
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            p();
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void b(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
        } else {
            if (!(obj instanceof QCircleMsgInfo)) {
                return;
            }
            QLog.d("QCircleMsgProcessor", 2, "QCircleMsgInfo onClick");
            n();
            ReportController.o(null, "dc00898", "", String.valueOf(this.f298706c), "0X800B24F", "0X800B24F", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            VSNetworkHelper.getInstance().cancelRequest(this.f298707d);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void e(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj);
        } else {
            if (!(obj instanceof QCircleMsgInfo)) {
                return;
            }
            QLog.d("QCircleMsgProcessor", 2, "QCircleMsgInfo onClickMessageCloseBtn");
            u(null);
            q();
            ReportController.o(null, "dc00898", "", String.valueOf(this.f298706c), "0X800B252", "0X800B252", 0, 0, "", "", "", "");
        }
    }
}
