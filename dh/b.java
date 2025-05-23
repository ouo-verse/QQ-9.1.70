package dh;

import NS_QMALL_COVER.PassiveFeedsPush;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import com.tencent.util.Pair;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.util.JceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseCommon$BytesEntry;
import qzone.QZoneBaseMeta$StUser;
import qzone.qzoneReddotMeta$ReddotInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0000*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0004\u001a>\u0010\u000b\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0018\u00010\u0006j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0018\u0001`\n*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000\u001a8\u0010\f\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0018\u00010\u0006j\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0018\u0001`\n*\u0004\u0018\u00010\u0001\u001a\f\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\u0004\u001a:\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0000*\b\u0012\u0004\u0012\u00020\u000e0\u00002\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010`\u0011\u001a.\u0010\u0014\u001a\u00020\u0004*\u00020\u000e2\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010`\u0011\u001a\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0016\u00a8\u0006\u0019"}, d2 = {"", "Ldh/c;", "Lld/a;", "c", "Ldh/e;", "d", "Ljava/util/ArrayList;", "Lcom/tencent/util/Pair;", "Lcooperation/qzone/UndealCount/QZoneCountUserInfo;", "", "Lkotlin/collections/ArrayList;", "b", "a", "e", "Lqzone/QZoneBaseMeta$StUser;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extraInfoMap", "g", "f", "Lqzone/qzoneReddotMeta$ReddotInfo;", "", WadlProxyConsts.CREATE_TIME, h.F, "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {
    public static final ld.a d(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        ld.a aVar = new ld.a();
        try {
            aVar.c(eVar.getUin());
            aVar.b(eVar.getNickname());
            aVar.e(eVar.getYellowVipType());
            aVar.d(eVar.getYellowVipLevel());
            return aVar;
        } catch (Exception unused) {
            QLog.e("toFeedProBannerUserBean", 1, "uin is " + eVar.getUin() + ", nick is " + eVar.getNickname() + " vip type is " + eVar.getYellowVipType() + ", vip is " + eVar.getYellowVipLevel());
            return null;
        }
    }

    public static final QZoneCountUserInfo e(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        QZoneCountUserInfo qZoneCountUserInfo = new QZoneCountUserInfo();
        try {
            qZoneCountUserInfo.uin = Long.parseLong(eVar.getUin());
            qZoneCountUserInfo.nickName = eVar.getNickname();
            qZoneCountUserInfo.iYellowType = eVar.getYellowVipType();
            qZoneCountUserInfo.iYellowLevel = eVar.getYellowVipLevel();
            qZoneCountUserInfo.pushData = eVar.getPassiveFeedsPush();
            return qZoneCountUserInfo;
        } catch (Exception unused) {
            QLog.e("toQZoneCountUserInfo", 1, "uin is " + eVar.getUin() + ", nick is " + eVar.getNickname() + " vip type is " + eVar.getYellowVipType() + ", vip is " + eVar.getYellowVipLevel());
            return null;
        }
    }

    public static final e f(QZoneBaseMeta$StUser qZoneBaseMeta$StUser, HashMap<String, byte[]> extraInfoMap) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StUser, "<this>");
        Intrinsics.checkNotNullParameter(extraInfoMap, "extraInfoMap");
        e eVar = new e();
        String str = qZoneBaseMeta$StUser.uin.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.uin.get()");
        eVar.h(str);
        String str2 = qZoneBaseMeta$StUser.nick.get();
        Intrinsics.checkNotNullExpressionValue(str2, "this.nick.get()");
        eVar.f(str2);
        eVar.j(qZoneBaseMeta$StUser.yellow_info.yellow_type.get());
        eVar.i(qZoneBaseMeta$StUser.yellow_info.yellow_level.get());
        eVar.g((PassiveFeedsPush) JceUtils.decodeWup(PassiveFeedsPush.class, extraInfoMap.get("pav_bubble_deco")));
        return eVar;
    }

    public static final List<e> g(List<QZoneBaseMeta$StUser> list, HashMap<String, byte[]> extraInfoMap) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(extraInfoMap, "extraInfoMap");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f((QZoneBaseMeta$StUser) it.next(), extraInfoMap));
        }
        return arrayList;
    }

    public static final List<ld.a> c(List<c> list) {
        if (ArrayUtils.isOutOfArrayIndex(0, list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Intrinsics.checkNotNull(list);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Iterator<T> it5 = ((c) it.next()).e().iterator();
            while (it5.hasNext()) {
                ld.a d16 = d((e) it5.next());
                if (d16 != null && !hashSet.contains(d16.getUin())) {
                    arrayList.add(d16);
                    hashSet.add(d16.getUin());
                }
            }
        }
        return arrayList;
    }

    public static final c h(qzoneReddotMeta$ReddotInfo qzonereddotmeta_reddotinfo, long j3) {
        if (qzonereddotmeta_reddotinfo == null) {
            return null;
        }
        c cVar = new c();
        List<QZoneBaseCommon$BytesEntry> list = qzonereddotmeta_reddotinfo.map_bytes_info.get();
        Intrinsics.checkNotNullExpressionValue(list, "this.map_bytes_info.get()");
        for (QZoneBaseCommon$BytesEntry qZoneBaseCommon$BytesEntry : list) {
            HashMap<String, byte[]> c16 = cVar.c();
            String str = qZoneBaseCommon$BytesEntry.key.get();
            Intrinsics.checkNotNullExpressionValue(str, "byteInfo.key.get()");
            byte[] byteArray = qZoneBaseCommon$BytesEntry.value.get().toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "byteInfo.value.get().toByteArray()");
            c16.put(str, byteArray);
        }
        cVar.h(qzonereddotmeta_reddotinfo.reddot_id.get());
        cVar.f(qzonereddotmeta_reddotinfo.count.count.get());
        String str2 = qzonereddotmeta_reddotinfo.bubble_msg.get();
        Intrinsics.checkNotNullExpressionValue(str2, "it.bubble_msg.get()");
        cVar.i(str2);
        List<QZoneBaseMeta$StUser> list2 = qzonereddotmeta_reddotinfo.user_list.get();
        Intrinsics.checkNotNullExpressionValue(list2, "it.user_list.get()");
        cVar.j(g(list2, cVar.c()));
        cVar.g(j3);
        return cVar;
    }

    public static final ArrayList<Pair<QZoneCountUserInfo, String>> a(c cVar) {
        if (cVar == null) {
            return null;
        }
        ArrayList<Pair<QZoneCountUserInfo, String>> arrayList = new ArrayList<>();
        for (e eVar : cVar.e()) {
            if (arrayList.size() >= 3) {
                break;
            }
            QZoneCountUserInfo e16 = e(eVar);
            if (e16 != null) {
                arrayList.add(new Pair<>(e16, eVar.getUin()));
            }
        }
        return arrayList;
    }

    public static final ArrayList<Pair<QZoneCountUserInfo, String>> b(List<c> list) {
        if (list == null) {
            return null;
        }
        ArrayList<Pair<QZoneCountUserInfo, String>> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ArrayList<Pair<QZoneCountUserInfo, String>> a16 = a((c) it.next());
            if (a16 != null) {
                for (Pair<QZoneCountUserInfo, String> pair : a16) {
                    if (!hashSet.contains(pair.second)) {
                        hashSet.add(pair.second);
                        arrayList.add(pair);
                    }
                }
            }
        }
        return arrayList;
    }
}
