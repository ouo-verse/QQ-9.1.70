package com.tencent.biz.qqcircle.immersive.repository.foldertab;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.l;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f89778e = uq3.c.S4();

    /* renamed from: a, reason: collision with root package name */
    private final l.a f89779a;

    /* renamed from: c, reason: collision with root package name */
    public List<e30.b> f89781c = null;

    /* renamed from: b, reason: collision with root package name */
    public List<e30.b> f89780b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public Map<Integer, e30.b> f89782d = new HashMap();

    public f(List<e30.b> list, @NonNull l.a aVar) {
        this.f89779a = aVar;
        if (list == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            e30.b bVar = list.get(i3);
            if (bVar != null) {
                if (b(bVar)) {
                    this.f89780b.add(bVar);
                } else {
                    int i16 = aVar.f89806c + i3;
                    this.f89782d.put(Integer.valueOf(i16), bVar);
                    QLog.d("QFSRankTabDataRepository[QFSRankFeedSnapshot]", 1, "getFeedSnapshot add diff feed bean to index:" + i16);
                }
            }
        }
    }

    private static boolean b(e30.b bVar) {
        FeedCloudMeta$StFeed g16 = bVar.g();
        if (g16 == null) {
            return false;
        }
        int i3 = g16.feedType.get();
        int i16 = g16.type.get();
        if (i3 == 1) {
            if (i16 != 2 && i16 != 3) {
                return false;
            }
            return true;
        }
        if (!f89778e || i3 != 4) {
            return false;
        }
        return true;
    }

    public l.a a() {
        return this.f89779a;
    }
}
