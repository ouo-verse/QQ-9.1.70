package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class m implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f421092a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f421093b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f421094c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f421095d;

    m(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull View view, @NonNull FrameLayout frameLayout2) {
        this.f421092a = frameLayout;
        this.f421093b = textView;
        this.f421094c = view;
        this.f421095d = frameLayout2;
    }

    @NonNull
    public static m e(@NonNull View view) {
        int i3 = R.id.f164822az1;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f164822az1);
        if (textView != null) {
            i3 = R.id.uyx;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.uyx);
            if (findChildViewById != null) {
                i3 = R.id.f27720h0;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f27720h0);
                if (frameLayout != null) {
                    return new m((FrameLayout) view, textView, findChildViewById, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static m g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ht7, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f421092a;
    }
}
