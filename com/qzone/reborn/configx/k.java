package com.qzone.reborn.configx;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0005\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/configx/k;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "j", "k", "p", "o", "t", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "r", "", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k extends d {
    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_WNS";
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return "qzone_publish";
    }

    public final boolean j() {
        return f("configx_check_apn_change_for_init", true);
    }

    public final boolean k() {
        return f("enable_change_stack_type", true);
    }

    public final boolean l() {
        return f("configx_pic_compress_use_new_strategy", true);
    }

    public final boolean m() {
        return f("configx_pic_video_connect_type_use_epoll", true);
    }

    public final boolean n() {
        return f("configx_enable_get_feed_fail_retry_optimize", true);
    }

    public final boolean o() {
        return f("configx_enable_publish_queue_restore_init", true);
    }

    public final boolean p() {
        return f("configx_enable_publish_shuoshuo_so_download", false);
    }

    public final boolean q() {
        return f("configx_upload_image_format_convert", true);
    }

    public final boolean r() {
        return f("configx_enable_upload_ip_route_race_optimize_gray", true);
    }

    public final boolean s() {
        return f("configx_enable_upload_ip_route_race_optimize_public", false);
    }

    public final int u() {
        return b("configx_upload_disconnect_max_count", 1);
    }

    public final String t() {
        String a16 = com.qzone.util.l.a(R.string.jih);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_alb\u2026get_feed_fail_retry_text)");
        return e("configx_publish_get_feed_fail_retry_text", a16);
    }
}
