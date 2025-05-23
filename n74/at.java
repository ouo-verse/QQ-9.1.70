package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.card.view.ZootopiaDoublePraiseView;
import com.tencent.sqshow.zootopia.card.view.widget.ZootopiaDoubleClickLayout;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressSquareDetailDesView;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressSquareDetailOperationView;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.SimpleCircleIndicator;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class at implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f418735a;

    /* renamed from: b, reason: collision with root package name */
    public final SimpleCircleIndicator f418736b;

    /* renamed from: c, reason: collision with root package name */
    public final DressSquareDetailDesView f418737c;

    /* renamed from: d, reason: collision with root package name */
    public final DressSquareDetailOperationView f418738d;

    /* renamed from: e, reason: collision with root package name */
    public final ZootopiaDoubleClickLayout f418739e;

    /* renamed from: f, reason: collision with root package name */
    public final ZootopiaDoublePraiseView f418740f;

    /* renamed from: g, reason: collision with root package name */
    public final RelativeLayout f418741g;

    /* renamed from: h, reason: collision with root package name */
    public final av f418742h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f418743i;

    /* renamed from: j, reason: collision with root package name */
    public final ax f418744j;

    /* renamed from: k, reason: collision with root package name */
    public final ViewPager f418745k;

    at(RelativeLayout relativeLayout, SimpleCircleIndicator simpleCircleIndicator, DressSquareDetailDesView dressSquareDetailDesView, DressSquareDetailOperationView dressSquareDetailOperationView, ZootopiaDoubleClickLayout zootopiaDoubleClickLayout, ZootopiaDoublePraiseView zootopiaDoublePraiseView, RelativeLayout relativeLayout2, av avVar, TextView textView, ax axVar, ViewPager viewPager) {
        this.f418735a = relativeLayout;
        this.f418736b = simpleCircleIndicator;
        this.f418737c = dressSquareDetailDesView;
        this.f418738d = dressSquareDetailOperationView;
        this.f418739e = zootopiaDoubleClickLayout;
        this.f418740f = zootopiaDoublePraiseView;
        this.f418741g = relativeLayout2;
        this.f418742h = avVar;
        this.f418743i = textView;
        this.f418744j = axVar;
        this.f418745k = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getMRv() {
        return this.f418735a;
    }

    public static at g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static at e(View view) {
        int i3 = R.id.pjz;
        SimpleCircleIndicator simpleCircleIndicator = (SimpleCircleIndicator) ViewBindings.findChildViewById(view, R.id.pjz);
        if (simpleCircleIndicator != null) {
            i3 = R.id.pou;
            DressSquareDetailDesView dressSquareDetailDesView = (DressSquareDetailDesView) ViewBindings.findChildViewById(view, R.id.pou);
            if (dressSquareDetailDesView != null) {
                i3 = R.id.f163471qa4;
                DressSquareDetailOperationView dressSquareDetailOperationView = (DressSquareDetailOperationView) ViewBindings.findChildViewById(view, R.id.f163471qa4);
                if (dressSquareDetailOperationView != null) {
                    i3 = R.id.qde;
                    ZootopiaDoubleClickLayout zootopiaDoubleClickLayout = (ZootopiaDoubleClickLayout) ViewBindings.findChildViewById(view, R.id.qde);
                    if (zootopiaDoubleClickLayout != null) {
                        i3 = R.id.qdf;
                        ZootopiaDoublePraiseView zootopiaDoublePraiseView = (ZootopiaDoublePraiseView) ViewBindings.findChildViewById(view, R.id.qdf);
                        if (zootopiaDoublePraiseView != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view;
                            i3 = R.id.qmv;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.qmv);
                            if (findChildViewById != null) {
                                av e16 = av.e(findChildViewById);
                                i3 = R.id.qqh;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qqh);
                                if (textView != null) {
                                    i3 = R.id.qyb;
                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.qyb);
                                    if (findChildViewById2 != null) {
                                        ax e17 = ax.e(findChildViewById2);
                                        i3 = R.id.qyg;
                                        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.qyg);
                                        if (viewPager != null) {
                                            return new at(relativeLayout, simpleCircleIndicator, dressSquareDetailDesView, dressSquareDetailOperationView, zootopiaDoubleClickLayout, zootopiaDoublePraiseView, relativeLayout, e16, textView, e17, viewPager);
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

    public static at h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dbh, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
