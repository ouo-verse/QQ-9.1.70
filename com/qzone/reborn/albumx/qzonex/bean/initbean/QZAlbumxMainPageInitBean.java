package com.qzone.reborn.albumx.qzonex.bean.initbean;

import com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", "Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;", "uin", "", "(Ljava/lang/String;)V", "from", "getFrom", "()Ljava/lang/String;", "setFrom", "tabIndex", "", "getTabIndex", "()I", "setTabIndex", "(I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxMainPageInitBean extends QZAlbumxInitBean {
    private String from;
    private int tabIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxMainPageInitBean(String uin) {
        super(uin);
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.from = "";
    }

    public final String getFrom() {
        return this.from;
    }

    public final int getTabIndex() {
        return this.tabIndex;
    }

    public final void setFrom(String str) {
        this.from = str;
    }

    public final void setTabIndex(int i3) {
        this.tabIndex = i3;
    }
}
