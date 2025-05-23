package fs;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f extends o<b, b> {

    /* renamed from: h, reason: collision with root package name */
    private final String f400412h;

    /* renamed from: i, reason: collision with root package name */
    public WeakReference<com.tencent.aelight.camera.aioeditor.takevideo.d> f400413i;

    public f() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6 A[Catch: all -> 0x0048, TryCatch #2 {all -> 0x0048, blocks: (B:17:0x0044, B:18:0x0061, B:20:0x0069, B:22:0x006f, B:25:0x0086, B:29:0x0096, B:32:0x009c, B:34:0x00a4, B:36:0x00aa, B:37:0x00b0, B:39:0x00b6, B:41:0x00bc, B:43:0x00c9, B:45:0x00d4, B:47:0x00da, B:51:0x00e9, B:52:0x00f0, B:55:0x008c, B:56:0x0075, B:58:0x007d, B:65:0x004c), top: B:16:0x0044, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc A[Catch: all -> 0x0048, TryCatch #2 {all -> 0x0048, blocks: (B:17:0x0044, B:18:0x0061, B:20:0x0069, B:22:0x006f, B:25:0x0086, B:29:0x0096, B:32:0x009c, B:34:0x00a4, B:36:0x00aa, B:37:0x00b0, B:39:0x00b6, B:41:0x00bc, B:43:0x00c9, B:45:0x00d4, B:47:0x00da, B:51:0x00e9, B:52:0x00f0, B:55:0x008c, B:56:0x0075, B:58:0x007d, B:65:0x004c), top: B:16:0x0044, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f0 A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #2 {all -> 0x0048, blocks: (B:17:0x0044, B:18:0x0061, B:20:0x0069, B:22:0x006f, B:25:0x0086, B:29:0x0096, B:32:0x009c, B:34:0x00a4, B:36:0x00aa, B:37:0x00b0, B:39:0x00b6, B:41:0x00bc, B:43:0x00c9, B:45:0x00d4, B:47:0x00da, B:51:0x00e9, B:52:0x00f0, B:55:0x008c, B:56:0x0075, B:58:0x007d, B:65:0x004c), top: B:16:0x0044, inners: #0, #1, #3 }] */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void runSegment(JobContext jobContext, b bVar) {
        Bitmap bitmap;
        EditVideoParams.EditSource editSource = bVar.f400386c;
        if (!(editSource instanceof EditLocalVideoSource) && !(editSource instanceof EditTakeVideoSource)) {
            hd0.c.v("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "parameters error : %s", editSource);
        } else {
            String str = this.f400412h;
            if (str == null) {
                str = s.a(bVar.f400385b, bVar.f400399p, ".jpg");
            }
            EditVideoParams.EditSource editSource2 = bVar.f400386c;
            long j3 = 0;
            long j16 = editSource2 instanceof EditLocalVideoSource ? ((EditLocalVideoSource) editSource2).f204045f : 0L;
            String sourcePath = editSource2.getSourcePath();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(sourcePath);
                } catch (IllegalArgumentException e16) {
                    hd0.c.h("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "Video Source is Invalid ! " + sourcePath, e16);
                }
                if (bVar.f400392i.f400431f) {
                    EditVideoParams.EditSource editSource3 = bVar.f400386c;
                    if (editSource3 instanceof EditLocalVideoSource) {
                        j3 = ((EditLocalVideoSource) editSource3).f204046h;
                    } else {
                        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                        if (extractMetadata != null) {
                            j3 = Long.valueOf(extractMetadata).longValue();
                        }
                    }
                    try {
                        bitmap = mediaMetadataRetriever.getFrameAtTime(j3 * 1000);
                    } catch (OutOfMemoryError e17) {
                        hd0.c.h("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime endTime * 1000L oom", e17);
                    }
                    if (bitmap == null) {
                        try {
                            bitmap = mediaMetadataRetriever.getFrameAtTime(1000 * j16);
                        } catch (OutOfMemoryError e18) {
                            hd0.c.h("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime startTime * 1000L oom", e18);
                        }
                    }
                    if (bitmap != null && bVar.f400387d.videoNeedRotate) {
                        bitmap = UIUtils.p(bitmap, 90.0f);
                    }
                    if (bVar.f400386c instanceof EditTakeVideoSource) {
                        bitmap = a(bVar, bitmap);
                    }
                    if (bitmap == null) {
                        boolean a16 = com.tencent.biz.qqstory.utils.b.a(bitmap, Bitmap.CompressFormat.JPEG, 80, str);
                        bitmap.recycle();
                        if (a16) {
                            File file = new File(str);
                            if (file.exists() && file.isFile()) {
                                hd0.c.b("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "success : %s", str);
                                bVar.f400393j = str;
                                super.notifyResult(bVar);
                                return;
                            }
                        } else {
                            hd0.c.t("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "compressToFile error");
                        }
                    } else {
                        hd0.c.v("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime error : startTime = %s", Long.valueOf(j16));
                    }
                }
                bitmap = null;
                if (bitmap == null) {
                }
                if (bitmap != null) {
                    bitmap = UIUtils.p(bitmap, 90.0f);
                }
                if (bVar.f400386c instanceof EditTakeVideoSource) {
                }
                if (bitmap == null) {
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        }
        notifyError(new ErrorMessage(-1, "GenerateLocalVideoSegment error"));
    }

    public f(String str) {
        this.f400412h = str;
    }

    private Bitmap a(b bVar, Bitmap bitmap) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        mr.a aVar = new mr.a();
        aVar.c(bitmap.getWidth(), bitmap.getHeight());
        WeakReference<com.tencent.aelight.camera.aioeditor.takevideo.d> weakReference = this.f400413i;
        if (weakReference != null && weakReference.get() != null) {
            try {
                bitmap2 = this.f400413i.get().V().t0(0);
            } catch (Exception e16) {
                hd0.c.g("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, read mosaic bitmap " + e16.toString());
            }
        }
        if (bitmap2 != null) {
            com.tencent.mobileqq.filter.c cVar = (com.tencent.mobileqq.filter.c) com.tencent.mobileqq.filter.a.a(106);
            cVar.c(bitmap2);
            cVar.init();
            Bitmap g16 = aVar.g(bitmap, cVar);
            hd0.c.b("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", g16);
            if (g16 != null) {
                bitmap = g16;
            }
            cVar.destroy();
        }
        aVar.b();
        return bitmap;
    }
}
