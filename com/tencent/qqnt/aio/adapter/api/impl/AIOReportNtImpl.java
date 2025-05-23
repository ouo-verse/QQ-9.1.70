package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOReport;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J@\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOReportNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOReport;", "", "bigT", "", "reportBigT", "", "entry", "result", "r1", "r2", "r3", "r4", "event", "", "params", "reportBeacon", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "reportRobot", "<init>", "()V", "Companion", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOReportNtImpl implements IAIOReport {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AIOReportFallback";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOReportNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOReportNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30886);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOReportNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    @NotNull
    public String currentMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return IAIOReport.a.a(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    public void reportArkExpo(int i3, @Nullable Integer num, @NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), num, msgRecord);
        } else {
            IAIOReport.a.b(this, i3, num, msgRecord);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    public void reportBeacon(@NotNull String event, @NotNull Map<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) event, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i(TAG, 1, "[reportBeacon] event=" + event + " params=" + params);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    public void reportBigT(@NotNull String bigT) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bigT);
            return;
        }
        Intrinsics.checkNotNullParameter(bigT, "bigT");
        QLog.i(TAG, 1, "[reportBigT] bigT=" + bigT);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    public void reportRobot(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        QLog.i(TAG, 1, "[reportRobot] msgRecord " + msgRecord.msgId + " chatType " + msgRecord.chatType);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOReport
    public void reportBigT(@NotNull String bigT, int entry, int result, @NotNull String r16, @NotNull String r26, @NotNull String r36, @NotNull String r46) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bigT, Integer.valueOf(entry), Integer.valueOf(result), r16, r26, r36, r46);
            return;
        }
        Intrinsics.checkNotNullParameter(bigT, "bigT");
        Intrinsics.checkNotNullParameter(r16, "r1");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r36, "r3");
        Intrinsics.checkNotNullParameter(r46, "r4");
        QLog.i(TAG, 1, "[reportBigT] bigT=" + bigT + ", entry=" + entry + ", result=" + result + "r1=" + r16 + ", r2=" + r26 + ", r3=" + r36 + ", r4=" + r46);
    }
}
