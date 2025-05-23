package com.qzone.reborn.intimate.bean;

import com.qzone.reborn.intimate.bean.init.QZoneIntimateInitBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/intimate/bean/QZoneIntimateActivateResultBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "()V", "activateStatus", "", "getActivateStatus", "()Z", "setActivateStatus", "(Z)V", "spaceId", "", "getSpaceId", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateActivateResultBean extends QZoneIntimateInitBean {
    private boolean activateStatus;
    private String spaceId = "";

    public final boolean getActivateStatus() {
        return this.activateStatus;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final void setActivateStatus(boolean z16) {
        this.activateStatus = z16;
    }

    public final void setSpaceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }
}
