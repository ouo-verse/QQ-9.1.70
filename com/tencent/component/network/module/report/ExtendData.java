package com.tencent.component.network.module.report;

import android.util.SparseArray;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ExtendData {
    private static final int EXTEND_COUNT = 12;
    public static final int EXTEND_POS_BUSINESS_REFER = 9;
    public static final int EXTEND_POS_DNS = 6;
    public static final int EXTEND_POS_DOWNLOAD_EXCEPTION = 11;
    public static final int EXTEND_POS_DOWNLOAD_EXTRAINFO = 10;
    public static final int EXTEND_POS_IS_SD_EXIST = 2;
    public static final int EXTEND_POS_IS_USB = 7;
    public static final int EXTEND_POS_MODEL = 0;
    public static final int EXTEND_POS_OS = 1;
    public static final int EXTEND_POS_SD_AVAIL = 4;
    public static final int EXTEND_POS_SD_TOTAL = 3;
    public static final int EXTEND_POS_TASK_STATE = 8;
    public static final int EXTEND_POS_UPLOAD_PATH = 5;
    private SparseArray<String> extendDataList = new SparseArray<>(12);

    public String getExtendString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.extendDataList.get(0, ""));
        for (int i3 = 1; i3 < 12; i3++) {
            sb5.append("|");
            sb5.append(this.extendDataList.get(i3, ""));
        }
        return sb5.toString();
    }

    public void put(int i3, String str) {
        this.extendDataList.put(i3, str);
    }
}
