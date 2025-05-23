package com.qzone.reborn.feedpro.layer.fragment;

import com.qzone.reborn.feedpro.layer.part.a;
import com.qzone.reborn.feedpro.layer.part.f;
import com.qzone.reborn.feedpro.layer.part.j;
import com.qzone.reborn.feedpro.layer.part.n;
import com.qzone.reborn.feedpro.layer.part.s;
import com.qzone.reborn.feedpro.layer.part.v;
import com.qzone.reborn.feedpro.utils.al;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.reborn.share.QzoneSharePart;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/fragment/QzoneFeedProAlbumFeedLayerFragment;", "Lcom/qzone/reborn/feedpro/layer/fragment/QzoneFeedProBaseLayerFragment;", "Lge/f;", "uh", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProAlbumFeedLayerFragment extends QzoneFeedProBaseLayerFragment {
    @Override // com.qzone.reborn.feedpro.layer.fragment.QzoneFeedProBaseLayerFragment, com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(new f());
        arrayList.add(new a());
        arrayList.add(new n());
        arrayList.add(new s());
        arrayList.add(new j());
        arrayList.add(new v());
        QQShareActionManagerV2 qQShareActionManagerV2 = new QQShareActionManagerV2();
        qQShareActionManagerV2.b(al.f54309a.b());
        arrayList.add(new QzoneSharePart(qQShareActionManagerV2, re.a.class));
        return arrayList;
    }

    @Override // com.qzone.reborn.feedpro.layer.fragment.QzoneFeedProBaseLayerFragment
    public ge.f uh() {
        ge.f fVar = new ge.f();
        fVar.e(2);
        return fVar;
    }
}
