package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/adapter/q;", "Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter;", "Lcom/tencent/mobileqq/data/RecentUser;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "Le30/b;", "feedBlockData", "k0", "Lcom/tencent/biz/qqcircle/immersive/adapter/q$a;", "listener", "l0", "", "pageId", "m0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/adapter/q$a;", "onItemClickListener", BdhLogUtil.LogTag.Tag_Conn, "Le30/b;", "mFeedBlockData", "D", "Ljava/lang/String;", "mPageId", "<init>", "()V", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class q extends BaseListViewAdapter<RecentUser> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private e30.b mFeedBlockData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String mPageId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a onItemClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/adapter/q$a;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "data", "", com.tencent.luggage.wxa.c8.c.G, "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface a {
        void a(@NotNull RecentUser data, int pos);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/adapter/q$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "mIv", "<init>", "(Landroid/widget/ImageView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView mIv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull ImageView mIv) {
            super(mIv);
            Intrinsics.checkNotNullParameter(mIv, "mIv");
            this.mIv = mIv;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final ImageView getMIv() {
            return this.mIv;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(q this$0, RecentUser recentUser, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.onItemClickListener;
        if (aVar != null) {
            aVar.a(recentUser, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void k0(@Nullable e30.b feedBlockData) {
        this.mFeedBlockData = feedBlockData;
    }

    public final void l0(@Nullable a listener) {
        this.onItemClickListener = listener;
    }

    public final void m0(@Nullable String pageId) {
        this.mPageId = pageId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof b) {
            final RecentUser item = getItem(position);
            ImageView mIv = ((b) holder).getMIv();
            Intrinsics.checkNotNull(item);
            mIv.setImageDrawable(QCirclePluginGlobalInfo.q(item.uin, QFSCommentAtHelper.W(item.type)));
            mIv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.adapter.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.j0(q.this, item, position, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new RecyclerView.LayoutParams(ImmersiveUtils.dpToPx(48.0f), ImmersiveUtils.dpToPx(48.0f)));
        imageView.setPadding(ImmersiveUtils.dpToPx(6.0f), ImmersiveUtils.dpToPx(6.0f), ImmersiveUtils.dpToPx(6.0f), ImmersiveUtils.dpToPx(6.0f));
        return new b(imageView);
    }
}
