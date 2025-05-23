package com.tencent.mobileqq.wink.publish.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.publish.part.PublishGalleryPart;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qzone.QzoneIPCModule;
import d93.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u0001:\u0004567\u001aB\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\tH\u0016J\"\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u001b\u0010\u001e\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR#\u0010$\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u00060+R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishGalleryPart;", "Lcom/tencent/mobileqq/wink/publish/part/j;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "W9", "aa", "", "S9", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "childResId", "", NodeProps.VISIBLE, "Z9", "Landroidx/recyclerview/widget/LinearLayoutManager;", "U9", "", "B9", "mRootView", "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "d", "Lkotlin/Lazy;", "T9", "()I", "completeVisibleItemCount", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "kotlin.jvm.PlatformType", "e", "V9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "publishViewModel", "f", "Landroidx/recyclerview/widget/RecyclerView;", "galleryRv", tl.h.F, "Landroidx/recyclerview/widget/LinearLayoutManager;", "galleryLayoutManager", "Lcom/tencent/mobileqq/wink/publish/part/PublishGalleryPart$b;", "i", "Lcom/tencent/mobileqq/wink/publish/part/PublishGalleryPart$b;", "galleryAdapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mediaCount", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "c", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishGalleryPart extends j {
    private static final int D = ViewExKt.d(16);
    private static final int E = ViewExKt.d(103);
    private static final int F = ViewExKt.d(83);
    private static final int G = ViewExKt.d(4);
    private static final int H = ViewExKt.d(2);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy completeVisibleItemCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy publishViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView galleryRv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayoutManager galleryLayoutManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b galleryAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mediaCount;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishGalleryPart$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/publish/part/PublishGalleryPart$d;", "Lcom/tencent/mobileqq/wink/publish/part/PublishGalleryPart;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "j0", "getItemCount", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "i0", "()Ljava/util/List;", "n0", "(Ljava/util/List;)V", QAdVrReportParams.ParamKey.MEDIA, "", BdhLogUtil.LogTag.Tag_Conn, "Z", "getDeletable", "()Z", "l0", "(Z)V", "deletable", "D", "isDragging", "m0", "<init>", "(Lcom/tencent/mobileqq/wink/publish/part/PublishGalleryPart;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends RecyclerView.Adapter<d> {

        /* renamed from: C, reason: from kotlin metadata */
        private boolean deletable;

        /* renamed from: D, reason: from kotlin metadata */
        private boolean isDragging;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<? extends LocalMediaInfo> media;

        public b() {
            List<? extends LocalMediaInfo> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.media = emptyList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.media.size();
        }

        @NotNull
        public final List<LocalMediaInfo> i0() {
            return this.media;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.q(position, this.media.get(position), this.deletable, this.isDragging);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            PublishGalleryPart publishGalleryPart = PublishGalleryPart.this;
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.guo, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026ew_holder, parent, false)");
            return new d(publishGalleryPart, inflate);
        }

        public final void l0(boolean z16) {
            this.deletable = z16;
        }

        public final void m0(boolean z16) {
            this.isDragging = z16;
        }

        public final void n0(@NotNull List<? extends LocalMediaInfo> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.media = list;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishGalleryPart$c;", "Landroidx/recyclerview/widget/DividerItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/wink/publish/part/PublishGalleryPart;Landroid/content/Context;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class c extends DividerItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PublishGalleryPart f325734d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull PublishGalleryPart publishGalleryPart, Context context) {
            super(context, 0);
            Intrinsics.checkNotNullParameter(context, "context");
            this.f325734d = publishGalleryPart;
        }

        @Override // androidx.recyclerview.widget.DividerItemDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            if (((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition() == 0) {
                outRect.set(PublishGalleryPart.D, 0, 0, 0);
            } else {
                outRect.set(PublishGalleryPart.G, 0, 0, 0);
            }
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J&\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006R\u001c\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\n \u0011*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\n \u0011*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishGalleryPart$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "url", "", "o", "", "deletable", "r", "", "position", "isDragging", "p", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "kotlin.jvm.PlatformType", "E", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "tvCoverIndicator", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "ivImage", "Landroid/view/View;", "G", "Landroid/view/View;", "ivRemove", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/publish/part/PublishGalleryPart;Landroid/view/View;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final RoundCorneredRelativeLayout tvCoverIndicator;

        /* renamed from: F, reason: from kotlin metadata */
        private final RoundCornerImageView ivImage;

        /* renamed from: G, reason: from kotlin metadata */
        private final View ivRemove;
        final /* synthetic */ PublishGalleryPart H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull final PublishGalleryPart publishGalleryPart, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.H = publishGalleryPart;
            RoundCorneredRelativeLayout roundCorneredRelativeLayout = (RoundCorneredRelativeLayout) itemView.findViewById(R.id.f107106_i);
            this.tvCoverIndicator = roundCorneredRelativeLayout;
            this.ivImage = (RoundCornerImageView) itemView.findViewById(R.id.y4u);
            this.ivRemove = itemView.findViewById(R.id.f165964y84);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishGalleryPart.d.n(PublishGalleryPart.this, this, view);
                }
            });
            float f16 = PublishGalleryPart.H;
            roundCorneredRelativeLayout.setRadius(f16, f16, f16, f16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(PublishGalleryPart this$0, d this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.V9().d3(this$0.getActivity(), this$1.getLayoutPosition());
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void o(String url) {
            this.ivImage.setCorner(PublishGalleryPart.H);
            Option option = new Option();
            option.setUrl(url).setTargetView(this.ivImage).setPredecode(true).setRequestWidth(PublishGalleryPart.F).setRequestHeight(PublishGalleryPart.F);
            QCircleFeedPicLoader.g().loadImage(option);
        }

        private final void p(int position, boolean isDragging) {
            if (position == 0 && !isDragging) {
                this.tvCoverIndicator.setVisibility(0);
            } else {
                this.tvCoverIndicator.setVisibility(4);
            }
        }

        private final void r(boolean deletable) {
            int i3;
            View view = this.ivRemove;
            if (deletable) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
            View view2 = this.ivRemove;
            final PublishGalleryPart publishGalleryPart = this.H;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    PublishGalleryPart.d.s(PublishGalleryPart.this, this, view3);
                }
            });
            VideoReport.setElementId(this.ivRemove, WinkDaTongReportConstant.ElementId.EM_XSJ_EDIT_DELETE_CROSS_BUTTON);
            VideoReport.setElementClickPolicy(this.ivRemove, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(this.ivRemove, ExposurePolicy.REPORT_ALL);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(PublishGalleryPart this$0, d this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.V9().q3(this$1.getLayoutPosition());
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void q(int position, @NotNull LocalMediaInfo media, boolean deletable, boolean isDragging) {
            Intrinsics.checkNotNullParameter(media, "media");
            String str = media.path;
            Intrinsics.checkNotNullExpressionValue(str, "media.path");
            o(str);
            r(deletable);
            p(position, isDragging);
        }
    }

    public PublishGalleryPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishGalleryPart$completeVisibleItemCount$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int S9;
                S9 = PublishGalleryPart.this.S9();
                return Integer.valueOf(S9);
            }
        });
        this.completeVisibleItemCount = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PublishViewModel>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishGalleryPart$publishViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishViewModel invoke() {
                return (PublishViewModel) PublishGalleryPart.this.getViewModel(PublishViewModel.class);
            }
        });
        this.publishViewModel = lazy2;
        this.galleryAdapter = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S9() {
        return ((ImmersiveUtils.getScreenWidth() - D) - E) / F;
    }

    private final int T9() {
        return ((Number) this.completeVisibleItemCount.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View U9(LinearLayoutManager linearLayoutManager) {
        View childAt;
        if (linearLayoutManager == null || (childAt = linearLayoutManager.getChildAt(0)) == null || linearLayoutManager.getPosition(childAt) != 0) {
            return null;
        }
        return childAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PublishViewModel V9() {
        return (PublishViewModel) this.publishViewModel.getValue();
    }

    private final void W9(RecyclerView recyclerView) {
        d93.d dVar = new d93.d();
        dVar.d(1.2f);
        dVar.b(0.9f);
        dVar.c(new e());
        new ItemTouchHelper(dVar).attachToRecyclerView(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(PublishGalleryPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.picker.g gVar = com.tencent.mobileqq.wink.picker.g.f324860a;
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        String traceId = WinkContext.INSTANCE.d().getTraceId();
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar = new Config.a();
        aVar.i(TabType.ONLY_IMAGE);
        aVar.p(this$0.galleryAdapter.getItemCount());
        MediaFilter.Companion companion2 = MediaFilter.INSTANCE;
        MediaFilter.a aVar2 = new MediaFilter.a();
        aVar2.e(0.375f);
        aVar2.c(2.5f);
        aVar.o(aVar2.a());
        Unit unit = Unit.INSTANCE;
        gVar.h(activity, 100, traceId, aVar.a());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(View parent, @IdRes int childResId, boolean visible) {
        View view;
        int i3;
        if (parent != null) {
            view = parent.findViewById(childResId);
        } else {
            view = null;
        }
        if (view != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa() {
        ViewGroup.LayoutParams layoutParams;
        int i3;
        RecyclerView recyclerView = this.galleryRv;
        ConstraintLayout.LayoutParams layoutParams2 = null;
        if (recyclerView != null) {
            layoutParams = recyclerView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            if (this.galleryAdapter.getItemCount() <= T9()) {
                if (this.galleryAdapter.getItemCount() == 0) {
                    i3 = D;
                } else {
                    i3 = -2;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = i3;
                layoutParams2.endToEnd = -1;
                layoutParams2.setMarginEnd(0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                layoutParams2.endToEnd = 0;
                layoutParams2.setMarginEnd(E);
            }
            RecyclerView recyclerView2 = this.galleryRv;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NotNull
    public String B9() {
        return "PublishGalleryPart";
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 100 || resultCode != -1 || data == null) {
            return;
        }
        V9().R1(data.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA));
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View mRootView) {
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        super.onInitView(mRootView);
        View findViewById = getPartRootView().findViewById(R.id.f1204379j);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
        View inflate = ((ViewStub) findViewById).inflate();
        final RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.f789948k);
        recyclerView.setItemViewCacheSize(0);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 0, false);
        this.galleryLayoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.galleryAdapter);
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        recyclerView.addItemDecoration(new c(this, context));
        Intrinsics.checkNotNullExpressionValue(recyclerView, "this");
        W9(recyclerView);
        MutableLiveData<ArrayList<LocalMediaInfo>> mutableLiveData = V9().C;
        BasePartFragment hostFragment = getHostFragment();
        final Function1<ArrayList<LocalMediaInfo>, Unit> function1 = new Function1<ArrayList<LocalMediaInfo>, Unit>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishGalleryPart$onInitView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<LocalMediaInfo> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<LocalMediaInfo> it) {
                int i3;
                int i16;
                PublishGalleryPart.b bVar = PublishGalleryPart.this.galleryAdapter;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                bVar.n0(it);
                PublishGalleryPart.this.galleryAdapter.notifyDataSetChanged();
                int size = it.size();
                i3 = PublishGalleryPart.this.mediaCount;
                if (size > i3) {
                    i16 = PublishGalleryPart.this.mediaCount;
                    if (i16 != 0) {
                        recyclerView.smoothScrollToPosition(it.size());
                    }
                }
                PublishGalleryPart publishGalleryPart = PublishGalleryPart.this;
                publishGalleryPart.mediaCount = publishGalleryPart.galleryAdapter.i0().size();
                PublishGalleryPart.this.aa();
            }
        };
        mutableLiveData.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishGalleryPart.X9(Function1.this, obj);
            }
        });
        this.galleryRv = recyclerView;
        ((RoundCornerImageView) inflate.findViewById(R.id.xzp)).setCorner(H);
        View findViewById2 = inflate.findViewById(R.id.f166085yn1);
        VideoReport.setElementId(findViewById2, WinkDaTongReportConstant.ElementId.EM_XSJ_CHOOSE_PICTURE);
        VideoReport.setElementClickPolicy(findViewById2, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(findViewById2, ExposurePolicy.REPORT_ALL);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishGalleryPart.Y9(PublishGalleryPart.this, view);
            }
        });
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/publish/part/PublishGalleryPart$e", "Ld93/d$a;", "", "getSize", "fromPosition", "toPosition", "", "onItemMoved", "position", "c", "a", "", "isInside", "b", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements d.a {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(PublishGalleryPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.galleryAdapter.notifyDataSetChanged();
        }

        @Override // d93.d.a
        public void a() {
            PublishGalleryPart.this.galleryAdapter.l0(true);
            PublishGalleryPart.this.galleryAdapter.m0(true);
            LinearLayoutManager linearLayoutManager = PublishGalleryPart.this.galleryLayoutManager;
            if (linearLayoutManager != null) {
                PublishGalleryPart publishGalleryPart = PublishGalleryPart.this;
                int childCount = linearLayoutManager.getChildCount();
                if (childCount >= 0) {
                    int i3 = 0;
                    while (true) {
                        publishGalleryPart.Z9(linearLayoutManager.getChildAt(i3), R.id.f165964y84, true);
                        if (i3 == childCount) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                publishGalleryPart.Z9(publishGalleryPart.U9(linearLayoutManager), R.id.f107106_i, false);
            }
        }

        @Override // d93.d.a
        public void b(boolean isInside) {
            PublishGalleryPart.this.galleryAdapter.m0(false);
            RecyclerView recyclerView = PublishGalleryPart.this.galleryRv;
            if (recyclerView != null) {
                final PublishGalleryPart publishGalleryPart = PublishGalleryPart.this;
                recyclerView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        PublishGalleryPart.e.e(PublishGalleryPart.this);
                    }
                }, 200L);
            }
        }

        @Override // d93.d.a
        public int getSize() {
            return PublishGalleryPart.this.galleryAdapter.i0().size();
        }

        @Override // d93.d.a
        public void onItemMoved(int fromPosition, int toPosition) {
            PublishGalleryPart.this.V9().a3(fromPosition, toPosition);
            PublishGalleryPart.this.galleryAdapter.notifyItemMoved(fromPosition, toPosition);
            RecyclerView recyclerView = PublishGalleryPart.this.galleryRv;
            if (recyclerView != null) {
                recyclerView.invalidateItemDecorations();
            }
        }

        @Override // d93.d.a
        public void c(int position) {
        }
    }
}
