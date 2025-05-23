package com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage.RequestStorage;
import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class RequestStorage {
    public static final Lazy<String> keyPrefix$delegate;
    public final Lazy cacheModule$delegate;
    public static final Companion Companion = new Companion();
    public static final VLog log = new VLog("KRS");

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
    }

    static {
        Lazy<String> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage.RequestStorage$Companion$keyPrefix$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("KRS_");
                c cVar = c.f117352a;
                m3.append(cVar.g().getPageName());
                m3.append(util.base64_pad_url);
                m3.append(cVar.g().getPageData().n().q("uin", ""));
                return m3.toString();
            }
        });
        keyPrefix$delegate = lazy;
    }

    public RequestStorage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CacheModule>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage.RequestStorage$cacheModule$2
            @Override // kotlin.jvm.functions.Function0
            public final CacheModule invoke() {
                return (CacheModule) c.f117352a.g().acquireModule("HRCacheModule");
            }
        });
        this.cacheModule$delegate = lazy;
    }

    public final long now() {
        return b.c((b) c.f117352a.g().acquireModule("KRCalendarModule"), 0L, 1, null).a();
    }

    public final void set(String str, final e eVar) {
        log.log$enumunboxing$("set " + str + ", value " + eVar, 1, true);
        ((CacheModule) this.cacheModule$delegate.getValue()).setObject(str, new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage.RequestStorage$set$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                eVar3.z("data", e.this);
                final RequestStorage requestStorage = this;
                eVar3.C(PublicAccountMessageUtilImpl.META_NAME, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage.RequestStorage$set$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(e eVar4) {
                        e eVar5 = eVar4;
                        eVar5.z("res_version", Long.valueOf(PageDataExtKt.getResVersion(c.f117352a.g().getPageData())));
                        RequestStorage requestStorage2 = RequestStorage.this;
                        RequestStorage.Companion companion = RequestStorage.Companion;
                        eVar5.z("timestamp", Long.valueOf(requestStorage2.now()));
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }));
    }

    public final boolean isExpired(e eVar, Long l3) {
        if (l3 == null || eVar == null) {
            return false;
        }
        long n3 = eVar.n("timestamp");
        log.log$enumunboxing$("it " + n3 + ", vp " + l3, 1, true);
        return now() > l3.longValue() + n3;
    }
}
