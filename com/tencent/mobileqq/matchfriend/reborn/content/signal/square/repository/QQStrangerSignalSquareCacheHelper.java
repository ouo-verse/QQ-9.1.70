package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalRecommendRsp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\rR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSquareCacheHelper;", "", "", "byteArray", "", WadlProxyConsts.PARAM_FILENAME, "", "i", "f", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalRecommendRsp;", "rsp", "g", "e", "", "d", "timeMillis", h.F, "Ljava/io/File;", "a", "Lkotlin/Lazy;", "b", "()Ljava/io/File;", "cacheDir", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "c", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "entity", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSquareCacheHelper {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy<ReentrantLock> f244987d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy cacheDir;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy entity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSquareCacheHelper$a;", "", "Ljava/util/concurrent/locks/ReentrantLock;", "cacheLock$delegate", "Lkotlin/Lazy;", "b", "()Ljava/util/concurrent/locks/ReentrantLock;", "cacheLock", "", "CACHE_FILE_SIGNAL_SELF", "Ljava/lang/String;", "CACHE_FILE_SIGNAL_SQUARE", "CACHE_PATH", "KEY_CACHE_SHOW_EXPIRE_TIME", "TAG", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareCacheHelper$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ReentrantLock b() {
            return (ReentrantLock) QQStrangerSignalSquareCacheHelper.f244987d.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ReentrantLock> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ReentrantLock>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareCacheHelper$Companion$cacheLock$2
            @Override // kotlin.jvm.functions.Function0
            public final ReentrantLock invoke() {
                return new ReentrantLock();
            }
        });
        f244987d = lazy;
    }

    public QQStrangerSignalSquareCacheHelper() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<File>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareCacheHelper$cacheDir$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return new File(BaseApplication.getContext().getCacheDir(), "qqstrangercache");
            }
        });
        this.cacheDir = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntityV2>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareCacheHelper$entity$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MMKVOptionEntityV2 invoke() {
                return QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            }
        });
        this.entity = lazy2;
    }

    private final File b() {
        return (File) this.cacheDir.getValue();
    }

    private final MMKVOptionEntityV2 c() {
        return (MMKVOptionEntityV2) this.entity.getValue();
    }

    private final byte[] f(String fileName) {
        byte[] readBytes;
        ReentrantLock b16 = INSTANCE.b();
        b16.lock();
        try {
            try {
                File file = new File(b(), fileName);
                if (file.exists() && file.length() > 0) {
                    readBytes = FilesKt__FileReadWriteKt.readBytes(file);
                    return readBytes;
                }
            } catch (Exception e16) {
                QLog.e("QQStrangerSignalSquareCacheHelper", 1, "loadFromFile exception: " + e16);
            }
            b16.unlock();
            return null;
        } finally {
            b16.unlock();
        }
    }

    private final void i(byte[] byteArray, String fileName) {
        ReentrantLock b16 = INSTANCE.b();
        b16.lock();
        try {
            if (!b().exists()) {
                b().mkdirs();
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(b(), fileName));
                    try {
                        fileOutputStream2.write(byteArray);
                        FileUtils.close(fileOutputStream2);
                    } catch (IOException e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        QLog.e("QQStrangerSignalSquareCacheHelper", 1, "saveToFile exception: " + e);
                        if (fileOutputStream != null) {
                            FileUtils.close(fileOutputStream);
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            FileUtils.close(fileOutputStream);
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e17) {
                e = e17;
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
            b16.unlock();
        }
    }

    public final long d() {
        String selfOpenId = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId();
        return c().getLong("key_cache_show_expire_time__" + selfOpenId, 0L);
    }

    public final void g(SignalPlazaSvrPB$SignalRecommendRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
            if (currentAccountUin == null) {
                currentAccountUin = "";
            }
            byte[] byteArray = rsp.toByteArray();
            if (byteArray != null) {
                i(byteArray, "signal_square_" + currentAccountUin);
            }
        } catch (Exception e16) {
            QLog.e("QQStrangerSignalSquareCacheHelper", 1, "putSignalRecommendRspToCache exception: " + e16);
        }
    }

    public final void h(long timeMillis) {
        String selfOpenId = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId();
        c().putLong("key_cache_show_expire_time__" + selfOpenId, timeMillis);
    }

    public final SignalPlazaSvrPB$SignalRecommendRsp e() {
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
            if (currentAccountUin == null) {
                currentAccountUin = "";
            }
            byte[] f16 = f("signal_square_" + currentAccountUin);
            if (f16 == null) {
                return null;
            }
            SignalPlazaSvrPB$SignalRecommendRsp signalPlazaSvrPB$SignalRecommendRsp = new SignalPlazaSvrPB$SignalRecommendRsp();
            signalPlazaSvrPB$SignalRecommendRsp.mergeFrom(f16);
            return signalPlazaSvrPB$SignalRecommendRsp;
        } catch (Exception e16) {
            QLog.e("QQStrangerSignalSquareCacheHelper", 1, "getSignalRecommendRspFromCache exception: " + e16);
            return null;
        }
    }
}
