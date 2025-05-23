package com.tencent.qq.minibox.exception;

import androidx.fragment.app.a;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\rH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010'\u001a\u00020\u0006H\u00c6\u0003J\t\u0010(\u001a\u00020\bH\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\rH\u00c6\u0003J\t\u0010-\u001a\u00020\u0006H\u00c6\u0003J\u008f\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\rH\u00c6\u0001J\u0013\u0010/\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u000101H\u00d6\u0003J\b\u00102\u001a\u0004\u0018\u00010\u0003J\t\u00103\u001a\u00020\rH\u00d6\u0001J\t\u00104\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0011\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f\u00a8\u00065"}, d2 = {"Lcom/tencent/qq/minibox/exception/MiniBoxExceptionDetail;", "Ljava/io/Serializable;", "appId", "", "gameVersion", "launchTime", "", "isNativeCrashed", "", "crashType", "crashAddress", "crashStack", "nativeSICODE", "", "crashTime", "processName", "dexVersion", "stackReportMaxLine", "(Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getCrashAddress", "getCrashStack", "getCrashTime", "()J", "getCrashType", "getDexVersion", "getGameVersion", "()Z", "getLaunchTime", "getNativeSICODE", "()I", "getProcessName", "getStackReportMaxLine", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getSliceCrashStack", "hashCode", "toString", "minibox-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final /* data */ class MiniBoxExceptionDetail implements Serializable {

    @Nullable
    private final String appId;

    @Nullable
    private final String crashAddress;

    @Nullable
    private final String crashStack;
    private final long crashTime;

    @Nullable
    private final String crashType;

    @Nullable
    private final String dexVersion;

    @Nullable
    private final String gameVersion;
    private final boolean isNativeCrashed;
    private final long launchTime;
    private final int nativeSICODE;

    @Nullable
    private final String processName;
    private final int stackReportMaxLine;

    public MiniBoxExceptionDetail(@Nullable String str, @Nullable String str2, long j3, boolean z16, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i3, long j16, @Nullable String str6, @Nullable String str7, int i16) {
        this.appId = str;
        this.gameVersion = str2;
        this.launchTime = j3;
        this.isNativeCrashed = z16;
        this.crashType = str3;
        this.crashAddress = str4;
        this.crashStack = str5;
        this.nativeSICODE = i3;
        this.crashTime = j16;
        this.processName = str6;
        this.dexVersion = str7;
        this.stackReportMaxLine = i16;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getProcessName() {
        return this.processName;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getDexVersion() {
        return this.dexVersion;
    }

    /* renamed from: component12, reason: from getter */
    public final int getStackReportMaxLine() {
        return this.stackReportMaxLine;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getGameVersion() {
        return this.gameVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLaunchTime() {
        return this.launchTime;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsNativeCrashed() {
        return this.isNativeCrashed;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getCrashType() {
        return this.crashType;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getCrashAddress() {
        return this.crashAddress;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getCrashStack() {
        return this.crashStack;
    }

    /* renamed from: component8, reason: from getter */
    public final int getNativeSICODE() {
        return this.nativeSICODE;
    }

    /* renamed from: component9, reason: from getter */
    public final long getCrashTime() {
        return this.crashTime;
    }

    @NotNull
    public final MiniBoxExceptionDetail copy(@Nullable String appId, @Nullable String gameVersion, long launchTime, boolean isNativeCrashed, @Nullable String crashType, @Nullable String crashAddress, @Nullable String crashStack, int nativeSICODE, long crashTime, @Nullable String processName, @Nullable String dexVersion, int stackReportMaxLine) {
        return new MiniBoxExceptionDetail(appId, gameVersion, launchTime, isNativeCrashed, crashType, crashAddress, crashStack, nativeSICODE, crashTime, processName, dexVersion, stackReportMaxLine);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniBoxExceptionDetail)) {
            return false;
        }
        MiniBoxExceptionDetail miniBoxExceptionDetail = (MiniBoxExceptionDetail) other;
        if (Intrinsics.areEqual(this.appId, miniBoxExceptionDetail.appId) && Intrinsics.areEqual(this.gameVersion, miniBoxExceptionDetail.gameVersion) && this.launchTime == miniBoxExceptionDetail.launchTime && this.isNativeCrashed == miniBoxExceptionDetail.isNativeCrashed && Intrinsics.areEqual(this.crashType, miniBoxExceptionDetail.crashType) && Intrinsics.areEqual(this.crashAddress, miniBoxExceptionDetail.crashAddress) && Intrinsics.areEqual(this.crashStack, miniBoxExceptionDetail.crashStack) && this.nativeSICODE == miniBoxExceptionDetail.nativeSICODE && this.crashTime == miniBoxExceptionDetail.crashTime && Intrinsics.areEqual(this.processName, miniBoxExceptionDetail.processName) && Intrinsics.areEqual(this.dexVersion, miniBoxExceptionDetail.dexVersion) && this.stackReportMaxLine == miniBoxExceptionDetail.stackReportMaxLine) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getAppId() {
        return this.appId;
    }

    @Nullable
    public final String getCrashAddress() {
        return this.crashAddress;
    }

    @Nullable
    public final String getCrashStack() {
        return this.crashStack;
    }

    public final long getCrashTime() {
        return this.crashTime;
    }

    @Nullable
    public final String getCrashType() {
        return this.crashType;
    }

    @Nullable
    public final String getDexVersion() {
        return this.dexVersion;
    }

    @Nullable
    public final String getGameVersion() {
        return this.gameVersion;
    }

    public final long getLaunchTime() {
        return this.launchTime;
    }

    public final int getNativeSICODE() {
        return this.nativeSICODE;
    }

    @Nullable
    public final String getProcessName() {
        return this.processName;
    }

    @Nullable
    public final String getSliceCrashStack() {
        List split$default;
        List take;
        int i3;
        IntRange until;
        List slice;
        boolean contains$default;
        String str = this.crashStack;
        if (str == null) {
            return null;
        }
        if (this.stackReportMaxLine >= 0) {
            try {
                split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"\n"}, false, 0, 6, (Object) null);
                if (split$default.size() >= this.stackReportMaxLine) {
                    Iterator it = split$default.iterator();
                    int i16 = 0;
                    while (true) {
                        if (it.hasNext()) {
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) it.next(), (CharSequence) "Caused by", false, 2, (Object) null);
                            if (contains$default) {
                                break;
                            }
                            i16++;
                        } else {
                            i16 = -1;
                            break;
                        }
                    }
                    if (i16 == -1 || (i3 = i16 + 1) >= split$default.size()) {
                        take = CollectionsKt___CollectionsKt.take(split$default, this.stackReportMaxLine);
                        str = CollectionsKt___CollectionsKt.joinToString$default(take, "\n", null, null, 0, null, null, 62, null);
                    } else {
                        until = RangesKt___RangesKt.until(i3, Math.min(split$default.size(), i16 + this.stackReportMaxLine + 1));
                        slice = CollectionsKt___CollectionsKt.slice(split$default, until);
                        str = CollectionsKt___CollectionsKt.joinToString$default(slice, "\n", null, null, 0, null, null, 62, null);
                    }
                }
            } catch (Throwable unused) {
                QLog.w("MiniBoxExceptionDetail", 1, "slice crash stack fail");
                str = this.crashStack;
            }
        }
        return str;
    }

    public final int getStackReportMaxLine() {
        return this.stackReportMaxLine;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        String str = this.appId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.gameVersion;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int a16 = (((i16 + hashCode2) * 31) + a.a(this.launchTime)) * 31;
        boolean z16 = this.isNativeCrashed;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (a16 + i17) * 31;
        String str3 = this.crashType;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i19 = (i18 + hashCode3) * 31;
        String str4 = this.crashAddress;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i26 = (i19 + hashCode4) * 31;
        String str5 = this.crashStack;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int a17 = (((((i26 + hashCode5) * 31) + this.nativeSICODE) * 31) + a.a(this.crashTime)) * 31;
        String str6 = this.processName;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i27 = (a17 + hashCode6) * 31;
        String str7 = this.dexVersion;
        if (str7 != null) {
            i3 = str7.hashCode();
        }
        return ((i27 + i3) * 31) + this.stackReportMaxLine;
    }

    public final boolean isNativeCrashed() {
        return this.isNativeCrashed;
    }

    @NotNull
    public String toString() {
        return "MiniBoxExceptionDetail(appId=" + this.appId + ", gameVersion=" + this.gameVersion + ", launchTime=" + this.launchTime + ", isNativeCrashed=" + this.isNativeCrashed + ", crashType=" + this.crashType + ", crashAddress=" + this.crashAddress + ", crashStack=" + this.crashStack + ", nativeSICODE=" + this.nativeSICODE + ", crashTime=" + this.crashTime + ", processName=" + this.processName + ", dexVersion=" + this.dexVersion + ", stackReportMaxLine=" + this.stackReportMaxLine + ')';
    }

    public /* synthetic */ MiniBoxExceptionDetail(String str, String str2, long j3, boolean z16, String str3, String str4, String str5, int i3, long j16, String str6, String str7, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j3, z16, str3, str4, str5, i3, j16, str6, str7, (i17 & 2048) != 0 ? -1 : i16);
    }
}
