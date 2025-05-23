package com.tencent.mobileqq.immersive.colorfetcher;

import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qui.immersive.c;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/immersive/colorfetcher/a;", "Lcom/tencent/mobileqq/qui/immersive/color/IColorFetcher;", "Landroid/view/View;", "view", "", "canHandle", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/tencent/mobileqq/qui/immersive/color/IColorFetcher$Area;", GdtGetUserInfoHandler.KEY_AREA, "Landroid/util/Pair;", "", "getColor", "<init>", "()V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements IColorFetcher {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable)).booleanValue();
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    @NotNull
    public Pair<Boolean, Integer> getColor(@NotNull View view, @Nullable IColorFetcher.Area area) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) area);
        }
        Intrinsics.checkNotNullParameter(view, "view");
        ScanningLightView scanningLightView = (ScanningLightView) view;
        return new Pair<>(Boolean.TRUE, Integer.valueOf(c.d(scanningLightView.r(), scanningLightView.getCurSkeletonColor())));
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? view instanceof ScanningLightView : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    @NotNull
    public Pair<Boolean, Integer> getColor(@Nullable Drawable drawable, @Nullable IColorFetcher.Area area) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? new Pair<>(Boolean.FALSE, 0) : (Pair) iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable, (Object) area);
    }
}
