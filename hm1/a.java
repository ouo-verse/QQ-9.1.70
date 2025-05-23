package hm1;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.temp.api.b;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qphone.base.util.QLog;
import fm1.c;
import fm1.d;
import fm1.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002\u001a\u001e\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0000j\u0002`\u0006*\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002\u001a8\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\n*\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0000j\u0004\u0018\u0001`\u0006\u001a\n\u0010\r\u001a\u00020\u0003*\u00020\f\u001a\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u00022\u0006\u0010\u0010\u001a\u00020\t*\u0018\b\u0002\u0010\u0013\"\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0012\u0004\u0012\u00020\u00010\u0000*\u0018\b\u0002\u0010\u0014\"\b\u0012\u0004\u0012\u00020\u00050\u00002\b\u0012\u0004\u0012\u00020\u00050\u0000*\u0018\b\u0002\u0010\u0015\"\b\u0012\u0004\u0012\u00020\f0\u00002\b\u0012\u0004\u0012\u00020\f0\u0000\u00a8\u0006\u0016"}, d2 = {"", "Lfm1/i;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/utils/BaseMediaList;", "", "a", "Lfm1/c;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/utils/LocalMediaList;", "b", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "f", QAdVrReportParams.ParamKey.MEDIA, "e", "from", "Lcom/tencent/mobileqq/guild/temp/api/b;", "c", "BaseMediaList", "LocalMediaList", "RawMediaList", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    public static final boolean a(@NotNull List<? extends i> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends i> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (d.c((i) it.next())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final List<c> b(@NotNull List<? extends i> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((i) obj).f()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Nullable
    public static final b c(@NotNull List<? extends i> list, @NotNull String from) {
        int collectionSizeOrDefault;
        Object firstOrNull;
        LocalMediaInfo realInfo;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        List<c> b16 = b(list);
        List<? extends i> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        boolean z16 = false;
        int i3 = 0;
        for (Object obj : list2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            i iVar = (i) obj;
            if (!iVar.f()) {
                realInfo = e(iVar);
            } else {
                realInfo = iVar.getRealInfo();
                Intrinsics.checkNotNull(realInfo);
            }
            arrayList.add(realInfo);
            i3 = i16;
        }
        Integer num = null;
        if (!arrayList.isEmpty()) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) b16);
            c cVar = (c) firstOrNull;
            if (cVar != null && cVar.l()) {
                z16 = true;
            }
            HashMap<String, String> d16 = d(b16);
            int size = arrayList.size();
            if (d16 != null) {
                num = Integer.valueOf(d16.size());
            }
            QLog.i("LocalMediaTransUtils", 2, from + "--rawMediaSize:" + size + ",isQuality:" + z16 + ",editMapSize:" + num);
            return new b(arrayList, z16, d16);
        }
        return null;
    }

    @Nullable
    public static final HashMap<String, String> d(@Nullable List<c> list) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Map map;
        boolean z16;
        if (list != null) {
            ArrayList<c> arrayList = new ArrayList();
            for (Object obj : list) {
                c cVar = (c) obj;
                if (!TextUtils.isEmpty(cVar.d()) && !TextUtils.equals(cVar.d(), cVar.getVideoPlayUrl())) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (c cVar2 : arrayList) {
                Pair pair = TuplesKt.to(cVar2.d(), cVar2.getVideoPlayUrl());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            map = MapsKt__MapsKt.toMap(linkedHashMap, new HashMap());
            return (HashMap) map;
        }
        return null;
    }

    private static final LocalMediaInfo e(i iVar) {
        String str;
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = "";
        localMediaInfo.mMediaType = !d.a(iVar) ? 1 : 0;
        if (d.a(iVar)) {
            str = "image";
        } else {
            str = "video/mp4";
        }
        localMediaInfo.mMimeType = str;
        return localMediaInfo;
    }

    public static final boolean f(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return !TextUtils.isEmpty(localMediaInfo.path);
    }
}
