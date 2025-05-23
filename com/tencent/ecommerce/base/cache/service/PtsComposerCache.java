package com.tencent.ecommerce.base.cache.service;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.httpcore.message.TokenParser;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003Bk\u0012\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010)\u0012\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0)\u0012\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010.0)\u0012\"\b\u0002\u00102\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\u001700\u00a2\u0006\u0004\b3\u00104J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\bH\u0007JP\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\b2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007J)\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00170\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R \u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R \u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010+R\"\u0010/\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010.0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010+R.\u00102\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\u0017008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "DataType", "KeyType", "", "", "keys", "", "k", "Lkotlin/Function0;", "listGenerator", "j", "", "pageName", "oldListGenerator", "newListGenerator", "Lkotlinx/coroutines/CoroutineDispatcher;", "workerDispatcher", "processor", h.F, "newList", "f", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "Lcom/tencent/pts/core/PTSComposer;", "g", "(Ljava/lang/Object;)Lcom/tencent/pts/core/PTSComposer;", "a", "Ljava/lang/String;", "TAG", "", "b", "Ljava/util/Map;", "ptsComposers", "Lkotlinx/coroutines/sync/Mutex;", "c", "Lkotlinx/coroutines/sync/Mutex;", "lastJobMutex", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "lastJob", "Lkotlin/Function1;", "e", "Lkotlin/jvm/functions/Function1;", "keyGenerator", "jsonStrGenerator", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "ptsListenerGenerator", "Lkotlin/Function3;", "Lkotlin/jvm/functions/Function3;", "composerBuilder", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class PtsComposerCache<DataType, KeyType> {

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: from kotlin metadata */
    private final Map<KeyType, PTSComposer> ptsComposers;

    /* renamed from: c, reason: from kotlin metadata */
    private final Mutex lastJobMutex;

    /* renamed from: d, reason: from kotlin metadata */
    private Job lastJob;

    /* renamed from: e, reason: from kotlin metadata */
    private final Function1<DataType, KeyType> keyGenerator;

    /* renamed from: f, reason: from kotlin metadata */
    private final Function1<DataType, String> jsonStrGenerator;

    /* renamed from: g, reason: from kotlin metadata */
    private final Function1<KeyType, IPTSLiteEventListener> ptsListenerGenerator;

    /* renamed from: h */
    private final Function3<String, String, IPTSLiteEventListener, PTSComposer> composerBuilder;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0005\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "DataType", "KeyType", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Void;"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.cache.service.PtsComposerCache$1 */
    /* loaded from: classes32.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1 {
        public static final AnonymousClass1 INSTANCE = ;

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(KeyType keytype) {
            return null;
        }

        AnonymousClass1() {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((AnonymousClass1) obj);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0015\u0010\u0004\u001a\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b2\u0015\u0010\t\u001a\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n2\u0017\u0010\u000b\u001a\u0013\u0018\u00010\f\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u00a2\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "Lcom/tencent/pts/core/PTSComposer;", "DataType", "KeyType", "p1", "", "Lkotlin/ParameterName;", "name", "PAGE_NAME", "p2", "jsonData", "p3", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "listener", "invoke"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.cache.service.PtsComposerCache$2 */
    /* loaded from: classes32.dex */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function3<String, String, IPTSLiteEventListener, PTSComposer> {
        AnonymousClass2(ECPTSStyleManager eCPTSStyleManager) {
            super(3, eCPTSStyleManager, ECPTSStyleManager.class, "buildPTSComposer", "buildPTSComposer(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/pts/core/lite/IPTSLiteEventListener;)Lcom/tencent/pts/core/PTSComposer;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public final PTSComposer invoke(String str, String str2, IPTSLiteEventListener iPTSLiteEventListener) {
            return ((ECPTSStyleManager) this.receiver).c(str, str2, iPTSLiteEventListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PtsComposerCache(Function1<? super DataType, ? extends KeyType> function1, Function1<? super DataType, String> function12, Function1<? super KeyType, ? extends IPTSLiteEventListener> function13, Function3<? super String, ? super String, ? super IPTSLiteEventListener, ? extends PTSComposer> function3) {
        CompletableJob Job$default;
        this.keyGenerator = function1;
        this.jsonStrGenerator = function12;
        this.ptsListenerGenerator = function13;
        this.composerBuilder = function3;
        this.TAG = "PtsComposerCache";
        this.ptsComposers = new LinkedHashMap();
        this.lastJobMutex = MutexKt.Mutex$default(false, 1, null);
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.lastJob = Job$default;
    }

    public final void k(List<? extends KeyType> keys) {
        for (Object obj : keys) {
            cg0.a.b(this.TAG, "removing composer: " + obj);
            PTSComposer remove = this.ptsComposers.remove(obj);
            if (remove != null) {
                remove.destroy();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object f(List<? extends DataType> list, String str, Continuation<? super Unit> continuation) {
        PtsComposerCache$generateNewList$1 ptsComposerCache$generateNewList$1;
        Object coroutine_suspended;
        int i3;
        List mutableList;
        Iterator it;
        PtsComposerCache<DataType, KeyType> ptsComposerCache;
        if (continuation instanceof PtsComposerCache$generateNewList$1) {
            ptsComposerCache$generateNewList$1 = (PtsComposerCache$generateNewList$1) continuation;
            int i16 = ptsComposerCache$generateNewList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                ptsComposerCache$generateNewList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = ptsComposerCache$generateNewList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = ptsComposerCache$generateNewList$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                    it = mutableList.iterator();
                    ptsComposerCache = this;
                } else if (i3 == 1) {
                    it = (Iterator) ptsComposerCache$generateNewList$1.L$2;
                    str = (String) ptsComposerCache$generateNewList$1.L$1;
                    ptsComposerCache = (PtsComposerCache) ptsComposerCache$generateNewList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    Object invoke = ptsComposerCache.keyGenerator.invoke(next);
                    if (!ptsComposerCache.ptsComposers.containsKey(invoke)) {
                        cg0.a.b(ptsComposerCache.TAG, "generating composer key = " + invoke);
                        ptsComposerCache.ptsComposers.put(invoke, ECPTSStyleManager.f100993b.c(str, (String) ptsComposerCache.jsonStrGenerator.invoke(next), (IPTSLiteEventListener) ptsComposerCache.ptsListenerGenerator.invoke(invoke)));
                        cg0.a.b(ptsComposerCache.TAG, "generated composer key = " + invoke);
                    } else {
                        cg0.a.b(ptsComposerCache.TAG, "composer already exists key = " + invoke);
                    }
                    ptsComposerCache$generateNewList$1.L$0 = ptsComposerCache;
                    ptsComposerCache$generateNewList$1.L$1 = str;
                    ptsComposerCache$generateNewList$1.L$2 = it;
                    ptsComposerCache$generateNewList$1.label = 1;
                    if (YieldKt.yield(ptsComposerCache$generateNewList$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        ptsComposerCache$generateNewList$1 = new PtsComposerCache$generateNewList$1(this, continuation);
        Object obj2 = ptsComposerCache$generateNewList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = ptsComposerCache$generateNewList$1.label;
        if (i3 != 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    public final PTSComposer g(DataType data) {
        cg0.a.b(this.TAG, "getting cached composer for key " + this.keyGenerator.invoke(data));
        PTSComposer pTSComposer = this.ptsComposers.get(this.keyGenerator.invoke(data));
        if (pTSComposer != null) {
            return pTSComposer;
        }
        if (!QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().isDebug()) {
            cg0.a.a(this.TAG, "getPtsComposer", "ptsComposer not exists " + this.keyGenerator.invoke(data) + TokenParser.SP + data);
            return null;
        }
        throw new IllegalStateException("ptsComposer \u7f13\u5b58\u4e0d\u5b58\u5728\uff01\u8c03\u7528\u672c\u7c7b\u65f6\uff0c\u8bf7\u52a1\u5fc5\u5728 processor \u65b9\u6cd5\u4e2d\u786e\u4fdd\u65e7\u7684 ptsComposer \u4e0d\u4f1a\u518d\u88ab\u4f7f\u7528\n\u8bf7\u67e5\u770b\u672c\u7c7b\u76f8\u5173\u4ee3\u7801\u6ce8\u91ca\u3002");
    }

    public final void h(String str, Function0<? extends List<? extends DataType>> function0, Function0<? extends List<? extends DataType>> function02, CoroutineDispatcher coroutineDispatcher, Function0<Unit> function03) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(coroutineDispatcher), null, null, new PtsComposerCache$preBuildPtsComposer$1(this, function0, function02, str, function03, null), 3, null);
    }

    public final void j(Function0<? extends List<? extends DataType>> listGenerator) {
        int collectionSizeOrDefault;
        List<? extends DataType> invoke = listGenerator.invoke();
        Function1<DataType, KeyType> function1 = this.keyGenerator;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(invoke, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = invoke.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke(it.next()));
        }
        k(arrayList);
    }

    public static /* synthetic */ void i(PtsComposerCache ptsComposerCache, String str, Function0 function0, Function0 function02, CoroutineDispatcher coroutineDispatcher, Function0 function03, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            coroutineDispatcher = Dispatchers.getDefault();
        }
        ptsComposerCache.h(str, function0, function02, coroutineDispatcher, function03);
    }

    public /* synthetic */ PtsComposerCache(Function1 function1, Function1 function12, Function1 function13, Function3 function3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, (i3 & 4) != 0 ? AnonymousClass1.INSTANCE : function13, (i3 & 8) != 0 ? new AnonymousClass2(ECPTSStyleManager.f100993b) : function3);
    }
}
