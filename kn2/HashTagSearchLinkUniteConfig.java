package kn2;

import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lkn2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "b", "I", "()I", "inputSpanUpdateLevel", "<init>", "(ZI)V", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: kn2.a, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class HashTagSearchLinkUniteConfig {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final HashTagSearchLinkUniteConfig f412718d = new HashTagSearchLinkUniteConfig(QLog.isDebugVersion(), 2);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean switch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int inputSpanUpdateLevel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lkn2/a$a;", "", "Lkn2/a;", "DEFAULT", "Lkn2/a;", "a", "()Lkn2/a;", "<init>", "()V", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kn2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashTagSearchLinkUniteConfig a() {
            return HashTagSearchLinkUniteConfig.f412718d;
        }

        Companion() {
        }
    }

    public HashTagSearchLinkUniteConfig(boolean z16, int i3) {
        this.switch = z16;
        this.inputSpanUpdateLevel = i3;
    }

    /* renamed from: b, reason: from getter */
    public final int getInputSpanUpdateLevel() {
        return this.inputSpanUpdateLevel;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getSwitch() {
        return this.switch;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HashTagSearchLinkUniteConfig)) {
            return false;
        }
        HashTagSearchLinkUniteConfig hashTagSearchLinkUniteConfig = (HashTagSearchLinkUniteConfig) other;
        if (this.switch == hashTagSearchLinkUniteConfig.switch && this.inputSpanUpdateLevel == hashTagSearchLinkUniteConfig.inputSpanUpdateLevel) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.switch;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.inputSpanUpdateLevel;
    }

    @NotNull
    public String toString() {
        return "HashTagSearchLinkUniteConfig(switch=" + this.switch + ", inputSpanUpdateLevel=" + this.inputSpanUpdateLevel + ')';
    }
}
