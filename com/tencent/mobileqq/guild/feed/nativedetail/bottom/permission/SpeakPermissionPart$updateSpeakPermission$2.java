package com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission;

import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionPart$updateSpeakPermission$2", f = "SpeakPermissionPart.kt", i = {0}, l = {271}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class SpeakPermissionPart$updateSpeakPermission$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $updateSource;
    final /* synthetic */ boolean $useCache;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SpeakPermissionPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionPart$updateSpeakPermission$2$1", f = "SpeakPermissionPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionPart$updateSpeakPermission$2$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IGProGuildInfo $guildInfo;
        int label;
        final /* synthetic */ SpeakPermissionPart this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SpeakPermissionPart speakPermissionPart, IGProGuildInfo iGProGuildInfo, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = speakPermissionPart;
            this.$guildInfo = iGProGuildInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$guildInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.P9(this.$guildInfo);
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
    public SpeakPermissionPart$updateSpeakPermission$2(SpeakPermissionPart speakPermissionPart, String str, boolean z16, Continuation<? super SpeakPermissionPart$updateSpeakPermission$2> continuation) {
        super(2, continuation);
        this.this$0 = speakPermissionPart;
        this.$updateSource = str;
        this.$useCache = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SpeakPermissionPart$updateSpeakPermission$2 speakPermissionPart$updateSpeakPermission$2 = new SpeakPermissionPart$updateSpeakPermission$2(this.this$0, this.$updateSource, this.$useCache, continuation);
        speakPermissionPart$updateSpeakPermission$2.L$0 = obj;
        return speakPermissionPart$updateSpeakPermission$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        CoroutineScope coroutineScope;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope = coroutineScope2;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            this.this$0.checkSpeakPermissionUpdateJob = null;
            GuildMainFrameUtils guildMainFrameUtils = GuildMainFrameUtils.f227682a;
            String str2 = this.this$0.guildId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            } else {
                str = str2;
            }
            this.L$0 = coroutineScope3;
            this.label = 1;
            Object h16 = GuildMainFrameUtils.h(guildMainFrameUtils, str, null, 0, null, this, 14, null);
            if (h16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope3;
            obj = h16;
        }
        GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp = (GuildMainFrameUtils.GuildAndChannelInfoRsp) obj;
        int result = guildAndChannelInfoRsp.getResult();
        String errMsg = guildAndChannelInfoRsp.getErrMsg();
        IGProGuildInfo guildInfo = guildAndChannelInfoRsp.getGuildInfo();
        if (result == 0 && guildInfo != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, ae.a().e(), null, new AnonymousClass1(this.this$0, guildInfo, null), 2, null);
            return Unit.INSTANCE;
        }
        QLog.e("SpeakPermissionPart", 1, "[updateSpeakPermission]: source=" + this.$updateSource + ", " + this.$useCache + ", result=" + result + ", errMsg=" + errMsg);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SpeakPermissionPart$updateSpeakPermission$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
