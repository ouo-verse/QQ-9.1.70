package com.huya.huyasdk.jce;

import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

/* compiled from: P */
/* loaded from: classes2.dex */
public class OpenMessageNotice {

    @Nullable
    @SerializedName("sOpenAppName")
    public String sOpenAppName = "";

    @SerializedName("lPresenterUid")
    public long lPresenterUid = 0;

    @Nullable
    @SerializedName("sContent")
    public String sContent = "";

    @SerializedName("lSenderUid")
    public long lSenderUid = 0;

    @Nullable
    @SerializedName("sSenderNick")
    public String sSenderNick = "";

    public String toString() {
        return "OpenMessageNotice{sOpenAppName='" + this.sOpenAppName + "', lPresenterUid=" + this.lPresenterUid + ", sContent='" + this.sContent + "', lSenderUid=" + this.lSenderUid + ", sSenderNick='" + this.sSenderNick + "'}";
    }
}
