package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    private a f202523a;

    /* renamed from: b, reason: collision with root package name */
    private String f202524b;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a implements com.tencent.mobileqq.config.n<String> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f202525a = false;

        @Override // com.tencent.mobileqq.config.n
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onParse(String str) {
            boolean z16;
            if (TextUtils.isEmpty(str)) {
                QLog.e("OpenSdkSwitchConfig", 1, "OpenVirtual.config content is empty");
                return;
            }
            QLog.i("OpenSdkSwitchConfig", 1, "OpenVirtual.switch.config.parse=" + str);
            try {
                if (new JSONObject(str).optInt("enable", 0) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f202525a = z16;
                if (QLog.isColorLevel()) {
                    QLog.e("OpenSdkSwitchConfig", 2, "OpenVirtual.switch.config.parse=", toString());
                }
            } catch (JSONException e16) {
                QLog.e("OpenSdkSwitchConfig", 1, "OpenVirtual.config.getException.", e16);
            }
        }

        public String toString() {
            return "OpenSdkSwitchConfig={enable:" + this.f202525a + "}";
        }
    }

    public ar() {
        this.f202524b = "";
        this.f202523a = new a();
    }

    public a a() {
        return this.f202523a;
    }

    public String b() {
        return this.f202524b;
    }

    public ar(String str, a aVar) {
        this.f202524b = str;
        this.f202523a = aVar;
    }
}
