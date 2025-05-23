package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.detail.base.GoodsDetailPriceView;
import com.tencent.sqshow.zootopia.nativeui.view.detail.base.GoodsSimpleInfoView;
import com.tencent.sqshow.zootopia.nativeui.view.detail.base.GoodsTagView;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class u implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f419418a;

    /* renamed from: b, reason: collision with root package name */
    public final View f419419b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f419420c;

    /* renamed from: d, reason: collision with root package name */
    public final Button f419421d;

    /* renamed from: e, reason: collision with root package name */
    public final Button f419422e;

    /* renamed from: f, reason: collision with root package name */
    public final Button f419423f;

    /* renamed from: g, reason: collision with root package name */
    public final AvatarPanelErrorView f419424g;

    /* renamed from: h, reason: collision with root package name */
    public final GoodsSimpleInfoView f419425h;

    /* renamed from: i, reason: collision with root package name */
    public final RelativeLayout f419426i;

    /* renamed from: j, reason: collision with root package name */
    public final View f419427j;

    /* renamed from: k, reason: collision with root package name */
    public final View f419428k;

    /* renamed from: l, reason: collision with root package name */
    public final RecyclerView f419429l;

    /* renamed from: m, reason: collision with root package name */
    public final GoodsDetailPriceView f419430m;

    /* renamed from: n, reason: collision with root package name */
    public final ScrollView f419431n;

    /* renamed from: o, reason: collision with root package name */
    public final ShimmerLinearLayout f419432o;

    /* renamed from: p, reason: collision with root package name */
    public final GoodsTagView f419433p;

    /* renamed from: q, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419434q;

    /* renamed from: r, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419435r;

    /* renamed from: s, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419436s;

    /* renamed from: t, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419437t;

    /* renamed from: u, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419438u;

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getMRv() {
        return this.f419418a;
    }

    u(RelativeLayout relativeLayout, View view, LinearLayout linearLayout, Button button, Button button2, Button button3, AvatarPanelErrorView avatarPanelErrorView, GoodsSimpleInfoView goodsSimpleInfoView, RelativeLayout relativeLayout2, View view2, View view3, RecyclerView recyclerView, GoodsDetailPriceView goodsDetailPriceView, ScrollView scrollView, ShimmerLinearLayout shimmerLinearLayout, GoodsTagView goodsTagView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView4, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView5) {
        this.f419418a = relativeLayout;
        this.f419419b = view;
        this.f419420c = linearLayout;
        this.f419421d = button;
        this.f419422e = button2;
        this.f419423f = button3;
        this.f419424g = avatarPanelErrorView;
        this.f419425h = goodsSimpleInfoView;
        this.f419426i = relativeLayout2;
        this.f419427j = view2;
        this.f419428k = view3;
        this.f419429l = recyclerView;
        this.f419430m = goodsDetailPriceView;
        this.f419431n = scrollView;
        this.f419432o = shimmerLinearLayout;
        this.f419433p = goodsTagView;
        this.f419434q = zplanExcludeFontPaddingTextView;
        this.f419435r = zplanExcludeFontPaddingTextView2;
        this.f419436s = zplanExcludeFontPaddingTextView3;
        this.f419437t = zplanExcludeFontPaddingTextView4;
        this.f419438u = zplanExcludeFontPaddingTextView5;
    }

    public static u g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static u h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_h, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static u e(View view) {
        int i3 = R.id.pas;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pas);
        if (findChildViewById != null) {
            i3 = R.id.per;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.per);
            if (linearLayout != null) {
                i3 = R.id.pfm;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.pfm);
                if (button != null) {
                    i3 = R.id.pg6;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.pg6);
                    if (button2 != null) {
                        i3 = R.id.pgf;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.pgf);
                        if (button3 != null) {
                            i3 = R.id.psw;
                            AvatarPanelErrorView avatarPanelErrorView = (AvatarPanelErrorView) ViewBindings.findChildViewById(view, R.id.psw);
                            if (avatarPanelErrorView != null) {
                                i3 = R.id.f163430q31;
                                GoodsSimpleInfoView goodsSimpleInfoView = (GoodsSimpleInfoView) ViewBindings.findChildViewById(view, R.id.f163430q31);
                                if (goodsSimpleInfoView != null) {
                                    i3 = R.id.q4i;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.q4i);
                                    if (relativeLayout != null) {
                                        i3 = R.id.q5j;
                                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.q5j);
                                        if (findChildViewById2 != null) {
                                            i3 = R.id.q5k;
                                            View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.q5k);
                                            if (findChildViewById3 != null) {
                                                i3 = R.id.q5q;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.q5q);
                                                if (recyclerView != null) {
                                                    i3 = R.id.qdt;
                                                    GoodsDetailPriceView goodsDetailPriceView = (GoodsDetailPriceView) ViewBindings.findChildViewById(view, R.id.qdt);
                                                    if (goodsDetailPriceView != null) {
                                                        i3 = R.id.qjc;
                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.qjc);
                                                        if (scrollView != null) {
                                                            i3 = R.id.qlc;
                                                            ShimmerLinearLayout shimmerLinearLayout = (ShimmerLinearLayout) ViewBindings.findChildViewById(view, R.id.qlc);
                                                            if (shimmerLinearLayout != null) {
                                                                i3 = R.id.qpg;
                                                                GoodsTagView goodsTagView = (GoodsTagView) ViewBindings.findChildViewById(view, R.id.qpg);
                                                                if (goodsTagView != null) {
                                                                    i3 = R.id.f163563qt1;
                                                                    ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163563qt1);
                                                                    if (zplanExcludeFontPaddingTextView != null) {
                                                                        i3 = R.id.f163564qt2;
                                                                        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163564qt2);
                                                                        if (zplanExcludeFontPaddingTextView2 != null) {
                                                                            i3 = R.id.f163565qt3;
                                                                            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163565qt3);
                                                                            if (zplanExcludeFontPaddingTextView3 != null) {
                                                                                i3 = R.id.f163570qu3;
                                                                                ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView4 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163570qu3);
                                                                                if (zplanExcludeFontPaddingTextView4 != null) {
                                                                                    i3 = R.id.f163571qu4;
                                                                                    ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView5 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163571qu4);
                                                                                    if (zplanExcludeFontPaddingTextView5 != null) {
                                                                                        return new u((RelativeLayout) view, findChildViewById, linearLayout, button, button2, button3, avatarPanelErrorView, goodsSimpleInfoView, relativeLayout, findChildViewById2, findChildViewById3, recyclerView, goodsDetailPriceView, scrollView, shimmerLinearLayout, goodsTagView, zplanExcludeFontPaddingTextView, zplanExcludeFontPaddingTextView2, zplanExcludeFontPaddingTextView3, zplanExcludeFontPaddingTextView4, zplanExcludeFontPaddingTextView5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
