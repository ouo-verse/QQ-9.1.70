package com.tencent.mobileqq.guild.feed.adapter;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.section.f;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ComputedKt;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageExKt;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003BCDB\u0013\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b@\u0010AJ$\u0010\n\u001a\u00020\t2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0003J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\u000f\u001a\u00020\t2\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010H\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0014J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R,\u0010+\u001a\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u00040'j\f\u0012\b\u0012\u00060\u0003j\u0002`\u0004`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R7\u0010<\u001a\u001e\u0012\f\u0012\n 7*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n 7*\u0004\u0018\u00010\u00070\u00070\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/adapter/GuildSimpleFeedItemImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/feed/adapter/GuildSimpleFeedItemImageAdapter$GuildSimpleFeedItemImageViewHolder;", "Lqj1/l;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IMediaDisplayable;", "mixedMediaData", "holder", "", "position", "", "t0", "Landroid/view/View;", "itemView", "z0", "view", "o0", "Landroid/util/Pair;", "size", "x0", "s0", "", "setData", "Lcom/tencent/mobileqq/guild/feed/adapter/o;", "listener", "y0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "w0", "u0", "getItemCount", "getItemViewType", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "depends", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/adapter/o;", "mListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "mMediaDataArray", "E", "I", "maxRow", UserInfo.SEX_FEMALE, "maxCol", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "G", "Lkotlin/Lazy;", "r0", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "mediaSizeUtils", "kotlin.jvm.PlatformType", "H", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "p0", "()Landroid/util/Pair;", "imageSize", "q0", "()I", "maxItemCount", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;)V", "a", "GuildSimpleFeedItemImageViewHolder", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSimpleFeedItemImageAdapter extends RecyclerView.Adapter<GuildSimpleFeedItemImageViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private o mListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<qj1.l> mMediaDataArray;

    /* renamed from: E, reason: from kotlin metadata */
    private final int maxRow;

    /* renamed from: F, reason: from kotlin metadata */
    private int maxCol;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaSizeUtils;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.utils.a imageSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final f.b depends;
    static final /* synthetic */ KProperty<Object>[] J = {Reflection.property1(new PropertyReference1Impl(GuildSimpleFeedItemImageAdapter.class, "imageSize", "getImageSize()Landroid/util/Pair;", 0))};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/adapter/GuildSimpleFeedItemImageAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "position", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "itemCount", "", "a", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        private final boolean a(int position, GridLayoutManager layoutManager, int itemCount) {
            int spanCount;
            if (itemCount % layoutManager.getSpanCount() == 0) {
                spanCount = layoutManager.getSpanCount();
            } else {
                spanCount = itemCount % layoutManager.getSpanCount();
            }
            if ((position + spanCount) - itemCount >= 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            RecyclerView.Adapter adapter = parent.getAdapter();
            if ((layoutManager instanceof GridLayoutManager) && adapter != null) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                int spanCount = gridLayoutManager.getSpanCount();
                int i3 = childAdapterPosition % spanCount;
                int dip2px = ViewUtils.dip2px(3.0f);
                outRect.left = (i3 * dip2px) / spanCount;
                outRect.right = dip2px - (((i3 + 1) * dip2px) / spanCount);
                if (!a(childAdapterPosition, gridLayoutManager, adapter.getNUM_BACKGOURND_ICON())) {
                    outRect.bottom = dip2px;
                }
            }
        }
    }

    public GuildSimpleFeedItemImageAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void o0(qj1.l mixedMediaData, View view) {
        Integer num;
        if (mixedMediaData != null && getNUM_BACKGOURND_ICON() != 0) {
            Logger.a d16 = Logger.f235387a.d();
            Integer num2 = null;
            if (view != null) {
                num = Integer.valueOf(view.getWidth());
            } else {
                num = null;
            }
            if (view != null) {
                num2 = Integer.valueOf(view.getHeight());
            }
            d16.d("GuildSimpleFeedItemImageAdapter", 1, "adjustViewSize, view: w: " + num + ", h: " + num2 + ", targetSize: " + s0());
            x0(view, s0());
        }
    }

    private final Pair<Integer, Integer> p0() {
        return (Pair) this.imageSize.getValue(this, J[0]);
    }

    private final int q0() {
        return this.maxCol * this.maxRow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbsGuildFeedMediaSizeUtils r0() {
        return (AbsGuildFeedMediaSizeUtils) this.mediaSizeUtils.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, Integer> s0() {
        return p0();
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void t0(qj1.l mixedMediaData, GuildSimpleFeedItemImageViewHolder holder, int position) {
        String str;
        Object a16;
        String thumbUrl = mixedMediaData.getThumbUrl();
        ImageView o16 = holder.o();
        kotlin.Pair pair = TuplesKt.to(p0().first, p0().second);
        f.b bVar = this.depends;
        if (bVar != null && (a16 = bVar.a()) != null) {
            str = a16 + "_image_" + position;
        } else {
            str = null;
        }
        GuildFeedListImageExKt.g(o16, thumbUrl, pair, str, GuildFeedListImageExKt.c(holder.o()), null, false, false, true, null, 368, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(GuildSimpleFeedItemImageAdapter this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        o oVar = this$0.mListener;
        if (oVar != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            oVar.onClick(view, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x0(View view, Pair<Integer, Integer> size) {
        if (view != null && size != null) {
            int width = view.getWidth();
            Integer num = (Integer) size.first;
            if (num != null && width == num.intValue()) {
                int height = view.getHeight();
                Integer num2 = (Integer) size.second;
                if (num2 != null && height == num2.intValue()) {
                    return;
                }
            }
            Object obj = size.first;
            Intrinsics.checkNotNullExpressionValue(obj, "size.first");
            int intValue = ((Number) obj).intValue();
            Object obj2 = size.second;
            Intrinsics.checkNotNullExpressionValue(obj2, "size.second");
            view.setLayoutParams(new ViewGroup.LayoutParams(intValue, ((Number) obj2).intValue()));
            ImageView imageView = (ImageView) view.findViewById(R.id.x0x);
            if (imageView != null) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                if (layoutParams == null) {
                    Object obj3 = size.first;
                    Intrinsics.checkNotNullExpressionValue(obj3, "size.first");
                    int intValue2 = ((Number) obj3).intValue();
                    Object obj4 = size.second;
                    Intrinsics.checkNotNullExpressionValue(obj4, "size.second");
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(intValue2, ((Number) obj4).intValue()));
                    return;
                }
                Object obj5 = size.first;
                Intrinsics.checkNotNullExpressionValue(obj5, "size.first");
                layoutParams.width = ((Number) obj5).intValue();
                Object obj6 = size.second;
                Intrinsics.checkNotNullExpressionValue(obj6, "size.second");
                layoutParams.height = ((Number) obj6).intValue();
                imageView.setLayoutParams(layoutParams);
            }
        }
    }

    private final void z0(View itemView, int position) {
        int coerceAtMost;
        if (itemView instanceof RoundCornerLayout) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(getNUM_BACKGOURND_ICON(), q0());
            f.b bVar = this.depends;
            if (bVar != null) {
                bVar.f((RoundCornerLayout) itemView, position, coerceAtMost);
            } else {
                ui1.a.f439021a.a((RoundCornerLayout) itemView, position, coerceAtMost);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.mMediaDataArray.size(), q0());
        return coerceAtMost;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1001;
    }

    public final void setData(@NotNull List<? extends qj1.l> mixedMediaData) {
        int i3;
        Intrinsics.checkNotNullParameter(mixedMediaData, "mixedMediaData");
        if (mixedMediaData.isEmpty()) {
            return;
        }
        this.mMediaDataArray.clear();
        this.mMediaDataArray.addAll(mixedMediaData);
        f.b bVar = this.depends;
        if (bVar != null) {
            i3 = bVar.d(this.mMediaDataArray.size());
        } else {
            i3 = 3;
        }
        this.maxCol = i3;
        notifyDataSetChanged();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a3, code lost:
    
        if (r2 == false) goto L26;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(@NotNull GuildSimpleFeedItemImageViewHolder holder, final int position) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(holder, "holder");
        int i3 = this.maxCol * this.maxRow;
        if (position >= i3) {
            return;
        }
        qj1.l lVar = this.mMediaDataArray.get(position);
        Intrinsics.checkNotNullExpressionValue(lVar, "mMediaDataArray[position]");
        qj1.l lVar2 = lVar;
        int size = this.mMediaDataArray.size();
        o0(lVar2, holder.itemView);
        View findViewById = holder.itemView.findViewById(R.id.x0v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "holder.itemView.findView\u2026ple_feed_item_image_item)");
        z0(findViewById, position);
        if (position == i3 - 1 && size > i3) {
            holder.m().setText("\u5171" + size);
            holder.m().setVisibility(0);
        } else {
            holder.m().setVisibility(8);
        }
        ImageView p16 = holder.p();
        boolean z18 = true;
        if (lVar2.getType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        p16.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, p16)) == null) {
            p16.setVisibility(8);
        }
        View l3 = holder.l();
        if (lVar2.getType() == 3) {
            if (holder.m().getVisibility() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z18 = false;
        Boolean valueOf2 = Boolean.valueOf(z18);
        l3.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf2, l3)) == null) {
            l3.setVisibility(8);
        }
        t0(lVar2, holder, position);
        holder.o().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.adapter.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSimpleFeedItemImageAdapter.v0(GuildSimpleFeedItemImageAdapter.this, position, view);
            }
        });
        if (lVar2.getType() == 2) {
            holder.o().setContentDescription(QQGuildUIUtil.r(R.string.f158171ow));
        } else {
            holder.o().setContentDescription(QQGuildUIUtil.r(R.string.f146620uo));
        }
        f.b bVar = this.depends;
        if (bVar != null) {
            bVar.c(holder.o(), "em_sgrp_forum_full_screen");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public GuildSimpleFeedItemImageViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168183f90, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new GuildSimpleFeedItemImageViewHolder(itemView);
    }

    public final void y0(@NotNull o listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    public /* synthetic */ GuildSimpleFeedItemImageAdapter(f.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }

    public GuildSimpleFeedItemImageAdapter(@Nullable f.b bVar) {
        Lazy lazy;
        this.depends = bVar;
        this.mMediaDataArray = new ArrayList<>();
        this.maxRow = bVar != null ? bVar.getMaxRow() : 1;
        this.maxCol = 3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AbsGuildFeedMediaSizeUtils>() { // from class: com.tencent.mobileqq.guild.feed.adapter.GuildSimpleFeedItemImageAdapter$mediaSizeUtils$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AbsGuildFeedMediaSizeUtils invoke() {
                f.b bVar2;
                AbsGuildFeedMediaSizeUtils e16;
                bVar2 = GuildSimpleFeedItemImageAdapter.this.depends;
                return (bVar2 == null || (e16 = bVar2.e()) == null) ? GuildFeedMediaSizeUtils.f219296d : e16;
            }
        });
        this.mediaSizeUtils = lazy;
        this.imageSize = new com.tencent.mobileqq.guild.feed.feedsquare.utils.a(new MutablePropertyReference0Impl(this) { // from class: com.tencent.mobileqq.guild.feed.adapter.GuildSimpleFeedItemImageAdapter$imageSize$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                int i3;
                i3 = ((GuildSimpleFeedItemImageAdapter) this.receiver).maxCol;
                return Integer.valueOf(i3);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(@Nullable Object obj) {
                ((GuildSimpleFeedItemImageAdapter) this.receiver).maxCol = ((Number) obj).intValue();
            }
        }, ComputedKt.a(), new Function1<Integer, Pair<Integer, Integer>>() { // from class: com.tencent.mobileqq.guild.feed.adapter.GuildSimpleFeedItemImageAdapter$imageSize$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Pair<Integer, Integer> invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final Pair<Integer, Integer> invoke(int i3) {
                AbsGuildFeedMediaSizeUtils r06;
                r06 = GuildSimpleFeedItemImageAdapter.this.r0();
                int c16 = (int) ((r06.c() - (ViewUtils.dpToPx(3.0f) * (i3 - 1))) / i3);
                return new Pair<>(Integer.valueOf(c16), Integer.valueOf(c16));
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/adapter/GuildSimpleFeedItemImageAdapter$GuildSimpleFeedItemImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/TextView;", "E", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "itemImgText", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "p", "()Landroid/widget/ImageView;", "itemVideoIcon", "Landroid/view/View;", "G", "l", "()Landroid/view/View;", "itemGifLabel", "H", "o", "itemImgView", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class GuildSimpleFeedItemImageViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final Lazy itemImgText;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final Lazy itemVideoIcon;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final Lazy itemGifLabel;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final Lazy itemImgView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildSimpleFeedItemImageViewHolder(@NotNull final View itemView) {
            super(itemView);
            Lazy lazy;
            Lazy lazy2;
            Lazy lazy3;
            Lazy lazy4;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.feed.adapter.GuildSimpleFeedItemImageAdapter$GuildSimpleFeedItemImageViewHolder$itemImgText$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    return (TextView) itemView.findViewById(R.id.x0y);
                }
            });
            this.itemImgText = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.feed.adapter.GuildSimpleFeedItemImageAdapter$GuildSimpleFeedItemImageViewHolder$itemVideoIcon$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ImageView invoke() {
                    return (ImageView) itemView.findViewById(R.id.x0z);
                }
            });
            this.itemVideoIcon = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.guild.feed.adapter.GuildSimpleFeedItemImageAdapter$GuildSimpleFeedItemImageViewHolder$itemGifLabel$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final View invoke() {
                    return itemView.findViewById(R.id.w9p);
                }
            });
            this.itemGifLabel = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.feed.adapter.GuildSimpleFeedItemImageAdapter$GuildSimpleFeedItemImageViewHolder$itemImgView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ImageView invoke() {
                    return (ImageView) itemView.findViewById(R.id.x0x);
                }
            });
            this.itemImgView = lazy4;
        }

        @NotNull
        public final View l() {
            Object value = this.itemGifLabel.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-itemGifLabel>(...)");
            return (View) value;
        }

        @NotNull
        public final TextView m() {
            Object value = this.itemImgText.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-itemImgText>(...)");
            return (TextView) value;
        }

        @NotNull
        public final ImageView o() {
            Object value = this.itemImgView.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-itemImgView>(...)");
            return (ImageView) value;
        }

        @NotNull
        public final ImageView p() {
            Object value = this.itemVideoIcon.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-itemVideoIcon>(...)");
            return (ImageView) value;
        }

        @SuppressLint({"UseCompatLoadingForDrawables"})
        public final void q() {
        }
    }
}
