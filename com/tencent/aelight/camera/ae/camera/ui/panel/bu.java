package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00148V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/bu;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/ae/camera/ui/panel/f;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/f;", "beautyConfig", "", "g", "()Ljava/lang/String;", "id", "i", "name", "e", "icon", "", "f", "()I", "iconId", "", "value", "c", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "enable", "<init>", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/f;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class bu extends bj {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final f beautyConfig;

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: c */
    public boolean getEnable() {
        return this.beautyConfig.getEnable();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: e */
    public String getIcon() {
        String iconUrl = this.beautyConfig.getIconUrl();
        return iconUrl == null ? "" : iconUrl;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: f */
    public int getIconId() {
        return this.beautyConfig.getIcon();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: g */
    public String getId() {
        return this.beautyConfig.getType();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: i */
    public String getName() {
        return this.beautyConfig.getName();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    public void n(boolean z16) {
        this.beautyConfig.l(z16);
    }

    /* renamed from: s, reason: from getter */
    public final f getBeautyConfig() {
        return this.beautyConfig;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(f beautyConfig) {
        super(null, null, null, 0, false, false, 0, false, 0, 0, false, 0, 4095, null);
        Intrinsics.checkNotNullParameter(beautyConfig, "beautyConfig");
        this.beautyConfig = beautyConfig;
    }
}
