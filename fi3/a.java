package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.sqshow.zootopia.view.ZootopiaDragLayout;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ZootopiaDragLayout f398766a;

    /* renamed from: b, reason: collision with root package name */
    public final View f398767b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f398768c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f398769d;

    /* renamed from: e, reason: collision with root package name */
    public final ZootopiaDragLayout f398770e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f398771f;

    /* renamed from: g, reason: collision with root package name */
    public final RoundRelativeLayout f398772g;

    /* renamed from: h, reason: collision with root package name */
    public final RelativeLayout f398773h;

    a(ZootopiaDragLayout zootopiaDragLayout, View view, FrameLayout frameLayout, FrameLayout frameLayout2, ZootopiaDragLayout zootopiaDragLayout2, ImageView imageView, RoundRelativeLayout roundRelativeLayout, RelativeLayout relativeLayout) {
        this.f398766a = zootopiaDragLayout;
        this.f398767b = view;
        this.f398768c = frameLayout;
        this.f398769d = frameLayout2;
        this.f398770e = zootopiaDragLayout2;
        this.f398771f = imageView;
        this.f398772g = roundRelativeLayout;
        this.f398773h = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ZootopiaDragLayout getRoot() {
        return this.f398766a;
    }

    public static a e(View view) {
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
                    i3 = R.id.pqj;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pqj);
                    if (imageView != null) {
                        i3 = R.id.qbn;
                        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) ViewBindings.findChildViewById(view, R.id.qbn);
                        if (roundRelativeLayout != null) {
                            i3 = R.id.f163510qi3;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163510qi3);
                            if (relativeLayout != null) {
                                return new a(zootopiaDragLayout, findChildViewById, frameLayout, frameLayout2, zootopiaDragLayout, imageView, roundRelativeLayout, relativeLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static a g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d2y, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
