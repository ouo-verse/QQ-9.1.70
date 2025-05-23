package com.tencent.biz.qqcircle.immersive.viewmodel.activity;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import feedcloud.FeedCloudMeta$StShare;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSpringPrizePopup$SpringMaterial;
import qqcircle.QQCircleSpringPrizePopup$StPrizeInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\n\u0010\u0018R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010 \u001a\u0004\b\u0016\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/PopupType;", "a", "Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/PopupType;", "c", "()Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/PopupType;", "popupType", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "popupId", "e", "reason", "Lqqcircle/QQCircleSpringPrizePopup$SpringMaterial;", "d", "Lqqcircle/QQCircleSpringPrizePopup$SpringMaterial;", "()Lqqcircle/QQCircleSpringPrizePopup$SpringMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lfeedcloud/FeedCloudMeta$StShare;", "Lfeedcloud/FeedCloudMeta$StShare;", "f", "()Lfeedcloud/FeedCloudMeta$StShare;", "shareInfo", "Lqqcircle/QQCircleSpringPrizePopup$StPrizeInfo;", "Lqqcircle/QQCircleSpringPrizePopup$StPrizeInfo;", "()Lqqcircle/QQCircleSpringPrizePopup$StPrizeInfo;", "prizeInfo", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/viewmodel/activity/PopupType;Ljava/lang/String;Ljava/lang/String;Lqqcircle/QQCircleSpringPrizePopup$SpringMaterial;Lfeedcloud/FeedCloudMeta$StShare;Lqqcircle/QQCircleSpringPrizePopup$StPrizeInfo;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PopupType popupType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String popupId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String reason;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QQCircleSpringPrizePopup$SpringMaterial material;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final FeedCloudMeta$StShare shareInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQCircleSpringPrizePopup$StPrizeInfo prizeInfo;

    public a(@NotNull PopupType popupType, @NotNull String popupId, @NotNull String reason, @Nullable QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial, @Nullable FeedCloudMeta$StShare feedCloudMeta$StShare, @NotNull QQCircleSpringPrizePopup$StPrizeInfo prizeInfo) {
        Intrinsics.checkNotNullParameter(popupType, "popupType");
        Intrinsics.checkNotNullParameter(popupId, "popupId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(prizeInfo, "prizeInfo");
        this.popupType = popupType;
        this.popupId = popupId;
        this.reason = reason;
        this.material = qQCircleSpringPrizePopup$SpringMaterial;
        this.shareInfo = feedCloudMeta$StShare;
        this.prizeInfo = prizeInfo;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final QQCircleSpringPrizePopup$SpringMaterial getMaterial() {
        return this.material;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPopupId() {
        return this.popupId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final PopupType getPopupType() {
        return this.popupType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final QQCircleSpringPrizePopup$StPrizeInfo getPrizeInfo() {
        return this.prizeInfo;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.popupType == aVar.popupType && Intrinsics.areEqual(this.popupId, aVar.popupId) && Intrinsics.areEqual(this.reason, aVar.reason) && Intrinsics.areEqual(this.material, aVar.material) && Intrinsics.areEqual(this.shareInfo, aVar.shareInfo) && Intrinsics.areEqual(this.prizeInfo, aVar.prizeInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final FeedCloudMeta$StShare getShareInfo() {
        return this.shareInfo;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.popupType.hashCode() * 31) + this.popupId.hashCode()) * 31) + this.reason.hashCode()) * 31;
        QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial = this.material;
        int i3 = 0;
        if (qQCircleSpringPrizePopup$SpringMaterial == null) {
            hashCode = 0;
        } else {
            hashCode = qQCircleSpringPrizePopup$SpringMaterial.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        FeedCloudMeta$StShare feedCloudMeta$StShare = this.shareInfo;
        if (feedCloudMeta$StShare != null) {
            i3 = feedCloudMeta$StShare.hashCode();
        }
        return ((i16 + i3) * 31) + this.prizeInfo.hashCode();
    }

    @NotNull
    public String toString() {
        String str;
        QQCircleSpringPrizePopup$SpringMaterial qQCircleSpringPrizePopup$SpringMaterial = this.material;
        if (qQCircleSpringPrizePopup$SpringMaterial != null) {
            str = "SpringMaterial('bgDialog=" + qQCircleSpringPrizePopup$SpringMaterial.bg_dialog.get() + "' backJumpUrl='" + qQCircleSpringPrizePopup$SpringMaterial.small_btn_back_jump_url.get() + "', leftJumpUrl='" + qQCircleSpringPrizePopup$SpringMaterial.btn_left_jump_url.get() + "', rightJumpUrl='" + qQCircleSpringPrizePopup$SpringMaterial.btn_right_jump_url.get() + "')";
        } else {
            str = null;
        }
        QQCircleSpringPrizePopup$StPrizeInfo qQCircleSpringPrizePopup$StPrizeInfo = this.prizeInfo;
        String str2 = "PrizeInfo(prizeId=" + qQCircleSpringPrizePopup$StPrizeInfo.prize_id.get() + ", prizeText='" + qQCircleSpringPrizePopup$StPrizeInfo.prize_text.get() + "', prizeIcon='" + qQCircleSpringPrizePopup$StPrizeInfo.prize_icon.get() + "')";
        return "QFSSpringFestivalActivityInfo(popupType=" + this.popupType + ", popupId=" + this.popupId + ", reason='" + this.reason + "', " + str + ", " + str2 + ")";
    }
}
