package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006 "}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumCommData;", "", "()V", "emptyMessage", "", "getEmptyMessage", "()Ljava/lang/String;", "setEmptyMessage", "(Ljava/lang/String;)V", "isMember", "", "()Z", "setMember", "(Z)V", "normalUpLoad", "getNormalUpLoad", "setNormalUpLoad", "rightList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getRightList", "()Ljava/util/ArrayList;", "setRightList", "(Ljava/util/ArrayList;)V", "timeLineEvents", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStTimeLineEvent;", "getTimeLineEvents", "()Ljava/util/List;", "setTimeLineEvents", "(Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonAlbumCommData {
    public static final int $stable = 8;
    private boolean isMember;
    private boolean normalUpLoad;
    private String emptyMessage = "";
    private ArrayList<Integer> rightList = new ArrayList<>();
    private List<CommonStTimeLineEvent> timeLineEvents = new ArrayList();

    public final String getEmptyMessage() {
        return this.emptyMessage;
    }

    public final boolean getNormalUpLoad() {
        return this.normalUpLoad;
    }

    public final ArrayList<Integer> getRightList() {
        return this.rightList;
    }

    public final List<CommonStTimeLineEvent> getTimeLineEvents() {
        return this.timeLineEvents;
    }

    /* renamed from: isMember, reason: from getter */
    public final boolean getIsMember() {
        return this.isMember;
    }

    public final void setEmptyMessage(String str) {
        this.emptyMessage = str;
    }

    public final void setMember(boolean z16) {
        this.isMember = z16;
    }

    public final void setNormalUpLoad(boolean z16) {
        this.normalUpLoad = z16;
    }

    public final void setRightList(ArrayList<Integer> arrayList) {
        this.rightList = arrayList;
    }

    public final void setTimeLineEvents(List<CommonStTimeLineEvent> list) {
        this.timeLineEvents = list;
    }
}
