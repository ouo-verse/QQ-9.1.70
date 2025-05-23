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
public final class ba implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f420973a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f420974b;

    ba(@NonNull FrameLayout frameLayout, @NonNull TextView textView) {
        this.f420973a = frameLayout;
        this.f420974b = textView;
    }

    @NonNull
    public static ba e(@NonNull View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.jfo);
        if (textView != null) {
            return new ba((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.jfo)));
    }

    @NonNull
    public static ba g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hxf, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f420973a;
    }
}
