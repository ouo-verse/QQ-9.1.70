package com.tencent.mobileqq.guild.feed.widget.comment;

import android.text.Spannable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/comment/e;", "", "", "id", "Landroid/text/Spannable;", "c", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "draft", "mediaInfo", "", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface e {
    @Nullable
    LocalMediaInfo a(@Nullable String id5);

    void b(@Nullable String id5, @NotNull Spannable draft, @Nullable LocalMediaInfo mediaInfo);

    @NotNull
    Spannable c(@Nullable String id5);
}
