package com.tencent.mobileqq.qwallet.preload;

import com.tencent.util.Pair;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes16.dex */
public class DownloadParam implements Serializable {
    public static final int FILE_POS_INNER = 1;
    public static final int FILE_POS_SDCARD = 0;
    public String filePath;
    public List<Pair<String, String>> headers;
    public String url;
    public String md5 = "";
    public long md5Time = 0;
    public boolean useQWalletConfig = false;
    public boolean isForceUnzip = false;
    public boolean isPreDownload = false;
    public int filePos = 0;
    public String md5ForChecked = "";
    public boolean isFlowControl = false;

    public void standardlize() {
        if (a.f278999a) {
            this.filePos = 1;
        }
    }

    public String toString() {
        return "DownloadParam{url='" + this.url + "', md5='" + this.md5 + "', md5Time=" + this.md5Time + ", isForceUnzip=" + this.isForceUnzip + ", headers=" + this.headers + ", md5ForChecked=" + this.md5ForChecked + ", filePos=" + this.filePos + '}';
    }
}
