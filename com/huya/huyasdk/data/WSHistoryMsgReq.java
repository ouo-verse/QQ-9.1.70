package com.huya.huyasdk.data;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public class WSHistoryMsgReq {

    @SerializedName("lUid")
    public Long lUid = 0L;

    @SerializedName("vGroupId")
    public ArrayList<String> vGroupId = null;

    @SerializedName("lLastMsgId")
    public Long lLastMsgId = 0L;
}
