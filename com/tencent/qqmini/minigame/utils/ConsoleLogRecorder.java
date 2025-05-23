package com.tencent.qqmini.minigame.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R(\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqmini/minigame/utils/ConsoleLogRecorder;", "", "", "j", "", "Landroid/util/Pair;", "", "k", "i", "l", "level", "msg", h.F, "f", "Ljava/io/File;", "g", "a", "Ljava/io/File;", "mLogFile", "Ljava/util/LinkedList;", "b", "Ljava/util/LinkedList;", "mLogList", "", "c", "Z", "mHasWriteTaskFinished", "<init>", "()V", "d", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class ConsoleLogRecorder {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile File mLogFile;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private LinkedList<Pair<String, String>> mLogList = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mHasWriteTaskFinished = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0005R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqmini/minigame/utils/ConsoleLogRecorder$a;", "", "", "b", "DIR_GAME_CONSOLE_LOG", "Ljava/lang/String;", "FILE_NAME_SUFFIX_CONSOLE_LOG", "", "MAX_SIZE_LOG_FILE", "I", "TAG", "THRESHOLD_SIZE_LIST_IN_MEM", "THRESHOLD_SIZE_TO_WRITE", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.minigame.utils.ConsoleLogRecorder$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b() {
            String substringAfter$default;
            try {
                AppLoaderFactory g16 = AppLoaderFactory.g();
                Intrinsics.checkExpressionValueIsNotNull(g16, "AppLoaderFactory.g()");
                String processName = ProcessUtil.getCurrentProcessName(g16.getContext());
                AppLoaderFactory g17 = AppLoaderFactory.g();
                Intrinsics.checkExpressionValueIsNotNull(g17, "AppLoaderFactory.g()");
                Context context = g17.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "AppLoaderFactory.g().context");
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    QMLog.e("ConsoleLogRecorder", "failed to getExternalCacheDir");
                    return null;
                }
                File file = new File(externalCacheDir, "Tencent/mini/game_console_log");
                if (TextUtils.isEmpty(processName)) {
                    QMLog.e("ConsoleLogRecorder", "invalid params, processName = " + processName);
                    return null;
                }
                StringBuilder sb5 = new StringBuilder();
                Intrinsics.checkExpressionValueIsNotNull(processName, "processName");
                substringAfter$default = StringsKt__StringsKt.substringAfter$default(processName, ":", (String) null, 2, (Object) null);
                sb5.append(substringAfter$default);
                sb5.append("_game_log.txt");
                return new File(file, sb5.toString()).getAbsolutePath();
            } catch (Exception e16) {
                QMLog.e("ConsoleLogRecorder", "buildConsoleLogFilePath failed -->", e16);
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ConsoleLogRecorder() {
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.utils.ConsoleLogRecorder$recreateFileAsync$1
            @Override // java.lang.Runnable
            public final void run() {
                File file;
                String b16;
                boolean z16;
                file = ConsoleLogRecorder.this.mLogFile;
                if (file == null) {
                    b16 = ConsoleLogRecorder.INSTANCE.b();
                    if (b16 != null && b16.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        return;
                    }
                    try {
                        FileUtils.deleteFile(b16);
                        ConsoleLogRecorder.this.mLogFile = FileUtils.createFile(b16);
                    } catch (Exception e16) {
                        QMLog.e("ConsoleLogRecorder", "recreate logFile failed -->", e16);
                    }
                }
            }
        });
    }

    private final void j() {
        if (this.mHasWriteTaskFinished) {
            this.mHasWriteTaskFinished = false;
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized List<Pair<String, String>> k() {
        LinkedList<Pair<String, String>> linkedList;
        linkedList = this.mLogList;
        this.mLogList = new LinkedList<>();
        return linkedList;
    }

    private final void l() {
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.utils.ConsoleLogRecorder$writeConsoleLogAsync$1
            @Override // java.lang.Runnable
            public final void run() {
                File file;
                List<Pair> k3;
                boolean z16;
                file = ConsoleLogRecorder.this.mLogFile;
                if (file != null) {
                    k3 = ConsoleLogRecorder.this.k();
                    if (file.length() < 20971520) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    BufferedOutputStream bufferedOutputStream = null;
                    try {
                        try {
                            try {
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, z16));
                                try {
                                    for (Pair pair : k3) {
                                        String str = '[' + ((String) pair.first) + "] " + ((String) pair.second) + '\n';
                                        Charset charset = Charsets.UTF_8;
                                        if (str != null) {
                                            byte[] bytes = str.getBytes(charset);
                                            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                                            bufferedOutputStream2.write(bytes);
                                        } else {
                                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                        }
                                    }
                                    bufferedOutputStream2.flush();
                                    bufferedOutputStream2.close();
                                } catch (IOException e16) {
                                    e = e16;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    QMLog.e("ConsoleLogRecorder", "writeLog failed -->", e);
                                    if (bufferedOutputStream != null) {
                                        bufferedOutputStream.close();
                                    }
                                    ConsoleLogRecorder.this.mHasWriteTaskFinished = true;
                                    return;
                                } catch (Throwable th5) {
                                    th = th5;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    if (bufferedOutputStream != null) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (IOException e17) {
                                            QMLog.e("ConsoleLogRecorder", "writeLog close stream failed -->", e17);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (IOException e18) {
                            e = e18;
                        }
                    } catch (IOException e19) {
                        QMLog.e("ConsoleLogRecorder", "writeLog close stream failed -->", e19);
                    }
                    ConsoleLogRecorder.this.mHasWriteTaskFinished = true;
                    return;
                }
                QMLog.e("ConsoleLogRecorder", "writeLog file not existed");
                ConsoleLogRecorder.this.i();
                ConsoleLogRecorder.this.mHasWriteTaskFinished = true;
            }
        });
    }

    public final synchronized void f() {
        j();
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final File getMLogFile() {
        return this.mLogFile;
    }

    public final synchronized void h(@NotNull String level, @NotNull String msg2) {
        Intrinsics.checkParameterIsNotNull(level, "level");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        this.mLogList.add(new Pair<>(level, msg2));
        if (this.mLogList.size() >= 20) {
            j();
        }
        if (this.mLogList.size() >= 200) {
            this.mLogList.removeFirst();
        }
    }
}
