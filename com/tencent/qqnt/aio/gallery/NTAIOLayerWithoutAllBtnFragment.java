package com.tencent.qqnt.aio.gallery;

import com.tencent.biz.richframework.part.Part;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerBottomOperatePart;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerControlPart;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerExitAnimLocatePart;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerFetchPart;
import com.tencent.qqnt.aio.gallery.part.q;
import com.tencent.qqnt.aio.gallery.part.r;
import com.tencent.qqnt.aio.gallery.part.u;
import com.tencent.qqnt.aio.gallery.part.v;
import com.tencent.richframework.gallery.QQLayerFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/NTAIOLayerWithoutAllBtnFragment;", "Lcom/tencent/richframework/gallery/QQLayerFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getPlayScene", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class NTAIOLayerWithoutAllBtnFragment extends QQLayerFragment {
    @Override // com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NTAIOLayerControlPart());
        arrayList.add(new u());
        arrayList.add(new NTAIOLayerFetchPart(true));
        arrayList.add(new v());
        arrayList.add(new r());
        arrayList.addAll(super.assembleParts());
        arrayList.add(new NTAIOLayerBottomOperatePart(false, 1, null));
        arrayList.add(new q());
        arrayList.add(new com.tencent.qqnt.aio.gallery.part.b());
        arrayList.add(new NTAIOLayerExitAnimLocatePart());
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 148;
    }
}
