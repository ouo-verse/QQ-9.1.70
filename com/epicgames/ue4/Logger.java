package com.epicgames.ue4;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Logger {
    private static boolean bAllowExceptionLogging = true;
    private static boolean bAllowLogging = true;
    private static boolean bPrependChanged = false;
    private static boolean bPrependSecondaryTag = false;
    private static ILoggerCallback mCallback;
    private boolean bHasSecondaryTag;
    private String mFormattedMessageTag;
    private String mFormattedTag;
    private final String mSecondaryTag;
    private final String mTag;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface ILoggerCallback {
        void LoggerCallback(String str, String str2, String str3);
    }

    public Logger(String str) {
        this(str, "");
    }

    public static void RegisterCallback(ILoggerCallback iLoggerCallback) {
        mCallback = iLoggerCallback;
    }

    public static void SuppressLogs() {
        bAllowExceptionLogging = false;
        bAllowLogging = false;
    }

    private String getFormattedMessage(String str) {
        if (this.bHasSecondaryTag && !bPrependSecondaryTag) {
            if (this.mFormattedMessageTag == null || bPrependChanged) {
                bPrependChanged = false;
                this.mFormattedMessageTag = "[" + this.mSecondaryTag + "] ";
            }
            return this.mFormattedMessageTag + str;
        }
        return str;
    }

    private String getFormattedTag() {
        if (this.mFormattedTag == null || bPrependChanged) {
            bPrependChanged = false;
            if (this.bHasSecondaryTag && bPrependSecondaryTag) {
                this.mFormattedTag = this.mTag + "-" + this.mSecondaryTag;
            } else {
                this.mFormattedTag = this.mTag;
            }
        }
        return this.mFormattedTag;
    }

    public static void prependSecondaryTag(boolean z16) {
        bPrependSecondaryTag = z16;
        bPrependChanged = true;
    }

    public void debug(String str) {
        if (bAllowLogging) {
            Log.d(getFormattedTag(), getFormattedMessage(str));
        }
        ILoggerCallback iLoggerCallback = mCallback;
        if (iLoggerCallback != null) {
            iLoggerCallback.LoggerCallback("D/", getFormattedTag(), getFormattedMessage(str));
        }
    }

    public void error(String str) {
        if (bAllowLogging) {
            Log.e(getFormattedTag(), getFormattedMessage(str));
        }
        ILoggerCallback iLoggerCallback = mCallback;
        if (iLoggerCallback != null) {
            iLoggerCallback.LoggerCallback("E/", getFormattedTag(), getFormattedMessage(str));
        }
    }

    public void verbose(String str) {
        if (bAllowLogging) {
            Log.v(getFormattedTag(), getFormattedMessage(str));
        }
        ILoggerCallback iLoggerCallback = mCallback;
        if (iLoggerCallback != null) {
            iLoggerCallback.LoggerCallback("V/", getFormattedTag(), getFormattedMessage(str));
        }
    }

    public void warn(String str) {
        if (bAllowLogging) {
            Log.w(getFormattedTag(), getFormattedMessage(str));
        }
        ILoggerCallback iLoggerCallback = mCallback;
        if (iLoggerCallback != null) {
            iLoggerCallback.LoggerCallback("W/", getFormattedTag(), getFormattedMessage(str));
        }
    }

    public Logger(String str, String str2) {
        this.mTag = str;
        if (str2 == null) {
            this.mSecondaryTag = "";
        } else {
            this.mSecondaryTag = str2;
        }
        this.bHasSecondaryTag = !TextUtils.isEmpty(this.mSecondaryTag);
    }

    public void error(String str, Throwable th5) {
        if (bAllowLogging) {
            Log.e(getFormattedTag(), getFormattedMessage(str), th5);
        }
        ILoggerCallback iLoggerCallback = mCallback;
        if (iLoggerCallback != null) {
            iLoggerCallback.LoggerCallback("E/", getFormattedTag(), getFormattedMessage(str));
        }
    }
}
