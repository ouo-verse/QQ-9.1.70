package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.emo.ui.EmoPanelIndicator;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class x implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421160a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final EmoPanelIndicator f421161b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewPager f421162c;

    x(@NonNull View view, @NonNull EmoPanelIndicator emoPanelIndicator, @NonNull ViewPager viewPager) {
        this.f421160a = view;
        this.f421161b = emoPanelIndicator;
        this.f421162c = viewPager;
    }

    @NonNull
    public static x e(@NonNull View view) {
        int i3 = R.id.xmd;
        EmoPanelIndicator emoPanelIndicator = (EmoPanelIndicator) ViewBindings.findChildViewById(view, R.id.xmd);
        if (emoPanelIndicator != null) {
            i3 = R.id.f2217030;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.f2217030);
            if (viewPager != null) {
                return new x(view, emoPanelIndicator, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static x f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.htz, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421160a;
    }
}
