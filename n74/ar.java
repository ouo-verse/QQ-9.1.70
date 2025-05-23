package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.banner.BannerLayout;
import com.tencent.sqshow.widget.pag.ZPlanPAGView;
import com.tencent.sqshow.zootopia.role.ui.RoleDotIndicator;
import com.tencent.sqshow.zootopia.role.ui.RoleLoadingButton;
import com.tencent.sqshow.zootopia.widget.ZootopiaRecycleView;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ar implements ViewBinding {
    public final TextView A;
    public final URLImageView B;

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f418690a;

    /* renamed from: b, reason: collision with root package name */
    public final ZPlanMediaView f418691b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f418692c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f418693d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f418694e;

    /* renamed from: f, reason: collision with root package name */
    public final ZPlanPAGView f418695f;

    /* renamed from: g, reason: collision with root package name */
    public final ZPlanMediaView f418696g;

    /* renamed from: h, reason: collision with root package name */
    public final RoleLoadingButton f418697h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f418698i;

    /* renamed from: j, reason: collision with root package name */
    public final ZootopiaRecycleView f418699j;

    /* renamed from: k, reason: collision with root package name */
    public final BannerLayout f418700k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f418701l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayout f418702m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f418703n;

    /* renamed from: o, reason: collision with root package name */
    public final RoleLoadingButton f418704o;

    /* renamed from: p, reason: collision with root package name */
    public final RoleDotIndicator f418705p;

    /* renamed from: q, reason: collision with root package name */
    public final View f418706q;

    /* renamed from: r, reason: collision with root package name */
    public final LinearLayout f418707r;

    /* renamed from: s, reason: collision with root package name */
    public final RoleLoadingButton f418708s;

    /* renamed from: t, reason: collision with root package name */
    public final ConstraintLayout f418709t;

    /* renamed from: u, reason: collision with root package name */
    public final ImageView f418710u;

    /* renamed from: v, reason: collision with root package name */
    public final ImageView f418711v;

    /* renamed from: w, reason: collision with root package name */
    public final ImageView f418712w;

    /* renamed from: x, reason: collision with root package name */
    public final RelativeLayout f418713x;

    /* renamed from: y, reason: collision with root package name */
    public final FrameLayout f418714y;

    /* renamed from: z, reason: collision with root package name */
    public final LinearLayout f418715z;

    ar(ConstraintLayout constraintLayout, ZPlanMediaView zPlanMediaView, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ZPlanPAGView zPlanPAGView, ZPlanMediaView zPlanMediaView2, RoleLoadingButton roleLoadingButton, TextView textView, ZootopiaRecycleView zootopiaRecycleView, BannerLayout bannerLayout, ImageView imageView3, LinearLayout linearLayout, ImageView imageView4, RoleLoadingButton roleLoadingButton2, RoleDotIndicator roleDotIndicator, View view, LinearLayout linearLayout2, RoleLoadingButton roleLoadingButton3, ConstraintLayout constraintLayout2, ImageView imageView5, ImageView imageView6, ImageView imageView7, RelativeLayout relativeLayout, FrameLayout frameLayout2, LinearLayout linearLayout3, TextView textView2, URLImageView uRLImageView) {
        this.f418690a = constraintLayout;
        this.f418691b = zPlanMediaView;
        this.f418692c = frameLayout;
        this.f418693d = imageView;
        this.f418694e = imageView2;
        this.f418695f = zPlanPAGView;
        this.f418696g = zPlanMediaView2;
        this.f418697h = roleLoadingButton;
        this.f418698i = textView;
        this.f418699j = zootopiaRecycleView;
        this.f418700k = bannerLayout;
        this.f418701l = imageView3;
        this.f418702m = linearLayout;
        this.f418703n = imageView4;
        this.f418704o = roleLoadingButton2;
        this.f418705p = roleDotIndicator;
        this.f418706q = view;
        this.f418707r = linearLayout2;
        this.f418708s = roleLoadingButton3;
        this.f418709t = constraintLayout2;
        this.f418710u = imageView5;
        this.f418711v = imageView6;
        this.f418712w = imageView7;
        this.f418713x = relativeLayout;
        this.f418714y = frameLayout2;
        this.f418715z = linearLayout3;
        this.A = textView2;
        this.B = uRLImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMRv() {
        return this.f418690a;
    }

    public static ar g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.db7, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    public static ar e(View view) {
        int i3 = R.id.pb8;
        ZPlanMediaView zPlanMediaView = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.pb8);
        if (zPlanMediaView != null) {
            i3 = R.id.pc5;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pc5);
            if (frameLayout != null) {
                i3 = R.id.f163297pd1;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163297pd1);
                if (imageView != null) {
                    i3 = R.id.f163298pd2;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163298pd2);
                    if (imageView2 != null) {
                        i3 = R.id.pda;
                        ZPlanPAGView zPlanPAGView = (ZPlanPAGView) ViewBindings.findChildViewById(view, R.id.pda);
                        if (zPlanPAGView != null) {
                            i3 = R.id.pdf;
                            ZPlanMediaView zPlanMediaView2 = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.pdf);
                            if (zPlanMediaView2 != null) {
                                i3 = R.id.pln;
                                RoleLoadingButton roleLoadingButton = (RoleLoadingButton) ViewBindings.findChildViewById(view, R.id.pln);
                                if (roleLoadingButton != null) {
                                    i3 = R.id.pqf;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pqf);
                                    if (textView != null) {
                                        i3 = R.id.ptd;
                                        ZootopiaRecycleView zootopiaRecycleView = (ZootopiaRecycleView) ViewBindings.findChildViewById(view, R.id.ptd);
                                        if (zootopiaRecycleView != null) {
                                            i3 = R.id.pya;
                                            BannerLayout bannerLayout = (BannerLayout) ViewBindings.findChildViewById(view, R.id.pya);
                                            if (bannerLayout != null) {
                                                i3 = R.id.pyb;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.pyb);
                                                if (imageView3 != null) {
                                                    i3 = R.id.py_;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.py_);
                                                    if (linearLayout != null) {
                                                        i3 = R.id.pyo;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.pyo);
                                                        if (imageView4 != null) {
                                                            i3 = R.id.pyu;
                                                            RoleLoadingButton roleLoadingButton2 = (RoleLoadingButton) ViewBindings.findChildViewById(view, R.id.pyu);
                                                            if (roleLoadingButton2 != null) {
                                                                i3 = R.id.q1v;
                                                                RoleDotIndicator roleDotIndicator = (RoleDotIndicator) ViewBindings.findChildViewById(view, R.id.q1v);
                                                                if (roleDotIndicator != null) {
                                                                    i3 = R.id.q6t;
                                                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.q6t);
                                                                    if (findChildViewById != null) {
                                                                        i3 = R.id.q6w;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q6w);
                                                                        if (linearLayout2 != null) {
                                                                            i3 = R.id.qia;
                                                                            RoleLoadingButton roleLoadingButton3 = (RoleLoadingButton) ViewBindings.findChildViewById(view, R.id.qia);
                                                                            if (roleLoadingButton3 != null) {
                                                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                                i3 = R.id.qjw;
                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.qjw);
                                                                                if (imageView5 != null) {
                                                                                    i3 = R.id.f163542qp0;
                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163542qp0);
                                                                                    if (imageView6 != null) {
                                                                                        i3 = R.id.f163543qp1;
                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163543qp1);
                                                                                        if (imageView7 != null) {
                                                                                            i3 = R.id.f163544qp2;
                                                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163544qp2);
                                                                                            if (relativeLayout != null) {
                                                                                                i3 = R.id.f163545qp3;
                                                                                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f163545qp3);
                                                                                                if (frameLayout2 != null) {
                                                                                                    i3 = R.id.f163555qr3;
                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163555qr3);
                                                                                                    if (linearLayout3 != null) {
                                                                                                        i3 = R.id.qr9;
                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qr9);
                                                                                                        if (textView2 != null) {
                                                                                                            i3 = R.id.qyt;
                                                                                                            URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.qyt);
                                                                                                            if (uRLImageView != null) {
                                                                                                                return new ar(constraintLayout, zPlanMediaView, frameLayout, imageView, imageView2, zPlanPAGView, zPlanMediaView2, roleLoadingButton, textView, zootopiaRecycleView, bannerLayout, imageView3, linearLayout, imageView4, roleLoadingButton2, roleDotIndicator, findChildViewById, linearLayout2, roleLoadingButton3, constraintLayout, imageView5, imageView6, imageView7, relativeLayout, frameLayout2, linearLayout3, textView2, uRLImageView);
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
