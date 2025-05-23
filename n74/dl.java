package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ScrollingHeaderLayout;
import com.tencent.sqshow.zootopia.recommend.main.dress.entrance.PublishEntranceView;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;
import com.tencent.sqshow.zootopia.view.ZootopiaViewPager;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class dl implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f419288a;

    /* renamed from: b, reason: collision with root package name */
    public final ScrollingHeaderLayout f419289b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f419290c;

    /* renamed from: d, reason: collision with root package name */
    public final ZootopiaViewPager f419291d;

    /* renamed from: e, reason: collision with root package name */
    public final CoordinatorLayout f419292e;

    /* renamed from: f, reason: collision with root package name */
    public final ZootopiaLoadFailView f419293f;

    /* renamed from: g, reason: collision with root package name */
    public final dk f419294g;

    /* renamed from: h, reason: collision with root package name */
    public final PublishEntranceView f419295h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f419296i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f419297j;

    /* renamed from: k, reason: collision with root package name */
    public final FrameLayout f419298k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f419299l;

    dl(FrameLayout frameLayout, ScrollingHeaderLayout scrollingHeaderLayout, ImageView imageView, ZootopiaViewPager zootopiaViewPager, CoordinatorLayout coordinatorLayout, ZootopiaLoadFailView zootopiaLoadFailView, dk dkVar, PublishEntranceView publishEntranceView, FrameLayout frameLayout2, ImageView imageView2, FrameLayout frameLayout3, TextView textView) {
        this.f419288a = frameLayout;
        this.f419289b = scrollingHeaderLayout;
        this.f419290c = imageView;
        this.f419291d = zootopiaViewPager;
        this.f419292e = coordinatorLayout;
        this.f419293f = zootopiaLoadFailView;
        this.f419294g = dkVar;
        this.f419295h = publishEntranceView;
        this.f419296i = frameLayout2;
        this.f419297j = imageView2;
        this.f419298k = frameLayout3;
        this.f419299l = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f419288a;
    }

    public static dl e(View view) {
        int i3 = R.id.pak;
        ScrollingHeaderLayout scrollingHeaderLayout = (ScrollingHeaderLayout) ViewBindings.findChildViewById(view, R.id.pak);
        if (scrollingHeaderLayout != null) {
            i3 = R.id.f163297pd1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163297pd1);
            if (imageView != null) {
                i3 = R.id.pm7;
                ZootopiaViewPager zootopiaViewPager = (ZootopiaViewPager) ViewBindings.findChildViewById(view, R.id.pm7);
                if (zootopiaViewPager != null) {
                    i3 = R.id.pmn;
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, R.id.pmn);
                    if (coordinatorLayout != null) {
                        i3 = R.id.psq;
                        ZootopiaLoadFailView zootopiaLoadFailView = (ZootopiaLoadFailView) ViewBindings.findChildViewById(view, R.id.psq);
                        if (zootopiaLoadFailView != null) {
                            i3 = R.id.q6i;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.q6i);
                            if (findChildViewById != null) {
                                dk e16 = dk.e(findChildViewById);
                                i3 = R.id.qej;
                                PublishEntranceView publishEntranceView = (PublishEntranceView) ViewBindings.findChildViewById(view, R.id.qej);
                                if (publishEntranceView != null) {
                                    FrameLayout frameLayout = (FrameLayout) view;
                                    i3 = R.id.qkl;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.qkl);
                                    if (imageView2 != null) {
                                        i3 = R.id.qr7;
                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qr7);
                                        if (frameLayout2 != null) {
                                            i3 = R.id.qrj;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qrj);
                                            if (textView != null) {
                                                return new dl(frameLayout, scrollingHeaderLayout, imageView, zootopiaViewPager, coordinatorLayout, zootopiaLoadFailView, e16, publishEntranceView, frameLayout, imageView2, frameLayout2, textView);
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

    public static dl g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dh_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
