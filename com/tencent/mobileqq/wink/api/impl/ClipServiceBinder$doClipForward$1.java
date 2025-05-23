package com.tencent.mobileqq.wink.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wink.api.IWinkWeClipApi;
import com.tencent.mobileqq.wink.model.MediaScanForwardResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.api.impl.ClipServiceBinder$doClipForward$1", f = "ClipServiceBinder.kt", i = {0}, l = {188, 196}, m = "invokeSuspend", n = {"destination$iv$iv"}, s = {"L$1"})
/* loaded from: classes21.dex */
final class ClipServiceBinder$doClipForward$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.wink.api.a $callback;
    final /* synthetic */ List<String> $uris;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ClipServiceBinder this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/api/impl/ClipServiceBinder$doClipForward$1$a", "Li83/h;", "", "Lkotlin/Pair;", "", "", com.tencent.rmonitor.base.config.data.k.FEATURES_KEY, "", "onSuccess", "onFail", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements i83.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.api.a f317970a;

        a(com.tencent.mobileqq.wink.api.a aVar) {
            this.f317970a = aVar;
        }

        @Override // i83.h
        public void onFail() {
            List<MediaScanForwardResult> emptyList;
            w53.b.c("ClipServiceBinder", "doClipForward, fail");
            com.tencent.mobileqq.wink.api.a aVar = this.f317970a;
            if (aVar != null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                aVar.R(emptyList);
            }
        }

        @Override // i83.h
        public void onSuccess(@NotNull List<Pair<String, float[]>> features) {
            int collectionSizeOrDefault;
            int lastIndex;
            boolean z16;
            Intrinsics.checkNotNullParameter(features, "features");
            w53.b.a("ClipServiceBinder", "doClipForward, features: " + features.size());
            com.tencent.mobileqq.wink.api.a aVar = this.f317970a;
            if (aVar != null) {
                List<Pair<String, float[]>> list = features;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                int i3 = 0;
                for (Object obj : list) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    Pair pair = (Pair) obj;
                    String str = (String) pair.getFirst();
                    float[] fArr = (float[]) pair.getSecond();
                    lastIndex = CollectionsKt__CollectionsKt.getLastIndex(features);
                    if (i3 == lastIndex) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    arrayList.add(new MediaScanForwardResult(str, "", fArr, true, z16, 224, 224));
                    i3 = i16;
                }
                aVar.R(arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipServiceBinder$doClipForward$1(List<String> list, ClipServiceBinder clipServiceBinder, com.tencent.mobileqq.wink.api.a aVar, Continuation<? super ClipServiceBinder$doClipForward$1> continuation) {
        super(2, continuation);
        this.$uris = list;
        this.this$0 = clipServiceBinder;
        this.$callback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ClipServiceBinder$doClipForward$1(this.$uris, this.this$0, this.$callback, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c7 A[Catch: Exception -> 0x00f1, TryCatch #2 {Exception -> 0x00f1, blocks: (B:8:0x00be, B:12:0x00c7, B:15:0x00ca, B:25:0x0070, B:27:0x0074), top: B:24:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ca A[Catch: Exception -> 0x00f1, TRY_LEAVE, TryCatch #2 {Exception -> 0x00f1, blocks: (B:8:0x00be, B:12:0x00c7, B:15:0x00ca, B:25:0x0070, B:27:0x0074), top: B:24:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074 A[Catch: Exception -> 0x00f1, TRY_LEAVE, TryCatch #2 {Exception -> 0x00f1, blocks: (B:8:0x00be, B:12:0x00c7, B:15:0x00ca, B:25:0x0070, B:27:0x0074), top: B:24:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0054 A[Catch: Exception -> 0x00f3, TRY_LEAVE, TryCatch #1 {Exception -> 0x00f3, blocks: (B:30:0x004e, B:32:0x0054, B:36:0x007d, B:38:0x009e, B:40:0x00a1), top: B:29:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007d A[Catch: Exception -> 0x00f3, TRY_ENTER, TryCatch #1 {Exception -> 0x00f3, blocks: (B:30:0x004e, B:32:0x0054, B:36:0x007d, B:38:0x009e, B:40:0x00a1), top: B:29:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0117  */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0069 -> B:24:0x0070). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ClipServiceBinder$doClipForward$1 clipServiceBinder$doClipForward$1;
        com.tencent.mobileqq.wink.api.a aVar;
        List<MediaScanForwardResult> emptyList;
        ArrayList arrayList;
        ClipServiceBinder clipServiceBinder;
        Iterator it;
        ClipServiceBinder$doClipForward$1 clipServiceBinder$doClipForward$12;
        ClipServiceBinder$doClipForward$1 clipServiceBinder$doClipForward$13;
        Object s16;
        Pair<String, Bitmap>[] pairArr;
        IWinkWeClipApi iWinkWeClipApi;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        try {
        } catch (Exception e16) {
            e = e16;
            clipServiceBinder$doClipForward$1 = this;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    clipServiceBinder$doClipForward$13 = this;
                    pairArr = (Pair[]) obj;
                    if (pairArr.length == 0) {
                        z16 = false;
                    }
                    if (!z16) {
                        return Unit.INSTANCE;
                    }
                    w53.b.a("ClipServiceBinder", "doClipForward, bitmapPairs: " + pairArr.length);
                    iWinkWeClipApi = clipServiceBinder$doClipForward$13.this$0.winkApi;
                    iWinkWeClipApi.doClipForward(pairArr, new a(clipServiceBinder$doClipForward$13.$callback));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Iterator it5 = (Iterator) this.L$2;
            ?? r56 = (Collection) this.L$1;
            ClipServiceBinder clipServiceBinder2 = (ClipServiceBinder) this.L$0;
            ResultKt.throwOnFailure(obj);
            ClipServiceBinder clipServiceBinder3 = clipServiceBinder2;
            ArrayList arrayList2 = r56;
            Iterator it6 = it5;
            Object obj2 = coroutine_suspended;
            clipServiceBinder$doClipForward$1 = this;
            try {
                try {
                    Pair pair = (Pair) obj;
                    if (pair != null) {
                        arrayList2.add(pair);
                    }
                    if (it.hasNext()) {
                        String str = (String) it.next();
                        clipServiceBinder$doClipForward$12.L$0 = clipServiceBinder;
                        clipServiceBinder$doClipForward$12.L$1 = arrayList;
                        clipServiceBinder$doClipForward$12.L$2 = it;
                        clipServiceBinder$doClipForward$12.label = 1;
                        s16 = clipServiceBinder.s1(str, clipServiceBinder$doClipForward$12);
                        if (s16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        clipServiceBinder$doClipForward$1 = clipServiceBinder$doClipForward$12;
                        obj = s16;
                        clipServiceBinder3 = clipServiceBinder;
                        arrayList2 = arrayList;
                        it6 = it;
                        obj2 = obj3;
                        Pair pair2 = (Pair) obj;
                        if (pair2 != null) {
                        }
                        clipServiceBinder$doClipForward$12 = clipServiceBinder$doClipForward$1;
                        coroutine_suspended = obj2;
                        it = it6;
                        arrayList = arrayList2;
                        clipServiceBinder = clipServiceBinder3;
                        if (it.hasNext()) {
                            ArrayList arrayList3 = arrayList;
                            w53.b.a("ClipServiceBinder", "doClipForward, downloadResults: " + arrayList3.size());
                            if (arrayList3.isEmpty()) {
                                return Unit.INSTANCE;
                            }
                            CoroutineDispatcher io5 = Dispatchers.getIO();
                            ClipServiceBinder$doClipForward$1$bitmapPairs$1 clipServiceBinder$doClipForward$1$bitmapPairs$1 = new ClipServiceBinder$doClipForward$1$bitmapPairs$1(arrayList3, clipServiceBinder$doClipForward$12.this$0, null);
                            clipServiceBinder$doClipForward$12.L$0 = null;
                            clipServiceBinder$doClipForward$12.L$1 = null;
                            clipServiceBinder$doClipForward$12.L$2 = null;
                            clipServiceBinder$doClipForward$12.label = 2;
                            Object withContext = BuildersKt.withContext(io5, clipServiceBinder$doClipForward$1$bitmapPairs$1, clipServiceBinder$doClipForward$12);
                            if (withContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            clipServiceBinder$doClipForward$13 = clipServiceBinder$doClipForward$12;
                            obj = withContext;
                            pairArr = (Pair[]) obj;
                            if (pairArr.length == 0) {
                            }
                            if (!z16) {
                            }
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    w53.b.c("ClipServiceBinder", "doClipForward, exception: " + e.getMessage());
                    e.printStackTrace();
                    aVar = clipServiceBinder$doClipForward$1.$callback;
                    if (aVar != null) {
                    }
                    return Unit.INSTANCE;
                }
            } catch (Exception e18) {
                clipServiceBinder$doClipForward$1 = clipServiceBinder$doClipForward$12;
                e = e18;
                w53.b.c("ClipServiceBinder", "doClipForward, exception: " + e.getMessage());
                e.printStackTrace();
                aVar = clipServiceBinder$doClipForward$1.$callback;
                if (aVar != null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    aVar.R(emptyList);
                }
                return Unit.INSTANCE;
            }
            clipServiceBinder$doClipForward$12 = clipServiceBinder$doClipForward$1;
            coroutine_suspended = obj2;
            it = it6;
            arrayList = arrayList2;
            clipServiceBinder = clipServiceBinder3;
        } else {
            ResultKt.throwOnFailure(obj);
            List<String> list = this.$uris;
            ClipServiceBinder clipServiceBinder4 = this.this$0;
            arrayList = new ArrayList();
            clipServiceBinder = clipServiceBinder4;
            it = list.iterator();
            clipServiceBinder$doClipForward$12 = this;
            if (it.hasNext()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ClipServiceBinder$doClipForward$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
