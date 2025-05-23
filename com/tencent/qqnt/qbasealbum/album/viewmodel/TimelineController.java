package com.tencent.qqnt.qbasealbum.album.viewmodel;

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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart;
import com.tencent.qqnt.qbasealbum.album.view.TimelineView;
import com.tencent.qqnt.qbasealbum.ktx.ListExKt;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.query.QueryViewModel;
import com.tencent.qqnt.qbasealbum.query.ScrollDirection;
import com.tencent.qqnt.qbasealbum.utils.f;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u00012B)\u0012\u0006\u0010f\u001a\u00020\r\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00104\u001a\u00020\u0002\u0012\b\u00108\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\bg\u0010hJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\bH\u0002J\u0006\u0010%\u001a\u00020\u0004J\u001c\u0010*\u001a\u00020\u00042\u0014\u0010)\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'\u0018\u00010&J\u0016\u0010+\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0002R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0004\u0018\u0001058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010MR\u0016\u0010O\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00103R\u0016\u0010P\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010BR\u0016\u0010Q\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010ER\u0018\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010VR\u0016\u0010X\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010BR\u0016\u0010Y\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00103R\u0016\u0010Z\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010ER\u0014\u0010\\\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u00103R\u0016\u0010]\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010BR\u0014\u0010`\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010_R\u0018\u0010d\u001a\u00060aR\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010cR\u0016\u0010e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010B\u00a8\u0006i"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/viewmodel/TimelineController;", "", "", "dy", "", "t", "start", "end", "", "needNotify", "Lcom/tencent/qqnt/qbasealbum/query/ScrollDirection;", "scrollDirection", "r", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "w", HippyTKDListViewAdapter.X, "y", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "posProportion", "j", "p", "proportion", DomainData.DOMAIN_NAME, NodeProps.VISIBLE, "k", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "verticalScrollRange", "D", "isResume", "l", "E", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "uiStateData", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "offsetRange", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "mMediaRV", "b", "I", "spanCount", "Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", "c", "Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", "queryViewModel", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mTimeBubble", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mTimeBubbleText", "f", "Z", "isOperateBubble", "g", UserInfo.SEX_FEMALE, "mTimeBtnDownY", h.F, "mTimeBtnStartY", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mTimeBubbleIcon", "Ljava/util/List;", "mAllMedia", "mBubbleOffsetRange", "hasShownTimeBubbleAni", "curProportion", "Lcom/tencent/qqnt/qbasealbum/album/view/TimelineView;", "Lcom/tencent/qqnt/qbasealbum/album/view/TimelineView;", "mTimelineView", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "mTimer", "hasGenerateTimeline", "mPhotoGridCurPos", "lastScrollPercent", ReportConstant.COSTREPORT_PREFIX, "mTimeBubbleHeight", "hasReportTimeBubbleScroll", "Landroidx/recyclerview/widget/GridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart$MediaListAdapter;", "Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart;", "Lcom/tencent/qqnt/qbasealbum/album/view/PickerMediaListPart$MediaListAdapter;", "mediaAdapter", "switchAlbum", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;ILcom/tencent/qqnt/qbasealbum/query/QueryViewModel;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TimelineController {
    static IPatchRedirector $redirector_;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

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
    private TimelineView mTimelineView;

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
    private final PickerMediaListPart.MediaListAdapter mediaAdapter;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean switchAlbum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/qbasealbum/album/viewmodel/TimelineController$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TimelineController.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            TimelineController.this.t(dy5);
            if (!TimelineController.this.isOperateBubble && dy5 != 0) {
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                float computeVerticalScrollRange = recyclerView.computeVerticalScrollRange() - TimelineController.this.mBubbleOffsetRange;
                if (computeVerticalScrollRange == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
                float f16 = computeVerticalScrollOffset / computeVerticalScrollRange;
                if (TimelineController.this.curProportion != 0.0f) {
                    z17 = false;
                }
                if (!z17) {
                    f16 = TimelineController.this.curProportion;
                    TimelineController.this.n(f16);
                    TimelineController.this.curProportion = 0.0f;
                }
                TimelineController.this.j(f16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/viewmodel/TimelineController$b;", "", "", "PHOTO_LIST_SCROLL_METHOD_THRESHOLD", "I", "", "TAG", "Ljava/lang/String;", "TIME_BUBBLE_ANIMATION_DURATION", "TIME_BUBBLE_DISAPPEAR_TIME", "", "TIME_BUBBLE_MAX_LENGTH", UserInfo.SEX_FEMALE, "", "TIME_ZONE_FLING_THRESHOLD", "D", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.album.viewmodel.TimelineController$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/qbasealbum/album/viewmodel/TimelineController$c", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends CountDownTimer {
        static IPatchRedirector $redirector_;

        c() {
            super(2000L, 1000L);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TimelineController.this);
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                TimelineController.this.m();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, millisUntilFinished);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34144);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TimelineController(@NotNull View rootView, @NotNull RecyclerView mMediaRV, int i3, @Nullable QueryViewModel queryViewModel) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(mMediaRV, "mMediaRV");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rootView, mMediaRV, Integer.valueOf(i3), queryViewModel);
            return;
        }
        this.mMediaRV = mMediaRV;
        this.spanCount = i3;
        this.queryViewModel = queryViewModel;
        this.mAllMedia = new ArrayList();
        this.mTimeBubbleHeight = com.tencent.qqnt.qbasealbum.ktx.d.b(32);
        RecyclerView.LayoutManager layoutManager = this.mMediaRV.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        this.layoutManager = (GridLayoutManager) layoutManager;
        RecyclerView.Adapter adapter = this.mMediaRV.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.qqnt.qbasealbum.album.view.PickerMediaListPart.MediaListAdapter");
        this.mediaAdapter = (PickerMediaListPart.MediaListAdapter) adapter;
        this.mTimeBubble = (RelativeLayout) rootView.findViewById(R.id.f246109l);
        this.mTimeBubbleIcon = (ImageView) rootView.findViewById(R.id.f246309n);
        this.mTimeBubbleText = (TextView) rootView.findViewById(R.id.f246209m);
        this.mTimelineView = (TimelineView) rootView.findViewById(R.id.f246409o);
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
                textView.setText(f.f361654a.e(j3, true));
            }
            return f16;
        }
        return 0.0f;
    }

    private final void k(boolean visible) {
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
        TimelineView timelineView = this.mTimelineView;
        if (timelineView != null) {
            timelineView.f(true);
        }
    }

    private final void l(final boolean isResume) {
        try {
            ox3.a.b("TimelineController", new Function0<String>(isResume) { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.TimelineController$changeURLDrawableStatus$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isResume;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$isResume = isResume;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, isResume);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "timeline scrollStateChanged, URLDrawable isResume:" + this.$isResume;
                }
            });
            if (isResume) {
                URLDrawable.resume();
            } else {
                URLDrawable.pause();
            }
        } catch (Throwable unused) {
            ox3.a.c("TimelineController", TimelineController$changeURLDrawableStatus$2.INSTANCE);
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
            ox3.a.c("TimelineController", TimelineController$efficientScrollPhotoList$1.INSTANCE);
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
            QLog.d("TimelineController", 1, "photo list height is 0");
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
        TimelineView timelineView = this.mTimelineView;
        if (timelineView != null && this.mBubbleOffsetRange != 0) {
            boolean z16 = true;
            if (!this.hasGenerateTimeline) {
                Intrinsics.checkNotNull(timelineView);
                timelineView.d();
                this.hasGenerateTimeline = true;
            }
            TimelineView timelineView2 = this.mTimelineView;
            Intrinsics.checkNotNull(timelineView2);
            timelineView2.g();
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
            TimelineView timelineView3 = this.mTimelineView;
            Intrinsics.checkNotNull(timelineView3);
            timelineView3.b(j3);
        }
    }

    private final void r(int start, int end, boolean needNotify, ScrollDirection scrollDirection) {
        List a16 = ListExKt.a(this.mediaAdapter.j0(), start, end);
        QueryViewModel queryViewModel = this.queryViewModel;
        if (queryViewModel != null) {
            QueryViewModel.b2(queryViewModel, start, end, a16, needNotify, scrollDirection, false, 32, null);
        }
    }

    static /* synthetic */ void s(TimelineController timelineController, int i3, int i16, boolean z16, ScrollDirection scrollDirection, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            scrollDirection = ScrollDirection.DEFAULT;
        }
        timelineController.r(i3, i16, z16, scrollDirection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int dy5) {
        com.tencent.qqnt.qbasealbum.query.a Z1;
        int coerceAtLeast;
        int coerceAtMost;
        int coerceAtMost2;
        int findFirstCompletelyVisibleItemPosition = this.layoutManager.findFirstCompletelyVisibleItemPosition();
        int findLastCompletelyVisibleItemPosition = this.layoutManager.findLastCompletelyVisibleItemPosition();
        QueryViewModel queryViewModel = this.queryViewModel;
        if (queryViewModel != null && (Z1 = queryViewModel.Z1()) != null) {
            if (dy5 > 0) {
                if (Math.abs(Z1.a() - findLastCompletelyVisibleItemPosition) <= 200) {
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(findLastCompletelyVisibleItemPosition + 1, this.mediaAdapter.j0().size() - 1);
                    coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(findLastCompletelyVisibleItemPosition + 500, this.mediaAdapter.j0().size());
                    r(coerceAtMost, coerceAtMost2, false, ScrollDirection.DOWN);
                    return;
                }
                return;
            }
            if (dy5 < 0 && Math.abs(findFirstCompletelyVisibleItemPosition - Z1.b()) <= 200) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(findFirstCompletelyVisibleItemPosition + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT, 0);
                r(coerceAtLeast, findFirstCompletelyVisibleItemPosition, false, ScrollDirection.UP);
            }
        }
    }

    private final void u() {
        this.mMediaRV.post(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.e
            @Override // java.lang.Runnable
            public final void run() {
                TimelineController.v(TimelineController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(TimelineController this$0) {
        int coerceAtLeast;
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int findFirstCompletelyVisibleItemPosition = this$0.layoutManager.findFirstCompletelyVisibleItemPosition();
        final int findLastCompletelyVisibleItemPosition = this$0.layoutManager.findLastCompletelyVisibleItemPosition();
        ox3.a.c("TimelineController", new Function0<String>(findFirstCompletelyVisibleItemPosition, findLastCompletelyVisibleItemPosition) { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.TimelineController$loadWhenStopScroll$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $firstVisiblePosition;
            final /* synthetic */ int $lastVisiblePosition;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$firstVisiblePosition = findFirstCompletelyVisibleItemPosition;
                this.$lastVisiblePosition = findLastCompletelyVisibleItemPosition;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(findFirstCompletelyVisibleItemPosition), Integer.valueOf(findLastCompletelyVisibleItemPosition));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "loadWhenStopScroll firstVisiblePosition: " + this.$firstVisiblePosition + " lastVisiblePosition: " + this.$lastVisiblePosition;
            }
        });
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(findFirstCompletelyVisibleItemPosition - 300, 0);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(findLastCompletelyVisibleItemPosition + 300, this$0.mediaAdapter.j0().size());
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
                ox3.a.i(TimelineController$onTouchActionMove$1.INSTANCE);
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
        TimelineView timelineView = this.mTimelineView;
        if (timelineView != null) {
            timelineView.f(false);
        }
        l(true);
    }

    public final void A(int offsetRange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, offsetRange);
            return;
        }
        if (offsetRange != this.mBubbleOffsetRange) {
            k(false);
            this.hasGenerateTimeline = false;
        }
        this.mBubbleOffsetRange = offsetRange;
        TimelineView timelineView = this.mTimelineView;
        if (timelineView != null) {
            timelineView.setTimelineHeight(offsetRange + this.mTimeBubbleHeight);
        }
    }

    public final void B(@Nullable UIStateData<List<LocalMediaInfo>> uiStateData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uiStateData);
            return;
        }
        if (uiStateData == null) {
            return;
        }
        if (uiStateData.getData().size() >= 10000 || uiStateData.getIsFinish()) {
            this.mAllMedia.clear();
            List<LocalMediaInfo> list = this.mAllMedia;
            List<LocalMediaInfo> data = uiStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
            list.addAll(data);
            TimelineView timelineView = this.mTimelineView;
            if (timelineView != null) {
                timelineView.setPhotoList(this.mAllMedia);
            }
        }
    }

    public final void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.switchAlbum = true;
        }
    }

    public final boolean z(@NotNull View v3, @NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
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
}
