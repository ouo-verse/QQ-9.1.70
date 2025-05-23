package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqexpand.utils.l;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0003\u0005B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/manager/b;", "", "", "a", "", "b", "Lcom/tencent/mobileqq/qqexpand/manager/b$a;", "Lcom/tencent/mobileqq/qqexpand/manager/b$a;", "mStatus", "<init>", "()V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ActiveUserStatus mStatus = new ActiveUserStatus(null, 0, 0, 7, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J7\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\t\u0010\u000e\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/manager/b$a;", "", "", "b", "", "uin", "a", "", "latestEnterMills", "latestLoginMills", "", "saveSp", "c", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Z)V", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "J", "getLatestEnterMills", "()J", "setLatestEnterMills", "(J)V", "getLatestLoginMills", "setLatestLoginMills", "<init>", "(Ljava/lang/String;JJ)V", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqexpand.manager.b$a, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class ActiveUserStatus {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private long latestEnterMills;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private long latestLoginMills;

        public ActiveUserStatus() {
            this(null, 0L, 0L, 7, null);
        }

        public final void c(String uin, Long latestEnterMills, Long latestLoginMills, boolean saveSp) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (!Intrinsics.areEqual(this.uin, uin)) {
                a(uin);
            }
            this.uin = uin;
            if (latestEnterMills != null) {
                this.latestEnterMills = latestEnterMills.longValue();
            }
            if (latestLoginMills != null) {
                this.latestLoginMills = latestLoginMills.longValue();
            }
            if (saveSp) {
                b();
            }
        }

        public int hashCode() {
            return (((this.uin.hashCode() * 31) + a.a(this.latestEnterMills)) * 31) + a.a(this.latestLoginMills);
        }

        public String toString() {
            return "ActiveUserStatus(uin=" + this.uin + ", latestEnterMills=" + this.latestEnterMills + ", latestLoginMills=" + this.latestLoginMills + ")";
        }

        public ActiveUserStatus(String uin, long j3, long j16) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            this.uin = uin;
            this.latestEnterMills = j3;
            this.latestLoginMills = j16;
            a(uin);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActiveUserStatus)) {
                return false;
            }
            ActiveUserStatus activeUserStatus = (ActiveUserStatus) other;
            return Intrinsics.areEqual(this.uin, activeUserStatus.uin) && this.latestEnterMills == activeUserStatus.latestEnterMills && this.latestLoginMills == activeUserStatus.latestLoginMills;
        }

        public /* synthetic */ ActiveUserStatus(String str, long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? 0L : j16);
        }

        public static /* synthetic */ void d(ActiveUserStatus activeUserStatus, String str, Long l3, Long l16, boolean z16, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                l3 = null;
            }
            if ((i3 & 4) != 0) {
                l16 = null;
            }
            if ((i3 & 8) != 0) {
                z16 = false;
            }
            activeUserStatus.c(str, l3, l16, z16);
        }

        private final void a(String uin) {
        }

        private final void b() {
        }
    }

    private final String a() {
        QQAppInterface q06 = ExpandManager.q0();
        String currentAccountUin = q06 != null ? q06.getCurrentAccountUin() : null;
        return currentAccountUin == null ? "Null" : currentAccountUin;
    }

    public final void b() {
        ActiveUserStatus.d(this.mStatus, a(), Long.valueOf(NetConnInfoCenter.getServerTimeMillis()), null, true, 4, null);
        l lVar = l.f264102a;
        if (QLog.isColorLevel()) {
            lVar.a().d("ActiveUserManager", 2, "markActive() -> " + this.mStatus);
        }
    }
}
