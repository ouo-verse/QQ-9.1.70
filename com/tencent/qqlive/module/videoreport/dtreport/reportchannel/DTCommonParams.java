package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.BuildConfig;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTPublicParamKey;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public class DTCommonParams {
    DTCommonParams() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Map<String, String> getCommParams(@NonNull IDTParamProvider iDTParamProvider) {
        HashMap hashMap = new HashMap();
        put(hashMap, DTPublicParamKey.DT_QQ, iDTParamProvider.getQQ());
        put(hashMap, DTPublicParamKey.DT_QQ_OPEN_ID, iDTParamProvider.getQQOpenID());
        put(hashMap, DTPublicParamKey.DT_WX_OPEN_ID, iDTParamProvider.getWxOpenID());
        put(hashMap, DTPublicParamKey.DT_WX_UNION_ID, iDTParamProvider.getWxUnionID());
        put(hashMap, DTPublicParamKey.DT_WB_OPEN_ID, iDTParamProvider.getWbOpenID());
        put(hashMap, DTPublicParamKey.DT_MAIN_LOGIN, iDTParamProvider.getMainLogin());
        put(hashMap, DTPublicParamKey.DT_ACCOUNT_ID, iDTParamProvider.getAccountID());
        DTAdditionalReportHandler dTAdditionalReportHandler = DTAdditionalReportHandler.getInstance();
        put(hashMap, DTPublicParamKey.DT_START_TYPE, String.valueOf(dTAdditionalReportHandler.getStartType()));
        put(hashMap, DTPublicParamKey.DT_CALL_FROM, dTAdditionalReportHandler.getCallFrom());
        put(hashMap, DTPublicParamKey.DT_CALL_SCHEME, dTAdditionalReportHandler.getCallScheme());
        put(hashMap, DTPublicParamKey.DT_OMG_BIZ_ID, iDTParamProvider.getOmgbzid());
        put(hashMap, DTPublicParamKey.DT_FACTORY_CHANNEL_ID, iDTParamProvider.getFactoryChannelId());
        put(hashMap, DTPublicParamKey.DT_MODIFY_CHANNEL_ID, iDTParamProvider.getModifyChannelId());
        put(hashMap, DTPublicParamKey.DT_SIM_TYPE, iDTParamProvider.getSIMType());
        put(hashMap, DTPublicParamKey.DT_AD_CODE, iDTParamProvider.getAdCode());
        put(hashMap, DTPublicParamKey.DT_TID, iDTParamProvider.getTid());
        put(hashMap, DTPublicParamKey.DT_OAID, iDTParamProvider.getOaid());
        put(hashMap, DTPublicParamKey.DT_GUID, iDTParamProvider.getGuid());
        put(hashMap, DTPublicParamKey.DT_SDK_VERSION, String.valueOf(BuildConfig.VERSION_CODE));
        return hashMap;
    }

    private static void put(@NonNull Map<String, String> map, @NonNull String str, @Nullable String str2) {
        map.put(str, (String) BaseUtils.nullAs(str2, ""));
    }
}
