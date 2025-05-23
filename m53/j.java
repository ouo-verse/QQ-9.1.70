package m53;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f416274a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f416275b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f416276c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f416277d;

    j(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull TextView textView) {
        this.f416274a = constraintLayout;
        this.f416275b = view;
        this.f416276c = view2;
        this.f416277d = textView;
    }

    @NonNull
    public static j e(@NonNull View view) {
        int i3 = R.id.icon;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.icon);
        if (findChildViewById != null) {
            i3 = R.id.f165756xi3;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f165756xi3);
            if (findChildViewById2 != null) {
                i3 = R.id.tv_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_name);
                if (textView != null) {
                    return new j((ConstraintLayout) view, findChildViewById, findChildViewById2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static j g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fd8, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f416274a;
    }
}
