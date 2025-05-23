package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\u0006\u0010\u001a\u001a\u00020\u0005J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/ReqBody;", "", "stream", "", "sign", "", "timestamp", "", "search_key", "(ZLjava/lang/String;JLjava/lang/String;)V", "getSearch_key", "()Ljava/lang/String;", "getSign", "getStream", "()Z", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toJson", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class ReqBody {

    @SerializedName("search_key")
    @NotNull
    private final String search_key;

    @SerializedName("sign")
    @NotNull
    private final String sign;

    @SerializedName("stream")
    private final boolean stream;

    @SerializedName("timestamp")
    private final long timestamp;

    public ReqBody(boolean z16, @NotNull String sign, long j3, @NotNull String search_key) {
        Intrinsics.checkNotNullParameter(sign, "sign");
        Intrinsics.checkNotNullParameter(search_key, "search_key");
        this.stream = z16;
        this.sign = sign;
        this.timestamp = j3;
        this.search_key = search_key;
    }

    public static /* synthetic */ ReqBody copy$default(ReqBody reqBody, boolean z16, String str, long j3, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = reqBody.stream;
        }
        if ((i3 & 2) != 0) {
            str = reqBody.sign;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            j3 = reqBody.timestamp;
        }
        long j16 = j3;
        if ((i3 & 8) != 0) {
            str2 = reqBody.search_key;
        }
        return reqBody.copy(z16, str3, j16, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getStream() {
        return this.stream;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSign() {
        return this.sign;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getSearch_key() {
        return this.search_key;
    }

    @NotNull
    public final ReqBody copy(boolean stream, @NotNull String sign, long timestamp, @NotNull String search_key) {
        Intrinsics.checkNotNullParameter(sign, "sign");
        Intrinsics.checkNotNullParameter(search_key, "search_key");
        return new ReqBody(stream, sign, timestamp, search_key);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReqBody)) {
            return false;
        }
        ReqBody reqBody = (ReqBody) other;
        if (this.stream == reqBody.stream && Intrinsics.areEqual(this.sign, reqBody.sign) && this.timestamp == reqBody.timestamp && Intrinsics.areEqual(this.search_key, reqBody.search_key)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getSearch_key() {
        return this.search_key;
    }

    @NotNull
    public final String getSign() {
        return this.sign;
    }

    public final boolean getStream() {
        return this.stream;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.stream;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((r06 * 31) + this.sign.hashCode()) * 31) + androidx.fragment.app.a.a(this.timestamp)) * 31) + this.search_key.hashCode();
    }

    @NotNull
    public final String toJson() {
        String json = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
        return json;
    }

    @NotNull
    public String toString() {
        return "ReqBody(stream=" + this.stream + ", sign=" + this.sign + ", timestamp=" + this.timestamp + ", search_key=" + this.search_key + ")";
    }
}
