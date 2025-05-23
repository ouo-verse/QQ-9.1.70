package com.qzone.reborn.configx;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0005\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/configx/f;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, "", "p", "j", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "k", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f extends d {
    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_CANG_LAN";
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return "";
    }

    public final boolean j() {
        return f("qzone_comment_panel_disable_long_click_forward", false);
    }

    public final boolean k() {
        return f("qzone_enable_auto_fill_text_to_qq_emo", true);
    }

    public final boolean l() {
        return f("qzone_comment_panel_enable_force_use_qui_theme", true);
    }

    public final String m() {
        return e("qzone_comment_panel_aniversay_feed_share_reason", "\u5206\u4eab\u7406\u7531");
    }

    public final String n() {
        return e("qzone_comment_panel_forward_reason", "\u8f6c\u53d1\u5230QQ\u7a7a\u95f4");
    }

    public final String o() {
        return e("qzone_comment_panel_year_today_share_reason", "\u5206\u4eab\u7f8e\u597d\u56de\u5fc6");
    }

    public final boolean p() {
        return f("qzone_comment_panel_use_qq_emotion", true);
    }
}
