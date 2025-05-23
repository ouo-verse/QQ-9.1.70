package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/bp;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "Lcom/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem;", "filterItem", "", "g", "()Ljava/lang/String;", "id", "i", "name", "e", "icon", "<init>", "(Lcom/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class bp extends bj {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final QIMFilterCategoryItem filterItem;

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: e */
    public String getIcon() {
        String str = this.filterItem.f66700h;
        Intrinsics.checkNotNullExpressionValue(str, "filterItem.iconUrl");
        return str;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: g */
    public String getId() {
        String str = this.filterItem.f66697d;
        Intrinsics.checkNotNullExpressionValue(str, "filterItem.id");
        return str;
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.bj
    /* renamed from: i */
    public String getName() {
        String str = this.filterItem.f66698e;
        Intrinsics.checkNotNullExpressionValue(str, "filterItem.name");
        return str;
    }

    /* renamed from: s, reason: from getter */
    public final QIMFilterCategoryItem getFilterItem() {
        return this.filterItem;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp(QIMFilterCategoryItem filterItem) {
        super(null, null, null, 0, false, false, 0, false, 0, 0, false, 0, 4095, null);
        Intrinsics.checkNotNullParameter(filterItem, "filterItem");
        this.filterItem = filterItem;
    }
}
