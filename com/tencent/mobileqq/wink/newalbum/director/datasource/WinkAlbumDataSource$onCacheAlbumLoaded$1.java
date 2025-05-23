package com.tencent.mobileqq.wink.newalbum.director.datasource;

import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.director.datasource.WinkAlbumDataSource$onCacheAlbumLoaded$1", f = "WinkAlbumDataSource.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAlbumDataSource$onCacheAlbumLoaded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<WinkNewMemoryAlbumResult> $newAlbumResults;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.director.datasource.WinkAlbumDataSource$onCacheAlbumLoaded$1$1", f = "WinkAlbumDataSource.kt", i = {}, l = {275}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.director.datasource.WinkAlbumDataSource$onCacheAlbumLoaded$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<WinkNewMemoryAlbumResult> $newAlbumResults;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<WinkNewMemoryAlbumResult> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$newAlbumResults = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$newAlbumResults, continuation);
        }

        /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v9, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            List<WinkNewMemoryAlbumResult> F;
            Iterator it;
            Object E;
            WinkNewAlbumDatabaseImp winkNewAlbumDatabaseImp;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    it = (Iterator) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                WinkAlbumDataSource winkAlbumDataSource = WinkAlbumDataSource.f324204a;
                QLog.e(winkAlbumDataSource.c(), 1, "onCacheAlbumLoaded start");
                ArrayList arrayList = new ArrayList();
                LinkedList linkedList = new LinkedList();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                F = winkAlbumDataSource.F(this.$newAlbumResults);
                for (WinkNewMemoryAlbumResult winkNewMemoryAlbumResult : F) {
                    while ((!linkedList.isEmpty()) && !Intrinsics.areEqual(((WinkNewMemoryAlbumResult) linkedList.peek()).getStoryID(), objectRef.element)) {
                        WinkNewMemoryAlbumResult toInsert = (WinkNewMemoryAlbumResult) linkedList.poll();
                        Intrinsics.checkNotNullExpressionValue(toInsert, "toInsert");
                        arrayList.add(toInsert);
                        objectRef.element = toInsert.getStoryID();
                    }
                    if (Intrinsics.areEqual(winkNewMemoryAlbumResult.getStoryID(), objectRef.element)) {
                        linkedList.add(winkNewMemoryAlbumResult);
                    } else {
                        arrayList.add(winkNewMemoryAlbumResult);
                        objectRef.element = winkNewMemoryAlbumResult.getStoryID();
                    }
                }
                while (!linkedList.isEmpty()) {
                    WinkNewMemoryAlbumResult toInsert2 = (WinkNewMemoryAlbumResult) linkedList.poll();
                    Intrinsics.checkNotNullExpressionValue(toInsert2, "toInsert");
                    arrayList.add(toInsert2);
                }
                it = arrayList.iterator();
            }
            while (it.hasNext()) {
                WinkNewMemoryAlbumResult winkNewMemoryAlbumResult2 = (WinkNewMemoryAlbumResult) it.next();
                Iterator<z83.a> it5 = winkNewMemoryAlbumResult2.i().iterator();
                String str = "";
                boolean z16 = true;
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    try {
                        str = it5.next().getPath();
                    } catch (Exception e16) {
                        QLog.e(WinkAlbumDataSource.TAG, 1, e16, new Object[0]);
                        z16 = false;
                    }
                    if (!new File(str).exists()) {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    WinkAlbumDataSource winkAlbumDataSource2 = WinkAlbumDataSource.f324204a;
                    this.L$0 = it;
                    this.label = 1;
                    E = winkAlbumDataSource2.E(winkNewMemoryAlbumResult2, this);
                    if (E == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    QLog.e(WinkAlbumDataSource.f324204a.c(), 1, "onCacheAlbumLoaded file not exist:" + str);
                    winkNewAlbumDatabaseImp = WinkAlbumDataSource.winkNewAlbumDatabaseImp;
                    winkNewAlbumDatabaseImp.v(winkNewMemoryAlbumResult2.getAlbumID());
                }
            }
            QLog.e(WinkAlbumDataSource.f324204a.c(), 1, "onCacheAlbumLoaded end");
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAlbumDataSource$onCacheAlbumLoaded$1(List<WinkNewMemoryAlbumResult> list, Continuation<? super WinkAlbumDataSource$onCacheAlbumLoaded$1> continuation) {
        super(2, continuation);
        this.$newAlbumResults = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAlbumDataSource$onCacheAlbumLoaded$1(this.$newAlbumResults, continuation);
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
            CoroutineDispatcher io5 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$newAlbumResults, null);
            this.label = 1;
            if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAlbumDataSource$onCacheAlbumLoaded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
