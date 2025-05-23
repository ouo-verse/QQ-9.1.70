package com.tencent.mobileqq.wink.pubcover.template;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.pubcover.template.WinkCoverTemplateMenuPart;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B9\u0012\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010#\u00a2\u0006\u0004\b.\u0010/J\"\u0010\t\u001a\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0014\u001a\u00020\bH\u0016R'\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001f\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0\u0015j\b\u0012\u0004\u0012\u00020)`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/template/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/pubcover/template/a$a;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "materials", "", "metaMaterialId", "", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "holder", "position", "", "k0", "m0", "j0", "getItemCount", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/ArrayList;", "list", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "getApplyMaterialOnlineTask", "()Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;", "applyMaterialOnlineTask", "Lkotlin/Function0;", "D", "Lkotlin/jvm/functions/Function0;", "getHandleItemClick", "()Lkotlin/jvm/functions/Function0;", "handleItemClick", "Lcom/tencent/mobileqq/wink/pubcover/template/b;", "E", "adapters", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "<init>", "(Ljava/util/ArrayList;Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask;Lkotlin/jvm/functions/Function0;)V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends RecyclerView.Adapter<C9079a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ApplyMaterialTask applyMaterialOnlineTask;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private final Function0<Unit> handleItemClick;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<b> adapters;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String metaMaterialId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MetaCategory> list;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/template/a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/support/v7/widget/RecyclerView;", "E", "Landroid/support/v7/widget/RecyclerView;", "l", "()Landroid/support/v7/widget/RecyclerView;", ParseCommon.CONTAINER, "<init>", "(Landroid/support/v7/widget/RecyclerView;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.pubcover.template.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9079a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final android.support.v7.widget.RecyclerView container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9079a(@NotNull android.support.v7.widget.RecyclerView container) {
            super(container);
            Intrinsics.checkNotNullParameter(container, "container");
            this.container = container;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final android.support.v7.widget.RecyclerView getContainer() {
            return this.container;
        }
    }

    public a(@NotNull ArrayList<MetaCategory> list, @NotNull ApplyMaterialTask applyMaterialOnlineTask, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(applyMaterialOnlineTask, "applyMaterialOnlineTask");
        this.list = list;
        this.applyMaterialOnlineTask = applyMaterialOnlineTask;
        this.handleItemClick = function0;
        this.adapters = new ArrayList<>();
    }

    private final int i0(List<MetaMaterial> materials, String metaMaterialId) {
        if (metaMaterialId != null && materials != null) {
            int size = materials.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (Intrinsics.areEqual(materials.get(i3).f30533id, metaMaterialId)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.list.size();
    }

    public final void j0(@Nullable MetaMaterial metaMaterialId) {
        String str;
        for (b bVar : this.adapters) {
            if (bVar != null) {
                List<MetaMaterial> B = bVar.B();
                if (metaMaterialId != null) {
                    str = metaMaterialId.f30533id;
                } else {
                    str = null;
                }
                bVar.notifyItemChanged(i0(B, str), 1);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C9079a holder, int position) {
        b bVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        MetaCategory metaCategory = this.list.get(position);
        Intrinsics.checkNotNullExpressionValue(metaCategory, "list[position]");
        MetaCategory metaCategory2 = metaCategory;
        RecyclerView.Adapter adapter = holder.getContainer().getAdapter();
        if (adapter instanceof b) {
            bVar = (b) adapter;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.Y(metaCategory2.materials);
            bVar.notifyDataSetChanged();
            bVar.b0(i0(bVar.B(), this.metaMaterialId), false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C9079a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        android.support.v7.widget.RecyclerView recyclerView = new android.support.v7.widget.RecyclerView(parent.getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4));
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        b bVar = new b(context, WinkEditorViewModel.EditMode.Video, this.handleItemClick);
        bVar.S(this.applyMaterialOnlineTask);
        recyclerView.addItemDecoration(new WinkCoverTemplateMenuPart.b(com.tencent.videocut.utils.e.f384236a.a(18.0f), 4));
        recyclerView.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        this.adapters.add(bVar);
        recyclerView.setAdapter(bVar);
        return new C9079a(recyclerView);
    }

    public final void m0(@Nullable String metaMaterialId) {
        this.metaMaterialId = metaMaterialId;
        notifyDataSetChanged();
    }
}
