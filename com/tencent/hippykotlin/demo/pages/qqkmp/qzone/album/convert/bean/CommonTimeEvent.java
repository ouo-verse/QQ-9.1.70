package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonTimeEvent;", "", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "copywriter", "getCopywriter", "setCopywriter", "time", "", "getTime", "()J", "setTime", "(J)V", "type", "", "getType", "()I", "setType", "(I)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonTimeEvent {
    public static final int $stable = 8;
    private String content = "";
    private String copywriter = "";
    private long time;
    private int type;

    public final String getContent() {
        return this.content;
    }

    public final String getCopywriter() {
        return this.copywriter;
    }

    public final long getTime() {
        return this.time;
    }

    public final int getType() {
        return this.type;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setCopywriter(String str) {
        this.copywriter = str;
    }

    public final void setTime(long j3) {
        this.time = j3;
    }

    public final void setType(int i3) {
        this.type = i3;
    }
}
