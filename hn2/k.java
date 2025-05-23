package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class k implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405382a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f405383b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f405384c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405385d;

    k(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.f405382a = linearLayout;
        this.f405383b = imageView;
        this.f405384c = imageView2;
        this.f405385d = textView;
    }

    @NonNull
    public static k e(@NonNull View view) {
        int i3 = R.id.f763841i;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f763841i);
        if (imageView != null) {
            i3 = R.id.f763941j;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f763941j);
            if (imageView2 != null) {
                i3 = R.id.f764241m;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f764241m);
                if (textView != null) {
                    return new k((LinearLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static k g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f169068ho0, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405382a;
    }
}
