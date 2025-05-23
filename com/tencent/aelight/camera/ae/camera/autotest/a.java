package com.tencent.aelight.camera.ae.camera.autotest;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import zp.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private List<a.C11707a> f62207b;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC0535a f62209d;

    /* renamed from: a, reason: collision with root package name */
    private b f62206a = null;

    /* renamed from: c, reason: collision with root package name */
    private int f62208c = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.camera.autotest.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public interface InterfaceC0535a {
        void a(String str, int i3);

        VideoMaterial b(String str);

        void c(String str, int i3);

        void d(String str, int i3);

        void e(VideoMaterial videoMaterial, int i3);

        void f(String str);

        void g(String str, int i3, int i16);

        void h(BeautyRealConfig.TYPE type, int i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(List<a.C11707a> list) {
        this.f62207b = list;
    }

    private void e(int i3, int i16, int i17, String str) {
        Bitmap saveTexture = RendererUtils.saveTexture(i3, i16, i17);
        if (saveTexture == null) {
            QLog.e("AutoImageTestManager", 4, "saveTextureID2File|failed!bitmap is null ,path:" + str);
            return;
        }
        d(saveTexture, str, 100);
        saveTexture.recycle();
        QLog.i("AutoImageTestManager", 4, "saveTextureID2File|successful!path:" + str);
    }

    public String a() {
        if (this.f62206a == null) {
            List<a.C11707a> list = this.f62207b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            int i3 = this.f62208c;
            if (size <= i3 || this.f62207b.get(i3) == null) {
                return null;
            }
            b bVar = new b(this.f62207b.get(this.f62208c));
            this.f62206a = bVar;
            bVar.m(this.f62209d);
        }
        return this.f62206a.a();
    }

    public boolean b() {
        b bVar = this.f62206a;
        return bVar != null && bVar.i();
    }

    public boolean c() {
        return this.f62206a == null;
    }

    public void f(InterfaceC0535a interfaceC0535a) {
        this.f62209d = interfaceC0535a;
    }

    public void g(int i3, int i16, int i17) {
        b bVar = this.f62206a;
        if (bVar == null) {
            return;
        }
        if (bVar.l()) {
            this.f62206a.m(null);
            this.f62206a = null;
            this.f62208c++;
        } else {
            this.f62206a.n();
            if (!this.f62206a.k() || this.f62206a.b() == null) {
                return;
            }
            e(i3, i16, i17, this.f62206a.b());
        }
    }

    public static BitmapUtils.SAVE_STATUS d(Bitmap bitmap, String str, int i3) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                if (bitmap != null) {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i3, fileOutputStream2);
                        fileOutputStream2.flush();
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        LogUtils.e(e);
                        BitmapUtils.SAVE_STATUS save_status = BitmapUtils.SAVE_STATUS.SAVE_FAILED;
                        IOUtils.closeQuietly(fileOutputStream);
                        return save_status;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        LogUtils.e(e);
                        if (bitmap != null) {
                            ReportUtil.report(String.format("OutOfMemoryError! saveBitmap. path = %s, width = %d, height = %d.", str, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
                        }
                        BitmapUtils.SAVE_STATUS save_status2 = BitmapUtils.SAVE_STATUS.SAVE_OOM;
                        IOUtils.closeQuietly(fileOutputStream);
                        return save_status2;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        IOUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                BitmapUtils.SAVE_STATUS save_status3 = BitmapUtils.SAVE_STATUS.SAVE_SUCCESS;
                IOUtils.closeQuietly(fileOutputStream2);
                return save_status3;
            } catch (Exception e18) {
                e = e18;
            } catch (OutOfMemoryError e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
