package com.tencent.mobileqq.zplan.easteregg.model;

import com.tencent.mobileqq.zplan.easteregg.PortraitSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u000e\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/model/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "code", "Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "b", "Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "getSource", "()Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "source", "", "c", "J", "getUin", "()J", "uin", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "path", "e", "getMsg", "msg", "<init>", "(ILcom/tencent/mobileqq/zplan/easteregg/PortraitSource;JLjava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.easteregg.model.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class EasterEggBgResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final PortraitSource source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long uin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String path;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String msg;

    public EasterEggBgResult() {
        this(0, null, 0L, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        return (((((((this.code * 31) + this.source.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.uin)) * 31) + this.path.hashCode()) * 31) + this.msg.hashCode();
    }

    public String toString() {
        return "EasterEggBgResult(code=" + this.code + ", source=" + this.source + ", uin=" + this.uin + ", path=" + this.path + ", msg=" + this.msg + ")";
    }

    public EasterEggBgResult(int i3, PortraitSource source, long j3, String path, String msg2) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.code = i3;
        this.source = source;
        this.uin = j3;
        this.path = path;
        this.msg = msg2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EasterEggBgResult)) {
            return false;
        }
        EasterEggBgResult easterEggBgResult = (EasterEggBgResult) other;
        return this.code == easterEggBgResult.code && this.source == easterEggBgResult.source && this.uin == easterEggBgResult.uin && Intrinsics.areEqual(this.path, easterEggBgResult.path) && Intrinsics.areEqual(this.msg, easterEggBgResult.msg);
    }

    public /* synthetic */ EasterEggBgResult(int i3, PortraitSource portraitSource, long j3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? PortraitSource.LOCAL : portraitSource, (i16 & 4) != 0 ? 0L : j3, (i16 & 8) != 0 ? "" : str, (i16 & 16) != 0 ? "" : str2);
    }
}
