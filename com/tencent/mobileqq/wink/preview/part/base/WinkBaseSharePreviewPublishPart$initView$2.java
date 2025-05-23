package com.tencent.mobileqq.wink.preview.part.base;

import android.view.View;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewPublishPart$initView$2", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", "b", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/wink/editor/util/c;", "d", "Lcom/tencent/mobileqq/wink/editor/util/c;", "debouncer", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkBaseSharePreviewPublishPart$initView$2 implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.editor.util.c debouncer = new com.tencent.mobileqq.wink.editor.util.c(2000);

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ WinkBaseSharePreviewPublishPart f325413e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkBaseSharePreviewPublishPart$initView$2(WinkBaseSharePreviewPublishPart winkBaseSharePreviewPublishPart) {
        this.f325413e = winkBaseSharePreviewPublishPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(View v3) {
        String str;
        if (FastClickUtils.isFastDoubleClick(BlockPart.TAG)) {
            return;
        }
        if (this.f325413e.J9().getIsPublishing()) {
            QQToast.makeText(this.f325413e.getContext(), R.string.f238887kz, 1).show();
            return;
        }
        Map<String, Object> param = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(param, "param");
        param.put("xsj_operation_activity_id", this.f325413e.G9());
        if (Intrinsics.areEqual(this.f325413e.J9().b2().getValue(), Boolean.TRUE)) {
            str = "1";
        } else {
            str = "0";
        }
        param.put(WinkDaTongReportConstant.ElementParamKey.QQ_IS_SYNC_QZONE_MONENT, str);
        VideoReport.reportEvent("ev_xsj_camera_action", param);
        this.f325413e.J9().d2();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull final View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        this.debouncer.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewPublishPart$initView$2$onClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkBaseSharePreviewPublishPart$initView$2.this.b(v3);
            }
        });
        EventCollector.getInstance().onViewClicked(v3);
    }
}
