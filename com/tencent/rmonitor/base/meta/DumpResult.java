package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/rmonitor/base/meta/DumpResult;", "", "()V", "hprofFileSize", "", "hprofPath", "", "success", "", "zipFilePath", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final class DumpResult {

    @JvmField
    public long hprofFileSize;

    @JvmField
    public boolean success;

    @JvmField
    @NotNull
    public String zipFilePath = "";

    @JvmField
    @NotNull
    public String hprofPath = "";
}
