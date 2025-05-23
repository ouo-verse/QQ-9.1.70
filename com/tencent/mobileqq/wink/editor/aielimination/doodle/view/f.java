package com.tencent.mobileqq.wink.editor.aielimination.doodle.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0000H&J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/f;", "", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/e;", "doodleItem", "Landroid/graphics/Paint;", "paint", "", DownloadInfo.spKey_Config, "copy", "Landroid/graphics/Canvas;", PM.CANVAS, "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/c;", "doodle", "drawHelpers", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface f {
    void config(@Nullable e doodleItem, @Nullable Paint paint);

    @Nullable
    f copy();

    void drawHelpers(@Nullable Canvas canvas, @Nullable c doodle);
}
