package h52;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.now.d;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: h52.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10413a implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f404335d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f404336e;

        C10413a(d dVar, String str) {
            this.f404335d = dVar;
            this.f404336e = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            boolean z16 = bundle.getBoolean("enable");
            QLog.i("AudioRoomSettingHandler", 1, "handleGetTmpMsgPushSetting: nowStatus=" + z16);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", "success");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pushSwitch", z16 ? 1 : 0);
                jSONObject.put("data", jSONObject2);
                this.f404335d.callJs(this.f404336e, jSONObject.toString());
            } catch (JSONException e16) {
                QLog.e("AudioRoomSettingHandler", 2, "handleGetTmpMsgPushSetting catch: " + e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f404337d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f404338e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f404339f;

        b(int i3, d dVar, String str) {
            this.f404337d = i3;
            this.f404338e = dVar;
            this.f404339f = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            boolean z16 = bundle.getBoolean("enable");
            String str = "success";
            boolean z17 = bundle.getBoolean("success");
            QLog.i("AudioRoomSettingHandler", 1, "handleSetTmpMsgPushSetting: toStatus=" + this.f404337d + " result=$isSucceed nowStatus=" + z16);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!z17) {
                    str = "fail";
                }
                jSONObject.put("result", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pushSwitch", z16 ? 1 : 0);
                jSONObject.put("data", jSONObject2);
                this.f404338e.callJs(this.f404339f, jSONObject.toString());
            } catch (JSONException e16) {
                QLog.e("AudioRoomSettingHandler", 2, "handleSetTmpMsgPushSetting catch: " + e16.toString());
            }
        }
    }

    private static void a(d dVar, JSONObject jSONObject, String str) {
        dVar.u().G((short) -23161, new C10413a(dVar, str));
    }

    public static void b(d dVar, String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String optString = jSONObject.optString("callback");
            int optInt = jSONObject.optInt(EventKey.ACT, -1);
            if (optInt == 1) {
                a(dVar, jSONObject, optString);
            } else if (optInt != 2) {
                QLog.w("AudioRoomSettingHandler", 1, "unknown action: " + optInt);
            } else {
                c(dVar, jSONObject, optString);
            }
        } catch (Exception e16) {
            QLog.w("AudioRoomSettingHandler", 1, "handleRequest catch: " + e16.toString());
        }
    }

    private static void c(d dVar, JSONObject jSONObject, String str) {
        int optInt = jSONObject.optInt("pushSwitch", -1);
        QLog.i("AudioRoomSettingHandler", 1, "handleSetTmpMsgPushSetting request: toStatus=" + optInt);
        if (optInt != 0 && optInt != 1) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", "fail");
                dVar.callJs(str, jSONObject2.toString());
                return;
            } catch (JSONException e16) {
                QLog.e("AudioRoomSettingHandler", 2, "handleSetTmpMsgPushSetting catch: " + e16.toString());
                return;
            }
        }
        dVar.u().G0((short) -23161, optInt == 1, new b(optInt, dVar, str));
    }
}
