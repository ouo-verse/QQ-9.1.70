package com.qzone.reborn.feedx.scroller;

import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014JL\u0010\u0012\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/feedx/scroller/b;", "Lhh/b;", "", "r", "", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "", "isScrollUp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onResume", "j", "", "J", "pageExposureStartTime", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends hh.b {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long pageExposureStartTime = -1;

    private final void r() {
        if (QZoneFeedxViewUtils.h(this.f404911e)) {
            this.pageExposureStartTime = System.currentTimeMillis();
            fo.c.b("qq_pgin", this.f404911e, "placeholder", null);
        }
    }

    @Override // hh.b
    /* renamed from: c */
    protected String getTAG() {
        return "QZoneAIOUserPageReportScroller";
    }

    @Override // hh.b
    public void j() {
        super.j();
        if (this.pageExposureStartTime == -1) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.pageExposureStartTime;
        HashMap hashMap = new HashMap();
        hashMap.put("stay_time", Long.valueOf(currentTimeMillis));
        fo.b bVar = new fo.b();
        bVar.l(hashMap);
        this.pageExposureStartTime = -1L;
        fo.c.b("qq_pgout", this.f404911e, "placeholder", bVar);
    }

    @Override // hh.b
    public void m(RecyclerView recyclerView, int newState, RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        super.m(recyclerView, newState, manager, firstVisiblePos, lastVisiblePos, firstCompletelyVisible, lastCompletelyVisible, isScrollUp);
        if (newState == 0 && this.pageExposureStartTime == -1) {
            r();
        }
    }

    @Override // hh.b
    public void onResume() {
        super.onResume();
        r();
    }
}
