package com.qzone.reborn.configx;

import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/configx/l;", "Lcom/qzone/reborn/configx/d;", "", "i", tl.h.F, "j", "k", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l extends d {
    @Override // com.qzone.reborn.configx.d
    public String h() {
        return "CONFIG_CHANNEL_WNS";
    }

    @Override // com.qzone.reborn.configx.d
    public String i() {
        return WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING;
    }

    public final String j() {
        return e("ToastInputIsNull", "\u8f93\u5165\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a");
    }

    public final String k() {
        return e("NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5");
    }
}
