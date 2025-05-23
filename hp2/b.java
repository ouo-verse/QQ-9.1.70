package hp2;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405628a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405629b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f405630c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final c f405631d;

    b(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull c cVar) {
        this.f405628a = constraintLayout;
        this.f405629b = linearLayout;
        this.f405630c = recyclerView;
        this.f405631d = cVar;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.bwi;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.bwi);
        if (linearLayout != null) {
            i3 = R.id.f71843p9;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f71843p9);
            if (recyclerView != null) {
                i3 = R.id.f81234dm;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f81234dm);
                if (findChildViewById != null) {
                    return new b((ConstraintLayout) view, linearLayout, recyclerView, c.e(findChildViewById));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405628a;
    }
}
