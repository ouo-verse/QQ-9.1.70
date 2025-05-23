package com.qzone.common.activities.base;

import android.os.Message;
import com.qzone.common.business.result.QZoneResult;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;

/* compiled from: P */
@Named("BaseFragmentPageDataImp")
/* loaded from: classes39.dex */
public class ac implements d5.v<QZoneResult> {

    /* renamed from: a, reason: collision with root package name */
    private d5.p<QZoneResult> f45442a;

    @Inject
    public ac() {
    }

    @Override // d5.v
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void b(QZoneResult qZoneResult) {
        d5.p<QZoneResult> pVar = this.f45442a;
        if (pVar != null) {
            pVar.a(qZoneResult);
        }
    }

    @Override // d5.v
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public QZoneResult a(Message message) {
        return QZoneResult.unpack(message);
    }

    @Inject
    public void setFootBannerInf(d5.p<QZoneResult> pVar) {
        this.f45442a = pVar;
    }
}
