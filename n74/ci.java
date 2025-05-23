package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleViewPagerTitleInner;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ci implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f419012a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419013b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f419014c;

    /* renamed from: d, reason: collision with root package name */
    public final ZootopiaLoadFailView f419015d;

    /* renamed from: e, reason: collision with root package name */
    public final View f419016e;

    /* renamed from: f, reason: collision with root package name */
    public final View f419017f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewPager f419018g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f419019h;

    /* renamed from: i, reason: collision with root package name */
    public final SameStyleViewPagerTitleInner f419020i;

    /* renamed from: j, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419021j;

    /* renamed from: k, reason: collision with root package name */
    public final HorizontalScrollView f419022k;

    ci(LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout, ZootopiaLoadFailView zootopiaLoadFailView, View view, View view2, ViewPager viewPager, FrameLayout frameLayout2, SameStyleViewPagerTitleInner sameStyleViewPagerTitleInner, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, HorizontalScrollView horizontalScrollView) {
        this.f419012a = linearLayout;
        this.f419013b = imageView;
        this.f419014c = frameLayout;
        this.f419015d = zootopiaLoadFailView;
        this.f419016e = view;
        this.f419017f = view2;
        this.f419018g = viewPager;
        this.f419019h = frameLayout2;
        this.f419020i = sameStyleViewPagerTitleInner;
        this.f419021j = zplanExcludeFontPaddingTextView;
        this.f419022k = horizontalScrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f419012a;
    }

    public static ci e(View view) {
        int i3 = R.id.pk7;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pk7);
        if (imageView != null) {
            i3 = R.id.f163345pm4;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f163345pm4);
            if (frameLayout != null) {
                i3 = R.id.psq;
                ZootopiaLoadFailView zootopiaLoadFailView = (ZootopiaLoadFailView) ViewBindings.findChildViewById(view, R.id.psq);
                if (zootopiaLoadFailView != null) {
                    i3 = R.id.q4o;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.q4o);
                    if (findChildViewById != null) {
                        i3 = R.id.qhp;
                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.qhp);
                        if (findChildViewById2 != null) {
                            i3 = R.id.qix;
                            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.qix);
                            if (viewPager != null) {
                                i3 = R.id.qr7;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qr7);
                                if (frameLayout2 != null) {
                                    i3 = R.id.qre;
                                    SameStyleViewPagerTitleInner sameStyleViewPagerTitleInner = (SameStyleViewPagerTitleInner) ViewBindings.findChildViewById(view, R.id.qre);
                                    if (sameStyleViewPagerTitleInner != null) {
                                        i3 = R.id.qrj;
                                        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.qrj);
                                        if (zplanExcludeFontPaddingTextView != null) {
                                            i3 = R.id.qyf;
                                            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.qyf);
                                            if (horizontalScrollView != null) {
                                                return new ci((LinearLayout) view, imageView, frameLayout, zootopiaLoadFailView, findChildViewById, findChildViewById2, viewPager, frameLayout2, sameStyleViewPagerTitleInner, zplanExcludeFontPaddingTextView, horizontalScrollView);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ci g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.del, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
