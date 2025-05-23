package com.tencent.qqnt;

import android.graphics.drawable.Drawable;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H&J$\u0010\u000e\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/b;", "", "", "e0", "delete", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "info", "f0", "", "h0", "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "g0", "i0", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface b {
    void delete();

    void e0();

    void f0(@NotNull SystemAndEmojiEmotionInfo info);

    void g0(@Nullable SystemAndEmojiEmotionInfo oldInfo, @NotNull SystemAndEmojiEmotionInfo newInfo, @Nullable Drawable d16);

    boolean h0(@NotNull SystemAndEmojiEmotionInfo info);

    void i0(@Nullable SystemAndEmojiEmotionInfo info);
}
