package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\nH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "listener", "", "b", "c", "", "timeMs", "tag", "", "assetPath", "Landroid/graphics/Bitmap;", "getBitmapByTime", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface d {
    @Nullable
    Bitmap a();

    void b(@NotNull f listener);

    void c(@NotNull f listener);

    @Nullable
    Bitmap getBitmapByTime(long timeMs, @Nullable Object tag, @NotNull String assetPath);
}
