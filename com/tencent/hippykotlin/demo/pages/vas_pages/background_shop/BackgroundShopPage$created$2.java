package com.tencent.hippykotlin.demo.pages.vas_pages.background_shop;

import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$created$2", f = "BackgroundShopPage.kt", i = {}, l = {679}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class BackgroundShopPage$created$2 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ BackgroundShopPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundShopPage$created$2(BackgroundShopPage backgroundShopPage, Continuation<? super BackgroundShopPage$created$2> continuation) {
        super(2, continuation);
        this.this$0 = backgroundShopPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BackgroundShopPage$created$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((BackgroundShopPage$created$2) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.this$0.friendUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                str = null;
            }
            if (str.length() == 0) {
                BackgroundShopPage backgroundShopPage = this.this$0;
                e eVar = new e();
                VasModule vasModule = backgroundShopPage.platformApi.getVasModule();
                String eVar2 = eVar.toString();
                VasModule.Companion companion = VasModule.Companion;
                vasModule.writeH5Data("/vip/gxh/bgshop", "currentChatInfo", eVar2, null);
                return Unit.INSTANCE;
            }
            Friends friends = this.this$0.platformApi.getVasModule().getFriends();
            String str2 = this.this$0.friendUin;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                str2 = null;
            }
            boolean z16 = this.this$0.uinType != 0;
            this.label = 1;
            obj = Friends.getFriendOrGroupName$default(friends, str2, z16, this, 4);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final String str3 = (String) obj;
        BackgroundShopPage backgroundShopPage2 = this.this$0;
        final BackgroundShopPage backgroundShopPage3 = this.this$0;
        e eVar3 = new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$created$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar4) {
                e eVar5 = eVar4;
                String str4 = BackgroundShopPage.this.friendUin;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("friendUin");
                    str4 = null;
                }
                eVar5.z("uin", str4);
                eVar5.z("uinType", Integer.valueOf(BackgroundShopPage.this.uinType));
                eVar5.z("name", str3);
                return Unit.INSTANCE;
            }
        });
        KProperty<Object>[] kPropertyArr = BackgroundShopPage.$$delegatedProperties;
        VasModule vasModule2 = backgroundShopPage2.platformApi.getVasModule();
        String eVar4 = eVar3.toString();
        VasModule.Companion companion2 = VasModule.Companion;
        vasModule2.writeH5Data("/vip/gxh/bgshop", "currentChatInfo", eVar4, null);
        return Unit.INSTANCE;
    }
}
