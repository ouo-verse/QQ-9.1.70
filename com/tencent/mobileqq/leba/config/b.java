package com.tencent.mobileqq.leba.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f240326a;

    /* renamed from: b, reason: collision with root package name */
    public int f240327b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f240326a = 0;
            this.f240327b = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001b A[Catch: Exception -> 0x0062, TryCatch #0 {Exception -> 0x0062, blocks: (B:11:0x000c, B:13:0x000f, B:4:0x0015, B:6:0x001b, B:9:0x0022), top: B:10:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022 A[Catch: Exception -> 0x0062, TRY_LEAVE, TryCatch #0 {Exception -> 0x0062, blocks: (B:11:0x000c, B:13:0x000f, B:4:0x0015, B:6:0x001b, B:9:0x0022), top: B:10:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(ai[] aiVarArr) {
        String str;
        b bVar = new b();
        if (aiVarArr != null) {
            try {
            } catch (Exception e16) {
                QLog.i("LebaQzoneStyleBean", 1, "handleLebaConfig parse", e16);
            }
            if (aiVarArr.length > 0) {
                str = aiVarArr[0].f202268b;
                if (!TextUtils.isEmpty(str)) {
                    QLog.i("LebaQzoneStyleBean", 1, "content is empty");
                } else {
                    JSONObject jSONObject = new JSONObject(str);
                    bVar.f240326a = jSONObject.optInt("gridstyle", 0);
                    bVar.f240327b = jSONObject.optInt("sequenceadjust", 0);
                    QLog.i("LebaQzoneStyleBean", 1, "parse config=" + str + ",style=" + bVar.f240326a + ",sequenceAdjust=" + bVar.f240327b);
                }
                return bVar;
            }
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
        return bVar;
    }
}
