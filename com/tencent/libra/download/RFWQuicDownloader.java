package com.tencent.libra.download;

import androidx.annotation.WorkerThread;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.download.lightquic.LightQuicRequestCallback;
import com.tencent.libra.download.lightquic.RFWLightQuic;
import com.tencent.libra.download.lightquic.RFWLightQuicSession;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00014B/\b\u0007\u0012\u0006\u0010$\u001a\u00020!\u0012\b\b\u0002\u0010(\u001a\u00020%\u0012\b\b\u0002\u0010,\u001a\u00020)\u0012\b\b\u0002\u00100\u001a\u00020-\u00a2\u0006\u0004\b1\u00102J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R,\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u00160\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R2\u0010 \u001a \u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/libra/download/RFWQuicDownloader;", "Lcom/tencent/libra/download/ILibraDownloader;", "Lcom/tencent/libra/request/Option;", "option", "", "canDownload", "Lcom/tencent/libra/download/ILibraDownloader$PicDownLoadListener;", "listener", "", "downLoad", "cancel", "Ljava/util/HashMap;", "", "Lcom/tencent/libra/download/lightquic/RFWLightQuicSession;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "sessionByOptionLocalPath", "", "e", "Ljava/lang/Object;", "sessionLock", "", "", "f", "Ljava/util/Map;", "listenersByLocalPath", "Lkotlin/Function4;", "Lcom/tencent/libra/download/lightquic/LightQuicRequestCallback$RequestResultCode;", "", h.F, "Lkotlin/jvm/functions/Function4;", "onLightQuicSessionFinished", "Lcom/tencent/libra/download/LibraDns;", "i", "Lcom/tencent/libra/download/LibraDns;", "libraDns", "Lcom/tencent/libra/download/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/libra/download/d;", "retryStrategy", "Lcom/tencent/libra/download/lightquic/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/libra/download/lightquic/a;", "lightQuic", "Lkotlinx/coroutines/CoroutineDispatcher;", "D", "Lkotlinx/coroutines/CoroutineDispatcher;", "workerDispatcher", "<init>", "(Lcom/tencent/libra/download/LibraDns;Lcom/tencent/libra/download/d;Lcom/tencent/libra/download/lightquic/a;Lkotlinx/coroutines/CoroutineDispatcher;)V", "E", "a", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class RFWQuicDownloader implements ILibraDownloader {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.libra.download.lightquic.a lightQuic;

    /* renamed from: D, reason: from kotlin metadata */
    private final CoroutineDispatcher workerDispatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, RFWLightQuicSession> sessionByOptionLocalPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Object sessionLock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Map<Integer, ILibraDownloader.PicDownLoadListener>> listenersByLocalPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Function4<String, Boolean, LightQuicRequestCallback.RequestResultCode, byte[], Unit> onLightQuicSessionFinished;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final LibraDns libraDns;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final d retryStrategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/libra/download/RFWQuicDownloader$a;", "", "Lcom/tencent/libra/request/Option;", "option", "", "a", "", "CONFIG_KEY_QQCIRCLE_PIC_DOWNLOAD_ENABLED_QUIC", "Ljava/lang/String;", "CONFIG_KEY_QQCIRCLE_PIC_DOWNLOAD_QUIC_DOMAINS", "DEFAULT_DOMAIN", "TAG", "<init>", "()V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.libra.download.RFWQuicDownloader$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
        
            r2 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r6, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(@Nullable Option option) {
            Object m476constructorimpl;
            Collection listOf;
            List plus;
            List split$default;
            int collectionSizeOrDefault;
            boolean z16;
            CharSequence trim;
            if (option != null) {
                com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
                if (aVar.e(option) > 0 || !aVar.i(option)) {
                    return false;
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(new URL(option.getUrl()));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m479exceptionOrNullimpl(m476constructorimpl) == null) {
                    URL url = (URL) m476constructorimpl;
                    String configValue = RFWConfig.getConfigValue("qqcircle_pic_download_quic_domains", "world.qpic.cn");
                    if (configValue == null || split$default == null) {
                        listOf = CollectionsKt__CollectionsJVMKt.listOf("world.qpic.cn");
                    } else {
                        List<String> list = split$default;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        for (String str : list) {
                            if (str != null) {
                                trim = StringsKt__StringsKt.trim((CharSequence) str);
                                arrayList.add(trim.toString());
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        }
                        listOf = new ArrayList();
                        for (Object obj : arrayList) {
                            if (((String) obj).length() > 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                listOf.add(obj);
                            }
                        }
                    }
                    plus = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) ((Collection<? extends Object>) listOf), "worldtest.photo.store.qq.com");
                    String host = url.getHost();
                    if (host != null) {
                        Locale locale = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
                        String lowerCase = host.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        if (lowerCase != null) {
                            if (!plus.contains(lowerCase)) {
                                RFWLog.e("RFWQuicDownloader", RFWLog.USR, "Can download: host " + lowerCase + " not in " + plus);
                                return false;
                            }
                            if (!RFWConfig.getConfigValue("qqcircle_pic_download_enabled_quic", true)) {
                                return false;
                            }
                            return true;
                        }
                    }
                    RFWLog.e("RFWQuicDownloader", RFWLog.USR, "Can download: url is invalidate without host: " + option.getUrl());
                    return false;
                }
                RFWLog.e("RFWQuicDownloader", RFWLog.USR, "Can download: url is invalidate: " + option.getUrl());
            }
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmOverloads
    public RFWQuicDownloader(@NotNull LibraDns libraDns, @NotNull d retryStrategy, @NotNull com.tencent.libra.download.lightquic.a lightQuic, @NotNull CoroutineDispatcher workerDispatcher) {
        Intrinsics.checkNotNullParameter(libraDns, "libraDns");
        Intrinsics.checkNotNullParameter(retryStrategy, "retryStrategy");
        Intrinsics.checkNotNullParameter(lightQuic, "lightQuic");
        Intrinsics.checkNotNullParameter(workerDispatcher, "workerDispatcher");
        this.libraDns = libraDns;
        this.retryStrategy = retryStrategy;
        this.lightQuic = lightQuic;
        this.workerDispatcher = workerDispatcher;
        this.sessionByOptionLocalPath = new HashMap<>();
        this.sessionLock = new Object();
        this.listenersByLocalPath = new LinkedHashMap();
        this.onLightQuicSessionFinished = new Function4<String, Boolean, LightQuicRequestCallback.RequestResultCode, byte[], Unit>() { // from class: com.tencent.libra.download.RFWQuicDownloader$onLightQuicSessionFinished$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool, LightQuicRequestCallback.RequestResultCode requestResultCode, byte[] bArr) {
                invoke(str, bool.booleanValue(), requestResultCode, bArr);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String localPath, boolean z16, @NotNull LightQuicRequestCallback.RequestResultCode errorCode, @NotNull byte[] byteArray) {
                Object obj;
                Object m476constructorimpl;
                Map map;
                Map map2;
                HashMap hashMap;
                Map map3;
                Map map4;
                Intrinsics.checkNotNullParameter(localPath, "localPath");
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                Intrinsics.checkNotNullParameter(byteArray, "byteArray");
                obj = RFWQuicDownloader.this.sessionLock;
                synchronized (obj) {
                    if (z16) {
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            File file = new File(localPath);
                            if (file.exists()) {
                                RFWLog.e("RFWQuicDownloader", RFWLog.USR, "file exists: " + localPath + ". is director: " + file.isDirectory());
                                file.delete();
                            }
                            RFWFileUtils.createFile(localPath);
                            FileOutputStream fileOutputStream = new FileOutputStream(localPath);
                            try {
                                fileOutputStream.write(byteArray);
                                Unit unit = Unit.INSTANCE;
                                Unit unit2 = null;
                                CloseableKt.closeFinally(fileOutputStream, null);
                                map2 = RFWQuicDownloader.this.listenersByLocalPath;
                                Map map5 = (Map) map2.get(localPath);
                                if (map5 != null) {
                                    Iterator it = map5.entrySet().iterator();
                                    while (it.hasNext()) {
                                        ((ILibraDownloader.PicDownLoadListener) ((Map.Entry) it.next()).getValue()).onResult(true, 0);
                                    }
                                    unit2 = Unit.INSTANCE;
                                }
                                m476constructorimpl = Result.m476constructorimpl(unit2);
                            } finally {
                            }
                        } catch (Throwable th5) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                        }
                        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                        if (m479exceptionOrNullimpl != null) {
                            File file2 = new File(localPath);
                            if (file2.exists()) {
                                file2.delete();
                            }
                            RFWLog.e("RFWQuicDownloader", RFWLog.USR, "Download success but write file failed. localPath: " + localPath, m479exceptionOrNullimpl);
                            map = RFWQuicDownloader.this.listenersByLocalPath;
                            Map map6 = (Map) map.get(localPath);
                            if (map6 != null) {
                                Iterator it5 = map6.entrySet().iterator();
                                while (it5.hasNext()) {
                                    ((ILibraDownloader.PicDownLoadListener) ((Map.Entry) it5.next()).getValue()).onResult(false, errorCode.ordinal());
                                }
                            }
                        }
                    } else {
                        RFWLog.e("RFWQuicDownloader", RFWLog.USR, "Download failed for localPath: " + localPath + ", errorCode: " + errorCode);
                        map4 = RFWQuicDownloader.this.listenersByLocalPath;
                        Map map7 = (Map) map4.get(localPath);
                        if (map7 != null) {
                            Iterator it6 = map7.entrySet().iterator();
                            while (it6.hasNext()) {
                                ((ILibraDownloader.PicDownLoadListener) ((Map.Entry) it6.next()).getValue()).onResult(false, errorCode.ordinal());
                            }
                        }
                    }
                    hashMap = RFWQuicDownloader.this.sessionByOptionLocalPath;
                    hashMap.remove(localPath);
                    map3 = RFWQuicDownloader.this.listenersByLocalPath;
                    map3.remove(localPath);
                    Unit unit3 = Unit.INSTANCE;
                }
            }
        };
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public boolean canDownload(@Nullable Option option) {
        return INSTANCE.a(option);
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public void cancel(@Nullable Option option) {
        if (option != null) {
            synchronized (this.sessionLock) {
                String localPath = option.getLocalPath();
                RFWLightQuicSession rFWLightQuicSession = this.sessionByOptionLocalPath.get(localPath);
                Map<Integer, ILibraDownloader.PicDownLoadListener> map = this.listenersByLocalPath.get(localPath);
                if (map != null) {
                    map.remove(Integer.valueOf(option.getSeq()));
                    if (map.isEmpty() && rFWLightQuicSession != null) {
                        RFWLog.e("RFWQuicDownloader", RFWLog.USR, "Cancel failed, no session found for localPath: " + localPath);
                        rFWLightQuicSession.k();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    @WorkerThread
    public void downLoad(@Nullable Option option, @Nullable ILibraDownloader.PicDownLoadListener listener) {
        RFWLog.i("RFWQuicDownloader", RFWLog.USR, "Start download\uff1a " + option);
        if (option != null) {
            synchronized (this.sessionLock) {
                String localPath = option.getLocalPath();
                if (listener != null) {
                    Map<String, Map<Integer, ILibraDownloader.PicDownLoadListener>> map = this.listenersByLocalPath;
                    Intrinsics.checkNotNullExpressionValue(localPath, "localPath");
                    Map<Integer, ILibraDownloader.PicDownLoadListener> map2 = map.get(localPath);
                    if (map2 == null) {
                        map2 = new LinkedHashMap<>();
                        map.put(localPath, map2);
                    }
                    map2.put(Integer.valueOf(option.getSeq()), listener);
                }
                HashMap<String, RFWLightQuicSession> hashMap = this.sessionByOptionLocalPath;
                Intrinsics.checkNotNullExpressionValue(localPath, "localPath");
                RFWLightQuicSession rFWLightQuicSession = hashMap.get(localPath);
                if (rFWLightQuicSession == null) {
                    com.tencent.libra.download.lightquic.a aVar = this.lightQuic;
                    String localPath2 = option.getLocalPath();
                    Intrinsics.checkNotNullExpressionValue(localPath2, "option.localPath");
                    String url = option.getUrl();
                    Intrinsics.checkNotNullExpressionValue(url, "option.url");
                    rFWLightQuicSession = new RFWLightQuicSession(aVar, localPath2, url, this.workerDispatcher, this.onLightQuicSessionFinished, this.retryStrategy, false, null, 192, null);
                    hashMap.put(localPath, rFWLightQuicSession);
                }
                RFWLightQuicSession rFWLightQuicSession2 = rFWLightQuicSession;
            }
        }
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public /* synthetic */ boolean needDownloadOnWorkThread() {
        return a.b(this);
    }

    public /* synthetic */ RFWQuicDownloader(LibraDns libraDns, d dVar, com.tencent.libra.download.lightquic.a aVar, CoroutineDispatcher coroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(libraDns, (i3 & 2) != 0 ? c.f118671a : dVar, (i3 & 4) != 0 ? new RFWLightQuic(libraDns) : aVar, (i3 & 8) != 0 ? RFWQuicDownloaderKt.b() : coroutineDispatcher);
    }
}
