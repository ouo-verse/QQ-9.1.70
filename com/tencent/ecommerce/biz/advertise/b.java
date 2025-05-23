package com.tencent.ecommerce.biz.advertise;

import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/advertise/b;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "adClickId", "", "c", "a", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f101293a = new b();

    b() {
    }

    public final String a(String orderId) {
        if (orderId != null) {
            ECLocalConfig.f100650f.getString(orderId, "", Boolean.TRUE);
        }
        return "";
    }

    public final void b(String orderId) {
        if (orderId != null) {
            ECLocalConfig.f100650f.remove(orderId, Boolean.TRUE);
        }
    }

    public final void c(String orderId, String adClickId) {
        if (orderId == null || orderId.length() == 0) {
            return;
        }
        if (adClickId == null || adClickId.length() == 0) {
            return;
        }
        ECLocalConfig.f100650f.setString(orderId, adClickId, Boolean.TRUE);
    }
}
