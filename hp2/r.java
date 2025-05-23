package hp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class r implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405735a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final URLImageView f405736b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405737c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405738d;

    r(@NonNull ConstraintLayout constraintLayout, @NonNull URLImageView uRLImageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f405735a = constraintLayout;
        this.f405736b = uRLImageView;
        this.f405737c = textView;
        this.f405738d = textView2;
    }

    @NonNull
    public static r e(@NonNull View view) {
        int i3 = R.id.icon;
        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.icon);
        if (uRLImageView != null) {
            i3 = R.id.f166942ja3;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f166942ja3);
            if (textView != null) {
                i3 = R.id.jfb;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.jfb);
                if (textView2 != null) {
                    return new r((ConstraintLayout) view, uRLImageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static r g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.gv6, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405735a;
    }
}
