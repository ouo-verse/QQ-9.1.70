package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProVideo extends Serializable {
    IGProImage getCover();

    int getDisplayIndex();

    int getDuration();

    String getFileId();

    int getFileSize();

    int getHeight();

    String getPlayUrl();

    int getPrior();

    int getRate();

    ArrayList<IGProTransVideo> getTransVideos();

    int getWidth();

    String toString();
}
