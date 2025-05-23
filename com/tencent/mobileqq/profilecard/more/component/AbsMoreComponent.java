package com.tencent.mobileqq.profilecard.more.component;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreController;
import com.tencent.mobileqq.profilecard.more.widget.ComponentTitleView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public abstract class AbsMoreComponent implements View.OnClickListener {
    private static String TAG = "AbsMoreComponent";
    ProfileCardMoreController mMoreController;
    public ComponentTitleView mViewContainer = null;

    public AbsMoreComponent(ProfileCardMoreController profileCardMoreController) {
        this.mMoreController = profileCardMoreController;
    }

    public abstract int getComponentKey();

    public abstract int getPartIndex();

    public View getViewContainer() {
        return this.mViewContainer;
    }

    public boolean isNeedShow() {
        return true;
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "onActivityResult(" + i3 + ", " + i16 + ")");
        }
    }

    public void onCreate(LayoutInflater layoutInflater) {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "onCreate()");
        }
        this.mViewContainer = new ComponentTitleView(this.mMoreController.mRootView.getContext());
        updateNightModeUIIfNeed();
    }

    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "onDestroy()");
        }
    }

    public void onPause() {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "onPause()");
        }
    }

    public void onResume() {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "onResume()");
        }
    }

    public void onStart() {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "onStart()");
        }
    }

    public void onStop() {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "onStop()");
        }
    }

    protected void updateNightModeUIIfNeed() {
        ProfileCardMoreController profileCardMoreController = this.mMoreController;
        if (profileCardMoreController == null || this.mViewContainer == null || !profileCardMoreController.isNightMode()) {
            return;
        }
        this.mViewContainer.updateNightModeUI();
    }
}
