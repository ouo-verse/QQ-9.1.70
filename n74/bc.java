package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bc implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f418812a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418813b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f418814c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f418815d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f418816e;

    bc(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.f418812a = linearLayout;
        this.f418813b = imageView;
        this.f418814c = imageView2;
        this.f418815d = textView;
        this.f418816e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f418812a;
    }

    public static bc e(View view) {
        int i3 = R.id.f163439q44;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163439q44);
        if (imageView != null) {
            i3 = R.id.f163440q45;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163440q45);
            if (imageView2 != null) {
                i3 = R.id.qtp;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qtp);
                if (textView != null) {
                    i3 = R.id.qtr;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qtr);
                    if (textView2 != null) {
                        return new bc((LinearLayout) view, imageView, imageView2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bc g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dbs, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
