package com.tencent.biz.qqcircle.immersive.redpacket.bean;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketPreviewBean;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "localVideoPath", "", "localCoverPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getLocalCoverPath", "()Ljava/lang/String;", "getLocalVideoPath", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSRedPacketPreviewBean extends QCircleInitBean {

    @NotNull
    private final String localCoverPath;

    @NotNull
    private final String localVideoPath;

    public /* synthetic */ QFSRedPacketPreviewBean(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2);
    }

    @NotNull
    public final String getLocalCoverPath() {
        return this.localCoverPath;
    }

    @NotNull
    public final String getLocalVideoPath() {
        return this.localVideoPath;
    }

    public QFSRedPacketPreviewBean(@NotNull String localVideoPath, @NotNull String localCoverPath) {
        Intrinsics.checkNotNullParameter(localVideoPath, "localVideoPath");
        Intrinsics.checkNotNullParameter(localCoverPath, "localCoverPath");
        this.localVideoPath = localVideoPath;
        this.localCoverPath = localCoverPath;
    }
}
