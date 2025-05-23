package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0016\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0003B3\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J;\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000e\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001f\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/p;", "", "", "a", tl.h.F, "", "i", "", "g", "state", "content", "reasonContent", "", "firstDataTimestamp", "firstContentTimestamp", "b", "toString", "hashCode", "other", "equals", "I", "f", "()I", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "c", "e", "J", "getFirstDataTimestamp", "()J", "getFirstContentTimestamp", "<init>", "(ILjava/lang/String;Ljava/lang/String;JJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.p, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class DSSearchData {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final String[] f231704g = {"\u2022", "\u2022\u2022", "\u2022\u2022\u2022"};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int state;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String content;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String reasonContent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long firstDataTimestamp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long firstContentTimestamp;

    public DSSearchData(int i3, @NotNull String content, @NotNull String reasonContent, long j3, long j16) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(reasonContent, "reasonContent");
        this.state = i3;
        this.content = content;
        this.reasonContent = reasonContent;
        this.firstDataTimestamp = j3;
        this.firstContentTimestamp = j16;
    }

    public static /* synthetic */ DSSearchData c(DSSearchData dSSearchData, int i3, String str, String str2, long j3, long j16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = dSSearchData.state;
        }
        if ((i16 & 2) != 0) {
            str = dSSearchData.content;
        }
        String str3 = str;
        if ((i16 & 4) != 0) {
            str2 = dSSearchData.reasonContent;
        }
        String str4 = str2;
        if ((i16 & 8) != 0) {
            j3 = dSSearchData.firstDataTimestamp;
        }
        long j17 = j3;
        if ((i16 & 16) != 0) {
            j16 = dSSearchData.firstContentTimestamp;
        }
        return dSSearchData.b(i3, str3, str4, j17, j16);
    }

    @NotNull
    public final String a() {
        String str;
        int uptimeMillis = ((int) (SystemClock.uptimeMillis() - this.firstDataTimestamp)) / 500;
        String[] strArr = f231704g;
        int length = uptimeMillis % strArr.length;
        String str2 = this.content;
        if (this.state == 4) {
            str = strArr[length];
        } else {
            str = "";
        }
        return str2 + str;
    }

    @NotNull
    public final DSSearchData b(int state, @NotNull String content, @NotNull String reasonContent, long firstDataTimestamp, long firstContentTimestamp) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(reasonContent, "reasonContent");
        return new DSSearchData(state, content, reasonContent, firstDataTimestamp, firstContentTimestamp);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getReasonContent() {
        return this.reasonContent;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DSSearchData)) {
            return false;
        }
        DSSearchData dSSearchData = (DSSearchData) other;
        if (this.state == dSSearchData.state && Intrinsics.areEqual(this.content, dSSearchData.content) && Intrinsics.areEqual(this.reasonContent, dSSearchData.reasonContent) && this.firstDataTimestamp == dSSearchData.firstDataTimestamp && this.firstContentTimestamp == dSSearchData.firstContentTimestamp) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getState() {
        return this.state;
    }

    public final boolean g() {
        int i3 = this.state;
        if (i3 != 5 && i3 != 6 && i3 != 8 && i3 != 7) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String h() {
        String str;
        int uptimeMillis = ((int) (SystemClock.uptimeMillis() - this.firstDataTimestamp)) / 500;
        String[] strArr = f231704g;
        int length = uptimeMillis % strArr.length;
        String str2 = this.reasonContent;
        if (this.state == 2) {
            str = strArr[length];
        } else {
            str = "";
        }
        return str2 + str;
    }

    public int hashCode() {
        return (((((((this.state * 31) + this.content.hashCode()) * 31) + this.reasonContent.hashCode()) * 31) + androidx.fragment.app.a.a(this.firstDataTimestamp)) * 31) + androidx.fragment.app.a.a(this.firstContentTimestamp);
    }

    public final int i() {
        int roundToInt;
        int roundToInt2;
        long j3 = this.firstDataTimestamp;
        if (j3 == 0) {
            return 0;
        }
        if (this.firstContentTimestamp >= j3) {
            roundToInt2 = MathKt__MathJVMKt.roundToInt((r2 - j3) / 1000.0d);
            return roundToInt2;
        }
        roundToInt = MathKt__MathJVMKt.roundToInt((SystemClock.uptimeMillis() - this.firstDataTimestamp) / 1000.0d);
        return roundToInt;
    }

    @NotNull
    public String toString() {
        return "DSSearchData(state=" + this.state + ", content=" + this.content + ", reasonContent=" + this.reasonContent + ", firstDataTimestamp=" + this.firstDataTimestamp + ", firstContentTimestamp=" + this.firstContentTimestamp + ")";
    }

    public /* synthetic */ DSSearchData(int i3, String str, String str2, long j3, long j16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, (i16 & 8) != 0 ? 0L : j3, (i16 & 16) != 0 ? 0L : j16);
    }
}
