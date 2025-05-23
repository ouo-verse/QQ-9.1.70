package com.qzone.reborn.feedpro.part;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.widget.header.QzoneFriendFeedProPublishEntranceView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ah;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u001b\u0010\u0016\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/feedpro/part/QzoneFriendFeedProCeilingPublishBarPart;", "Lcom/qzone/reborn/feedpro/part/b;", "", "J9", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "firstPos", "", "H9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "d", "Lkotlin/Lazy;", "I9", "()I", "titleHeight", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "e", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "motionContainer", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFriendFeedProPublishEntranceView;", "f", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFriendFeedProPublishEntranceView;", "ceilingPublishBar", "Lcom/qzone/reborn/feedpro/widget/header/a;", tl.h.F, "Lcom/qzone/reborn/feedpro/widget/header/a;", "publishBarInList", "i", "Landroid/view/View;", "titlePlaceholder", "Lcom/qzone/reborn/feedpro/viewmodel/n;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedpro/viewmodel/n;", "scrollViewModel", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollListener", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFriendFeedProCeilingPublishBarPart extends com.qzone.reborn.feedpro.part.b {

    /* renamed from: C, reason: from kotlin metadata */
    private RecyclerView.OnScrollListener onScrollListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy titleHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MotionLayout motionContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QzoneFriendFeedProPublishEntranceView ceilingPublishBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.widget.header.a publishBarInList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View titlePlaceholder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.n scrollViewModel;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedpro/part/QzoneFriendFeedProCeilingPublishBarPart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            float H9 = QzoneFriendFeedProCeilingPublishBarPart.this.H9(recyclerView, ah.a(recyclerView));
            if (H9 <= 0.01f) {
                com.qzone.reborn.feedpro.widget.header.a aVar = QzoneFriendFeedProCeilingPublishBarPart.this.publishBarInList;
                if (aVar != null) {
                    aVar.O();
                }
            } else {
                com.qzone.reborn.feedpro.widget.header.a aVar2 = QzoneFriendFeedProCeilingPublishBarPart.this.publishBarInList;
                if (aVar2 != null) {
                    aVar2.J();
                }
            }
            com.qzone.reborn.feedpro.viewmodel.n nVar = QzoneFriendFeedProCeilingPublishBarPart.this.scrollViewModel;
            if (nVar != null) {
                nVar.X1(H9 == 1.0f);
            }
            if (!RFWApplication.isPublicVersion()) {
                int i3 = RFWLog.DEV;
                Object[] objArr = new Object[1];
                objArr[0] = "[onScrolled] curProgress: " + H9 + ", isEnd: " + (H9 == 1.0f);
                RFWLog.d("QzoneFriendFeedProCeilingPublishBarPart", i3, objArr);
            }
            MotionLayout motionLayout = QzoneFriendFeedProCeilingPublishBarPart.this.motionContainer;
            if (motionLayout == null) {
                return;
            }
            motionLayout.setProgress(H9);
        }
    }

    public QzoneFriendFeedProCeilingPublishBarPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.qzone.reborn.feedpro.part.QzoneFriendFeedProCeilingPublishBarPart$titleHeight$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(QZoneFeedxViewUtils.e(QzoneFriendFeedProCeilingPublishBarPart.this.getActivity()));
            }
        });
        this.titleHeight = lazy;
    }

    private final int I9() {
        return ((Number) this.titleHeight.getValue()).intValue();
    }

    private final void J9() {
        b bVar = new b();
        this.onScrollListener = bVar;
        com.qzone.reborn.feedpro.viewmodel.n nVar = this.scrollViewModel;
        if (nVar != null) {
            nVar.N1(bVar);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFriendFeedProCeilingPublishBarPart";
    }

    @Override // com.qzone.reborn.feedpro.part.b, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        ViewGroup.LayoutParams layoutParams;
        int dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        super.onInitView(rootView);
        this.scrollViewModel = (com.qzone.reborn.feedpro.viewmodel.n) getViewModel(com.qzone.reborn.feedpro.viewmodel.n.class);
        ViewGroup.LayoutParams layoutParams4 = null;
        layoutParams4 = null;
        this.motionContainer = rootView != null ? (MotionLayout) rootView.findViewById(R.id.n2e) : null;
        this.ceilingPublishBar = rootView != null ? (QzoneFriendFeedProPublishEntranceView) rootView.findViewById(R.id.n2f) : null;
        this.titlePlaceholder = rootView != null ? rootView.findViewById(R.id.n2j) : null;
        QzoneFriendFeedProPublishEntranceView qzoneFriendFeedProPublishEntranceView = this.ceilingPublishBar;
        if (qzoneFriendFeedProPublishEntranceView != null) {
            qzoneFriendFeedProPublishEntranceView.setHostActivity(getActivity());
        }
        View view = this.titlePlaceholder;
        if (view != null) {
            if (view == null || (layoutParams3 = view.getLayoutParams()) == null) {
                layoutParams3 = null;
            } else {
                layoutParams3.height = I9();
            }
            view.setLayoutParams(layoutParams3);
        }
        MotionLayout motionLayout = this.motionContainer;
        if (motionLayout != null) {
            if (motionLayout != null && (layoutParams = motionLayout.getLayoutParams()) != null) {
                QzoneFriendFeedProPublishEntranceView qzoneFriendFeedProPublishEntranceView2 = this.ceilingPublishBar;
                if (qzoneFriendFeedProPublishEntranceView2 != null && (layoutParams2 = qzoneFriendFeedProPublishEntranceView2.getLayoutParams()) != null) {
                    Integer valueOf = Integer.valueOf(layoutParams2.height);
                    Integer num = valueOf.intValue() > 0 ? valueOf : null;
                    if (num != null) {
                        dimensionPixelSize = num.intValue();
                        layoutParams.height = I9() + dimensionPixelSize;
                        layoutParams4 = layoutParams;
                    }
                }
                dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f97306);
                layoutParams.height = I9() + dimensionPixelSize;
                layoutParams4 = layoutParams;
            }
            motionLayout.setLayoutParams(layoutParams4);
        }
        J9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        com.qzone.reborn.feedpro.viewmodel.n nVar;
        super.onPartDestroy(activity);
        RecyclerView.OnScrollListener onScrollListener = this.onScrollListener;
        if (onScrollListener == null || (nVar = this.scrollViewModel) == null) {
            return;
        }
        nVar.S1(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final float H9(RecyclerView recyclerView, int firstPos) {
        int measuredHeight;
        int coerceAtMost;
        if (firstPos >= 2) {
            return 1.0f;
        }
        View childAt = recyclerView.getChildAt(0);
        if (!(childAt instanceof com.qzone.reborn.feedpro.widget.header.b)) {
            return 0.0f;
        }
        int abs = Math.abs(childAt.getTop());
        Integer valueOf = Integer.valueOf(((com.qzone.reborn.feedpro.widget.header.b) childAt).e());
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            measuredHeight = valueOf.intValue();
        } else {
            measuredHeight = childAt.getMeasuredHeight();
        }
        if (abs > 0 && measuredHeight > 0) {
            int I9 = (measuredHeight - abs) - I9();
            if (I9 >= 0) {
                return 0.0f;
            }
            KeyEvent.Callback childAt2 = recyclerView.getChildAt(1);
            if (!(childAt2 instanceof com.qzone.reborn.feedpro.widget.header.a)) {
                RFWLog.e("QzoneFriendFeedProCeilingPublishBarPart", RFWLog.USR, "[calCeilingProgress] recyclerView children are abnormal.");
                return 0.0f;
            }
            com.qzone.reborn.feedpro.widget.header.a aVar = (com.qzone.reborn.feedpro.widget.header.a) childAt2;
            int realHeight = aVar.getRealHeight();
            if (realHeight <= 0) {
                RFWLog.e("QzoneFriendFeedProCeilingPublishBarPart", RFWLog.USR, "[calCeilingProgress] publishBarHeight is illegal.");
                return 0.0f;
            }
            this.publishBarInList = aVar;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(Math.abs(I9), realHeight);
            return coerceAtMost / realHeight;
        }
        RFWLog.e("QzoneFriendFeedProCeilingPublishBarPart", RFWLog.USR, "[calCeilingProgress] coverHeight is illegal.");
        return 0.0f;
    }
}
