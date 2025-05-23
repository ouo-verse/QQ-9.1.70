package com.qzone.reborn.feedx.scroller;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014JJ\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/feedx/scroller/a;", "Lhh/b;", "", "r", "", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "", "isScrollUp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mHasReportLogin", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends hh.b {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mHasReportLogin;

    private final void r() {
        if (this.mHasReportLogin) {
            return;
        }
        QLog.i("QZoneAIOLoginReportScroller", 1, "reportLogin");
        QZoneLoginReportHelper.reportLoginFromQQAio();
        this.mHasReportLogin = true;
    }

    @Override // hh.b
    /* renamed from: c */
    protected String getTAG() {
        return "QZoneAIOLoginReportScroller";
    }

    @Override // hh.b
    public void m(RecyclerView recyclerView, int newState, RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.m(recyclerView, newState, manager, firstVisiblePos, lastVisiblePos, firstCompletelyVisible, lastCompletelyVisible, isScrollUp);
        if (this.mHasReportLogin || newState != 0 || lastCompletelyVisible < 0) {
            return;
        }
        r();
    }
}
