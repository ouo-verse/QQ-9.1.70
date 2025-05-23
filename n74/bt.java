package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.avatar.loading.view.AvatarNativeUILoading;
import com.tencent.sqshow.zootopia.card.view.ZootopiaDoublePraiseView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.utils.ui.NoScrollViewPager;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bt implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418914a;

    /* renamed from: b, reason: collision with root package name */
    public final NoScrollViewPager f418915b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewStub f418916c;

    /* renamed from: d, reason: collision with root package name */
    public final ViewStub f418917d;

    /* renamed from: e, reason: collision with root package name */
    public final ViewStub f418918e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f418919f;

    /* renamed from: g, reason: collision with root package name */
    public final AvatarPanelErrorView f418920g;

    /* renamed from: h, reason: collision with root package name */
    public final AvatarGlobalLoadingView f418921h;

    /* renamed from: i, reason: collision with root package name */
    public final ViewStub f418922i;

    /* renamed from: j, reason: collision with root package name */
    public final FrameLayout f418923j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f418924k;

    /* renamed from: l, reason: collision with root package name */
    public final View f418925l;

    /* renamed from: m, reason: collision with root package name */
    public final AvatarNativeUILoading f418926m;

    /* renamed from: n, reason: collision with root package name */
    public final RelativeLayout f418927n;

    /* renamed from: o, reason: collision with root package name */
    public final ZootopiaDoublePraiseView f418928o;

    /* renamed from: p, reason: collision with root package name */
    public final ViewStub f418929p;

    /* renamed from: q, reason: collision with root package name */
    public final ViewStub f418930q;

    /* renamed from: r, reason: collision with root package name */
    public final ViewStub f418931r;

    /* renamed from: s, reason: collision with root package name */
    public final FrameLayout f418932s;

    /* renamed from: t, reason: collision with root package name */
    public final ai f418933t;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public View getMContainer() {
        return this.f418914a;
    }

    bt(View view, NoScrollViewPager noScrollViewPager, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, FrameLayout frameLayout, AvatarPanelErrorView avatarPanelErrorView, AvatarGlobalLoadingView avatarGlobalLoadingView, ViewStub viewStub4, FrameLayout frameLayout2, ImageView imageView, View view2, AvatarNativeUILoading avatarNativeUILoading, RelativeLayout relativeLayout, ZootopiaDoublePraiseView zootopiaDoublePraiseView, ViewStub viewStub5, ViewStub viewStub6, ViewStub viewStub7, FrameLayout frameLayout3, ai aiVar) {
        this.f418914a = view;
        this.f418915b = noScrollViewPager;
        this.f418916c = viewStub;
        this.f418917d = viewStub2;
        this.f418918e = viewStub3;
        this.f418919f = frameLayout;
        this.f418920g = avatarPanelErrorView;
        this.f418921h = avatarGlobalLoadingView;
        this.f418922i = viewStub4;
        this.f418923j = frameLayout2;
        this.f418924k = imageView;
        this.f418925l = view2;
        this.f418926m = avatarNativeUILoading;
        this.f418927n = relativeLayout;
        this.f418928o = zootopiaDoublePraiseView;
        this.f418929p = viewStub5;
        this.f418930q = viewStub6;
        this.f418931r = viewStub7;
        this.f418932s = frameLayout3;
        this.f418933t = aiVar;
    }

    public static bt e(View view) {
        int i3 = R.id.f163306pf0;
        NoScrollViewPager noScrollViewPager = (NoScrollViewPager) ViewBindings.findChildViewById(view, R.id.f163306pf0);
        if (noScrollViewPager != null) {
            i3 = R.id.pir;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.pir);
            if (viewStub != null) {
                i3 = R.id.f163348pn2;
                ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, R.id.f163348pn2);
                if (viewStub2 != null) {
                    i3 = R.id.ppd;
                    ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, R.id.ppd);
                    if (viewStub3 != null) {
                        i3 = R.id.ppq;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.ppq);
                        if (frameLayout != null) {
                            i3 = R.id.psq;
                            AvatarPanelErrorView avatarPanelErrorView = (AvatarPanelErrorView) ViewBindings.findChildViewById(view, R.id.psq);
                            if (avatarPanelErrorView != null) {
                                i3 = R.id.pwx;
                                AvatarGlobalLoadingView avatarGlobalLoadingView = (AvatarGlobalLoadingView) ViewBindings.findChildViewById(view, R.id.pwx);
                                if (avatarGlobalLoadingView != null) {
                                    i3 = R.id.pzr;
                                    ViewStub viewStub4 = (ViewStub) ViewBindings.findChildViewById(view, R.id.pzr);
                                    if (viewStub4 != null) {
                                        i3 = R.id.pzt;
                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pzt);
                                        if (frameLayout2 != null) {
                                            i3 = R.id.pzu;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pzu);
                                            if (imageView != null) {
                                                i3 = R.id.q4e;
                                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.q4e);
                                                if (findChildViewById != null) {
                                                    i3 = R.id.q__;
                                                    AvatarNativeUILoading avatarNativeUILoading = (AvatarNativeUILoading) ViewBindings.findChildViewById(view, R.id.q__);
                                                    if (avatarNativeUILoading != null) {
                                                        i3 = R.id.qbg;
                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qbg);
                                                        if (relativeLayout != null) {
                                                            i3 = R.id.qdd;
                                                            ZootopiaDoublePraiseView zootopiaDoublePraiseView = (ZootopiaDoublePraiseView) ViewBindings.findChildViewById(view, R.id.qdd);
                                                            if (zootopiaDoublePraiseView != null) {
                                                                i3 = R.id.qfz;
                                                                ViewStub viewStub5 = (ViewStub) ViewBindings.findChildViewById(view, R.id.qfz);
                                                                if (viewStub5 != null) {
                                                                    i3 = R.id.qj9;
                                                                    ViewStub viewStub6 = (ViewStub) ViewBindings.findChildViewById(view, R.id.qj9);
                                                                    if (viewStub6 != null) {
                                                                        i3 = R.id.qry;
                                                                        ViewStub viewStub7 = (ViewStub) ViewBindings.findChildViewById(view, R.id.qry);
                                                                        if (viewStub7 != null) {
                                                                            i3 = R.id.qyq;
                                                                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qyq);
                                                                            if (frameLayout3 != null) {
                                                                                i3 = R.id.qyr;
                                                                                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.qyr);
                                                                                if (findChildViewById2 != null) {
                                                                                    return new bt(view, noScrollViewPager, viewStub, viewStub2, viewStub3, frameLayout, avatarPanelErrorView, avatarGlobalLoadingView, viewStub4, frameLayout2, imageView, findChildViewById, avatarNativeUILoading, relativeLayout, zootopiaDoublePraiseView, viewStub5, viewStub6, viewStub7, frameLayout3, ai.e(findChildViewById2));
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bt f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f167454de3, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
