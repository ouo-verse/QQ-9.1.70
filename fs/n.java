package fs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;

/* compiled from: P */
/* loaded from: classes38.dex */
public class n extends o<b, b> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext jobContext, b bVar) {
        int i3 = (UIUtils.i(BaseApplication.getContext()) * 720) / UIUtils.j(BaseApplication.getContext());
        if (i3 % 2 != 0) {
            i3++;
        }
        g gVar = bVar.f400395l;
        String str = gVar.f400415a;
        if (!gVar.f400422h && gVar.f400421g) {
            str = gVar.f400416b;
        }
        try {
            Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(str, new BitmapFactory.Options());
            if (decodeFileWithBufferedStream == null) {
                hd0.c.t("Q.qqstory.publish.edit.MakeStoryPicSegment", "aioBitmap is null please check!");
                super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 0));
                return;
            }
            boolean z16 = (bVar.f400384a.C == decodeFileWithBufferedStream.getHeight() && bVar.f400384a.f204060m == decodeFileWithBufferedStream.getWidth()) ? false : true;
            if (decodeFileWithBufferedStream.getWidth() > 720 || decodeFileWithBufferedStream.getHeight() > i3) {
                float min = Math.min(720 / decodeFileWithBufferedStream.getWidth(), i3 / decodeFileWithBufferedStream.getHeight());
                decodeFileWithBufferedStream = com.tencent.biz.qqstory.utils.b.q(decodeFileWithBufferedStream, min, true);
                hd0.c.c("Q.qqstory.publish.edit.MakeStoryPicSegment", "scale by %s, aioBitmap=%s", Float.valueOf(min), decodeFileWithBufferedStream);
                if (decodeFileWithBufferedStream == null) {
                    notifyError(new BitmapError("resizeBitmapByScale failed", -1));
                    return;
                }
            }
            hd0.c.a("Q.qqstory.publish.edit.MakeStoryPicSegment", "current bitmap size " + decodeFileWithBufferedStream.getWidth() + ", " + decodeFileWithBufferedStream.getHeight() + "destWidth: 720 destHeight: " + i3);
            if (z16) {
                decodeFileWithBufferedStream = com.tencent.biz.qqstory.utils.b.e(decodeFileWithBufferedStream, 720, i3, false, true);
            }
            if (decodeFileWithBufferedStream == null) {
                notifyError(new BitmapError("fillBitmapEdge failed", -1));
                return;
            }
            if (decodeFileWithBufferedStream.getHeight() % 2 != 0 || decodeFileWithBufferedStream.getWidth() % 2 != 0) {
                decodeFileWithBufferedStream = Bitmap.createScaledBitmap(decodeFileWithBufferedStream, (decodeFileWithBufferedStream.getWidth() >> 1) << 1, (decodeFileWithBufferedStream.getHeight() >> 1) << 1, false);
            }
            String a16 = s.a(bVar.f400385b, bVar.f400399p, ".jpg");
            com.tencent.biz.qqstory.utils.b.b(decodeFileWithBufferedStream, a16);
            decodeFileWithBufferedStream.recycle();
            bVar.f400387d.thumbPath = a16;
            super.notifyResult(bVar);
        } catch (OutOfMemoryError e16) {
            hd0.c.u("Q.qqstory.publish.edit.MakeStoryPicSegment", "decodeFileWithBufferedStream failed", e16);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.MakeStoryPicSegment", 6));
        }
    }
}
