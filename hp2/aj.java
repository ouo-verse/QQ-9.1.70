package hp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class aj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405591a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405592b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405593c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405594d;

    aj(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView) {
        this.f405591a = linearLayout;
        this.f405592b = linearLayout2;
        this.f405593c = linearLayout3;
        this.f405594d = textView;
    }

    @NonNull
    public static aj e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.f96535hy;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f96535hy);
        if (linearLayout2 != null) {
            i3 = R.id.f96725ig;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f96725ig);
            if (textView != null) {
                return new aj(linearLayout, linearLayout, linearLayout2, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static aj g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.h3e, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405591a;
    }
}
