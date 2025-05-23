package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f421070a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final AvatarRoundImageView f421071b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final AvatarRoundImageView f421072c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final AvatarRoundImageView f421073d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f421074e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f421075f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f421076g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f421077h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final FrameLayout f421078i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f421079j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f421080k;

    j(@NonNull LinearLayout linearLayout, @NonNull AvatarRoundImageView avatarRoundImageView, @NonNull AvatarRoundImageView avatarRoundImageView2, @NonNull AvatarRoundImageView avatarRoundImageView3, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull TextView textView4) {
        this.f421070a = linearLayout;
        this.f421071b = avatarRoundImageView;
        this.f421072c = avatarRoundImageView2;
        this.f421073d = avatarRoundImageView3;
        this.f421074e = frameLayout;
        this.f421075f = textView;
        this.f421076g = textView2;
        this.f421077h = textView3;
        this.f421078i = frameLayout2;
        this.f421079j = frameLayout3;
        this.f421080k = textView4;
    }

    @NonNull
    public static j e(@NonNull View view) {
        int i3 = R.id.t0l;
        AvatarRoundImageView avatarRoundImageView = (AvatarRoundImageView) ViewBindings.findChildViewById(view, R.id.t0l);
        if (avatarRoundImageView != null) {
            i3 = R.id.t0r;
            AvatarRoundImageView avatarRoundImageView2 = (AvatarRoundImageView) ViewBindings.findChildViewById(view, R.id.t0r);
            if (avatarRoundImageView2 != null) {
                i3 = R.id.t0t;
                AvatarRoundImageView avatarRoundImageView3 = (AvatarRoundImageView) ViewBindings.findChildViewById(view, R.id.t0t);
                if (avatarRoundImageView3 != null) {
                    i3 = R.id.v6n;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.v6n);
                    if (frameLayout != null) {
                        i3 = R.id.f80144ao;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f80144ao);
                        if (textView != null) {
                            i3 = R.id.f80154ap;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f80154ap);
                            if (textView2 != null) {
                                i3 = R.id.f80164aq;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f80164aq);
                                if (textView3 != null) {
                                    i3 = R.id.f81594el;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f81594el);
                                    if (frameLayout2 != null) {
                                        i3 = R.id.f96445hp;
                                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f96445hp);
                                        if (frameLayout3 != null) {
                                            i3 = R.id.f100475sl;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f100475sl);
                                            if (textView4 != null) {
                                                return new j((LinearLayout) view, avatarRoundImageView, avatarRoundImageView2, avatarRoundImageView3, frameLayout, textView, textView2, textView3, frameLayout2, frameLayout3, textView4);
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
    public static j g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f169114ht4, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f421070a;
    }
}
