package com.qzone.reborn.albumx.qzonex.bean;

import com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/QZAlbumxDescDetailInitBean;", "Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;", "uin", "", "titleBarText", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getTitleBarText", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxDescDetailInitBean extends QZAlbumxInitBean {
    private final String text;
    private final String titleBarText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxDescDetailInitBean(String uin, String titleBarText, String text) {
        super(uin);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(titleBarText, "titleBarText");
        Intrinsics.checkNotNullParameter(text, "text");
        this.titleBarText = titleBarText;
        this.text = text;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitleBarText() {
        return this.titleBarText;
    }
}
