package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nJ\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\nR\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b\u0015\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/app/utils/i;", "", "Landroid/content/Context;", "context", "", "fontScale", "", "f", "b", "newFontScale", "", "e", "isCallback", "a", "d", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "g", "forceUpdate", "i", UserInfo.SEX_FEMALE, "_systemFontScale", "c", "sPreviousSystemFontScale", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getSizeChangeCallbackRunnable", "()Lkotlin/jvm/functions/Function1;", tl.h.F, "(Lkotlin/jvm/functions/Function1;)V", "sizeChangeCallbackRunnable", "", "Ljava/lang/String;", "()Ljava/lang/String;", "setPropertiesContent", "(Ljava/lang/String;)V", "propertiesContent", "<init>", "()V", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f196664a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static float _systemFontScale;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static float sPreviousSystemFontScale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function1<? super Context, Unit> sizeChangeCallbackRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String propertiesContent;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37351);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f196664a = new i();
        sPreviousSystemFontScale = -1.0f;
        propertiesContent = "";
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float b(Context context) {
        boolean z16;
        float parseFloat;
        boolean z17 = false;
        if (sPreviousSystemFontScale == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String preValStr = PropertiesUtils.read(context, PropertiesUtils.KEY_PREVIOUS_SYS_SCALE, "");
            if (!TextUtils.isEmpty(preValStr)) {
                try {
                    Intrinsics.checkNotNullExpressionValue(preValStr, "preValStr");
                    parseFloat = Float.parseFloat(preValStr);
                } catch (NumberFormatException unused) {
                }
                if (parseFloat == -1.0f) {
                    z17 = true;
                }
                if (z17) {
                    parseFloat = context.getResources().getConfiguration().fontScale;
                    f(context, parseFloat);
                    QLog.d("FontSettingHelper", 1, "[getPreviousSystemFontScale] not set before, use current font scale.");
                    propertiesContent = PropertiesUtils.readPropertiesContent(context);
                }
                QLog.d("FontSettingHelper", 1, "[getPreviousSystemFontScale] previous system font scale: " + parseFloat);
                sPreviousSystemFontScale = parseFloat;
            }
            parseFloat = -1.0f;
            if (parseFloat == -1.0f) {
            }
            if (z17) {
            }
            QLog.d("FontSettingHelper", 1, "[getPreviousSystemFontScale] previous system font scale: " + parseFloat);
            sPreviousSystemFontScale = parseFloat;
        }
        return sPreviousSystemFontScale;
    }

    private final boolean e(Context context, float newFontScale) {
        boolean z16;
        float b16 = b(context);
        if (QLog.isDevelopLevel()) {
            QLog.d("FontSettingHelper", 4, "[isSystemFontScaleChanged] currentFontScale: " + newFontScale + ", previousFontScale: " + b16);
        }
        if (b16 == newFontScale) {
            z16 = true;
        } else {
            z16 = false;
        }
        return !z16;
    }

    private final void f(Context context, float fontScale) {
        if (QLog.isDevelopLevel()) {
            QLog.d("FontSettingHelper", 4, "[savePreviousSystemFontScale] fontScale=" + fontScale);
        }
        sPreviousSystemFontScale = fontScale;
        try {
            PropertiesUtils.save(context, PropertiesUtils.KEY_PREVIOUS_SYS_SCALE, String.valueOf(fontScale));
        } catch (Throwable th5) {
            QLog.e("FontSettingHelper", 1, "savePreviousSystemFontScale, e:", th5);
        }
    }

    public final boolean a(@NotNull Context context, boolean isCallback) {
        boolean z16;
        Function1<? super Context, Unit> function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, context, Boolean.valueOf(isCallback))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        float f16 = _systemFontScale;
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("FontSettingHelper", 1, "[checkConfigurationChangeAndUpdate] system font size not init");
            return false;
        }
        if (!e(context, f16)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("FontSettingHelper", 4, "[checkConfigurationChangeAndUpdate] system font size not changed");
            }
            return false;
        }
        g(context, true);
        f(context, f16);
        if (isCallback && (function1 = sizeChangeCallbackRunnable) != null) {
            function1.invoke(context);
        }
        QLog.d("FontSettingHelper", 1, "[checkConfigurationChangeAndUpdate] system font size changed, update qq font. fontScale=" + f16);
        return true;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return propertiesContent;
    }

    public final boolean d(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return Intrinsics.areEqual("1", PropertiesUtils.read(context, PropertiesUtils.KEY_SHOW_FONT_CHANGED_TIP, ""));
    }

    public final void g(@NotNull Context context, boolean r75) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, Boolean.valueOf(r75));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (r75) {
            str = "1";
        } else {
            str = "0";
        }
        try {
            PropertiesUtils.save(context, PropertiesUtils.KEY_SHOW_FONT_CHANGED_TIP, str);
        } catch (Throwable th5) {
            QLog.e("FontSettingHelper", 1, "setShowFontChangeTipSwitch, e:", th5);
        }
    }

    public final void h(@Nullable Function1<? super Context, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function1);
        } else {
            sizeChangeCallbackRunnable = function1;
        }
    }

    public final void i(float newFontScale, boolean forceUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(newFontScale), Boolean.valueOf(forceUpdate));
        } else if ((_systemFontScale <= 0.0f || forceUpdate) && newFontScale > 0.0f) {
            _systemFontScale = newFontScale;
        }
    }
}
