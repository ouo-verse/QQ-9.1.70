package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "i", "", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a extends h {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7760a {
        public static int a(@NotNull a aVar) {
            return h.a.a(aVar);
        }
    }

    boolean e();

    @NotNull
    LongFeedUIData i(@NotNull LongFeedParseParam parseParam);
}
