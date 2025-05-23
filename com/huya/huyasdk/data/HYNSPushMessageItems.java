package com.huya.huyasdk.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes2.dex */
public class HYNSPushMessageItems {

    @SerializedName("sGroupId")
    public String sGroupId;

    @SerializedName("vMsgItem")
    public List<WSPushMessage> vMsgItem;
}
