package com.tencent.hippykotlin.demo.pages.qqfile.model;

import com.tencent.mobileqq.highway.transaction.Tracker;

/* compiled from: P */
/* loaded from: classes37.dex */
public final /* synthetic */ class DownloadStatus$EnumUnboxingLocalUtility {
    public static /* synthetic */ String stringValueOf(int i3) {
        if (i3 == 1) {
            return "UNDOWNLOAD";
        }
        if (i3 == 2) {
            return "DOWNLOADING";
        }
        if (i3 == 3) {
            return "CANCEL";
        }
        if (i3 == 4) {
            return "DOWNDONE";
        }
        if (i3 == 5) {
            return Tracker.FAIL;
        }
        return "null";
    }
}
