package ii2;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormSwitchItem;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f407714a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FormSwitchItem f407715b;

    b(@NonNull LinearLayout linearLayout, @NonNull FormSwitchItem formSwitchItem) {
        this.f407714a = linearLayout;
        this.f407715b = formSwitchItem;
    }

    @NonNull
    public static b e(@NonNull View view) {
        FormSwitchItem formSwitchItem = (FormSwitchItem) ViewBindings.findChildViewById(view, R.id.f635333s);
        if (formSwitchItem != null) {
            return new b((LinearLayout) view, formSwitchItem);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f635333s)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f407714a;
    }
}
