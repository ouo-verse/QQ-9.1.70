package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class z implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f399439a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f399440b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f399441c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f399442d;

    z(RelativeLayout relativeLayout, ImageView imageView, TextView textView, ImageView imageView2) {
        this.f399439a = relativeLayout;
        this.f399440b = imageView;
        this.f399441c = textView;
        this.f399442d = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f399439a;
    }

    public static z e(View view) {
        int i3 = R.id.psm;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.psm);
        if (imageView != null) {
            i3 = R.id.psp;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.psp);
            if (textView != null) {
                i3 = R.id.q6d;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.q6d);
                if (imageView2 != null) {
                    return new z((RelativeLayout) view, imageView, textView, imageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static z g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d8u, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
