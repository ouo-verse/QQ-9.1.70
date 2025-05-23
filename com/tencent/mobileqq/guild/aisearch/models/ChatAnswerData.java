package com.tencent.mobileqq.guild.aisearch.models;

import android.os.SystemClock;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0003BC\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\u0002H\u0016JE\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u00c6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0011\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b\"\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/e;", "", "", "a", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "j", "i", "toString", "state", "content", "reasonContent", "", "firstDataTimestamp", "firstContentTimestamp", "dataTimestamp", "b", "hashCode", "other", "equals", "I", tl.h.F, "()I", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "c", "g", "J", "f", "()J", "e", "getFirstContentTimestamp", "<init>", "(ILjava/lang/String;Ljava/lang/String;JJJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.aisearch.models.e, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class ChatAnswerData {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final String[] f214136h = {"\u2022", "\u2022\u2022", "\u2022\u2022\u2022"};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int state;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String content;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String reasonContent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long firstDataTimestamp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long firstContentTimestamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long dataTimestamp;

    public ChatAnswerData() {
        this(0, null, null, 0L, 0L, 0L, 63, null);
    }

    public static /* synthetic */ ChatAnswerData c(ChatAnswerData chatAnswerData, int i3, String str, String str2, long j3, long j16, long j17, int i16, Object obj) {
        int i17;
        String str3;
        String str4;
        long j18;
        long j19;
        long j26;
        if ((i16 & 1) != 0) {
            i17 = chatAnswerData.state;
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            str3 = chatAnswerData.content;
        } else {
            str3 = str;
        }
        if ((i16 & 4) != 0) {
            str4 = chatAnswerData.reasonContent;
        } else {
            str4 = str2;
        }
        if ((i16 & 8) != 0) {
            j18 = chatAnswerData.firstDataTimestamp;
        } else {
            j18 = j3;
        }
        if ((i16 & 16) != 0) {
            j19 = chatAnswerData.firstContentTimestamp;
        } else {
            j19 = j16;
        }
        if ((i16 & 32) != 0) {
            j26 = chatAnswerData.dataTimestamp;
        } else {
            j26 = j17;
        }
        return chatAnswerData.b(i17, str3, str4, j18, j19, j26);
    }

    @NotNull
    public final String a() {
        String str;
        int uptimeMillis = ((int) (SystemClock.uptimeMillis() - this.firstDataTimestamp)) / 500;
        String[] strArr = f214136h;
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
    public final ChatAnswerData b(int state, @NotNull String content, @NotNull String reasonContent, long firstDataTimestamp, long firstContentTimestamp, long dataTimestamp) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(reasonContent, "reasonContent");
        return new ChatAnswerData(state, content, reasonContent, firstDataTimestamp, firstContentTimestamp, dataTimestamp);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: e, reason: from getter */
    public final long getDataTimestamp() {
        return this.dataTimestamp;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatAnswerData)) {
            return false;
        }
        ChatAnswerData chatAnswerData = (ChatAnswerData) other;
        if (this.state == chatAnswerData.state && Intrinsics.areEqual(this.content, chatAnswerData.content) && Intrinsics.areEqual(this.reasonContent, chatAnswerData.reasonContent) && this.firstDataTimestamp == chatAnswerData.firstDataTimestamp && this.firstContentTimestamp == chatAnswerData.firstContentTimestamp && this.dataTimestamp == chatAnswerData.dataTimestamp) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getFirstDataTimestamp() {
        return this.firstDataTimestamp;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getReasonContent() {
        return this.reasonContent;
    }

    /* renamed from: h, reason: from getter */
    public final int getState() {
        return this.state;
    }

    public int hashCode() {
        return (((((((((this.state * 31) + this.content.hashCode()) * 31) + this.reasonContent.hashCode()) * 31) + androidx.fragment.app.a.a(this.firstDataTimestamp)) * 31) + androidx.fragment.app.a.a(this.firstContentTimestamp)) * 31) + androidx.fragment.app.a.a(this.dataTimestamp);
    }

    public final boolean i() {
        int i3 = this.state;
        if (i3 != 6 && i3 != 8 && i3 != 7 && i3 != 9 && i3 != 10) {
            return false;
        }
        return true;
    }

    public final boolean j() {
        if (this.state == 1) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        int i3 = this.state;
        if (i3 != 5 && i3 != 6 && i3 != 8 && i3 != 7) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String l() {
        String str;
        int uptimeMillis = ((int) (SystemClock.uptimeMillis() - this.firstDataTimestamp)) / 500;
        String[] strArr = f214136h;
        int length = uptimeMillis % strArr.length;
        String str2 = this.reasonContent;
        if (this.state == 2) {
            str = strArr[length];
        } else {
            str = "";
        }
        return str2 + str;
    }

    public final int m() {
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
        return "ChatAnswerData(state=" + this.state + ", content=" + MiscKt.i(this.content, 0, 1, null) + ", reasonContent=" + MiscKt.i(this.reasonContent, 0, 1, null) + ", firstDataTimestamp=" + this.firstDataTimestamp + ", firstContentTimestamp=" + this.firstContentTimestamp + ")";
    }

    public ChatAnswerData(int i3, @NotNull String content, @NotNull String reasonContent, long j3, long j16, long j17) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(reasonContent, "reasonContent");
        this.state = i3;
        this.content = content;
        this.reasonContent = reasonContent;
        this.firstDataTimestamp = j3;
        this.firstContentTimestamp = j16;
        this.dataTimestamp = j17;
    }

    public /* synthetic */ ChatAnswerData(int i3, String str, String str2, long j3, long j16, long j17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 1 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) == 0 ? str2 : "", (i16 & 8) != 0 ? 0L : j3, (i16 & 16) != 0 ? 0L : j16, (i16 & 32) == 0 ? j17 : 0L);
    }
}
