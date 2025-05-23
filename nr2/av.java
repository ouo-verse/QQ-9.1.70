package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.team.impl.floating.TeamFloatingStateView;
import com.tencent.timi.game.team.impl.floating.WaveAvatarRoundView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class av implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f420913a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f420914b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f420915c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f420916d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f420917e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f420918f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final Space f420919g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TeamFloatingStateView f420920h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final WaveAvatarRoundView f420921i;

    av(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView2, @NonNull View view, @NonNull FrameLayout frameLayout2, @NonNull Space space, @NonNull TeamFloatingStateView teamFloatingStateView, @NonNull WaveAvatarRoundView waveAvatarRoundView) {
        this.f420913a = frameLayout;
        this.f420914b = imageView;
        this.f420915c = constraintLayout;
        this.f420916d = imageView2;
        this.f420917e = view;
        this.f420918f = frameLayout2;
        this.f420919g = space;
        this.f420920h = teamFloatingStateView;
        this.f420921i = waveAvatarRoundView;
    }

    @NonNull
    public static av e(@NonNull View view) {
        int i3 = R.id.tzb;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.tzb);
        if (imageView != null) {
            i3 = R.id.vdt;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.vdt);
            if (constraintLayout != null) {
                i3 = R.id.f165393vt0;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165393vt0);
                if (imageView2 != null) {
                    i3 = R.id.f165394vt1;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.f165394vt1);
                    if (findChildViewById != null) {
                        i3 = R.id.f165395vt2;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f165395vt2);
                        if (frameLayout != null) {
                            i3 = R.id.iz9;
                            Space space = (Space) ViewBindings.findChildViewById(view, R.id.iz9);
                            if (space != null) {
                                i3 = R.id.f88044w0;
                                TeamFloatingStateView teamFloatingStateView = (TeamFloatingStateView) ViewBindings.findChildViewById(view, R.id.f88044w0);
                                if (teamFloatingStateView != null) {
                                    i3 = R.id.f120727_b;
                                    WaveAvatarRoundView waveAvatarRoundView = (WaveAvatarRoundView) ViewBindings.findChildViewById(view, R.id.f120727_b);
                                    if (waveAvatarRoundView != null) {
                                        return new av((FrameLayout) view, imageView, constraintLayout, imageView2, findChildViewById, frameLayout, space, teamFloatingStateView, waveAvatarRoundView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static av g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hwv, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getMContainer() {
        return this.f420913a;
    }
}
