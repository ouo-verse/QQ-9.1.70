package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.sqshow.zootopia.view.ZootopiaDragLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ZootopiaDragLayout f418956a;

    /* renamed from: b, reason: collision with root package name */
    public final View f418957b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f418958c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f418959d;

    /* renamed from: e, reason: collision with root package name */
    public final ZootopiaDragLayout f418960e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f418961f;

    /* renamed from: g, reason: collision with root package name */
    public final RoundRelativeLayout f418962g;

    c(ZootopiaDragLayout zootopiaDragLayout, View view, FrameLayout frameLayout, FrameLayout frameLayout2, ZootopiaDragLayout zootopiaDragLayout2, ImageView imageView, RoundRelativeLayout roundRelativeLayout) {
        this.f418956a = zootopiaDragLayout;
        this.f418957b = view;
        this.f418958c = frameLayout;
        this.f418959d = frameLayout2;
        this.f418960e = zootopiaDragLayout2;
        this.f418961f = imageView;
        this.f418962g = roundRelativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ZootopiaDragLayout getRoot() {
        return this.f418956a;
    }

    public static c e(View view) {
        int i3 = R.id.pdu;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pdu);
        if (findChildViewById != null) {
            i3 = R.id.per;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.per);
            if (frameLayout != null) {
                i3 = R.id.pm_;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pm_);
                if (frameLayout2 != null) {
                    ZootopiaDragLayout zootopiaDragLayout = (ZootopiaDragLayout) view;
                    i3 = R.id.pqk;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pqk);
                    if (imageView != null) {
                        i3 = R.id.qbn;
                        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) ViewBindings.findChildViewById(view, R.id.qbn);
                        if (roundRelativeLayout != null) {
                            return new c(zootopiaDragLayout, findChildViewById, frameLayout, frameLayout2, zootopiaDragLayout, imageView, roundRelativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static c g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d7_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
