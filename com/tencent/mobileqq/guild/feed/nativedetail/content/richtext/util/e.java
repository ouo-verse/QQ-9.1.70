package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util;

import android.text.Layout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/util/e;", "", "", "location", "", "getLocationInWindow", "a", "Landroid/text/Layout;", "getLayout", "()Landroid/text/Layout;", TtmlNode.TAG_LAYOUT, "", "getText", "()Ljava/lang/CharSequence;", "text", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface e {
    void a(@NotNull int[] location);

    @Nullable
    Layout getLayout();

    void getLocationInWindow(@NotNull int[] location);

    @Nullable
    CharSequence getText();
}
