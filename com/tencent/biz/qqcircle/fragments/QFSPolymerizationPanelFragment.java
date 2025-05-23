package com.tencent.biz.qqcircle.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.bizparts.bx;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t40.g;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0011\u0010!\u001a\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/qqcircle/fragments/QFSPolymerizationPanelFragment;", "Lcom/tencent/biz/qqcircle/fragments/QCirclePolymerizationFragment;", "", "Bh", "Lcom/tencent/biz/qqcircle/beans/QCirclePolymerizationBean;", "initBean", "Dh", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "initIntentData", "", "xh", "", "getContentLayoutId", "", "getLogTag", "Lt40/g;", "H", "Lt40/g;", "mPanelIoc", "Lcom/tencent/biz/qqcircle/fragments/QCircleBlockContainer;", "I", "Lcom/tencent/biz/qqcircle/fragments/QCircleBlockContainer;", "mBlockContainer", "Lcom/tencent/biz/richframework/part/block/base/NestScrollRecyclerView;", "Ch", "()Lcom/tencent/biz/richframework/part/block/base/NestScrollRecyclerView;", "recyclerView", "<init>", "(Lt40/g;)V", "J", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPolymerizationPanelFragment extends QCirclePolymerizationFragment {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final g mPanelIoc;

    /* renamed from: I, reason: from kotlin metadata */
    private QCircleBlockContainer mBlockContainer;

    public QFSPolymerizationPanelFragment(@NotNull g mPanelIoc) {
        Intrinsics.checkNotNullParameter(mPanelIoc, "mPanelIoc");
        this.mPanelIoc = mPanelIoc;
    }

    private final void Bh() {
        VideoReport.setPageId(this.mPanelIoc.v6(), getDaTongPageId());
        VideoReport.setPageParams(this.mPanelIoc.v6(), new QCircleDTParamBuilder().buildPageParams(getTAG(), getChildDaTongPageParams()));
        VideoReport.setElementId(this.mPanelIoc.v6(), "em_xsj_close_button");
        ImageView v65 = this.mPanelIoc.v6();
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(v65, exposurePolicy);
        VideoReport.setElementId(this.mPanelIoc.A(), QCircleDaTongConstant.ElementId.EM_XSJ_FULLPAGE_SWITCH_BUTTON);
        VideoReport.setPageId(this.mPanelIoc.A(), getDaTongPageId());
        VideoReport.setPageParams(this.mPanelIoc.A(), new QCircleDTParamBuilder().buildPageParams(getTAG(), getChildDaTongPageParams()));
        VideoReport.setElementExposePolicy(this.mPanelIoc.A(), exposurePolicy);
    }

    @NotNull
    public final NestScrollRecyclerView Ch() {
        QCircleBlockContainer qCircleBlockContainer = this.mBlockContainer;
        if (qCircleBlockContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlockContainer");
            qCircleBlockContainer = null;
        }
        NestScrollRecyclerView recyclerView = qCircleBlockContainer.getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mBlockContainer.recyclerView");
        return recyclerView;
    }

    public final void Dh(@NotNull QCirclePolymerizationBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.C = initBean;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        if (assembleParts != null) {
            QCirclePolymerizationBean mInitBean = this.C;
            Intrinsics.checkNotNullExpressionValue(mInitBean, "mInitBean");
            assembleParts.add(new bx(mInitBean, this.mPanelIoc));
        }
        return assembleParts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gnt;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPolymerizationPanelFragment";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        View findViewById = contentView.findViewById(R.id.uaf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.cpv_component_view)");
        this.mBlockContainer = (QCircleBlockContainer) findViewById;
        ViewTreeViewModelStoreOwner.set(Ch(), this);
        com.tencent.mobileqq.qui.b.f276860a.a(Ch(), RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        Bh();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment
    protected boolean xh() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment
    protected void initIntentData() {
    }
}
