package com.tencent.mobileqq.onlinestatus.repository;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.ac;
import com.tencent.mobileqq.onlinestatus.av;
import com.tencent.mobileqq.onlinestatus.bb;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.ICardHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f256220a;

    /* renamed from: b, reason: collision with root package name */
    private AccountOnlineStateViewModel f256221b;

    /* renamed from: c, reason: collision with root package name */
    private BusinessObserver f256222c = ((ICardHandler) QRoute.api(ICardHandler.class)).newCardHandlerForAutoReply(new C8191a());

    /* renamed from: d, reason: collision with root package name */
    private AccountObserver f256223d = new b();

    /* renamed from: e, reason: collision with root package name */
    private bb f256224e = new c();

    /* renamed from: f, reason: collision with root package name */
    private av f256225f = new d();

    /* renamed from: g, reason: collision with root package name */
    private ac f256226g = new e();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.onlinestatus.repository.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8191a implements ICardHandler.a {
        C8191a() {
        }

        @Override // com.tencent.mobileqq.relation.api.ICardHandler.a
        public void a(boolean z16, List<AutoReplyText> list, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountOnlineStateRepository", 2, String.format("onGetAutoReplyList, isSuccess: %s, selectId: %s, replyList: %s", Boolean.valueOf(z16), Integer.valueOf(i3), list));
            }
            a.this.f256221b.d2(z16, list);
        }

        @Override // com.tencent.mobileqq.relation.api.ICardHandler.a
        public void b(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountOnlineStateRepository", 2, "onSetAutoReplyList, isSuccess: " + z16);
            }
            if (z16) {
                a.this.f256221b.W1().setValue(new com.tencent.mobileqq.onlinestatus.model.h(true, true));
            } else {
                a.this.f256221b.W1().setValue(new com.tencent.mobileqq.onlinestatus.model.h(false, -2));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends AccountObserver {
        b() {
        }

        @Override // mqq.observer.AccountObserver
        protected void onOnlineStatusChanged(boolean z16, AppRuntime.Status status, long j3, boolean z17, boolean z18, long j16, boolean z19) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountOnlineStateRepository", 2, "onOnlineStatusChanged, isSuccess: " + z16 + " , mIsUpdateStatus: " + a.this.f256221b.R1() + ", isUserSet: " + z17);
            }
            if (a.this.f256221b.R1()) {
                a.this.f256221b.g2(false);
                if (z16) {
                    a.this.f256221b.W1().setValue(new com.tencent.mobileqq.onlinestatus.model.h(true, 0));
                } else {
                    a.this.f256221b.W1().setValue(new com.tencent.mobileqq.onlinestatus.model.h(false, -1));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c extends bb {
        c() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.bb
        public void a(boolean z16, Bundle bundle) {
            super.a(z16, bundle);
            if (z16) {
                if (!bundle.getBoolean("param_need_switch_online_status")) {
                    a.this.f256221b.W1().setValue(new com.tencent.mobileqq.onlinestatus.model.h(true, 0));
                    return;
                }
                return;
            }
            a.this.f256221b.W1().setValue(new com.tencent.mobileqq.onlinestatus.model.h(true, -1));
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d extends av {
        d() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void e(boolean z16, Bundle bundle) {
            super.e(z16, bundle);
            int i3 = bundle.getInt("StatusId");
            if (!z16) {
                a.this.f256221b.W1().setValue(new com.tencent.mobileqq.onlinestatus.model.h(false, -1));
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountOnlineStateRepository", 2, "onSetExtInfo: invoked. ", " isSuccess: ", Boolean.valueOf(z16), " statusId", Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void f(boolean z16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountOnlineStateRepository", 2, "onSetOnlineStatus, isSuccess: ", Boolean.valueOf(z16), " , mIsUpdateStatus: ", Boolean.valueOf(a.this.f256221b.R1()));
            }
            if (a.this.f256221b.R1()) {
                a.this.f256221b.g2(false);
                if (z16) {
                    a.this.f256221b.W1().setValue(new com.tencent.mobileqq.onlinestatus.model.h(true, 0));
                } else {
                    a.this.f256221b.W1().setValue(new com.tencent.mobileqq.onlinestatus.model.h(false, -1));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class e extends ac {
        e() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.ac
        public void a(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountOnlineStateRepository", 2, "onBatteryChanged updateOnlineStatusItem");
            }
            a.this.f256221b.P1().setValue(Integer.valueOf(i3));
        }
    }

    public a(AppInterface appInterface) {
        this.f256220a = appInterface;
    }

    public void k() {
        this.f256220a.addObserver(this.f256222c);
        this.f256220a.registObserver(this.f256226g);
        this.f256220a.registObserver(this.f256223d);
        this.f256220a.addObserver(this.f256225f);
        this.f256220a.registObserver(this.f256224e);
    }

    public void l() {
        this.f256220a.removeObserver(this.f256222c);
        this.f256220a.unRegistObserver(this.f256226g);
        this.f256220a.unRegistObserver(this.f256223d);
        this.f256220a.removeObserver(this.f256225f);
        this.f256220a.unRegistObserver(this.f256224e);
    }

    public void m(AccountOnlineStateViewModel accountOnlineStateViewModel) {
        this.f256221b = accountOnlineStateViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.a
    public void onDestroy() {
        super.onDestroy();
        l();
    }
}
