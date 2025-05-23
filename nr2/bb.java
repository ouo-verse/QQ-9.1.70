package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class bb implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420975a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f420976b;

    bb(@NonNull View view, @NonNull RecyclerView recyclerView) {
        this.f420975a = view;
        this.f420976b = recyclerView;
    }

    @NonNull
    public static bb e(@NonNull View view) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.i4l);
        if (recyclerView != null) {
            return new bb(view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.i4l)));
    }

    @NonNull
    public static bb f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hxn, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f420975a;
    }
}
