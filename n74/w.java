package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class w implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419457a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f419458b;

    /* renamed from: c, reason: collision with root package name */
    public final RoundCornerImageView f419459c;

    /* renamed from: d, reason: collision with root package name */
    public final URLImageView f419460d;

    /* renamed from: e, reason: collision with root package name */
    public final URLImageView f419461e;

    w(View view, FrameLayout frameLayout, RoundCornerImageView roundCornerImageView, URLImageView uRLImageView, URLImageView uRLImageView2) {
        this.f419457a = view;
        this.f419458b = frameLayout;
        this.f419459c = roundCornerImageView;
        this.f419460d = uRLImageView;
        this.f419461e = uRLImageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419457a;
    }

    public static w e(View view) {
        int i3 = R.id.pkp;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pkp);
        if (frameLayout != null) {
            i3 = R.id.q2w;
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.q2w);
            if (roundCornerImageView != null) {
                i3 = R.id.q4p;
                URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.q4p);
                if (uRLImageView != null) {
                    i3 = R.id.qhs;
                    URLImageView uRLImageView2 = (URLImageView) ViewBindings.findChildViewById(view, R.id.qhs);
                    if (uRLImageView2 != null) {
                        return new w(view, frameLayout, roundCornerImageView, uRLImageView, uRLImageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static w f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d_k, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
