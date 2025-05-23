package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import p35.m;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StrangerFeedLikeRepo$strangerFeedLikeRequest$1 extends Lambda implements Function4<m, byte[], Integer, String, Unit> {
    public final /* synthetic */ Function1<Boolean, Unit> $callback;
    public final /* synthetic */ String $extInfo;
    public final /* synthetic */ String $feedId;
    public final /* synthetic */ boolean $isLike;
    public final /* synthetic */ int $newLikeCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StrangerFeedLikeRepo$strangerFeedLikeRequest$1(Function1<? super Boolean, Unit> function1, boolean z16, int i3, String str, String str2) {
        super(4);
        this.$callback = function1;
        this.$isLike = z16;
        this.$newLikeCount = i3;
        this.$feedId = str;
        this.$extInfo = str2;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Unit invoke(m mVar, byte[] bArr, Integer num, String str) {
        m mVar2 = mVar;
        int intValue = num.intValue();
        String str2 = str;
        if (intValue == 0 && mVar2 != null) {
            KLog.INSTANCE.i("StrangerFeedLikeRepo", "strangerFeedLikeRequest success");
            Function1<Boolean, Unit> function1 = this.$callback;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        } else {
            k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
            e eVar = new e();
            boolean z16 = this.$isLike;
            int i3 = this.$newLikeCount;
            Object obj = this.$feedId;
            String str3 = this.$extInfo;
            eVar.t("count", z16 ? i3 - 1 : i3 + 1);
            eVar.v("feedId", obj);
            eVar.t("isLike", !z16 ? 1 : 0);
            if (str3.length() > 0) {
                eVar.v("extInfo", str3);
            }
            Unit unit = Unit.INSTANCE;
            k.d(kVar, "NearbyFeedLikeStatusChangedEvent", eVar, false, 4, null);
            KLog.INSTANCE.i("StrangerFeedLikeRepo", "strangerFeedLikeRequest failure code:" + intValue + ", message:" + str2 + '}');
            Function1<Boolean, Unit> function12 = this.$callback;
            if (function12 != null) {
                function12.invoke(Boolean.FALSE);
            }
        }
        return Unit.INSTANCE;
    }
}
