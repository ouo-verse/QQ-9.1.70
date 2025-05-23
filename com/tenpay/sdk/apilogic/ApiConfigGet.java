package com.tenpay.sdk.apilogic;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.basebl.TenpayBL;
import com.tenpay.sdk.basebl.UserInfo;
import com.tenpay.sdk.net.core.comm.CftSKeyCacheUtils;
import com.tenpay.sdk.util.ConfigUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiConfigGet extends ApiNetListener {
    private static final String TAG = "ApiConfigGet";

    public ApiConfigGet(Context context, UserInfo userInfo) {
        super(context, null, userInfo, false, false);
    }

    public void checkCacheVersion(String str) {
        int i3;
        boolean z16;
        QwLog.i("get config = " + str);
        if (!CftSKeyCacheUtils.hasCftSKey(this.userInfo.uin)) {
            QwLog.i("skey error...");
            return;
        }
        try {
            i3 = Integer.parseInt(ConfigUtil.parseValueByKey(str, "QPAY"));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            i3 = -1;
        }
        int unifiedConfigVersion = ConfigUtil.getUnifiedConfigVersion();
        if (-1 != i3 && -1 != unifiedConfigVersion && i3 <= unifiedConfigVersion) {
            z16 = ConfigUtil.loadUnifiedConfig();
        } else {
            z16 = false;
        }
        QwLog.i("load config = " + z16 + ", localVer=" + unifiedConfigVersion + " newVer = " + i3);
        if (!z16) {
            HashMap hashMap = new HashMap();
            hashMap.put("uin", this.userInfo.uin);
            TenpayBL tenpayBL = new TenpayBL();
            tenpayBL.setNetListener(this);
            tenpayBL.doTask(this.context, Cgi.URI_PAY_UNIFIED_CONFIG, hashMap, "", "0", this.userInfo.uin, true);
        }
    }

    @Override // com.tenpay.sdk.apilogic.ApiNetListener, com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        QwLog.i("get config error..." + jSONObject);
    }

    @Override // com.tenpay.sdk.apilogic.ApiNetListener, com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        QwLog.i("config = " + jSONObject);
        ConfigUtil.saveUnifiedConfig(jSONObject);
    }
}
