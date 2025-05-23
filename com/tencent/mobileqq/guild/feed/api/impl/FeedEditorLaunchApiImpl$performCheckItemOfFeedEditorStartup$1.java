package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.feed.api.FeedEditorCheckItemResult;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchOptionModel;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl$performCheckItemOfFeedEditorStartup$1", f = "FeedEditorLaunchApiImpl.kt", i = {0, 1}, l = {127, 131, 141}, m = "invokeSuspend", n = {"isKeepGoing", "contactUsed"}, s = {"I$0", "L$0"})
/* loaded from: classes13.dex */
public final class FeedEditorLaunchApiImpl$performCheckItemOfFeedEditorStartup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.guild.feed.api.c $checkItemListener;
    final /* synthetic */ com.tencent.mobileqq.guild.data.s $contact;
    final /* synthetic */ FeedEditorLaunchOptionModel $option;
    final /* synthetic */ JSONObject $richContentJson;
    final /* synthetic */ int $traceId;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ FeedEditorLaunchApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorLaunchApiImpl$performCheckItemOfFeedEditorStartup$1(com.tencent.mobileqq.guild.data.s sVar, FeedEditorLaunchApiImpl feedEditorLaunchApiImpl, com.tencent.mobileqq.guild.feed.api.c cVar, int i3, JSONObject jSONObject, FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, Continuation<? super FeedEditorLaunchApiImpl$performCheckItemOfFeedEditorStartup$1> continuation) {
        super(2, continuation);
        this.$contact = sVar;
        this.this$0 = feedEditorLaunchApiImpl;
        this.$checkItemListener = cVar;
        this.$traceId = i3;
        this.$richContentJson = jSONObject;
        this.$option = feedEditorLaunchOptionModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedEditorLaunchApiImpl$performCheckItemOfFeedEditorStartup$1(this.$contact, this.this$0, this.$checkItemListener, this.$traceId, this.$richContentJson, this.$option, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00af  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        boolean z16;
        com.tencent.mobileqq.guild.data.s sVar;
        boolean z17;
        com.tencent.mobileqq.guild.data.s sVar2;
        Object A;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z18 = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                sVar2 = (com.tencent.mobileqq.guild.data.s) this.L$0;
                ResultKt.throwOnFailure(obj);
                z18 = ((Boolean) obj).booleanValue();
                sVar = sVar2;
                if (z18) {
                    FeedEditorLaunchApiImpl feedEditorLaunchApiImpl = this.this$0;
                    int i16 = this.$traceId;
                    JSONObject jSONObject = this.$richContentJson;
                    FeedEditorLaunchOptionModel feedEditorLaunchOptionModel = this.$option;
                    com.tencent.mobileqq.guild.feed.api.c cVar = this.$checkItemListener;
                    this.L$0 = null;
                    this.label = 3;
                    A = feedEditorLaunchApiImpl.A(i16, sVar, jSONObject, feedEditorLaunchOptionModel, cVar, this);
                    if (A == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            int i17 = this.I$0;
            ResultKt.throwOnFailure(obj);
            z17 = i17;
        } else {
            ResultKt.throwOnFailure(obj);
            com.tencent.mobileqq.guild.data.s sVar3 = this.$contact;
            if (sVar3 != null) {
                str = sVar3.getGuildId();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (this.$contact != null) {
                    ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).preloadSpeakRule(this.$contact.getGuildId(), null);
                    FeedEditorLaunchApiImpl feedEditorLaunchApiImpl2 = this.this$0;
                    String guildId = this.$contact.getGuildId();
                    String channelId = this.$contact.getChannelId();
                    this.I$0 = 1;
                    this.label = 1;
                    obj = feedEditorLaunchApiImpl2.o(guildId, channelId, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z17 = true;
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                sVar = null;
                if (z18) {
                }
                return Unit.INSTANCE;
            }
        }
        SpeakPermissionType speakPermissionType = (SpeakPermissionType) obj;
        com.tencent.mobileqq.guild.data.s sVar4 = this.$contact;
        if (speakPermissionType != SpeakPermissionType.PERMISSION_TYPE_NORMAL) {
            com.tencent.mobileqq.guild.feed.api.c cVar2 = this.$checkItemListener;
            FeedEditorCheckItemResult feedEditorCheckItemResult = new FeedEditorCheckItemResult(1, speakPermissionType);
            this.L$0 = sVar4;
            this.label = 2;
            obj = cVar2.a(feedEditorCheckItemResult, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            sVar2 = sVar4;
            z18 = ((Boolean) obj).booleanValue();
            sVar = sVar2;
            if (z18) {
            }
            return Unit.INSTANCE;
        }
        z18 = z17;
        sVar = sVar4;
        if (z18) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorLaunchApiImpl$performCheckItemOfFeedEditorStartup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
