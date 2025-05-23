package com.tencent.aegiskmm.bean;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0006\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\r\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u0013\u0010\u001bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/aegiskmm/bean/f;", "Lcom/tencent/aegiskmm/bean/e;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "d", "", "e", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "msg", "Lcom/tencent/aegiskmm/bean/AegisLogLevel;", "c", "Lcom/tencent/aegiskmm/bean/AegisLogLevel;", "()Lcom/tencent/aegiskmm/bean/AegisLogLevel;", "setLevel", "(Lcom/tencent/aegiskmm/bean/AegisLogLevel;)V", "level", "Lcom/tencent/aegiskmm/bean/AegisLogType;", "Lcom/tencent/aegiskmm/bean/AegisLogType;", "()Lcom/tencent/aegiskmm/bean/AegisLogType;", "type", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "getExtInfo", "()Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "setExtInfo", "(Lcom/tencent/kuikly/core/nvi/serialization/json/e;)V", "extInfo", "<init>", "(Ljava/lang/String;Lcom/tencent/aegiskmm/bean/AegisLogLevel;Lcom/tencent/aegiskmm/bean/AegisLogType;Lcom/tencent/kuikly/core/nvi/serialization/json/e;)V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.aegiskmm.bean.f, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class NormalLog extends e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String msg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private AegisLogLevel level;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final AegisLogType type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private com.tencent.kuikly.core.nvi.serialization.json.e extInfo;

    public /* synthetic */ NormalLog(String str, AegisLogLevel aegisLogLevel, AegisLogType aegisLogType, com.tencent.kuikly.core.nvi.serialization.json.e eVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, aegisLogLevel, aegisLogType, (i3 & 8) != 0 ? new com.tencent.kuikly.core.nvi.serialization.json.e() : eVar);
    }

    /* renamed from: b, reason: from getter */
    public final AegisLogLevel getLevel() {
        return this.level;
    }

    /* renamed from: c, reason: from getter */
    public final AegisLogType getType() {
        return this.type;
    }

    public com.tencent.kuikly.core.nvi.serialization.json.e d() {
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("msg", this.msg);
        if (this.level != AegisLogLevel.NULL) {
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String();
            String name = this.level.name();
            if (name != null) {
                String lowerCase = name.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                eVar.v("level", lowerCase);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("type", this.type);
        Iterator<String> c16 = this.extInfo.c();
        while (c16.hasNext()) {
            String next = c16.next();
            getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v(next, this.extInfo.e(next));
        }
        return getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String();
    }

    public String e() {
        com.tencent.kuikly.core.nvi.serialization.json.e d16 = d();
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        Iterator<String> c16 = d16.c();
        while (c16.hasNext()) {
            String next = c16.next();
            if (!Intrinsics.areEqual(next, "type")) {
                eVar.v(next, d16.e(next));
            }
        }
        return eVar.toString();
    }

    public int hashCode() {
        String str = this.msg;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AegisLogLevel aegisLogLevel = this.level;
        int hashCode2 = (hashCode + (aegisLogLevel != null ? aegisLogLevel.hashCode() : 0)) * 31;
        AegisLogType aegisLogType = this.type;
        int hashCode3 = (hashCode2 + (aegisLogType != null ? aegisLogType.hashCode() : 0)) * 31;
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = this.extInfo;
        return hashCode3 + (eVar != null ? eVar.hashCode() : 0);
    }

    public String toString() {
        return "NormalLog(msg=" + this.msg + ", level=" + this.level + ", type=" + this.type + ", extInfo=" + this.extInfo + ")";
    }

    public NormalLog(String msg2, AegisLogLevel level, AegisLogType type, com.tencent.kuikly.core.nvi.serialization.json.e extInfo) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        this.msg = msg2;
        this.level = level;
        this.type = type;
        this.extInfo = extInfo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NormalLog)) {
            return false;
        }
        NormalLog normalLog = (NormalLog) other;
        return Intrinsics.areEqual(this.msg, normalLog.msg) && Intrinsics.areEqual(this.level, normalLog.level) && Intrinsics.areEqual(this.type, normalLog.type) && Intrinsics.areEqual(this.extInfo, normalLog.extInfo);
    }
}
