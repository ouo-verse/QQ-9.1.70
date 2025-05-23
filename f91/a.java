package f91;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.ark.config.ArkMsgReplyConfigMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* compiled from: P */
    /* renamed from: f91.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C10292a implements py2.a<String> {
        C10292a() {
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                QLog.w("ArkApp.ArkMsgReplyConfParser", 1, "ArkMsgReplyConfig == null");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkMsgReplyConfParser", 1, "ArkMsgReplyConfig [onParsed] , content = ");
                a.c(str);
            }
            try {
                ArkMsgReplyConfigMgr.getInstance().updateConfig(new JSONObject(str));
            } catch (JSONException e16) {
                QLog.w("ArkApp.ArkMsgReplyConfParser", 1, "ArkMsgReplyConfig [onParsed] error" + e16);
            }
        }
    }

    public static void b() {
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsStringAsync("ark_msg_reply_config", "", new C10292a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        int i3 = 0;
        int i16 = 0;
        while (i3 < str.length() && i16 < 5) {
            try {
                int i17 = i3 + 1024;
                QLog.d("ArkApp.ArkMsgReplyConfParser", 1, str.substring(i3, Math.min(i17, str.length())));
                i16++;
                i3 = i17;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
    }
}
