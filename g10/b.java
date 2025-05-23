package g10;

import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.List;
import mz.h;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static int c(XRecyclerView xRecyclerView) {
        int e16 = e(xRecyclerView);
        x.f("WSGridUtils", "[WSGridPageUtils.java][getDefaultExposeCount] visibleHeaderCount: " + e16);
        try {
            return (d(xRecyclerView) - e16) + 1;
        } catch (Exception e17) {
            x.f("WSGridUtils", "[WSGridPageUtils.java][getDefaultExposeCount] error: " + e17.getMessage());
            return 4;
        }
    }

    public static int b(int[] iArr) {
        int i3 = iArr[0];
        for (int i16 : iArr) {
            if (i16 > i3) {
                i3 = i16;
            }
        }
        return i3;
    }

    public static int d(XRecyclerView xRecyclerView) {
        if (xRecyclerView != null && xRecyclerView.getRecyclerView() != null) {
            RecyclerView.LayoutManager layoutManager = xRecyclerView.getRecyclerView().getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] iArr = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                try {
                    ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(iArr);
                    return b(iArr);
                } catch (NullPointerException unused) {
                    x.f("WSGridUtils", "[WSGridPageUtils.java][getLastVisiblePosition] NullPointerException");
                }
            }
        }
        return -1;
    }

    public static h a(List<h> list, String str) {
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            for (h hVar : list) {
                if (str.equals(hVar.d())) {
                    return hVar;
                }
            }
        }
        return null;
    }

    private static int e(XRecyclerView xRecyclerView) {
        if (xRecyclerView == null || xRecyclerView.getRecyclerView() == null || !(xRecyclerView.getRecyclerView().getAdapter() instanceof RecyclerViewHeaderViewAdapter)) {
            return 0;
        }
        RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter) xRecyclerView.getRecyclerView().getAdapter();
        int headerCount = recyclerViewHeaderViewAdapter.getHeaderCount();
        int i3 = 0;
        for (int i16 = 0; i16 < headerCount; i16++) {
            if (recyclerViewHeaderViewAdapter.getHeader(i16).getVisibility() == 0) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String f(boolean z16, int i3, stSimpleMetaFeed stsimplemetafeed, WSRedDotPushMsg wSRedDotPushMsg, String str) {
        String str2;
        String str3;
        int i16;
        if (wSRedDotPushMsg != null) {
            str2 = wSRedDotPushMsg.mFeedIds;
            str3 = wSRedDotPushMsg.mPushId;
            i16 = bb.s(wSRedDotPushMsg);
        } else {
            str2 = "";
            str3 = "0";
            i16 = 0;
        }
        if (!z16 && TextUtils.isEmpty(str2) && stsimplemetafeed != null) {
            str2 = stsimplemetafeed.f25129id;
        }
        int V = i16 != 0 ? WeiShiCacheManager.O().V() : 0;
        int i17 = z16 ? 1 : 2;
        WSReportDc00898.o(301, new Object[]{Integer.valueOf(i3), str3, str2, Integer.valueOf(V), Integer.valueOf(i16), Integer.valueOf(i17), 1});
        com.tencent.biz.pubaccount.weishi.recommend.a.r(stsimplemetafeed, i16, i17, V, str);
        return str2;
    }
}
