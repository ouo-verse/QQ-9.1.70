package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class br implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418897a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f418898b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f418899c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f418900d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f418901e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f418902f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f418903g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f418904h;

    /* renamed from: i, reason: collision with root package name */
    public final RelativeLayout f418905i;

    br(View view, LinearLayout linearLayout, TextView textView, ImageView imageView, RecyclerView recyclerView, FrameLayout frameLayout, ImageView imageView2, TextView textView2, RelativeLayout relativeLayout) {
        this.f418897a = view;
        this.f418898b = linearLayout;
        this.f418899c = textView;
        this.f418900d = imageView;
        this.f418901e = recyclerView;
        this.f418902f = frameLayout;
        this.f418903g = imageView2;
        this.f418904h = textView2;
        this.f418905i = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418897a;
    }

    public static br e(View view) {
        int i3 = R.id.qfm;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qfm);
        if (linearLayout != null) {
            i3 = R.id.qfn;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qfn);
            if (textView != null) {
                i3 = R.id.qfo;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qfo);
                if (imageView != null) {
                    i3 = R.id.qfq;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.qfq);
                    if (recyclerView != null) {
                        i3 = R.id.qfr;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qfr);
                        if (frameLayout != null) {
                            i3 = R.id.qfs;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.qfs);
                            if (imageView2 != null) {
                                i3 = R.id.qft;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qft);
                                if (textView2 != null) {
                                    i3 = R.id.qfu;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qfu);
                                    if (relativeLayout != null) {
                                        return new br(view, linearLayout, textView, imageView, recyclerView, frameLayout, imageView2, textView2, relativeLayout);
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

    public static br f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f167452de1, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
