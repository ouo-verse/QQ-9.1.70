package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class LeftTxtRightPicInfo {
    public ArrayList<StRichMsg> txtInfo = new ArrayList<>();
    public StImage picInfo = new StImage();

    public StImage getPicInfo() {
        return this.picInfo;
    }

    public ArrayList<StRichMsg> getTxtInfo() {
        return this.txtInfo;
    }
}
