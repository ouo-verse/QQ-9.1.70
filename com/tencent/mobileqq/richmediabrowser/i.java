package com.tencent.mobileqq.richmediabrowser;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i implements e {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.mobileqq.activity.aio.photo.h f281829a;

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public void A(long j3, int i3, int i16) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.A(j3, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.e
    public void B(long j3) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.B(j3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public void C(long j3, int i3, Bundle bundle) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.C(j3, i3, bundle);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public void D(int i3) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.D(i3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public Intent E(long j3, int i3) throws RemoteException {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            return hVar.E(j3, i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public void G(long j3) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.G(j3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public void b(String str, int i3) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.b(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public boolean c(long j3) {
        return true;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public void d(long j3) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.d(j3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.e
    public void e(MessageRecord messageRecord) {
        com.tencent.mobileqq.activity.aio.photo.h hVar;
        if ((messageRecord instanceof MessageForShortVideo) && (hVar = this.f281829a) != null) {
            hVar.J4((MessageForShortVideo) messageRecord);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public void f(long j3) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.f(j3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public void g(int i3, boolean z16, String str, String str2, String str3, String str4) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.g(i3, z16, str, str2, str3, str4);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public void h(long j3, int i3) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.h(j3, i3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public int k(long j3, int i3) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            return hVar.k(j3, i3);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public void m(long j3) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.m(j3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public boolean n() {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            return hVar.asBinder().pingBinder();
        }
        return false;
    }

    public void o(com.tencent.mobileqq.activity.aio.photo.h hVar) {
        this.f281829a = hVar;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public Intent u(long j3, int i3, int i16) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            return hVar.u(j3, i3, i16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.f
    public void y(long j3, int i3, int i16) {
        com.tencent.mobileqq.activity.aio.photo.h hVar = this.f281829a;
        if (hVar != null) {
            hVar.y(j3, i3, i16);
        }
    }

    @Override // d04.a
    public void a(String str) {
    }

    @Override // d04.a
    public void i(String str) {
    }

    @Override // d04.a
    public void j(String str) {
    }

    @Override // d04.a
    public void l(String str) {
    }
}
