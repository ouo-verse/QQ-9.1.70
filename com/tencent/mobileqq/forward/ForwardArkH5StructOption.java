package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ark.Constants;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkSecure;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardArkH5StructOption extends ForwardPluginShareStructMsgOption {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements com.tencent.mobileqq.ark.secure.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardArkH5StructOption.this);
            }
        }

        @Override // com.tencent.mobileqq.ark.secure.b
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 1, "ShareArkFromH5 checkUrlFromNormal CheckShareUrl = ", Boolean.valueOf(z16));
            if (z16) {
                ForwardArkH5StructOption.this.mExtraData.putBoolean(AppConstants.Key.FORWARD_ARK_FROM_H5_SUCCESS, true);
            }
        }
    }

    public ForwardArkH5StructOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    protected boolean A(String str, String str2, int i3) {
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3))).booleanValue();
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = str;
        sessionInfo.f179559f = str2;
        if (i3 >= 0 && !TextUtils.isEmpty(str)) {
            String string = this.mExtraData.getString("forward_ark_app_name");
            String string2 = this.mExtraData.getString("forward_ark_app_view");
            String string3 = this.mExtraData.getString("forward_ark_biz_src", "");
            String string4 = this.mExtraData.getString(AppConstants.Key.FORWARD_ARK_APP_DESC, "");
            String string5 = this.mExtraData.getString("forward_ark_app_meta");
            String string6 = this.mExtraData.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG);
            String string7 = this.mExtraData.getString("forward_ark_app_prompt");
            String str5 = Constants.DEFAULT_MIN_APP_VERSION;
            Map<String, String> applicationFromManifest = ArkAppCacheMgr.getApplicationFromManifest(string, string3, Constants.DEFAULT_MIN_APP_VERSION);
            if (applicationFromManifest != null && applicationFromManifest.containsKey("version")) {
                str5 = applicationFromManifest.get("version");
            }
            String str6 = str5;
            if (TextUtils.isEmpty(string7)) {
                string7 = String.format(HardCodeUtil.qqStr(R.string.mo7), "");
            }
            String str7 = string7;
            if (TextUtils.isEmpty(string4)) {
                str3 = "";
            } else {
                str3 = string4;
            }
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                if (this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT)) {
                    ReportCenter.f().p(this.app.getCurrentAccountUin(), "", "0", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID, "2006", "0", false);
                }
                ArkAppMessage arkAppMessage = new ArkAppMessage(str7, string, string3, str3, string2, str6, string5, string6, "");
                ArkAppMessage arkAppMessage2 = (ArkAppMessage) com.tencent.mobileqq.ark.e.a(2, string, this.mExtraData, arkAppMessage);
                if (arkAppMessage2 != null) {
                    arkAppMessage = arkAppMessage2;
                }
                AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(this.mExtraData);
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
                if (e16 != null) {
                    int i16 = sessionInfo.f179555d;
                    if (i16 != 1000 && i16 != 1004 && i16 != 1020) {
                        str4 = this.app.getCurrentAccountUin();
                    } else {
                        str4 = sessionInfo.f179559f;
                    }
                    String str8 = str4;
                    QQAppInterface qQAppInterface = this.app;
                    String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                    String str9 = sessionInfo.f179557e;
                    int i17 = sessionInfo.f179555d;
                    int i18 = MobileQQServiceBase.seq;
                    MobileQQServiceBase.seq = i18 + 1;
                    arkAppMessage.containStructMsg = com.tencent.mobileqq.service.message.q.A(qQAppInterface, currentAccountUin, str9, str8, i17, i18, e16);
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

    protected void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        try {
            String str = "";
            if (getEditTextType() != 0) {
                str = this.mConfirmDialog.getInputValue();
            }
            Intent aliasIntent = SplashActivity.getAliasIntent(this.mActivity);
            aliasIntent.putExtras(this.mExtraData);
            ChatActivityFacade.K0(this.app, this.mActivity, ForwardUtils.n0(aliasIntent), str);
        } catch (Exception e16) {
            QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean addStructView(QQCustomDialog qQCustomDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) qQCustomDialog)).booleanValue();
        }
        if (!this.mExtraData.getBoolean("is_ark_display_share") || !this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_FROM_H5_PARSE_META_SUCCESS)) {
            super.addStructView(qQCustomDialog);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardOnConfirm() {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.mExtraData.getInt("uintype") == 10014) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (getEditTextType() != 0) {
                str = this.mConfirmDialog.getInputValue();
            } else {
                str = "";
            }
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), new int[]{2});
            this.mExtraData.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, str);
            m3.putExtras(this.mExtraData);
            SessionInfo n06 = ForwardUtils.n0(m3);
            this.mIntent.putExtra("is_need_show_toast", false);
            this.mNeedInterrupFinishActivity = true;
            ForwardPluginShareWebViewHelper.d(this.app, this.mActivity, n06, m3, null);
            return;
        }
        boolean z17 = this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_FROM_H5_SUCCESS);
        boolean z18 = this.mExtraData.getBoolean(AppConstants.Key.FORWARD_ARK_FROM_H5_PARSE_META_SUCCESS);
        QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 1, "ShareArkFromH5 before sendArkMag isUrlLegal=", Boolean.valueOf(z17), ", isMetaLegal=", Boolean.valueOf(z18));
        if (isMultiTarget2Send()) {
            if (z17 && z18) {
                reportSendAction();
                for (ResultRecord resultRecord : getMultiTargetWithoutDataLine()) {
                    A(resultRecord.uin, resultRecord.groupUin, resultRecord.getUinType());
                }
                return;
            }
            super.forwardOnConfirm();
            return;
        }
        if (z17 && z18) {
            reportSendAction();
            if (z() && needSendMessage()) {
                B();
            }
            this.mActivity.finish();
            return;
        }
        super.forwardOnConfirm();
    }

    @Override // com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        y();
        checkMetaLegality();
        return super.preloadData();
    }

    protected void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        String string = this.mExtraData.getString("forward_ark_app_name");
        String string2 = this.mExtraData.getString(AppConstants.Key.FORWARD_ARK_H5_FROM_NORMAL);
        String string3 = this.mExtraData.getString("forward_ark_app_view");
        String string4 = this.mExtraData.getString("forward_ark_biz_src", "");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            ((IArkSecure) QRoute.api(IArkSecure.class)).checkShareUrl(string, string3, string4, string2, new a());
        }
    }

    protected boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return A(this.mExtraData.getString("uin"), this.mExtraData.getString("troop_uin"), this.mExtraData.getInt("uintype"));
    }
}
