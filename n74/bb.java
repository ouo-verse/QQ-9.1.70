package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bb implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f418808a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f418809b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f418810c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f418811d;

    bb(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, RecyclerView recyclerView) {
        this.f418808a = linearLayout;
        this.f418809b = textView;
        this.f418810c = linearLayout2;
        this.f418811d = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f418808a;
    }

    public static bb g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bb e(View view) {
        int i3 = R.id.qet;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qet);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.r2p);
            if (recyclerView != null) {
                return new bb(linearLayout, textView, linearLayout, recyclerView);
            }
            i3 = R.id.r2p;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bb h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dbr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
