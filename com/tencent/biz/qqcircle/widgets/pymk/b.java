package com.tencent.biz.qqcircle.widgets.pymk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalHintViewChangeEvent;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qc0.i;
import qc0.n;
import qc0.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000289B\u000f\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0014\u0010\u0017\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015J\u0018\u0010\u001a\u001a\u00020\u00052\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018H\u0016J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0012\u0010!\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010 H\u0016J\b\u0010\"\u001a\u00020\u001bH\u0014R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010-\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u001e\u00101\u001a\n .*\u0004\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006:"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/pymk/b;", "Lcom/tencent/biz/qqcircle/bizparts/a;", "Lfeedcloud/FeedCloudMeta$StUserRecomInfo;", "", c.G, "", "m0", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "p0", "loadData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "position", "getItemViewType", "getViewTypeCount", "getItemCount", "viewHolder", "onBindViewHolder", "", "recomUsers", "updateData", "", "list", "setDatas", "", "title", "", "showDivider", "n0", "Landroid/os/Bundle;", "onInitBlock", "getLogTag", "Lcom/tencent/biz/qqcircle/widgets/pymk/b$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/widgets/pymk/b$b;", "callBack", BdhLogUtil.LogTag.Tag_Conn, "I", "ITEM_TYPE_NORMAL", "D", "ITEM_TYPE_CONTRACT", "E", "ITEM_TYPE_TOP_HINT", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "mTopTitle", "G", "Z", "mTopDividerShow", "<init>", "(Lcom/tencent/biz/qqcircle/widgets/pymk/b$b;)V", "H", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class b extends com.tencent.biz.qqcircle.bizparts.a<FeedCloudMeta$StUserRecomInfo> {

    /* renamed from: C, reason: from kotlin metadata */
    private final int ITEM_TYPE_NORMAL;

    /* renamed from: D, reason: from kotlin metadata */
    private final int ITEM_TYPE_CONTRACT;

    /* renamed from: E, reason: from kotlin metadata */
    private final int ITEM_TYPE_TOP_HINT;

    /* renamed from: F, reason: from kotlin metadata */
    private String mTopTitle;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mTopDividerShow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InterfaceC0940b callBack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/pymk/b$b;", "", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.widgets.pymk.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0940b {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull InterfaceC0940b callBack) {
        super(new Bundle());
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        this.callBack = callBack;
        this.ITEM_TYPE_CONTRACT = 1;
        this.ITEM_TYPE_TOP_HINT = 2;
        this.mTopTitle = h.a(R.string.f184083kx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(b this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(b this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m0(i3);
    }

    private final void m0(int pos) {
        boolean z16;
        QLog.d("QFSPYMKRecommendListAdapterNew", 1, "remove data index:" + pos);
        delete(pos);
        List<FeedCloudMeta$StUserRecomInfo> dataList = getDataList();
        if (dataList != null && dataList.size() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            clearData();
            BlockMerger blockMerger = getBlockMerger();
            if (blockMerger != null) {
                blockMerger.showHint(false);
            }
            BlockMerger blockMerger2 = getBlockMerger();
            if (blockMerger2 != null) {
                blockMerger2.onLoadMoreCompleted(false, true);
            }
            this.callBack.a();
            SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalHintViewChangeEvent(2));
        }
        notifyItemRemoved(pos);
        notifyItemRangeChanged(pos, getNUM_BACKGOURND_ICON());
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<E> list = this.mDataList;
        if (list != 0) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return this.ITEM_TYPE_TOP_HINT;
        }
        if (getDataList().size() > position && Intrinsics.areEqual(getDataList().get(position).user.f398463id.get(), "tag_type_contract")) {
            return this.ITEM_TYPE_CONTRACT;
        }
        return this.ITEM_TYPE_NORMAL;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    protected String getLogTag() {
        return "QFSPYMKRecommendListAdapterNew";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public final void n0(@NotNull String title, boolean showDivider) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.mTopTitle = title;
        this.mTopDividerShow = showDivider;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (viewHolder instanceof n) {
            n nVar = (n) viewHolder;
            nVar.B(position);
            nVar.A(new n.c() { // from class: qc0.k
                @Override // qc0.n.c
                public final void onClick(int i3) {
                    com.tencent.biz.qqcircle.widgets.pymk.b.k0(com.tencent.biz.qqcircle.widgets.pymk.b.this, i3);
                }
            });
            if (ArrayUtils.isOutOfArrayIndex(position, this.mDataList)) {
                QLog.d("QFSPYMKRecommendListAdapterNew", 1, "invalid index: " + position + "|" + this.mDataList.size());
                return;
            }
            nVar.C(false);
            nVar.y(this.mDataList.get(position));
            return;
        }
        if (viewHolder instanceof i) {
            i iVar = (i) viewHolder;
            iVar.w(position);
            iVar.v(new n.c() { // from class: qc0.l
                @Override // qc0.n.c
                public final void onClick(int i3) {
                    com.tencent.biz.qqcircle.widgets.pymk.b.l0(com.tencent.biz.qqcircle.widgets.pymk.b.this, i3);
                }
            });
            Object obj = this.mDataList.get(position);
            Intrinsics.checkNotNullExpressionValue(obj, "mDataList[position]");
            iVar.u((FeedCloudMeta$StUserRecomInfo) obj);
            return;
        }
        if (viewHolder instanceof q) {
            String mTopTitle = this.mTopTitle;
            Intrinsics.checkNotNullExpressionValue(mTopTitle, "mTopTitle");
            ((q) viewHolder).m(mTopTitle, this.mTopDividerShow);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == this.ITEM_TYPE_CONTRACT) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gpx, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(\n                  \u2026em_layout, parent, false)");
            return new i(inflate);
        }
        if (viewType == this.ITEM_TYPE_TOP_HINT) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168747gq2, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(\n                pa\u2026_top_hint, parent, false)");
            return new q(inflate2);
        }
        return new n(LayoutInflater.from(parent.getContext()).inflate(R.layout.gpy, parent, false));
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(@Nullable List<FeedCloudMeta$StUserRecomInfo> list) {
        super.setDatas(list);
        SimpleEventBus.getInstance().dispatchEvent(new QFSPersonalHintViewChangeEvent(1));
    }

    public final void updateData(@NotNull List<FeedCloudMeta$StUserRecomInfo> recomUsers) {
        Intrinsics.checkNotNullParameter(recomUsers, "recomUsers");
        this.mDataList.addAll(recomUsers);
        notifyDataSetChanged();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(@Nullable LoadInfo p06) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle p06) {
    }
}
