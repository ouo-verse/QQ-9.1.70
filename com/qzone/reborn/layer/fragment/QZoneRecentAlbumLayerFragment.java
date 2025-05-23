package com.qzone.reborn.layer.fragment;

import com.qzone.reborn.layer.part.QZoneAlbumLayerDescPart;
import com.qzone.reborn.layer.part.ab;
import com.qzone.reborn.layer.part.ac;
import com.qzone.reborn.layer.part.ag;
import com.qzone.reborn.layer.part.ak;
import com.qzone.reborn.layer.part.al;
import com.qzone.reborn.layer.part.bc;
import com.qzone.reborn.layer.part.bh;
import com.qzone.reborn.layer.part.bi;
import com.qzone.reborn.layer.part.bj;
import com.qzone.reborn.layer.part.bz;
import com.qzone.reborn.layer.part.cs;
import com.qzone.reborn.layer.part.v;
import com.qzone.reborn.layer.part.w;
import com.qzone.reborn.layer.part.y;
import com.tencent.biz.richframework.part.Part;
import java.util.List;
import ve.l;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneRecentAlbumLayerFragment extends QZoneLayerBaseFragment {
    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(0, new y());
        assembleParts.add(new cs());
        assembleParts.add(new bi());
        assembleParts.add(new bz(new l().b(2)));
        assembleParts.add(new v());
        assembleParts.add(new ak());
        assembleParts.add(new bc(10));
        assembleParts.add(new QZoneAlbumLayerDescPart());
        assembleParts.add(new ag());
        assembleParts.add(new w());
        assembleParts.add(new bj());
        assembleParts.add(new al());
        assembleParts.add(new ab());
        assembleParts.add(new ac());
        assembleParts.add(new bh());
        return assembleParts;
    }
}
