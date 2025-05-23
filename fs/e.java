package fs;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.View;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e extends o<b, b> {

    /* renamed from: h, reason: collision with root package name */
    private boolean f400409h = false;

    /* renamed from: i, reason: collision with root package name */
    public final WeakReference<com.tencent.aelight.camera.aioeditor.takevideo.d> f400410i;

    /* renamed from: m, reason: collision with root package name */
    public final String f400411m;

    public e(com.tencent.aelight.camera.aioeditor.takevideo.d dVar, String str) {
        this.f400410i = new WeakReference<>(dVar);
        this.f400411m = str;
    }

    private Bitmap a(b bVar, Bitmap bitmap) {
        try {
            View a16 = bVar.a();
            hd0.c.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view = %s", a16);
            if (a16 == null) {
                hd0.c.g("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "filter view has been recycled.");
                return bitmap;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap);
            float width = createBitmap.getWidth();
            float height = createBitmap.getHeight();
            float width2 = a16.getWidth();
            float height2 = a16.getHeight();
            Canvas canvas = new Canvas(createBitmap);
            canvas.scale(width / width2, height / height2);
            a16.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e16) {
            hd0.c.h("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "create filterBitmap error : %s", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext jobContext, b bVar) {
        Bitmap r16;
        long uptimeMillis = SystemClock.uptimeMillis();
        String str = this.f400411m;
        if (str == null) {
            str = s.a(bVar.f400385b, bVar.f400399p, ".png");
        }
        com.tencent.aelight.camera.aioeditor.takevideo.d dVar = this.f400410i.get();
        if (dVar != null && !dVar.isEmpty() && (r16 = dVar.r()) != null) {
            bVar.f400395l.f400418d = r16;
            bVar.f400389f = true;
            Bitmap a16 = a(bVar, r16);
            if (a16 != null) {
                hd0.c.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap success %s", Integer.valueOf(System.identityHashCode(a16)));
                r16 = a16;
            } else {
                hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateFilterBitmap failed");
            }
            if (this.f400409h) {
                boolean a17 = com.tencent.biz.qqstory.utils.b.a(r16, Bitmap.CompressFormat.PNG, 60, str);
                bVar.f400389f = a17;
                bVar.f400387d.doodlePath = str;
                if (!a17) {
                    hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "Save doodle bitmap to " + str + " failed! error code = " + a17);
                }
            }
        }
        hd0.c.t("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "GenerateEditPicDoodleSegment" + bVar.f400389f + " cost " + (SystemClock.uptimeMillis() - uptimeMillis));
        super.notifyResult(bVar);
    }
}
