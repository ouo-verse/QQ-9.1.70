package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DesktopAppInfo extends DesktopItemInfo {
    public MiniAppInfo mMiniAppInfo;
    public int fromBackup = 0;
    private boolean fromCache = false;
    private boolean isDrag = false;
    private boolean isBubbleShown = false;
    private boolean isRecommendBadgeShow = false;

    public DesktopAppInfo(int i3, MiniAppInfo miniAppInfo) {
        this.mModuleType = i3;
        this.mMiniAppInfo = miniAppInfo;
        if (i3 == 1) {
            this.dragEnable = true;
            this.dropEnable = false;
            this.deleteEnable = true;
        } else if (i3 == 2) {
            this.dragEnable = false;
            this.dropEnable = false;
            this.deleteEnable = false;
        } else if (i3 == 3) {
            this.dragEnable = true;
            this.dropEnable = true;
            this.deleteEnable = true;
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
    public Boolean areContentsTheSame(DesktopItemInfo desktopItemInfo) {
        return Boolean.valueOf(this.mMiniAppInfo.equals(((DesktopAppInfo) desktopItemInfo).mMiniAppInfo) && this.isTemp == desktopItemInfo.isTemp && this.mMiniAppInfo.isGdtMiniAppAd == ((DesktopAppInfo) desktopItemInfo).mMiniAppInfo.isGdtMiniAppAd);
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
    public Boolean areItemsTheSame(DesktopItemInfo desktopItemInfo) {
        if (!(desktopItemInfo instanceof DesktopAppInfo)) {
            QLog.e("DesktopAppInfo", 1, "areItemsTheSame newItem is:" + desktopItemInfo);
            return Boolean.FALSE;
        }
        return Boolean.valueOf(this.mMiniAppInfo.equals(((DesktopAppInfo) desktopItemInfo).mMiniAppInfo));
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
    public Object getChangePayload(DesktopItemInfo desktopItemInfo) {
        return new Object();
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
    public int getViewType() {
        return 2;
    }

    public boolean isBubbleShown() {
        return this.isBubbleShown;
    }

    public boolean isDrag() {
        return this.isDrag;
    }

    public boolean isRecommendBadgeShow() {
        return this.isRecommendBadgeShow;
    }

    public void setBubbleShown(boolean z16) {
        this.isBubbleShown = z16;
    }

    public void setDrag(boolean z16) {
        this.isDrag = z16;
    }

    public void setRecommendBadgeShow(boolean z16) {
        this.isRecommendBadgeShow = z16;
    }

    public String toString() {
        if (this.mMiniAppInfo != null) {
            return this.mMiniAppInfo.name + "_" + this.mModuleType;
        }
        return " ";
    }
}
