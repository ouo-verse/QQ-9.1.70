package com.tencent.thumbplayer.report.reportv1;

import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.v1.TPDefaultReportInfo;
import com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase;

/* loaded from: classes26.dex */
public class TPReportNonImplPlugin implements ITPPluginBase, ITPBusinessReportManager {
    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
    public void onAttach() {
    }

    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
    public void onDetach() {
    }

    @Override // com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager
    public void setReportInfoGetter(TPDefaultReportInfo tPDefaultReportInfo) {
    }

    @Override // com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager
    public void setReportSamplingRate(double d16) {
    }

    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
    public void onEvent(int i3, int i16, int i17, String str, Object obj) {
    }
}
