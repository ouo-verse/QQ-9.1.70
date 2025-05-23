package com.tencent.intervideo.nowproxy.customized_interface;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface CustomizedLog {
    public static final int D = 1;
    public static final int E = 4;
    public static final int I = 2;
    public static final int V = 0;
    public static final int W = 3;
    public static final int WTF = 5;

    void onFlushLogs();

    void onLog(int i3, String str, String str2);

    void onUploadLogs();
}
