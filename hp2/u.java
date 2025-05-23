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
public final class u implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405750a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405751b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405752c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405753d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f405754e;

    u(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f405750a = constraintLayout;
        this.f405751b = constraintLayout2;
        this.f405752c = textView;
        this.f405753d = textView2;
        this.f405754e = textView3;
    }

    @NonNull
    public static u e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i3 = R.id.f110136hp;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f110136hp);
        if (textView != null) {
            i3 = R.id.f110916jt;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f110916jt);
            if (textView2 != null) {
                i3 = R.id.f110926ju;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f110926ju);
                if (textView3 != null) {
                    return new u(constraintLayout, constraintLayout, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405750a;
    }
}
