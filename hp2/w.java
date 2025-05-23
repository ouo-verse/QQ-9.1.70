package hp2;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class w implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405781a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f405782b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405783c;

    w(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull TextView textView) {
        this.f405781a = constraintLayout;
        this.f405782b = view;
        this.f405783c = textView;
    }

    @NonNull
    public static w e(@NonNull View view) {
        int i3 = R.id.djp;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.djp);
        if (findChildViewById != null) {
            i3 = R.id.jfb;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jfb);
            if (textView != null) {
                return new w((ConstraintLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405781a;
    }
}
