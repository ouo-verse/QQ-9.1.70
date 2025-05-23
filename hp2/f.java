package hp2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.base.widget.ThemeFixSizeImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405641a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUICheckBox f405642b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405643c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ThemeFixSizeImageView f405644d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f405645e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f405646f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405647g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f405648h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f405649i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f405650j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f405651k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f405652l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f405653m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final ImageView f405654n;

    f(@NonNull LinearLayout linearLayout, @NonNull QUICheckBox qUICheckBox, @NonNull TextView textView, @NonNull ThemeFixSizeImageView themeFixSizeImageView, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView2, @NonNull ImageView imageView3, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ImageView imageView4) {
        this.f405641a = linearLayout;
        this.f405642b = qUICheckBox;
        this.f405643c = textView;
        this.f405644d = themeFixSizeImageView;
        this.f405645e = relativeLayout;
        this.f405646f = imageView;
        this.f405647g = linearLayout2;
        this.f405648h = imageView2;
        this.f405649i = relativeLayout2;
        this.f405650j = textView2;
        this.f405651k = imageView3;
        this.f405652l = textView3;
        this.f405653m = textView4;
        this.f405654n = imageView4;
    }

    @NonNull
    public static f e(@NonNull View view) {
        int i3 = R.id.axa;
        QUICheckBox qUICheckBox = (QUICheckBox) ViewBindings.findChildViewById(view, R.id.axa);
        if (qUICheckBox != null) {
            i3 = R.id.bgt;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.bgt);
            if (textView != null) {
                i3 = R.id.image;
                ThemeFixSizeImageView themeFixSizeImageView = (ThemeFixSizeImageView) ViewBindings.findChildViewById(view, R.id.image);
                if (themeFixSizeImageView != null) {
                    i3 = R.id.dpr;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.dpr);
                    if (relativeLayout != null) {
                        i3 = R.id.dwd;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.dwd);
                        if (imageView != null) {
                            i3 = R.id.f166090ed2;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f166090ed2);
                            if (linearLayout != null) {
                                i3 = R.id.i_m;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.i_m);
                                if (imageView2 != null) {
                                    i3 = R.id.ibz;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ibz);
                                    if (relativeLayout2 != null) {
                                        i3 = R.id.iww;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.iww);
                                        if (textView2 != null) {
                                            i3 = R.id.j1v;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.j1v);
                                            if (imageView3 != null) {
                                                i3 = R.id.f166931j64;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f166931j64);
                                                if (textView3 != null) {
                                                    i3 = R.id.title;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                                                    if (textView4 != null) {
                                                        i3 = R.id.kab;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.kab);
                                                        if (imageView4 != null) {
                                                            return new f((LinearLayout) view, qUICheckBox, textView, themeFixSizeImageView, relativeLayout, imageView, linearLayout, imageView2, relativeLayout2, textView2, imageView3, textView3, textView4, imageView4);
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

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405641a;
    }
}
