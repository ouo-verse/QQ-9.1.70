package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.ark.Constants;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ark.share.IShareArkViewApi;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.api.IGuildTextForwardApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.util.GuildForwardUtilKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.api.IArkMsgService;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardQzoneArkMsgOption extends ForwardBaseOption implements al {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f210793d;

    public ForwardQzoneArkMsgOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        } else {
            this.f210793d = QZoneConfigHelper.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(SessionInfo sessionInfo, String str) {
        com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, str);
    }

    private boolean p(String str, String str2, int i3) {
        final String userInputStr = getUserInputStr();
        if (!TextUtils.isEmpty(userInputStr)) {
            if (QLog.isColorLevel()) {
                QLog.i(ForwardBaseOption.TAG, 2, "sendMessage2TargetOnConfirmNew: invoked. textAndEmoji: " + userInputStr);
            }
            if (i3 == 10014) {
                ((IGuildTextForwardApi) QRoute.api(IGuildTextForwardApi.class)).sendMsg(str2, str, userInputStr);
                return true;
            }
            final SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179555d = i3;
            sessionInfo.f179557e = str;
            sessionInfo.f179559f = str2;
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.forward.r
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardQzoneArkMsgOption.m(SessionInfo.this, userInputStr);
                }
            });
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, com.tencent.mobileqq.guild.feed.api.g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean addStructView(QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) qQCustomDialog)).booleanValue();
        }
        if (!this.mExtraData.getBoolean("is_ark_display_share")) {
            super.addStructView(qQCustomDialog);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ boolean b() {
        return ak.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (!this.mFromSharePanelPreviewAndSend && !useBottomSheetPreview()) {
            return super.buildNewVersionContentView();
        }
        return ((IShareArkViewApi) QRoute.api(IShareArkViewApi.class)).createShareArkView(this.mActivity, this.mExtraData);
    }

    @Override // com.tencent.mobileqq.forward.al
    @Nullable
    public SharePublishGuildFeedParam c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (SharePublishGuildFeedParam) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return GuildForwardUtilKt.g(this.mExtraData);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getDialogContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (TextUtils.isEmpty(this.mForwardText)) {
            String string = this.mExtraData.getString("forward_ark_app_prompt");
            this.mForwardText = string;
            if (TextUtils.isEmpty(string)) {
                this.mForwardText = this.mExtraData.getString(AppConstants.Key.FORWARD_ARK_APP_DESC);
            }
        }
        return this.mForwardText;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null && !Utils.J(recentUser.uin) && recentUser.getType() != 1008 && recentUser.getType() != 1005 && (recentUser.getType() != 1006 || isSupportAbility(e.U3))) {
                if (recentUser.getType() != 1009 && recentUser.getType() != 1021 && recentUser.getType() != 10004 && recentUser.getType() != 7000 && recentUser.getType() != 6004 && recentUser.getType() != 9501 && (recentUser.getType() != 0 || !CrmUtils.v(this.app, recentUser.uin, recentUser.getType()))) {
                    arrayList.add(recentUser);
                }
            }
        }
        return arrayList;
    }

    protected boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return o(this.mExtraData.getString("uin"), this.mExtraData.getInt("uintype"), this.mExtraData.getString("troop_uin"), this.mExtraData.getString("guild_id"));
    }

    protected boolean o(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2, str3)).booleanValue();
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = str;
        sessionInfo.f179559f = str2;
        if (i3 >= 0 && !TextUtils.isEmpty(str)) {
            String string = this.mExtraData.getString("forward_ark_app_name");
            String string2 = this.mExtraData.getString("forward_ark_app_view");
            String string3 = this.mExtraData.getString("forward_ark_biz_src", "");
            String string4 = this.mExtraData.getString("forward_ark_app_meta");
            String string5 = this.mExtraData.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG);
            String string6 = this.mExtraData.getString("forward_ark_app_prompt");
            String string7 = this.mExtraData.getString(AppConstants.Key.FORWARD_ARK_APP_DESC);
            String str4 = Constants.DEFAULT_MIN_APP_VERSION;
            Map<String, String> applicationFromManifest = ArkAppCacheMgr.getApplicationFromManifest(string, string3, Constants.DEFAULT_MIN_APP_VERSION);
            if (applicationFromManifest != null && applicationFromManifest.containsKey("version")) {
                str4 = applicationFromManifest.get("version");
            }
            String str5 = str4;
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
                    ReportCenter.f().p(this.app.getCurrentAccountUin(), "", "0", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID, "2006", "0", false);
                }
                ArkAppMessage arkAppMessage = new ArkAppMessage(string6, string, string3, string7, string2, str5, string4, string5, "");
                ArkAppMessage arkAppMessage2 = (ArkAppMessage) com.tencent.mobileqq.ark.e.a(2, string, this.mExtraData, arkAppMessage);
                if (arkAppMessage2 != null) {
                    arkAppMessage = arkAppMessage2;
                }
                String string8 = this.mExtraData.getString(AppConstants.Key.FORWARD_APPID_ARK_FROM_SDK);
                String string9 = this.mExtraData.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME);
                String string10 = this.mExtraData.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA);
                String string11 = this.mExtraData.getString("struct_share_key_source_a_action_data_from_h5");
                String string12 = this.mExtraData.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL);
                if (!TextUtils.isEmpty(string8)) {
                    arkAppMessage.appId = string8;
                    arkAppMessage.mSourceName = string9;
                    arkAppMessage.mSourceActionData = string10;
                    arkAppMessage.mSource_A_ActionData = string11;
                    arkAppMessage.mSourceUrl = string12;
                }
                this.mExtraData.getInt("KEY_MSG_FORWARD_ID");
                if (i3 == 10014) {
                    com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
                    aVar.o(arkAppMessage.toAppXml());
                    ((IArkMsgService) QRoute.api(IArkMsgService.class)).sendMsg(str3, sessionInfo.f179557e, aVar, null);
                    return true;
                }
                com.tencent.mobileqq.forward.utils.f.f211079a.g(sessionInfo, arkAppMessage);
                return true;
            }
            if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
                ReportCenter.f().p(this.app.getCurrentAccountUin(), "", "0", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID, "2006", "1", false);
            }
            return false;
        }
        if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
            ReportCenter.f().p(this.app.getCurrentAccountUin(), "", "0", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID, "2006", "1", false);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        super.preloadData();
        if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
            n();
            this.mActivity.finish();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (isMultiTarget2Send()) {
            for (ResultRecord resultRecord : getMultiTargetWithoutDataLine()) {
                o(resultRecord.uin, resultRecord.getUinType(), resultRecord.groupUin, resultRecord.guildId);
            }
            return super.realForwardTo();
        }
        n();
        return super.realForwardTo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean sendMessage2TargetOnConfirm(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, str, str2, Integer.valueOf(i3))).booleanValue();
        }
        if (this.f210793d) {
            return p(str, str2, i3);
        }
        return super.sendMessage2TargetOnConfirm(str, str2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!this.mFromSharePanelPreviewAndSend && !useBottomSheetPreview()) {
            return super.useNewVersionDialog();
        }
        return true;
    }
}
