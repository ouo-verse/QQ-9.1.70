package com.tencent.biz.qqcircle.immersive.repository.foldertab;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends k {

    /* renamed from: i, reason: collision with root package name */
    private QFSTabRequestSender f89769i;

    public c(@NonNull l lVar) {
        super(lVar);
        this.f89769i = new QFSTabRequestSender(a(), lVar);
    }

    private void h(m.a aVar) {
        if (!aVar.b()) {
            d(UIStateData.obtainLoading());
        }
        this.f89769i.F(aVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.repository.foldertab.k
    public String a() {
        return b() + "_QFSNetworkDataSource";
    }

    public boolean g(m.a aVar, String str) {
        QLog.d(a(), 1, "fetchData");
        this.f89796d.b("3");
        h(aVar);
        return true;
    }
}
