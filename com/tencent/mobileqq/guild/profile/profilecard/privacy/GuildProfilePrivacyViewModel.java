package com.tencent.mobileqq.guild.profile.profilecard.privacy;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.profile.profilecard.main.l;
import com.tencent.mobileqq.guild.profile.profilecard.privacy.GuildProfilePrivacyViewModel;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.mvvm.c;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import vh2.cd;
import vh2.r;
import wy1.a;

/* loaded from: classes14.dex */
public class GuildProfilePrivacyViewModel extends c<a> {
    private static final String TAG = "Guild.profile.GuildProfilePrivacyViewModel";
    private GuildBaseProfileData mGuildBaseProfileData;
    private final MutableLiveData<Boolean> mIsSwitchChecked;
    private final cn<l> mToastEvent;

    public GuildProfilePrivacyViewModel(a aVar) {
        super(aVar);
        this.mToastEvent = new cn<>();
        this.mIsSwitchChecked = new MutableLiveData<>();
    }

    private int getSwitchStatusByChecked(boolean z16) {
        if (z16) {
            return 2;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchDirectMsgStatus$1(int i3, String str, int i16, int i17, int i18) {
        boolean z16 = false;
        QLog.i(TAG, 1, String.format("fetchDirectMsgStatus result:%d, errMsg:%s, status:%d", Integer.valueOf(i3), str, Integer.valueOf(i16)));
        if (i3 != 0) {
            this.mIsSwitchChecked.postValue(Boolean.TRUE);
            return;
        }
        MutableLiveData<Boolean> mutableLiveData = this.mIsSwitchChecked;
        if (i16 == 2) {
            z16 = true;
        }
        mutableLiveData.postValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDirectMsgSwitchStatus$0(boolean z16, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        QLog.i(TAG, 2, String.format("setDirectMsgSwitchStatus\uff1aresult = %d, errMsg = %s, errMsg = %s", Integer.valueOf(i3), str, str));
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            if (((a) this.mRepository).l() == null) {
                return;
            }
            notifySwitchChanged(z16);
        } else {
            this.mToastEvent.postValue(new l(i3, str, iGProSecurityResult));
            MutableLiveData<Boolean> mutableLiveData = this.mIsSwitchChecked;
            mutableLiveData.postValue(mutableLiveData.getValue());
        }
    }

    private void notifySwitchChanged(boolean z16) {
        ((QQGuildHandler) ((a) this.mRepository).l().getBusinessHandler(QQGuildHandler.class.getName())).c3(z16);
    }

    public void fetchDirectMsgStatus() {
        ((IGPSService) ((a) this.mRepository).l().getRuntimeService(IGPSService.class, "")).fetchDirectMsgStatus(new r() { // from class: cw1.b
            @Override // vh2.r
            public final void a(int i3, String str, int i16, int i17, int i18) {
                GuildProfilePrivacyViewModel.this.lambda$fetchDirectMsgStatus$1(i3, str, i16, i17, i18);
            }
        });
    }

    public GuildBaseProfileData getGuildBaseProfileData() {
        return this.mGuildBaseProfileData;
    }

    public cn<l> getToastEvent() {
        return this.mToastEvent;
    }

    public MutableLiveData<Boolean> isSwitchChanged() {
        return this.mIsSwitchChecked;
    }

    public void setDirectMsgSwitchStatus(final boolean z16) {
        ((IGPSService) ((a) this.mRepository).l().getRuntimeService(IGPSService.class, "")).setDirectMsgStatus(getSwitchStatusByChecked(z16), 0, new cd() { // from class: cw1.c
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                GuildProfilePrivacyViewModel.this.lambda$setDirectMsgSwitchStatus$0(z16, i3, str, iGProSecurityResult);
            }
        });
    }

    public void setGuildBaseProfileData(GuildBaseProfileData guildBaseProfileData) {
        this.mGuildBaseProfileData = guildBaseProfileData;
    }
}
