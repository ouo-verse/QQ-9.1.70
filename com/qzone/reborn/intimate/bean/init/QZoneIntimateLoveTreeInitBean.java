package com.qzone.reborn.intimate.bean.init;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateLoveTreeInitBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "()V", "enterPage", "", "getEnterPage", "()Ljava/lang/String;", "setEnterPage", "(Ljava/lang/String;)V", "flowerId", "getFlowerId", "setFlowerId", "from", "getFrom", "setFrom", "peerUin", "getPeerUin", "setPeerUin", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateLoveTreeInitBean extends QZoneIntimateInitBean {
    private String peerUin = "";
    private String enterPage = "";
    private String flowerId = "";
    private String from = "";

    public final String getEnterPage() {
        return this.enterPage;
    }

    public final String getFlowerId() {
        return this.flowerId;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getPeerUin() {
        return this.peerUin;
    }

    public final void setEnterPage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.enterPage = str;
    }

    public final void setFlowerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.flowerId = str;
    }

    public final void setFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.from = str;
    }

    public final void setPeerUin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.peerUin = str;
    }

    public String toString() {
        return "QZoneIntimateLoveTreeInitBean(peerUin='" + this.peerUin + "', enterPage=" + this.enterPage + ", flowerId=" + this.flowerId + ", from=" + this.from + ")";
    }
}
