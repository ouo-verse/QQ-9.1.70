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
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.team.impl.team.MicWaveViewLottie;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarSpeakingMicImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class bg implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f421026a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final AvatarSpeakingMicImageView f421027b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final MicWaveViewLottie f421028c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f421029d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final URLImageView f421030e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final AvatarRoundImageView f421031f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final AvatarTextView f421032g;

    bg(@NonNull ConstraintLayout constraintLayout, @NonNull AvatarSpeakingMicImageView avatarSpeakingMicImageView, @NonNull MicWaveViewLottie micWaveViewLottie, @NonNull TextView textView, @NonNull URLImageView uRLImageView, @NonNull AvatarRoundImageView avatarRoundImageView, @NonNull AvatarTextView avatarTextView) {
        this.f421026a = constraintLayout;
        this.f421027b = avatarSpeakingMicImageView;
        this.f421028c = micWaveViewLottie;
        this.f421029d = textView;
        this.f421030e = uRLImageView;
        this.f421031f = avatarRoundImageView;
        this.f421032g = avatarTextView;
    }

    @NonNull
    public static bg e(@NonNull View view) {
        int i3 = R.id.f166253z64;
        AvatarSpeakingMicImageView avatarSpeakingMicImageView = (AvatarSpeakingMicImageView) ViewBindings.findChildViewById(view, R.id.f166253z64);
        if (avatarSpeakingMicImageView != null) {
            i3 = R.id.z65;
            MicWaveViewLottie micWaveViewLottie = (MicWaveViewLottie) ViewBindings.findChildViewById(view, R.id.z65);
            if (micWaveViewLottie != null) {
                i3 = R.id.zwn;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.zwn);
                if (textView != null) {
                    i3 = R.id.f114846uf;
                    URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.f114846uf);
                    if (uRLImageView != null) {
                        i3 = R.id.f114866uh;
                        AvatarRoundImageView avatarRoundImageView = (AvatarRoundImageView) ViewBindings.findChildViewById(view, R.id.f114866uh);
                        if (avatarRoundImageView != null) {
                            i3 = R.id.f115026ux;
                            AvatarTextView avatarTextView = (AvatarTextView) ViewBindings.findChildViewById(view, R.id.f115026ux);
                            if (avatarTextView != null) {
                                return new bg((ConstraintLayout) view, avatarSpeakingMicImageView, micWaveViewLottie, textView, uRLImageView, avatarRoundImageView, avatarTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bg g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hxv, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f421026a;
    }
}
