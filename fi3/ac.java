package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.view.ZootopiaSmallHomeCardBottomView;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.view.ZootopiaSmallHomeCardMsgPopView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ac implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f398787a;

    /* renamed from: b, reason: collision with root package name */
    public final ZPlanMediaView f398788b;

    /* renamed from: c, reason: collision with root package name */
    public final ZootopiaSmallHomeCardBottomView f398789c;

    /* renamed from: d, reason: collision with root package name */
    public final ZootopiaSmallHomeCardMsgPopView f398790d;

    ac(View view, ZPlanMediaView zPlanMediaView, ZootopiaSmallHomeCardBottomView zootopiaSmallHomeCardBottomView, ZootopiaSmallHomeCardMsgPopView zootopiaSmallHomeCardMsgPopView) {
        this.f398787a = view;
        this.f398788b = zPlanMediaView;
        this.f398789c = zootopiaSmallHomeCardBottomView;
        this.f398790d = zootopiaSmallHomeCardMsgPopView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public View getMRv() {
        return this.f398787a;
    }

    public static ac e(View view) {
        int i3 = R.id.pd5;
        ZPlanMediaView zPlanMediaView = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.pd5);
        if (zPlanMediaView != null) {
            i3 = R.id.pev;
            ZootopiaSmallHomeCardBottomView zootopiaSmallHomeCardBottomView = (ZootopiaSmallHomeCardBottomView) ViewBindings.findChildViewById(view, R.id.pev);
            if (zootopiaSmallHomeCardBottomView != null) {
                i3 = R.id.q9t;
                ZootopiaSmallHomeCardMsgPopView zootopiaSmallHomeCardMsgPopView = (ZootopiaSmallHomeCardMsgPopView) ViewBindings.findChildViewById(view, R.id.q9t);
                if (zootopiaSmallHomeCardMsgPopView != null) {
                    return new ac(view, zPlanMediaView, zootopiaSmallHomeCardBottomView, zootopiaSmallHomeCardMsgPopView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ac f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d9b, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
