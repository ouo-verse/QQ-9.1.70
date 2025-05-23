package p81;

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
/* loaded from: classes11.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f425710a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f425711b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f425712c;

    a(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f425710a = linearLayout;
        this.f425711b = imageView;
        this.f425712c = textView;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.f166301zd1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f166301zd1);
        if (imageView != null) {
            i3 = R.id.f166302zd2;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f166302zd2);
            if (textView != null) {
                return new a((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.drr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f425710a;
    }
}
