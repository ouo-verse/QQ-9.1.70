package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f419351a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f419352b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f419353c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f419354d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f419355e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f419356f;

    j(LinearLayout linearLayout, Button button, Button button2, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f419351a = linearLayout;
        this.f419352b = button;
        this.f419353c = button2;
        this.f419354d = recyclerView;
        this.f419355e = textView;
        this.f419356f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f419351a;
    }

    public static j g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static j e(View view) {
        int i3 = R.id.pg6;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.pg6);
        if (button != null) {
            i3 = R.id.pgf;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.pgf);
            if (button2 != null) {
                i3 = R.id.qgq;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.qgq);
                if (recyclerView != null) {
                    i3 = R.id.qtd;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qtd);
                    if (textView != null) {
                        i3 = R.id.que;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.que);
                        if (textView2 != null) {
                            return new j((LinearLayout) view, button, button2, recyclerView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static j h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_4, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
