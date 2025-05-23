package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.pager.g;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import n25.a;
import n25.b;
import n25.j;
import n25.k;
import n25.l;
import o25.e;
import o25.f;
import p35.ac;
import p35.ag;
import p35.ah;
import p35.d;
import p35.h;
import p35.n;
import r25.c;
import s35.af;
import v25.i;

/* loaded from: classes31.dex */
public final class NearbyProUtilsKt {
    public static final i getCachedMapThemeList() {
        String cachedFromNative = Utils.INSTANCE.currentBridgeModule().getCachedFromNative("fetchMapTheme");
        if (cachedFromNative.length() == 0) {
            return null;
        }
        try {
            return toMapThemeListRsp(cachedFromNative);
        } catch (JSONException e16) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Error parsing data from cache: ");
            m3.append(e16.getMessage());
            kLog.e("NearbyMapThemeRepo", m3.toString());
            return null;
        }
    }

    public static final e getCoord() {
        UserDataManager userDataManager = UserDataManager.INSTANCE;
        return new e((float) userDataManager.getUserSelfInfo().latLng.latitude, (float) userDataManager.getUserSelfInfo().latLng.longitude, 4);
    }

    public static final String getInteractiveNumCacheKey() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("nearbypro_key_interactive_num");
        m3.append(String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid));
        return m3.toString();
    }

    public static final f getMapThemeFromCache(String str) {
        List<f> emptyList;
        i cachedMapThemeList = getCachedMapThemeList();
        if (cachedMapThemeList == null || (emptyList = cachedMapThemeList.f440858e) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        for (f fVar : emptyList) {
            if (Intrinsics.areEqual(fVar.f421849d, str)) {
                return fVar;
            }
        }
        return null;
    }

    public static final k getPOI() {
        NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
        NBPLatLng nBPLatLng = userSelfInfo.latLng;
        double d16 = 1000000;
        n25.i iVar = new n25.i((long) (nBPLatLng.latitude * d16), (long) (nBPLatLng.longitude * d16), 12);
        String str = userSelfInfo.locationAddress;
        String str2 = userSelfInfo.locationCountry;
        String str3 = userSelfInfo.locationProvince;
        String str4 = userSelfInfo.locationCity;
        String str5 = userSelfInfo.locationDistrict;
        String str6 = userSelfInfo.locationName;
        return new k((String) null, str6, 0, (String) null, str, 0, iVar, 0, 0, (String) null, str2, str3, str4, 0, 0, (String) null, str5, (String) null, (String) null, str6, 1500077);
    }

    public static final float getPageViewWidthOptimized(g gVar) {
        if (gVar.l() / gVar.m() < 1.7777778f) {
            return gVar.l() / 1.7777778f;
        }
        return gVar.m();
    }

    public static final String getPoiDetailName(k kVar) {
        return kVar.G + QbAddrData.DATA_SPLITER + kVar.H + QbAddrData.DATA_SPLITER + kVar.I + QbAddrData.DATA_SPLITER + kVar.M + QbAddrData.DATA_SPLITER + kVar.Q;
    }

    public static final boolean isCityWalk(l lVar) {
        List<a> list;
        if (lVar.L != 1) {
            return false;
        }
        b bVar = lVar.M;
        return bVar != null && (list = bVar.f418049d) != null && (list.isEmpty() ^ true);
    }

    public static final boolean isInNBPMain() {
        return Intrinsics.areEqual(Utils.INSTANCE.currentBridgeModule().getCachedFromNative("in_nbp_main"), "1");
    }

    public static final boolean isShowBackendErrorMsg(int i3) {
        if (50000 <= i3 && i3 < 60001) {
            return true;
        }
        return false;
    }

    public static final Pair<Long, Integer> parsePrayCalendarTips() {
        boolean contains$default;
        List listOf;
        Long longOrNull;
        Integer intOrNull;
        String item = Utils.INSTANCE.cacheModule("").getItem("NBP_CACHE_KEY_HOME_LAST_PRAY_CALENDAR_TIPS");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) item, (CharSequence) ":", false, 2, (Object) null);
        if (!contains$default) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"", ""});
        } else {
            listOf = StringsKt__StringsKt.split$default((CharSequence) item, new String[]{":"}, false, 0, 6, (Object) null);
        }
        String str = (String) listOf.get(0);
        String str2 = (String) listOf.get(1);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
        return new Pair<>(Long.valueOf(longValue), Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0));
    }

    public static final void setCachedMapThemeList(i iVar) {
        String eVar;
        if (iVar != null) {
            try {
                com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                eVar2.v("fetchMapTheme", c45.i.c(iVar));
                eVar = eVar2.toString();
            } catch (JSONException e16) {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Error encoding data for cache: ");
                m3.append(e16.getMessage());
                kLog.e("NearbyMapThemeRepo", m3.toString());
                return;
            }
        } else {
            eVar = "";
        }
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.setCachedToNative("fetchMapTheme", eVar, null);
        KLog.INSTANCE.i("NearbyMapThemeRepo", "Map themes updated in cache. rspInfo:" + iVar);
    }

    public static final void setEnterNBPMain(boolean z16) {
        String str;
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.setCachedToNative("in_nbp_main", str, null);
    }

    public static final void setPrayCalendarTips(boolean z16) {
        int i3;
        Pair<Long, Integer> parsePrayCalendarTips = parsePrayCalendarTips();
        long longValue = parsePrayCalendarTips.component1().longValue();
        int intValue = parsePrayCalendarTips.component2().intValue();
        if (z16) {
            i3 = 2;
        } else {
            i3 = NearbyFormatUtils.INSTANCE.isToday(longValue) ? intValue + 1 : 1;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(APICallTechReporterKt.NBPCurrentTime());
        sb5.append(':');
        sb5.append(i3);
        Utils.INSTANCE.cacheModule("").setItem("NBP_CACHE_KEY_HOME_LAST_PRAY_CALENDAR_TIPS", sb5.toString());
    }

    public static final List<j> toNearbyProStImages(List<ag> list) {
        ArrayList arrayList = new ArrayList();
        for (ag agVar : list) {
            arrayList.add(new j(agVar.f425139d, agVar.f425140e, 4));
        }
        return arrayList;
    }

    public static final List<ag> toStImages(List<j> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<j> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ag(it.next().f418083d, 14));
        }
        return arrayList;
    }

    public static final l toStatusFeed(String str) {
        try {
            byte[] a16 = d45.a.a(str);
            if (a16 == null) {
                return null;
            }
            return (l) c45.i.b(new l(null, null, null, null, null, null, null, 0L, null, false, 0, null, 0, null, null, 2097151), a16);
        } catch (Throwable th5) {
            KLog.INSTANCE.i("toStatusFeed", "error: " + th5);
            return null;
        }
    }

    public static final af toUser(r25.e eVar) {
        List mutableList;
        if (eVar == null) {
            return null;
        }
        String str = eVar.J;
        int i3 = eVar.K;
        String str2 = eVar.L;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) eVar.I);
        int i16 = 0;
        if (str.length() == 0) {
            UserDataManager userDataManager = UserDataManager.INSTANCE;
            if (userDataManager.isHostTid(Long.valueOf(eVar.f430610d))) {
                str = userDataManager.getUserSelfInfo().nickName;
                i3 = userDataManager.getUserSelfInfo().gender;
                str2 = userDataManager.getUserSelfInfo().avatarUrl;
                mutableList = CollectionsKt__CollectionsKt.mutableListOf(new r25.b(i16, new c(userDataManager.getUserSelfInfo().avatarDressBorderUrl, 23), 3));
            }
        }
        return new af(null, eVar.f430610d, str, 0, null, i3, null, null, str2, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, mutableList, null, null, false, false, -295, 251);
    }

    public static void toastAPIErrorMsg$default(int i3, String str) {
        if (!isShowBackendErrorMsg(i3)) {
            str = "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
        }
        Utils.INSTANCE.currentBridgeModule().qToast(str, QToastMode.Info);
    }

    public static final boolean isCityWalk(n nVar) {
        d dVar = nVar.H;
        if (dVar != null) {
            Intrinsics.checkNotNull(dVar);
            if (!dVar.f425158d.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static final i toMapThemeListRsp(String str) {
        m25.c cVar = null;
        byte b16 = 0;
        byte b17 = 0;
        try {
            byte[] a16 = d45.a.a(new com.tencent.kuikly.core.nvi.serialization.json.e(str).p("fetchMapTheme"));
            if (a16 == null) {
                return null;
            }
            return (i) c45.i.b(new i(cVar, b17 == true ? 1 : 0, 3, b16 == true ? 1 : 0), a16);
        } catch (Throwable th5) {
            KLog.INSTANCE.i("toGetMapThemeListRsp", "error: " + th5);
            return null;
        }
    }

    public static boolean canOpenPOIPage$default(ah ahVar) {
        String str;
        if (ahVar == null || (str = ahVar.Q) == null) {
            str = "";
        }
        if (ahVar == null) {
            return false;
        }
        if ((str.length() == 0) || Intrinsics.areEqual(str, "\u672a\u77e5\u5730\u70b9")) {
            return false;
        }
        if (ahVar.G.length() == 0) {
            return false;
        }
        if (ahVar.H.length() == 0) {
            return false;
        }
        if (ahVar.I.length() == 0) {
            return false;
        }
        return !(ahVar.M.length() == 0);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public static final p35.n toStrangerFeed(n25.l r48) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt.toStrangerFeed(n25.l):p35.n");
    }

    public static final boolean checkEditAccess(int i3) {
        if (i3 == 1) {
            return Intrinsics.areEqual(Utils.INSTANCE.currentBridgeModule().getCachedFromNative("is_in_qq_kl"), "1");
        }
        return isInNBPMain();
    }

    public static final l toStatusFeed(n nVar) {
        String str;
        r25.e eVar;
        q25.g gVar;
        q25.f fVar;
        c45.a aVar;
        List<j> list;
        k kVar;
        n25.f fVar2;
        long j3;
        boolean z16;
        int i3;
        int i16;
        b bVar;
        n nVar2;
        Iterator<p35.c> it;
        long j16;
        boolean z17;
        int i17;
        int i18;
        n25.i iVar;
        String str2;
        int i19;
        n25.i iVar2;
        String str3 = nVar.f425193d;
        r25.e user = toUser(nVar.f425194e);
        q25.g gVar2 = nVar.f425195f;
        if (gVar2 == null) {
            gVar2 = new q25.g(0, 0, null, null, null, null, null, null, null, null, 1023, null);
        }
        q25.f fVar3 = nVar.f425196h;
        if (fVar3 == null) {
            fVar3 = new q25.f(0, null, null, null, null, null, 63, null);
        }
        c45.a aVar2 = nVar.f425197i;
        List<j> nearbyProStImages = toNearbyProStImages(nVar.f425198m);
        ah ahVar = nVar.C;
        if (ahVar != null) {
            String str4 = ahVar.f425143d;
            String str5 = ahVar.f425144e;
            int i26 = ahVar.f425145f;
            String str6 = ahVar.f425146h;
            String str7 = ahVar.f425147i;
            int i27 = ahVar.f425148m;
            p35.af afVar = ahVar.C;
            if (afVar != null) {
                Intrinsics.checkNotNull(afVar);
                aVar = aVar2;
                list = nearbyProStImages;
                long j17 = afVar.f425135d;
                p35.af afVar2 = ahVar.C;
                Intrinsics.checkNotNull(afVar2);
                gVar = gVar2;
                fVar = fVar3;
                long j18 = afVar2.f425136e;
                p35.af afVar3 = ahVar.C;
                Intrinsics.checkNotNull(afVar3);
                str = str3;
                eVar = user;
                long j19 = afVar3.f425137f;
                p35.af afVar4 = ahVar.C;
                Intrinsics.checkNotNull(afVar4);
                str2 = str7;
                i19 = i27;
                iVar2 = new n25.i(j17, j18, j19, afVar4.f425138h);
            } else {
                str = str3;
                eVar = user;
                gVar = gVar2;
                fVar = fVar3;
                aVar = aVar2;
                list = nearbyProStImages;
                str2 = str7;
                i19 = i27;
                iVar2 = null;
            }
            kVar = new k(str4, str5, i26, str6, str2, i19, iVar2, ahVar.D, ahVar.E, ahVar.F, ahVar.G, ahVar.H, ahVar.I, ahVar.J, ahVar.K, ahVar.L, ahVar.M, ahVar.N, ahVar.P, ahVar.Q, 1048576);
        } else {
            str = str3;
            eVar = user;
            gVar = gVar2;
            fVar = fVar3;
            aVar = aVar2;
            list = nearbyProStImages;
            kVar = null;
        }
        long j26 = nVar.D;
        ac acVar = nVar.E;
        if (acVar != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<af> it5 = acVar.f425121f.iterator();
            while (it5.hasNext()) {
                r25.e user2 = toUser(it5.next());
                Intrinsics.checkNotNull(user2);
                arrayList.add(user2);
            }
            fVar2 = new n25.f(acVar.f425119d, acVar.f425120e, arrayList, acVar.f425122h, 48);
        } else {
            fVar2 = null;
        }
        boolean z18 = nVar.F;
        int i28 = nVar.G;
        int i29 = nVar.L;
        d dVar = nVar.H;
        if (dVar != null) {
            List<p35.c> list2 = dVar.f425158d;
            ArrayList arrayList2 = new ArrayList();
            Iterator<p35.c> it6 = list2.iterator();
            while (it6.hasNext()) {
                p35.c next = it6.next();
                String str8 = next.f425152d;
                int i36 = next.f425153e;
                List<j> nearbyProStImages2 = toNearbyProStImages(next.f425154f);
                p35.af afVar5 = next.f425155h;
                if (afVar5 != null) {
                    Intrinsics.checkNotNull(afVar5);
                    i18 = i29;
                    long j27 = afVar5.f425135d;
                    it = it6;
                    p35.af afVar6 = next.f425155h;
                    Intrinsics.checkNotNull(afVar6);
                    z17 = z18;
                    i17 = i28;
                    long j28 = afVar6.f425136e;
                    p35.af afVar7 = next.f425155h;
                    Intrinsics.checkNotNull(afVar7);
                    j16 = j26;
                    long j29 = afVar7.f425137f;
                    p35.af afVar8 = next.f425155h;
                    Intrinsics.checkNotNull(afVar8);
                    iVar = new n25.i(j27, j28, j29, afVar8.f425138h);
                } else {
                    it = it6;
                    j16 = j26;
                    z17 = z18;
                    i17 = i28;
                    i18 = i29;
                    iVar = null;
                }
                arrayList2.add(new a(str8, i36, nearbyProStImages2, iVar, next.f425156i, next.f425157m));
                i29 = i18;
                it6 = it;
                z18 = z17;
                i28 = i17;
                j26 = j16;
            }
            j3 = j26;
            z16 = z18;
            i3 = i28;
            i16 = i29;
            nVar2 = nVar;
            bVar = new b(arrayList2);
        } else {
            j3 = j26;
            z16 = z18;
            i3 = i28;
            i16 = i29;
            bVar = null;
            nVar2 = nVar;
        }
        return new l(str, eVar, gVar, fVar, aVar, list, kVar, j3, fVar2, z16, i3, null, i16, bVar, nVar2.I, 1733120);
    }

    public static final String formatToDisplay(int i3) {
        String sb5;
        try {
            if (i3 < 10000) {
                sb5 = String.valueOf(i3);
            } else {
                if (i3 >= 100000) {
                    return "10\u4e07+";
                }
                double d16 = (i3 + 500) / 10000.0d;
                int i16 = (int) d16;
                int i17 = (int) ((d16 - i16) * 10);
                if (i17 == 0) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(i16);
                    sb6.append('\u4e07');
                    sb5 = sb6.toString();
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(i16);
                    sb7.append('.');
                    sb7.append(i17);
                    sb7.append('\u4e07');
                    sb5 = sb7.toString();
                }
            }
            return sb5;
        } catch (Throwable th5) {
            System.out.println((Object) ("formatToDisplay error: " + th5));
            return "";
        }
    }

    public static final void postOnNBPArticleFeedDetailFirstFeedDeleted(int i3, String str) {
        if (i3 != 1) {
            return;
        }
        try {
            com.tencent.kuikly.core.module.k kVar = (com.tencent.kuikly.core.module.k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            eVar.v("feed_id", str);
            eVar.v("feedId", str);
            Unit unit = Unit.INSTANCE;
            com.tencent.kuikly.core.module.k.d(kVar, "NBPFeedDeleteEvent", eVar, false, 4, null);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("postOnNBPFeedDeleteEvent error: ", th5, KLog.INSTANCE, "postOnNBPArticleFeedDetailFirstFeedDeleted");
        }
    }

    public static final ah toPoiInfo(k kVar) {
        String str;
        int i3;
        p35.af afVar;
        if (kVar == null) {
            return null;
        }
        String str2 = kVar.f418086d;
        String str3 = kVar.f418087e;
        int i16 = kVar.f418088f;
        String str4 = kVar.f418089h;
        String str5 = kVar.f418090i;
        int i17 = kVar.f418091m;
        n25.i iVar = kVar.C;
        if (iVar != null) {
            str = str5;
            i3 = i17;
            afVar = new p35.af(iVar.f418079d, iVar.f418080e, iVar.f418081f, iVar.f418082h);
        } else {
            str = str5;
            i3 = i17;
            afVar = null;
        }
        return new ah(str2, str3, i16, str4, str, i3, afVar, kVar.D, kVar.E, kVar.F, kVar.G, kVar.H, kVar.I, kVar.J, kVar.K, kVar.L, kVar.M, kVar.N, kVar.P, kVar.Q, null, 1048576);
    }

    public static final float doCalculateProgress(boolean z16, boolean z17, int i3, boolean z18, boolean z19, int i16, int i17) {
        List listOf;
        int i18;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Boolean[]{Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(i3 != 0), Boolean.valueOf(z18)});
        if ((listOf instanceof Collection) && listOf.isEmpty()) {
            i18 = 0;
        } else {
            Iterator it = listOf.iterator();
            i18 = 0;
            while (it.hasNext()) {
                if (((Boolean) it.next()).booleanValue() && (i18 = i18 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        return ((((i18 * 5) + Math.min(i16 * 3, 30)) + (z19 ? 20 : 0)) + Math.min(i17 * 3, 30)) / 100;
    }

    public static final void postOnGetNBPArticleFeedDetailFirstFeed(int i3, int i16, n nVar) {
        List<af> list;
        List<h> list2;
        List<af> list3;
        List<h> list4;
        n nVar2 = nVar;
        if (i3 == 1 && i16 == 1) {
            p35.g gVar = nVar2.J;
            int i17 = 0;
            int size = (gVar == null || (list4 = gVar.f425170e) == null) ? 0 : list4.size();
            ac acVar = nVar2.E;
            if (acVar != null && (list3 = acVar.f425121f) != null) {
                i17 = list3.size();
            }
            if (size > 0 || i17 > 0) {
                nVar2 = (n) c45.i.b(new n(null, null, null, null, null, null, null, 0L, null, false, 0, null, null, null, 0, 0, 524287), c45.i.d(nVar));
                p35.g gVar2 = nVar2.J;
                if (gVar2 != null && (list2 = gVar2.f425170e) != null) {
                    list2.clear();
                }
                ac acVar2 = nVar2.E;
                if (acVar2 != null && (list = acVar2.f425121f) != null) {
                    list.clear();
                }
            }
            try {
                com.tencent.kuikly.core.module.k kVar = (com.tencent.kuikly.core.module.k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                eVar.v("first_feed_base64", c45.i.c(nVar2));
                Unit unit = Unit.INSTANCE;
                com.tencent.kuikly.core.module.k.d(kVar, "OnGetArticleFeedDetailFirstFeed", eVar, false, 4, null);
            } catch (Throwable th5) {
                AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("postOnGetNBPArticleFeedDetailFirstFeed error: ", th5, KLog.INSTANCE, "postOnGetNBPArticleFeedDetailFirstFeed");
            }
        }
    }

    public static final r25.e toUser(af afVar) {
        if (afVar != null) {
            return new r25.e(afVar.f433207e, afVar.f433210f0, afVar.f433209f, afVar.f433218m, afVar.E, 1073680382);
        }
        return null;
    }
}
