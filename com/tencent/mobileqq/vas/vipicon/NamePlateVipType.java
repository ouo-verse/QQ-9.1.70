package com.tencent.mobileqq.vas.vipicon;

/* loaded from: classes20.dex */
public class NamePlateVipType {
    public final int value;
    public static final NamePlateVipType NONE = new NamePlateVipType(0);
    public static final NamePlateVipType QQVIP = new NamePlateVipType(1);
    public static final NamePlateVipType QQVIP_YEAR = new NamePlateVipType(257);
    public static final NamePlateVipType SUPERVIP = new NamePlateVipType(2);
    public static final NamePlateVipType SUPERVIP_YEAR = new NamePlateVipType(258);
    public static final NamePlateVipType BIGCLUB = new NamePlateVipType(3);
    public static final NamePlateVipType BIGCLUB_YEAR = new NamePlateVipType(259);

    public NamePlateVipType(int i3) {
        this.value = i3;
    }

    public static NamePlateVipType convert(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    switch (i3) {
                        case 257:
                            return QQVIP_YEAR;
                        case 258:
                            return SUPERVIP_YEAR;
                        case 259:
                            return BIGCLUB_YEAR;
                        default:
                            return NONE;
                    }
                }
                return BIGCLUB;
            }
            return SUPERVIP;
        }
        return QQVIP;
    }

    public boolean atLeastSuperVip() {
        if ((this.value & 15) > 1) {
            return true;
        }
        return false;
    }

    public boolean isBigVip() {
        if ((this.value & 15) == 3) {
            return true;
        }
        return false;
    }

    public boolean isNormalVip() {
        if ((this.value & 15) == 1) {
            return true;
        }
        return false;
    }

    public boolean isSuperVip() {
        if ((this.value & 15) == 2) {
            return true;
        }
        return false;
    }

    public boolean isYear() {
        if (this.value > 15) {
            return true;
        }
        return false;
    }
}
