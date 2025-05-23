package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00148V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/ar;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;", "beautyConfig", "", "g", "()Ljava/lang/String;", "id", "i", "name", "e", "icon", "", "f", "()I", "iconId", "", "j", "()Z", "showAdjust", "value", "c", DomainData.DOMAIN_NAME, "(Z)V", "enable", "<init>", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ar extends bj {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final b beautyConfig;

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: c */
    public boolean getEnable() {
        return this.beautyConfig.getEnable();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: e */
    public String getIcon() {
        return this.beautyConfig.getIconUrl();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: f */
    public int getIconId() {
        return this.beautyConfig.getImageResId();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: g */
    public String getId() {
        return String.valueOf(this.beautyConfig.getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String().getType().ordinal());
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: i */
    public String getName() {
        return this.beautyConfig.getKey();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: j */
    public boolean getShowAdjust() {
        return this.beautyConfig.getEnable() && AEProviderViewModel.INSTANCE.b(this.beautyConfig) != 0;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    public void n(boolean z16) {
        this.beautyConfig.p(z16);
        Iterator<T> it = this.beautyConfig.i().iterator();
        while (it.hasNext()) {
            ((f) it.next()).l(z16);
        }
    }

    /* renamed from: s, reason: from getter */
    public final b getBeautyConfig() {
        return this.beautyConfig;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(b beautyConfig) {
        super(null, null, null, 0, false, false, 0, false, 0, 0, false, 0, 4095, null);
        Intrinsics.checkNotNullParameter(beautyConfig, "beautyConfig");
        this.beautyConfig = beautyConfig;
    }
}
