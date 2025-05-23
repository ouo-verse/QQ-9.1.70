package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStLike;", "", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "ownerStatus", "getOwnerStatus", "setOwnerStatus", "postUser", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "getPostUser", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "setPostUser", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;)V", "status", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "setStatus", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonStLike {
    public static final int $stable = 8;
    private int count;
    private int ownerStatus;
    private int status;
    private String id = "";
    private CommonStUser postUser = new CommonStUser();

    public final int getCount() {
        return this.count;
    }

    public final String getId() {
        return this.id;
    }

    public final int getOwnerStatus() {
        return this.ownerStatus;
    }

    public final CommonStUser getPostUser() {
        return this.postUser;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setCount(int i3) {
        this.count = i3;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setOwnerStatus(int i3) {
        this.ownerStatus = i3;
    }

    public final void setPostUser(CommonStUser commonStUser) {
        this.postUser = commonStUser;
    }

    public final void setStatus(int i3) {
        this.status = i3;
    }
}
