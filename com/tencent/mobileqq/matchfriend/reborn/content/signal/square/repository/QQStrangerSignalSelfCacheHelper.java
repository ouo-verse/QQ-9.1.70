package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$GetUserSignalRsp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\b\u0010\f\u001a\u0004\u0018\u00010\tR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSelfCacheHelper;", "", "", "byteArray", "", WadlProxyConsts.PARAM_FILENAME, "", "f", "d", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$GetUserSignalRsp;", "rsp", "e", "c", "Ljava/io/File;", "a", "Lkotlin/Lazy;", "b", "()Ljava/io/File;", "cacheDir", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSelfCacheHelper {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy<ReentrantLock> f244979c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy cacheDir;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSelfCacheHelper$a;", "", "Ljava/util/concurrent/locks/ReentrantLock;", "cacheLock$delegate", "Lkotlin/Lazy;", "b", "()Ljava/util/concurrent/locks/ReentrantLock;", "cacheLock", "", "CACHE_FILE_SIGNAL_SELF", "Ljava/lang/String;", "CACHE_PATH", "TAG", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSelfCacheHelper$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ReentrantLock b() {
            return (ReentrantLock) QQStrangerSignalSelfCacheHelper.f244979c.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ReentrantLock> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ReentrantLock>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSelfCacheHelper$Companion$cacheLock$2
            @Override // kotlin.jvm.functions.Function0
            public final ReentrantLock invoke() {
                return new ReentrantLock();
            }
        });
        f244979c = lazy;
    }

    public QQStrangerSignalSelfCacheHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<File>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSelfCacheHelper$cacheDir$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return new File(BaseApplication.getContext().getCacheDir(), "qqstrangercache");
            }
        });
        this.cacheDir = lazy;
    }

    private final File b() {
        return (File) this.cacheDir.getValue();
    }

    private final byte[] d(String fileName) {
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
                QLog.e("QQStrangerSignalSelfCacheHelper", 1, "loadFromFile exception: " + e16);
            }
            b16.unlock();
            return null;
        } finally {
            b16.unlock();
        }
    }

    private final void f(byte[] byteArray, String fileName) {
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
                        QLog.e("QQStrangerSignalSelfCacheHelper", 1, "saveToFile exception: " + e);
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

    public final SignalPlazaSvrPB$GetUserSignalRsp c() {
        Object m476constructorimpl;
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
            if (currentAccountUin == null) {
                currentAccountUin = "";
            }
            byte[] d16 = d("signal_self_" + currentAccountUin);
            if (d16 == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(new SignalPlazaSvrPB$GetUserSignalRsp().mergeFrom(d16));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                QLog.e("QQStrangerSignalSelfCacheHelper", 1, "[getGetUserSignalRspFromCache] mergeFrom error ", m479exceptionOrNullimpl);
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            return (SignalPlazaSvrPB$GetUserSignalRsp) m476constructorimpl;
        } catch (Exception e16) {
            QLog.e("QQStrangerSignalSelfCacheHelper", 1, "getGetUserSignalRspFromCache exception: " + e16);
            return null;
        }
    }

    public final void e(SignalPlazaSvrPB$GetUserSignalRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
            if (currentAccountUin == null) {
                currentAccountUin = "";
            }
            byte[] byteArray = rsp.toByteArray();
            if (byteArray != null) {
                f(byteArray, "signal_self_" + currentAccountUin);
            }
        } catch (Exception e16) {
            QLog.e("QQStrangerSignalSelfCacheHelper", 1, "putGetUserSignalRspToCache exception: " + e16);
        }
    }
}
