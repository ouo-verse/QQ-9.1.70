package com.qzone.reborn.albumx.qzone.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/event/QZoneAlbumxMediaListTitleEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "I", "getClickType", "()I", "setClickType", "(I)V", "<init>", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxMediaListTitleEvent extends SimpleBaseEvent {
    public static final int CLICK_TYPE_CANCEL_OPERATE_LEFT = 2;
    public static final int CLICK_TYPE_CANCEL_OPERATE_RIGHT_ALL_SELECT = 3;
    public static final int CLICK_TYPE_CANCEL_OPERATE_RIGHT_CANCEL_ALL_SELECT = 4;
    public static final int CLICK_TYPE_OPERATE_RIGHT = 1;
    private int clickType;

    public QZoneAlbumxMediaListTitleEvent(int i3) {
        this.clickType = i3;
    }

    public final int getClickType() {
        return this.clickType;
    }

    public final void setClickType(int i3) {
        this.clickType = i3;
    }
}
