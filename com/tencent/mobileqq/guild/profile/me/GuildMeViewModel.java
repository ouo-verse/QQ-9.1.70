package com.tencent.mobileqq.guild.profile.me;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.guild.profile.me.edit.GuildMeAddFriendModel;
import com.tencent.mobileqq.guild.sign.config.GuildSignAndWalletConfig;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreatedGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalPrivacySwitchGroup;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import wh2.aw;
import wh2.de;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMeViewModel extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    private static final String TAG = "Guild.profile.GuildMeViewModel";
    private IGPSService mGPSService;
    private final GPServiceObserver mGPServiceObserver;
    private final MutableLiveData<ri1.a> mGuildError;
    private final MutableLiveData<String> mInfo;
    private final MutableLiveData<GuildMeAddFriendModel> mIsFriendSwitchChecked;
    private final MutableLiveData<Boolean> mIsQQProfileSwitchChecked;
    private final MutableLiveData<ArrayList<IGProCreatedGuildInfo>> mMyGuildsList;
    private final MutableLiveData<String> mName;
    private final ak mProfileChangeListener;
    private final MutableLiveData<ev> mSelfInfoUpdateLiveData;
    private final MutableLiveData<GuildSignAndWalletConfig.GuildWalletEntranceConfig> mWalletConfig;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onCreateGuild(IGProGuildInfo iGProGuildInfo) {
            super.onCreateGuild(iGProGuildInfo);
            if (QLog.isColorLevel()) {
                QLog.i(GuildMeViewModel.TAG, 2, "IGProGuildInfo onCreateGuild");
            }
            GuildMeViewModel.this.fetchMyCreatedGuildList();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(String str) {
            super.onDestoryGuild(str);
            if (QLog.isColorLevel()) {
                QLog.i(GuildMeViewModel.TAG, 2, "onDestroyGuild id=" + str);
            }
            if (GuildMeViewModel.this.isMyCreatedGuild(str)) {
                GuildMeViewModel.this.fetchMyCreatedGuildList();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            super.onGuildInfoUpdated(str);
            if (QLog.isColorLevel()) {
                QLog.i(GuildMeViewModel.TAG, 2, "onGuildInfoUpdated,fetch my created list\uff1aguildId: " + str);
            }
            if (GuildMeViewModel.this.isMyCreatedGuild(str)) {
                GuildMeViewModel.this.fetchMyCreatedGuildList();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements ak {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.profile.me.ak
        public void a(@NonNull ev evVar) {
            if (QLog.isColorLevel()) {
                QLog.i(GuildMeViewModel.TAG, 2, "onProfileChange name: " + evVar.getNickName());
            }
            GuildMeViewModel.this.mSelfInfoUpdateLiveData.postValue(evVar);
            GuildMeViewModel.this.dealProfileInfo(evVar);
        }
    }

    public GuildMeViewModel(wy1.a aVar) {
        super(aVar);
        this.mGPServiceObserver = createGpServiceObserver();
        this.mProfileChangeListener = createProfileChangeListener();
        this.mName = new MutableLiveData<>();
        this.mInfo = new MutableLiveData<>();
        this.mSelfInfoUpdateLiveData = new MutableLiveData<>();
        this.mMyGuildsList = new MutableLiveData<>();
        this.mIsFriendSwitchChecked = new MutableLiveData<>();
        this.mIsQQProfileSwitchChecked = new MutableLiveData<>();
        this.mGuildError = new MutableLiveData<>();
        this.mWalletConfig = new MutableLiveData<>();
    }

    private void addObserver() {
        this.mGPSService.addObserver(this.mGPServiceObserver);
        aj.g(this.mProfileChangeListener);
    }

    private void concatProfileInfo(int i3, int i16, String str, long j3) {
        int i17;
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 1) {
            sb5.append("\u7537 ");
        } else if (i3 == 2) {
            sb5.append("\u5973 ");
        }
        if (i16 >= 0) {
            sb5.append(i16);
            sb5.append("\u5c81 ");
        }
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
        }
        if (j3 > 0) {
            i17 = getDateDiffDays(j3 * 1000, NetConnInfoCenter.getServerTimeMillis());
        } else {
            i17 = 0;
        }
        if (i17 > 0) {
            if (sb5.length() > 0) {
                sb5.append(APLogFileUtil.SEPARATOR_LOG);
            }
            sb5.append("\u52a0\u5165\u9891\u9053");
            sb5.append(i17);
            sb5.append("\u5929");
        } else if (i17 == 0) {
            if (sb5.length() > 0) {
                sb5.append(APLogFileUtil.SEPARATOR_LOG);
            }
            sb5.append("\u521a\u521a\u52a0\u5165\u9891\u9053");
        }
        if (sb5.length() > 0) {
            this.mInfo.postValue(sb5.toString());
        }
    }

    private GPServiceObserver createGpServiceObserver() {
        return new a();
    }

    private ak createProfileChangeListener() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealProfileInfo(ev evVar) {
        String nickName = evVar.getNickName();
        if (!TextUtils.isEmpty(nickName)) {
            this.mName.postValue(nickName);
        }
        concatProfileInfo(evVar.getGender(), evVar.getAge(), lv1.a.a(evVar).toString(), evVar.q());
    }

    private int getDateDiffDays(long j3, long j16) {
        if (j3 > 0 && j16 > 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "date: " + com.tencent.mobileqq.remind.e.a(j3) + " - date2: " + com.tencent.mobileqq.remind.e.a(j16));
            }
            return (int) ((((Math.abs(j3 - j16) / 1000) / 60) / 60) / 24);
        }
        return -1;
    }

    private int getSwitchStatusByChecked(boolean z16) {
        if (z16) {
            return 2;
        }
        return 3;
    }

    private boolean isEqualGuildInfo(IGProCreatedGuildInfo iGProCreatedGuildInfo, IGProCreatedGuildInfo iGProCreatedGuildInfo2) {
        if (iGProCreatedGuildInfo.getGuildId() == iGProCreatedGuildInfo2.getGuildId() && TextUtils.equals(iGProCreatedGuildInfo.getFaceUrl(), iGProCreatedGuildInfo2.getFaceUrl())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMyCreatedGuild(String str) {
        ArrayList<IGProCreatedGuildInfo> value = this.mMyGuildsList.getValue();
        if (value == null) {
            return true;
        }
        Iterator<IGProCreatedGuildInfo> it = value.iterator();
        while (it.hasNext()) {
            if (it.next().getGuildId() == az.d(str, 0L)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchMyCreatedGuildList$0(int i3, String str, ArrayList arrayList) {
        if (i3 != 0) {
            QLog.e(TAG, 1, "fetch data failed:result=" + i3 + "msg:" + str);
            SecurityTipHelperKt.A(ch.i(), i3, str, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "fetchMyCreatedGuildList list: " + arrayList);
        }
        if (needUpdateGuild(arrayList)) {
            this.mMyGuildsList.postValue(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchProfilePrivacySetting$3(int i3, String str, IGProGlobalPrivacySwitchGroup iGProGlobalPrivacySwitchGroup) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (i3 != 0) {
            QLog.i(TAG, 1, String.format("fetchDirectMsgStatus result:%d, errMsg:%s, addFriendSwitch:%d, allSwitch:%d", Integer.valueOf(i3), str, Integer.valueOf(iGProGlobalPrivacySwitchGroup.getAddFriendSwitch()), Integer.valueOf(iGProGlobalPrivacySwitchGroup.getAllSwitch())));
            this.mIsFriendSwitchChecked.postValue(new GuildMeAddFriendModel(true));
            this.mIsQQProfileSwitchChecked.postValue(Boolean.TRUE);
            return;
        }
        MutableLiveData<GuildMeAddFriendModel> mutableLiveData = this.mIsFriendSwitchChecked;
        if (iGProGlobalPrivacySwitchGroup.getAddFriendSwitch() != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (iGProGlobalPrivacySwitchGroup.getAllSwitch() != 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        mutableLiveData.postValue(new GuildMeAddFriendModel(z16, z17));
        MutableLiveData<Boolean> mutableLiveData2 = this.mIsQQProfileSwitchChecked;
        if (iGProGlobalPrivacySwitchGroup.getQqProfileShowSwitch() != 1) {
            z18 = true;
        }
        mutableLiveData2.postValue(Boolean.valueOf(z18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAddFriendSwitchStatus$1(boolean z16, int i3, String str, IGProGlobalPrivacySwitchGroup iGProGlobalPrivacySwitchGroup) {
        if (z16 && iGProGlobalPrivacySwitchGroup.getAllSwitch() == 1) {
            this.mIsFriendSwitchChecked.postValue(new GuildMeAddFriendModel(false, false, "QQ\u5df2\u8bbe\u7f6e\u7981\u6b62\u4efb\u4f55\u65b9\u5f0f\u52a0\u6211\u4e3a\u597d\u53cb"));
        }
        if (i3 != 0) {
            QLog.w(TAG, 1, "result = " + i3 + ", errMsg=" + str + ", switchGroup=" + iGProGlobalPrivacySwitchGroup);
            this.mIsFriendSwitchChecked.postValue(new GuildMeAddFriendModel(z16 ^ true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewQQProfileSwitchStatus$2(boolean z16, int i3, String str, IGProGlobalPrivacySwitchGroup iGProGlobalPrivacySwitchGroup) {
        if (i3 != 0) {
            QLog.w(TAG, 1, "result = " + i3 + ", errMsg=" + str + ", switchGroup=" + iGProGlobalPrivacySwitchGroup);
            this.mIsQQProfileSwitchChecked.postValue(Boolean.valueOf(z16 ^ true));
            this.mGuildError.setValue(ri1.a.b(i3, str));
        }
    }

    private boolean needUpdateGuild(ArrayList<IGProCreatedGuildInfo> arrayList) {
        ArrayList<IGProCreatedGuildInfo> value = this.mMyGuildsList.getValue();
        if (value == arrayList) {
            return false;
        }
        if (value == null || value.size() != arrayList.size()) {
            return true;
        }
        int size = value.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!isEqualGuildInfo(value.get(i3), arrayList.get(i3))) {
                return true;
            }
        }
        return false;
    }

    private void removeObserver() {
        this.mGPSService.deleteObserver(this.mGPServiceObserver);
        aj.q(this.mProfileChangeListener);
    }

    public void fetchMyCreatedGuildList() {
        this.mGPSService.fetchMyCreateGuilds(new aw() { // from class: com.tencent.mobileqq.guild.profile.me.m
            @Override // wh2.aw
            public final void onFetchMyCreateGuilds(int i3, String str, ArrayList arrayList) {
                GuildMeViewModel.this.lambda$fetchMyCreatedGuildList$0(i3, str, arrayList);
            }
        });
    }

    @SuppressLint({"DefaultLocale"})
    public void fetchProfilePrivacySetting() {
        this.mGPSService.fetchGlobalPrivacySwitch(new de() { // from class: com.tencent.mobileqq.guild.profile.me.j
            @Override // wh2.de
            public final void a(int i3, String str, IGProGlobalPrivacySwitchGroup iGProGlobalPrivacySwitchGroup) {
                GuildMeViewModel.this.lambda$fetchProfilePrivacySetting$3(i3, str, iGProGlobalPrivacySwitchGroup);
            }
        });
    }

    public LiveData<ri1.a> getGuildError() {
        return this.mGuildError;
    }

    public MutableLiveData<String> getInfo() {
        return this.mInfo;
    }

    public MutableLiveData<ArrayList<IGProCreatedGuildInfo>> getMyCreatedGuildList() {
        return this.mMyGuildsList;
    }

    public MutableLiveData<String> getName() {
        return this.mName;
    }

    public MutableLiveData<ev> getSelfInfoUpdateLiveData() {
        return this.mSelfInfoUpdateLiveData;
    }

    public LiveData<GuildSignAndWalletConfig.GuildWalletEntranceConfig> getWalletConfig() {
        return this.mWalletConfig;
    }

    public void init() {
        this.mGPSService = (IGPSService) ch.R0(IGPSService.class);
        addObserver();
        ev l3 = aj.l();
        if (l3 != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "init nickname: " + l3.getNickName());
            }
            dealProfileInfo(l3);
            this.mSelfInfoUpdateLiveData.setValue(l3);
        } else {
            QLog.w(TAG, 1, "init nickname: userProfileInfo is null");
        }
        this.mWalletConfig.setValue(GuildSignAndWalletConfig.INSTANCE.a().getGuildWalletEntranceConfig());
    }

    public MutableLiveData<GuildMeAddFriendModel> isFriendSwitchChecked() {
        return this.mIsFriendSwitchChecked;
    }

    public LiveData<Boolean> isQQProfileSwitchChecked() {
        return this.mIsQQProfileSwitchChecked;
    }

    public void onAfterAccountChanged(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onAfterAccountChanged isSwitchAccount: " + z16);
        }
        this.mGPSService = (IGPSService) ch.R0(IGPSService.class);
        addObserver();
        fetchMyCreatedGuildList();
        this.mWalletConfig.setValue(GuildSignAndWalletConfig.INSTANCE.a().getGuildWalletEntranceConfig());
    }

    public void onBeforeAccountChanged() {
        removeObserver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        removeObserver();
    }

    public void setAddFriendSwitchStatus(final boolean z16) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        this.mGPSService.setGlobalPrivacySwitch(i3, 0, new de() { // from class: com.tencent.mobileqq.guild.profile.me.l
            @Override // wh2.de
            public final void a(int i16, String str, IGProGlobalPrivacySwitchGroup iGProGlobalPrivacySwitchGroup) {
                GuildMeViewModel.this.lambda$setAddFriendSwitchStatus$1(z16, i16, str, iGProGlobalPrivacySwitchGroup);
            }
        });
    }

    public void setViewQQProfileSwitchStatus(final boolean z16) {
        int i3;
        this.mIsQQProfileSwitchChecked.postValue(Boolean.valueOf(z16));
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        this.mGPSService.setGlobalPrivacySwitch(i3, 1, new de() { // from class: com.tencent.mobileqq.guild.profile.me.k
            @Override // wh2.de
            public final void a(int i16, String str, IGProGlobalPrivacySwitchGroup iGProGlobalPrivacySwitchGroup) {
                GuildMeViewModel.this.lambda$setViewQQProfileSwitchStatus$2(z16, i16, str, iGProGlobalPrivacySwitchGroup);
            }
        });
    }
}
