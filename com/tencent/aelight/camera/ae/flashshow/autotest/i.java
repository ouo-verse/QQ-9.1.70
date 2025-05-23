package com.tencent.aelight.camera.ae.flashshow.autotest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private volatile hq.a f64186a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends TypeToken<hq.a> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        protected static final i f64188a = new i();
    }

    i() {
    }

    public static i d() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sInstance code:");
        i iVar = b.f64188a;
        sb5.append(iVar);
        QLog.i("TestCameraFilterConfig", 4, sb5.toString());
        return iVar;
    }

    private void e() {
        File file = new File("/sdcard/qq_img_auto_test/qq_camera_test.json");
        if (!file.exists()) {
            QLog.d("TestCameraFilterConfig", 4, "intiParamsFromJson over|no config json file:/sdcard/qq_img_auto_test/qq_camera_test.json");
            return;
        }
        try {
            String readFileToString = FileUtils.readFileToString(file);
            QLog.d("TestCameraFilterConfig", 4, "content:" + readFileToString);
            hq.a aVar = (hq.a) new Gson().fromJson(readFileToString, new a().getType());
            QLog.d("TestCameraFilterConfig", 4, "beans:" + aVar);
            if (aVar != null) {
                aVar.a();
                this.f64186a = aVar;
                QLog.d("TestCameraFilterConfig", 4, "videoTestMode:" + this.f64186a.f405868a + ",imageTestMode:" + this.f64186a.f405870c);
                if (this.f64186a.f405868a > 0) {
                    ArrayList arrayList = new ArrayList();
                    LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                    localMediaInfo.path = this.f64186a.f405869b;
                    arrayList.add(localMediaInfo);
                    com.tencent.aelight.camera.ae.flashshow.autotest.b.m(this.f64186a.f405868a == 1, arrayList);
                }
                if (this.f64186a.f405870c > 0) {
                    boolean z16 = aVar.f405870c == 1;
                    com.tencent.aelight.camera.ae.flashshow.autotest.b.f64141g = z16;
                    com.tencent.aelight.camera.ae.flashshow.autotest.b.f64144j = z16;
                }
            }
            QLog.d("TestCameraFilterConfig", 4, "intiParamsFromJson over.");
        } catch (Exception e16) {
            QLog.e("TestCameraFilterConfig", 4, "intiParamsFromJson:exception:" + e16.getMessage());
        }
    }

    public com.tencent.aelight.camera.ae.flashshow.autotest.a a() {
        if (com.tencent.aelight.camera.ae.flashshow.autotest.b.f64144j) {
            return new com.tencent.aelight.camera.ae.flashshow.autotest.a(this.f64186a.f405871d);
        }
        return null;
    }

    public void b() {
        if (this.f64186a != null) {
            return;
        }
        e();
    }

    public f c() {
        if (com.tencent.aelight.camera.ae.flashshow.autotest.b.f64151q) {
            return f.INSTANCE.a();
        }
        return null;
    }
}
