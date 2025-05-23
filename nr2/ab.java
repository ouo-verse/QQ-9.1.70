package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.widget.chat.ChatFloatingMessageLayout;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ab implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f420758a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ChatFloatingMessageLayout f420759b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ChatFloatingMessageLayout f420760c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f420761d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f420762e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f420763f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f420764g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f420765h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f420766i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f420767j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420768k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f420769l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420770m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f420771n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f420772o;

    ab(@NonNull ConstraintLayout constraintLayout, @NonNull ChatFloatingMessageLayout chatFloatingMessageLayout, @NonNull ChatFloatingMessageLayout chatFloatingMessageLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull ImageView imageView7, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView8, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull ConstraintLayout constraintLayout2) {
        this.f420758a = constraintLayout;
        this.f420759b = chatFloatingMessageLayout;
        this.f420760c = chatFloatingMessageLayout2;
        this.f420761d = imageView;
        this.f420762e = imageView2;
        this.f420763f = imageView3;
        this.f420764g = imageView4;
        this.f420765h = imageView5;
        this.f420766i = imageView6;
        this.f420767j = imageView7;
        this.f420768k = linearLayout;
        this.f420769l = imageView8;
        this.f420770m = linearLayout2;
        this.f420771n = relativeLayout;
        this.f420772o = constraintLayout2;
    }

    @NonNull
    public static ab e(@NonNull View view) {
        int i3 = R.id.sny;
        ChatFloatingMessageLayout chatFloatingMessageLayout = (ChatFloatingMessageLayout) ViewBindings.findChildViewById(view, R.id.sny);
        if (chatFloatingMessageLayout != null) {
            i3 = R.id.snz;
            ChatFloatingMessageLayout chatFloatingMessageLayout2 = (ChatFloatingMessageLayout) ViewBindings.findChildViewById(view, R.id.snz);
            if (chatFloatingMessageLayout2 != null) {
                i3 = R.id.f634233h;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f634233h);
                if (imageView != null) {
                    i3 = R.id.f634333i;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f634333i);
                    if (imageView2 != null) {
                        i3 = R.id.f634433j;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f634433j);
                        if (imageView3 != null) {
                            i3 = R.id.f634533k;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f634533k);
                            if (imageView4 != null) {
                                i3 = R.id.f634633l;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.f634633l);
                                if (imageView5 != null) {
                                    i3 = R.id.f6365344;
                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.f6365344);
                                    if (imageView6 != null) {
                                        i3 = R.id.f6366345;
                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, R.id.f6366345);
                                        if (imageView7 != null) {
                                            i3 = R.id.f6367346;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f6367346);
                                            if (linearLayout != null) {
                                                i3 = R.id.f6368347;
                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, R.id.f6368347);
                                                if (imageView8 != null) {
                                                    i3 = R.id.f6369348;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f6369348);
                                                    if (linearLayout2 != null) {
                                                        i3 = R.id.f6370349;
                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f6370349);
                                                        if (relativeLayout != null) {
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                            return new ab(constraintLayout, chatFloatingMessageLayout, chatFloatingMessageLayout2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout, imageView8, linearLayout2, relativeLayout, constraintLayout);
                                                        }
                                                    }
                                                }
                                            }
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
    public static ab g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.huo, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMRv() {
        return this.f420758a;
    }
}
