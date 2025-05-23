package com.tencent.biz.qqcircle.comment.album;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.ktx.ListExKt;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.query.QueryViewModel;
import com.tencent.qqnt.qbasealbum.query.ScrollDirection;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u00012B)\u0012\u0006\u0010e\u001a\u00020\r\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00104\u001a\u00020\u0002\u0012\b\u00108\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\bH\u0002J\u0006\u0010#\u001a\u00020\u0004J\u001c\u0010(\u001a\u00020\u00042\u0014\u0010'\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%\u0018\u00010$J\u0016\u0010)\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0002J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\bR\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0004\u0018\u0001058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010MR\u0016\u0010O\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u00103R\u0016\u0010P\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010BR\u0016\u0010Q\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010ER\u0018\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010VR\u0016\u0010X\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010BR\u0016\u0010Y\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00103R\u0016\u0010Z\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010ER\u0014\u0010\\\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u00103R\u0016\u0010]\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010BR\u0014\u0010`\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010_R\u0014\u0010c\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010bR\u0016\u0010d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010B\u00a8\u0006h"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/album/QFSTimelineController;", "", "", "dy", "", "t", "start", "end", "", "needNotify", "Lcom/tencent/qqnt/qbasealbum/query/ScrollDirection;", "scrollDirection", "r", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "w", HippyTKDListViewAdapter.X, "y", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "posProportion", "j", "p", "proportion", DomainData.DOMAIN_NAME, BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "verticalScrollRange", "D", "isResume", "l", "E", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "uiStateData", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "offsetRange", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, NodeProps.VISIBLE, "k", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "mMediaRV", "b", "I", "spanCount", "Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", "c", "Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", "queryViewModel", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mTimeBubble", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mTimeBubbleText", "f", "Z", "isOperateBubble", "g", UserInfo.SEX_FEMALE, "mTimeBtnDownY", tl.h.F, "mTimeBtnStartY", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mTimeBubbleIcon", "Ljava/util/List;", "mAllMedia", "mBubbleOffsetRange", "hasShownTimeBubbleAni", "curProportion", "Lcom/tencent/biz/qqcircle/comment/album/QFSTimelineView;", "Lcom/tencent/biz/qqcircle/comment/album/QFSTimelineView;", "mTimelineView", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "mTimer", "hasGenerateTimeline", "mPhotoGridCurPos", "lastScrollPercent", ReportConstant.COSTREPORT_PREFIX, "mTimeBubbleHeight", "hasReportTimeBubbleScroll", "Landroidx/recyclerview/widget/GridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/tencent/biz/qqcircle/comment/album/m;", "Lcom/tencent/biz/qqcircle/comment/album/m;", "mediaAdapter", "switchAlbum", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;ILcom/tencent/qqnt/qbasealbum/query/QueryViewModel;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSTimelineController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RecyclerView mMediaRV;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int spanCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QueryViewModel queryViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout mTimeBubble;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mTimeBubbleText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isOperateBubble;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float mTimeBtnDownY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mTimeBtnStartY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mTimeBubbleIcon;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> mAllMedia;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int mBubbleOffsetRange;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean hasShownTimeBubbleAni;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float curProportion;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSTimelineView mTimelineView;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownTimer mTimer;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean hasGenerateTimeline;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int mPhotoGridCurPos;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private float lastScrollPercent;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final int mTimeBubbleHeight;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean hasReportTimeBubbleScroll;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GridLayoutManager layoutManager;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m mediaAdapter;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean switchAlbum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/comment/album/QFSTimelineController$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            boolean z16;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            QFSTimelineController.this.t(dy5);
            if (!QFSTimelineController.this.isOperateBubble && dy5 != 0) {
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                float computeVerticalScrollRange = recyclerView.computeVerticalScrollRange() - QFSTimelineController.this.mBubbleOffsetRange;
                boolean z17 = true;
                if (computeVerticalScrollRange == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
                float f16 = computeVerticalScrollOffset / computeVerticalScrollRange;
                if (QFSTimelineController.this.curProportion != 0.0f) {
                    z17 = false;
                }
                if (!z17) {
                    f16 = QFSTimelineController.this.curProportion;
                    QFSTimelineController.this.n(f16);
                    QFSTimelineController.this.curProportion = 0.0f;
                }
                QFSTimelineController.this.j(f16);
            }
        }
    }

    public QFSTimelineController(@NotNull View rootView, @NotNull RecyclerView mMediaRV, int i3, @Nullable QueryViewModel queryViewModel) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(mMediaRV, "mMediaRV");
        this.mMediaRV = mMediaRV;
        this.spanCount = i3;
        this.queryViewModel = queryViewModel;
        this.mAllMedia = new ArrayList();
        this.mTimeBubbleHeight = com.tencent.qqnt.qbasealbum.ktx.d.b(32);
        RecyclerView.LayoutManager layoutManager = this.mMediaRV.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        this.layoutManager = (GridLayoutManager) layoutManager;
        RecyclerView.Adapter adapter = this.mMediaRV.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.biz.qqcircle.comment.album.QFSMediaListAdapter");
        this.mediaAdapter = (m) adapter;
        this.mTimeBubble = (RelativeLayout) rootView.findViewById(R.id.f4881210);
        this.mTimeBubbleIcon = (ImageView) rootView.findViewById(R.id.f4883212);
        this.mTimeBubbleText = (TextView) rootView.findViewById(R.id.f4882211);
        this.mTimelineView = (QFSTimelineView) rootView.findViewById(R.id.f4884213);
        this.mMediaRV.addOnScrollListener(new a());
    }

    private final void C() {
        RelativeLayout relativeLayout = this.mTimeBubble;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(0);
        if (!this.hasShownTimeBubbleAni) {
            this.hasShownTimeBubbleAni = true;
            o();
        }
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            Intrinsics.checkNotNull(countDownTimer);
            countDownTimer.cancel();
        }
        c cVar = new c();
        this.mTimer = cVar;
        Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type android.os.CountDownTimer");
        cVar.start();
    }

    private final void D(float proportion, int verticalScrollRange) {
        boolean z16;
        this.mMediaRV.scrollBy(0, (int) (verticalScrollRange * (proportion - this.lastScrollPercent)));
        boolean z17 = true;
        if (proportion == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mMediaRV.scrollBy(0, verticalScrollRange - this.mPhotoGridCurPos);
            return;
        }
        if (proportion != 0.0f) {
            z17 = false;
        }
        if (z17) {
            this.mMediaRV.scrollBy(0, -(verticalScrollRange + this.mPhotoGridCurPos));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float j(float posProportion) {
        RelativeLayout relativeLayout;
        if (this.mAllMedia.size() != 0 && (relativeLayout = this.mTimeBubble) != null) {
            float f16 = this.mBubbleOffsetRange * posProportion;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setY(f16);
            int size = (int) (this.mAllMedia.size() * posProportion);
            int i3 = this.spanCount;
            long j3 = Long.MAX_VALUE;
            for (int i16 = 0; i16 < i3; i16++) {
                int i17 = size + i16;
                if (!com.tencent.qqnt.qbasealbum.utils.b.f361643a.a(i17, this.mAllMedia)) {
                    LocalMediaInfo localMediaInfo = this.mAllMedia.get(i17);
                    if (localMediaInfo.getModifiedDate() < j3) {
                        j3 = localMediaInfo.getModifiedDate();
                    }
                }
            }
            if (j3 != Long.MAX_VALUE) {
                TextView textView = this.mTimeBubbleText;
                Intrinsics.checkNotNull(textView);
                textView.setText(com.tencent.qqnt.qbasealbum.utils.f.f361654a.e(j3, true));
            }
            return f16;
        }
        return 0.0f;
    }

    private final void l(final boolean isResume) {
        try {
            ox3.a.a("QFSTimelineController", new Function0<String>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSTimelineController$changeURLDrawableStatus$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "timeline scrollStateChanged, URLDrawable isResume:" + isResume;
                }
            });
            if (isResume) {
                URLDrawable.resume();
            } else {
                URLDrawable.pause();
            }
        } catch (Throwable unused) {
            ox3.a.c("QFSTimelineController", new Function0<String>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSTimelineController$changeURLDrawableStatus$2
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "timeline URLDrawable status error";
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        this.hasShownTimeBubbleAni = false;
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            Intrinsics.checkNotNull(countDownTimer);
            countDownTimer.cancel();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(320L);
        ArrayList arrayList = new ArrayList();
        RelativeLayout relativeLayout = this.mTimeBubble;
        Intrinsics.checkNotNull(relativeLayout);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "translationX", 0.0f, com.tencent.qqnt.qbasealbum.ktx.d.a(140.0f));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(mTimeBubble!!, \"\u2026_MAX_LENGTH.dp.toFloat())");
        arrayList.add(ofFloat);
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(float proportion) {
        boolean z16;
        if (this.switchAlbum) {
            ox3.a.c("QFSTimelineController", new Function0<String>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSTimelineController$efficientScrollPhotoList$1
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "album change and first scroll";
                }
            });
            u();
            this.switchAlbum = false;
        }
        this.mMediaRV.scrollToPosition((int) (this.mAllMedia.size() * proportion));
        boolean z17 = true;
        if (proportion == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mMediaRV.scrollToPosition(this.mAllMedia.size() - 1);
            return;
        }
        if (proportion != 0.0f) {
            z17 = false;
        }
        if (z17) {
            this.mMediaRV.scrollToPosition(0);
        }
    }

    private final void o() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(320L);
        ArrayList arrayList = new ArrayList();
        RelativeLayout relativeLayout = this.mTimeBubble;
        Intrinsics.checkNotNull(relativeLayout);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "translationX", com.tencent.qqnt.qbasealbum.ktx.d.a(140.0f), 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(mTimeBubble!!, \"\u2026_LENGTH.dp.toFloat(), 0F)");
        arrayList.add(ofFloat);
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    private final float p(MotionEvent event) {
        float f16 = 0.0f;
        if (this.mBubbleOffsetRange == 0) {
            QLog.d("QFSTimelineController", 1, "photo list height is 0");
            return 0.0f;
        }
        float rawY = (event.getRawY() - this.mTimeBtnDownY) + this.mTimeBtnStartY;
        if (rawY >= 0.0f) {
            int i3 = this.mBubbleOffsetRange;
            if (rawY > i3) {
                f16 = i3;
            } else {
                f16 = rawY;
            }
        }
        return f16 / this.mBubbleOffsetRange;
    }

    private final void q(MotionEvent event) {
        QFSTimelineView qFSTimelineView = this.mTimelineView;
        if (qFSTimelineView != null && this.mBubbleOffsetRange != 0) {
            boolean z16 = true;
            if (!this.hasGenerateTimeline) {
                Intrinsics.checkNotNull(qFSTimelineView);
                qFSTimelineView.d();
                this.hasGenerateTimeline = true;
            }
            QFSTimelineView qFSTimelineView2 = this.mTimelineView;
            Intrinsics.checkNotNull(qFSTimelineView2);
            qFSTimelineView2.g();
            float p16 = p(event);
            int computeVerticalScrollRange = this.mMediaRV.computeVerticalScrollRange() - this.mBubbleOffsetRange;
            this.mPhotoGridCurPos = this.mPhotoGridCurPos + ((int) (computeVerticalScrollRange * (p16 - this.lastScrollPercent)));
            if (Math.abs(p16 - r4) >= 5.0E-4d) {
                z16 = false;
            }
            l(z16);
            if (this.mAllMedia.size() < 1500) {
                D(p16, computeVerticalScrollRange);
            } else {
                n(p16);
            }
            this.lastScrollPercent = p16;
            float j3 = j(p16) + (this.mTimeBubbleHeight / 2);
            QFSTimelineView qFSTimelineView3 = this.mTimelineView;
            Intrinsics.checkNotNull(qFSTimelineView3);
            qFSTimelineView3.b(j3);
        }
    }

    private final void r(int start, int end, boolean needNotify, ScrollDirection scrollDirection) {
        int collectionSizeOrDefault;
        List a16 = ListExKt.a(this.mediaAdapter.k0(), start, end);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = a16.iterator();
        while (it.hasNext()) {
            arrayList.add(((QFSLocalMediaInfo) it.next()).getLocalMediaInfo());
        }
        QueryViewModel queryViewModel = this.queryViewModel;
        if (queryViewModel != null) {
            QueryViewModel.b2(queryViewModel, start, end, arrayList, needNotify, scrollDirection, false, 32, null);
        }
    }

    static /* synthetic */ void s(QFSTimelineController qFSTimelineController, int i3, int i16, boolean z16, ScrollDirection scrollDirection, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            scrollDirection = ScrollDirection.DEFAULT;
        }
        qFSTimelineController.r(i3, i16, z16, scrollDirection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int dy5) {
        final com.tencent.qqnt.qbasealbum.query.a Z1;
        int coerceAtLeast;
        int coerceAtMost;
        int coerceAtMost2;
        final int findFirstCompletelyVisibleItemPosition = this.layoutManager.findFirstCompletelyVisibleItemPosition();
        final int findLastCompletelyVisibleItemPosition = this.layoutManager.findLastCompletelyVisibleItemPosition();
        QueryViewModel queryViewModel = this.queryViewModel;
        if (queryViewModel != null && (Z1 = queryViewModel.Z1()) != null) {
            if (dy5 > 0) {
                if (Math.abs(Z1.a() - findLastCompletelyVisibleItemPosition) <= 200) {
                    ox3.a.b("QFSTimelineController", new Function0<String>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSTimelineController$loadWhenScroll$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            return "scroll down lastVisiblePosition: " + findLastCompletelyVisibleItemPosition + " startPos:" + Z1.b() + " endPos:" + Z1.a();
                        }
                    });
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(findLastCompletelyVisibleItemPosition + 1, this.mediaAdapter.k0().size() - 1);
                    coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(findLastCompletelyVisibleItemPosition + 500, this.mediaAdapter.k0().size());
                    r(coerceAtMost, coerceAtMost2, false, ScrollDirection.DOWN);
                    return;
                }
                return;
            }
            if (dy5 < 0 && Math.abs(findFirstCompletelyVisibleItemPosition - Z1.b()) <= 200) {
                ox3.a.b("QFSTimelineController", new Function0<String>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSTimelineController$loadWhenScroll$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        return "scroll up firstVisiblePosition: " + findFirstCompletelyVisibleItemPosition + " startPos:" + Z1.b() + " endPos:" + Z1.a();
                    }
                });
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(findFirstCompletelyVisibleItemPosition + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT, 0);
                r(coerceAtLeast, findFirstCompletelyVisibleItemPosition, false, ScrollDirection.UP);
            }
        }
    }

    private final void u() {
        this.mMediaRV.post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.album.p
            @Override // java.lang.Runnable
            public final void run() {
                QFSTimelineController.v(QFSTimelineController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QFSTimelineController this$0) {
        int coerceAtLeast;
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int findFirstCompletelyVisibleItemPosition = this$0.layoutManager.findFirstCompletelyVisibleItemPosition();
        final int findLastCompletelyVisibleItemPosition = this$0.layoutManager.findLastCompletelyVisibleItemPosition();
        ox3.a.c("QFSTimelineController", new Function0<String>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSTimelineController$loadWhenStopScroll$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "loadWhenStopScroll firstVisiblePosition: " + findFirstCompletelyVisibleItemPosition + " lastVisiblePosition: " + findLastCompletelyVisibleItemPosition;
            }
        });
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(findFirstCompletelyVisibleItemPosition - 300, 0);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(findLastCompletelyVisibleItemPosition + 300, this$0.mediaAdapter.k0().size());
        s(this$0, coerceAtLeast, coerceAtMost, true, null, 8, null);
    }

    private final void w(View v3, MotionEvent event) {
        int id5 = v3.getId();
        RelativeLayout relativeLayout = this.mTimeBubble;
        Intrinsics.checkNotNull(relativeLayout);
        if (id5 == relativeLayout.getId()) {
            this.isOperateBubble = true;
            this.mTimeBtnDownY = event.getRawY();
            RelativeLayout relativeLayout2 = this.mTimeBubble;
            Intrinsics.checkNotNull(relativeLayout2);
            this.mTimeBtnStartY = relativeLayout2.getY();
            ImageView imageView = this.mTimeBubbleIcon;
            Intrinsics.checkNotNull(imageView);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(com.tencent.qqnt.qbasealbum.ktx.d.b(45));
            ImageView imageView2 = this.mTimeBubbleIcon;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setLayoutParams(layoutParams2);
            n(p(event));
        }
    }

    private final void x(MotionEvent event) {
        k(true);
        if (this.isOperateBubble) {
            if (!this.hasReportTimeBubbleScroll) {
                this.hasReportTimeBubbleScroll = true;
                ox3.a.i(new Function0<String>() { // from class: com.tencent.biz.qqcircle.comment.album.QFSTimelineController$onTouchActionMove$1
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        return "onPickerScrollEvent";
                    }
                });
            }
            q(event);
        }
    }

    private final void y(MotionEvent event) {
        if (this.isOperateBubble) {
            this.isOperateBubble = false;
            this.curProportion = p(event);
            u();
        }
        ImageView imageView = this.mTimeBubbleIcon;
        Intrinsics.checkNotNull(imageView);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(com.tencent.qqnt.qbasealbum.ktx.d.b(10));
        ImageView imageView2 = this.mTimeBubbleIcon;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setLayoutParams(layoutParams2);
        QFSTimelineView qFSTimelineView = this.mTimelineView;
        if (qFSTimelineView != null) {
            qFSTimelineView.f(false);
        }
        l(true);
    }

    public final void A(int offsetRange) {
        if (offsetRange != this.mBubbleOffsetRange) {
            k(false);
            this.hasGenerateTimeline = false;
        }
        this.mBubbleOffsetRange = offsetRange;
        QFSTimelineView qFSTimelineView = this.mTimelineView;
        if (qFSTimelineView != null) {
            qFSTimelineView.setTimelineHeight(offsetRange + this.mTimeBubbleHeight);
        }
    }

    public final void B(@Nullable UIStateData<List<LocalMediaInfo>> uiStateData) {
        if (uiStateData == null) {
            return;
        }
        if (uiStateData.getData().size() >= 10000 || uiStateData.getIsFinish()) {
            this.mAllMedia.clear();
            List<LocalMediaInfo> list = this.mAllMedia;
            List<LocalMediaInfo> data = uiStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
            list.addAll(data);
            QFSTimelineView qFSTimelineView = this.mTimelineView;
            if (qFSTimelineView != null) {
                qFSTimelineView.setPhotoList(this.mAllMedia);
            }
        }
    }

    public final void E() {
        this.switchAlbum = true;
    }

    public final void k(boolean visible) {
        if (this.mAllMedia.size() < 45) {
            return;
        }
        if (visible) {
            C();
            return;
        }
        if (this.hasShownTimeBubbleAni) {
            m();
        }
        QFSTimelineView qFSTimelineView = this.mTimelineView;
        if (qFSTimelineView != null) {
            qFSTimelineView.f(true);
        }
    }

    public final boolean z(@NotNull View v3, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    x(event);
                }
            } else {
                y(event);
            }
        } else {
            w(v3, event);
        }
        return this.isOperateBubble;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/comment/album/QFSTimelineController$c", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends CountDownTimer {
        c() {
            super(2000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            QFSTimelineController.this.m();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
        }
    }
}
