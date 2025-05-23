package com.tencent.storage.view;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/storage/view/c;", "", "", WidgetCacheConstellationData.NUM, "", "a", "", "dp", "Landroid/content/res/Resources;", "res", "c", "", "size", "Landroid/util/Pair;", "d", "target", "b", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "e", "<init>", "()V", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f373802a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f373802a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a(int num) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < num; i3++) {
            sb5.append((char) 0);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @NotNull
    public final String b(@NotNull String target) {
        int indexOf$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) target, ".", 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            return a(target.length());
        }
        String str = a(indexOf$default) + "." + a((target.length() - 1) - indexOf$default);
        Intrinsics.checkNotNullExpressionValue(str, "{\n            StringBuil\u2026    .toString()\n        }");
        return str;
    }

    public final float c(float dp5, @NotNull Resources res) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(dp5), res)).floatValue();
        }
        Intrinsics.checkNotNullParameter(res, "res");
        if (dp5 != 0.0f) {
            z16 = false;
        }
        if (z16) {
            return 0.0f;
        }
        return (dp5 * res.getDisplayMetrics().density) + 0.5f;
    }

    @NotNull
    public final Pair<String, String> d(long size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, size);
        }
        float baseNumber = FileUtils.getBaseNumber();
        double d16 = size;
        float f16 = baseNumber * baseNumber;
        if (d16 < f16 * 0.05d) {
            return new Pair<>("0", "MB");
        }
        double baseNumberThreshold = FileUtils.getBaseNumberThreshold();
        if (((float) size) < f16) {
            DecimalFormat decimalFormat = new DecimalFormat("0.#");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            return new Pair<>(decimalFormat.format((r12 / baseNumber) / baseNumber), "MB");
        }
        if (d16 < f16 * baseNumber * baseNumberThreshold) {
            DecimalFormat decimalFormat2 = new DecimalFormat("0");
            decimalFormat2.setRoundingMode(RoundingMode.DOWN);
            return new Pair<>(decimalFormat2.format((r12 / baseNumber) / baseNumber), "MB");
        }
        DecimalFormat decimalFormat3 = new DecimalFormat("0.#");
        decimalFormat3.setRoundingMode(RoundingMode.HALF_UP);
        return new Pair<>(decimalFormat3.format(((r12 / baseNumber) / baseNumber) / baseNumber), "GB");
    }

    public final boolean e(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        QLog.d("Utils", 1, "isSmallDimen width: " + i3 + ", height: " + i16);
        if (i3 < 856 || i16 < 1852) {
            return true;
        }
        return false;
    }
}
