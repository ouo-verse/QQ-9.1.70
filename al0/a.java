package al0;

import com.tencent.ark.ark;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001\u000eB;\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b\u0015\u0010 \"\u0004\b!\u0010\"R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010#\u001a\u0004\b\u0018\u0010$\"\u0004\b%\u0010&R\u0011\u0010(\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u0011\u00a8\u0006+"}, d2 = {"Lal0/a;", "", "", "errorCode", "", "errorMessage", "", "g", "toString", "hashCode", "other", "", "equals", "", "a", "J", "d", "()J", "l", "(J)V", "startTime", "b", "i", "endTime", "c", "Z", "e", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "success", "I", "()I", "j", "(I)V", "Ljava/lang/String;", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "f", "timeCost", "<init>", "(JJZILjava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean success;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int errorCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String errorMessage;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003R\u0011\u0010\n\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lal0/a$a;", "", "Lal0/a;", "Lorg/json/JSONObject;", "c", ark.ARKMETADATA_JSON, "a", "", "b", "()J", "currentTimeMillis", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: al0.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final a a(@NotNull JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new a(json.optLong("startTime"), json.optLong("endTime"), json.optBoolean("success", true), json.optInt("errorCode"), json.optString("errorMessage"));
        }

        public final long b() {
            return System.currentTimeMillis();
        }

        @NotNull
        public final JSONObject c(@NotNull a toJSON) {
            Intrinsics.checkNotNullParameter(toJSON, "$this$toJSON");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", toJSON.getStartTime());
            jSONObject.put("endTime", toJSON.getEndTime());
            jSONObject.put("success", toJSON.getSuccess());
            jSONObject.put("errorCode", toJSON.getErrorCode());
            jSONObject.put("errorMessage", toJSON.getErrorMessage());
            return jSONObject;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a() {
        this(0L, 0L, false, 0, null, 31, null);
    }

    public static /* synthetic */ void h(a aVar, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = null;
        }
        aVar.g(i3, str);
    }

    /* renamed from: a, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: b, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: d, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof a) {
                a aVar = (a) other;
                if (this.startTime != aVar.startTime || this.endTime != aVar.endTime || this.success != aVar.success || this.errorCode != aVar.errorCode || !Intrinsics.areEqual(this.errorMessage, aVar.errorMessage)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long f() {
        long j3 = this.endTime - this.startTime;
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public final void g(int errorCode, @Nullable String errorMessage) {
        boolean z16;
        if (errorCode == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.success = z16;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        long j3 = this.startTime;
        long j16 = this.endTime;
        int i16 = ((((int) (j3 ^ (j3 >>> 32))) * 31) + ((int) ((j16 >>> 32) ^ j16))) * 31;
        boolean z16 = this.success;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (((i16 + i17) * 31) + this.errorCode) * 31;
        String str = this.errorMessage;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i18 + i3;
    }

    public final void i(long j3) {
        this.endTime = j3;
    }

    public final void j(int i3) {
        this.errorCode = i3;
    }

    public final void k(@Nullable String str) {
        this.errorMessage = str;
    }

    public final void l(long j3) {
        this.startTime = j3;
    }

    public final void m(boolean z16) {
        this.success = z16;
    }

    @NotNull
    public String toString() {
        String str;
        if (this.success) {
            str = "\u2705";
        } else {
            str = "\u274c";
        }
        return str + ", errorCode:" + this.errorCode + ", errorMessage:" + this.errorMessage + ", cost:" + f() + " [start:" + this.startTime + ", end:" + this.endTime + ']';
    }

    public a(long j3, long j16, boolean z16, int i3, @Nullable String str) {
        this.startTime = j3;
        this.endTime = j16;
        this.success = z16;
        this.errorCode = i3;
        this.errorMessage = str;
    }

    public /* synthetic */ a(long j3, long j16, boolean z16, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) == 0 ? j16 : 0L, (i16 & 4) != 0 ? true : z16, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? "" : str);
    }
}
