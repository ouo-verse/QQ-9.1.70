package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.robot.aio.story.StoryBlurBgView;
import com.tencent.robot.aio.story.StoryTransitionView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class q implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405406a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final StoryBlurBgView f405407b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f405408c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f405409d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f405410e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f405411f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final StoryTransitionView f405412g;

    q(@NonNull ConstraintLayout constraintLayout, @NonNull StoryBlurBgView storyBlurBgView, @NonNull ImageView imageView, @NonNull LottieAnimationView lottieAnimationView, @NonNull LottieAnimationView lottieAnimationView2, @NonNull TextView textView, @NonNull StoryTransitionView storyTransitionView) {
        this.f405406a = constraintLayout;
        this.f405407b = storyBlurBgView;
        this.f405408c = imageView;
        this.f405409d = lottieAnimationView;
        this.f405410e = lottieAnimationView2;
        this.f405411f = textView;
        this.f405412g = storyTransitionView;
    }

    @NonNull
    public static q e(@NonNull View view) {
        int i3 = R.id.f774944i;
        StoryBlurBgView storyBlurBgView = (StoryBlurBgView) ViewBindings.findChildViewById(view, R.id.f774944i);
        if (storyBlurBgView != null) {
            i3 = R.id.f775044j;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f775044j);
            if (imageView != null) {
                i3 = R.id.f775144k;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.f775144k);
                if (lottieAnimationView != null) {
                    i3 = R.id.f775244l;
                    LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.f775244l);
                    if (lottieAnimationView2 != null) {
                        i3 = R.id.f775344m;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f775344m);
                        if (textView != null) {
                            i3 = R.id.f775444n;
                            StoryTransitionView storyTransitionView = (StoryTransitionView) ViewBindings.findChildViewById(view, R.id.f775444n);
                            if (storyTransitionView != null) {
                                return new q((ConstraintLayout) view, storyBlurBgView, imageView, lottieAnimationView, lottieAnimationView2, textView, storyTransitionView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static q g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static q h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hpa, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405406a;
    }
}
