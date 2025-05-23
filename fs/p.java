package fs;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;

/* compiled from: P */
/* loaded from: classes38.dex */
public class p extends o<b, b> {

    /* renamed from: h, reason: collision with root package name */
    private boolean f400463h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f400464i;

    /* renamed from: m, reason: collision with root package name */
    public final String f400465m;

    public p(boolean z16) {
        this(z16, null);
    }

    private static Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 == null) {
            return bitmap;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            canvas.drawBitmap(bitmap2, 20.0f, (bitmap.getHeight() - 20) - bitmap2.getHeight(), (Paint) null);
            return createBitmap;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qqstory.publish.edit.MergePicSegment", 2, e16, new Object[0]);
            }
            return bitmap;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.qqstory.publish.edit.MergePicSegment", 2, e17, new Object[0]);
            }
            return bitmap;
        }
    }

    private Bitmap b(Bitmap bitmap) {
        int l3 = (UIUtils.l(BaseApplication.getContext()) * 720) / UIUtils.m(BaseApplication.getContext());
        if (l3 % 2 != 0) {
            l3++;
        }
        return com.tencent.biz.qqstory.utils.b.p(bitmap, 720, l3, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext jobContext, b bVar) {
        boolean z16;
        Bitmap b16;
        String str = this.f400465m;
        if (str == null) {
            str = s.a(bVar.f400385b, bVar.f400399p, ".jpg");
        }
        int exifOrientation = BaseImageUtil.getExifOrientation(bVar.f400395l.f400415a);
        boolean z17 = false;
        if (this.f400463h && bVar.f400389f) {
            hd0.c.a("Q.qqstory.publish.edit.MergePicSegment", "merge has doodle");
            try {
                g gVar = bVar.f400395l;
                Bitmap bitmap = gVar.f400417c;
                Bitmap bitmap2 = gVar.f400418d;
                int i3 = bVar.f400385b;
                if (i3 != 2 && i3 != 5 && i3 != 6) {
                    float height = (bitmap.getHeight() * 1.0f) / bitmap.getWidth();
                    float height2 = (bitmap2.getHeight() * 1.0f) / bitmap2.getWidth();
                    if (((bitmap.getWidth() > bitmap.getHeight() && bitmap2.getWidth() < bitmap2.getHeight()) || Math.abs(height - height2) > 0.1d) && (b16 = b(bitmap)) != null) {
                        bitmap = b16;
                    }
                }
                Bitmap a16 = a(com.tencent.biz.qqstory.utils.b.j(bitmap, bitmap2), this.f400464i);
                if (a16 != null) {
                    z16 = com.tencent.biz.qqstory.utils.b.b(a16, str);
                }
            } catch (Throwable th5) {
                hd0.c.g("Q.qqstory.publish.edit.MergePicSegment", "merge err: " + th5 + th5.getStackTrace());
            }
            z16 = false;
            str = null;
        } else {
            g gVar2 = bVar.f400395l;
            if (gVar2.f400420f > 0) {
                hd0.c.a("Q.qqstory.publish.edit.MergePicSegment", "merge use display");
                Bitmap a17 = a(bVar.f400395l.f400417c, this.f400464i);
                if (a17 == null || a17.isRecycled()) {
                    if (a17 == null) {
                        hd0.c.g("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is null");
                    } else if (a17.isRecycled()) {
                        hd0.c.g("Q.qqstory.publish.edit.MergePicSegment", "mergeBitmap is recycled");
                    }
                    z16 = false;
                    str = null;
                } else {
                    z16 = com.tencent.biz.qqstory.utils.b.b(a17, str);
                }
            } else if (gVar2.f400419e) {
                z16 = com.tencent.biz.qqstory.utils.b.b(gVar2.f400417c, str);
            } else if (exifOrientation != 0 && exifOrientation % 90 == 0) {
                hd0.c.a("Q.qqstory.publish.edit.MergePicSegment", "save rotate bitmap");
                z16 = com.tencent.biz.qqstory.utils.b.b(bVar.f400395l.f400417c, str);
            } else {
                hd0.c.a("Q.qqstory.publish.edit.MergePicSegment", "merge use origin");
                str = bVar.f400395l.f400415a;
                id0.b.f("0X80075C9");
                bVar.f400395l.f400422h = false;
                z17 = true;
                z16 = false;
            }
        }
        if (!z17 && !z16) {
            hd0.c.g("Q.qqstory.publish.edit.MergePicSegment", "save err");
            super.notifyError(new ErrorMessage(-1, HardCodeUtil.qqStr(R.string.o0l)));
        } else {
            g gVar3 = bVar.f400395l;
            gVar3.f400416b = str;
            gVar3.f400421g = z16;
            super.notifyResult(bVar);
        }
    }

    public p(String str) {
        this(true, str);
    }

    public p(boolean z16, String str) {
        this.f400463h = z16;
        this.f400465m = str;
    }

    public p(String str, boolean z16, Bitmap bitmap) {
        this(z16, str);
        this.f400464i = bitmap;
    }
}
