package com.tencent.mobileqq.search.guildsearch.activation.delegate;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.guildsearch.activation.ListBaseData;
import com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import hp2.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/search/guildsearch/activation/delegate/OperationHotSearchChildItemViewHolder;", "", "Lcom/tencent/mobileqq/search/guildsearch/activation/ListBaseData$OperationHotSearchItemData;", "dataList", "", "hasRightPic", "", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "position", "j0", "getItemCount", "viewHolder", "i0", "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;", "getListController", "()Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;", "l0", "(Lcom/tencent/mobileqq/search/guildsearch/parts/GuildSearchActivationPart$e;)V", "listController", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "D", "Z", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c extends RecyclerView.Adapter<OperationHotSearchChildItemViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<ListBaseData.OperationHotSearchItemData> itemList = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasRightPic;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildSearchActivationPart.e listController;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.itemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull OperationHotSearchChildItemViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (position >= 0 && position <= this.itemList.size() - 1) {
            viewHolder.n(this.itemList.get(position), position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public OperationHotSearchChildItemViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int position) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        r g16 = r.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        if (this.hasRightPic) {
            g16.getRoot().setPadding(ViewUtils.dpToPx(16.0f), 0, ViewUtils.dpToPx(6.0f), 0);
        }
        return new OperationHotSearchChildItemViewHolder(g16, this.listController);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void k0(@NotNull List<ListBaseData.OperationHotSearchItemData> dataList, boolean hasRightPic) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.itemList = dataList;
        this.hasRightPic = hasRightPic;
        notifyDataSetChanged();
    }

    public final void l0(@Nullable GuildSearchActivationPart.e eVar) {
        this.listController = eVar;
    }
}
