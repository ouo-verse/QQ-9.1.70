package m53;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f416270a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f416271b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f416272c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f416273d;

    i(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull View view, @NonNull FrameLayout frameLayout) {
        this.f416270a = constraintLayout;
        this.f416271b = textView;
        this.f416272c = view;
        this.f416273d = frameLayout;
    }

    @NonNull
    public static i e(@NonNull View view) {
        int i3 = R.id.k4v;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.k4v);
        if (textView != null) {
            i3 = R.id.kme;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.kme);
            if (findChildViewById != null) {
                i3 = R.id.f115926xc;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f115926xc);
                if (frameLayout != null) {
                    return new i((ConstraintLayout) view, textView, findChildViewById, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static i g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static i h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e_z, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f416270a;
    }
}
