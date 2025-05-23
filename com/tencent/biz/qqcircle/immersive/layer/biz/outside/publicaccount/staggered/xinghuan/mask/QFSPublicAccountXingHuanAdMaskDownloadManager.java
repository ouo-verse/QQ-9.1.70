package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\u0014\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\nR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/xinghuan/mask/QFSPublicAccountXingHuanAdMaskDownloadManager;", "", "", "downloadUrl", "", "f", "i", "Lorg/json/JSONObject;", "cachedAds", "c", "", "e", "adMaskInfoList", "g", "", "b", "J", "maskAdEffectiveInterval", "", "I", "maskAdInfoListMaxSize", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountXingHuanAdMaskDownloadManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSPublicAccountXingHuanAdMaskDownloadManager f87145a = new QFSPublicAccountXingHuanAdMaskDownloadManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long maskAdEffectiveInterval = 604800000;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int maskAdInfoListMaxSize = 20;

    QFSPublicAccountXingHuanAdMaskDownloadManager() {
    }

    private final void c(JSONObject cachedAds) {
        int coerceAtMost;
        try {
            Iterator keys = cachedAds.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "cachedAds.keys()");
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            ArrayList arrayList = new ArrayList();
            while (keys.hasNext()) {
                JSONObject jSONObject = new JSONObject(cachedAds.optString(String.valueOf(keys.next()), ""));
                if (serverTimeMillis <= j.c(jSONObject) * 1000 && serverTimeMillis - jSONObject.optLong("update_time", 0L) <= maskAdEffectiveInterval) {
                    arrayList.add(jSONObject);
                }
            }
            final QFSPublicAccountXingHuanAdMaskDownloadManager$filterAdJsonList$1 qFSPublicAccountXingHuanAdMaskDownloadManager$filterAdJsonList$1 = new Function2<JSONObject, JSONObject, Integer>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.QFSPublicAccountXingHuanAdMaskDownloadManager$filterAdJsonList$1
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Integer invoke(JSONObject jSONObject2, JSONObject jSONObject3) {
                    return Integer.valueOf(jSONObject2.optLong("update_time", 0L) < jSONObject3.optLong("update_time", 0L) ? 1 : -1);
                }
            };
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.h
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int d16;
                    d16 = QFSPublicAccountXingHuanAdMaskDownloadManager.d(Function2.this, obj, obj2);
                    return d16;
                }
            });
            JSONObject jSONObject2 = new JSONObject();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(maskAdInfoListMaxSize, arrayList.size());
            for (int i3 = 0; i3 < coerceAtMost; i3++) {
                Object obj = arrayList.get(i3);
                Intrinsics.checkNotNullExpressionValue(obj, "effectiveAdList[count]");
                jSONObject2.put(j.h((JSONObject) obj), ((JSONObject) arrayList.get(i3)).toString());
            }
            i.f87158a.c(jSONObject2);
        } catch (Throwable th5) {
            QLog.e("QFSPublicAccountXingHuanAdMaskDownloadManager", 1, "filterAdJsonList failed, error is ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final void f(String downloadUrl) {
        boolean z16;
        if (downloadUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("QFSPublicAccountXingHuanAdMaskDownloadManager", 1, "can't download empty download url, cancel download");
            return;
        }
        f fVar = f.f87155a;
        if (fVar.a(fVar.d(downloadUrl))) {
            if (QLog.isColorLevel()) {
                QLog.d("QFSPublicAccountXingHuanAdMaskDownloadManager", 1, "res has downloaded, cancel download");
                return;
            }
            return;
        }
        i(downloadUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(List adMaskInfoList) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(adMaskInfoList, "$adMaskInfoList");
        boolean z16 = true;
        QLog.d("QFSPublicAccountXingHuanAdMaskDownloadManager", 1, "startDownloadAd");
        String b16 = i.f87158a.b();
        if (b16.length() != 0) {
            z16 = false;
        }
        if (z16) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = new JSONObject(b16);
        }
        Iterator it = adMaskInfoList.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject2 = (JSONObject) it.next();
            jSONObject.put(j.h(jSONObject2), jSONObject2.toString());
            String f16 = j.f(jSONObject2);
            QFSPublicAccountXingHuanAdMaskDownloadManager qFSPublicAccountXingHuanAdMaskDownloadManager = f87145a;
            qFSPublicAccountXingHuanAdMaskDownloadManager.f(f16);
            qFSPublicAccountXingHuanAdMaskDownloadManager.f(j.d(jSONObject2));
            qFSPublicAccountXingHuanAdMaskDownloadManager.f(j.b(jSONObject2));
        }
        f87145a.c(jSONObject);
    }

    private final void i(String downloadUrl) {
        boolean z16;
        if (downloadUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("QFSPublicAccountXingHuanAdMaskDownloadManager", 1, "can't download file, cancel download");
        } else {
            QLog.d("QFSPublicAccountXingHuanAdMaskDownloadManager", 1, "startPreDownload");
            f.f87155a.c().download(downloadUrl);
        }
    }

    @NotNull
    public final List<JSONObject> e() {
        boolean z16;
        String b16 = i.f87158a.b();
        if (b16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new ArrayList();
        }
        return f.f87155a.b(b16);
    }

    public final void g(@NotNull final List<? extends JSONObject> adMaskInfoList) {
        Intrinsics.checkNotNullParameter(adMaskInfoList, "adMaskInfoList");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.g
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountXingHuanAdMaskDownloadManager.h(adMaskInfoList);
            }
        }, 16, null, false);
    }
}
