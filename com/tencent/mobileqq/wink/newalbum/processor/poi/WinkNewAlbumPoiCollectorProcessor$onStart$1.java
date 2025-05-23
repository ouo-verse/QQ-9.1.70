package com.tencent.mobileqq.wink.newalbum.processor.poi;

import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.poi.WinkNewAlbumPoiCollectorProcessor$onStart$1", f = "WinkNewAlbumPoiCollectorProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkNewAlbumPoiCollectorProcessor$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WinkNewAlbumPoiCollectorProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumPoiCollectorProcessor$onStart$1(WinkNewAlbumPoiCollectorProcessor winkNewAlbumPoiCollectorProcessor, Continuation<? super WinkNewAlbumPoiCollectorProcessor$onStart$1> continuation) {
        super(2, continuation);
        this.this$0 = winkNewAlbumPoiCollectorProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkNewAlbumPoiCollectorProcessor$onStart$1(this.this$0, continuation);
    }

    /* JADX WARN: Incorrect condition in loop: B:5:0x0019 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        AtomicBoolean atomicBoolean;
        LinkedBlockingQueue linkedBlockingQueue;
        int i3;
        int i16;
        List list;
        AtomicBoolean atomicBoolean2;
        c cVar;
        boolean F;
        List list2;
        List list3;
        WinkNewAlbumDatabaseImp winkNewAlbumDatabaseImp;
        List list4;
        c cVar2;
        int i17;
        int i18;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.G();
            while (!atomicBoolean.get()) {
                linkedBlockingQueue = this.this$0.pendingList;
                WinkNewAlbumContext winkNewAlbumContext = (WinkNewAlbumContext) linkedBlockingQueue.poll();
                if (winkNewAlbumContext != null) {
                    if (!winkNewAlbumContext.getIsLast()) {
                        F = this.this$0.F(winkNewAlbumContext);
                        if (F) {
                            list2 = this.this$0.clusteringList;
                            list2.add(winkNewAlbumContext);
                            String a16 = WinkNewAlbumPoiCollectorProcessor.INSTANCE.a();
                            String city = winkNewAlbumContext.getMetaData().getCity();
                            list3 = this.this$0.clusteringList;
                            QLog.d(a16, 4, "city is not null:" + city + ", clusteringList.size:" + list3.size());
                        } else {
                            a aVar = a.f324300a;
                            winkNewAlbumDatabaseImp = this.this$0.databaseImp;
                            aVar.a(winkNewAlbumContext, winkNewAlbumDatabaseImp);
                            if (aVar.b(winkNewAlbumContext)) {
                                list4 = this.this$0.clusteringList;
                                list4.add(winkNewAlbumContext);
                                cVar2 = this.this$0.poiRequestUtils;
                                cVar2.a(winkNewAlbumContext);
                                WinkNewAlbumPoiCollectorProcessor winkNewAlbumPoiCollectorProcessor = this.this$0;
                                i17 = winkNewAlbumPoiCollectorProcessor.hasGPSCount;
                                winkNewAlbumPoiCollectorProcessor.hasGPSCount = i17 + 1;
                            } else {
                                WinkNewAlbumPoiCollectorProcessor winkNewAlbumPoiCollectorProcessor2 = this.this$0;
                                i18 = winkNewAlbumPoiCollectorProcessor2.noGPSCount;
                                winkNewAlbumPoiCollectorProcessor2.noGPSCount = i18 + 1;
                                QLog.d(WinkNewAlbumPoiCollectorProcessor.INSTANCE.a(), 4, "gps is null, not add, path:" + winkNewAlbumContext.getMetaData().getPath());
                            }
                        }
                    } else {
                        String a17 = WinkNewAlbumPoiCollectorProcessor.INSTANCE.a();
                        i3 = this.this$0.totalCount;
                        i16 = this.this$0.noGPSCount;
                        list = this.this$0.clusteringList;
                        QLog.i(a17, 1, "scan finish, allnum:" + i3 + ", diacrdNum:" + i16 + ", clusteringList.size:" + list.size());
                        atomicBoolean2 = this.this$0.isFinished;
                        atomicBoolean2.set(true);
                        cVar = this.this$0.poiRequestUtils;
                        cVar.e();
                        return Unit.INSTANCE;
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkNewAlbumPoiCollectorProcessor$onStart$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
