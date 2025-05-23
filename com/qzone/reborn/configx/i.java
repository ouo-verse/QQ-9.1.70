package com.qzone.reborn.configx;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/configx/i;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, "", "j", "k", "", DomainData.DOMAIN_NAME, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class i extends d {
    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_WNS";
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return "QZoneSetting";
    }

    public final boolean j() {
        return f("configx_enable_qzone_runtime", true);
    }

    public final boolean k() {
        return f("configx_enable_qzone_memory_release", true);
    }

    public final boolean l() {
        return f("configx_enable_save_picture_new", true);
    }

    public final boolean m() {
        return f("configx_enable_save_video_new", true);
    }

    public final int n() {
        return b("configx_get_action_panel_has_focus_delay", 200);
    }

    public final int o() {
        return b("configx_min_display_metrics_density_dpi", 480);
    }

    public final boolean p() {
        return b("configx_close_watermark_download_and_share", 0) == 0;
    }

    public final boolean q() {
        return f("configx_show_share_image_by_libra", true);
    }
}
