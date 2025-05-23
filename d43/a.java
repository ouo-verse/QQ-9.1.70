package d43;

import com.tencent.mobileqq.vasgift.api.impl.service.QQGiftSendGiftReportHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public AtomicInteger f392789a;

    /* renamed from: b, reason: collision with root package name */
    public dn0.a f392790b;

    /* renamed from: c, reason: collision with root package name */
    public QQGiftSendGiftReportHelper.SendGiftReportData f392791c;

    public a(AtomicInteger atomicInteger) {
        this.f392790b = null;
        this.f392791c = null;
        this.f392789a = atomicInteger;
    }

    public String toString() {
        return "QQGiftComboReqMapData{unConsumeReq=" + this.f392789a + ", overReq=" + this.f392790b + ", comboOverReportData=" + this.f392791c + '}';
    }

    public a() {
        this.f392790b = null;
        this.f392791c = null;
        this.f392789a = new AtomicInteger(0);
    }
}
