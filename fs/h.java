package fs;

import android.app.Activity;
import android.graphics.BitmapFactory;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.async.JobContext;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h extends o<b, b> {

    /* renamed from: h, reason: collision with root package name */
    public WeakReference<Activity> f400424h;

    /* renamed from: i, reason: collision with root package name */
    private int f400425i;

    public h(Activity activity, int i3) {
        this.f400424h = new WeakReference<>(activity);
        this.f400425i = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext jobContext, b bVar) {
        Activity activity = this.f400424h.get();
        if (activity == null) {
            hd0.c.g("Q.qqstory.publish.edit.GeneratePicThumbSegment", "ChangePicArgToVideoArgSegment, activity is null");
            super.notifyError(new ErrorMessage(-1, "ChangePicArgToVideoArgSegment error"));
            return;
        }
        g gVar = bVar.f400395l;
        String str = gVar.f400415a;
        if (!gVar.f400422h && gVar.f400421g) {
            str = gVar.f400416b;
        }
        String str2 = str;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str2, options);
        bVar.f400392i = new i(activity, options.outWidth, options.outHeight, str2, 0.0f, this.f400425i == 5, 0, 0.0d, 0.0d, null, false);
        bVar.f400393j = str2;
        super.notifyResult(bVar);
    }
}
