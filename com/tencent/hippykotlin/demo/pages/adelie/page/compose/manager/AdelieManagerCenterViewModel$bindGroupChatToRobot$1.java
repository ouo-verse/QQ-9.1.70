package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import h25.ao;
import h25.ap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$bindGroupChatToRobot$1", f = "AdelieManagerCenterViewModel.kt", i = {}, l = {242}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieManagerCenterViewModel$bindGroupChatToRobot$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ String $botUid;
    public final /* synthetic */ Function1<Boolean, Unit> $callback;
    public final /* synthetic */ List<String> $troopUins;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieManagerCenterViewModel$bindGroupChatToRobot$1(String str, List<String> list, Function1<? super Boolean, Unit> function1, Continuation<? super AdelieManagerCenterViewModel$bindGroupChatToRobot$1> continuation) {
        super(2, continuation);
        this.$botUid = str;
        this.$troopUins = list;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieManagerCenterViewModel$bindGroupChatToRobot$1(this.$botUid, this.$troopUins, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieManagerCenterViewModel$bindGroupChatToRobot$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int collectionSizeOrDefault;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            final String str = this.$botUid;
            List<String> list = this.$troopUins;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            final ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Boxing.boxLong(Long.parseLong((String) it.next())));
            }
            this.label = 1;
            obj = RequestKt.sendOIDBRequest(1, 37479, new Function0<ao>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.AdelieManagerRequest$bindGroupChatToRobot$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final ao invoke() {
                    List mutableList;
                    String str2 = str;
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                    return new ao(str2, mutableList);
                }
            }, new Function1<byte[], ap>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.kuikly.manager.AdelieManagerRequest$bindGroupChatToRobot$3
                @Override // kotlin.jvm.functions.Function1
                public final ap invoke(byte[] bArr) {
                    return (ap) i.b(new ap(), bArr);
                }
            }, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OIDBResponse oIDBResponse = (OIDBResponse) obj;
        Function1<Boolean, Unit> function1 = this.$callback;
        if (function1 != null) {
            function1.invoke(Boxing.boxBoolean(oIDBResponse.success));
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("bindGroupChatToRobot, success: ");
        m3.append(oIDBResponse.success);
        m3.append(", code: ");
        m3.append(oIDBResponse.code);
        m3.append(", msg: ");
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, oIDBResponse.f114186msg, kLog, "AdelieManagerCenterViewModel");
        return Unit.INSTANCE;
    }
}
