package p81;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeGreatMoveView;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f425758a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final Barrier f425759b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f425760c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f425761d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f425762e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f425763f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f425764g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f425765h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f425766i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final AIOPokeGreatMoveView f425767j;

    j(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull ImageView imageView, @NonNull LottieAnimationView lottieAnimationView, @NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull ProgressBar progressBar, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull AIOPokeGreatMoveView aIOPokeGreatMoveView) {
        this.f425758a = constraintLayout;
        this.f425759b = barrier;
        this.f425760c = imageView;
        this.f425761d = lottieAnimationView;
        this.f425762e = relativeLayout;
        this.f425763f = view;
        this.f425764g = progressBar;
        this.f425765h = imageView2;
        this.f425766i = imageView3;
        this.f425767j = aIOPokeGreatMoveView;
    }

    @NonNull
    public static j e(@NonNull View view) {
        int i3 = R.id.t4q;
        Barrier barrier = (Barrier) ViewBindings.findChildViewById(view, R.id.t4q);
        if (barrier != null) {
            i3 = R.id.f26170ct;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f26170ct);
            if (imageView != null) {
                i3 = R.id.f26180cu;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.f26180cu);
                if (lottieAnimationView != null) {
                    i3 = R.id.f26190cv;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f26190cv);
                    if (relativeLayout != null) {
                        i3 = R.id.f26200cw;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f26200cw);
                        if (findChildViewById != null) {
                            i3 = R.id.f26210cx;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.f26210cx);
                            if (progressBar != null) {
                                i3 = R.id.f26220cy;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f26220cy);
                                if (imageView2 != null) {
                                    i3 = R.id.f26230cz;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f26230cz);
                                    if (imageView3 != null) {
                                        i3 = R.id.f26240d0;
                                        AIOPokeGreatMoveView aIOPokeGreatMoveView = (AIOPokeGreatMoveView) ViewBindings.findChildViewById(view, R.id.f26240d0);
                                        if (aIOPokeGreatMoveView != null) {
                                            return new j((ConstraintLayout) view, barrier, imageView, lottieAnimationView, relativeLayout, findChildViewById, progressBar, imageView2, imageView3, aIOPokeGreatMoveView);
                                        }
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
    public static j g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167616dw2, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f425758a;
    }
}
