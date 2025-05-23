package com.tencent.aelight.camera.ae.flashshow.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.light.LightConstants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\f*\u0001'\u0018\u0000 /2\u00020\u0001:\u000401\r\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b*\u0010+B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b*\u0010,B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010-\u001a\u00020\b\u00a2\u0006\u0004\b*\u0010.J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\f\u0010\u0013\u001a\u00020\b*\u00020\bH\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0014J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0006R\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001cR\u0016\u0010 \u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\"\u001a\u0004\b\u001e\u0010#\"\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010(\u00a8\u00062"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "f", "", "color", "", "cornerRadius", "Landroid/view/View;", "c", "itemSizePx", "Landroid/content/res/ColorStateList;", "textSizePx", "Landroidx/recyclerview/widget/RecyclerView;", "d", h.F, "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "position", "", LightConstants.DowngradeStrategyKey.SMOOTH, "setCurrentItem", "g", "Landroid/view/View;", "mHighlightBgView", "e", "Landroidx/recyclerview/widget/RecyclerView;", "mTabListView", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$b;", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$b;", "()Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$b;", "setTabSwitchListener", "(Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$b;)V", "tabSwitchListener", "com/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$f", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$f;", "mSlowScroller", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "b", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class FlashShowSwitchLayout extends FrameLayout {

    /* renamed from: d, reason: from kotlin metadata */
    private View mHighlightBgView;

    /* renamed from: e, reason: from kotlin metadata */
    private RecyclerView mTabListView;

    /* renamed from: f, reason: from kotlin metadata */
    private b tabSwitchListener;

    /* renamed from: h */
    private final f mSlowScroller;

    /* renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m */
    private static final int f65137m = R.color.qui_common_bg_bottom_light;
    private static final int C = R.color.qui_common_text_primary;
    private static final int D = R.color.qui_common_text_allwhite_primary;
    private static final String[] E = {"\u7167\u7247", "\u89c6\u9891"};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$a;", "", "", "", "TAB_ITEMS", "[Ljava/lang/String;", "a", "()[Ljava/lang/String;", "", "HIGHLIGHT_BG_HEIGHT_DP", "I", "HIGHLIGHT_BG_WIDTH_DP", "TAB_ITEM_SIZE_DP", "TEXT_SIZE_DP", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String[] a() {
            return FlashShowSwitchLayout.E;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$b;", "", "", "position", "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface b {
        void a(int position);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010#\u001a\u00020\u0005\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010 \u001a\u0004\b$\u0010\"\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$d;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/content/res/ColorStateList;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/res/ColorStateList;", "getColor", "()Landroid/content/res/ColorStateList;", "color", "", "D", UserInfo.SEX_FEMALE, "getTextSizePx", "()F", "textSizePx", "E", "I", "getTabWidthPx", "()I", "tabWidthPx", "getSelected", "k0", "(I)V", "selected", "<init>", "(Landroid/content/Context;Landroid/content/res/ColorStateList;FI)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c extends RecyclerView.Adapter<d> {

        /* renamed from: C */
        private final ColorStateList color;

        /* renamed from: D */
        private final float textSizePx;

        /* renamed from: E, reason: from kotlin metadata */
        private final int tabWidthPx;

        /* renamed from: F */
        private int selected;

        /* renamed from: m */
        private final Context context;

        public c(Context context, ColorStateList color, float f16, int i3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(color, "color");
            this.context = context;
            this.color = color;
            this.textSizePx = f16;
            this.tabWidthPx = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return FlashShowSwitchLayout.INSTANCE.a().length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0 */
        public void onBindViewHolder(d holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.getTextView().setText(FlashShowSwitchLayout.INSTANCE.a()[position]);
            holder.getTextView().setSelected(position == this.selected);
            holder.getTextView().setTextSize(14.0f);
            if (holder.getTextView().isSelected()) {
                holder.getTextView().setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                holder.getTextView().setTypeface(Typeface.DEFAULT);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0 */
        public d onCreateViewHolder(ViewGroup r46, int viewType) {
            Intrinsics.checkNotNullParameter(r46, "parent");
            TextView textView = new TextView(this.context);
            textView.setTextSize(0, this.textSizePx);
            textView.setTextColor(this.color);
            textView.setShadowLayer(1.5f, -1.0f, 1.0f, -3355444);
            textView.setGravity(17);
            textView.setLayoutParams(new RecyclerView.LayoutParams(this.tabWidthPx, -2));
            return new d(textView);
        }

        public final void k0(int i3) {
            this.selected = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "textView", "<init>", "(Landroid/widget/TextView;)V", UserInfo.SEX_FEMALE, "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: F */
        public static final Companion INSTANCE = new Companion(null);
        private static Function1<? super Integer, Unit> G;

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView textView;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR?\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$d$a;", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "listener", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "a", "(Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout$d$a */
        /* loaded from: classes32.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final void a(Function1<? super Integer, Unit> function1) {
                d.G = function1;
            }

            Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TextView textView) {
            super(textView);
            Intrinsics.checkNotNullParameter(textView, "textView");
            this.textView = textView;
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FlashShowSwitchLayout.d.m(FlashShowSwitchLayout.d.this, view);
                }
            });
        }

        public static final void m(d this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Function1<? super Integer, Unit> function1 = G;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(this$0.getAdapterPosition()));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* renamed from: o, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class e extends RecyclerView.OnScrollListener {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                RecyclerView recyclerView2 = FlashShowSwitchLayout.this.mTabListView;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTabListView");
                    recyclerView2 = null;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                RecyclerView recyclerView3 = FlashShowSwitchLayout.this.mTabListView;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTabListView");
                    recyclerView3 = null;
                }
                RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                if (adapter != null) {
                    c cVar = adapter instanceof c ? (c) adapter : null;
                    if (cVar != null) {
                        cVar.k0(findFirstVisibleItemPosition);
                        cVar.notifyDataSetChanged();
                    }
                }
                b tabSwitchListener = FlashShowSwitchLayout.this.getTabSwitchListener();
                if (tabSwitchListener != null) {
                    tabSwitchListener.a(findFirstVisibleItemPosition);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/view/FlashShowSwitchLayout$f", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class f extends LinearSmoothScroller {
        f(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return super.calculateSpeedPerPixel(displayMetrics) * 5;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlashShowSwitchLayout(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final View c(Context context, int color, float cornerRadius) {
        View view = new View(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(cornerRadius);
        gradientDrawable.setColor(color);
        ViewCompat.setBackground(view, gradientDrawable);
        return view;
    }

    private final RecyclerView d(Context context, int itemSizePx, ColorStateList color, float textSizePx) {
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.setAdapter(new c(context, color, textSizePx, itemSizePx));
        String[] strArr = E;
        recyclerView.setPadding((strArr.length - 1) * itemSizePx, 0, itemSizePx * (strArr.length - 1), 0);
        new LinearSnapHelper().attachToRecyclerView(recyclerView);
        recyclerView.setClipToPadding(false);
        recyclerView.addOnScrollListener(new e());
        return recyclerView;
    }

    private final void f(Context context, AttributeSet r112) {
        View c16 = c(context, context.getColor(f65137m), h(28));
        this.mHighlightBgView = c16;
        RecyclerView recyclerView = null;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHighlightBgView");
            c16 = null;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h(48), h(28));
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        addView(c16, layoutParams);
        RecyclerView d16 = d(context, h(45), new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{context.getColor(C), context.getColor(D)}), h(14));
        this.mTabListView = d16;
        if (d16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabListView");
        } else {
            recyclerView = d16;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        addView(recyclerView, layoutParams2);
        d.INSTANCE.a(new Function1<Integer, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.view.FlashShowSwitchLayout$init$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                FlashShowSwitchLayout.this.setCurrentItem(i3, true);
            }
        });
    }

    /* renamed from: e, reason: from getter */
    public final b getTabSwitchListener() {
        return this.tabSwitchListener;
    }

    public final void g() {
        d.INSTANCE.a(null);
    }

    public final void setTabSwitchListener(b bVar) {
        this.tabSwitchListener = bVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlashShowSwitchLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int h(int i3) {
        return (int) TypedValue.applyDimension(1, i3, getResources().getDisplayMetrics());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashShowSwitchLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSlowScroller = new f(getContext());
        f(context, attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(h(45) * ((E.length * 2) - 1), 1073741824), heightMeasureSpec);
    }

    public final void setCurrentItem(int position, boolean r65) {
        if (position == -1) {
            return;
        }
        RecyclerView recyclerView = this.mTabListView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabListView");
            recyclerView = null;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        c cVar = adapter instanceof c ? (c) adapter : null;
        if (cVar != null) {
            cVar.k0(position);
            cVar.notifyDataSetChanged();
        }
        if (r65) {
            this.mSlowScroller.setTargetPosition(position);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.startSmoothScroll(this.mSlowScroller);
                return;
            }
            return;
        }
        recyclerView.scrollToPosition(position);
        b bVar = this.tabSwitchListener;
        if (bVar != null) {
            bVar.a(position);
        }
    }

    public static /* synthetic */ void setCurrentItem$default(FlashShowSwitchLayout flashShowSwitchLayout, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        flashShowSwitchLayout.setCurrentItem(i3, z16);
    }
}
