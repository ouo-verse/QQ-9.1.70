package com.tencent.biz.qqcircle.beans;

import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/beans/QFSAIOFeedShareInitBean;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "aioUin", "", "aioChatType", "", IProfileCardConst.KEY_FROM_TYPE, "(Ljava/lang/String;ILjava/lang/String;)V", "getAioChatType", "()I", "getAioUin", "()Ljava/lang/String;", "getFromType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QFSAIOFeedShareInitBean extends QCircleInitBean {
    private final int aioChatType;

    @NotNull
    private final String aioUin;

    @NotNull
    private final String fromType;

    public /* synthetic */ QFSAIOFeedShareInitBean(String str, int i3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i16 & 4) != 0 ? "" : str2);
    }

    public static /* synthetic */ QFSAIOFeedShareInitBean copy$default(QFSAIOFeedShareInitBean qFSAIOFeedShareInitBean, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = qFSAIOFeedShareInitBean.aioUin;
        }
        if ((i16 & 2) != 0) {
            i3 = qFSAIOFeedShareInitBean.aioChatType;
        }
        if ((i16 & 4) != 0) {
            str2 = qFSAIOFeedShareInitBean.fromType;
        }
        return qFSAIOFeedShareInitBean.copy(str, i3, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAioUin() {
        return this.aioUin;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAioChatType() {
        return this.aioChatType;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getFromType() {
        return this.fromType;
    }

    @NotNull
    public final QFSAIOFeedShareInitBean copy(@NotNull String aioUin, int aioChatType, @NotNull String fromType) {
        Intrinsics.checkNotNullParameter(aioUin, "aioUin");
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        return new QFSAIOFeedShareInitBean(aioUin, aioChatType, fromType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSAIOFeedShareInitBean)) {
            return false;
        }
        QFSAIOFeedShareInitBean qFSAIOFeedShareInitBean = (QFSAIOFeedShareInitBean) other;
        if (Intrinsics.areEqual(this.aioUin, qFSAIOFeedShareInitBean.aioUin) && this.aioChatType == qFSAIOFeedShareInitBean.aioChatType && Intrinsics.areEqual(this.fromType, qFSAIOFeedShareInitBean.fromType)) {
            return true;
        }
        return false;
    }

    public final int getAioChatType() {
        return this.aioChatType;
    }

    @NotNull
    public final String getAioUin() {
        return this.aioUin;
    }

    @NotNull
    public final String getFromType() {
        return this.fromType;
    }

    public int hashCode() {
        return (((this.aioUin.hashCode() * 31) + this.aioChatType) * 31) + this.fromType.hashCode();
    }

    @NotNull
    public String toString() {
        return "QFSAIOFeedShareInitBean(aioUin=" + this.aioUin + ", aioChatType=" + this.aioChatType + ", fromType=" + this.fromType + ")";
    }

    public QFSAIOFeedShareInitBean(@NotNull String aioUin, int i3, @NotNull String fromType) {
        Intrinsics.checkNotNullParameter(aioUin, "aioUin");
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        this.aioUin = aioUin;
        this.aioChatType = i3;
        this.fromType = fromType;
    }
}
