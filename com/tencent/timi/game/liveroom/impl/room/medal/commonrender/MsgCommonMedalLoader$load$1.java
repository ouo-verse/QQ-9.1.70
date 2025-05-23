package com.tencent.timi.game.liveroom.impl.room.medal.commonrender;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.medal.commonrender.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr4.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.timi.game.liveroom.impl.room.medal.commonrender.MsgCommonMedalLoader$load$1", f = "MsgCommonMedalLoader.kt", i = {0}, l = {45, 48}, m = "invokeSuspend", n = {"resultBitmapList"}, s = {"L$0"})
/* loaded from: classes26.dex */
public final class MsgCommonMedalLoader$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c.b $callback;
    final /* synthetic */ long $roomId;
    final /* synthetic */ com.tencent.mobileqq.qqlive.widget.chat.data.b $userMedalInfo;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MsgCommonMedalLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.timi.game.liveroom.impl.room.medal.commonrender.MsgCommonMedalLoader$load$1$2", f = "MsgCommonMedalLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.medal.commonrender.MsgCommonMedalLoader$load$1$2, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ c.b $callback;
        final /* synthetic */ Ref.ObjectRef<List<Bitmap>> $resultBitmapList;
        final /* synthetic */ long $roomId;
        final /* synthetic */ com.tencent.mobileqq.qqlive.widget.chat.data.b $userMedalInfo;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MsgCommonMedalLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar, MsgCommonMedalLoader msgCommonMedalLoader, long j3, Ref.ObjectRef<List<Bitmap>> objectRef, c.b bVar2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$userMedalInfo = bVar;
            this.this$0 = msgCommonMedalLoader;
            this.$roomId = j3;
            this.$resultBitmapList = objectRef;
            this.$callback = bVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$userMedalInfo, this.this$0, this.$roomId, this.$resultBitmapList, this.$callback, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            MedalLayoutStyleConfig g16;
            SpannableString d16;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                int i3 = 0;
                for (g info : this.$userMedalInfo.f273762g) {
                    int i16 = i3 + 1;
                    MsgCommonMedalLoader msgCommonMedalLoader = this.this$0;
                    long j3 = this.$roomId;
                    Intrinsics.checkNotNullExpressionValue(info, "info");
                    g16 = msgCommonMedalLoader.g(j3, info);
                    if (g16 != null) {
                        if (this.$resultBitmapList.element.get(i3) == null) {
                            AegisLogger.INSTANCE.i("Chat_Message|MsgCommonMedalRender", "load", "build medal span fail, bgImage is null, drawConfig=" + g16 + ", medalInfo=" + info);
                        } else {
                            Bitmap bitmap = this.$resultBitmapList.element.get(i3);
                            if (bitmap != null) {
                                d16 = this.this$0.d(bitmap, info, g16);
                                spannableStringBuilder.append((CharSequence) d16);
                                spannableStringBuilder.append((CharSequence) " ");
                            }
                        }
                    }
                    i3 = i16;
                }
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                companion.i("Chat_Message|MsgCommonMedalRender", "load", "Completed");
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    this.$callback.a(this.$userMedalInfo, spannableStringBuilder);
                } else {
                    companion.i("Chat_Message|MsgCommonMedalRender", "load", "is not active, cancel callback");
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgCommonMedalLoader$load$1(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar, MsgCommonMedalLoader msgCommonMedalLoader, long j3, c.b bVar2, Continuation<? super MsgCommonMedalLoader$load$1> continuation) {
        super(2, continuation);
        this.$userMedalInfo = bVar;
        this.this$0 = msgCommonMedalLoader;
        this.$roomId = j3;
        this.$callback = bVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MsgCommonMedalLoader$load$1 msgCommonMedalLoader$load$1 = new MsgCommonMedalLoader$load$1(this.$userMedalInfo, this.this$0, this.$roomId, this.$callback, continuation);
        msgCommonMedalLoader$load$1.L$0 = obj;
        return msgCommonMedalLoader$load$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, java.util.ArrayList] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Deferred async$default;
        T t16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) this.L$1;
            Ref.ObjectRef objectRef3 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            objectRef2 = objectRef3;
            t16 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AegisLogger.INSTANCE.i("Chat_Message|MsgCommonMedalRender", "load", "download bgImages, medal_list_size=" + this.$userMedalInfo.f273762g.size());
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            objectRef4.element = new ArrayList();
            List<g> list = this.$userMedalInfo.f273762g;
            Intrinsics.checkNotNullExpressionValue(list, "userMedalInfo.medalInfoNewList");
            MsgCommonMedalLoader msgCommonMedalLoader = this.this$0;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new MsgCommonMedalLoader$load$1$1$medalJob$1((g) it.next(), msgCommonMedalLoader, null), 3, null);
                ((ArrayList) objectRef4.element).add(async$default);
            }
            objectRef = new Ref.ObjectRef();
            Collection collection = (Collection) objectRef4.element;
            this.L$0 = objectRef;
            this.L$1 = objectRef;
            this.label = 1;
            Object awaitAll = AwaitKt.awaitAll(collection, this);
            if (awaitAll == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef2 = objectRef;
            t16 = awaitAll;
        }
        objectRef.element = t16;
        AegisLogger.INSTANCE.i("Chat_Message|MsgCommonMedalRender", "load", "build medal span...");
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$userMedalInfo, this.this$0, this.$roomId, objectRef2, this.$callback, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MsgCommonMedalLoader$load$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
