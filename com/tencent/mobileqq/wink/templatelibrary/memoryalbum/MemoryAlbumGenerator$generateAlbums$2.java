package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import android.os.SystemClock;
import com.tencent.mobileqq.wink.db.memoryalbumdb.WinkMemoryAlbumDBHelper;
import com.tencent.view.FilterEnum;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumGenerator$generateAlbums$2", f = "MemoryAlbumGenerator.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, l = {FilterEnum.MIC_PTU_TRANS_XINXIAN, FilterEnum.MIC_PTU_BAIXI, 288, 292, 294}, m = "invokeSuspend", n = {"queryAlbums", "start1", "start", "queryAlbums", "start1", "start", "queryAlbums", "start1", "queryAlbums", "start1", "start1"}, s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "L$0", "J$0", "J$0"})
/* loaded from: classes21.dex */
public final class MemoryAlbumGenerator$generateAlbums$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    long J$0;
    long J$1;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemoryAlbumGenerator$generateAlbums$2(Continuation<? super MemoryAlbumGenerator$generateAlbums$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MemoryAlbumGenerator$generateAlbums$2(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bc  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        long elapsedRealtime;
        long elapsedRealtime2;
        List<s53.a> list;
        Object h06;
        Object p06;
        long j3;
        WinkMemoryAlbumDBHelper winkMemoryAlbumDBHelper;
        long j16;
        Object u06;
        long j17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                j17 = this.J$0;
                                ResultKt.throwOnFailure(obj);
                                long elapsedRealtime3 = SystemClock.elapsedRealtime() - j17;
                                MemoryAlbumGenerator memoryAlbumGenerator = MemoryAlbumGenerator.f326501a;
                                memoryAlbumGenerator.j0(elapsedRealtime3);
                                w53.b.f(memoryAlbumGenerator.c(), "generateAlbums cost time " + elapsedRealtime3);
                                return Boxing.boxBoolean(true);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j16 = this.J$0;
                        list = (List) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        MemoryAlbumGenerator memoryAlbumGenerator2 = MemoryAlbumGenerator.f326501a;
                        this.L$0 = null;
                        this.J$0 = j16;
                        this.label = 5;
                        u06 = memoryAlbumGenerator2.u0(list, this);
                        if (u06 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        j17 = j16;
                        long elapsedRealtime32 = SystemClock.elapsedRealtime() - j17;
                        MemoryAlbumGenerator memoryAlbumGenerator3 = MemoryAlbumGenerator.f326501a;
                        memoryAlbumGenerator3.j0(elapsedRealtime32);
                        w53.b.f(memoryAlbumGenerator3.c(), "generateAlbums cost time " + elapsedRealtime32);
                        return Boxing.boxBoolean(true);
                    }
                    j3 = this.J$0;
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    MemoryAlbumGenerator.f326501a.n0(list);
                    winkMemoryAlbumDBHelper = WinkMemoryAlbumDBHelper.f318173a;
                    this.L$0 = list;
                    this.J$0 = j3;
                    this.label = 4;
                    if (winkMemoryAlbumDBHelper.d(list, this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j16 = j3;
                    MemoryAlbumGenerator memoryAlbumGenerator22 = MemoryAlbumGenerator.f326501a;
                    this.L$0 = null;
                    this.J$0 = j16;
                    this.label = 5;
                    u06 = memoryAlbumGenerator22.u0(list, this);
                    if (u06 != coroutine_suspended) {
                    }
                } else {
                    elapsedRealtime2 = this.J$1;
                    elapsedRealtime = this.J$0;
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    long elapsedRealtime4 = SystemClock.elapsedRealtime();
                    MemoryAlbumGenerator memoryAlbumGenerator4 = MemoryAlbumGenerator.f326501a;
                    w53.b.a(memoryAlbumGenerator4.c(), "generateAlbums findAlbumByConfig cost time " + (elapsedRealtime4 - elapsedRealtime2));
                    memoryAlbumGenerator4.n0(list);
                    this.L$0 = list;
                    this.J$0 = elapsedRealtime;
                    this.label = 3;
                    p06 = memoryAlbumGenerator4.p0(list, elapsedRealtime, this);
                    if (p06 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j3 = elapsedRealtime;
                    MemoryAlbumGenerator.f326501a.n0(list);
                    winkMemoryAlbumDBHelper = WinkMemoryAlbumDBHelper.f318173a;
                    this.L$0 = list;
                    this.J$0 = j3;
                    this.label = 4;
                    if (winkMemoryAlbumDBHelper.d(list, this) != coroutine_suspended) {
                    }
                }
            } else {
                elapsedRealtime2 = this.J$1;
                elapsedRealtime = this.J$0;
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            elapsedRealtime = SystemClock.elapsedRealtime();
            elapsedRealtime2 = SystemClock.elapsedRealtime();
            ArrayList arrayList = new ArrayList();
            WinkMemoryAlbumDBHelper winkMemoryAlbumDBHelper2 = WinkMemoryAlbumDBHelper.f318173a;
            this.L$0 = arrayList;
            this.J$0 = elapsedRealtime;
            this.J$1 = elapsedRealtime2;
            this.label = 1;
            Object c16 = winkMemoryAlbumDBHelper2.c(this);
            if (c16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = arrayList;
            obj = c16;
        }
        MemoryAlbumGenerator memoryAlbumGenerator5 = MemoryAlbumGenerator.f326501a;
        this.L$0 = list;
        this.J$0 = elapsedRealtime;
        this.J$1 = elapsedRealtime2;
        this.label = 2;
        h06 = memoryAlbumGenerator5.h0(list, this);
        if (h06 == coroutine_suspended) {
            return coroutine_suspended;
        }
        long elapsedRealtime42 = SystemClock.elapsedRealtime();
        MemoryAlbumGenerator memoryAlbumGenerator42 = MemoryAlbumGenerator.f326501a;
        w53.b.a(memoryAlbumGenerator42.c(), "generateAlbums findAlbumByConfig cost time " + (elapsedRealtime42 - elapsedRealtime2));
        memoryAlbumGenerator42.n0(list);
        this.L$0 = list;
        this.J$0 = elapsedRealtime;
        this.label = 3;
        p06 = memoryAlbumGenerator42.p0(list, elapsedRealtime, this);
        if (p06 != coroutine_suspended) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((MemoryAlbumGenerator$generateAlbums$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
