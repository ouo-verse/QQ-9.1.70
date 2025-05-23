package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%\u00a8\u0006("}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStImage;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "toJSONObject", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", PhotoCategorySinglePicInfo.SLOC, "getSloc", "setSloc", "lloc", "getLloc", "setLloc", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicSpecUrlEntry;", "photoUrl", "Ljava/util/List;", "getPhotoUrl", "()Ljava/util/List;", "setPhotoUrl", "(Ljava/util/List;)V", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;", "defaultUrl", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;", "getDefaultUrl", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;", "setDefaultUrl", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;)V", "", NodeProps.CUSTOM_PROP_ISGIF, "Z", "()Z", "setGif", "(Z)V", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStImage {
    public static final int $stable = 8;
    private boolean isGif;
    private String name = "";
    private String sloc = "";
    private String lloc = "";
    private List<CommonStPicSpecUrlEntry> photoUrl = new ArrayList();
    private CommonStPicUrl defaultUrl = new CommonStPicUrl();

    public final CommonStPicUrl getDefaultUrl() {
        return this.defaultUrl;
    }

    public final String getLloc() {
        return this.lloc;
    }

    public final String getName() {
        return this.name;
    }

    public final List<CommonStPicSpecUrlEntry> getPhotoUrl() {
        return this.photoUrl;
    }

    public final String getSloc() {
        return this.sloc;
    }

    /* renamed from: isGif, reason: from getter */
    public final boolean getIsGif() {
        return this.isGif;
    }

    public final void setDefaultUrl(CommonStPicUrl commonStPicUrl) {
        this.defaultUrl = commonStPicUrl;
    }

    public final void setGif(boolean z16) {
        this.isGif = z16;
    }

    public final void setLloc(String str) {
        this.lloc = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPhotoUrl(List<CommonStPicSpecUrlEntry> list) {
        this.photoUrl = list;
    }

    public final void setSloc(String str) {
        this.sloc = str;
    }

    public final e toJSONObject() {
        e eVar = new e();
        eVar.v("name", this.name);
        eVar.v(PhotoCategorySinglePicInfo.SLOC, this.sloc);
        b a16 = o.a(eVar, "lloc", this.lloc);
        Iterator<CommonStPicSpecUrlEntry> it = this.photoUrl.iterator();
        while (it.hasNext()) {
            a16.t(it.next().toJSONObject());
        }
        eVar.v("photoUrl", a16);
        eVar.v("defaultUrl", this.defaultUrl.toJSONObject());
        eVar.w(NodeProps.CUSTOM_PROP_ISGIF, this.isGif);
        return eVar;
    }
}
