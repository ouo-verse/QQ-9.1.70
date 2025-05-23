package com.tencent.qqnt.qbasealbum.urldrawable;

import android.content.Context;
import android.os.HandlerThread;
import android.util.LruCache;
import android.util.Pair;
import com.tencent.image.api.ICache;
import com.tencent.image.api.ILog;
import com.tencent.image.api.IThreadListener;
import com.tencent.image.api.IThreadManager;
import com.tencent.image.api.ITool;
import com.tencent.image.api.IVersion;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.coroutine.QAlbumCoroutineScopes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.net.URLStreamHandlerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/URLDrawableDepWrapInit;", "", "Lcom/tencent/image/api/URLDrawableDepWrap;", "b", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class URLDrawableDepWrapInit {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final URLDrawableDepWrapInit f361600a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/qbasealbum/urldrawable/URLDrawableDepWrapInit$a", "Lcom/tencent/image/api/ITool;", "Landroid/content/Context;", "getContext", "context", "", "soName", "", "loadSoByName", "Ljava/net/URLStreamHandlerFactory;", "getFactory", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends ITool {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.api.ITool
        @NotNull
        public Context getContext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return com.tencent.qqnt.qbasealbum.inject.a.f361230a.a();
        }

        @Override // com.tencent.image.api.ITool
        @Nullable
        public URLStreamHandlerFactory getFactory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (URLStreamHandlerFactory) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return null;
        }

        @Override // com.tencent.image.api.ITool
        public boolean loadSoByName(@NotNull Context context, @NotNull String soName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) soName)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(soName, "soName");
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J$\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"com/tencent/qqnt/qbasealbum/urldrawable/URLDrawableDepWrapInit$b", "Lcom/tencent/image/api/ICache;", "", "key", "", "get", "value", "", "priority", "put", "", "remove", "evictAll", "getNormalPriority", "Landroid/util/LruCache;", "a", "Landroid/util/LruCache;", "getMLruCache", "()Landroid/util/LruCache;", "setMLruCache", "(Landroid/util/LruCache;)V", "mLruCache", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements ICache {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private LruCache<String, Object> mLruCache;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/qbasealbum/urldrawable/URLDrawableDepWrapInit$b$a", "Landroid/util/LruCache;", "", "", "key", "value", "", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        public static final class a extends LruCache<String, Object> {
            static IPatchRedirector $redirector_;

            a() {
                super(104857600);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int sizeOf(@NotNull String key, @Nullable Object value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, value)).intValue();
                }
                Intrinsics.checkNotNullParameter(key, "key");
                if (value instanceof Pair) {
                    Object obj = ((Pair) value).second;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) obj).intValue();
                }
                return 100;
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mLruCache = new a();
            }
        }

        @Override // com.tencent.image.api.ICache
        public void evictAll() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                this.mLruCache.evictAll();
            }
        }

        @Override // com.tencent.image.api.ICache
        @Nullable
        public Object get(@NotNull String key) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) key);
            }
            Intrinsics.checkNotNullParameter(key, "key");
            return this.mLruCache.get(key);
        }

        @Override // com.tencent.image.api.ICache
        public byte getNormalPriority() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Byte) iPatchRedirector.redirect((short) 8, (Object) this)).byteValue();
            }
            return (byte) 0;
        }

        @Override // com.tencent.image.api.ICache
        @Nullable
        public Object put(@NotNull String key, @Nullable Object value, byte priority) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, this, key, value, Byte.valueOf(priority));
            }
            Intrinsics.checkNotNullParameter(key, "key");
            return this.mLruCache.put(key, value);
        }

        @Override // com.tencent.image.api.ICache
        public void remove(@NotNull String key) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) key);
            } else {
                Intrinsics.checkNotNullParameter(key, "key");
                this.mLruCache.remove(key);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J \u0010\u0007\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J(\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/qqnt/qbasealbum/urldrawable/URLDrawableDepWrapInit$c", "Lcom/tencent/image/api/ILog;", "", "isColorLevel", "", ReportConstant.COSTREPORT_PREFIX, "", "i", ICustomDataEditor.STRING_PARAM_1, "", "d", "", "throwable", "e", "w", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements ILog {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.api.ILog
        public void d(@NotNull String s16, int i3, @NotNull String s17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(i3), s17);
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            Intrinsics.checkNotNullParameter(s17, "s1");
            QLog.d(s16, i3, s17);
        }

        @Override // com.tencent.image.api.ILog
        public void e(@NotNull String s16, int i3, @NotNull String s17, @NotNull Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, s16, Integer.valueOf(i3), s17, throwable);
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            Intrinsics.checkNotNullParameter(s17, "s1");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            QLog.e(s16, i3, s17, throwable);
        }

        @Override // com.tencent.image.api.ILog
        public void i(@NotNull String s16, int i3, @NotNull String s17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, s16, Integer.valueOf(i3), s17);
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            Intrinsics.checkNotNullParameter(s17, "s1");
            QLog.i(s16, i3, s17);
        }

        @Override // com.tencent.image.api.ILog
        public boolean isColorLevel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return QLog.isColorLevel();
        }

        @Override // com.tencent.image.api.ILog
        public void w(@NotNull String s16, int i3, @NotNull String s17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, s16, Integer.valueOf(i3), s17);
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            Intrinsics.checkNotNullParameter(s17, "s1");
            QLog.w(s16, i3, s17);
        }

        @Override // com.tencent.image.api.ILog
        public void e(@NotNull String s16, int i3, @NotNull String s17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, s16, Integer.valueOf(i3), s17);
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            Intrinsics.checkNotNullParameter(s17, "s1");
            QLog.e(s16, i3, s17);
        }

        @Override // com.tencent.image.api.ILog
        public void i(@NotNull String s16, int i3, @NotNull String s17, @NotNull Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, s16, Integer.valueOf(i3), s17, throwable);
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            Intrinsics.checkNotNullParameter(s17, "s1");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            QLog.d(s16, i3, s17, throwable);
        }

        @Override // com.tencent.image.api.ILog
        public void w(@NotNull String s16, int i3, @NotNull Throwable throwable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, s16, Integer.valueOf(i3), throwable);
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            QLog.w(s16, i3, "", throwable);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45246);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f361600a = new URLDrawableDepWrapInit();
        }
    }

    URLDrawableDepWrapInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c() {
        return com.tencent.qqnt.qbasealbum.inject.g.f361234b.isPublicVersion();
    }

    @NotNull
    public final URLDrawableDepWrap b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (URLDrawableDepWrap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        URLDrawableDepWrap uRLDrawableDepWrap = new URLDrawableDepWrap();
        uRLDrawableDepWrap.defaultInit(new a());
        uRLDrawableDepWrap.mCache = new b();
        uRLDrawableDepWrap.mLog = new c();
        uRLDrawableDepWrap.mThreadManager = new IThreadManager() { // from class: com.tencent.qqnt.qbasealbum.urldrawable.URLDrawableDepWrapInit$generateDepWrap$4
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final HandlerThread subHandlerThread;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final HandlerThread fileHandlerThread;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("qbasealbum-sub");
                this.subHandlerThread = baseHandlerThread;
                BaseHandlerThread baseHandlerThread2 = new BaseHandlerThread("qbasealbum-file");
                this.fileHandlerThread = baseHandlerThread2;
                baseHandlerThread.start();
                baseHandlerThread2.start();
            }

            @Override // com.tencent.image.api.IThreadManager
            public void executeOnFileThreadExcutor(@NotNull Runnable runnable, @Nullable IThreadListener listener, boolean canAutoRetrieve) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, runnable, listener, Boolean.valueOf(canAutoRetrieve));
                } else {
                    Intrinsics.checkNotNullParameter(runnable, "runnable");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QAlbumCoroutineScopes.f361069a.b()), null, null, new URLDrawableDepWrapInit$generateDepWrap$4$executeOnFileThreadExcutor$1(runnable, null), 3, null);
                }
            }

            @Override // com.tencent.image.api.IThreadManager
            public void executeOnNetThreadExcutor(@NotNull Runnable runnable, @Nullable IThreadListener listener, boolean canAutoRetrieve) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, this, runnable, listener, Boolean.valueOf(canAutoRetrieve));
                } else {
                    Intrinsics.checkNotNullParameter(runnable, "runnable");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QAlbumCoroutineScopes.f361069a.c()), null, null, new URLDrawableDepWrapInit$generateDepWrap$4$executeOnNetThreadExcutor$1(runnable, null), 3, null);
                }
            }

            @Override // com.tencent.image.api.IThreadManager
            @NotNull
            public HandlerThread getFileThread() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (HandlerThread) iPatchRedirector2.redirect((short) 3, (Object) this);
                }
                return this.fileHandlerThread;
            }

            @Override // com.tencent.image.api.IThreadManager
            @NotNull
            public HandlerThread getSubThread() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HandlerThread) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return this.subHandlerThread;
            }
        };
        uRLDrawableDepWrap.mVersion = new IVersion() { // from class: com.tencent.qqnt.qbasealbum.urldrawable.f
            @Override // com.tencent.image.api.IVersion
            public final boolean isPublicVersion() {
                boolean c16;
                c16 = URLDrawableDepWrapInit.c();
                return c16;
            }
        };
        ox3.a.a("URLDrawableDepWrapInit", URLDrawableDepWrapInit$generateDepWrap$6.INSTANCE);
        return uRLDrawableDepWrap;
    }
}
