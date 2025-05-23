package com.tencent.mobileqq.nearbypro.map.avatar;

import ab2.c;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.profile.edit.event.HasEditProfileEvent;
import com.tencent.mobileqq.nearbypro.repository.service.BDHService;
import fu4.v;
import fu4.w;
import fu4.z;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.map.avatar.MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1", f = "MapAvatarUtils.kt", i = {0}, l = {276}, m = "invokeSuspend", n = {"$this$qLaunch"}, s = {"L$0"})
/* loaded from: classes15.dex */
final class MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ w $msgInfo;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1(w wVar, Continuation<? super MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1> continuation) {
        super(2, continuation);
        this.$msgInfo = wVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1 mapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1 = new MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1(this.$msgInfo, continuation);
        mapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1.L$0 = obj;
        return mapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object firstOrNull;
        Object firstOrNull2;
        final SelfUserInfo selfUserInfo;
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            z[] zVarArr = this.$msgInfo.f400825a;
            Intrinsics.checkNotNullExpressionValue(zVarArr, "msgInfo.msgInfoBody");
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(zVarArr);
            z zVar = (z) firstOrNull;
            if (zVar == null) {
                return Unit.INSTANCE;
            }
            BDHService bDHService = new BDHService();
            v vVar = zVar.f400830a;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = bDHService.j(vVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) obj);
        String str = (String) firstOrNull2;
        if (str == null) {
            return Unit.INSTANCE;
        }
        IMapNearbyDataService f16 = ab2.a.f25767a.f();
        if (f16 != null) {
            selfUserInfo = f16.getSelfUserInfo();
        } else {
            selfUserInfo = null;
        }
        if (selfUserInfo != null) {
            Boxing.boxBoolean(selfUserInfo.r(str));
        }
        if (selfUserInfo != null) {
            c.f25771a.c(selfUserInfo);
        }
        j.g().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.map.avatar.MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1.1
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
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                SelfUserInfo selfUserInfo2 = SelfUserInfo.this;
                simpleEventBus.dispatchEvent(new HasEditProfileEvent(selfUserInfo2 != null ? Long.valueOf(selfUserInfo2.getTid()) : null));
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MapAvatarUtils$composeAndUploadAvartarImage$1$onComposeFinish$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
