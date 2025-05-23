package a63;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001\tBC\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\r\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001b\u0010\u000bR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0017\u0010\u000b\u00a8\u0006!"}, d2 = {"La63/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "b", "f", "setTipsString", "(Ljava/lang/String;)V", "tipsString", "c", "I", "()I", "showLevel", "", "d", "J", "()J", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "e", "tianShuTraceInfo", "tianShuADID", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "g", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: a63.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkBubbleInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String tipsString;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int showLevel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long showTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String tianShuTraceInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String tianShuADID;

    public WinkBubbleInfo(@NotNull String name, @NotNull String tipsString, int i3, long j3, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tipsString, "tipsString");
        this.name = name;
        this.tipsString = tipsString;
        this.showLevel = i3;
        this.showTime = j3;
        this.tianShuTraceInfo = str;
        this.tianShuADID = str2;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: b, reason: from getter */
    public final int getShowLevel() {
        return this.showLevel;
    }

    /* renamed from: c, reason: from getter */
    public final long getShowTime() {
        return this.showTime;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getTianShuADID() {
        return this.tianShuADID;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getTianShuTraceInfo() {
        return this.tianShuTraceInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkBubbleInfo)) {
            return false;
        }
        WinkBubbleInfo winkBubbleInfo = (WinkBubbleInfo) other;
        if (Intrinsics.areEqual(this.name, winkBubbleInfo.name) && Intrinsics.areEqual(this.tipsString, winkBubbleInfo.tipsString) && this.showLevel == winkBubbleInfo.showLevel && this.showTime == winkBubbleInfo.showTime && Intrinsics.areEqual(this.tianShuTraceInfo, winkBubbleInfo.tianShuTraceInfo) && Intrinsics.areEqual(this.tianShuADID, winkBubbleInfo.tianShuADID)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTipsString() {
        return this.tipsString;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((this.name.hashCode() * 31) + this.tipsString.hashCode()) * 31) + this.showLevel) * 31) + androidx.fragment.app.a.a(this.showTime)) * 31;
        String str = this.tianShuTraceInfo;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        String str2 = this.tianShuADID;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "WinkBubbleInfo(name=" + this.name + ", tipsString=" + this.tipsString + ", showLevel=" + this.showLevel + ", showTime=" + this.showTime + ", tianShuTraceInfo=" + this.tianShuTraceInfo + ", tianShuADID=" + this.tianShuADID + ")";
    }

    public /* synthetic */ WinkBubbleInfo(String str, String str2, int i3, long j3, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i16 & 4) != 0 ? 1 : i3, (i16 & 8) != 0 ? 3000L : j3, (i16 & 16) != 0 ? null : str3, (i16 & 32) != 0 ? null : str4);
    }
}
