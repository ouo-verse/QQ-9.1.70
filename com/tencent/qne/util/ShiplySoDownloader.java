package com.tencent.qne.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qne.delegate.e;
import com.tencent.qne.model.PreloadStatusCode;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010$\u001a\u00020\u0004\u00a2\u0006\u0004\b%\u0010&J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J1\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011JR\u0010\u001a\u001a\u00020\u0007*\u00020\u000228\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b0\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018J\u001c\u0010\u001c\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001b*\u0004\u0018\u00010\u0002R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010!R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/qne/util/ShiplySoDownloader;", "", "Lorg/json/JSONObject;", "shiplyInfo", "", "soFolder", "resourceId", "", "g", "", "specificTaskId", "", "checkMd5", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Z)Z", "Lcom/tencent/qne/util/c;", "c", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "predicate", "Lkotlin/Function0;", "action", "e", "Lkotlin/Pair;", "f", "Lcom/tencent/qne/delegate/d;", "a", "Lcom/tencent/qne/delegate/d;", "shiply", "Ljava/lang/String;", "Ljava/lang/Long;", "d", "unzipPath", "<init>", "(Lcom/tencent/qne/delegate/d;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final class ShiplySoDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final a f344361e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    @NotNull
    private static final Lazy<Mutex> f344362f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qne.delegate.d shiply;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String resourceId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Long specificTaskId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String unzipPath;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qne/util/ShiplySoDownloader$a;", "", "Lkotlinx/coroutines/sync/Mutex;", "unzipMutex$delegate", "Lkotlin/Lazy;", "a", "()Lkotlinx/coroutines/sync/Mutex;", "unzipMutex", "", "SHIPLY_INFO", "Ljava/lang/String;", "TAG", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes22.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final Mutex a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Mutex) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (Mutex) ShiplySoDownloader.f344362f.getValue();
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<Mutex> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f344361e = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(ShiplySoDownloader$Companion$unzipMutex$2.INSTANCE);
        f344362f = lazy;
    }

    public ShiplySoDownloader(@NotNull com.tencent.qne.delegate.d shiply, @NotNull String resourceId, @Nullable Long l3, @NotNull String unzipPath) {
        Intrinsics.checkNotNullParameter(shiply, "shiply");
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        Intrinsics.checkNotNullParameter(unzipPath, "unzipPath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, shiply, resourceId, l3, unzipPath);
            return;
        }
        this.shiply = shiply;
        this.resourceId = resourceId;
        this.specificTaskId = l3;
        this.unzipPath = unzipPath;
    }

    private final boolean b(final String soFolder, final String resourceId, final Long specificTaskId, final boolean checkMd5) {
        boolean z16;
        JSONObject d16;
        if (soFolder.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        final File file = new File(soFolder);
        if (!file.exists() || !file.isDirectory() || (d16 = com.tencent.qne.util.a.d(com.tencent.qne.util.a.e(soFolder, Intrinsics.stringPlus(resourceId, Sticker.JSON_SUFFIX)))) == null) {
            return false;
        }
        if (specificTaskId != null && !d16.has("ShiplyInfo")) {
            Logger.e("[qne]ShiplySoDownloader", "cannot find ShiplyInfo in config for resource " + resourceId + ", folder:" + file);
            com.tencent.qne.util.a.a(soFolder);
            return false;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        e(d16, new Function2<String, JSONObject, Boolean>(specificTaskId, resourceId, file, soFolder, this, checkMd5) { // from class: com.tencent.qne.util.ShiplySoDownloader$checkLocalCacheValidOrNot$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $checkMd5;
            final /* synthetic */ File $folder;
            final /* synthetic */ String $resourceId;
            final /* synthetic */ String $soFolder;
            final /* synthetic */ Long $specificTaskId;
            final /* synthetic */ ShiplySoDownloader this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$specificTaskId = specificTaskId;
                this.$resourceId = resourceId;
                this.$folder = file;
                this.$soFolder = soFolder;
                this.this$0 = this;
                this.$checkMd5 = checkMd5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, specificTaskId, resourceId, file, soFolder, this, Boolean.valueOf(checkMd5));
                }
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Boolean invoke(@NotNull String name, @Nullable JSONObject jSONObject) {
                boolean equals;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) name, (Object) jSONObject);
                }
                Intrinsics.checkNotNullParameter(name, "name");
                if (Intrinsics.areEqual(name, "ShiplyInfo")) {
                    if (this.$specificTaskId == null) {
                        return Boolean.FALSE;
                    }
                    Long valueOf = jSONObject == null ? null : Long.valueOf(jSONObject.optLong("specificTaskId"));
                    if (valueOf == null) {
                        Logger.e("[qne]ShiplySoDownloader", "cannot find version for resource " + this.$resourceId + ", folder:" + this.$folder);
                        return Boolean.TRUE;
                    }
                    boolean areEqual = Intrinsics.areEqual(valueOf, this.$specificTaskId);
                    Logger.i("[qne]ShiplySoDownloader", "check specificTaskId for resource " + this.$resourceId + ", match:" + areEqual + ", current:" + valueOf + ", specific:" + this.$specificTaskId);
                    return Boolean.valueOf(!areEqual);
                }
                String e16 = a.e(this.$soFolder, name);
                if (e16 == null || e16.length() == 0) {
                    Logger.e("[qne]ShiplySoDownloader", Intrinsics.stringPlus("can not find path for ", name));
                    return Boolean.TRUE;
                }
                Pair<Long, String> f16 = this.this$0.f(jSONObject);
                Long component1 = f16.component1();
                String component2 = f16.component2();
                if (component1 != null) {
                    if (!(component2 == null || component2.length() == 0)) {
                        long length = new File(e16).length();
                        if (length != component1.longValue()) {
                            Logger.e("[qne]ShiplySoDownloader", "check size for " + name + " fail, config size:" + component1 + ", real size:" + length);
                            return Boolean.TRUE;
                        }
                        if (this.$checkMd5) {
                            long currentTimeMillis = System.currentTimeMillis();
                            String a16 = Md5UtilKt.a(e16);
                            equals = StringsKt__StringsJVMKt.equals(a16, component2, true);
                            if (!equals) {
                                Logger.e("[qne]ShiplySoDownloader", "check md5 for " + name + " fail, config md5:" + component1 + ", real md5:" + ((Object) a16));
                                return Boolean.TRUE;
                            }
                            Logger.i("[qne]ShiplySoDownloader", "check md5 for " + name + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
                        }
                        return Boolean.FALSE;
                    }
                }
                Logger.e("[qne]ShiplySoDownloader", "get config for " + name + ", size:" + component1 + ", md5:" + ((Object) component2) + " fail");
                return Boolean.TRUE;
            }
        }, new Function0<Unit>(file, soFolder, booleanRef) { // from class: com.tencent.qne.util.ShiplySoDownloader$checkLocalCacheValidOrNot$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.BooleanRef $allSoCheckSuccess;
            final /* synthetic */ File $folder;
            final /* synthetic */ String $soFolder;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$folder = file;
                this.$soFolder = soFolder;
                this.$allSoCheckSuccess = booleanRef;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, file, soFolder, booleanRef);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Logger.e("[qne]ShiplySoDownloader", Intrinsics.stringPlus("checkLocalCacheValidOrNot fail, deleteDirectory:", this.$folder));
                a.a(this.$soFolder);
                this.$allSoCheckSuccess.element = false;
            }
        });
        return booleanRef.element;
    }

    public static /* synthetic */ Object d(ShiplySoDownloader shiplySoDownloader, boolean z16, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return shiplySoDownloader.c(z16, continuation);
    }

    private final void g(JSONObject shiplyInfo, String soFolder, String resourceId) {
        if (!com.tencent.qne.util.a.b(soFolder)) {
            return;
        }
        String e16 = com.tencent.qne.util.a.e(soFolder, Intrinsics.stringPlus(resourceId, Sticker.JSON_SUFFIX));
        JSONObject d16 = com.tencent.qne.util.a.d(e16);
        if (d16 != null) {
            d16.put("ShiplyInfo", shiplyInfo);
        }
        com.tencent.qne.util.a.f(d16, e16);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0130 A[Catch: all -> 0x01a5, TRY_LEAVE, TryCatch #0 {all -> 0x01a5, blocks: (B:19:0x0124, B:21:0x0130, B:24:0x0155, B:26:0x015d), top: B:18:0x0124 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0155 A[Catch: all -> 0x01a5, TRY_ENTER, TryCatch #0 {all -> 0x01a5, blocks: (B:19:0x0124, B:21:0x0130, B:24:0x0155, B:26:0x015d), top: B:18:0x0124 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0072  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(boolean z16, @NotNull Continuation<? super c> continuation) {
        ShiplySoDownloader$fetch$1 shiplySoDownloader$fetch$1;
        Object coroutine_suspended;
        int i3;
        ShiplySoDownloader shiplySoDownloader;
        int a16;
        boolean z17;
        boolean z18;
        ShiplySoDownloader shiplySoDownloader2;
        e eVar;
        Mutex mutex;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), continuation);
        }
        if (continuation instanceof ShiplySoDownloader$fetch$1) {
            shiplySoDownloader$fetch$1 = (ShiplySoDownloader$fetch$1) continuation;
            int i16 = shiplySoDownloader$fetch$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                shiplySoDownloader$fetch$1.label = i16 - Integer.MIN_VALUE;
                Object obj = shiplySoDownloader$fetch$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = shiplySoDownloader$fetch$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            mutex = (Mutex) shiplySoDownloader$fetch$1.L$3;
                            str = (String) shiplySoDownloader$fetch$1.L$2;
                            eVar = (e) shiplySoDownloader$fetch$1.L$1;
                            shiplySoDownloader2 = (ShiplySoDownloader) shiplySoDownloader$fetch$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            try {
                                if (!shiplySoDownloader2.b(shiplySoDownloader2.unzipPath, shiplySoDownloader2.resourceId, shiplySoDownloader2.specificTaskId, true)) {
                                    Logger.w("[qne]ShiplySoDownloader", "fetch " + shiplySoDownloader2.resourceId + " download success, but do not unzip");
                                    return new c(shiplySoDownloader2.resourceId, true, true);
                                }
                                boolean h16 = com.tencent.qne.util.a.h(str, shiplySoDownloader2.unzipPath);
                                if (h16) {
                                    shiplySoDownloader2.g(eVar.f(), shiplySoDownloader2.unzipPath, shiplySoDownloader2.resourceId);
                                }
                                if (h16) {
                                    z19 = shiplySoDownloader2.b(shiplySoDownloader2.unzipPath, shiplySoDownloader2.resourceId, shiplySoDownloader2.specificTaskId, true);
                                }
                                Logger.i("[qne]ShiplySoDownloader", "fetch " + shiplySoDownloader2.resourceId + " download success, unzip:" + h16 + ", check:" + z19);
                                return new c(shiplySoDownloader2.resourceId, z19, true);
                            } finally {
                                mutex.unlock(null);
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    shiplySoDownloader = (ShiplySoDownloader) shiplySoDownloader$fetch$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (b(this.unzipPath, this.resourceId, this.specificTaskId, z16)) {
                        Logger.i("[qne]ShiplySoDownloader", "fetch " + this.resourceId + " succeed with local cache, path:" + this.unzipPath);
                        return new c(this.resourceId, true, false);
                    }
                    Logger.i("[qne]ShiplySoDownloader", "fetch " + this.resourceId + " download start, path:" + this.unzipPath);
                    com.tencent.qne.delegate.d dVar = this.shiply;
                    String str2 = this.resourceId;
                    Long l3 = this.specificTaskId;
                    shiplySoDownloader$fetch$1.L$0 = this;
                    shiplySoDownloader$fetch$1.label = 1;
                    obj = dVar.a(str2, l3, shiplySoDownloader$fetch$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    shiplySoDownloader = this;
                }
                e eVar2 = (e) obj;
                a16 = eVar2.a();
                if (a16 == PreloadStatusCode.DownloadSuccess.getValue() || a16 == PreloadStatusCode.NotNeedDownload.getValue()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                String c16 = eVar2.c();
                if (z17) {
                    if (c16 != null && c16.length() != 0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (!z18) {
                        Mutex a17 = f344361e.a();
                        shiplySoDownloader$fetch$1.L$0 = shiplySoDownloader;
                        shiplySoDownloader$fetch$1.L$1 = eVar2;
                        shiplySoDownloader$fetch$1.L$2 = c16;
                        shiplySoDownloader$fetch$1.L$3 = a17;
                        shiplySoDownloader$fetch$1.label = 2;
                        if (a17.lock(null, shiplySoDownloader$fetch$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        shiplySoDownloader2 = shiplySoDownloader;
                        eVar = eVar2;
                        mutex = a17;
                        str = c16;
                        if (!shiplySoDownloader2.b(shiplySoDownloader2.unzipPath, shiplySoDownloader2.resourceId, shiplySoDownloader2.specificTaskId, true)) {
                        }
                    }
                }
                Logger.e("[qne]ShiplySoDownloader", "fetch " + shiplySoDownloader.resourceId + " download failed");
                return new c(shiplySoDownloader.resourceId, false, true);
            }
        }
        shiplySoDownloader$fetch$1 = new ShiplySoDownloader$fetch$1(this, continuation);
        Object obj2 = shiplySoDownloader$fetch$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = shiplySoDownloader$fetch$1.label;
        if (i3 == 0) {
        }
        e eVar22 = (e) obj2;
        a16 = eVar22.a();
        if (a16 == PreloadStatusCode.DownloadSuccess.getValue()) {
            z17 = false;
            String c162 = eVar22.c();
            if (z17) {
            }
            Logger.e("[qne]ShiplySoDownloader", "fetch " + shiplySoDownloader.resourceId + " download failed");
            return new c(shiplySoDownloader.resourceId, false, true);
        }
        z17 = true;
        String c1622 = eVar22.c();
        if (z17) {
        }
        Logger.e("[qne]ShiplySoDownloader", "fetch " + shiplySoDownloader.resourceId + " download failed");
        return new c(shiplySoDownloader.resourceId, false, true);
    }

    public final void e(@NotNull JSONObject jSONObject, @NotNull Function2<? super String, ? super JSONObject, Boolean> predicate, @NotNull Function0<Unit> action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, jSONObject, predicate, action);
            return;
        }
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(key);
            Intrinsics.checkNotNullExpressionValue(key, "key");
            if (predicate.invoke(key, optJSONObject).booleanValue()) {
                action.invoke();
                return;
            }
        }
    }

    @NotNull
    public final Pair<Long, String> f(@Nullable JSONObject jSONObject) {
        Long valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSONObject);
        }
        String str = null;
        if (jSONObject == null) {
            valueOf = null;
        } else {
            valueOf = Long.valueOf(jSONObject.optLong("size"));
        }
        if (jSONObject != null) {
            str = jSONObject.optString("md5");
        }
        return new Pair<>(valueOf, str);
    }
}
