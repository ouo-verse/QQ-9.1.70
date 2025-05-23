package com.qzone.reborn.feedx.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 22\u00020\u0001:\u000234B\u0007\u00a2\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R$\u0010'\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\"\u0010*\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\n\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\"\u0010-\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\n\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000e\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/feedx/bean/QZoneDragonUserInfo;", "Ljava/io/Serializable;", "", "isValidDragonResInfo", "isValidGrowthResInfo", "isValidListTypeResInfo", "isValidThreeLayerResInfo", "isValidDynamicResInfo", "", "activityState", "I", "getActivityState", "()I", "setActivityState", "(I)V", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "dragonResInfo", "Lcom/qzone/feed/business/model/FeedResourceInfo;", "getDragonResInfo", "()Lcom/qzone/feed/business/model/FeedResourceInfo;", "setDragonResInfo", "(Lcom/qzone/feed/business/model/FeedResourceInfo;)V", "Lcom/qzone/reborn/feedx/bean/QZoneDragonListBadgeInfo;", "listBadge", "Lcom/qzone/reborn/feedx/bean/QZoneDragonListBadgeInfo;", "getListBadge", "()Lcom/qzone/reborn/feedx/bean/QZoneDragonListBadgeInfo;", "setListBadge", "(Lcom/qzone/reborn/feedx/bean/QZoneDragonListBadgeInfo;)V", "Lcom/qzone/reborn/feedx/bean/QZoneDragonThreeLayerBadgeInfo;", "threeLayerBadge", "Lcom/qzone/reborn/feedx/bean/QZoneDragonThreeLayerBadgeInfo;", "getThreeLayerBadge", "()Lcom/qzone/reborn/feedx/bean/QZoneDragonThreeLayerBadgeInfo;", "setThreeLayerBadge", "(Lcom/qzone/reborn/feedx/bean/QZoneDragonThreeLayerBadgeInfo;)V", "fusionBadge", "getFusionBadge", "setFusionBadge", "fireResInfo", "getFireResInfo", "setFireResInfo", "grade", "getGrade", "setGrade", "badgeType", "getBadgeType", "setBadgeType", "<init>", "()V", "Companion", "BadgeType", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneDragonUserInfo implements Serializable {

    @SerializedName("activity_state")
    private int activityState;

    @SerializedName("badge_type")
    private int badgeType = BadgeType.BADGE_TYPE_GROWTH.getType();

    @SerializedName("dragon_res_info")
    private FeedResourceInfo dragonResInfo;

    @SerializedName("fire_res_info")
    private FeedResourceInfo fireResInfo;

    @SerializedName("fusion_badge")
    private FeedResourceInfo fusionBadge;

    @SerializedName("grade")
    private int grade;

    @SerializedName("list_badge")
    private QZoneDragonListBadgeInfo listBadge;

    @SerializedName("three_layer_badge")
    private QZoneDragonThreeLayerBadgeInfo threeLayerBadge;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedx/bean/QZoneDragonUserInfo$BadgeType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "BADGE_TYPE_GROWTH", "BADGE_TYPE_LIST", "BADGE_TYPE_THREE_LAYER", "BADGE_TYPE_FUSION", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public enum BadgeType {
        BADGE_TYPE_GROWTH(0),
        BADGE_TYPE_LIST(1),
        BADGE_TYPE_THREE_LAYER(2),
        BADGE_TYPE_FUSION(3);

        private final int type;

        BadgeType(int i3) {
            this.type = i3;
        }

        public final int getType() {
            return this.type;
        }
    }

    public final int getActivityState() {
        return this.activityState;
    }

    public final int getBadgeType() {
        return this.badgeType;
    }

    public final FeedResourceInfo getDragonResInfo() {
        return this.dragonResInfo;
    }

    public final FeedResourceInfo getFireResInfo() {
        return this.fireResInfo;
    }

    public final FeedResourceInfo getFusionBadge() {
        return this.fusionBadge;
    }

    public final int getGrade() {
        return this.grade;
    }

    public final QZoneDragonListBadgeInfo getListBadge() {
        return this.listBadge;
    }

    public final QZoneDragonThreeLayerBadgeInfo getThreeLayerBadge() {
        return this.threeLayerBadge;
    }

    public final boolean isValidDragonResInfo() {
        int i3 = this.badgeType;
        if (i3 == BadgeType.BADGE_TYPE_GROWTH.getType()) {
            return isValidGrowthResInfo();
        }
        if (i3 == BadgeType.BADGE_TYPE_LIST.getType()) {
            return isValidListTypeResInfo();
        }
        if (i3 == BadgeType.BADGE_TYPE_THREE_LAYER.getType()) {
            return isValidThreeLayerResInfo();
        }
        if (i3 == BadgeType.BADGE_TYPE_FUSION.getType()) {
            return isValidDynamicResInfo();
        }
        return false;
    }

    public final boolean isValidDynamicResInfo() {
        FeedResourceInfo feedResourceInfo = this.fusionBadge;
        if (!TextUtils.isEmpty(feedResourceInfo != null ? feedResourceInfo.getSourceMaterialUrl() : null)) {
            return true;
        }
        QLog.e("QZoneDragonUserInfo", 1, "[isValidDynamicResInfo] is not valid");
        return false;
    }

    public final boolean isValidGrowthResInfo() {
        FeedResourceInfo feedResourceInfo = this.dragonResInfo;
        if (!TextUtils.isEmpty(feedResourceInfo != null ? feedResourceInfo.getSourceMaterialUrl() : null)) {
            return true;
        }
        QLog.e("QZoneDragonUserInfo", 1, "[isValidGrowthResInfo] is not valid");
        return false;
    }

    public final boolean isValidListTypeResInfo() {
        List<FeedResourceInfo> list;
        QZoneDragonListBadgeInfo qZoneDragonListBadgeInfo = this.listBadge;
        if (qZoneDragonListBadgeInfo != null && (list = qZoneDragonListBadgeInfo.getList()) != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String sourceMaterialUrl = ((FeedResourceInfo) it.next()).getSourceMaterialUrl();
                if (sourceMaterialUrl == null || sourceMaterialUrl.length() == 0) {
                    QLog.e("QZoneDragonUserInfo", 1, "[isValidListTypeResInfo] is not valid");
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean isValidThreeLayerResInfo() {
        FeedResourceInfo bottom;
        QZoneDragonThreeLayerBadgeInfo qZoneDragonThreeLayerBadgeInfo = this.threeLayerBadge;
        String sourceMaterialUrl = (qZoneDragonThreeLayerBadgeInfo == null || (bottom = qZoneDragonThreeLayerBadgeInfo.getBottom()) == null) ? null : bottom.getSourceMaterialUrl();
        if (!(sourceMaterialUrl == null || sourceMaterialUrl.length() == 0)) {
            return true;
        }
        QLog.e("QZoneDragonUserInfo", 1, "[isValidThreeLayerResInfo] no bottom dragon");
        return false;
    }

    public final void setActivityState(int i3) {
        this.activityState = i3;
    }

    public final void setBadgeType(int i3) {
        this.badgeType = i3;
    }

    public final void setDragonResInfo(FeedResourceInfo feedResourceInfo) {
        this.dragonResInfo = feedResourceInfo;
    }

    public final void setFireResInfo(FeedResourceInfo feedResourceInfo) {
        this.fireResInfo = feedResourceInfo;
    }

    public final void setFusionBadge(FeedResourceInfo feedResourceInfo) {
        this.fusionBadge = feedResourceInfo;
    }

    public final void setGrade(int i3) {
        this.grade = i3;
    }

    public final void setListBadge(QZoneDragonListBadgeInfo qZoneDragonListBadgeInfo) {
        this.listBadge = qZoneDragonListBadgeInfo;
    }

    public final void setThreeLayerBadge(QZoneDragonThreeLayerBadgeInfo qZoneDragonThreeLayerBadgeInfo) {
        this.threeLayerBadge = qZoneDragonThreeLayerBadgeInfo;
    }
}
