package com.tencent.mobileqq.vas.api.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.api.IVasDataHelperApi;
import com.tencent.mobileqq.vas.api.impl.VasDataHelperApiImpl;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasDataHelperApiImpl implements IVasDataHelperApi {
    private static final String TAG = "VasDataHelperApiImpl";
    private final Object lock = new Object();
    private final ConcurrentHashMap<String, a> uinToListenerMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f308484a;

        /* renamed from: b, reason: collision with root package name */
        private final String f308485b;

        /* renamed from: c, reason: collision with root package name */
        private final VasDataHelperApiImpl f308486c;

        /* renamed from: d, reason: collision with root package name */
        private long f308487d = 0;

        /* renamed from: e, reason: collision with root package name */
        ArrayList<IVasDataHelperApi.RequestCallback> f308488e = new ArrayList<>();

        /* renamed from: f, reason: collision with root package name */
        private Runnable f308489f;

        public a(String str, String str2, VasDataHelperApiImpl vasDataHelperApiImpl) {
            this.f308484a = str;
            this.f308485b = str2;
            this.f308486c = vasDataHelperApiImpl;
        }

        private void c(String str, NTVasSimpleInfo nTVasSimpleInfo, IVasDataHelperApi.RequestCallback requestCallback) {
            if (requestCallback != null) {
                if (nTVasSimpleInfo != null) {
                    requestCallback.call(str, nTVasSimpleInfo.faceId, nTVasSimpleInfo.pendantId, nTVasSimpleInfo.pendantDiyId);
                } else {
                    requestCallback.call(str, 0, 0L, 0);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            this.f308486c.handleComplete(this.f308484a, this.f308485b);
        }

        void b(@Nullable IVasDataHelperApi.RequestCallback requestCallback) {
            if (requestCallback != null) {
                try {
                    this.f308488e.add(requestCallback);
                } catch (Exception e16) {
                    QLog.i(VasDataHelperApiImpl.TAG, 1, "addCallbackAndResetDelayTask exception: " + e16.getMessage());
                }
                if (this.f308489f != null) {
                    return;
                }
                this.f308489f = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        VasDataHelperApiImpl.a.this.f();
                    }
                }, 16, null, false, 5000L);
            }
        }

        void d(String str, String str2) {
            try {
                NTVasSimpleInfo queryExtensionInfo = this.f308486c.queryExtensionInfo(str2, true);
                Iterator it = new ArrayList(this.f308488e).iterator();
                while (it.hasNext()) {
                    c(str, queryExtensionInfo, (IVasDataHelperApi.RequestCallback) it.next());
                }
            } catch (Exception e16) {
                QLog.i(VasDataHelperApiImpl.TAG, 1, "handleCallbackList", e16);
            }
        }

        boolean e() {
            if (System.currentTimeMillis() - this.f308487d >= 5000) {
                return true;
            }
            return false;
        }

        void g(long j3) {
            this.f308487d = j3;
        }
    }

    private VasFaceManager getFaceManager(AppRuntime appRuntime) {
        return ((com.tencent.mobileqq.vas.ao) appRuntime.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308429f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleComplete(@NonNull String str, @NonNull String str2) {
        a remove;
        synchronized (this.lock) {
            remove = this.uinToListenerMap.remove(str2);
        }
        if (remove != null) {
            remove.d(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestFaceId$0(String str, String str2, String str3, Object obj) {
        handleComplete(str, str2);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDataHelperApi
    @Nullable
    public NTVasSimpleInfo queryExtensionInfo(@NonNull String str, boolean z16) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface) {
            return ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), TAG);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasDataHelperApi
    public void requestFaceId(@NonNull final String str, @NonNull final String str2, String str3, @Nullable IVasDataHelperApi.RequestCallback requestCallback) {
        System.currentTimeMillis();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            return;
        }
        synchronized (this.lock) {
            a aVar = this.uinToListenerMap.get(str2);
            if (aVar == null || aVar.e()) {
                VasManager.CompleteListener<String> completeListener = new VasManager.CompleteListener() { // from class: com.tencent.mobileqq.vas.api.impl.ac
                    @Override // com.tencent.mobileqq.vas.VasManager.CompleteListener
                    public final void onComplete(Object obj, Object obj2) {
                        VasDataHelperApiImpl.this.lambda$requestFaceId$0(str, str2, (String) obj, obj2);
                    }
                };
                if (aVar == null) {
                    aVar = new a(str, str2, this);
                }
                a aVar2 = aVar;
                aVar2.g(System.currentTimeMillis());
                getFaceManager(peekAppRuntime).r(str2, completeListener, ApngOptions.EMPTY_DRAWABLE, true, true);
                aVar = aVar2;
            }
            this.uinToListenerMap.put(str2, aVar);
            if (requestCallback != null) {
                aVar.b(requestCallback);
            }
        }
    }
}
