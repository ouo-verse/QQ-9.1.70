package ii2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f407705a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f407706b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f407707c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f407708d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f407709e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f407710f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f407711g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f407712h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final b f407713i;

    a(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull View view, @NonNull LinearLayout linearLayout2, @NonNull View view2, @NonNull TextView textView2, @NonNull b bVar) {
        this.f407705a = relativeLayout;
        this.f407706b = linearLayout;
        this.f407707c = textView;
        this.f407708d = relativeLayout2;
        this.f407709e = view;
        this.f407710f = linearLayout2;
        this.f407711g = view2;
        this.f407712h = textView2;
        this.f407713i = bVar;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.f634733m;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f634733m);
        if (linearLayout != null) {
            i3 = R.id.f634933o;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f634933o);
            if (textView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i3 = R.id.f635033p;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f635033p);
                if (findChildViewById != null) {
                    i3 = R.id.f635133q;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f635133q);
                    if (linearLayout2 != null) {
                        i3 = R.id.f635233r;
                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f635233r);
                        if (findChildViewById2 != null) {
                            i3 = R.id.f639234u;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f639234u);
                            if (textView2 != null) {
                                i3 = R.id.f96085gq;
                                View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.f96085gq);
                                if (findChildViewById3 != null) {
                                    return new a(relativeLayout, linearLayout, textView, relativeLayout, findChildViewById, linearLayout2, findChildViewById2, textView2, b.e(findChildViewById3));
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
    public static a g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static a h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.h9f, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f407705a;
    }
}
