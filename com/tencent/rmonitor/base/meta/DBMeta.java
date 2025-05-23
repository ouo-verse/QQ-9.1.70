package com.tencent.rmonitor.base.meta;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u000bH\u00c6\u0003J\t\u0010!\u001a\u00020\u000bH\u00c6\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u00d6\u0003J\t\u0010'\u001a\u00020(H\u00d6\u0001J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011\u00a8\u0006*"}, d2 = {"Lcom/tencent/rmonitor/base/meta/DBMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "processName", "", "threadName", "dbPath", "table", "sql", "explain", "extInfo", "sqlTimeCost", "", WadlProxyConsts.CREATE_TIME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getCreateTime", "()J", "getDbPath", "()Ljava/lang/String;", "getExplain", "getExtInfo", "getProcessName", "getSql", "getSqlTimeCost", "getTable", "getThreadName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final /* data */ class DBMeta extends MonitorMeta {
    private final long createTime;

    @NotNull
    private final String dbPath;

    @NotNull
    private final String explain;

    @NotNull
    private final String extInfo;

    @NotNull
    private final String processName;

    @NotNull
    private final String sql;
    private final long sqlTimeCost;

    @NotNull
    private final String table;

    @NotNull
    private final String threadName;

    public DBMeta(@NotNull String processName, @NotNull String threadName, @NotNull String dbPath, @NotNull String table, @NotNull String sql, @NotNull String explain, @NotNull String extInfo, long j3, long j16) {
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(threadName, "threadName");
        Intrinsics.checkParameterIsNotNull(dbPath, "dbPath");
        Intrinsics.checkParameterIsNotNull(table, "table");
        Intrinsics.checkParameterIsNotNull(sql, "sql");
        Intrinsics.checkParameterIsNotNull(explain, "explain");
        Intrinsics.checkParameterIsNotNull(extInfo, "extInfo");
        this.processName = processName;
        this.threadName = threadName;
        this.dbPath = dbPath;
        this.table = table;
        this.sql = sql;
        this.explain = explain;
        this.extInfo = extInfo;
        this.sqlTimeCost = j3;
        this.createTime = j16;
    }

    public static /* synthetic */ DBMeta copy$default(DBMeta dBMeta, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j3, long j16, int i3, Object obj) {
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        long j17;
        long j18;
        if ((i3 & 1) != 0) {
            str8 = dBMeta.processName;
        } else {
            str8 = str;
        }
        if ((i3 & 2) != 0) {
            str9 = dBMeta.threadName;
        } else {
            str9 = str2;
        }
        if ((i3 & 4) != 0) {
            str10 = dBMeta.dbPath;
        } else {
            str10 = str3;
        }
        if ((i3 & 8) != 0) {
            str11 = dBMeta.table;
        } else {
            str11 = str4;
        }
        if ((i3 & 16) != 0) {
            str12 = dBMeta.sql;
        } else {
            str12 = str5;
        }
        if ((i3 & 32) != 0) {
            str13 = dBMeta.explain;
        } else {
            str13 = str6;
        }
        if ((i3 & 64) != 0) {
            str14 = dBMeta.extInfo;
        } else {
            str14 = str7;
        }
        if ((i3 & 128) != 0) {
            j17 = dBMeta.sqlTimeCost;
        } else {
            j17 = j3;
        }
        if ((i3 & 256) != 0) {
            j18 = dBMeta.createTime;
        } else {
            j18 = j16;
        }
        return dBMeta.copy(str8, str9, str10, str11, str12, str13, str14, j17, j18);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getProcessName() {
        return this.processName;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getThreadName() {
        return this.threadName;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getDbPath() {
        return this.dbPath;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getTable() {
        return this.table;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getSql() {
        return this.sql;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getExplain() {
        return this.explain;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getExtInfo() {
        return this.extInfo;
    }

    /* renamed from: component8, reason: from getter */
    public final long getSqlTimeCost() {
        return this.sqlTimeCost;
    }

    /* renamed from: component9, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final DBMeta copy(@NotNull String processName, @NotNull String threadName, @NotNull String dbPath, @NotNull String table, @NotNull String sql, @NotNull String explain, @NotNull String extInfo, long sqlTimeCost, long createTime) {
        Intrinsics.checkParameterIsNotNull(processName, "processName");
        Intrinsics.checkParameterIsNotNull(threadName, "threadName");
        Intrinsics.checkParameterIsNotNull(dbPath, "dbPath");
        Intrinsics.checkParameterIsNotNull(table, "table");
        Intrinsics.checkParameterIsNotNull(sql, "sql");
        Intrinsics.checkParameterIsNotNull(explain, "explain");
        Intrinsics.checkParameterIsNotNull(extInfo, "extInfo");
        return new DBMeta(processName, threadName, dbPath, table, sql, explain, extInfo, sqlTimeCost, createTime);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        if (this != other) {
            if (other instanceof DBMeta) {
                DBMeta dBMeta = (DBMeta) other;
                if (Intrinsics.areEqual(this.processName, dBMeta.processName) && Intrinsics.areEqual(this.threadName, dBMeta.threadName) && Intrinsics.areEqual(this.dbPath, dBMeta.dbPath) && Intrinsics.areEqual(this.table, dBMeta.table) && Intrinsics.areEqual(this.sql, dBMeta.sql) && Intrinsics.areEqual(this.explain, dBMeta.explain) && Intrinsics.areEqual(this.extInfo, dBMeta.extInfo)) {
                    if (this.sqlTimeCost == dBMeta.sqlTimeCost) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        if (this.createTime == dBMeta.createTime) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getDbPath() {
        return this.dbPath;
    }

    @NotNull
    public final String getExplain() {
        return this.explain;
    }

    @NotNull
    public final String getExtInfo() {
        return this.extInfo;
    }

    @NotNull
    public final String getProcessName() {
        return this.processName;
    }

    @NotNull
    public final String getSql() {
        return this.sql;
    }

    public final long getSqlTimeCost() {
        return this.sqlTimeCost;
    }

    @NotNull
    public final String getTable() {
        return this.table;
    }

    @NotNull
    public final String getThreadName() {
        return this.threadName;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        String str = this.processName;
        int i27 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = i3 * 31;
        String str2 = this.threadName;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        String str3 = this.dbPath;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i36 = (i29 + i17) * 31;
        String str4 = this.table;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i37 = (i36 + i18) * 31;
        String str5 = this.sql;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i38 = (i37 + i19) * 31;
        String str6 = this.explain;
        if (str6 != null) {
            i26 = str6.hashCode();
        } else {
            i26 = 0;
        }
        int i39 = (i38 + i26) * 31;
        String str7 = this.extInfo;
        if (str7 != null) {
            i27 = str7.hashCode();
        }
        int i46 = (i39 + i27) * 31;
        long j3 = this.sqlTimeCost;
        int i47 = (i46 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j16 = this.createTime;
        return i47 + ((int) (j16 ^ (j16 >>> 32)));
    }

    @NotNull
    public String toString() {
        return "DBMeta(processName=" + this.processName + ", threadName=" + this.threadName + ", dbPath=" + this.dbPath + ", table=" + this.table + ", sql=" + this.sql + ", explain=" + this.explain + ", extInfo=" + this.extInfo + ", sqlTimeCost=" + this.sqlTimeCost + ", createTime=" + this.createTime + ")";
    }
}
