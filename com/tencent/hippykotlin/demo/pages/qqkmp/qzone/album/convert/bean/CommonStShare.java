package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.mobileqq.vas.webview.VasWebConstants;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStShare;", "", "()V", "ark", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareToArk;", "getArk", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareToArk;", "setArk", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareToArk;)V", VasWebConstants.REPORT_ORIGIN, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareOutside;", "getOutside", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareOutside;", "setOutside", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareOutside;)V", "qzone", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareToQzone;", "getQzone", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareToQzone;", "setQzone", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareToQzone;)V", "shareKey", "", "getShareKey", "()Ljava/lang/String;", "setShareKey", "(Ljava/lang/String;)V", "summary", "getSummary", "setSummary", "title", "getTitle", "setTitle", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonStShare {
    public static final int $stable = 8;
    private CommonShareToQzone qzone = new CommonShareToQzone();
    private CommonShareToArk ark = new CommonShareToArk();
    private CommonShareOutside outside = new CommonShareOutside();
    private String title = "";
    private String summary = "";
    private String shareKey = "";

    public final CommonShareToArk getArk() {
        return this.ark;
    }

    public final CommonShareOutside getOutside() {
        return this.outside;
    }

    public final CommonShareToQzone getQzone() {
        return this.qzone;
    }

    public final String getShareKey() {
        return this.shareKey;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setArk(CommonShareToArk commonShareToArk) {
        this.ark = commonShareToArk;
    }

    public final void setOutside(CommonShareOutside commonShareOutside) {
        this.outside = commonShareOutside;
    }

    public final void setQzone(CommonShareToQzone commonShareToQzone) {
        this.qzone = commonShareToQzone;
    }

    public final void setShareKey(String str) {
        this.shareKey = str;
    }

    public final void setSummary(String str) {
        this.summary = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}
