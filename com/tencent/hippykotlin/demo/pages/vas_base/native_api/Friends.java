package com.tencent.hippykotlin.demo.pages.vas_base.native_api;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.INativeApi;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Friends {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class PanelParams {
        public int maxNum = 9;
        public String overLimitTips = "";
    }

    public final Object getFriendOrGroupName(final String str, boolean z16, boolean z17, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        INativeApi.Companion.checkQQVersion$default();
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        e eVar = new e();
        eVar.v("uin", str);
        eVar.w("isGroup", z16);
        eVar.w("needRemark", z17);
        Unit unit = Unit.INSTANCE;
        VasModule.Companion.getInstance().toNative(false, "friendsGetName", eVar.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.Friends$getFriendOrGroupName$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                String str2;
                e eVar3 = eVar2;
                Continuation<String> continuation2 = safeContinuation;
                if (eVar3 == null || (str2 = eVar3.p("name")) == null) {
                    str2 = str;
                }
                continuation2.resumeWith(Result.m476constructorimpl(str2));
                return Unit.INSTANCE;
            }
        }, false);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class FriendInfo {
        public final String name;
        public final String uin;
        public final int uinType;

        public FriendInfo(String str, String str2, int i3) {
            this.uin = str;
            this.name = str2;
            this.uinType = i3;
        }

        public final int hashCode() {
            return this.uinType + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.name, this.uin.hashCode() * 31, 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("FriendInfo(uin=");
            m3.append(this.uin);
            m3.append(", name=");
            m3.append(this.name);
            m3.append(", uinType=");
            return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.uinType, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FriendInfo)) {
                return false;
            }
            FriendInfo friendInfo = (FriendInfo) obj;
            return Intrinsics.areEqual(this.uin, friendInfo.uin) && Intrinsics.areEqual(this.name, friendInfo.name) && this.uinType == friendInfo.uinType;
        }
    }

    public static /* synthetic */ Object getFriendOrGroupName$default(Friends friends, String str, boolean z16, Continuation continuation, int i3) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return friends.getFriendOrGroupName(str, z16, (i3 & 4) != 0, continuation);
    }
}
