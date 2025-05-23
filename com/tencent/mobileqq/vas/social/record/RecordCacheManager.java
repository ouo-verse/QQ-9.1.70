package com.tencent.mobileqq.vas.social.record;

import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.zplan.meme.action.MODE;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J.\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/social/record/RecordCacheManager;", "", "Lcom/tencent/state/square/record/RecordIdentifier;", "recordIdentifier", "", "actionId", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "a", "c", "Lcom/tencent/mobileqq/vas/social/record/g;", "b", "state", "product", "", "d", "g", "f", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "stepCache", "productCache", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RecordCacheManager {

    /* renamed from: a, reason: collision with root package name */
    public static final RecordCacheManager f310795a = new RecordCacheManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, String> stepCache = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, RecordStepProduct> productCache = new ConcurrentHashMap<>();

    RecordCacheManager() {
    }

    private final String a(RecordIdentifier recordIdentifier, int actionId, MODE mode) {
        final StringBuilder sb5 = new StringBuilder();
        Iterator<T> it = recordIdentifier.getAllUinList().iterator();
        while (it.hasNext()) {
            ((UserIdentifier) it.next()).getDressKey(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.vas.social.record.RecordCacheManager$getMemoryKey$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String dressKey) {
                    Intrinsics.checkNotNullParameter(dressKey, "dressKey");
                    sb5.append(dressKey + "_");
                }
            });
        }
        sb5.append(actionId + "_");
        sb5.append(mode.name());
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    private final RecordStepProduct b(RecordIdentifier recordIdentifier, int actionId, MODE mode) {
        RecordStepProduct recordStepProduct;
        String a16 = a(recordIdentifier, actionId, mode);
        ConcurrentHashMap<String, RecordStepProduct> concurrentHashMap = productCache;
        synchronized (concurrentHashMap) {
            recordStepProduct = concurrentHashMap.get(a16);
            if (recordStepProduct == null) {
                recordStepProduct = new RecordStepProduct(null, null, null, null, null, 31, null);
            } else {
                Intrinsics.checkNotNullExpressionValue(recordStepProduct, "productCache[key] ?: RecordStepProduct()");
            }
        }
        return recordStepProduct;
    }

    private final String c(RecordIdentifier recordIdentifier, int actionId, MODE mode) {
        String str;
        String a16 = a(recordIdentifier, actionId, mode);
        ConcurrentHashMap<String, String> concurrentHashMap = stepCache;
        synchronized (concurrentHashMap) {
            str = concurrentHashMap.get(a16);
            if (str == null) {
                str = "UN_RECORDED";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "stepCache[key] ?: RecordState.UN_RECORDED.name");
            }
        }
        return str;
    }

    private final void d(RecordIdentifier recordIdentifier, int actionId, String state, RecordStepProduct product, MODE mode) {
        String a16 = a(recordIdentifier, actionId, mode);
        ConcurrentHashMap<String, String> concurrentHashMap = stepCache;
        synchronized (concurrentHashMap) {
            concurrentHashMap.put(a16, state);
            ConcurrentHashMap<String, RecordStepProduct> concurrentHashMap2 = productCache;
            synchronized (concurrentHashMap2) {
                concurrentHashMap2.put(a16, product);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final RecordStepProduct e(RecordIdentifier recordIdentifier, int actionId, MODE mode) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(mode, "mode");
        RecordStepProduct b16 = b(recordIdentifier, actionId, mode);
        QLog.d("RecordCacheManager", 4, "queryState cacheState:" + b16);
        return b16;
    }

    public final String f(RecordIdentifier recordIdentifier, int actionId, MODE mode) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(mode, "mode");
        String c16 = c(recordIdentifier, actionId, mode);
        QLog.d("RecordCacheManager", 4, "queryState cacheState:" + c16);
        return c16;
    }

    public final void g(RecordIdentifier recordIdentifier, int actionId, String state, RecordStepProduct product, MODE mode) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(mode, "mode");
        d(recordIdentifier, actionId, state, product, mode);
    }
}
