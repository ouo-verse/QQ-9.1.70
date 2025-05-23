package com.tencent.biz.richframework.util.bean;

import com.tencent.biz.richframework.media.MediaType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWSaveMediaResultBean {
    public final boolean isSuccess;
    public MediaType mediaType = MediaType.UNKNOWN;
    public final String savePath;

    public RFWSaveMediaResultBean(boolean z16, String str) {
        this.isSuccess = z16;
        this.savePath = str;
    }
}
