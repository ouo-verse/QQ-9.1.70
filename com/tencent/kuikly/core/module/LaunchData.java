package com.tencent.kuikly.core.module;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b-\b\u0086\b\u0018\u0000 32\u00020\u0001:\u0001\tBw\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\u0006\u0010+\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020\u0004\u0012\u0006\u00100\u001a\u00020\u0004\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\fR\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\fR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b$\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010(\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b'\u0010\fR\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b)\u0010\n\u001a\u0004\b*\u0010\fR\u0017\u0010.\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b-\u0010\fR\u0017\u00100\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u00064"}, d2 = {"Lcom/tencent/kuikly/core/module/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getInitViewCost", "()I", "initViewCost", "b", "getPreloadDexClassCost", "preloadDexClassCost", "c", "getFetchContextCodeCost", "fetchContextCodeCost", "d", "initRenderContextCost", "e", "getInitRenderCoreCost", "initRenderCoreCost", "f", "getInitRenderLayerReadCacheCost", "initRenderLayerReadCacheCost", "g", "getInitRenderLayerRenderCacheCost", "initRenderLayerRenderCacheCost", tl.h.F, "getNewPageCost", "newPageCost", "i", "pageBuildCost", "j", "pageLayoutCost", "k", "getCreatePageCost", "createPageCost", "l", "getCreateInstanceCost", "createInstanceCost", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getRenderCost", "renderCost", DomainData.DOMAIN_NAME, "firstPaintCost", "<init>", "(IIIIIIIIIIIIII)V", "o", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.module.g, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class LaunchData {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int initViewCost;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int preloadDexClassCost;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int fetchContextCodeCost;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int initRenderContextCost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int initRenderCoreCost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int initRenderLayerReadCacheCost;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int initRenderLayerRenderCacheCost;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int newPageCost;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int pageBuildCost;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final int pageLayoutCost;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final int createPageCost;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int createInstanceCost;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int renderCost;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int firstPaintCost;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/kuikly/core/module/g$a;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "jsonObject", "Lcom/tencent/kuikly/core/module/g;", "a", "", "KEY_FETCH_CONTEXT_CODE_COST", "Ljava/lang/String;", "KEY_FIRST_PAINT_COST", "KEY_INIT_RENDER_CONTEXT_COST", "KEY_INIT_RENDER_CORE_COST", "KEY_INIT_RENDER_LAYER_READ_CACHE_COST", "KEY_INIT_RENDER_LAYER_RENDER_CACHE_COST", "KEY_INIT_VIEW_COST", "KEY_NEW_PAGE_COST", "KEY_ON_CREATE_INSTANCE_COST", "KEY_ON_CREATE_PAGE_COST", "KEY_ON_RENDER_COST", "KEY_PAGE_BUILD_COST", "KEY_PAGE_LAYOUT_COST", "KEY_PRELOAD_DEX_CLASS_COST", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.module.g$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final LaunchData a(com.tencent.kuikly.core.nvi.serialization.json.e jsonObject) {
            if (jsonObject != null) {
                return new LaunchData(jsonObject.j("initViewCost"), jsonObject.j("preloadDexClassCost"), jsonObject.j("fetchContextCodeCost"), jsonObject.j("initRenderContextCost"), jsonObject.j("initRenderCoreCost"), jsonObject.j("initRenderLayerReadCacheCost"), jsonObject.j("initRenderLayerRenderCacheCost"), jsonObject.j("newPageCost"), jsonObject.j("pageBuildCost"), jsonObject.j("pageLayoutCost"), jsonObject.j("createPageCost"), jsonObject.j("createInstanceCost"), jsonObject.j("renderCost"), jsonObject.j("firstPaintCost"));
            }
            return null;
        }
    }

    public LaunchData(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46) {
        this.initViewCost = i3;
        this.preloadDexClassCost = i16;
        this.fetchContextCodeCost = i17;
        this.initRenderContextCost = i18;
        this.initRenderCoreCost = i19;
        this.initRenderLayerReadCacheCost = i26;
        this.initRenderLayerRenderCacheCost = i27;
        this.newPageCost = i28;
        this.pageBuildCost = i29;
        this.pageLayoutCost = i36;
        this.createPageCost = i37;
        this.createInstanceCost = i38;
        this.renderCost = i39;
        this.firstPaintCost = i46;
    }

    /* renamed from: a, reason: from getter */
    public final int getFirstPaintCost() {
        return this.firstPaintCost;
    }

    /* renamed from: b, reason: from getter */
    public final int getInitRenderContextCost() {
        return this.initRenderContextCost;
    }

    /* renamed from: c, reason: from getter */
    public final int getPageBuildCost() {
        return this.pageBuildCost;
    }

    /* renamed from: d, reason: from getter */
    public final int getPageLayoutCost() {
        return this.pageLayoutCost;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.initViewCost * 31) + this.preloadDexClassCost) * 31) + this.fetchContextCodeCost) * 31) + this.initRenderContextCost) * 31) + this.initRenderCoreCost) * 31) + this.initRenderLayerReadCacheCost) * 31) + this.initRenderLayerRenderCacheCost) * 31) + this.newPageCost) * 31) + this.pageBuildCost) * 31) + this.pageLayoutCost) * 31) + this.createPageCost) * 31) + this.createInstanceCost) * 31) + this.renderCost) * 31) + this.firstPaintCost;
    }

    public String toString() {
        return "LaunchData(\n   firstPaintCost=" + this.firstPaintCost + " \n   initViewCost=" + this.initViewCost + ", \n   preloadDexClassCost=" + this.preloadDexClassCost + ", \n   fetchContextCodeCost=" + this.fetchContextCodeCost + ", \n   initRenderCoreCost=" + this.initRenderCoreCost + ", \n   initRenderContextCost=" + this.initRenderContextCost + ", \n   initRenderLayerReadCacheCost=" + this.initRenderLayerReadCacheCost + ", \n   initRenderLayerRenderCacheCost=" + this.initRenderLayerRenderCacheCost + ", \n   createInstanceCost=" + this.createInstanceCost + ", \n   newPageCost=" + this.newPageCost + ", \n   onCreatePageCost=" + this.createPageCost + ", \n   pageBuildCost=" + this.pageBuildCost + ", \n   pageLayoutCost=" + this.pageLayoutCost + ", \n   renderCost=" + this.renderCost + ", \n)";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LaunchData)) {
            return false;
        }
        LaunchData launchData = (LaunchData) other;
        return this.initViewCost == launchData.initViewCost && this.preloadDexClassCost == launchData.preloadDexClassCost && this.fetchContextCodeCost == launchData.fetchContextCodeCost && this.initRenderContextCost == launchData.initRenderContextCost && this.initRenderCoreCost == launchData.initRenderCoreCost && this.initRenderLayerReadCacheCost == launchData.initRenderLayerReadCacheCost && this.initRenderLayerRenderCacheCost == launchData.initRenderLayerRenderCacheCost && this.newPageCost == launchData.newPageCost && this.pageBuildCost == launchData.pageBuildCost && this.pageLayoutCost == launchData.pageLayoutCost && this.createPageCost == launchData.createPageCost && this.createInstanceCost == launchData.createInstanceCost && this.renderCost == launchData.renderCost && this.firstPaintCost == launchData.firstPaintCost;
    }
}
