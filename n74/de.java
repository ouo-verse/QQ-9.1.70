package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.taskcenter.common.TaskHalfScreenFloatingView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class de implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f419226a;

    /* renamed from: b, reason: collision with root package name */
    public final TaskHalfScreenFloatingView f419227b;

    de(RelativeLayout relativeLayout, TaskHalfScreenFloatingView taskHalfScreenFloatingView) {
        this.f419226a = relativeLayout;
        this.f419227b = taskHalfScreenFloatingView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f419226a;
    }

    public static de g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static de e(View view) {
        TaskHalfScreenFloatingView taskHalfScreenFloatingView = (TaskHalfScreenFloatingView) ViewBindings.findChildViewById(view, R.id.qfd);
        if (taskHalfScreenFloatingView != null) {
            return new de((RelativeLayout) view, taskHalfScreenFloatingView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.qfd)));
    }

    public static de h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dgk, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
