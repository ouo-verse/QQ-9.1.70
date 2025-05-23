package com.huya.huyasdk.data;

import com.google.gson.annotations.SerializedName;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class UniPacket {
    public static AtomicInteger sRequestIdProducer = new AtomicInteger(0);

    @SerializedName("iRequestId")
    public Integer iRequestId = Integer.valueOf(sRequestIdProducer.incrementAndGet());

    @SerializedName("sBuffer")
    public String sBuffer;

    @SerializedName("sFuncName")
    public String sFuncName;

    @SerializedName("sServantName")
    public String sServantName;
}
