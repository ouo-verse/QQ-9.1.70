package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThumbImage;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProImage implements IGProImage {
    public final GProImage mInfo;

    public GGProImage(GProImage gProImage) {
        this.mInfo = gProImage;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage
    public int getDisplayIndex() {
        return this.mInfo.getDisplayIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage
    public int getHeight() {
        return this.mInfo.getHeight();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage
    public int getImageType() {
        return this.mInfo.getImageType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage
    public boolean getIsOrig() {
        return this.mInfo.getIsOrig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage
    public int getOrigSize() {
        return this.mInfo.getOrigSize();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage
    public ArrayList<IGProThumbImage> getThumbImages() {
        ArrayList<GProThumbImage> thumbImages = this.mInfo.getThumbImages();
        ArrayList<IGProThumbImage> arrayList = new ArrayList<>();
        Iterator<GProThumbImage> it = thumbImages.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProThumbImage(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage
    public int getWidth() {
        return this.mInfo.getWidth();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage
    public String toString() {
        return this.mInfo.toString();
    }
}
