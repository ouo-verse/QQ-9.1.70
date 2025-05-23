package com.qq.e.tg.nativ;

import android.view.View;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface NativeADDataRef {
    boolean equalsAdData(NativeADDataRef nativeADDataRef);

    double getAPPPrice();

    int getAPPScore();

    int getAPPStatus();

    int getAdPatternType();

    String getDesc();

    long getDownloadCount();

    int getECPM();

    String getECPMLevel();

    String getIconUrl();

    List<String> getImgList();

    String getImgUrl();

    int getPictureHeight();

    int getPictureWidth();

    int getProgress();

    String getTitle();

    boolean isAPP();

    void negativeFeedback();

    void onClicked(View view);

    void onExposured(View view);
}
