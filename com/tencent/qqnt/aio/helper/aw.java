package com.tencent.qqnt.aio.helper;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/helper/aw;", "Lcom/tencent/aio/main/businesshelper/h;", "", "e", "g", "", "c", "", "time1", "time2", "b", "i", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "<init>", "()V", "d", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class aw implements com.tencent.aio.main.businesshelper.h {
    private final boolean b(long time1, long time2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time1);
        int i3 = calendar.get(6);
        int i16 = calendar.get(1);
        calendar.setTimeInMillis(time2);
        return i3 == calendar.get(6) && i16 == calendar.get(1);
    }

    private final boolean c() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("key_lastest_report_game_card_status_ts", 0L);
        if (decodeLong > 0) {
            return b(decodeLong, System.currentTimeMillis());
        }
        return false;
    }

    private final void g() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.av
            @Override // java.lang.Runnable
            public final void run() {
                aw.h(aw.this);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(aw this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.c()) {
            return;
        }
        QLog.d("GameCenterGroupHelper", 1, "reportGameCardStatus");
        ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).reportGameCardStatus(MobileQQ.sMobileQQ.peekAppRuntime());
        this$0.i();
    }

    private final void i() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeLong("key_lastest_report_game_card_status_ts", System.currentTimeMillis());
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350670s;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "GameCenterGroupHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onCreate(com.tencent.aio.main.businesshelper.b bVar) {
        h.a.a(this, bVar);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    private final void e() {
        QLog.d("GameCenterGroupHelper", 1, "onDelayLoad");
        g();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{4};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 4) {
            e();
        }
    }
}
