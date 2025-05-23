package com.tencent.av.ui.effect.toolbar.newversion;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import yv.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseToolbarNewVersion extends BaseToolbar {
    public BaseToolbarNewVersion(VideoAppInterface videoAppInterface, AVActivity aVActivity) {
        super(videoAppInterface, aVActivity);
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    protected Button createEffectButton(ViewGroup viewGroup, int i3, BaseToolbar.a aVar) {
        if (viewGroup == null || aVar == null) {
            return null;
        }
        DownLineButton downLineButton = new DownLineButton(viewGroup.getContext());
        Resources resources = viewGroup.getResources();
        downLineButton.setId(i3);
        downLineButton.setGravity(17);
        downLineButton.setContentDescription(aVar.f75563g);
        downLineButton.setBackgroundDrawable(null);
        downLineButton.setPadding(BaseAIOUtils.f(14.0f, resources), 0, BaseAIOUtils.f(14.0f, resources), 0);
        downLineButton.setText(aVar.f75563g);
        downLineButton.setGravity(17);
        downLineButton.setTextSize(ViewUtils.pxTosp(BaseAIOUtils.f(16.0f, resources)));
        downLineButton.setTextColor(resources.getColor(R.color.c_a));
        downLineButton.setMinWidth(0);
        downLineButton.setMinimumWidth(0);
        downLineButton.setMinimumHeight(0);
        downLineButton.setMinHeight(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, BaseAIOUtils.f(49.0f, resources));
        layoutParams.gravity = 1;
        downLineButton.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        layoutParams2.gravity = 16;
        layoutParams2.rightMargin = BaseAIOUtils.f(2.0f, resources);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(downLineButton);
        viewGroup.addView(linearLayout);
        return downLineButton;
    }

    public boolean isShowRedDot(int i3) {
        int i16;
        if (r.h0() != null && n.e().f() != null) {
            i16 = n.e().f().f73035i;
        } else {
            i16 = 0;
        }
        return a.a(this.mApp, i3, i16);
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public void setEffectBtnVisibility(boolean z16) {
        int i3;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        Button button = this.mEffectBtn;
        if (button != null) {
            button.setVisibility(i3);
            ((ViewGroup) this.mEffectBtn.getParent()).setVisibility(i3);
        }
        RedTouch redTouch = this.mEffectBtnRedTouch;
        if (redTouch != null) {
            redTouch.setVisibility(i3);
        }
    }

    @Override // com.tencent.av.ui.effect.toolbar.BaseToolbar
    public void updateEffectBtnStatus() {
        boolean z16;
        boolean z17;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "updateEffectBtnStatus, EffectBtnId[" + getEffectBtnId() + "]");
        }
        if (this.mEffectBtn == null) {
            if (QLog.isColorLevel()) {
                QLog.e(this.TAG, 2, "updateEffectBtnStatus, mEffectBtn\u4e3a\u7a7a");
                return;
            }
            return;
        }
        if (VideoUtil.g(this.mApp, true) && !n.e().f().z() && getEffectBtnId() != 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        Button button = this.mEffectBtn;
        if (z16 && isEffectBtnEnable()) {
            z17 = true;
        } else {
            z17 = false;
        }
        button.setEnabled(z17);
        this.mEffectBtn.setClickable(true);
        if (getUIInfo() == null) {
            return;
        }
        if (z16 && isEffectBtnNormal()) {
            RedTouch redTouch = this.mEffectBtnRedTouch;
            if (redTouch != null) {
                redTouch.setHostEnable(true);
            }
            i3 = R.color.c_9;
        } else {
            RedTouch redTouch2 = this.mEffectBtnRedTouch;
            if (redTouch2 != null) {
                redTouch2.setHostEnable(false);
            }
            i3 = R.color.all;
        }
        this.mEffectBtn.setTextColor(b.a(this.mEffectBtn.getResources(), i3));
    }
}
