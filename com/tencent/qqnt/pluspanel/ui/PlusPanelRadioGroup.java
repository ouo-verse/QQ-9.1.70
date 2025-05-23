package com.tencent.qqnt.pluspanel.ui;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ \u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/pluspanel/ui/PlusPanelRadioGroup;", "Landroid/widget/LinearLayout;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroid/view/View;", "a", "", "selectPos", "", "d", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "b", "position", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "count", "c", "Landroidx/viewpager/widget/ViewPager;", "e", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "mOnPageChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PlusPanelRadioGroup extends LinearLayout implements ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager viewPager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager.OnPageChangeListener mOnPageChangeListener;

    public PlusPanelRadioGroup(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    private final View a() {
        View view = new View(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(8.0f)));
        return view;
    }

    private final void d(int selectPos) {
        GradientDrawable gradientDrawable;
        int dpToPx;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int childCount = getChildCount();
        float dpToPx2 = ViewUtils.dpToPx(4.0f);
        for (int i3 = 0; i3 < childCount; i3++) {
            if (i3 == selectPos) {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(getResources().getColorStateList(R.color.qui_common_fill_standard_quaternary));
                gradientDrawable.setCornerRadius(dpToPx2);
            } else {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(getResources().getColorStateList(R.color.qui_common_fill_standard_primary));
                gradientDrawable.setCornerRadius(dpToPx2);
            }
            if (i3 == childCount - 1) {
                dpToPx = 0;
            } else {
                dpToPx = ViewUtils.dpToPx(8.0f);
            }
            View childAt = getChildAt(i3);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = null;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.rightMargin = dpToPx;
                }
                childAt.setBackground(gradientDrawable);
            }
        }
        requestLayout();
    }

    public final void b(@Nullable ViewPager viewPager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewPager);
            return;
        }
        this.viewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(this);
        }
    }

    public final void c(int count) {
        int i3;
        ViewPager viewPager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, count);
            return;
        }
        removeAllViews();
        int childCount = getChildCount();
        if (count > childCount) {
            int i16 = count - childCount;
            for (int i17 = 0; i17 < i16; i17++) {
                addView(a());
            }
        } else if (count < childCount && count <= childCount - 1) {
            while (true) {
                removeViewAt(i3);
                if (i3 == count) {
                    break;
                } else {
                    i3--;
                }
            }
        }
        if (count > 0 && (viewPager = this.viewPager) != null) {
            Intrinsics.checkNotNull(viewPager);
            d(viewPager.getCurrentItem());
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, state);
            return;
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            Intrinsics.checkNotNull(onPageChangeListener);
            onPageChangeListener.onPageScrollStateChanged(state);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), Float.valueOf(positionOffset), Integer.valueOf(positionOffsetPixels));
            return;
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            Intrinsics.checkNotNull(onPageChangeListener);
            onPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, position);
            return;
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            Intrinsics.checkNotNull(onPageChangeListener);
            onPageChangeListener.onPageSelected(position);
        }
        if (getChildCount() <= position) {
            return;
        }
        if (position >= getChildCount()) {
            position = getChildCount() - 1;
        }
        d(position);
    }
}
