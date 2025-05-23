package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bg implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f418825a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418826b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f418827c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f418828d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f418829e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f418830f;

    /* renamed from: g, reason: collision with root package name */
    public final NativePanelLoadingIgv f418831g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f418832h;

    /* renamed from: i, reason: collision with root package name */
    public final RelativeLayout f418833i;

    bg(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, NativePanelLoadingIgv nativePanelLoadingIgv, ImageView imageView2, RelativeLayout relativeLayout) {
        this.f418825a = constraintLayout;
        this.f418826b = imageView;
        this.f418827c = constraintLayout2;
        this.f418828d = constraintLayout3;
        this.f418829e = textView;
        this.f418830f = textView2;
        this.f418831g = nativePanelLoadingIgv;
        this.f418832h = imageView2;
        this.f418833i = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f418825a;
    }

    public static bg g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bg e(View view) {
        int i3 = R.id.pax;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pax);
        if (imageView != null) {
            i3 = R.id.pdn;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.pdn);
            if (constraintLayout != null) {
                i3 = R.id.peg;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.peg);
                if (constraintLayout2 != null) {
                    i3 = R.id.peh;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.peh);
                    if (textView != null) {
                        i3 = R.id.pei;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pei);
                        if (textView2 != null) {
                            i3 = R.id.q6m;
                            NativePanelLoadingIgv nativePanelLoadingIgv = (NativePanelLoadingIgv) ViewBindings.findChildViewById(view, R.id.q6m);
                            if (nativePanelLoadingIgv != null) {
                                i3 = R.id.f163496qf4;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163496qf4);
                                if (imageView2 != null) {
                                    i3 = R.id.qf5;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qf5);
                                    if (relativeLayout != null) {
                                        return new bg((ConstraintLayout) view, imageView, constraintLayout, constraintLayout2, textView, textView2, nativePanelLoadingIgv, imageView2, relativeLayout);
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

    public static bg h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dcj, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
