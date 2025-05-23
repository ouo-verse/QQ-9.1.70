package nr2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class am implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f420831a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f420832b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f420833c;

    am(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f420831a = linearLayout;
        this.f420832b = textView;
        this.f420833c = textView2;
    }

    @NonNull
    public static am e(@NonNull View view) {
        int i3 = R.id.xsc;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.xsc);
        if (textView != null) {
            i3 = R.id.xse;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.xse);
            if (textView2 != null) {
                return new am((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f420831a;
    }
}
