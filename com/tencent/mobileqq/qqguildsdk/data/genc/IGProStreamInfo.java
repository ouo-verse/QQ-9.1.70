package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProStreamInfo extends Serializable {
    int getStreamType();

    ArrayList<IGProStreamURL> getStreamUrlList();

    String toString();
}
