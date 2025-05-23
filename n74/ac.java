package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ac implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f418587a;

    /* renamed from: b, reason: collision with root package name */
    public final View f418588b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f418589c;

    ac(LinearLayout linearLayout, View view, TextView textView) {
        this.f418587a = linearLayout;
        this.f418588b = view;
        this.f418589c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f418587a;
    }

    public static ac g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static ac e(View view) {
        int i3 = R.id.q5h;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.q5h);
        if (findChildViewById != null) {
            i3 = R.id.qqe;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qqe);
            if (textView != null) {
                return new ac((LinearLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ac h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_q, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
