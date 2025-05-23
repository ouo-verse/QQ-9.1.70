package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f405337a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405338b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f405339c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405340d;

    a(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f405337a = view;
        this.f405338b = linearLayout;
        this.f405339c = imageView;
        this.f405340d = textView;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.e1p;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.e1p);
        if (linearLayout != null) {
            i3 = R.id.yce;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.yce);
            if (imageView != null) {
                i3 = R.id.yck;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.yck);
                if (textView != null) {
                    return new a(view, linearLayout, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dst, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f405337a;
    }
}
