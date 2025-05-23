package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonRecommendMedia;", "", "()V", "medias", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", "getMedias", "()Ljava/util/List;", "setMedias", "(Ljava/util/List;)V", "recommendId", "", "getRecommendId", "()Ljava/lang/String;", "setRecommendId", "(Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonRecommendMedia {
    public static final int $stable = 8;
    private List<CommonStMedia> medias = new ArrayList();
    private String recommendId = "";

    public final List<CommonStMedia> getMedias() {
        return this.medias;
    }

    public final String getRecommendId() {
        return this.recommendId;
    }

    public final void setMedias(List<CommonStMedia> list) {
        this.medias = list;
    }

    public final void setRecommendId(String str) {
        this.recommendId = str;
    }
}
