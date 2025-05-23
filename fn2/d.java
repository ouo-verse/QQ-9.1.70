package fn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f400114a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f400115b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ScanningLightView f400116c;

    d(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull ScanningLightView scanningLightView) {
        this.f400114a = constraintLayout;
        this.f400115b = linearLayout;
        this.f400116c = scanningLightView;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.a39;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.a39);
        if (linearLayout != null) {
            i3 = R.id.f79704_h;
            ScanningLightView scanningLightView = (ScanningLightView) ViewBindings.findChildViewById(view, R.id.f79704_h);
            if (scanningLightView != null) {
                return new d((ConstraintLayout) view, linearLayout, scanningLightView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static d g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.h27, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f400114a;
    }
}
