package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class aa implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420753a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f420754b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f420755c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f420756d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420757e;

    aa(@NonNull View view, @NonNull View view2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout) {
        this.f420753a = view;
        this.f420754b = view2;
        this.f420755c = imageView;
        this.f420756d = imageView2;
        this.f420757e = linearLayout;
    }

    @NonNull
    public static aa e(@NonNull View view) {
        int i3 = R.id.ty8;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.ty8);
        if (findChildViewById != null) {
            i3 = R.id.zws;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.zws);
            if (imageView != null) {
                i3 = R.id.f215901f;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f215901f);
                if (imageView2 != null) {
                    i3 = R.id.f94825db;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f94825db);
                    if (linearLayout != null) {
                        return new aa(view, findChildViewById, imageView, imageView2, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static aa f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hub, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f420753a;
    }
}
