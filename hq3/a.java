package hq3;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;
import hq3.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f405939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: hq3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C10466a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b.InterfaceC10469b f405940d;

        C10466a(b.InterfaceC10469b interfaceC10469b) {
            this.f405940d = interfaceC10469b;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            QLog.d("AccountChecker", 1, "check: checkOpenidDiff, code=" + i3);
            if (i3 == 0) {
                this.f405940d.onSuccess(true);
            } else if (i3 == 16) {
                this.f405940d.onSuccess(false);
            } else {
                this.f405940d.onError(i3, "");
            }
        }
    }

    public a(QQAppInterface qQAppInterface) {
        this.f405939a = qQAppInterface;
    }

    public void a(long j3, String str, b.InterfaceC10469b interfaceC10469b) {
        OpenID b36 = this.f405939a.getMsgHandler().b3(String.valueOf(j3));
        if (b36 != null) {
            boolean equals = TextUtils.equals(str, b36.openID);
            interfaceC10469b.onSuccess(equals);
            QLog.d("AccountChecker", 1, "check: use cache, account is same? " + equals);
            return;
        }
        try {
            this.f405939a.getMsgHandler().O2(Long.parseLong(this.f405939a.getCurrentAccountUin()), str, j3, new C10466a(interfaceC10469b));
        } catch (NumberFormatException e16) {
            QLog.e("AccountChecker", 1, "check: NumberFormatException");
            interfaceC10469b.onError(-1, e16.getMessage());
        }
    }
}
