package com.tencent.mobileqq.icgame.sso;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.data.config.ConfigData;
import com.tencent.mobileqq.icgame.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.icgame.data.login.LoginInfo;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.util.QQDeviceInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j implements com.tencent.mobileqq.qqlive.sso.b {

    /* renamed from: a, reason: collision with root package name */
    private IQQLiveModuleLogin f237785a;

    /* renamed from: b, reason: collision with root package name */
    private QQLiveSDKConfig f237786b;

    /* renamed from: c, reason: collision with root package name */
    private ConfigData f237787c;

    public j(IQQLiveModuleLogin iQQLiveModuleLogin, QQLiveSDKConfig qQLiveSDKConfig, ConfigData configData) {
        this.f237785a = iQQLiveModuleLogin;
        this.f237786b = qQLiveSDKConfig;
        this.f237787c = configData;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public String a() {
        LoginInfo loginInfo = this.f237785a.getLoginInfo();
        if (loginInfo == null) {
            return "";
        }
        return loginInfo.accessToken;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public int b() {
        int pullMsgClientType = this.f237787c.getPullMsgClientType();
        if (pullMsgClientType == -1) {
            return getPlatform();
        }
        return pullMsgClientType;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public String c() {
        LoginInfo loginInfo = this.f237785a.getLoginInfo();
        if (loginInfo == null) {
            return "";
        }
        return loginInfo.f237263a2;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public Boolean d() {
        return Boolean.FALSE;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public String getClientId() {
        String qimei = QQDeviceInfo.getQIMEI();
        if (TextUtils.isEmpty(qimei)) {
            return com.tencent.mobileqq.qqlive.utils.e.a();
        }
        return qimei;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public int getLoginType() {
        LoginInfo loginInfo = this.f237785a.getLoginInfo();
        if (loginInfo == null) {
            return 1;
        }
        return loginInfo.loginType;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public String getOpenId() {
        LoginInfo loginInfo = this.f237785a.getLoginInfo();
        if (loginInfo == null) {
            return "";
        }
        return loginInfo.openId;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public int getPlatform() {
        return this.f237787c.getLiveClientType();
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public int getStreamType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public long getTinyId() {
        LoginInfo loginInfo = this.f237785a.getLoginInfo();
        if (loginInfo == null) {
            return 0L;
        }
        return loginInfo.tinyid;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public long getUid() {
        LoginInfo loginInfo = this.f237785a.getLoginInfo();
        if (loginInfo == null) {
            return 0L;
        }
        return loginInfo.uid;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public String getVersion() {
        String str = AppSetting.f99551k;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public int getVersionCode() {
        return TVKEventId.PLAYER_STATE_SWITCHDEF_START;
    }
}
