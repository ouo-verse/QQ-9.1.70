package com.tencent.mobileqq.proavatar.drawable;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J*\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/proavatar/drawable/ProAvatarDrawableFactory;", "Lcom/tencent/qqnt/avatar/dynamic/drawable/a;", "", "path", "", "width", "height", "Landroid/graphics/drawable/Drawable;", "e", "d", "Landroid/os/Bundle;", "g", "type", "a", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ProAvatarDrawableFactory implements com.tencent.qqnt.avatar.dynamic.drawable.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f259560b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/proavatar/drawable/ProAvatarDrawableFactory$a;", "", "", "useDynamicDrawableSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "useDynamicDrawableSwitch", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.drawable.ProAvatarDrawableFactory$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) ProAvatarDrawableFactory.f259560b.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/proavatar/drawable/ProAvatarDrawableFactory$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable, (Object) cause);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable, progress);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            Drawable drawable2;
            ApngImage image;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
                return;
            }
            ApngDrawable apngDrawable = null;
            if (drawable != null) {
                drawable2 = drawable.getCurrDrawable();
            } else {
                drawable2 = null;
            }
            if (drawable2 instanceof ApngDrawable) {
                apngDrawable = (ApngDrawable) drawable2;
            }
            if (apngDrawable != null && (image = apngDrawable.getImage()) != null) {
                image.setSupportGlobalPasued(false);
            }
        }
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(ProAvatarDrawableFactory$Companion$useDynamicDrawableSwitch$2.INSTANCE);
        f259560b = lazy;
    }

    public ProAvatarDrawableFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Drawable d(String path, int width, int height) {
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mUseApngImage = true;
            obtain.mRequestWidth = width;
            obtain.mRequestHeight = height;
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            obtain.mExtraInfo = g();
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(path, obtain);
            fileDrawable.setURLDrawableListener(new b());
            return fileDrawable;
        } catch (Exception e16) {
            QLog.e("ProAvatarDrawableFactory", 1, "createApngDrawable error:", e16);
            return null;
        }
    }

    private final Drawable e(String path, final int width, final int height) {
        if (TextUtils.isEmpty(path)) {
            QLog.e("ProAvatarDrawableFactory", 1, "createDynamicDrawable path is empty ");
            return null;
        }
        return com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(path).g(new a.c() { // from class: com.tencent.mobileqq.proavatar.drawable.a
            @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
            public final void a(k kVar) {
                ProAvatarDrawableFactory.f(width, height, kVar);
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, int i16, k it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.H(false);
        it.y(-1);
        if (i3 > 0) {
            it.C(i3);
        }
        if (i16 > 0) {
            it.B(i16);
        }
        it.I(true);
        it.t(true);
    }

    private final Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_loop", -1);
        bundle.putBoolean(ApngImage.KEY_USE_FILE_LOOP, true);
        bundle.putBoolean("key_double_bitmap", true);
        bundle.putBoolean("key_draw_round", true);
        bundle.putBoolean("key_stop_on_first", true);
        bundle.putBoolean("key_once_clear", true);
        bundle.putString("key_name", "-face-");
        return bundle;
    }

    @Override // com.tencent.qqnt.avatar.dynamic.drawable.a
    @Nullable
    public Drawable a(@NotNull String type, @NotNull String path, int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, this, type, path, Integer.valueOf(width), Integer.valueOf(height));
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(path, "path");
        if (Intrinsics.areEqual(type, "apng")) {
            if (INSTANCE.b()) {
                return e(path, width, height);
            }
            return d(path, width, height);
        }
        return null;
    }
}
