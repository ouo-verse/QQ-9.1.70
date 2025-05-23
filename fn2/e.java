package fn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f400117a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f400118b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f400119c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f400120d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f400121e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f400122f;

    e(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView3) {
        this.f400117a = relativeLayout;
        this.f400118b = textView;
        this.f400119c = imageView;
        this.f400120d = textView2;
        this.f400121e = relativeLayout2;
        this.f400122f = textView3;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.f774344c;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f774344c);
        if (textView != null) {
            i3 = R.id.f774444d;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f774444d);
            if (imageView != null) {
                i3 = R.id.f774544e;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f774544e);
                if (textView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i3 = R.id.f774744g;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f774744g);
                    if (textView3 != null) {
                        return new e(relativeLayout, textView, imageView, textView2, relativeLayout, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static e g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.h2d, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f400117a;
    }
}
