package fs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends o<b, b> implements xc0.a {
    public final int C;

    /* renamed from: h, reason: collision with root package name */
    public final WeakReference<com.tencent.aelight.camera.aioeditor.takevideo.d> f400406h;

    /* renamed from: i, reason: collision with root package name */
    public final WeakReference<com.tencent.aelight.camera.aioeditor.takevideo.e> f400407i;

    /* renamed from: m, reason: collision with root package name */
    public final String f400408m;

    public d(com.tencent.aelight.camera.aioeditor.takevideo.d dVar, com.tencent.aelight.camera.aioeditor.takevideo.e eVar, int i3) {
        this(dVar, eVar, null, i3);
    }

    public d(com.tencent.aelight.camera.aioeditor.takevideo.d dVar, com.tencent.aelight.camera.aioeditor.takevideo.e eVar, String str, int i3) {
        if (dVar != null) {
            this.f400406h = new WeakReference<>(dVar);
            this.f400407i = new WeakReference<>(eVar);
            this.f400408m = str;
            this.C = i3;
            return;
        }
        throw new NullPointerException("doodleLayout should not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext jobContext, b bVar) {
        int i3;
        long uptimeMillis = SystemClock.uptimeMillis();
        String str = bVar.f400393j;
        if (TextUtils.isEmpty(str)) {
            super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
            id0.a.k("take_video", "create_doodle_result", 0, -1, new String[0]);
            return;
        }
        com.tencent.aelight.camera.aioeditor.takevideo.d dVar = this.f400406h.get();
        com.tencent.aelight.camera.aioeditor.takevideo.e eVar = this.f400407i.get();
        if (dVar != null && (!dVar.O(this.C) || (eVar != null && eVar.F(this.C)))) {
            Bitmap L = dVar.L(this.C, true);
            String str2 = this.f400408m;
            if (str2 == null) {
                str2 = s.a(bVar.f400385b, bVar.f400399p, ".png");
            }
            if (L != null) {
                if (eVar != null) {
                    try {
                        if (eVar.F(this.C)) {
                            eVar.Y(this.C, new Canvas(L), L.getWidth(), L.getHeight());
                        }
                    } catch (OutOfMemoryError e16) {
                        hd0.c.u("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "decode video thumb failed %s", e16);
                        super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", 6));
                        return;
                    } finally {
                        dVar.b(L);
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BaseImageUtil.decodeFileWithBufferedStream(str, options);
                int i16 = options.outWidth;
                int i17 = options.outHeight;
                EditVideoParams editVideoParams = bVar.f400384a;
                boolean z16 = (editVideoParams.f204055d == 14 && editVideoParams.q() && bVar.f400384a.f204059i.getWidth() < bVar.f400384a.f204059i.getHeight()) || bVar.f400384a.f204055d != 14;
                if (i16 > i17 && z16) {
                    i16 = options.outHeight;
                    i17 = options.outWidth;
                }
                Bitmap e17 = com.tencent.biz.qqstory.utils.b.e(L, i16, i17, true, false);
                int a16 = k.a(bVar);
                if (a16 != 0) {
                    e17 = UIUtils.p(e17, a16);
                } else if (options.outWidth > options.outHeight && ((i3 = bVar.f400385b) == 12 || i3 == 11)) {
                    e17 = UIUtils.p(e17, 270.0f);
                }
                boolean a17 = e17 != null ? com.tencent.biz.qqstory.utils.b.a(e17, Bitmap.CompressFormat.PNG, 60, str2) : false;
                if (e17 != L) {
                    com.tencent.biz.qqstory.utils.b.m(e17);
                }
                if (e17 != null && a17) {
                    hd0.c.a("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and crop original doodle image success");
                    id0.a.k("take_video", "create_doodle_time", 0, 0, "" + (SystemClock.uptimeMillis() - uptimeMillis));
                    id0.a.k("take_video", "create_doodle_result", 0, 0, new String[0]);
                    bVar.f400387d.putExtra("dynamic_Sticker_image_path", str2);
                    super.notifyResult(bVar);
                    return;
                }
                hd0.c.t("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "resize and save doodle image failed");
                id0.a.k("take_video", "create_doodle_result", 0, -2, new String[0]);
                super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
                return;
            }
            hd0.c.t("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "get doodle bitmap failed");
            id0.a.k("take_video", "create_doodle_result", 0, -2, new String[0]);
            super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
            return;
        }
        hd0.c.t("Q.qqstory.publish.edit.GenerateDynamicDoodleImage", "do not generate doodle image because doodle is empty");
        super.notifyResult(bVar);
    }
}
