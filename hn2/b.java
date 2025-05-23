package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f405341a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405342b;

    b(@NonNull View view, @NonNull LinearLayout linearLayout) {
        this.f405341a = view;
        this.f405342b = linearLayout;
    }

    @NonNull
    public static b e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ycg);
        if (linearLayout != null) {
            return new b(view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.ycg)));
    }

    @NonNull
    public static b f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dsu, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f405341a;
    }
}
