package com.tencent.filament.zplan.business.impl;

import com.heytap.databaseengine.type.DataTableNameType;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.exception.BlackListResourceException;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.b;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "Lcom/tencent/filament/zplan/avatar/model/ReloadAvatarResourceModel;", "Lal0/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene$fetchReloadAvatarResourceWithStatistic$2", f = "AbsBusinessScene.kt", i = {0, 0, 0}, l = {DataTableNameType.TABLE_SPORT_METADATA}, m = "invokeSuspend", n = {"statistic", "fetchAvatarResourceSpan", "this_$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class AbsBusinessScene$fetchReloadAvatarResourceWithStatistic$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends ReloadAvatarResourceModel, ? extends al0.a>>, Object> {
    final /* synthetic */ JSONObject $avatarInfo;
    final /* synthetic */ c $zplanSpanContext;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AbsBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$fetchReloadAvatarResourceWithStatistic$2(AbsBusinessScene absBusinessScene, c cVar, JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.this$0 = absBusinessScene;
        this.$zplanSpanContext = cVar;
        this.$avatarInfo = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new AbsBusinessScene$fetchReloadAvatarResourceWithStatistic$2(this.this$0, this.$zplanSpanContext, this.$avatarInfo, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends ReloadAvatarResourceModel, ? extends al0.a>> continuation) {
        return ((AbsBusinessScene$fetchReloadAvatarResourceWithStatistic$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ed  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        b startSpan;
        al0.a aVar;
        b bVar;
        al0.a aVar2;
        c c16;
        Object W;
        al0.a aVar3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                aVar3 = (al0.a) this.L$2;
                bVar = (b) this.L$1;
                aVar2 = (al0.a) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    startSpan = bVar;
                    W = obj;
                } catch (BlackListResourceException e16) {
                    e = e16;
                    FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource BlackListResourceException exception: " + e.getMessage(), e);
                    aVar2.g(201005, e.getMessage());
                    if (bVar != null) {
                    }
                    return new Pair(null, aVar2);
                } catch (FetchFileException e17) {
                    e = e17;
                    FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource FetchFileException exception: " + e.getMessage(), e);
                    aVar2.g(e.getErrorCode(), e.getMessage());
                    if (bVar != null) {
                    }
                    return new Pair(null, aVar2);
                } catch (Throwable th5) {
                    th = th5;
                    FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource Throwable exception: " + th.getMessage(), th);
                    aVar2.g(201003, th.getMessage());
                    if (bVar != null) {
                    }
                    return new Pair(null, aVar2);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            al0.a aVar4 = new al0.a(0L, 0L, false, 0, null, 31, null);
            startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchReloadAvatarResourceWithStatistic", this.$zplanSpanContext);
            try {
                aVar4.l(al0.a.INSTANCE.b());
                ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                if (startSpan != null) {
                    try {
                        c16 = startSpan.c();
                    } catch (BlackListResourceException e18) {
                        e = e18;
                        aVar2 = aVar4;
                        bVar = startSpan;
                        FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource BlackListResourceException exception: " + e.getMessage(), e);
                        aVar2.g(201005, e.getMessage());
                        if (bVar != null) {
                        }
                        return new Pair(null, aVar2);
                    } catch (FetchFileException e19) {
                        e = e19;
                        aVar2 = aVar4;
                        bVar = startSpan;
                        FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource FetchFileException exception: " + e.getMessage(), e);
                        aVar2.g(e.getErrorCode(), e.getMessage());
                        if (bVar != null) {
                        }
                        return new Pair(null, aVar2);
                    } catch (Throwable th6) {
                        th = th6;
                        aVar2 = aVar4;
                        bVar = startSpan;
                        FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource Throwable exception: " + th.getMessage(), th);
                        aVar2.g(201003, th.getMessage());
                        if (bVar != null) {
                        }
                        return new Pair(null, aVar2);
                    }
                } else {
                    c16 = null;
                }
                JSONObject jSONObject = this.$avatarInfo;
                FilamentUrlTemplate urlTemplate = this.this$0.getUrlTemplate();
                this.L$0 = aVar4;
                this.L$1 = startSpan;
                this.L$2 = aVar4;
                this.label = 1;
                aVar = aVar4;
                try {
                    W = ZPlanAvatarResourceHelper.W(zPlanAvatarResourceHelper, c16, jSONObject, urlTemplate, false, this, 8, null);
                    if (W == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar3 = aVar;
                    aVar2 = aVar3;
                } catch (BlackListResourceException e26) {
                    e = e26;
                    bVar = startSpan;
                    aVar2 = aVar;
                    FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource BlackListResourceException exception: " + e.getMessage(), e);
                    aVar2.g(201005, e.getMessage());
                    if (bVar != null) {
                    }
                    return new Pair(null, aVar2);
                } catch (FetchFileException e27) {
                    e = e27;
                    bVar = startSpan;
                    aVar2 = aVar;
                    FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource FetchFileException exception: " + e.getMessage(), e);
                    aVar2.g(e.getErrorCode(), e.getMessage());
                    if (bVar != null) {
                    }
                    return new Pair(null, aVar2);
                } catch (Throwable th7) {
                    th = th7;
                    bVar = startSpan;
                    aVar2 = aVar;
                    FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource Throwable exception: " + th.getMessage(), th);
                    aVar2.g(201003, th.getMessage());
                    if (bVar != null) {
                    }
                    return new Pair(null, aVar2);
                }
            } catch (BlackListResourceException e28) {
                e = e28;
                aVar = aVar4;
            } catch (FetchFileException e29) {
                e = e29;
                aVar = aVar4;
            } catch (Throwable th8) {
                th = th8;
                aVar = aVar4;
            }
        }
        try {
            ReloadAvatarResourceModel reloadAvatarResourceModel = (ReloadAvatarResourceModel) W;
            aVar3.i(al0.a.INSTANCE.b());
            if (startSpan != null) {
                startSpan.b();
            }
            return new Pair(reloadAvatarResourceModel, aVar2);
        } catch (BlackListResourceException e36) {
            e = e36;
            bVar = startSpan;
            FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource BlackListResourceException exception: " + e.getMessage(), e);
            aVar2.g(201005, e.getMessage());
            if (bVar != null) {
                bVar.a(e.getMessage());
            }
            return new Pair(null, aVar2);
        } catch (FetchFileException e37) {
            e = e37;
            bVar = startSpan;
            FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource FetchFileException exception: " + e.getMessage(), e);
            aVar2.g(e.getErrorCode(), e.getMessage());
            if (bVar != null) {
                bVar.a(e.getMessage());
            }
            return new Pair(null, aVar2);
        } catch (Throwable th9) {
            th = th9;
            bVar = startSpan;
            FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAvatarResource Throwable exception: " + th.getMessage(), th);
            aVar2.g(201003, th.getMessage());
            if (bVar != null) {
                bVar.a(th.getMessage());
            }
            return new Pair(null, aVar2);
        }
    }
}
