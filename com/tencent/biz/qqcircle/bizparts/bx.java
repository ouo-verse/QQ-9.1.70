package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/bizparts/bx;", "Lcom/tencent/biz/qqcircle/bizparts/QFSPolymerizationBaseSharePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "getLogTag", "Lt40/g;", BdhLogUtil.LogTag.Tag_Conn, "Lt40/g;", "mPanelIoc", "Landroid/widget/ImageView;", "D9", "()Landroid/widget/ImageView;", "shareView", "Lcom/tencent/biz/qqcircle/beans/QCirclePolymerizationBean;", "initBean", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCirclePolymerizationBean;Lt40/g;)V", "D", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class bx extends QFSPolymerizationBaseSharePart {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final t40.g mPanelIoc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(@NotNull QCirclePolymerizationBean initBean, @NotNull t40.g mPanelIoc) {
        super(initBean);
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        Intrinsics.checkNotNullParameter(mPanelIoc, "mPanelIoc");
        this.mPanelIoc = mPanelIoc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(bx this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.biz.qqcircle.launcher.c.j0(this$0.getContext(), this$0.mInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSPolymerizationBaseSharePart
    @NotNull
    protected ImageView D9() {
        return this.mPanelIoc.k2();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPolymerizationTitlePart";
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSPolymerizationBaseSharePart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.mPanelIoc.A().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.bw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bx.K9(bx.this, view);
            }
        });
    }
}
