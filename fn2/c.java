package fn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f400111a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f400112b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUIButton f400113c;

    c(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout, @NonNull QUIButton qUIButton) {
        this.f400111a = relativeLayout;
        this.f400112b = frameLayout;
        this.f400113c = qUIButton;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.uzc;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.uzc);
        if (frameLayout != null) {
            i3 = R.id.i9b;
            QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.i9b);
            if (qUIButton != null) {
                return new c((RelativeLayout) view, frameLayout, qUIButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.h26, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f400111a;
    }
}
