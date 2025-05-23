package com.tencent.mobileqq.profilecard.more.component;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreConstants;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreController;

/* compiled from: P */
/* loaded from: classes35.dex */
public class DividerComponent extends AbsMoreComponent {
    private View mDividerView;

    public DividerComponent(ProfileCardMoreController profileCardMoreController) {
        super(profileCardMoreController);
    }

    private View bindRootView() {
        Activity activity;
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController == null || (activity = profileCardMoreController.mActivity) == null || this.mViewContainer == null) {
            return null;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.cza, (ViewGroup) null);
        this.mViewContainer.addComponentContent(inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public int getComponentKey() {
        return ProfileCardMoreConstants.MORE_COMPONENT_KEY_DIVIDER;
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public int getPartIndex() {
        return -1;
    }

    @Override // com.tencent.mobileqq.profilecard.more.component.AbsMoreComponent
    public void onCreate(LayoutInflater layoutInflater) {
        super.onCreate(layoutInflater);
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController == null || profileCardMoreController.mActivity == null || this.mViewContainer == null) {
            return;
        }
        initDividerView(bindRootView());
        this.mViewContainer.hideTitleArea();
    }

    private void initDividerView(View view) {
        if (view == null) {
            return;
        }
        this.mDividerView = view.findViewById(R.id.owl);
        if (this.mMoreController.isNightMode()) {
            this.mDividerView.setBackgroundColor(-12763839);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
