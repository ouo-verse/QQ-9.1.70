package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.ark.share.IShareArkViewApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.api.IWinkShareAPI;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardAECameraArkOption extends ForwardBaseOption implements al {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements i83.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f210547a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f210548b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f210549c;

        a(int i3, String str, String str2) {
            this.f210547a = i3;
            this.f210548b = str;
            this.f210549c = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardAECameraArkOption.this, Integer.valueOf(i3), str, str2);
            }
        }

        @Override // i83.g
        public void onFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // i83.g
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardAECameraArkOption.this.n(this.f210547a, this.f210548b, this.f210549c);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public ForwardAECameraArkOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    private String m() {
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog == null) {
            return "";
        }
        String inputValue = qQCustomDialog.getInputValue();
        if (TextUtils.isEmpty(inputValue)) {
            return "";
        }
        return inputValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i3, String str, String str2) {
        String m3 = m();
        if (TextUtils.isEmpty(m3) && !TextUtils.isEmpty(this.mSharePanelLeaveMsg)) {
            m3 = this.mSharePanelLeaveMsg;
        }
        if (!TextUtils.isEmpty(m3) && this.mExtraData != null) {
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179555d = i3;
            sessionInfo.f179557e = str;
            sessionInfo.f179559f = str2;
            com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, m3);
        }
    }

    private void o() {
        List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
        if (multiTargetWithoutDataLine != null && !multiTargetWithoutDataLine.isEmpty()) {
            for (ResultRecord resultRecord : multiTargetWithoutDataLine) {
                q(resultRecord.uinType, resultRecord.uin, resultRecord.groupUin);
            }
        }
    }

    private void p() {
        QLog.i("ForwardAECameraArkOption", 2, "sendSingleArkMessage");
        q(this.mExtraData.getInt("uintype"), this.mExtraData.getString("uin"), this.mExtraData.getString("troop_uin"));
    }

    private void q(int i3, String str, String str2) {
        String str3;
        if (i3 != 0) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str2;
                    JSONObject jSONObject = new JSONObject(this.mExtraData.getString("forward_ark_app_meta"));
                    this.mActivity.setResult(-1);
                    ((IWinkShareAPI) QRoute.api(IWinkShareAPI.class)).requestArk(i3 + 1, Long.parseLong(str3), jSONObject.toString(), new a(i3, str, str2));
                }
            } catch (Exception e16) {
                QLog.e("ForwardAECameraArkOption", 2, "ArkMessage Error", e16);
                return;
            }
        }
        str3 = str;
        JSONObject jSONObject2 = new JSONObject(this.mExtraData.getString("forward_ark_app_meta"));
        this.mActivity.setResult(-1);
        ((IWinkShareAPI) QRoute.api(IWinkShareAPI.class)).requestArk(i3 + 1, Long.parseLong(str3), jSONObject2.toString(), new a(i3, str, str2));
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, com.tencent.mobileqq.guild.feed.api.g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected boolean allowQZoneAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ boolean b() {
        return ak.b(this);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void buildForwardAbility() {
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

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (!this.mFromSharePanelPreviewAndSend && !useBottomSheetPreview()) {
            return super.buildNewVersionContentView();
        }
        return ((IShareArkViewApi) QRoute.api(IShareArkViewApi.class)).createShareArkView(this.mActivity, this.mExtraData);
    }

    @Override // com.tencent.mobileqq.forward.al
    @Nullable
    public SharePublishGuildFeedParam c() {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SharePublishGuildFeedParam) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        try {
            jSONObject = new JSONObject(this.mExtraData.getString("forward_ark_app_meta", ""));
        } catch (Exception e16) {
            QLog.e("ForwardAECameraArkOption", 1, "forwardToGuildFeed error", e16);
            jSONObject = null;
        }
        if (jSONObject == null) {
            QLog.w("ForwardAECameraArkOption", 1, "forwardToGuildFeed metaDetail data is null");
            return null;
        }
        String optString = jSONObject.optString("jumpUrlForGuild");
        if (optString.isEmpty()) {
            optString = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
        }
        w53.b.a("ForwardAECameraArkOption", "generateForwardToGuildParam jumpUrlForGuild:" + optString);
        return new SharePublishGuildFeedParam.LinkTypeParam(optString, jSONObject.optString("preview"), jSONObject.optString("title"), jSONObject.optString("desc"));
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
    public void initContext(QQAppInterface qQAppInterface, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) activity);
            return;
        }
        super.initContext(qQAppInterface, activity);
        QLog.i("ForwardAECameraArkOption", 2, "ForwardAECameraArkOptions, initContext");
        ((IArkHelper) QRoute.api(IArkHelper.class)).preDownloadApp(this.mExtraData.getString("forward_ark_app_name"), this.mExtraData.getString("forward_ark_app_view"), this.mExtraData.getString("forward_ark_biz_src", ""));
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.mFromSharePanelPreviewAndSend) {
            o();
            return true;
        }
        p();
        this.mActivity.finish();
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (!this.mFromSharePanelPreviewAndSend && !useBottomSheetPreview()) {
            return super.useNewVersionDialog();
        }
        return true;
    }
}
