package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.ShareAppMessageMethod;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.ShareAppMessageMethod$fetchShareInfo$1", f = "ShareAppMessageMethod.kt", i = {0}, l = {223, 234}, m = "invokeSuspend", n = {"imageCheckCode"}, s = {"L$0"})
/* loaded from: classes14.dex */
public final class ShareAppMessageMethod$fetchShareInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Integer, String, String, Unit> $callback;
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ String $query;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ShareAppMessageMethod this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.ShareAppMessageMethod$fetchShareInfo$1$2", f = "ShareAppMessageMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.ShareAppMessageMethod$fetchShareInfo$1$2, reason: invalid class name */
    /* loaded from: classes14.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ String $imageUrl;
        int label;
        final /* synthetic */ ShareAppMessageMethod this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ShareAppMessageMethod shareAppMessageMethod, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = shareAppMessageMethod;
            this.$imageUrl = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$imageUrl, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int t16;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                t16 = this.this$0.t(this.$imageUrl);
                return Boxing.boxInt(t16);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Integer> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShareAppMessageMethod$fetchShareInfo$1(String str, Function3<? super Integer, ? super String, ? super String, Unit> function3, ShareAppMessageMethod shareAppMessageMethod, String str2, Continuation<? super ShareAppMessageMethod$fetchShareInfo$1> continuation) {
        super(2, continuation);
        this.$imageUrl = str;
        this.$callback = function3;
        this.this$0 = shareAppMessageMethod;
        this.$query = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ShareAppMessageMethod$fetchShareInfo$1(this.$imageUrl, this.$callback, this.this$0, this.$query, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0100  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        Ref.IntRef intRef;
        Object i3;
        Ref.IntRef intRef2;
        int i16;
        Object w3;
        ShareAppMessageMethod.FetchRsp fetchRsp;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        int i18 = 0;
        int i19 = -10001;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 2) {
                    ResultKt.throwOnFailure(obj);
                    w3 = obj;
                    fetchRsp = (ShareAppMessageMethod.FetchRsp) w3;
                    if (fetchRsp.d()) {
                        if (fetchRsp.getCode() == 706000) {
                            i19 = -10002;
                        }
                        Function3<Integer, String, String, Unit> function3 = this.$callback;
                        if (function3 != null) {
                            function3.invoke(Boxing.boxInt(i19), "", "");
                        }
                        Logger.f235387a.d().w("ShareAppMessageMethod", 1, "[requestSessionId] error shareResult " + i19 + " code " + fetchRsp.getCode());
                        return Unit.INSTANCE;
                    }
                    Logger.f235387a.d().d("ShareAppMessageMethod", 1, "[fetchShareInfo] final fetchRsp " + fetchRsp);
                    Function3<Integer, String, String, Unit> function32 = this.$callback;
                    if (function32 != null) {
                        function32.invoke(Boxing.boxInt(fetchRsp.getCode()), fetchRsp.getFileId(), fetchRsp.getSessionId());
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.IntRef intRef3 = (Ref.IntRef) this.L$1;
            Ref.IntRef intRef4 = (Ref.IntRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            intRef = intRef4;
            intRef2 = intRef3;
            i3 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            Logger logger = Logger.f235387a;
            String str = this.$imageUrl;
            String str2 = this.$query;
            logger.d().d("ShareAppMessageMethod", 1, "[fetchShareInfo] begin imageUrl " + str + " query " + str2);
            Ref.IntRef intRef5 = new Ref.IntRef();
            intRef5.element = -10001;
            if (this.$imageUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && HttpUtil.isValidUrl(this.$imageUrl)) {
                i.f fVar = i.f.f261784e;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$imageUrl, null);
                this.L$0 = intRef5;
                this.L$1 = intRef5;
                this.label = 1;
                intRef = intRef5;
                i3 = CorountineFunKt.i(fVar, null, null, anonymousClass2, this, 6, null);
                if (i3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                intRef2 = intRef;
            } else {
                intRef = intRef5;
                Ref.IntRef intRef6 = intRef;
                Logger.f235387a.d().d("ShareAppMessageMethod", 1, "[fetchShareInfo] doCheckImageSize imageCheckCode " + intRef6.element);
                i16 = intRef6.element;
                if (i16 == 0) {
                    Function3<Integer, String, String, Unit> function33 = this.$callback;
                    if (function33 != null) {
                        function33.invoke(Boxing.boxInt(i16), "", "");
                    }
                    return Unit.INSTANCE;
                }
                ShareAppMessageMethod shareAppMessageMethod = this.this$0;
                String str3 = this.$imageUrl;
                String str4 = this.$query;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                w3 = shareAppMessageMethod.w(str3, str4, this);
                if (w3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                fetchRsp = (ShareAppMessageMethod.FetchRsp) w3;
                if (fetchRsp.d()) {
                }
            }
        }
        Integer num = (Integer) i3;
        if (num != null) {
            i18 = num.intValue();
        }
        intRef2.element = i18;
        Ref.IntRef intRef62 = intRef;
        Logger.f235387a.d().d("ShareAppMessageMethod", 1, "[fetchShareInfo] doCheckImageSize imageCheckCode " + intRef62.element);
        i16 = intRef62.element;
        if (i16 == 0) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ShareAppMessageMethod$fetchShareInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
