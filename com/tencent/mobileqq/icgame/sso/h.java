package com.tencent.mobileqq.icgame.sso;

import androidx.annotation.NonNull;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h extends g {

    /* renamed from: d, reason: collision with root package name */
    private final a f237774d;

    public h(@NonNull a aVar) {
        this.f237774d = aVar;
    }

    @Override // com.tencent.mobileqq.icgame.sso.g
    public void onReceive(int i3, boolean z16, i iVar) {
        if (this.f237774d == null) {
            QLog.e("ICGameBaseSsoCallback", 1, "the callback is null");
            return;
        }
        if (z16) {
            if (iVar != null && iVar.e() != null) {
                if (iVar.b() != 0) {
                    this.f237774d.onBusinessFailed(iVar.b(), iVar.c());
                    return;
                }
                if (iVar.g() != 0) {
                    this.f237774d.onFailed(iVar.g(), "business error " + iVar.c());
                    return;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("ICGameBaseSsoCallback", 2, "onProxyRequestSuccess method:" + iVar.h().getServiceCmd());
                    }
                    this.f237774d.onProxyRequestSuccess(i3, iVar);
                    return;
                } catch (InvalidProtocolBufferNanoException unused) {
                    this.f237774d.onFailed(-1, " transform error: InvalidProtocolBufferNanoException ");
                    return;
                }
            }
            this.f237774d.onFailed(-1, "the data is null");
            return;
        }
        if (iVar.h() != null) {
            this.f237774d.onFailed(iVar.h().getResultCode(), "sso fail request: " + iVar.h().getServiceCmd());
        }
    }
}
