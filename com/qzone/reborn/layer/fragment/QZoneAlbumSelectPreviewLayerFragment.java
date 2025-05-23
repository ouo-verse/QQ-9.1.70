package com.qzone.reborn.layer.fragment;

import com.qzone.reborn.layer.part.cs;
import com.qzone.reborn.layer.part.j;
import com.qzone.reborn.layer.part.m;
import com.qzone.reborn.layer.part.n;
import com.qzone.reborn.layer.part.y;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/qzone/reborn/layer/fragment/QZoneAlbumSelectPreviewLayerFragment;", "Lcom/qzone/reborn/layer/fragment/QZoneLayerBaseFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneAlbumSelectPreviewLayerFragment extends QZoneLayerBaseFragment {
    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new y());
        arrayList.add(new cs());
        arrayList.addAll(super.assembleParts());
        arrayList.add(new n());
        arrayList.add(new j(true));
        arrayList.add(new m());
        return arrayList;
    }
}
