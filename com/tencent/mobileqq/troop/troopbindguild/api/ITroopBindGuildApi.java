package com.tencent.mobileqq.troop.troopbindguild.api;

import androidx.fragment.app.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopbindguild/api/ITroopBindGuildApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troopUin", "Lcom/tencent/mobileqq/troop/troopbindguild/api/ITroopBindGuildApi$a;", "getBindGuildInfoFromExtInfo", "", "getAIOShowBindGuildSwitch", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopBindGuildApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/troopbindguild/api/ITroopBindGuildApi$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "J", "()J", "guildId", "<init>", "(ZJ)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopbindguild.api.ITroopBindGuildApi$a, reason: from toString */
    /* loaded from: classes19.dex */
    public static final /* data */ class TroopBindGuildInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean switch;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long guildId;

        public TroopBindGuildInfo(boolean z16, long j3) {
            this.switch = z16;
            this.guildId = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getSwitch() {
            return this.switch;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TroopBindGuildInfo)) {
                return false;
            }
            TroopBindGuildInfo troopBindGuildInfo = (TroopBindGuildInfo) other;
            if (this.switch == troopBindGuildInfo.switch && this.guildId == troopBindGuildInfo.guildId) {
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
            return (r06 * 31) + a.a(this.guildId);
        }

        @NotNull
        public String toString() {
            return "TroopBindGuildInfo(switch=" + this.switch + ", guildId=" + this.guildId + ")";
        }
    }

    boolean getAIOShowBindGuildSwitch();

    @Nullable
    TroopBindGuildInfo getBindGuildInfoFromExtInfo(@NotNull String troopUin);
}
