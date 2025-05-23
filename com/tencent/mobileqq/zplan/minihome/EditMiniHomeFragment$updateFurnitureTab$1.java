package com.tencent.mobileqq.zplan.minihome;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.zplan.minihome.data.ServerFurnitureDesc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import fi3.ay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import yk0.FurnitureDesc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$updateFurnitureTab$1", f = "EditMiniHomeFragment.kt", i = {}, l = {1936}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class EditMiniHomeFragment$updateFurnitureTab$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StateFlow<Pair<Integer, List<n55.a>>> $source;
    int label;
    final /* synthetic */ EditMiniHomeFragment this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements FlowCollector<Pair<? extends Integer, ? extends List<? extends n55.a>>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditMiniHomeFragment f334266d;

        public a(EditMiniHomeFragment editMiniHomeFragment) {
            this.f334266d = editMiniHomeFragment;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(Pair<? extends Integer, ? extends List<? extends n55.a>> pair, Continuation<? super Unit> continuation) {
            final Pair<? extends Integer, ? extends List<? extends n55.a>> pair2 = pair;
            final EditMiniHomeFragment editMiniHomeFragment = this.f334266d;
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$updateFurnitureTab$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ay Gi;
                    ay Gi2;
                    ay Gi3;
                    ConcurrentHashMap concurrentHashMap;
                    String str;
                    ay Gi4;
                    ay Gi5;
                    Set of5;
                    String str2;
                    ay Gi6;
                    ay Gi7;
                    final int intValue = pair2.getFirst().intValue();
                    List<n55.a> second = pair2.getSecond();
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = second.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        String str3 = ((n55.a) next).f418394c;
                        if (true ^ (str3 == null || str3.length() == 0)) {
                            arrayList.add(next);
                        }
                    }
                    if (intValue == -1 || !arrayList.isEmpty()) {
                        Gi = editMiniHomeFragment.Gi();
                        Gi.f398987m.setVisibility(8);
                        Gi2 = editMiniHomeFragment.Gi();
                        Gi2.f398994t.setVisibility(0);
                    } else {
                        Gi6 = editMiniHomeFragment.Gi();
                        Gi6.f398987m.setVisibility(0);
                        Gi7 = editMiniHomeFragment.Gi();
                        Gi7.f398994t.setVisibility(8);
                    }
                    Gi3 = editMiniHomeFragment.Gi();
                    RecyclerView.Adapter adapter = Gi3.f398994t.getAdapter();
                    af afVar = adapter instanceof af ? (af) adapter : null;
                    if (afVar == null) {
                        return;
                    }
                    concurrentHashMap = editMiniHomeFragment.furnitureDescMapOnScreen;
                    str = editMiniHomeFragment.selectedSlot;
                    FurnitureDesc furnitureDesc = (FurnitureDesc) concurrentHashMap.get(str);
                    EditMiniHomeFragment editMiniHomeFragment2 = editMiniHomeFragment;
                    boolean z16 = false;
                    int i3 = 0;
                    Integer num = null;
                    for (Object obj : arrayList) {
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        n55.a aVar = (n55.a) obj;
                        ServerFurnitureDesc a16 = ServerFurnitureDesc.INSTANCE.a(aVar.f418399h);
                        if (a16 != null) {
                            if ((furnitureDesc != null && a16.getId() == furnitureDesc.getId()) && a16.getSubState() == furnitureDesc.getSubState()) {
                                of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"wall", "floor"});
                                str2 = editMiniHomeFragment2.selectedSlot;
                                if (of5.contains(str2) || !furnitureDesc.getDeleted()) {
                                    num = Integer.valueOf(i3);
                                    if (aVar.f418400i == 2) {
                                        z16 = true;
                                    }
                                }
                            }
                        }
                        i3 = i16;
                    }
                    afVar.n0(num);
                    Gi4 = editMiniHomeFragment.Gi();
                    Gi4.f398976b.setVisibility(z16 ? 0 : 8);
                    Gi5 = editMiniHomeFragment.Gi();
                    RecyclerView.LayoutManager layoutManager = Gi5.f398994t.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                    final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                    final int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
                    View findViewByPosition = gridLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                    int top = findViewByPosition != null ? findViewByPosition.getTop() : 0;
                    ArrayList arrayList2 = TypeIntrinsics.isMutableList(arrayList) ? arrayList : null;
                    final EditMiniHomeFragment editMiniHomeFragment3 = editMiniHomeFragment;
                    final int i17 = top;
                    afVar.submitList(arrayList2, new Runnable() { // from class: com.tencent.mobileqq.zplan.minihome.EditMiniHomeFragment$updateFurnitureTab$1$1$1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            ay Gi8;
                            if (intValue == 0) {
                                Gi8 = editMiniHomeFragment3.Gi();
                                Gi8.f398994t.scrollToPosition(0);
                            } else {
                                gridLayoutManager.scrollToPositionWithOffset(findFirstVisibleItemPosition, i17);
                            }
                        }
                    });
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EditMiniHomeFragment$updateFurnitureTab$1(StateFlow<? extends Pair<Integer, ? extends List<n55.a>>> stateFlow, EditMiniHomeFragment editMiniHomeFragment, Continuation<? super EditMiniHomeFragment$updateFurnitureTab$1> continuation) {
        super(2, continuation);
        this.$source = stateFlow;
        this.this$0 = editMiniHomeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditMiniHomeFragment$updateFurnitureTab$1(this.$source, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("EditMiniHomeFragment", 1, "collect source");
            StateFlow<Pair<Integer, List<n55.a>>> stateFlow = this.$source;
            if (stateFlow != null) {
                a aVar = new a(this.this$0);
                this.label = 1;
                if (stateFlow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EditMiniHomeFragment$updateFurnitureTab$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
