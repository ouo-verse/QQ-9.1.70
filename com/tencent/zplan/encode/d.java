package com.tencent.zplan.encode;

import android.util.Log;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\f\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007J \u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007J \u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007J(\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0002R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/zplan/encode/d;", "", "", "f", "", "tag", "", "usr", ReportConstant.COSTREPORT_PREFIX, "", "a", "e", "b", "msgString", "", ReportConstant.COSTREPORT_TRANS, "c", "d", "Z", "getEnableDebugLog", "()Z", "setEnableDebugLog", "(Z)V", "enableDebugLog", "<init>", "()V", "hardware_encode_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f385329a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean enableDebugLog;

    d() {
    }

    @JvmStatic
    public static final void a(String tag, int usr, String s16) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(s16, "s");
        if (enableDebugLog) {
            Log.d(Intrinsics.stringPlus("mp4Helper-", tag), s16);
        }
    }

    @JvmStatic
    public static final void b(String tag, int usr, String s16) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(s16, "s");
        Log.e(Intrinsics.stringPlus("mp4Helper-", tag), s16);
    }

    @JvmStatic
    public static final void c(String tag, int usr, String msgString, Throwable tr5) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msgString, "msgString");
        Intrinsics.checkParameterIsNotNull(tr5, "tr");
        Log.e(Intrinsics.stringPlus("mp4Helper-", tag), Intrinsics.stringPlus(msgString, f385329a.d(tr5)));
    }

    private final String d(Throwable e16) {
        String stackTraceString = Log.getStackTraceString(e16);
        Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "getStackTraceString(e)");
        return stackTraceString;
    }

    @JvmStatic
    public static final void e(String tag, int usr, String s16) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(s16, "s");
        if (enableDebugLog) {
            Log.i(Intrinsics.stringPlus("mp4Helper-", tag), s16);
        }
    }

    @JvmStatic
    public static final boolean f() {
        return true;
    }
}
