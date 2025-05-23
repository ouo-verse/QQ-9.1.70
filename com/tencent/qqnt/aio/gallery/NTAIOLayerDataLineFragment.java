package com.tencent.qqnt.aio.gallery;

import com.tencent.biz.richframework.part.Part;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerBottomOperatePart;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerControlPart;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerExitAnimLocatePart;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerMorePart;
import com.tencent.qqnt.aio.gallery.part.q;
import com.tencent.qqnt.aio.gallery.part.r;
import com.tencent.qqnt.aio.gallery.part.v;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.aio.gallery.share.ab;
import com.tencent.qqnt.aio.gallery.share.ac;
import com.tencent.qqnt.aio.gallery.share.o;
import com.tencent.qqnt.aio.gallery.share.t;
import com.tencent.qqnt.aio.gallery.share.x;
import com.tencent.richframework.gallery.QQLayerFragment;
import com.tencent.richframework.gallery.part.NTAIOLayerSavePart;
import com.tencent.richframework.gallery.part.RFWLayerExtraDataPart;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/NTAIOLayerDataLineFragment;", "Lcom/tencent/richframework/gallery/QQLayerFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getPlayScene", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class NTAIOLayerDataLineFragment extends QQLayerFragment {
    @Override // com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NTAIOLayerControlPart());
        arrayList.add(new v());
        arrayList.add(new r());
        arrayList.addAll(super.assembleParts());
        arrayList.add(new NTAIOLayerBottomOperatePart(false, 1, null));
        arrayList.add(new q());
        arrayList.add(new NTAIOLayerSavePart());
        arrayList.add(new com.tencent.qqnt.aio.gallery.part.b());
        arrayList.add(new NTAIOLayerExitAnimLocatePart());
        arrayList.add(new RFWLayerExtraDataPart());
        NTShareActionManager nTShareActionManager = new NTShareActionManager();
        nTShareActionManager.a(new x());
        nTShareActionManager.a(new t(false, 1, null));
        nTShareActionManager.a(new com.tencent.qqnt.aio.gallery.share.v());
        nTShareActionManager.a(new ac());
        nTShareActionManager.a(new ab());
        nTShareActionManager.a(new com.tencent.qqnt.aio.gallery.share.j());
        nTShareActionManager.a(new com.tencent.qqnt.aio.gallery.share.r(true));
        nTShareActionManager.a(new com.tencent.qqnt.aio.gallery.share.b());
        nTShareActionManager.a(new com.tencent.qqnt.aio.gallery.share.c(false));
        nTShareActionManager.a(new com.tencent.qqnt.aio.gallery.share.c(true));
        nTShareActionManager.a(new com.tencent.qqnt.aio.gallery.share.d());
        nTShareActionManager.a(new o(false, 1, null));
        nTShareActionManager.a(new com.tencent.qqnt.aio.gallery.share.i());
        arrayList.add(new NTAIOLayerMorePart(nTShareActionManager, false, 2, null));
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 166;
    }
}
