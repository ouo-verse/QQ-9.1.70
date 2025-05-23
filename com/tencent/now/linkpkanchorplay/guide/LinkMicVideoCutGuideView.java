package com.tencent.now.linkpkanchorplay.guide;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.app.common.widget.BaseViewPager;
import com.tencent.now.linkpkanchorplay.guide.LinkMicVideoCutGuideView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "D0", "C0", "Lcom/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideView$a;", "d", "Lcom/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideView$a;", "getCallback", "()Lcom/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideView$a;", "callback", "Lcom/tencent/now/app/common/widget/BaseViewPager;", "e", "Lcom/tencent/now/app/common/widget/BaseViewPager;", "tabViewPager", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "viewPagerButton", "Lcom/tencent/now/linkpkanchorplay/guide/ViewPagerDotView;", h.F, "Lcom/tencent/now/linkpkanchorplay/guide/ViewPagerDotView;", "dotView", "Lim3/b;", "i", "Lim3/b;", "tabViewAdapter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideView$a;)V", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class LinkMicVideoCutGuideView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private BaseViewPager tabViewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView viewPagerButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewPagerDotView dotView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private im3.b tabViewAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideView$a;", "", "", NodeProps.ON_CLICK, "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface a {
        void onClick();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkMicVideoCutGuideView(@NotNull Context context, @NotNull a callback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        View.inflate(context, R.layout.h_y, this);
        View findViewById = findViewById(R.id.f916255o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tabViewPager)");
        this.tabViewPager = (BaseViewPager) findViewById;
        View findViewById2 = findViewById(R.id.f11847749);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.viewPager_dot_view)");
        this.dotView = (ViewPagerDotView) findViewById2;
        View findViewById3 = findViewById(R.id.f916355p);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tabViewPager_button)");
        TextView textView = (TextView) findViewById3;
        this.viewPagerButton = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: im3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinkMicVideoCutGuideView.A0(LinkMicVideoCutGuideView.this, view);
            }
        });
        D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(LinkMicVideoCutGuideView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C0() {
        this.callback.onClick();
    }

    private final void D0() {
        ArrayList arrayList = new ArrayList();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        arrayList.add(new VideoCutGuidePage(true, context));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        arrayList.add(new VideoCutGuidePage(false, context2));
        this.dotView.a(arrayList.size());
        im3.b bVar = new im3.b(arrayList);
        this.tabViewAdapter = bVar;
        this.tabViewPager.setAdapter(bVar);
        this.tabViewPager.addOnPageChangeListener(new b());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/now/linkpkanchorplay/guide/LinkMicVideoCutGuideView$b", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            LinkMicVideoCutGuideView.this.dotView.b(position);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
