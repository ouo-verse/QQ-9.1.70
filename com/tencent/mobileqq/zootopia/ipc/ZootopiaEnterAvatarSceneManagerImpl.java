package com.tencent.mobileqq.zootopia.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.authorize.api.CheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ZootopiaEnterAvatarSceneManagerImpl implements r {
    private static final String TAG = "ZootopiaEnterAvatarSceneManagerImpl_";
    private com.tencent.mobileqq.zootopia.lua.i listener;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements Function2<Integer, Integer, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f328329d;

        a(q qVar) {
            this.f328329d = qVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Integer num, Integer num2) {
            this.f328329d.a(num.intValue(), num2.intValue());
            return null;
        }
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.r
    public void enterAvatarResidence() {
        com.tencent.mobileqq.zootopia.lua.i iVar = this.listener;
        if (iVar == null) {
            return;
        }
        iVar.enterAvatarResidence();
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.r
    public void enterAvatarScene(int i3, String str, Boolean bool, q qVar) {
        com.tencent.mobileqq.zootopia.lua.i iVar = this.listener;
        if (iVar == null) {
            return;
        }
        iVar.a(i3, str, bool.booleanValue(), new a(qVar));
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.r
    public void enterPortal(ZootopiaSource zootopiaSource, Bundle bundle, s sVar) {
        ((com.tencent.mobileqq.zplan.authorize.api.c) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.authorize.api.c.class)).S(1, CheckPhoneManager.EntryType.AVATAR, zootopiaSource, new b(sVar, zootopiaSource, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.r
    public void registerEnterAvatarSceneListener(com.tencent.mobileqq.zootopia.lua.i iVar) {
        QLog.i(TAG, 1, "registerEnterAvatarSceneListener old:" + this.listener + ", new:" + iVar);
        this.listener = iVar;
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.r
    public void unRegisterEnterAvatarSceneListener(com.tencent.mobileqq.zootopia.lua.i iVar) {
        QLog.i(TAG, 1, "unRegisterEnterAvatarSceneListener old:" + this.listener + ", new:" + iVar);
        if (this.listener == iVar) {
            this.listener = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements com.tencent.mobileqq.zplan.authorize.api.a<CheckResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f328331a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f328332b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bundle f328333c;

        b(s sVar, ZootopiaSource zootopiaSource, Bundle bundle) {
            this.f328331a = sVar;
            this.f328332b = zootopiaSource;
            this.f328333c = bundle;
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(CheckResult checkResult) {
            this.f328331a.onResponse(checkResult.getResultCode());
            if (checkResult.isPassed()) {
                ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(BaseApplication.context, this.f328332b, this.f328333c);
            }
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(CheckResult checkResult) {
        }
    }
}
