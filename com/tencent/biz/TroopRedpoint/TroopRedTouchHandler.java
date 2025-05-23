package com.tencent.biz.TroopRedpoint;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.m;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.h;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.NewIntent;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791$RedDotInfo;
import tencent.im.oidb.cmd0x791.oidb_0x791$ReqBody;
import tencent.im.oidb.cmd0x791.oidb_0x791$RspBody;
import tencent.im.oidb.cmd0x791.oidb_0x791$SetRedDotOpt;
import tencent.im.oidb.cmd0x791.oidb_0x791$SetRedDotRes;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x69.Submsgtype0x69;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TroopRedTouchHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    protected int f78323d;

    /* renamed from: e, reason: collision with root package name */
    protected d f78324e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f78325f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f78326h;

    /* renamed from: i, reason: collision with root package name */
    protected BusinessObserver f78327i;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.TroopRedpoint.TroopRedTouchHandler$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f78330d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f78331e;

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferences sharedPreferences = this.f78330d.getApplication().getSharedPreferences(this.f78330d.getCurrentAccountUin() + "RedTouchExManager_GetTime", 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong("last_get_time", System.currentTimeMillis() / 1000);
                edit.putLong("interval_time", this.f78331e);
                edit.commit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements mqq.observer.BusinessObserver {
        a() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom(byteArray);
                    if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                        oidb_0x791$RspBody oidb_0x791_rspbody = new oidb_0x791$RspBody();
                        oidb_0x791_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                        oidb_0x791$SetRedDotRes oidb_0x791_setreddotres = oidb_0x791_rspbody.msg_set_reddot_res.get();
                        if (oidb_0x791_setreddotres != null) {
                            String str = "";
                            Iterator<Long> it = oidb_0x791_setreddotres.rpt_uint64_failed_uin.get().iterator();
                            while (it.hasNext()) {
                                str = str + String.valueOf(it.next().longValue()) + ",";
                            }
                            if (!TextUtils.isEmpty(str) && QLog.isColorLevel()) {
                                QLog.d("SplashActivityQ.qqstory.redPoint", 2, "reportRedTouchHasClick failed result is:" + str);
                            }
                        }
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b extends bs {
        b() {
        }

        @Override // com.tencent.mobileqq.app.bs, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (105 == i3) {
                if (QLog.isColorLevel()) {
                    QLog.i("storyRedDotDebug", 2, "mGetRedPointPushObserver");
                }
                TroopRedTouchHandler.this.notifyUI(105, true, obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements mqq.observer.BusinessObserver {
        c() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom(byteArray);
                    if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                        oidb_0x791$RspBody oidb_0x791_rspbody = new oidb_0x791$RspBody();
                        oidb_0x791_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                        oidb_0x791$SetRedDotRes oidb_0x791_setreddotres = oidb_0x791_rspbody.msg_set_reddot_res.get();
                        if (oidb_0x791_setreddotres != null) {
                            String str = "";
                            Iterator<Long> it = oidb_0x791_setreddotres.rpt_uint64_failed_uin.get().iterator();
                            while (it.hasNext()) {
                                str = str + String.valueOf(it.next().longValue()) + ",";
                            }
                            if (!TextUtils.isEmpty(str) && QLog.isColorLevel()) {
                                QLog.d("SplashActivityQ.qqstory.redPoint", 2, "setRedDotInfo failed result is:" + str);
                            }
                        }
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public TroopRedTouchHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f78325f = false;
        this.f78327i = new b();
        this.f78326h = qQAppInterface;
        this.f78324e = new d(this);
        AppNetConnInfo.registerConnectionChangeReceiver(qQAppInterface.getApplication(), this.f78324e);
        this.f78323d = 0;
    }

    public static void F2(QQAppInterface qQAppInterface, oidb_0x791$RedDotInfo oidb_0x791_reddotinfo) {
        TroopRedTouchManager troopRedTouchManager;
        if (qQAppInterface != null && oidb_0x791_reddotinfo != null && (troopRedTouchManager = (TroopRedTouchManager) qQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)) != null) {
            int i3 = oidb_0x791_reddotinfo.uint32_appid.get();
            if (i3 != 56 && i3 != 61) {
                oidb_0x791_reddotinfo.bool_display_reddot.set(false);
                oidb_0x791_reddotinfo.uint32_number.set(0);
                troopRedTouchManager.B(oidb_0x791_reddotinfo);
            }
            TroopRedTouchHandler troopRedTouchHandler = (TroopRedTouchHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
            troopRedTouchHandler.J2(oidb_0x791_reddotinfo);
            troopRedTouchHandler.I2(oidb_0x791_reddotinfo.uint32_appid.get());
        }
    }

    public static oidb_0x791$RedDotInfo G2(QQAppInterface qQAppInterface, byte[] bArr) {
        boolean z16;
        int i3;
        oidb_0x791$RedDotInfo oidb_0x791_reddotinfo = null;
        if (bArr != null && qQAppInterface != null) {
            try {
                Submsgtype0x69 submsgtype0x69 = new Submsgtype0x69();
                submsgtype0x69.mergeFrom(bArr);
                boolean z17 = submsgtype0x69.bool_test_env.get();
                if (z17 != h.f286485d) {
                    hd0.c.c("TroopRedTouchHandler", "parsePushRedPointInfo env not match!! isTestEnvFromPush = %b, sIsTestEnv = %b", Boolean.valueOf(z17), Boolean.valueOf(h.f286485d));
                    if (z17) {
                        hd0.c.c("TroopRedTouchHandler", "parsePushRedPointInfo env not match!! isTestEnvFromPush = %b, QQStoryNetReqUtils.isDevEnv() = %b", Boolean.valueOf(z17), Boolean.FALSE);
                        return null;
                    }
                }
                oidb_0x791$RedDotInfo oidb_0x791_reddotinfo2 = new oidb_0x791$RedDotInfo();
                oidb_0x791_reddotinfo2.uint32_appid.set(submsgtype0x69.uint32_appid.get());
                oidb_0x791_reddotinfo2.bool_display_reddot.set(submsgtype0x69.bool_display_reddot.get());
                oidb_0x791_reddotinfo2.uint32_number.set(submsgtype0x69.uint32_number.get());
                oidb_0x791_reddotinfo2.uint32_reason.set(submsgtype0x69.uint32_reason.get());
                oidb_0x791_reddotinfo2.uint32_last_time.set(submsgtype0x69.uint32_last_time.get());
                oidb_0x791_reddotinfo2.uint64_cmd_uin.set(submsgtype0x69.uint64_cmd_uin.get());
                oidb_0x791_reddotinfo2.str_face_url.set(submsgtype0x69.bytes_face_url.get());
                oidb_0x791_reddotinfo2.str_custom_buffer.set(submsgtype0x69.bytes_custom_buffer.get());
                oidb_0x791_reddotinfo2.uint32_expire_time.set(submsgtype0x69.uint32_expire_time.get());
                oidb_0x791_reddotinfo2.uint32_cmd_uin_type.set(submsgtype0x69.uint32_cmd_uin_type.get());
                oidb_0x791_reddotinfo2.uint32_report_type.set(submsgtype0x69.uint32_report_type.get());
                if (QLog.isColorLevel()) {
                    QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "parsePushRedPointInfo:" + TroopRedTouchManager.y(oidb_0x791_reddotinfo2));
                }
                if (oidb_0x791_reddotinfo2.uint32_appid.get() == 38) {
                    try {
                        JSONObject jSONObject = new JSONObject(oidb_0x791_reddotinfo2.str_custom_buffer.get().toStringUtf8());
                        if (jSONObject.optInt("official_topic") == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        int optInt = jSONObject.optInt("red_content_type");
                        int intValue = ((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(qQAppInterface.getCurrentAccountUin(), INearbySPUtil.SP_KEY_SELF_GENDER, (Object) (-1))).intValue();
                        if (z16) {
                            new q(qQAppInterface).i("dc00899").a("grp_lbs").f("entry").d("push_red_send").b(String.valueOf(intValue), "0", String.valueOf(optInt), "0").g();
                            Log.i("redreport", "retport push_red_send d1 = " + intValue + " d3 = " + optInt);
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                TroopRedTouchManager troopRedTouchManager = (TroopRedTouchManager) qQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
                if (46 == oidb_0x791_reddotinfo2.uint32_appid.get()) {
                    if (((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).isTencentDocsAssistantEnable(qQAppInterface)) {
                        oidb_0x791$RedDotInfo f16 = troopRedTouchManager.f(46, false);
                        if (f16 != null && f16.uint32_last_time.has()) {
                            i3 = f16.uint32_last_time.get();
                        } else {
                            i3 = 0;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("TroopRedTouchHandler", 2, "TENCENT_DOCS_ASSISTANT  show redDot" + oidb_0x791_reddotinfo2.bool_display_reddot.get());
                        }
                        troopRedTouchManager.G(f16, oidb_0x791_reddotinfo2);
                        troopRedTouchManager.B(oidb_0x791_reddotinfo2);
                        M2(qQAppInterface, oidb_0x791_reddotinfo2, i3, false);
                    }
                    return null;
                }
                if (com.tencent.biz.TroopRedpoint.a.c(oidb_0x791_reddotinfo2.uint32_appid.get())) {
                    return null;
                }
                troopRedTouchManager.B(oidb_0x791_reddotinfo2);
                oidb_0x791_reddotinfo = oidb_0x791_reddotinfo2;
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        hd0.c.b("TroopRedTouchHandler", "parsePushRedPointInfo() return %s", oidb_0x791_reddotinfo);
        return oidb_0x791_reddotinfo;
    }

    public static void M2(QQAppInterface qQAppInterface, oidb_0x791$RedDotInfo oidb_0x791_reddotinfo, int i3, boolean z16) {
        int i16;
        boolean z17;
        long serverTimeMillis;
        if (qQAppInterface != null && oidb_0x791_reddotinfo != null && oidb_0x791_reddotinfo.uint32_appid.has()) {
            int i17 = oidb_0x791_reddotinfo.uint32_appid.get();
            if (oidb_0x791_reddotinfo.uint32_number.has()) {
                i16 = oidb_0x791_reddotinfo.uint32_number.get();
            } else {
                i16 = 0;
            }
            if (i17 == 46) {
                boolean z18 = true;
                if (oidb_0x791_reddotinfo.uint32_last_time.has() && oidb_0x791_reddotinfo.uint32_last_time.get() != i3) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
                String str = AppConstants.TENCENT_DOCS_ASSISTANT_UIN;
                if (m3.findRecentUser(str, 6004) == null) {
                    z18 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopRedTouchHandler", 2, " hasRecentUser " + z18 + " isClicked " + z16 + " redDotInfo.bool_display_reddot" + oidb_0x791_reddotinfo.bool_display_reddot.get());
                }
                if (!z18 && !oidb_0x791_reddotinfo.bool_display_reddot.get() && !z16) {
                    return;
                }
                RecentUser findRecentUserByUin = m3.findRecentUserByUin(str, 6004);
                if (i16 > 0 && (oidb_0x791_reddotinfo.bool_display_reddot.get() || z16)) {
                    if (oidb_0x791_reddotinfo.uint32_last_time.has()) {
                        serverTimeMillis = oidb_0x791_reddotinfo.uint32_last_time.get();
                    } else {
                        serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
                    }
                    findRecentUserByUin.lastmsgtime = serverTimeMillis;
                }
                findRecentUserByUin.msgType = 0;
                findRecentUserByUin.displayName = qQAppInterface.getApp().getString(R.string.hzo);
                if (z17) {
                    m3.saveRecentUser(findRecentUserByUin);
                }
                qQAppInterface.getMessageFacade().K0(findRecentUserByUin);
                if (qQAppInterface.isLogin()) {
                    ((IAppBadgeService) qQAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
                }
            }
        }
    }

    public void D2(int i3) {
        E2(i3, true);
    }

    public void E2(int i3, boolean z16) {
        oidb_0x791$RedDotInfo f16;
        TroopRedTouchManager troopRedTouchManager = (TroopRedTouchManager) this.f78326h.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
        if (troopRedTouchManager != null && (f16 = troopRedTouchManager.f(i3, false)) != null && f16.uint32_number.has() && f16.uint32_number.get() > 0) {
            f16.uint32_number.set(0);
            troopRedTouchManager.B(f16);
            oidb_0x791$RedDotInfo oidb_0x791_reddotinfo = new oidb_0x791$RedDotInfo();
            oidb_0x791_reddotinfo.uint32_appid.set(i3);
            if (f16.uint32_last_time.has()) {
                oidb_0x791_reddotinfo.uint32_last_time.set(f16.uint32_last_time.get());
            }
            K2(i3, false, 0, true, oidb_0x791_reddotinfo, true, z16);
        }
    }

    public void H2() {
        this.f78326h.addObserver(this.f78327i);
    }

    public void I2(int i3) {
        String str = "7719.771901";
        if (i3 == 60) {
            E2(60, false);
        } else if (i3 == 59) {
            E2(59, false);
            str = "7719.771903";
        } else if (i3 == 38) {
            str = "7719.771904";
        } else if (i3 != 53 && i3 != 54) {
            if (i3 == 70) {
                E2(70, false);
            } else if (i3 != 42) {
                str = "";
            }
        }
        if (str.length() <= 0) {
            return;
        }
        IRedTouchManager iRedTouchManager = (IRedTouchManager) this.f78326h.getRuntimeService(IRedTouchManager.class, "");
        iRedTouchManager.onRedTouchItemClick(str);
        if (iRedTouchManager.getNumRedPathListByAppId(BusinessInfoCheckUpdateItem.UIAPPID_NEARBY_NEW) == null) {
            return;
        }
        iRedTouchManager.onReportNumRedPoint(BusinessInfoCheckUpdateItem.UIAPPID_NEARBY_NEW, str);
    }

    public void J2(oidb_0x791$RedDotInfo oidb_0x791_reddotinfo) {
        if (oidb_0x791_reddotinfo == null) {
            return;
        }
        oidb_0x791$SetRedDotOpt oidb_0x791_setreddotopt = new oidb_0x791$SetRedDotOpt();
        oidb_0x791_setreddotopt.uint64_cmd_uin.set(Long.parseLong(this.f78326h.getCurrentAccountUin()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(Long.parseLong(this.f78326h.getCurrentAccountUin())));
        oidb_0x791_setreddotopt.rpt_uint64_uin.set(arrayList);
        oidb_0x791_setreddotopt.bool_clear.set(true);
        if (oidb_0x791_reddotinfo.uint32_appid.get() == 46) {
            oidb_0x791_setreddotopt.bool_push_to_client.set(true);
        } else {
            oidb_0x791_setreddotopt.bool_push_to_client.set(false);
        }
        oidb_0x791$ReqBody oidb_0x791_reqbody = new oidb_0x791$ReqBody();
        oidb_0x791_reqbody.msg_set_reddot.set(oidb_0x791_setreddotopt);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1937);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(oidb_0x791_reddotinfo.uint32_appid.get());
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x791_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f78326h.getApplication(), m.class);
        newIntent.putExtra("cmd", "OidbSvc.0x791_" + String.valueOf(oidb_0x791_reddotinfo.uint32_appid.get()));
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.setObserver(new a());
        this.f78326h.startServlet(newIntent);
    }

    public void K2(int i3, boolean z16, int i16, boolean z17, oidb_0x791$RedDotInfo oidb_0x791_reddotinfo, boolean z18, boolean z19) {
        int i17;
        oidb_0x791$SetRedDotOpt oidb_0x791_setreddotopt = new oidb_0x791$SetRedDotOpt();
        oidb_0x791_setreddotopt.uint64_cmd_uin.set(Long.parseLong(this.f78326h.getCurrentAccountUin()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(Long.parseLong(this.f78326h.getCurrentAccountUin())));
        oidb_0x791_setreddotopt.rpt_uint64_uin.set(arrayList);
        oidb_0x791_setreddotopt.bool_clear.set(z16);
        if (i16 >= 0) {
            oidb_0x791_setreddotopt.uint32_total_number.set(i16);
        }
        oidb_0x791_setreddotopt.bool_keep_unchanged.set(z17);
        oidb_0x791_setreddotopt.bool_push_to_client.set(z18);
        if (oidb_0x791_reddotinfo != null) {
            if (oidb_0x791_reddotinfo.bool_display_reddot.has()) {
                oidb_0x791_setreddotopt.bool_display_reddot.set(oidb_0x791_reddotinfo.bool_display_reddot.get());
            }
            if (oidb_0x791_reddotinfo.uint32_number.has()) {
                oidb_0x791_setreddotopt.int32_number.set(oidb_0x791_reddotinfo.uint32_number.get());
            }
            if (oidb_0x791_reddotinfo.str_custom_buffer.has()) {
                oidb_0x791_setreddotopt.str_custom_buffer.set(oidb_0x791_reddotinfo.str_custom_buffer.get());
            }
            if (oidb_0x791_reddotinfo.str_face_url.has()) {
                oidb_0x791_setreddotopt.str_face_url.set(oidb_0x791_reddotinfo.str_face_url.get());
            }
            if (oidb_0x791_reddotinfo.uint32_expire_time.has()) {
                oidb_0x791_setreddotopt.uint32_expire_time.set(oidb_0x791_reddotinfo.uint32_expire_time.get());
            }
            if (oidb_0x791_reddotinfo.uint64_cmd_uin.has()) {
                oidb_0x791_setreddotopt.uint64_cmd_uin.set(oidb_0x791_reddotinfo.uint64_cmd_uin.get());
            }
            if (oidb_0x791_reddotinfo.uint32_reason.has()) {
                oidb_0x791_setreddotopt.uint32_reason.set(oidb_0x791_reddotinfo.uint32_reason.get());
            }
            if (oidb_0x791_reddotinfo.uint32_last_time.has()) {
                oidb_0x791_setreddotopt.uint32_last_time.set(oidb_0x791_reddotinfo.uint32_last_time.get());
            }
        }
        oidb_0x791$ReqBody oidb_0x791_reqbody = new oidb_0x791$ReqBody();
        oidb_0x791_reqbody.msg_set_reddot.set(oidb_0x791_setreddotopt);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        PBUInt32Field pBUInt32Field = oidb_sso_oidbssopkg.uint32_command;
        if (z19) {
            i17 = 2887;
        } else {
            i17 = 1937;
        }
        pBUInt32Field.set(i17);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(i3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x791_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(this.f78326h.getApplication(), m.class);
        newIntent.putExtra("cmd", "OidbSvc.0x791_" + String.valueOf(i3));
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.setObserver(new c());
        this.f78326h.startServlet(newIntent);
    }

    public void L2() {
        this.f78326h.removeObserver(this.f78327i);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return com.tencent.mobileqq.observer.b.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        d dVar = this.f78324e;
        if (dVar != null) {
            AppNetConnInfo.unregisterNetInfoHandler(dVar);
        }
        this.f78323d = 0;
        super.onDestroy();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class d implements INetInfoHandler {

        /* renamed from: d, reason: collision with root package name */
        protected WeakReference<TroopRedTouchHandler> f78335d;

        public d(TroopRedTouchHandler troopRedTouchHandler) {
            this.f78335d = new WeakReference<>(troopRedTouchHandler);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            TroopRedTouchHandler troopRedTouchHandler = this.f78335d.get();
            if (troopRedTouchHandler != null) {
                troopRedTouchHandler.f78323d = 2;
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            TroopRedTouchHandler troopRedTouchHandler = this.f78335d.get();
            if (troopRedTouchHandler != null) {
                troopRedTouchHandler.f78323d = 2;
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
