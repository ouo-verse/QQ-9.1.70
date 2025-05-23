package com.tencent.mobileqq.guild.feed.batchmanage.delegate;

import androidx.core.util.Supplier;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.data.s;
import com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedCountReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedCountRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCountCallback;
import com.tencent.richframework.data.base.UIStateData;
import ij1.g;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012&\u0010\u0013\u001a\"\u0012\u001e\u0012\u001c\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u00100\u000b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR4\u0010\u0013\u001a\"\u0012\u001e\u0012\u001c\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u0018\u00010\fj\u0004\u0018\u0001`\u00100\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R5\u0010\u001d\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00180\f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/delegate/FeedBatchManageBottomOperationPartDependencyDefaultImpl;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageBottomOperationPart$a;", "", "channelId", "", "a", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/data/s;", "b", "Lcom/tencent/mobileqq/guild/data/s;", "contact", "Landroidx/core/util/Supplier;", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/g;", "Lcom/tencent/mobileqq/guild/feed/batchmanage/delegate/FeedListUIState;", "c", "Landroidx/core/util/Supplier;", "feedListUIStateProvider", "", "d", "Ljava/lang/String;", "logTag", "Ldo1/a;", "", "e", "Lkotlin/Lazy;", "()Landroidx/lifecycle/LiveData;", "feedCollectionViewState", "<init>", "(Lcom/tencent/mobileqq/guild/data/s;Landroidx/core/util/Supplier;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class FeedBatchManageBottomOperationPartDependencyDefaultImpl extends GuildFeedBatchManageBottomOperationPart.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final s contact;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<LiveData<UIStateData<List<g>>>> feedListUIStateProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedCollectionViewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetFeedCountRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a implements IGProGetFeedCountCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Integer> f218152b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GProGetFeedCountReq f218153c;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super Integer> cancellableContinuation, GProGetFeedCountReq gProGetFeedCountReq) {
            this.f218152b = cancellableContinuation;
            this.f218153c = gProGetFeedCountReq;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedCountCallback
        public final void onResult(int i3, String str, GProGetFeedCountRsp gProGetFeedCountRsp) {
            if (i3 != 0 || gProGetFeedCountRsp == null) {
                QLog.e(FeedBatchManageBottomOperationPartDependencyDefaultImpl.this.logTag, 1, "GetFeedCount|result=" + i3 + ", errMsg=" + str);
                this.f218152b.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            String str2 = FeedBatchManageBottomOperationPartDependencyDefaultImpl.this.logTag;
            GProGetFeedCountReq gProGetFeedCountReq = this.f218153c;
            QLog.i(str2, 1, "GetFeedCount|guildId=" + gProGetFeedCountReq.guildId + " channelId=" + gProGetFeedCountReq.channelId + " feedCount=" + gProGetFeedCountRsp.feedCount);
            CancellableContinuation<Integer> cancellableContinuation = this.f218152b;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(Integer.valueOf(gProGetFeedCountRsp.getFeedCount())));
        }
    }

    public FeedBatchManageBottomOperationPartDependencyDefaultImpl(@NotNull s contact, @NotNull Supplier<LiveData<UIStateData<List<g>>>> feedListUIStateProvider) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(feedListUIStateProvider, "feedListUIStateProvider");
        this.contact = contact;
        this.feedListUIStateProvider = feedListUIStateProvider;
        this.logTag = "FeedBatchManagement.BottomOperation";
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new FeedBatchManageBottomOperationPartDependencyDefaultImpl$feedCollectionViewState$2(this));
        this.feedCollectionViewState = lazy;
    }

    static /* synthetic */ Object h(FeedBatchManageBottomOperationPartDependencyDefaultImpl feedBatchManageBottomOperationPartDependencyDefaultImpl, long j3, Continuation<? super Integer> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        GProGetFeedCountReq gProGetFeedCountReq = new GProGetFeedCountReq();
        gProGetFeedCountReq.guildId = MiscKt.l(feedBatchManageBottomOperationPartDependencyDefaultImpl.contact.getGuildId());
        gProGetFeedCountReq.channelId = j3;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        o c16 = l.c();
        if (c16 != null) {
            c16.getFeedCount(gProGetFeedCountReq, new a(cancellableContinuationImpl, gProGetFeedCountReq));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart.a
    @Nullable
    public Object a(long j3, @NotNull Continuation<? super Integer> continuation) {
        return h(this, j3, continuation);
    }

    @Override // com.tencent.mobileqq.guild.feed.batchmanage.part.GuildFeedBatchManageBottomOperationPart.a
    @NotNull
    public LiveData<do1.a<? extends Collection<?>, Integer>> b() {
        Object value = this.feedCollectionViewState.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-feedCollectionViewState>(...)");
        return (LiveData) value;
    }
}
