package p81;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tx.x2j.AioNotificationTodoUiItemBinding;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f425749a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f425750b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f425751c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f425752d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FrameLayout f425753e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f425754f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f425755g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f425756h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f425757i;

    i(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull FrameLayout frameLayout2, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull View view, @NonNull TextView textView3) {
        this.f425749a = frameLayout;
        this.f425750b = imageView;
        this.f425751c = linearLayout;
        this.f425752d = textView;
        this.f425753e = frameLayout2;
        this.f425754f = textView2;
        this.f425755g = imageView2;
        this.f425756h = view;
        this.f425757i = textView3;
    }

    @NonNull
    public static i e(@NonNull View view) {
        int i3 = R.id.f164187sj0;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164187sj0);
        if (imageView != null) {
            i3 = R.id.f164188sj1;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f164188sj1);
            if (linearLayout != null) {
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
                                    i3 = R.id.sjb;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.sjb);
                                    if (textView3 != null) {
                                        return new i((FrameLayout) view, imageView, linearLayout, textView, frameLayout, textView2, imageView2, findChildViewById, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static i g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioNotificationTodoUiItemBinding aioNotificationTodoUiItemBinding = new AioNotificationTodoUiItemBinding();
        aioNotificationTodoUiItemBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioNotificationTodoUiItemBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dvy, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f425749a;
    }
}
