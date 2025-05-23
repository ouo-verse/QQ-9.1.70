package com.tencent.mobileqq.guild.feed.part.notice;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoLikeCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&J4\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/notice/f;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStNotice;", "stNotice", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "comment", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "reply", "", "isInGuildNotice", "", "e6", "mStNotice", "gProStReply", "", "status", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoLikeCallback;", "cb", "l8", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface f {
    void e6(@NotNull GProStNotice stNotice, @NotNull GProStComment comment, @Nullable GProStReply reply, boolean isInGuildNotice);

    void l8(@NotNull GProStNotice mStNotice, @NotNull GProStComment comment, @Nullable GProStReply gProStReply, int status, @Nullable IGProDoLikeCallback cb5);
}
