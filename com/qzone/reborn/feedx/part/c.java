package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.itemview.memoryseal.QZoneGuestMemorySealFooterView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/feedx/part/c;", "Lcom/qzone/reborn/base/k;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "Lcom/tencent/mobileqq/activity/aio/intimate/flingappbar/FlingAppBarLayout;", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "E9", "", "D9", "G9", "I9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/activity/aio/intimate/flingappbar/FlingAppBarLayout$c;", "d", "Lcom/tencent/mobileqq/activity/aio/intimate/flingappbar/FlingAppBarLayout$c;", "mOnOffsetChangedListener", "", "e", "Z", "mHasReportLogin", "Lcom/tencent/biz/richframework/part/block/BlockContainer;", "f", "Lcom/tencent/biz/richframework/part/block/BlockContainer;", "mBlockContainer", tl.h.F, "Lcom/tencent/mobileqq/activity/aio/intimate/flingappbar/FlingAppBarLayout;", "mAppBarLayout", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FlingAppBarLayout.c mOnOffsetChangedListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mHasReportLogin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BlockContainer mBlockContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FlingAppBarLayout mAppBarLayout;

    private final void D9() {
        try {
            View G9 = G9();
            if (G9 == null || !G9.getLocalVisibleRect(new Rect())) {
                return;
            }
            I9();
        } catch (Throwable th5) {
            RFWLog.fatal("QZoneAIOLoginReportPart", RFWLog.USR, th5);
        }
    }

    private final View G9() {
        BlockMerger blockMerger;
        BlockContainer blockContainer = this.mBlockContainer;
        NestScrollRecyclerView recyclerView = blockContainer != null ? blockContainer.getRecyclerView() : null;
        if (recyclerView == null || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        BlockContainer blockContainer2 = this.mBlockContainer;
        int count = (blockContainer2 == null || (blockMerger = blockContainer2.getBlockMerger()) == null) ? 0 : blockMerger.getCount();
        if (count == 2) {
            return linearLayoutManager.findViewByPosition(1);
        }
        if (count <= 2) {
            return null;
        }
        View findViewByPosition = linearLayoutManager.findViewByPosition(2);
        return findViewByPosition instanceof QZoneGuestMemorySealFooterView ? linearLayoutManager.findViewByPosition(1) : findViewByPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(c this$0, FlingAppBarLayout flingAppBarLayout, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 || this$0.mHasReportLogin) {
            return;
        }
        this$0.D9();
    }

    private final void I9() {
        if (this.mHasReportLogin) {
            return;
        }
        QLog.i("QZoneAIOLoginReportPart", 1, "doReportLogin");
        QZoneLoginReportHelper.reportLoginFromQQAio();
        this.mHasReportLogin = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.mBlockContainer = rootView != null ? (BlockContainer) rootView.findViewById(R.id.mn6) : null;
        try {
            CoordinatorLayout E9 = E9(rootView);
            QLog.i("QZoneAIOLoginReportPart", 1, "find coordinatorLayout: " + E9);
            FlingAppBarLayout F9 = F9(E9);
            this.mAppBarLayout = F9;
            QLog.i("QZoneAIOLoginReportPart", 1, "find appBarLayout: " + F9);
            if (this.mOnOffsetChangedListener == null) {
                this.mOnOffsetChangedListener = new FlingAppBarLayout.c() { // from class: com.qzone.reborn.feedx.part.b
                    @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.b
                    public final void a(FlingAppBarLayout flingAppBarLayout, int i3) {
                        c.H9(c.this, flingAppBarLayout, i3);
                    }
                };
            }
            FlingAppBarLayout flingAppBarLayout = this.mAppBarLayout;
            if (flingAppBarLayout != null) {
                flingAppBarLayout.b(this.mOnOffsetChangedListener);
            }
        } catch (Throwable th5) {
            RFWLog.fatal("QZoneAIOLoginReportPart", RFWLog.USR, th5);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        FlingAppBarLayout.c cVar;
        super.onPartDestroy(activity);
        try {
            FlingAppBarLayout flingAppBarLayout = this.mAppBarLayout;
            if (flingAppBarLayout == null || (cVar = this.mOnOffsetChangedListener) == null) {
                return;
            }
            if (flingAppBarLayout != null) {
                flingAppBarLayout.r(cVar);
            }
            this.mAppBarLayout = null;
            this.mOnOffsetChangedListener = null;
            QLog.i("QZoneAIOLoginReportPart", 1, "remove login part listener success");
        } catch (Throwable th5) {
            RFWLog.fatal("QZoneAIOLoginReportPart", RFWLog.USR, th5);
        }
    }

    private final CoordinatorLayout E9(View rootView) {
        while (rootView != null && rootView.getParent() != null) {
            Object parent = rootView.getParent();
            if (parent instanceof View) {
                rootView = (View) parent;
                if (rootView instanceof CoordinatorLayout) {
                    return (CoordinatorLayout) rootView;
                }
            }
        }
        return null;
    }

    private final FlingAppBarLayout F9(CoordinatorLayout coordinatorLayout) {
        if (coordinatorLayout == null) {
            return null;
        }
        int childCount = coordinatorLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = coordinatorLayout.getChildAt(i3);
            if (childAt instanceof FlingAppBarLayout) {
                return (FlingAppBarLayout) childAt;
            }
        }
        return null;
    }
}
