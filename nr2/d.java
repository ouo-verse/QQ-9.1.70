package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f421042a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f421043b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f421044c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f421045d;

    d(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f421042a = frameLayout;
        this.f421043b = textView;
        this.f421044c = imageView;
        this.f421045d = textView2;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.s7r;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.s7r);
        if (textView != null) {
            i3 = R.id.twj;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.twj);
            if (imageView != null) {
                i3 = R.id.f7772455;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f7772455);
                if (textView2 != null) {
                    return new d((FrameLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static d g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hsn, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f421042a;
    }
}
