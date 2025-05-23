package com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import xv1.b;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class IGuildComponentController implements com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a<GuildProfileData> {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        View getRootView();
    }

    public abstract void addComponent(AbsGuildProfileComponent absGuildProfileComponent);

    public abstract AbsGuildProfileComponent createComponent(int i3, GuildProfileData guildProfileData);

    public abstract AbsGuildProfileComponent getComponent(int i3);

    public abstract ViewGroup getContentViewContainer();

    public abstract a getDelegate();

    public abstract /* synthetic */ void handleDismissAction();

    public abstract void init(Fragment fragment, GuildProfileData guildProfileData, a aVar);

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public abstract /* synthetic */ void onConfigurationChanged();

    public abstract /* synthetic */ void onCreate(Fragment fragment, AppInterface appInterface, Bundle bundle);

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public abstract /* synthetic */ void onDestroy();

    public abstract /* synthetic */ void onInitData(Object obj);

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public abstract /* synthetic */ void onLoadFinish();

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public abstract /* synthetic */ void onLoadStart();

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public abstract /* synthetic */ void onPause();

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public abstract /* synthetic */ void onResume();

    public abstract /* synthetic */ void onUpdateData(Object obj);

    public abstract void removeComponent(AbsGuildProfileComponent absGuildProfileComponent);

    public abstract void setContentViewContainer(ViewGroup viewGroup);

    public abstract /* synthetic */ void setDismissAction(b bVar);
}
