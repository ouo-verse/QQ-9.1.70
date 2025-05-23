package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonOperationShareOutInfo;", "", "()V", "shareAccessResource", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonShareAccessResourceInfo;", "getShareAccessResource", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonShareAccessResourceInfo;", "setShareAccessResource", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonShareAccessResourceInfo;)V", "shareOutButtonToast", "", "getShareOutButtonToast", "()Ljava/lang/String;", "setShareOutButtonToast", "(Ljava/lang/String;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonOperationShareOutInfo {
    public static final int $stable = 8;
    private CommonShareAccessResourceInfo shareAccessResource;
    private String shareOutButtonToast = "";

    public final CommonShareAccessResourceInfo getShareAccessResource() {
        return this.shareAccessResource;
    }

    public final String getShareOutButtonToast() {
        return this.shareOutButtonToast;
    }

    public final void setShareAccessResource(CommonShareAccessResourceInfo commonShareAccessResourceInfo) {
        this.shareAccessResource = commonShareAccessResourceInfo;
    }

    public final void setShareOutButtonToast(String str) {
        this.shareOutButtonToast = str;
    }
}
