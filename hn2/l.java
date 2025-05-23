package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.robot.aio.bottombar.picture.RobotPictureRecyclerView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class l implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405386a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RobotPictureRecyclerView f405387b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f405388c;

    l(@NonNull LinearLayout linearLayout, @NonNull RobotPictureRecyclerView robotPictureRecyclerView, @NonNull RecyclerView recyclerView) {
        this.f405386a = linearLayout;
        this.f405387b = robotPictureRecyclerView;
        this.f405388c = recyclerView;
    }

    @NonNull
    public static l e(@NonNull View view) {
        int i3 = R.id.f771743n;
        RobotPictureRecyclerView robotPictureRecyclerView = (RobotPictureRecyclerView) ViewBindings.findChildViewById(view, R.id.f771743n);
        if (robotPictureRecyclerView != null) {
            i3 = R.id.f771843o;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f771843o);
            if (recyclerView != null) {
                return new l((LinearLayout) view, robotPictureRecyclerView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static l g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static l h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f169069ho1, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405386a;
    }
}
