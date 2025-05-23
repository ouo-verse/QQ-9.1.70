package com.qzone.reborn.layer.fragment;

import com.qzone.reborn.layer.part.QZoneAlbumLayerDescPart;
import com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart;
import com.qzone.reborn.layer.part.ab;
import com.qzone.reborn.layer.part.ac;
import com.qzone.reborn.layer.part.ag;
import com.qzone.reborn.layer.part.am;
import com.qzone.reborn.layer.part.an;
import com.qzone.reborn.layer.part.ao;
import com.qzone.reborn.layer.part.bc;
import com.qzone.reborn.layer.part.bz;
import com.qzone.reborn.layer.part.cs;
import com.qzone.reborn.layer.part.g;
import com.qzone.reborn.layer.part.u;
import com.qzone.reborn.layer.part.v;
import com.qzone.reborn.layer.part.x;
import com.qzone.reborn.layer.part.y;
import com.tencent.biz.richframework.part.Part;
import java.util.List;
import qb.a;
import ve.l;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneAlbumLayerFragment extends QZoneLayerBaseFragment {
    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(0, new y());
        assembleParts.add(new cs());
        assembleParts.add(new am(new l().b(2)));
        assembleParts.add(new bz(new l().b(2)));
        assembleParts.add(new v());
        assembleParts.add(new g());
        assembleParts.add(new bc());
        assembleParts.add(new QZoneAlbumLayerDescPart());
        if (u.Q9()) {
            assembleParts.add(new u());
        }
        assembleParts.add(new ag());
        assembleParts.add(new an());
        assembleParts.add(new QZoneFeedxLayerSharePart());
        assembleParts.add(new ao());
        assembleParts.add(new ab());
        assembleParts.add(new ac());
        assembleParts.add(new x());
        assembleParts.add(new a("qzone_album_old_album_layer"));
        return assembleParts;
    }

    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 151;
    }
}
