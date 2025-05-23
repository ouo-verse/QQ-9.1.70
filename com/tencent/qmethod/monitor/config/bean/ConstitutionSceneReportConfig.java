package com.tencent.qmethod.monitor.config.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qmethod/monitor/config/bean/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "apis", "Lcom/tencent/qmethod/monitor/config/bean/b;", "b", "c", "scene", "Ljava/lang/String;", "()Ljava/lang/String;", "module", "<init>", "(Ljava/lang/String;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.qmethod.monitor.config.bean.c, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class ConstitutionSceneReportConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> apis;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ConstitutionSceneConfig> scene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String module;

    public ConstitutionSceneReportConfig(@NotNull String module) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        this.module = module;
        this.apis = new ArrayList();
        this.scene = new ArrayList();
    }

    @NotNull
    public final List<String> a() {
        return this.apis;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getModule() {
        return this.module;
    }

    @NotNull
    public final List<ConstitutionSceneConfig> c() {
        return this.scene;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof ConstitutionSceneReportConfig) || !Intrinsics.areEqual(this.module, ((ConstitutionSceneReportConfig) other).module)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public int hashCode() {
        String str = this.module;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "ConstitutionSceneReportConfig(module=" + this.module + ")";
    }
}
