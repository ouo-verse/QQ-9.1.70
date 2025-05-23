package com.huya.huyasdk.data;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes2.dex */
public class WSPushMessage {

    @SerializedName("iUri")
    public Integer iUri;

    @SerializedName("lMsgId")
    public Long lMsgId;

    @SerializedName("sMsg")
    public List<Integer> sMsg;

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("WSPushMessage{iUri : ");
        sb5.append(this.iUri);
        sb5.append(", lMsgId : ");
        sb5.append(this.lMsgId);
        sb5.append("}");
        return sb5.toString();
    }
}
