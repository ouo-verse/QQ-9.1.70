package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f420738a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f420739b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f420740c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420741d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f420742e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f420743f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f420744g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f420745h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f420746i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f420747j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f420748k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f420749l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f420750m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f420751n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f420752o;

    a(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView2, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull View view, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView9) {
        this.f420738a = constraintLayout;
        this.f420739b = textView;
        this.f420740c = imageView;
        this.f420741d = linearLayout;
        this.f420742e = textView2;
        this.f420743f = textView3;
        this.f420744g = imageView2;
        this.f420745h = textView4;
        this.f420746i = textView5;
        this.f420747j = view;
        this.f420748k = textView6;
        this.f420749l = textView7;
        this.f420750m = textView8;
        this.f420751n = relativeLayout;
        this.f420752o = textView9;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.uae;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.uae);
        if (textView != null) {
            i3 = R.id.yki;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.yki);
            if (imageView != null) {
                i3 = R.id.ykj;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ykj);
                if (linearLayout != null) {
                    i3 = R.id.ykk;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ykk);
                    if (textView2 != null) {
                        i3 = R.id.z2s;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.z2s);
                        if (textView3 != null) {
                            i3 = R.id.zow;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.zow);
                            if (imageView2 != null) {
                                i3 = R.id.zox;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.zox);
                                if (textView4 != null) {
                                    i3 = R.id.f785747f;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f785747f);
                                    if (textView5 != null) {
                                        i3 = R.id.f87484uh;
                                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.f87484uh);
                                        if (findChildViewById != null) {
                                            i3 = R.id.jfs;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.jfs);
                                            if (textView6 != null) {
                                                i3 = R.id.f166986jo4;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.f166986jo4);
                                                if (textView7 != null) {
                                                    i3 = R.id.f114396t8;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.f114396t8);
                                                    if (textView8 != null) {
                                                        i3 = R.id.f114406t9;
                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f114406t9);
                                                        if (relativeLayout != null) {
                                                            i3 = R.id.f114426ta;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.f114426ta);
                                                            if (textView9 != null) {
                                                                return new a((ConstraintLayout) view, textView, imageView, linearLayout, textView2, textView3, imageView2, textView4, textView5, findChildViewById, textView6, textView7, textView8, relativeLayout, textView9);
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
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dx5, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f420738a;
    }
}
