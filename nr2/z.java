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
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class z implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421168a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f421169b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421170c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final URLImageView f421171d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final URLImageView f421172e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f421173f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f421174g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f421175h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f421176i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f421177j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f421178k;

    z(@NonNull View view, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull URLImageView uRLImageView, @NonNull URLImageView uRLImageView2, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView2, @NonNull View view2) {
        this.f421168a = view;
        this.f421169b = imageView;
        this.f421170c = linearLayout;
        this.f421171d = uRLImageView;
        this.f421172e = uRLImageView2;
        this.f421173f = textView;
        this.f421174g = relativeLayout;
        this.f421175h = textView2;
        this.f421176i = textView3;
        this.f421177j = imageView2;
        this.f421178k = view2;
    }

    @NonNull
    public static z e(@NonNull View view) {
        int i3 = R.id.sco;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.sco);
        if (imageView != null) {
            i3 = R.id.b9r;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.b9r);
            if (linearLayout != null) {
                i3 = R.id.vo_;
                URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.vo_);
                if (uRLImageView != null) {
                    i3 = R.id.voh;
                    URLImageView uRLImageView2 = (URLImageView) ViewBindings.findChildViewById(view, R.id.voh);
                    if (uRLImageView2 != null) {
                        i3 = R.id.voj;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.voj);
                        if (textView != null) {
                            i3 = R.id.von;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.von);
                            if (relativeLayout != null) {
                                i3 = R.id.vop;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.vop);
                                if (textView2 != null) {
                                    i3 = R.id.vor;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.vor);
                                    if (textView3 != null) {
                                        i3 = R.id.zbs;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.zbs);
                                        if (imageView2 != null) {
                                            i3 = R.id.f99565q5;
                                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f99565q5);
                                            if (findChildViewById != null) {
                                                return new z(view, imageView, linearLayout, uRLImageView, uRLImageView2, textView, relativeLayout, textView2, textView3, imageView2, findChildViewById);
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
    public static z f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hu5, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421168a;
    }
}
