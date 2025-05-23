package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellOperation;", "", "()V", "feedReportCookie", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonEntry;", "getFeedReportCookie", "()Ljava/util/List;", "setFeedReportCookie", "(Ljava/util/List;)V", "forwardToQzone", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonOperationForwardToQzoneInfo;", "getForwardToQzone", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonOperationForwardToQzoneInfo;", "setForwardToQzone", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonOperationForwardToQzoneInfo;)V", "shareOutside", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonOperationShareOutInfo;", "getShareOutside", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonOperationShareOutInfo;", "setShareOutside", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonOperationShareOutInfo;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellOperation {
    public static final int $stable = 8;
    private List<CommonEntry> feedReportCookie = new ArrayList();
    private CommonOperationForwardToQzoneInfo forwardToQzone;
    private CommonOperationShareOutInfo shareOutside;

    public final List<CommonEntry> getFeedReportCookie() {
        return this.feedReportCookie;
    }

    public final CommonOperationForwardToQzoneInfo getForwardToQzone() {
        return this.forwardToQzone;
    }

    public final CommonOperationShareOutInfo getShareOutside() {
        return this.shareOutside;
    }

    public final void setFeedReportCookie(List<CommonEntry> list) {
        this.feedReportCookie = list;
    }

    public final void setForwardToQzone(CommonOperationForwardToQzoneInfo commonOperationForwardToQzoneInfo) {
        this.forwardToQzone = commonOperationForwardToQzoneInfo;
    }

    public final void setShareOutside(CommonOperationShareOutInfo commonOperationShareOutInfo) {
        this.shareOutside = commonOperationShareOutInfo;
    }
}
