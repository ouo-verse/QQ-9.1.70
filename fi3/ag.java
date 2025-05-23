package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ag implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f398809a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f398810b;

    ag(RelativeLayout relativeLayout, TextView textView) {
        this.f398809a = relativeLayout;
        this.f398810b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f398809a;
    }

    public static ag g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static ag e(View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qpa);
        if (textView != null) {
            return new ag((RelativeLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qpa)));
    }

    public static ag h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d9i, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
