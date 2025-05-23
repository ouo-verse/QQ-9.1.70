package com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes14.dex */
public abstract class AbsGuildProfileComponent implements b<View, GuildProfileData> {
    protected static final boolean LOG_ENABLE = false;
    private static final String TAG = "Guild.profile.AbsGuildProfileComponent";
    protected AppInterface mApp;
    protected IGuildComponentController mComponentController;
    protected GuildProfileData mData;
    protected Fragment mFragment;
    protected View mViewContainer;

    public AbsGuildProfileComponent(IGuildComponentController iGuildComponentController, GuildProfileData guildProfileData) {
        this.mComponentController = iGuildComponentController;
        this.mData = guildProfileData;
    }

    public void attachToComponentController() {
        IGuildComponentController iGuildComponentController = this.mComponentController;
        if (iGuildComponentController != null) {
            iGuildComponentController.addComponent(this);
        }
    }

    protected View createView(Context context) {
        return LayoutInflater.from(context).inflate(getContentLayoutId(), (ViewGroup) null);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.b
    public void detachFromComponentController() {
        IGuildComponentController iGuildComponentController = this.mComponentController;
        if (iGuildComponentController != null) {
            iGuildComponentController.removeComponent(this);
        }
    }

    public IGuildComponentController getComponentController() {
        return this.mComponentController;
    }

    public abstract /* synthetic */ String getComponentName();

    public abstract /* synthetic */ int getComponentType();

    @LayoutRes
    public abstract /* synthetic */ int getContentLayoutId();

    public void onCreate(Fragment fragment, AppInterface appInterface, Bundle bundle) {
        this.mFragment = fragment;
        this.mApp = appInterface;
        if (fragment == null) {
            QLog.w(TAG, 1, "mFragment is null!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, String.format("getComponentType: %d, %s", Integer.valueOf(getComponentType()), this.mViewContainer));
        }
        this.mViewContainer = m193getContainerView();
    }

    @Override // 
    public void onInitData(GuildProfileData guildProfileData) {
    }

    @Override // 
    public void onUpdateData(GuildProfileData guildProfileData) {
    }

    public String toString() {
        return String.format("Component@%s{componentType=%s componentName=%s}", Integer.valueOf(hashCode()), Integer.valueOf(getComponentType()), getComponentName());
    }

    /* renamed from: getContainerView, reason: merged with bridge method [inline-methods] */
    public View m193getContainerView() {
        if (this.mViewContainer == null) {
            this.mViewContainer = createView(this.mFragment.getContext());
        }
        return this.mViewContainer;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onConfigurationChanged() {
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onDestroy() {
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadFinish() {
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadStart() {
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onPause() {
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onResume() {
    }
}
