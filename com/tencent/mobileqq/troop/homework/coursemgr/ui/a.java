package com.tencent.mobileqq.troop.homework.coursemgr.ui;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/ui/a;", "", "", "courseName", "Landroid/graphics/drawable/Drawable;", "a", "", "b", "Ljava/util/Map;", "colorMap", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f296927a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String> colorMap;

    static {
        Map<String, String> mutableMapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f296927a = new a();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("\u6570\u5b66", "#3385FF"), TuplesKt.to("\u653f\u6cbb", "#B91E06"), TuplesKt.to("\u8bed\u6587", "#FF5967"), TuplesKt.to("\u82f1\u8bed", "#BC66FF"), TuplesKt.to("\u7269\u7406", "#15D173"), TuplesKt.to("\u751f\u7269", "#466365"), TuplesKt.to("\u5386\u53f2", "#FF8D40"), TuplesKt.to("\u5316\u5b66", "#FFB300"), TuplesKt.to("\u5730\u7406", "#6F3900"), TuplesKt.to("\u7f8e\u672f", "#8566FF"), TuplesKt.to("\u4e66\u6cd5", "#858585"), TuplesKt.to("\u97f3\u4e50", "#FF66B3"));
        colorMap = mutableMapOf;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Drawable a(@NotNull String courseName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) courseName);
        }
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        GradientDrawable gradientDrawable = new GradientDrawable();
        String str = colorMap.get(courseName);
        if (str == null) {
            str = "#0099FF";
        }
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ViewUtils.dip2px(4.0f));
        return gradientDrawable;
    }
}
