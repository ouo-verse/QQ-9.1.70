package com.tencent.ttpic.openapi.manager;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FaceOffFilterManager {
    public static final int CHANGE_SWITCH_OFF = 1;
    public static final int CHANGE_SWITCH_ON = 0;
    public static final int COSMETIC_CHANGE_MODE_RANDOM = 0;
    public static final int COSMETIC_CHANGE_MODE_SEQUENCE = 1;
    public static final int LEFTCHEEK = 1;
    public static final int LEFTSHADOW = 3;
    public static final int LIPS = 0;
    private static final int MATERIAL_COUNT = 5;
    public static final int RIGHTCHEEK = 2;
    public static final int RIGHTSHADOW = 4;
    public static final int SHELTER_SWITCH_OFF = 1;
    public static final int SHELTER_SWITCH_ON = 0;
    private int changeSwitch;
    private int cosmeticChangeMode;
    private int[] materialIndex;
    private int[] materialMaxCount;
    private boolean[] needUpdate;
    private int shelterSwitch;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class Holder {
        private static final FaceOffFilterManager instance = new FaceOffFilterManager();

        Holder() {
        }
    }

    public static FaceOffFilterManager getInstance() {
        return Holder.instance;
    }

    public int getChangeSwitch() {
        return this.changeSwitch;
    }

    public int getRandomIndex(int i3) {
        return this.materialIndex[i3];
    }

    public int getShelterSwitch() {
        return this.shelterSwitch;
    }

    public void reset() {
        Arrays.fill(this.materialIndex, 0);
        Arrays.fill(this.needUpdate, true);
        Arrays.fill(this.materialMaxCount, 0);
        this.shelterSwitch = 0;
        this.changeSwitch = 0;
        this.cosmeticChangeMode = 0;
    }

    public void setCosmeticChangeMode(int i3) {
        if (i3 == 0 || i3 == 1) {
            this.cosmeticChangeMode = i3;
        }
    }

    public void setMaterialsMaxCount(int i3, int i16) {
        int[] iArr = this.materialMaxCount;
        iArr[i3] = Math.max(i16, iArr[i3]);
    }

    public void setSwitch(int i3, int i16) {
        this.shelterSwitch = i3;
        this.changeSwitch = i16;
    }

    public void setUpdateStatus(int i3, boolean z16) {
        this.needUpdate[i3] = z16;
    }

    public void updateIndex() {
        int[] iArr;
        for (int i3 = 0; i3 < 5; i3++) {
            if (this.needUpdate[i3]) {
                int[] iArr2 = this.materialMaxCount;
                if (iArr2[i3] > 1) {
                    if (this.cosmeticChangeMode == 1) {
                        int[] iArr3 = this.materialIndex;
                        int i16 = iArr3[i3] + 1;
                        iArr3[i3] = i16;
                        iArr3[i3] = i16 % iArr2[i3];
                    } else {
                        int i17 = this.materialIndex[i3];
                        while (true) {
                            iArr = this.materialIndex;
                            if (i17 != iArr[i3]) {
                                break;
                            } else {
                                i17 = (int) (Math.random() * this.materialMaxCount[i3]);
                            }
                        }
                        iArr[i3] = i17;
                    }
                }
                this.needUpdate[i3] = false;
            }
        }
    }

    FaceOffFilterManager() {
        this.materialIndex = new int[5];
        this.needUpdate = new boolean[5];
        this.materialMaxCount = new int[5];
        this.shelterSwitch = 0;
        this.changeSwitch = 0;
        this.cosmeticChangeMode = 0;
    }
}
