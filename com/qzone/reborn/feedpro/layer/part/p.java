package com.qzone.reborn.feedpro.layer.part;

import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0007"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/p;", "Lcom/qzone/reborn/albumx/common/layer/part/g;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "", "O9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class p extends com.qzone.reborn.albumx.common.layer.part.g<QzoneFeedProLayerExtraInfoBean> {
    @Override // com.qzone.reborn.albumx.common.layer.part.g
    protected boolean O9() {
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        boolean z16 = false;
        if (x95 != null && LoginData.getInstance().getUin() == x95.getOwnerUin()) {
            z16 = true;
        }
        return !z16;
    }
}
