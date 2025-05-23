package nr2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import com.tencent.timi.game.widget.MediumBoldTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class au implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f420898a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f420899b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final MediumBoldTextView f420900c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f420901d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ScrollView f420902e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f420903f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f420904g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f420905h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final MediumBoldTextView f420906i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final MediumBoldTextView f420907j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f420908k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final AvatarRoundImageView f420909l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final AvatarTextView f420910m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final FrameLayout f420911n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final RecyclerView f420912o;

    au(@NonNull FrameLayout frameLayout, @NonNull View view, @NonNull MediumBoldTextView mediumBoldTextView, @NonNull View view2, @NonNull ScrollView scrollView, @NonNull FrameLayout frameLayout2, @NonNull View view3, @NonNull RoundCornerImageView roundCornerImageView, @NonNull MediumBoldTextView mediumBoldTextView2, @NonNull MediumBoldTextView mediumBoldTextView3, @NonNull RelativeLayout relativeLayout, @NonNull AvatarRoundImageView avatarRoundImageView, @NonNull AvatarTextView avatarTextView, @NonNull FrameLayout frameLayout3, @NonNull RecyclerView recyclerView) {
        this.f420898a = frameLayout;
        this.f420899b = view;
        this.f420900c = mediumBoldTextView;
        this.f420901d = view2;
        this.f420902e = scrollView;
        this.f420903f = frameLayout2;
        this.f420904g = view3;
        this.f420905h = roundCornerImageView;
        this.f420906i = mediumBoldTextView2;
        this.f420907j = mediumBoldTextView3;
        this.f420908k = relativeLayout;
        this.f420909l = avatarRoundImageView;
        this.f420910m = avatarTextView;
        this.f420911n = frameLayout3;
        this.f420912o = recyclerView;
    }

    @NonNull
    public static au e(@NonNull View view) {
        int i3 = R.id.t67;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.t67);
        if (findChildViewById != null) {
            i3 = R.id.tlc;
            MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) ViewBindings.findChildViewById(view, R.id.tlc);
            if (mediumBoldTextView != null) {
                i3 = R.id.f164881u44;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f164881u44);
                if (findChildViewById2 != null) {
                    i3 = R.id.b9r;
                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.b9r);
                    if (scrollView != null) {
                        FrameLayout frameLayout = (FrameLayout) view;
                        i3 = R.id.lft;
                        View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.lft);
                        if (findChildViewById3 != null) {
                            i3 = R.id.vak;
                            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.vak);
                            if (roundCornerImageView != null) {
                                i3 = R.id.f166846in1;
                                MediumBoldTextView mediumBoldTextView2 = (MediumBoldTextView) ViewBindings.findChildViewById(view, R.id.f166846in1);
                                if (mediumBoldTextView2 != null) {
                                    i3 = R.id.f83064ik;
                                    MediumBoldTextView mediumBoldTextView3 = (MediumBoldTextView) ViewBindings.findChildViewById(view, R.id.f83064ik);
                                    if (mediumBoldTextView3 != null) {
                                        i3 = R.id.f84104lc;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f84104lc);
                                        if (relativeLayout != null) {
                                            i3 = R.id.f85504p5;
                                            AvatarRoundImageView avatarRoundImageView = (AvatarRoundImageView) ViewBindings.findChildViewById(view, R.id.f85504p5);
                                            if (avatarRoundImageView != null) {
                                                i3 = R.id.f85514p6;
                                                AvatarTextView avatarTextView = (AvatarTextView) ViewBindings.findChildViewById(view, R.id.f85514p6);
                                                if (avatarTextView != null) {
                                                    i3 = R.id.f114976us;
                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f114976us);
                                                    if (frameLayout2 != null) {
                                                        i3 = R.id.f115056v0;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f115056v0);
                                                        if (recyclerView != null) {
                                                            return new au(frameLayout, findChildViewById, mediumBoldTextView, findChildViewById2, scrollView, frameLayout, findChildViewById3, roundCornerImageView, mediumBoldTextView2, mediumBoldTextView3, relativeLayout, avatarRoundImageView, avatarTextView, frameLayout2, recyclerView);
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
    public static au g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static au h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hwt, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f420898a;
    }
}
