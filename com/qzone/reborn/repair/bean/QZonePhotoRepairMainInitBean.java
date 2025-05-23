package com.qzone.reborn.repair.bean;

import com.qzone.reborn.bean.QZoneInitBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/repair/bean/QZonePhotoRepairMainInitBean;", "Lcom/qzone/reborn/bean/QZoneInitBean;", "from", "", "(I)V", "getFrom", "()I", "setFrom", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZonePhotoRepairMainInitBean extends QZoneInitBean {
    private int from;

    public QZonePhotoRepairMainInitBean() {
        this(0, 1, null);
    }

    public final int getFrom() {
        return this.from;
    }

    public final void setFrom(int i3) {
        this.from = i3;
    }

    public /* synthetic */ QZonePhotoRepairMainInitBean(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
    }

    public QZonePhotoRepairMainInitBean(int i3) {
        this.from = i3;
    }
}
