package com.tencent.biz.pubaccount.weishi.event;

import a20.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108F@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/event/WSSubTabPagerSelectedEvent;", "Lcom/tencent/biz/pubaccount/weishi/event/WSSimpleBaseEvent;", "", "position", "I", "getPosition", "()I", "setPosition", "(I)V", "La20/c;", "subTabInfo", "La20/c;", "getSubTabInfo", "()La20/c;", "setSubTabInfo", "(La20/c;)V", "", "<set-?>", "subTabId", "Ljava/lang/String;", "getSubTabId", "()Ljava/lang/String;", "<init>", "(ILa20/c;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSSubTabPagerSelectedEvent extends WSSimpleBaseEvent {
    private int position;
    private String subTabId;
    private c subTabInfo;

    public WSSubTabPagerSelectedEvent(int i3, c subTabInfo) {
        Intrinsics.checkNotNullParameter(subTabInfo, "subTabInfo");
        this.position = i3;
        this.subTabInfo = subTabInfo;
        this.subTabId = "";
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getSubTabId() {
        String b16 = this.subTabInfo.b();
        Intrinsics.checkNotNullExpressionValue(b16, "subTabInfo.id");
        return b16;
    }

    public final c getSubTabInfo() {
        return this.subTabInfo;
    }

    public final void setPosition(int i3) {
        this.position = i3;
    }

    public final void setSubTabInfo(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.subTabInfo = cVar;
    }
}
