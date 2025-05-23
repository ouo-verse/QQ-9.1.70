package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.module.e;
import g25.c;
import g25.d;
import g25.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieCategoryHomeDataManager {
    public static final AdelieCategoryHomeDataManager INSTANCE = new AdelieCategoryHomeDataManager();
    public static final List<Long> backFlowDoneRobotList = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchMobileRobotRecommendCards$qecommerce_biz_release(final a aVar, final String str, final String str2, boolean z16, Continuation<? super OIDBResponse<c>> continuation) {
        AdelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1 adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        OIDBResponse oIDBResponse;
        Lazy lazy;
        c cVar;
        h hVar;
        String str3;
        byte[] bArr;
        if (continuation instanceof AdelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1) {
            adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1 = (AdelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1) continuation;
            int i16 = adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1.label = i16 - Integer.MIN_VALUE;
                Object obj = adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    Function0<d> function0 = new Function0<d>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$rsp$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final d invoke() {
                            return new d(a.this, str, str2, true, 24);
                        }
                    };
                    Function1<byte[], c> function1 = new Function1<byte[], c>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$rsp$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Type inference failed for: r0v1, types: [T, byte[]] */
                        @Override // kotlin.jvm.functions.Function1
                        public final c invoke(byte[] bArr2) {
                            byte[] bArr3 = bArr2;
                            objectRef2.element = bArr3;
                            return (c) i.b(new c(null, null, null, null, null, null, false, null, 0L, false, 1023, null), bArr3);
                        }
                    };
                    adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1.L$0 = objectRef2;
                    adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1.Z$0 = z16;
                    adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1.label = 1;
                    Object sendOIDBRequest = RequestKt.sendOIDBRequest(4, 37122, function0, function1, adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1);
                    if (sendOIDBRequest == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = sendOIDBRequest;
                    objectRef = objectRef2;
                } else if (i3 == 1) {
                    z16 = adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1.Z$0;
                    objectRef = adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                oIDBResponse = (OIDBResponse) obj;
                if (oIDBResponse.success && z16) {
                    lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieKuiklyBaseModule>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$adelieKuiklyModule$2
                        @Override // kotlin.jvm.functions.Function0
                        public final AdelieKuiklyBaseModule invoke() {
                            return (AdelieKuiklyBaseModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
                        }
                    });
                    cVar = (c) oIDBResponse.rsp;
                    if (cVar != null && (hVar = cVar.f401143h) != null && (str3 = hVar.f401163d) != null && (bArr = (byte[]) objectRef.element) != null) {
                        AdelieKuiklyBaseModule adelieKuiklyBaseModule = (AdelieKuiklyBaseModule) lazy.getValue();
                        String str4 = str3 + util.base64_pad_url + PageDataExtKt.getUin(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData());
                        adelieKuiklyBaseModule.getClass();
                        ((e) com.tencent.kuikly.core.pager.h.a().acquireModule("KRDiskCacheModule")).e(str4, bArr);
                    }
                }
                return oIDBResponse;
            }
        }
        adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1 = new AdelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1(this, continuation);
        Object obj2 = adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = adelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$1.label;
        if (i3 != 0) {
        }
        oIDBResponse = (OIDBResponse) obj2;
        if (oIDBResponse.success) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieKuiklyBaseModule>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomeDataManager$fetchMobileRobotRecommendCards$adelieKuiklyModule$2
                @Override // kotlin.jvm.functions.Function0
                public final AdelieKuiklyBaseModule invoke() {
                    return (AdelieKuiklyBaseModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
                }
            });
            cVar = (c) oIDBResponse.rsp;
            if (cVar != null) {
                AdelieKuiklyBaseModule adelieKuiklyBaseModule2 = (AdelieKuiklyBaseModule) lazy.getValue();
                String str42 = str3 + util.base64_pad_url + PageDataExtKt.getUin(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData());
                adelieKuiklyBaseModule2.getClass();
                ((e) com.tencent.kuikly.core.pager.h.a().acquireModule("KRDiskCacheModule")).e(str42, bArr);
            }
        }
        return oIDBResponse;
    }
}
