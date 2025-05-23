package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StAddressInfo;
import NS_MINI_INTERFACE.INTERFACE$StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetProfileReq;
import NS_MINI_INTERFACE.INTERFACE$StGetProfileRsp;
import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes23.dex */
public class GetProfileRequest extends ProtoBufRequest {
    private static final String TAG = "GetProfileRequest";
    private INTERFACE$StGetProfileReq req;

    public GetProfileRequest(String str, boolean z16, String str2) {
        INTERFACE$StGetProfileReq iNTERFACE$StGetProfileReq = new INTERFACE$StGetProfileReq();
        this.req = iNTERFACE$StGetProfileReq;
        iNTERFACE$StGetProfileReq.appid.set(str);
        this.req.withCredentials.set(z16 ? 1 : 0);
        if (!TextUtils.isEmpty(str2)) {
            this.req.lang.set(str2);
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetProfile";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_user_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetProfileRsp iNTERFACE$StGetProfileRsp = new INTERFACE$StGetProfileRsp();
        try {
            iNTERFACE$StGetProfileRsp.mergeFrom(bArr);
            JSONObject jSONObject2 = new JSONObject();
            INTERFACE$StApiUserInfo iNTERFACE$StApiUserInfo = iNTERFACE$StGetProfileRsp.user;
            if (iNTERFACE$StApiUserInfo != null) {
                jSONObject2.put("nickName", iNTERFACE$StApiUserInfo.nick.get());
                jSONObject2.put(PhotoCategorySummaryInfo.AVATAR_URL, iNTERFACE$StGetProfileRsp.user.avatar.get());
                jSONObject2.put("gender", iNTERFACE$StGetProfileRsp.user.gender.get());
                jSONObject2.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, iNTERFACE$StGetProfileRsp.user.language.get());
                INTERFACE$StAddressInfo iNTERFACE$StAddressInfo = iNTERFACE$StGetProfileRsp.user.address;
                if (iNTERFACE$StAddressInfo != null) {
                    jSONObject2.put("province", iNTERFACE$StAddressInfo.province.get());
                    jSONObject2.put("city", iNTERFACE$StGetProfileRsp.user.address.city.get());
                    jSONObject2.put("country", iNTERFACE$StGetProfileRsp.user.address.country.get());
                }
            }
            jSONObject.put("rawData", iNTERFACE$StGetProfileRsp.rawData.get());
            jSONObject.put("signature", iNTERFACE$StGetProfileRsp.signature.get());
            jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, iNTERFACE$StGetProfileRsp.encryptedData.get());
            jSONObject.put("iv", iNTERFACE$StGetProfileRsp.f24961iv.get());
            jSONObject.put(ITVKPlayerEventListener.KEY_USER_INFO, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("data", iNTERFACE$StGetProfileRsp.rawData.get());
            jSONObject3.put("signature", iNTERFACE$StGetProfileRsp.signature.get());
            jSONObject.put("data", jSONObject3.toString());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
