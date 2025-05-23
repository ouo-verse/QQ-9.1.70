package com.tencent.av.business.manager;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.utils.at;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private a f73320a;

    /* renamed from: b, reason: collision with root package name */
    private VideoAppInterface f73321b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements Observer {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<c> f73322d;

        a(c cVar) {
            this.f73322d = new WeakReference<>(cVar);
        }

        public boolean a() {
            WeakReference<c> weakReference = this.f73322d;
            if (weakReference != null && weakReference.get() != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            c cVar = this.f73322d.get();
            if (cVar != null) {
                cVar.c(observable, obj);
            }
        }
    }

    public c(VideoAppInterface videoAppInterface) {
        this.f73321b = videoAppInterface;
        a aVar = new a(this);
        this.f73320a = aVar;
        this.f73321b.addObserver(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Observable observable, Object obj) {
        Object[] objArr = (Object[]) obj;
        int intValue = ((Integer) objArr[0]).intValue();
        if (intValue != 13) {
            if (intValue != 28) {
                if (intValue != 101) {
                    if (intValue != 203) {
                        if (intValue == 6103) {
                            e(((Integer) objArr[1]).intValue(), (String) objArr[2]);
                            return;
                        }
                        return;
                    }
                    String str = (String) objArr[1];
                    boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                    long e16 = at.e(objArr, 3);
                    String str2 = n.e().f().f73091w;
                    QLog.w("BusinessMessageCenter", 1, "onSessionStatusChanged[END], eventPeerUin[" + str + "], isQuit[" + booleanValue + "], curPeerUin[" + str2 + "], relationId[" + n.e().f().P0 + "]");
                    if (str2 != null && !str2.equalsIgnoreCase(str)) {
                        return;
                    }
                    f(e16, 3, null);
                    return;
                }
                f(at.e(objArr, 1), 2, null);
                return;
            }
            String str3 = (String) objArr[1];
            boolean booleanValue2 = ((Boolean) objArr[2]).booleanValue();
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            d(str3, booleanValue2);
            return;
        }
        long e17 = at.e(objArr, 1);
        if (QLog.isColorLevel()) {
            QLog.w("BusinessMessageCenter", 1, "onSessionStatusChanged[Connected],");
        }
        f(e17, 1, null);
    }

    private void d(String str, boolean z16) {
        for (int i3 = 0; i3 < 20; i3++) {
            if (this.f73321b.Y(i3)) {
                this.f73321b.B(i3).h(str, z16);
            }
        }
    }

    public boolean b() {
        a aVar = this.f73320a;
        if (aVar != null && aVar.a()) {
            return true;
        }
        return false;
    }

    public int e(int i3, String str) {
        if (i3 == 3 || i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.i("BusinessMessageCenter", 2, "onReceivedMessageFaceOfPeer type: " + i3 + " info: " + str);
            }
            com.tencent.av.business.manager.support.a aVar = (com.tencent.av.business.manager.support.a) this.f73321b.B(5);
            boolean o16 = aVar.o(3, i3, str);
            if (QLog.isColorLevel()) {
                QLog.i("BusinessMessageCenter", 2, "onReceivedMessageFaceOfPeer supportManager: " + aVar + " hasHandled: " + o16);
            }
            if (!o16) {
                ((com.tencent.av.business.manager.magicface.a) this.f73321b.B(3)).V(i3, str);
                return 0;
            }
            return 0;
        }
        return 0;
    }

    public void f(long j3, int i3, String str) {
        String str2 = r.h0().O() + "";
        for (int i16 = 0; i16 < 20; i16++) {
            if (this.f73321b.Y(i16)) {
                this.f73321b.B(i16).j(j3, i3, str2, str);
            }
        }
    }
}
