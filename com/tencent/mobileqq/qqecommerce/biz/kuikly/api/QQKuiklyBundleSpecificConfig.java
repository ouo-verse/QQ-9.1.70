package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "resId", "c", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "J", "d", "()J", "setVersion", "(J)V", "version", WadlProxyConsts.EXTRA_DATA, "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.j, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class QQKuiklyBundleSpecificConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String resId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String taskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long version;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String extraData;

    public QQKuiklyBundleSpecificConfig(@NotNull String resId, @Nullable String str, long j3, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        this.resId = resId;
        this.taskId = str;
        this.version = j3;
        this.extraData = str2;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getExtraData() {
        return this.extraData;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getResId() {
        return this.resId;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: d, reason: from getter */
    public final long getVersion() {
        return this.version;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQKuiklyBundleSpecificConfig)) {
            return false;
        }
        QQKuiklyBundleSpecificConfig qQKuiklyBundleSpecificConfig = (QQKuiklyBundleSpecificConfig) other;
        if (Intrinsics.areEqual(this.resId, qQKuiklyBundleSpecificConfig.resId) && Intrinsics.areEqual(this.taskId, qQKuiklyBundleSpecificConfig.taskId) && this.version == qQKuiklyBundleSpecificConfig.version && Intrinsics.areEqual(this.extraData, qQKuiklyBundleSpecificConfig.extraData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.resId.hashCode() * 31;
        String str = this.taskId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int a16 = (((hashCode2 + hashCode) * 31) + androidx.fragment.app.a.a(this.version)) * 31;
        String str2 = this.extraData;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return a16 + i3;
    }

    @NotNull
    public String toString() {
        return "QQKuiklyBundleSpecificConfig(resId=" + this.resId + ", taskId=" + this.taskId + ", version=" + this.version + ", extraData=" + this.extraData + ')';
    }

    public /* synthetic */ QQKuiklyBundleSpecificConfig(String str, String str2, long j3, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? "" : str3);
    }
}
