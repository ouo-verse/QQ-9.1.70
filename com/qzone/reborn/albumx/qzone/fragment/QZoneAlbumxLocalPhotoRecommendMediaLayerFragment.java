package com.qzone.reborn.albumx.qzone.fragment;

import com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment;
import com.qzone.reborn.albumx.qzone.part.f;
import com.tencent.biz.richframework.part.Part;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/fragment/QZoneAlbumxLocalPhotoRecommendMediaLayerFragment;", "Lcom/qzone/reborn/albumx/common/layer/fragment/CommonLayerFragment;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "sh", "", "th", "getPlayScene", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxLocalPhotoRecommendMediaLayerFragment extends CommonLayerFragment {
    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new f());
        return assembleParts;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 146;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected Part sh() {
        return null;
    }

    @Override // com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment
    protected int th() {
        return -1;
    }
}
