package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class bc implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420977a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f420978b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f420979c;

    bc(@NonNull View view, @NonNull TextView textView, @NonNull View view2) {
        this.f420977a = view;
        this.f420978b = textView;
        this.f420979c = view2;
    }

    @NonNull
    public static bc e(@NonNull View view) {
        int i3 = R.id.x_o;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.x_o);
        if (textView != null) {
            i3 = R.id.f166131ys4;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f166131ys4);
            if (findChildViewById != null) {
                return new bc(view, textView, findChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bc f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hxq, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f420977a;
    }
}
