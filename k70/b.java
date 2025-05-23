package k70;

import android.text.TextUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import l70.c;
import l70.d;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<FeedCloudMeta$StBarrage> f411796a;

    /* renamed from: b, reason: collision with root package name */
    private final d f411797b;

    /* renamed from: c, reason: collision with root package name */
    private final c f411798c;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a implements Comparator<FeedCloudMeta$StBarrage> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage2) {
            if (feedCloudMeta$StBarrage == null || feedCloudMeta$StBarrage2 == null || feedCloudMeta$StBarrage.feedPlayTime.get() <= feedCloudMeta$StBarrage2.feedPlayTime.get()) {
                return -1;
            }
            return 1;
        }
    }

    public b(com.tencent.rfw.barrage.core.c cVar, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f411797b = new d(cVar, feedCloudMeta$StFeed);
        this.f411798c = new c(cVar);
    }

    private List<FeedCloudMeta$StBarrage> c(List<FeedCloudMeta$StBarrage> list) {
        boolean z16;
        String str;
        String str2;
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.e("QDM-QFSBarrageDataFactory", 1, "[filterRepeatData] current filter list is empty, filter fail.");
            return null;
        }
        if (RFSafeListUtils.isEmpty(this.f411796a)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (FeedCloudMeta$StBarrage feedCloudMeta$StBarrage : list) {
            Iterator<FeedCloudMeta$StBarrage> it = this.f411796a.iterator();
            while (true) {
                if (it.hasNext()) {
                    FeedCloudMeta$StBarrage next = it.next();
                    if (next == null) {
                        str = null;
                    } else {
                        str = next.f398446id.get();
                    }
                    if (feedCloudMeta$StBarrage == null) {
                        str2 = null;
                    } else {
                        str2 = feedCloudMeta$StBarrage.f398446id.get();
                    }
                    if (TextUtils.equals(str, str2)) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                arrayList.add(feedCloudMeta$StBarrage);
            }
        }
        return arrayList;
    }

    private int d(String str) {
        String str2;
        if (RFSafeListUtils.isEmpty(this.f411796a)) {
            return -1;
        }
        for (int i3 = 0; i3 < this.f411796a.size(); i3++) {
            FeedCloudMeta$StBarrage feedCloudMeta$StBarrage = (FeedCloudMeta$StBarrage) RFSafeListUtils.get(this.f411796a, i3);
            if (feedCloudMeta$StBarrage == null) {
                str2 = null;
            } else {
                str2 = feedCloudMeta$StBarrage.f398446id.get();
            }
            if (TextUtils.equals(str, str2)) {
                return i3;
            }
        }
        return -1;
    }

    public List<FeedCloudMeta$StBarrage> a(List<FeedCloudMeta$StBarrage> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.e("QDM-QFSBarrageDataFactory", 1, "[appendToDataSource] current data source is empty, append data fail.");
            return null;
        }
        if (this.f411796a == null) {
            this.f411796a = new ArrayList();
        }
        List<FeedCloudMeta$StBarrage> arrayList = new ArrayList<>();
        try {
            String str = "[";
            arrayList = c(list);
            for (FeedCloudMeta$StBarrage feedCloudMeta$StBarrage : arrayList) {
                if (feedCloudMeta$StBarrage != null) {
                    this.f411796a.add(feedCloudMeta$StBarrage);
                    str = str + feedCloudMeta$StBarrage.f398446id.get() + "|" + feedCloudMeta$StBarrage.content.get() + ",";
                }
            }
            QLog.d("QDM-QFSBarrageDataFactory", 1, "[appendToDataSource] list: " + RFSafeListUtils.getSize(list) + " | barrageIdList: " + (str + "]"));
            Collections.sort(this.f411796a, new a());
        } catch (Throwable th5) {
            QLog.e("QDM-QFSBarrageDataFactory", 1, "[appendToDataSource] error: ", th5);
        }
        return arrayList;
    }

    public void b(List<FeedCloudMeta$StBarrage> list, k70.a aVar) {
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.e("QDM-QFSBarrageDataFactory", 1, "[convertFakeListToRenderNode] current data source is empty, convert fake list fail.");
            return;
        }
        List<com.tencent.rfw.barrage.data.a> b16 = this.f411798c.b(list);
        if (aVar == null) {
            QLog.e("QDM-QFSBarrageDataFactory", 1, "[convertFakeListToRenderNode] listener should not be null.");
        } else {
            aVar.a(b16);
        }
    }

    public List<FeedCloudMeta$StBarrage> e() {
        return this.f411796a;
    }

    public List<FeedCloudMeta$StBarrage> f(long j3) {
        PBUInt64Field pBUInt64Field;
        long j16;
        if (RFSafeListUtils.isEmpty(this.f411796a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f411796a.size(); i3++) {
            FeedCloudMeta$StBarrage feedCloudMeta$StBarrage = (FeedCloudMeta$StBarrage) RFSafeListUtils.get(this.f411796a, i3);
            if (feedCloudMeta$StBarrage == null) {
                pBUInt64Field = null;
            } else {
                pBUInt64Field = feedCloudMeta$StBarrage.feedPlayTime;
            }
            if (pBUInt64Field == null) {
                j16 = 0;
            } else {
                j16 = pBUInt64Field.get();
            }
            if (j3 <= j16) {
                arrayList.add(feedCloudMeta$StBarrage);
            }
        }
        return arrayList;
    }

    public boolean g(long j3, long j16) {
        int i3;
        int i16;
        boolean z16;
        long j17;
        if (RFSafeListUtils.isEmpty(this.f411796a)) {
            return false;
        }
        long j18 = j16 + j3;
        if (((int) j3) > 0) {
            i3 = (int) (j3 / 1000);
        } else {
            i3 = 0;
        }
        if (((int) j18) > 0) {
            i16 = (int) (j18 / 1000);
        } else {
            i16 = 0;
        }
        boolean z17 = false;
        while (i3 > i16) {
            Iterator<FeedCloudMeta$StBarrage> it = this.f411796a.iterator();
            while (true) {
                if (it.hasNext()) {
                    FeedCloudMeta$StBarrage next = it.next();
                    long j19 = 0;
                    if (next == null) {
                        j17 = 0;
                    } else {
                        j17 = next.feedPlayTime.get();
                    }
                    if (j17 > 0) {
                        j19 = j17 / 1000;
                    }
                    if (j19 >= i3) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                return false;
            }
            i3++;
            z17 = true;
        }
        return z17;
    }

    public void h(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        List<FeedCloudMeta$StBarrage> list = this.f411796a;
        if (list != null && feedCloudMeta$StBarrage != null) {
            list.remove(feedCloudMeta$StBarrage);
        }
    }

    public void i() {
        List<FeedCloudMeta$StBarrage> list = this.f411796a;
        if (list == null) {
            return;
        }
        QLog.d("QDM-QFSBarrageDataFactory", 1, "[resetToDataSource] reset data source, current data list count: " + RFSafeListUtils.getSize(list));
        this.f411796a.clear();
    }

    public void j(List<FeedCloudMeta$StBarrage> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.e("QDM-QFSBarrageDataFactory", 1, "[setDataSource] current data source is empty, set data source end flow.");
            return;
        }
        List<FeedCloudMeta$StBarrage> list2 = this.f411796a;
        if (list2 == null) {
            this.f411796a = new ArrayList();
        } else {
            list2.clear();
        }
        String str = "[";
        for (FeedCloudMeta$StBarrage feedCloudMeta$StBarrage : list) {
            if (feedCloudMeta$StBarrage != null) {
                this.f411796a.add(feedCloudMeta$StBarrage);
                str = str + feedCloudMeta$StBarrage.f398446id.get() + "|" + feedCloudMeta$StBarrage.content.get() + ",";
            }
        }
        QLog.e("QDM-QFSBarrageDataFactory", 1, "[setDataSource] list: " + RFSafeListUtils.getSize(list) + " | barrageIdList: " + (str + "]"));
        try {
            Collections.sort(this.f411796a, new a());
        } catch (Throwable th5) {
            QLog.e("QDM-QFSBarrageDataFactory", 1, "[setDataSource] error: ", th5);
        }
    }

    public void k(float f16) {
        d dVar = this.f411797b;
        if (dVar != null) {
            dVar.c(f16);
        }
        c cVar = this.f411798c;
        if (cVar != null) {
            cVar.c(f16);
        }
    }

    public void l(String str, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        if (this.f411796a == null) {
            QLog.e("QDM-QFSBarrageDataFactory", 1, "[updateFakeBarrageInfo] barrage list should not be null.");
            return;
        }
        int d16 = d(str);
        try {
            if (d16 != -1) {
                this.f411796a.remove(d16);
            } else {
                d16 = this.f411796a.size();
            }
            this.f411796a.add(d16, feedCloudMeta$StBarrage);
        } catch (Throwable th5) {
            QLog.e("QDM-QFSBarrageDataFactory", 1, "[updateFakeBarrageInfo] error: ", th5);
        }
    }
}
