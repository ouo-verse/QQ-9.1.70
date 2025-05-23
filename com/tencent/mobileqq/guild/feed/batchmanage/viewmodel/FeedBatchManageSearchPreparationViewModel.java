package com.tencent.mobileqq.guild.feed.batchmanage.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R)\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/FeedBatchManageSearchPreparationViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Lkotlin/Lazy;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "searchState", "", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L1", "searchKeyword", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBatchManageSearchPreparationViewModel extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchKeyword;

    public FeedBatchManageSearchPreparationViewModel() {
        Lazy lazy;
        Lazy lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MutableLiveData<Integer>>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.FeedBatchManageSearchPreparationViewModel$searchState$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MutableLiveData<Integer> invoke() {
                return new MutableLiveData<>();
            }
        });
        this.searchState = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MutableLiveData<String>>() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.FeedBatchManageSearchPreparationViewModel$searchKeyword$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MutableLiveData<String> invoke() {
                return new MutableLiveData<>("");
            }
        });
        this.searchKeyword = lazy2;
    }

    @NotNull
    public final MutableLiveData<String> L1() {
        return (MutableLiveData) this.searchKeyword.getValue();
    }

    @NotNull
    public final MutableLiveData<Integer> M1() {
        return (MutableLiveData) this.searchState.getValue();
    }
}
