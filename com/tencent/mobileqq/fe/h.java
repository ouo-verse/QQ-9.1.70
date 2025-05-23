package com.tencent.mobileqq.fe;

import android.util.Base64;
import com.tencent.mobileqq.channel.ChannelManager;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sign.QQSecuritySign;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import kotlin.time.DurationKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Long, EventCallback> f205841a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13172);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f205841a = new HashMap<>(32);
        }
    }

    public static void a(String str, String str2, EventCallback eventCallback) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c.a("FEKit_SafeChannelDispatch", 1, "face detect data null");
                eventCallback.onResult(-2000, new byte[0]);
                return;
            }
            String optString = jSONObject.optString("cmd", "");
            if ("face_detect".equals(optString)) {
                QQSecuritySign.getInstance().notifyFaceDetect(str, optJSONObject.optString("key", ""), optJSONObject.optString("content", ""), eventCallback);
                if (eventCallback != null) {
                    eventCallback.onResult(0, new byte[0]);
                    return;
                }
                return;
            }
            if ("ui_report".equals(optString)) {
                String optString2 = optJSONObject.optString("scene", "");
                String optString3 = optJSONObject.optString("event", "");
                String optString4 = optJSONObject.optString("params", "");
                c.a("FEKit_SafeChannelDispatch", 1, "QSec_Channel event:" + optString3);
                QQSecuritySign.getInstance().safeUiReport(optString2, optString3, optString4, null);
                if (eventCallback != null) {
                    eventCallback.onResult(0, new byte[0]);
                    return;
                }
                return;
            }
            if ("camera_detect".equals(optString)) {
                QQSecuritySign.getInstance().notifyCamera(optJSONObject.optString(AudienceReportConst.ROOM_ID, ""), optJSONObject.optString("camera_id", ""), optJSONObject.optString("camera_type", ""), optJSONObject.optString("camera_business", ""), optJSONObject.optString("camera_fromuin", ""), optJSONObject.optString("camera_touin", ""), eventCallback);
                if (eventCallback != null) {
                    eventCallback.onResult(0, new byte[0]);
                    return;
                }
                return;
            }
            c.a("FEKit_SafeChannelDispatch", 1, "unknow subcmd");
        } catch (JSONException e16) {
            c.a("FEKit_SafeChannelDispatch", 1, "JSONException e:" + e16);
            if (eventCallback != null) {
                eventCallback.onResult(-2000, new byte[0]);
            }
        }
    }

    public static void b(String str, byte[] bArr, boolean z16, int i3, long j3) {
        try {
            c.c("FEKit_SafeChannelDispatch", 1, "receive cmd:" + str + ",code:" + i3 + ",succ:" + z16 + ",callbackid:" + j3 + ",data len:" + bArr.length);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("receive_data", new String(Base64.encode(bArr, 0)));
            jSONObject.put("cmd", str);
            jSONObject.put("j_callbackid", j3);
            byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
            HashMap<Long, EventCallback> hashMap = f205841a;
            if (hashMap.containsKey(Long.valueOf(j3))) {
                hashMap.get(Long.valueOf(j3)).onResult(i3, bytes);
                hashMap.remove(Long.valueOf(j3));
            }
        } catch (Throwable th5) {
            c.a("FEKit_SafeChannelDispatch", 1, "JSONException e:" + th5);
        }
    }

    public static boolean c(long j3) {
        if (j3 >= DurationKt.MAX_MILLIS) {
            return true;
        }
        return false;
    }

    public static void d(String str, String str2, EventCallback eventCallback) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            QQSecuritySign.getInstance().dispatchEventPB(str, jSONObject.optString("cmd", ""), Base64.decode(jSONObject.optString("data", ""), 0), eventCallback);
        } catch (JSONException e16) {
            c.a("FEKit_SafeChannelDispatch", 1, "JSONException e:" + e16);
            eventCallback.onResult(-2000, new byte[0]);
        }
    }

    public static void e(String str, String str2, EventCallback eventCallback) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("send_data", "");
            String optString2 = jSONObject.optString("cmd", "");
            long optLong = jSONObject.optLong("j_callbackid", -1L);
            byte[] decode = Base64.decode(optString, 0);
            c.c("FEKit_SafeChannelDispatch", 1, "pj,cmd:" + optString2 + ",callbakid:" + optLong + ",len:" + decode.length);
            ChannelManager.getInstance().sendMessage(optString2, decode, optLong);
            f205841a.put(Long.valueOf(optLong), eventCallback);
        } catch (JSONException e16) {
            c.a("FEKit_SafeChannelDispatch", 1, "JSONException e:" + e16);
            eventCallback.onResult(-2000, new byte[0]);
        }
    }
}
