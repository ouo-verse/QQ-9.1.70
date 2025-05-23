package fs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends o<b, b> implements xc0.a {
    public final int C;

    /* renamed from: h, reason: collision with root package name */
    public final WeakReference<com.tencent.aelight.camera.aioeditor.takevideo.d> f400403h;

    /* renamed from: i, reason: collision with root package name */
    public final WeakReference<com.tencent.aelight.camera.aioeditor.takevideo.e> f400404i;

    /* renamed from: m, reason: collision with root package name */
    public final String f400405m;

    public c(com.tencent.aelight.camera.aioeditor.takevideo.d dVar) {
        this(dVar, null, 0);
    }

    public static Bitmap a(Bitmap bitmap, int i3) {
        if ((i3 + 90) % 180 == 0) {
            try {
                hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation begin!");
                long currentTimeMillis = System.currentTimeMillis();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.reset();
                matrix.postRotate(i3);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateOrientation end, cost:" + ((System.currentTimeMillis() - currentTimeMillis) / 1000.0d));
                return createBitmap;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 2, "rotate exception:" + e16);
                }
            }
        }
        return null;
    }

    public c(com.tencent.aelight.camera.aioeditor.takevideo.d dVar, com.tencent.aelight.camera.aioeditor.takevideo.e eVar, int i3) {
        this(dVar, eVar, null, i3);
    }

    public c(com.tencent.aelight.camera.aioeditor.takevideo.d dVar, com.tencent.aelight.camera.aioeditor.takevideo.e eVar, String str, int i3) {
        if (dVar != null) {
            this.f400403h = new WeakReference<>(dVar);
            this.f400404i = new WeakReference<>(eVar);
            this.f400405m = str;
            this.C = i3;
            return;
        }
        throw new NullPointerException("doodleLayout should not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0145 A[Catch: all -> 0x01b0, TRY_LEAVE, TryCatch #0 {all -> 0x01b0, blocks: (B:75:0x00c8, B:77:0x00d0, B:36:0x00eb, B:38:0x00f1, B:40:0x00fd, B:41:0x0106, B:50:0x013d, B:52:0x0145, B:67:0x0118, B:69:0x011e, B:70:0x0135), top: B:74:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0159 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011e A[Catch: all -> 0x01b0, TryCatch #0 {all -> 0x01b0, blocks: (B:75:0x00c8, B:77:0x00d0, B:36:0x00eb, B:38:0x00f1, B:40:0x00fd, B:41:0x0106, B:50:0x013d, B:52:0x0145, B:67:0x0118, B:69:0x011e, B:70:0x0135), top: B:74:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013b  */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void runSegment(JobContext jobContext, b bVar) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        Bitmap a16;
        Bitmap e16;
        String p06;
        long uptimeMillis = SystemClock.uptimeMillis();
        String str = bVar.f400393j;
        if (TextUtils.isEmpty(str)) {
            super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
            id0.a.k("take_video", "create_doodle_result", 0, -1, new String[0]);
            return;
        }
        com.tencent.aelight.camera.aioeditor.takevideo.d dVar = this.f400403h.get();
        com.tencent.aelight.camera.aioeditor.takevideo.e eVar = this.f400404i.get();
        if (dVar != null && (!dVar.O(this.C) || (eVar != null && eVar.F(this.C)))) {
            Bitmap t06 = dVar.V().t0(this.C);
            if (t06 != null) {
                String a17 = s.a(bVar.f400385b, bVar.f400399p, "mosaic.png");
                try {
                    com.tencent.biz.qqstory.utils.b.s(t06, a17, null);
                    bVar.f400387d.mosaicPath = a17;
                    hd0.c.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", a17);
                } catch (IOException e17) {
                    hd0.c.h("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", e17);
                    super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
                    return;
                }
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                BaseImageUtil.decodeFileWithBufferedStream(str, options);
                int i27 = options.outWidth;
                int i28 = options.outHeight;
                DynamicFaceLayer d06 = dVar.V().d0();
                if (d06 != null && (p06 = d06.p0(i27, i28, true)) != null) {
                    bVar.f400387d.putExtra("dynamic_Sticker_data", p06);
                }
                Bitmap L = dVar.L(this.C, false);
                String str2 = this.f400405m;
                if (str2 == null) {
                    str2 = s.a(bVar.f400385b, bVar.f400399p, ".png");
                }
                if (L != null) {
                    if (eVar != null) {
                        try {
                            if (eVar.F(this.C)) {
                                i3 = i27;
                                i16 = i28;
                                eVar.Y(this.C, new Canvas(L), L.getWidth(), L.getHeight());
                                if ((bVar.f400386c instanceof EditLocalVideoSource) || !bVar.f400387d.getBooleanExtra("landscape_video", false)) {
                                    i17 = i3;
                                    i18 = i16;
                                } else {
                                    i17 = options.outHeight;
                                    i18 = options.outWidth;
                                }
                                i19 = bVar.f400392i.f400432g;
                                i26 = bVar.f400385b;
                                if (i26 != 2 || i26 == 3 || i26 == 5 || i26 == 6) {
                                    if (bVar.f400386c instanceof EditLocalVideoSource) {
                                        hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resizedBitmap orientation=0");
                                        i19 = 0;
                                    }
                                    a16 = a(L, i19);
                                    if (a16 != null) {
                                        e16 = com.tencent.biz.qqstory.utils.b.e(a16, i17, i18, true, false);
                                        boolean a18 = e16 != null ? com.tencent.biz.qqstory.utils.b.a(e16, Bitmap.CompressFormat.PNG, 60, str2) : false;
                                        if (e16 != L) {
                                            com.tencent.biz.qqstory.utils.b.m(e16);
                                        }
                                        if (e16 == null && a18) {
                                            hd0.c.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
                                            id0.a.k("take_video", "create_doodle_time", 0, 0, "" + (SystemClock.uptimeMillis() - uptimeMillis));
                                            id0.a.k("take_video", "create_doodle_result", 0, 0, new String[0]);
                                            bVar.f400387d.doodlePath = str2;
                                            super.notifyResult(bVar);
                                            return;
                                        }
                                        hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
                                        id0.a.k("take_video", "create_doodle_result", 0, -2, new String[0]);
                                        bVar.f400387d.doodlePath = null;
                                        super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
                                        return;
                                    }
                                }
                                a16 = L;
                                e16 = com.tencent.biz.qqstory.utils.b.e(a16, i17, i18, true, false);
                                if (e16 != null) {
                                }
                                if (e16 != L) {
                                }
                                if (e16 == null) {
                                }
                                hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
                                id0.a.k("take_video", "create_doodle_result", 0, -2, new String[0]);
                                bVar.f400387d.doodlePath = null;
                                super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
                                return;
                            }
                        } finally {
                            dVar.b(L);
                        }
                    }
                    i3 = i27;
                    i16 = i28;
                    if (bVar.f400386c instanceof EditLocalVideoSource) {
                    }
                    i17 = i3;
                    i18 = i16;
                    i19 = bVar.f400392i.f400432g;
                    i26 = bVar.f400385b;
                    if (i26 != 2) {
                    }
                    if (bVar.f400386c instanceof EditLocalVideoSource) {
                    }
                    a16 = a(L, i19);
                    if (a16 != null) {
                    }
                    a16 = L;
                    e16 = com.tencent.biz.qqstory.utils.b.e(a16, i17, i18, true, false);
                    if (e16 != null) {
                    }
                    if (e16 != L) {
                    }
                    if (e16 == null) {
                    }
                    hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
                    id0.a.k("take_video", "create_doodle_result", 0, -2, new String[0]);
                    bVar.f400387d.doodlePath = null;
                    super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
                    return;
                }
                hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
                id0.a.k("take_video", "create_doodle_result", 0, -2, new String[0]);
                bVar.f400387d.doodlePath = null;
                super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
                return;
            } catch (OutOfMemoryError e18) {
                hd0.c.u("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", e18);
                super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
                return;
            }
        }
        hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
        bVar.f400387d.doodlePath = null;
        super.notifyResult(bVar);
    }
}
