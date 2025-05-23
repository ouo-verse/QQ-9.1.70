package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FlashTransferSendMsgReq {
    public ArrayList<FlashTransferMsgTarget> targets = new ArrayList<>();
    public String fileSetId = "";

    public String getFileSetId() {
        return this.fileSetId;
    }

    public ArrayList<FlashTransferMsgTarget> getTargets() {
        return this.targets;
    }
}
