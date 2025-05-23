package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006)"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRichMsg;", "", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "mediaItems", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "getMediaItems", "()Ljava/util/List;", "setMediaItems", "(Ljava/util/List;)V", "name", "getName", "setName", "type", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/RichMsgType;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "uid", "getUid", "setUid", "uin", "getUin", "setUin", "url", "getUrl", "setUrl", "who", "getWho", "()I", "setWho", "(I)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonRichMsg {
    public static final int $stable = 8;
    private String content;
    private List<CommonMedia> mediaItems;
    private String name;
    private Integer type;
    private String uid;
    private String uin;
    private String url;
    private int who;

    public CommonRichMsg() {
        List<CommonMedia> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mediaItems = emptyList;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<CommonMedia> getMediaItems() {
        return this.mediaItems;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUin() {
        return this.uin;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWho() {
        return this.who;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setMediaItems(List<CommonMedia> list) {
        this.mediaItems = list;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public final void setUin(String str) {
        this.uin = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setWho(int i3) {
        this.who = i3;
    }
}
