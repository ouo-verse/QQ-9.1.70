package fs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobContext;

/* compiled from: P */
/* loaded from: classes38.dex */
public class u extends o<b, b> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext jobContext, b bVar) {
        int i3;
        int i16;
        System.currentTimeMillis();
        int l3 = (UIUtils.l(BaseApplication.getContext()) * 720) / UIUtils.m(BaseApplication.getContext());
        if (l3 % 2 != 0) {
            l3++;
        }
        g gVar = bVar.f400395l;
        String str = gVar.f400415a;
        if (!gVar.f400422h && gVar.f400421g) {
            str = gVar.f400416b;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BaseImageUtil.decodeFileWithBufferedStream(str, options);
            if (!(bVar.f400386c instanceof EditLocalPhotoSource) && (i3 = options.outWidth) <= 720 && (i16 = options.outHeight) <= l3 && i3 % 2 == 0 && i16 % 2 == 0) {
                hd0.c.o("Q.qqstory.publish.edit.ResizeBitmapSegment", "no need resize. srcWidth=%s, srcHeight=%s, destWidth=%s, destHeight=%s", Integer.valueOf(i3), Integer.valueOf(options.outHeight), 720, Integer.valueOf(l3));
                super.notifyResult(bVar);
                return;
            }
            Bitmap bitmap = bVar.f400395l.f400417c;
            if (bitmap == null) {
                hd0.c.t("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap is null please check!");
                super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 0));
                return;
            }
            hd0.c.c("Q.qqstory.publish.edit.ResizeBitmapSegment", "srcBitmap width=%s, height=%s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            Bitmap p16 = com.tencent.biz.qqstory.utils.b.p(bitmap, 720, l3, false, false);
            if (p16 == null) {
                super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 5));
                return;
            }
            g gVar2 = bVar.f400395l;
            gVar2.f400422h = false;
            gVar2.f400421g = true;
            String a16 = s.a(bVar.f400385b, bVar.f400399p, ".jpg");
            com.tencent.biz.qqstory.utils.b.b(p16, a16);
            if (bitmap != p16) {
                p16.recycle();
                hd0.c.t("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge recycle bitmap");
            } else {
                hd0.c.t("Q.qqstory.publish.edit.ResizeBitmapSegment", "BitmapUtils.resizeAndFillBitmapEdge do not recycle bitmap");
            }
            bVar.f400395l.f400416b = a16;
            super.notifyResult(bVar);
        } catch (OutOfMemoryError e16) {
            hd0.c.u("Q.qqstory.publish.edit.ResizeBitmapSegment", "decode image failed", e16);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.ResizeBitmapSegment", 6));
        }
    }
}
