package com.qzone.reborn.albumx.qzonex.part.editalbum;

import android.view.View;
import com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditDescPart;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/editalbum/o;", "Lcom/qzone/reborn/albumx/common/part/editalbum/CommonAlbumEditDescPart;", "Landroid/view/View;", "view", "", "I9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o extends CommonAlbumEditDescPart {
    private final void I9(View view) {
        fo.c.o(view, "em_qz_change_album_describe", new fo.b());
    }

    @Override // com.qzone.reborn.albumx.common.part.editalbum.CommonAlbumEditDescPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        I9(getContainer());
    }
}
