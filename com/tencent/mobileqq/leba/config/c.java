package com.tencent.mobileqq.leba.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f240328a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f240328a = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001b A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:14:0x000c, B:16:0x000f, B:4:0x0015, B:6:0x001b, B:9:0x0022, B:12:0x0031), top: B:13:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022 A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:14:0x000c, B:16:0x000f, B:4:0x0015, B:6:0x001b, B:9:0x0022, B:12:0x0031), top: B:13:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(ai[] aiVarArr) {
        String str;
        c cVar = new c();
        boolean z16 = false;
        if (aiVarArr != null) {
            try {
            } catch (Exception e16) {
                QLog.i("LebaRedTouchSwitchBean", 1, "handleLebaConfig parse", e16);
            }
            if (aiVarArr.length > 0) {
                str = aiVarArr[0].f202268b;
                if (!TextUtils.isEmpty(str)) {
                    QLog.i("LebaRedTouchSwitchBean", 1, "content is empty");
                } else {
                    if (new JSONObject(str).optInt("red_touch_all_tianshu", 0) == 1) {
                        z16 = true;
                    }
                    cVar.f240328a = z16;
                    QLog.i("LebaRedTouchSwitchBean", 1, "parse config=" + str + ",mRedTouchAllTianshu=" + cVar.f240328a);
                }
                return cVar;
            }
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
        return cVar;
    }
}
