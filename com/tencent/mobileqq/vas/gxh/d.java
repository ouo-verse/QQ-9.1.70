package com.tencent.mobileqq.vas.gxh;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.report.VasJsbCommonReport;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import cooperation.qzone.QzoneIPCModule;
import eipc.EIPCCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ&\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/d;", "", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "", "id", "type", "", "d", "g", "", "isVoice", "a", "forceRequest", "Leipc/EIPCCallback;", "callback", "b", "stage", QzoneIPCModule.RESULT_CODE, "c", "f", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "e", "()Lcom/tencent/mobileqq/vas/report/VasJsbCommonReport;", "report", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VasJsbCommonReport report = VasJsbCommonReport.INSTANCE;

    public final void a(@NotNull String setKey, int id5, boolean isVoice) {
        String str;
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        if (isVoice) {
            VipMMKV.INSTANCE.getCommon(str).encodeInt(AppConstants.Preferences.SVIP_BUBBLE_VOICE_PRINT_ID, id5);
        } else {
            VipMMKV.INSTANCE.getCommon(str).encodeInt(AppConstants.Preferences.SVIP_BUBBLE_ID, id5);
        }
        f(setKey, String.valueOf(id5));
    }

    public final void b(@NotNull String setKey, boolean forceRequest, @Nullable EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        VasUtil.getService().getJsbCallManager().getCardInfo(callback, forceRequest);
        VasJsbCommonReport.TimeRecord timeRecord = this.report.getMSetKeyToStartTime().get(setKey);
        if (timeRecord == null) {
            return;
        }
        timeRecord.setSetupTime(System.currentTimeMillis());
    }

    public final void c(@NotNull String setKey, int id5, int stage, int resultCode) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        VasJsbCommonReport.TimeRecord timeRecord = this.report.getMSetKeyToStartTime().get(setKey);
        if (timeRecord == null) {
            return;
        }
        if (resultCode == 0) {
            this.report.reportSingleStepSuccess(setKey, String.valueOf(id5), System.currentTimeMillis() - timeRecord.getSetupTime(), stage);
            f(setKey, String.valueOf(id5));
        } else {
            this.report.reportSingleStepFail(setKey, String.valueOf(id5), System.currentTimeMillis() - timeRecord.getSetupTime(), stage, resultCode);
            this.report.reportSetEndSetFail(setKey, String.valueOf(id5), System.currentTimeMillis() - timeRecord.getFirstQueryTime(), resultCode);
        }
    }

    public final void d(@NotNull String setKey, int id5, int type) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        VasUtil.getService().getJsbCallManager().saveFont(id5, type);
        f(setKey, String.valueOf(id5));
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final VasJsbCommonReport getReport() {
        return this.report;
    }

    public final void f(@NotNull String setKey, @NotNull String id5) {
        long j3;
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        Intrinsics.checkNotNullParameter(id5, "id");
        VasJsbCommonReport vasJsbCommonReport = this.report;
        long currentTimeMillis = System.currentTimeMillis();
        VasJsbCommonReport.TimeRecord timeRecord = this.report.getMSetKeyToStartTime().get(setKey);
        if (timeRecord != null) {
            j3 = timeRecord.getFirstQueryTime();
        } else {
            j3 = 0;
        }
        vasJsbCommonReport.reportSetEndSetSuccess(setKey, id5, currentTimeMillis - j3);
    }

    public final void g(@NotNull String setKey, int id5) {
        Intrinsics.checkNotNullParameter(setKey, "setKey");
        VasUtil.getService().getVasThemeFontApi().switchFont(id5);
        f(setKey, String.valueOf(id5));
    }
}
