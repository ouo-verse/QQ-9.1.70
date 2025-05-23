package com.qzone.reborn.feedpro.layer.fragment;

import com.qzone.reborn.feedpro.layer.part.aa;
import com.qzone.reborn.feedpro.layer.part.ac;
import com.qzone.reborn.feedpro.layer.part.ad;
import com.qzone.reborn.feedpro.layer.part.g;
import com.qzone.reborn.feedpro.layer.part.j;
import com.qzone.reborn.feedpro.layer.part.s;
import com.qzone.reborn.feedpro.utils.al;
import com.qzone.reborn.layer.fragment.RFWLayerLongPicFragment;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.qzone.reborn.share.QzoneSharePart;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p9.a;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/fragment/QzoneFeedProLongPicLayerFragment;", "Lcom/qzone/reborn/layer/fragment/RFWLayerLongPicFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedProLongPicLayerFragment extends RFWLayerLongPicFragment {
    @Override // com.qzone.reborn.layer.fragment.RFWLayerLongPicFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        List<Part> assembleParts = super.assembleParts();
        Intrinsics.checkNotNullExpressionValue(assembleParts, "super.assembleParts()");
        arrayList.addAll(assembleParts);
        arrayList.add(new g(new a()));
        arrayList.add(new ac());
        arrayList.add(new ad());
        arrayList.add(new j());
        arrayList.add(new s());
        arrayList.add(new aa());
        QQShareActionManagerV2 qQShareActionManagerV2 = new QQShareActionManagerV2();
        qQShareActionManagerV2.b(al.f54309a.d());
        arrayList.add(new QzoneSharePart(qQShareActionManagerV2, re.a.class));
        return arrayList;
    }
}
