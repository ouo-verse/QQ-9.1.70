package com.tencent.mobileqq.wink.index;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.index.PageTabLayout;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 B2\u00020\u0001:\u0004CDE\u001dB'\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\u0006\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u001c\u0010\u0012\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\u000fJ\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0014R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010'\u001a\f\u0012\b\u0012\u00060%R\u00020\u00000$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001eR\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001c\u00105\u001a\b\u0018\u000102R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/wink/index/PageTabLayout;", "Landroid/widget/FrameLayout;", "", "k", "j", "l", "", "index", "", "needScroll", "forceSelect", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "position", DomainData.DOMAIN_NAME, "", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "pages", "selectIndex", "setPages", "Lcom/tencent/mobileqq/wink/index/PageTabLayout$b;", "callback", "setTabSelectCallback", "targetPage", "p", "Landroid/view/View;", "i", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "d", "Ljava/util/List;", "e", "Lkotlin/Lazy;", tl.h.F, "()Ljava/util/List;", "fixTabResIds", "", "Lcom/tencent/mobileqq/wink/index/PageTabLayout$d;", "f", "fixTabs", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "tabRecyclerView", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "tabLinerLayoutManager", "Landroidx/recyclerview/widget/LinearSnapHelper;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/LinearSnapHelper;", "linearSnapHelper", "Lcom/tencent/mobileqq/wink/index/PageTabLayout$c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/index/PageTabLayout$c;", "tabLayoutAdapter", "D", "I", "currentIndex", "E", "Lcom/tencent/mobileqq/wink/index/PageTabLayout$b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "b", "c", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PageTabLayout extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private c tabLayoutAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private int currentIndex;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private b callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<? extends QQWinkPage> pages;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy fixTabResIds;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d> fixTabs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView tabRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayoutManager tabLinerLayoutManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearSnapHelper linearSnapHelper;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/index/PageTabLayout$b;", "", "", "index", "", "f", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void f(int index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001c\u0010\r\u001a\u00020\u00062\n\u0010\f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/index/PageTabLayout$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/index/PageTabLayout$d;", "Lcom/tencent/mobileqq/wink/index/PageTabLayout;", "", "position", "", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "j0", "holder", "i0", "getItemCount", "<init>", "(Lcom/tencent/mobileqq/wink/index/PageTabLayout;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class c extends RecyclerView.Adapter<d> {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List list = PageTabLayout.this.pages;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pages");
                list = null;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            List list = PageTabLayout.this.pages;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pages");
                list = null;
            }
            holder.m((QQWinkPage) list.get(position), position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.h7o, parent, false);
            PageTabLayout pageTabLayout = PageTabLayout.this;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new d(pageTabLayout, view);
        }

        public final void k0(int position) {
            if (position >= 0) {
                List list = PageTabLayout.this.pages;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pages");
                    list = null;
                }
                if (position < list.size()) {
                    notifyDataSetChanged();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/index/PageTabLayout$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "page", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "tabName", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/index/PageTabLayout;Landroid/view/View;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView tabName;
        final /* synthetic */ PageTabLayout F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull PageTabLayout pageTabLayout, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.F = pageTabLayout;
            View findViewById = itemView.findViewById(R.id.j_q);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tab_name)");
            this.tabName = (TextView) findViewById;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(PageTabLayout this$0, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.q(i3, true, false);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull QQWinkPage page, final int position) {
            Intrinsics.checkNotNullParameter(page, "page");
            this.tabName.setText(page.getPageName());
            o(position);
            View view = this.itemView;
            final PageTabLayout pageTabLayout = this.F;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.index.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PageTabLayout.d.n(PageTabLayout.this, position, view2);
                }
            });
        }

        public final void o(int position) {
            boolean z16;
            if (this.F.currentIndex == position) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.tabName.setSelected(z16);
            if (z16) {
                this.tabName.setTextSize(1, 17.0f);
                this.tabName.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.tabName.setTextSize(1, 16.0f);
                this.tabName.setTypeface(Typeface.defaultFromStyle(0));
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/index/PageTabLayout$e", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "v", "Landroidx/recyclerview/widget/RecyclerView;", "p", "Landroidx/recyclerview/widget/RecyclerView$State;", ReportConstant.COSTREPORT_PREFIX, "", "getItemOffsets", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f322905d;

        e(int i3) {
            this.f322905d = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View v3, @NotNull RecyclerView p16, @NotNull RecyclerView.State s16) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(p16, "p");
            Intrinsics.checkNotNullParameter(s16, "s");
            outRect.right = this.f322905d;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/index/PageTabLayout$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends RecyclerView.OnScrollListener {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            LinearSnapHelper linearSnapHelper;
            View findSnapView;
            PageTabLayout pageTabLayout;
            LinearLayoutManager linearLayoutManager;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0 && (linearSnapHelper = PageTabLayout.this.linearSnapHelper) != null && (findSnapView = linearSnapHelper.findSnapView(PageTabLayout.this.tabLinerLayoutManager)) != null && (linearLayoutManager = (pageTabLayout = PageTabLayout.this).tabLinerLayoutManager) != null) {
                pageTabLayout.q(linearLayoutManager.getPosition(findSnapView), false, false);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/index/PageTabLayout$g", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView f322908e;

        g(RecyclerView recyclerView) {
            this.f322908e = recyclerView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PageTabLayout.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int width = this.f322908e.getWidth() / 2;
            this.f322908e.setPadding(width, 0, width, 0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PageTabLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final List<Integer> h() {
        return (List) this.fixTabResIds.getValue();
    }

    private final void j() {
        int i3;
        List<? extends QQWinkPage> list = this.pages;
        List<? extends QQWinkPage> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pages");
            list = null;
        }
        if (list.size() == 3) {
            i3 = R.layout.h7p;
        } else {
            i3 = R.layout.h7q;
        }
        int i16 = 0;
        View inflate = LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) this, false);
        List<? extends QQWinkPage> list3 = this.pages;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pages");
        } else {
            list2 = list3;
        }
        for (Object obj : list2) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            List<d> list4 = this.fixTabs;
            View findViewById = inflate.findViewById(h().get(i16).intValue());
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(fixTabResIds[index])");
            d dVar = new d(this, findViewById);
            dVar.m((QQWinkPage) obj, i16);
            list4.add(dVar);
            i16 = i17;
        }
        addView(inflate, new FrameLayout.LayoutParams(-1, -1));
    }

    private final void k() {
        List<? extends QQWinkPage> list = this.pages;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pages");
            list = null;
        }
        if (list.size() <= 3) {
            j();
        } else {
            l();
        }
    }

    private final void l() {
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setClipToPadding(false);
        recyclerView.addItemDecoration(new e(ViewExKt.d(8)));
        recyclerView.addOnScrollListener(new f());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 0, false);
        this.tabLinerLayoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        c cVar = new c();
        this.tabLayoutAdapter = cVar;
        recyclerView.setAdapter(cVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(recyclerView, layoutParams);
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new g(recyclerView));
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(recyclerView);
        this.linearSnapHelper = linearSnapHelper;
        this.tabRecyclerView = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(RecyclerView this_run, PageTabLayout this$0) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int width = this_run.getWidth() / 2;
        this_run.setPadding(width, 0, width, 0);
        int i3 = this$0.currentIndex;
        if (i3 != -1) {
            this_run.scrollToPosition(i3);
        }
    }

    private final void n(final int position) {
        final RecyclerView recyclerView = this.tabRecyclerView;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.index.b
                @Override // java.lang.Runnable
                public final void run() {
                    PageTabLayout.o(PageTabLayout.this, position, recyclerView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        r1 = kotlin.collections.ArraysKt___ArraysKt.firstOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void o(PageTabLayout this$0, int i3, RecyclerView this_run) {
        View findViewByPosition;
        LinearSnapHelper linearSnapHelper;
        Integer firstOrNull;
        int intValue;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        LinearLayoutManager linearLayoutManager = this$0.tabLinerLayoutManager;
        if (linearLayoutManager != null && (findViewByPosition = linearLayoutManager.findViewByPosition(i3)) != null && (linearSnapHelper = this$0.linearSnapHelper) != null && (r1 = linearSnapHelper.calculateDistanceToFinalSnap(linearLayoutManager, findViewByPosition)) != null && firstOrNull != null && (intValue = firstOrNull.intValue()) != 0) {
            this_run.scrollBy(intValue, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int index, boolean needScroll, boolean forceSelect) {
        if ((forceSelect || index != this.currentIndex) && index >= 0) {
            List<? extends QQWinkPage> list = this.pages;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pages");
                list = null;
            }
            if (index < list.size()) {
                this.currentIndex = index;
                if (needScroll) {
                    n(index);
                }
                c cVar = this.tabLayoutAdapter;
                if (cVar != null) {
                    cVar.k0(index);
                }
                int i3 = 0;
                for (Object obj : this.fixTabs) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    ((d) obj).o(i3);
                    i3 = i16;
                }
                b bVar = this.callback;
                if (bVar != null) {
                    bVar.f(index);
                }
            }
        }
    }

    @Nullable
    public final View i(@NotNull QQWinkPage targetPage) {
        Object orNull;
        View findViewByPosition;
        Intrinsics.checkNotNullParameter(targetPage, "targetPage");
        List<? extends QQWinkPage> list = this.pages;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pages");
            list = null;
        }
        int indexOf = list.indexOf(targetPage);
        if (indexOf == -1) {
            return null;
        }
        LinearLayoutManager linearLayoutManager = this.tabLinerLayoutManager;
        if (linearLayoutManager == null || (findViewByPosition = linearLayoutManager.findViewByPosition(indexOf)) == null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.fixTabs, indexOf);
            d dVar = (d) orNull;
            if (dVar == null) {
                return null;
            }
            return dVar.itemView;
        }
        return findViewByPosition;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        final RecyclerView recyclerView = this.tabRecyclerView;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.index.a
                @Override // java.lang.Runnable
                public final void run() {
                    PageTabLayout.m(RecyclerView.this, this);
                }
            });
        }
    }

    public final void p(@NotNull QQWinkPage targetPage) {
        Intrinsics.checkNotNullParameter(targetPage, "targetPage");
        List<? extends QQWinkPage> list = this.pages;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pages");
            list = null;
        }
        int indexOf = list.indexOf(targetPage);
        if (indexOf != -1) {
            q(indexOf, true, true);
        }
    }

    public final void setPages(@NotNull List<? extends QQWinkPage> pages, int selectIndex) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        if (pages.size() <= 1) {
            return;
        }
        this.pages = pages;
        k();
        q(selectIndex, true, false);
    }

    public final void setTabSelectCallback(@Nullable b callback) {
        this.callback = callback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PageTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PageTabLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PageTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends Integer>>() { // from class: com.tencent.mobileqq.wink.index.PageTabLayout$fixTabResIds$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends Integer> invoke() {
                List<? extends Integer> listOf;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.f915455g), Integer.valueOf(R.id.f915555h), Integer.valueOf(R.id.f915655i)});
                return listOf;
            }
        });
        this.fixTabResIds = lazy;
        this.fixTabs = new ArrayList();
        this.currentIndex = -1;
    }
}
