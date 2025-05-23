package com.tencent.mobileqq.richmedialist.view;

import an2.c;
import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bn2.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.richmedialist.model.BaseItemInfo;
import com.tencent.mobileqq.richmedialist.model.ItemType;
import com.tencent.mobileqq.richmedialist.view.RichMediaListView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\n\u001a\u00020\u00022\u001e\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00060\u0005H\u0002J\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0002R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR2\u0010!\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00060\u00050\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/richmedialist/view/RichMediaListView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "E", "H", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/richmedialist/model/ItemType;", "Lcom/tencent/mobileqq/richmedialist/model/BaseItemInfo;", "pairList", "I", "Lbn2/a;", "manager", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "D", "Landroid/content/Context;", "context", "itemType", "Lan2/c;", "operatorListener", UserInfo.SEX_FEMALE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "Lbn2/a;", "richMediaManager", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "contactAdapter", "Landroidx/lifecycle/Observer;", "i", "Landroidx/lifecycle/Observer;", "listObserver", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RichMediaListView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private a richMediaManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWConcatAdapter contactAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<Pair<ItemType, List<BaseItemInfo>>>> listObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichMediaListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.listObserver = new Observer() { // from class: en2.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RichMediaListView.G(RichMediaListView.this, (List) obj);
            }
        };
    }

    private final void E() {
        a aVar = this.richMediaManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richMediaManager");
            aVar = null;
        }
        this.contactAdapter = aVar.a();
        setLayoutManager(new LinearLayoutManager(getContext()));
        setAdapter(this.contactAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(RichMediaListView this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.I(it);
    }

    private final void H() {
        a aVar = this.richMediaManager;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richMediaManager");
            aVar = null;
        }
        aVar.e().removeObserver(this.listObserver);
        a aVar3 = this.richMediaManager;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richMediaManager");
        } else {
            aVar2 = aVar3;
        }
        aVar2.b();
    }

    private final void I(List<? extends Pair<? extends ItemType, ? extends List<? extends BaseItemInfo>>> pairList) {
        Iterator<T> it = pairList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            a aVar = this.richMediaManager;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("richMediaManager");
                aVar = null;
            }
            AsyncListDifferDelegationAdapter<BaseItemInfo> f16 = aVar.f((ItemType) pair.getFirst());
            if (f16 != null) {
                f16.setItems((List) pair.getSecond());
            }
        }
    }

    public final void D(@NotNull a manager, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.richMediaManager = manager;
        manager.e().observe(lifecycleOwner, this.listObserver);
        a aVar = this.richMediaManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richMediaManager");
            aVar = null;
        }
        aVar.g(lifecycleOwner);
        E();
    }

    public final void F(@NotNull Context context, @NotNull ItemType itemType, @NotNull c operatorListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(operatorListener, "operatorListener");
        a aVar = this.richMediaManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("richMediaManager");
            aVar = null;
        }
        aVar.h(context, itemType, operatorListener);
    }

    public final void onDestroy() {
        H();
    }
}
