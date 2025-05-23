package gs3;

import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u000bR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lgs3/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appIdRule", "b", "d", "crashTypeRule", "c", "crashAddressRule", "crashStackRule", "e", "f", "processNameRule", "dexVersionRule", "g", "I", "()I", "stackReportMaxLine", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: gs3.d, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class MiniBoxExceptionReportRule {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String appIdRule;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String crashTypeRule;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String crashAddressRule;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String crashStackRule;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String processNameRule;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String dexVersionRule;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int stackReportMaxLine;

    public MiniBoxExceptionReportRule() {
        this(null, null, null, null, null, null, 0, 127, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAppIdRule() {
        return this.appIdRule;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getCrashAddressRule() {
        return this.crashAddressRule;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getCrashStackRule() {
        return this.crashStackRule;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getCrashTypeRule() {
        return this.crashTypeRule;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getDexVersionRule() {
        return this.dexVersionRule;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniBoxExceptionReportRule)) {
            return false;
        }
        MiniBoxExceptionReportRule miniBoxExceptionReportRule = (MiniBoxExceptionReportRule) other;
        if (Intrinsics.areEqual(this.appIdRule, miniBoxExceptionReportRule.appIdRule) && Intrinsics.areEqual(this.crashTypeRule, miniBoxExceptionReportRule.crashTypeRule) && Intrinsics.areEqual(this.crashAddressRule, miniBoxExceptionReportRule.crashAddressRule) && Intrinsics.areEqual(this.crashStackRule, miniBoxExceptionReportRule.crashStackRule) && Intrinsics.areEqual(this.processNameRule, miniBoxExceptionReportRule.processNameRule) && Intrinsics.areEqual(this.dexVersionRule, miniBoxExceptionReportRule.dexVersionRule) && this.stackReportMaxLine == miniBoxExceptionReportRule.stackReportMaxLine) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getProcessNameRule() {
        return this.processNameRule;
    }

    /* renamed from: g, reason: from getter */
    public final int getStackReportMaxLine() {
        return this.stackReportMaxLine;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        String str = this.appIdRule;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.crashTypeRule;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.crashAddressRule;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.crashStackRule;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.processNameRule;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str6 = this.dexVersionRule;
        if (str6 != null) {
            i3 = str6.hashCode();
        }
        return ((i26 + i3) * 31) + this.stackReportMaxLine;
    }

    @NotNull
    public String toString() {
        return "MiniBoxExceptionReportRule(appIdRule=" + this.appIdRule + ", crashTypeRule=" + this.crashTypeRule + ", crashAddressRule=" + this.crashAddressRule + ", crashStackRule=" + this.crashStackRule + ", processNameRule=" + this.processNameRule + ", dexVersionRule=" + this.dexVersionRule + ", stackReportMaxLine=" + this.stackReportMaxLine + ')';
    }

    public MiniBoxExceptionReportRule(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, int i3) {
        this.appIdRule = str;
        this.crashTypeRule = str2;
        this.crashAddressRule = str3;
        this.crashStackRule = str4;
        this.processNameRule = str5;
        this.dexVersionRule = str6;
        this.stackReportMaxLine = i3;
    }

    public /* synthetic */ MiniBoxExceptionReportRule(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? MiniGameVAUtil.META_MINI_GAME_APPID : str, (i16 & 2) != 0 ? null : str2, (i16 & 4) != 0 ? null : str3, (i16 & 8) != 0 ? null : str4, (i16 & 16) != 0 ? ProcessConstant.MINI_BOX_CORE : str5, (i16 & 32) == 0 ? str6 : null, (i16 & 64) != 0 ? 5 : i3);
    }
}
