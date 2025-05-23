package fs;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.takevideo.x;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class l extends o<b, b> {

    /* renamed from: h, reason: collision with root package name */
    private String f400456h;

    /* renamed from: i, reason: collision with root package name */
    private final WeakReference<x> f400457i;

    /* renamed from: m, reason: collision with root package name */
    private final int f400458m;

    public l(String str, x xVar, int i3) {
        this.f400456h = str;
        this.f400457i = new WeakReference<>(xVar);
        this.f400458m = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext jobContext, b bVar) {
        Bitmap bitmap;
        x xVar;
        String str;
        int i3;
        int i16;
        float f16;
        double d16;
        double d17;
        hd0.c.b("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "start generate thumb ... mVideoIndex = %d", Integer.valueOf(this.f400458m));
        i iVar = bVar.f400392i;
        int i17 = iVar.f400432g;
        WeakReference<x> weakReference = this.f400457i;
        x xVar2 = weakReference != null ? weakReference.get() : null;
        if (xVar2 != null) {
            Bitmap m3 = xVar2.m(this.f400458m);
            if (m3 != null) {
                try {
                    String str2 = this.f400456h;
                    if (str2 == null) {
                        str2 = s.a(bVar.f400385b, bVar.f400399p, ".jpg");
                    }
                    str = str2;
                    i3 = iVar.f400427b;
                    i16 = iVar.f400428c;
                    f16 = iVar.f400430e;
                    d16 = iVar.f400433h;
                    d17 = iVar.f400434i;
                    xVar = xVar2;
                } catch (Throwable th5) {
                    th = th5;
                    bitmap = m3;
                    xVar = xVar2;
                }
                try {
                    int intValue = new j(m3, str, i3, i16, i17, f16, d16, d17, bVar.f400385b).a(new Void[0]).intValue();
                    xVar.b(m3);
                    if (intValue == 0) {
                        bVar.f400393j = str;
                        bVar.f400387d.thumbPath = str;
                        hd0.c.v("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb success ...", Integer.valueOf(this.f400458m));
                        super.notifyResult(bVar);
                        return;
                    }
                    hd0.c.v("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ...", Integer.valueOf(this.f400458m));
                    super.notifyError(new ErrorMessage(-1, HardCodeUtil.qqStr(R.string.f172102nd2) + this.f400458m));
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    bitmap = m3;
                    xVar.b(bitmap);
                    throw th;
                }
            }
            hd0.c.v("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... EditVideoPlayerExport generateVideoFrameBitmap return null", Integer.valueOf(this.f400458m));
            super.notifyError(new ErrorMessage(-1, HardCodeUtil.qqStr(R.string.f172103nd3) + this.f400458m));
            return;
        }
        hd0.c.v("Q.qqstory.publish.edit.HWEncodeGenerateThumbSegment", "generate %d thumb failed ... can not find EditVideoPlayerExport", Integer.valueOf(this.f400458m));
        super.notifyError(new ErrorMessage(-1, HardCodeUtil.qqStr(R.string.ncu) + this.f400458m));
    }
}
