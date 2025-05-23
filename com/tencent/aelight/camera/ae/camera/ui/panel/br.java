package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.trace.LibraTraceConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\nR$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0003\u0010\u0015R$\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00198V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/br;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "", "g", "()Ljava/lang/String;", "id", "i", "name", "e", "icon", "", "value", "l", "()Z", "r", "(Z)V", "usable", "b", LibraTraceConst.Node.IMAGE_DOWNLOADING, "", "a", "()I", "setDownloadProgress", "(I)V", "downloadProgress", "<init>", "(Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class br extends bj {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final AEMaterialMetaData material;

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: a */
    public int getDownloadProgress() {
        return this.material.downloadProgress;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: b */
    public boolean getCom.tencent.libra.trace.LibraTraceConst.Node.IMAGE_DOWNLOADING java.lang.String() {
        return this.material.downloading;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: e */
    public String getIcon() {
        String str = this.material.iconurl;
        return str == null ? "" : str;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: g */
    public String getId() {
        String str = this.material.f69050id;
        Intrinsics.checkNotNullExpressionValue(str, "material.id");
        return str;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: i */
    public String getName() {
        String str = this.material.cosmeticName;
        return str == null ? "" : str;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: l */
    public boolean getUsable() {
        return this.material.usable;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    public void m(boolean z16) {
        this.material.downloading = z16;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    public void r(boolean z16) {
        this.material.usable = z16;
    }

    /* renamed from: s, reason: from getter */
    public final AEMaterialMetaData getMaterial() {
        return this.material;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(AEMaterialMetaData material) {
        super(null, null, null, 0, false, false, 0, false, 0, 0, false, 0, 4095, null);
        Intrinsics.checkNotNullParameter(material, "material");
        this.material = material;
    }
}
