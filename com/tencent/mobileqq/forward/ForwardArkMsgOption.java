package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.ark.api.IArkSecure;
import com.tencent.mobileqq.ark.share.IShareArkViewApi;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameReportApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.util.GuildForwardUtilKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardArkMsgOption extends ForwardBaseOption implements al {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private boolean f210555d;

    /* renamed from: e, reason: collision with root package name */
    private String f210556e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements com.tencent.mobileqq.ark.secure.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardArkMsgOption.this);
            }
        }

        @Override // com.tencent.mobileqq.ark.secure.b
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else if (!z16) {
                QLog.e(ForwardBaseOption.TAG, 2, "checkUrlFromJsApi error");
            }
        }
    }

    public ForwardArkMsgOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        } else {
            this.f210555d = false;
            this.f210556e = "";
        }
    }

    public static boolean n(Bundle bundle, QQAppInterface qQAppInterface, String str, int i3, String str2, int i16) {
        int[] intArray;
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = str;
        sessionInfo.f179559f = str2;
        if (i3 >= 0 && !TextUtils.isEmpty(str)) {
            bundle.keySet();
            String string = bundle.getString("forward_ark_app_name");
            String string2 = bundle.getString("forward_ark_app_view");
            String string3 = bundle.getString("forward_ark_biz_src", "");
            String string4 = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_DESC);
            String string5 = bundle.getString("forward_ark_app_ver");
            String string6 = bundle.getString("forward_ark_app_prompt");
            String string7 = bundle.getString("forward_ark_app_meta");
            String string8 = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG);
            String string9 = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_COMPAT);
            String string10 = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_LIST);
            String string11 = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_TEXT);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                if (bundle.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
                    ReportCenter.f().p(qQAppInterface.getCurrentAccountUin(), "", "0", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID, "2006", "0", false);
                }
                ArkAppMessage arkAppMessage = new ArkAppMessage(string6, string, string3, string4, string2, string5, string7, string8, string9);
                if (!TextUtils.isEmpty(string11)) {
                    arkAppMessage.mText = string11;
                }
                if (!TextUtils.isEmpty(string10)) {
                    try {
                        JSONArray jSONArray = new JSONArray(string10);
                        int length = jSONArray.length();
                        arkAppMessage.mAppList = new ArrayList();
                        for (int i17 = 0; i17 < length; i17++) {
                            String optString = jSONArray.optString(i17);
                            if (!TextUtils.isEmpty(optString)) {
                                ArkAppMessage arkAppMessage2 = new ArkAppMessage();
                                arkAppMessage2.fromAppXml(optString);
                                arkAppMessage.mAppList.add(arkAppMessage2);
                            }
                        }
                    } catch (Exception unused) {
                        QLog.e(ForwardBaseOption.TAG, 1, "appList error");
                    }
                }
                ArkAppMessage arkAppMessage3 = (ArkAppMessage) com.tencent.mobileqq.ark.e.a(2, string, bundle, arkAppMessage);
                if (arkAppMessage3 != null) {
                    arkAppMessage = arkAppMessage3;
                }
                String string12 = bundle.getString(AppConstants.Key.FORWARD_APPID_ARK_FROM_SDK);
                String string13 = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME);
                String string14 = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA);
                String string15 = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA);
                String string16 = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL);
                if (!TextUtils.isEmpty(string12)) {
                    arkAppMessage.appId = string12;
                    arkAppMessage.mSourceName = string13;
                    arkAppMessage.mSourceActionData = string14;
                    arkAppMessage.mSource_A_ActionData = string15;
                    arkAppMessage.mSourceUrl = string16;
                }
                int i18 = bundle.getInt("KEY_MSG_FORWARD_ID");
                if (i18 == 0 && (intArray = bundle.getIntArray("KEY_MSG_FORWARD_ID_ARRAY")) != null) {
                    if (intArray.length > i16) {
                        i18 = intArray[i16];
                    } else {
                        com.tencent.mobileqq.ark.d.d("ArkApp", "ForwardArkMsgOption.sendArkMessage, forward array has not enough length");
                    }
                }
                if (!NtMsgForwardUtils.f(bundle)) {
                    int i19 = sessionInfo.f179555d;
                    if (i19 != 10014 && i19 != 10016) {
                        long h16 = com.tencent.mobileqq.forward.utils.f.f211079a.h(sessionInfo, arkAppMessage);
                        int i26 = sessionInfo.f179555d;
                        if (i26 == 0 || i26 == 1) {
                            HashMap hashMap = (HashMap) bundle.getSerializable(AppConstants.Key.FORWARD_ARK_MSG_ID_MAP);
                            if (hashMap != null) {
                                hashMap.put(sessionInfo.f179557e, Long.valueOf(h16));
                            } else {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(sessionInfo.f179557e, Long.valueOf(h16));
                                bundle.putSerializable(AppConstants.Key.FORWARD_ARK_MSG_ID_MAP, hashMap2);
                            }
                        }
                        QLog.d(ForwardBaseOption.TAG, 2, "sendArkMessage uin:" + sessionInfo.f179557e + ", curType:" + sessionInfo.f179555d + ", msg Id: " + h16);
                    } else {
                        ChatActivityFacade.x0(qQAppInterface, sessionInfo, arkAppMessage, i18);
                    }
                }
                if (sessionInfo.f179555d == 1 && (IGameReportApi.HONOR_RANK_ARK_APP_NAME.equals(string) || IGameReportApi.HONOR_RANK_ARK_APP_NAME2.equals(string))) {
                    ((IGameReportApi) QRoute.api(IGameReportApi.class)).reportSendHonorRankArkMsg(sessionInfo.f179557e);
                }
                return true;
            }
            if (bundle.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
                ReportCenter.f().p(qQAppInterface.getCurrentAccountUin(), "", "0", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID, "2006", "1", false);
            }
            return false;
        }
        if (bundle.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
            ReportCenter.f().p(qQAppInterface.getCurrentAccountUin(), "", "0", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID, "2006", "1", false);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, com.tencent.mobileqq.guild.feed.api.g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ boolean b() {
        return ak.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (SharePublishGuildFeedParam) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        SharePublishGuildFeedParam h16 = GuildForwardUtilKt.h(this.mExtraData);
        if (h16 == null) {
            SharePublishGuildFeedParam g16 = GuildForwardUtilKt.g(this.mExtraData);
            if (this.mExtraData.getInt("miniAppShareAppType") == 2 && (g16 instanceof SharePublishGuildFeedParam.LinkTypeParam)) {
                SharePublishGuildFeedParam.LinkTypeParam linkTypeParam = (SharePublishGuildFeedParam.LinkTypeParam) g16;
                return new SharePublishGuildFeedParam.LinkTypeParam(((IWxMiniHostSceneManager) QRoute.api(IWxMiniHostSceneManager.class)).formatShareGuildFeedsUrl(linkTypeParam.getUrl()), linkTypeParam.getImageUrl(), linkTypeParam.getTitle(), linkTypeParam.getDesc());
            }
            return g16;
        }
        return h16;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardDirectly(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if (this.mFromSharePanelPreviewAndSend) {
            super.forwardDirectly(str);
            return;
        }
        this.f210555d = true;
        this.f210556e = str;
        prepareForwardTargets();
        if (isMultiTarget2Send()) {
            sendToMultiTarget();
        } else {
            sendToSingleTarget("");
        }
        updateRecentForwardUser();
        QLog.d(ForwardBaseOption.TAG, 1, "[ForwardArkMsgOption] forwardDirectly.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.forwardOnConfirm();
            jq3.a.e(this.mExtraData, this.appid);
        }
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
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

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void initContext(QQAppInterface qQAppInterface, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) activity);
        } else {
            super.initContext(qQAppInterface, activity);
            ((IArkHelper) QRoute.api(IArkHelper.class)).preDownloadApp(this.mExtraData.getString("forward_ark_app_name"), this.mExtraData.getString("forward_ark_app_view"), this.mExtraData.getString("forward_ark_biz_src", ""));
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        String string = this.mExtraData.getString("forward_ark_app_name");
        String string2 = this.mExtraData.getString(AppConstants.Key.FORWARD_ARK_H5_FROM_JS);
        String string3 = this.mExtraData.getString("forward_ark_app_view");
        String string4 = this.mExtraData.getString("forward_ark_biz_src", "");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            ((IArkSecure) QRoute.api(IArkSecure.class)).checkShareUrl(string, string3, string4, string2, new a());
        }
    }

    protected boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        int i3 = this.mExtraData.getInt("uintype");
        return n(this.mExtraData, this.app, this.mExtraData.getString("uin"), i3, this.mExtraData.getString("troop_uin"), 0);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        super.preloadData();
        l();
        if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
            m();
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
            List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
            for (int i3 = 0; i3 < multiTargetWithoutDataLine.size(); i3++) {
                ResultRecord resultRecord = multiTargetWithoutDataLine.get(i3);
                n(this.mExtraData, this.app, resultRecord.uin, resultRecord.getUinType(), resultRecord.groupUin, i3);
            }
            return super.realForwardTo();
        }
        m();
        return super.realForwardTo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean sendMessage2TargetOnConfirm(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, str, str2, Integer.valueOf(i3))).booleanValue();
        }
        if (TextUtils.isEmpty(this.f210556e)) {
            return super.sendMessage2TargetOnConfirm(str, str2, i3);
        }
        return sendMessage2TargetOnConfirm(str, str2, i3, this.f210556e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (!this.mFromSharePanelPreviewAndSend && !useBottomSheetPreview()) {
            return super.useNewVersionDialog();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, z16)).booleanValue();
        }
        if (this.f210555d) {
            return super.realForwardTo(true);
        }
        return super.realForwardTo(z16);
    }
}
