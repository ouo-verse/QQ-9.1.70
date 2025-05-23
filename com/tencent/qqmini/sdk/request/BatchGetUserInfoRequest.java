package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE$StBatchGetUserInfoReq;
import NS_MINI_INTERFACE.INTERFACE$StBatchGetUserInfoRsp;
import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BatchGetUserInfoRequest extends ProtoBufRequest {
    private static final String TAG = "BatchGetUserInfoRequest";
    private INTERFACE$StBatchGetUserInfoReq req;

    public BatchGetUserInfoRequest(String str, String str2, String[] strArr) {
        INTERFACE$StBatchGetUserInfoReq iNTERFACE$StBatchGetUserInfoReq = new INTERFACE$StBatchGetUserInfoReq();
        this.req = iNTERFACE$StBatchGetUserInfoReq;
        iNTERFACE$StBatchGetUserInfoReq.appid.set(str);
        if (!TextUtils.isEmpty(str2)) {
            this.req.lang.set(str2);
        }
        for (String str3 : strArr) {
            this.req.openIds.add(str3);
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "BatchGetUserInfo";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_user_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        INTERFACE$StBatchGetUserInfoRsp iNTERFACE$StBatchGetUserInfoRsp = new INTERFACE$StBatchGetUserInfoRsp();
        iNTERFACE$StBatchGetUserInfoRsp.mergeFrom(bArr);
        PBRepeatMessageField<INTERFACE$StApiUserInfo> pBRepeatMessageField = iNTERFACE$StBatchGetUserInfoRsp.user;
        if (pBRepeatMessageField != null) {
            List<INTERFACE$StApiUserInfo> list = pBRepeatMessageField.get();
            JSONArray jSONArray = new JSONArray();
            for (INTERFACE$StApiUserInfo iNTERFACE$StApiUserInfo : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("nickName", iNTERFACE$StApiUserInfo.nick.get());
                jSONObject2.put(PhotoCategorySummaryInfo.AVATAR_URL, iNTERFACE$StApiUserInfo.avatar.get());
                jSONObject2.put("gender", iNTERFACE$StApiUserInfo.gender.get());
                jSONObject2.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, iNTERFACE$StApiUserInfo.language.get());
                jSONObject2.put("country", iNTERFACE$StApiUserInfo.address.country.get());
                jSONObject2.put("province", iNTERFACE$StApiUserInfo.address.province.get());
                jSONObject2.put("city", iNTERFACE$StApiUserInfo.address.city.get());
                jSONObject2.put("openId", iNTERFACE$StApiUserInfo.openid.get());
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("data", jSONArray);
            return jSONObject;
        }
        QMLog.d(TAG, "onResponse fail.rsp = null");
        return null;
    }
}
