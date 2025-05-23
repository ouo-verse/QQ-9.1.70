package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;

/* compiled from: P */
/* loaded from: classes18.dex */
public interface QQDanceEventHandler {
    boolean changeDanceStatus(boolean z16, String str);

    void closeEvent(boolean z16);

    void enterSilhouette();

    void playSceneEndEvent(BoyDataReport boyDataReport);

    void readySceneBegin(long j3);

    void scoreSceneEnd(int i3, String str, String str2);
}
