package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import android.graphics.Color;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.ay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/n;", "", "Landroid/widget/ImageView;", "imageView", "", "d", "", "a", "", "c", "b", "Ljava/lang/String;", "name", "color", "iconUrl", "I", WidgetCacheConstellationData.NUM, "e", "total", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String color;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String iconUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int num;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int total;

    public n(@NotNull String name, @NotNull String color, @NotNull String iconUrl, int i3, int i16) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, name, color, iconUrl, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.name = name;
        this.color = color;
        this.iconUrl = iconUrl;
        this.num = i3;
        this.total = i16;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.name;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        try {
            return Color.parseColor(this.color);
        } catch (Exception unused) {
            return SupportMenu.CATEGORY_MASK;
        }
    }

    public final int c() {
        int roundToInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        int i3 = this.total;
        if (i3 != 0) {
            roundToInt = MathKt__MathJVMKt.roundToInt((this.num * 100) / i3);
            return roundToInt;
        }
        return 0;
    }

    public final void d(@NotNull ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageView);
        } else {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            ay.f302095a.a(this.iconUrl, imageView);
        }
    }
}
