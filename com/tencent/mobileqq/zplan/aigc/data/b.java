package com.tencent.mobileqq.zplan.aigc.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/b;", "", "", "a", "I", "b", "()I", "c", "(I)V", "type", "", "Ljava/lang/String;", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "extra", "<init>", "(ILjava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String extra;

    public b() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final void c(int i3) {
        this.type = i3;
    }

    public b(int i3, String extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.type = i3;
        this.extra = extra;
    }

    public /* synthetic */ b(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 1 : i3, (i16 & 2) != 0 ? "" : str);
    }
}
