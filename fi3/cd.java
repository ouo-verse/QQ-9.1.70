package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cd implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f399238a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f399239b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f399240c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f399241d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399242e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f399243f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f399244g;

    cd(LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout2, TextView textView2, ImageView imageView, FrameLayout frameLayout2) {
        this.f399238a = linearLayout;
        this.f399239b = textView;
        this.f399240c = frameLayout;
        this.f399241d = linearLayout2;
        this.f399242e = textView2;
        this.f399243f = imageView;
        this.f399244g = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f399238a;
    }

    public static cd g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static cd e(View view) {
        int i3 = R.id.pmh;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pmh);
        if (textView != null) {
            i3 = R.id.qbf;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qbf);
            if (frameLayout != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i3 = R.id.f163575qv3;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f163575qv3);
                if (textView2 != null) {
                    i3 = R.id.qv5;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qv5);
                    if (imageView != null) {
                        i3 = R.id.r2i;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.r2i);
                        if (frameLayout2 != null) {
                            return new cd(linearLayout, textView, frameLayout, linearLayout, textView2, imageView, frameLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cd h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167468dh2, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
