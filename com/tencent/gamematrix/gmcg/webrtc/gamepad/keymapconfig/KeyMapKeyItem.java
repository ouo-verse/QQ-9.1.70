package com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig;

import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.KeyItem;

/* compiled from: P */
/* loaded from: classes6.dex */
public class KeyMapKeyItem extends KeyItem {
    private final String TAG = "KeyItem";

    public KeyMapKeyItem() {
        this.keyCodes = new int[2];
    }

    private int getIndex(int i3) {
        if (this.keyCodes != null) {
            int i16 = 0;
            while (true) {
                int[] iArr = this.keyCodes;
                if (i16 < iArr.length) {
                    if (iArr[i16] == i3) {
                        return i16;
                    }
                    i16++;
                } else {
                    return -1;
                }
            }
        } else {
            return -1;
        }
    }

    public boolean hasConbinKey(int i3) {
        int[] iArr = this.keyCodes;
        if (iArr != null && iArr.length == 2 && getIndex(i3) == 0) {
            return true;
        }
        return false;
    }

    public boolean isCombinKey(int i3, int i16) {
        int[] iArr = this.keyCodes;
        if (iArr != null && iArr.length == 2) {
            try {
                if (iArr[0] == i3) {
                    if (iArr[1] == i16) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public boolean isJoyKeyType() {
        int i3 = this.keyType;
        if (i3 != 7 && i3 != 10) {
            return false;
        }
        return true;
    }

    public boolean isOneKey(int i3) {
        int[] iArr = this.keyCodes;
        if (iArr == null || iArr.length != 1 || iArr[0] != i3) {
            return false;
        }
        return true;
    }

    public void setKeyCodes(int[] iArr) {
        this.keyCodes = iArr;
    }

    public void setKeyName(String str) {
        this.keyName = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPercentX(float f16) {
        this.percentX = f16;
    }

    public void setPercentY(float f16) {
        this.percentY = f16;
    }

    public void setRadius(int i3) {
        this.radius = i3;
    }

    public void setSensitivity(float f16) {
        CGLog.i("KeyItem sensitivity is " + f16);
        this.sensitivity = f16;
    }

    public void setType(int i3) {
        this.keyType = i3;
    }

    public void setValid(boolean z16) {
        this.isValid = z16;
    }

    public int size() {
        return this.keyCodes.length;
    }

    public void setKeyCodes(int i3, int i16) {
        int[] iArr = this.keyCodes;
        if (iArr == null || iArr.length <= i3) {
            return;
        }
        iArr[i3] = i16;
    }

    public KeyMapKeyItem(int i3) {
        this.keyCodes = new int[i3];
    }
}
