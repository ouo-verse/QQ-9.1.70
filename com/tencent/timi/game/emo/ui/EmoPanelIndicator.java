package com.tencent.timi.game.emo.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.emo.ui.EmoPanelIndicator;
import com.tencent.timi.game.utils.b;
import com.tencent.timi.game.utils.l;
import fh4.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 R2\u00020\u0001:\u0004STU\u001cB'\b\u0007\u0012\u0006\u0010L\u001a\u00020K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010O\u001a\u00020\u0006\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0014\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0006R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u00060'R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R$\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u001005j\b\u0012\u0004\u0012\u00020\u0010`68\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001c\u0010=\u001a\n ;*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010<R\u0014\u0010?\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010!R\u0016\u0010B\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0018\u0010J\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006V"}, d2 = {"Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator;", "Landroid/widget/FrameLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "y", "", "selectedItemViewPosLeft", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "r", "v", ReportConstant.COSTREPORT_PREFIX, "t", "u", "", "Lxg4/a;", "data", "setData", "Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator$c;", "l", "setItemClickListener", "", "leftMargin", "setIndicatorLeftMarin", "position", "setSelectedPos", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Landroid/view/View;", "e", "Landroid/view/View;", "mTouchConsumeView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "f", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mLayoutManager", "Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator$a;", h.F, "Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator$a;", "mAdapter", "i", UserInfo.SEX_FEMALE, "mSingleItemWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mSelectHintViewWidth", BdhLogUtil.LogTag.Tag_Conn, "mIndicatorLeftMargin", "D", "I", "mCurrentSelectedPos", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "mDataList", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "kotlin.jvm.PlatformType", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "defaultOpt", "G", "mSelectHintView", "H", "Z", "mAutoScrollAnimRunning", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mDelaySetSelectedPosTask", "J", "mDelaySmoothScrollTask", "K", "Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator$c;", "mItemClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class EmoPanelIndicator extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float mIndicatorLeftMargin;

    /* renamed from: D, reason: from kotlin metadata */
    private int mCurrentSelectedPos;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<xg4.a> mDataList;

    /* renamed from: F, reason: from kotlin metadata */
    private final URLDrawable.URLDrawableOptions defaultOpt;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final View mSelectHintView;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mAutoScrollAnimRunning;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Runnable mDelaySetSelectedPosTask;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Runnable mDelaySmoothScrollTask;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private c mItemClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView mRecyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mTouchConsumeView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayoutManager mLayoutManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mSingleItemWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mSelectHintViewWidth;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator$d;", "Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "j0", "getItemCount", "<init>", "(Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class a extends RecyclerView.Adapter<d> {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k0(EmoPanelIndicator this$0, d holder, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(holder, "$holder");
            this$0.mCurrentSelectedPos = holder.getAdapterPosition();
            c cVar = this$0.mItemClickListener;
            if (cVar != null) {
                cVar.c(this$0.mCurrentSelectedPos);
            }
            this$0.u();
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return EmoPanelIndicator.this.mDataList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull final d holder, int position) {
            boolean z16;
            Intrinsics.checkNotNullParameter(holder, "holder");
            Object obj = EmoPanelIndicator.this.mDataList.get(position);
            Intrinsics.checkNotNullExpressionValue(obj, "mDataList[position]");
            xg4.a aVar = (xg4.a) obj;
            if (aVar.getHintIconResId() != 0) {
                holder.getIconIgv().setImageResource(aVar.getHintIconResId());
            } else {
                if (aVar.getHintIconUrl().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    URLImageView iconIgv = holder.getIconIgv();
                    String hintIconUrl = aVar.getHintIconUrl();
                    URLDrawable.URLDrawableOptions defaultOpt = EmoPanelIndicator.this.defaultOpt;
                    Intrinsics.checkNotNullExpressionValue(defaultOpt, "defaultOpt");
                    b.g(iconIgv, hintIconUrl, defaultOpt);
                } else {
                    holder.getItem().setBackgroundResource(R.color.ajr);
                    l.e("EmoPanelIndicator_", "indicator hint icon is null! itemData:" + aVar + " ");
                }
            }
            View item = holder.getItem();
            final EmoPanelIndicator emoPanelIndicator = EmoPanelIndicator.this;
            item.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.emo.ui.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmoPanelIndicator.a.k0(EmoPanelIndicator.this, holder, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = View.inflate(EmoPanelIndicator.this.getContext(), R.layout.hty, null);
            EmoPanelIndicator emoPanelIndicator = EmoPanelIndicator.this;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new d(emoPanelIndicator, itemView);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator$c;", "", "", com.tencent.luggage.wxa.c8.c.G, "", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface c {
        void c(int pos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "E", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/image/URLImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/image/URLImageView;", "l", "()Lcom/tencent/image/URLImageView;", "iconIgv", "<init>", "(Lcom/tencent/timi/game/emo/ui/EmoPanelIndicator;Landroid/view/View;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View item;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final URLImageView iconIgv;
        final /* synthetic */ EmoPanelIndicator G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull EmoPanelIndicator emoPanelIndicator, View item) {
            super(item);
            Intrinsics.checkNotNullParameter(item, "item");
            this.G = emoPanelIndicator;
            this.item = item;
            View findViewById = item.findViewById(R.id.f165725xd4);
            Intrinsics.checkNotNullExpressionValue(findViewById, "item.findViewById(R.id.iconIgv)");
            this.iconIgv = (URLImageView) findViewById;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final URLImageView getIconIgv() {
            return this.iconIgv;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final View getItem() {
            return this.item;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/emo/ui/EmoPanelIndicator$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e extends RecyclerView.OnScrollListener {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                Runnable runnable = EmoPanelIndicator.this.mDelaySmoothScrollTask;
                if (runnable != null) {
                    runnable.run();
                }
                EmoPanelIndicator.this.mDelaySmoothScrollTask = null;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (!EmoPanelIndicator.this.mAutoScrollAnimRunning) {
                EmoPanelIndicator.this.mSelectHintView.setTranslationX(EmoPanelIndicator.this.mSelectHintView.getTranslationX() - dx5);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EmoPanelIndicator(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void o() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) getContext().getResources().getDimension(R.dimen.dfr));
        addView(this.mRecyclerView, layoutParams);
        addView(this.mTouchConsumeView, layoutParams);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.addOnScrollListener(new e());
        this.mTouchConsumeView.setOnClickListener(new View.OnClickListener() { // from class: zg4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoPanelIndicator.p(view);
            }
        });
        this.mTouchConsumeView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        l.i("EmoPanelIndicator_", "hh");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mSelectHintViewWidth, (int) getContext().getResources().getDimension(R.dimen.dfu));
        layoutParams.gravity = 16;
        addView(this.mSelectHintView, layoutParams);
    }

    private final boolean r() {
        if (v()) {
            return true;
        }
        View findViewByPosition = this.mLayoutManager.findViewByPosition(this.mCurrentSelectedPos);
        if (findViewByPosition == null) {
            l.e("EmoPanelIndicator_", "autoScroll selectedView is null");
            return false;
        }
        int[] iArr = new int[2];
        findViewByPosition.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.mRecyclerView.getLocationOnScreen(iArr2);
        int i3 = iArr[0];
        float f16 = i3;
        float f17 = this.mSingleItemWidth + f16;
        int i16 = iArr2[0];
        int width = this.mRecyclerView.getWidth() + i16;
        l.i("EmoPanelIndicator_", "autoScroll left:" + i3 + ", right:" + f17 + ", leftBorder:" + i16 + ", rightBorder:" + width);
        float f18 = (float) width;
        if (f17 > f18) {
            float f19 = f17 - f18;
            s();
            this.mRecyclerView.smoothScrollBy((int) f19, 0);
            z((int) (f16 - f19));
            return true;
        }
        if (i3 >= i16) {
            return false;
        }
        int i17 = i16 - i3;
        s();
        this.mRecyclerView.smoothScrollBy(-i17, 0);
        z(i3 + i17);
        return true;
    }

    private final void s() {
        this.mAutoScrollAnimRunning = true;
        this.mTouchConsumeView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        this.mAutoScrollAnimRunning = false;
        this.mTouchConsumeView.setVisibility(8);
        Runnable runnable = this.mDelaySetSelectedPosTask;
        if (runnable != null) {
            runnable.run();
        }
        this.mDelaySetSelectedPosTask = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        if (!r()) {
            y();
        }
    }

    private final boolean v() {
        float f16;
        float f17;
        int findFirstVisibleItemPosition = this.mLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.mLayoutManager.findLastVisibleItemPosition();
        l.b("EmoPanelIndicator_", "scrollToShowSelectedPos mCurrentSelectedPos:" + this.mCurrentSelectedPos + " firstVisiblePos:" + findFirstVisibleItemPosition + " lastVisiblePos:" + findLastVisibleItemPosition);
        int i3 = this.mCurrentSelectedPos;
        if (i3 < findFirstVisibleItemPosition) {
            f16 = i3 - findFirstVisibleItemPosition;
            f17 = this.mSingleItemWidth;
        } else {
            if (findLastVisibleItemPosition >= i3) {
                return false;
            }
            f16 = i3 - findLastVisibleItemPosition;
            f17 = this.mSingleItemWidth;
        }
        float f18 = f16 * f17;
        s();
        this.mDelaySmoothScrollTask = new Runnable() { // from class: zg4.c
            @Override // java.lang.Runnable
            public final void run() {
                EmoPanelIndicator.w(EmoPanelIndicator.this);
            }
        };
        this.mRecyclerView.smoothScrollBy((int) f18, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(EmoPanelIndicator this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(EmoPanelIndicator this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCurrentSelectedPos = i3;
        this$0.u();
    }

    private final void y() {
        View findViewByPosition = this.mLayoutManager.findViewByPosition(this.mCurrentSelectedPos);
        if (findViewByPosition == null) {
            l.e("EmoPanelIndicator_", "updateSelectHintViewPos selectedView is null");
        } else {
            this.mSelectHintView.setVisibility(0);
            z(g.h(findViewByPosition));
        }
    }

    private final void z(int selectedItemViewPosLeft) {
        s();
        float translationX = this.mSelectHintView.getTranslationX();
        float f16 = 2;
        float h16 = ((selectedItemViewPosLeft + (this.mSingleItemWidth / f16)) - (this.mSelectHintViewWidth / f16)) - g.h(this.mRecyclerView);
        l.i("EmoPanelIndicator_", "updateSelectHintViewPosReal mCurrentSelectedPos:" + this.mCurrentSelectedPos + ", currentTranX:" + translationX + ", targetTransX:" + h16 + ", selectedItemViewPosLeft:" + selectedItemViewPosLeft + ",  mRecyclerView.getLocationXOnScreen():" + g.h(this.mRecyclerView));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mSelectHintView, "translationX", translationX, h16);
        ofFloat.addListener(new f());
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    public final void setData(@NotNull List<xg4.a> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mDataList.clear();
        this.mDataList.addAll(data);
        this.mAdapter.notifyDataSetChanged();
        y();
    }

    public final void setIndicatorLeftMarin(float leftMargin) {
        this.mIndicatorLeftMargin = leftMargin;
    }

    public final void setItemClickListener(@NotNull c l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mItemClickListener = l3;
    }

    public final void setSelectedPos(final int position) {
        if (position >= 0 && position < this.mDataList.size()) {
            int i3 = this.mCurrentSelectedPos;
            if (position == i3) {
                l.e("EmoPanelIndicator_", "setSelectedPos position equal with current. mCurrentSelectedPos:" + i3 + ", position:" + position);
                return;
            }
            if (this.mAutoScrollAnimRunning) {
                this.mDelaySetSelectedPosTask = new Runnable() { // from class: zg4.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        EmoPanelIndicator.x(EmoPanelIndicator.this, position);
                    }
                };
                return;
            } else {
                this.mCurrentSelectedPos = position;
                u();
                return;
            }
        }
        l.e("EmoPanelIndicator_", "setSelectedPos bad position:" + position);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EmoPanelIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ EmoPanelIndicator(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EmoPanelIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDataList = new ArrayList<>();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        this.defaultOpt = obtain;
        this.mSingleItemWidth = context.getResources().getDimension(R.dimen.dft);
        this.mSelectHintViewWidth = context.getResources().getDimension(R.dimen.dfw);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.mLayoutManager = linearLayoutManager;
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setOverScrollMode(2);
        this.mRecyclerView = recyclerView;
        View view = new View(context);
        view.setBackgroundResource(R.color.ajr);
        this.mTouchConsumeView = view;
        this.mAdapter = new a();
        View view2 = new View(context);
        view2.setBackgroundResource(R.drawable.lrh);
        this.mSelectHintView = view2;
        q();
        o();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/emo/ui/EmoPanelIndicator$f", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f extends com.tencent.mobileqq.widget.f {
        f() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            EmoPanelIndicator.this.t();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
