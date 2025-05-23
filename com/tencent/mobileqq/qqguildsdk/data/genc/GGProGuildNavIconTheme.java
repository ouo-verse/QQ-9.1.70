package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildNavIconInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildNavIconTheme;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildNavIconTheme implements IGProGuildNavIconTheme {
    public final GProGuildNavIconTheme mInfo;

    public GGProGuildNavIconTheme(GProGuildNavIconTheme gProGuildNavIconTheme) {
        this.mInfo = gProGuildNavIconTheme;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme
    public String getIconSelectorColor() {
        return this.mInfo.getIconSelectorColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme
    public String getIconSelectorUrl() {
        return this.mInfo.getIconSelectorUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme
    public ArrayList<IGProGuildNavIconInfo> getIcons() {
        ArrayList<GProGuildNavIconInfo> icons = this.mInfo.getIcons();
        ArrayList<IGProGuildNavIconInfo> arrayList = new ArrayList<>();
        Iterator<GProGuildNavIconInfo> it = icons.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildNavIconInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme
    public String toString() {
        return this.mInfo.toString();
    }
}
