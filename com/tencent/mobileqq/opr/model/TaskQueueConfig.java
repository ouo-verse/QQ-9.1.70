package com.tencent.mobileqq.opr.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = true, allMethods = false)
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u00c6\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/opr/model/TaskQueueConfig;", "", "workTime", "", "pauseTime", "thermalConfig", "", "Lcom/tencent/mobileqq/opr/model/ThermalPauseTimeConfig;", "(IILjava/util/List;)V", "getPauseTime", "()I", "getThermalConfig", "()Ljava/util/List;", "getWorkTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "opr_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class TaskQueueConfig {
    static IPatchRedirector $redirector_;

    @SerializedName("pauseTimeInSeconds")
    private final int pauseTime;

    @SerializedName("thermalConfig")
    @Nullable
    private final List<ThermalPauseTimeConfig> thermalConfig;

    @SerializedName("workTimeInSeconds")
    private final int workTime;

    public TaskQueueConfig() {
        this(0, 0, null, 7, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskQueueConfig copy$default(TaskQueueConfig taskQueueConfig, int i3, int i16, List list, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = taskQueueConfig.workTime;
        }
        if ((i17 & 2) != 0) {
            i16 = taskQueueConfig.pauseTime;
        }
        if ((i17 & 4) != 0) {
            list = taskQueueConfig.thermalConfig;
        }
        return taskQueueConfig.copy(i3, i16, list);
    }

    public final int component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.workTime;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.pauseTime;
    }

    @Nullable
    public final List<ThermalPauseTimeConfig> component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.thermalConfig;
    }

    @NotNull
    public final TaskQueueConfig copy(int workTime, int pauseTime, @Nullable List<ThermalPauseTimeConfig> thermalConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TaskQueueConfig) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(workTime), Integer.valueOf(pauseTime), thermalConfig);
        }
        return new TaskQueueConfig(workTime, pauseTime, thermalConfig);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskQueueConfig)) {
            return false;
        }
        TaskQueueConfig taskQueueConfig = (TaskQueueConfig) other;
        if (this.workTime == taskQueueConfig.workTime && this.pauseTime == taskQueueConfig.pauseTime && Intrinsics.areEqual(this.thermalConfig, taskQueueConfig.thermalConfig)) {
            return true;
        }
        return false;
    }

    public final int getPauseTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.pauseTime;
    }

    @Nullable
    public final List<ThermalPauseTimeConfig> getThermalConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.thermalConfig;
    }

    public final int getWorkTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.workTime;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int i3 = ((this.workTime * 31) + this.pauseTime) * 31;
        List<ThermalPauseTimeConfig> list = this.thermalConfig;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "TaskQueueConfig(workTime=" + this.workTime + ", pauseTime=" + this.pauseTime + ", thermalConfig=" + this.thermalConfig + ')';
    }

    public TaskQueueConfig(int i3, int i16, @Nullable List<ThermalPauseTimeConfig> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), list);
            return;
        }
        this.workTime = i3;
        this.pauseTime = i16;
        this.thermalConfig = list;
    }

    public /* synthetic */ TaskQueueConfig(int i3, int i16, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? Integer.MAX_VALUE : i3, (i17 & 2) != 0 ? 0 : i16, (i17 & 4) != 0 ? null : list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), list, Integer.valueOf(i17), defaultConstructorMarker);
    }
}
