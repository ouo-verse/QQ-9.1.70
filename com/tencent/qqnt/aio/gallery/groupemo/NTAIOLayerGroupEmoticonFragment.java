package com.tencent.qqnt.aio.gallery.groupemo;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.emotionintegrate.t;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerBottomOperatePart;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerControlPart;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerExitAnimLocatePart;
import com.tencent.qqnt.aio.gallery.part.NTAIOLayerMorePart;
import com.tencent.qqnt.aio.gallery.part.b;
import com.tencent.qqnt.aio.gallery.part.q;
import com.tencent.qqnt.aio.gallery.part.u;
import com.tencent.qqnt.aio.gallery.part.v;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.aio.gallery.share.w;
import com.tencent.qqnt.aio.gallery.share.y;
import com.tencent.richframework.gallery.QQLayerFragment;
import com.tencent.richframework.gallery.part.NTAIOLayerSavePart;
import dv3.c;
import dv3.d;
import dv3.e;
import dv3.f;
import dv3.g;
import dv3.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/groupemo/NTAIOLayerGroupEmoticonFragment;", "Lcom/tencent/richframework/gallery/QQLayerFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getPlayScene", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class NTAIOLayerGroupEmoticonFragment extends QQLayerFragment {
    @Override // com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NTAIOLayerControlPart());
        arrayList.add(new u());
        arrayList.add(new v());
        arrayList.add(new c());
        arrayList.addAll(super.assembleParts());
        boolean z16 = false;
        DefaultConstructorMarker defaultConstructorMarker = null;
        arrayList.add(new NTAIOLayerBottomOperatePart(z16, 1, defaultConstructorMarker));
        arrayList.add(new q());
        t tVar = t.f205295a;
        if (!tVar.c()) {
            arrayList.add(new NTAIOLayerSavePart());
        }
        arrayList.add(new b());
        arrayList.add(new NTAIOLayerExitAnimLocatePart());
        NTShareActionManager nTShareActionManager = new NTShareActionManager();
        nTShareActionManager.a(new f());
        nTShareActionManager.a(new e());
        nTShareActionManager.a(new com.tencent.qqnt.aio.gallery.share.v());
        nTShareActionManager.a(new g());
        nTShareActionManager.a(new h());
        nTShareActionManager.a(new y());
        nTShareActionManager.a(new w());
        nTShareActionManager.a(new dv3.b());
        if (!tVar.c()) {
            nTShareActionManager.a(new d());
        }
        arrayList.add(new NTAIOLayerMorePart(nTShareActionManager, z16, 2, defaultConstructorMarker));
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 148;
    }
}
