package com.tencent.qqnt.impl;

import android.os.Bundle;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qqnt.ITroopReportApi;
import com.tencent.qqnt.report.TroopCMDReport;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\r\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J&\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J-\u0010\r\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/impl/TroopReportApiImpl;", "Lcom/tencent/qqnt/ITroopReportApi;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "", "troopUin", "from", "", "configTroopCmdReportObj", "req", "", "requestErrorCode", "logicErrorCode", "doTroopCmdReport", "cmdName", "Ljava/io/Serializable;", "createTroopCmdReportObj", "reportObj", "(Ljava/io/Serializable;Ljava/lang/Integer;Ljava/lang/Integer;)V", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class TroopReportApiImpl implements ITroopReportApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String REPORT_OBJ_KEY = "k_troop_cmd_report_obj";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/impl/TroopReportApiImpl$a;", "", "", "REPORT_OBJ_KEY", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.impl.TroopReportApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62188);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ITroopReportApi
    public void configTroopCmdReportObj(@Nullable ToServiceMsg request, @Nullable String troopUin, @Nullable String from) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, request, troopUin, from);
        } else if (request != null && (bundle = request.extraData) != null) {
            bundle.putSerializable("k_troop_cmd_report_obj", new TroopCMDReport(request.getServiceCmd(), troopUin, from));
        }
    }

    @Override // com.tencent.qqnt.ITroopReportApi
    @NotNull
    public Serializable createTroopCmdReportObj(@Nullable String cmdName, @Nullable String troopUin, @Nullable String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Serializable) iPatchRedirector.redirect((short) 4, this, cmdName, troopUin, from);
        }
        return new TroopCMDReport(cmdName, troopUin, from);
    }

    @Override // com.tencent.qqnt.ITroopReportApi
    public void doTroopCmdReport(@Nullable ToServiceMsg req, int requestErrorCode, int logicErrorCode) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, req, Integer.valueOf(requestErrorCode), Integer.valueOf(logicErrorCode));
            return;
        }
        Serializable serializable = (req == null || (bundle = req.extraData) == null) ? null : bundle.getSerializable("k_troop_cmd_report_obj");
        if (serializable instanceof TroopCMDReport) {
            ((TroopCMDReport) serializable).doReport(Integer.valueOf(requestErrorCode), Integer.valueOf(logicErrorCode));
        }
    }

    @Override // com.tencent.qqnt.ITroopReportApi
    public void doTroopCmdReport(@Nullable Serializable reportObj, @Nullable Integer requestErrorCode, @Nullable Integer logicErrorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, reportObj, requestErrorCode, logicErrorCode);
        } else if (reportObj instanceof TroopCMDReport) {
            ((TroopCMDReport) reportObj).doReport(requestErrorCode, logicErrorCode);
        }
    }
}
