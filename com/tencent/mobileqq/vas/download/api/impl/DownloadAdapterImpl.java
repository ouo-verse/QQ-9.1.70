package com.tencent.mobileqq.vas.download.api.impl;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.download.api.IDownloadAdapter;
import com.tencent.mobileqq.vip.g;
import com.tencent.open.agent.report.ReportCenter;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DownloadAdapterImpl implements IDownloadAdapter {
    @Override // com.tencent.mobileqq.vas.download.api.IDownloadAdapter
    public void vipReportCgi(g gVar) {
        ReportCenter.f().r(gVar.f313011i, 100, gVar.f313006d, String.valueOf(gVar.Z.f313030b), gVar.Z.f313029a, HardCodeUtil.qqStr(R.string.lrr), true);
    }
}
