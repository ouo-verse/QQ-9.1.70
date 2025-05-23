package com.qzone.reborn.layer.fragment;

import com.qzone.reborn.layer.part.QZoneLayerLongPicControlPart;
import com.qzone.reborn.layer.part.ag;
import com.qzone.reborn.layer.part.bd;
import com.qzone.reborn.layer.part.be;
import com.qzone.reborn.layer.part.bz;
import com.qzone.reborn.layer.part.cp;
import com.qzone.reborn.layer.part.v;
import com.qzone.reborn.layer.part.w;
import com.qzone.reborn.layer.part.x;
import com.qzone.reborn.layer.part.y;
import com.tencent.biz.richframework.part.Part;
import java.util.List;
import ve.l;

/* loaded from: classes37.dex */
public class QZoneLongPicLayerFragment extends RFWLayerLongPicFragment {
    @Override // com.qzone.reborn.layer.fragment.RFWLayerLongPicFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(0, new y());
        assembleParts.add(new QZoneLayerLongPicControlPart());
        assembleParts.add(new bz(new l().b(1)));
        assembleParts.add(new v());
        assembleParts.add(new bd());
        assembleParts.add(new ag());
        assembleParts.add(new w());
        assembleParts.add(new be());
        assembleParts.add(new cp());
        assembleParts.add(new x());
        return assembleParts;
    }
}
