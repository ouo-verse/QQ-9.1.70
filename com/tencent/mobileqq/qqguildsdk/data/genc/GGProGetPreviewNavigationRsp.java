package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetPreviewNavigationRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildNavIconTheme;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGetPreviewNavigationRsp implements IGProGetPreviewNavigationRsp {
    public final GProGetPreviewNavigationRsp mInfo;

    public GGProGetPreviewNavigationRsp(GProGetPreviewNavigationRsp gProGetPreviewNavigationRsp) {
        this.mInfo = gProGetPreviewNavigationRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPreviewNavigationRsp
    public IGProGuildNavigationInfo getGuildNavigation() {
        return new GGProGuildNavigationInfo(this.mInfo.getGuildNavigation());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPreviewNavigationRsp
    public ArrayList<IGProGuildNavIconTheme> getIconThemes() {
        ArrayList<GProGuildNavIconTheme> iconThemes = this.mInfo.getIconThemes();
        ArrayList<IGProGuildNavIconTheme> arrayList = new ArrayList<>();
        Iterator<GProGuildNavIconTheme> it = iconThemes.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildNavIconTheme(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPreviewNavigationRsp
    public int getTotal() {
        return this.mInfo.getTotal();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPreviewNavigationRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
