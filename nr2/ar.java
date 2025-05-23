package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.widget.MediumBoldTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ar implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420858a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundImageView f420859b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420860c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final aq f420861d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f420862e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f420863f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420864g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final MediumBoldTextView f420865h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final MediumBoldTextView f420866i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f420867j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f420868k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final FrameLayout f420869l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420870m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final aq f420871n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final aq f420872o;

    ar(@NonNull View view, @NonNull RoundImageView roundImageView, @NonNull LinearLayout linearLayout, @NonNull aq aqVar, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull MediumBoldTextView mediumBoldTextView, @NonNull MediumBoldTextView mediumBoldTextView2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout3, @NonNull aq aqVar2, @NonNull aq aqVar3) {
        this.f420858a = view;
        this.f420859b = roundImageView;
        this.f420860c = linearLayout;
        this.f420861d = aqVar;
        this.f420862e = textView;
        this.f420863f = textView2;
        this.f420864g = linearLayout2;
        this.f420865h = mediumBoldTextView;
        this.f420866i = mediumBoldTextView2;
        this.f420867j = textView3;
        this.f420868k = imageView;
        this.f420869l = frameLayout;
        this.f420870m = linearLayout3;
        this.f420871n = aqVar2;
        this.f420872o = aqVar3;
    }

    @NonNull
    public static ar e(@NonNull View view) {
        int i3 = R.id.t2z;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.t2z);
        if (roundImageView != null) {
            i3 = R.id.ugh;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ugh);
            if (linearLayout != null) {
                i3 = R.id.v6o;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.v6o);
                if (findChildViewById != null) {
                    aq e16 = aq.e(findChildViewById);
                    i3 = R.id.x_5;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.x_5);
                    if (textView != null) {
                        i3 = R.id.x_6;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.x_6);
                        if (textView2 != null) {
                            i3 = R.id.yht;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.yht);
                            if (linearLayout2 != null) {
                                i3 = R.id.yhu;
                                MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) ViewBindings.findChildViewById(view, R.id.yhu);
                                if (mediumBoldTextView != null) {
                                    i3 = R.id.f26510dq;
                                    MediumBoldTextView mediumBoldTextView2 = (MediumBoldTextView) ViewBindings.findChildViewById(view, R.id.f26510dq);
                                    if (mediumBoldTextView2 != null) {
                                        i3 = R.id.f26520dr;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f26520dr);
                                        if (textView3 != null) {
                                            i3 = R.id.f70963mv;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f70963mv);
                                            if (imageView != null) {
                                                i3 = R.id.f776344w;
                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f776344w);
                                                if (frameLayout != null) {
                                                    i3 = R.id.f7767450;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f7767450);
                                                    if (linearLayout3 != null) {
                                                        i3 = R.id.f81604em;
                                                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f81604em);
                                                        if (findChildViewById2 != null) {
                                                            aq e17 = aq.e(findChildViewById2);
                                                            i3 = R.id.f96455hq;
                                                            View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.f96455hq);
                                                            if (findChildViewById3 != null) {
                                                                return new ar(view, roundImageView, linearLayout, e16, textView, textView2, linearLayout2, mediumBoldTextView, mediumBoldTextView2, textView3, imageView, frameLayout, linearLayout3, e17, aq.e(findChildViewById3));
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
    public static ar f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f169126hw1, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f420858a;
    }
}
