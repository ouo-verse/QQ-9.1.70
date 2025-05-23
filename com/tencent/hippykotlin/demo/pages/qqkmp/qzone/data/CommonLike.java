package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b\u00a8\u0006#"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLike;", "", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "likeMans", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonLikeMan;", "getLikeMans", "()Ljava/util/List;", "setLikeMans", "(Ljava/util/List;)V", "ownerStatus", "getOwnerStatus", "setOwnerStatus", "postUser", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "getPostUser", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "setPostUser", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;)V", "status", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "setStatus", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonLike {
    public static final int LIKE_STATUS_LIKED = 1;
    public static final int LIKE_STATUS_UNLIKE = 0;
    private int count;
    private String id;
    private List<CommonLikeMan> likeMans = new ArrayList();
    private int ownerStatus;
    private CommonUser postUser;
    private int status;
    public static final int $stable = 8;

    public final int getCount() {
        return this.count;
    }

    public final String getId() {
        return this.id;
    }

    public final List<CommonLikeMan> getLikeMans() {
        return this.likeMans;
    }

    public final int getOwnerStatus() {
        return this.ownerStatus;
    }

    public final CommonUser getPostUser() {
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

    public final void setLikeMans(List<CommonLikeMan> list) {
        this.likeMans = list;
    }

    public final void setOwnerStatus(int i3) {
        this.ownerStatus = i3;
    }

    public final void setPostUser(CommonUser commonUser) {
        this.postUser = commonUser;
    }

    public final void setStatus(int i3) {
        this.status = i3;
    }
}
