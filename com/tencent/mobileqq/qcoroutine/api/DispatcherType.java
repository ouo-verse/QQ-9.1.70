package com.tencent.mobileqq.qcoroutine.api;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/DispatcherType;", "", "(Ljava/lang/String;I)V", "MAIN", PreDownloadConstants.RPORT_KEY_CPU, "IO", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class DispatcherType {
    private static final /* synthetic */ DispatcherType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final DispatcherType CPU;
    public static final DispatcherType IO;
    public static final DispatcherType MAIN;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(AppConstants.VALUE.UIN_TYPE_SERVICE_ACCOUNT_FOLDER);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        DispatcherType dispatcherType = new DispatcherType("MAIN", 0);
        MAIN = dispatcherType;
        DispatcherType dispatcherType2 = new DispatcherType(PreDownloadConstants.RPORT_KEY_CPU, 1);
        CPU = dispatcherType2;
        DispatcherType dispatcherType3 = new DispatcherType("IO", 2);
        IO = dispatcherType3;
        $VALUES = new DispatcherType[]{dispatcherType, dispatcherType2, dispatcherType3};
    }

    DispatcherType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    public static DispatcherType valueOf(String str) {
        return (DispatcherType) Enum.valueOf(DispatcherType.class, str);
    }

    public static DispatcherType[] values() {
        return (DispatcherType[]) $VALUES.clone();
    }
}
