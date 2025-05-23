package hp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.base.view.ShadowFrameLayout;
import com.tencent.mobileqq.widget.RoundFrameLayout;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405669a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405670b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ListView f405671c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundFrameLayout f405672d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ShadowFrameLayout f405673e;

    i(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ListView listView, @NonNull RoundFrameLayout roundFrameLayout, @NonNull ShadowFrameLayout shadowFrameLayout) {
        this.f405669a = constraintLayout;
        this.f405670b = constraintLayout2;
        this.f405671c = listView;
        this.f405672d = roundFrameLayout;
        this.f405673e = shadowFrameLayout;
    }

    @NonNull
    public static i e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i3 = R.id.f213000n;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.f213000n);
        if (listView != null) {
            i3 = R.id.f213100o;
            RoundFrameLayout roundFrameLayout = (RoundFrameLayout) ViewBindings.findChildViewById(view, R.id.f213100o);
            if (roundFrameLayout != null) {
                i3 = R.id.f84074l_;
                ShadowFrameLayout shadowFrameLayout = (ShadowFrameLayout) ViewBindings.findChildViewById(view, R.id.f84074l_);
                if (shadowFrameLayout != null) {
                    return new i(constraintLayout, constraintLayout, listView, roundFrameLayout, shadowFrameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static i g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static i h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fny, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405669a;
    }
}
