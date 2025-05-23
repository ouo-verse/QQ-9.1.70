package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMediaLike;", "", "()V", "key", "", "getKey", "()Ljava/lang/String;", VasCommonJsbProxy.JSON_KEY_SET_KEY, "(Ljava/lang/String;)V", "liked", "", "getLiked", "()Z", "setLiked", "(Z)V", WidgetCacheConstellationData.NUM, "", "getNum", "()I", "setNum", "(I)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonMediaLike {
    public static final int $stable = 8;
    private String key;
    private boolean liked;
    private int num;

    public final String getKey() {
        return this.key;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final int getNum() {
        return this.num;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setLiked(boolean z16) {
        this.liked = z16;
    }

    public final void setNum(int i3) {
        this.num = i3;
    }
}
