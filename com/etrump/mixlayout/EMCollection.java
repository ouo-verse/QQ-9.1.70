package com.etrump.mixlayout;

import com.etrump.mixlayout.api.IEMCollection;
import com.etrump.mixlayout.api.IETFont;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EMCollection implements IEMCollection {
    private int[] mEmoticonIndexArray = null;
    private ETEngine mEngine;

    public EMCollection(ETEngine eTEngine) {
        this.mEngine = eTEngine;
    }

    private int getStringCount(String str) {
        int i3;
        int length = str.length();
        int i16 = 0;
        int i17 = 0;
        while (i16 < length) {
            if (Character.isHighSurrogate(str.charAt(i16)) && (i3 = i16 + 1) < length && Character.isLowSurrogate(str.charAt(i3))) {
                i17++;
                i16 = i3;
            } else {
                i17++;
            }
            i16++;
        }
        return i17;
    }

    @Override // com.etrump.mixlayout.api.IEMCollection
    public int getEmoticonCount() {
        int[] iArr = this.mEmoticonIndexArray;
        if (iArr != null) {
            return iArr.length;
        }
        return 0;
    }

    public EMImage getEmoticonImage(String str, int i3, ETFont eTFont) {
        int[] iArr;
        ETEngine eTEngine = this.mEngine;
        if (eTEngine != null && (iArr = this.mEmoticonIndexArray) != null) {
            return eTEngine.native_emoticonCreateImage(str, iArr[i3], eTFont);
        }
        return null;
    }

    @Override // com.etrump.mixlayout.api.IEMCollection
    public int getEmoticonIndex(int i3) {
        int[] iArr = this.mEmoticonIndexArray;
        if (iArr != null && i3 >= 0 && i3 < iArr.length) {
            return iArr[i3];
        }
        return -1;
    }

    @Override // com.etrump.mixlayout.api.IEMCollection
    public boolean retrieve(String str, IETFont iETFont) {
        if (this.mEngine != null && str != null && iETFont != null) {
            this.mEmoticonIndexArray = this.mEngine.native_emoticonRetrieveCollection(str, getStringCount(str), (ETFont) iETFont);
        }
        if (this.mEmoticonIndexArray != null) {
            return true;
        }
        return false;
    }
}
