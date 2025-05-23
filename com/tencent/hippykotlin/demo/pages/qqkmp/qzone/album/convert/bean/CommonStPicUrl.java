package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "toJSONObject", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStPicUrl {
    public static final int $stable = 8;
    private int height;
    private String url = "";
    private int width;

    public final int getHeight() {
        return this.height;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    public final e toJSONObject() {
        e eVar = new e();
        eVar.v("url", this.url);
        eVar.t("width", this.width);
        eVar.t("height", this.height);
        return eVar;
    }
}
