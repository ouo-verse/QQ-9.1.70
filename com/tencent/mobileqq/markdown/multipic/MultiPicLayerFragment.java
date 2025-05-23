package com.tencent.mobileqq.markdown.multipic;

import com.tencent.biz.richframework.part.Part;
import com.tencent.richframework.gallery.QQLayerFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/markdown/multipic/MultiPicLayerFragment;", "Lcom/tencent/richframework/gallery/QQLayerFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getPlayScene", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MultiPicLayerFragment extends QQLayerFragment {
    @Override // com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(new b());
        arrayList.add(new a());
        arrayList.add(new f());
        arrayList.add(new MultiPicMorePart());
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 173;
    }
}
