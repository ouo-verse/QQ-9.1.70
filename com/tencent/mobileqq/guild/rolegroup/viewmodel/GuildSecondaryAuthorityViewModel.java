package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.rolegroup.model.data.Permissions;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.type.IPermissionType;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import or1.c;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildSecondaryAuthorityViewModel extends com.tencent.mobileqq.guild.base.b<wy1.a> implements com.tencent.mobileqq.guild.base.repository.a {
    private static final String TAG = "Guild.rg.GuildSecondaryAuthorityViewModel";
    private String mChannelId;
    private final GPServiceObserver mGProObserver;
    private String mGuildId;
    private IGPSService mIgpsService;
    private final MutableLiveData<Boolean> mIsCategoryAdmin;
    private MutableLiveData<Boolean> mIsEnableFeedBatchManage;
    private final MutableLiveData<Boolean> mIsGuildAdminOrCreator;
    private final MutableLiveData<Boolean> mIsGuildCreator;
    private final MutableLiveData<Boolean> mNoticeAuthorityEnd;
    private final MutableLiveData<Boolean> mShowBlackListMember;
    private final MutableLiveData<Boolean> mShowCategoryChannelManageLiveData;
    private final MutableLiveData<Boolean> mShowChannelEditCheck;
    private final MutableLiveData<Boolean> mShowChannelEditSpeak;
    private final MutableLiveData<Boolean> mShowChannelManage;
    private final MutableLiveData<Boolean> mShowCreateChannel;
    private final MutableLiveData<Boolean> mShowCreateChannelOrGroup;
    private final MutableLiveData<Boolean> mShowCreateGroup;
    private final MutableLiveData<Boolean> mShowDataBoard;
    private final MutableLiveData<Boolean> mShowDeleteGroup;
    private final MutableLiveData<Boolean> mShowForbiddenWords;
    private final MutableLiveData<Boolean> mShowGuildJoinMode;
    private final MutableLiveData<Boolean> mShowGuildManage;
    private final MutableLiveData<Boolean> mShowManageLog;
    private final MutableLiveData<Boolean> mShowModifyChannelName;
    private final MutableLiveData<Boolean> mShowModifyGroupName;
    private final MutableLiveData<Boolean> mShowModifyGuildInfo;
    private final MutableLiveData<Boolean> mShowModifyRole;
    private final MutableLiveData<Boolean> mShowModifyVoiceChannel;
    private final MutableLiveData<Boolean> mShowPlatformIdentity;
    private final MutableLiveData<Boolean> mShowRemoveMember;
    private final MutableLiveData<Boolean> mShowRoleGroupManage;
    private final MutableLiveData<Boolean> mShowSearchKeyWordOrPreviewedGuildSwitch;
    private final MutableLiveData<Boolean> mShowSignInLiveData;
    private final MutableLiveData<Boolean> mShowSortIcon;
    private final MutableLiveData<Boolean> mShowSpeakRuleManage;
    private final MutableLiveData<Boolean> mShowVisitorRedPoint;
    private final c.a mVisitorRedListener;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements c.a {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(String str, HashSet<String> hashSet) {
            super.onChannelPermissionChanged(str, hashSet);
            if (TextUtils.equals(str, GuildSecondaryAuthorityViewModel.this.mGuildId) && hashSet != null && hashSet.contains(GuildSecondaryAuthorityViewModel.this.mChannelId)) {
                GuildSecondaryAuthorityViewModel guildSecondaryAuthorityViewModel = GuildSecondaryAuthorityViewModel.this;
                guildSecondaryAuthorityViewModel.loadGuildRoles(str, guildSecondaryAuthorityViewModel.mChannelId, "onChannelPermissionChanged");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(String str, dx dxVar) {
            super.onGuildPermissionChanged(str, dxVar);
            if (TextUtils.equals(str, GuildSecondaryAuthorityViewModel.this.mGuildId)) {
                GuildSecondaryAuthorityViewModel.this.loadGuildRoles(str, "", "onGuildPermissionChanged");
            }
        }
    }

    public GuildSecondaryAuthorityViewModel(wy1.a aVar) {
        super(aVar);
        this.mGProObserver = createObserver();
        this.mVisitorRedListener = new a();
        this.mIsGuildCreator = new MutableLiveData<>();
        this.mIsGuildAdminOrCreator = new MutableLiveData<>();
        this.mShowModifyGuildInfo = new MutableLiveData<>();
        this.mShowSearchKeyWordOrPreviewedGuildSwitch = new MutableLiveData<>();
        this.mShowPlatformIdentity = new MutableLiveData<>();
        this.mShowRemoveMember = new MutableLiveData<>();
        this.mShowBlackListMember = new MutableLiveData<>();
        this.mShowForbiddenWords = new MutableLiveData<>();
        this.mShowModifyRole = new MutableLiveData<>();
        this.mShowDataBoard = new MutableLiveData<>();
        this.mShowManageLog = new MutableLiveData<>();
        this.mShowCreateGroup = new MutableLiveData<>();
        this.mShowModifyGroupName = new MutableLiveData<>();
        this.mShowDeleteGroup = new MutableLiveData<>();
        this.mShowCreateChannel = new MutableLiveData<>();
        this.mShowModifyChannelName = new MutableLiveData<>();
        this.mShowModifyVoiceChannel = new MutableLiveData<>();
        this.mShowCreateChannelOrGroup = new MutableLiveData<>();
        this.mShowGuildManage = new MutableLiveData<>();
        this.mShowChannelManage = new MutableLiveData<>();
        this.mShowGuildJoinMode = new MutableLiveData<>();
        this.mShowRoleGroupManage = new MutableLiveData<>();
        this.mShowChannelEditCheck = new MutableLiveData<>();
        this.mShowChannelEditSpeak = new MutableLiveData<>();
        this.mNoticeAuthorityEnd = new MutableLiveData<>();
        this.mShowVisitorRedPoint = new MutableLiveData<>();
        this.mShowSortIcon = new MutableLiveData<>();
        this.mIsCategoryAdmin = new MutableLiveData<>();
        this.mShowCategoryChannelManageLiveData = new MutableLiveData<>();
        this.mShowSpeakRuleManage = new MutableLiveData<>();
        this.mShowSignInLiveData = new MutableLiveData<>();
        this.mIsEnableFeedBatchManage = new MutableLiveData<>(Boolean.FALSE);
    }

    private GPServiceObserver createObserver() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadGuildRoles(String str, String str2, String str3) {
        Permissions channelPermission;
        Permissions permissions;
        boolean z16;
        this.mGuildId = str;
        this.mChannelId = str2;
        if (TextUtils.isEmpty(str2)) {
            channelPermission = com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().getGuildPermission(str);
        } else {
            channelPermission = com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().getChannelPermission(str, str2);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "guildPermission is " + channelPermission + " from:" + str3);
        }
        boolean n06 = ch.n0(str);
        boolean m06 = ch.m0(str);
        boolean g06 = ch.g0(str);
        boolean a16 = channelPermission.a(10001);
        boolean a17 = channelPermission.a(10003);
        boolean z17 = channelPermission.d() || g06;
        boolean a18 = channelPermission.a(70002);
        boolean z18 = a18 || channelPermission.i();
        boolean a19 = channelPermission.a(80002);
        boolean a26 = channelPermission.a(100001);
        boolean a27 = channelPermission.a(100002);
        boolean a28 = channelPermission.a(90001);
        boolean e16 = or1.c.e();
        boolean a29 = channelPermission.a(50001);
        boolean a36 = channelPermission.a(60001);
        boolean z19 = z17;
        boolean a37 = channelPermission.a(IPermissionType.MODIFY_CHANNEL_VIEW);
        boolean a38 = channelPermission.a(IPermissionType.MODIFY_CHANNEL_SPEAK);
        boolean a39 = channelPermission.a(20005);
        boolean a46 = channelPermission.a(20006);
        boolean a47 = channelPermission.a(20007);
        boolean a48 = channelPermission.a(20001);
        boolean a49 = channelPermission.a(20003);
        boolean a56 = channelPermission.a(20012);
        if (m06 || z18 || a16 || a19 || a17 || a27 || a28 || a36 || a29) {
            permissions = channelPermission;
            z16 = true;
        } else {
            permissions = channelPermission;
            z16 = false;
        }
        boolean z26 = z18;
        this.mIsGuildCreator.setValue(Boolean.valueOf(n06));
        this.mIsGuildAdminOrCreator.setValue(Boolean.valueOf(m06));
        this.mIsCategoryAdmin.setValue(Boolean.valueOf(g06));
        this.mShowModifyGuildInfo.setValue(Boolean.valueOf(a16));
        this.mShowSearchKeyWordOrPreviewedGuildSwitch.setValue(Boolean.valueOf(a19));
        this.mShowPlatformIdentity.setValue(Boolean.valueOf(a17));
        this.mShowRemoveMember.setValue(Boolean.valueOf(a26));
        this.mShowBlackListMember.setValue(Boolean.valueOf(a27));
        this.mShowForbiddenWords.setValue(Boolean.valueOf(a28));
        this.mShowModifyRole.setValue(Boolean.valueOf(a18));
        this.mShowDataBoard.setValue(Boolean.valueOf(a29));
        this.mShowManageLog.setValue(Boolean.valueOf(a36));
        this.mShowCreateGroup.setValue(Boolean.valueOf(a39));
        this.mShowModifyGroupName.setValue(Boolean.valueOf(a46));
        this.mShowCreateChannelOrGroup.setValue(Boolean.valueOf(a48 || a39));
        this.mShowDeleteGroup.setValue(Boolean.valueOf(a47));
        this.mShowCreateChannel.setValue(Boolean.valueOf(a48));
        this.mShowModifyChannelName.setValue(Boolean.valueOf(a49));
        this.mShowModifyVoiceChannel.setValue(Boolean.valueOf(a56));
        this.mShowGuildManage.setValue(Boolean.valueOf(z16));
        this.mShowGuildJoinMode.setValue(Boolean.valueOf(a19));
        this.mShowChannelManage.setValue(Boolean.valueOf(z19));
        this.mShowRoleGroupManage.setValue(Boolean.valueOf(z26));
        this.mShowChannelEditCheck.setValue(Boolean.valueOf(a37));
        this.mShowChannelEditSpeak.setValue(Boolean.valueOf(a38));
        this.mShowVisitorRedPoint.setValue(Boolean.valueOf(e16));
        this.mNoticeAuthorityEnd.setValue(Boolean.TRUE);
        this.mShowSortIcon.setValue(Boolean.valueOf(m06 || g06));
        this.mShowCategoryChannelManageLiveData.setValue(Boolean.valueOf(n06 || permissions.c()));
        Permissions permissions2 = permissions;
        this.mShowSpeakRuleManage.setValue(Boolean.valueOf(n06 || (permissions2.a(10004) && permissions2.a(10005))));
        this.mShowSignInLiveData.setValue(Boolean.valueOf(n06 || (m06 && permissions2.a(10009))));
        this.mIsEnableFeedBatchManage.postValue(Boolean.valueOf(m06 || permissions2.a(30002)));
    }

    public MutableLiveData<Boolean> getIsCategoryAdmin() {
        return this.mIsCategoryAdmin;
    }

    public MutableLiveData<Boolean> getIsCategoryChannelManager() {
        return this.mShowCategoryChannelManageLiveData;
    }

    public MutableLiveData<Boolean> getIsGuildAdminOrCreator() {
        return this.mIsGuildAdminOrCreator;
    }

    public MutableLiveData<Boolean> getIsGuildCreator() {
        return this.mIsGuildCreator;
    }

    public MutableLiveData<Boolean> getIsShowSortIcon() {
        return this.mShowSortIcon;
    }

    public MutableLiveData<Boolean> getNoticeAuthorityEnd() {
        return this.mNoticeAuthorityEnd;
    }

    public MutableLiveData<Boolean> getShowBlackListMember() {
        return this.mShowBlackListMember;
    }

    public MutableLiveData<Boolean> getShowChannelEditCheck() {
        return this.mShowChannelEditCheck;
    }

    public MutableLiveData<Boolean> getShowChannelEditSpeak() {
        return this.mShowChannelEditSpeak;
    }

    public MutableLiveData<Boolean> getShowChannelManage() {
        return this.mShowChannelManage;
    }

    public MutableLiveData<Boolean> getShowCreateChannel() {
        return this.mShowCreateChannel;
    }

    public MutableLiveData<Boolean> getShowCreateChannelOrGroup() {
        return this.mShowCreateChannelOrGroup;
    }

    public MutableLiveData<Boolean> getShowCreateGroup() {
        return this.mShowCreateGroup;
    }

    public MutableLiveData<Boolean> getShowDataBoard() {
        return this.mShowDataBoard;
    }

    public MutableLiveData<Boolean> getShowDeleteGroup() {
        return this.mShowDeleteGroup;
    }

    public MutableLiveData<Boolean> getShowForbiddenWords() {
        return this.mShowForbiddenWords;
    }

    public MutableLiveData<Boolean> getShowGuildJoinMode() {
        return this.mShowGuildJoinMode;
    }

    public MutableLiveData<Boolean> getShowGuildManage() {
        return this.mShowGuildManage;
    }

    public MutableLiveData<Boolean> getShowManageLog() {
        return this.mShowManageLog;
    }

    public MutableLiveData<Boolean> getShowModifyChannelName() {
        return this.mShowModifyChannelName;
    }

    public MutableLiveData<Boolean> getShowModifyGroupName() {
        return this.mShowModifyGroupName;
    }

    public MutableLiveData<Boolean> getShowModifyGuildInfo() {
        return this.mShowModifyGuildInfo;
    }

    public MutableLiveData<Boolean> getShowModifyRole() {
        return this.mShowModifyRole;
    }

    public MutableLiveData<Boolean> getShowModifyVoiceChannel() {
        return this.mShowModifyVoiceChannel;
    }

    public MutableLiveData<Boolean> getShowPlatformIdentity() {
        return this.mShowPlatformIdentity;
    }

    public MutableLiveData<Boolean> getShowRemoveMember() {
        return this.mShowRemoveMember;
    }

    public MutableLiveData<Boolean> getShowRoleGroupManage() {
        return this.mShowRoleGroupManage;
    }

    public MutableLiveData<Boolean> getShowSearchKeyWordOrPreviewedGuildSwitch() {
        return this.mShowSearchKeyWordOrPreviewedGuildSwitch;
    }

    public MutableLiveData<Boolean> getShowSignInfLiveData() {
        return this.mShowSignInLiveData;
    }

    public MutableLiveData<Boolean> getShowVisitorRedPoint() {
        return this.mShowVisitorRedPoint;
    }

    public MutableLiveData<Boolean> getSpeakRuleManagerLiveData() {
        return this.mShowSpeakRuleManage;
    }

    public void init(IGProGuildInfo iGProGuildInfo, String str) {
        if (iGProGuildInfo == null) {
            QLog.w(TAG, 1, "guildInfo is null");
        } else {
            init(iGProGuildInfo.getGuildID(), "", str);
        }
    }

    public MutableLiveData<Boolean> isEnableFeedBatchManage() {
        return this.mIsEnableFeedBatchManage;
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onAccountChanged account: " + str);
        }
        IGPSService iGPSService = this.mIgpsService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.mGProObserver);
        }
        IGPSService iGPSService2 = (IGPSService) ch.R0(IGPSService.class);
        this.mIgpsService = iGPSService2;
        iGPSService2.addObserver(this.mGProObserver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        AccountChangedNotifier.f214789d.d(this);
        or1.c.d(this.mVisitorRedListener);
        IGPSService iGPSService = this.mIgpsService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.mGProObserver);
        }
    }

    public void init(String str, String str2) {
        init(str, "", str2);
    }

    public void init(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "guildId is null");
            return;
        }
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        this.mIgpsService = iGPSService;
        iGPSService.addObserver(this.mGProObserver);
        loadGuildRoles(str, str2, str3);
        AccountChangedNotifier.f214789d.a(this);
        or1.c.b(this.mVisitorRedListener);
    }
}
