package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cb implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f399226a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f399227b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f399228c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f399229d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f399230e;

    cb(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, FrameLayout frameLayout3, FrameLayout frameLayout4) {
        this.f399226a = frameLayout;
        this.f399227b = frameLayout2;
        this.f399228c = imageView;
        this.f399229d = frameLayout3;
        this.f399230e = frameLayout4;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f399226a;
    }

    public static cb g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static cb e(View view) {
        int i3 = R.id.f163289pb2;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f163289pb2);
        if (frameLayout != null) {
            i3 = R.id.pdq;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pdq);
            if (imageView != null) {
                i3 = R.id.pzm;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pzm);
                if (frameLayout2 != null) {
                    i3 = R.id.q67;
                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q67);
                    if (frameLayout3 != null) {
                        return new cb((FrameLayout) view, frameLayout, imageView, frameLayout2, frameLayout3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cb h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dgz, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
