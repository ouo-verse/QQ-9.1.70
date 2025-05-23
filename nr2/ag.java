package nr2;

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
public final class ag implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f420802a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f420803b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final URLImageView f420804c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f420805d;

    ag(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull URLImageView uRLImageView, @NonNull TextView textView2) {
        this.f420802a = constraintLayout;
        this.f420803b = textView;
        this.f420804c = uRLImageView;
        this.f420805d = textView2;
    }

    @NonNull
    public static ag e(@NonNull View view) {
        int i3 = R.id.suv;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.suv);
        if (textView != null) {
            i3 = R.id.f166249z60;
            URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.f166249z60);
            if (uRLImageView != null) {
                i3 = R.id.zwm;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.zwm);
                if (textView2 != null) {
                    return new ag((ConstraintLayout) view, textView, uRLImageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ag g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hvg, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f420802a;
    }
}
