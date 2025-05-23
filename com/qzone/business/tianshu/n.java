package com.qzone.business.tianshu;

import android.text.TextUtils;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.vip.pb.TianShuAccess;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004H\u0002J\u001c\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0010R$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/business/tianshu/n;", "", "", "b", "", "", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "plusMenuItemCache", "", "g", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "posId", "f", "Lcooperation/vip/pb/TianShuAccess$RspEntry;", "rspEntry", "", tl.h.F, "d", "e", "Ljava/util/Map;", "mPlusMenuItemCache", "", "c", "J", "mLastFetchTime", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f44882a = new n();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Map<Integer, TianShuAccess.AdItem> mPlusMenuItemCache = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mLastFetchTime;

    n() {
    }

    private final void b() {
        final List<Integer> mutableListOf;
        RFWLog.d("QZonePlusMenuTianShuHelper", RFWLog.USR, "fetchPlusMenuItem start");
        mLastFetchTime = System.currentTimeMillis();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Integer.valueOf(gdt_analysis_event.CONFIG_REPORT_FOR_LINK_LANDING_PAGE_LOAD_SCRIPT), 1347);
        QZoneTianShuAdManager.e().m(mutableListOf, new TianShuGetAdvCallback() { // from class: com.qzone.business.tianshu.m
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                n.c(mutableListOf, z16, getAdsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(List posIdList, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        Intrinsics.checkNotNullParameter(posIdList, "$posIdList");
        if (z16) {
            Iterator it = posIdList.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                TianShuAccess.AdItem f16 = f44882a.f(getAdsRsp, intValue);
                if (f16 != null) {
                    mPlusMenuItemCache.put(Integer.valueOf(intValue), f16);
                }
            }
            RFWLog.d("QZonePlusMenuTianShuHelper", RFWLog.USR, "fetchPlusMenuItem success: " + f44882a.g(mPlusMenuItemCache));
            return;
        }
        RFWLog.d("QZonePlusMenuTianShuHelper", RFWLog.USR, "fetchPlusMenuItem fail");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001a A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:87:0x0008, B:89:0x000c, B:5:0x001a, B:6:0x002c, B:8:0x0032, B:15:0x0048, B:19:0x004d, B:22:0x0054, B:24:0x0060, B:26:0x0064, B:27:0x006a, B:29:0x0071, B:30:0x0077, B:32:0x007d, B:35:0x0095, B:38:0x009b, B:44:0x00ab, B:46:0x00b3, B:53:0x00c4, B:55:0x00c8, B:57:0x00e6, B:59:0x00ea, B:61:0x00f8, B:63:0x00fc, B:65:0x010a, B:67:0x010e, B:74:0x00d4, B:76:0x00d8), top: B:86:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final TianShuAccess.AdItem f(TianShuAccess.GetAdsRsp getAdsRsp, int posId) {
        PBRepeatMessageField<TianShuAccess.RspEntry> pBRepeatMessageField;
        boolean z16;
        Object obj;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        PBStringField pBStringField5;
        PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField2;
        boolean z17 = true;
        if (getAdsRsp != null) {
            try {
                pBRepeatMessageField = getAdsRsp.mapAds;
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
            if (pBRepeatMessageField != null && pBRepeatMessageField.has()) {
                z16 = true;
                if (z16) {
                    List<TianShuAccess.RspEntry> rspEntries = getAdsRsp.mapAds.get();
                    Intrinsics.checkNotNullExpressionValue(rspEntries, "rspEntries");
                    Iterator<T> it = rspEntries.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((TianShuAccess.RspEntry) obj).key.get() == posId) {
                            break;
                        }
                    }
                    TianShuAccess.RspEntry rspEntry = (TianShuAccess.RspEntry) obj;
                    if (rspEntry == null || !h(rspEntry)) {
                        return null;
                    }
                    TianShuAccess.AdItem adItem = rspEntry.value.lst.get(0);
                    List<TianShuAccess.MapEntry> list = (adItem == null || (pBRepeatMessageField2 = adItem.argList) == null) ? null : pBRepeatMessageField2.get();
                    HashMap hashMap = new HashMap();
                    if (list != null) {
                        for (TianShuAccess.MapEntry mapEntry : list) {
                            String keyStr = mapEntry.key.get();
                            String valueStr = mapEntry.value.get();
                            if (!TextUtils.isEmpty(keyStr) && !TextUtils.isEmpty(valueStr)) {
                                Intrinsics.checkNotNullExpressionValue(keyStr, "keyStr");
                                Intrinsics.checkNotNullExpressionValue(valueStr, "valueStr");
                                hashMap.put(keyStr, valueStr);
                            }
                        }
                    }
                    String str = (String) hashMap.get("reddot");
                    if (str != null) {
                        if (str.length() > 0) {
                            if (z17) {
                                if (adItem != null && (pBStringField = adItem.title) != null) {
                                    pBStringField.set((String) hashMap.get("name"));
                                }
                            } else if (adItem != null && (pBStringField5 = adItem.title) != null) {
                                pBStringField5.set((String) hashMap.get("reddot"));
                            }
                            if (adItem != null && (pBStringField4 = adItem.jumpurl) != null) {
                                pBStringField4.set((String) hashMap.get("jumpurl"));
                            }
                            if (adItem != null && (pBStringField3 = adItem.desc) != null) {
                                pBStringField3.set((String) hashMap.get("text"));
                            }
                            if (adItem != null && (pBStringField2 = adItem.iconurl) != null) {
                                pBStringField2.set((String) hashMap.get("icon"));
                            }
                            return adItem;
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                    if (adItem != null) {
                        pBStringField4.set((String) hashMap.get("jumpurl"));
                    }
                    if (adItem != null) {
                        pBStringField3.set((String) hashMap.get("text"));
                    }
                    if (adItem != null) {
                        pBStringField2.set((String) hashMap.get("icon"));
                    }
                    return adItem;
                }
                return null;
            }
        }
        z16 = false;
        if (z16) {
        }
        return null;
    }

    public final void d() {
        if (!e()) {
            RFWLog.d("QZonePlusMenuTianShuHelper", RFWLog.USR, "fetchPlusMenuItem disable, just return");
            return;
        }
        if ((!mPlusMenuItemCache.isEmpty()) && System.currentTimeMillis() - mLastFetchTime <= MiniBoxNoticeInfo.MIN_5) {
            RFWLog.d("QZonePlusMenuTianShuHelper", RFWLog.USR, "fetchPlusMenuItem, has item data, just return");
            return;
        }
        try {
            b();
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
        }
    }

    public final boolean e() {
        return com.qzone.reborn.configx.g.f53821a.b().I1();
    }

    private final String g(Map<Integer, TianShuAccess.AdItem> plusMenuItemCache) {
        if (plusMenuItemCache == null) {
            return "";
        }
        String str = " ";
        for (Map.Entry<Integer, TianShuAccess.AdItem> entry : plusMenuItemCache.entrySet()) {
            TianShuAccess.AdItem value = entry.getValue();
            if (value != null) {
                str = ((Object) str) + "posId: " + entry.getKey() + ", adId: " + value.iAdId.get() + ", adTitle: " + value.title.get() + ", desc: " + value.desc.get() + ", ";
            }
        }
        return str;
    }

    private final boolean h(TianShuAccess.RspEntry rspEntry) {
        return ((rspEntry != null ? rspEntry.value : null) == null || rspEntry.value.lst.size() == 0 || rspEntry.value.lst.get(0) == null || rspEntry.value.lst.get(0).argList == null || rspEntry.value.lst.get(0).argList.get() == null) ? false : true;
    }
}
