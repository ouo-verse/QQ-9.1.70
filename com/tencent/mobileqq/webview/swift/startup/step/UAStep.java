package com.tencent.mobileqq.webview.swift.startup.step;

import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.l;
import com.tencent.mobileqq.webview.swift.injector.r;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0015\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/UAStep;", "Lcom/tencent/mobileqq/webview/swift/startup/step/BrowserStep;", "", "doStep", "T", "g", "()Ljava/lang/Object;", "<init>", "()V", "d", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class UAStep extends BrowserStep {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public static volatile String f314696e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0016\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/webview/swift/startup/step/UAStep$a;", "", "", "a", "ua", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.swift.startup.step.UAStep$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(14:8|(1:10)|11|(1:13)(1:34)|14|15|16|(2:18|(6:20|21|22|(1:24)|26|27))|32|21|22|(0)|26|27) */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x01b7, code lost:
        
            r1 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x01b8, code lost:
        
            r5 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x01bb, code lost:
        
            com.tencent.qphone.base.util.QLog.e("SwiftWebViewUtils", 1, "getUA ", r1);
            r9 = r5;
         */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0190 A[Catch: all -> 0x01b7, TRY_LEAVE, TryCatch #0 {all -> 0x01b7, blocks: (B:22:0x018a, B:24:0x0190), top: B:21:0x018a }] */
        @JvmStatic
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String a() {
            String str;
            int i3;
            String configuration;
            boolean contains$default;
            boolean contains$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder("%s ");
            String qua = ((l) aa.k(l.class)).getQUA();
            if (qua != null) {
                sb5.append(qua);
            }
            sb5.append("%s");
            sb5.append(" ");
            sb5.append("QQ/");
            sb5.append(((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).getSubVersion());
            sb5.append(".");
            sb5.append(((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).f());
            sb5.append(i.j());
            sb5.append("%s");
            sb5.append(" ");
            sb5.append("AppId/");
            sb5.append(((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).getAppId());
            sb5.append(" ");
            sb5.append("Pixel/");
            sb5.append(BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels);
            sb5.append(" ");
            sb5.append("StatusBarHeight/");
            sb5.append(ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
            sb5.append(" ");
            sb5.append("SimpleUISwitch/");
            sb5.append(SimpleUIUtil.isNowSimpleMode() ? 1 : 0);
            String currentThemeId = ((r) aa.k(r.class)).getCurrentThemeId();
            sb5.append(" ");
            sb5.append("QQTheme/");
            if (currentThemeId == null) {
                str = "0";
            } else {
                str = currentThemeId;
            }
            sb5.append(str);
            QLog.d("SwiftWebViewUtils", 1, "getWebViewUAForQQ themeId: " + currentThemeId);
            boolean studyModeSwitch = ((l) aa.k(l.class)).getStudyModeSwitch();
            sb5.append(" ");
            sb5.append("StudyMode/");
            sb5.append(studyModeSwitch ? 1 : 0);
            sb5.append(" ");
            sb5.append("CurrentMode/");
            sb5.append(SimpleUIUtil.getCurrentMode(studyModeSwitch));
            sb5.append(" ");
            sb5.append("CurrentFontScale/");
            sb5.append(FontSettingManager.getFontLevel() / 16.0f);
            sb5.append(" ");
            sb5.append("GlobalDensityScale/");
            sb5.append(GlobalDisplayMetricsManager.getScale());
            sb5.append(" ");
            sb5.append("AllowLandscape/");
            sb5.append(((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isAllowLandscape(BaseApplication.getContext()));
            boolean isNowElderMode = SimpleUIUtil.isNowElderMode();
            int i16 = 0;
            try {
                configuration = BaseApplication.getContext().getResources().getConfiguration().toString();
                Intrinsics.checkNotNullExpressionValue(configuration, "getContext().resources.configuration.toString()");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) configuration, (CharSequence) "hwMultiwindow-magic", false, 2, (Object) null);
            } catch (Throwable th5) {
                th = th5;
            }
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) configuration, (CharSequence) "hw-magic-windows", false, 2, (Object) null);
                if (!contains$default2) {
                    i3 = 0;
                    if (QLog.isColorLevel()) {
                        QLog.d("SwiftWebViewUtils", 2, "config:", configuration, " isInMagicWindow:", Integer.valueOf(i3), ", bElderMode:", Boolean.valueOf(isNowElderMode));
                    }
                    sb5.append(" ");
                    sb5.append("InMagicWin/");
                    sb5.append(i3);
                    sb5.append(((l) aa.k(l.class)).a());
                    String sb6 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
                    return sb6;
                }
            }
            i3 = 1;
            if (QLog.isColorLevel()) {
            }
            sb5.append(" ");
            sb5.append("InMagicWin/");
            sb5.append(i3);
            sb5.append(((l) aa.k(l.class)).a());
            String sb62 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb62, "sb.toString()");
            return sb62;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46033);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
            f314696e = "";
        }
    }

    public UAStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (f314696e.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f314696e = INSTANCE.a();
        }
        return super.doStep();
    }

    @Override // com.tencent.mobileqq.webview.swift.startup.step.BrowserStep
    public <T> T g() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        CharSequence charSequence = (T) f314696e;
        if (charSequence.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            charSequence = (T) INSTANCE.a();
        }
        f314696e = "";
        return (T) charSequence;
    }
}
