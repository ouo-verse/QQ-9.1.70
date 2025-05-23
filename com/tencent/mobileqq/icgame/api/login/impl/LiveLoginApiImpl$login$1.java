package com.tencent.mobileqq.icgame.api.login.impl;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.icgame.context.QQLiveContext;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.icgame.techreport.d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.icgame.api.login.impl.LiveLoginApiImpl$login$1", f = "LiveLoginApiImpl.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
final class LiveLoginApiImpl$login$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ Function1<QQLiveResponse<LiveLoginInfo>, Unit> $callback;
    final /* synthetic */ String $uin;
    int label;
    final /* synthetic */ LiveLoginApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LiveLoginApiImpl$login$1(LiveLoginApiImpl liveLoginApiImpl, String str, String str2, Function1<? super QQLiveResponse<LiveLoginInfo>, Unit> function1, Continuation<? super LiveLoginApiImpl$login$1> continuation) {
        super(2, continuation);
        this.this$0 = liveLoginApiImpl;
        this.$appId = str;
        this.$uin = str2;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LiveLoginApiImpl$login$1(this.this$0, this.$appId, this.$uin, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        LiveLoginInfo liveInfoFromMmkv;
        boolean z16;
        Map map;
        Map mapOf;
        String traceId;
        Map map2;
        List mutableListOf;
        Map map3;
        Integer num;
        Map map4;
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
            liveInfoFromMmkv = this.this$0.getLiveInfoFromMmkv(this.$appId, this.$uin);
            if (liveInfoFromMmkv != null && liveInfoFromMmkv.u()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                map = this.this$0.pendingLoginCallback;
                if (map.containsKey(this.$appId)) {
                    Function1<QQLiveResponse<LiveLoginInfo>, Unit> function1 = this.$callback;
                    if (function1 != null) {
                        LiveLoginApiImpl liveLoginApiImpl = this.this$0;
                        String str = this.$appId;
                        map4 = liveLoginApiImpl.pendingLoginCallback;
                        List list = (List) map4.get(str);
                        if (list != null) {
                            Boxing.boxBoolean(list.add(function1));
                        }
                    }
                    a.Companion companion = a.INSTANCE;
                    map3 = this.this$0.pendingLoginCallback;
                    List list2 = (List) map3.get(this.$appId);
                    if (list2 != null) {
                        num = Boxing.boxInt(list2.size());
                    } else {
                        num = null;
                    }
                    companion.k("ICGameLogin|ICGameLiveLoginApiImpl", "login", "no login, pending callback, size=" + num);
                    return Unit.INSTANCE;
                }
                Function1<QQLiveResponse<LiveLoginInfo>, Unit> function12 = this.$callback;
                if (function12 != null) {
                    LiveLoginApiImpl liveLoginApiImpl2 = this.this$0;
                    String str2 = this.$appId;
                    map2 = liveLoginApiImpl2.pendingLoginCallback;
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(function12);
                    map2.put(str2, mutableListOf);
                }
                a.INSTANCE.k("ICGameLogin|ICGameLiveLoginApiImpl", "login", "no login, to request");
                Pair[] pairArr = new Pair[3];
                String str3 = "";
                pairArr[0] = TuplesKt.to("event_code", "");
                pairArr[1] = TuplesKt.to(AudienceReportConst.EVENT_MSG, "begin");
                QQLiveContext b16 = QQLiveContext.INSTANCE.b(this.$appId);
                if (b16 != null && (traceId = b16.getTraceId()) != null) {
                    str3 = traceId;
                }
                pairArr[2] = TuplesKt.to("ext1", str3);
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                d.g("ev_icgame_login", mapOf);
                LiveLoginApiImpl liveLoginApiImpl3 = this.this$0;
                String str4 = this.$appId;
                String str5 = this.$uin;
                this.label = 1;
                if (LiveLoginApiImpl.getAuthAndDoRequest$default(liveLoginApiImpl3, str4, liveInfoFromMmkv, str5, false, this, 8, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Function1<QQLiveResponse<LiveLoginInfo>, Unit> function13 = this.$callback;
                if (function13 != null) {
                    function13.invoke(new QQLiveResponse<>(null, true, 0L, null, liveInfoFromMmkv));
                }
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LiveLoginApiImpl$login$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
