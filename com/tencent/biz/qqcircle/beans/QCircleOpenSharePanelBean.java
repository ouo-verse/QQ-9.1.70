package com.tencent.biz.qqcircle.beans;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/beans/QCircleOpenSharePanelBean;", "", "feedId", "", "openSharePanel", "", "(Ljava/lang/String;Z)V", "getFeedId", "()Ljava/lang/String;", "getOpenSharePanel", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QCircleOpenSharePanelBean {

    @Nullable
    private final String feedId;
    private final boolean openSharePanel;

    public QCircleOpenSharePanelBean(@Nullable String str, boolean z16) {
        this.feedId = str;
        this.openSharePanel = z16;
    }

    public static /* synthetic */ QCircleOpenSharePanelBean copy$default(QCircleOpenSharePanelBean qCircleOpenSharePanelBean, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qCircleOpenSharePanelBean.feedId;
        }
        if ((i3 & 2) != 0) {
            z16 = qCircleOpenSharePanelBean.openSharePanel;
        }
        return qCircleOpenSharePanelBean.copy(str, z16);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getOpenSharePanel() {
        return this.openSharePanel;
    }

    @NotNull
    public final QCircleOpenSharePanelBean copy(@Nullable String feedId, boolean openSharePanel) {
        return new QCircleOpenSharePanelBean(feedId, openSharePanel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QCircleOpenSharePanelBean)) {
            return false;
        }
        QCircleOpenSharePanelBean qCircleOpenSharePanelBean = (QCircleOpenSharePanelBean) other;
        if (Intrinsics.areEqual(this.feedId, qCircleOpenSharePanelBean.feedId) && this.openSharePanel == qCircleOpenSharePanelBean.openSharePanel) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getFeedId() {
        return this.feedId;
    }

    public final boolean getOpenSharePanel() {
        return this.openSharePanel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        String str = this.feedId;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i3 = hashCode * 31;
        boolean z16 = this.openSharePanel;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        return "QCircleOpenSharePanelBean(feedId=" + this.feedId + ", openSharePanel=" + this.openSharePanel + ")";
    }
}
