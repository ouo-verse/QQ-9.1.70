package com.tencent.mobileqq.vas.quickupdate;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.BusinessItemInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TroopEnterEffectBusiness extends QQVasUpdateBusiness {
    public String getAnimFile(int i3) {
        return getSavePath(i3) + File.separator + i3;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 25L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "troop_enter_effect";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    public BusinessItemInfo getBusinessItemInfo(long j3, String str) {
        BusinessItemInfo businessItemInfo = super.getBusinessItemInfo(j3, str);
        businessItemInfo.ignoreUncompressMode = true;
        return businessItemInfo;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "business";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return "groupeffect_item_" + i3 + ".zip";
    }

    public String getUrl(int i3) {
        File file = new File(getSavePath(i3), ".iteminfo");
        if (file.exists()) {
            try {
                String optString = new JSONObject(FileUtils.readFileContent(file)).optJSONObject("customInfo").optString("ipIdUrl");
                if (!TextUtils.isEmpty(optString)) {
                    return optString;
                }
            } catch (JSONException e16) {
                QLog.e("VasUpdate_QQBusiness", 1, e16, new Object[0]);
            }
        }
        return ((IVasWebUrl) QRoute.api(IVasWebUrl.class)).getUrl(IndividuationUrlHelper.UrlId.TROOP_ENTER_EFFECT);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
