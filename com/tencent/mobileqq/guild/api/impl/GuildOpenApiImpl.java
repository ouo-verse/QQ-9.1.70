package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.config.QQGuildMCBean;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.guild.nt.troop.api.ITroopApi;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.util.URLUtil;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildOpenApiImpl implements IGuildOpenApi {
    private static final String TAG = "Guild.jump.QQGuildOpenApiImpl";
    private AppRuntime app;
    private HashMap<String, e> mPackageSchemeMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f214388d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f214389e;

        a(String str, e eVar) {
            this.f214388d = str;
            this.f214389e = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", 0);
                jSONObject.put("action", this.f214388d);
                GuildOpenApiImpl.this.handleGuildOpenResult(this.f214389e.f214395a, jSONObject.toString());
            } catch (Exception e16) {
                QLog.e(GuildOpenApiImpl.TAG, 1, e16, new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQGuildOpenData f214392d;

        c(QQGuildOpenData qQGuildOpenData) {
            this.f214392d = qQGuildOpenData;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", 0);
                jSONObject.put("action", this.f214392d.from);
                GuildOpenApiImpl.this.handleGuildOpenResult(this.f214392d.packageId, jSONObject.toString());
            } catch (Exception e16) {
                QLog.e(GuildOpenApiImpl.TAG, 1, e16, new Object[0]);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        String f214395a;

        /* renamed from: b, reason: collision with root package name */
        String f214396b;

        /* renamed from: c, reason: collision with root package name */
        QQGuildOpenData f214397c;

        public e(String str, String str2, QQGuildOpenData qQGuildOpenData) {
            this.f214395a = str;
            this.f214396b = str2;
            this.f214397c = qQGuildOpenData;
        }
    }

    private boolean checkOldVersionByScheme(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("version");
        if (TextUtils.isEmpty(queryParameter)) {
            return true;
        }
        if (!az.b(queryParameter)) {
            QLog.e(TAG, 1, "[checkOldVersionByScheme] invalid version: " + queryParameter);
            return true;
        }
        try {
            if (Integer.parseInt(queryParameter) < 1) {
                return true;
            }
            return false;
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "[checkOldVersionByScheme] exception: ", e16);
            return true;
        }
    }

    private e getDefaultPackageData() {
        if (this.mPackageSchemeMap.size() == 0) {
            QLog.e(TAG, 1, "handleGuildOpenResultSuccess package is null");
            return null;
        }
        Iterator<e> it = this.mPackageSchemeMap.values().iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    private String getGuildOpenCreateUrl(boolean z16, String str) {
        String guildOpenCreateIntroUrl;
        if (!checkOldVersionByScheme(str)) {
            return "https://qun.qq.com/qunng/next/h5/game-connect";
        }
        QQGuildMCBean.b globalGuildConfig = bs.f235483a.h("100554").getGuildConfigBean().getGlobalGuildConfig();
        if (globalGuildConfig == null) {
            return "";
        }
        if (z16) {
            guildOpenCreateIntroUrl = globalGuildConfig.getGuildCreateUrl();
        } else {
            guildOpenCreateIntroUrl = globalGuildConfig.getGuildOpenCreateIntroUrl();
        }
        if (TextUtils.isEmpty(guildOpenCreateIntroUrl)) {
            return "";
        }
        return guildOpenCreateIntroUrl;
    }

    private void goBackToThirdApp(long j3, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openid", str3);
            jSONObject.put("user_openid", str3);
            jSONObject.put("gamedata", Base64.encodeToString(str2.getBytes(), 0));
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        String format = String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response=%3$s", Long.valueOf(j3), "guildOpen", jSONObject.toString());
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(format));
        QLog.i(TAG, 2, "handleGuildOpenResult uriString:" + format);
        intent.setPackage(str);
        intent.addFlags(268435456);
        intent.putExtra("big_brother_source_key", "biz_src_jc_qqstation_wzry");
        BaseApplication.getContext().startActivity(intent);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildOpenApi
    public QQGuildOpenData getGuildOpenDataFromApp(String str) {
        e eVar = this.mPackageSchemeMap.get(str);
        if (eVar == null) {
            return null;
        }
        return eVar.f214397c;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildOpenApi
    public void gotoGuildOpenCreateAction(Activity activity, String str, String str2, QQGuildOpenData qQGuildOpenData) {
        this.mPackageSchemeMap.clear();
        this.mPackageSchemeMap.put(str, new e(str, str2, qQGuildOpenData));
        String guildOpenCreateUrl = getGuildOpenCreateUrl(qQGuildOpenData.isFromSDK, qQGuildOpenData.rawUrl);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "gotoGuildOpenCreateAction url:", guildOpenCreateUrl);
        }
        if (!TextUtils.isEmpty(guildOpenCreateUrl)) {
            guildOpenCreateUrl = URLUtil.addParameter(URLUtil.addParameter(guildOpenCreateUrl, "raw_url", qQGuildOpenData.rawUrl), "package_id", str);
        }
        cx.a(activity, guildOpenCreateUrl);
        activity.finish();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildOpenApi
    public void handleBackToAppDialog(Activity activity, String str, Bundle bundle) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (bundle != null && activity != null) {
            String string = bundle.getString(AppConstants.Key.GUILD_FROM);
            String string2 = bundle.getString(AppConstants.Key.GUILD_FROM_APP_NAME);
            if (!TextUtils.isEmpty(string)) {
                if ("guildOpenCreate".equals(string) || "guildOpenJoin".equals(string)) {
                    IGProGuildInfo guildInfo = ((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).getGuildInfo(str);
                    e defaultPackageData = getDefaultPackageData();
                    if (guildInfo != null && defaultPackageData != null && defaultPackageData.f214397c != null) {
                        boolean equals = string.equals("guildOpenCreate");
                        QLog.i(TAG, 2, "handleBackToAppDialog show dialog success");
                        Object[] objArr = new Object[2];
                        if (equals) {
                            str2 = "\u9891\u9053\u521b\u5efa\u6210\u529f\uff01";
                        } else {
                            str2 = "\u52a0\u5165\u6210\u529f\uff01";
                        }
                        objArr[0] = str2;
                        objArr[1] = string2;
                        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 232, (String) null, String.format("%s\u662f\u5426\u8fd4\u56de%s", objArr), "\u7559\u5728\u9891\u9053", "\u8fd4\u56de" + string2 + "", new a(string, defaultPackageData), new b());
                        createCustomDialog.show();
                        View findViewById = createCustomDialog.findViewById(R.id.bja);
                        if (equals) {
                            str3 = "pg_sgrp_create_success";
                        } else {
                            str3 = "pg_sgrp_join_success";
                        }
                        VideoReport.setPageId(findViewById, str3);
                        HashMap hashMap = new HashMap();
                        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
                        hashMap.put("sgrp_channel_id", guildInfo.getGuildID());
                        hashMap.put("sgrp_game_teamid", defaultPackageData.f214397c.orgId);
                        hashMap.put("sgrp_game_sceneid", defaultPackageData.f214397c.from);
                        hashMap.put("sgrp_game_appid", Long.valueOf(defaultPackageData.f214397c.appId));
                        VideoReport.setPageParams(findViewById, new PageParams(hashMap));
                        TextView btnLeft = createCustomDialog.getBtnLeft();
                        if (equals) {
                            str4 = "em_sgrp_create_success_stay";
                        } else {
                            str4 = "em_sgrp_join_success_stay";
                        }
                        VideoReport.setElementId(btnLeft, str4);
                        TextView btnLeft2 = createCustomDialog.getBtnLeft();
                        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
                        VideoReport.setElementExposePolicy(btnLeft2, exposurePolicy);
                        TextView btnLeft3 = createCustomDialog.getBtnLeft();
                        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
                        VideoReport.setElementClickPolicy(btnLeft3, clickPolicy);
                        TextView btnight = createCustomDialog.getBtnight();
                        if (equals) {
                            str5 = "em_sgrp_create_success_back";
                        } else {
                            str5 = "em_sgrp_join_success_back";
                        }
                        VideoReport.setElementId(btnight, str5);
                        VideoReport.setElementExposePolicy(createCustomDialog.getBtnight(), exposurePolicy);
                        VideoReport.setElementClickPolicy(createCustomDialog.getBtnight(), clickPolicy);
                        return;
                    }
                    QLog.e(TAG, 2, "handleBackToAppDialog null guildInfo or packageData");
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildOpenApi
    public void handleEnterToTroop(String str, String str2) {
        QLog.i(TAG, 2, "handleEnterToTroop, troopUin: " + str2 + ",packageId:" + str);
        if (TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 1, "handleEnterToTroop error troop uin");
            return;
        }
        QQGuildOpenData guildOpenDataFromApp = getGuildOpenDataFromApp(str);
        if (guildOpenDataFromApp == null) {
            QLog.e(TAG, 1, "handleEnterToTroop error none guildOpenData");
        } else {
            ((ITroopApi) QRoute.api(ITroopApi.class)).enterTroop(str2, guildOpenDataFromApp);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildOpenApi
    public void handleGuildOpenResult(String str, String str2) {
        if (!TextUtils.isEmpty(str) && this.mPackageSchemeMap.get(str) != null) {
            e eVar = this.mPackageSchemeMap.get(str);
            if (eVar == null) {
                return;
            }
            QQGuildOpenData qQGuildOpenData = eVar.f214397c;
            goBackToThirdApp(qQGuildOpenData.appId, str, str2, qQGuildOpenData.openId);
            return;
        }
        QLog.e(TAG, 2, "handleGuildOpenResult error scheme and package is null");
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildOpenApi
    public void handleTroopBackToAppDialog(Activity activity, Bundle bundle) {
        QQGuildOpenData guildOpenDataFromApp;
        if (!((ITroopApi) QRoute.api(ITroopApi.class)).isFromThirdApp(bundle) || (guildOpenDataFromApp = getGuildOpenDataFromApp(((ITroopApi) QRoute.api(ITroopApi.class)).extractPackageId(bundle))) == null) {
            return;
        }
        DialogUtil.createCustomDialog(activity, 232, (String) null, String.format("%s\u662f\u5426\u8fd4\u56de%s", "\u6218\u961f\u7fa4\u521b\u5efa\u6210\u529f\uff01", guildOpenDataFromApp.appName), "\u7559\u5728\u6218\u961f\u7fa4", "\u8fd4\u56de" + guildOpenDataFromApp.appName + "", new c(guildOpenDataFromApp), new d()).show();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mPackageSchemeMap.clear();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildOpenApi
    public void setPackageSchemeData(String str, String str2, QQGuildOpenData qQGuildOpenData) {
        this.mPackageSchemeMap.clear();
        qQGuildOpenData.packageId = str;
        this.mPackageSchemeMap.put(str, new e(str, str2, qQGuildOpenData));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildOpenApi
    public void handleGuildOpenResult(String str, String str2, long j3, String str3) {
        goBackToThirdApp(j3, str, str2, str3);
    }

    private void showBackThirdAppDialog() {
    }
}
