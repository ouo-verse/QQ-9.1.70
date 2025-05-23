package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsgInfo implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<MsgInfoBody> msgInfoBody = new ArrayList<>();
    public ExtBizInfo extBizInfo = new ExtBizInfo();

    public ExtBizInfo getExtBizInfo() {
        return this.extBizInfo;
    }

    public ArrayList<MsgInfoBody> getMsgInfoBody() {
        return this.msgInfoBody;
    }
}
