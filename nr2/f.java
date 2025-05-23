package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f421053a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f421054b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f421055c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f421056d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f421057e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f421058f;

    f(@NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView2, @NonNull View view2) {
        this.f421053a = relativeLayout;
        this.f421054b = view;
        this.f421055c = textView;
        this.f421056d = relativeLayout2;
        this.f421057e = textView2;
        this.f421058f = view2;
    }

    @NonNull
    public static f e(@NonNull View view) {
        int i3 = R.id.t67;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.t67);
        if (findChildViewById != null) {
            i3 = R.id.u0g;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.u0g);
            if (textView != null) {
                i3 = R.id.b9r;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.b9r);
                if (relativeLayout != null) {
                    i3 = R.id.uva;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.uva);
                    if (textView2 != null) {
                        i3 = R.id.f100935tu;
                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f100935tu);
                        if (findChildViewById2 != null) {
                            return new f((RelativeLayout) view, findChildViewById, textView, relativeLayout, textView2, findChildViewById2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static f g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static f h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hsr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f421053a;
    }
}
