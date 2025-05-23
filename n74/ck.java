package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.avatar.mall.AvatarRoleTitleView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.recommend.characterV2.view.ZPlanRoleMidTouchTap;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ck implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f419025a;

    /* renamed from: b, reason: collision with root package name */
    public final ZPlanRoleMidTouchTap f419026b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f419027c;

    /* renamed from: d, reason: collision with root package name */
    public final AvatarPanelErrorView f419028d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f419029e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f419030f;

    /* renamed from: g, reason: collision with root package name */
    public final AvatarRoleTitleView f419031g;

    ck(FrameLayout frameLayout, ZPlanRoleMidTouchTap zPlanRoleMidTouchTap, FrameLayout frameLayout2, AvatarPanelErrorView avatarPanelErrorView, FrameLayout frameLayout3, FrameLayout frameLayout4, AvatarRoleTitleView avatarRoleTitleView) {
        this.f419025a = frameLayout;
        this.f419026b = zPlanRoleMidTouchTap;
        this.f419027c = frameLayout2;
        this.f419028d = avatarPanelErrorView;
        this.f419029e = frameLayout3;
        this.f419030f = frameLayout4;
        this.f419031g = avatarRoleTitleView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getMRv() {
        return this.f419025a;
    }

    public static ck g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static ck e(View view) {
        int i3 = R.id.f163289pb2;
        ZPlanRoleMidTouchTap zPlanRoleMidTouchTap = (ZPlanRoleMidTouchTap) ViewBindings.findChildViewById(view, R.id.f163289pb2);
        if (zPlanRoleMidTouchTap != null) {
            i3 = R.id.q67;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q67);
            if (frameLayout != null) {
                i3 = R.id.q69;
                AvatarPanelErrorView avatarPanelErrorView = (AvatarPanelErrorView) ViewBindings.findChildViewById(view, R.id.q69);
                if (avatarPanelErrorView != null) {
                    i3 = R.id.q7m;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q7m);
                    if (frameLayout2 != null) {
                        i3 = R.id.q95;
                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q95);
                        if (frameLayout3 != null) {
                            i3 = R.id.f163596qz4;
                            AvatarRoleTitleView avatarRoleTitleView = (AvatarRoleTitleView) ViewBindings.findChildViewById(view, R.id.f163596qz4);
                            if (avatarRoleTitleView != null) {
                                return new ck((FrameLayout) view, zPlanRoleMidTouchTap, frameLayout, avatarPanelErrorView, frameLayout2, frameLayout3, avatarRoleTitleView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ck h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.des, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
