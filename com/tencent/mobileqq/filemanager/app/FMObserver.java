package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FMObserver implements Observer {

    /* renamed from: d, reason: collision with root package name */
    private Map<Integer, aw> f206845d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements aw {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.w0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class aa implements aw {
        aa() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.W0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ab implements aw {
        ab() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.M0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ac implements aw {
        ac() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.E0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ad implements aw {
        ad() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.E0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ae implements aw {
        ae() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.D0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class af implements aw {
        af() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.v0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ag implements aw {
        ag() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.E0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ah implements aw {
        ah() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.D0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ai implements aw {
        ai() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.O0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class aj implements aw {
        aj() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.c0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ak implements aw {
        ak() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.N0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class al implements aw {
        al() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.Z0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class am implements aw {
        am() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.e0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class an implements aw {
        an() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.y0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ao implements aw {
        ao() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.X(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ap implements aw {
        ap() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.W(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class aq implements aw {
        aq() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class ar implements aw {
        ar() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.F0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class as implements aw {
        as() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.F0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class at implements aw {
        at() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.G0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class au implements aw {
        au() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.w0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class av implements aw {
        av() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.w0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface aw {
        void a(Object[] objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements aw {
        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.w0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements aw {
        c() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.O(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements aw {
        d() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.O(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements aw {
        e() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.O(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements aw {
        f() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.O(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements aw {
        g() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.O(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements aw {
        h() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.O(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class i implements aw {
        i() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.K(objArr[2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class j implements aw {
        j() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.z0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class k implements aw {
        k() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.q0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class l implements aw {
        l() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.N(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class m implements aw {
        m() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.S0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class n implements aw {
        n() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.V0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class o implements aw {
        o() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.i0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class p implements aw {
        p() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.X0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class q implements aw {
        q() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.H0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class r implements aw {
        r() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.h0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class s implements aw {
        s() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.C0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class t implements aw {
        t() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.r0(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class u implements aw {
        u() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.I(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class v implements aw {
        v() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.b1(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class w implements aw {
        w() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.a1(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class x implements aw {
        x() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.c1(objArr[2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class y implements aw {
        y() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.t0(objArr[2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class z implements aw {
        z() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver.aw
        public void a(Object[] objArr) {
            FMObserver.this.p0(objArr[2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(Object[] objArr) {
        String str;
        if (((Boolean) objArr[1]).booleanValue()) {
            Object[] objArr2 = (Object[]) objArr[2];
            com.tencent.mobileqq.filemanager.data.n nVar = new com.tencent.mobileqq.filemanager.data.n();
            nVar.f207830a = (String) objArr2[0];
            nVar.f207831b = ((Integer) objArr2[1]).intValue();
            nVar.f207833d = (String) objArr2[2];
            nVar.f207832c = objArr2[3];
            QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess,fileId[" + nVar.f207830a + "],filePath[" + nVar.f207833d + "]");
            if (nVar.f207832c != null && (str = nVar.f207833d) != null && str.length() > 0) {
                Object obj = nVar.f207832c;
                if (obj instanceof WeiYunFileInfo) {
                    ((WeiYunFileInfo) obj).H = nVar.f207833d;
                } else if (obj instanceof OfflineFileInfo) {
                    ((OfflineFileInfo) obj).G = nVar.f207833d;
                } else if (obj instanceof FileManagerEntity) {
                    ((FileManagerEntity) obj).strThumbPath = nVar.f207833d;
                }
            }
            B0(nVar);
            return;
        }
        Object[] objArr3 = (Object[]) objArr[2];
        String str2 = (String) objArr3[0];
        final com.tencent.mobileqq.filemanager.data.n nVar2 = new com.tencent.mobileqq.filemanager.data.n();
        nVar2.f207833d = null;
        nVar2.f207830a = str2;
        nVar2.f207832c = objArr3[1];
        Handler handler = new Handler();
        QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess(faild),fileId[" + nVar2.f207830a + "],delay 1000ms");
        handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FMObserver.50
            @Override // java.lang.Runnable
            public void run() {
                FMObserver.this.B0(nVar2);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(Object[] objArr) {
        ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        FileManagerEntity fileManagerEntity = (FileManagerEntity) objArr2[0];
        int intValue = ((Integer) objArr2[1]).intValue();
        com.tencent.mobileqq.filemanager.data.n nVar = new com.tencent.mobileqq.filemanager.data.n();
        nVar.f207832c = fileManagerEntity;
        nVar.f207830a = fileManagerEntity.Uuid;
        nVar.f207833d = null;
        nVar.f207834e = fileManagerEntity.nSessionId;
        A0(nVar, intValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        int i3 = 0;
        FileManagerEntity fileManagerEntity = (FileManagerEntity) objArr2[0];
        if (objArr2.length > 1) {
            i3 = ((Integer) objArr2[1]).intValue();
        }
        if (booleanValue) {
            com.tencent.mobileqq.filemanager.data.n nVar = new com.tencent.mobileqq.filemanager.data.n();
            nVar.f207832c = fileManagerEntity;
            nVar.f207830a = fileManagerEntity.Uuid;
            nVar.f207835f = i3;
            if (i3 == 7) {
                nVar.f207833d = fileManagerEntity.strLargeThumPath;
            } else if (i3 == 5) {
                nVar.f207833d = fileManagerEntity.strMiddleThumPath;
            } else {
                nVar.f207833d = fileManagerEntity.strThumbPath;
            }
            nVar.f207834e = fileManagerEntity.nSessionId;
            B0(nVar);
            return;
        }
        com.tencent.mobileqq.filemanager.data.n nVar2 = new com.tencent.mobileqq.filemanager.data.n();
        nVar2.f207832c = fileManagerEntity;
        nVar2.f207830a = fileManagerEntity.Uuid;
        nVar2.f207833d = null;
        nVar2.f207835f = i3;
        nVar2.f207834e = fileManagerEntity.nSessionId;
        B0(nVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(Object[] objArr) {
        long longValue = ((Long) objArr[1]).longValue();
        long longValue2 = ((Long) objArr[2]).longValue();
        String str = (String) objArr[3];
        int intValue = ((Integer) objArr[4]).intValue();
        if (QLog.isColorLevel()) {
            QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferStart uniseq[" + String.valueOf(longValue) + "],nSessionId[" + String.valueOf(longValue2) + "], strUin[" + str + "], peerType[" + String.valueOf(intValue) + "]");
        }
        U(longValue, longValue2, str, intValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(Object[] objArr) {
        long longValue = ((Long) objArr[1]).longValue();
        long longValue2 = ((Long) objArr[2]).longValue();
        String str = (String) objArr[3];
        int intValue = ((Integer) objArr[4]).intValue();
        if (((Integer) objArr[5]).intValue() == 14) {
            T(false, longValue, longValue2, str, intValue);
        } else {
            T(true, longValue, longValue2, str, intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        I0(((Long) objArr2[0]).longValue(), booleanValue, ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Object[] objArr) {
        long longValue = ((Long) objArr[1]).longValue();
        long longValue2 = ((Long) objArr[2]).longValue();
        String str = (String) objArr[3];
        int intValue = ((Integer) objArr[4]).intValue();
        if (QLog.isColorLevel()) {
            QLog.i("FMObserver<FileAssistant>", 1, "OnFileCome uniseq[" + String.valueOf(longValue) + "],nSessionId[" + String.valueOf(longValue2) + "], strUin[" + str + "], peerType[" + String.valueOf(intValue) + "]");
        }
        P(longValue, longValue2, str, intValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(Object obj) {
        Object[] objArr = (Object[]) obj;
        int intValue = ((Integer) objArr[0]).intValue();
        H();
        aw awVar = this.f206845d.get(Integer.valueOf(intValue));
        if (awVar != null) {
            awVar.a(objArr);
            return;
        }
        QLog.e("FMObserver<FileAssistant>", 1, "OnUpdate : Status[" + intValue + "] not processed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Object obj) {
        Object[] objArr = (Object[]) obj;
        o0(((Long) objArr[0]).longValue(), ((Long) objArr[1]).longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        Integer num = (Integer) objArr2[0];
        String str = (String) objArr2[1];
        if (!booleanValue) {
            QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdFailed");
            K0(num.intValue(), str);
        } else {
            QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdSuccess");
            L0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        int intValue = ((Integer) objArr2[0]).intValue();
        String str = (String) objArr2[1];
        String str2 = (String) objArr2[2];
        String str3 = (String) objArr2[3];
        String str4 = (String) objArr2[4];
        String str5 = (String) objArr2[5];
        int intValue2 = ((Integer) objArr2[6]).intValue();
        Bundle bundle = (Bundle) objArr2[7];
        QLog.i("FMObserver<FileAssistant>", 1, "OnDiscFilePreview retCode[" + String.valueOf(intValue) + "],retMsg[" + str + "], downloadKey[" + str3 + "], downloadIp[" + str4 + "], downloadDomain[" + str5 + "], port[" + String.valueOf(intValue2) + "]");
        Q(booleanValue, intValue, str, str2, str3, str4, str5, intValue2, null, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        int intValue = ((Integer) objArr2[0]).intValue();
        String str = (String) objArr2[1];
        String str2 = (String) objArr2[2];
        String str3 = (String) objArr2[3];
        String str4 = (String) objArr2[4];
        String str5 = (String) objArr2[5];
        int intValue2 = ((Integer) objArr2[6]).intValue();
        String str6 = (String) objArr2[7];
        long longValue = ((Long) objArr2[8]).longValue();
        Bundle bundle = (Bundle) objArr2[9];
        QLog.i("FMObserver<FileAssistant>", 1, "OnGetDiscVideoThumbInfo retCode[" + String.valueOf(intValue) + "],retMsg[" + str + "], downloadKey[" + str3 + "], downloadIp[" + str4 + "], downloadDomain[" + str5 + "], port[" + String.valueOf(intValue2) + "]");
        Z(booleanValue, intValue, str, str2, str3, str4, str5, intValue2, str6, longValue, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Object[] objArr) {
        String str;
        long longValue = ((Long) objArr[1]).longValue();
        long longValue2 = ((Long) objArr[2]).longValue();
        String str2 = (String) objArr[3];
        int intValue = ((Integer) objArr[4]).intValue();
        int intValue2 = ((Integer) objArr[5]).intValue();
        Object obj = objArr[6];
        if (obj == null) {
            str = null;
        } else {
            str = (String) obj;
        }
        String str3 = str;
        v0();
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(longValue) + "],nSessionId[" + String.valueOf(longValue2) + "],errCode[" + String.valueOf(intValue2) + "],errMsg[" + String.valueOf(str3) + "], peerType[" + String.valueOf(intValue) + "]");
        S(false, longValue, longValue2, str2, intValue, intValue2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        int intValue = ((Integer) objArr2[0]).intValue();
        String str = (String) objArr2[1];
        String str2 = (String) objArr2[2];
        String str3 = (String) objArr2[3];
        String str4 = (String) objArr2[4];
        String str5 = (String) objArr2[5];
        int intValue2 = ((Integer) objArr2[6]).intValue();
        String str6 = (String) objArr2[7];
        long longValue = ((Long) objArr2[8]).longValue();
        Bundle bundle = (Bundle) objArr2[9];
        QLog.i("FMObserver<FileAssistant>", 1, "OnGetOfflineVideoThumbInfo retCode[" + String.valueOf(intValue) + "],retMsg[" + str + "], downloadKey[" + str3 + "], downloadIp[" + str4 + "], downloadDomain[" + str5 + "], port[" + String.valueOf(intValue2) + "]");
        b0(booleanValue, intValue, str, str2, str3, str4, str5, intValue2, str6, longValue, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(Object[] objArr) {
        String str;
        Object obj;
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        int intValue = ((Integer) objArr2[0]).intValue();
        String str2 = (String) objArr2[1];
        String str3 = (String) objArr2[2];
        String str4 = (String) objArr2[3];
        String str5 = (String) objArr2[4];
        String str6 = (String) objArr2[5];
        int intValue2 = ((Integer) objArr2[6]).intValue();
        if (objArr2.length > 7 && (obj = objArr2[7]) != null) {
            str = (String) obj;
        } else {
            str = null;
        }
        QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunFilePreview retCode[" + String.valueOf(intValue) + "],retMsg[" + str2 + "], downloadKey[" + str3 + "], downloadIp[" + str5 + "], downloadDomain[" + str6 + "], port[" + String.valueOf(intValue2) + "]");
        V(booleanValue, intValue, str2, str3, str4, str5, str6, intValue2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(Object[] objArr) {
        if (((Boolean) objArr[1]).booleanValue()) {
            Object[] objArr2 = (Object[]) objArr[2];
            String str = (String) objArr2[0];
            boolean booleanValue = ((Boolean) objArr2[1]).booleanValue();
            int intValue = ((Integer) objArr2[2]).intValue();
            String str2 = (String) objArr2[3];
            List<WeiYunFileInfo> list = (List) objArr2[4];
            int intValue2 = ((Integer) objArr2[5]).intValue();
            QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoSuccess, categoryId[" + str + "], isEnd[" + String.valueOf(booleanValue) + "], count[" + String.valueOf(intValue) + "], localVersion[" + str2 + "], List<WeiYunFileInfo> size[" + list.size() + "], index[" + String.valueOf(intValue2) + "]");
            R0(str, booleanValue, intValue, str2, list, intValue2);
            return;
        }
        Object[] objArr3 = (Object[]) objArr[2];
        int intValue3 = ((Integer) objArr3[0]).intValue();
        String str3 = (String) objArr3[1];
        String str4 = (String) objArr3[2];
        QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoFaild, , errorCode[" + String.valueOf(intValue3) + "], strErrMsg[" + String.valueOf(str3) + "], strCategoryId[" + String.valueOf(str4) + "]");
        Q0(intValue3, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        Integer num = (Integer) objArr2[0];
        String str = (String) objArr2[1];
        if (!booleanValue) {
            QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdFailed");
            f0(num.intValue(), str);
            return;
        }
        Boolean bool = (Boolean) objArr2[2];
        QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdSuccess,  need verify[" + bool + "]");
        g0(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(Object[] objArr) {
        if (((Boolean) objArr[1]).booleanValue()) {
            if (QLog.isColorLevel()) {
                QLog.d("FMObserver<FileAssistant>", 2, "OnWeiYunSendToOfflineSuccess");
            }
            U0();
            return;
        }
        Object[] objArr2 = (Object[]) objArr[2];
        int intValue = ((Integer) objArr2[0]).intValue();
        String str = (String) objArr2[1];
        long longValue = ((Long) objArr2[2]).longValue();
        QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(longValue) + "], errorCode[" + String.valueOf(intValue) + "], strErrMsg[" + String.valueOf(str) + "]");
        T0(Integer.valueOf(intValue), longValue, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        long longValue = ((Long) objArr2[0]).longValue();
        Y0(booleanValue, ((Integer) objArr2[1]).intValue(), longValue, (String) objArr2[3], (String) objArr2[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        Integer num = (Integer) objArr2[0];
        String str = (String) objArr2[1];
        String str2 = (String) objArr2[2];
        String str3 = (String) objArr2[3];
        Boolean bool = (Boolean) objArr2[4];
        if (!booleanValue) {
            QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileFaild,  uuid[" + str2 + "]strFileName[" + String.valueOf(str3) + "]errorCode[" + String.valueOf(num) + "],retMsg[" + str + "],bOffline[" + String.valueOf(bool) + "]");
            L(str2, str3, num, str, bool.booleanValue());
            return;
        }
        QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileSuccess,  uuid[" + str2 + "]strFileName[" + String.valueOf(str3) + "],bOffline[" + String.valueOf(bool) + "]");
        M(str2, str3, bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        int intValue = ((Integer) objArr2[0]).intValue();
        String str = (String) objArr2[1];
        long longValue = ((Long) objArr2[2]).longValue();
        long longValue2 = ((Long) objArr2[3]).longValue();
        String str2 = (String) objArr2[4];
        long longValue3 = ((Long) objArr2[5]).longValue();
        QLog.i("FMObserver<FileAssistant>", 1, "OnForwardOfflineFile, bSuccess[" + String.valueOf(booleanValue) + "], retCode[" + String.valueOf(intValue) + "], retMsg[" + String.valueOf(str) + "], totalSpace[" + String.valueOf(longValue) + "], usedSpace[" + String.valueOf(longValue2) + "], strUuid[" + String.valueOf(str2) + "], nSessionId[" + String.valueOf(longValue3) + "]");
        Y(booleanValue, intValue, str, longValue, longValue2, str2, longValue3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        int intValue = ((Integer) objArr2[0]).intValue();
        String str = (String) objArr2[1];
        String str2 = (String) objArr2[2];
        String str3 = (String) objArr2[3];
        String str4 = (String) objArr2[4];
        String str5 = (String) objArr2[5];
        int intValue2 = ((Integer) objArr2[6]).intValue();
        String str6 = (String) objArr2[7];
        long longValue = ((Long) objArr2[8]).longValue();
        Bundle bundle = (Bundle) objArr2[9];
        QLog.i("FMObserver<FileAssistant>", 1, "OnGetOfflineVideoThumbInfo retCode[" + String.valueOf(intValue) + "],retMsg[" + str + "], downloadKey[" + str3 + "], downloadIp[" + str4 + "], downloadDomain[" + str5 + "], port[" + String.valueOf(intValue2) + "]");
        a0(booleanValue, intValue, str, str2, str3, str4, str5, intValue2, str6, longValue, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(Object obj) {
        Long l3 = (Long) ((Object[]) obj)[0];
        QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileProgressDirectDone, nSessionId=" + l3);
        l0(l3.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(Object[] objArr) {
        Object[] objArr2 = (Object[]) objArr[2];
        long longValue = ((Long) objArr2[0]).longValue();
        int intValue = ((Integer) objArr2[1]).intValue();
        int intValue2 = ((Integer) objArr2[2]).intValue();
        String str = (String) objArr2[3];
        String str2 = (String) objArr2[4];
        Bundle bundle = (Bundle) objArr2[5];
        QLog.i("FMObserver<FileAssistant>", 1, "onMMApkFileSafeCheckResult sessionId[" + longValue + "] errCode[" + intValue + "] safeLevel [" + intValue2 + "] tipString [" + str + "] jumpDetailUrl [" + str2 + "]");
        d0(longValue, intValue, intValue2, str, str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(Object[] objArr) {
        if (((Boolean) objArr[1]).booleanValue()) {
            Object[] objArr2 = (Object[]) objArr[2];
            int intValue = ((Integer) objArr2[0]).intValue();
            String str = (String) objArr2[1];
            String str2 = (String) objArr2[2];
            long longValue = ((Long) objArr2[3]).longValue();
            if (QLog.isColorLevel()) {
                QLog.d("FMObserver<FileAssistant>", 2, "OnOfflineSendToWeiYunSuccess, nSessionId[" + String.valueOf(longValue) + "]");
            }
            k0(longValue, str2, intValue, str);
            return;
        }
        Object[] objArr3 = (Object[]) objArr[2];
        int intValue2 = ((Integer) objArr3[0]).intValue();
        String str3 = (String) objArr3[1];
        long longValue2 = ((Long) objArr3[3]).longValue();
        QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(longValue2) + "], errorCode[" + String.valueOf(intValue2) + "], strErrMsg[" + String.valueOf(str3) + "]");
        j0(intValue2, longValue2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(Object[] objArr) {
        if (((Boolean) objArr[1]).booleanValue()) {
            Object[] objArr2 = (Object[]) objArr[2];
            int i3 = 0;
            boolean booleanValue = ((Boolean) objArr2[0]).booleanValue();
            List<OfflineFileInfo> list = (List) objArr2[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("OnWeiYunOfflineListSucess, , isEnd[");
            sb5.append(String.valueOf(booleanValue));
            sb5.append("], List<OfflineFileInfo> size[");
            if (list != null) {
                i3 = list.size();
            }
            sb5.append(String.valueOf(i3));
            sb5.append("]");
            QLog.i("FMObserver<FileAssistant>", 1, sb5.toString());
            P0(Boolean.valueOf(booleanValue), list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Object obj) {
        Long l3 = (Long) ((Object[]) obj)[0];
        QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileQueryUpProgressTimeOut, nSessionId=" + l3);
        m0(l3.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        Object[] objArr2 = (Object[]) objArr[2];
        int intValue = ((Integer) objArr2[0]).intValue();
        String str = (String) objArr2[1];
        String str2 = (String) objArr2[2];
        String str3 = (String) objArr2[3];
        String str4 = (String) objArr2[4];
        String str5 = (String) objArr2[5];
        int intValue2 = ((Integer) objArr2[6]).intValue();
        Bundle bundle = (Bundle) objArr2[7];
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileOfflinePreview retCode[" + String.valueOf(intValue) + "],retMsg[" + str + "], downloadKey[" + str3 + "], downloadIp[" + str4 + "], downloadDomain[" + str5 + "], port[" + String.valueOf(intValue2) + "]");
        R(booleanValue, intValue, str2, str, str3, str4, str5, intValue2, null, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Object[] objArr) {
        boolean z16;
        try {
            z16 = ((Boolean) objArr[1]).booleanValue();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("FMObserver<FileAssistant>", 1, "OnRefreshList param error!");
            }
            z16 = false;
        }
        if (z16) {
            s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(Object obj) {
        Long l3 = (Long) ((Object[]) obj)[0];
        QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileRecvButSenderReplayTimeOut, nSessionId=" + l3);
        n0(l3.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(Object[] objArr) {
        long longValue = ((Long) objArr[1]).longValue();
        long longValue2 = ((Long) objArr[2]).longValue();
        String str = (String) objArr[3];
        int intValue = ((Integer) objArr[4]).intValue();
        v0();
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + longValue + "],nSessionId[" + longValue2 + "], peerType[" + intValue + "]");
        S(true, longValue, longValue2, str, intValue, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Object[] objArr) {
        Object[] objArr2 = (Object[]) objArr[2];
        x0((FileManagerEntity) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(Object[] objArr) {
        String str;
        long longValue = ((Long) objArr[1]).longValue();
        long longValue2 = ((Long) objArr[2]).longValue();
        int intValue = ((Integer) objArr[4]).intValue();
        int intValue2 = ((Integer) objArr[5]).intValue();
        Object obj = objArr[6];
        if (obj == null) {
            str = null;
        } else {
            str = (String) obj;
        }
        v0();
        QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(longValue) + "],nSessionId[" + String.valueOf(longValue2) + "],errCode[" + String.valueOf(intValue2) + "],errMsg[" + String.valueOf(str) + "], peerType[" + String.valueOf(intValue) + "]");
        u0(intValue2, str);
    }

    protected final void H() {
        if (this.f206845d != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        this.f206845d = hashMap;
        hashMap.put(17, new u());
        this.f206845d.put(0, new af());
        this.f206845d.put(25, new aq());
        this.f206845d.put(10, new ar());
        this.f206845d.put(13, new as());
        this.f206845d.put(16, new at());
        this.f206845d.put(14, new au());
        this.f206845d.put(11, new av());
        this.f206845d.put(35, new a());
        this.f206845d.put(37, new b());
        this.f206845d.put(1, new c());
        this.f206845d.put(15, new d());
        this.f206845d.put(12, new e());
        this.f206845d.put(36, new f());
        this.f206845d.put(38, new g());
        this.f206845d.put(23, new h());
        this.f206845d.put(22, new i());
        this.f206845d.put(4, new j());
        this.f206845d.put(18, new k());
        this.f206845d.put(21, new l());
        this.f206845d.put(278, new m());
        this.f206845d.put(31, new n());
        this.f206845d.put(32, new o());
        this.f206845d.put(33, new p());
        this.f206845d.put(46, new q());
        this.f206845d.put(34, new r());
        this.f206845d.put(39, new s());
        this.f206845d.put(3, new t());
        this.f206845d.put(19, new v());
        this.f206845d.put(20, new w());
        this.f206845d.put(41, new x());
        this.f206845d.put(42, new y());
        this.f206845d.put(43, new z());
        this.f206845d.put(44, new aa());
        this.f206845d.put(45, new ab());
        this.f206845d.put(51, new ac());
        this.f206845d.put(50, new ad());
        this.f206845d.put(52, new ae());
        this.f206845d.put(54, new ag());
        this.f206845d.put(55, new ah());
        this.f206845d.put(191, new ai());
        this.f206845d.put(193, new aj());
        this.f206845d.put(192, new ak());
        this.f206845d.put(60, new al());
        this.f206845d.put(200, new am());
        this.f206845d.put(24, new an());
        this.f206845d.put(56, new ao());
        this.f206845d.put(57, new ap());
    }

    @Override // java.util.Observer
    public void update(Observable observable, final Object obj) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.FMObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    FMObserver.this.J0(obj);
                }
            });
        } else {
            J0(obj);
        }
    }

    protected void J() {
    }

    protected void L0() {
    }

    protected void U0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s0() {
    }

    protected void v0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B0(com.tencent.mobileqq.filemanager.data.n nVar) {
    }

    protected void W(Object[] objArr) {
    }

    protected void X(Object[] objArr) {
    }

    protected void g0(boolean z16) {
    }

    protected void l0(long j3) {
    }

    protected void m0(long j3) {
    }

    protected void n0(long j3) {
    }

    protected void A0(com.tencent.mobileqq.filemanager.data.n nVar, int i3) {
    }

    protected void K0(int i3, String str) {
    }

    protected void P0(Boolean bool, List<OfflineFileInfo> list) {
    }

    protected void f0(int i3, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o0(long j3, long j16) {
    }

    protected void u0(int i3, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x0(FileManagerEntity fileManagerEntity, boolean z16) {
    }

    protected void M(String str, String str2, boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q0(int i3, String str, String str2) {
    }

    protected void T0(Integer num, long j3, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j0(int i3, long j3, String str) {
    }

    protected void I0(long j3, boolean z16, int i3, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(long j3, long j16, String str, int i3) {
    }

    protected void U(long j3, long j16, String str, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k0(long j3, String str, int i3, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(String str, String str2, Integer num, String str3, boolean z16) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T(boolean z16, long j3, long j16, String str, int i3) {
    }

    protected void Y0(boolean z16, int i3, long j3, String str, String str2) {
    }

    protected void Q(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6, Bundle bundle) {
    }

    protected void R(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6, Bundle bundle) {
    }

    protected void R0(String str, boolean z16, int i3, String str2, List<WeiYunFileInfo> list, int i16) {
    }

    protected void d0(long j3, int i3, int i16, String str, String str2, Bundle bundle) {
    }

    protected void Z(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6, long j3, Bundle bundle) {
    }

    protected void a0(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6, long j3, Bundle bundle) {
    }

    protected void b0(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6, long j3, Bundle bundle) {
    }

    protected void S(boolean z16, long j3, long j16, String str, int i3, int i16, String str2) {
    }

    protected void Y(boolean z16, int i3, String str, long j3, long j16, String str2, long j17) {
    }

    protected void V(boolean z16, int i3, String str, String str2, String str3, String str4, String str5, int i16, String str6) {
    }
}
