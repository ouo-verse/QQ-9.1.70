package com.qzone.reborn.layer.fragment;

import com.qzone.reborn.layer.part.aa;
import com.qzone.reborn.layer.part.am;
import com.qzone.reborn.layer.part.bz;
import com.qzone.reborn.layer.part.cs;
import com.qzone.reborn.layer.part.y;
import com.tencent.biz.richframework.part.Part;
import java.util.List;
import ve.l;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneSimpleLayerFragment extends QZoneLayerBaseFragment {
    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(0, new y());
        assembleParts.add(new cs());
        assembleParts.add(new am());
        assembleParts.add(new bz(new l().b(1)));
        assembleParts.add(new aa());
        return assembleParts;
    }

    @Override // com.tencent.richframework.gallery.RFWLayerFragment
    public boolean isOpenNavigationBarImmersive() {
        return true;
    }
}
