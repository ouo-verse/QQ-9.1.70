package com.qzone.reborn.feedpro.part.detail;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/feedpro/part/detail/t;", "Lcom/qzone/reborn/feedpro/part/d;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/os/Handler;", "getMainHandler", "cacheFeedKey", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "J9", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "G", "Lcom/qzone/reborn/feedpro/viewmodel/i;", "mDetailViewModel", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class t extends com.qzone.reborn.feedpro.part.d {

    /* renamed from: G, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.i mDetailViewModel;

    @Override // com.qzone.reborn.feedpro.part.d
    public CommonFeed J9(String cacheFeedKey) {
        com.qzone.reborn.feedpro.viewmodel.i iVar = this.mDetailViewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailViewModel");
            iVar = null;
        }
        return iVar.d2();
    }

    @Override // com.qzone.reborn.feedpro.part.d, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProDetailCommentOperationPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }

    @Override // com.qzone.reborn.feedpro.part.d, com.qzone.reborn.feedpro.part.b, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedpro.viewmodel.i.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QzoneFeedPr\u2026ailViewModel::class.java)");
        this.mDetailViewModel = (com.qzone.reborn.feedpro.viewmodel.i) viewModel;
    }
}
