package com.tencent.mobileqq.wink.schema;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preCheckBaseBundle$2", f = "WinkSchemaPreCheck.kt", i = {0, 0, 0}, l = {302}, m = "invokeSuspend", n = {"destination$iv$iv", "startTime", "checkAEKit"}, s = {"L$0", "J$0", "I$0"})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheck$preCheckBaseBundle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ HashMap<String, Object> $costCollector;
    final /* synthetic */ String $entryId;
    final /* synthetic */ String $jumpTarget;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preCheckBaseBundle$2$1", f = "WinkSchemaPreCheck.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preCheckBaseBundle$2$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ HashMap<String, Object> $costCollector;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HashMap<String, Object> hashMap, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$costCollector = hashMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$costCollector, continuation);
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
                WinkSchemaPreCheck winkSchemaPreCheck = WinkSchemaPreCheck.f326271a;
                String str = AEResInfo.AE_RES_BASE_PACKAGE.agentType;
                Intrinsics.checkNotNullExpressionValue(str, "AE_RES_BASE_PACKAGE.agentType");
                HashMap<String, Object> hashMap = this.$costCollector;
                this.label = 1;
                obj = winkSchemaPreCheck.p(str, hashMap, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return obj;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheck$preCheckBaseBundle$2(String str, String str2, HashMap<String, Object> hashMap, Continuation<? super WinkSchemaPreCheck$preCheckBaseBundle$2> continuation) {
        super(2, continuation);
        this.$jumpTarget = str;
        this.$entryId = str2;
        this.$costCollector = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkSchemaPreCheck$preCheckBaseBundle$2 winkSchemaPreCheck$preCheckBaseBundle$2 = new WinkSchemaPreCheck$preCheckBaseBundle$2(this.$jumpTarget, this.$entryId, this.$costCollector, continuation);
        winkSchemaPreCheck$preCheckBaseBundle$2.L$0 = obj;
        return winkSchemaPreCheck$preCheckBaseBundle$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00e7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0101 -> B:5:0x0103). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int i3;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        List mutableListOf;
        int collectionSizeOrDefault;
        Collection arrayList;
        Iterator it;
        long j3;
        int i16;
        WinkSchemaPreCheck$preCheckBaseBundle$2 winkSchemaPreCheck$preCheckBaseBundle$2;
        Deferred async$default4;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        boolean z16 = false;
        if (i17 != 0) {
            if (i17 == 1) {
                i16 = this.I$0;
                j3 = this.J$0;
                arrayList = (Collection) this.L$2;
                Iterator it5 = (Iterator) this.L$1;
                Collection collection = (Collection) this.L$0;
                ResultKt.throwOnFailure(obj);
                winkSchemaPreCheck$preCheckBaseBundle$2 = this;
                Iterator it6 = it5;
                Collection collection2 = collection;
                Object await = obj;
                arrayList.add(Boxing.boxBoolean(((Boolean) await).booleanValue()));
                arrayList = collection2;
                it = it6;
                if (it.hasNext()) {
                    Deferred deferred = (Deferred) it.next();
                    winkSchemaPreCheck$preCheckBaseBundle$2.L$0 = arrayList;
                    winkSchemaPreCheck$preCheckBaseBundle$2.L$1 = it;
                    winkSchemaPreCheck$preCheckBaseBundle$2.L$2 = arrayList;
                    winkSchemaPreCheck$preCheckBaseBundle$2.J$0 = j3;
                    winkSchemaPreCheck$preCheckBaseBundle$2.I$0 = i16;
                    winkSchemaPreCheck$preCheckBaseBundle$2.label = 1;
                    await = deferred.await(winkSchemaPreCheck$preCheckBaseBundle$2);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it6 = it;
                    collection2 = arrayList;
                    arrayList.add(Boxing.boxBoolean(((Boolean) await).booleanValue()));
                    arrayList = collection2;
                    it = it6;
                    if (it.hasNext()) {
                        boolean z17 = !((List) arrayList).contains(Boxing.boxBoolean(false));
                        if (z17) {
                            IAECameraLauncher iAECameraLauncher = (IAECameraLauncher) QRoute.api(IAECameraLauncher.class);
                            String str = winkSchemaPreCheck$preCheckBaseBundle$2.$entryId;
                            if (i16 != 0) {
                                z16 = true;
                            }
                            iAECameraLauncher.isFlashCameraResReady(str, z16);
                        }
                        long currentTimeMillis = System.currentTimeMillis() - j3;
                        winkSchemaPreCheck$preCheckBaseBundle$2.$costCollector.put(MiniAppConst.MENU_STYLE_LIGHT, Boxing.boxLong(currentTimeMillis));
                        w53.b.f("TAG_WinkSchemaPreCheck", "preCheckBaseBundle finish result = " + z17 + ". cost " + currentTimeMillis);
                        return Boxing.boxBoolean(z17);
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!Intrinsics.areEqual("3", this.$jumpTarget) && !Intrinsics.areEqual("7", this.$jumpTarget) && !Intrinsics.areEqual("6", this.$jumpTarget) && !Intrinsics.areEqual("1001", this.$jumpTarget)) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            WinkCoroutineScopes winkCoroutineScopes = WinkCoroutineScopes.f317652a;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkSchemaPreCheck$preCheckBaseBundle$2$deferredList$1(this.$costCollector, null), 2, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkSchemaPreCheck$preCheckBaseBundle$2$deferredList$2(this.$costCollector, null), 2, null);
            async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkSchemaPreCheck$preCheckBaseBundle$2$deferredList$3(this.$costCollector, null), 2, null);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(async$default, async$default2, async$default3);
            if (i3 != 0) {
                async$default4 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AnonymousClass1(this.$costCollector, null), 3, null);
                mutableListOf.add(async$default4);
            }
            List list = mutableListOf;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            it = list.iterator();
            j3 = currentTimeMillis2;
            i16 = i3;
            winkSchemaPreCheck$preCheckBaseBundle$2 = this;
            if (it.hasNext()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((WinkSchemaPreCheck$preCheckBaseBundle$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
