package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarTextViewImpl;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class as implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f420873a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f420874b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f420875c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f420876d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final URLImageView f420877e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f420878f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f420879g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f420880h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final FrameLayout f420881i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f420882j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f420883k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TimiAvatarRoundImageViewImpl f420884l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420885m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f420886n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f420887o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f420888p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final ImageView f420889q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final TimiAvatarTextViewImpl f420890r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final TextView f420891s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    public final TextView f420892t;

    as(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull URLImageView uRLImageView, @NonNull ImageView imageView4, @NonNull FrameLayout frameLayout2, @NonNull TextView textView, @NonNull FrameLayout frameLayout3, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TimiAvatarRoundImageViewImpl timiAvatarRoundImageViewImpl, @NonNull LinearLayout linearLayout, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull ImageView imageView5, @NonNull TimiAvatarTextViewImpl timiAvatarTextViewImpl, @NonNull TextView textView7, @NonNull TextView textView8) {
        this.f420873a = frameLayout;
        this.f420874b = imageView;
        this.f420875c = imageView2;
        this.f420876d = imageView3;
        this.f420877e = uRLImageView;
        this.f420878f = imageView4;
        this.f420879g = frameLayout2;
        this.f420880h = textView;
        this.f420881i = frameLayout3;
        this.f420882j = textView2;
        this.f420883k = textView3;
        this.f420884l = timiAvatarRoundImageViewImpl;
        this.f420885m = linearLayout;
        this.f420886n = textView4;
        this.f420887o = textView5;
        this.f420888p = textView6;
        this.f420889q = imageView5;
        this.f420890r = timiAvatarTextViewImpl;
        this.f420891s = textView7;
        this.f420892t = textView8;
    }

    @NonNull
    public static as e(@NonNull View view) {
        int i3 = R.id.scn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.scn);
        if (imageView != null) {
            i3 = R.id.swf;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.swf);
            if (imageView2 != null) {
                i3 = R.id.uel;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.uel);
                if (imageView3 != null) {
                    i3 = R.id.x_4;
                    URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.x_4);
                    if (uRLImageView != null) {
                        i3 = R.id.ybz;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.ybz);
                        if (imageView4 != null) {
                            i3 = R.id.f165991yc0;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f165991yc0);
                            if (frameLayout != null) {
                                i3 = R.id.f165992yc1;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f165992yc1);
                                if (textView != null) {
                                    i3 = R.id.f166204yz4;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f166204yz4);
                                    if (frameLayout2 != null) {
                                        i3 = R.id.yz5;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.yz5);
                                        if (textView2 != null) {
                                            i3 = R.id.f8990511;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f8990511);
                                            if (textView3 != null) {
                                                i3 = R.id.f8991512;
                                                TimiAvatarRoundImageViewImpl timiAvatarRoundImageViewImpl = (TimiAvatarRoundImageViewImpl) ViewBindings.findChildViewById(view, R.id.f8991512);
                                                if (timiAvatarRoundImageViewImpl != null) {
                                                    i3 = R.id.f8992513;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f8992513);
                                                    if (linearLayout != null) {
                                                        i3 = R.id.f8993514;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f8993514);
                                                        if (textView4 != null) {
                                                            i3 = R.id.f8994515;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f8994515);
                                                            if (textView5 != null) {
                                                                i3 = R.id.f8996517;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.f8996517);
                                                                if (textView6 != null) {
                                                                    i3 = R.id.f8997518;
                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.f8997518);
                                                                    if (imageView5 != null) {
                                                                        i3 = R.id.f8998519;
                                                                        TimiAvatarTextViewImpl timiAvatarTextViewImpl = (TimiAvatarTextViewImpl) ViewBindings.findChildViewById(view, R.id.f8998519);
                                                                        if (timiAvatarTextViewImpl != null) {
                                                                            i3 = R.id.f900051a;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.f900051a);
                                                                            if (textView7 != null) {
                                                                                i3 = R.id.f900151b;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.f900151b);
                                                                                if (textView8 != null) {
                                                                                    return new as((FrameLayout) view, imageView, imageView2, imageView3, uRLImageView, imageView4, frameLayout, textView, frameLayout2, textView2, textView3, timiAvatarRoundImageViewImpl, linearLayout, textView4, textView5, textView6, imageView5, timiAvatarTextViewImpl, textView7, textView8);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static as g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hwf, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f420873a;
    }
}
