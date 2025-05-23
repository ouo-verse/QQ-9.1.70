package e40;

import qqcircle.QQCircleDitto$StPicTextBanner;
import tianshu.QQCircleTianShu$AdItem;

/* compiled from: P */
/* loaded from: classes4.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public QQCircleDitto$StPicTextBanner f395680a;

    /* renamed from: b, reason: collision with root package name */
    public QQCircleTianShu$AdItem f395681b;

    public String a() {
        QQCircleTianShu$AdItem qQCircleTianShu$AdItem = this.f395681b;
        if (qQCircleTianShu$AdItem != null) {
            return String.valueOf(qQCircleTianShu$AdItem.iAdId.get());
        }
        return "";
    }

    public String b() {
        QQCircleTianShu$AdItem qQCircleTianShu$AdItem = this.f395681b;
        if (qQCircleTianShu$AdItem != null) {
            return qQCircleTianShu$AdItem.traceinfo.get();
        }
        return "";
    }

    public s c(QQCircleTianShu$AdItem qQCircleTianShu$AdItem) {
        this.f395681b = qQCircleTianShu$AdItem;
        return this;
    }

    public s d(QQCircleDitto$StPicTextBanner qQCircleDitto$StPicTextBanner) {
        this.f395680a = qQCircleDitto$StPicTextBanner;
        return this;
    }
}
