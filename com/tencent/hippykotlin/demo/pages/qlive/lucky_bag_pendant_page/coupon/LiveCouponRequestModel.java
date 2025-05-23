package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.base.SSORequestModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LiveCouponRequestModel extends SSORequestModel {
    public long roomId;

    public LiveCouponRequestModel(String str) {
        super(str);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final String cmd() {
        return "trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr/GetCoupon";
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final e reqParam() {
        e eVar = new e();
        eVar.u(AudienceReportConst.ROOM_ID, this.roomId);
        eVar.t(WadlProxyConsts.CHANNEL, 8);
        return eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
    public final void requestData(final Function3<? super e, ? super Integer, ? super String, Unit> function3) {
        super.requestData(new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponRequestModel$requestData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(e eVar, Integer num, String str) {
                e eVar2 = eVar;
                int intValue = num.intValue();
                String str2 = str;
                if (eVar2.d() > 0) {
                    LiveCouponRequestModel liveCouponRequestModel = LiveCouponRequestModel.this;
                    eVar2.k("coupon_num", 0);
                    eVar2.o("last_pickup_ts", 0L);
                    eVar2.q("discount_price", "");
                    b l3 = eVar2.l("coupons");
                    if (l3 != null) {
                        ArrayList arrayList = new ArrayList();
                        int c16 = l3.c();
                        for (int i3 = 0; i3 < c16; i3++) {
                            Object d16 = l3.d(i3);
                            if (d16 != null) {
                                Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                arrayList.add(new LivingCoupon(((e) d16).q("coupon_batch_id", "")));
                            }
                        }
                    }
                    liveCouponRequestModel.getClass();
                }
                function3.invoke(eVar2, Integer.valueOf(intValue), str2);
                return Unit.INSTANCE;
            }
        });
    }
}
