package com.tencent.qqnt.aio.helper;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/helper/er;", "", "", "isTroopOwner", "", "b", "a", "", "type", "d", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "c", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class er {

    /* renamed from: a, reason: collision with root package name */
    public static final er f350819a = new er();

    er() {
    }

    public final void a(boolean isTroopOwner) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_qdesign_shareview");
        hashMap.put("eid", "em_group_withdraw");
        if (isTroopOwner) {
            str = "host";
        } else {
            str = "admin";
        }
        hashMap.put("role_type", str);
        VideoReport.reportEvent("dt_clck", hashMap);
    }

    public final void b(boolean isTroopOwner) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_qdesign_shareview");
        hashMap.put("eid", "em_group_withdraw");
        if (isTroopOwner) {
            str = "host";
        } else {
            str = "admin";
        }
        hashMap.put("role_type", str);
        VideoReport.reportEvent("dt_imp", hashMap);
    }

    public final void c(int type, String clickType) {
        Intrinsics.checkNotNullParameter(clickType, "clickType");
        HashMap hashMap = new HashMap();
        hashMap.put("group_popup_type", Integer.valueOf(type));
        hashMap.put("click_type", clickType);
        com.tencent.mobileqq.aio.utils.b.l("em_group_withdraw_fail", hashMap);
    }

    public final void d(int type) {
        HashMap hashMap = new HashMap();
        hashMap.put("group_popup_type", Integer.valueOf(type));
        com.tencent.mobileqq.aio.utils.b.q("em_group_withdraw_fail", hashMap);
    }
}
