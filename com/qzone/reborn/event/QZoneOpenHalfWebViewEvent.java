package com.qzone.reborn.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/event/QZoneOpenHalfWebViewEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", WadlProxyConsts.KEY_JUMP_URL, "", "isSchema", "", "heightRatio", "", "(Ljava/lang/String;ZF)V", "getHeightRatio", "()F", "()Z", "getJumpUrl", "()Ljava/lang/String;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneOpenHalfWebViewEvent extends SimpleBaseEvent {
    private final float heightRatio;
    private final boolean isSchema;
    private final String jumpUrl;

    public QZoneOpenHalfWebViewEvent(String jumpUrl, boolean z16, float f16) {
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.jumpUrl = jumpUrl;
        this.isSchema = z16;
        this.heightRatio = f16;
    }

    public final float getHeightRatio() {
        return this.heightRatio;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: isSchema, reason: from getter */
    public final boolean getIsSchema() {
        return this.isSchema;
    }
}
