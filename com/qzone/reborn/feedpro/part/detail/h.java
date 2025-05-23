package com.qzone.reborn.feedpro.part.detail;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.title.QZoneCommonTitle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/feedpro/part/detail/h;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "d", "Lcom/qzone/reborn/feedx/widget/title/QZoneCommonTitle;", "mDetailTitle", "Lcom/qzone/reborn/feedpro/viewmodel/d;", "e", "Lcom/qzone/reborn/feedpro/viewmodel/d;", "mDetailViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneCommonTitle mDetailTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.d mDetailViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z9(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        re.b bVar = (re.b) this$0.getViewModel(re.b.class);
        if (bVar != null) {
            com.qzone.reborn.feedpro.viewmodel.d dVar = this$0.mDetailViewModel;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDetailViewModel");
                dVar = null;
            }
            UIStateData<CommonFeed> value = dVar.N1().getValue();
            bVar.W1(value != null ? value.getData() : null);
            bVar.X1(true);
            bVar.O1().setValue(Boolean.TRUE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProBlogDetailTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
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
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedpro.viewmodel.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QzoneFeedPr\u2026ailViewModel::class.java)");
        this.mDetailViewModel = (com.qzone.reborn.feedpro.viewmodel.d) viewModel;
        QZoneCommonTitle qZoneCommonTitle4 = this.mDetailTitle;
        if (qZoneCommonTitle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailTitle");
        } else {
            qZoneCommonTitle2 = qZoneCommonTitle4;
        }
        String a16 = com.qzone.util.l.a(R.string.akv);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.detail.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.z9(h.this, view);
            }
        };
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.detail_button_top_right_more)");
        qZoneCommonTitle2.c(new uh.d(R.drawable.qui_more, null, onClickListener, null, a16, false, 42, null));
    }
}
