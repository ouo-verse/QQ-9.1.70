package com.tencent.widget;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TraceUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String ASYNC_TRACE_BEGIN = "asyncTraceBegin";
    private static final String ASYNC_TRACE_END = "asyncTraceEnd";
    private static final String TRACE_BEGIN = "traceBegin";
    private static final String TRACE_END = "traceEnd";
    public static final long TRACE_TAG_ACTIVITY_MANAGER = 64;
    public static final long TRACE_TAG_ALWAYS = 1;
    public static final long TRACE_TAG_APP = 4096;
    public static final long TRACE_TAG_AUDIO = 256;
    public static final long TRACE_TAG_CAMERA = 1024;
    public static final long TRACE_TAG_DALVIK = 16384;
    public static final long TRACE_TAG_GRAPHICS = 2;
    public static final long TRACE_TAG_HAL = 2048;
    public static final long TRACE_TAG_INPUT = 4;
    public static final long TRACE_TAG_NEVER = 0;
    private static final long TRACE_TAG_NOT_READY = Long.MIN_VALUE;
    public static final long TRACE_TAG_RESOURCES = 8192;
    public static final long TRACE_TAG_RS = 32768;
    public static final long TRACE_TAG_SYNC_MANAGER = 128;
    public static final long TRACE_TAG_VIDEO = 512;
    public static final long TRACE_TAG_VIEW = 8;
    public static final long TRACE_TAG_WEBVIEW = 16;
    public static final long TRACE_TAG_WINDOW_MANAGER = 32;
    public static final boolean USE_TRACE = false;
    private static Method sAsyncTraceBegin;
    private static Method sAsyncTraceEnd;
    private static Method sMethodBegin;
    private static Method sMethodEnd;

    public TraceUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void traceEnd() {
    }

    public static void traceBegin(String str) {
    }

    public static void asyncTraceBegin(long j3, String str, int i3) {
    }

    public static void asyncTraceEnd(long j3, String str, int i3) {
    }
}
