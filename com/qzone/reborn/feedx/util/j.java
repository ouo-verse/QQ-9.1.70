package com.qzone.reborn.feedx.util;

import android.app.Activity;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.account.LoginData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\f\u001a\u00020\u000b2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b`\tH\u0002J\u001a\u0010\u000e\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u0003\u001a\u00020\u0002J.\u0010\u0018\u001a\u00020\u000b2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b`\tJ\u0018\u0010\u0019\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002J.\u0010\u001a\u001a\u00020\u000b2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b`\tJ\u0018\u0010\u001c\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001d2\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fR\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010#R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010#\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/feedx/util/j;", "", "", "countId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "Ljava/util/HashMap;", "Lcooperation/qzone/UndealCount/QZoneCountInfo;", "Lkotlin/collections/HashMap;", "stMapCountInfo", "", "c", "countInfo", "e", "", "f", "g", "k", "p", "", "j", "", "l", "b", "d", "a", "id", DomainData.DOMAIN_NAME, "", tl.h.F, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "o", "", "[I", "activeCountInfoArray", "intimateCountInfoArray", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f55760a = new j();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int[] activeCountInfoArray = {74};

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int[] intimateCountInfoArray = {74, 73};

    j() {
    }

    private final boolean c(HashMap<Integer, QZoneCountInfo> stMapCountInfo) {
        for (int i3 : intimateCountInfoArray) {
            if (stMapCountInfo.containsKey(Integer.valueOf(i3)) && !com.qzone.reborn.configx.g.f53821a.h().F()) {
                QLog.i("QZoneActiveCountInfoManager", 1, "checkIsNeedToRemoveIntimateCountInfo, message tab switch is closed, remove red count " + i3);
                stMapCountInfo.remove(Integer.valueOf(i3));
                return true;
            }
        }
        return false;
    }

    private final boolean e(QZoneCountInfo countInfo, int countId) {
        boolean contains;
        contains = ArraysKt___ArraysKt.contains(intimateCountInfoArray, countId);
        if (!contains || com.qzone.reborn.configx.g.f53821a.h().F()) {
            return false;
        }
        QLog.i("QZoneActiveCountInfoManager", 1, "checkIsNeedToRemoveIntimateCountInfoById, message tab switch is closed, remove red count " + countId);
        return true;
    }

    private final String i(int countId) {
        return "activeCountInfoStMsg_" + countId + "_" + LoginData.getInstance().getUinString();
    }

    private final String m(int countId) {
        return "activeCountInfoUinSet_" + countId + "_" + LoginData.getInstance().getUinString();
    }

    public final boolean a(HashMap<Integer, QZoneCountInfo> stMapCountInfo) {
        Intrinsics.checkNotNullParameter(stMapCountInfo, "stMapCountInfo");
        for (int i3 : activeCountInfoArray) {
            if (stMapCountInfo.containsKey(Integer.valueOf(i3)) && n(stMapCountInfo.get(Integer.valueOf(i3)), i3)) {
                stMapCountInfo.remove(Integer.valueOf(i3));
                return true;
            }
        }
        return false;
    }

    public final boolean b(HashMap<Integer, QZoneCountInfo> stMapCountInfo) {
        Intrinsics.checkNotNullParameter(stMapCountInfo, "stMapCountInfo");
        return c(stMapCountInfo);
    }

    public final boolean d(QZoneCountInfo countInfo, int countId) {
        return e(countInfo, countId);
    }

    public final void f() {
        for (int i3 : activeCountInfoArray) {
            QZoneFeedAlertService.getInstance().clearSingleUnreadCount(i3);
        }
    }

    public final void g(int countId) {
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(countId);
    }

    public final List<Long> h(QZoneCountInfo countInfo) {
        ArrayList arrayList = new ArrayList();
        if ((countInfo != null ? countInfo.friendList : null) != null) {
            Iterator<QZoneCountUserInfo> it = countInfo.friendList.iterator();
            while (it.hasNext()) {
                QZoneCountUserInfo next = it.next();
                if (next != null) {
                    long j3 = next.uin;
                    if (j3 > 0) {
                        arrayList.add(Long.valueOf(j3));
                    }
                }
            }
        }
        return arrayList;
    }

    public final long j(int countId) {
        return com.qzone.reborn.util.i.b().h(k(countId), 0L);
    }

    public final String k(int countId) {
        return "activeCountInfoTimestamp_" + countId + "_" + LoginData.getInstance().getUinString();
    }

    public final Set<String> l(int countId) {
        Set<String> k3 = com.qzone.reborn.util.i.b().k(m(countId), new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(k3, "g().getStringSet(getRedC\u2026countId), mutableSetOf())");
        return k3;
    }

    public final boolean o(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return !((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).needShowQzoneFrame(activity, MobileQQ.sMobileQQ.peekAppRuntime()) || QzoneFrame.isShowOldQZoneFrame();
    }

    public final void p(int countId, QZoneCountInfo countInfo) {
        boolean z16;
        int[] iArr = activeCountInfoArray;
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z16 = false;
                break;
            } else {
                if (iArr[i3] == countId) {
                    z16 = true;
                    break;
                }
                i3++;
            }
        }
        if (z16 && countInfo != null) {
            QLog.i("QZoneActiveCountInfoManager", 1, "record red count cTime is " + countInfo.cTime + ", id is " + countId);
            com.qzone.reborn.util.i.b().p(k(countId), countInfo.cTime);
            com.qzone.reborn.util.i.b().r(i(countId), countInfo.strShowMsg);
            if (ArrayUtils.isOutOfArrayIndex(0, countInfo.friendList)) {
                RFWLog.e("QZoneActiveCountInfoManager", RFWLog.USR, "friend list is empty");
                return;
            }
            HashSet hashSet = new HashSet();
            ArrayList<QZoneCountUserInfo> arrayList = countInfo.friendList;
            if (arrayList != null) {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    hashSet.add(String.valueOf(((QZoneCountUserInfo) it.next()).uin));
                }
            }
            com.qzone.reborn.util.i.b().s(m(countId), hashSet);
            return;
        }
        QLog.e("QZoneActiveCountInfoManager", 1, "count id is " + countId + ", not register in map, return");
    }

    public final boolean n(QZoneCountInfo countInfo, int id5) {
        boolean contains;
        if (countInfo == null) {
            return false;
        }
        contains = ArraysKt___ArraysKt.contains(activeCountInfoArray, id5);
        if (!contains) {
            return false;
        }
        if (ArrayUtils.isOutOfArrayIndex(0, countInfo.friendList)) {
            QLog.e("QZoneActiveCountInfoManager", 1, "friend list is empty");
            return true;
        }
        if (countInfo.cTime > j(id5)) {
            QLog.i("QZoneActiveCountInfoManager", 1, "new timestamp is " + countInfo.cTime + ", old timestamp is " + j(id5));
            return false;
        }
        Set<String> l3 = l(id5);
        if (l3.size() != countInfo.friendList.size()) {
            QLog.i("QZoneActiveCountInfoManager", 1, "size not equal, pre size is " + l3.size() + ", current size is " + countInfo.friendList.size());
            return false;
        }
        Iterator<QZoneCountUserInfo> it = countInfo.friendList.iterator();
        while (it.hasNext()) {
            QZoneCountUserInfo next = it.next();
            if (next == null) {
                return true;
            }
            String valueOf = String.valueOf(next.uin);
            if (!l3.contains(valueOf)) {
                QLog.i("QZoneActiveCountInfoManager", 1, "new uin is " + valueOf);
                return false;
            }
        }
        RFWLog.d("QZoneActiveCountInfoManager", RFWLog.USR, "new count info cTime is " + countInfo.cTime + " new uCount is " + countInfo.uCount + " new count info uin size " + countInfo.friendList.size() + " pre uin size is " + l3.size() + " pre cTime is " + j(id5));
        return true;
    }
}
