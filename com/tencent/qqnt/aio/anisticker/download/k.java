package com.tencent.qqnt.aio.anisticker.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.emoticonview.download.EmoLottieResReloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\t\nB\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\bH\u0004R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR6\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/download/k;", "Landroid/os/Handler$Callback;", "Landroid/os/Message;", "msg", "", "handleMessage", "", "cacheKey", "", "a", "b", "c", "Lcom/tencent/qqnt/aio/anisticker/download/k$b;", "d", "Lcom/tencent/qqnt/aio/anisticker/download/k$b;", "mResReloadListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "getMWaitingReloadList", "()Ljava/util/ArrayList;", "setMWaitingReloadList", "(Ljava/util/ArrayList;)V", "mWaitingReloadList", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "mHandler", "Ljava/util/concurrent/locks/Lock;", tl.h.F, "Ljava/util/concurrent/locks/Lock;", "mLoadingLock", "<init>", "(Lcom/tencent/qqnt/aio/anisticker/download/k$b;)V", "i", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class k implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b mResReloadListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<String> mWaitingReloadList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lock mLoadingLock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0004X\u0084T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/download/k$a;", "", "", "MSG_RELOAD_DRAWABLE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.anisticker.download.k$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/download/k$b;", "", "", "cacheKey", "", "startReloadDrawable", "triggerDownloadRes", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface b {
        void startReloadDrawable(@Nullable String cacheKey);

        void triggerDownloadRes();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34388);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public k(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.mResReloadListener = bVar;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mLoadingLock = new ReentrantLock();
    }

    public final void a(@NotNull String cacheKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cacheKey);
            return;
        }
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.mLoadingLock.lock();
        try {
            if (this.mWaitingReloadList == null) {
                this.mWaitingReloadList = new ArrayList<>();
                c();
            }
            ArrayList<String> arrayList = this.mWaitingReloadList;
            Intrinsics.checkNotNull(arrayList);
            if (!arrayList.contains(cacheKey)) {
                ArrayList<String> arrayList2 = this.mWaitingReloadList;
                Intrinsics.checkNotNull(arrayList2);
                arrayList2.add(0, cacheKey);
                if (QLog.isColorLevel()) {
                    ArrayList<String> arrayList3 = this.mWaitingReloadList;
                    Intrinsics.checkNotNull(arrayList3);
                    QLog.d(EmoLottieResReloader.TAG, 2, "addReloadLottieDrawable key:", cacheKey, " ,size:", Integer.valueOf(arrayList3.size()));
                }
            }
        } finally {
            this.mLoadingLock.unlock();
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mHandler.sendEmptyMessage(10002);
        }
    }

    protected final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        b bVar = this.mResReloadListener;
        if (bVar != null) {
            bVar.triggerDownloadRes();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        ArrayList<String> arrayList;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 10002 && (arrayList = this.mWaitingReloadList) != null) {
            Intrinsics.checkNotNull(arrayList);
            if (arrayList.size() > 0) {
                this.mLoadingLock.lock();
                try {
                    ArrayList<String> arrayList2 = this.mWaitingReloadList;
                    Intrinsics.checkNotNull(arrayList2);
                    if (arrayList2.size() > 0) {
                        ArrayList<String> arrayList3 = this.mWaitingReloadList;
                        Intrinsics.checkNotNull(arrayList3);
                        str = arrayList3.remove(0);
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        b bVar = this.mResReloadListener;
                        if (bVar != null) {
                            bVar.startReloadDrawable(str);
                        }
                        ArrayList<String> arrayList4 = this.mWaitingReloadList;
                        Intrinsics.checkNotNull(arrayList4);
                        if (arrayList4.size() > 0) {
                            this.mHandler.sendEmptyMessageDelayed(10002, 300L);
                        } else if (QLog.isColorLevel()) {
                            QLog.d(EmoLottieResReloader.TAG, 2, "finish reloading");
                        }
                    }
                } finally {
                    this.mLoadingLock.unlock();
                }
            }
        }
        return false;
    }
}
