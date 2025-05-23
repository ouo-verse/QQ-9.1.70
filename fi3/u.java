package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.portal.detail.v2.ZootopiaDetailTabView;
import com.tencent.mobileqq.zootopia.portal.detail.v2.ZootopiaDetailTabViewPager;
import com.tencent.mobileqq.zootopia.portal.detail.v2.ZootopiaDetailV2HeaderView;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zootopia.view.ZootopiaSelfRankFloatBar;
import com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ScrollingHeaderLayout;
import com.tencent.sqshow.zootopia.view.ZootopiaLoadFailView;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaDetailPullToRefreshView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class u implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f399384a;

    /* renamed from: b, reason: collision with root package name */
    public final ScrollingHeaderLayout f399385b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f399386c;

    /* renamed from: d, reason: collision with root package name */
    public final View f399387d;

    /* renamed from: e, reason: collision with root package name */
    public final RelativeLayout f399388e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f399389f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f399390g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f399391h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f399392i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f399393j;

    /* renamed from: k, reason: collision with root package name */
    public final ZootopiaDetailTabViewPager f399394k;

    /* renamed from: l, reason: collision with root package name */
    public final ZootopiaDetailTabView f399395l;

    /* renamed from: m, reason: collision with root package name */
    public final CoordinatorLayout f399396m;

    /* renamed from: n, reason: collision with root package name */
    public final ZootopiaDetailV2HeaderView f399397n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f399398o;

    /* renamed from: p, reason: collision with root package name */
    public final ZootopiaDownloadButton f399399p;

    /* renamed from: q, reason: collision with root package name */
    public final ZootopiaDetailPullToRefreshView f399400q;

    /* renamed from: r, reason: collision with root package name */
    public final ZootopiaSelfRankFloatBar f399401r;

    /* renamed from: s, reason: collision with root package name */
    public final ZootopiaLoadFailView f399402s;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f399384a;
    }

    u(FrameLayout frameLayout, ScrollingHeaderLayout scrollingHeaderLayout, RelativeLayout relativeLayout, View view, RelativeLayout relativeLayout2, ImageView imageView, FrameLayout frameLayout2, TextView textView, ImageView imageView2, ImageView imageView3, ZootopiaDetailTabViewPager zootopiaDetailTabViewPager, ZootopiaDetailTabView zootopiaDetailTabView, CoordinatorLayout coordinatorLayout, ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView, ImageView imageView4, ZootopiaDownloadButton zootopiaDownloadButton, ZootopiaDetailPullToRefreshView zootopiaDetailPullToRefreshView, ZootopiaSelfRankFloatBar zootopiaSelfRankFloatBar, ZootopiaLoadFailView zootopiaLoadFailView) {
        this.f399384a = frameLayout;
        this.f399385b = scrollingHeaderLayout;
        this.f399386c = relativeLayout;
        this.f399387d = view;
        this.f399388e = relativeLayout2;
        this.f399389f = imageView;
        this.f399390g = frameLayout2;
        this.f399391h = textView;
        this.f399392i = imageView2;
        this.f399393j = imageView3;
        this.f399394k = zootopiaDetailTabViewPager;
        this.f399395l = zootopiaDetailTabView;
        this.f399396m = coordinatorLayout;
        this.f399397n = zootopiaDetailV2HeaderView;
        this.f399398o = imageView4;
        this.f399399p = zootopiaDownloadButton;
        this.f399400q = zootopiaDetailPullToRefreshView;
        this.f399401r = zootopiaSelfRankFloatBar;
        this.f399402s = zootopiaLoadFailView;
    }

    public static u g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d89, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static u e(View view) {
        int i3 = R.id.pak;
        ScrollingHeaderLayout scrollingHeaderLayout = (ScrollingHeaderLayout) ViewBindings.findChildViewById(view, R.id.pak);
        if (scrollingHeaderLayout != null) {
            i3 = R.id.pal;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pal);
            if (relativeLayout != null) {
                i3 = R.id.pam;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.pam);
                if (findChildViewById != null) {
                    i3 = R.id.pan;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pan);
                    if (relativeLayout2 != null) {
                        i3 = R.id.pfa;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pfa);
                        if (imageView != null) {
                            i3 = R.id.pfw;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pfw);
                            if (frameLayout != null) {
                                i3 = R.id.pfx;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pfx);
                                if (textView != null) {
                                    i3 = R.id.pfy;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pfy);
                                    if (imageView2 != null) {
                                        i3 = R.id.pfz;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.pfz);
                                        if (imageView3 != null) {
                                            i3 = R.id.pmc;
                                            ZootopiaDetailTabViewPager zootopiaDetailTabViewPager = (ZootopiaDetailTabViewPager) ViewBindings.findChildViewById(view, R.id.pmc);
                                            if (zootopiaDetailTabViewPager != null) {
                                                i3 = R.id.pmd;
                                                ZootopiaDetailTabView zootopiaDetailTabView = (ZootopiaDetailTabView) ViewBindings.findChildViewById(view, R.id.pmd);
                                                if (zootopiaDetailTabView != null) {
                                                    i3 = R.id.pmn;
                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, R.id.pmn);
                                                    if (coordinatorLayout != null) {
                                                        i3 = R.id.ppa;
                                                        ZootopiaDetailV2HeaderView zootopiaDetailV2HeaderView = (ZootopiaDetailV2HeaderView) ViewBindings.findChildViewById(view, R.id.ppa);
                                                        if (zootopiaDetailV2HeaderView != null) {
                                                            i3 = R.id.qci;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.qci);
                                                            if (imageView4 != null) {
                                                                i3 = R.id.qcj;
                                                                ZootopiaDownloadButton zootopiaDownloadButton = (ZootopiaDownloadButton) ViewBindings.findChildViewById(view, R.id.qcj);
                                                                if (zootopiaDownloadButton != null) {
                                                                    i3 = R.id.qeq;
                                                                    ZootopiaDetailPullToRefreshView zootopiaDetailPullToRefreshView = (ZootopiaDetailPullToRefreshView) ViewBindings.findChildViewById(view, R.id.qeq);
                                                                    if (zootopiaDetailPullToRefreshView != null) {
                                                                        i3 = R.id.qfh;
                                                                        ZootopiaSelfRankFloatBar zootopiaSelfRankFloatBar = (ZootopiaSelfRankFloatBar) ViewBindings.findChildViewById(view, R.id.qfh);
                                                                        if (zootopiaSelfRankFloatBar != null) {
                                                                            i3 = R.id.r0x;
                                                                            ZootopiaLoadFailView zootopiaLoadFailView = (ZootopiaLoadFailView) ViewBindings.findChildViewById(view, R.id.r0x);
                                                                            if (zootopiaLoadFailView != null) {
                                                                                return new u((FrameLayout) view, scrollingHeaderLayout, relativeLayout, findChildViewById, relativeLayout2, imageView, frameLayout, textView, imageView2, imageView3, zootopiaDetailTabViewPager, zootopiaDetailTabView, coordinatorLayout, zootopiaDetailV2HeaderView, imageView4, zootopiaDownloadButton, zootopiaDetailPullToRefreshView, zootopiaSelfRankFloatBar, zootopiaLoadFailView);
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
}
