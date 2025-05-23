package com.tencent.mobileqq.richmediabrowser;

import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.config.DanmuConfProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    public static List<com.tencent.common.danmaku.data.a> a(long j3, List<DanmuItemBean> list, com.tencent.mobileqq.comment.danmaku.a aVar, ConcurrentHashMap<Long, Set<DanmuItemBean>> concurrentHashMap) {
        if (list != null && !list.isEmpty() && aVar != null) {
            List<DanmuItemBean> f16 = f(j3, list, concurrentHashMap);
            if (f16 == null || f16.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<DanmuItemBean> it = f16.iterator();
            while (it.hasNext()) {
                com.tencent.common.danmaku.data.a j16 = aVar.j(new com.tencent.mobileqq.comment.danmaku.data.a(it.next()));
                if (j16 != null) {
                    j16.u0(5000);
                    j16.r0(true);
                    arrayList.add(j16);
                }
            }
            return arrayList;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDanmakuUtils", 4, "buildPictureDanmakuList list is null");
        return null;
    }

    public static List<com.tencent.common.danmaku.data.a> b(long j3, List<DanmuItemBean> list, com.tencent.mobileqq.comment.danmaku.a aVar, ConcurrentHashMap<Long, Set<DanmuItemBean>> concurrentHashMap, long j16) {
        if (list != null && !list.isEmpty()) {
            return c(e(j3, list, concurrentHashMap, j16), aVar);
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDanmakuUtils", 4, "buildVideoDanmakuList list is null");
        return null;
    }

    private static List<com.tencent.common.danmaku.data.a> c(List<DanmuItemBean> list, com.tencent.mobileqq.comment.danmaku.a aVar) {
        if (list == null || list.isEmpty() || aVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (DanmuItemBean danmuItemBean : list) {
            com.tencent.mobileqq.comment.danmaku.data.a aVar2 = new com.tencent.mobileqq.comment.danmaku.data.a(danmuItemBean);
            com.tencent.common.danmaku.data.a j3 = aVar.j(aVar2);
            if (j3 != null) {
                j3.v0(danmuItemBean.f201731f);
                if (!TextUtils.isEmpty(aVar2.f201778b)) {
                    String account = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
                    if (!TextUtils.isEmpty(account) && account.equals(aVar2.f201778b)) {
                        j3.r0(true);
                    }
                }
                arrayList.add(j3);
            }
        }
        return arrayList;
    }

    private static List<DanmuItemBean> d(Set<DanmuItemBean> set, long j3) {
        if (set != null && !set.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (DanmuItemBean danmuItemBean : set) {
                if (danmuItemBean.f201731f + 1000 >= j3) {
                    arrayList.add(danmuItemBean);
                }
            }
            return arrayList;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List<DanmuItemBean> e(long j3, List<DanmuItemBean> list, ConcurrentHashMap<Long, Set<DanmuItemBean>> concurrentHashMap, long j16) {
        Set<DanmuItemBean> set = concurrentHashMap.get(Long.valueOf(j3));
        Set<DanmuItemBean> arraySet = new ArraySet<>();
        arraySet.addAll(list);
        if (set == null) {
            concurrentHashMap.put(Long.valueOf(j3), arraySet);
            return d(arraySet, j16);
        }
        concurrentHashMap.clear();
        ArraySet arraySet2 = new ArraySet();
        for (DanmuItemBean danmuItemBean : arraySet) {
            if (!set.contains(danmuItemBean)) {
                arraySet2.add(danmuItemBean);
            }
        }
        set.addAll(arraySet2);
        concurrentHashMap.put(Long.valueOf(j3), set);
        return d(arraySet2, j16);
    }

    private static List<DanmuItemBean> f(long j3, List<DanmuItemBean> list, ConcurrentHashMap<Long, Set<DanmuItemBean>> concurrentHashMap) {
        Set<DanmuItemBean> set = concurrentHashMap.get(Long.valueOf(j3));
        if (set == null) {
            Set<DanmuItemBean> arraySet = new ArraySet<>();
            arraySet.addAll(list);
            concurrentHashMap.put(Long.valueOf(j3), arraySet);
            return list;
        }
        concurrentHashMap.clear();
        ArrayList arrayList = new ArrayList();
        for (DanmuItemBean danmuItemBean : list) {
            if (!set.contains(danmuItemBean)) {
                arrayList.add(danmuItemBean);
            }
        }
        set.addAll(arrayList);
        concurrentHashMap.put(Long.valueOf(j3), set);
        return arrayList;
    }

    public static List<com.tencent.common.danmaku.data.a> g(long j3, long j16, com.tencent.mobileqq.comment.danmaku.a aVar, ConcurrentHashMap<Long, Set<DanmuItemBean>> concurrentHashMap) {
        Set<DanmuItemBean> set = concurrentHashMap.get(Long.valueOf(j3));
        if (set != null) {
            return c(d(set, j16), aVar);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00de, code lost:
    
        if (((com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData) r0).isInMixedMsg != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(RichMediaBrowserInfo richMediaBrowserInfo) {
        if (!DanmuConfProcessor.a()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("shouldShowDanmakuBtn, paramsManager.isFromMultiMsg() = ");
            sb5.append(h.a().q());
            sb5.append(" , paramsManager.getmCurType() = ");
            sb5.append(h.a().f());
            sb5.append(" , paramsManager.getSourceEntrance() = ");
            sb5.append(h.a().c());
            sb5.append(" , paramsManager.isReplyMsgFromSameSession() = ");
            sb5.append(h.a().t());
            sb5.append(" , paramsManager.isMixedMsg = ");
            sb5.append(h.a().f281824t);
            sb5.append(" , paramsManager.isReplySrcMsgExist = ");
            sb5.append(h.a().f281825u);
            if (richMediaBrowserInfo != null) {
                RichMediaBaseData richMediaBaseData = richMediaBrowserInfo.baseData;
                if (richMediaBaseData instanceof AIOBrowserBaseData) {
                    AIOBrowserBaseData aIOBrowserBaseData = (AIOBrowserBaseData) richMediaBaseData;
                    sb5.append(", galleryInfo.mData.isInMixedMsg = ");
                    sb5.append(aIOBrowserBaseData.isInMixedMsg);
                    sb5.append(" isMsgSeqReady = ");
                    sb5.append(aIOBrowserBaseData.isMsgSeqReady);
                }
            }
            QLog.d("BrowserDanmakuUtils", 2, sb5.toString());
        }
        if (!h.a().q() && h.a().f() == 1 && h.a().c() != 4 && h.a().t() && h.a().f281825u) {
            if (richMediaBrowserInfo != null) {
                RichMediaBaseData richMediaBaseData2 = richMediaBrowserInfo.baseData;
                if (richMediaBaseData2 instanceof AIOBrowserBaseData) {
                }
            }
            if (richMediaBrowserInfo != null) {
                RichMediaBaseData richMediaBaseData3 = richMediaBrowserInfo.baseData;
                if (!(richMediaBaseData3 instanceof AIOBrowserBaseData) || ((AIOBrowserBaseData) richMediaBaseData3).isMsgSeqReady) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean i() {
        return false;
    }
}
