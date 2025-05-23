package com.tencent.sqshow.zootopia.utils;

import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Landroid/support/v7/widget/RecyclerView;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "", "a", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class p {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\"\u0010\u0011\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006 "}, d2 = {"com/tencent/sqshow/zootopia/utils/p$a", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "Lid3/d;", "dtReportHelper", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "", "scrollInstance", "screenHeight", "", "b", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "newState", "onScrollStateChanged", "dx", "dy", "onScrolled", "d", "I", "getMDy", "()I", "setMDy", "(I)V", "mDy", "e", "getScreenHeight", "f", "Lid3/d;", "getDtReporter", "()Lid3/d;", "dtReporter", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mDy;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int screenHeight;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final id3.d dtReporter = new id3.d(null, 1, null);

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f373298h;

        a(RecyclerView recyclerView, ZootopiaSource zootopiaSource) {
            this.f373298h = zootopiaSource;
            this.screenHeight = ScreenUtil.getRealHeight(recyclerView.getContext());
        }

        private final void b(id3.d dtReportHelper, ZootopiaSource sourceCurrent, int scrollInstance, int screenHeight) {
            String str;
            HashMap hashMap = new HashMap();
            VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
            String str2 = pageInfo != null ? pageInfo.pageId : null;
            if (str2 == null) {
                str2 = "";
            }
            QLog.i("RecyclerViewEx", 1, "finalReportEvent " + sourceCurrent + " , scrollInstance = " + scrollInstance + " , page is " + str2);
            if ((pageInfo != null ? pageInfo.pageId : null) != null) {
                String str3 = pageInfo.pageId;
                Intrinsics.checkNotNullExpressionValue(str3, "curPage.pageId");
                hashMap.put("dt_pgid", str3);
            }
            hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(sourceCurrent));
            hashMap.put("zplan_screen_height", Integer.valueOf(screenHeight));
            hashMap.put("zplan_slide_distance", Integer.valueOf(Math.abs(scrollInstance)));
            if (scrollInstance > 0) {
                str = "1";
            } else {
                str = "2";
            }
            hashMap.put("zplan_slide_direction", str);
            dtReportHelper.d("ev_zplan_screen_slide", hashMap);
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                b(this.dtReporter, this.f373298h, this.mDy, this.screenHeight);
                this.mDy = 0;
            } else {
                if (newState != 1) {
                    return;
                }
                this.mDy = 0;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            super.onScrolled(recyclerView, dx5, dy5);
            this.mDy += dy5;
        }
    }

    public static final void a(RecyclerView recyclerView, ZootopiaSource sourceCurrent) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        QLog.i("RecyclerViewEx", 1, "bindScrollReport " + recyclerView);
        recyclerView.addOnScrollListener(new a(recyclerView, sourceCurrent));
    }
}
