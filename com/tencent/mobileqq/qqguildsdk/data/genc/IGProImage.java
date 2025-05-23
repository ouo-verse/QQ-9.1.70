package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProImage extends Serializable {
    int getDisplayIndex();

    int getHeight();

    int getImageType();

    boolean getIsOrig();

    int getOrigSize();

    ArrayList<IGProThumbImage> getThumbImages();

    String getUrl();

    int getWidth();

    String toString();
}
