package com.tencent.biz.qqcircle.comment.recpic;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/an;", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "Z", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Z", "status", "b", "I", "getReason", "()I", "reason", "c", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "scene", "<init>", "(ZILjava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.comment.recpic.an, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class RestartScanResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int reason;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String scene;

    public RestartScanResult(boolean z16, int i3, @NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.status = z16;
        this.reason = i3;
        this.scene = scene;
    }

    @NotNull
    public final String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", this.status);
        jSONObject.put("reason", this.reason);
        jSONObject.put("scene", this.scene);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ene)\n        }.toString()");
        return jSONObject2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestartScanResult)) {
            return false;
        }
        RestartScanResult restartScanResult = (RestartScanResult) other;
        if (this.status == restartScanResult.status && this.reason == restartScanResult.reason && Intrinsics.areEqual(this.scene, restartScanResult.scene)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.status;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.reason) * 31) + this.scene.hashCode();
    }

    @NotNull
    public String toString() {
        return "RestartScanResult(status=" + this.status + ", reason=" + this.reason + ", scene=" + this.scene + ")";
    }
}
