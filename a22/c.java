package a22;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f25370a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f25371b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f25372c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f25373d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f25374e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final GuildAIOInputEditText f25375f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f25376g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f25377h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f25378i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f25379j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f25380k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f25381l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f25382m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final ViewStub f25383n;

    c(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull FrameLayout frameLayout2, @NonNull GuildAIOInputEditText guildAIOInputEditText, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull FrameLayout frameLayout3, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ViewStub viewStub) {
        this.f25370a = frameLayout;
        this.f25371b = linearLayout;
        this.f25372c = imageView;
        this.f25373d = linearLayout2;
        this.f25374e = frameLayout2;
        this.f25375f = guildAIOInputEditText;
        this.f25376g = textView;
        this.f25377h = linearLayout3;
        this.f25378i = linearLayout4;
        this.f25379j = frameLayout3;
        this.f25380k = imageView2;
        this.f25381l = textView2;
        this.f25382m = textView3;
        this.f25383n = viewStub;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.sjm;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.sjm);
        if (linearLayout != null) {
            i3 = R.id.vxa;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.vxa);
            if (imageView != null) {
                i3 = R.id.vxi;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vxi);
                if (linearLayout2 != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i3 = R.id.vxk;
                    GuildAIOInputEditText guildAIOInputEditText = (GuildAIOInputEditText) ViewBindings.findChildViewById(view, R.id.vxk);
                    if (guildAIOInputEditText != null) {
                        i3 = R.id.vyg;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vyg);
                        if (textView != null) {
                            i3 = R.id.wjq;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wjq);
                            if (linearLayout3 != null) {
                                i3 = R.id.wjs;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.wjs);
                                if (linearLayout4 != null) {
                                    i3 = R.id.wmm;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.wmm);
                                    if (frameLayout2 != null) {
                                        i3 = R.id.f73093sm;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f73093sm);
                                        if (imageView2 != null) {
                                            i3 = R.id.f73253t2;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f73253t2);
                                            if (textView2 != null) {
                                                i3 = R.id.f73333t_;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f73333t_);
                                                if (textView3 != null) {
                                                    i3 = R.id.f1204779n;
                                                    ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.f1204779n);
                                                    if (viewStub != null) {
                                                        return new c(frameLayout, linearLayout, imageView, linearLayout2, frameLayout, guildAIOInputEditText, textView, linearLayout3, linearLayout4, frameLayout2, imageView2, textView2, textView3, viewStub);
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
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.exx, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f25370a;
    }
}
