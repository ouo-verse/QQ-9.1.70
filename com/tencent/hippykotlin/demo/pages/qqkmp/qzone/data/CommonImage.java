package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R$\u0010$\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006,"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", "", "()V", "defaultUrl", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "getDefaultUrl", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "setDefaultUrl", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;)V", "hasRaw", "", "getHasRaw", "()Z", "setHasRaw", "(Z)V", NodeProps.CUSTOM_PROP_ISGIF, "setGif", "lloc", "", "getLloc", "()Ljava/lang/String;", "setLloc", "(Ljava/lang/String;)V", "name", "getName", "setName", "photoUrl", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicSpecUrlEntry;", "getPhotoUrl", "()Ljava/util/List;", "setPhotoUrl", "(Ljava/util/List;)V", PhotoCategorySinglePicInfo.SLOC, "getSloc", "setSloc", "type", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ImageTypeEnum;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonImage {
    public static final int $stable = 8;
    private CommonPicUrl defaultUrl;
    private boolean hasRaw;
    private boolean isGif;
    private String lloc;
    private String name;
    private List<CommonPicSpecUrlEntry> photoUrl;
    private String sloc;
    private Integer type;

    public CommonImage() {
        List<CommonPicSpecUrlEntry> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.photoUrl = emptyList;
    }

    public final CommonPicUrl getDefaultUrl() {
        return this.defaultUrl;
    }

    public final boolean getHasRaw() {
        return this.hasRaw;
    }

    public final String getLloc() {
        return this.lloc;
    }

    public final String getName() {
        return this.name;
    }

    public final List<CommonPicSpecUrlEntry> getPhotoUrl() {
        return this.photoUrl;
    }

    public final String getSloc() {
        return this.sloc;
    }

    public final Integer getType() {
        return this.type;
    }

    /* renamed from: isGif, reason: from getter */
    public final boolean getIsGif() {
        return this.isGif;
    }

    public final void setDefaultUrl(CommonPicUrl commonPicUrl) {
        this.defaultUrl = commonPicUrl;
    }

    public final void setGif(boolean z16) {
        this.isGif = z16;
    }

    public final void setHasRaw(boolean z16) {
        this.hasRaw = z16;
    }

    public final void setLloc(String str) {
        this.lloc = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPhotoUrl(List<CommonPicSpecUrlEntry> list) {
        this.photoUrl = list;
    }

    public final void setSloc(String str) {
        this.sloc = str;
    }

    public final void setType(Integer num) {
        this.type = num;
    }
}
