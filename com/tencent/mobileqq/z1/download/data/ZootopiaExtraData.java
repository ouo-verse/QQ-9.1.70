package com.tencent.mobileqq.z1.download.data;

import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0013J\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\t\u0010*\u001a\u00020\tH\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0007H\u00c6\u0003J\t\u0010.\u001a\u00020\tH\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\tH\u00c6\u0003J\t\u00101\u001a\u00020\tH\u00c6\u0003J\t\u00102\u001a\u00020\tH\u00c6\u0003J\u0085\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\tH\u00c6\u0001J\u0013\u00104\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u000106H\u00d6\u0003J\t\u00107\u001a\u00020\u0007H\u00d6\u0001J\t\u00108\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001aR\u001a\u0010\f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\r\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001a\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/z1/download/data/ZootopiaExtraData;", "Ljava/io/Serializable;", "projectName", "", "icon", "scriptType", "sceneType", "", "showGameHealthyLoading", "", "runScript", "isAutoDownload", "isSilentDownload", "needNotification", "cloudGameInfo", "Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "loadingParams", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "isPlayDownloadTogether", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;ZZZLcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;Z)V", "getCloudGameInfo", "()Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "setCloudGameInfo", "(Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;)V", "getIcon", "()Ljava/lang/String;", "()Z", "setSilentDownload", "(Z)V", "getLoadingParams", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "getNeedNotification", "setNeedNotification", "getProjectName", "getRunScript", "getSceneType", "()I", "getScriptType", "getShowGameHealthyLoading", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class ZootopiaExtraData implements Serializable {

    @Nullable
    private ZPlanCloudGameInfo cloudGameInfo;

    @NotNull
    private final String icon;
    private final boolean isAutoDownload;
    private final boolean isPlayDownloadTogether;
    private boolean isSilentDownload;

    @Nullable
    private final ZootopiaMapLoadingParams loadingParams;
    private boolean needNotification;

    @NotNull
    private final String projectName;

    @NotNull
    private final String runScript;
    private final int sceneType;

    @NotNull
    private final String scriptType;
    private final boolean showGameHealthyLoading;

    public ZootopiaExtraData(@NotNull String projectName, @NotNull String icon, @NotNull String scriptType, int i3, boolean z16, @NotNull String runScript, boolean z17, boolean z18, boolean z19, @Nullable ZPlanCloudGameInfo zPlanCloudGameInfo, @Nullable ZootopiaMapLoadingParams zootopiaMapLoadingParams, boolean z26) {
        Intrinsics.checkNotNullParameter(projectName, "projectName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(scriptType, "scriptType");
        Intrinsics.checkNotNullParameter(runScript, "runScript");
        this.projectName = projectName;
        this.icon = icon;
        this.scriptType = scriptType;
        this.sceneType = i3;
        this.showGameHealthyLoading = z16;
        this.runScript = runScript;
        this.isAutoDownload = z17;
        this.isSilentDownload = z18;
        this.needNotification = z19;
        this.cloudGameInfo = zPlanCloudGameInfo;
        this.loadingParams = zootopiaMapLoadingParams;
        this.isPlayDownloadTogether = z26;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getProjectName() {
        return this.projectName;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final ZPlanCloudGameInfo getCloudGameInfo() {
        return this.cloudGameInfo;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final ZootopiaMapLoadingParams getLoadingParams() {
        return this.loadingParams;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsPlayDownloadTogether() {
        return this.isPlayDownloadTogether;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getScriptType() {
        return this.scriptType;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSceneType() {
        return this.sceneType;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getShowGameHealthyLoading() {
        return this.showGameHealthyLoading;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getRunScript() {
        return this.runScript;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsAutoDownload() {
        return this.isAutoDownload;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsSilentDownload() {
        return this.isSilentDownload;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getNeedNotification() {
        return this.needNotification;
    }

    @NotNull
    public final ZootopiaExtraData copy(@NotNull String projectName, @NotNull String icon, @NotNull String scriptType, int sceneType, boolean showGameHealthyLoading, @NotNull String runScript, boolean isAutoDownload, boolean isSilentDownload, boolean needNotification, @Nullable ZPlanCloudGameInfo cloudGameInfo, @Nullable ZootopiaMapLoadingParams loadingParams, boolean isPlayDownloadTogether) {
        Intrinsics.checkNotNullParameter(projectName, "projectName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(scriptType, "scriptType");
        Intrinsics.checkNotNullParameter(runScript, "runScript");
        return new ZootopiaExtraData(projectName, icon, scriptType, sceneType, showGameHealthyLoading, runScript, isAutoDownload, isSilentDownload, needNotification, cloudGameInfo, loadingParams, isPlayDownloadTogether);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaExtraData)) {
            return false;
        }
        ZootopiaExtraData zootopiaExtraData = (ZootopiaExtraData) other;
        if (Intrinsics.areEqual(this.projectName, zootopiaExtraData.projectName) && Intrinsics.areEqual(this.icon, zootopiaExtraData.icon) && Intrinsics.areEqual(this.scriptType, zootopiaExtraData.scriptType) && this.sceneType == zootopiaExtraData.sceneType && this.showGameHealthyLoading == zootopiaExtraData.showGameHealthyLoading && Intrinsics.areEqual(this.runScript, zootopiaExtraData.runScript) && this.isAutoDownload == zootopiaExtraData.isAutoDownload && this.isSilentDownload == zootopiaExtraData.isSilentDownload && this.needNotification == zootopiaExtraData.needNotification && Intrinsics.areEqual(this.cloudGameInfo, zootopiaExtraData.cloudGameInfo) && Intrinsics.areEqual(this.loadingParams, zootopiaExtraData.loadingParams) && this.isPlayDownloadTogether == zootopiaExtraData.isPlayDownloadTogether) {
            return true;
        }
        return false;
    }

    @Nullable
    public final ZPlanCloudGameInfo getCloudGameInfo() {
        return this.cloudGameInfo;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final ZootopiaMapLoadingParams getLoadingParams() {
        return this.loadingParams;
    }

    public final boolean getNeedNotification() {
        return this.needNotification;
    }

    @NotNull
    public final String getProjectName() {
        return this.projectName;
    }

    @NotNull
    public final String getRunScript() {
        return this.runScript;
    }

    public final int getSceneType() {
        return this.sceneType;
    }

    @NotNull
    public final String getScriptType() {
        return this.scriptType;
    }

    public final boolean getShowGameHealthyLoading() {
        return this.showGameHealthyLoading;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((this.projectName.hashCode() * 31) + this.icon.hashCode()) * 31) + this.scriptType.hashCode()) * 31) + this.sceneType) * 31;
        boolean z16 = this.showGameHealthyLoading;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode3 = (((hashCode2 + i16) * 31) + this.runScript.hashCode()) * 31;
        boolean z17 = this.isAutoDownload;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode3 + i17) * 31;
        boolean z18 = this.isSilentDownload;
        int i19 = z18;
        if (z18 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        boolean z19 = this.needNotification;
        int i27 = z19;
        if (z19 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        ZPlanCloudGameInfo zPlanCloudGameInfo = this.cloudGameInfo;
        int i29 = 0;
        if (zPlanCloudGameInfo == null) {
            hashCode = 0;
        } else {
            hashCode = zPlanCloudGameInfo.hashCode();
        }
        int i36 = (i28 + hashCode) * 31;
        ZootopiaMapLoadingParams zootopiaMapLoadingParams = this.loadingParams;
        if (zootopiaMapLoadingParams != null) {
            i29 = zootopiaMapLoadingParams.hashCode();
        }
        int i37 = (i36 + i29) * 31;
        boolean z26 = this.isPlayDownloadTogether;
        if (!z26) {
            i3 = z26 ? 1 : 0;
        }
        return i37 + i3;
    }

    public final boolean isAutoDownload() {
        return this.isAutoDownload;
    }

    public final boolean isPlayDownloadTogether() {
        return this.isPlayDownloadTogether;
    }

    public final boolean isSilentDownload() {
        return this.isSilentDownload;
    }

    public final void setCloudGameInfo(@Nullable ZPlanCloudGameInfo zPlanCloudGameInfo) {
        this.cloudGameInfo = zPlanCloudGameInfo;
    }

    public final void setNeedNotification(boolean z16) {
        this.needNotification = z16;
    }

    public final void setSilentDownload(boolean z16) {
        this.isSilentDownload = z16;
    }

    @NotNull
    public String toString() {
        return "ZootopiaExtraData(projectName=" + this.projectName + ", icon=" + this.icon + ", scriptType=" + this.scriptType + ", sceneType=" + this.sceneType + ", showGameHealthyLoading=" + this.showGameHealthyLoading + ", runScript=" + this.runScript + ", isAutoDownload=" + this.isAutoDownload + ", isSilentDownload=" + this.isSilentDownload + ", needNotification=" + this.needNotification + ", cloudGameInfo=" + this.cloudGameInfo + ", loadingParams=" + this.loadingParams + ", isPlayDownloadTogether=" + this.isPlayDownloadTogether + ')';
    }

    public /* synthetic */ ZootopiaExtraData(String str, String str2, String str3, int i3, boolean z16, String str4, boolean z17, boolean z18, boolean z19, ZPlanCloudGameInfo zPlanCloudGameInfo, ZootopiaMapLoadingParams zootopiaMapLoadingParams, boolean z26, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i3, z16, str4, (i16 & 64) != 0 ? false : z17, (i16 & 128) != 0 ? false : z18, (i16 & 256) != 0 ? false : z19, (i16 & 512) != 0 ? null : zPlanCloudGameInfo, (i16 & 1024) != 0 ? null : zootopiaMapLoadingParams, (i16 & 2048) != 0 ? false : z26);
    }
}
