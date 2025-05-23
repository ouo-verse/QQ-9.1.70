package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler$Companion$fetchShareFeedInfo$1", f = "ShareFeedActionHandler.kt", i = {0, 1}, l = {128, 129}, m = "invokeSuspend", n = {"fetchCreateShareDef", "shareUrlResult"}, s = {"L$0", "L$0"})
/* loaded from: classes13.dex */
public final class ShareFeedActionHandler$Companion$fetchShareFeedInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $block;
    final /* synthetic */ String $fromTag;
    final /* synthetic */ PanelContext<Activity, vk1.b> $panelContext;
    final /* synthetic */ ShareFeedActionHandler.Companion.ReqHandleArgs $reqArgs;
    final /* synthetic */ GuildFeedArkShareInfo $shareArkInfo;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/ShareFeedActionHandler$Companion$a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler$Companion$fetchShareFeedInfo$1$2", f = "ShareFeedActionHandler.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler$Companion$fetchShareFeedInfo$1$2, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ShareFeedActionHandler.Companion.FetchShareUrlResult>, Object> {
        final /* synthetic */ GuildFeedArkShareInfo $shareArkInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(GuildFeedArkShareInfo guildFeedArkShareInfo, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$shareArkInfo = guildFeedArkShareInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$shareArkInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ShareFeedActionHandler.Companion companion = ShareFeedActionHandler.INSTANCE;
                GuildFeedArkShareInfo guildFeedArkShareInfo = this.$shareArkInfo;
                this.label = 1;
                obj = companion.k(guildFeedArkShareInfo, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ShareFeedActionHandler.Companion.FetchShareUrlResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler$Companion$fetchShareFeedInfo$1$3", f = "ShareFeedActionHandler.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler$Companion$fetchShareFeedInfo$1$3, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PanelContext<Activity, vk1.b> $panelContext;
        final /* synthetic */ GuildFeedArkShareInfo $shareArkInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PanelContext<Activity, vk1.b> panelContext, GuildFeedArkShareInfo guildFeedArkShareInfo, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$panelContext = panelContext;
            this.$shareArkInfo = guildFeedArkShareInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass3(this.$panelContext, this.$shareArkInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Object h16;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ShareFeedActionHandler.Companion companion = ShareFeedActionHandler.INSTANCE;
                vk1.b j3 = this.$panelContext.j();
                GuildFeedArkShareInfo guildFeedArkShareInfo = this.$shareArkInfo;
                this.label = 1;
                h16 = companion.h(j3, guildFeedArkShareInfo, this);
                if (h16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShareFeedActionHandler$Companion$fetchShareFeedInfo$1(GuildFeedArkShareInfo guildFeedArkShareInfo, ShareFeedActionHandler.Companion.ReqHandleArgs reqHandleArgs, PanelContext<Activity, vk1.b> panelContext, Function1<? super Boolean, Unit> function1, String str, Continuation<? super ShareFeedActionHandler$Companion$fetchShareFeedInfo$1> continuation) {
        super(2, continuation);
        this.$shareArkInfo = guildFeedArkShareInfo;
        this.$reqArgs = reqHandleArgs;
        this.$panelContext = panelContext;
        this.$block = function1;
        this.$fromTag = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ShareFeedActionHandler$Companion$fetchShareFeedInfo$1 shareFeedActionHandler$Companion$fetchShareFeedInfo$1 = new ShareFeedActionHandler$Companion$fetchShareFeedInfo$1(this.$shareArkInfo, this.$reqArgs, this.$panelContext, this.$block, this.$fromTag, continuation);
        shareFeedActionHandler$Companion$fetchShareFeedInfo$1.L$0 = obj;
        return shareFeedActionHandler$Companion$fetchShareFeedInfo$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x01cd, code lost:
    
        if (r17.$reqArgs.getNeedCreateShare() != false) goto L81;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0110  */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.tencent.mobileqq.guild.feed.morepanel.handler.ShareFeedActionHandler$Companion$a] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v18, types: [kotlinx.coroutines.Deferred] */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Continuation continuation;
        Deferred deferred;
        Object obj2;
        ?? r26;
        Object await;
        Object async$default;
        ?? r95;
        ShareFeedActionHandler.Companion.FetchShareUrlResult fetchShareUrlResult;
        Object obj3;
        Function1<Boolean, Unit> function1;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    fetchShareUrlResult = (ShareFeedActionHandler.Companion.FetchShareUrlResult) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r26 = fetchShareUrlResult;
                    if (this.$reqArgs.getNeedHandleError()) {
                        if (this.$panelContext.h().isFinishing()) {
                            Logger logger = Logger.f235387a;
                            String str = this.$fromTag;
                            logger.d().i("guild.share.ShareFeedActionHandler", 1, "handle item:" + str + " isFinishing");
                            Function1<Boolean, Unit> function12 = this.$block;
                            if (function12 != null) {
                                function12.invoke(Boxing.boxBoolean(false));
                            }
                            return Unit.INSTANCE;
                        }
                        if (r26 != 0 && !r26.getIsSuccess()) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        if (z26) {
                            ShareFeedActionHandler.INSTANCE.n(r26.getError(), this.$panelContext);
                            Logger logger2 = Logger.f235387a;
                            String str2 = this.$fromTag;
                            logger2.d().i("guild.share.ShareFeedActionHandler", 1, "handle item:" + str2 + " has handle fetchShareUrl Error ");
                            Function1<Boolean, Unit> function13 = this.$block;
                            if (function13 != null) {
                                function13.invoke(Boxing.boxBoolean(false));
                            }
                            return Unit.INSTANCE;
                        }
                        String z37 = this.$shareArkInfo.z();
                        Intrinsics.checkNotNullExpressionValue(z37, "shareArkInfo.shareUrl");
                        if (z37.length() == 0) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        if (!z27 || !this.$reqArgs.getNeedShareUrl()) {
                            String g16 = this.$shareArkInfo.g();
                            Intrinsics.checkNotNullExpressionValue(g16, "shareArkInfo.arkJson");
                            if (g16.length() == 0) {
                                z28 = true;
                            } else {
                                z28 = false;
                            }
                            if (z28) {
                            }
                        }
                        String str3 = this.$fromTag;
                        String z38 = this.$shareArkInfo.z();
                        Intrinsics.checkNotNullExpressionValue(z38, "shareArkInfo.shareUrl");
                        if (z38.length() > 0) {
                            z29 = true;
                        } else {
                            z29 = false;
                        }
                        String g17 = this.$shareArkInfo.g();
                        Intrinsics.checkNotNullExpressionValue(g17, "shareArkInfo.arkJson");
                        if (g17.length() > 0) {
                            z36 = true;
                        } else {
                            z36 = false;
                        }
                        QLog.e("guild.share.ShareFeedActionHandler", 1, "handle item:" + str3 + " onFetchShareInfo error shareUrl:" + z29 + " arkJson:" + z36);
                        QQToastUtil.showQQToast(1, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~");
                        Function1<Boolean, Unit> function14 = this.$block;
                        if (function14 != null) {
                            function14.invoke(Boxing.boxBoolean(false));
                        }
                        return Unit.INSTANCE;
                    }
                    function1 = this.$block;
                    if (function1 != null) {
                        function1.invoke(Boxing.boxBoolean(true));
                    }
                    Logger logger3 = Logger.f235387a;
                    String str4 = this.$fromTag;
                    logger3.d().i("guild.share.ShareFeedActionHandler", 1, "fetchShareFeedInfo from:" + str4 + " finish");
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj4 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj3 = obj4;
            await = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            String z39 = this.$shareArkInfo.z();
            Intrinsics.checkNotNullExpressionValue(z39, "shareArkInfo.shareUrl");
            if (z39.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && this.$reqArgs.getNeedShareUrl()) {
                z17 = true;
            } else {
                z17 = false;
            }
            String g18 = this.$shareArkInfo.g();
            Intrinsics.checkNotNullExpressionValue(g18, "shareArkInfo.arkJson");
            if (g18.length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18 && this.$reqArgs.getNeedCreateShare()) {
                z19 = true;
            } else {
                z19 = false;
            }
            Logger logger4 = Logger.f235387a;
            String str5 = this.$fromTag;
            ShareFeedActionHandler.Companion.ReqHandleArgs reqHandleArgs = this.$reqArgs;
            logger4.d().i("guild.share.ShareFeedActionHandler", 1, "fetchShareFeedInfo from:'" + str5 + "' needFetchShareUrl:" + z17 + " needFetchCreateShare:" + z19 + " reqArgs:" + reqHandleArgs);
            Deferred deferred2 = null;
            if (z17) {
                continuation = null;
                deferred2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass2(this.$shareArkInfo, null), 3, null);
            } else {
                continuation = null;
            }
            if (z19) {
                deferred = deferred2;
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass3(this.$panelContext, this.$shareArkInfo, continuation), 3, null);
                obj2 = async$default;
            } else {
                deferred = deferred2;
                obj2 = continuation;
            }
            if (deferred != null) {
                this.L$0 = obj2;
                this.label = 1;
                await = deferred.await(this);
                obj3 = obj2;
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                r26 = continuation;
                r95 = obj2;
                if (r95 != 0) {
                    this.L$0 = r26;
                    this.label = 2;
                    if (r95.await(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fetchShareUrlResult = r26;
                    r26 = fetchShareUrlResult;
                }
                if (this.$reqArgs.getNeedHandleError()) {
                }
                function1 = this.$block;
                if (function1 != null) {
                }
                Logger logger32 = Logger.f235387a;
                String str42 = this.$fromTag;
                logger32.d().i("guild.share.ShareFeedActionHandler", 1, "fetchShareFeedInfo from:" + str42 + " finish");
                return Unit.INSTANCE;
            }
        }
        r26 = (ShareFeedActionHandler.Companion.FetchShareUrlResult) await;
        r95 = obj3;
        if (r95 != 0) {
        }
        if (this.$reqArgs.getNeedHandleError()) {
        }
        function1 = this.$block;
        if (function1 != null) {
        }
        Logger logger322 = Logger.f235387a;
        String str422 = this.$fromTag;
        logger322.d().i("guild.share.ShareFeedActionHandler", 1, "fetchShareFeedInfo from:" + str422 + " finish");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ShareFeedActionHandler$Companion$fetchShareFeedInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
