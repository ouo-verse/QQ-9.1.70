package com.tencent.mobileqq.wink.downloader;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.wink.utils.au;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J/\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ/\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\rJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0010R#\u0010\u0017\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/downloader/WinkQZoneMediaDownloader;", "", "", h.F, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "downloadUrl", "e", "g", "", "downloadUrls", "", "d", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lcom/tencent/superplayer/api/ISPlayerDownloader;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "f", "()Lcom/tencent/superplayer/api/ISPlayerDownloader;", "superPlayerDownload", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneMediaDownloader {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkQZoneMediaDownloader f318202a = new WinkQZoneMediaDownloader();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy superPlayerDownload;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isInited", "", "onSDKInited"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class c implements SDKInitListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f318209d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super Boolean> continuation) {
            this.f318209d = continuation;
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public final void onSDKInited(boolean z16) {
            w53.b.f("WinkQZoneMediaDownloader", "initSDKAsync done");
            this.f318209d.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ISPlayerDownloader>() { // from class: com.tencent.mobileqq.wink.downloader.WinkQZoneMediaDownloader$superPlayerDownload$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ISPlayerDownloader invoke() {
                return SuperPlayerFactory.createDownloader(MobileQQ.sMobileQQ.getApplicationContext(), 153);
            }
        });
        superPlayerDownload = lazy;
    }

    WinkQZoneMediaDownloader() {
    }

    private final ISPlayerDownloader f() {
        return (ISPlayerDownloader) superPlayerDownload.getValue();
    }

    private final Object h(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        if (!QQVideoPlaySDKManager.isSoLoadSucess()) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            w53.b.f("WinkQZoneMediaDownloader", "initSDKAsync start");
            QQVideoPlaySDKManager.initSDKAsync(MobileQQ.sMobileQQ.getApplicationContext(), new c(safeContinuation));
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return Boxing.boxBoolean(true);
    }

    @Nullable
    public final Object a(@NotNull String str, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        String c16 = au.f326689a.c(str);
        String e16 = e(c16);
        if (!new File(e16).exists()) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            SafeContinuation safeContinuation = new SafeContinuation(intercepted);
            AppInterface a16 = com.tencent.mobileqq.wink.b.a();
            if (a16 == null) {
                safeContinuation.resumeWith(Result.m476constructorimpl(null));
            } else {
                IHttpEngineService iHttpEngineService = (IHttpEngineService) a16.getRuntimeService(IHttpEngineService.class, "all");
                HttpNetReq httpNetReq = new HttpNetReq();
                httpNetReq.mReqUrl = c16;
                httpNetReq.mHttpMethod = 0;
                httpNetReq.mOutPath = e16;
                httpNetReq.mContinuErrorLimit = 2;
                httpNetReq.mCallback = new a(safeContinuation, e16);
                iHttpEngineService.sendReq(httpNetReq);
            }
            Object orThrow = safeContinuation.getOrThrow();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (orThrow == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
        return e16;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0078 -> B:10:0x0079). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(@NotNull List<String> list, @NotNull Continuation<? super Map<String, String>> continuation) {
        WinkQZoneMediaDownloader$downloadImages$1 winkQZoneMediaDownloader$downloadImages$1;
        Object coroutine_suspended;
        int i3;
        int collectionSizeOrDefault;
        Iterator it;
        Collection collection;
        Map map;
        boolean z16;
        if (continuation instanceof WinkQZoneMediaDownloader$downloadImages$1) {
            winkQZoneMediaDownloader$downloadImages$1 = (WinkQZoneMediaDownloader$downloadImages$1) continuation;
            int i16 = winkQZoneMediaDownloader$downloadImages$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkQZoneMediaDownloader$downloadImages$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkQZoneMediaDownloader$downloadImages$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkQZoneMediaDownloader$downloadImages$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        collection = (Collection) winkQZoneMediaDownloader$downloadImages$1.L$3;
                        String str = (String) winkQZoneMediaDownloader$downloadImages$1.L$2;
                        it = (Iterator) winkQZoneMediaDownloader$downloadImages$1.L$1;
                        Collection collection2 = (Collection) winkQZoneMediaDownloader$downloadImages$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        String str2 = (String) obj;
                        if (str2 == null && str2.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            return null;
                        }
                        collection.add(TuplesKt.to(str, str2));
                        collection = collection2;
                        if (it.hasNext()) {
                            map = MapsKt__MapsKt.toMap((List) collection);
                            return map;
                        }
                        str = (String) it.next();
                        WinkQZoneMediaDownloader winkQZoneMediaDownloader = f318202a;
                        winkQZoneMediaDownloader$downloadImages$1.L$0 = collection;
                        winkQZoneMediaDownloader$downloadImages$1.L$1 = it;
                        winkQZoneMediaDownloader$downloadImages$1.L$2 = str;
                        winkQZoneMediaDownloader$downloadImages$1.L$3 = collection;
                        winkQZoneMediaDownloader$downloadImages$1.label = 1;
                        obj = winkQZoneMediaDownloader.a(str, winkQZoneMediaDownloader$downloadImages$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        collection2 = collection;
                        String str22 = (String) obj;
                        if (str22 == null) {
                        }
                        z16 = true;
                        if (!z16) {
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    List<String> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    it = list2.iterator();
                    collection = arrayList;
                    if (it.hasNext()) {
                    }
                }
            }
        }
        winkQZoneMediaDownloader$downloadImages$1 = new WinkQZoneMediaDownloader$downloadImages$1(this, continuation);
        Object obj2 = winkQZoneMediaDownloader$downloadImages$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkQZoneMediaDownloader$downloadImages$1.label;
        if (i3 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(@NotNull String str, @NotNull Continuation<? super String> continuation) {
        WinkQZoneMediaDownloader$downloadVideo$1 winkQZoneMediaDownloader$downloadVideo$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        WinkQZoneMediaDownloader winkQZoneMediaDownloader;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof WinkQZoneMediaDownloader$downloadVideo$1) {
            winkQZoneMediaDownloader$downloadVideo$1 = (WinkQZoneMediaDownloader$downloadVideo$1) continuation;
            int i16 = winkQZoneMediaDownloader$downloadVideo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkQZoneMediaDownloader$downloadVideo$1.label = i16 - Integer.MIN_VALUE;
                obj = winkQZoneMediaDownloader$downloadVideo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkQZoneMediaDownloader$downloadVideo$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) winkQZoneMediaDownloader$downloadVideo$1.L$1;
                    winkQZoneMediaDownloader = (WinkQZoneMediaDownloader) winkQZoneMediaDownloader$downloadVideo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    winkQZoneMediaDownloader$downloadVideo$1.L$0 = this;
                    winkQZoneMediaDownloader$downloadVideo$1.L$1 = str;
                    winkQZoneMediaDownloader$downloadVideo$1.label = 1;
                    obj = h(winkQZoneMediaDownloader$downloadVideo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkQZoneMediaDownloader = this;
                }
                if (((Boolean) obj).booleanValue()) {
                    return null;
                }
                String g16 = winkQZoneMediaDownloader.g(str);
                if (new File(g16).exists()) {
                    return g16;
                }
                if (QLog.isColorLevel()) {
                    w53.b.f("WinkQZoneMediaDownloader", "[downloadVideo] url=" + str);
                }
                winkQZoneMediaDownloader$downloadVideo$1.L$0 = str;
                winkQZoneMediaDownloader$downloadVideo$1.L$1 = g16;
                winkQZoneMediaDownloader$downloadVideo$1.label = 2;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(winkQZoneMediaDownloader$downloadVideo$1);
                SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                f318202a.f().startOfflineDownload(SuperPlayerFactory.createVideoInfoForUrl(str, 104, (String) null, g16), new b(str, safeContinuation, g16));
                obj = safeContinuation.getOrThrow();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(winkQZoneMediaDownloader$downloadVideo$1);
                }
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        winkQZoneMediaDownloader$downloadVideo$1 = new WinkQZoneMediaDownloader$downloadVideo$1(this, continuation);
        obj = winkQZoneMediaDownloader$downloadVideo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkQZoneMediaDownloader$downloadVideo$1.label;
        if (i3 == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0098 -> B:11:0x0099). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(@NotNull List<String> list, @NotNull Continuation<? super Map<String, String>> continuation) {
        WinkQZoneMediaDownloader$downloadVideos$1 winkQZoneMediaDownloader$downloadVideos$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        int collectionSizeOrDefault;
        Iterator it;
        Collection collection;
        Map map;
        boolean z16;
        if (continuation instanceof WinkQZoneMediaDownloader$downloadVideos$1) {
            winkQZoneMediaDownloader$downloadVideos$1 = (WinkQZoneMediaDownloader$downloadVideos$1) continuation;
            int i16 = winkQZoneMediaDownloader$downloadVideos$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkQZoneMediaDownloader$downloadVideos$1.label = i16 - Integer.MIN_VALUE;
                obj = winkQZoneMediaDownloader$downloadVideos$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkQZoneMediaDownloader$downloadVideos$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            collection = (Collection) winkQZoneMediaDownloader$downloadVideos$1.L$3;
                            String str = (String) winkQZoneMediaDownloader$downloadVideos$1.L$2;
                            it = (Iterator) winkQZoneMediaDownloader$downloadVideos$1.L$1;
                            Collection collection2 = (Collection) winkQZoneMediaDownloader$downloadVideos$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            String str2 = (String) obj;
                            if (str2 == null && str2.length() != 0) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (!z16) {
                                return null;
                            }
                            collection.add(TuplesKt.to(str, str2));
                            collection = collection2;
                            if (it.hasNext()) {
                                map = MapsKt__MapsKt.toMap((List) collection);
                                return map;
                            }
                            str = (String) it.next();
                            WinkQZoneMediaDownloader winkQZoneMediaDownloader = f318202a;
                            winkQZoneMediaDownloader$downloadVideos$1.L$0 = collection;
                            winkQZoneMediaDownloader$downloadVideos$1.L$1 = it;
                            winkQZoneMediaDownloader$downloadVideos$1.L$2 = str;
                            winkQZoneMediaDownloader$downloadVideos$1.L$3 = collection;
                            winkQZoneMediaDownloader$downloadVideos$1.label = 2;
                            obj = winkQZoneMediaDownloader.c(str, winkQZoneMediaDownloader$downloadVideos$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            collection2 = collection;
                            String str22 = (String) obj;
                            if (str22 == null) {
                            }
                            z16 = true;
                            if (!z16) {
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        list = (List) winkQZoneMediaDownloader$downloadVideos$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    winkQZoneMediaDownloader$downloadVideos$1.L$0 = list;
                    winkQZoneMediaDownloader$downloadVideos$1.label = 1;
                    obj = h(winkQZoneMediaDownloader$downloadVideos$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    return null;
                }
                List<String> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                it = list2.iterator();
                collection = arrayList;
                if (it.hasNext()) {
                }
            }
        }
        winkQZoneMediaDownloader$downloadVideos$1 = new WinkQZoneMediaDownloader$downloadVideos$1(this, continuation);
        obj = winkQZoneMediaDownloader$downloadVideos$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkQZoneMediaDownloader$downloadVideos$1.label;
        if (i3 == 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    @NotNull
    public final String e(@NotNull String downloadUrl) {
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        return com.tencent.mobileqq.wink.downloader.b.f318210a.c() + "/" + com.tencent.securitysdk.utils.c.b(downloadUrl);
    }

    @NotNull
    public final String g(@NotNull String downloadUrl) {
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        return com.tencent.mobileqq.wink.downloader.b.f318210a.c() + "/" + com.tencent.securitysdk.utils.c.b(downloadUrl) + ".mp4";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0016J8\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0015H\u0016\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/wink/downloader/WinkQZoneMediaDownloader$b", "Lcom/tencent/superplayer/api/ISPlayerDownloader$Listener;", "", "p0", "p1", "p2", "", "p3", "p4", "", "p5", "", "onDownloadProgressUpdate", "onDownloadFinish", "onDownloadError", "onDownloadCdnUrlUpdate", "onDownloadCdnUrlInfoUpdate", "", "onDownloadCdnUrlExpired", "onDownloadStatusUpdate", "onDownloadProtocolUpdate", "Lcom/tencent/thumbplayer/core/datatransport/aidl/TPDataTransportMessageInfo;", "onCommonMessageCallback", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ISPlayerDownloader.Listener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f318206a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f318207b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f318208c;

        /* JADX WARN: Multi-variable type inference failed */
        b(String str, Continuation<? super String> continuation, String str2) {
            this.f318206a = str;
            this.f318207b = continuation;
            this.f318208c = str2;
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadError(int p06, int p16, int p26, @Nullable String p36) {
            if (QLog.isColorLevel()) {
                w53.b.f("WinkQZoneMediaDownloader", "[onDownloadError] url=" + this.f318206a);
            }
            this.f318207b.resumeWith(Result.m476constructorimpl(null));
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadFinish(int p06) {
            if (QLog.isColorLevel()) {
                w53.b.f("WinkQZoneMediaDownloader", "[onDownloadFinish] url=" + this.f318206a);
            }
            Continuation<String> continuation = this.f318207b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(this.f318208c));
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadCdnUrlExpired(int p06, @Nullable Map<String, String> p16) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadCdnUrlUpdate(int p06, @Nullable String p16) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadStatusUpdate(int p06, int p16) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onCommonMessageCallback(int p06, int p16, @Nullable TPDataTransportMessageInfo p26) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadProtocolUpdate(int p06, @Nullable String p16, @Nullable String p26) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadCdnUrlInfoUpdate(int p06, @Nullable String p16, @Nullable String p26, @Nullable String p36, @Nullable String p46) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadProgressUpdate(int p06, int p16, int p26, long p36, long p46, @Nullable String p56) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/downloader/WinkQZoneMediaDownloader$a", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<String> f318204d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f318205e;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super String> continuation, String str) {
            this.f318204d = continuation;
            this.f318205e = str;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(@NotNull NetResp resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            int i3 = resp.mResult;
            if (i3 == 0) {
                Continuation<String> continuation = this.f318204d;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(this.f318205e));
            } else if (i3 != 3) {
                this.f318204d.resumeWith(Result.m476constructorimpl(null));
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(@Nullable NetReq req, long curOffset, long totalLen) {
        }
    }
}
