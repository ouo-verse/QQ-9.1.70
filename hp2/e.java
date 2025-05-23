package hp2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405639a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f405640b;

    e(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.f405639a = linearLayout;
        this.f405640b = textView;
    }

    @NonNull
    public static e e(@NonNull View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.kbs);
        if (textView != null) {
            return new e((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.kbs)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405639a;
    }
}
