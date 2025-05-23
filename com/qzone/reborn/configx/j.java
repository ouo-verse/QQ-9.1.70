package com.qzone.reborn.configx;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/configx/j;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "j", DomainData.DOMAIN_NAME, "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j extends d {
    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_CANG_LAN";
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return "";
    }

    public final String j() {
        return e("qzone_protect_forbidden_banner_config", "");
    }

    public final String k() {
        return e("qzone_protect_forbidden_feed_section_config", "");
    }

    public final String l() {
        return e("qzone_protect_forbidden_part_config", "");
    }

    public final String m() {
        return e("qzone_protect_forbidden_section_config", "");
    }

    public final String n() {
        return e("qzone_protect_forbidden_new_section_config", "");
    }
}
