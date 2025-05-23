package p81;

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
import com.tx.x2j.AioNotificationSimpleUiItemBinding;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f425742a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f425743b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f425744c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f425745d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f425746e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f425747f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f425748g;

    h(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull FrameLayout frameLayout2, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull View view) {
        this.f425742a = frameLayout;
        this.f425743b = imageView;
        this.f425744c = textView;
        this.f425745d = frameLayout2;
        this.f425746e = textView2;
        this.f425747f = imageView2;
        this.f425748g = view;
    }

    @NonNull
    public static h e(@NonNull View view) {
        int i3 = R.id.f164187sj0;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164187sj0);
        if (imageView != null) {
            i3 = R.id.f164189sj2;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f164189sj2);
            if (textView != null) {
                i3 = R.id.f164190sj3;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f164190sj3);
                if (frameLayout != null) {
                    i3 = R.id.f164191sj4;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f164191sj4);
                    if (textView2 != null) {
                        i3 = R.id.sj6;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.sj6);
                        if (imageView2 != null) {
                            i3 = R.id.sja;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.sja);
                            if (findChildViewById != null) {
                                return new h((FrameLayout) view, imageView, textView, frameLayout, textView2, imageView2, findChildViewById);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static h g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioNotificationSimpleUiItemBinding aioNotificationSimpleUiItemBinding = new AioNotificationSimpleUiItemBinding();
        aioNotificationSimpleUiItemBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioNotificationSimpleUiItemBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dvx, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f425742a;
    }
}
