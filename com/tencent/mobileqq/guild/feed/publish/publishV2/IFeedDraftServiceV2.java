package com.tencent.mobileqq.guild.feed.publish.publishV2;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H&J3\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ-\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ:\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H&\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J,\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH&\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/IFeedDraftServiceV2;", "Lmqq/app/api/IRuntimeService;", "deleteGuildFeedDraft", "", "draftId", "", "draftType", "", "draftKey", "feedDraftFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeedDraft", "peekFeedDraftCache", "Lkotlin/Result;", "peekFeedDraftCache-0E7RQCE", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Object;", "setFeedDraft", "draft", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public interface IFeedDraftServiceV2 extends IRuntimeService {
    void deleteGuildFeedDraft(@NotNull String draftId, int draftType, @NotNull String draftKey);

    @Nullable
    Object feedDraftFlow(@NotNull String str, int i3, @NotNull String str2, @NotNull Continuation<? super StateFlow<GProGuildFeedDraft>> continuation);

    @Nullable
    Object getFeedDraft(@NotNull String str, int i3, @NotNull String str2, @NotNull Continuation<? super GProGuildFeedDraft> continuation);

    @NotNull
    /* renamed from: peekFeedDraftCache-0E7RQCE, reason: not valid java name */
    Object mo185peekFeedDraftCache0E7RQCE(@NotNull String draftId, int draftType, @NotNull String draftKey);

    void setFeedDraft(@NotNull String draftId, int draftType, @NotNull String draftKey, @Nullable GProGuildFeedDraft draft);
}
