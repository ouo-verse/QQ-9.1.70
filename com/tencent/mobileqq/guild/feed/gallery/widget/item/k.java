package com.tencent.mobileqq.guild.feed.gallery.widget.item;

import android.content.Context;
import android.view.MotionEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/k;", "", "", "from", "", "positionX", "positionY", "", "b", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "Landroid/view/MotionEvent;", "event", "c", "Landroid/content/Context;", "context", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface k {
    void a(@NotNull Context context, @NotNull String from);

    void b(@NotNull String from, @Nullable Float positionX, @Nullable Float positionY);

    void c(@NotNull String from, @Nullable MotionEvent event);
}
