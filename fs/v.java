package fs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.aelight.camera.aioeditor.takevideo.ai;
import com.tencent.aelight.camera.zplan.api.impl.ZPlanPortraitImageView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003H\u0002J \u0010\u0012\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0014R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lfs/v;", "Lfs/o;", "Lfs/b;", "", "originPath", "Landroid/graphics/Bitmap;", "a", "originBitmap", "", "newWidth", "newHeight", "d", "errMsg", "", "b", "Lcom/tribe/async/async/JobContext;", "p0", "p1", "c", "Lcom/tencent/aelight/camera/aioeditor/takevideo/ai;", tl.h.F, "Lcom/tencent/aelight/camera/aioeditor/takevideo/ai;", "picRawImageExport", "<init>", "(Lcom/tencent/aelight/camera/aioeditor/takevideo/ai;)V", "i", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class v extends o<b, b> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ai picRawImageExport;

    public v(ai aiVar) {
        this.picRawImageExport = aiVar;
    }

    private final Bitmap a(String originPath) {
        ai aiVar = this.picRawImageExport;
        if (aiVar == null) {
            return null;
        }
        ZPlanPortraitImageView e06 = aiVar.e0();
        Matrix imageMatrix = e06.getImageMatrix();
        RectF mRestrictInRect = e06.getMRestrictInRect();
        Matrix z16 = this.picRawImageExport.z();
        Matrix matrix = new Matrix();
        z16.invert(matrix);
        matrix.postConcat(imageMatrix);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        Bitmap srcBitmap = SafeBitmapFactory.safeDecode(originPath, options);
        Intrinsics.checkNotNullExpressionValue(srcBitmap, "srcBitmap");
        Bitmap d16 = d(srcBitmap, e06.getWidth(), e06.getHeight());
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        Rect rect = new Rect();
        RectF rectF = new RectF();
        matrix2.mapRect(rectF, mRestrictInRect);
        rectF.round(rect);
        return Bitmap.createBitmap(d16, rect.left, rect.top, rect.width(), rect.height());
    }

    private final void b(String errMsg) {
        QLog.e("ZPlanCropPicSegment", 1, errMsg);
        notifyError(new ErrorMessage(-1, errMsg));
    }

    private final Bitmap d(Bitmap originBitmap, int newWidth, int newHeight) {
        int width = originBitmap.getWidth();
        int height = originBitmap.getHeight();
        if (width == newWidth && height == newHeight) {
            return originBitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(newWidth / width, newHeight / height);
        Bitmap createBitmap = Bitmap.createBitmap(originBitmap, 0, 0, width, height, matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(originBitma\u2026th, height, matrix, true)");
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext<?> p06, b p16) {
        if (p16 == null) {
            b("GenerateContext null");
            return;
        }
        g gVar = p16.f400395l;
        if (gVar == null) {
            b("picArgs null.");
            return;
        }
        String originPath = gVar.f400416b;
        if (originPath == null || originPath.length() == 0) {
            b("origin pic path empty.");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(originPath, "originPath");
        Bitmap a16 = a(originPath);
        String a17 = s.a(p16.f400385b, p16.f400399p, ".png");
        Intrinsics.checkNotNullExpressionValue(a17, "generateCacheFilePath(bu\u2026, mUploadTempDir, \".png\")");
        boolean a18 = com.tencent.biz.qqstory.utils.b.a(a16, Bitmap.CompressFormat.PNG, 100, a17);
        if (a16 != null) {
            a16.recycle();
        }
        if (!a18) {
            b("compress bitmap to file failed.");
        } else {
            p16.f400395l.f400416b = a17;
            super.notifyResult(p16);
        }
    }
}
