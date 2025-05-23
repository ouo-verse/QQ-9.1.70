package com.tencent.mobileqq.qui.bridge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.ui.api.IQQImageDrawableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qui/bridge/m;", "Ltd0/m;", "", "url", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/content/Context;", "context", "b", "uin", "a", "Landroid/graphics/Bitmap;", "getDefaultFaceBitmap", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class m implements td0.m {
    static IPatchRedirector $redirector_;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // td0.m
    @Nullable
    public Drawable a(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ((IQQImageDrawableApi) QRoute.api(IQQImageDrawableApi.class)).getQQFaceDrawable(uin);
    }

    @Override // td0.m
    @Nullable
    public Drawable b(@NotNull Context context, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) url);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        return ((IQQImageDrawableApi) QRoute.api(IQQImageDrawableApi.class)).getApngUrlDrawable(context, url);
    }

    @Override // td0.m
    @NotNull
    public Drawable c(@Nullable String url) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new GradientDrawable();
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = null;
        obtain.mLoadingDrawable = null;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, option)");
        return drawable;
    }

    @Override // td0.m
    @NotNull
    public Bitmap getDefaultFaceBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Bitmap defaultFaceBitmap = ((IQQImageDrawableApi) QRoute.api(IQQImageDrawableApi.class)).getDefaultFaceBitmap();
        Intrinsics.checkNotNullExpressionValue(defaultFaceBitmap, "api(IQQImageDrawableApi:\u2026s.java).defaultFaceBitmap");
        return defaultFaceBitmap;
    }
}
