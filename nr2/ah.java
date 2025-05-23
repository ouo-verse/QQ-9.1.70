package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ah implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f420806a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f420807b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f420808c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final AvatarRoundImageView f420809d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f420810e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final AvatarTextView f420811f;

    ah(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull AvatarRoundImageView avatarRoundImageView, @NonNull TextView textView3, @NonNull AvatarTextView avatarTextView) {
        this.f420806a = constraintLayout;
        this.f420807b = textView;
        this.f420808c = textView2;
        this.f420809d = avatarRoundImageView;
        this.f420810e = textView3;
        this.f420811f = avatarTextView;
    }

    @NonNull
    public static ah e(@NonNull View view) {
        int i3 = R.id.sf9;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sf9);
        if (textView != null) {
            i3 = R.id.suw;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.suw);
            if (textView2 != null) {
                i3 = R.id.t0v;
                AvatarRoundImageView avatarRoundImageView = (AvatarRoundImageView) ViewBindings.findChildViewById(view, R.id.t0v);
                if (avatarRoundImageView != null) {
                    i3 = R.id.xhg;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.xhg);
                    if (textView3 != null) {
                        i3 = R.id.f115016uw;
                        AvatarTextView avatarTextView = (AvatarTextView) ViewBindings.findChildViewById(view, R.id.f115016uw);
                        if (avatarTextView != null) {
                            return new ah((ConstraintLayout) view, textView, textView2, avatarRoundImageView, textView3, avatarTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ah g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hvi, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f420806a;
    }
}
