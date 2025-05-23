package com.tencent.aelight.camera.report.atta;

import com.tencent.mobileqq.app.AppConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0019\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001a\u0010\fR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u0018\u0010\u001eR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b\u0015\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/aelight/camera/report/atta/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "eventCode", "", "b", "J", "getEventTime", "()J", "eventTime", "duration", "d", "g", "result", "e", "code", "f", "msg", "", "Ljava/util/List;", "()Ljava/util/List;", AppConstants.Key.COLUMN_EXT_STR, h.F, AppConstants.Key.COLUMN_EXT_INT, "<init>", "(Ljava/lang/String;JJLjava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.aelight.camera.report.atta.b, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class AttaEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String eventCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long eventTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long duration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String result;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long code;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String msg;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> extStr;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<Long> extInt;

    public AttaEvent(String eventCode, long j3, long j16, String result, long j17, String msg2, List<String> extStr, List<Long> extInt) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(extStr, "extStr");
        Intrinsics.checkNotNullParameter(extInt, "extInt");
        this.eventCode = eventCode;
        this.eventTime = j3;
        this.duration = j16;
        this.result = result;
        this.code = j17;
        this.msg = msg2;
        this.extStr = extStr;
        this.extInt = extInt;
    }

    /* renamed from: a, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: c, reason: from getter */
    public final String getEventCode() {
        return this.eventCode;
    }

    public final List<Long> d() {
        return this.extInt;
    }

    public final List<String> e() {
        return this.extStr;
    }

    /* renamed from: f, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: g, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    public int hashCode() {
        return (((((((((((((this.eventCode.hashCode() * 31) + a.a(this.eventTime)) * 31) + a.a(this.duration)) * 31) + this.result.hashCode()) * 31) + a.a(this.code)) * 31) + this.msg.hashCode()) * 31) + this.extStr.hashCode()) * 31) + this.extInt.hashCode();
    }

    public String toString() {
        return "AttaEvent(eventCode=" + this.eventCode + ", eventTime=" + this.eventTime + ", duration=" + this.duration + ", result=" + this.result + ", code=" + this.code + ", msg=" + this.msg + ", extStr=" + this.extStr + ", extInt=" + this.extInt + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttaEvent)) {
            return false;
        }
        AttaEvent attaEvent = (AttaEvent) other;
        return Intrinsics.areEqual(this.eventCode, attaEvent.eventCode) && this.eventTime == attaEvent.eventTime && this.duration == attaEvent.duration && Intrinsics.areEqual(this.result, attaEvent.result) && this.code == attaEvent.code && Intrinsics.areEqual(this.msg, attaEvent.msg) && Intrinsics.areEqual(this.extStr, attaEvent.extStr) && Intrinsics.areEqual(this.extInt, attaEvent.extInt);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AttaEvent(String str, long j3, long j16, String str2, long j17, String str3, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, r8, r10, r11, r13, r14, r15);
        List list3;
        List list4;
        List emptyList;
        List emptyList2;
        long j18 = (i3 & 4) != 0 ? 0L : j16;
        String str4 = (i3 & 8) != 0 ? "fail" : str2;
        long j19 = (i3 & 16) != 0 ? 0L : j17;
        String str5 = (i3 & 32) != 0 ? "" : str3;
        if ((i3 & 64) != 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list3 = emptyList2;
        } else {
            list3 = list;
        }
        if ((i3 & 128) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list4 = emptyList;
        } else {
            list4 = list2;
        }
    }
}
