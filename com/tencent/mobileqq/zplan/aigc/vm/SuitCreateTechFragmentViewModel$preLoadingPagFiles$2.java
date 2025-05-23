package com.tencent.mobileqq.zplan.aigc.vm;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.widget.pag.ZPlanPAGLoader;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel$preLoadingPagFiles$2", f = "SuitCreateTechFragmentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitCreateTechFragmentViewModel$preLoadingPagFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $loadingPagUrlList;
    final /* synthetic */ int $requestIndex;
    final /* synthetic */ List<String> $urlList;
    int label;
    final /* synthetic */ SuitCreateTechFragmentViewModel this$0;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel$preLoadingPagFiles$2$a", "Lvk3/a;", "", "url", "path", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements vk3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f330838a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SuitCreateTechFragmentViewModel f330839b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f330840c;

        a(List<String> list, SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel, int i3) {
            this.f330838a = list;
            this.f330839b = suitCreateTechFragmentViewModel;
            this.f330840c = i3;
        }

        @Override // vk3.a
        public void a(String url, String path) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(path, "path");
            if (TextUtils.isEmpty(url)) {
                return;
            }
            this.f330838a.remove(url);
            if (this.f330838a.isEmpty()) {
                ZPlanPAGLoader.f369875a.k(this);
                QLog.i("SuitCreateTechFragmentViewModel", 1, "preLoadingPagFiles all download success");
                List<Boolean> j26 = this.f330839b.j2();
                int i3 = this.f330840c;
                Boolean bool = Boolean.TRUE;
                j26.set(i3, bool);
                this.f330839b.k2().set(this.f330840c, bool);
                this.f330839b.c2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCreateTechFragmentViewModel$preLoadingPagFiles$2(List<String> list, List<String> list2, SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel, int i3, Continuation<? super SuitCreateTechFragmentViewModel$preLoadingPagFiles$2> continuation) {
        super(2, continuation);
        this.$urlList = list;
        this.$loadingPagUrlList = list2;
        this.this$0 = suitCreateTechFragmentViewModel;
        this.$requestIndex = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCreateTechFragmentViewModel$preLoadingPagFiles$2(this.$urlList, this.$loadingPagUrlList, this.this$0, this.$requestIndex, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List plus;
        List<String> A2;
        List mutableList;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            plus = CollectionsKt___CollectionsKt.plus((Collection) this.$urlList, (Iterable) this.$loadingPagUrlList);
            A2 = this.this$0.A2(plus);
            if (!A2.isEmpty()) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) A2);
                SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel = this.this$0;
                a aVar = new a(mutableList, suitCreateTechFragmentViewModel, this.$requestIndex);
                ZPlanPAGLoader.f369875a.c(aVar);
                suitCreateTechFragmentViewModel.x3(aVar);
                List<String> list = this.$loadingPagUrlList;
                for (String str : A2) {
                    if (!list.contains(str)) {
                        ZPlanPAGLoader.f369875a.n(str);
                    }
                }
                return Unit.INSTANCE;
            }
            this.this$0.j2().set(this.$requestIndex, Boxing.boxBoolean(true));
            this.this$0.k2().set(this.$requestIndex, Boxing.boxBoolean(true));
            this.this$0.c2();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCreateTechFragmentViewModel$preLoadingPagFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
