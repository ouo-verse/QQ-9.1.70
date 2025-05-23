package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicSpecUrlEntry;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "toJSONObject", "", "spec", "I", "getSpec", "()I", "setSpec", "(I)V", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;", "url", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;", "getUrl", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;", "setUrl", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;)V", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStPicSpecUrlEntry {
    public static final int $stable = 8;
    private int spec = CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal();
    private CommonStPicUrl url = new CommonStPicUrl();

    public final int getSpec() {
        return this.spec;
    }

    public final CommonStPicUrl getUrl() {
        return this.url;
    }

    public final void setSpec(int i3) {
        this.spec = i3;
    }

    public final void setUrl(CommonStPicUrl commonStPicUrl) {
        this.url = commonStPicUrl;
    }

    public final e toJSONObject() {
        e eVar = new e();
        eVar.t("spec", this.spec);
        eVar.v("url", this.url.toJSONObject());
        return eVar;
    }
}
