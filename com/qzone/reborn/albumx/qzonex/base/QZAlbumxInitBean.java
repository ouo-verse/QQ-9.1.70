package com.qzone.reborn.albumx.qzonex.base;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;", "Ljava/io/Serializable;", "uin", "", "(Ljava/lang/String;)V", "launchTime", "", "getLaunchTime", "()J", "setLaunchTime", "(J)V", "serialVersionUID", "getUin", "()Ljava/lang/String;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public abstract class QZAlbumxInitBean implements Serializable {
    private long launchTime;
    private final long serialVersionUID;
    private final String uin;

    public QZAlbumxInitBean(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.serialVersionUID = 1521697345907559143L;
    }

    public long getLaunchTime() {
        return this.launchTime;
    }

    public String getUin() {
        return this.uin;
    }

    public void setLaunchTime(long j3) {
        this.launchTime = j3;
    }
}
