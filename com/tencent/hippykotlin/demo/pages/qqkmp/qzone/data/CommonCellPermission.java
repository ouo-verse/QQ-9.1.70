package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;", "", "()V", "actionUrl", "", "getActionUrl", "()Ljava/lang/String;", "setActionUrl", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "icon", "getIcon", "setIcon", "right", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRight;", "getRight", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRight;", "setRight", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRight;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellPermission {
    public static final int $stable = 8;
    private String actionUrl;
    private String desc;
    private String icon;
    private CommonRight right;

    public final String getActionUrl() {
        return this.actionUrl;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final CommonRight getRight() {
        return this.right;
    }

    public final void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setRight(CommonRight commonRight) {
        this.right = commonRight;
    }
}
