package dv3;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.gallery.part.r;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Ldv3/c;", "Lcom/tencent/qqnt/aio/gallery/part/r;", "", "clickSaveBtn", "clickShowMoreBtn", "<init>", "()V", "f", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends r {
    @Override // com.tencent.qqnt.aio.gallery.part.r, com.tencent.richframework.gallery.delegate.INTLayerOperationListener
    public void clickSaveBtn() {
        if (QLog.isColorLevel()) {
            QLog.d("NTGroupEmoReportPart", 2, "clickSaveBtn");
        }
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
        super.clickSaveBtn();
    }

    @Override // com.tencent.qqnt.aio.gallery.part.r, com.tencent.richframework.gallery.delegate.INTLayerOperationListener
    public void clickShowMoreBtn() {
        QLog.d("NTGroupEmoReportPart", 2, "clickShowMoreBtn");
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        super.clickShowMoreBtn();
    }
}
