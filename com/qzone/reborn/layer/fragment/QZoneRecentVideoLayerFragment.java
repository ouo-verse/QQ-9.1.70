package com.qzone.reborn.layer.fragment;

import com.qzone.reborn.layer.part.QZoneFeedxLayerDanmuPart;
import com.qzone.reborn.layer.part.ab;
import com.qzone.reborn.layer.part.ac;
import com.qzone.reborn.layer.part.ag;
import com.qzone.reborn.layer.part.ak;
import com.qzone.reborn.layer.part.bl;
import com.qzone.reborn.layer.part.bm;
import com.qzone.reborn.layer.part.bn;
import com.qzone.reborn.layer.part.bo;
import com.qzone.reborn.layer.part.bp;
import com.qzone.reborn.layer.part.bq;
import com.qzone.reborn.layer.part.bz;
import com.qzone.reborn.layer.part.cs;
import com.qzone.reborn.layer.part.y;
import com.tencent.biz.richframework.part.Part;
import java.util.List;
import ve.l;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneRecentVideoLayerFragment extends QZoneLayerBaseFragment {
    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(0, new y());
        assembleParts.add(new cs());
        assembleParts.add(new bo());
        assembleParts.add(new bz(new l().b(2)));
        assembleParts.add(new bl());
        assembleParts.add(new ak());
        assembleParts.add(new QZoneFeedxLayerDanmuPart());
        assembleParts.add(new ag());
        assembleParts.add(new bm());
        assembleParts.add(new bq());
        assembleParts.add(new bp());
        assembleParts.add(new ab());
        assembleParts.add(new ac());
        assembleParts.add(new bn());
        return assembleParts;
    }
}
