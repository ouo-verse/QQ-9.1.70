package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cv implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f419166a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419167b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f419168c;

    /* renamed from: d, reason: collision with root package name */
    public final bh f419169d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f419170e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f419171f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f419172g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f419173h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f419174i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f419175j;

    cv(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, bh bhVar, TextView textView2, LinearLayout linearLayout, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, TextView textView3) {
        this.f419166a = constraintLayout;
        this.f419167b = imageView;
        this.f419168c = textView;
        this.f419169d = bhVar;
        this.f419170e = textView2;
        this.f419171f = linearLayout;
        this.f419172g = imageView2;
        this.f419173h = imageView3;
        this.f419174i = linearLayout2;
        this.f419175j = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f419166a;
    }

    public static cv e(View view) {
        int i3 = R.id.pnh;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pnh);
        if (imageView != null) {
            i3 = R.id.pnj;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pnj);
            if (textView != null) {
                i3 = R.id.pxe;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.pxe);
                if (findChildViewById != null) {
                    bh e16 = bh.e(findChildViewById);
                    i3 = R.id.pxf;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pxf);
                    if (textView2 != null) {
                        i3 = R.id.pxg;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pxg);
                        if (linearLayout != null) {
                            i3 = R.id.pxh;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pxh);
                            if (imageView2 != null) {
                                i3 = R.id.pxi;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.pxi);
                                if (imageView3 != null) {
                                    i3 = R.id.pxj;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pxj);
                                    if (linearLayout2 != null) {
                                        i3 = R.id.pxo;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.pxo);
                                        if (textView3 != null) {
                                            return new cv((ConstraintLayout) view, imageView, textView, e16, textView2, linearLayout, imageView2, imageView3, linearLayout2, textView3);
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

    public static cv g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.df9, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
