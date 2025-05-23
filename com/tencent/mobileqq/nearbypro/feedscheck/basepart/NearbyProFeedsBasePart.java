package com.tencent.mobileqq.nearbypro.feedscheck.basepart;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/NearbyProFeedsBasePart;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/g;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/g;", "feedsViewModel", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class NearbyProFeedsBasePart extends com.tencent.mobileqq.nearbypro.part.e {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedsViewModel;

    public NearbyProFeedsBasePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<g>() { // from class: com.tencent.mobileqq.nearbypro.feedscheck.basepart.NearbyProFeedsBasePart$feedsViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final g invoke() {
                return (g) NearbyProFeedsBasePart.this.getViewModel(g.class);
            }
        });
        this.feedsViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final g E9() {
        return (g) this.feedsViewModel.getValue();
    }
}
