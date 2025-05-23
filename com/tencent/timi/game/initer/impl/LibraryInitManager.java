package com.tencent.timi.game.initer.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.utils.w;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0002J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0016R \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/timi/game/initer/impl/LibraryInitManager;", "Landroid/content/BroadcastReceiver;", "", "result", "", "f", "d", "e", "Lhi4/c;", "listener", h.F, "i", "c", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "", "b", "I", "status", "Z", "broadcastHasRegistered", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "pagLibraryLoadedListenerList", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LibraryInitManager extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LibraryInitManager f377186a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile int status;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean broadcastHasRegistered;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<WeakReference<hi4.c>> pagLibraryLoadedListenerList;

    static {
        LibraryInitManager libraryInitManager = new LibraryInitManager();
        f377186a = libraryInitManager;
        status = 1;
        pagLibraryLoadedListenerList = new CopyOnWriteArrayList<>();
        libraryInitManager.d();
    }

    LibraryInitManager() {
    }

    private final void d() {
        if (c()) {
            return;
        }
        e();
    }

    private final void e() {
        Object m476constructorimpl;
        String str;
        IAEResUtil iAEResUtil;
        AEResInfo aEResInfo;
        IVasTempApi.Companion companion = IVasTempApi.INSTANCE;
        QRouteApi api = QRoute.api(IVasTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasTempApi::class.java)");
        final IVasTempApi iVasTempApi = (IVasTempApi) api;
        if (MobileQQ.sProcessId != 1) {
            try {
                Result.Companion companion2 = Result.INSTANCE;
                iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
                aEResInfo = AEResInfo.LIGHT_RES_PAG;
            } catch (Throwable th5) {
                Result.Companion companion3 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (iAEResUtil.isAEResExist(aEResInfo)) {
                QLog.i("LibraryInitManager", 1, "already download");
                f377186a.f(iVasTempApi.initPagSo());
                return;
            }
            BaseApplication context = BaseApplication.getContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION);
            Unit unit = Unit.INSTANCE;
            context.registerReceiver(this, intentFilter);
            broadcastHasRegistered = true;
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    str = m479exceptionOrNullimpl.getMessage();
                } else {
                    str = null;
                }
                QLog.e("LibraryInitManager", 1, "loadPagWithIPC throw e:" + str);
                return;
            }
            return;
        }
        iVasTempApi.requestPagDownload(new Function0<Unit>() { // from class: com.tencent.timi.game.initer.impl.LibraryInitManager$loadPAGWithIPC$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LibraryInitManager.f377186a.f(IVasTempApi.this.initPagSo());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(boolean result) {
        if (!result) {
            QLog.e("LibraryInitManager", 1, "PAG download failed");
            return;
        }
        status = 3;
        if (broadcastHasRegistered) {
            BaseApplication.getContext().unregisterReceiver(this);
            broadcastHasRegistered = false;
        }
        Iterator<T> it = pagLibraryLoadedListenerList.iterator();
        while (it.hasNext()) {
            final WeakReference weakReference = (WeakReference) it.next();
            w.c(new Runnable() { // from class: com.tencent.timi.game.initer.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    LibraryInitManager.g(WeakReference.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(WeakReference weakReference) {
        hi4.c cVar = (hi4.c) weakReference.get();
        if (cVar != null) {
            cVar.onLoaded();
        }
    }

    public final boolean c() {
        if (status == 3) {
            return true;
        }
        return false;
    }

    public final void h(@NotNull hi4.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        i(listener);
        pagLibraryLoadedListenerList.add(new WeakReference<>(listener));
    }

    public final void i(@NotNull final hi4.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CollectionsKt__MutableCollectionsKt.removeAll((List) pagLibraryLoadedListenerList, (Function1) new Function1<WeakReference<hi4.c>, Boolean>() { // from class: com.tencent.timi.game.initer.impl.LibraryInitManager$unregisterOnPAGLibraryLoadedListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(WeakReference<hi4.c> weakReference) {
                return Boolean.valueOf(Intrinsics.areEqual(weakReference.get(), hi4.c.this));
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        Intrinsics.checkNotNull(intent);
        if (Intrinsics.areEqual(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION, intent.getAction())) {
            String stringExtra = intent.getStringExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BUNDLE_REGISTER_PATH);
            String stringExtra2 = intent.getStringExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_AGENT_TYPE);
            QLog.i("LibraryInitManager", 1, "\u6536\u5230\u5e7f\u64ad: path = " + stringExtra + " agent = " + stringExtra2);
            if (AEResInfo.LIGHT_RES_PAG.agentType.equals(stringExtra2)) {
                IVasTempApi.Companion companion = IVasTempApi.INSTANCE;
                QRouteApi api = QRoute.api(IVasTempApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IVasTempApi::class.java)");
                f(((IVasTempApi) api).initPagSo());
            }
        }
    }
}
