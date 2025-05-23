package com.tencent.mobileqq.wink.templatelibrary.memoryalbum;

import com.tencent.mobileqq.wink.db.memoryalbumdb.WinkMemoryAlbumDBHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.MemoryAlbumGenerator$faceDetectIn$2$1$1", f = "MemoryAlbumGenerator.kt", i = {}, l = {495}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class MemoryAlbumGenerator$faceDetectIn$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $photos;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryAlbumGenerator$faceDetectIn$2$1$1(List<String> list, Continuation<? super MemoryAlbumGenerator$faceDetectIn$2$1$1> continuation) {
        super(2, continuation);
        this.$photos = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MemoryAlbumGenerator$faceDetectIn$2$1$1(this.$photos, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        int collectionSizeOrDefault;
        boolean z16;
        boolean z17;
        s53.b X;
        String path;
        String str;
        int i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            for (String str2 : this.$photos) {
                MemoryAlbumGenerator memoryAlbumGenerator = MemoryAlbumGenerator.f326501a;
                s53.b X2 = memoryAlbumGenerator.X(str2);
                boolean z18 = false;
                if (X2 != null && X2.getHaveFace() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    s53.b X3 = memoryAlbumGenerator.X(str2);
                    if (X3 != null && X3.getMediaType() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17 && (X = memoryAlbumGenerator.X(str2)) != null && (path = X.getPath()) != null) {
                        s53.b X4 = memoryAlbumGenerator.X(str2);
                        if (X4 != null && X4.getHaveFace() == 0) {
                            z18 = true;
                        }
                        if (z18) {
                            long currentTimeMillis = System.currentTimeMillis();
                            boolean h16 = com.tencent.mobileqq.wink.utils.j.f326712a.h(path, 256, 256);
                            String c16 = memoryAlbumGenerator.c();
                            s53.b X5 = memoryAlbumGenerator.X(str2);
                            if (X5 != null) {
                                str = X5.getPath();
                            } else {
                                str = null;
                            }
                            w53.b.a(c16, "detectFaceIn " + str + " " + h16 + " cost " + (System.currentTimeMillis() - currentTimeMillis));
                            s53.b X6 = memoryAlbumGenerator.X(str2);
                            if (X6 != null) {
                                if (h16) {
                                    i3 = 1;
                                } else {
                                    i3 = 2;
                                }
                                X6.v(i3);
                            }
                        }
                    }
                }
            }
            WinkMemoryAlbumDBHelper winkMemoryAlbumDBHelper = WinkMemoryAlbumDBHelper.f318173a;
            List<String> list = this.$photos;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                s53.b X7 = MemoryAlbumGenerator.f326501a.X((String) it.next());
                Intrinsics.checkNotNull(X7);
                arrayList.add(X7);
            }
            this.label = 1;
            if (winkMemoryAlbumDBHelper.f(arrayList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MemoryAlbumGenerator$faceDetectIn$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
