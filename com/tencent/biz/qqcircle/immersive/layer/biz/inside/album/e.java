package com.tencent.biz.qqcircle.immersive.layer.biz.inside.album;

import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.immersive.part.ac;
import com.tencent.biz.qqcircle.immersive.part.ai;
import com.tencent.biz.qqcircle.immersive.part.fg;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends com.tencent.biz.qqcircle.immersive.layer.base.b {
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> g(com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        if (!(aVar.b() instanceof QCircleAlbumBean)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d((QCircleAlbumBean) aVar.b()));
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_album_use_common_bottom_sheet_view", true)) {
            arrayList.add(new ai((QCircleAlbumBean) aVar.b()));
        } else {
            arrayList.add(new ac((QCircleAlbumBean) aVar.b()));
        }
        arrayList.add(new fg());
        return arrayList;
    }
}
