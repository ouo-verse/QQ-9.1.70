package com.tencent.util;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ,\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006J,\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/util/g;", "", "", "trace", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "Lkotlin/collections/ArrayList;", "infos", "", "a", "Lcom/tencent/qqnt/ntrelation/zoneinfo/bean/a;", "b", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f383981a = new g();

    g() {
    }

    public final void a(String trace, ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> infos) {
        if (infos == null) {
            return;
        }
        Iterator<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> it = infos.iterator();
        while (it.hasNext()) {
            QLog.i("LogUtil", 1, "OnlineStatusService " + trace + " detailInfo is " + it.next() + " \n");
        }
    }

    public final void b(String trace, ArrayList<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> infos) {
        if (infos == null) {
            return;
        }
        Iterator<com.tencent.qqnt.ntrelation.zoneinfo.bean.a> it = infos.iterator();
        while (it.hasNext()) {
            QLog.i("LogUtil", 1, "ZoneStatusService " + trace + " detailInfo is " + it.next() + " \n");
        }
    }
}
