package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bb implements ViewBinding {
    public final TextView A;
    public final LinearLayout B;
    public final ImageView C;
    public final TextView D;
    public final LinearLayout E;

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f399029a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f399030b;

    /* renamed from: c, reason: collision with root package name */
    public final ZootopiaDownloadButton f399031c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f399032d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f399033e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f399034f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f399035g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f399036h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f399037i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f399038j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f399039k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f399040l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f399041m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f399042n;

    /* renamed from: o, reason: collision with root package name */
    public final RoundRelativeLayout f399043o;

    /* renamed from: p, reason: collision with root package name */
    public final ImageView f399044p;

    /* renamed from: q, reason: collision with root package name */
    public final ImageView f399045q;

    /* renamed from: r, reason: collision with root package name */
    public final NavBarCommon f399046r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f399047s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f399048t;

    /* renamed from: u, reason: collision with root package name */
    public final LinearLayout f399049u;

    /* renamed from: v, reason: collision with root package name */
    public final TextView f399050v;

    /* renamed from: w, reason: collision with root package name */
    public final TextView f399051w;

    /* renamed from: x, reason: collision with root package name */
    public final TextView f399052x;

    /* renamed from: y, reason: collision with root package name */
    public final TextView f399053y;

    /* renamed from: z, reason: collision with root package name */
    public final TextView f399054z;

    bb(LinearLayout linearLayout, ImageView imageView, ZootopiaDownloadButton zootopiaDownloadButton, ImageView imageView2, LinearLayout linearLayout2, TextView textView, LinearLayout linearLayout3, TextView textView2, ImageView imageView3, LinearLayout linearLayout4, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, RoundRelativeLayout roundRelativeLayout, ImageView imageView8, ImageView imageView9, NavBarCommon navBarCommon, TextView textView3, TextView textView4, LinearLayout linearLayout5, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, LinearLayout linearLayout6, ImageView imageView10, TextView textView11, LinearLayout linearLayout7) {
        this.f399029a = linearLayout;
        this.f399030b = imageView;
        this.f399031c = zootopiaDownloadButton;
        this.f399032d = imageView2;
        this.f399033e = linearLayout2;
        this.f399034f = textView;
        this.f399035g = linearLayout3;
        this.f399036h = textView2;
        this.f399037i = imageView3;
        this.f399038j = linearLayout4;
        this.f399039k = imageView4;
        this.f399040l = imageView5;
        this.f399041m = imageView6;
        this.f399042n = imageView7;
        this.f399043o = roundRelativeLayout;
        this.f399044p = imageView8;
        this.f399045q = imageView9;
        this.f399046r = navBarCommon;
        this.f399047s = textView3;
        this.f399048t = textView4;
        this.f399049u = linearLayout5;
        this.f399050v = textView5;
        this.f399051w = textView6;
        this.f399052x = textView7;
        this.f399053y = textView8;
        this.f399054z = textView9;
        this.A = textView10;
        this.B = linearLayout6;
        this.C = imageView10;
        this.D = textView11;
        this.E = linearLayout7;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f399029a;
    }

    public static bb g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dcp, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static bb e(View view) {
        int i3 = R.id.paf;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.paf);
        if (imageView != null) {
            i3 = R.id.pfv;
            ZootopiaDownloadButton zootopiaDownloadButton = (ZootopiaDownloadButton) ViewBindings.findChildViewById(view, R.id.pfv);
            if (zootopiaDownloadButton != null) {
                i3 = R.id.f163367pr1;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163367pr1);
                if (imageView2 != null) {
                    i3 = R.id.f163401py0;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163401py0);
                    if (linearLayout != null) {
                        i3 = R.id.f163402py1;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163402py1);
                        if (textView != null) {
                            i3 = R.id.f163423q20;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163423q20);
                            if (linearLayout2 != null) {
                                i3 = R.id.qyi;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qyi);
                                if (textView2 != null) {
                                    i3 = R.id.qyk;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.qyk);
                                    if (imageView3 != null) {
                                        i3 = R.id.qyl;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qyl);
                                        if (linearLayout3 != null) {
                                            i3 = R.id.qym;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.qym);
                                            if (imageView4 != null) {
                                                i3 = R.id.f163627r50;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163627r50);
                                                if (imageView5 != null) {
                                                    i3 = R.id.f163628r51;
                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163628r51);
                                                    if (imageView6 != null) {
                                                        i3 = R.id.f163629r52;
                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163629r52);
                                                        if (imageView7 != null) {
                                                            i3 = R.id.f163630r53;
                                                            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) ViewBindings.findChildViewById(view, R.id.f163630r53);
                                                            if (roundRelativeLayout != null) {
                                                                i3 = R.id.f163631r54;
                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163631r54);
                                                                if (imageView8 != null) {
                                                                    i3 = R.id.f163632r55;
                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163632r55);
                                                                    if (imageView9 != null) {
                                                                        i3 = R.id.r56;
                                                                        NavBarCommon navBarCommon = (NavBarCommon) ViewBindings.findChildViewById(view, R.id.r56);
                                                                        if (navBarCommon != null) {
                                                                            i3 = R.id.r57;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.r57);
                                                                            if (textView3 != null) {
                                                                                i3 = R.id.r9i;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.r9i);
                                                                                if (textView4 != null) {
                                                                                    i3 = R.id.r9j;
                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.r9j);
                                                                                    if (linearLayout4 != null) {
                                                                                        i3 = R.id.r9k;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.r9k);
                                                                                        if (textView5 != null) {
                                                                                            i3 = R.id.r9l;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.r9l);
                                                                                            if (textView6 != null) {
                                                                                                i3 = R.id.r9m;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.r9m);
                                                                                                if (textView7 != null) {
                                                                                                    i3 = R.id.r9n;
                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.r9n);
                                                                                                    if (textView8 != null) {
                                                                                                        i3 = R.id.r9o;
                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.r9o);
                                                                                                        if (textView9 != null) {
                                                                                                            i3 = R.id.r9p;
                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.r9p);
                                                                                                            if (textView10 != null) {
                                                                                                                i3 = R.id.r9q;
                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.r9q);
                                                                                                                if (linearLayout5 != null) {
                                                                                                                    i3 = R.id.r9r;
                                                                                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, R.id.r9r);
                                                                                                                    if (imageView10 != null) {
                                                                                                                        i3 = R.id.r9s;
                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, R.id.r9s);
                                                                                                                        if (textView11 != null) {
                                                                                                                            i3 = R.id.r9t;
                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.r9t);
                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                return new bb((LinearLayout) view, imageView, zootopiaDownloadButton, imageView2, linearLayout, textView, linearLayout2, textView2, imageView3, linearLayout3, imageView4, imageView5, imageView6, imageView7, roundRelativeLayout, imageView8, imageView9, navBarCommon, textView3, textView4, linearLayout4, textView5, textView6, textView7, textView8, textView9, textView10, linearLayout5, imageView10, textView11, linearLayout6);
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
