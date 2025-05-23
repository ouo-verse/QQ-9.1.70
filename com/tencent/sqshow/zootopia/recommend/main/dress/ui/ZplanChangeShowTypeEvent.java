package com.tencent.sqshow.zootopia.recommend.main.dress.ui;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/dress/ui/ZplanChangeShowTypeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "id", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getShowType", "()I", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZplanChangeShowTypeEvent extends SimpleBaseEvent {
    private final String id;
    private final int showType;

    public ZplanChangeShowTypeEvent(String id5, int i3) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
        this.showType = i3;
    }

    public final String getId() {
        return this.id;
    }

    public final int getShowType() {
        return this.showType;
    }
}
