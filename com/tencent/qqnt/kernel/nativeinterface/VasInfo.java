package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class VasInfo {
    public boolean bigClub;
    public int bigClubLevel;
    public int diyFontId;
    public ArrayList<Integer> diyNameplateIDs;
    public int extendNameplateId;
    public int faceId;
    public int fontEffect;
    public long gameCardId;
    public boolean gameIconShowFlag;
    public long gameLastLoginTime;
    public long gameNameplateId;
    public int gameRank;
    public int grayNameplateFlag;
    public int magicFont;
    public int nameplateVipType;
    public int newLoverDiamondFlag;
    public int pendantDiyId;
    public int pendantId;
    public int superVipTemplateId;
    public boolean svipFlag;
    public int vipDataFlag;
    public boolean vipFlag;
    public int vipFont;
    public int vipFontType;
    public int vipLevel;
    public int vipStartFlag;
    public boolean yearVipFlag;

    public VasInfo() {
        this.diyNameplateIDs = new ArrayList<>();
    }

    public boolean getBigClub() {
        return this.bigClub;
    }

    public int getBigClubLevel() {
        return this.bigClubLevel;
    }

    public int getDiyFontId() {
        return this.diyFontId;
    }

    public ArrayList<Integer> getDiyNameplateIDs() {
        return this.diyNameplateIDs;
    }

    public int getExtendNameplateId() {
        return this.extendNameplateId;
    }

    public int getFaceId() {
        return this.faceId;
    }

    public int getFontEffect() {
        return this.fontEffect;
    }

    public long getGameCardId() {
        return this.gameCardId;
    }

    public boolean getGameIconShowFlag() {
        return this.gameIconShowFlag;
    }

    public long getGameLastLoginTime() {
        return this.gameLastLoginTime;
    }

    public long getGameNameplateId() {
        return this.gameNameplateId;
    }

    public int getGameRank() {
        return this.gameRank;
    }

    public int getGrayNameplateFlag() {
        return this.grayNameplateFlag;
    }

    public int getMagicFont() {
        return this.magicFont;
    }

    public int getNameplateVipType() {
        return this.nameplateVipType;
    }

    public int getNewLoverDiamondFlag() {
        return this.newLoverDiamondFlag;
    }

    public int getPendantDiyId() {
        return this.pendantDiyId;
    }

    public int getPendantId() {
        return this.pendantId;
    }

    public int getSuperVipTemplateId() {
        return this.superVipTemplateId;
    }

    public boolean getSvipFlag() {
        return this.svipFlag;
    }

    public int getVipDataFlag() {
        return this.vipDataFlag;
    }

    public boolean getVipFlag() {
        return this.vipFlag;
    }

    public int getVipFont() {
        return this.vipFont;
    }

    public int getVipFontType() {
        return this.vipFontType;
    }

    public int getVipLevel() {
        return this.vipLevel;
    }

    public int getVipStartFlag() {
        return this.vipStartFlag;
    }

    public boolean getYearVipFlag() {
        return this.yearVipFlag;
    }

    public VasInfo(boolean z16, boolean z17, boolean z18, int i3, boolean z19, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, ArrayList<Integer> arrayList, int i48, int i49, long j3, long j16, int i56, boolean z26, long j17) {
        new ArrayList();
        this.vipFlag = z16;
        this.yearVipFlag = z17;
        this.svipFlag = z18;
        this.vipLevel = i3;
        this.bigClub = z19;
        this.bigClubLevel = i16;
        this.nameplateVipType = i17;
        this.grayNameplateFlag = i18;
        this.superVipTemplateId = i19;
        this.diyFontId = i26;
        this.pendantId = i27;
        this.pendantDiyId = i28;
        this.faceId = i29;
        this.vipFont = i36;
        this.vipFontType = i37;
        this.magicFont = i38;
        this.fontEffect = i39;
        this.newLoverDiamondFlag = i46;
        this.extendNameplateId = i47;
        this.diyNameplateIDs = arrayList;
        this.vipStartFlag = i48;
        this.vipDataFlag = i49;
        this.gameNameplateId = j3;
        this.gameLastLoginTime = j16;
        this.gameRank = i56;
        this.gameIconShowFlag = z26;
        this.gameCardId = j17;
    }
}
