package com.tencent.mobileqq.vas.font.manager;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.vas.font.manager.h;
import com.tencent.mobileqq.vas.font.report.VasFontReporter;
import com.tencent.mobileqq.vas.updatesystem.business.FontSoBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u0000 \u00192\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/font/manager/i;", "Lcom/tencent/mobileqq/vas/font/manager/h;", "", "c", "", "a", "Lcom/tencent/mobileqq/vas/font/manager/h$b;", "listener", "b", "", "Ljava/lang/String;", "soPathName", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "loadLibState", "Ljava/util/concurrent/CopyOnWriteArraySet;", "", "d", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mSoLoadListenerSet", "e", "Z", "mSoLoadSuccess", "<init>", "(Ljava/lang/String;)V", "f", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class i implements h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String soPathName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger loadLibState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArraySet<Object> mSoLoadListenerSet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mSoLoadSuccess;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/font/manager/i$b", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f309253a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f309254b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h.b f309255c;

        b(String str, i iVar, h.b bVar) {
            this.f309253a = str;
            this.f309254b = iVar;
            this.f309255c = bVar;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            QLog.e("SoLoadManager", 1, "so onLoadFail");
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            if (new File(this.f309253a).exists()) {
                this.f309254b.b(this.f309255c);
                return;
            }
            QLog.e("SoLoadManager", 1, "so onLoadSuccess bug file not exists soPath : " + this.f309253a);
        }
    }

    public i(@NotNull String soPathName) {
        Intrinsics.checkNotNullParameter(soPathName, "soPathName");
        this.loadLibState = new AtomicInteger(-2);
        this.mSoLoadListenerSet = new CopyOnWriteArraySet<>();
        this.soPathName = soPathName;
    }

    private final void c() {
        Iterator<Object> it = this.mSoLoadListenerSet.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "mSoLoadListenerSet.iterator()");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.mobileqq.vas.font.manager.ISoLoadManager.LoadListener");
            ((h.b) next).a(this.mSoLoadSuccess);
        }
        this.mSoLoadListenerSet.clear();
    }

    public synchronized boolean a() {
        boolean z16;
        if (this.loadLibState.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public synchronized void b(@Nullable h.b listener) {
        String replace$default;
        String replace$default2;
        if (listener != null) {
            this.mSoLoadListenerSet.add(listener);
        }
        if (this.loadLibState.get() == 0) {
            if (listener != null) {
                listener.a(this.mSoLoadSuccess);
                this.mSoLoadListenerSet.remove(listener);
            }
            QLog.i("SoLoadManager", 1, "so has been loaded");
            return;
        }
        if (this.loadLibState.get() == -1) {
            QLog.i("SoLoadManager", 1, "so has been loading");
            return;
        }
        FontSoBusiness fontSoBusiness = FontSoBusiness.instance;
        String soPath = fontSoBusiness.getSoPath(this.soPathName);
        if (!new File(soPath).exists()) {
            fontSoBusiness.startDownloadSo(this.soPathName, new b(soPath, this, listener));
            return;
        }
        this.loadLibState.set(-1);
        try {
            System.load(soPath);
            QLog.i("SoLoadManager", 1, "so load success");
            this.mSoLoadSuccess = true;
            this.loadLibState.set(0);
            c();
        } catch (Throwable th5) {
            QLog.e("SoLoadManager", 1, "load so library failed:" + th5);
            replace$default = StringsKt__StringsJVMKt.replace$default(VasFontReporter.ERROR_SO_LOAD, "{soPath}", this.soPathName, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{errorMsg}", String.valueOf(th5.getMessage()), false, 4, (Object) null);
            VasFontReporter.INSTANCE.report(replace$default2);
        }
    }
}
