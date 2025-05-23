package com.tencent.biz.qqcircle.beans;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003H\u00c2\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u00d6\u0003J\t\u0010\u000b\u001a\u00020\fH\u00d6\u0001J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/beans/QCircleHotEventPolymerizationBean;", "Lcom/tencent/biz/qqcircle/beans/QCirclePolymerizationBean;", "hotInfo", "Lcom/tencent/biz/qqcircle/beans/HotEventInfo;", "(Lcom/tencent/biz/qqcircle/beans/HotEventInfo;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QCircleHotEventPolymerizationBean extends QCirclePolymerizationBean {

    @NotNull
    private final HotEventInfo hotInfo;

    public QCircleHotEventPolymerizationBean(@NotNull HotEventInfo hotInfo) {
        Intrinsics.checkNotNullParameter(hotInfo, "hotInfo");
        this.hotInfo = hotInfo;
        setPolymerizationType(63);
        setHotEventInfo(hotInfo);
    }

    /* renamed from: component1, reason: from getter */
    private final HotEventInfo getHotInfo() {
        return this.hotInfo;
    }

    public static /* synthetic */ QCircleHotEventPolymerizationBean copy$default(QCircleHotEventPolymerizationBean qCircleHotEventPolymerizationBean, HotEventInfo hotEventInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            hotEventInfo = qCircleHotEventPolymerizationBean.hotInfo;
        }
        return qCircleHotEventPolymerizationBean.copy(hotEventInfo);
    }

    @NotNull
    public final QCircleHotEventPolymerizationBean copy(@NotNull HotEventInfo hotInfo) {
        Intrinsics.checkNotNullParameter(hotInfo, "hotInfo");
        return new QCircleHotEventPolymerizationBean(hotInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof QCircleHotEventPolymerizationBean) && Intrinsics.areEqual(this.hotInfo, ((QCircleHotEventPolymerizationBean) other).hotInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.hotInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "QCircleHotEventPolymerizationBean(hotInfo=" + this.hotInfo + ")";
    }
}
