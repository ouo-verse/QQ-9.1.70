package np2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

/* compiled from: P */
/* loaded from: classes18.dex */
final class c {

    @SerializedName("ad_posid")
    public String adPosId;

    @SerializedName("aid")
    public String aid;

    @SerializedName("apurl")
    public String apurl;

    @SerializedName("group_id")
    public String groupId;

    /* renamed from: rl, reason: collision with root package name */
    @SerializedName("rl")
    public String f420659rl;

    @SerializedName("traceid")
    public String traceId;

    c() {
    }

    public static c a(String str) {
        return (c) op2.a.a(str, c.class, null);
    }

    public boolean b() {
        if (!TextUtils.isEmpty(this.adPosId) && !TextUtils.isEmpty(this.aid) && !TextUtils.isEmpty(this.apurl) && !TextUtils.isEmpty(this.groupId) && !TextUtils.isEmpty(this.f420659rl) && !TextUtils.isEmpty(this.traceId)) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "QQSearchWXAdExtBackComm(adPosId:" + this.adPosId + ", aid:" + this.aid + ", apurl:" + this.apurl + ", rl:" + this.f420659rl + ", traceId:" + this.traceId + ")";
    }
}
