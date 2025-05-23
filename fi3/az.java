package fi3;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class az implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399000a;

    /* renamed from: b, reason: collision with root package name */
    public final View f399001b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f399002c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f399003d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399004e;

    az(ConstraintLayout constraintLayout, View view, RecyclerView recyclerView, ConstraintLayout constraintLayout2, TextView textView) {
        this.f399000a = constraintLayout;
        this.f399001b = view;
        this.f399002c = recyclerView;
        this.f399003d = constraintLayout2;
        this.f399004e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399000a;
    }

    public static az e(View view) {
        int i3 = R.id.f163513qj1;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f163513qj1);
        if (findChildViewById != null) {
            i3 = R.id.f163515qj3;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f163515qj3);
            if (recyclerView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i3 = R.id.qr6;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qr6);
                if (textView != null) {
                    return new az(constraintLayout, findChildViewById, recyclerView, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
