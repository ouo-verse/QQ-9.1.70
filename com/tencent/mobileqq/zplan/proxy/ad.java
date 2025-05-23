package com.tencent.mobileqq.zplan.proxy;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/ad;", "Lzx4/t;", "", "eventId", "", "ext", "", "report", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ad implements zx4.t {

    /* renamed from: b, reason: collision with root package name */
    private static final String f334966b = "QQZplanDatongReportProxy";

    /* renamed from: c, reason: collision with root package name */
    private static final String f334967c = SquareReportConst.APP_KEY;

    @Override // zx4.t
    public void report(String eventId, Map<String, String> ext) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(ext, "ext");
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        Activity resumeActivity = application != null ? application.getResumeActivity() : null;
        QLog.d(f334966b, 4, "report " + eventId + ", " + resumeActivity);
        ext.put(DTParamKey.REPORT_KEY_APPKEY, f334967c);
        VideoReport.reportEvent(eventId, ext);
    }
}
