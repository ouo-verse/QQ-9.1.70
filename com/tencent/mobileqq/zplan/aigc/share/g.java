package com.tencent.mobileqq.zplan.aigc.share;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&JD\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/share/g;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "e", "Lcom/tencent/mobileqq/zplan/aigc/share/bk;", "getData", "", "ugcId", "bgBitmap", "wordBitmap", "avatarBitmap", "maskBitmap", "clothBitmap", tl.h.F, "Landroid/app/Activity;", "context", "c", "b", "g", "", "action", "d", "a", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface g {
    void a(Activity context);

    void b(Activity context);

    void c(Activity context);

    void d(Activity context, int action);

    void e(Bitmap bitmap);

    void f(Activity context);

    void g(Activity context);

    SuitShareData getData();

    Bitmap h(long ugcId, Bitmap bgBitmap, Bitmap wordBitmap, Bitmap avatarBitmap, Bitmap maskBitmap, Bitmap clothBitmap);
}
