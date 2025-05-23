package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f419342a;

    /* renamed from: b, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419343b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f419344c;

    /* renamed from: d, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419345d;

    /* renamed from: e, reason: collision with root package name */
    public final View f419346e;

    h(LinearLayout linearLayout, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, LinearLayout linearLayout2, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2, View view) {
        this.f419342a = linearLayout;
        this.f419343b = zplanExcludeFontPaddingTextView;
        this.f419344c = linearLayout2;
        this.f419345d = zplanExcludeFontPaddingTextView2;
        this.f419346e = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f419342a;
    }

    public static h g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static h e(View view) {
        int i3 = R.id.p9y;
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.p9y);
        if (zplanExcludeFontPaddingTextView != null) {
            i3 = R.id.p9z;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.p9z);
            if (linearLayout != null) {
                i3 = R.id.p_0;
                ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.p_0);
                if (zplanExcludeFontPaddingTextView2 != null) {
                    i3 = R.id.p_1;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.p_1);
                    if (findChildViewById != null) {
                        return new h((LinearLayout) view, zplanExcludeFontPaddingTextView, linearLayout, zplanExcludeFontPaddingTextView2, findChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static h h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d9z, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
