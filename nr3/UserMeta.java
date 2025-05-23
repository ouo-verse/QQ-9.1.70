package nr3;

import com.tencent.qmethod.monitor.base.PMonitorInitParam;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0006\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0016\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lnr3/b;", "", "", "b", "", "a", "toString", "", "hashCode", "other", "", "equals", "Lpr3/a;", "Lpr3/a;", "appUniqueIDHelper", "Ljava/lang/String;", "uin", "c", "uuid", "d", com.heytap.mcssdk.a.a.f36102l, "e", "appId", "f", "appVersion", "g", "sdkVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: nr3.b, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class UserMeta {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final pr3.a appUniqueIDHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @NotNull
    public String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @NotNull
    public String uuid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @NotNull
    public String appKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @NotNull
    public String appId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @NotNull
    public String appVersion;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @JvmField
    @NotNull
    public String sdkVersion;

    public UserMeta() {
        this(null, null, null, null, null, null, 63, null);
    }

    @NotNull
    public final String a() {
        return this.appUniqueIDHelper.a();
    }

    public final void b() {
        boolean isBlank;
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        this.uin = aVar.d(PMonitorInitParam.Property.APP_USER_ID);
        this.appId = aVar.g().getAppId();
        this.appKey = aVar.g().getAppKey();
        this.appVersion = aVar.d(PMonitorInitParam.Property.APP_VERSION);
        this.uuid = aVar.d(PMonitorInitParam.Property.APP_RDM_UUID);
        if (Intrinsics.areEqual("unknown", this.appVersion)) {
            this.appVersion = com.tencent.qmethod.monitor.base.util.a.f343531j.a(aVar.g().getContext());
        }
        if (Intrinsics.areEqual("unknown", this.uuid)) {
            this.uuid = com.tencent.qmethod.monitor.base.util.a.f343531j.b(aVar.g().getContext());
        }
        String d16 = aVar.d(PMonitorInitParam.Property.APP_UNIQUE_ID);
        if (!Intrinsics.areEqual("unknown", d16)) {
            isBlank = StringsKt__StringsJVMKt.isBlank(d16);
            if (!isBlank) {
                this.appUniqueIDHelper.c(d16);
            }
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof UserMeta) {
                UserMeta userMeta = (UserMeta) other;
                if (!Intrinsics.areEqual(this.uin, userMeta.uin) || !Intrinsics.areEqual(this.uuid, userMeta.uuid) || !Intrinsics.areEqual(this.appKey, userMeta.appKey) || !Intrinsics.areEqual(this.appId, userMeta.appId) || !Intrinsics.areEqual(this.appVersion, userMeta.appVersion) || !Intrinsics.areEqual(this.sdkVersion, userMeta.sdkVersion)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        String str = this.uin;
        int i26 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        String str2 = this.uuid;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        String str3 = this.appKey;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        String str4 = this.appId;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        String str5 = this.appVersion;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i37 = (i36 + i19) * 31;
        String str6 = this.sdkVersion;
        if (str6 != null) {
            i26 = str6.hashCode();
        }
        return i37 + i26;
    }

    @NotNull
    public String toString() {
        return "UserMeta(uin=" + this.uin + ", uuid=" + this.uuid + ", appKey=" + this.appKey + ", appId=" + this.appId + ", appVersion=" + this.appVersion + ", sdkVersion=" + this.sdkVersion + ")";
    }

    public UserMeta(@NotNull String uin, @NotNull String uuid, @NotNull String appKey, @NotNull String appId, @NotNull String appVersion, @NotNull String sdkVersion) {
        Intrinsics.checkParameterIsNotNull(uin, "uin");
        Intrinsics.checkParameterIsNotNull(uuid, "uuid");
        Intrinsics.checkParameterIsNotNull(appKey, "appKey");
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        Intrinsics.checkParameterIsNotNull(appVersion, "appVersion");
        Intrinsics.checkParameterIsNotNull(sdkVersion, "sdkVersion");
        this.uin = uin;
        this.uuid = uuid;
        this.appKey = appKey;
        this.appId = appId;
        this.appVersion = appVersion;
        this.sdkVersion = sdkVersion;
        this.appUniqueIDHelper = new pr3.a();
    }

    public /* synthetic */ UserMeta(String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "unknown" : str, (i3 & 2) != 0 ? "unknown" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) == 0 ? str5 : "unknown", (i3 & 32) != 0 ? "0.9.15-rc2+build.1" : str6);
    }
}
