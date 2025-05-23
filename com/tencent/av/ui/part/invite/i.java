package com.tencent.av.ui.part.invite;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.av.ui.m;
import com.tencent.biz.richframework.part.Part;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends Part {

    /* renamed from: d, reason: collision with root package name */
    private View f76464d;

    /* renamed from: e, reason: collision with root package name */
    private View f76465e;

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            QLog.e("AVInviteStatusBarPart", 1, "onInitView rootView is null");
            return;
        }
        this.f76464d = view.findViewById(m.d.f76008f);
        this.f76465e = view.getRootView().findViewById(m.d.f76009g);
        x9(view.getContext());
    }

    void x9(Context context) {
        if (context == null || this.f76464d == null) {
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() != 1) {
            this.f76464d.setVisibility(8);
            View view = this.f76465e;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(context);
        QLog.w("AVInviteStatusBarPart", 1, "adjust, height[" + statusBarHeight + "]");
        if (statusBarHeight > 0) {
            z9(this.f76464d, statusBarHeight);
            z9(this.f76465e, statusBarHeight);
        }
        if (com.tencent.av.utils.e.e(0) == 1) {
            this.f76464d.setBackgroundColor(2140405971);
            View view2 = this.f76465e;
            if (view2 != null) {
                view2.setBackgroundColor(2140405971);
            }
        }
    }

    private void z9(View view, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        if (view == null || (layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }
}
