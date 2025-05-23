package com.qq.e.comm.pi;

/* loaded from: classes3.dex */
public interface SrcDownloadPermissionListener {
    public static final int ALLOW_DOWNLOAD = 0;
    public static final int IMG = 1;
    public static final int VIDEO = 2;
    public static final int ZIP = 3;

    int canDownload(String str, String str2, int i3);
}
