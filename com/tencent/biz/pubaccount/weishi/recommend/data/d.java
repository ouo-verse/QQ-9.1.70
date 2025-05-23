package com.tencent.biz.pubaccount.weishi.recommend.data;

import UserGrowth.stCardInfo;
import UserGrowth.stCollection;
import UserGrowth.stCollectionCardInfo;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<String> f81417a = new HashSet<>();

    private String b(StringBuilder sb5) {
        if (sb5.length() > 1) {
            String substring = sb5.substring(0, sb5.length() - 1);
            x.m("WSGridDataFilter", "[getRepetitiveFeedIds] repetitive feedIds:" + substring);
            return substring;
        }
        return "";
    }

    private String c(HashSet<String> hashSet) {
        if (hashSet.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<String> it = hashSet.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append("_");
            }
            String substring = sb5.substring(0, sb5.length() - 1);
            x.m("WSGridDataFilter", "[getRepetitiveTraceIds] repetitive traceIds:" + substring);
            return substring;
        }
        return "";
    }

    private boolean d(stSimpleMetaFeed stsimplemetafeed) {
        stCollectionCardInfo stcollectioncardinfo;
        ArrayList<stCollection> arrayList;
        if (stsimplemetafeed == null || stsimplemetafeed.video_type != 9) {
            return false;
        }
        stCardInfo stcardinfo = stsimplemetafeed.cardInfo;
        if (stcardinfo == null || (stcollectioncardinfo = stcardinfo.collectionCardInfo) == null || (arrayList = stcollectioncardinfo.collectionList) == null) {
            return true;
        }
        return TextUtils.isEmpty(stcollectioncardinfo.title) || arrayList.size() <= 0;
    }

    public void a(boolean z16, boolean z17, ArrayList<stSimpleMetaFeed> arrayList, String str) {
        if (z16 || z17) {
            this.f81417a.clear();
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        HashSet<String> hashSet = new HashSet<>();
        StringBuilder sb5 = new StringBuilder();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            stSimpleMetaFeed stsimplemetafeed = (stSimpleMetaFeed) it.next();
            if (d(stsimplemetafeed)) {
                arrayList.remove(stsimplemetafeed);
            } else if (this.f81417a.contains(stsimplemetafeed.f25129id)) {
                x.f("WSGridDataFilter", "[filterRepetitiveFeedList] removeFromList feedId:" + stsimplemetafeed.f25129id + ", traceId:" + stsimplemetafeed.traceId + ", title:" + stsimplemetafeed.feed_desc);
                sb5.append(stsimplemetafeed.f25129id);
                sb5.append("_");
                hashSet.add(stsimplemetafeed.traceId);
                arrayList.remove(stsimplemetafeed);
            } else if (!TextUtils.isEmpty(stsimplemetafeed.f25129id)) {
                x.j("WSGridDataFilter", "[filterRepetitiveFeedList] addToHashSet feedId:" + stsimplemetafeed.f25129id + ", traceId:" + stsimplemetafeed.traceId + ", title:" + stsimplemetafeed.feed_desc);
                this.f81417a.add(stsimplemetafeed.f25129id);
            }
        }
        String b16 = b(sb5);
        String c16 = c(hashSet);
        if (!z16 && !z17) {
            com.tencent.biz.pubaccount.weishi.recommend.a.l(0, b16, c16, str);
        } else {
            com.tencent.biz.pubaccount.weishi.recommend.a.m(z16, z17, 0, str);
        }
    }
}
