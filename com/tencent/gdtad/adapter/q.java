package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.statistics.AdReporterForOuterJumpAdapter;
import com.tencent.gdtad.aditem.GdtOuterJumpReporter;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class q implements AdReporterForOuterJumpAdapter {
    @Override // com.tencent.ad.tangram.statistics.AdReporterForOuterJumpAdapter
    public void onClick(Ad ad5) {
        GdtOuterJumpReporter.getInstance().clickStart(ad5);
    }
}
