package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressSquareDetailHeaderView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ay implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f418769a;

    /* renamed from: b, reason: collision with root package name */
    public final av f418770b;

    /* renamed from: c, reason: collision with root package name */
    public final DressSquareDetailHeaderView f418771c;

    /* renamed from: d, reason: collision with root package name */
    public final az f418772d;

    /* renamed from: e, reason: collision with root package name */
    public final QFSPullRefreshLayout f418773e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f418774f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f418775g;

    /* renamed from: h, reason: collision with root package name */
    public final ViewPager2 f418776h;

    ay(RelativeLayout relativeLayout, av avVar, DressSquareDetailHeaderView dressSquareDetailHeaderView, az azVar, QFSPullRefreshLayout qFSPullRefreshLayout, ImageView imageView, ImageView imageView2, ViewPager2 viewPager2) {
        this.f418769a = relativeLayout;
        this.f418770b = avVar;
        this.f418771c = dressSquareDetailHeaderView;
        this.f418772d = azVar;
        this.f418773e = qFSPullRefreshLayout;
        this.f418774f = imageView;
        this.f418775g = imageView2;
        this.f418776h = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f418769a;
    }

    public static ay e(View view) {
        int i3 = R.id.pst;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pst);
        if (findChildViewById != null) {
            av e16 = av.e(findChildViewById);
            i3 = R.id.f163409pz3;
            DressSquareDetailHeaderView dressSquareDetailHeaderView = (DressSquareDetailHeaderView) ViewBindings.findChildViewById(view, R.id.f163409pz3);
            if (dressSquareDetailHeaderView != null) {
                i3 = R.id.q6v;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.q6v);
                if (findChildViewById2 != null) {
                    az e17 = az.e(findChildViewById2);
                    i3 = R.id.qdy;
                    QFSPullRefreshLayout qFSPullRefreshLayout = (QFSPullRefreshLayout) ViewBindings.findChildViewById(view, R.id.qdy);
                    if (qFSPullRefreshLayout != null) {
                        i3 = R.id.qev;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qev);
                        if (imageView != null) {
                            i3 = R.id.qnm;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.qnm);
                            if (imageView2 != null) {
                                i3 = R.id.qyg;
                                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, R.id.qyg);
                                if (viewPager2 != null) {
                                    return new ay((RelativeLayout) view, e16, dressSquareDetailHeaderView, e17, qFSPullRefreshLayout, imageView, imageView2, viewPager2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ay g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dbo, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
