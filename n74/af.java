package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.nativeui.view.experience.ExperienceCountdownView;
import com.tencent.sqshow.zootopia.nativeui.view.history.AvatarHistoryControlView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class af implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418606a;

    /* renamed from: b, reason: collision with root package name */
    public final ExperienceCountdownView f418607b;

    /* renamed from: c, reason: collision with root package name */
    public final AvatarHistoryControlView f418608c;

    af(View view, ExperienceCountdownView experienceCountdownView, AvatarHistoryControlView avatarHistoryControlView) {
        this.f418606a = view;
        this.f418607b = experienceCountdownView;
        this.f418608c = avatarHistoryControlView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418606a;
    }

    public static af e(View view) {
        int i3 = R.id.pkw;
        ExperienceCountdownView experienceCountdownView = (ExperienceCountdownView) ViewBindings.findChildViewById(view, R.id.pkw);
        if (experienceCountdownView != null) {
            i3 = R.id.pzo;
            AvatarHistoryControlView avatarHistoryControlView = (AvatarHistoryControlView) ViewBindings.findChildViewById(view, R.id.pzo);
            if (avatarHistoryControlView != null) {
                return new af(view, experienceCountdownView, avatarHistoryControlView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static af f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f167433da2, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
