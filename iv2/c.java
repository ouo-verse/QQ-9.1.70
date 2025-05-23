package iv2;

import android.text.TextUtils;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import iv2.d;
import java.util.HashMap;
import pw2.i;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(int i3, String str) {
        if (i3 == 0) {
            n.e("QAdEffectReport", "reportDownloadEffect==" + str);
            return;
        }
        n.e("QAdEffectReport", "reportDownloadEffect errCode:" + str);
    }

    public static void c(String str, String str2, AdReport adReport, String str3, String str4, String str5, String str6) {
        if (adReport == null) {
            boolean z16 = com.tencent.miniqadsdk.a.f151670a;
            return;
        }
        n.e("QAdEffectReport", "reportDownloadEffect clickId:" + str3 + " actionID:" + str4 + " adId:" + str + " adPos:" + str2 + " url:" + adReport.url);
        String str7 = adReport.url;
        if (!TextUtils.isEmpty(str7)) {
            if (!TextUtils.isEmpty(str3)) {
                str7 = str7.replace("__CLICK_ID__", str3);
            }
            str7 = str7.replace("__ACTION_ID__", str4);
        }
        n.e("QAdEffectReport", "reportDownloadEffect  url:" + str7);
        d.a d16 = d.d(str7);
        if (d16 != null && !TextUtils.isEmpty(d16.b())) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("Content-Type", ITVKHttpProcessor.HTTP_REQUEST_CONTENT_TYPE_VALUE_FORM);
            i.q(d16.b(), d16.a(), hashMap, new iw2.a() { // from class: iv2.b
                @Override // iw2.a
                public final void a(int i3, String str8) {
                    c.b(i3, str8);
                }
            });
        }
    }
}
