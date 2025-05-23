package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.async.JobContext;
import fs.b;
import fs.i;
import fs.j;
import fs.o;
import fs.s;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends o<b, b> {
    private static Bitmap a(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
                try {
                    mediaMetadataRetriever.release();
                    return frameAtTime;
                } catch (RuntimeException unused) {
                    return frameAtTime;
                }
            } catch (IllegalArgumentException e16) {
                ms.a.d("AEGenerateThumbnailSegment", "getVideoThumbnailBitmap error: ", e16);
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused2) {
                    return null;
                }
            } catch (RuntimeException e17) {
                ms.a.d("AEGenerateThumbnailSegment", "getVideoThumbnailBitmap error: ", e17);
                mediaMetadataRetriever.release();
            }
        } catch (Throwable th5) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused3) {
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext jobContext, b bVar) {
        ms.a.a("AEGenerateThumbnailSegment", "start generate thumb ...");
        i iVar = bVar.f400392i;
        int i3 = iVar.f400432g;
        Bitmap a16 = a(bVar.f400386c.getSourcePath());
        if (a16 != null) {
            String a17 = s.a(bVar.f400385b, bVar.f400399p, ".jpg");
            if (new j(a16, a17, iVar.f400427b, iVar.f400428c, i3, iVar.f400430e, iVar.f400433h, iVar.f400434i, bVar.f400385b).a(new Void[0]).intValue() == 0) {
                bVar.f400393j = a17;
                bVar.f400387d.thumbPath = a17;
                ms.a.i("AEGenerateThumbnailSegment", "generate %d thumb success ...");
                super.notifyResult(bVar);
                return;
            }
            ms.a.i("AEGenerateThumbnailSegment", "generate %d thumb failed ...");
            super.notifyError(new ErrorMessage(-1, HardCodeUtil.qqStr(R.string.f172102nd2)));
            return;
        }
        ms.a.i("AEGenerateThumbnailSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null");
        super.notifyError(new ErrorMessage(-1, HardCodeUtil.qqStr(R.string.f172103nd3)));
    }
}
