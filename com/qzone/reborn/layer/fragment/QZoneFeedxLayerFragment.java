package com.qzone.reborn.layer.fragment;

import com.qzone.reborn.layer.part.QZoneAlbumLayerDescPart;
import com.qzone.reborn.layer.part.QZoneFeedxLayerDanmuPart;
import com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart;
import com.qzone.reborn.layer.part.aa;
import com.qzone.reborn.layer.part.ab;
import com.qzone.reborn.layer.part.ac;
import com.qzone.reborn.layer.part.ad;
import com.qzone.reborn.layer.part.ag;
import com.qzone.reborn.layer.part.am;
import com.qzone.reborn.layer.part.bc;
import com.qzone.reborn.layer.part.bz;
import com.qzone.reborn.layer.part.cs;
import com.qzone.reborn.layer.part.u;
import com.qzone.reborn.layer.part.v;
import com.qzone.reborn.layer.part.w;
import com.qzone.reborn.layer.part.x;
import com.qzone.reborn.layer.part.y;
import com.qzone.reborn.repair.part.layer.p;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import java.util.List;
import ve.l;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxLayerFragment extends QZoneLayerBaseFragment {
    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(0, new y());
        assembleParts.add(new cs());
        assembleParts.add(new am(new l().b(1)));
        assembleParts.add(new bz(new l().b(1)));
        assembleParts.add(new v());
        assembleParts.add(new aa());
        assembleParts.add(new bc());
        if (ph()) {
            assembleParts.add(new QZoneFeedxLayerDanmuPart());
        }
        assembleParts.add(new ag());
        assembleParts.add(new w());
        assembleParts.add(new QZoneFeedxLayerSharePart());
        assembleParts.add(new QZoneAlbumLayerDescPart());
        if (u.Q9()) {
            assembleParts.add(new u());
        }
        assembleParts.add(new ad());
        assembleParts.add(new ab());
        assembleParts.add(new ac());
        assembleParts.add(new x());
        assembleParts.add(new p());
        return assembleParts;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SceneTracker.f258213d.traceEnd("QZoneFeedxLayerFragment");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SceneTracker.f258213d.m("QZoneFeedxLayerFragment");
    }

    protected boolean ph() {
        if (getActivity() == null || getActivity().getIntent() == null) {
            return true;
        }
        return !getActivity().getIntent().getBooleanExtra("is_forward_album_feed", false);
    }
}
