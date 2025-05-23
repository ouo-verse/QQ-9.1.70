package com.tencent.rmonitor.common.logcat;

import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.rmonitor.common.util.FileUtil;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016R(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/rmonitor/common/logcat/b;", "Lcom/tencent/rmonitor/common/logcat/a;", "", "", "args", "", "a", "([Ljava/lang/String;)V", "b", "[Ljava/lang/String;", "getLogcatArguments", "()[Ljava/lang/String;", "setLogcatArguments", "logcatArguments", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String[] logcatArguments = {Argument.DURATION, "100", "-v", PerfTracer.THREADTIME_TAG};

    @Override // com.tencent.rmonitor.common.logcat.a
    public void a(@Nullable String[] args) {
        if (args == null) {
            args = new String[0];
        }
        this.logcatArguments = args;
    }

    @Override // com.tencent.rmonitor.common.logcat.a
    @Nullable
    public String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("logcat");
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, this.logcatArguments);
        StringBuilder sb5 = new StringBuilder();
        FileUtil.Companion companion = FileUtil.INSTANCE;
        sb5.append(companion.i());
        sb5.append("/logcat/log_");
        sb5.append(System.currentTimeMillis());
        sb5.append(".txt");
        File file = new File(sb5.toString());
        Process process = new ProcessBuilder(new String[0]).command(arrayList).redirectErrorStream(true).start();
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(process, "process");
        InputStream inputStream = process.getInputStream();
        Intrinsics.checkExpressionValueIsNotNull(inputStream, "process.inputStream");
        companion.p(absolutePath, companion.m(inputStream, 8196), false);
        process.destroy();
        return file.getAbsolutePath();
    }
}
