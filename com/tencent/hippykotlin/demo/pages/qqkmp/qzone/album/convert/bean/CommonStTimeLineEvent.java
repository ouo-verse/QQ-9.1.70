package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014\u00a8\u0006+"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStTimeLineEvent;", "", "()V", "attachInfo", "", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "beginTime", "", "getBeginTime", "()J", "setBeginTime", "(J)V", "bindingType", "", "getBindingType", "()I", "setBindingType", "(I)V", "content", "getContent", "setContent", "disable", "", "getDisable", "()Z", "setDisable", "(Z)V", "endTime", "getEndTime", "setEndTime", "itemCount", "getItemCount", "setItemCount", "title", "getTitle", "setTitle", "type", "getType", "setType", "toString", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonStTimeLineEvent {
    public static final int $stable = 8;
    private long beginTime;
    private int bindingType;
    private boolean disable;
    private long endTime;
    private int itemCount;
    private int type;
    private String title = "";
    private String content = "";
    private String attachInfo = "";

    public final String getAttachInfo() {
        return this.attachInfo;
    }

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final int getBindingType() {
        return this.bindingType;
    }

    public final String getContent() {
        return this.content;
    }

    public final boolean getDisable() {
        return this.disable;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final int getItemCount() {
        return this.itemCount;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final void setAttachInfo(String str) {
        this.attachInfo = str;
    }

    public final void setBeginTime(long j3) {
        this.beginTime = j3;
    }

    public final void setBindingType(int i3) {
        this.bindingType = i3;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setDisable(boolean z16) {
        this.disable = z16;
    }

    public final void setEndTime(long j3) {
        this.endTime = j3;
    }

    public final void setItemCount(int i3) {
        this.itemCount = i3;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    public String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CommonStTimeLineEvent(type:");
        m3.append(this.type);
        m3.append("| title:");
        m3.append(this.title);
        m3.append("| content:");
        m3.append(this.content);
        m3.append("| attachInfo:");
        m3.append(this.attachInfo);
        m3.append("| beginTime:");
        m3.append(this.beginTime);
        m3.append("| endTime:");
        m3.append(this.endTime);
        m3.append(" )");
        return m3.toString();
    }
}
