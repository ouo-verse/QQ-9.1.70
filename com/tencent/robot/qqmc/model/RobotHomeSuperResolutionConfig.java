package com.tencent.robot.qqmc.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.opr.model.ModelConfig;
import com.tencent.mobileqq.opr.model.TaskQueueConfig;
import com.tencent.qne.model.QneInterpreter;
import com.tencent.qne.model.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006("}, d2 = {"Lcom/tencent/robot/qqmc/model/h;", "", "", "model", "", "e", "", "Lcom/tencent/qne/model/QneInterpreter;", "interpreter", "Lcom/tencent/mobileqq/opr/model/ModelConfig;", "modelConfig", "a", "f", "toString", "", "hashCode", "other", "equals", "enable", "Z", "getEnable", "()Z", "supportedBackend", "Ljava/util/List;", "getSupportedBackend", "()Ljava/util/List;", "modelBlackList", "getModelBlackList", "Lcom/tencent/mobileqq/opr/model/TaskQueueConfig;", "taskQueueConfig", "Lcom/tencent/mobileqq/opr/model/TaskQueueConfig;", "d", "()Lcom/tencent/mobileqq/opr/model/TaskQueueConfig;", "onlyDownloadOnWifi", "c", "Lcom/tencent/mobileqq/opr/model/ModelConfig;", "b", "()Lcom/tencent/mobileqq/opr/model/ModelConfig;", "<init>", "(ZLjava/util/List;Ljava/util/List;Lcom/tencent/mobileqq/opr/model/TaskQueueConfig;ZLcom/tencent/mobileqq/opr/model/ModelConfig;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.qqmc.model.h, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotHomeSuperResolutionConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("modelBlackList")
    @NotNull
    private final List<String> modelBlackList;

    @SerializedName("modelConfig")
    @NotNull
    private final ModelConfig modelConfig;

    @SerializedName("onlyDownloadOnWifi")
    private final boolean onlyDownloadOnWifi;

    @SerializedName("supportedBackend")
    @NotNull
    private final List<String> supportedBackend;

    @SerializedName("taskQueueConfig")
    @NotNull
    private final TaskQueueConfig taskQueueConfig;

    public RobotHomeSuperResolutionConfig() {
        this(false, null, null, null, false, null, 63, null);
    }

    private final boolean a(List<String> list, QneInterpreter qneInterpreter, ModelConfig modelConfig) {
        com.tencent.qne.model.a a16;
        com.tencent.qne.model.f c16;
        if (modelConfig.getEnableLocalNPU() && (c16 = qneInterpreter.c()) != null && list.contains(c16.b())) {
            return true;
        }
        if (modelConfig.getEnableLocalCPUAndGPU() && (a16 = qneInterpreter.a()) != null && list.contains(a16.b())) {
            return true;
        }
        return false;
    }

    private final boolean e(String model) {
        Object obj;
        boolean equals;
        if (!this.modelBlackList.isEmpty()) {
            Iterator<T> it = this.modelBlackList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    equals = StringsKt__StringsJVMKt.equals((String) obj, model, true);
                    if (equals) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ModelConfig getModelConfig() {
        return this.modelConfig;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getOnlyDownloadOnWifi() {
        return this.onlyDownloadOnWifi;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final TaskQueueConfig getTaskQueueConfig() {
        return this.taskQueueConfig;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotHomeSuperResolutionConfig)) {
            return false;
        }
        RobotHomeSuperResolutionConfig robotHomeSuperResolutionConfig = (RobotHomeSuperResolutionConfig) other;
        if (this.enable == robotHomeSuperResolutionConfig.enable && Intrinsics.areEqual(this.supportedBackend, robotHomeSuperResolutionConfig.supportedBackend) && Intrinsics.areEqual(this.modelBlackList, robotHomeSuperResolutionConfig.modelBlackList) && Intrinsics.areEqual(this.taskQueueConfig, robotHomeSuperResolutionConfig.taskQueueConfig) && this.onlyDownloadOnWifi == robotHomeSuperResolutionConfig.onlyDownloadOnWifi && Intrinsics.areEqual(this.modelConfig, robotHomeSuperResolutionConfig.modelConfig)) {
            return true;
        }
        return false;
    }

    public final boolean f(@NotNull QneInterpreter interpreter) {
        Intrinsics.checkNotNullParameter(interpreter, "interpreter");
        if (!this.enable || e(interpreter.b())) {
            return false;
        }
        return a(this.supportedBackend, interpreter, this.modelConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean z16 = this.enable;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode = ((((((r06 * 31) + this.supportedBackend.hashCode()) * 31) + this.modelBlackList.hashCode()) * 31) + this.taskQueueConfig.hashCode()) * 31;
        boolean z17 = this.onlyDownloadOnWifi;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((hashCode + i3) * 31) + this.modelConfig.hashCode();
    }

    @NotNull
    public String toString() {
        return "RobotHomeSuperResolutionConfig(enable=" + this.enable + ", supportedBackend=" + this.supportedBackend + ", modelBlackList=" + this.modelBlackList + ", taskQueueConfig=" + this.taskQueueConfig + ", onlyDownloadOnWifi=" + this.onlyDownloadOnWifi + ", modelConfig=" + this.modelConfig + ")";
    }

    public RobotHomeSuperResolutionConfig(boolean z16, @NotNull List<String> supportedBackend, @NotNull List<String> modelBlackList, @NotNull TaskQueueConfig taskQueueConfig, boolean z17, @NotNull ModelConfig modelConfig) {
        Intrinsics.checkNotNullParameter(supportedBackend, "supportedBackend");
        Intrinsics.checkNotNullParameter(modelBlackList, "modelBlackList");
        Intrinsics.checkNotNullParameter(taskQueueConfig, "taskQueueConfig");
        Intrinsics.checkNotNullParameter(modelConfig, "modelConfig");
        this.enable = z16;
        this.supportedBackend = supportedBackend;
        this.modelBlackList = modelBlackList;
        this.taskQueueConfig = taskQueueConfig;
        this.onlyDownloadOnWifi = z17;
        this.modelConfig = modelConfig;
    }

    public /* synthetic */ RobotHomeSuperResolutionConfig(boolean z16, List list, List list2, TaskQueueConfig taskQueueConfig, boolean z17, ModelConfig modelConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{f.d.f344357i.b(), f.e.f344358i.b(), f.C9348f.f344359i.b(), f.b.f344355i.b()}) : list, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 8) != 0 ? new TaskQueueConfig(0, 0, null, 7, null) : taskQueueConfig, (i3 & 16) == 0 ? z17 : true, (i3 & 32) != 0 ? new ModelConfig("realesr_x2v3", 1, 2, 288, true, false) : modelConfig);
    }
}
