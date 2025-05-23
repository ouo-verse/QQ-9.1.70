package com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig;

import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.inference.WinkInferenceResManager;
import com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0002H\u0007R8\u0010\u000e\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00050\u0005 \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u000b0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/resmanager/albumconfig/WinkNewAlbumTextFeatureManager;", "Lkotlinx/coroutines/CoroutineScope;", "", "d", "f", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/albumconfig/a;", "callback", "c", "g", "", "kotlin.jvm.PlatformType", "", "e", "Ljava/util/Set;", "fetchResultCallbackList", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumTextFeatureManager implements CoroutineScope {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final WinkNewAlbumTextFeatureManager f324317d = new WinkNewAlbumTextFeatureManager();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Set<a> fetchResultCallbackList = Collections.newSetFromMap(new ConcurrentHashMap());

    WinkNewAlbumTextFeatureManager() {
    }

    private final void d() {
        WinkInferenceResManager.f322940a.B(new com.tencent.mobileqq.wink.inference.a() { // from class: com.tencent.mobileqq.wink.newalbum.resmanager.albumconfig.b
            @Override // com.tencent.mobileqq.wink.inference.a
            public final void a(Object obj) {
                WinkNewAlbumTextFeatureManager.e((WinkNewAlbumTextFetchResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(WinkNewAlbumTextFetchResult result) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(f324317d, Dispatchers.getMain(), null, new WinkNewAlbumTextFeatureManager$callbackFetchResultIfNeed$1$1$1(result, null), 2, null);
            if (launch$default != null) {
                return;
            }
        }
        QLog.w("WinkNewAlbum_WinkNewAlbumTextFeatureManager", 1, "callbackFetchResultIfNeed, fetchResult is null ");
        Unit unit = Unit.INSTANCE;
    }

    private final void f() {
        String str;
        int i3;
        w83.b bVar = w83.b.f445025a;
        if (!bVar.L()) {
            QLog.d("WinkNewAlbum_WinkNewAlbumTextFeatureManager", 1, "fetchAlbumConfigInMainProcess, isHitExpNewAlbum is false ");
            return;
        }
        if (!bVar.P()) {
            QLog.d("WinkNewAlbum_WinkNewAlbumTextFeatureManager", 1, "fetchAlbumConfigInMainProcess, isNewAlbumOpen is false ");
            return;
        }
        WinkNewAlbumResConfig.Companion companion = WinkNewAlbumResConfig.INSTANCE;
        WinkNewAlbumResConfig b16 = companion.b();
        String str2 = null;
        if (b16 != null) {
            str = b16.k();
        } else {
            str = null;
        }
        QLog.d("WinkNewAlbum_WinkNewAlbumTextFeatureManager", 1, "fetchAlbumConfigInMainProcess, remoteResConfig:" + str);
        if (b16 != null && b16.getTextVersion() != 0) {
            WinkNewAlbumResConfig a16 = companion.a();
            if (a16 != null) {
                str2 = a16.k();
            }
            QLog.d("WinkNewAlbum_WinkNewAlbumTextFeatureManager", 1, "fetchAlbumConfigInMainProcess, localResConfig:" + str2);
            int i16 = 0;
            if (a16 != null) {
                i3 = a16.getTextVersion();
            } else {
                i3 = 0;
            }
            QLog.d("WinkNewAlbum_WinkNewAlbumTextFeatureManager", 1, "loc: " + i3 + ", remo: " + b16.getTextVersion());
            int textVersion = b16.getTextVersion();
            if (a16 != null) {
                i16 = a16.getTextVersion();
            }
            if (textVersion <= i16) {
                d();
                return;
            }
            QLog.d("WinkNewAlbum_WinkNewAlbumTextFeatureManager", 1, "fetchAlbumConfigInMainProcess, start ");
            b16.j();
            QLog.d("WinkNewAlbum_WinkNewAlbumTextFeatureManager", 1, "fetchAlbumConfigInMainProcess, config save local ");
            d();
            QLog.d("WinkNewAlbum_WinkNewAlbumTextFeatureManager", 1, "fetchAlbumConfigInMainProcess, end ");
        }
    }

    public final void c(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("WinkNewAlbum_WinkNewAlbumTextFeatureManager", 1, "asyncGetResFetchResult, callback:" + callback);
        fetchResultCallbackList.add(callback);
        d();
    }

    @JvmOverloads
    public final void g() {
        QLog.d("WinkNewAlbum_WinkNewAlbumTextFeatureManager", 1, "fetchNewAlbumTextRes, process:" + MobileQQ.sProcessId);
        f();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return WinkCoroutineScopes.f317652a.c().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("WinkNewAlbum_WinkNewAlbumTextFeatureManager"));
    }
}
