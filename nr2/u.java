package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
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
public final class u implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f421136a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f421137b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f421138c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f421139d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final EditText f421140e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f421141f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f421142g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f421143h;

    u(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull EditText editText, @NonNull View view, @NonNull RelativeLayout relativeLayout3, @NonNull FrameLayout frameLayout) {
        this.f421136a = relativeLayout;
        this.f421137b = textView;
        this.f421138c = imageView;
        this.f421139d = relativeLayout2;
        this.f421140e = editText;
        this.f421141f = view;
        this.f421142g = relativeLayout3;
        this.f421143h = frameLayout;
    }

    @NonNull
    public static u e(@NonNull View view) {
        int i3 = R.id.tlf;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tlf);
        if (textView != null) {
            i3 = R.id.txi;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.txi);
            if (imageView != null) {
                i3 = R.id.xoa;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.xoa);
                if (relativeLayout != null) {
                    i3 = R.id.dmg;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.dmg);
                    if (editText != null) {
                        i3 = R.id.enc;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.enc);
                        if (findChildViewById != null) {
                            i3 = R.id.f80514bo;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f80514bo);
                            if (relativeLayout2 != null) {
                                i3 = R.id.f80634c0;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f80634c0);
                                if (frameLayout != null) {
                                    return new u((RelativeLayout) view, textView, imageView, relativeLayout, editText, findChildViewById, relativeLayout2, frameLayout);
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
    public static u g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static u h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.htv, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f421136a;
    }
}
