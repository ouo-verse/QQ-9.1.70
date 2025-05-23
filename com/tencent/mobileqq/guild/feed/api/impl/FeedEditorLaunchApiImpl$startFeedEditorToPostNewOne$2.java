package com.tencent.mobileqq.guild.feed.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchOptionModel;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchSourceModel;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2", f = "FeedEditorLaunchApiImpl.kt", i = {}, l = {388, 403}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.guild.data.s $contact;
    final /* synthetic */ Context $context;
    final /* synthetic */ FeedEditorLaunchOptionModel $option;
    final /* synthetic */ FeedEditorLaunchSourceModel $source;
    final /* synthetic */ com.tencent.mobileqq.guild.feed.api.d $startProcedureAware;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedEditorLaunchApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2$1", f = "FeedEditorLaunchApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).preloadWebProcess();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2(FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, com.tencent.mobileqq.guild.data.s sVar, FeedEditorLaunchApiImpl feedEditorLaunchApiImpl, Context context, FeedEditorLaunchSourceModel feedEditorLaunchSourceModel, com.tencent.mobileqq.guild.feed.api.d dVar, Continuation<? super FeedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2> continuation) {
        super(2, continuation);
        this.$option = feedEditorLaunchOptionModel;
        this.$contact = sVar;
        this.this$0 = feedEditorLaunchApiImpl;
        this.$context = context;
        this.$source = feedEditorLaunchSourceModel;
        this.$startProcedureAware = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2 feedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2 = new FeedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2(this.$option, this.$contact, this.this$0, this.$context, this.$source, this.$startProcedureAware, continuation);
        feedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2.L$0 = obj;
        return feedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String channelId;
        Long longOrNull;
        com.tencent.mobileqq.guild.data.s sVar;
        com.tencent.mobileqq.guild.data.s sVar2;
        boolean z16;
        Object K;
        String guildId;
        boolean z17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        GuildSimpleContact guildSimpleContact = null;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (this.$option.getFeedType() == 1) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, ae.a().e(), null, new AnonymousClass1(null), 2, null);
            }
            com.tencent.mobileqq.guild.data.s sVar3 = this.$contact;
            if (sVar3 != null && TextUtils.isEmpty(sVar3.getChannelId())) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.$contact.getGuildId());
                if (longOrNull != null) {
                    FeedEditorLaunchApiImpl feedEditorLaunchApiImpl = this.this$0;
                    long longValue = longOrNull.longValue();
                    this.label = 1;
                    obj = feedEditorLaunchApiImpl.q(longValue, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                com.tencent.mobileqq.guild.data.s sVar4 = this.$contact;
                if (sVar4 != null) {
                    channelId = sVar4.getChannelId();
                    sVar = this.$contact;
                    if (sVar != null) {
                        String guildId2 = sVar.getGuildId();
                        if (channelId == null) {
                            channelId = "";
                        }
                        guildSimpleContact = new GuildSimpleContact(guildId2, channelId);
                    }
                    GuildSimpleContact guildSimpleContact2 = guildSimpleContact;
                    if (QLog.isDevelopLevel()) {
                        QLog.d("FeedEditorLaunchApiImpl", 4, "[startFeedEditorToPostNewOne]: option=" + this.$option + ", newContact=" + guildSimpleContact2);
                    }
                    if (this.$option.isBeyondGuild() || this.$option.getFeedType() != 1) {
                        sVar2 = this.$contact;
                        z16 = false;
                        if (sVar2 != null && (guildId = sVar2.getGuildId()) != null) {
                            if (guildId.length() <= 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                z16 = true;
                            }
                        }
                        if (z16) {
                            FeedEditorLaunchApiImpl feedEditorLaunchApiImpl2 = this.this$0;
                            Context context = this.$context;
                            FeedEditorLaunchOptionModel feedEditorLaunchOptionModel = this.$option;
                            FeedEditorLaunchSourceModel feedEditorLaunchSourceModel = this.$source;
                            com.tencent.mobileqq.guild.feed.api.d dVar = this.$startProcedureAware;
                            this.label = 2;
                            K = feedEditorLaunchApiImpl2.K(context, guildSimpleContact2, feedEditorLaunchOptionModel, feedEditorLaunchSourceModel, dVar, this);
                            if (K == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    QLog.e("FeedEditorLaunchApiImpl", 1, "[parse]: illegal argument of: contact=" + this.$contact + ", option=" + this.$option);
                    return Unit.INSTANCE;
                }
            }
            channelId = null;
            sVar = this.$contact;
            if (sVar != null) {
            }
            GuildSimpleContact guildSimpleContact22 = guildSimpleContact;
            if (QLog.isDevelopLevel()) {
            }
            if (this.$option.isBeyondGuild()) {
            }
            sVar2 = this.$contact;
            z16 = false;
            if (sVar2 != null) {
                if (guildId.length() <= 0) {
                }
                if (z17) {
                }
            }
            if (z16) {
            }
            QLog.e("FeedEditorLaunchApiImpl", 1, "[parse]: illegal argument of: contact=" + this.$contact + ", option=" + this.$option);
            return Unit.INSTANCE;
        }
        channelId = String.valueOf(obj);
        sVar = this.$contact;
        if (sVar != null) {
        }
        GuildSimpleContact guildSimpleContact222 = guildSimpleContact;
        if (QLog.isDevelopLevel()) {
        }
        if (this.$option.isBeyondGuild()) {
        }
        sVar2 = this.$contact;
        z16 = false;
        if (sVar2 != null) {
        }
        if (z16) {
        }
        QLog.e("FeedEditorLaunchApiImpl", 1, "[parse]: illegal argument of: contact=" + this.$contact + ", option=" + this.$option);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorLaunchApiImpl$startFeedEditorToPostNewOne$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
