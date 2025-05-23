package com.tencent.mobileqq.simpleui;

import QC.Concise;
import QC.UniBusinessItem;
import QC.UniSetReq;
import QC.UniSetRsp;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.loginregister.SwitchSimpleModeResult;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.config.ThemeSplashHelper;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.NormalNightModeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.cmd0xed1.oidb_0xed1$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tianshu.growth.SimpleModeGrowth$GetConciseModelStReq;
import tianshu.growth.SimpleModeGrowth$GetConciseModelStResp;
import tianshu.growth.SimpleModeGrowth$GetTargetStResp;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SimpleUIHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    private QQAppInterface C;
    private long D;
    private long E;

    /* renamed from: d, reason: collision with root package name */
    private AtomicLong f288501d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicInteger f288502e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f288503f;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicInteger f288504h;

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f288505i;

    /* renamed from: m, reason: collision with root package name */
    volatile boolean f288506m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class EmptyThemeSwitchCallback extends ThemeSwitchCallback {
        static IPatchRedirector $redirector_;
        private boolean mHandled;

        public EmptyThemeSwitchCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SimpleUIHandler.this);
            } else {
                this.mHandled = false;
            }
        }

        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
        public boolean postSwitch(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
            }
            QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("emptyCallback postSwitch %d", Integer.valueOf(i3)));
            if (this.mHandled) {
                return true;
            }
            this.mHandled = true;
            SimpleUIHandler simpleUIHandler = SimpleUIHandler.this;
            simpleUIHandler.g3(simpleUIHandler.f288502e, SimpleUIHandler.this.f288503f);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class SimpleUIThemeSwitchCallback extends ThemeSwitchCallback {
        static IPatchRedirector $redirector_;
        private boolean mHandled;

        public SimpleUIThemeSwitchCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SimpleUIHandler.this);
            } else {
                this.mHandled = false;
            }
        }

        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
        public boolean postSwitch(int i3) {
            int i16;
            boolean z16;
            boolean z17;
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
            }
            QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("postSwitch %d", Integer.valueOf(i3)));
            if (this.mHandled) {
                return true;
            }
            this.mHandled = true;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            return true;
                        }
                    } else {
                        i16 = 1;
                    }
                }
                i16 = 3;
            } else {
                i16 = 0;
            }
            if (i16 == 0) {
                if (!AppNetConnInfo.isNetSupport()) {
                    SimpleUIHandler simpleUIHandler = SimpleUIHandler.this;
                    simpleUIHandler.notifyUI(3, false, new Object[]{Boolean.TRUE, Boolean.valueOf(simpleUIHandler.f288506m), 6});
                    boolean M2 = SimpleUIHandler.this.M2(false, ThemeReporter.FROM_SIMPLE, SimpleUIUtil.getSimpleUISwitch(), true, SimpleUIUtil.getThemeId(SimpleUIUtil.getSimpleUIPref()));
                    if (!M2) {
                        SimpleUIHandler simpleUIHandler2 = SimpleUIHandler.this;
                        simpleUIHandler2.g3(simpleUIHandler2.f288502e, SimpleUIHandler.this.f288503f);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("postSwitch net_err revert theme bStartSwtich=%b", Boolean.valueOf(M2)));
                    }
                    return true;
                }
                SimpleUIHandler simpleUIHandler3 = (SimpleUIHandler) SimpleUIHandler.this.C.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
                SimpleUIHandler simpleUIHandler4 = SimpleUIHandler.this;
                if (simpleUIHandler4.O2(simpleUIHandler4.f288502e) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                SimpleUIHandler simpleUIHandler5 = SimpleUIHandler.this;
                int O2 = simpleUIHandler5.O2(simpleUIHandler5.f288503f);
                SimpleUIHandler simpleUIHandler6 = SimpleUIHandler.this;
                if (simpleUIHandler6.O2(simpleUIHandler6.f288504h) == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                SimpleUIHandler simpleUIHandler7 = SimpleUIHandler.this;
                if (simpleUIHandler7.O2(simpleUIHandler7.f288505i) == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                try {
                    SimpleUIHandler.this.f288501d.set(simpleUIHandler3.d3(z16, O2, SimpleUIHandler.this.f288506m, z17, z18));
                } catch (Exception unused) {
                }
            } else {
                SimpleUIHandler simpleUIHandler8 = SimpleUIHandler.this;
                simpleUIHandler8.g3(simpleUIHandler8.f288502e, SimpleUIHandler.this.f288503f, SimpleUIHandler.this.f288504h, SimpleUIHandler.this.f288505i);
                SimpleUIHandler simpleUIHandler9 = SimpleUIHandler.this;
                simpleUIHandler9.notifyUI(3, false, new Object[]{Boolean.FALSE, Boolean.valueOf(simpleUIHandler9.f288506m), Integer.valueOf(i16)});
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f288510d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f288511e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f288512f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f288513h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f288514i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ long f288515m;

        a(boolean z16, boolean z17, boolean z18, boolean z19, int i3, long j3) {
            this.f288510d = z16;
            this.f288511e = z17;
            this.f288512f = z18;
            this.f288513h = z19;
            this.f288514i = i3;
            this.f288515m = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SimpleUIHandler.this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19), Integer.valueOf(i3), Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                return;
            }
            StringBuilder sb5 = new StringBuilder("sendSwitchBubbleUnread onUpdate");
            sb5.append(" type=");
            sb5.append(i3);
            sb5.append(",success=");
            sb5.append(z16);
            sb5.append(",data=");
            if (obj == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb5.append(z17);
            boolean z18 = obj instanceof UniSetRsp;
            if (z18) {
                sb5.append(",ret=");
                sb5.append(((UniSetRsp) obj).ret);
            }
            QLog.i("SimpleUILog.SimpleUIHandler", 1, sb5.toString());
            if (z16 && z18 && ((UniSetRsp) obj).ret == 0) {
                SimpleUIHandler.this.b3(new boolean[]{this.f288510d, this.f288511e, this.f288512f, this.f288513h}, this.f288514i, this.f288515m);
            } else {
                SimpleUIHandler.this.U2(this.f288513h);
            }
        }
    }

    public SimpleUIHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f288501d = new AtomicLong(0L);
        this.f288502e = new AtomicInteger(Integer.MIN_VALUE);
        this.f288503f = new AtomicInteger(Integer.MIN_VALUE);
        this.f288504h = new AtomicInteger(Integer.MIN_VALUE);
        this.f288505i = new AtomicInteger(Integer.MIN_VALUE);
        this.f288506m = true;
        this.D = 0L;
        this.E = 0L;
        this.C = qQAppInterface;
        ThemeFontAdapter.w();
    }

    public static void L2(boolean z16, int i3, QQAppInterface qQAppInterface, boolean z17, boolean z18) {
        boolean z19;
        QLog.d("SimpleUILog.SimpleUIHandler", 1, "[KidMode]doSwitchSimpleMode sSimpleOpen:", Boolean.valueOf(z16), " sSimpleThemeId:", Integer.valueOf(i3), " sStudyOpen:", Boolean.valueOf(z17), " sKidOpen:", Boolean.valueOf(z18));
        boolean z26 = z17 | z18;
        StudyModeManager.R(z26, qQAppInterface);
        ((l) qQAppInterface.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).t(z26);
        if (StudyModeManager.d(qQAppInterface, z26, z16)) {
            z16 = false;
        }
        if (z16 || z26) {
            ElderModeManager.q(false);
        }
        int themeIndex = SimpleUIUtil.getThemeIndex(String.valueOf(i3));
        if (themeIndex != -1) {
            g.i(qQAppInterface, themeIndex);
            g.g(qQAppInterface.getCurrentAccountUin(), z16, 1);
            if (!NormalNightModeUtil.getNormalNightModeFeatureSwitch() || z16) {
                g.f(qQAppInterface.getCurrentAccountUin(), themeIndex, 1);
            }
        } else {
            g.c(qQAppInterface, z16, String.valueOf(i3));
        }
        SimpleUIHandler simpleUIHandler = (SimpleUIHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
        boolean a16 = com.tencent.relation.common.config.toggle.b.a(1);
        if (QLog.isColorLevel()) {
            QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("simpleUIReqMerge:%b", Boolean.valueOf(a16)));
        }
        if (!z16 && !z26) {
            ElderModeManager.a(qQAppInterface);
        }
        if (!z16 && !z26 && !a16) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("sSimpleOpen: %b, retKidOpen: %b, simpleUIReqMerge:%b, requestGetSimpleUISwitch: %b", Boolean.valueOf(z16), Boolean.valueOf(z26), Boolean.valueOf(a16), Boolean.valueOf(z19)));
        }
        if (z19) {
            simpleUIHandler.a3();
        }
        boolean a17 = com.tencent.relation.common.config.toggle.b.a(6);
        if (QLog.isColorLevel()) {
            QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("simpleUIExpLebaFrameModeReqMerge:%b", Boolean.valueOf(a17)));
        }
        if (!a17) {
            simpleUIHandler.Z2();
        }
        ThemeSplashHelper.v();
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).triggerChatsNtFilter(com.tencent.mobileqq.studymode.g.a());
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.simpleui.SimpleUIHandler.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    SimpleModeHelper.F();
                }
            }
        }, 5000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean N2(boolean z16, String str, boolean z17, boolean z18, String str2, boolean z19) {
        String str3;
        IThemeSwitchCallback emptyThemeSwitchCallback;
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(this.C, true, null);
        String userCurrentThemeId = ThemeUtil.getUserCurrentThemeId(this.C);
        String string = ThemeSwitchUtil.getPreviousThemeIdVersion(this.C).getString("themeID");
        if (TextUtils.isEmpty(string)) {
            string = "1000";
        }
        if (z18) {
            if (isNowThemeIsNight) {
                if (z17) {
                    str3 = "2920";
                } else {
                    str3 = "1103";
                }
            } else if (!z17) {
                str3 = string;
            }
            QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("doSwitchTheme needCallback=%b dst=[%b,%s][cur,pre,to]=[%s,%s,%s]", Boolean.valueOf(z16), Boolean.valueOf(z17), str2, userCurrentThemeId, string, str3));
            if (!userCurrentThemeId.equals(str3) && !z19) {
                return false;
            }
            QQAppInterface qQAppInterface = this.C;
            if (!z16) {
                emptyThemeSwitchCallback = new SimpleUIThemeSwitchCallback();
            } else {
                emptyThemeSwitchCallback = new EmptyThemeSwitchCallback();
            }
            return ThemeSwitcher.startSwitch(qQAppInterface, str3, str, emptyThemeSwitchCallback);
        }
        str3 = str2;
        QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("doSwitchTheme needCallback=%b dst=[%b,%s][cur,pre,to]=[%s,%s,%s]", Boolean.valueOf(z16), Boolean.valueOf(z17), str2, userCurrentThemeId, string, str3));
        if (!userCurrentThemeId.equals(str3)) {
        }
        QQAppInterface qQAppInterface2 = this.C;
        if (!z16) {
        }
        return ThemeSwitcher.startSwitch(qQAppInterface2, str3, str, emptyThemeSwitchCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O2(AtomicInteger atomicInteger) {
        int i3;
        synchronized (this.f288502e) {
            i3 = atomicInteger.get();
        }
        return i3;
    }

    private void P2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Bundle bundle = toServiceMsg.extraData;
        if (bundle == null) {
            QLog.i("SimpleUILog.SimpleUIHandler", 1, "handleReqGetTargetSt req.extraData is null");
            return;
        }
        String string = bundle.getString("uin", "");
        if (TextUtils.isEmpty(string)) {
            QLog.i("SimpleUILog.SimpleUIHandler", 1, "handleReqGetTargetSt uin error = " + string);
            return;
        }
        SimpleModeGrowth$GetTargetStResp simpleModeGrowth$GetTargetStResp = new SimpleModeGrowth$GetTargetStResp();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, simpleModeGrowth$GetTargetStResp);
        if (parseOIDBPkg != 0) {
            QLog.i("SimpleUILog.SimpleUIHandler", 1, "handleReqGetTargetSt code = " + parseOIDBPkg);
            return;
        }
        g.e(string, simpleModeGrowth$GetTargetStResp.target.get());
    }

    private void Q2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        this.E = System.currentTimeMillis();
        QLog.d("SimpleUILog.SimpleUIHandler", 1, "handleReqGetConciseModelSt request time spend: " + (((float) (this.E - this.D)) / 1000.0f) + " seconds, start delay 800ms to execute actually");
        ThreadManagerV2.executeDelay(new Runnable(toServiceMsg, fromServiceMsg, obj) { // from class: com.tencent.mobileqq.simpleui.SimpleUIHandler.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ToServiceMsg f288507d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ FromServiceMsg f288508e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Object f288509f;

            {
                this.f288507d = toServiceMsg;
                this.f288508e = fromServiceMsg;
                this.f288509f = obj;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SimpleUIHandler.this, toServiceMsg, fromServiceMsg, obj);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("delete_800_ms_block_adjust_8996_115165323", false);
                QLog.i("SimpleUILog.SimpleUIHandler", 1, "handleReqGetConciseModelSt, delete800msAdjustSwitch:" + isSwitchOn);
                if (isSwitchOn) {
                    return;
                }
                Bundle bundle = this.f288507d.extraData;
                if (bundle == null) {
                    QLog.d("SimpleUILog.SimpleUIHandler", 1, "handleReqGetConciseModelSt req.extraData is null");
                    return;
                }
                String string = bundle.getString("uin", "");
                if (TextUtils.isEmpty(string)) {
                    QLog.i("SimpleUILog.SimpleUIHandler", 1, "handleReqGetConciseModelSt uin error = " + string);
                    return;
                }
                SimpleModeGrowth$GetConciseModelStResp simpleModeGrowth$GetConciseModelStResp = new SimpleModeGrowth$GetConciseModelStResp();
                int parseOIDBPkg = OidbWrapper.parseOIDBPkg(this.f288508e, this.f288509f, simpleModeGrowth$GetConciseModelStResp);
                if (parseOIDBPkg != 0) {
                    QLog.i("SimpleUILog.SimpleUIHandler", 1, "handleReqGetSimpleUIConciseMode code = " + parseOIDBPkg);
                    return;
                }
                int i3 = simpleModeGrowth$GetConciseModelStResp.userType.get();
                int i16 = simpleModeGrowth$GetConciseModelStResp.concise_model.get();
                int i17 = simpleModeGrowth$GetConciseModelStResp.now_concise_model.get();
                SharedPreferences.Editor edit = ThemeUtil.getUinThemePreferences(SimpleUIHandler.this.C).edit();
                edit.putInt("key_use_simple_mode_directly_user_type", i3);
                edit.putInt("key_use_simple_mode_directly", i16);
                List<String> list = QQTheme.SIMPLE_THEME_IDS;
                edit.putInt("key_normal_user_switch_to_simple_mode_directly", list.indexOf(String.valueOf(i17)));
                edit.apply();
                g.d(string, i16);
                SwitchSimpleModeResult.j(SimpleUIHandler.this.C, string, i3, i16, list.indexOf(String.valueOf(i17)));
            }
        }, 16, null, true, 800L);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void T2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        char c16;
        char c17;
        char c18;
        int i16;
        int i17;
        oidb_sso$OIDBSSOPkg mergeFrom;
        Object obj2;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = toServiceMsg.extraData.getBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
        boolean z18 = toServiceMsg.extraData.getBoolean("studyModeSwitch");
        boolean z19 = toServiceMsg.extraData.getBoolean("elderModeSwitch");
        int i18 = toServiceMsg.extraData.getInt("pref");
        boolean z26 = toServiceMsg.extraData.getBoolean("switchElsePref");
        long j3 = toServiceMsg.extraData.getLong("reqTs");
        String currentAccountUin = this.C.getCurrentAccountUin();
        StringBuilder sb5 = new StringBuilder(1024);
        if (z16) {
            try {
                mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
            } catch (Exception e17) {
                e = e17;
            }
            try {
                if (mergeFrom.uint32_result.has() && mergeFrom.uint32_result.get() == 0) {
                    if (mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                        sb5.append(String.format("suc=%b bSwitch=%b bPref=%d [%s]", Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i18), this.C.getCurrentAccountUin()));
                        ElderModeManager.q(z19);
                        StudyModeManager.R(z18, this.C);
                        g.g(this.C.getCurrentAccountUin(), z17, 3);
                        g.f(this.C.getCurrentAccountUin(), i18, 3);
                    } else {
                        sb5.append("fail pkg.bytes is null");
                    }
                } else {
                    Object[] objArr = new Object[1];
                    if (mergeFrom.uint32_result.has()) {
                        obj2 = Integer.valueOf(mergeFrom.uint32_result.get());
                    } else {
                        obj2 = "no result";
                    }
                    objArr[0] = obj2;
                    sb5.append(String.format("fail %s", objArr));
                }
                z16 = false;
            } catch (InvalidProtocolBufferMicroException e18) {
                e = e18;
                z16 = false;
                e.printStackTrace();
                boolean z27 = z16;
                sb5.append(",ts=");
                sb5.append(j3);
                sb5.append(", mReqTs:=");
                sb5.append(this.f288501d.get());
                QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("handleReqSetSimpleUISwitch %s", sb5.toString()));
                if (j3 == this.f288501d.get()) {
                }
                if (j3 != 0) {
                }
            } catch (Exception e19) {
                e = e19;
                z16 = false;
                QLog.i("SimpleUILog.SimpleUIHandler", 2, "handleReqSetSimpleUISwitch occur exception", e);
                boolean z272 = z16;
                sb5.append(",ts=");
                sb5.append(j3);
                sb5.append(", mReqTs:=");
                sb5.append(this.f288501d.get());
                QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("handleReqSetSimpleUISwitch %s", sb5.toString()));
                if (j3 == this.f288501d.get()) {
                }
                if (j3 != 0) {
                }
            }
        } else {
            sb5.append(String.format("fail resultCode=%d", Integer.valueOf(fromServiceMsg.getResultCode())));
        }
        boolean z2722 = z16;
        sb5.append(",ts=");
        sb5.append(j3);
        sb5.append(", mReqTs:=");
        sb5.append(this.f288501d.get());
        QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("handleReqSetSimpleUISwitch %s", sb5.toString()));
        if (j3 == this.f288501d.get()) {
            if (!z2722) {
                c16 = 4;
                boolean M2 = M2(false, ThemeReporter.FROM_SIMPLE, SimpleUIUtil.getSimpleUISwitch(), true, SimpleUIUtil.getThemeId(SimpleUIUtil.getSimpleUIPref()));
                if (!M2) {
                    i17 = 1;
                    g3(this.f288502e, this.f288503f, this.f288504h, this.f288505i);
                } else {
                    i17 = 1;
                }
                if (QLog.isColorLevel()) {
                    Object[] objArr2 = new Object[i17];
                    objArr2[0] = Boolean.valueOf(M2);
                    c17 = 2;
                    QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqSetSimpleUISwitch revert theme bStartSwtich=%b", objArr2));
                } else {
                    c17 = 2;
                }
                c18 = 1;
                i16 = 3;
            } else {
                c17 = 2;
                c16 = 4;
                c18 = 1;
                i16 = 3;
                g3(this.f288502e, this.f288503f, this.f288504h, this.f288505i);
            }
            Object[] objArr3 = new Object[i16];
            objArr3[0] = Boolean.TRUE;
            objArr3[c18] = Boolean.valueOf(z26);
            i3 = 5;
            objArr3[c17] = 5;
            notifyUI(i16, z2722, objArr3);
        } else {
            i3 = 5;
            c16 = 4;
        }
        if (j3 != 0) {
            Object[] objArr4 = new Object[i3];
            objArr4[0] = Boolean.valueOf(z17);
            objArr4[1] = Integer.valueOf(i18);
            objArr4[2] = Boolean.valueOf(z26);
            objArr4[3] = currentAccountUin;
            objArr4[c16] = Long.valueOf(j3);
            notifyUI(2, z2722, objArr4);
        }
    }

    private boolean V2(boolean z16, String str) {
        boolean isNowThemeIsSimple = ThemeUtil.isNowThemeIsSimple(this.C, true, null);
        String userCurrentThemeId = ThemeUtil.getUserCurrentThemeId(this.C);
        if (isNowThemeIsSimple != z16) {
            return true;
        }
        if (z16 && !str.equals(userCurrentThemeId)) {
            return true;
        }
        return false;
    }

    private boolean W2(boolean z16) {
        if (z16 && !QQTheme.isSimpleWhite()) {
            return true;
        }
        return false;
    }

    public static void e3(boolean z16, int i3, BusinessObserver businessObserver) {
        IJce build = VasUtil.getService().getJceRequset().build("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.uniSet", "stReq", "rsp");
        UniSetReq uniSetReq = new UniSetReq();
        uniSetReq.stLogin = IJce.Util.getLoginInfo();
        UniBusinessItem uniBusinessItem = new UniBusinessItem();
        uniSetReq.stUniBusinessItem = uniBusinessItem;
        uniBusinessItem.appid = 307;
        uniBusinessItem.itemid = Integer.decode(SimpleUIUtil.getThemeId(i3)).intValue();
        Concise concise = new Concise();
        uniSetReq.stConcise = concise;
        concise.isSwitch = z16 ? 1 : 0;
        build.request("uniSet", uniSetReq, new UniSetRsp(), businessObserver, false);
    }

    private void f3(AtomicInteger atomicInteger, int i3, AtomicInteger atomicInteger2, int i16, AtomicInteger atomicInteger3, int i17, AtomicInteger atomicInteger4, int i18) {
        synchronized (this.f288502e) {
            if (atomicInteger != null) {
                try {
                    atomicInteger.set(i3);
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            if (atomicInteger2 != null) {
                atomicInteger2.set(i16);
            }
            if (atomicInteger3 != null) {
                atomicInteger3.set(i17);
            }
            if (atomicInteger4 != null) {
                atomicInteger4.set(i18);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3(AtomicInteger... atomicIntegerArr) {
        for (AtomicInteger atomicInteger : atomicIntegerArr) {
            if (atomicInteger != null) {
                atomicInteger.set(Integer.MIN_VALUE);
            }
        }
    }

    protected boolean M2(boolean z16, String str, boolean z17, boolean z18, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Boolean.valueOf(z18), str2)).booleanValue();
        }
        return N2(z16, str, z17, z18, str2, false);
    }

    public void R2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String string = toServiceMsg.extraData.getString("uin", "");
        if (TextUtils.isEmpty(string)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleReqGetSimpleUIConciseMode uin error= ");
            if (string == null) {
                str = "null";
            } else {
                str = GlobalUtil.DEF_STRING;
            }
            sb5.append(str);
            QLog.i("SimpleUILog.SimpleUIHandler", 1, sb5.toString());
            return;
        }
        oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x5eb_rspbody);
        if (parseOIDBPkg != 0) {
            QLog.i("SimpleUILog.SimpleUIHandler", 1, "handleReqGetSimpleUIConciseMode code= " + parseOIDBPkg);
            return;
        }
        PBRepeatMessageField<oidb_0x5eb$UdcUinData> pBRepeatMessageField = oidb_0x5eb_rspbody.rpt_msg_uin_data;
        if (pBRepeatMessageField.size() > 0) {
            int i3 = 0;
            oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = pBRepeatMessageField.get(0);
            if (oidb_0x5eb_udcuindata.unit32_concise_mode_flag.has()) {
                i3 = oidb_0x5eb_udcuindata.unit32_concise_mode_flag.get();
            }
            g.d(string, i3);
        }
    }

    public void S2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ToServiceMsg toServiceMsg2;
        boolean z16;
        StringBuilder sb5;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        Object obj2;
        int i3;
        boolean z27;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            toServiceMsg2 = toServiceMsg;
            z16 = true;
        } else {
            toServiceMsg2 = toServiceMsg;
            z16 = false;
        }
        String string = toServiceMsg2.extraData.getString("uin", "");
        int simpleUIPref = SimpleUIUtil.getSimpleUIPref();
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder(1024);
        } else {
            sb5 = null;
        }
        StringBuilder sb6 = sb5;
        if (z16) {
            byte[] bArr = (byte[]) obj;
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                if (oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                    oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                    try {
                        oidb_0x5eb_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    } catch (InvalidProtocolBufferMicroException e17) {
                        e17.printStackTrace();
                    }
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                        oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0);
                        int i17 = oidb_0x5eb_udcuindata.uint32_simple_ui_switch.get();
                        int i18 = oidb_0x5eb_udcuindata.uint32_flag_study_mode_switch.get();
                        int i19 = oidb_0x5eb_udcuindata.uint32_elder_mode_flag.get();
                        if (oidb_0x5eb_udcuindata.uint32_flag_kid_mode_switch.has()) {
                            i16 = oidb_0x5eb_udcuindata.uint32_flag_kid_mode_switch.get();
                        } else {
                            i16 = 0;
                        }
                        QLog.d("SimpleUILog.SimpleUIHandler", 1, "studyFlag:", Integer.valueOf(i18), " kidModeFlag:", Integer.valueOf(i16));
                        if (i18 != 1 && i16 != 1) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (i17 == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (i19 == 1) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        i3 = SimpleUIUtil.getSimpleUIPref();
                        if (z18 && (z17 || z27)) {
                            QLog.e("SimpleUILog.SimpleUIHandler", 1, "[KidMode: ", Boolean.valueOf(z17), "] or [ElderMode: ", Boolean.valueOf(z27), "] is true");
                            z18 = false;
                            i3 = 0;
                        }
                        g.g(string, z18, 2);
                        g.f(string, i3, 2);
                        StudyModeManager.R(z17, this.C);
                        ((IChatsUtil) QRoute.api(IChatsUtil.class)).triggerChatsNtFilter(com.tencent.mobileqq.studymode.g.a());
                        z26 = true;
                    } else {
                        z17 = false;
                        z18 = false;
                        z26 = false;
                        i3 = simpleUIPref;
                        z27 = false;
                    }
                    if (sb6 != null) {
                        sb6.append(String.format("suc=%b %s", Boolean.valueOf(z26), string));
                    }
                    z19 = z27;
                    simpleUIPref = i3;
                } else if (sb6 != null) {
                    sb6.append("fail pkg.bytes is null");
                }
            } else if (sb6 != null) {
                Object[] objArr = new Object[1];
                if (oidb_sso_oidbssopkg == null) {
                    obj2 = "pkg=null";
                } else if (oidb_sso_oidbssopkg.uint32_result.has()) {
                    obj2 = Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.get());
                } else {
                    obj2 = "no result";
                }
                objArr[0] = obj2;
                sb6.append(String.format("fail %s", objArr));
            }
            z17 = false;
            z18 = false;
            z26 = false;
            i3 = simpleUIPref;
            z27 = false;
            z19 = z27;
            simpleUIPref = i3;
        } else {
            if (sb6 != null) {
                sb6.append(String.format("fail resultCode=%d", Integer.valueOf(fromServiceMsg.getResultCode())));
            }
            z17 = false;
            z18 = false;
            z19 = false;
            z26 = false;
        }
        if (QLog.isColorLevel() && sb6 != null) {
            sb6.append("; bSwitch = ");
            sb6.append(z18);
            sb6.append("; bPref = ");
            sb6.append(simpleUIPref);
            QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("handleReqGetSimpleUISwitch %s", sb6.toString()));
        }
        notifyUI(1, z26, new Object[]{Boolean.valueOf(z18), Boolean.valueOf(z17), Integer.valueOf(simpleUIPref), string, Boolean.valueOf(z19)});
    }

    protected void U2(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        l lVar = (l) this.C.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
        int i16 = this.f288503f.get();
        if (z16) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        lVar.l(i16, i3);
        g3(this.f288502e, this.f288503f, this.f288504h, this.f288505i);
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        notifyUI(3, false, new Object[]{bool, bool2, 5});
        notifyUI(5, false, new Object[]{1, Integer.valueOf(SimpleUIUtil.getSimpleUIPref()), bool2, bool});
    }

    public boolean X2(boolean z16, int i3) {
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Integer.valueOf(i3))).booleanValue();
        }
        if (O2(this.f288502e) != Integer.MIN_VALUE) {
            QLog.i("SimpleUILog.SimpleUIHandler", 1, "onGetSimpleUISwitchLogin mToSwitch minValue");
            return false;
        }
        String userCurrentThemeId = ThemeUtil.getUserCurrentThemeId(this.C);
        if (!V2(z16, SimpleUIUtil.getThemeId(i3)) && !ElderModeManager.j()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            z18 = N2(false, ThemeReporter.FROM_SIMPLE_INIT, (z16 ? 1 : 0) | (ElderModeManager.j() ? 1 : 0), true, SimpleUIUtil.getThemeId(i3), ElderModeManager.j());
        } else {
            z18 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("onGetSimpleUISwtichLogin [%b,%b] cur=%s needChange=%b start=%b", Boolean.valueOf(z16), Integer.valueOf(i3), userCurrentThemeId, Boolean.valueOf(z17), Boolean.valueOf(z18)));
        }
        if (z18) {
            f3(this.f288502e, z16 ? 1 : 0, this.f288503f, i3, null, Integer.MIN_VALUE, null, Integer.MIN_VALUE);
        } else {
            g3(this.f288502e, this.f288503f);
        }
        return z18;
    }

    public void Y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.D = System.currentTimeMillis();
        SimpleModeGrowth$GetConciseModelStReq simpleModeGrowth$GetConciseModelStReq = new SimpleModeGrowth$GetConciseModelStReq();
        simpleModeGrowth$GetConciseModelStReq.uin.set(this.C.getCurrentUin());
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvcTrpcTcp.0x107c", 4220, 1, simpleModeGrowth$GetConciseModelStReq.toByteArray());
        makeOIDBPkg.extraData.putString("uin", this.C.getCurrentAccountUin());
        sendPbReq(makeOIDBPkg);
    }

    public void Z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(this.C.getLongAccountUin()));
        oidb_0x5eb_reqbody.unit32_concise_mode_flag.set(1);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_ExpLebaFrameMode", 1515, 22, oidb_0x5eb_reqbody.toByteArray());
        makeOIDBPkg.extraData.putString("uin", this.C.getCurrentAccountUin());
        sendPbReq(makeOIDBPkg);
    }

    public void a3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        String currentAccountUin = this.C.getCurrentAccountUin();
        if (QLog.isColorLevel()) {
            QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("reqGetSimpleUISwitch uin=%s", currentAccountUin));
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        try {
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.C.getCurrentAccountUin())));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        oidb_0x5eb_reqbody.uint32_simple_ui_switch.set(1);
        oidb_0x5eb_reqbody.uint32_simple_ui_pref.set(1);
        oidb_0x5eb_reqbody.uint32_flag_study_mode_switch.set(1);
        oidb_0x5eb_reqbody.uint32_elder_mode_flag.set(1);
        oidb_0x5eb_reqbody.uint32_flag_kid_mode_switch.set(1);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x5eb_SimpleUI", 1515, 22, oidb_0x5eb_reqbody.toByteArray());
        makeOIDBPkg.extraData.putString("uin", currentAccountUin);
        sendPbReq(makeOIDBPkg);
    }

    public long b3(boolean[] zArr, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, this, zArr, Integer.valueOf(i3), Long.valueOf(j3))).longValue();
        }
        boolean z16 = zArr[0];
        boolean z17 = zArr[1];
        boolean z18 = zArr[2];
        boolean z19 = zArr[3];
        QLog.i("SimpleUILog.SimpleUIHandler", 1, String.format("reqSetSimpleUISwitch [%b,%d,%b, %b] uin=%s", Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z19), this.C.getCurrentAccountUin()));
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(3793);
            oidb_sso_oidbssopkg.uint32_service_type.set(1);
            if (z19) {
                i16 = 1;
            }
            oidb_0xed1$ReqBody oidb_0xed1_reqbody = new oidb_0xed1$ReqBody();
            oidb_0xed1_reqbody.uint32_simple_mode.set(z16 ? 1 : 0);
            oidb_0xed1_reqbody.uint32_learn_mode.set(z18 ? 1 : 0);
            oidb_0xed1_reqbody.uint32_elder_mode.set(i16);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xed1_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xed1_SimpleUI");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.extraData.putBoolean("studyModeSwitch", z18);
            createToServiceMsg.extraData.putBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, z16);
            createToServiceMsg.extraData.putInt("pref", i3);
            createToServiceMsg.extraData.putBoolean("switchElsePref", z17);
            createToServiceMsg.extraData.putBoolean("elderModeSwitch", z19);
            createToServiceMsg.extraData.putLong("reqTs", j3);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SimpleUILog.SimpleUIHandler", 1, "reqSetSimpleUISwitch ex", e16);
            }
        }
        return j3;
    }

    public long c3(boolean z16, int i3, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18))).longValue();
        }
        return d3(z16, i3, z17, z18, ElderModeManager.j());
    }

    public long d3(boolean z16, int i3, boolean z17, boolean z18, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19))).longValue();
        }
        QLog.i("SimpleUILog.SimpleUIHandler", 1, "sendSwitchAndSetSimpleUI switch=" + z16 + ",prefId=" + i3 + ",bSwitchElsePref=" + z17 + ",bStudyModeSwitch=" + z18 + ", bElderModeSwitch=" + z19);
        long currentTimeMillis = System.currentTimeMillis();
        e3(z16, i3, new a(z16, z17, z18, z19, i3, currentTimeMillis));
        return currentTimeMillis;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0x107c");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0x10d1");
        }
        return this.allowCmdSet;
    }

    public boolean h3(boolean z16, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17))).booleanValue();
        }
        return i3(z16, i3, z17, false);
    }

    public boolean i3(boolean z16, int i3, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18))).booleanValue();
        }
        return j3(z16, i3, z17, z18, false);
    }

    public boolean j3(boolean z16, int i3, boolean z17, boolean z18, boolean z19) {
        boolean z26;
        boolean z27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19))).booleanValue();
        }
        if (O2(this.f288502e) != Integer.MIN_VALUE) {
            QLog.i("SimpleUILog.SimpleUIHandler", 1, "startSwitchSimpleUI mToSwitch minValue");
            return false;
        }
        String themeId = SimpleUIUtil.getThemeId(i3);
        if (!V2(z16, themeId) && !W2(z19)) {
            z26 = false;
        } else {
            z26 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("startSwitchSimpleUI [%b,%s,%b] needSwitch=%b", Boolean.valueOf(z16), themeId, Boolean.valueOf(z17), Boolean.valueOf(z26)));
        }
        if (z26) {
            z27 = N2(true, ThemeReporter.FROM_SIMPLE, (z16 ? 1 : 0) | (z19 ? 1 : 0), z17, themeId, z19);
        } else {
            this.f288501d.set(((SimpleUIHandler) this.C.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).b3(new boolean[]{z16, z17, z18, z19}, i3, System.currentTimeMillis()));
            z27 = true;
        }
        if (z27) {
            f3(this.f288502e, z16 ? 1 : 0, this.f288503f, i3, this.f288504h, z18 ? 1 : 0, this.f288505i, z19 ? 1 : 0);
            this.f288506m = z17;
        } else {
            g3(this.f288502e, this.f288503f, this.f288504h, this.f288505i);
        }
        return z27;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return f.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            super.onDestroy();
            SimpleUIUtil.onDestroy();
        }
    }

    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        O2(this.f288502e);
        boolean isNowThemeIsSimple = ThemeUtil.isNowThemeIsSimple(this.C, false, null);
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        if (QLog.isColorLevel()) {
            QLog.i("SimpleUILog.SimpleUIHandler", 2, String.format("onPostThemeChanged bSimpleSwitch=%b isSimpleMode=%b", Boolean.valueOf(simpleUISwitch), Boolean.valueOf(isNowThemeIsSimple)));
        }
        if (isNowThemeIsSimple != simpleUISwitch) {
            QLog.e("SimpleUILog.SimpleUIHandler", 1, String.format("onPostThemeChanged switch inconsistent [%b,%b]", Boolean.valueOf(simpleUISwitch), Boolean.valueOf(isNowThemeIsSimple)));
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (TextUtils.equals("OidbSvc.0x5eb_SimpleUI", fromServiceMsg.getServiceCmd())) {
            S2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (TextUtils.equals("OidbSvc.0xed1_SimpleUI", fromServiceMsg.getServiceCmd())) {
            T2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (TextUtils.equals("OidbSvc.0x5eb_ExpLebaFrameMode", fromServiceMsg.getServiceCmd())) {
            R2(toServiceMsg, fromServiceMsg, obj);
        } else if (TextUtils.equals("OidbSvcTrpcTcp.0x107c", fromServiceMsg.getServiceCmd())) {
            Q2(toServiceMsg, fromServiceMsg, obj);
        } else if (TextUtils.equals("OidbSvcTrpcTcp.0x10d1", fromServiceMsg.getServiceCmd())) {
            P2(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void setReqTs(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, j3);
        } else {
            this.f288501d.set(j3);
        }
    }
}
