package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bs implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f399146a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f399147b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f399148c;

    bs(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.f399146a = linearLayout;
        this.f399147b = linearLayout2;
        this.f399148c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f399146a;
    }

    public static bs e(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qfg);
        if (textView != null) {
            return new bs(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qfg)));
    }

    public static bs g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.den, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
