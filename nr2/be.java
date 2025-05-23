package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class be implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421003a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421004b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f421005c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f421006d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f421007e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f421008f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f421009g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f421010h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f421011i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f421012j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421013k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f421014l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f421015m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f421016n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f421017o;

    be(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull RoundCornerImageView roundCornerImageView, @NonNull RoundCornerImageView roundCornerImageView2, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull TextView textView5, @NonNull View view2, @NonNull TextView textView6) {
        this.f421003a = view;
        this.f421004b = linearLayout;
        this.f421005c = textView;
        this.f421006d = relativeLayout;
        this.f421007e = relativeLayout2;
        this.f421008f = textView2;
        this.f421009g = textView3;
        this.f421010h = textView4;
        this.f421011i = roundCornerImageView;
        this.f421012j = roundCornerImageView2;
        this.f421013k = linearLayout2;
        this.f421014l = imageView;
        this.f421015m = textView5;
        this.f421016n = view2;
        this.f421017o = textView6;
    }

    @NonNull
    public static be e(@NonNull View view) {
        int i3 = R.id.sxe;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.sxe);
        if (linearLayout != null) {
            i3 = R.id.sxf;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sxf);
            if (textView != null) {
                i3 = R.id.u7t;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.u7t);
                if (relativeLayout != null) {
                    i3 = R.id.ufh;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ufh);
                    if (relativeLayout2 != null) {
                        i3 = R.id.ufi;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ufi);
                        if (textView2 != null) {
                            i3 = R.id.f165117uy3;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f165117uy3);
                            if (textView3 != null) {
                                i3 = R.id.f165118uy4;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f165118uy4);
                                if (textView4 != null) {
                                    i3 = R.id.x5t;
                                    RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.x5t);
                                    if (roundCornerImageView != null) {
                                        i3 = R.id.x7q;
                                        RoundCornerImageView roundCornerImageView2 = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.x7q);
                                        if (roundCornerImageView2 != null) {
                                            i3 = R.id.f7768451;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f7768451);
                                            if (linearLayout2 != null) {
                                                i3 = R.id.f7769452;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f7769452);
                                                if (imageView != null) {
                                                    i3 = R.id.f7773456;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f7773456);
                                                    if (textView5 != null) {
                                                        i3 = R.id.f84014l4;
                                                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f84014l4);
                                                        if (findChildViewById != null) {
                                                            i3 = R.id.f86484rs;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.f86484rs);
                                                            if (textView6 != null) {
                                                                return new be(view, linearLayout, textView, relativeLayout, relativeLayout2, textView2, textView3, textView4, roundCornerImageView, roundCornerImageView2, linearLayout2, imageView, textView5, findChildViewById, textView6);
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

    @NonNull
    public static be f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hxt, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421003a;
    }
}
