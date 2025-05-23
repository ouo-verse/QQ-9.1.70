package com.tencent.mobileqq.settingme;

import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/settingme/a;", "Lcom/tencent/mobileqq/qui/immersive/color/a;", "Landroid/view/View;", "view", "", "canHandle", "Lcom/tencent/mobileqq/qui/immersive/color/IColorFetcher$Area;", GdtGetUserInfoHandler.KEY_AREA, "Landroid/util/Pair;", "", "getColor", "Landroid/graphics/drawable/Drawable;", "drawable", "<init>", "()V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a extends com.tencent.mobileqq.qui.immersive.color.a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return false;
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.a, com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    @NotNull
    public Pair<Boolean, Integer> getColor(@NotNull View view, @NotNull IColorFetcher.Area area) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) area);
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(area, "area");
        Pair<Boolean, Integer> color = getColor(((QQSettingMeBackgroundView) view).getDrawable(), area);
        Intrinsics.checkNotNullExpressionValue(color, "getColor((view as QQSett\u2026oundView).drawable, area)");
        return color;
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(view, "view");
        return (view instanceof QQSettingMeBackgroundView) && ((QQSettingMeBackgroundView) view).getDrawable() != null;
    }
}
