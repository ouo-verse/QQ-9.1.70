package com.tencent.mobileqq.wink.schema;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preCheckOnlineMedia$2", f = "WinkSchemaPreCheck.kt", i = {0, 0, 0, 0}, l = {360}, m = "invokeSuspend", n = {"needDownloadPaths", "resultPaths", "destination$iv$iv", "startTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheck$preCheckOnlineMedia$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ HashMap<String, Object> $costCollector;
    final /* synthetic */ ConcurrentHashMap<String, String> $keyAttrs;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheck$preCheckOnlineMedia$2(ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, Object> hashMap, Continuation<? super WinkSchemaPreCheck$preCheckOnlineMedia$2> continuation) {
        super(2, continuation);
        this.$keyAttrs = concurrentHashMap;
        this.$costCollector = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkSchemaPreCheck$preCheckOnlineMedia$2(this.$keyAttrs, this.$costCollector, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00b0  */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x00d6 -> B:5:0x00df). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long currentTimeMillis;
        List t16;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Collection collection;
        ArrayList arrayList;
        Iterator it;
        ArrayList arrayList2;
        WinkSchemaPreCheck$preCheckOnlineMedia$2 winkSchemaPreCheck$preCheckOnlineMedia$2;
        boolean startsWith$default;
        boolean startsWith$default2;
        String v3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                long j3 = this.J$0;
                ?? r16 = (Collection) this.L$4;
                Iterator it5 = (Iterator) this.L$3;
                ?? r85 = (Collection) this.L$2;
                ?? r95 = (List) this.L$1;
                Collection collection2 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                Collection collection3 = collection2;
                ArrayList arrayList3 = r95;
                Iterator it6 = it5;
                long j16 = j3;
                ArrayList arrayList4 = r16;
                Object obj2 = coroutine_suspended;
                WinkSchemaPreCheck$preCheckOnlineMedia$2 winkSchemaPreCheck$preCheckOnlineMedia$22 = this;
                ArrayList arrayList5 = r85;
                arrayList4.add(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
                winkSchemaPreCheck$preCheckOnlineMedia$2 = winkSchemaPreCheck$preCheckOnlineMedia$22;
                coroutine_suspended = obj2;
                currentTimeMillis = j16;
                arrayList2 = arrayList5;
                it = it6;
                arrayList = arrayList3;
                collection = collection3;
                if (it.hasNext()) {
                    String str = (String) it.next();
                    CoroutineDispatcher b16 = WinkCoroutineScopes.f317652a.b();
                    WinkSchemaPreCheck$preCheckOnlineMedia$2$downloadResult$1$1 winkSchemaPreCheck$preCheckOnlineMedia$2$downloadResult$1$1 = new WinkSchemaPreCheck$preCheckOnlineMedia$2$downloadResult$1$1(str, null);
                    winkSchemaPreCheck$preCheckOnlineMedia$2.L$0 = collection;
                    winkSchemaPreCheck$preCheckOnlineMedia$2.L$1 = arrayList;
                    winkSchemaPreCheck$preCheckOnlineMedia$2.L$2 = arrayList2;
                    winkSchemaPreCheck$preCheckOnlineMedia$2.L$3 = it;
                    winkSchemaPreCheck$preCheckOnlineMedia$2.L$4 = arrayList2;
                    winkSchemaPreCheck$preCheckOnlineMedia$2.J$0 = currentTimeMillis;
                    winkSchemaPreCheck$preCheckOnlineMedia$2.label = 1;
                    Object withContext = BuildersKt.withContext(b16, winkSchemaPreCheck$preCheckOnlineMedia$2$downloadResult$1$1, winkSchemaPreCheck$preCheckOnlineMedia$2);
                    if (withContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    collection3 = collection;
                    arrayList3 = arrayList;
                    it6 = it;
                    j16 = currentTimeMillis;
                    arrayList4 = arrayList2;
                    obj2 = coroutine_suspended;
                    winkSchemaPreCheck$preCheckOnlineMedia$22 = winkSchemaPreCheck$preCheckOnlineMedia$2;
                    obj = withContext;
                    arrayList5 = arrayList4;
                    arrayList4.add(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
                    winkSchemaPreCheck$preCheckOnlineMedia$2 = winkSchemaPreCheck$preCheckOnlineMedia$22;
                    coroutine_suspended = obj2;
                    currentTimeMillis = j16;
                    arrayList2 = arrayList5;
                    it = it6;
                    arrayList = arrayList3;
                    collection = collection3;
                    if (it.hasNext()) {
                        ConcurrentHashMap<String, String> concurrentHashMap = winkSchemaPreCheck$preCheckOnlineMedia$2.$keyAttrs;
                        v3 = WinkSchemaPreCheck.f326271a.v(arrayList);
                        concurrentHashMap.put("mediapath", v3);
                        boolean z16 = !arrayList2.contains(Boxing.boxBoolean(false));
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        winkSchemaPreCheck$preCheckOnlineMedia$2.$costCollector.put(QAdVrReportParams.ParamKey.MEDIA, Boxing.boxLong(currentTimeMillis2));
                        w53.b.f("TAG_WinkSchemaPreCheck", "preCheckOnlineMedia finish needDownloadPaths = " + collection + ", result = " + z16 + ". cost " + currentTimeMillis2);
                        return Boxing.boxBoolean(z16);
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            currentTimeMillis = System.currentTimeMillis();
            t16 = WinkSchemaPreCheck.f326271a.t(this.$keyAttrs);
            List<String> list = t16;
            Collection arrayList6 = new ArrayList();
            for (Object obj3 : list) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default((String) obj3, "http", false, 2, null);
                if (startsWith$default2) {
                    arrayList6.add(obj3);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList7 = new ArrayList(collectionSizeOrDefault);
            for (String str2 : list) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, "http", false, 2, null);
                if (startsWith$default) {
                    str2 = WinkSchemaPreCheck.f326271a.x(str2);
                }
                arrayList7.add(str2);
            }
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList6, 10);
            ArrayList arrayList8 = new ArrayList(collectionSizeOrDefault2);
            collection = arrayList6;
            arrayList = arrayList7;
            it = arrayList6.iterator();
            arrayList2 = arrayList8;
            winkSchemaPreCheck$preCheckOnlineMedia$2 = this;
            if (it.hasNext()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((WinkSchemaPreCheck$preCheckOnlineMedia$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
