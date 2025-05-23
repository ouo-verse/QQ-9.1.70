package com.tencent.qqnt.aio.utils;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/aio/utils/d;", "", "Landroid/graphics/drawable/Drawable;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f352294a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/aio/utils/d$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@NotNull URLDrawable urlDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) urlDrawable);
            } else {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                QLog.i("AIOMsgLoadingUtils", 1, "URLDrawable.onLoadCanceled:");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@NotNull URLDrawable urlDrawable, @NotNull Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) urlDrawable, (Object) throwable);
                return;
            }
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            QLog.i("AIOMsgLoadingUtils", 1, "URLDrawable.onLoadFialed:");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@NotNull URLDrawable urlDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) urlDrawable, i3);
            } else {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                QLog.i("AIOMsgLoadingUtils", 1, "URLDrawable.onLoadProgressed:");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable urlDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) urlDrawable);
                return;
            }
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            QLog.i("AIOMsgLoadingUtils", 1, "URLDrawable.onLoadSuccessed:");
            Drawable current = urlDrawable.getCurrent();
            Intrinsics.checkNotNullExpressionValue(current, "urlDrawable.current");
            if (current instanceof ApngDrawable) {
                try {
                    ((ApngDrawable) current).resume();
                } catch (Exception e16) {
                    QLog.i("AIOMsgLoadingUtils", 1, "[getLoadingDrawable]: " + e16);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65619);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f352294a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final Drawable a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            URL url = new URL("assets_img", "host_image", "loading/aio_msg_loading.png");
            if (QLog.isColorLevel()) {
                QLog.d("AIOMsgLoadingUtils", 2, "getDrawable url:" + url);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mUseApngImage = true;
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            drawable.setURLDrawableListener(new a());
            return drawable;
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOMsgLoadingUtils", 2, "getDrawable ,", e16);
                return null;
            }
            return null;
        }
    }
}
