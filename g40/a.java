package g40;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverFeedItemView;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverPlusItemView;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverPublishFailedItemView;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverPublishingItemView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import h40.QFSPersonalCoverFeedInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000534567B\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b0\u00101J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J(\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 H\u0014J\b\u0010$\u001a\u00020#H\u0014R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R#\u0010/\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010.\u00a8\u00068"}, d2 = {"Lg40/a;", "Lcom/tencent/biz/qqcircle/bizparts/a;", "Lh40/a;", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", com.tencent.luggage.wxa.c8.c.G, "spanCount", "", "j0", "k0", "Landroid/view/ViewGroup;", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "", "onBindViewHolder", "getItemViewType", "getItemCount", "Landroid/os/Bundle;", "initParams", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "loadData", "getViewTypeCount", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "getItemOffsets", "", "getLogTag", "", "", "Lg40/a$e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "_publishingItemHolder", "", BdhLogUtil.LogTag.Tag_Conn, "i0", "()Ljava/util/Map;", "publishingItemHolder", "<init>", "(Landroid/os/Bundle;)V", "D", "a", "b", "c", "d", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a extends com.tencent.biz.qqcircle.bizparts.a<QFSPersonalCoverFeedInfo> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<Long, e> publishingItemHolder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, e> _publishingItemHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lg40/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverFeedItemView;", "E", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverFeedItemView;", "l", "()Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverFeedItemView;", "feedItemView", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverFeedItemView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QFSPersonalCoverFeedItemView feedItemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull QFSPersonalCoverFeedItemView feedItemView) {
            super(feedItemView);
            Intrinsics.checkNotNullParameter(feedItemView, "feedItemView");
            this.feedItemView = feedItemView;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final QFSPersonalCoverFeedItemView getFeedItemView() {
            return this.feedItemView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lg40/a$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPlusItemView;", "E", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPlusItemView;", "l", "()Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPlusItemView;", "plusItemView", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPlusItemView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QFSPersonalCoverPlusItemView plusItemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull QFSPersonalCoverPlusItemView plusItemView) {
            super(plusItemView);
            Intrinsics.checkNotNullParameter(plusItemView, "plusItemView");
            this.plusItemView = plusItemView;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final QFSPersonalCoverPlusItemView getPlusItemView() {
            return this.plusItemView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lg40/a$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPublishFailedItemView;", "E", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPublishFailedItemView;", "l", "()Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPublishFailedItemView;", "publishFailedItemView", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPublishFailedItemView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QFSPersonalCoverPublishFailedItemView publishFailedItemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull QFSPersonalCoverPublishFailedItemView publishFailedItemView) {
            super(publishFailedItemView);
            Intrinsics.checkNotNullParameter(publishFailedItemView, "publishFailedItemView");
            this.publishFailedItemView = publishFailedItemView;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final QFSPersonalCoverPublishFailedItemView getPublishFailedItemView() {
            return this.publishFailedItemView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lg40/a$e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPublishingItemView;", "E", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPublishingItemView;", "l", "()Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPublishingItemView;", "publishingItemView", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPublishingItemView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QFSPersonalCoverPublishingItemView publishingItemView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull QFSPersonalCoverPublishingItemView publishingItemView) {
            super(publishingItemView);
            Intrinsics.checkNotNullParameter(publishingItemView, "publishingItemView");
            this.publishingItemView = publishingItemView;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final QFSPersonalCoverPublishingItemView getPublishingItemView() {
            return this.publishingItemView;
        }
    }

    public a(@Nullable Bundle bundle) {
        super(bundle);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this._publishingItemHolder = linkedHashMap;
        this.publishingItemHolder = linkedHashMap;
    }

    private final boolean j0(RecyclerView parent, int pos, int spanCount) {
        if (!(parent.getLayoutManager() instanceof GridLayoutManager) || pos % spanCount != 0) {
            return false;
        }
        return true;
    }

    private final boolean k0(RecyclerView parent, int pos, int spanCount) {
        if (!(parent.getLayoutManager() instanceof GridLayoutManager) || (pos + 1) % spanCount != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<E> list = this.mDataList;
        if (list == 0) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (parent.getAdapter() == null) {
            return;
        }
        int childLayoutPosition = parent.getChildLayoutPosition(view);
        boolean j06 = j0(parent, childLayoutPosition, 3);
        boolean k06 = k0(parent, childLayoutPosition, 3);
        int a16 = cx.a(0.5f);
        if (j06) {
            i3 = 0;
        } else if (k06) {
            i3 = a16 * 2;
        } else {
            i3 = a16;
        }
        if (k06) {
            i16 = 0;
        } else if (j06) {
            i16 = a16 * 2;
        } else {
            i16 = a16;
        }
        outRect.set(i3, 0, i16, a16 * 3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return ((QFSPersonalCoverFeedInfo) this.mDataList.get(position)).getItemType();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    protected String getLogTag() {
        return "QFSPersonalCoverFeedAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    @NotNull
    public final Map<Long, e> i0() {
        return this.publishingItemHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QFSPersonalCoverFeedInfo qFSPersonalCoverFeedInfo = (QFSPersonalCoverFeedInfo) this.mDataList.get(position);
        if (holder instanceof c) {
            c cVar = (c) holder;
            cVar.getPlusItemView().setData(qFSPersonalCoverFeedInfo, position);
            i40.b.f407181a.d(cVar.getPlusItemView(), true);
            return;
        }
        if (holder instanceof e) {
            ((e) holder).getPublishingItemView().setData(qFSPersonalCoverFeedInfo, position);
            TaskInfo taskInfo = qFSPersonalCoverFeedInfo.getTaskInfo();
            if (taskInfo != null) {
                this._publishingItemHolder.put(Long.valueOf(taskInfo.getTaskId()), holder);
                return;
            }
            return;
        }
        if (holder instanceof d) {
            ((d) holder).getPublishFailedItemView().setData(qFSPersonalCoverFeedInfo, position);
        } else if (holder instanceof b) {
            b bVar = (b) holder;
            bVar.getFeedItemView().setData(qFSPersonalCoverFeedInfo, position);
            i40.b.f407181a.b(bVar.getFeedItemView(), qFSPersonalCoverFeedInfo.getFeed());
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NotNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 100001:
            case 100002:
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                return new b(new QFSPersonalCoverFeedItemView(context));
            case 100003:
                Bundle initParams = getInitParams();
                HashMap hashMap = null;
                if (initParams != null) {
                    serializable = initParams.getSerializable("key_bundle_common_init_bean");
                } else {
                    serializable = null;
                }
                if (serializable instanceof HashMap) {
                    hashMap = (HashMap) serializable;
                }
                Context context2 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                return new c(new QFSPersonalCoverPlusItemView(context2, hashMap));
            case 100004:
                Context context3 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
                return new e(new QFSPersonalCoverPublishingItemView(context3));
            case 100005:
                Context context4 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "parent.context");
                return new d(new QFSPersonalCoverPublishFailedItemView(context4));
            default:
                Context context5 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "parent.context");
                return new b(new QFSPersonalCoverFeedItemView(context5));
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(@Nullable LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle initParams) {
    }
}
