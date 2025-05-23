package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.nativeui.view.customerface.MakeFaceTabView;
import com.tencent.sqshow.zootopia.nativeui.view.history.AvatarHistoryControlView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ag implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418609a;

    /* renamed from: b, reason: collision with root package name */
    public final MakeFaceTabView f418610b;

    /* renamed from: c, reason: collision with root package name */
    public final AvatarHistoryControlView f418611c;

    ag(View view, MakeFaceTabView makeFaceTabView, AvatarHistoryControlView avatarHistoryControlView) {
        this.f418609a = view;
        this.f418610b = makeFaceTabView;
        this.f418611c = avatarHistoryControlView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418609a;
    }

    public static ag e(View view) {
        int i3 = R.id.ptk;
        MakeFaceTabView makeFaceTabView = (MakeFaceTabView) ViewBindings.findChildViewById(view, R.id.ptk);
        if (makeFaceTabView != null) {
            i3 = R.id.pzo;
            AvatarHistoryControlView avatarHistoryControlView = (AvatarHistoryControlView) ViewBindings.findChildViewById(view, R.id.pzo);
            if (avatarHistoryControlView != null) {
                return new ag(view, makeFaceTabView, avatarHistoryControlView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ag f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f167434da3, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
