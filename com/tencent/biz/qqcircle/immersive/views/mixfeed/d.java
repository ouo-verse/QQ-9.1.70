package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleDefaultFeedItemView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleDitto$StCircleDittoDataNew;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;
import qqcircle.QQCircleFeedBase$StSubTabInfo;
import x70.f;
import x70.g;
import x70.h;
import x70.i;
import x70.j;
import x70.k;
import x70.l;
import x70.m;
import x70.n;
import x70.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static int f90914a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f90915b = 2;

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f90916c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<Integer, g> f90917d;

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        f90916c = hashMap;
        HashMap<Integer, g> hashMap2 = new HashMap<>();
        f90917d = hashMap2;
        hashMap.put(20, 536870944);
        hashMap2.put(536870944, new f());
        hashMap.put(27, 536870951);
        hashMap2.put(536870951, new i());
        hashMap.put(21, 536870945);
        hashMap2.put(536870945, new h());
        hashMap.put(22, 536870946);
        hashMap2.put(536870946, new l());
        hashMap.put(23, 536870947);
        hashMap2.put(536870947, new j());
        hashMap.put(51, 536870961);
        hashMap2.put(536870961, new k());
        hashMap.put(52, 536870962);
        hashMap2.put(536870962, new x70.b());
        hashMap.put(53, 536870963);
        hashMap2.put(536870963, new x70.c());
        hashMap.put(24, 536870948);
        hashMap2.put(536870948, new m());
        hashMap.put(25, 536870949);
        hashMap2.put(536870949, new o());
        hashMap.put(26, 536870950);
        hashMap2.put(536870950, new n());
        hashMap.put(4, 536870960);
        hashMap2.put(536870960, new x70.e());
        hashMap.put(2, 536870952);
        hashMap.put(3, 536870952);
        hashMap2.put(536870952, new x70.d());
        hashMap2.put(536870912, new x70.a());
    }

    public static QCircleBaseWidgetView<e30.b> a(ViewGroup viewGroup, int i3) {
        if (i3 == 536870949 && !uq3.c.J6()) {
            return new QCircleDefaultFeedItemView(viewGroup.getContext());
        }
        g gVar = f90917d.get(Integer.valueOf(i3));
        if (gVar == null) {
            return new QCircleDefaultFeedItemView(viewGroup.getContext());
        }
        return gVar.a(viewGroup.getContext());
    }

    public static int b() {
        return f90916c.size() - 1;
    }

    public static int c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return 536870912;
        }
        int i3 = feedCloudMeta$StFeed.dittoFeed.dittoId.get();
        HashMap<Integer, Integer> hashMap = f90916c;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            return hashMap.get(Integer.valueOf(i3)).intValue();
        }
        if (!hashMap.containsKey(Integer.valueOf(feedCloudMeta$StFeed.type.get()))) {
            return 536870912;
        }
        return hashMap.get(Integer.valueOf(feedCloudMeta$StFeed.type.get())).intValue();
    }

    public static int d(int i3) {
        switch (i3) {
            case 536870949:
            case 536870950:
            case 536870952:
            case 536870960:
                return f90914a;
            default:
                return f90915b;
        }
    }

    public static int e(List<QQCircleFeedBase$StSubTabInfo> list, int i3) {
        Iterator<QQCircleFeedBase$StSubTabInfo> it = list.iterator();
        int i16 = -1;
        while (it.hasNext()) {
            i16++;
            if (it.next().sourceType.get() == i3) {
                return i16;
            }
        }
        return -1;
    }

    public static String f(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, String str) {
        if (qQCircleDitto$StItemInfo.urlInfo.get() == null) {
            return "";
        }
        return QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.urlInfo.get(), str);
    }

    public static boolean g(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean == null) {
            QLog.e("QFSMixFeedViewHelper", 1, "[isShowPoiView] initBean should not be null");
            return false;
        }
        if (qCircleInitBean.getSchemeAttrs() != null) {
            String str = qCircleInitBean.getSchemeAttrs().get("xsj_custom_pgid");
            if (!TextUtils.isEmpty(str) && str.equals(QCircleDaTongConstant.PageId.PG_XSJ_MINIGAME_FEED_PAGE)) {
                return false;
            }
        }
        if (qCircleInitBean.getFeed() != null && qCircleInitBean.getFeed().liteBanner != null && TextUtils.isEmpty(qCircleInitBean.getFeed().liteBanner.title.get()) && qCircleInitBean.getFeed().liteBanner.style_type.get() == 0) {
            return true;
        }
        return false;
    }

    public static Pair<Integer, Integer> h(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return new Pair<>(0, 0);
        }
        int i3 = (bz.i(context) / 2) - cx.a(4.0f);
        if (c(feedCloudMeta$StFeed) != 536870950 && c(feedCloudMeta$StFeed) != 536870949) {
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf((int) (i3 * 1.3333334f)));
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf((int) ((i3 * 1.3333334f) + cx.a(60.0f))));
    }

    public static QQCircleDitto$StItemContainer i(e30.b bVar, String str) {
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = null;
        try {
            QQCircleDitto$StCircleDittoDataNew qQCircleDitto$StCircleDittoDataNew = new QQCircleDitto$StCircleDittoDataNew();
            Object b16 = bVar.b(str);
            if (b16 instanceof QQCircleDitto$StCircleDittoDataNew) {
                qQCircleDitto$StItemContainer = ((QQCircleDitto$StCircleDittoDataNew) b16).itemContainter;
                QLog.d("QFSMixFeedViewHelper", 1, "[bindData] get data from blockData");
            } else {
                qQCircleDitto$StItemContainer = qQCircleDitto$StCircleDittoDataNew.mergeFrom(bVar.g().dittoFeed.dittoDataNew.get().toByteArray()).itemContainter;
                QLog.d("QFSMixFeedViewHelper", 1, "[bindData] get data from merger");
            }
        } catch (Exception e16) {
            QLog.e("QFSMixFeedViewHelper", 1, "[bindData] Exception" + e16);
        }
        return qQCircleDitto$StItemContainer;
    }
}
