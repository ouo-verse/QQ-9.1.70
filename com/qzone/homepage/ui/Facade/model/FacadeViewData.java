package com.qzone.homepage.ui.Facade.model;

import NS_MOBILE_CUSTOM.FacadeView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FacadeViewData extends _FacadeViewData {
    @Override // com.qzone.homepage.ui.Facade.model._FacadeViewData
    public /* bridge */ /* synthetic */ ArrayList getConfigRect() {
        return super.getConfigRect();
    }

    @Override // com.qzone.homepage.ui.Facade.model._FacadeViewData
    public /* bridge */ /* synthetic */ DownloadableInfo getCustomFileInfo() {
        return super.getCustomFileInfo();
    }

    @Override // com.qzone.homepage.ui.Facade.model._FacadeViewData
    public /* bridge */ /* synthetic */ ProfileRectArea getProfileRect() {
        return super.getProfileRect();
    }

    public static ArrayList<FacadeViewData> createFromJce(ArrayList<FacadeView> arrayList, long j3) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<FacadeViewData> arrayList2 = new ArrayList<>();
        Iterator<FacadeView> it = arrayList.iterator();
        while (it.hasNext()) {
            FacadeView next = it.next();
            FacadeViewData facadeViewData = new FacadeViewData();
            facadeViewData.mCustomFileInfo = DownloadableInfo.createDownloadableInfo(next.stFileInfo);
            facadeViewData.mConfigRect = ConfigArea.createConfigAreas(next.vecConfRect, j3);
            ProfileRectArea createFromJce = ProfileRectArea.createFromJce(next.stProfileRect);
            facadeViewData.mProfileRect = createFromJce;
            if (next.iNeedProfileAdjust == 1) {
                ProfileRectArea.AdjustProfileConfiArea(createFromJce, facadeViewData.mConfigRect);
            }
            arrayList2.add(facadeViewData);
        }
        return arrayList2;
    }
}
