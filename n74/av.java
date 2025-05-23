package n74;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class av implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f418757a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418758b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f418759c;

    av(RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        this.f418757a = relativeLayout;
        this.f418758b = imageView;
        this.f418759c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f418757a;
    }

    public static av e(View view) {
        int i3 = R.id.pss;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pss);
        if (imageView != null) {
            i3 = R.id.qr5;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qr5);
            if (textView != null) {
                return new av((RelativeLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
