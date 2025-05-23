package com.qzone.reborn.feedpro.layer.part;

import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedpro.layer.router.QzoneFeedProLayerExtraInfoBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/c;", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Lcom/qzone/reborn/feedpro/layer/router/QzoneFeedProLayerExtraInfoBean;", "", "E9", "", "F9", "D9", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class c extends com.qzone.reborn.albumx.common.layer.part.i<QzoneFeedProLayerExtraInfoBean> {
    public final int D9() {
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        return (x95 == null || !x95.getIsVideo()) ? 0 : 1;
    }

    public final boolean E9() {
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        boolean z16 = false;
        if (x95 != null && x95.getOwnerUin() == LoginData.getInstance().getUin()) {
            z16 = true;
        }
        return !z16;
    }

    public final int F9() {
        QzoneFeedProLayerExtraInfoBean x95 = x9();
        return !Intrinsics.areEqual(String.valueOf(x95 != null ? Long.valueOf(x95.getOwnerUin()) : null), LoginData.getInstance().getUinString()) ? 1 : 0;
    }
}
