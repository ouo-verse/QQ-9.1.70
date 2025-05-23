package com.tencent.mobileqq.vas.adv.common.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.aditem.GdtAd;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0002\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\bH\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\t\u0010&\u001a\u00020\bH\u00c6\u0003JG\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u00c6\u0001J\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020\u0005H\u00d6\u0001J\t\u0010+\u001a\u00020\nH\u00d6\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "", "gdtAd", "Lcom/tencent/gdtad/aditem/GdtAd;", WadlProxyConsts.SCENE_ID, "", "componentId", "autoDownloadApp", "", "srcId", "", "shouldShowVideoCeiling", "(Lcom/tencent/gdtad/aditem/GdtAd;IIZLjava/lang/String;Z)V", "getAutoDownloadApp", "()Z", "setAutoDownloadApp", "(Z)V", "getComponentId", "()I", "setComponentId", "(I)V", "getGdtAd", "()Lcom/tencent/gdtad/aditem/GdtAd;", "setGdtAd", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "getSceneId", "setSceneId", "getShouldShowVideoCeiling", "setShouldShowVideoCeiling", "getSrcId", "()Ljava/lang/String;", "setSrcId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class LandingPageParams {
    private boolean autoDownloadApp;
    private int componentId;

    @Nullable
    private GdtAd gdtAd;
    private int sceneId;
    private boolean shouldShowVideoCeiling;

    @NotNull
    private String srcId;

    public LandingPageParams() {
        this(null, 0, 0, false, null, false, 63, null);
    }

    public static /* synthetic */ LandingPageParams copy$default(LandingPageParams landingPageParams, GdtAd gdtAd, int i3, int i16, boolean z16, String str, boolean z17, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            gdtAd = landingPageParams.gdtAd;
        }
        if ((i17 & 2) != 0) {
            i3 = landingPageParams.sceneId;
        }
        int i18 = i3;
        if ((i17 & 4) != 0) {
            i16 = landingPageParams.componentId;
        }
        int i19 = i16;
        if ((i17 & 8) != 0) {
            z16 = landingPageParams.autoDownloadApp;
        }
        boolean z18 = z16;
        if ((i17 & 16) != 0) {
            str = landingPageParams.srcId;
        }
        String str2 = str;
        if ((i17 & 32) != 0) {
            z17 = landingPageParams.shouldShowVideoCeiling;
        }
        return landingPageParams.copy(gdtAd, i18, i19, z18, str2, z17);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final GdtAd getGdtAd() {
        return this.gdtAd;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSceneId() {
        return this.sceneId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getComponentId() {
        return this.componentId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getAutoDownloadApp() {
        return this.autoDownloadApp;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getSrcId() {
        return this.srcId;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getShouldShowVideoCeiling() {
        return this.shouldShowVideoCeiling;
    }

    @NotNull
    public final LandingPageParams copy(@Nullable GdtAd gdtAd, int sceneId, int componentId, boolean autoDownloadApp, @NotNull String srcId, boolean shouldShowVideoCeiling) {
        Intrinsics.checkNotNullParameter(srcId, "srcId");
        return new LandingPageParams(gdtAd, sceneId, componentId, autoDownloadApp, srcId, shouldShowVideoCeiling);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LandingPageParams)) {
            return false;
        }
        LandingPageParams landingPageParams = (LandingPageParams) other;
        if (Intrinsics.areEqual(this.gdtAd, landingPageParams.gdtAd) && this.sceneId == landingPageParams.sceneId && this.componentId == landingPageParams.componentId && this.autoDownloadApp == landingPageParams.autoDownloadApp && Intrinsics.areEqual(this.srcId, landingPageParams.srcId) && this.shouldShowVideoCeiling == landingPageParams.shouldShowVideoCeiling) {
            return true;
        }
        return false;
    }

    public final boolean getAutoDownloadApp() {
        return this.autoDownloadApp;
    }

    public final int getComponentId() {
        return this.componentId;
    }

    @Nullable
    public final GdtAd getGdtAd() {
        return this.gdtAd;
    }

    public final int getSceneId() {
        return this.sceneId;
    }

    public final boolean getShouldShowVideoCeiling() {
        return this.shouldShowVideoCeiling;
    }

    @NotNull
    public final String getSrcId() {
        return this.srcId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd == null) {
            hashCode = 0;
        } else {
            hashCode = gdtAd.hashCode();
        }
        int i3 = ((((hashCode * 31) + this.sceneId) * 31) + this.componentId) * 31;
        boolean z16 = this.autoDownloadApp;
        int i16 = 1;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int hashCode2 = (((i3 + i17) * 31) + this.srcId.hashCode()) * 31;
        boolean z17 = this.shouldShowVideoCeiling;
        if (!z17) {
            i16 = z17 ? 1 : 0;
        }
        return hashCode2 + i16;
    }

    public final void setAutoDownloadApp(boolean z16) {
        this.autoDownloadApp = z16;
    }

    public final void setComponentId(int i3) {
        this.componentId = i3;
    }

    public final void setGdtAd(@Nullable GdtAd gdtAd) {
        this.gdtAd = gdtAd;
    }

    public final void setSceneId(int i3) {
        this.sceneId = i3;
    }

    public final void setShouldShowVideoCeiling(boolean z16) {
        this.shouldShowVideoCeiling = z16;
    }

    public final void setSrcId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.srcId = str;
    }

    @NotNull
    public String toString() {
        return "LandingPageParams(gdtAd=" + this.gdtAd + ", sceneId=" + this.sceneId + ", componentId=" + this.componentId + ", autoDownloadApp=" + this.autoDownloadApp + ", srcId=" + this.srcId + ", shouldShowVideoCeiling=" + this.shouldShowVideoCeiling + ')';
    }

    public LandingPageParams(@Nullable GdtAd gdtAd, int i3, int i16, boolean z16, @NotNull String srcId, boolean z17) {
        Intrinsics.checkNotNullParameter(srcId, "srcId");
        this.gdtAd = gdtAd;
        this.sceneId = i3;
        this.componentId = i16;
        this.autoDownloadApp = z16;
        this.srcId = srcId;
        this.shouldShowVideoCeiling = z17;
    }

    public /* synthetic */ LandingPageParams(GdtAd gdtAd, int i3, int i16, boolean z16, String str, boolean z17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? null : gdtAd, (i17 & 2) != 0 ? Integer.MIN_VALUE : i3, (i17 & 4) == 0 ? i16 : Integer.MIN_VALUE, (i17 & 8) != 0 ? false : z16, (i17 & 16) != 0 ? "" : str, (i17 & 32) != 0 ? false : z17);
    }
}
