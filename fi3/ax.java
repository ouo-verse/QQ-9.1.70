package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ax implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f398968a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f398969b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f398970c;

    /* renamed from: d, reason: collision with root package name */
    public final Button f398971d;

    /* renamed from: e, reason: collision with root package name */
    public final EditText f398972e;

    /* renamed from: f, reason: collision with root package name */
    public final Button f398973f;

    /* renamed from: g, reason: collision with root package name */
    public final Button f398974g;

    ax(LinearLayout linearLayout, EditText editText, Button button, Button button2, EditText editText2, Button button3, Button button4) {
        this.f398968a = linearLayout;
        this.f398969b = editText;
        this.f398970c = button;
        this.f398971d = button2;
        this.f398972e = editText2;
        this.f398973f = button3;
        this.f398974g = button4;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f398968a;
    }

    public static ax g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static ax e(View view) {
        int i3 = R.id.q99;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.q99);
        if (editText != null) {
            i3 = R.id.q9_;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.q9_);
            if (button != null) {
                i3 = R.id.q9a;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.q9a);
                if (button2 != null) {
                    i3 = R.id.qvl;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.qvl);
                    if (editText2 != null) {
                        i3 = R.id.qvm;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.qvm);
                        if (button3 != null) {
                            i3 = R.id.qvn;
                            Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.qvn);
                            if (button4 != null) {
                                return new ax((LinearLayout) view, editText, button, button2, editText2, button3, button4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ax h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dbe, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
