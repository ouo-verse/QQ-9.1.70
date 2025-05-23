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
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f416192a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f416193b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f416194c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f416195d;

    b(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull View view) {
        this.f416192a = constraintLayout;
        this.f416193b = textView;
        this.f416194c = textView2;
        this.f416195d = view;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.f1052165e;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f1052165e);
        if (textView != null) {
            i3 = R.id.f1057066q;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f1057066q);
            if (textView2 != null) {
                i3 = R.id.f115986xi;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f115986xi);
                if (findChildViewById != null) {
                    return new b((ConstraintLayout) view, textView, textView2, findChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static b h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e9x, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f416192a;
    }
}
