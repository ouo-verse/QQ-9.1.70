package com.tencent.mobileqq.zplan.aigc.vm;

import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
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
import qu4.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel$updateCustomColor$customColorRunnable$1$1", f = "SuitCustomColorVewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class SuitCustomColorVewModel$updateCustomColor$customColorRunnable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AigcPreviewBusinessScene.e $callback;
    final /* synthetic */ ArrayList<p> $colors;
    final /* synthetic */ ZplanFilamentSuitRender $filamentRender;
    int label;
    final /* synthetic */ SuitCustomColorVewModel this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/aigc/vm/SuitCustomColorVewModel$updateCustomColor$customColorRunnable$1$1$a", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene$e;", "", "onComplete", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements AigcPreviewBusinessScene.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SuitCustomColorVewModel f330871a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f330872b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AigcPreviewBusinessScene.e f330873c;

        a(SuitCustomColorVewModel suitCustomColorVewModel, int i3, AigcPreviewBusinessScene.e eVar) {
            this.f330871a = suitCustomColorVewModel;
            this.f330872b = i3;
            this.f330873c = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene.e
        public void onComplete() {
            SuitCustomColorVewModel.TaskStatus taskStatus = (SuitCustomColorVewModel.TaskStatus) this.f330871a.doubleBufferStatus.get(Integer.valueOf(this.f330872b));
            if (taskStatus != null) {
                taskStatus.d(false);
            }
            AigcPreviewBusinessScene.e eVar = this.f330873c;
            if (eVar != null) {
                eVar.onComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCustomColorVewModel$updateCustomColor$customColorRunnable$1$1(SuitCustomColorVewModel suitCustomColorVewModel, ArrayList<p> arrayList, ZplanFilamentSuitRender zplanFilamentSuitRender, AigcPreviewBusinessScene.e eVar, Continuation<? super SuitCustomColorVewModel$updateCustomColor$customColorRunnable$1$1> continuation) {
        super(2, continuation);
        this.this$0 = suitCustomColorVewModel;
        this.$colors = arrayList;
        this.$filamentRender = zplanFilamentSuitRender;
        this.$callback = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCustomColorVewModel$updateCustomColor$customColorRunnable$1$1(this.this$0, this.$colors, this.$filamentRender, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        List list2;
        List list3;
        List list4;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        List list5;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            list = this.this$0.generateTextureFilePathList;
            if (list.isEmpty()) {
                return Unit.INSTANCE;
            }
            int i3 = (this.this$0.previewResourceIndex.get() + 1) % 2;
            list2 = this.this$0.generateTextureFilePathList;
            if (i3 > list2.size()) {
                return Unit.INSTANCE;
            }
            SuitCustomColorVewModel suitCustomColorVewModel = this.this$0;
            ArrayList<p> arrayList = this.$colors;
            list3 = suitCustomColorVewModel.generateTextureFilePathList;
            suitCustomColorVewModel.y3(arrayList, (String) list3.get(i3));
            this.this$0.previewResourceIndex.set(i3);
            list4 = this.this$0.previewResourceList;
            if (list4.isEmpty()) {
                return Unit.INSTANCE;
            }
            SuitCustomColorVewModel.TaskStatus taskStatus = (SuitCustomColorVewModel.TaskStatus) this.this$0.doubleBufferStatus.get(Boxing.boxInt(i3));
            if (taskStatus != null) {
                taskStatus.d(true);
            }
            AigcPreviewBusinessScene scene = this.$filamentRender.getScene();
            if (scene != null) {
                list5 = this.this$0.previewResourceList;
                scene.updateUgc(new HashMap<>((Map) list5.get(i3)), new a(this.this$0, i3, this.$callback));
            }
            SuitCustomColorVewModel.TaskStatus taskStatus2 = (SuitCustomColorVewModel.TaskStatus) this.this$0.doubleBufferStatus.get(Boxing.boxInt(i3));
            if (taskStatus2 != null) {
                taskStatus2.c(false);
            }
            SuitCustomColorVewModel suitCustomColorVewModel2 = this.this$0;
            concurrentLinkedQueue = suitCustomColorVewModel2.generateUGCQueue;
            suitCustomColorVewModel2.x3(concurrentLinkedQueue);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCustomColorVewModel$updateCustomColor$customColorRunnable$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
