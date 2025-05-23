package com.tencent.qqmini.miniapp.util.logmonitor;

import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LogCatCmd {
    private static final List<String> DEFAULT_COMMAND;
    private static LogCatCmd mInstance;
    private List<String> commandLine = new ArrayList(DEFAULT_COMMAND);

    static {
        ArrayList arrayList = new ArrayList();
        DEFAULT_COMMAND = arrayList;
        mInstance = null;
        arrayList.add("logcat");
    }

    LogCatCmd() {
    }

    public static LogCatCmd getInstance() {
        if (mInstance == null) {
            mInstance = new LogCatCmd();
        }
        return mInstance;
    }

    @CheckResult
    public LogCatCmd clear() {
        this.commandLine.add(LogCmdOptions.CLEAR);
        return this;
    }

    public Process commit() {
        Process process;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                List<String> list = this.commandLine;
                process = RuntimeMonitor.exec(runtime, (String[]) list.toArray(new String[list.size()]));
            } catch (IOException e16) {
                e16.printStackTrace();
                this.commandLine = new ArrayList(DEFAULT_COMMAND);
                process = null;
            }
            return process;
        } finally {
            this.commandLine = new ArrayList(DEFAULT_COMMAND);
        }
    }

    @CheckResult
    public LogCatCmd filter(@NonNull String str) {
        return filter(str, "V");
    }

    public LogCatCmd options(String str) {
        this.commandLine.add(str);
        return this;
    }

    public LogCatCmd recentLines(@IntRange(from = 0) int i3) {
        this.commandLine.add(Argument.DURATION);
        this.commandLine.add(String.valueOf(i3));
        return this;
    }

    @CheckResult
    public LogCatCmd withTime() {
        this.commandLine.add("-v");
        this.commandLine.add("time");
        return this;
    }

    @CheckResult
    public LogCatCmd filter(@Nullable String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.commandLine.add(str.trim() + ":" + str2);
            this.commandLine.add("*:S");
        } else {
            this.commandLine.add("*:" + str2);
        }
        return this;
    }
}
