package com.qzone.reborn.intimate.bean.init;

import com.qzone.reborn.intimate.bean.QZoneIntimateUserBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "()V", "anniversary", "", "getAnniversary", "()J", "setAnniversary", "(J)V", "spaceType", "", "getSpaceType", "()I", "setSpaceType", "(I)V", "users", "", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateUserBean;", "getUsers", "()Ljava/util/List;", "setUsers", "(Ljava/util/List;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateActivateSpaceBean extends QZoneIntimateInitBean {
    private long anniversary;
    private int spaceType;
    private List<QZoneIntimateUserBean> users = new ArrayList();

    public final long getAnniversary() {
        return this.anniversary;
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    public final List<QZoneIntimateUserBean> getUsers() {
        return this.users;
    }

    public final void setAnniversary(long j3) {
        this.anniversary = j3;
    }

    public final void setSpaceType(int i3) {
        this.spaceType = i3;
    }

    public final void setUsers(List<QZoneIntimateUserBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.users = list;
    }
}
