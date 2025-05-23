package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f418842a;

    /* renamed from: b, reason: collision with root package name */
    public final ZPlanMediaView f418843b;

    /* renamed from: c, reason: collision with root package name */
    public final URLImageView f418844c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f418845d;

    /* renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f418846e;

    /* renamed from: f, reason: collision with root package name */
    public final View f418847f;

    bj(ConstraintLayout constraintLayout, ZPlanMediaView zPlanMediaView, URLImageView uRLImageView, TextView textView, ConstraintLayout constraintLayout2, View view) {
        this.f418842a = constraintLayout;
        this.f418843b = zPlanMediaView;
        this.f418844c = uRLImageView;
        this.f418845d = textView;
        this.f418846e = constraintLayout2;
        this.f418847f = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f418842a;
    }

    public static bj e(View view) {
        int i3 = R.id.r4w;
        ZPlanMediaView zPlanMediaView = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.r4w);
        if (zPlanMediaView != null) {
            i3 = R.id.r4x;
            URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.r4x);
            if (uRLImageView != null) {
                i3 = R.id.r4y;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.r4y);
                if (textView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i3 = R.id.r8e;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.r8e);
                    if (findChildViewById != null) {
                        return new bj(constraintLayout, zPlanMediaView, uRLImageView, textView, constraintLayout, findChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bj g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dcm, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
