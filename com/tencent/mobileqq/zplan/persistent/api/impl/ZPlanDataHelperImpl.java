package com.tencent.mobileqq.zplan.persistent.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.model.g;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import gw4.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ji3.f;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\rH\u0016J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u001aH\u0016J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u001f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0018\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010%\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/zplan/persistent/api/impl/ZPlanDataHelperImpl;", "Lcom/tencent/mobileqq/zplan/persistent/api/IZPlanDataHelper;", "Lcom/tencent/mobileqq/zplan/persistent/api/IZPlanDataHelper$a;", "listener", "", "updateCheckInPackageListeners", "", "result", "notifyCheckInPackageListeners", "", "uin", "Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", "getUserZPlanInfo", "", "forceFromDB", "serviceType", "Lji3/g;", "callback", "needNetReq", "getUserZPlanInfoFromNet", "getUserZPlanInfoFromCache", "Lcom/tencent/mobileqq/zplan/model/g;", "bgInfo", "saveUserBackgroundInfo", "getUserBackgroundInfo", "", "Lji3/f;", "getUserAppearanceChangeInfo", "Lji3/a;", "checkAppearanceEverChanged", "getIsInAlreadyCreatedRolePackage", "checkCreatedRole", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCreatedRolePackageCache", "updateCreatedRolePackageCache", "keyForCheck", "checkAppearanceKeyUpToDate", "TAG", "Ljava/lang/String;", "isRequestIngCheckInPackage", "Z", "isInPackageFromMemory", "I", "", "checkInPackageListenerList", "Ljava/util/List;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanDataHelperImpl implements IZPlanDataHelper {
    private boolean isRequestIngCheckInPackage;
    private final String TAG = "ZPlanDataHelperImpl";
    private int isInPackageFromMemory = -1;
    private final List<IZPlanDataHelper.a> checkInPackageListenerList = new ArrayList();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/persistent/api/impl/ZPlanDataHelperImpl$a", "Lcom/tencent/mobileqq/zplan/persistent/api/IZPlanDataHelper$a;", "", "isInPackage", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements IZPlanDataHelper.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f334915b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Boolean> continuation) {
            this.f334915b = continuation;
        }

        @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper.a
        public void onResult(int isInPackage) {
            QLog.i(ZPlanDataHelperImpl.this.TAG, 1, "checkCreatedRole, isInPackage: " + isInPackage);
            Continuation<Boolean> continuation = this.f334915b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(isInPackage == 1)));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/persistent/api/impl/ZPlanDataHelperImpl$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lgw4/e;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements e<gw4.e> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f334917e;

        b(long j3) {
            this.f334917e = j3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(gw4.e result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i(ZPlanDataHelperImpl.this.TAG, 1, "[getIsInAlreadyCreatedRolePackage] onResultSuccess result:" + result + ".result");
            ZPlanDataHelperImpl.this.isRequestIngCheckInPackage = false;
            ZPlanDataHelperImpl.this.isInPackageFromMemory = result.f403467a;
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setInt("ZPLAN_CHECK_IN_PACKAGE_" + this.f334917e, ZPlanDataHelperImpl.this.isInPackageFromMemory);
            ZPlanDataHelperImpl zPlanDataHelperImpl = ZPlanDataHelperImpl.this;
            zPlanDataHelperImpl.notifyCheckInPackageListeners(zPlanDataHelperImpl.isInPackageFromMemory);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i(ZPlanDataHelperImpl.this.TAG, 1, "[getIsInAlreadyCreatedRolePackage] onResultSuccess error:" + error + " message:" + message);
            ZPlanDataHelperImpl.this.isRequestIngCheckInPackage = false;
            ZPlanDataHelperImpl.this.notifyCheckInPackageListeners(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void notifyCheckInPackageListeners(int result) {
        Iterator<IZPlanDataHelper.a> it = this.checkInPackageListenerList.iterator();
        while (it.hasNext()) {
            it.next().onResult(result);
        }
        this.checkInPackageListenerList.clear();
    }

    private final synchronized void updateCheckInPackageListeners(IZPlanDataHelper.a listener) {
        this.checkInPackageListenerList.add(listener);
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public void checkAppearanceEverChanged(long uin, int serviceType, ji3.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZplanDataRepository.f334898a.f(uin, serviceType, callback);
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public boolean checkAppearanceKeyUpToDate(String keyForCheck, String uin) {
        Intrinsics.checkNotNullParameter(keyForCheck, "keyForCheck");
        Intrinsics.checkNotNullParameter(uin, "uin");
        String str = getUserZPlanInfo(uin).appearanceKey;
        QLog.i(this.TAG, 2, "checkAppearanceKeyUpToDate, keyForCheck: " + keyForCheck + ", currKey: " + str);
        return Intrinsics.areEqual(str, keyForCheck);
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public Object checkCreatedRole(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        getIsInAlreadyCreatedRolePackage(new a(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public void clearCreatedRolePackageCache() {
        AppRuntime d16 = bb.f335811a.d();
        if (d16 != null) {
            long longAccountUin = d16.getLongAccountUin();
            QLog.i(this.TAG, 1, "[clearCreatedRolePackageCache] currentUin:" + longAccountUin);
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).remove("ZPLAN_CHECK_IN_PACKAGE_" + longAccountUin);
        }
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public void getIsInAlreadyCreatedRolePackage(IZPlanDataHelper.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        AppRuntime d16 = bb.f335811a.d();
        if (d16 != null) {
            long longAccountUin = d16.getLongAccountUin();
            int i3 = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getInt("ZPLAN_CHECK_IN_PACKAGE_" + longAccountUin, -1);
            this.isInPackageFromMemory = i3;
            QLog.i(this.TAG, 1, "[getIsInAlreadyCreatedRolePackage] isInPackageFromMemory:" + i3);
            int i16 = this.isInPackageFromMemory;
            if (i16 != -1) {
                listener.onResult(i16);
                return;
            }
            updateCheckInPackageListeners(listener);
            if (this.isRequestIngCheckInPackage) {
                QLog.i(this.TAG, 1, "[getIsInAlreadyCreatedRolePackage] isRequestIng return");
                return;
            }
            this.isRequestIngCheckInPackage = true;
            d dVar = new d();
            dVar.f403464a = longAccountUin;
            dVar.f403466c = 11;
            com.tencent.mobileqq.zplan.persistent.a.b(com.tencent.mobileqq.zplan.persistent.a.f334912a, dVar, new b(longAccountUin), 0, 4, null);
        }
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public void getUserAppearanceChangeInfo(long uin, int serviceType, f callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZplanDataRepository.f334898a.h(uin, serviceType, callback);
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public g getUserBackgroundInfo(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZplanDataRepository.f334898a.i(uin);
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public ZPlanUserInfo getUserZPlanInfo(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZplanDataRepository.l(ZplanDataRepository.f334898a, uin, false, 2, null);
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public ZPlanUserInfo getUserZPlanInfoFromCache(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZplanDataRepository.f334898a.m(uin);
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public void getUserZPlanInfoFromNet(String uin, int serviceType, ji3.g callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ZplanDataRepository.f334898a.o(uin, serviceType, callback);
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public void saveUserBackgroundInfo(String uin, g bgInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ZplanDataRepository.f334898a.y(uin, bgInfo);
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public void updateCreatedRolePackageCache() {
        AppRuntime d16 = bb.f335811a.d();
        if (d16 != null) {
            long longAccountUin = d16.getLongAccountUin();
            QLog.i(this.TAG, 1, "[updateCreatedRolePackageCache] currentUin:" + longAccountUin);
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setInt("ZPLAN_CHECK_IN_PACKAGE_" + longAccountUin, 1);
        }
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public ZPlanUserInfo getUserZPlanInfo(String uin, boolean forceFromDB) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ZplanDataRepository.f334898a.j(uin, forceFromDB);
    }

    @Override // com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper
    public void getUserZPlanInfo(String uin, int serviceType, ji3.g callback, boolean needNetReq) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZplanDataRepository.f334898a.k(uin, serviceType, callback, needNetReq);
    }
}
