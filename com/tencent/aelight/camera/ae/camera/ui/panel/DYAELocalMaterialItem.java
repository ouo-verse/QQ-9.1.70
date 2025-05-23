package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/bq;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "", "toString", "", "hashCode", "", "other", "", "equals", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "g", "()Ljava/lang/String;", "id", DomainData.DOMAIN_NAME, "i", "name", "o", "e", "icon", "p", ReportConstant.COSTREPORT_PREFIX, "path", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.aelight.camera.ae.camera.ui.panel.bq, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class DYAELocalMaterialItem extends bj {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String id;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final String name;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final String icon;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private final String path;

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: e, reason: from getter */
    public String getIcon() {
        return this.icon;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: g, reason: from getter */
    public String getId() {
        return this.id;
    }

    public int hashCode() {
        return (((((getId().hashCode() * 31) + getName().hashCode()) * 31) + getIcon().hashCode()) * 31) + this.path.hashCode();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: i, reason: from getter */
    public String getName() {
        return this.name;
    }

    /* renamed from: s, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public String toString() {
        return "DYAELocalMaterialItem(id=" + getId() + ", name=" + getName() + ", icon=" + getIcon() + ", path=" + this.path + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DYAELocalMaterialItem)) {
            return false;
        }
        DYAELocalMaterialItem dYAELocalMaterialItem = (DYAELocalMaterialItem) other;
        return Intrinsics.areEqual(getId(), dYAELocalMaterialItem.getId()) && Intrinsics.areEqual(getName(), dYAELocalMaterialItem.getName()) && Intrinsics.areEqual(getIcon(), dYAELocalMaterialItem.getIcon()) && Intrinsics.areEqual(this.path, dYAELocalMaterialItem.path);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DYAELocalMaterialItem(String id5, String name, String icon, String path) {
        super(id5, name, icon, 0, false, false, 0, false, 0, 0, false, 0, 4088, null);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(path, "path");
        this.id = id5;
        this.name = name;
        this.icon = icon;
        this.path = path;
    }
}
