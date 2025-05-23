package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class GProStClientImageContent {
    public boolean isGif;
    public boolean isOrig;
    public int origSize;
    public String taskId = "";
    public String picId = "";
    public String url = "";
    public String md5 = "";

    public boolean getIsGif() {
        return this.isGif;
    }

    public boolean getIsOrig() {
        return this.isOrig;
    }

    public String getMd5() {
        return this.md5;
    }

    public int getOrigSize() {
        return this.origSize;
    }

    public String getPicId() {
        return this.picId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProStClientImageContent{taskId=" + this.taskId + ",picId=" + this.picId + JefsClass.INDEX_URL + this.url + ",isOrig=" + this.isOrig + ",origSize=" + this.origSize + ",isGif=" + this.isGif + ",md5=" + this.md5 + ",}";
    }
}
