package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f421061a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TimiGamePAGView f421062b;

    h(@NonNull FrameLayout frameLayout, @NonNull TimiGamePAGView timiGamePAGView) {
        this.f421061a = frameLayout;
        this.f421062b = timiGamePAGView;
    }

    @NonNull
    public static h e(@NonNull View view) {
        TimiGamePAGView timiGamePAGView = (TimiGamePAGView) ViewBindings.findChildViewById(view, R.id.u9s);
        if (timiGamePAGView != null) {
            return new h((FrameLayout) view, timiGamePAGView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.u9s)));
    }

    @NonNull
    public static h g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hst, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f421061a;
    }
}
