package n74;

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
import com.tencent.sqshow.zootopia.avatar.loading.anim.ZPlanLoadingAnimView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class al implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f418660a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f418661b;

    /* renamed from: c, reason: collision with root package name */
    public final View f418662c;

    /* renamed from: d, reason: collision with root package name */
    public final ZPlanLoadingAnimView f418663d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f418664e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f418665f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f418666g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f418667h;

    /* renamed from: i, reason: collision with root package name */
    public final View f418668i;

    /* renamed from: j, reason: collision with root package name */
    public final View f418669j;

    al(FrameLayout frameLayout, LinearLayout linearLayout, View view, ZPlanLoadingAnimView zPlanLoadingAnimView, ImageView imageView, TextView textView, TextView textView2, TextView textView3, View view2, View view3) {
        this.f418660a = frameLayout;
        this.f418661b = linearLayout;
        this.f418662c = view;
        this.f418663d = zPlanLoadingAnimView;
        this.f418664e = imageView;
        this.f418665f = textView;
        this.f418666g = textView2;
        this.f418667h = textView3;
        this.f418668i = view2;
        this.f418669j = view3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f418660a;
    }

    public static al e(View view) {
        int i3 = R.id.pdo;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pdo);
        if (linearLayout != null) {
            i3 = R.id.pem;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.pem);
            if (findChildViewById != null) {
                i3 = R.id.f163447q60;
                ZPlanLoadingAnimView zPlanLoadingAnimView = (ZPlanLoadingAnimView) ViewBindings.findChildViewById(view, R.id.f163447q60);
                if (zPlanLoadingAnimView != null) {
                    i3 = R.id.f163449q62;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163449q62);
                    if (imageView != null) {
                        i3 = R.id.q6g;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.q6g);
                        if (textView != null) {
                            i3 = R.id.q6k;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.q6k);
                            if (textView2 != null) {
                                i3 = R.id.q6l;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.q6l);
                                if (textView3 != null) {
                                    i3 = R.id.qs8;
                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.qs8);
                                    if (findChildViewById2 != null) {
                                        i3 = R.id.qs_;
                                        View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.qs_);
                                        if (findChildViewById3 != null) {
                                            return new al((FrameLayout) view, linearLayout, findChildViewById, zPlanLoadingAnimView, imageView, textView, textView2, textView3, findChildViewById2, findChildViewById3);
                                        }
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

    public static al g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.da8, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
