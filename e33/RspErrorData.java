package e33;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Le33/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "errCode", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "c", "prompt", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e33.c, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class RspErrorData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer errCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String prompt;

    public RspErrorData(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
        this.errCode = num;
        this.errMsg = str;
        this.prompt = str2;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getErrCode() {
        return this.errCode;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RspErrorData)) {
            return false;
        }
        RspErrorData rspErrorData = (RspErrorData) other;
        if (Intrinsics.areEqual(this.errCode, rspErrorData.errCode) && Intrinsics.areEqual(this.errMsg, rspErrorData.errMsg) && Intrinsics.areEqual(this.prompt, rspErrorData.prompt)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        Integer num = this.errCode;
        int i3 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i16 = hashCode * 31;
        String str = this.errMsg;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.prompt;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "RspErrorData(errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", prompt=" + this.prompt + ')';
    }
}
