package com.qzone.reborn.layer.fragment;

import com.qzone.reborn.layer.part.bg;
import com.qzone.reborn.layer.part.ck;
import com.tencent.biz.richframework.part.Part;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneExpireLayerFragment extends QZoneSimpleLayerFragment {
    @Override // com.qzone.reborn.layer.fragment.QZoneSimpleLayerFragment, com.qzone.reborn.layer.fragment.QZoneLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new bg());
        assembleParts.add(new ck());
        return assembleParts;
    }
}
