package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request;

import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.BaseRequest;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class UserIDRequest {
    /* JADX WARN: Removed duplicated region for block: B:12:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object isSuperVip(VasBasePage vasBasePage, Continuation<? super Boolean> continuation) {
        UserIDRequest$isSuperVip$1 userIDRequest$isSuperVip$1;
        Object coroutine_suspended;
        int i3;
        String p16;
        if (continuation instanceof UserIDRequest$isSuperVip$1) {
            userIDRequest$isSuperVip$1 = (UserIDRequest$isSuperVip$1) continuation;
            int i16 = userIDRequest$isSuperVip$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                userIDRequest$isSuperVip$1.label = i16 - Integer.MIN_VALUE;
                UserIDRequest$isSuperVip$1 userIDRequest$isSuperVip$12 = userIDRequest$isSuperVip$1;
                Object obj = userIDRequest$isSuperVip$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = userIDRequest$isSuperVip$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    BaseRequest.Companion companion = BaseRequest.Companion;
                    e eVar = new e();
                    eVar.z("uin", Boxing.boxLong(Long.parseLong(vasBasePage.platformApi.getQqModule().getUin())));
                    Unit unit = Unit.INSTANCE;
                    userIDRequest$isSuperVip$12.label = 1;
                    obj = companion.buildBaseRequest(vasBasePage, "https://zb.vip.qq.com/trpc-proxy/qqclub/vip_profile_read/logic/GetUserVipFlags", eVar, "ksvip", userIDRequest$isSuperVip$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p16 = ((Response) obj).data.p("response");
                if (!(p16.length() == 0)) {
                    return Boxing.boxBoolean(false);
                }
                return Boxing.boxBoolean(Intrinsics.areEqual(new e(p16).p("isSuperclub"), "1"));
            }
        }
        userIDRequest$isSuperVip$1 = new UserIDRequest$isSuperVip$1(this, continuation);
        UserIDRequest$isSuperVip$1 userIDRequest$isSuperVip$122 = userIDRequest$isSuperVip$1;
        Object obj2 = userIDRequest$isSuperVip$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = userIDRequest$isSuperVip$122.label;
        if (i3 != 0) {
        }
        p16 = ((Response) obj2).data.p("response");
        if (!(p16.length() == 0)) {
        }
    }
}
