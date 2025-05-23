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
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f400108a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIButton f400109b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f400110c;

    b(@NonNull RelativeLayout relativeLayout, @NonNull QUIButton qUIButton, @NonNull FrameLayout frameLayout) {
        this.f400108a = relativeLayout;
        this.f400109b = qUIButton;
        this.f400110c = frameLayout;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.f164010gx;
        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.f164010gx);
        if (qUIButton != null) {
            i3 = R.id.bwi;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.bwi);
            if (frameLayout != null) {
                return new b((RelativeLayout) view, qUIButton, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168857h25, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f400108a;
    }
}
