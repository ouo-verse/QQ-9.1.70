package com.qzone.reborn.feedpro.utils;

import android.graphics.Bitmap;
import com.qzone.reborn.feedpro.utils.QzoneFeedProLongPicUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qzone.reborn.feedpro.utils.QzoneFeedProLongPicUtils$realSaveLongPic$1", f = "QzoneFeedProLongPicUtils.kt", i = {0}, l = {126, 127}, m = "invokeSuspend", n = {"tempSavePaths"}, s = {"L$0"})
/* loaded from: classes37.dex */
public final class QzoneFeedProLongPicUtils$realSaveLongPic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ QzoneFeedProLongPicUtils.a $callback;
    final /* synthetic */ List<String> $downloadPicList;
    final /* synthetic */ List<String> $localPathUrlList;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.qzone.reborn.feedpro.utils.QzoneFeedProLongPicUtils$realSaveLongPic$1$2", f = "QzoneFeedProLongPicUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qzone.reborn.feedpro.utils.QzoneFeedProLongPicUtils$realSaveLongPic$1$2, reason: invalid class name */
    /* loaded from: classes37.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ QzoneFeedProLongPicUtils.a $callback;
        final /* synthetic */ String[] $tempSavePaths;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String[] strArr, QzoneFeedProLongPicUtils.a aVar, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$tempSavePaths = strArr;
            this.$callback = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$tempSavePaths, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            List mutableList;
            Bitmap g16;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                list = ArraysKt___ArraysKt.toList(this.$tempSavePaths);
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                QzoneFeedProLongPicUtils qzoneFeedProLongPicUtils = QzoneFeedProLongPicUtils.f54255a;
                g16 = qzoneFeedProLongPicUtils.g(mutableList);
                qzoneFeedProLongPicUtils.h(mutableList);
                this.$callback.a(g16);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProLongPicUtils$realSaveLongPic$1(List<String> list, QzoneFeedProLongPicUtils.a aVar, List<String> list2, Continuation<? super QzoneFeedProLongPicUtils$realSaveLongPic$1> continuation) {
        super(2, continuation);
        this.$downloadPicList = list;
        this.$callback = aVar;
        this.$localPathUrlList = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QzoneFeedProLongPicUtils$realSaveLongPic$1 qzoneFeedProLongPicUtils$realSaveLongPic$1 = new QzoneFeedProLongPicUtils$realSaveLongPic$1(this.$downloadPicList, this.$callback, this.$localPathUrlList, continuation);
        qzoneFeedProLongPicUtils$realSaveLongPic$1.L$0 = obj;
        return qzoneFeedProLongPicUtils$realSaveLongPic$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QzoneFeedProLongPicUtils$realSaveLongPic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int collectionSizeOrDefault;
        String[] strArr;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (Exception e16) {
            RFWLog.e(QzoneFeedProLongPicUtils.f54255a.o(), RFWLog.USR, "realSaveLongPic error:" + e16);
            this.$callback.onFail();
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            strArr = (String[]) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            String[] strArr2 = new String[this.$downloadPicList.size()];
            List<String> list = this.$downloadPicList;
            List<String> list2 = list;
            List<String> list3 = this.$localPathUrlList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            int i16 = 0;
            for (Object obj2 : list2) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ArrayList arrayList2 = arrayList;
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new QzoneFeedProLongPicUtils$realSaveLongPic$1$1$1(list, i16, list3, strArr2, null), 2, null);
                arrayList2.add(async$default);
                arrayList = arrayList2;
                i16 = i17;
            }
            this.L$0 = strArr2;
            this.label = 1;
            if (AwaitKt.awaitAll(arrayList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            strArr = strArr2;
        }
        CoroutineDispatcher io5 = Dispatchers.getIO();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(strArr, this.$callback, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(io5, anonymousClass2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
