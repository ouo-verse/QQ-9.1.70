package com.tencent.mobileqq.zootopia.ipc;

import android.text.TextUtils;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.openid.ZootopiaOpenIdSilentHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ZootopiaOpenIdRemoteManagerImpl implements ac {
    private static final String TAG = "ZootopiaOpenIdRemoteManagerImpl";

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements com.tencent.mobileqq.zootopia.openid.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ab f328341a;

        a(ab abVar) {
            this.f328341a = abVar;
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void a(ZootopiaOpenIdResult zootopiaOpenIdResult) {
            this.f328341a.a(zootopiaOpenIdResult);
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void b(int i3, String str) {
            this.f328341a.b(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements com.tencent.mobileqq.zootopia.openid.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ab f328343a;

        b(ab abVar) {
            this.f328343a = abVar;
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void a(ZootopiaOpenIdResult zootopiaOpenIdResult) {
            this.f328343a.a(zootopiaOpenIdResult);
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void b(int i3, String str) {
            this.f328343a.b(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements com.tencent.mobileqq.zootopia.openid.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ab f328345a;

        c(ab abVar) {
            this.f328345a = abVar;
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void b(int i3, String str) {
            QLog.i(ZootopiaOpenIdRemoteManagerImpl.TAG, 1, "getOpenIdInfoSilent onOpenIdError errCode = " + i3 + " errMsg = " + str);
            this.f328345a.b(i3, str);
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void a(ZootopiaOpenIdResult zootopiaOpenIdResult) {
            QLog.i(ZootopiaOpenIdRemoteManagerImpl.TAG, 1, "getOpenIdInfoSilent onOpenIdResult");
            this.f328345a.a(zootopiaOpenIdResult);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class d implements com.tencent.mobileqq.zootopia.openid.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ab f328347a;

        d(ab abVar) {
            this.f328347a = abVar;
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void a(ZootopiaOpenIdResult zootopiaOpenIdResult) {
            this.f328347a.a(zootopiaOpenIdResult);
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void b(int i3, String str) {
            this.f328347a.b(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ac
    public void getOpenIdInfoSilent(ab abVar) {
        ZootopiaOpenIdSilentHelper.INSTANCE.a().h(new c(abVar), false);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ac
    public void reAuthOpenId(ZootopiaSource zootopiaSource, String str, ab abVar) {
        String b16 = com.tencent.sqshow.zootopia.utils.w.f373306a.b();
        if (TextUtils.isEmpty(b16)) {
            return;
        }
        com.tencent.mobileqq.zootopia.openid.f fVar = com.tencent.mobileqq.zootopia.openid.f.f328608a;
        fVar.e(b16);
        fVar.g(BaseApplication.getContext(), b16, str, new b(abVar), zootopiaSource);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ac
    public void reAuthOpenIdSilent(ab abVar) {
        ZootopiaOpenIdSilentHelper.INSTANCE.a().t(new d(abVar));
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ac
    public void getOpenIdInfo(ZootopiaSource zootopiaSource, String str, ab abVar) {
        if (abVar == null) {
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null) {
            abVar.b(-1, "context is null");
            return;
        }
        AppRuntime waitAppRuntime = mobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            abVar.b(-1, "runtime is null");
        } else {
            com.tencent.mobileqq.zootopia.openid.f.f328608a.g(mobileQQ, waitAppRuntime.getCurrentUin(), str, new a(abVar), zootopiaSource);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ac
    public void reAuthorization(ab abVar) {
        if (abVar == null) {
            return;
        }
        com.tencent.mobileqq.zootopia.openid.f.f328608a.n();
        abVar.c();
    }
}
