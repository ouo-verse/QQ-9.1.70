package com.tencent.mobileqq.zplan.aigc.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.aigc.data.AIGCModelRenderTask;
import com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u0001\u0005B\u0019\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u00100\u001a\u0004\u0018\u00010/\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0004JB\u0010\u0015\u001a\u00020\u00042\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u000bj\b\u0012\u0004\u0012\u00020\u001a`\rR$\u0010!\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010#R\u0016\u0010&\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010'R\u001c\u0010,\u001a\b\u0018\u00010)R\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/AIGCViewPagerWithIndicator;", "Landroid/widget/LinearLayout;", "", "count", "", "b", "position", h.F, "f", "c", "g", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "Lkotlin/collections/ArrayList;", "renderList", "Landroid/graphics/Bitmap;", "modelBitmap", "", "needAnimation", "Lzd3/a;", "reporter", "setData", "Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$c;", "listener", "setOnItemClickListener", "e", "Landroid/view/View;", "d", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "setDtReporter", "(Lzd3/a;)V", "dtReporter", "Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager;", "Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager;", "viewPager", "Landroid/widget/LinearLayout;", "indicatorLayout", "Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$c;", "itemClickCallback", "Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$d;", "i", "Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$d;", "viewPagerAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AIGCViewPagerWithIndicator extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private zd3.a dtReporter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AIGCGridViewPager viewPager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout indicatorLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AIGCGridViewPager.c itemClickCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AIGCGridViewPager.d viewPagerAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIGCViewPagerWithIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.dfx, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.qye);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.viewPager)");
        this.viewPager = (AIGCGridViewPager) findViewById;
        View findViewById2 = findViewById(R.id.q1w);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.indicatorLayout)");
        this.indicatorLayout = (LinearLayout) findViewById2;
        AIGCGridViewPager aIGCGridViewPager = this.viewPager;
        if (aIGCGridViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            aIGCGridViewPager = null;
        }
        aIGCGridViewPager.addOnPageChangeListener(new a());
    }

    private final void b(int count) {
        LinearLayout linearLayout = this.indicatorLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorLayout");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        for (int i3 = 0; i3 < count; i3++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.drawable.i6c);
            ViewCompat.setElevation(imageView, 10.0f);
            LinearLayout linearLayout2 = this.indicatorLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicatorLayout");
                linearLayout2 = null;
            }
            linearLayout2.addView(imageView);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = 20;
            layoutParams.height = 20;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = 10;
            imageView.setLayoutParams(layoutParams);
            h(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int position) {
        LinearLayout linearLayout = this.indicatorLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorLayout");
            linearLayout = null;
        }
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            LinearLayout linearLayout2 = this.indicatorLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicatorLayout");
                linearLayout2 = null;
            }
            View childAt = linearLayout2.getChildAt(i3);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) childAt;
            if (i3 == position) {
                imageView.setImageResource(R.drawable.i6c);
            } else {
                imageView.setImageResource(R.drawable.i6f);
            }
        }
    }

    public final int c() {
        AIGCGridViewPager aIGCGridViewPager = this.viewPager;
        if (aIGCGridViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            aIGCGridViewPager = null;
        }
        return aIGCGridViewPager.getCurrentItem();
    }

    public final ArrayList<View> d() {
        new ArrayList();
        if (this.viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        AIGCGridViewPager aIGCGridViewPager = this.viewPager;
        if (aIGCGridViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            aIGCGridViewPager = null;
        }
        return aIGCGridViewPager.b();
    }

    public final void e() {
        AIGCGridViewPager aIGCGridViewPager = this.viewPager;
        if (aIGCGridViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            aIGCGridViewPager = null;
        }
        aIGCGridViewPager.setAdapter(null);
    }

    public final void f() {
        AIGCGridViewPager aIGCGridViewPager = this.viewPager;
        if (aIGCGridViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            aIGCGridViewPager = null;
        }
        aIGCGridViewPager.c();
    }

    public final void g() {
        AIGCGridViewPager aIGCGridViewPager = this.viewPager;
        AIGCGridViewPager aIGCGridViewPager2 = null;
        if (aIGCGridViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            aIGCGridViewPager = null;
        }
        int currentItem = aIGCGridViewPager.getCurrentItem();
        AIGCGridViewPager aIGCGridViewPager3 = this.viewPager;
        if (aIGCGridViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            aIGCGridViewPager3 = null;
        }
        PagerAdapter adapter = aIGCGridViewPager3.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.MyPagerAdapter");
        int f373114d = (currentItem + 1) % ((AIGCGridViewPager.d) adapter).getF373114d();
        QLog.e("GridViewPager3", 1, "turnToNextPage nextPage " + f373114d + " ~~~~");
        AIGCGridViewPager aIGCGridViewPager4 = this.viewPager;
        if (aIGCGridViewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            aIGCGridViewPager2 = aIGCGridViewPager4;
        }
        aIGCGridViewPager2.setCurrentItem(f373114d, true);
    }

    public final void setDtReporter(zd3.a aVar) {
        this.dtReporter = aVar;
    }

    public final void setOnItemClickListener(AIGCGridViewPager.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemClickCallback = listener;
        AIGCGridViewPager.d dVar = this.viewPagerAdapter;
        if (dVar == null) {
            return;
        }
        dVar.j(listener);
    }

    public final void setData(ArrayList<AIGCModelRenderTask> renderList, Bitmap modelBitmap, boolean needAnimation, zd3.a reporter) {
        if (renderList != null) {
            if (this.viewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            }
            AIGCGridViewPager aIGCGridViewPager = this.viewPager;
            LinearLayout linearLayout = null;
            if (aIGCGridViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                aIGCGridViewPager = null;
            }
            if (aIGCGridViewPager.getAdapter() == null) {
                return;
            }
            AIGCGridViewPager aIGCGridViewPager2 = this.viewPager;
            if (aIGCGridViewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                aIGCGridViewPager2 = null;
            }
            aIGCGridViewPager2.setData(renderList, modelBitmap, needAnimation, reporter);
            AIGCGridViewPager aIGCGridViewPager3 = this.viewPager;
            if (aIGCGridViewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                aIGCGridViewPager3 = null;
            }
            PagerAdapter adapter = aIGCGridViewPager3.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.MyPagerAdapter");
            this.viewPagerAdapter = (AIGCGridViewPager.d) adapter;
            b(renderList.size() / 4);
            AIGCGridViewPager.d dVar = this.viewPagerAdapter;
            Intrinsics.checkNotNull(dVar);
            if (dVar.getF373114d() <= 1 && renderList.size() <= 4) {
                LinearLayout linearLayout2 = this.indicatorLayout;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("indicatorLayout");
                } else {
                    linearLayout = linearLayout2;
                }
                linearLayout.setVisibility(4);
                return;
            }
            LinearLayout linearLayout3 = this.indicatorLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicatorLayout");
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.setVisibility(0);
        }
    }

    public static /* synthetic */ void setData$default(AIGCViewPagerWithIndicator aIGCViewPagerWithIndicator, ArrayList arrayList, Bitmap bitmap, boolean z16, zd3.a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            aVar = null;
        }
        aIGCViewPagerWithIndicator.setData(arrayList, bitmap, z16, aVar);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/aigc/view/AIGCViewPagerWithIndicator$a", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            AIGCViewPagerWithIndicator.this.h(position);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
