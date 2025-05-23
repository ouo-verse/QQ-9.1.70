package com.tencent.mobileqq.zplan.friend.changerole.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.zplan.friend.FriendInfo;
import com.tencent.mobileqq.zplan.friend.changerole.view.itemview.ZplanFriendStepItemDecoration;
import com.tencent.mobileqq.zplan.friend.e;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u001b\u0010\u000f\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/changerole/view/widget/ZPlanFriendRoleStepSelectView;", "Landroid/widget/FrameLayout;", "", "e", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/mobileqq/zplan/friend/changerole/model/a;", "viewModel", "Lcom/tencent/mobileqq/zplan/friend/e;", "binder", "setViewModelAndObserveData", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Lkotlin/Lazy;", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lwh3/b;", "Lwh3/b;", "getChooseRoleAdapter", "()Lwh3/b;", "setChooseRoleAdapter", "(Lwh3/b;)V", "chooseRoleAdapter", "f", "Lcom/tencent/mobileqq/zplan/friend/changerole/model/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFriendRoleStepSelectView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private wh3.b chooseRoleAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.friend.changerole.model.a viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanFriendRoleStepSelectView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.zplan.friend.changerole.view.widget.ZPlanFriendRoleStepSelectView$recyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return new RecyclerView(context);
            }
        });
        this.recyclerView = lazy;
    }

    private final void e() {
        RecyclerView d16 = d();
        d16.setLayoutManager(new LinearLayoutManager(d16.getContext(), 0, false));
        d16.setAdapter(this.chooseRoleAdapter);
        d16.addItemDecoration(new ZplanFriendStepItemDecoration());
        wh3.b bVar = this.chooseRoleAdapter;
        if (bVar != null) {
            bVar.s0(new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.friend.changerole.view.widget.ZPlanFriendRoleStepSelectView$initView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Unit invoke(int i3) {
                    com.tencent.mobileqq.zplan.friend.changerole.model.a aVar;
                    aVar = ZPlanFriendRoleStepSelectView.this.viewModel;
                    if (aVar == null) {
                        return null;
                    }
                    aVar.e2(i3);
                    return Unit.INSTANCE;
                }
            });
        }
        addView(d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ZPlanFriendRoleStepSelectView this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        wh3.b bVar = this$0.chooseRoleAdapter;
        if (bVar != null) {
            bVar.t0(map, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ZPlanFriendRoleStepSelectView this$0, Integer it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        wh3.b bVar = this$0.chooseRoleAdapter;
        if (bVar == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        bVar.r0(it.intValue());
    }

    public final RecyclerView d() {
        return (RecyclerView) this.recyclerView.getValue();
    }

    public final void setChooseRoleAdapter(wh3.b bVar) {
        this.chooseRoleAdapter = bVar;
    }

    public final void setViewModelAndObserveData(LifecycleOwner owner, com.tencent.mobileqq.zplan.friend.changerole.model.a viewModel, e binder) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(binder, "binder");
        this.viewModel = viewModel;
        wh3.b bVar = new wh3.b(binder);
        this.chooseRoleAdapter = bVar;
        MutableLiveData<Map<Integer, FriendInfo>> Z1 = viewModel.Z1();
        Map<Integer, FriendInfo> value = Z1 != null ? Z1.getValue() : null;
        bVar.t0(TypeIntrinsics.isMutableMap(value) ? value : null, viewModel.W1());
        MutableLiveData<Map<Integer, FriendInfo>> Z12 = viewModel.Z1();
        if (Z12 != null) {
            Z12.observe(owner, new Observer() { // from class: com.tencent.mobileqq.zplan.friend.changerole.view.widget.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZPlanFriendRoleStepSelectView.f(ZPlanFriendRoleStepSelectView.this, (Map) obj);
                }
            });
        }
        MutableLiveData<Integer> T1 = viewModel.T1();
        if (T1 != null) {
            T1.observe(owner, new Observer() { // from class: com.tencent.mobileqq.zplan.friend.changerole.view.widget.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZPlanFriendRoleStepSelectView.g(ZPlanFriendRoleStepSelectView.this, (Integer) obj);
                }
            });
        }
        e();
    }
}
