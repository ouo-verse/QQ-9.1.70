package com.tencent.sqshow.zootopia.avatar.filament.anim;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadMeshAnim$2", f = "PortalAnimHelper.kt", i = {}, l = {692}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class PortalAnimHelper$loadMeshAnim$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $avatarPbJson;
    final /* synthetic */ FilamentViewerV2 $viewer;
    int label;
    final /* synthetic */ PortalAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalAnimHelper$loadMeshAnim$2(PortalAnimHelper portalAnimHelper, JSONObject jSONObject, FilamentViewerV2 filamentViewerV2, Continuation<? super PortalAnimHelper$loadMeshAnim$2> continuation) {
        super(2, continuation);
        this.this$0 = portalAnimHelper;
        this.$avatarPbJson = jSONObject;
        this.$viewer = filamentViewerV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PortalAnimHelper$loadMeshAnim$2(this.this$0, this.$avatarPbJson, this.$viewer, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        final List filterNotNull;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            PortalAnimHelper portalAnimHelper = this.this$0;
            JSONObject jSONObject = this.$avatarPbJson;
            this.label = 1;
            obj = portalAnimHelper.g0(jSONObject, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) obj;
        if (list != null) {
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(list);
            if (filterNotNull.isEmpty()) {
                QLog.i("PortalAnimHelper_", 1, "loadMeshAnim empty");
                this.this$0.mMeshAnimList = null;
                return Unit.INSTANCE;
            }
            i mTaskExecutor = this.this$0.getMTaskExecutor();
            if (mTaskExecutor != null) {
                final PortalAnimHelper portalAnimHelper2 = this.this$0;
                final FilamentViewerV2 filamentViewerV2 = this.$viewer;
                mTaskExecutor.runOnViewerThread("trackGroupWithAnimations", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper$loadMeshAnim$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ArrayList arrayList = new ArrayList();
                        List<ZPlanAction> list2 = filterNotNull;
                        PortalAnimHelper portalAnimHelper3 = portalAnimHelper2;
                        FilamentViewerV2 filamentViewerV22 = filamentViewerV2;
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList.add(PortalAnimHelper.r1(portalAnimHelper3, filamentViewerV22, new ZPlanAction[]{(ZPlanAction) it.next()}, null, 4, null));
                        }
                        portalAnimHelper2.mMeshAnimList = arrayList;
                        portalAnimHelper2.mMeshAnimBeginTime = 0.0d;
                        QLog.i("PortalAnimHelper_", 1, "loadMeshAnim end");
                    }
                });
            }
            return Unit.INSTANCE;
        }
        QLog.i("PortalAnimHelper_", 1, "loadMeshAnim failed, no mesh anim need load");
        this.this$0.mMeshAnimList = null;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PortalAnimHelper$loadMeshAnim$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
