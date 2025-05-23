package com.tencent.aelight.camera.ae.camera.autotest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private volatile zp.a f62215a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends TypeToken<zp.a> {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        protected static final c f62217a = new c();
    }

    c() {
    }

    public static c c() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sInstance code:");
        c cVar = b.f62217a;
        sb5.append(cVar);
        QLog.i("TestCameraFilterConfig", 4, sb5.toString());
        return cVar;
    }

    private void d() {
        File file = new File("/sdcard/qq_img_auto_test/qq_camera_test.json");
        if (!file.exists()) {
            QLog.d("TestCameraFilterConfig", 4, "intiParamsFromJson over|no config json file:/sdcard/qq_img_auto_test/qq_camera_test.json");
            return;
        }
        try {
            String readFileToString = FileUtils.readFileToString(file);
            QLog.d("TestCameraFilterConfig", 4, "content:" + readFileToString);
            zp.a aVar = (zp.a) new Gson().fromJson(readFileToString, new a().getType());
            QLog.d("TestCameraFilterConfig", 4, "beans:" + aVar);
            if (aVar != null) {
                aVar.a();
                this.f62215a = aVar;
                QLog.d("TestCameraFilterConfig", 4, "videoTestMode:" + this.f62215a.f452925a + ",imageTestMode:" + this.f62215a.f452927c);
                if (this.f62215a.f452925a > 0) {
                    eq.a.l(this.f62215a.f452925a == 1, this.f62215a.f452926b);
                }
                if (this.f62215a.f452927c > 0) {
                    boolean z16 = aVar.f452927c == 1;
                    eq.a.f396953f = z16;
                    eq.a.f396956i = z16;
                }
            }
            QLog.d("TestCameraFilterConfig", 4, "intiParamsFromJson over.");
        } catch (Exception e16) {
            QLog.e("TestCameraFilterConfig", 4, "intiParamsFromJson:exception:" + e16.getMessage());
        }
    }

    public com.tencent.aelight.camera.ae.camera.autotest.a a() {
        if (eq.a.f396956i) {
            return new com.tencent.aelight.camera.ae.camera.autotest.a(this.f62215a.f452928d);
        }
        return null;
    }

    public void b() {
        if (this.f62215a != null) {
            return;
        }
        d();
    }
}
