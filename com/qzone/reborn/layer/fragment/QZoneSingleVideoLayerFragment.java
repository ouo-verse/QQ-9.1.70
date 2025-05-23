package com.qzone.reborn.layer.fragment;

import com.qzone.reborn.layer.part.QZoneFeedxLayerDanmuPart;
import com.qzone.reborn.layer.part.QZoneFeedxLayerQFSPart;
import com.qzone.reborn.layer.part.QZoneFeedxSingleVideoControlPart;
import com.qzone.reborn.layer.part.aa;
import com.qzone.reborn.layer.part.ac;
import com.qzone.reborn.layer.part.ag;
import com.qzone.reborn.layer.part.bz;
import com.qzone.reborn.layer.part.ca;
import com.qzone.reborn.layer.part.cb;
import com.qzone.reborn.layer.part.cs;
import com.qzone.reborn.layer.part.u;
import com.qzone.reborn.layer.part.v;
import com.qzone.reborn.layer.part.w;
import com.qzone.reborn.layer.part.x;
import com.qzone.reborn.layer.part.y;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import java.util.List;
import ve.l;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneSingleVideoLayerFragment extends QZoneLayerBaseFragment {
    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new QZoneFeedxLayerQFSPart());
        assembleParts.add(0, new y());
        assembleParts.add(new cs());
        assembleParts.add(new QZoneFeedxSingleVideoControlPart());
        assembleParts.add(new bz(new l().b(1)));
        assembleParts.add(new v());
        if (u.Q9()) {
            assembleParts.add(new u());
        }
        assembleParts.add(new aa());
        assembleParts.add(new QZoneFeedxLayerDanmuPart());
        assembleParts.add(new ag());
        assembleParts.add(new w());
        assembleParts.add(new cb());
        assembleParts.add(new ca());
        assembleParts.add(new ac());
        assembleParts.add(new x());
        return assembleParts;
    }

    @Override // com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        return 146;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    protected boolean isSimplyNavigationBarImmersive() {
        return false;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SceneTracker.f258213d.traceEnd("QZoneSingleVideoLayerFragment");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SceneTracker.f258213d.m("QZoneSingleVideoLayerFragment");
    }
}
