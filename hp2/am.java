package hp2;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaVideoView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class am implements ViewBinding {

    @NonNull
    public final NetSearchMultiMediaVideoView A;

    @NonNull
    public final TextView B;

    @NonNull
    public final ImageView C;

    @NonNull
    public final ImageView D;

    @NonNull
    public final TextView E;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405602a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f405603b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405604c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QQProAvatarView f405605d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405606e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f405607f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f405608g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f405609h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405610i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f405611j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final Guideline f405612k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final Guideline f405613l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final ViewStub f405614m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f405615n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405616o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405617p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405618q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405619r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405620s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405621t;

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405622u;

    /* renamed from: v, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405623v;

    /* renamed from: w, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405624w;

    /* renamed from: x, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405625x;

    /* renamed from: y, reason: collision with root package name */
    @NonNull
    public final TextView f405626y;

    /* renamed from: z, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405627z;

    am(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull QQProAvatarView qQProAvatarView, @NonNull ImageFilterView imageFilterView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull View view, @NonNull LinearLayout linearLayout, @NonNull TextView textView5, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull ViewStub viewStub, @NonNull TextView textView6, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageFilterView imageFilterView2, @NonNull ImageFilterView imageFilterView3, @NonNull ImageFilterView imageFilterView4, @NonNull ImageFilterView imageFilterView5, @NonNull ImageFilterView imageFilterView6, @NonNull ImageFilterView imageFilterView7, @NonNull ImageFilterView imageFilterView8, @NonNull ImageFilterView imageFilterView9, @NonNull ImageFilterView imageFilterView10, @NonNull TextView textView7, @NonNull ImageFilterView imageFilterView11, @NonNull NetSearchMultiMediaVideoView netSearchMultiMediaVideoView, @NonNull TextView textView8, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView9) {
        this.f405602a = constraintLayout;
        this.f405603b = textView;
        this.f405604c = textView2;
        this.f405605d = qQProAvatarView;
        this.f405606e = imageFilterView;
        this.f405607f = textView3;
        this.f405608g = textView4;
        this.f405609h = view;
        this.f405610i = linearLayout;
        this.f405611j = textView5;
        this.f405612k = guideline;
        this.f405613l = guideline2;
        this.f405614m = viewStub;
        this.f405615n = textView6;
        this.f405616o = constraintLayout2;
        this.f405617p = imageFilterView2;
        this.f405618q = imageFilterView3;
        this.f405619r = imageFilterView4;
        this.f405620s = imageFilterView5;
        this.f405621t = imageFilterView6;
        this.f405622u = imageFilterView7;
        this.f405623v = imageFilterView8;
        this.f405624w = imageFilterView9;
        this.f405625x = imageFilterView10;
        this.f405626y = textView7;
        this.f405627z = imageFilterView11;
        this.A = netSearchMultiMediaVideoView;
        this.B = textView8;
        this.C = imageView;
        this.D = imageView2;
        this.E = textView9;
    }

    @NonNull
    public static am e(@NonNull View view) {
        int i3 = R.id.tnf;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tnf);
        if (textView != null) {
            i3 = R.id.tng;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tng);
            if (textView2 != null) {
                i3 = R.id.tnu;
                QQProAvatarView qQProAvatarView = (QQProAvatarView) ViewBindings.findChildViewById(view, R.id.tnu);
                if (qQProAvatarView != null) {
                    i3 = R.id.tnv;
                    ImageFilterView imageFilterView = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.tnv);
                    if (imageFilterView != null) {
                        i3 = R.id.tok;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tok);
                        if (textView3 != null) {
                            i3 = R.id.ar_;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.ar_);
                            if (textView4 != null) {
                                i3 = R.id.bwi;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.bwi);
                                if (findChildViewById != null) {
                                    i3 = R.id.vda;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vda);
                                    if (linearLayout != null) {
                                        i3 = R.id.vdb;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.vdb);
                                        if (textView5 != null) {
                                            i3 = R.id.vvt;
                                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.vvt);
                                            if (guideline != null) {
                                                i3 = R.id.vvu;
                                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, R.id.vvu);
                                                if (guideline2 != null) {
                                                    i3 = R.id.xpl;
                                                    ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.xpl);
                                                    if (viewStub != null) {
                                                        i3 = R.id.f166206z01;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.f166206z01);
                                                        if (textView6 != null) {
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                            i3 = R.id.f25270ad;
                                                            ImageFilterView imageFilterView2 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25270ad);
                                                            if (imageFilterView2 != null) {
                                                                i3 = R.id.f25280ae;
                                                                ImageFilterView imageFilterView3 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25280ae);
                                                                if (imageFilterView3 != null) {
                                                                    i3 = R.id.f25290af;
                                                                    ImageFilterView imageFilterView4 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25290af);
                                                                    if (imageFilterView4 != null) {
                                                                        i3 = R.id.f25300ag;
                                                                        ImageFilterView imageFilterView5 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25300ag);
                                                                        if (imageFilterView5 != null) {
                                                                            i3 = R.id.f25310ah;
                                                                            ImageFilterView imageFilterView6 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25310ah);
                                                                            if (imageFilterView6 != null) {
                                                                                i3 = R.id.f25320ai;
                                                                                ImageFilterView imageFilterView7 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25320ai);
                                                                                if (imageFilterView7 != null) {
                                                                                    i3 = R.id.f25330aj;
                                                                                    ImageFilterView imageFilterView8 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25330aj);
                                                                                    if (imageFilterView8 != null) {
                                                                                        i3 = R.id.f25340ak;
                                                                                        ImageFilterView imageFilterView9 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25340ak);
                                                                                        if (imageFilterView9 != null) {
                                                                                            i3 = R.id.f25350al;
                                                                                            ImageFilterView imageFilterView10 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25350al);
                                                                                            if (imageFilterView10 != null) {
                                                                                                i3 = R.id.f85034nv;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.f85034nv);
                                                                                                if (textView7 != null) {
                                                                                                    i3 = R.id.iwl;
                                                                                                    ImageFilterView imageFilterView11 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.iwl);
                                                                                                    if (imageFilterView11 != null) {
                                                                                                        i3 = R.id.f85654pj;
                                                                                                        NetSearchMultiMediaVideoView netSearchMultiMediaVideoView = (NetSearchMultiMediaVideoView) ViewBindings.findChildViewById(view, R.id.f85654pj);
                                                                                                        if (netSearchMultiMediaVideoView != null) {
                                                                                                            i3 = R.id.f110786jg;
                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.f110786jg);
                                                                                                            if (textView8 != null) {
                                                                                                                i3 = R.id.f116086xs;
                                                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f116086xs);
                                                                                                                if (imageView != null) {
                                                                                                                    i3 = R.id.f1199678_;
                                                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f1199678_);
                                                                                                                    if (imageView2 != null) {
                                                                                                                        i3 = R.id.f1199778a;
                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.f1199778a);
                                                                                                                        if (textView9 != null) {
                                                                                                                            return new am(constraintLayout, textView, textView2, qQProAvatarView, imageFilterView, textView3, textView4, findChildViewById, linearLayout, textView5, guideline, guideline2, viewStub, textView6, constraintLayout, imageFilterView2, imageFilterView3, imageFilterView4, imageFilterView5, imageFilterView6, imageFilterView7, imageFilterView8, imageFilterView9, imageFilterView10, textView7, imageFilterView11, netSearchMultiMediaVideoView, textView8, imageView, imageView2, textView9);
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

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405602a;
    }
}
