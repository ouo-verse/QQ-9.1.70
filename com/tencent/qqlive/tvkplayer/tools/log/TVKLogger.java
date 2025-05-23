package com.tencent.qqlive.tvkplayer.tools.log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLogger implements ITVKLogger {

    @NonNull
    private final String mModuleName;

    @Nullable
    private TVKContext mTVKContext;

    public TVKLogger(@Nullable TVKContext tVKContext, @NonNull String str) {
        this.mTVKContext = tVKContext;
        this.mModuleName = str;
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public void debug(String str, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            TVKLogUtil.d(getTag(), String.format(Locale.getDefault(), str, objArr));
        } else {
            TVKLogUtil.d(getTag(), str);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public void error(String str, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            TVKLogUtil.e(getTag(), String.format(Locale.getDefault(), str, objArr));
        } else {
            TVKLogUtil.e(getTag(), str);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public String getTag() {
        if (this.mTVKContext == null) {
            return "TVKPlayer_" + this.mModuleName;
        }
        return "TVKPlayer_C" + this.mTVKContext.getInstanceID() + "_T" + this.mTVKContext.getSequence() + "_" + this.mModuleName;
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public void info(String str, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            TVKLogUtil.i(getTag(), String.format(Locale.getDefault(), str, objArr));
        } else {
            TVKLogUtil.i(getTag(), str);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public void printException(Throwable th5) {
        TVKLogUtil.e(getTag(), th5);
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public void verbose(String str, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            TVKLogUtil.v(getTag(), String.format(Locale.getDefault(), str, objArr));
        } else {
            TVKLogUtil.v(getTag(), str);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public void warn(String str, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            TVKLogUtil.w(getTag(), String.format(Locale.getDefault(), str, objArr));
        } else {
            TVKLogUtil.w(getTag(), str);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public void debug(String str, String str2, Object... objArr) {
        debug(str + str2, objArr);
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public void error(String str, String str2, Object... objArr) {
        error(str + str2, objArr);
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public void info(String str, String str2, Object... objArr) {
        info(str + str2, objArr);
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public void verbose(String str, String str2, Object... objArr) {
        verbose(str + str2, objArr);
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger
    public void warn(String str, String str2, Object... objArr) {
        warn(str + str2, objArr);
    }
}
