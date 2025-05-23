package com.qzone.reborn.intimate.event;

import com.qzone.reborn.intimate.bean.QZIntimateSettingItemBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/qzone/reborn/intimate/event/QZIntimateModifySettingEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "settingItem", "Lcom/qzone/reborn/intimate/bean/QZIntimateSettingItemBean;", "(Lcom/qzone/reborn/intimate/bean/QZIntimateSettingItemBean;)V", "getSettingItem", "()Lcom/qzone/reborn/intimate/bean/QZIntimateSettingItemBean;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZIntimateModifySettingEvent extends SimpleBaseEvent {
    private final QZIntimateSettingItemBean settingItem;

    public QZIntimateModifySettingEvent(QZIntimateSettingItemBean settingItem) {
        Intrinsics.checkNotNullParameter(settingItem, "settingItem");
        this.settingItem = settingItem;
    }

    public final QZIntimateSettingItemBean getSettingItem() {
        return this.settingItem;
    }
}
