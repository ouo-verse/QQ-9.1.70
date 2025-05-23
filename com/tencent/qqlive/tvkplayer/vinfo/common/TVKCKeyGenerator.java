package com.tencent.qqlive.tvkplayer.vinfo.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.checktime.TVKServerTimeGetter;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKCKeyGenerator {
    public static final String ENCRYPT_VER_4 = "4.1";
    public static final String ENCRYPT_VER_4_2 = "4.2";
    public static final String ENCRYPT_VER_5 = "5.1";
    private static final String TAG = "TVKCKeyGenerator";

    private static int[] constructCkeyExternParams(int i3, int i16, Map<String, String> map) {
        int[] iArr = {0, 0, 0};
        if (i3 == 3) {
            iArr[0] = 1;
        } else if (i3 != 0 && i3 != 4) {
            iArr[0] = 4;
        } else {
            iArr[0] = 0;
        }
        if (map != null) {
            if (map.containsKey(TVKCommonParamEnum.REQ_PARAM_KEY_TOUSHE) && map.containsKey(TVKCommonParamEnum.REQ_PARAM_KEY_FROM_PLATFORM)) {
                iArr[0] = 16;
                iArr[1] = TVKUtils.optInt(map.get(TVKCommonParamEnum.REQ_PARAM_KEY_FROM_PLATFORM), i16);
            } else if (map.containsKey(TVKCommonParamEnum.REQ_PARAM_KEY_SPTEST)) {
                iArr[0] = 64;
            }
        }
        iArr[2] = TVKCommParams.getOttFlag();
        return iArr;
    }

    @Nullable
    public static TVKCKeyDecryptedResult decryptCKeyServerResponse(@NonNull String str) {
        CKeyFacade.instance();
        CKeyFacade.DecInfo decCkeySecData = CKeyFacade.decCkeySecData(str);
        if (decCkeySecData == null) {
            TVKLogUtil.e(TAG, "fail to decCkeySecData, decCkeySecData return null");
            return null;
        }
        if (decCkeySecData.code != 0) {
            TVKLogUtil.e(TAG, "fail to decCkeySecData, decCkeySecData code:" + decCkeySecData.code);
            return null;
        }
        TVKCKeyDecryptedResult tVKCKeyDecryptedResult = new TVKCKeyDecryptedResult();
        tVKCKeyDecryptedResult.setData(decCkeySecData.data);
        tVKCKeyDecryptedResult.setRetCode(decCkeySecData.code);
        return tVKCKeyDecryptedResult;
    }

    public static String genCkey(@NonNull TVKCkeyParam tVKCkeyParam, ITVKLogger iTVKLogger) {
        return genCkey(tVKCkeyParam, TVKServerTimeGetter.getInstance().calculateCurrentServerTimeSec(), iTVKLogger);
    }

    @NonNull
    public static TVKCKeyEncryptedResult getCKeyWithData(@NonNull TVKCkeyParam tVKCkeyParam, long j3, @NonNull byte[] bArr) {
        String jSONObject;
        String assetIdForCKey = tVKCkeyParam.getAssetIdForCKey();
        if (tVKCkeyParam.getExtraJson() == null) {
            jSONObject = "";
        } else {
            jSONObject = tVKCkeyParam.getExtraJson().toString();
        }
        CKeyFacade.CKeyInfo cKeyWithData = CKeyFacade.getCKeyWithData(TVKCommParams.getStaGuid(), j3, assetIdForCKey, tVKCkeyParam.getAppVer(), String.valueOf(TVKUtils.optInt(tVKCkeyParam.getPlatform(), 0)), tVKCkeyParam.getSdtfrom(), null, 0, jSONObject, bArr);
        TVKCKeyEncryptedResult tVKCKeyEncryptedResult = new TVKCKeyEncryptedResult();
        if (cKeyWithData != null && cKeyWithData.ckey != null) {
            TVKLogUtil.v(TAG, "GenCkey version = " + tVKCkeyParam.getAppVer() + " curTime = " + j3 + " assetIdForCKey = " + tVKCkeyParam.getAssetIdForCKey() + " platform = " + TVKUtils.optInt(tVKCkeyParam.getPlatform(), 0) + " ckey = " + new String(cKeyWithData.ckey, StandardCharsets.UTF_8));
            tVKCKeyEncryptedResult.setCKey(cKeyWithData.ckey);
            tVKCKeyEncryptedResult.setCipher(cKeyWithData.cipher);
            return tVKCKeyEncryptedResult;
        }
        TVKLogUtil.e(TAG, "getCKeyWithData error, cKeyInfo:" + cKeyWithData);
        return tVKCKeyEncryptedResult;
    }

    public static String getEncryptVer() {
        int i3 = TVKMediaPlayerConfig.PlayerConfig.encrypt_ver;
        if (65 == i3) {
            return ENCRYPT_VER_4;
        }
        if (66 == i3) {
            return ENCRYPT_VER_4_2;
        }
        return ENCRYPT_VER_5;
    }

    public static String genCkey(@NonNull TVKCkeyParam tVKCkeyParam, long j3, ITVKLogger iTVKLogger) {
        String assetIdForCKey = tVKCkeyParam.getAssetIdForCKey();
        int optInt = TVKUtils.optInt(tVKCkeyParam.getPlatform(), 0);
        int[] constructCkeyExternParams = constructCkeyExternParams(tVKCkeyParam.getRequestType(), optInt, tVKCkeyParam.getExtraParamsMap());
        String cKey = CKeyFacade.getCKey(TVKCommParams.getStaGuid(), j3, assetIdForCKey, tVKCkeyParam.getAppVer(), String.valueOf(optInt), tVKCkeyParam.getSdtfrom(), constructCkeyExternParams, constructCkeyExternParams.length, tVKCkeyParam.getExtraJson() == null ? "" : tVKCkeyParam.getExtraJson().toString());
        iTVKLogger.info("CGI: GenCkey version = " + tVKCkeyParam.getAppVer() + " curTime = " + j3 + " assetIdForCKey = " + assetIdForCKey + " platform = " + optInt + " ckey = " + cKey, new Object[0]);
        return cKey;
    }
}
