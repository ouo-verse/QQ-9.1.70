package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.downloader.WinkQZoneMediaDownloader;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import com.tencent.mobileqq.winkpublish.report.MediaPickerErrorCode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J1\u0010\u000b\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ1\u0010\u000f\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\fJ\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006H\u0002J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/DownloadQZoneMediaInterceptor;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "", "e", "", "g", "", "", "unDownloadVideoUrls", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "unDownloadedVideos", tl.h.F, "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unDownloadImageUrls", "unDownloadedImages", "f", "l", "k", "j", "i", "name", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "d", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "Ljava/lang/String;", "qZoneMediaSaveDir", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "syncLatch", "Lcom/tencent/mobileqq/wink/picker/interceptor/InterceptException;", "Lcom/tencent/mobileqq/wink/picker/interceptor/InterceptException;", "interceptException", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DownloadQZoneMediaInterceptor implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c.a chain;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String qZoneMediaSaveDir = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownLatch syncLatch;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterceptException interceptException;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[LOOP:0: B:10:0x0020->B:36:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean e() {
        boolean z16;
        List<LocalMediaInfo> e16;
        boolean z17;
        boolean z18;
        c.a aVar = this.chain;
        if (aVar != null && (e16 = aVar.e()) != null) {
            List<LocalMediaInfo> list = e16;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    String v3 = e93.i.v((LocalMediaInfo) it.next());
                    if (v3 != null) {
                        if (v3.length() > 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            z17 = true;
                            if (!z17) {
                                z16 = true;
                                break;
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                }
            }
        }
        z16 = false;
        if (!z16) {
            return false;
        }
        if (l() && k()) {
            return false;
        }
        if (NetworkUtil.isNetworkAvailable()) {
            return true;
        }
        throw new InterceptException(name(), new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_NO_NETWORK, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(List<String> list, List<? extends LocalMediaInfo> list2, Continuation<? super Unit> continuation) {
        DownloadQZoneMediaInterceptor$downloadImages$1 downloadQZoneMediaInterceptor$downloadImages$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        DownloadQZoneMediaInterceptor downloadQZoneMediaInterceptor;
        Map map;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        if (continuation instanceof DownloadQZoneMediaInterceptor$downloadImages$1) {
            downloadQZoneMediaInterceptor$downloadImages$1 = (DownloadQZoneMediaInterceptor$downloadImages$1) continuation;
            int i16 = downloadQZoneMediaInterceptor$downloadImages$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                downloadQZoneMediaInterceptor$downloadImages$1.label = i16 - Integer.MIN_VALUE;
                Object obj = downloadQZoneMediaInterceptor$downloadImages$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = downloadQZoneMediaInterceptor$downloadImages$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        list2 = (List) downloadQZoneMediaInterceptor$downloadImages$1.L$1;
                        downloadQZoneMediaInterceptor = (DownloadQZoneMediaInterceptor) downloadQZoneMediaInterceptor$downloadImages$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    List<String> list3 = list;
                    if (list3 != null && !list3.isEmpty()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        return Unit.INSTANCE;
                    }
                    WinkQZoneMediaDownloader winkQZoneMediaDownloader = WinkQZoneMediaDownloader.f318202a;
                    downloadQZoneMediaInterceptor$downloadImages$1.L$0 = this;
                    downloadQZoneMediaInterceptor$downloadImages$1.L$1 = list2;
                    downloadQZoneMediaInterceptor$downloadImages$1.label = 1;
                    obj = winkQZoneMediaDownloader.b(list, downloadQZoneMediaInterceptor$downloadImages$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    downloadQZoneMediaInterceptor = this;
                }
                map = (Map) obj;
                if (map != null) {
                    downloadQZoneMediaInterceptor.interceptException = new InterceptException(downloadQZoneMediaInterceptor.name(), new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_QZONE_IMAGE_DOWNLOAD_FAILED, null, 2, null));
                    CountDownLatch countDownLatch = downloadQZoneMediaInterceptor.syncLatch;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                    return Unit.INSTANCE;
                }
                List<? extends LocalMediaInfo> list4 = list2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (Object obj2 : list4) {
                    linkedHashMap.put(e93.i.j((LocalMediaInfo) obj2), obj2);
                }
                for (Map.Entry entry : map.entrySet()) {
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) linkedHashMap.get(entry.getKey());
                    if (localMediaInfo != null) {
                        e93.i.M(localMediaInfo, true);
                        localMediaInfo.path = (String) entry.getValue();
                    }
                }
                return Unit.INSTANCE;
            }
        }
        downloadQZoneMediaInterceptor$downloadImages$1 = new DownloadQZoneMediaInterceptor$downloadImages$1(this, continuation);
        Object obj3 = downloadQZoneMediaInterceptor$downloadImages$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = downloadQZoneMediaInterceptor$downloadImages$1.label;
        if (i3 == 0) {
        }
        map = (Map) obj3;
        if (map != null) {
        }
    }

    private final void g() {
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean z16;
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b16;
        boolean z17;
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b17;
        com.tencent.mobileqq.wink.downloader.b.f318210a.a();
        c.a aVar = this.chain;
        if (aVar != null && (b17 = aVar.b()) != null) {
            b17.E0();
        }
        this.interceptException = null;
        List<LocalMediaInfo> j3 = j();
        if (j3 != null) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it = j3.iterator();
            while (it.hasNext()) {
                String j16 = e93.i.j((LocalMediaInfo) it.next());
                if (j16 != null) {
                    arrayList3.add(j16);
                }
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        List<LocalMediaInfo> i3 = i();
        if (i3 != null) {
            ArrayList arrayList4 = new ArrayList();
            Iterator<T> it5 = i3.iterator();
            while (it5.hasNext()) {
                String j17 = e93.i.j((LocalMediaInfo) it5.next());
                if (j17 != null) {
                    arrayList4.add(j17);
                }
            }
            arrayList2 = arrayList4;
        } else {
            arrayList2 = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                return;
            }
        }
        this.syncLatch = new CountDownLatch(1);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new DownloadQZoneMediaInterceptor$downloadMedia$1(this, arrayList, j3, arrayList2, i3, null), 3, null);
        CountDownLatch countDownLatch = this.syncLatch;
        if (countDownLatch != null) {
            countDownLatch.await();
        }
        InterceptException interceptException = this.interceptException;
        if (interceptException == null) {
            c.a aVar2 = this.chain;
            if (aVar2 != null && (b16 = aVar2.b()) != null) {
                b16.b0(false);
                return;
            }
            return;
        }
        throw interceptException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(List<String> list, List<? extends LocalMediaInfo> list2, Continuation<? super Unit> continuation) {
        DownloadQZoneMediaInterceptor$downloadVideos$1 downloadQZoneMediaInterceptor$downloadVideos$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        DownloadQZoneMediaInterceptor downloadQZoneMediaInterceptor;
        Map map;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        if (continuation instanceof DownloadQZoneMediaInterceptor$downloadVideos$1) {
            downloadQZoneMediaInterceptor$downloadVideos$1 = (DownloadQZoneMediaInterceptor$downloadVideos$1) continuation;
            int i16 = downloadQZoneMediaInterceptor$downloadVideos$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                downloadQZoneMediaInterceptor$downloadVideos$1.label = i16 - Integer.MIN_VALUE;
                Object obj = downloadQZoneMediaInterceptor$downloadVideos$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = downloadQZoneMediaInterceptor$downloadVideos$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        list2 = (List) downloadQZoneMediaInterceptor$downloadVideos$1.L$1;
                        downloadQZoneMediaInterceptor = (DownloadQZoneMediaInterceptor) downloadQZoneMediaInterceptor$downloadVideos$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    List<String> list3 = list;
                    if (list3 != null && !list3.isEmpty()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        return Unit.INSTANCE;
                    }
                    WinkQZoneMediaDownloader winkQZoneMediaDownloader = WinkQZoneMediaDownloader.f318202a;
                    downloadQZoneMediaInterceptor$downloadVideos$1.L$0 = this;
                    downloadQZoneMediaInterceptor$downloadVideos$1.L$1 = list2;
                    downloadQZoneMediaInterceptor$downloadVideos$1.label = 1;
                    obj = winkQZoneMediaDownloader.d(list, downloadQZoneMediaInterceptor$downloadVideos$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    downloadQZoneMediaInterceptor = this;
                }
                map = (Map) obj;
                if (map != null) {
                    downloadQZoneMediaInterceptor.interceptException = new InterceptException(downloadQZoneMediaInterceptor.name(), new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_QZONE_VIDEO_DOWNLOAD_FAILED, null, 2, null));
                    CountDownLatch countDownLatch = downloadQZoneMediaInterceptor.syncLatch;
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
                    return Unit.INSTANCE;
                }
                List<? extends LocalMediaInfo> list4 = list2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (Object obj2 : list4) {
                    linkedHashMap.put(e93.i.j((LocalMediaInfo) obj2), obj2);
                }
                for (Map.Entry entry : map.entrySet()) {
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) linkedHashMap.get(entry.getKey());
                    if (localMediaInfo != null) {
                        e93.i.M(localMediaInfo, true);
                        localMediaInfo.path = (String) entry.getValue();
                    }
                }
                return Unit.INSTANCE;
            }
        }
        downloadQZoneMediaInterceptor$downloadVideos$1 = new DownloadQZoneMediaInterceptor$downloadVideos$1(this, continuation);
        Object obj3 = downloadQZoneMediaInterceptor$downloadVideos$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = downloadQZoneMediaInterceptor$downloadVideos$1.label;
        if (i3 == 0) {
        }
        map = (Map) obj3;
        if (map != null) {
        }
    }

    private final List<LocalMediaInfo> i() {
        List<LocalMediaInfo> e16;
        boolean z16;
        c.a aVar = this.chain;
        if (aVar != null && (e16 = aVar.e()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = e16.iterator();
            while (true) {
                boolean z17 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) next;
                if (!e93.i.E(localMediaInfo) || e93.i.C(localMediaInfo) || !e93.i.G(localMediaInfo)) {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) obj;
                WinkQZoneMediaDownloader winkQZoneMediaDownloader = WinkQZoneMediaDownloader.f318202a;
                String j3 = e93.i.j(localMediaInfo2);
                Intrinsics.checkNotNull(j3);
                String e17 = winkQZoneMediaDownloader.e(j3);
                if (new File(e17).exists()) {
                    localMediaInfo2.path = e17;
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        }
        return null;
    }

    private final List<LocalMediaInfo> j() {
        List<LocalMediaInfo> e16;
        boolean z16;
        c.a aVar = this.chain;
        if (aVar != null && (e16 = aVar.e()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = e16.iterator();
            while (true) {
                boolean z17 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) next;
                if (!e93.i.E(localMediaInfo) || e93.i.C(localMediaInfo) || !e93.i.I(localMediaInfo)) {
                    z17 = false;
                }
                if (z17) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) obj;
                WinkQZoneMediaDownloader winkQZoneMediaDownloader = WinkQZoneMediaDownloader.f318202a;
                String j3 = e93.i.j(localMediaInfo2);
                Intrinsics.checkNotNull(j3);
                String g16 = winkQZoneMediaDownloader.g(j3);
                if (new File(g16).exists()) {
                    localMediaInfo2.path = g16;
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        }
        return null;
    }

    private final boolean k() {
        List<LocalMediaInfo> i3 = i();
        if (i3 != null) {
            return i3.isEmpty();
        }
        return true;
    }

    private final boolean l() {
        List<LocalMediaInfo> j3 = j();
        if (j3 != null) {
            return j3.isEmpty();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public MediaPickerOutput a(@NotNull c.a chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        this.chain = chain;
        if (!e()) {
            return chain.f(chain.d());
        }
        g();
        return chain.f(chain.d());
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public String name() {
        return "DownloadQZoneMediaInterceptor";
    }
}
