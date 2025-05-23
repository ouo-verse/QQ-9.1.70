package com.qzone.misc.network.ttt;

import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    long f48531b;

    /* renamed from: c, reason: collision with root package name */
    long f48532c;

    /* renamed from: e, reason: collision with root package name */
    public int f48534e;

    /* renamed from: g, reason: collision with root package name */
    public Map<Integer, String> f48536g;

    /* renamed from: i, reason: collision with root package name */
    public BusinessFeedData f48538i;

    /* renamed from: a, reason: collision with root package name */
    private String f48530a = null;

    /* renamed from: d, reason: collision with root package name */
    public long f48533d = LoginData.getInstance().getUin();

    /* renamed from: f, reason: collision with root package name */
    public int f48535f = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f48537h = -1;

    public String b() {
        if (this.f48530a == null && this.f48531b != 0 && this.f48535f != -1) {
            this.f48530a = String.format("%s_%s_%s", Long.valueOf(this.f48533d), Long.valueOf(this.f48531b / 1000), Integer.valueOf(this.f48535f));
        }
        return this.f48530a;
    }

    public void c() {
        if (this.f48531b == 0) {
            this.f48531b = System.currentTimeMillis();
        }
    }

    public void a(int i3, int i16, int i17, BusinessFeedData businessFeedData, int i18, long j3) {
        CellFeedCommInfo feedCommInfo;
        BusinessFeedData businessFeedData2 = this.f48538i;
        if (businessFeedData2 == null) {
            feedCommInfo = businessFeedData.getFeedCommInfo();
        } else {
            feedCommInfo = businessFeedData2.getFeedCommInfo();
        }
        TTTReportManager.s().l(i3, i16, i17, System.currentTimeMillis(), null, businessFeedData, i18, 0, this.f48534e, this.f48535f, this.f48536g, j3, b(), null, feedCommInfo.isRealTimeTTTReport());
    }

    public void d() {
        BusinessFeedData businessFeedData = this.f48538i;
        if (businessFeedData == null) {
            return;
        }
        TTTReportManager.s().l(0, 84, 29, System.currentTimeMillis(), null, this.f48538i, this.f48537h, 0, this.f48534e, this.f48535f, this.f48536g, 0L, b(), null, businessFeedData.getFeedCommInfo().isRealTimeTTTReport());
    }

    public void e() {
        if (this.f48532c == 0) {
            return;
        }
        BusinessFeedData businessFeedData = this.f48538i;
        if (businessFeedData == null) {
            QLog.e("QZoneTTTRecomendReporter", 2, "reportLayerStay: businessFeedData is null", new RuntimeException());
            return;
        }
        TTTReportManager.s().l(0, 84, 34, System.currentTimeMillis(), null, null, 0, 0, this.f48534e, this.f48535f, this.f48536g, this.f48532c, b(), null, businessFeedData.getFeedCommInfo().isRealTimeTTTReport());
        this.f48532c = 0L;
    }
}
