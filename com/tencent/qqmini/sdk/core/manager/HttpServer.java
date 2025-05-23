package com.tencent.qqmini.sdk.core.manager;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.util.Base64;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.service.RequestProxyDefault;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.request.ProtoBufRequest;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class HttpServer {
    private static final String TAG = "HttpServer";
    private static RequestProxyDefault mRequestProxy;
    private static Random sRandom = new Random();
    private static boolean useHttpDirectly;

    static {
        boolean z16;
        if (!QUAUtil.isAlienApp() && !QUAUtil.isDemoApp()) {
            z16 = false;
        } else {
            z16 = true;
        }
        useHttpDirectly = z16;
        mRequestProxy = new RequestProxyDefault();
    }

    private static String getPlatformKey() {
        return "test";
    }

    private static String getRequestUrl() {
        String str = "Nonce=" + sRandom.nextInt();
        String str2 = "PlatformID=" + ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getPlatformId();
        String str3 = "Timestamp=" + (System.currentTimeMillis() / 1000);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Signature=");
        sb5.append(getSignature("POST /mini/OpenChannel?Action=input" + ContainerUtils.FIELD_DELIMITER + str + ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.FIELD_DELIMITER + "SignatureMethod=HmacSHA256" + ContainerUtils.FIELD_DELIMITER + str3));
        return "https://q.qq.com/mini/OpenChannel?Action=input" + ContainerUtils.FIELD_DELIMITER + str + ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.FIELD_DELIMITER + "SignatureMethod=HmacSHA256" + ContainerUtils.FIELD_DELIMITER + str3 + ContainerUtils.FIELD_DELIMITER + sb5.toString();
    }

    private static String getSignature(String str) {
        try {
            QMLog.d(TAG, "getSignature(). original request = " + str);
            byte[] hmacSHA256 = hmacSHA256(str, getPlatformKey());
            if (hmacSHA256 == null) {
                return null;
            }
            String encodeToString = Base64.encodeToString(hmacSHA256, 0);
            int length = encodeToString.length() - 1;
            if (length >= 0 && encodeToString.charAt(length) == '\n') {
                encodeToString = encodeToString.substring(0, length);
            }
            String encode = URLEncoder.encode(encodeToString, "UTF-8");
            QMLog.d(TAG, "getSignature(). signature = " + encode);
            return encode;
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return "";
        } catch (InvalidKeyException e17) {
            e17.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e18) {
            e18.printStackTrace();
            return "";
        }
    }

    private static byte[] hmacSHA256(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256);
        mac.init(new SecretKeySpec(str2.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256));
        return mac.doFinal(str.getBytes());
    }

    public static void postData(String str, byte[] bArr, HashMap<String, String> hashMap, MiniAppProxy.SenderListener senderListener) {
        try {
            ((RequestProxy) ProxyManager.get(RequestProxy.class)).request(str, bArr, hashMap, Method.POST, 60, new a(senderListener));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void requestContainerInfo(final ProtoBufRequest protoBufRequest, final AsyncResult asyncResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("Cookie", "uin=o0740688395; p_uin=o0740688395; client_version=8.8.93; pgv_info=ssid=s1967585512; pgv_pvid=2664493930; qq_locale_id=2052; qq_route_id=-1; skey=MGepK42JzC; p_skey=egqVkQSOkypsHyFerKtdi8c*dgf8qtwvNsroDo85y-I_");
        postData("https://pd.qq.com/cgi-bin/group_pro/getminiappconfig", protoBufRequest.encode(), hashMap, new MiniAppProxy.SenderListener() { // from class: com.tencent.qqmini.sdk.core.manager.HttpServer.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener
            public boolean onReply(int i3, byte[] bArr, String str) {
                if (AsyncResult.this != null) {
                    AsyncResult.this.onReceiveResult(true, protoBufRequest.getResponse(bArr));
                }
                return true;
            }
        });
    }

    public static void sendData(byte[] bArr, MiniAppProxy.SenderListener senderListener) {
        if (bArr == null) {
            Log.e(TAG, "no request data");
            senderListener.onReply(-1, null, "no request data");
            return;
        }
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        try {
            stQWebReq.mergeFrom(bArr);
            RequestProxy requestProxy = (RequestProxy) ProxyManager.get(RequestProxy.class);
            if (useHttpDirectly) {
                requestProxy = mRequestProxy;
            }
            requestProxy.request(getRequestUrl(), stQWebReq.toByteArray(), null, Method.POST, 60, new b(senderListener));
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class a implements RequestProxy.RequestListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MiniAppProxy.SenderListener f348017a;

        a(MiniAppProxy.SenderListener senderListener) {
            this.f348017a = senderListener;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
        public void onRequestFailed(int i3, String str) {
            QMLog.i(HttpServer.TAG, "code = " + i3 + ", errorMsg = " + str);
            MiniAppProxy.SenderListener senderListener = this.f348017a;
            if (senderListener != null) {
                senderListener.onReply(i3, null, str);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
        public void onRequestSucceed(int i3, byte[] bArr, Map<String, List<String>> map) {
            if (i3 == 200) {
                i3 = 0;
            }
            this.f348017a.onReply(i3, bArr, "");
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
        public void onRequestHeadersReceived(int i3, Map<String, List<String>> map) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    static class b implements RequestProxy.RequestListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MiniAppProxy.SenderListener f348018a;

        b(MiniAppProxy.SenderListener senderListener) {
            this.f348018a = senderListener;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
        public void onRequestFailed(int i3, String str) {
            QMLog.i(HttpServer.TAG, "code = " + i3 + ", errorMsg = " + str);
            MiniAppProxy.SenderListener senderListener = this.f348018a;
            if (senderListener != null) {
                senderListener.onReply(i3, null, str);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
        public void onRequestSucceed(int i3, byte[] bArr, Map<String, List<String>> map) {
            if (i3 == 200) {
                i3 = 0;
            }
            PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
            try {
                stQWebRsp.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            MiniAppProxy.SenderListener senderListener = this.f348018a;
            if (senderListener != null) {
                senderListener.onReply(i3, stQWebRsp.toByteArray(), null);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
        public void onRequestHeadersReceived(int i3, Map<String, List<String>> map) {
        }
    }
}
