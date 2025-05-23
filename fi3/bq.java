package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bq implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399140a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f399141b;

    bq(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.f399140a = constraintLayout;
        this.f399141b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399140a;
    }

    public static bq g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bq e(View view) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f163639r71);
        if (recyclerView != null) {
            return new bq((ConstraintLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f163639r71)));
    }

    public static bq h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddq, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
