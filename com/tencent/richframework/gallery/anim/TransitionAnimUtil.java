package com.tencent.richframework.gallery.anim;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/gallery/anim/TransitionAnimUtil;", "", "Ljava/util/UUID;", "uuid", "Lcom/tencent/richframework/gallery/anim/TransitionAnimUtil$TransViewAndDrawable;", "getTransViewAndDrawable", "Ljava/util/concurrent/ConcurrentHashMap;", "sTransParam", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "TransViewAndDrawable", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class TransitionAnimUtil {

    @NotNull
    public static final TransitionAnimUtil INSTANCE = new TransitionAnimUtil();
    private static final ConcurrentHashMap<UUID, TransViewAndDrawable> sTransParam = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/richframework/gallery/anim/TransitionAnimUtil$TransViewAndDrawable;", "", "Landroid/graphics/drawable/Drawable;", "coverDrawable", "", "saveCoverDrawable", "Ljava/lang/ref/WeakReference;", "Landroid/widget/ImageView;", "mWrfImageView", "Ljava/lang/ref/WeakReference;", "getMWrfImageView", "()Ljava/lang/ref/WeakReference;", "setMWrfImageView", "(Ljava/lang/ref/WeakReference;)V", "mWrfDrawable", "getMWrfDrawable", "setMWrfDrawable", "getCoverDrawable", "()Landroid/graphics/drawable/Drawable;", "imageView", "getEnterImageView", "()Landroid/widget/ImageView;", "setEnterImageView", "(Landroid/widget/ImageView;)V", "enterImageView", "<init>", "()V", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class TransViewAndDrawable {

        @Nullable
        private WeakReference<Drawable> mWrfDrawable;

        @Nullable
        private WeakReference<ImageView> mWrfImageView;

        @Nullable
        public final Drawable getCoverDrawable() {
            WeakReference<Drawable> weakReference = this.mWrfDrawable;
            if (weakReference != null) {
                Intrinsics.checkNotNull(weakReference);
                return weakReference.get();
            }
            return null;
        }

        @Nullable
        public final ImageView getEnterImageView() {
            WeakReference<ImageView> weakReference = this.mWrfImageView;
            if (weakReference != null) {
                Intrinsics.checkNotNull(weakReference);
                return weakReference.get();
            }
            return null;
        }

        @Nullable
        public final WeakReference<ImageView> getMWrfImageView() {
            return this.mWrfImageView;
        }

        public final void saveCoverDrawable(@Nullable Drawable coverDrawable) {
            WeakReference<Drawable> weakReference;
            if (coverDrawable != null) {
                weakReference = new WeakReference<>(coverDrawable);
            } else {
                weakReference = null;
            }
            this.mWrfDrawable = weakReference;
        }

        public final void setEnterImageView(@Nullable ImageView imageView) {
            WeakReference<ImageView> weakReference;
            if (imageView != null) {
                weakReference = new WeakReference<>(imageView);
            } else {
                weakReference = null;
            }
            this.mWrfImageView = weakReference;
        }
    }

    TransitionAnimUtil() {
    }

    @NotNull
    public final synchronized TransViewAndDrawable getTransViewAndDrawable(@NotNull UUID uuid) {
        TransViewAndDrawable transViewAndDrawable;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        ConcurrentHashMap<UUID, TransViewAndDrawable> concurrentHashMap = sTransParam;
        transViewAndDrawable = concurrentHashMap.get(uuid);
        if (transViewAndDrawable == null) {
            transViewAndDrawable = new TransViewAndDrawable();
            concurrentHashMap.put(uuid, transViewAndDrawable);
        }
        return transViewAndDrawable;
    }
}
