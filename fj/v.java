package fj;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.servlet.CloudStorageServlet;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class v {
    public static void a(boolean z16, int i3, int i16, long j3, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("request_success", Integer.valueOf(z16 ? 1 : 0));
        hashMap.put(CloudStorageServlet.REQUEST_TYPE, Integer.valueOf(i3));
        hashMap.put("fail_error_code", Integer.valueOf(i16));
        hashMap.put("back_end_response_time", Long.valueOf(j3));
        if (!z16 && !TextUtils.isEmpty(str)) {
            hashMap.put("trace_id", str);
        }
        fo.c.c("ev_qun_album_request", hashMap);
    }
}
