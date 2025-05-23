package com.tencent.mobileqq.dt.model;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002R$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/dt/model/h;", "", "", tl.h.F, "", "f", "g", "", "i", "a", "", "uin", "b", "k", "l", "j", "e", "d", "c", "", "Ljava/util/Map;", "mToggleResult", "Z", "mToggleEnable", "mToggleEnableFEKit", "mToggleEnableFEKitSafeMode", "mShiplyEnableRegReport", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "mToggleJsonResult", "mToggleJsonResultFEKit", "mToggleJsonResultFEKitSafeMode", "mShiplyJsonResultRegReport", "<init>", "()V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, String> mToggleResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mToggleEnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mToggleEnableFEKit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mToggleEnableFEKitSafeMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mShiplyEnableRegReport;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONObject mToggleJsonResult;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONObject mToggleJsonResultFEKit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONObject mToggleJsonResultFEKitSafeMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONObject mShiplyJsonResultRegReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/dt/model/h$a;", "", "", "KEY_DOWNLOAD", "Ljava/lang/String;", "KEY_DOWNLOAD_UIN_BEGIN", "KEY_DOWNLOAD_UIN_END", "KEY_FEKIT_SAFE_MODE_COUNT", "KEY_FEKIT_SAFE_MODE_ENABLE", "KEY_FEKIT_SAFE_MODE_TIMEGAP", "KEY_SHIPLY_REG_REPORT_ENABLE", "KEY_TINYID", "KEY_TURINGIDNEW", "TAG", "VALUE_POSITIVE", "shiplyRegActionReport", "toggleFEkitSafeMode", "toggleFEkitSo", "toggleName", "<init>", "()V", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.dt.model.h$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25048);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ava, ProcessConstant.ALL)");
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) runtimeService;
        boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable("devicetoken_report");
        this.mToggleEnable = isFeatureSwitchEnable;
        if (isFeatureSwitchEnable) {
            this.mToggleResult = iFeatureRuntimeService.isEnabledWithDataSet("devicetoken_report", "");
            if (("devicetoken toggle switch attach info :" + this.mToggleResult) != null) {
                str = String.valueOf(this.mToggleResult);
            } else {
                str = null;
            }
            QLog.e("FEKitMain_ToggleDeviceToken", 2, str);
            this.mToggleJsonResult = iFeatureRuntimeService.getJSONObject("devicetoken_report", "{}");
        }
        boolean isFeatureSwitchEnable2 = iFeatureRuntimeService.isFeatureSwitchEnable("fekitso_switch_898");
        this.mToggleEnableFEKit = isFeatureSwitchEnable2;
        if (isFeatureSwitchEnable2) {
            this.mToggleJsonResultFEKit = iFeatureRuntimeService.getJSONObject("fekitso_switch_898", "{}");
        }
        boolean isFeatureSwitchEnable3 = iFeatureRuntimeService.isFeatureSwitchEnable("fekitso_safemode_8913");
        this.mToggleEnableFEKitSafeMode = isFeatureSwitchEnable3;
        if (isFeatureSwitchEnable3) {
            this.mToggleJsonResultFEKitSafeMode = iFeatureRuntimeService.getJSONObject("fekitso_safemode_8913", "{}");
        }
        boolean isFeatureSwitchEnable4 = iFeatureRuntimeService.isFeatureSwitchEnable("reg_action_report");
        this.mShiplyEnableRegReport = isFeatureSwitchEnable4;
        if (isFeatureSwitchEnable4) {
            this.mShiplyJsonResultRegReport = iFeatureRuntimeService.getJSONObject("reg_action_report", "{}");
        }
    }

    public final boolean a() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.mToggleEnableFEKit) {
            JSONObject jSONObject = this.mToggleJsonResultFEKit;
            if (jSONObject != null) {
                str = jSONObject.optString("fekit_download_enable");
            } else {
                str = null;
            }
            return Intrinsics.areEqual("1", str);
        }
        return false;
    }

    public final boolean b(@NotNull String uin) {
        int i3;
        String substring;
        Integer num;
        String optString;
        String optString2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) uin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!a()) {
            return false;
        }
        JSONObject jSONObject = this.mToggleJsonResultFEKit;
        int i16 = 999;
        if (jSONObject != null && (optString2 = jSONObject.optString("fekit_download_uin_begin")) != null) {
            i3 = Integer.parseInt(optString2);
        } else {
            i3 = 999;
        }
        JSONObject jSONObject2 = this.mToggleJsonResultFEKit;
        if (jSONObject2 != null && (optString = jSONObject2.optString("fekit_download_uin_end")) != null) {
            i16 = Integer.parseInt(optString);
        }
        if (uin.length() >= 6) {
            substring = StringsKt__StringsKt.substring(uin, new IntRange(uin.length() - 6, uin.length() - 4));
            if (substring != null) {
                num = Integer.valueOf(Integer.parseInt(substring));
            } else {
                num = null;
            }
            IntRange intRange = new IntRange(i3, i16);
            if (num == null || !intRange.contains(num.intValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean c() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        JSONObject jSONObject = this.mShiplyJsonResultRegReport;
        if (jSONObject != null) {
            obj = jSONObject.opt("loginenable");
        } else {
            obj = null;
        }
        return Intrinsics.areEqual("1", obj);
    }

    public final boolean d() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        JSONObject jSONObject = this.mToggleJsonResult;
        if (jSONObject != null) {
            obj = jSONObject.opt("tinyid");
        } else {
            obj = null;
        }
        return Intrinsics.areEqual("1", obj);
    }

    public final boolean e() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        JSONObject jSONObject = this.mToggleJsonResult;
        if (jSONObject != null) {
            obj = jSONObject.opt("turingidnew");
        } else {
            obj = null;
        }
        return Intrinsics.areEqual("1", obj);
    }

    public final int f() {
        JSONObject jSONObject;
        String optString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (this.mToggleEnableFEKitSafeMode && (jSONObject = this.mToggleJsonResultFEKitSafeMode) != null && (optString = jSONObject.optString("safe_mode_count")) != null) {
            return Integer.parseInt(optString);
        }
        return 10;
    }

    public final int g() {
        JSONObject jSONObject;
        String optString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (this.mToggleEnableFEKitSafeMode && (jSONObject = this.mToggleJsonResultFEKitSafeMode) != null && (optString = jSONObject.optString("safe_mode_timeGap")) != null) {
            return Integer.parseInt(optString);
        }
        return 5000;
    }

    public final boolean h() {
        int i3;
        String optString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!this.mToggleEnableFEKitSafeMode) {
            return false;
        }
        JSONObject jSONObject = this.mToggleJsonResultFEKitSafeMode;
        if (jSONObject != null && (optString = jSONObject.optString("safe_mode_enable")) != null) {
            i3 = Integer.parseInt(optString);
        } else {
            i3 = 0;
        }
        if (i3 < 1) {
            return false;
        }
        return true;
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ava, ProcessConstant.ALL)");
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) runtimeService;
        boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable("fekitso_switch_898");
        this.mToggleEnableFEKit = isFeatureSwitchEnable;
        if (isFeatureSwitchEnable) {
            this.mToggleJsonResultFEKit = iFeatureRuntimeService.getJSONObject("fekitso_switch_898", "{}");
        }
    }

    @NotNull
    public final String j() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        JSONObject jSONObject = this.mToggleJsonResultFEKit;
        if (jSONObject != null) {
            str = jSONObject.toString();
        } else {
            str = null;
        }
        if (str == null) {
            return "{}";
        }
        return str;
    }

    @NotNull
    public final String k() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (!a()) {
            return AEResManagerConfigBean.DEFAULT_VERSION;
        }
        JSONObject jSONObject = this.mToggleJsonResultFEKit;
        if (jSONObject != null) {
            str = jSONObject.optString(HiAnalyticsConstant.BI_KEY_TARGET_VER, "0,0.0");
        } else {
            str = null;
        }
        if (str == null) {
            return AEResManagerConfigBean.DEFAULT_VERSION;
        }
        return str;
    }

    public final boolean l() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (a()) {
            JSONObject jSONObject = this.mToggleJsonResultFEKit;
            String str2 = "0";
            if (jSONObject != null) {
                str = jSONObject.optString("reshub", "0");
            } else {
                str = null;
            }
            if (str != null) {
                str2 = str;
            }
            return Intrinsics.areEqual("1", str2);
        }
        return false;
    }
}
