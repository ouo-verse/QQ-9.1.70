package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static String f75327c = "AIOTopRightButtonConfig";

    /* renamed from: d, reason: collision with root package name */
    private static a f75328d;

    /* renamed from: a, reason: collision with root package name */
    private int f75329a = -1;

    /* renamed from: b, reason: collision with root package name */
    private Object f75330b = new Object();

    public static a a() {
        synchronized (a.class) {
            if (f75328d == null) {
                f75328d = new a();
            }
        }
        return f75328d;
    }

    public void b(String str) {
        synchronized (this.f75330b) {
            this.f75329a = 1;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("AVFromRightCornerEnable") && !jSONObject.getBoolean("AVFromRightCornerEnable")) {
                    this.f75329a = 0;
                }
            } catch (JSONException e16) {
                QLog.w(f75327c, 1, "updateConfig, JSONException", e16);
            }
        }
    }
}
