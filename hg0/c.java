package hg0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0011\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lhg0/c;", "", "", "spanName", "e", "", "d", "toString", "", "hashCode", "other", "equals", "a", "Lhg0/c;", "()Lhg0/c;", "setParentSpan", "(Lhg0/c;)V", "parentSpan", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "setSpanName", "(Ljava/lang/String;)V", "c", "I", "()I", "f", "(I)V", "spanStatus", "<init>", "(Lhg0/c;Ljava/lang/String;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private c parentSpan;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String spanName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int spanStatus;

    public c() {
        this(null, null, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final c getParentSpan() {
        return this.parentSpan;
    }

    /* renamed from: b, reason: from getter */
    public final String getSpanName() {
        return this.spanName;
    }

    /* renamed from: c, reason: from getter */
    public final int getSpanStatus() {
        return this.spanStatus;
    }

    public final boolean d() {
        return this.parentSpan == null;
    }

    public final c e(String spanName) {
        if (Intrinsics.areEqual(this.spanName, spanName)) {
            return this;
        }
        c cVar = this.parentSpan;
        if (cVar != null) {
            return cVar.e(spanName);
        }
        return null;
    }

    public final void f(int i3) {
        this.spanStatus = i3;
    }

    public int hashCode() {
        c cVar = this.parentSpan;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        String str = this.spanName;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.spanStatus;
    }

    public String toString() {
        return "spanName = " + this.spanName + " spanStatus = " + this.spanStatus;
    }

    public c(c cVar, String str, int i3) {
        this.parentSpan = cVar;
        this.spanName = str;
        this.spanStatus = i3;
    }

    public /* synthetic */ c(c cVar, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : cVar, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? 0 : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        return Intrinsics.areEqual(this.parentSpan, cVar.parentSpan) && Intrinsics.areEqual(this.spanName, cVar.spanName) && this.spanStatus == cVar.spanStatus;
    }
}
