package com.tencent.mobileqq.profilecard.view.vas;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.container.IVasCustomBgView;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class VasBaseBGComponent extends AbsProfileContentComponent {
    private static final String TAG = "VasBaseBGComponent";
    private IVasCustomBgView layout;

    public VasBaseBGComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addLayout(QBaseActivity qBaseActivity) {
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate == null || !iProfileActivityDelegate.isShowVasCustomBgCover()) {
            return;
        }
        if (this.layout == null) {
            this.layout = new VasCustomBgLayout(qBaseActivity);
        }
        VIEW view = this.mViewContainer;
        if ((view instanceof FrameLayout) && ((FrameLayout) view).indexOfChild((View) this.layout) == -1) {
            ((FrameLayout) this.mViewContainer).addView(this.layout.getLayoutView(), new ViewGroup.LayoutParams(-1, -1));
            QLog.e(TAG, 1, "addLayout VasCustomBgLayout.");
        }
        this.layout.updateData((ProfileCardInfo) this.mData);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return null;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1003;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return TAG;
    }

    public IVasCustomBgView getVasCustomBgView() {
        return this.layout;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        addLayout(qBaseActivity);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        IVasCustomBgView iVasCustomBgView = this.layout;
        if (iVasCustomBgView != null) {
            iVasCustomBgView.onStop();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        super.onPause();
        IVasCustomBgView iVasCustomBgView = this.layout;
        if (iVasCustomBgView != null) {
            iVasCustomBgView.onPause();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        super.onResume();
        IVasCustomBgView iVasCustomBgView = this.layout;
        if (iVasCustomBgView != null) {
            iVasCustomBgView.onResume();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((VasBaseBGComponent) profileCardInfo);
        addLayout(this.mActivity);
        return lambda$checkValidComponent$3;
    }
}
