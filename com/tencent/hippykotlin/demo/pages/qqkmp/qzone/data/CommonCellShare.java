package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006 "}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellShare;", "", "()V", "actionUrl", "", "getActionUrl", "()Ljava/lang/String;", "setActionUrl", "(Ljava/lang/String;)V", "additionalInfo", "getAdditionalInfo", "setAdditionalInfo", "medias", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "getMedias", "()Ljava/util/List;", "setMedias", "(Ljava/util/List;)V", "summary", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "getSummary", "setSummary", "title", "getTitle", "setTitle", "type", "", "getType", "()I", "setType", "(I)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellShare {
    public static final int $stable = 8;
    private String actionUrl;
    private String additionalInfo;
    private List<CommonMedia> medias;
    private List<CommonRichMsg> summary;
    private List<CommonRichMsg> title;
    private int type;

    public CommonCellShare() {
        List<CommonRichMsg> emptyList;
        List<CommonRichMsg> emptyList2;
        List<CommonMedia> emptyList3;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.title = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.summary = emptyList2;
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        this.medias = emptyList3;
    }

    public final String getActionUrl() {
        return this.actionUrl;
    }

    public final String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final List<CommonMedia> getMedias() {
        return this.medias;
    }

    public final List<CommonRichMsg> getSummary() {
        return this.summary;
    }

    public final List<CommonRichMsg> getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public final void setAdditionalInfo(String str) {
        this.additionalInfo = str;
    }

    public final void setMedias(List<CommonMedia> list) {
        this.medias = list;
    }

    public final void setSummary(List<CommonRichMsg> list) {
        this.summary = list;
    }

    public final void setTitle(List<CommonRichMsg> list) {
        this.title = list;
    }

    public final void setType(int i3) {
        this.type = i3;
    }
}
