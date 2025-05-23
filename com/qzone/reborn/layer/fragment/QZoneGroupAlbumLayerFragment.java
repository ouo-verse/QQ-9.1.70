package com.qzone.reborn.layer.fragment;

import com.qzone.reborn.layer.part.QZoneAlbumLayerDescPart;
import com.qzone.reborn.layer.part.aq;
import com.qzone.reborn.layer.part.ar;
import com.qzone.reborn.layer.part.as;
import com.qzone.reborn.layer.part.at;
import com.qzone.reborn.layer.part.au;
import com.qzone.reborn.layer.part.av;
import com.qzone.reborn.layer.part.aw;
import com.qzone.reborn.layer.part.ax;
import com.qzone.reborn.layer.part.bz;
import com.qzone.reborn.layer.part.cs;
import com.qzone.reborn.layer.part.v;
import com.qzone.reborn.layer.part.y;
import com.tencent.biz.richframework.part.Part;
import java.util.List;
import ve.l;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneGroupAlbumLayerFragment extends QZoneLayerBaseFragment {
    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(0, new y());
        assembleParts.add(new cs());
        assembleParts.add(new as());
        assembleParts.add(new bz(new l().b(2)));
        assembleParts.add(new v());
        assembleParts.add(new at());
        assembleParts.add(new QZoneAlbumLayerDescPart());
        assembleParts.add(new aq());
        assembleParts.add(new ax());
        assembleParts.add(new aw());
        assembleParts.add(new au());
        assembleParts.add(new av());
        assembleParts.add(new ar());
        return assembleParts;
    }
}
