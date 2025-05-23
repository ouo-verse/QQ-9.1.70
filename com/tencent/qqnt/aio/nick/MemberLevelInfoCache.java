package com.tencent.qqnt.aio.nick;

import android.util.LruCache;
import com.google.gson.Gson;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0003\u000e\u0012\u0017B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\bJ\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/nick/MemberLevelInfoCache;", "", "", tl.h.F, "", "groupUid", "senderUid", "g", "Lcom/tencent/qqnt/aio/nick/f;", "e", "info", "l", "j", "Lcom/tencent/qqnt/aio/nick/MemberLevelInfoCache$c;", "a", "Lcom/tencent/qqnt/aio/nick/MemberLevelInfoCache$c;", "infoLruCache", "", "b", "Lkotlin/Lazy;", "f", "()Z", NodeProps.ENABLED, "c", "Z", "dataChangedSinceSerialization", "<init>", "()V", "d", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MemberLevelInfoCache {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<MMKVOptionEntity> f351683e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<MemberLevelInfoCache> f351684f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c infoLruCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy enabled;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean dataChangedSinceSerialization;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0007B\u001b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0004\b\u000b\u0010\fB\t\b\u0016\u00a2\u0006\u0004\b\u000b\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/nick/MemberLevelInfoCache$a;", "", "", "b", "", "", "Lcom/tencent/qqnt/aio/nick/f;", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "snapshot", "<init>", "(Ljava/util/Map;)V", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, f> snapshot;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/nick/MemberLevelInfoCache$a$a;", "", "", "bytes", "Lcom/tencent/qqnt/aio/nick/MemberLevelInfoCache$a;", "a", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.aio.nick.MemberLevelInfoCache$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes23.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            @NotNull
            public final a a(@Nullable byte[] bytes) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bytes);
                }
                if (bytes != null) {
                    if (bytes.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        try {
                            Object fromJson = new Gson().fromJson(new String(bytes, Charsets.UTF_8), (Class<Object>) a.class);
                            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(json, CacheData::class.java)");
                            return (a) fromJson;
                        } catch (Exception e16) {
                            QLog.w("MemberLevelInfo", 1, "[fromBytes] exception!!! exc=" + e16);
                            return new a();
                        }
                    }
                }
                return new a();
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51199);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public a(@NotNull Map<String, f> snapshot) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.snapshot = snapshot;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) snapshot);
            }
        }

        @NotNull
        public final Map<String, f> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.snapshot;
        }

        @NotNull
        public final byte[] b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            try {
                String json = new Gson().toJson(this);
                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
                byte[] bytes = json.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                return bytes;
            } catch (Exception e16) {
                QLog.w("MemberLevelInfo", 1, "[toBytes] exception!!! exc=" + e16);
                return new byte[0];
            }
        }

        public a() {
            this(new HashMap());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/nick/MemberLevelInfoCache$b;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkv$delegate", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkv", "Lcom/tencent/qqnt/aio/nick/MemberLevelInfoCache;", "instance$delegate", "b", "()Lcom/tencent/qqnt/aio/nick/MemberLevelInfoCache;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "CACHE_SIZE", "I", "", "KEY_MMKV_CACHE", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.nick.MemberLevelInfoCache$b, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final MMKVOptionEntity c() {
            return (MMKVOptionEntity) MemberLevelInfoCache.f351683e.getValue();
        }

        @NotNull
        public final MemberLevelInfoCache b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MemberLevelInfoCache) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (MemberLevelInfoCache) MemberLevelInfoCache.f351684f.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/nick/MemberLevelInfoCache$c;", "Landroid/util/LruCache;", "", "Lcom/tencent/qqnt/aio/nick/f;", "key", "a", "", "evicted", "oldValue", "newValue", "", "b", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends LruCache<String, f> {
        static IPatchRedirector $redirector_;

        public c() {
            super(100);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f create(@NotNull String key) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key);
            }
            Intrinsics.checkNotNullParameter(key, "key");
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean evicted, @NotNull String key, @NotNull f oldValue, @Nullable f newValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(evicted), key, oldValue, newValue);
                return;
            }
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(oldValue, "oldValue");
            super.entryRemoved(evicted, key, oldValue, newValue);
        }
    }

    static {
        Lazy<MMKVOptionEntity> lazy;
        Lazy<MemberLevelInfoCache> lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51209);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(MemberLevelInfoCache$Companion$mmkv$2.INSTANCE);
        f351683e = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) MemberLevelInfoCache$Companion$instance$2.INSTANCE);
        f351684f = lazy2;
    }

    public MemberLevelInfoCache() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.infoLruCache = new c();
        lazy = LazyKt__LazyJVMKt.lazy(MemberLevelInfoCache$enabled$2.INSTANCE);
        this.enabled = lazy;
        h();
    }

    private final boolean f() {
        return ((Boolean) this.enabled.getValue()).booleanValue();
    }

    private final String g(String groupUid, String senderUid) {
        return groupUid + "-" + senderUid;
    }

    private final void h() {
        if (!f()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.nick.g
            @Override // java.lang.Runnable
            public final void run() {
                MemberLevelInfoCache.i(MemberLevelInfoCache.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MemberLevelInfoCache this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StopWatch i3 = new StopWatch("MemberLevelInfo-loadCache", QLog.isColorLevel()).i();
        byte[] decodeBytes = INSTANCE.c().decodeBytes("MemberLevelInfoCache", new byte[0]);
        i3.e("read " + decodeBytes.length + " from mmkv");
        a a16 = a.INSTANCE.a(decodeBytes);
        i3.e("deserialize " + a16.a().size() + " entries");
        synchronized (this$0.infoLruCache) {
            for (Map.Entry<String, f> entry : a16.a().entrySet()) {
                this$0.infoLruCache.put(entry.getKey(), entry.getValue());
            }
            Unit unit = Unit.INSTANCE;
        }
        i3.b("fill cache with " + a16.a().size() + " entries");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MemberLevelInfoCache this$0) {
        Map<String, f> snapshot;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StopWatch i3 = new StopWatch("MemberLevelInfo-serializeCaches", QLog.isColorLevel()).i();
        synchronized (this$0.infoLruCache) {
            snapshot = this$0.infoLruCache.snapshot();
            Intrinsics.checkNotNullExpressionValue(snapshot, "infoLruCache.snapshot()");
            Unit unit = Unit.INSTANCE;
        }
        i3.e("snapshot");
        byte[] b16 = new a(snapshot).b();
        i3.e("serialize " + snapshot.size() + " entries");
        INSTANCE.c().encodeBytes("MemberLevelInfoCache", b16);
        i3.b("save " + b16.length + " bytes");
    }

    @Nullable
    public final f e(@NotNull String groupUid, @NotNull String senderUid) {
        boolean z16;
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupUid, (Object) senderUid);
        }
        Intrinsics.checkNotNullParameter(groupUid, "groupUid");
        Intrinsics.checkNotNullParameter(senderUid, "senderUid");
        if (!f()) {
            return null;
        }
        boolean z17 = true;
        if (groupUid.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (senderUid.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                String g16 = g(groupUid, senderUid);
                synchronized (this.infoLruCache) {
                    fVar = this.infoLruCache.get(g16);
                }
                return fVar;
            }
        }
        return null;
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (!f() || !this.dataChangedSinceSerialization) {
                return;
            }
            this.dataChangedSinceSerialization = false;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.nick.h
                @Override // java.lang.Runnable
                public final void run() {
                    MemberLevelInfoCache.k(MemberLevelInfoCache.this);
                }
            }, 16, null, false);
        }
    }

    public final void l(@NotNull String groupUid, @NotNull String senderUid, @Nullable f info) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, groupUid, senderUid, info);
            return;
        }
        Intrinsics.checkNotNullParameter(groupUid, "groupUid");
        Intrinsics.checkNotNullParameter(senderUid, "senderUid");
        if (!f()) {
            return;
        }
        boolean z17 = false;
        if (groupUid.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (senderUid.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                this.dataChangedSinceSerialization = true;
                String g16 = g(groupUid, senderUid);
                synchronized (this.infoLruCache) {
                    if (info != null) {
                        this.infoLruCache.put(g16, info);
                    } else {
                        this.infoLruCache.remove(g16);
                    }
                }
            }
        }
    }
}
