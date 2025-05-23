package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.kuikly.core.layout.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShareContentData {
    public final String arkJson;
    public final d clipArea;
    public final String desc;
    public final List<String> imageUrls;
    public final String qzoneComment;
    public final String qzoneThirdPartyAppId;
    public final float scale;
    public final int shareType;
    public String shareUrl;
    public final String title;
    public final int useQCircleWxShare;
    public final int viewTag;

    public ShareContentData(int i3, String str, String str2, String str3, List<String> list, String str4, String str5, String str6, int i16, d dVar, float f16, int i17) {
        this.shareType = i3;
        this.arkJson = str;
        this.title = str2;
        this.desc = str3;
        this.imageUrls = list;
        this.shareUrl = str4;
        this.qzoneComment = str5;
        this.qzoneThirdPartyAppId = str6;
        this.viewTag = i16;
        this.clipArea = dVar;
        this.scale = f16;
        this.useQCircleWxShare = i17;
    }

    public /* synthetic */ ShareContentData(int i3, String str, String str2, String str3, List list, String str4, String str5, int i16, int i17, int i18) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? "" : str2, (i18 & 8) != 0 ? "" : str3, (i18 & 16) != 0 ? new ArrayList() : list, (i18 & 32) != 0 ? "" : str4, (i18 & 64) != 0 ? "" : null, (i18 & 128) != 0 ? "" : str5, (i18 & 256) != 0 ? -1 : i16, null, (i18 & 1024) != 0 ? 1.0f : 0.0f, (i18 & 2048) != 0 ? com.tencent.kuikly.core.base.d.b(true) : i17);
    }
}
