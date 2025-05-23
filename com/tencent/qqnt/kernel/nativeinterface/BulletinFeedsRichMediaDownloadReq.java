package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BulletinFeedsRichMediaDownloadReq {
    public String feedsId = "";
    public String fileId = "";
    public String url = "";

    public String getFeedsId() {
        return this.feedsId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "BulletinFeedsRichMediaDownloadReq{feedsId=" + this.feedsId + ",fileId=" + this.fileId + JefsClass.INDEX_URL + this.url + ",}";
    }
}
