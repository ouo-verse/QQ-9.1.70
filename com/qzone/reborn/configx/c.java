package com.qzone.reborn.configx;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/configx/c;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, "", "l", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", DomainData.DOMAIN_NAME, "o", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends d {
    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_CANG_LAN";
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return "";
    }

    public final boolean j() {
        return f("qzone_publishx_business_disable", false);
    }

    public final boolean k() {
        return f("qzone_album_qcircle_red_dot_disable", false);
    }

    public final boolean l() {
        return f("qzone_albumx_business_disable", false);
    }

    public final boolean m() {
        return f("qzone_albumx_small_gray_tab", false);
    }

    public final String n() {
        return e("qzone_album_entrance_guide_bubble_text", "\u77ed\u89c6\u9891\u79fb\u81f3\u76f8\u518c\u5566");
    }

    public final String o() {
        return e("qzone_qcircle_album_entrance_guide_bubble_text", "\u77ed\u89c6\u9891\u8fc1\u79fb\u81f3\u6b64\u76f8\u518c");
    }
}
