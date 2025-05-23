package com.tencent.mobileqq.guild.feed.preload.detail.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/preload/detail/data/ResponseCode;", "", "code", "", "msg", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class ResponseCode {
    private final int code;

    @NotNull
    private final String msg;

    public ResponseCode() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ResponseCode copy$default(ResponseCode responseCode, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = responseCode.code;
        }
        if ((i16 & 2) != 0) {
            str = responseCode.msg;
        }
        return responseCode.copy(i3, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final ResponseCode copy(int code, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return new ResponseCode(code, msg2);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseCode)) {
            return false;
        }
        ResponseCode responseCode = (ResponseCode) other;
        if (this.code == responseCode.code && Intrinsics.areEqual(this.msg, responseCode.msg)) {
            return true;
        }
        return false;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        return (this.code * 31) + this.msg.hashCode();
    }

    @NotNull
    public String toString() {
        return "ResponseCode(code=" + this.code + ", msg=" + this.msg + ")";
    }

    public ResponseCode(int i3, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.code = i3;
        this.msg = msg2;
    }

    public /* synthetic */ ResponseCode(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? "" : str);
    }
}
