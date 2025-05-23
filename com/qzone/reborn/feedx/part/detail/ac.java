package com.qzone.reborn.feedx.part.detail;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.viewmodel.QZoneBlogDetailViewModel;
import com.qzone.reborn.feedx.widget.title.QZoneCommonTitle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedx/part/detail/ac;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "I1", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "d", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "mDetailTitle", "Lcom/qzone/reborn/feedx/viewmodel/h;", "e", "Lcom/qzone/reborn/feedx/viewmodel/h;", "mDetailViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class ac extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneCommonTitle mDetailTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.h mDetailViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(ac this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("toggle_share_panel", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    public boolean I1() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZoneFeedxDetailTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        com.qzone.reborn.feedx.viewmodel.h hVar;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.mz9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026qzone_feedx_detail_title)");
        QZoneCommonTitle qZoneCommonTitle = (QZoneCommonTitle) findViewById;
        this.mDetailTitle = qZoneCommonTitle;
        QZoneCommonTitle qZoneCommonTitle2 = null;
        if (qZoneCommonTitle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailTitle");
            qZoneCommonTitle = null;
        }
        qZoneCommonTitle.getMCenterTitle().setText(com.qzone.util.l.a(R.string.mvm));
        QZoneCommonTitle qZoneCommonTitle3 = this.mDetailTitle;
        if (qZoneCommonTitle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailTitle");
            qZoneCommonTitle3 = null;
        }
        qZoneCommonTitle3.setupTitleHeight(QZoneFeedxViewUtils.b(getActivity()));
        if (I1()) {
            ViewModel viewModel = getViewModel(QZoneBlogDetailViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "{\n            getViewMod\u2026el::class.java)\n        }");
            hVar = (com.qzone.reborn.feedx.viewmodel.h) viewModel;
        } else {
            ViewModel viewModel2 = getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
            Intrinsics.checkNotNullExpressionValue(viewModel2, "{\n            getViewMod\u2026el::class.java)\n        }");
            hVar = (com.qzone.reborn.feedx.viewmodel.h) viewModel2;
        }
        this.mDetailViewModel = hVar;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailViewModel");
            hVar = null;
        }
        if (hVar.u2()) {
            return;
        }
        QZoneCommonTitle qZoneCommonTitle4 = this.mDetailTitle;
        if (qZoneCommonTitle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailTitle");
        } else {
            qZoneCommonTitle2 = qZoneCommonTitle4;
        }
        String a16 = com.qzone.util.l.a(R.string.akv);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.detail.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ac.z9(ac.this, view);
            }
        };
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(com.tencent.mobile\u2026il_button_top_right_more)");
        qZoneCommonTitle2.c(new uh.d(R.drawable.qui_more, null, onClickListener, null, a16, false, 42, null));
    }
}
