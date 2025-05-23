package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ai implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f420812a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f420813b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f420814c;

    ai(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull RoundCornerImageView roundCornerImageView) {
        this.f420812a = frameLayout;
        this.f420813b = textView;
        this.f420814c = roundCornerImageView;
    }

    @NonNull
    public static ai e(@NonNull View view) {
        int i3 = R.id.x_o;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.x_o);
        if (textView != null) {
            i3 = R.id.zzq;
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.zzq);
            if (roundCornerImageView != null) {
                return new ai((FrameLayout) view, textView, roundCornerImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ai g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hvl, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f420812a;
    }
}
