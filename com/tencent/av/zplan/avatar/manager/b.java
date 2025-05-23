package com.tencent.av.zplan.avatar.manager;

import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/av/zplan/avatar/manager/b;", "", "Lcom/airbnb/lottie/LottieComposition;", "a", "Lcom/airbnb/lottie/LottieComposition;", "()Lcom/airbnb/lottie/LottieComposition;", "composition", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "imageAssets", "<init>", "(Lcom/airbnb/lottie/LottieComposition;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LottieComposition composition;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String imageAssets;

    public b(@NotNull LottieComposition composition, @NotNull String imageAssets) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        Intrinsics.checkNotNullParameter(imageAssets, "imageAssets");
        this.composition = composition;
        this.imageAssets = imageAssets;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final LottieComposition getComposition() {
        return this.composition;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getImageAssets() {
        return this.imageAssets;
    }
}
