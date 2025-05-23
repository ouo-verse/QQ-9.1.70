package com.tencent.gdtad.statistics;

import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.c2s.GdtC2SReportInterface;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a extends BaseGdtC2SReporter {

    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.statistics.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1166a {
        void a(int i3, int i16, qq_ad_get.QQAdGetRsp.AdInfo adInfo);
    }

    @Nullable
    private static InterfaceC1166a a(int i3) {
        if (i3 != 0 && 1 != i3 && 2 != i3 && 3 != i3 && i3 != 4) {
            return null;
        }
        return new GdtC2SReportInterface();
    }

    public static void b(int i3, int i16, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        InterfaceC1166a a16;
        if (i3 >= 0 && i3 < 3 && i16 >= 0 && i16 < 6 && (a16 = a(i16)) != null) {
            a16.a(i3, i16, adInfo);
        } else {
            GdtReporterForAnalysis.g(BaseApplicationImpl.getApplication(), new GdtAd(adInfo), i3, i16, false);
        }
    }
}
