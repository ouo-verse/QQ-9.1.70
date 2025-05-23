package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePremier;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.upload.task.UploadTask;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u000bB\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ai;", "", "", "soPath", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ai$a;", "callback", "", "d", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ai$b;", "c", "jniPath", "b", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ai {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ai f228560a = new ai();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ai$a;", "", "", "code", "", "errMsg", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface a {
        void a(int code, @Nullable String errMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ai$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "code", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "<init>", "(ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.core.logic.trtc.ai$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class LoadSoPathResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int code;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String msg;

        public LoadSoPathResult() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        /* renamed from: a, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadSoPathResult)) {
                return false;
            }
            LoadSoPathResult loadSoPathResult = (LoadSoPathResult) other;
            if (this.code == loadSoPathResult.code && Intrinsics.areEqual(this.msg, loadSoPathResult.msg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.code * 31) + this.msg.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadSoPathResult(code=" + this.code + ", msg=" + this.msg + ")";
        }

        public LoadSoPathResult(int i3, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.code = i3;
            this.msg = msg2;
        }

        public /* synthetic */ LoadSoPathResult(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/trtc/ai$c", "Lcom/tencent/live2/V2TXLivePremier$V2TXLivePremierObserver;", "", "level", "", "log", "", "onLog", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends V2TXLivePremier.V2TXLivePremierObserver {
        c() {
        }

        @Override // com.tencent.live2.V2TXLivePremier.V2TXLivePremierObserver
        public void onLog(int level, @NotNull String log) {
            Intrinsics.checkNotNullParameter(log, "log");
            if (QLog.isColorLevel()) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("TRTC.GuildAudioRoom", 2, " " + level + UploadTask.REPORT_MSG_DIVIDER + log);
                    return;
                }
                return;
            }
            if (level >= 2) {
                Logger.f235387a.d().i("TRTC.GuildAudioRoom", 1, " " + level + UploadTask.REPORT_MSG_DIVIDER + log);
            }
        }
    }

    ai() {
    }

    private final void b(String jniPath) {
        com.tencent.mobileqq.guild.media.core.w.b("TRTCSoLoadHelper", "init");
        Logger logger = Logger.f235387a;
        logger.d().d("TRTCSoLoadHelper", 1, "[initTRTC] setLibraryPath: " + jniPath);
        logger.d().d("TRTCSoLoadHelper", 1, "[initTRTC] setLibraryPath file list: " + Arrays.toString(new File(jniPath).list()));
        com.tencent.mobileqq.guild.media.core.w.b("TRTCSoLoadHelper", "setLibraryPath");
        TXLiveBase.setLibraryPath(jniPath);
        com.tencent.mobileqq.guild.media.core.w.a("TRTCSoLoadHelper", "setLibraryPath");
        V2TXLiveDef.V2TXLiveLogConfig v2TXLiveLogConfig = new V2TXLiveDef.V2TXLiveLogConfig();
        v2TXLiveLogConfig.enableObserver = true;
        v2TXLiveLogConfig.logLevel = 0;
        v2TXLiveLogConfig.enableConsole = false;
        v2TXLiveLogConfig.enableLogFile = false;
        V2TXLivePremier.setLogConfig(v2TXLiveLogConfig);
        V2TXLivePremier.setObserver(new c());
        com.tencent.mobileqq.guild.media.core.w.a("TRTCSoLoadHelper", "init");
    }

    private final LoadSoPathResult c(String soPath) {
        String str;
        int i3;
        if (TextUtils.isEmpty(soPath)) {
            i3 = 5;
            str = ImageTaskConst.ErrorDesciption.IMAGE_TASK_NO_SUCH_FILE_DESC;
        } else {
            boolean areEqual = Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
            int priority = Thread.currentThread().getPriority();
            int threadPriority = Process.getThreadPriority(Process.myTid());
            Logger.f235387a.d().d("TRTCSoLoadHelper", 1, "[loadSoPath] loadSoPath, isMainThread: " + areEqual + ", oldThreadPriority: " + priority + ", oldProcessThreadPriority: " + threadPriority);
            if (!areEqual) {
                try {
                    Thread.currentThread().setPriority(10);
                    Process.setThreadPriority(-19);
                } catch (Throwable th5) {
                    try {
                        String message = th5.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        str = message;
                        i3 = 6;
                    } finally {
                        if (!areEqual) {
                            Thread.currentThread().setPriority(priority);
                            Process.setThreadPriority(threadPriority);
                        }
                    }
                }
            }
            b(soPath);
            if (!areEqual) {
                Thread.currentThread().setPriority(priority);
                Process.setThreadPriority(threadPriority);
            }
            i3 = 0;
            str = "";
        }
        return new LoadSoPathResult(i3, str);
    }

    @JvmStatic
    public static final void d(@NotNull final String soPath, @NotNull final a callback) {
        Intrinsics.checkNotNullParameter(soPath, "soPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TextUtils.isEmpty(soPath)) {
            LoadSoPathResult c16 = f228560a.c(soPath);
            callback.a(c16.getCode(), c16.getMsg());
        } else {
            SoLoad.load(SoLoad.BIZ_TRTC_QQCHANNEL, SoLoadConstants.SONAME_TRTC, new SoLoad.LoadCallback() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.ah
                @Override // com.tencent.mobileqq.soload.api.SoLoad.LoadCallback
                public final void onLoad(boolean z16, String str, String str2) {
                    ai.e(soPath, callback, z16, str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String soPath, a callback, boolean z16, String errMsg, String str) {
        Intrinsics.checkNotNullParameter(soPath, "$soPath");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Logger.f235387a.d().d("TRTCSoLoadHelper", 1, "[prepare] onLoadResult isSuccess:" + z16 + ", " + str);
        if (z16) {
            ai aiVar = f228560a;
            if (str != null) {
                soPath = str;
            }
            LoadSoPathResult c16 = aiVar.c(soPath);
            callback.a(c16.getCode(), c16.getMsg());
            return;
        }
        callback.a(-1, "so_LoadFail: " + errMsg);
    }
}
