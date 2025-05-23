package com.qzone.reborn.albumx.qzonex.part.layer;

import android.view.View;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/aa;", "Lcom/qzone/reborn/albumx/common/layer/part/h;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aa extends com.qzone.reborn.albumx.common.layer.part.h<QZAlbumxLayerExtraInfoBean> {
    @Override // com.qzone.reborn.albumx.common.layer.part.h
    protected void D9(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        H9(rootView.findViewById(R.id.mpr));
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.h
    protected boolean F9() {
        return false;
    }
}
