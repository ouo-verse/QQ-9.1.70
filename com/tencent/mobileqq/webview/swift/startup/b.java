package com.tencent.mobileqq.webview.swift.startup;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.a;
import com.tencent.mobileqq.app.automator.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.startup.step.BrowserStep;
import com.tencent.mobileqq.webview.swift.startup.step.BrowserUIObserverStep;
import com.tencent.mobileqq.webview.swift.startup.step.BrowserUIStep;
import com.tencent.mobileqq.webview.swift.startup.step.CdnCacheConfigParseStep;
import com.tencent.mobileqq.webview.swift.startup.step.InitHtmlSessionStep;
import com.tencent.mobileqq.webview.swift.startup.step.InitX5Step;
import com.tencent.mobileqq.webview.swift.startup.step.InitX5StrategyStep;
import com.tencent.mobileqq.webview.swift.startup.step.OnActivityCreateTasksStep;
import com.tencent.mobileqq.webview.swift.startup.step.PreCreateEngineStep;
import com.tencent.mobileqq.webview.swift.startup.step.PreInitPluginCheckerStep;
import com.tencent.mobileqq.webview.swift.startup.step.ProxyConfigParseStep;
import com.tencent.mobileqq.webview.swift.startup.step.SetTbsUserDataStep;
import com.tencent.mobileqq.webview.swift.startup.step.UAStep;
import com.tencent.mobileqq.webview.swift.startup.step.VipWebReportLogStep;
import com.tencent.mobileqq.webview.swift.startup.step.WebViewPreCreateStep;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bY\u0010ZJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0010R\u0014\u0010\u001f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0014\u0010!\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0010R\u0014\u0010#\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0010R\u0014\u0010$\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0010R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u0010R\u0014\u0010(\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u0010R\u0014\u0010*\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u0010R\u0016\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u0010R\u0014\u0010.\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\u0010R\u0014\u00100\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\u0010R\u0014\u00102\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010\u0010R\u0014\u00104\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010\u0010R\u0014\u00106\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010\u0010R\u0014\u00108\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010\u0010R\u0014\u0010:\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010\u0010R\u0014\u0010<\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010\u0010R\u0014\u0010>\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010\u0010R\u0014\u0010@\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010\u0010R\u0014\u0010B\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010\u0010R\u0014\u0010D\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010\u0010R\u0014\u0010F\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010\u0010R0\u0010P\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020I0H0G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020Q8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010SR\u0014\u0010X\u001a\u00020Q8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010S\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/b;", "Lcom/tencent/mobileqq/app/automator/d$a;", "Landroid/os/Handler;", "b", "", "stepId", "Lcom/tencent/mobileqq/app/automator/AsyncStep;", "a", "e", "Landroid/os/Handler;", "getUiHandler", "()Landroid/os/Handler;", "setUiHandler", "(Landroid/os/Handler;)V", "uiHandler", "f", "I", "STEP_UI_EVENT_ACTIVITY_CREATE", h.F, "STEP_UI_EVENT_KERNEL_CREATE", "i", "STEP_UI_EVENT_KERNEL_START", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "STEP_UI_EVENT_KERNEL_INIT_DATA", BdhLogUtil.LogTag.Tag_Conn, "STEP_UI_EVENT_KERNEL_INIT_X5", "D", "STEP_UI_EVENT_KERNEL_INIT_ENGINE", "E", "STEP_UI_EVENT_KERNEL_INIT_WEBVIEW", UserInfo.SEX_FEMALE, "STEP_UI_EVENT_KERNEL_LOAD_URL", "G", "STEP_UI_EVENT_KERNEL_INIT_UIFRAME", "H", "STEP_UI_EVENT_KERNEL_INIT_UICONTENT", "STEP_UI_EVENT_KERNEL_INIT_TITLEBAR", "J", "STEP_UI_EVENT_KERNEL_INIT_BOTTOM", "K", "STEP_UI_EVENT_KERNEL_INIT_FINAL", "L", "STEP_UI_EVENT_END", "M", "stepCounter", "N", "STEP_X5_INIT", "P", "STEP_X5_INIT_STRATEGY", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "STEP_UA_INIT", BdhLogUtil.LogTag.Tag_Req, "STEP_SET_TBS_USER_DATA", ExifInterface.LATITUDE_SOUTH, "STEP_HTML_SESSION_INIT", "T", "STEP_CDN_CACHE_CONFIG_PARSE", "U", "STEP_PROXY_CONFIG_PARSE", "V", "STEP_TITLESTYLE_PARSE", "W", "STEP_VIP_WEBREPORTLOG", "X", "STEP_PREINIT_PLUGINS", "Y", "STEP_TASKS_ACTIVITY_CREATE", "Z", "STEP_PRECREATE_ENGINE", "a0", "STEP_UI_PRECREATE_WEBVIEW", "Landroid/util/SparseArray;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/webview/swift/startup/step/BrowserStep;", "b0", "Landroid/util/SparseArray;", "getSStepMap", "()Landroid/util/SparseArray;", "setSStepMap", "(Landroid/util/SparseArray;)V", "sStepMap", "", "c0", "Ljava/lang/String;", "STEPS_X5ENV_INIT", "d0", "STEPS_BROWSER_PRELOAD", "e0", "STEPS_STARTUP", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends d.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_INIT_X5;

    /* renamed from: D, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_INIT_ENGINE;

    /* renamed from: E, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_INIT_WEBVIEW;

    /* renamed from: F, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_LOAD_URL;

    /* renamed from: G, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_INIT_UIFRAME;

    /* renamed from: H, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_INIT_UICONTENT;

    /* renamed from: I, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_INIT_TITLEBAR;

    /* renamed from: J, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_INIT_BOTTOM;

    /* renamed from: K, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_INIT_FINAL;

    /* renamed from: L, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_END;

    /* renamed from: M, reason: from kotlin metadata */
    @JvmField
    public static int stepCounter;

    /* renamed from: N, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_X5_INIT;

    /* renamed from: P, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_X5_INIT_STRATEGY;

    /* renamed from: Q, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_UA_INIT;

    /* renamed from: R, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_SET_TBS_USER_DATA;

    /* renamed from: S, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_HTML_SESSION_INIT;

    /* renamed from: T, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_CDN_CACHE_CONFIG_PARSE;

    /* renamed from: U, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_PROXY_CONFIG_PARSE;

    /* renamed from: V, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_TITLESTYLE_PARSE;

    /* renamed from: W, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_VIP_WEBREPORTLOG;

    /* renamed from: X, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_PREINIT_PLUGINS;

    /* renamed from: Y, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_TASKS_ACTIVITY_CREATE;

    /* renamed from: Z, reason: from kotlin metadata */
    @JvmField
    public static final int STEP_PRECREATE_ENGINE;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int STEP_UI_PRECREATE_WEBVIEW;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SparseArray<Class<? extends BrowserStep>> sStepMap;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String STEPS_X5ENV_INIT;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final b f314655d;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String STEPS_BROWSER_PRELOAD;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Handler uiHandler;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final String STEPS_STARTUP;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_ACTIVITY_CREATE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_CREATE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_START;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int STEP_UI_EVENT_KERNEL_INIT_DATA;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_NAMEPLATEVIPTYPE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f314655d = new b();
        STEP_UI_EVENT_ACTIVITY_CREATE = e.EVENT_ACTIVITY_CREATE;
        STEP_UI_EVENT_KERNEL_CREATE = e.EVENT_KERNEL_CREATE;
        STEP_UI_EVENT_KERNEL_START = e.EVENT_KERNEL_START;
        STEP_UI_EVENT_KERNEL_INIT_DATA = e.EVENT_KERNEL_INIT_DATA;
        STEP_UI_EVENT_KERNEL_INIT_X5 = e.EVENT_KERNEL_INIT_X5;
        STEP_UI_EVENT_KERNEL_INIT_ENGINE = e.EVENT_KERNEL_INIT_ENGINE;
        STEP_UI_EVENT_KERNEL_INIT_WEBVIEW = e.EVENT_KERNEL_INIT_WEBVIEW;
        STEP_UI_EVENT_KERNEL_LOAD_URL = e.EVENT_KERNEL_LOAD_URL;
        STEP_UI_EVENT_KERNEL_INIT_UIFRAME = e.EVENT_KERNEL_INIT_UIFRAME;
        STEP_UI_EVENT_KERNEL_INIT_UICONTENT = e.EVENT_KERNEL_INIT_UICONTENT;
        STEP_UI_EVENT_KERNEL_INIT_TITLEBAR = e.EVENT_KERNEL_INIT_TITLEBAR;
        STEP_UI_EVENT_KERNEL_INIT_BOTTOM = e.EVENT_KERNEL_INIT_BOTTOM;
        STEP_UI_EVENT_KERNEL_INIT_FINAL = e.EVENT_KERNEL_INIT_FINAL;
        int i3 = e.EVENT_END;
        STEP_UI_EVENT_END = i3;
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        STEP_X5_INIT = i16;
        int i18 = i17 + 1;
        STEP_X5_INIT_STRATEGY = i17;
        int i19 = i18 + 1;
        STEP_UA_INIT = i18;
        int i26 = i19 + 1;
        STEP_SET_TBS_USER_DATA = i19;
        int i27 = i26 + 1;
        STEP_HTML_SESSION_INIT = i26;
        int i28 = i27 + 1;
        STEP_CDN_CACHE_CONFIG_PARSE = i27;
        int i29 = i28 + 1;
        STEP_PROXY_CONFIG_PARSE = i28;
        int i36 = i29 + 1;
        STEP_TITLESTYLE_PARSE = i29;
        int i37 = i36 + 1;
        STEP_VIP_WEBREPORTLOG = i36;
        int i38 = i37 + 1;
        STEP_PREINIT_PLUGINS = i37;
        int i39 = i38 + 1;
        STEP_TASKS_ACTIVITY_CREATE = i38;
        int i46 = i39 + 1;
        STEP_PRECREATE_ENGINE = i39;
        stepCounter = i46 + 1;
        STEP_UI_PRECREATE_WEBVIEW = i46;
        sStepMap = new SparseArray<>(stepCounter);
        if (i3 >= 0) {
            int i47 = 0;
            while (true) {
                sStepMap.put(i47, BrowserUIObserverStep.class);
                if (i47 == i3) {
                    break;
                } else {
                    i47++;
                }
            }
        }
        SparseArray<Class<? extends BrowserStep>> sparseArray = sStepMap;
        int i48 = STEP_X5_INIT;
        sparseArray.put(i48, InitX5Step.class);
        SparseArray<Class<? extends BrowserStep>> sparseArray2 = sStepMap;
        int i49 = STEP_X5_INIT_STRATEGY;
        sparseArray2.put(i49, InitX5StrategyStep.class);
        SparseArray<Class<? extends BrowserStep>> sparseArray3 = sStepMap;
        int i56 = STEP_UA_INIT;
        sparseArray3.put(i56, UAStep.class);
        SparseArray<Class<? extends BrowserStep>> sparseArray4 = sStepMap;
        int i57 = STEP_SET_TBS_USER_DATA;
        sparseArray4.put(i57, SetTbsUserDataStep.class);
        SparseArray<Class<? extends BrowserStep>> sparseArray5 = sStepMap;
        int i58 = STEP_HTML_SESSION_INIT;
        sparseArray5.put(i58, InitHtmlSessionStep.class);
        SparseArray<Class<? extends BrowserStep>> sparseArray6 = sStepMap;
        int i59 = STEP_UI_PRECREATE_WEBVIEW;
        sparseArray6.put(i59, WebViewPreCreateStep.class);
        SparseArray<Class<? extends BrowserStep>> sparseArray7 = sStepMap;
        int i65 = STEP_CDN_CACHE_CONFIG_PARSE;
        sparseArray7.put(i65, CdnCacheConfigParseStep.class);
        SparseArray<Class<? extends BrowserStep>> sparseArray8 = sStepMap;
        int i66 = STEP_PROXY_CONFIG_PARSE;
        sparseArray8.put(i66, ProxyConfigParseStep.class);
        SparseArray<Class<? extends BrowserStep>> sparseArray9 = sStepMap;
        int i67 = STEP_VIP_WEBREPORTLOG;
        sparseArray9.put(i67, VipWebReportLogStep.class);
        SparseArray<Class<? extends BrowserStep>> sparseArray10 = sStepMap;
        int i68 = STEP_TASKS_ACTIVITY_CREATE;
        sparseArray10.put(i68, OnActivityCreateTasksStep.class);
        SparseArray<Class<? extends BrowserStep>> sparseArray11 = sStepMap;
        int i69 = STEP_PRECREATE_ENGINE;
        sparseArray11.put(i69, PreCreateEngineStep.class);
        SparseArray<Class<? extends BrowserStep>> sparseArray12 = sStepMap;
        int i75 = STEP_PREINIT_PLUGINS;
        sparseArray12.put(i75, PreInitPluginCheckerStep.class);
        a.Companion companion = com.tencent.mobileqq.app.automator.a.INSTANCE;
        STEPS_X5ENV_INIT = companion.a(companion.b(Integer.valueOf(i48), Integer.valueOf(i75), Integer.valueOf(i69), Integer.valueOf(i57)));
        STEPS_BROWSER_PRELOAD = companion.a(companion.b(Integer.valueOf(i59), Integer.valueOf(i69), Integer.valueOf(i75), Integer.valueOf(i56), Integer.valueOf(i65), Integer.valueOf(i66), Integer.valueOf(i67)));
        STEPS_STARTUP = companion.a(Integer.valueOf(STEP_UI_EVENT_ACTIVITY_CREATE), companion.b(Integer.valueOf(i58), Integer.valueOf(i69), Integer.valueOf(i68)), Integer.valueOf(STEP_UI_EVENT_KERNEL_CREATE), Integer.valueOf(STEP_UI_EVENT_KERNEL_LOAD_URL), Integer.valueOf(i49));
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.tencent.mobileqq.app.automator.AsyncStep, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.tencent.mobileqq.webview.swift.startup.step.BrowserStep] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // com.tencent.mobileqq.app.automator.d.a
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AsyncStep<?> a(int stepId) {
        BrowserStep browserStep;
        AsyncStep<?> asyncStep;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AsyncStep) iPatchRedirector.redirect((short) 7, (Object) this, stepId);
        }
        Class<? extends BrowserStep> cls = sStepMap.get(stepId);
        Intrinsics.checkNotNullExpressionValue(cls, "sStepMap[stepId]");
        Class<? extends BrowserStep> cls2 = cls;
        String str = null;
        try {
            if (f.class.isAssignableFrom(cls2)) {
                BrowserStep newInstance = cls2.getDeclaredConstructor(Integer.TYPE).newInstance(Integer.valueOf(stepId));
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.mobileqq.webview.swift.startup.step.BrowserStep");
                browserStep = newInstance;
                try {
                    e.f314664a.addObserver((f) browserStep);
                    browserStep = browserStep;
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("Automator_Browser.StepFactory", 1, e, new Object[0]);
                    asyncStep = browserStep;
                    if (asyncStep != null) {
                    }
                    QLog.d("Automator_Browser.StepFactory", 1, "createSingleStep: " + stepId + " " + str);
                    return asyncStep;
                }
            } else if (BrowserUIStep.class.isAssignableFrom(cls2)) {
                BrowserStep newInstance2 = cls2.getDeclaredConstructor(Handler.class).newInstance(b());
                Intrinsics.checkNotNull(newInstance2, "null cannot be cast to non-null type com.tencent.mobileqq.webview.swift.startup.step.BrowserStep");
                browserStep = newInstance2;
            } else {
                BrowserStep newInstance3 = cls2.newInstance();
                Intrinsics.checkNotNull(newInstance3, "null cannot be cast to non-null type com.tencent.mobileqq.webview.swift.startup.step.BrowserStep");
                browserStep = newInstance3;
            }
            browserStep.mName = browserStep.getClass().getSimpleName();
            asyncStep = browserStep;
        } catch (Exception e17) {
            e = e17;
            browserStep = 0;
        }
        if (asyncStep != null) {
            str = asyncStep.mName;
        }
        QLog.d("Automator_Browser.StepFactory", 1, "createSingleStep: " + stepId + " " + str);
        return asyncStep;
    }

    @NotNull
    public final Handler b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Handler) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (uiHandler == null) {
            uiHandler = new Handler(Looper.getMainLooper());
        }
        Handler handler = uiHandler;
        Intrinsics.checkNotNull(handler, "null cannot be cast to non-null type android.os.Handler");
        return handler;
    }
}
