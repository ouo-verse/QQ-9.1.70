package com.huya.huyasdk.data;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public class WSHistoryMsgRsp {

    @SerializedName("vMsg")
    public ArrayList<HYNSPushMessageItems> vMsg = null;

    @SerializedName("lLastMsgId")
    public Long lLastMsgId = 0L;
}
