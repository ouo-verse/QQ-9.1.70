package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/c;", "", "", "startTimeUs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "b", "timeUs", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/a;", "c", "a", "release", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface c {
    void a(long timeUs);

    void b(long startTimeUs, @NotNull Bitmap bitmap);

    @Nullable
    BitmapPoint c(long timeUs);

    void release();
}
