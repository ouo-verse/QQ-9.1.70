package com.tencent.mobileqq.zplan.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0002\u0006\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$a;", "info", "", "showGrayTip", "a", "GrayTipType", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanAIOGrayTipApi extends QRouteApi {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$GrayTipType;", "", "(Ljava/lang/String;I)V", "OPEN_GUIDE_DIALOG", "SWITCH_SCENE", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum GrayTipType {
        OPEN_GUIDE_DIALOG,
        SWITCH_SCENE
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\r\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "friendUin", "b", "c", "sceneName", "I", "()I", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$GrayTipType;", "d", "Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$GrayTipType;", "()Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$GrayTipType;", "e", "(Lcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$GrayTipType;)V", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/zplan/api/IZPlanAIOGrayTipApi$GrayTipType;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.api.IZPlanAIOGrayTipApi$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class GrayTipInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String friendUin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String sceneName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int sceneId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private GrayTipType type;

        public GrayTipInfo() {
            this(null, null, 0, null, 15, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getFriendUin() {
            return this.friendUin;
        }

        /* renamed from: b, reason: from getter */
        public final int getSceneId() {
            return this.sceneId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getSceneName() {
            return this.sceneName;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final GrayTipType getType() {
            return this.type;
        }

        public final void e(@NotNull GrayTipType grayTipType) {
            Intrinsics.checkNotNullParameter(grayTipType, "<set-?>");
            this.type = grayTipType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GrayTipInfo)) {
                return false;
            }
            GrayTipInfo grayTipInfo = (GrayTipInfo) other;
            if (Intrinsics.areEqual(this.friendUin, grayTipInfo.friendUin) && Intrinsics.areEqual(this.sceneName, grayTipInfo.sceneName) && this.sceneId == grayTipInfo.sceneId && this.type == grayTipInfo.type) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.friendUin.hashCode() * 31) + this.sceneName.hashCode()) * 31) + this.sceneId) * 31) + this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "GrayTipInfo(friendUin=" + this.friendUin + ", sceneName=" + this.sceneName + ", sceneId=" + this.sceneId + ", type=" + this.type + ')';
        }

        public GrayTipInfo(@NotNull String friendUin, @NotNull String sceneName, int i3, @NotNull GrayTipType type) {
            Intrinsics.checkNotNullParameter(friendUin, "friendUin");
            Intrinsics.checkNotNullParameter(sceneName, "sceneName");
            Intrinsics.checkNotNullParameter(type, "type");
            this.friendUin = friendUin;
            this.sceneName = sceneName;
            this.sceneId = i3;
            this.type = type;
        }

        public /* synthetic */ GrayTipInfo(String str, String str2, int i3, GrayTipType grayTipType, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? GrayTipType.OPEN_GUIDE_DIALOG : grayTipType);
        }
    }

    void showGrayTip(@NotNull GrayTipInfo info);
}
