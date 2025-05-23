package com.tencent.gamematrix.gmcg.sdk.nonage.net;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.volley.VolleyError;
import com.android.volley.h;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.network.CGGsonRequest;
import com.tencent.gamematrix.gmcg.base.network.CGHttpReqManager;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGFaceRecognitionResp;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageCheckTokenResp;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageCloudGameHeartBeatResp;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageCreateTokenResp;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageGetUserAgeResp;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGNonageUser;
import com.tencent.gamematrix.gmcg.sdk.nonage.net.CGNonAgeProtectRequest;
import com.tencent.gamematrix.gmcg.sdk.service.CGServerProvider;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class CGNonAgeProtectRequest {
    private static String OFFICIAL_HOST = "https://m.gamer.qq.com";
    private static String TEST_HOST = "https://test3.guyu.qq.com";
    private static String TIYAN_HOST = "https://guyu.qq.com";

    /* loaded from: classes6.dex */
    public interface IRequestCallback<T> {
        void onError(GmCgError gmCgError);

        void onSuccess(T t16);
    }

    public static void getCheckToken(String str, @Nullable IRequestCallback<CGNonageCheckTokenResp> iRequestCallback) {
        String str2;
        try {
            str2 = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e16) {
            CGLog.d("checkToken: " + e16.getMessage());
            str2 = null;
        }
        request(getHost() + "/v2/api/session/check_token?token=" + str2 + "&scene_type=user&_" + String.valueOf(System.currentTimeMillis() / 1000), 0, CGNonageCheckTokenResp.class, null, null, iRequestCallback);
    }

    public static void getCreateToken(@Nullable IRequestCallback<CGNonageCreateTokenResp> iRequestCallback) {
        request(getHost() + "/v2/api/session/create_token", 0, CGNonageCreateTokenResp.class, null, null, iRequestCallback);
    }

    public static void getFaceRecognitionOpenLink(String str, @Nullable IRequestCallback<CGFaceRecognitionResp> iRequestCallback) {
        try {
            str = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e16) {
            CGLog.e("faceRecognitionUrl encode failed! " + e16.getMessage());
        }
        request(getHost() + "/v1/user/queryFaceJumpWxUrl?guideURL=" + str, 0, CGFaceRecognitionResp.class, null, null, iRequestCallback);
    }

    public static String getHost() {
        if (CGServerProvider.getServerType() == 1) {
            if (CGGlbConfig.hasServerMapping() && CGGlbConfig.getServerMapping().containsKey(TEST_HOST)) {
                return CGGlbConfig.getServerMapping().get(TEST_HOST);
            }
            return TEST_HOST;
        }
        if (CGServerProvider.getServerType() == 2) {
            if (CGGlbConfig.hasServerMapping() && CGGlbConfig.getServerMapping().containsKey(TIYAN_HOST)) {
                return CGGlbConfig.getServerMapping().get(TIYAN_HOST);
            }
            return TIYAN_HOST;
        }
        if (CGGlbConfig.hasServerMapping() && CGGlbConfig.getServerMapping().containsKey(OFFICIAL_HOST)) {
            return CGGlbConfig.getServerMapping().get(OFFICIAL_HOST);
        }
        return OFFICIAL_HOST;
    }

    public static String getLoginQrCode(String str) {
        return getHost() + "/v2/passport/login?token=" + str;
    }

    public static void getUserAge(String str, String str2, String str3, @Nullable IRequestCallback<CGNonageGetUserAgeResp> iRequestCallback) {
        requestWithLoginParams(getHost() + "/v1/childguard/queryAge?szAppID=" + str, 0, CGNonageGetUserAgeResp.class, null, str2, str3, null, iRequestCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$request$0(IRequestCallback iRequestCallback, Object obj) {
        if (iRequestCallback != null) {
            iRequestCallback.onSuccess(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$request$1(IRequestCallback iRequestCallback, VolleyError volleyError) {
        if (iRequestCallback != null) {
            iRequestCallback.onError(parseRequestError(volleyError));
        }
    }

    private static GmCgError parseRequestError(VolleyError volleyError) {
        GmCgError gmCgError = GmCgError.ErrorRequestFail;
        if (volleyError != null && volleyError.networkResponse != null) {
            CGLog.e("request http error: " + volleyError.networkResponse.f31331a + "|" + new String(volleyError.networkResponse.f31332b));
            int i3 = volleyError.networkResponse.f31331a;
            if (401 == i3 || 403 == i3) {
                return GmCgError.ErrorInvalidToken;
            }
            return gmCgError;
        }
        return gmCgError;
    }

    public static void postHeatBeat(int i3, long j3, String str, @Nullable IRequestCallback<CGNonageCloudGameHeartBeatResp> iRequestCallback) {
        requestWithLoginParams(getHost() + "/v1/user/heartbeatProxy?iFactType=" + i3 + "&iDuration=" + j3 + "&szAppID=" + str, 1, CGNonageCloudGameHeartBeatResp.class, null, null, iRequestCallback);
    }

    public static void postHeatBeatExcute(String str, String str2, @Nullable IRequestCallback<CGNonageCloudGameHeartBeatResp> iRequestCallback) {
        String str3 = getHost() + "/v1/user/reportExecute";
        HashMap hashMap = new HashMap();
        hashMap.put("szInstrTraceId", str);
        hashMap.put("szRuleName", str2);
        requestWithLoginParams(str3, 1, CGNonageCloudGameHeartBeatResp.class, null, hashMap, iRequestCallback);
    }

    private static <T> void request(String str, int i3, @NonNull Class<T> cls, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable final IRequestCallback<T> iRequestCallback) {
        CGHttpReqManager.get().newReq(new CGGsonRequest(i3, str, cls, map, map2, null, new h.b() { // from class: tl0.a
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                CGNonAgeProtectRequest.lambda$request$0(CGNonAgeProtectRequest.IRequestCallback.this, obj);
            }
        }, new h.a() { // from class: tl0.b
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                CGNonAgeProtectRequest.lambda$request$1(CGNonAgeProtectRequest.IRequestCallback.this, volleyError);
            }
        }));
    }

    private static <T> void requestWithLoginParams(String str, int i3, @NonNull Class<T> cls, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable IRequestCallback<T> iRequestCallback) {
        String str2;
        String str3;
        CGNonageUser user = CGNonAgeProtectModule.getInstance().getUser();
        if (user != null) {
            String userId = user.getUserId();
            str3 = user.getKey();
            str2 = userId;
        } else {
            str2 = "";
            str3 = str2;
        }
        requestWithLoginParams(str, i3, cls, map, str2, str3, map2, iRequestCallback);
    }

    public static String stringToMD5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb5 = new StringBuilder(digest.length * 2);
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if (i3 < 16) {
                    sb5.append("0");
                }
                sb5.append(Integer.toHexString(i3));
            }
            return sb5.toString();
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    private static <T> void requestWithLoginParams(String str, int i3, @NonNull Class<T> cls, Map<String, String> map, String str2, String str3, @Nullable Map<String, String> map2, @Nullable IRequestCallback<T> iRequestCallback) {
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map3 = map;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            String stringToMD5 = stringToMD5("dorisisnicegirl" + str2 + (System.currentTimeMillis() / 3600000));
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            String str4 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str4 = ContainerUtils.FIELD_DELIMITER;
            }
            sb5.append(str4);
            sb5.append("tk=");
            sb5.append(stringToMD5);
            str = sb5.toString();
            map3.put("cookie", "key=" + str3);
        }
        request(str, i3, cls, map3, map2, iRequestCallback);
    }
}
