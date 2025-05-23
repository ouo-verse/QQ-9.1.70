package e30;

import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$RecomReed;
import feedcloud.FeedCloudMeta$StFeed;
import h30.e;
import h30.f;
import h30.g;
import h30.h;
import h30.i;
import h30.j;
import h30.k;
import h30.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static List<h30.c> f395537a;

    static {
        ArrayList arrayList = new ArrayList();
        f395537a = arrayList;
        arrayList.add(new h30.d());
        f395537a.add(new h30.b());
        f395537a.add(new f());
        f395537a.add(new l());
        f395537a.add(new g());
        f395537a.add(new j());
        f395537a.add(new h());
        f395537a.add(new i());
        f395537a.add(new h30.a());
        f395537a.add(new e());
        f395537a.add(new k());
    }

    public static void a(b bVar, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (bVar != null && feedCloudMeta$StFeed != null) {
            Iterator<h30.c> it = f395537a.iterator();
            while (it.hasNext()) {
                it.next().d(bVar);
            }
        }
    }

    public static ArrayList<b> b(List<FeedCloudMeta$StFeed> list) {
        ArrayList<b> arrayList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
                try {
                    uc0.a.e(feedCloudMeta$StFeed);
                    arrayList.add(new b(feedCloudMeta$StFeed).p());
                } catch (Exception e16) {
                    QLog.d("QCircleTransFormHelper", 1, "transForm exception:" + e16.getMessage());
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static List<FeedCloudCommon$RecomReed> c(@NonNull List<FeedCloudMeta$StFeed> list) {
        ArrayList arrayList = new ArrayList();
        for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
            if (feedCloudMeta$StFeed != null) {
                FeedCloudCommon$RecomReed feedCloudCommon$RecomReed = new FeedCloudCommon$RecomReed();
                feedCloudCommon$RecomReed.item_id.set(feedCloudMeta$StFeed.f398449id.get());
                feedCloudCommon$RecomReed.tranfer.set(feedCloudMeta$StFeed.recomInfo.clientSealData.get());
                arrayList.add(feedCloudCommon$RecomReed);
            }
        }
        return arrayList;
    }

    public static ArrayList<FeedCloudMeta$StFeed> d(List<b> list) {
        ArrayList<FeedCloudMeta$StFeed> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (b bVar : list) {
                if (bVar != null && bVar.g() != null && bVar.g().dittoFeed != null && bVar.g().dittoFeed.dittoId.get() == 0) {
                    arrayList.add(bVar.g());
                }
            }
        }
        return arrayList;
    }
}
