package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class o implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f399312a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f399313b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f399314c;

    o(FrameLayout frameLayout, LinearLayout linearLayout, RecyclerView recyclerView) {
        this.f399312a = frameLayout;
        this.f399313b = linearLayout;
        this.f399314c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f399312a;
    }

    public static o e(View view) {
        int i3 = R.id.prs;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.prs);
        if (linearLayout != null) {
            i3 = R.id.q5l;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.q5l);
            if (recyclerView != null) {
                return new o((FrameLayout) view, linearLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static o g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d7t, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
