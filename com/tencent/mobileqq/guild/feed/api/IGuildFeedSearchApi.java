package com.tencent.mobileqq.guild.feed.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00030\u0002H&J.\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\tH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedSearchApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "Lzg1/c;", "Lzg1/b;", "getFeedSearchListAdapterDelegates", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "gproStFeed", "", "", "highlightKeywords", "traceId", "Lzg1/a;", "convertToFeedItem", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildFeedSearchApi extends QRouteApi {
    @Nullable
    zg1.a convertToFeedItem(@Nullable GProStFeed gproStFeed, @Nullable Collection<String> highlightKeywords, @NotNull String traceId);

    @NotNull
    List<zg1.c<zg1.b<?>>> getFeedSearchListAdapterDelegates();
}
