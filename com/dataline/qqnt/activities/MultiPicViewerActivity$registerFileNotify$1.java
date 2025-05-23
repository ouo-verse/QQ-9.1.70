package com.dataline.qqnt.activities;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\u008a@"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/qqnt/msg/d;", "Lkotlin/collections/ArrayList;", "msgRecords", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.dataline.qqnt.activities.MultiPicViewerActivity$registerFileNotify$1", f = "MultiPicViewerActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MultiPicViewerActivity$registerFileNotify$1 extends SuspendLambda implements Function2<ArrayList<d>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MultiPicViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPicViewerActivity$registerFileNotify$1(MultiPicViewerActivity multiPicViewerActivity, Continuation<? super MultiPicViewerActivity$registerFileNotify$1> continuation) {
        super(2, continuation);
        this.this$0 = multiPicViewerActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MultiPicViewerActivity$registerFileNotify$1 multiPicViewerActivity$registerFileNotify$1 = new MultiPicViewerActivity$registerFileNotify$1(this.this$0, continuation);
        multiPicViewerActivity$registerFileNotify$1.L$0 = obj;
        return multiPicViewerActivity$registerFileNotify$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        db1.b bVar;
        Object obj2;
        boolean c36;
        boolean d36;
        boolean Z2;
        db1.b bVar2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Iterator it = ((ArrayList) this.L$0).iterator();
            while (true) {
                bVar = null;
                if (it.hasNext()) {
                    obj2 = it.next();
                    d dVar = (d) obj2;
                    MsgRecord msgRecord = MultiPicViewerActivity.INSTANCE.a().get();
                    boolean z16 = false;
                    if (msgRecord != null && dVar.a().msgId == msgRecord.getMsgId()) {
                        z16 = true;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            d dVar2 = (d) obj2;
            if (dVar2 != null) {
                this.this$0.i3(dVar2.a());
                c36 = this.this$0.c3();
                if (c36) {
                    bVar2 = this.this$0.binding;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        bVar = bVar2;
                    }
                    bVar.f393509f.setVisibility(8);
                } else {
                    d36 = this.this$0.d3();
                    if (d36) {
                        this.this$0.j3();
                    } else {
                        Z2 = this.this$0.Z2();
                        if (Z2) {
                            this.this$0.h3();
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ArrayList<d> arrayList, @Nullable Continuation<? super Unit> continuation) {
        return ((MultiPicViewerActivity$registerFileNotify$1) create(arrayList, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
