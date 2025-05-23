package com.qzone.reborn.configx;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/configx/a;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", DomainData.DOMAIN_NAME, "l", "k", "j", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends d {
    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_CANG_LAN";
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return "";
    }

    public final boolean j() {
        return f("disable_group_album_scroll_to_comment_location_pos", false);
    }

    public final boolean k() {
        return f("enable_group_album_post_runnable_notify_data", true);
    }

    public final boolean l() {
        return f("group_album_group_aio_forward_switch", true);
    }

    public final int m() {
        return b("group_album_detail_share_pool_size", 50);
    }

    public final boolean n() {
        return f("group_album_nick_to_remark", true);
    }
}
