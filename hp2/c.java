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
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405632a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f405633b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405634c;

    c(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2) {
        this.f405632a = constraintLayout;
        this.f405633b = textView;
        this.f405634c = constraintLayout2;
    }

    @NonNull
    public static c e(@NonNull View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.zij);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new c(constraintLayout, textView, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.zij)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405632a;
    }
}
