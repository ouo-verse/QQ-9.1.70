package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/bizparts/bj;", "Lcom/tencent/biz/qqcircle/bizparts/QFSReportBottomSheetPart;", "", "na", "ma", "oa", "qa", "", "pa", "Z9", "Landroid/view/View;", "P9", "Y9", "", "ba", LocaleUtils.L_JAPANESE, "G9", "Lcom/tencent/biz/qqcircle/utils/QCircleAlbumSlidBottomView;", "K", "Lcom/tencent/biz/qqcircle/utils/QCircleAlbumSlidBottomView;", "mRightSheetView", "L", "Landroid/view/View;", "mContentView", "<init>", "()V", "M", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class bj extends QFSReportBottomSheetPart {

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private QCircleAlbumSlidBottomView mRightSheetView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View mContentView;

    private final void ma() {
        View view = this.mContentView;
        if (view != null) {
            view.setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.qui_common_bg_middle_light_bg, null));
        }
    }

    private final void na() {
        ViewGroup.LayoutParams layoutParams;
        ImageView mCloseBtn = getMCloseBtn();
        if (mCloseBtn != null) {
            layoutParams = mCloseBtn.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = DisplayUtil.dip2px(getContext(), 4.0f);
        ImageView mCloseBtn2 = getMCloseBtn();
        if (mCloseBtn2 != null) {
            mCloseBtn2.setLayoutParams(layoutParams2);
        }
    }

    private final void oa() {
        ViewGroup.LayoutParams layoutParams;
        RecyclerView mReasonList = getMReasonList();
        if (mReasonList != null) {
            layoutParams = mReasonList.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.bottomToTop = -1;
        RecyclerView mReasonList2 = getMReasonList();
        if (mReasonList2 != null) {
            mReasonList2.setLayoutParams(layoutParams2);
        }
    }

    private final int pa() {
        int max = Math.max(DisplayUtil.getScreenWidth(), DisplayUtil.getScreenHeight());
        int dip2px = DisplayUtil.dip2px(getContext(), 400.0f);
        int min = Math.min(max / 2, dip2px);
        QLog.d("QFSFullScreenReportSheetPart", 1, "[getPanelSize] screenW: " + max + ", maxPanelW: " + dip2px + ", result: " + min);
        return min;
    }

    private final void qa() {
        ViewGroup.LayoutParams layoutParams;
        int pa5 = pa();
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = this.mRightSheetView;
        if (qCircleAlbumSlidBottomView != null) {
            qCircleAlbumSlidBottomView.setPanelSize(pa5);
        }
        View view = this.mContentView;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.width = pa5;
        }
        View view2 = this.mContentView;
        if (view2 != null) {
            view2.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(bj this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart
    public void G9() {
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = this.mRightSheetView;
        if (qCircleAlbumSlidBottomView != null) {
            qCircleAlbumSlidBottomView.d();
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart
    @Nullable
    public View P9() {
        return this.mRightSheetView;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart
    public void Y9() {
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = this.mRightSheetView;
        if (qCircleAlbumSlidBottomView != null) {
            qCircleAlbumSlidBottomView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.bi
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bj.ra(bj.this, view);
                }
            });
        }
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView2 = this.mRightSheetView;
        if (qCircleAlbumSlidBottomView2 != null) {
            qCircleAlbumSlidBottomView2.c(new b());
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart
    public void Z9() {
        View view;
        TextView textView;
        ImageView imageView;
        RecyclerView recyclerView;
        if (this.mRightSheetView != null) {
            return;
        }
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = (QCircleAlbumSlidBottomView) getPartRootView().findViewById(R.id.f32470tu);
        this.mRightSheetView = qCircleAlbumSlidBottomView;
        QUIButton qUIButton = null;
        if (qCircleAlbumSlidBottomView != null) {
            view = qCircleAlbumSlidBottomView.findViewById(R.id.f52212_7);
        } else {
            view = null;
        }
        this.mContentView = view;
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView2 = this.mRightSheetView;
        if (qCircleAlbumSlidBottomView2 != null) {
            textView = (TextView) qCircleAlbumSlidBottomView2.findViewById(R.id.f52232_9);
        } else {
            textView = null;
        }
        ia(textView);
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView3 = this.mRightSheetView;
        if (qCircleAlbumSlidBottomView3 != null) {
            imageView = (ImageView) qCircleAlbumSlidBottomView3.findViewById(R.id.f520729t);
        } else {
            imageView = null;
        }
        da(imageView);
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView4 = this.mRightSheetView;
        if (qCircleAlbumSlidBottomView4 != null) {
            recyclerView = (RecyclerView) qCircleAlbumSlidBottomView4.findViewById(R.id.f52192_5);
        } else {
            recyclerView = null;
        }
        ga(recyclerView);
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView5 = this.mRightSheetView;
        if (qCircleAlbumSlidBottomView5 != null) {
            qUIButton = (QUIButton) qCircleAlbumSlidBottomView5.findViewById(R.id.f52222_8);
        }
        ha(qUIButton);
        oa();
        ma();
        na();
        qa();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart
    public boolean ba() {
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView = this.mRightSheetView;
        if (qCircleAlbumSlidBottomView != null) {
            return qCircleAlbumSlidBottomView.k();
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart
    public void ja() {
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView;
        QCircleAlbumSlidBottomView qCircleAlbumSlidBottomView2 = this.mRightSheetView;
        boolean z16 = false;
        if (qCircleAlbumSlidBottomView2 != null && qCircleAlbumSlidBottomView2.getVisibility() == 0) {
            z16 = true;
        }
        if (!z16 && (qCircleAlbumSlidBottomView = this.mRightSheetView) != null) {
            qCircleAlbumSlidBottomView.o();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/qqcircle/bizparts/bj$b", "Lcom/tencent/biz/qqcircle/utils/QCircleAlbumSlidBottomView$c;", "", "onShow", "onDismiss", "", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "onScrollChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements QCircleAlbumSlidBottomView.c {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onDismiss() {
            bj.this.Q9();
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onShow() {
            bj.this.R9();
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleAlbumSlidBottomView.c
        public void onScrollChanged(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        }
    }
}
