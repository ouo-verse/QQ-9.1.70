package com.tencent.mobileqq.ecshop.utils;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007JB\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/ecshop/utils/f;", "", "", "urlStr", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "Landroid/os/Bundle;", "args", "Lcom/tencent/image/URLDrawable;", "b", "path", "failedDrawable", "", "picTag", "bundle", "a", "Landroid/view/View;", "layoutContent", "", "bgRadius", "", "d", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f203956a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/ecshop/utils/f$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f203957a;

        a(float f16) {
            this.f203957a = f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16));
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f203957a);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29289);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203956a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final URLDrawable a(String path, String urlStr, Drawable loadingDrawable, Drawable failedDrawable, int[] picTag, Bundle bundle) {
        try {
            if (TextUtils.isEmpty(path)) {
                path = com.tencent.mobileqq.qwallet.preload.a.f(urlStr);
            }
            boolean z16 = bundle.getBoolean(VasApngUtil.KEY_PLAY_APNG, true);
            int i3 = bundle.getInt("key_loop");
            bundle.putIntArray("key_tagId_arr", picTag);
            bundle.putString("key_name", urlStr);
            if (!bundle.containsKey(ApngImage.KEY_USE_FILE_LOOP)) {
                bundle.putBoolean(ApngImage.KEY_USE_FILE_LOOP, true);
            }
            bundle.putBoolean("key_double_bitmap", bundle.getBoolean("key_double_bitmap", true));
            URL url = new URL("vasapngdownloader", path, urlStr);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mUseApngImage = z16;
            obtain.mUseMemoryCache = bundle.getBoolean("key_use_cache", true);
            if (i3 > 0) {
                obtain.mUseMemoryCache = false;
            }
            obtain.mMemoryCacheKeySuffix = z16 + "," + i3;
            obtain.mLoadingDrawable = loadingDrawable;
            obtain.mFailedDrawable = failedDrawable;
            obtain.mExtraInfo = bundle;
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            if (QLog.isColorLevel()) {
                QLog.d("QQShopPicUtil", 2, "getApngDrawable ApngImage ok path:" + path + ", urlStr=" + urlStr);
            }
            return drawable;
        } catch (Throwable unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final URLDrawable b(@NotNull String urlStr, @Nullable Drawable loadingDrawable, @NotNull Bundle args) {
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(args, "args");
        URLDrawable a16 = f203956a.a(null, urlStr, loadingDrawable, loadingDrawable, new int[]{40}, args);
        ApngImage.playByTag(40);
        return a16;
    }

    public static /* synthetic */ URLDrawable c(String str, Drawable drawable, Bundle bundle, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        if ((i3 & 4) != 0) {
            bundle = new Bundle();
        }
        return b(str, drawable, bundle);
    }

    @JvmStatic
    public static final void d(@NotNull View layoutContent, float bgRadius) {
        Intrinsics.checkNotNullParameter(layoutContent, "layoutContent");
        layoutContent.setOutlineProvider(new a(bgRadius));
        layoutContent.setClipToOutline(true);
    }
}
