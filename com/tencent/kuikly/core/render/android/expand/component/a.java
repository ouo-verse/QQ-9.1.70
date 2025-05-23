package com.tencent.kuikly.core.render.android.expand.component;

import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002M\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J#\u0010\f\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096\u0002R\"\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/a;", "Lkotlin/Function3;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "errorCode", "", "errorMsg", "", "Lcom/tencent/kuikly/core/render/android/expand/component/ResultDrawableCallback;", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRImageView;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "imageViewWeakRef", "e", "Ljava/lang/String;", "tempSrc", "imageView", "<init>", "(Lcom/tencent/kuikly/core/render/android/expand/component/KRImageView;Ljava/lang/String;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a implements Function3<Drawable, Integer, String, Unit> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<KRImageView> imageViewWeakRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String tempSrc;

    public a(@NotNull KRImageView imageView, @NotNull String tempSrc) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(tempSrc, "tempSrc");
        this.tempSrc = tempSrc;
        this.imageViewWeakRef = new WeakReference<>(imageView);
    }

    public void a(@Nullable Drawable drawable, int errorCode, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        KRImageView kRImageView = this.imageViewWeakRef.get();
        if (kRImageView != null) {
            kRImageView.D(drawable, this.tempSrc, errorCode, errorMsg);
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable, Integer num, String str) {
        a(drawable, num.intValue(), str);
        return Unit.INSTANCE;
    }
}
