package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OtherFlag {
    public int colorRindId;
    public boolean isAioShortcutBarOpen;
    public boolean isSharingLocation;
    public boolean isZPlanCoupleOpen;
    public boolean onlyChat;
    public boolean qzoneNotWatch;
    public boolean qzoneNotWatched;
    public int studyFlag;
    public int teenagerFlag;
    public int zplanCoupleSceneId;

    public OtherFlag() {
    }

    public int getColorRindId() {
        return this.colorRindId;
    }

    public boolean getIsAioShortcutBarOpen() {
        return this.isAioShortcutBarOpen;
    }

    public boolean getIsSharingLocation() {
        return this.isSharingLocation;
    }

    public boolean getIsZPlanCoupleOpen() {
        return this.isZPlanCoupleOpen;
    }

    public boolean getOnlyChat() {
        return this.onlyChat;
    }

    public boolean getQzoneNotWatch() {
        return this.qzoneNotWatch;
    }

    public boolean getQzoneNotWatched() {
        return this.qzoneNotWatched;
    }

    public int getStudyFlag() {
        return this.studyFlag;
    }

    public int getTeenagerFlag() {
        return this.teenagerFlag;
    }

    public int getZplanCoupleSceneId() {
        return this.zplanCoupleSceneId;
    }

    public OtherFlag(boolean z16, boolean z17, boolean z18, boolean z19, int i3, int i16, int i17, boolean z26, int i18, boolean z27) {
        this.onlyChat = z16;
        this.qzoneNotWatch = z17;
        this.qzoneNotWatched = z18;
        this.isZPlanCoupleOpen = z19;
        this.zplanCoupleSceneId = i3;
        this.teenagerFlag = i16;
        this.studyFlag = i17;
        this.isAioShortcutBarOpen = z26;
        this.colorRindId = i18;
        this.isSharingLocation = z27;
    }
}
