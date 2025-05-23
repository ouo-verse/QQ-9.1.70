package com.qzone.reborn.feedx.presenter.ad.reward;

import android.os.Bundle;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.qphone.base.util.QLog;
import ih.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/reward/a;", "", "", "e", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneActivity;", "g", "", "profitable", "", "elapsedTime", "isRealTimeRequest", "f", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.qzone.reborn.feedx.presenter.ad.reward.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public static final class C0468a {
        public static void a(a aVar, int i3, Bundle resultData) {
            Intrinsics.checkNotNullParameter(resultData, "resultData");
            if (i3 == -1) {
                aVar.f(resultData.getBoolean("profitable_flag", false), (int) resultData.getLong("elapsed_time"), false);
            }
        }

        public static void c(a aVar, boolean z16, int i3, boolean z17) {
            String str;
            PBEnumField pBEnumField;
            vac_adv_get.QzoneActivity mQZoneActivity = aVar.getMQZoneActivity();
            if (mQZoneActivity != null && z16) {
                PBStringField pBStringField = mQZoneActivity.trace_id;
                QLog.i("QZoneAdRewardPresenter", 1, "isRealTimeRequest:" + z17 + ",received reward success, qzoneactivity traceId: " + (pBStringField != null ? pBStringField.get() : null));
                aVar.e();
                if (z17) {
                    vac_adv_get.Activity y16 = QZoneAdFeedUtils.f55717a.y(mQZoneActivity);
                    f.f407629a.d(String.valueOf((y16 == null || (pBEnumField = y16.reward_type) == null) ? 0 : pBEnumField.get()), i3);
                } else {
                    f.f407629a.c(mQZoneActivity, i3);
                }
                PBStringField pBStringField2 = mQZoneActivity.trace_id;
                if (pBStringField2 == null || (str = pBStringField2.get()) == null) {
                    return;
                }
                QZoneAdFeedUtils.f55717a.x().add(str);
            }
        }

        public static void b(a aVar, boolean z16, int i3) {
            aVar.f(z16, i3, true);
        }
    }

    void e();

    void f(boolean profitable, int elapsedTime, boolean isRealTimeRequest);

    /* renamed from: g */
    vac_adv_get.QzoneActivity getMQZoneActivity();
}
