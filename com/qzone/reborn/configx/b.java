package com.qzone.reborn.configx;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/configx/b;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, DomainData.DOMAIN_NAME, "l", "j", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends d {
    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_WNS";
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return "group_album";
    }

    public final String j() {
        return e("group_album_space_album_list_guest_empty_text", "\u6253\u9020\u4e13\u5c5e\u7fa4\u76f8\u518c\uff0c\u7559\u4f4f\u96be\u5fd8\u65f6\u523b");
    }

    public final String k() {
        return e("group_album_message_list_empty_text", "\u671f\u5f85\u4f60\u4eec\u7684\u4e92\u52a8");
    }

    public final String l() {
        return e("group_album_space_album_list_owner_empty_text", "\u671f\u5f85\u5206\u4eab\u7f8e\u597d\u65f6\u5149");
    }

    public final boolean m() {
        return f("GROUP_ALBUM_del_media_file_default_check_state", true);
    }

    public final String n() {
        return e("group_album_feed_like_list_url", "https://h5.qzone.qq.com/intimate-space/h5/album-like-list?_wv=2&_bid=5588");
    }
}
