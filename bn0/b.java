package bn0;

import com.google.gson.annotations.SerializedName;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {

    @SerializedName("app_id")
    public String appId;

    @SerializedName("handle_click")
    public a clickInfo;

    @SerializedName("sdk_version")
    public String sdkVersion;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class a {

        @SerializedName("click_pos")
        public int clickPosition;

        @SerializedName("click_time_millis")
        public long clickTimeMillis;
    }
}
