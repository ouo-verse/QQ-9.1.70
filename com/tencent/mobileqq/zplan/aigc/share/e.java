package com.tencent.mobileqq.zplan.aigc.share;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&Js\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u001bH&J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/share/e;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "e", "Lcom/tencent/mobileqq/zplan/aigc/share/m;", "getData", "bgBitmap", "maskBitmap", "avatarBitmap", "", "itemBitmaps", "itemBgBitmaps", "goodLookBubbleBitmap", "veryGoodLookBubbleBitmap", "", "createTs", "", "nickName", tl.h.F, "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/util/List;Ljava/util/List;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/Long;Ljava/lang/String;)Landroid/graphics/Bitmap;", "Landroid/app/Activity;", "context", "c", "b", "g", "", "action", "d", "a", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface e {
    void a(Activity context);

    void b(Activity context);

    void c(Activity context);

    void d(Activity context, int action);

    void e(Bitmap bitmap);

    void f(Activity context);

    void g(Activity context);

    SuitOutfitShareData getData();

    Bitmap h(Bitmap bgBitmap, Bitmap maskBitmap, Bitmap avatarBitmap, List<Bitmap> itemBitmaps, List<Bitmap> itemBgBitmaps, Bitmap goodLookBubbleBitmap, Bitmap veryGoodLookBubbleBitmap, Long createTs, String nickName);
}
