package com.qzone.reborn.configx;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import qzone.qzoneWnsSwitch$SetWnsSwitchRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\f\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/configx/n;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, "secondKey", "value", "", "p", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "o", "k", "r", "l", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class n extends d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String secondKey, String value, QZoneSetWnsSwitchRequest request, BaseRequest baseRequest, boolean z16, long j3, String str, qzoneWnsSwitch$SetWnsSwitchRsp qzonewnsswitch_setwnsswitchrsp) {
        Intrinsics.checkNotNullParameter(secondKey, "$secondKey");
        Intrinsics.checkNotNullParameter(value, "$value");
        Intrinsics.checkNotNullParameter(request, "$request");
        if (z16 && j3 == 0) {
            QzoneConfig.getInstance().updateOneConfig("qzone_wns", secondKey, value);
            QLog.d("QZoneWatermark", 4, "[setWnsSwitch] set switch success! retCode = " + j3 + APLogFileUtil.SEPARATOR_LOG + request.getTraceId() + " | secondKey:" + secondKey + ",value:" + value);
            return;
        }
        QLog.e("QZoneWatermark", 1, "[setWnsSwitch] set switch error! retCode = " + j3 + APLogFileUtil.SEPARATOR_LOG + request.getTraceId());
    }

    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_WNS";
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return "qzone_wns";
    }

    public final boolean k() {
        return f("enable_fragment_start_activity_for_result", true);
    }

    public final boolean l() {
        List split$default;
        String e16 = e("qzone_holiday_first_comment_fail_reload_disable_span", "");
        boolean z16 = true;
        QLog.i("QZoneWnsNewConfig", 1, "time interval is " + e16);
        if (TextUtils.isEmpty(e16)) {
            return true;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) e16, new String[]{";"}, false, 0, 6, (Object) null);
        if (split$default.isEmpty() || split$default.size() < 2) {
            return true;
        }
        try {
            long parseLong = Long.parseLong((String) split$default.get(0));
            long parseLong2 = Long.parseLong((String) split$default.get(1));
            long currentTimeMillis = System.currentTimeMillis();
            QLog.i("QZoneWnsNewConfig", 1, "start time is " + parseLong + ", end time is " + parseLong2 + ", current time is " + currentTimeMillis);
            if (currentTimeMillis >= parseLong && currentTimeMillis <= parseLong2) {
                z16 = false;
            }
            return z16;
        } catch (Throwable th5) {
            QLog.e("QZoneWnsNewConfig", 1, "throwable is " + th5);
            return false;
        }
    }

    public final int m() {
        return b("feed_refresh_interval_has_passive", 180);
    }

    public final int n() {
        return b("feed_refresh_interval_no_passive", 900);
    }

    public final boolean o() {
        return f("is_force_refresh_when_first_enter_feed", true);
    }

    public final void p(final String secondKey, final String value) {
        Intrinsics.checkNotNullParameter(secondKey, "secondKey");
        Intrinsics.checkNotNullParameter(value, "value");
        final QZoneSetWnsSwitchRequest qZoneSetWnsSwitchRequest = new QZoneSetWnsSwitchRequest(secondKey, value);
        VSNetworkHelper.getInstance().sendRequest(qZoneSetWnsSwitchRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.configx.m
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                n.q(secondKey, value, qZoneSetWnsSwitchRequest, baseRequest, z16, j3, str, (qzoneWnsSwitch$SetWnsSwitchRsp) obj);
            }
        });
    }

    public final boolean r() {
        return f("wait_for_runtime_when_init", true);
    }
}
