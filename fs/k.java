package fs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tribe.async.async.JobContext;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class k extends o<b, b> implements xc0.a {
    public final int C;

    /* renamed from: h, reason: collision with root package name */
    public final WeakReference<com.tencent.aelight.camera.aioeditor.takevideo.d> f400453h;

    /* renamed from: i, reason: collision with root package name */
    public final WeakReference<com.tencent.aelight.camera.aioeditor.takevideo.e> f400454i;

    /* renamed from: m, reason: collision with root package name */
    public final String f400455m;

    public k(com.tencent.aelight.camera.aioeditor.takevideo.d dVar) {
        this(dVar, null, 0);
    }

    public static int a(b bVar) {
        return bVar.f400386c instanceof EditLocalVideoSource ? (bVar.f400387d.getBooleanExtra("local_import", false) || !bVar.f400387d.getBooleanExtra("landscape_video", false)) ? 0 : 270 : bVar.f400392i.f400432g;
    }

    public k(com.tencent.aelight.camera.aioeditor.takevideo.d dVar, com.tencent.aelight.camera.aioeditor.takevideo.e eVar, int i3) {
        this(dVar, eVar, null, i3);
    }

    public k(com.tencent.aelight.camera.aioeditor.takevideo.d dVar, com.tencent.aelight.camera.aioeditor.takevideo.e eVar, String str, int i3) {
        if (dVar != null) {
            this.f400453h = new WeakReference<>(dVar);
            this.f400454i = new WeakReference<>(eVar);
            this.f400455m = str;
            this.C = i3;
            return;
        }
        throw new NullPointerException("doodleLayout should not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0142 A[Catch: all -> 0x0127, TryCatch #2 {all -> 0x0127, blocks: (B:77:0x010a, B:79:0x0112, B:48:0x0132, B:49:0x0136, B:51:0x0142, B:53:0x0160, B:69:0x0148, B:71:0x014e, B:75:0x0158), top: B:76:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0160 A[Catch: all -> 0x0127, TRY_LEAVE, TryCatch #2 {all -> 0x0127, blocks: (B:77:0x010a, B:79:0x0112, B:48:0x0132, B:49:0x0136, B:51:0x0142, B:53:0x0160, B:69:0x0148, B:71:0x014e, B:75:0x0158), top: B:76:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0148 A[Catch: all -> 0x0127, TryCatch #2 {all -> 0x0127, blocks: (B:77:0x010a, B:79:0x0112, B:48:0x0132, B:49:0x0136, B:51:0x0142, B:53:0x0160, B:69:0x0148, B:71:0x014e, B:75:0x0158), top: B:76:0x010a }] */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void runSegment(JobContext jobContext, b bVar) {
        String str;
        String str2;
        Bitmap e16;
        int a16;
        int i3;
        boolean z16;
        String p06;
        long uptimeMillis = SystemClock.uptimeMillis();
        String str3 = bVar.f400393j;
        if (TextUtils.isEmpty(str3)) {
            super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
            id0.a.k("take_video", "create_doodle_result", 0, -1, new String[0]);
            return;
        }
        com.tencent.aelight.camera.aioeditor.takevideo.d dVar = this.f400453h.get();
        com.tencent.aelight.camera.aioeditor.takevideo.e eVar = this.f400454i.get();
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
                } catch (UnsupportedOperationException e18) {
                    hd0.c.h("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", e18);
                    super.notifyError(new ErrorMessage(-1, "updateExif failed."));
                    return;
                }
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                BaseImageUtil.decodeFileWithBufferedStream(str3, options);
                int i16 = options.outWidth;
                int i17 = options.outHeight;
                EditVideoParams editVideoParams = bVar.f400384a;
                boolean z17 = (editVideoParams.f204055d == 14 && editVideoParams.q() && bVar.f400384a.f204059i.getWidth() < bVar.f400384a.f204059i.getHeight()) || bVar.f400384a.f204055d != 14;
                DynamicFaceLayer d06 = dVar.V().d0();
                if (d06 != null && (p06 = d06.p0(i16, i17, z17)) != null) {
                    bVar.f400387d.putExtra("dynamic_Sticker_data", p06);
                }
                Bitmap L = dVar.L(this.C, false);
                String str4 = this.f400455m;
                if (str4 == null) {
                    str = "create_doodle_result";
                    str4 = s.a(bVar.f400385b, bVar.f400399p, ".png");
                } else {
                    str = "create_doodle_result";
                }
                if (L != null) {
                    if (eVar != null) {
                        try {
                            if (eVar.F(this.C)) {
                                str2 = "take_video";
                                eVar.Y(this.C, new Canvas(L), L.getWidth(), L.getHeight());
                                if (i16 > i17 && z17) {
                                    i16 = options.outHeight;
                                    i17 = options.outWidth;
                                }
                                e16 = com.tencent.biz.qqstory.utils.b.e(L, i16, i17, true, false);
                                a16 = a(bVar);
                                if (a16 == 0) {
                                    e16 = UIUtils.p(e16, a16);
                                } else if (options.outWidth > options.outHeight && ((i3 = bVar.f400385b) == 12 || i3 == 11)) {
                                    e16 = UIUtils.p(e16, 270.0f);
                                }
                                if (e16 == null) {
                                    z16 = com.tencent.biz.qqstory.utils.b.a(e16, Bitmap.CompressFormat.PNG, 60, str4);
                                    bVar.f400387d.doodleRawPath = str4;
                                } else {
                                    z16 = false;
                                }
                                dVar.b(L);
                                if (e16 != L) {
                                    com.tencent.biz.qqstory.utils.b.m(e16);
                                }
                                if (e16 == null && z16) {
                                    hd0.c.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
                                    String str5 = str2;
                                    id0.a.k(str5, "create_doodle_time", 0, 0, "" + (SystemClock.uptimeMillis() - uptimeMillis));
                                    id0.a.k(str5, str, 0, 0, new String[0]);
                                    bVar.f400387d.doodlePath = str4;
                                    super.notifyResult(bVar);
                                    return;
                                }
                                hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
                                id0.a.k(str2, str, 0, -2, new String[0]);
                                bVar.f400387d.doodlePath = null;
                                super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
                                return;
                            }
                        } catch (Throwable th5) {
                            dVar.b(L);
                            throw th5;
                        }
                    }
                    str2 = "take_video";
                    if (i16 > i17) {
                        i16 = options.outHeight;
                        i17 = options.outWidth;
                    }
                    e16 = com.tencent.biz.qqstory.utils.b.e(L, i16, i17, true, false);
                    a16 = a(bVar);
                    if (a16 == 0) {
                    }
                    if (e16 == null) {
                    }
                    dVar.b(L);
                    if (e16 != L) {
                    }
                    if (e16 == null) {
                    }
                    hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
                    id0.a.k(str2, str, 0, -2, new String[0]);
                    bVar.f400387d.doodlePath = null;
                    super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
                    return;
                }
                hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
                id0.a.k("take_video", str, 0, -2, new String[0]);
                bVar.f400387d.doodlePath = null;
                super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
                return;
            } catch (OutOfMemoryError e19) {
                hd0.c.u("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", e19);
                super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
                return;
            }
        }
        hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
        bVar.f400387d.doodlePath = null;
        super.notifyResult(bVar);
    }
}
