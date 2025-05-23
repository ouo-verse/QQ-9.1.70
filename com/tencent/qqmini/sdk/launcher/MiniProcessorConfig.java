package com.tencent.qqmini.sdk.launcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;

/* loaded from: classes23.dex */
public class MiniProcessorConfig {

    @NonNull
    public final Class<?> appPreLoadClass;

    @NonNull
    public final Class<?> appUIClass;

    @Nullable
    public final Class<?> internalUIClass;

    @NonNull
    public final String processName;

    @NonNull
    public final ProcessType processType;
    public final int supportRuntimeType;

    public MiniProcessorConfig(ProcessType processType, String str, Class cls, Class cls2, Class cls3, int i3) {
        this.processType = processType;
        this.processName = str;
        this.appUIClass = cls;
        this.internalUIClass = cls2;
        this.appPreLoadClass = cls3;
        this.supportRuntimeType = i3;
    }

    public String toString() {
        return "pName:" + this.processName + " pType:" + this.processType + " UI:" + this.appUIClass + " Internal:" + this.internalUIClass + " receiver:" + this.appPreLoadClass + " supportRuntimeType:" + this.supportRuntimeType;
    }
}
