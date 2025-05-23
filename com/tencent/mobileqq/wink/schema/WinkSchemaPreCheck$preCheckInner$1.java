package com.tencent.mobileqq.wink.schema;

import android.os.Bundle;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preCheckInner$1", f = "WinkSchemaPreCheck.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {244, 245, 246, 247, 250}, m = "invokeSuspend", n = {"preCheckOnlineResDeferred", "preCheckDownloadMaterialDeferred", "preCheckUserInfoDeferred", "startTime", "preCheckOnlineResDeferred", "preCheckUserInfoDeferred", "startTime", "preCheckBaseBundleResult", "preCheckUserInfoDeferred", "preCheckDownloadMaterialResult", "startTime", "preCheckBaseBundleResult", "preCheckDownloadMaterialResult", "startTime", "preCheckBaseBundleResult", "preCheckOnlineResResult", "preCheckDownloadMaterialResult", "startTime", "preCheckBaseBundleResult", "preCheckOnlineResResult", "preCheckUserInfoResult"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "Z$0", "L$0", "L$1", "J$0", "Z$0", "L$0", "J$0", "Z$0", "Z$1", "L$0", "J$0", "Z$0", "Z$1", "Z$2"})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheck$preCheckInner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ String $businessName;
    final /* synthetic */ WinkSchemaPreCheck.a $callback;
    final /* synthetic */ HashMap<String, Object> $costCollector;
    final /* synthetic */ String $entryId;
    final /* synthetic */ String $jumpTarget;
    final /* synthetic */ ConcurrentHashMap<String, String> $keyAttrs;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheck$preCheckInner$1(Bundle bundle, ConcurrentHashMap<String, String> concurrentHashMap, WinkSchemaPreCheck.a aVar, String str, String str2, HashMap<String, Object> hashMap, String str3, Continuation<? super WinkSchemaPreCheck$preCheckInner$1> continuation) {
        super(2, continuation);
        this.$args = bundle;
        this.$keyAttrs = concurrentHashMap;
        this.$callback = aVar;
        this.$jumpTarget = str;
        this.$entryId = str2;
        this.$costCollector = hashMap;
        this.$businessName = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkSchemaPreCheck$preCheckInner$1 winkSchemaPreCheck$preCheckInner$1 = new WinkSchemaPreCheck$preCheckInner$1(this.$args, this.$keyAttrs, this.$callback, this.$jumpTarget, this.$entryId, this.$costCollector, this.$businessName, continuation);
        winkSchemaPreCheck$preCheckInner$1.L$0 = obj;
        return winkSchemaPreCheck$preCheckInner$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x01b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0155 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013b A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        Deferred async$default4;
        Object await;
        long j3;
        Deferred deferred;
        Object await2;
        long j16;
        Deferred deferred2;
        Deferred deferred3;
        boolean z16;
        List list;
        Object await3;
        Object await4;
        boolean z17;
        boolean z18;
        boolean booleanValue;
        boolean z19;
        List list2;
        Object withContext;
        boolean z26;
        long j17;
        List list3;
        WinkSchemaPreCheck.a aVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                z26 = this.Z$2;
                                z18 = this.Z$1;
                                z17 = this.Z$0;
                                j17 = this.J$0;
                                list3 = (List) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                withContext = obj;
                                z19 = ((Boolean) withContext).booleanValue();
                                long j18 = j17;
                                booleanValue = z26;
                                list2 = list3;
                                j16 = j18;
                                w53.b.f("TAG_WinkSchemaPreCheck", "preCheckInner finish. cost " + (System.currentTimeMillis() - j16));
                                if (!z17 && z18 && z19 && booleanValue) {
                                    this.$args.putSerializable(QQWinkConstants.KEY_SCHEME_MATE_MATERIALS, new ArrayList(list2));
                                    this.$args.putSerializable("key_attrs", this.$keyAttrs);
                                    WinkSchemaPreCheck.a aVar2 = this.$callback;
                                    if (aVar2 != null) {
                                        aVar2.a(this.$args, this.$keyAttrs);
                                    }
                                } else {
                                    aVar = this.$callback;
                                    if (aVar != null) {
                                        aVar.onFailed();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z18 = this.Z$1;
                        boolean z27 = this.Z$0;
                        j16 = this.J$0;
                        list = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        z17 = z27;
                        await4 = obj;
                        booleanValue = ((Boolean) await4).booleanValue();
                        if (!z17) {
                            CoroutineDispatcher b16 = WinkCoroutineScopes.f317652a.b();
                            WinkSchemaPreCheck$preCheckInner$1$preCheckMaterialResult$1 winkSchemaPreCheck$preCheckInner$1$preCheckMaterialResult$1 = new WinkSchemaPreCheck$preCheckInner$1$preCheckMaterialResult$1(list, this.$costCollector, null);
                            this.L$0 = list;
                            this.J$0 = j16;
                            this.Z$0 = z17;
                            this.Z$1 = z18;
                            this.Z$2 = booleanValue;
                            this.label = 5;
                            withContext = BuildersKt.withContext(b16, winkSchemaPreCheck$preCheckInner$1$preCheckMaterialResult$1, this);
                            if (withContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z26 = booleanValue;
                            j17 = j16;
                            list3 = list;
                            z19 = ((Boolean) withContext).booleanValue();
                            long j182 = j17;
                            booleanValue = z26;
                            list2 = list3;
                            j16 = j182;
                            w53.b.f("TAG_WinkSchemaPreCheck", "preCheckInner finish. cost " + (System.currentTimeMillis() - j16));
                            if (!z17) {
                            }
                            aVar = this.$callback;
                            if (aVar != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        List list4 = list;
                        z19 = false;
                        list2 = list4;
                        w53.b.f("TAG_WinkSchemaPreCheck", "preCheckInner finish. cost " + (System.currentTimeMillis() - j16));
                        if (!z17) {
                        }
                        aVar = this.$callback;
                        if (aVar != null) {
                        }
                        return Unit.INSTANCE;
                    }
                    z16 = this.Z$0;
                    j16 = this.J$0;
                    list = (List) this.L$1;
                    deferred3 = (Deferred) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    await3 = obj;
                    boolean booleanValue2 = ((Boolean) await3).booleanValue();
                    this.L$0 = list;
                    this.L$1 = null;
                    this.J$0 = j16;
                    this.Z$0 = z16;
                    this.Z$1 = booleanValue2;
                    this.label = 4;
                    await4 = deferred3.await(this);
                    if (await4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z17 = z16;
                    z18 = booleanValue2;
                    booleanValue = ((Boolean) await4).booleanValue();
                    if (!z17) {
                    }
                } else {
                    z16 = this.Z$0;
                    long j19 = this.J$0;
                    deferred3 = (Deferred) this.L$1;
                    deferred2 = (Deferred) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    await2 = obj;
                    j16 = j19;
                    list = (List) await2;
                    this.L$0 = deferred3;
                    this.L$1 = list;
                    this.J$0 = j16;
                    this.Z$0 = z16;
                    this.label = 3;
                    await3 = deferred2.await(this);
                    if (await3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    boolean booleanValue22 = ((Boolean) await3).booleanValue();
                    this.L$0 = list;
                    this.L$1 = null;
                    this.J$0 = j16;
                    this.Z$0 = z16;
                    this.Z$1 = booleanValue22;
                    this.label = 4;
                    await4 = deferred3.await(this);
                    if (await4 == coroutine_suspended) {
                    }
                }
            } else {
                j3 = this.J$0;
                async$default4 = (Deferred) this.L$2;
                deferred = (Deferred) this.L$1;
                Deferred deferred4 = (Deferred) this.L$0;
                ResultKt.throwOnFailure(obj);
                await = obj;
                async$default2 = deferred4;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            long currentTimeMillis = System.currentTimeMillis();
            WinkCoroutineScopes winkCoroutineScopes = WinkCoroutineScopes.f317652a;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkSchemaPreCheck$preCheckInner$1$preCheckBaseBundleDeferred$1(this.$jumpTarget, this.$entryId, this.$costCollector, null), 2, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkSchemaPreCheck$preCheckInner$1$preCheckOnlineResDeferred$1(this.$keyAttrs, this.$costCollector, null), 2, null);
            async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkSchemaPreCheck$preCheckInner$1$preCheckDownloadMaterialDeferred$1(this.$jumpTarget, this.$keyAttrs, this.$businessName, this.$costCollector, null), 2, null);
            async$default4 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkSchemaPreCheck$preCheckInner$1$preCheckUserInfoDeferred$1(this.$keyAttrs, this.$costCollector, null), 2, null);
            this.L$0 = async$default2;
            this.L$1 = async$default3;
            this.L$2 = async$default4;
            this.J$0 = currentTimeMillis;
            this.label = 1;
            await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            j3 = currentTimeMillis;
            deferred = async$default3;
        }
        boolean booleanValue3 = ((Boolean) await).booleanValue();
        this.L$0 = async$default2;
        this.L$1 = async$default4;
        this.L$2 = null;
        this.J$0 = j3;
        this.Z$0 = booleanValue3;
        this.label = 2;
        await2 = deferred.await(this);
        if (await2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        j16 = j3;
        deferred2 = async$default2;
        deferred3 = async$default4;
        z16 = booleanValue3;
        list = (List) await2;
        this.L$0 = deferred3;
        this.L$1 = list;
        this.J$0 = j16;
        this.Z$0 = z16;
        this.label = 3;
        await3 = deferred2.await(this);
        if (await3 == coroutine_suspended) {
        }
        boolean booleanValue222 = ((Boolean) await3).booleanValue();
        this.L$0 = list;
        this.L$1 = null;
        this.J$0 = j16;
        this.Z$0 = z16;
        this.Z$1 = booleanValue222;
        this.label = 4;
        await4 = deferred3.await(this);
        if (await4 == coroutine_suspended) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkSchemaPreCheck$preCheckInner$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
