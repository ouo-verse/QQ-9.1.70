package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/widget/QWalletAvatarLoader;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "Lcom/tencent/mobileqq/armap/f;", "a", "d", "Landroidx/lifecycle/LifecycleOwner;", "b", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "e", "Lcom/tencent/mobileqq/armap/f;", "avatarLoader", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "FaceDrawable", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QWalletAvatarLoader implements LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.armap.f avatarLoader;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B+\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0017\u0010\u0018\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/widget/QWalletAvatarLoader$FaceDrawable;", "Lcom/tencent/mobileqq/util/AsynLoadDrawable;", "Lcom/tencent/mobileqq/armap/e;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "b", "Landroid/graphics/drawable/Drawable;", "getDefaultDrawable", "", "uin", "headPath", "head", tl.h.F, "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "d", "Ljava/lang/String;", "getTargetUin", "()Ljava/lang/String;", IProfileProtocolConst.PARAM_TARGET_UIN, "Lcom/tencent/mobileqq/widget/QWalletAvatarLoader;", "e", "Lcom/tencent/mobileqq/widget/QWalletAvatarLoader;", "avatarLoader", "loadingDrawable", "failureDrawable", "<init>", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcom/tencent/mobileqq/widget/QWalletAvatarLoader;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class FaceDrawable extends AsynLoadDrawable implements com.tencent.mobileqq.armap.e, LifecycleEventObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String targetUin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final QWalletAvatarLoader avatarLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FaceDrawable(@NotNull String targetUin, @Nullable Drawable drawable, @Nullable Drawable drawable2, @NotNull QWalletAvatarLoader avatarLoader) {
            super(drawable, drawable2);
            Intrinsics.checkNotNullParameter(targetUin, "targetUin");
            Intrinsics.checkNotNullParameter(avatarLoader, "avatarLoader");
            this.targetUin = targetUin;
            this.avatarLoader = avatarLoader;
            avatarLoader.getLifecycleOwner().getLifecycle().addObserver(this);
            avatarLoader.getAvatarLoader().a(this);
            Bitmap retBitmap = avatarLoader.getAvatarLoader().d(targetUin, true, BaseImageUtil.getDefaultFaceBitmap());
            if (Intrinsics.areEqual(retBitmap, BaseImageUtil.getDefaultFaceBitmap())) {
                this.mCurState = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(retBitmap, "retBitmap");
                b(retBitmap);
            }
        }

        private final void b(Bitmap bitmap) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(BaseApplication.getContext().getResources(), bitmap);
            this.mLoadedDrawable = bitmapDrawable;
            bitmapDrawable.setVisible(isVisible(), true);
            this.mLoadedDrawable.setBounds(getBounds());
            this.mCurState = 1;
            invalidateSelf();
        }

        @Override // com.tencent.mobileqq.util.AsynLoadDrawable
        @Nullable
        public Drawable getDefaultDrawable() {
            return this.mLoadingDrawable;
        }

        @Override // com.tencent.mobileqq.armap.e
        public void h(@Nullable String uin, @Nullable String headPath, @Nullable Bitmap head) {
            if (!Intrinsics.areEqual(this.targetUin, uin)) {
                return;
            }
            if (head != null) {
                b(head);
            } else {
                this.mCurState = 2;
            }
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.avatarLoader.getAvatarLoader().f(this);
            }
        }
    }

    public QWalletAvatarLoader(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
        com.tencent.mobileqq.armap.f nonMainAppHeadLoader = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(BaseApplication.getContext(), 1);
        Intrinsics.checkNotNullExpressionValue(nonMainAppHeadLoader, "api(IQQNonMainProcAvatar\u2026eadType.QQHEAD_TYPE_USER)");
        this.avatarLoader = nonMainAppHeadLoader;
        lifecycleOwner.getLifecycle().addObserver(this);
        this.avatarLoader.init();
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final com.tencent.mobileqq.armap.f getAvatarLoader() {
        return this.avatarLoader;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.avatarLoader.destroy();
        }
    }
}
