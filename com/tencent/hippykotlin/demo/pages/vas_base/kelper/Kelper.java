package com.tencent.hippykotlin.demo.pages.vas_base.kelper;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.KRequest;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.luggage.wxa.yf.o;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Kelper {
    public static final Kelper INSTANCE = new Kelper();
    public static final boolean canIUse;
    public static final Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> debugMiddleware;
    public static final Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> releaseMiddleware;
    public static final Lazy requester$delegate;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<KRequest>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.kelper.Kelper$requester$2
            @Override // kotlin.jvm.functions.Function0
            public final KRequest invoke() {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("http://");
                Kelper kelper = Kelper.INSTANCE;
                m3.append("");
                return new KRequest(new RequestConfig(null, m3.toString(), null, null, null, 6, null, o.CTRL_INDEX));
            }
        });
        requester$delegate = lazy;
        canIUse = Intrinsics.areEqual("production", "development");
        Kelper$observer$1 kelper$observer$1 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.kelper.Kelper$observer$1
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Kelper kelper = Kelper.INSTANCE;
                return Unit.INSTANCE;
            }
        };
        debugMiddleware = new Kelper$debugMiddleware$1(null);
        releaseMiddleware = new Kelper$releaseMiddleware$1(null);
    }

    public final Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> middleware() {
        if (canIUse) {
            return debugMiddleware;
        }
        return releaseMiddleware;
    }
}
