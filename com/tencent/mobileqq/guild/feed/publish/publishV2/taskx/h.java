package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.guild.data.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\tBA\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R'\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0015\u0010\u0010R*\u0010!\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u001a\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010%R\u0011\u0010(\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", "result", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "", "Lcom/tencent/mobileqq/guild/data/o;", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediumUploadTaskInfo;", "c", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "taskInfoMap", "d", "errorCodeFromService", "firstFailFileId", "Lcom/tencent/mobileqq/guild/data/o;", "()Lcom/tencent/mobileqq/guild/data/o;", "i", "(Lcom/tencent/mobileqq/guild/data/o;)V", "inconsistentTaskInfo", "g", "getDebugSummaryMessage", tl.h.F, "(Ljava/lang/String;)V", "debugSummaryMessage", "()Z", "isSuccess", "<init>", "(ILjava/lang/String;Ljava/util/Map;ILjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String errMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, o> taskInfoMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int errorCodeFromService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String firstFailFileId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private o inconsistentTaskInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String debugSummaryMessage;

    /* JADX WARN: Multi-variable type inference failed */
    public h(int i3, @NotNull String errMsg, @NotNull Map<String, ? extends o> taskInfoMap, int i16, @NotNull String firstFailFileId) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(taskInfoMap, "taskInfoMap");
        Intrinsics.checkNotNullParameter(firstFailFileId, "firstFailFileId");
        this.result = i3;
        this.errMsg = errMsg;
        this.taskInfoMap = taskInfoMap;
        this.errorCodeFromService = i16;
        this.firstFailFileId = firstFailFileId;
        this.debugSummaryMessage = "";
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getErrMsg() {
        return this.errMsg;
    }

    /* renamed from: b, reason: from getter */
    public final int getErrorCodeFromService() {
        return this.errorCodeFromService;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFirstFailFileId() {
        return this.firstFailFileId;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final o getInconsistentTaskInfo() {
        return this.inconsistentTaskInfo;
    }

    /* renamed from: e, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof h)) {
            return false;
        }
        h hVar = (h) other;
        if (this.result == hVar.result && Intrinsics.areEqual(this.errMsg, hVar.errMsg) && Intrinsics.areEqual(this.taskInfoMap, hVar.taskInfoMap) && this.errorCodeFromService == hVar.errorCodeFromService && Intrinsics.areEqual(this.firstFailFileId, hVar.firstFailFileId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Map<String, o> f() {
        return this.taskInfoMap;
    }

    public final boolean g() {
        if (this.result == 0) {
            return true;
        }
        return false;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.debugSummaryMessage = str;
    }

    public int hashCode() {
        return (((((((this.result * 31) + this.errMsg.hashCode()) * 31) + this.taskInfoMap.hashCode()) * 31) + this.errorCodeFromService) * 31) + this.firstFailFileId.hashCode();
    }

    public final void i(@Nullable o oVar) {
        this.inconsistentTaskInfo = oVar;
    }

    @NotNull
    public String toString() {
        String str;
        boolean z16;
        int i3 = this.result;
        String str2 = this.errMsg;
        int i16 = this.errorCodeFromService;
        int size = this.taskInfoMap.size();
        String str3 = this.firstFailFileId;
        o oVar = this.inconsistentTaskInfo;
        if (oVar != null) {
            str = oVar.getFileId();
        } else {
            str = null;
        }
        StringBuilder sb5 = new StringBuilder("{result=" + i3 + ", errMsg=" + str2 + ", errorCodeFromService=" + i16 + ", taskInfoMap.size=" + size + ", firstFailFileId=" + str3 + ", inconsistentTaskInfo.fileId=" + str + "}, ");
        if (this.debugSummaryMessage.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            sb5.append("debugMessage=" + this.debugSummaryMessage);
        } else {
            sb5.append("taskInfoMap.keys=[" + this.taskInfoMap.keySet() + "]");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        return sb6;
    }

    public /* synthetic */ h(int i3, String str, Map map, int i16, String str2, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, map, i16, (i17 & 16) != 0 ? "" : str2);
    }
}
