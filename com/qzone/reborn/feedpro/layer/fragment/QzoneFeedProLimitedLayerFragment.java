package com.qzone.reborn.feedpro.layer.fragment;

import com.qzone.reborn.feedpro.layer.part.d;
import com.qzone.reborn.feedpro.layer.part.f;
import com.qzone.reborn.feedpro.layer.part.x;
import com.qzone.reborn.feedpro.utils.al;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.reborn.share.QzoneSharePart;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import re.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/fragment/QzoneFeedProLimitedLayerFragment;", "Lcom/qzone/reborn/feedpro/layer/fragment/QzoneFeedProBaseLayerFragment;", "Lge/f;", "uh", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lp9/a;", "vh", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProLimitedLayerFragment extends QzoneFeedProBaseLayerFragment {
    @Override // com.qzone.reborn.feedpro.layer.fragment.QzoneFeedProBaseLayerFragment, com.qzone.reborn.albumx.common.layer.fragment.CommonLayerFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(new d());
        arrayList.add(new f());
        arrayList.add(new x());
        QQShareActionManagerV2 qQShareActionManagerV2 = new QQShareActionManagerV2();
        qQShareActionManagerV2.b(al.f54309a.b());
        arrayList.add(new QzoneSharePart(qQShareActionManagerV2, a.class));
        return arrayList;
    }

    @Override // com.qzone.reborn.feedpro.layer.fragment.QzoneFeedProBaseLayerFragment
    public ge.f uh() {
        ge.f fVar = new ge.f();
        fVar.e(1);
        return fVar;
    }

    @Override // com.qzone.reborn.feedpro.layer.fragment.QzoneFeedProBaseLayerFragment
    protected p9.a vh() {
        p9.a aVar = new p9.a();
        aVar.d(false);
        aVar.c(false);
        return aVar;
    }
}
