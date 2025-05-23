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
public final class aj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f420815a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f420816b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f420817c;

    aj(@NonNull FrameLayout frameLayout, @NonNull RoundCornerImageView roundCornerImageView, @NonNull TextView textView) {
        this.f420815a = frameLayout;
        this.f420816b = roundCornerImageView;
        this.f420817c = textView;
    }

    @NonNull
    public static aj e(@NonNull View view) {
        int i3 = R.id.zzq;
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.zzq);
        if (roundCornerImageView != null) {
            i3 = R.id.f97585ks;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f97585ks);
            if (textView != null) {
                return new aj((FrameLayout) view, roundCornerImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static aj g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hvm, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f420815a;
    }
}
