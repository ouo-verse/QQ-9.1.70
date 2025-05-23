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
public final class ai implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405588a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405589b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405590c;

    ai(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView) {
        this.f405588a = constraintLayout;
        this.f405589b = constraintLayout2;
        this.f405590c = textView;
    }

    @NonNull
    public static ai e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.content);
        if (textView != null) {
            return new ai(constraintLayout, constraintLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.content)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405588a;
    }
}
