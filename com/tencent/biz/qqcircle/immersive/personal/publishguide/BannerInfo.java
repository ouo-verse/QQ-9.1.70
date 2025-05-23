package com.tencent.biz.qqcircle.immersive.personal.publishguide;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\t\u0010\n\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u000f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010\u0018\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0019\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u001b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u001a\u0010\u000eR\u0017\u0010\u001c\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/a;", "", "", "", "c", "other", "", "equals", "", "hashCode", "toString", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "id", "b", tl.h.F, "title", "d", "desc", "backgroundImg", "e", "g", WadlProxyConsts.KEY_JUMP_URL, "buttonText", "getMaterialId", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "hotIcon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.personal.publishguide.a, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class BannerInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String backgroundImg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String jumpUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String buttonText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String materialId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String hotIcon;

    public BannerInfo(@NotNull String id5, @NotNull String title, @NotNull String desc, @NotNull String backgroundImg, @NotNull String jumpUrl, @NotNull String buttonText, @NotNull String materialId, @NotNull String hotIcon) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(backgroundImg, "backgroundImg");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(hotIcon, "hotIcon");
        this.id = id5;
        this.title = title;
        this.desc = desc;
        this.backgroundImg = backgroundImg;
        this.jumpUrl = jumpUrl;
        this.buttonText = buttonText;
        this.materialId = materialId;
        this.hotIcon = hotIcon;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBackgroundImg() {
        return this.backgroundImg;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    @NotNull
    public final Map<String, Object> c() {
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        com.tencent.biz.qqcircle.wink.j jVar = com.tencent.biz.qqcircle.wink.j.f93954a;
        Pair<String, String> a16 = jVar.a(this.jumpUrl);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_material_type", a16.getFirst());
        map.put("xsj_material_id", a16.getSecond());
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_WUJI_MATERIAL_ID, this.materialId);
        map.put("xsj_operation_activity_id", jVar.c(this.jumpUrl));
        return map;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getHotIcon() {
        return this.hotIcon;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(BannerInfo.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.biz.qqcircle.immersive.personal.publishguide.BannerInfo");
        return Intrinsics.areEqual(this.id, ((BannerInfo) other).id);
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    @NotNull
    public String toString() {
        return "BannerInfo(id=" + this.id + ", title=" + this.title + ", desc=" + this.desc + ", backgroundImg=" + this.backgroundImg + ", jumpUrl=" + this.jumpUrl + ", buttonText=" + this.buttonText + ", materialId=" + this.materialId + ", hotIcon=" + this.hotIcon + ")";
    }
}
