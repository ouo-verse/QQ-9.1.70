package com.tencent.mobileqq.troop.qrcode.api.impl;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.qrcode.ak;
import com.tencent.mobileqq.troop.qrcode.api.ITroopQRCodeShareApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J&\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/api/impl/TroopQRCodeShareApiImpl;", "Lcom/tencent/mobileqq/troop/qrcode/api/ITroopQRCodeShareApi;", "", "troopUin", "shareLink", "reqTailJumpUrl", "shortChain", "reqAuthSigByShortChain", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/av;", "getJumpParser", "troopName", "Landroid/os/Bundle;", "getQZonePublishBizBundle", "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopQRCodeShareApiImpl implements ITroopQRCodeShareApi {
    private static final String TAG = "TroopQRCodeShareApiImpl";
    public static final String TAIL_KEY_ACTION_TYPE = "action_type";
    public static final String TAIL_KEY_JUMP_URL = "jump_url";
    public static final String TAIL_KEY_RECOM_ID = "recom_bottom_id";
    public static final String TAIL_KEY_TITLE = "title";
    public static final String TROOP_INFO_CARD_SCHEMA = "mqqapi://card/show_pslcard?card_type=group&src_type=internal&version=1&wSourceSubID=10205";

    private final String reqAuthSigByShortChain(String shortChain) {
        HttpURLConnection httpURLConnection;
        try {
            URLConnection openConnection = new URL(shortChain).openConnection();
            httpURLConnection = openConnection instanceof HttpURLConnection ? (HttpURLConnection) openConnection : null;
        } catch (Exception e16) {
            QLog.i(TAG, 1, "[reqAuthSigByShortChain] exception = " + e16);
        }
        if (httpURLConnection == null) {
            return null;
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.connect();
        QLog.i(TAG, 1, "[reqAuthSigByShortChain] shortChain = " + shortChain + " responseCode = " + httpURLConnection.getResponseCode());
        if (httpURLConnection.getResponseCode() == 302) {
            return Uri.parse(httpURLConnection.getHeaderField("Location")).getQueryParameter("authKey");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.qrcode.api.ITroopQRCodeShareApi
    public Class<av> getJumpParser() {
        return ak.class;
    }

    @Override // com.tencent.mobileqq.troop.qrcode.api.ITroopQRCodeShareApi
    public Bundle getQZonePublishBizBundle(String troopUin, String troopName, String shareLink) {
        if (!(!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105575", true))) {
            if (!(troopUin == null || troopUin.length() == 0)) {
                if (!(troopName == null || troopName.length() == 0)) {
                    Bundle bundle = new Bundle();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(TAIL_KEY_RECOM_ID, 7);
                    jSONObject.put("title", "\u7fa4\u804a\u00b7" + troopName);
                    jSONObject.put("action_type", 2);
                    jSONObject.put("jump_url", reqTailJumpUrl(troopUin, shareLink));
                    bundle.putString("shareSource", "miniApp");
                    bundle.putString("key_mini_appid", "0");
                    bundle.putString(QZoneShareManager.QZONE_SHARE_KEY_MINI_APP_TAIL, jSONObject.toString());
                    QLog.i(TAG, 1, "[getQZonePublishBizBundle] tailJson = " + jSONObject + " bizBundle = " + bundle);
                    return bundle;
                }
            }
        }
        return new Bundle();
    }

    private final String reqTailJumpUrl(String troopUin, String shareLink) {
        if (shareLink == null || shareLink.length() == 0) {
            return "";
        }
        String reqAuthSigByShortChain = reqAuthSigByShortChain(shareLink);
        if (reqAuthSigByShortChain == null || reqAuthSigByShortChain.length() == 0) {
            return shareLink;
        }
        return "mqqapi://card/show_pslcard?card_type=group&src_type=internal&version=1&wSourceSubID=10205&uin=" + troopUin + "&authSig=" + reqAuthSigByShortChain;
    }
}
