package com.qzone.reborn.albumx.qzonex.part.layer;

import android.view.View;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0005\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/z;", "Lcom/qzone/reborn/albumx/common/layer/part/g;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "", "L9", "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "M9", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class z extends com.qzone.reborn.albumx.common.layer.part.g<QZAlbumxLayerExtraInfoBean> {
    @Override // com.qzone.reborn.albumx.common.layer.part.g
    protected void K9() {
        pk.b A9 = A9();
        if (A9 != null) {
            A9.E3();
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.g
    protected void L9() {
        pk.b A9 = A9();
        if (A9 != null) {
            A9.L6();
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.g
    protected void M9(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Q9(rootView.findViewById(R.id.mpq));
    }
}
