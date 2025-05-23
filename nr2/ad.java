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
import com.tencent.timi.game.liveroom.impl.room.view.head.QQLiveRankRecyclerView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ad implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420785a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f420786b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QQLiveRankRecyclerView f420787c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420788d;

    ad(@NonNull View view, @NonNull ImageView imageView, @NonNull QQLiveRankRecyclerView qQLiveRankRecyclerView, @NonNull LinearLayout linearLayout) {
        this.f420785a = view;
        this.f420786b = imageView;
        this.f420787c = qQLiveRankRecyclerView;
        this.f420788d = linearLayout;
    }

    @NonNull
    public static ad e(@NonNull View view) {
        int i3 = R.id.f70163kp;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f70163kp);
        if (imageView != null) {
            i3 = R.id.f780045w;
            QQLiveRankRecyclerView qQLiveRankRecyclerView = (QQLiveRankRecyclerView) ViewBindings.findChildViewById(view, R.id.f780045w);
            if (qQLiveRankRecyclerView != null) {
                i3 = R.id.f780145x;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f780145x);
                if (linearLayout != null) {
                    return new ad(view, imageView, qQLiveRankRecyclerView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ad f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hut, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f420785a;
    }
}
