package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.liveroom.impl.room.widget.ChildViewPager;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class l implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421089a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421090b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ChildViewPager f421091c;

    l(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull ChildViewPager childViewPager) {
        this.f421089a = view;
        this.f421090b = linearLayout;
        this.f421091c = childViewPager;
    }

    @NonNull
    public static l e(@NonNull View view) {
        int i3 = R.id.xmd;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.xmd);
        if (linearLayout != null) {
            i3 = R.id.zzz;
            ChildViewPager childViewPager = (ChildViewPager) ViewBindings.findChildViewById(view, R.id.zzz);
            if (childViewPager != null) {
                return new l(view, linearLayout, childViewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static l f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.ht6, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421089a;
    }
}
