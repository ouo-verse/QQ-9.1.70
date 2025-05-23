package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsLayoutContentCollections;
import com.tencent.qqnt.kernel.nativeinterface.UfsSearchMiniAppItem;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ah extends lo2.m {

    /* renamed from: b0, reason: collision with root package name */
    public up2.a f283512b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f283513c0;

    @Override // com.tencent.mobileqq.search.model.z
    public void F(int i3) {
        up2.a aVar = this.f283512b0;
        if (aVar != null) {
            aVar.F(i3);
        }
        super.F(i3);
    }

    @Override // lo2.m
    public void S(String str, UfsLayoutContentCollections ufsLayoutContentCollections) {
        String str2;
        String str3;
        String str4;
        JSONObject optJSONObject;
        UfsSearchMiniAppItem ufsSearchMiniAppItem;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appname");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("appIcon");
            String optString4 = jSONObject.optString("appid");
            int optInt = jSONObject.optInt("showMask", 0);
            int optInt2 = jSONObject.optInt("miniAppType", 0);
            int optInt3 = jSONObject.optInt("appType");
            String optString5 = jSONObject.optString(QZoneDTLoginReporter.SCHEMA);
            if (ufsLayoutContentCollections == null || (ufsSearchMiniAppItem = ufsLayoutContentCollections.searchMiniAppLayoutContent) == null) {
                str2 = "";
            } else {
                str2 = ufsSearchMiniAppItem.miniIconUrl;
            }
            if (jSONObject.has("friendExtra") && (optJSONObject = jSONObject.optJSONObject("friendExtra")) != null && optJSONObject.has("displayText")) {
                str3 = optJSONObject.optString("displayText");
            } else {
                str3 = null;
            }
            if (!TextUtils.isEmpty(str3)) {
                str4 = str3 + APLogFileUtil.SEPARATOR_LOG + optString2;
            } else {
                str4 = optString2;
            }
            MiniAppLocalSearchEntity miniAppLocalSearchEntity = new MiniAppLocalSearchEntity(optString4, optString, optString3, str4, optInt, optInt2, optString5, str2);
            miniAppLocalSearchEntity.reportType = optInt3;
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            this.f283512b0 = new up2.a(qQAppInterface, this.R, miniAppLocalSearchEntity, this.N, optString5);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(this.N) && optString.equalsIgnoreCase(this.N)) {
                this.f283513c0 = true;
            } else {
                this.f283513c0 = false;
            }
            if (qQAppInterface != null) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).updateDataDbFromNetResultInLocalSearchManager(miniAppLocalSearchEntity);
            }
            QLog.i("NetSearchTemplateMiniAppItem", 1, "parseLayoutExtensions, content=" + miniAppLocalSearchEntity);
        } catch (JSONException unused) {
            QLog.e("NetSearchTemplateMiniAppItem", 1, "parseLayoutExtensions, exception.");
        }
    }

    @Override // lo2.m
    public void U() {
        String str;
        MiniAppLocalSearchEntity miniAppLocalSearchEntity;
        super.U();
        if (this.f283513c0) {
            str = "0X8009D32";
        } else {
            str = "0X8009D44";
        }
        com.tencent.mobileqq.search.report.b.e(null, 0, this.R, str, 0, 0, null, null);
        up2.a aVar = this.f283512b0;
        if (aVar != null && (miniAppLocalSearchEntity = aVar.X) != null) {
            String str2 = miniAppLocalSearchEntity.appId;
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniSearch(this.f283512b0.X, 1, false, miniAppLocalSearchEntity.reportType);
        }
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        up2.a aVar = this.f283512b0;
        if (aVar != null) {
            return aVar.getTitle();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.z
    public String z() {
        return this.f283512b0.z();
    }
}
