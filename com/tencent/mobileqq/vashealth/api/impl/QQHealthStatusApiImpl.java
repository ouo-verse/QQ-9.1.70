package com.tencent.mobileqq.vashealth.api.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vashealth.StepCounterPermissionUtils;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthStatusApiImpl;
import com.tencent.mobileqq.vashealth.c;
import com.tencent.mobileqq.vashealth.pb.QQSportsUserServer$UserStep;
import com.tencent.mobileqq.vashealth.t;
import com.tencent.mobileqq.vashealth.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthStatusApiImpl;", "Lcom/tencent/mobileqq/vashealth/api/IQQHealthStatusApi;", "", "uinString", "", "getUinLong", "uin", "", "isMainState", "Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthStatusApiImpl$b;", "callback", "", "getUserStep", "", "stepCount", "getStepPicUrl", "getStepText", "Lg43/c;", "getJumpConfigData", "getStepPermission", "Lh43/e;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestStepPermission", "Lh43/a;", "getStepInfo", "jumpToMainPage", "Lcom/tencent/mobileqq/vashealth/t;", "mStepPermissionListener", "Lcom/tencent/mobileqq/vashealth/t;", "<init>", "()V", "Companion", "a", "b", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQHealthStatusApiImpl implements IQQHealthStatusApi {

    @NotNull
    private static final String IMG_CDN = "https://business-ad.cdn-go.cn/cdn-website/v1.38.0/public/yundong/client/";

    @NotNull
    private static final String TAG = "QQHealthStatusApiImpl";

    @Nullable
    private t mStepPermissionListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthStatusApiImpl$b;", "", "", "stepCount", "", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void a(int stepCount);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vashealth/api/impl/QQHealthStatusApiImpl$c", "Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthStatusApiImpl$b;", "", "stepCount", "", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference<h43.a> f312231b;

        c(WeakReference<h43.a> weakReference) {
            this.f312231b = weakReference;
        }

        @Override // com.tencent.mobileqq.vashealth.api.impl.QQHealthStatusApiImpl.b
        public void a(int stepCount) {
            h43.f fVar = new h43.f(stepCount, QQHealthStatusApiImpl.this.getStepPicUrl(stepCount), QQHealthStatusApiImpl.this.getStepText(stepCount));
            h43.a aVar = this.f312231b.get();
            if (aVar != null) {
                aVar.a(fVar);
            }
            n43.c.f418310a.f(stepCount);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vashealth/api/impl/QQHealthStatusApiImpl$d", "Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthStatusApiImpl$b;", "", "stepCount", "", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference<h43.a> f312233b;

        d(WeakReference<h43.a> weakReference) {
            this.f312233b = weakReference;
        }

        @Override // com.tencent.mobileqq.vashealth.api.impl.QQHealthStatusApiImpl.b
        public void a(int stepCount) {
            h43.f fVar = new h43.f(stepCount, QQHealthStatusApiImpl.this.getStepPicUrl(stepCount), QQHealthStatusApiImpl.this.getStepText(stepCount));
            h43.a aVar = this.f312233b.get();
            if (aVar != null) {
                aVar.a(fVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vashealth/api/impl/QQHealthStatusApiImpl$e", "Lcom/tencent/mobileqq/vashealth/c$a;", "", "retCode", "step", "", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements c.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference<h43.a> f312235b;

        e(WeakReference<h43.a> weakReference) {
            this.f312235b = weakReference;
        }

        @Override // com.tencent.mobileqq.vashealth.c.a
        public void a(int retCode, int step) {
            if (retCode != 0) {
                step = 0;
            }
            h43.f fVar = new h43.f(step, QQHealthStatusApiImpl.this.getStepPicUrl(step), QQHealthStatusApiImpl.this.getStepText(step));
            h43.a aVar = this.f312235b.get();
            if (aVar != null) {
                aVar.a(fVar);
            }
            n43.c.f418310a.f(step);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vashealth/api/impl/QQHealthStatusApiImpl$f", "Ln43/d;", "", "result", "Lcom/tencent/mobileqq/vashealth/pb/QQSportsUserServer$UserStep;", "userStep", "", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class f implements n43.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f312236a;

        f(b bVar) {
            this.f312236a = bVar;
        }

        @Override // n43.d
        public void a(boolean result, @NotNull QQSportsUserServer$UserStep userStep) {
            Intrinsics.checkNotNullParameter(userStep, "userStep");
            this.f312236a.a(userStep.step.get());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/vashealth/api/impl/QQHealthStatusApiImpl$g", "Lcom/tencent/mobileqq/vashealth/t;", "", "b", "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class g implements t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h43.e f312237a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQHealthStatusApiImpl f312238b;

        g(h43.e eVar, QQHealthStatusApiImpl qQHealthStatusApiImpl) {
            this.f312237a = eVar;
            this.f312238b = qQHealthStatusApiImpl;
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void a() {
            this.f312237a.a();
            QLog.d(QQHealthStatusApiImpl.TAG, 1, "requestStepPermission: permissionDenied");
            this.f312238b.mStepPermissionListener = null;
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void b() {
            StepCounterPermissionUtils.q();
            this.f312237a.b();
            QLog.d(QQHealthStatusApiImpl.TAG, 1, "requestStepPermission: permissionAllowed");
            this.f312238b.mStepPermissionListener = null;
        }
    }

    private final g43.c getJumpConfigData() {
        g43.c cVar = (g43.c) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100502");
        if (cVar == null) {
            return new g43.c(false, null, null, null, null, 31, null);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getStepInfo$lambda$0(e getCurrentStepCallback) {
        Intrinsics.checkNotNullParameter(getCurrentStepCallback, "$getCurrentStepCallback");
        com.tencent.mobileqq.vashealth.c.f312250a.c(getCurrentStepCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStepPicUrl(int stepCount) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str;
        boolean z26 = true;
        if (stepCount >= 0 && stepCount < 3001) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "yogurt.png";
        } else {
            if (3001 <= stepCount && stepCount < 6001) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                str = "toast.png";
            } else {
                if (6001 <= stepCount && stepCount < 9001) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    str = "milk-tea.png";
                } else {
                    if (9001 <= stepCount && stepCount < 12001) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        str = "hamburger.png";
                    } else {
                        if (12001 > stepCount || stepCount >= 18001) {
                            z26 = false;
                        }
                        if (z26) {
                            str = "ramen.png";
                        } else {
                            str = "huoguo.png";
                        }
                    }
                }
            }
        }
        return IMG_CDN + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getStepText(int stepCount) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26 = true;
        if (stepCount >= 0 && stepCount < 3001) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "\u4eca\u65e5\u6b65\u6570\u5927\u7ea6\u5df2\u6d88\u80171\u74f6\u9178\u5976\u7684\u70ed\u91cf\u5566";
        }
        if (3001 <= stepCount && stepCount < 6001) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return "\u4eca\u65e5\u6b65\u6570\u5927\u7ea6\u5df2\u6d88\u80171\u7247\u5410\u53f8\u7684\u70ed\u91cf\u5566";
        }
        if (6001 <= stepCount && stepCount < 9001) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return "\u4eca\u65e5\u6b65\u6570\u5927\u7ea6\u5df2\u6d88\u80171\u676f\u5976\u8336\u7684\u70ed\u91cf\u5566";
        }
        if (9001 <= stepCount && stepCount < 12001) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            return "\u4eca\u65e5\u6b65\u6570\u5927\u7ea6\u5df2\u6d88\u80171\u4e2a\u6c49\u5821\u7684\u70ed\u91cf\u5566";
        }
        if (12001 > stepCount || stepCount >= 18001) {
            z26 = false;
        }
        if (z26) {
            return "\u4eca\u65e5\u6b65\u6570\u5927\u7ea6\u5df2\u6d88\u80171\u7897\u62c9\u9762\u7684\u70ed\u91cf\u5566";
        }
        return "\u4eca\u65e5\u6b65\u6570\u5927\u7ea6\u5df2\u6d88\u80171\u987f\u706b\u9505\u7684\u70ed\u91cf\u5566";
    }

    private final long getUinLong(String uinString) {
        if (TextUtils.isEmpty(uinString)) {
            return 0L;
        }
        try {
            return Long.parseLong(uinString);
        } catch (Exception unused) {
            QLog.e(TAG, 1, "getUinLong error");
            return 0L;
        }
    }

    private final void getUserStep(long uin, boolean isMainState, b callback) {
        List<Long> listOf;
        f fVar = new f(callback);
        if (!isMainState) {
            n43.c cVar = n43.c.f418310a;
            if (!cVar.e(uin) && cVar.c(uin) >= 0) {
                QLog.d(TAG, 1, "getUserStep use cache:", Long.valueOf(uin));
                callback.a(cVar.c(uin));
                return;
            }
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(uin));
        n43.a.f418307a.d(listOf, new WeakReference<>(fVar));
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi
    public /* bridge */ /* synthetic */ void getStepInfo(String str, Boolean bool, h43.a aVar) {
        getStepInfo(str, bool.booleanValue(), aVar);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi
    public boolean getStepPermission() {
        boolean z16;
        if (StepCounterPermissionUtils.m()) {
            z16 = StepCounterPermissionUtils.c();
        } else {
            z16 = true;
        }
        QLog.d(TAG, 1, "getStepPermission:", Boolean.valueOf(z16));
        return z16;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi
    public void jumpToMainPage() {
        jumpToMainPage("");
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi
    public void requestStepPermission(@NotNull h43.e callback, @Nullable Activity activity) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mStepPermissionListener = new g(callback, this);
        StepCounterPermissionUtils.s(new WeakReference(this.mStepPermissionListener), activity);
    }

    public void getStepInfo(@NotNull String uin, boolean isMainState, @NotNull h43.a callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        WeakReference weakReference = new WeakReference(callback);
        i43.b bVar = i43.b.f407199a;
        if (bVar.c()) {
            int d16 = isMainState ? bVar.d() : bVar.b();
            h43.f fVar = new h43.f(d16, getStepPicUrl(d16), getStepText(d16));
            h43.a aVar = (h43.a) weakReference.get();
            if (aVar != null) {
                aVar.a(fVar);
                return;
            }
            return;
        }
        if (isMainState) {
            n43.c cVar = n43.c.f418310a;
            if (!cVar.d()) {
                int b16 = cVar.b();
                h43.f fVar2 = new h43.f(b16, getStepPicUrl(b16), getStepText(b16));
                h43.a aVar2 = (h43.a) weakReference.get();
                if (aVar2 != null) {
                    aVar2.a(fVar2);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.vashealth.c cVar2 = com.tencent.mobileqq.vashealth.c.f312250a;
            if (cVar2.g()) {
                getUserStep(cVar2.e(), true, new c(weakReference));
                return;
            } else {
                final e eVar = new e(weakReference);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.api.impl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQHealthStatusApiImpl.getStepInfo$lambda$0(QQHealthStatusApiImpl.e.this);
                    }
                }, 64, null, false);
                return;
            }
        }
        long uinLong = getUinLong(uin);
        if (uinLong == 0) {
            QLog.e(TAG, 1, "getStepInfo error: uin error");
        } else {
            getUserStep(uinLong, false, new d(weakReference));
        }
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi
    public void jumpToMainPage(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        String mainPageUrl = getJumpConfigData().getMainPageUrl();
        if (TextUtils.isEmpty(mainPageUrl)) {
            QLog.e(TAG, 1, "jumpToMainPage error: targetJumpUrl is null");
            return;
        }
        if (!TextUtils.isEmpty(uin) && !TextUtils.equals(uin, com.tencent.mobileqq.vashealth.c.f312250a.f())) {
            mainPageUrl = mainPageUrl + "&friendUin=" + uin;
        }
        QLog.d(TAG, 2, "jumpToMainPage:", mainPageUrl);
        com.tencent.mobileqq.vashealth.f fVar = com.tencent.mobileqq.vashealth.f.f312270a;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        fVar.k((BaseQQAppInterface) peekAppRuntime, "167");
        x.k(BaseApplication.context, mainPageUrl, true);
    }
}
