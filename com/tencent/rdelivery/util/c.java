package com.tencent.rdelivery.util;

import android.util.Log;
import com.tencent.raft.standard.log.IRLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0013J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J$\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J$\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/rdelivery/util/c;", "", "", "tag", "msg", "", "doPrint", "", "a", "e", "c", "", "throwable", "d", "Lcom/tencent/raft/standard/log/IRLog;", "Lcom/tencent/raft/standard/log/IRLog;", "getIrLog", "()Lcom/tencent/raft/standard/log/IRLog;", "setIrLog", "(Lcom/tencent/raft/standard/log/IRLog;)V", "irLog", "<init>", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IRLog irLog;

    public c(@Nullable IRLog iRLog) {
        this.irLog = iRLog;
    }

    public static /* synthetic */ void b(c cVar, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        cVar.a(str, str2, z16);
    }

    public static /* synthetic */ void f(c cVar, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        cVar.e(str, str2, z16);
    }

    public final void a(@Nullable String tag, @Nullable String msg2, boolean doPrint) {
        if (!doPrint) {
            return;
        }
        IRLog iRLog = this.irLog;
        if (iRLog != null) {
            iRLog.d(tag, msg2);
        } else {
            Log.d(tag, msg2);
        }
    }

    public final void c(@Nullable String tag, @Nullable String msg2) {
        IRLog iRLog = this.irLog;
        if (iRLog != null) {
            iRLog.e(tag, msg2);
        } else {
            Log.e(tag, msg2);
        }
    }

    public final void d(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IRLog iRLog = this.irLog;
        if (iRLog != null) {
            iRLog.e(tag, msg2, throwable);
        } else {
            Log.e(tag, msg2, throwable);
        }
    }

    public final void e(@Nullable String tag, @Nullable String msg2, boolean doPrint) {
        if (!doPrint) {
            return;
        }
        IRLog iRLog = this.irLog;
        if (iRLog != null) {
            iRLog.i(tag, msg2);
        } else {
            Log.i(tag, msg2);
        }
    }
}
