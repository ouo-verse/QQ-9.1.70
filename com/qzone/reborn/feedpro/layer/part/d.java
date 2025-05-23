package com.qzone.reborn.feedpro.layer.part;

import androidx.lifecycle.ViewModel;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerListBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/d;", "Lcom/qzone/reborn/feedpro/layer/part/QzoneFeedProBaseLayerControlPart;", "Lge/g;", "na", "Lq9/a;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerListBean;", "L9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends QzoneFeedProBaseLayerControlPart {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public q9.a<QzoneFeedProLayerListBean> L9() {
        ViewModel viewModel = getViewModel(ke.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QzoneFeedPr\u2026yerViewModel::class.java)");
        return (q9.a) viewModel;
    }

    @Override // com.qzone.reborn.feedpro.layer.part.QzoneFeedProBaseLayerControlPart
    protected ge.g na() {
        String str;
        ge.g gVar = new ge.g();
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        if (x95 == null || (str = x95.getLLoc()) == null) {
            str = "";
        }
        gVar.j(str);
        gVar.k(ma().getLeftAttachInfo());
        gVar.m(ma().getRightAttachInfo());
        return gVar;
    }
}
