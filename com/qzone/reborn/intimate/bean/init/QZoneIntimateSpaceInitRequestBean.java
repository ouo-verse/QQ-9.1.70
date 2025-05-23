package com.qzone.reborn.intimate.bean.init;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\t\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "spaceId", "Z", "c", "()Z", "isDraft", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "activateSpaceBean", "<init>", "(Ljava/lang/String;ZLcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.reborn.intimate.bean.init.b, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class QZoneIntimateSpaceInitRequestBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String spaceId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDraft;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final QZoneIntimateActivateSpaceBean activateSpaceBean;

    public QZoneIntimateSpaceInitRequestBean(String spaceId, boolean z16, QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        this.spaceId = spaceId;
        this.isDraft = z16;
        this.activateSpaceBean = qZoneIntimateActivateSpaceBean;
    }

    /* renamed from: a, reason: from getter */
    public final QZoneIntimateActivateSpaceBean getActivateSpaceBean() {
        return this.activateSpaceBean;
    }

    /* renamed from: b, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsDraft() {
        return this.isDraft;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.spaceId.hashCode() * 31;
        boolean z16 = this.isDraft;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean = this.activateSpaceBean;
        return i16 + (qZoneIntimateActivateSpaceBean == null ? 0 : qZoneIntimateActivateSpaceBean.hashCode());
    }

    public String toString() {
        return "QZoneIntimateSpaceInitRequestBean(spaceId=" + this.spaceId + ", isDraft=" + this.isDraft + ", activateSpaceBean=" + this.activateSpaceBean + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneIntimateSpaceInitRequestBean)) {
            return false;
        }
        QZoneIntimateSpaceInitRequestBean qZoneIntimateSpaceInitRequestBean = (QZoneIntimateSpaceInitRequestBean) other;
        return Intrinsics.areEqual(this.spaceId, qZoneIntimateSpaceInitRequestBean.spaceId) && this.isDraft == qZoneIntimateSpaceInitRequestBean.isDraft && Intrinsics.areEqual(this.activateSpaceBean, qZoneIntimateSpaceInitRequestBean.activateSpaceBean);
    }
}
