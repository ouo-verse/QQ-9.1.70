package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class r implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f419399a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f419400b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f419401c;

    r(LinearLayout linearLayout, Button button, Button button2) {
        this.f419399a = linearLayout;
        this.f419400b = button;
        this.f419401c = button2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f419399a;
    }

    public static r g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static r e(View view) {
        int i3 = R.id.pfh;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.pfh);
        if (button != null) {
            i3 = R.id.pgi;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.pgi);
            if (button2 != null) {
                return new r((LinearLayout) view, button, button2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static r h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_d, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
