package com.tencent.biz.qqcircle.comment.abovebar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewStub;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.bizparts.QFSCommentPanelPart;
import com.tencent.biz.qqcircle.comment.af;
import com.tencent.biz.qqcircle.comment.recpic.InputClusterBean;
import com.tencent.biz.qqcircle.comment.recpic.QFSCommentRecPicClusterHelper;
import com.tencent.biz.qqcircle.comment.recpic.QFSRecPicInfo;
import com.tencent.biz.qqcircle.comment.recpic.aa;
import com.tencent.biz.qqcircle.comment.recpic.ac;
import com.tencent.biz.qqcircle.comment.recpic.ag;
import com.tencent.biz.qqcircle.comment.recpic.ak;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.biz.qqcircle.comment.recpic.z;
import com.tencent.biz.qqcircle.comment.u;
import com.tencent.biz.qqcircle.comment.widget.QFSCommentRecPicLoadingView;
import com.tencent.biz.qqcircle.events.QFSRecPicStateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.Embedding;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.PredefinedPipeline;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u20.QFSPipelineConfig;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001`B\u001f\u0012\u0006\u0010Y\u001a\u000200\u0012\u0006\u0010[\u001a\u00020Z\u0012\u0006\u0010]\u001a\u00020\\\u00a2\u0006\u0004\b^\u0010_J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0016\u0010\u0019\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u0004\u0018\u00010#J\b\u0010%\u001a\u00020\u0004H\u0016J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tJ\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\u0012\u0010+\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010/\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030-0,j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030-`.H\u0016R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0018\u00107\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00102R\u0018\u0010=\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00102R\u0018\u0010>\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00102R\u0018\u0010?\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00102R\u0018\u0010@\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00102R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010IR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010LR\u0016\u0010N\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010P\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010\bR\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010\bR\u0016\u0010T\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010\bR\u0016\u0010U\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0016\u0010X\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006a"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/abovebar/QFSCommentRecPicBar;", "Lcom/tencent/biz/qqcircle/comment/abovebar/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "V", "J", "N", "Z", "", "show", "Y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", UserInfo.SEX_FEMALE, "U", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "B", "E", "X", ExifInterface.LATITUDE_SOUTH, "", "Lfeedcloud/Embedding;", "embeddings", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "event", "M", "L", "H", BdhLogUtil.LogTag.Tag_Conn, "y", "isElementCanActivate", "onElementActivated", "Lcooperation/qqcircle/report/QCircleReportBean;", "G", "onElementInactivated", "notify", "W", "", "getPriority", "j", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/view/View;", "i", "Landroid/view/View;", "mContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mPicContainer", "Landroidx/recyclerview/widget/RecyclerView;", "mRecommendPicRecyclerView", "Lcom/tencent/biz/qqcircle/comment/widget/QFSCommentRecPicLoadingView;", "D", "Lcom/tencent/biz/qqcircle/comment/widget/QFSCommentRecPicLoadingView;", "mLoadingView", "mRecPicCloseBtn", "mHelpBtn", "mHelpBtn2", "mTitleTv", "mIconIv", "Ls20/b;", "Ls20/b;", "mRecPicAdapter", "Lcom/tencent/biz/qqcircle/comment/recpic/ag;", "K", "Lcom/tencent/biz/qqcircle/comment/recpic/ag;", "inferViewModel", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "handleInputRunnable", "", "Ljava/util/List;", "mHasExposePic", "isFirstOpenPermission", "P", "hasInflate", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "autoShow", BdhLogUtil.LogTag.Tag_Req, "isShowBar", "userClose", "T", "Ljava/lang/String;", "lastReqTxt", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/biz/qqcircle/comment/abovebar/a;", "host", "Lcom/tencent/biz/qqcircle/widgets/comment/CommentEditText;", "textInput", "<init>", "(Landroid/view/View;Lcom/tencent/biz/qqcircle/comment/abovebar/a;Lcom/tencent/biz/qqcircle/widgets/comment/CommentEditText;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSCommentRecPicBar extends com.tencent.biz.qqcircle.comment.abovebar.b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mRecommendPicRecyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QFSCommentRecPicLoadingView mLoadingView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View mRecPicCloseBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View mHelpBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View mHelpBtn2;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View mTitleTv;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View mIconIv;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private s20.b mRecPicAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ag inferViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Runnable handleInputRunnable;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final List<String> mHasExposePic;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isFirstOpenPermission;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hasInflate;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean autoShow;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isShowBar;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean userClose;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String lastReqTxt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mPicContainer;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f83280a;

        static {
            int[] iArr = new int[PredefinedPipeline.values().length];
            try {
                iArr[PredefinedPipeline.PREDEFINED_PIPELINE_NOOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PredefinedPipeline.PREDEFINED_PIPELINE_COMMENT_PROMPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f83280a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/comment/abovebar/QFSCommentRecPicBar$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                QLog.d("QFSCommentRecPicBar", 1, "[onScrollStateChanged] expose itemView");
                QFSCommentRecPicBar.this.B(recyclerView);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/comment/abovebar/QFSCommentRecPicBar$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class e extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f83284e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f83285f;

        e(boolean z16, boolean z17) {
            this.f83284e = z16;
            this.f83285f = z17;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            if (this.f83285f) {
                com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(QFSCommentRecPicBar.this.getContextHashCode(), QFSCommentRecPicBar.this.getGroup());
            }
            if (this.f83284e) {
                QFSCommentRecPicBar.this.f83294d.R4().isShowRecPicBar = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            QFSCommentRecPicBar.this.isShowBar = this.f83284e;
            QFSCommentRecPicBar.this.autoShow = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSCommentRecPicBar(@NotNull View rootView, @NotNull a host, @NotNull CommentEditText textInput) {
        super(rootView, host, textInput);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(textInput, "textInput");
        this.inferViewModel = new ag();
        this.handleInputRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.comment.abovebar.f
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentRecPicBar.K(QFSCommentRecPicBar.this);
            }
        };
        this.mHasExposePic = new ArrayList();
        this.lastReqTxt = "";
        SimpleEventBus.getInstance().registerReceiver(this);
        S();
        V();
    }

    private final void A() {
        String str;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        VideoReport.setElementId(this.mRecPicCloseBtn, QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_BAR_CLOSE_BTN);
        VideoReport.setElementExposePolicy(this.mRecPicCloseBtn, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.mRecPicCloseBtn, ClickPolicy.REPORT_NONE);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        FeedCloudMeta$StFeed feed = this.f83294d.getFeed();
        if (feed != null && (feedCloudMeta$StUser = feed.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str);
        params.put("xsj_feed_id", i());
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_REC_PIC_BAR_CLOSE_BTN);
        params.put("xsj_custom_pgid", F());
        VideoReport.reportEvent("ev_xsj_abnormal_clck", this.mRecPicCloseBtn, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(RecyclerView recyclerView) {
        QCircleReportBean qCircleReportBean;
        QCircleReportBean qCircleReportBean2;
        QCircleReportBean qCircleReportBean3;
        String str;
        PBStringField pBStringField;
        String str2;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField2;
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastVisibleItemPosition();
            o20.d d85 = this.f83294d.d8();
            if (d85 != null) {
                qCircleReportBean = d85.f421796d;
            } else {
                qCircleReportBean = null;
            }
            if (qCircleReportBean != null) {
                FeedCloudMeta$StFeed feed = this.f83294d.getFeed();
                if (feed != null && (feedCloudMeta$StUser = feed.poster) != null && (pBStringField2 = feedCloudMeta$StUser.f398463id) != null) {
                    str2 = pBStringField2.get();
                } else {
                    str2 = null;
                }
                qCircleReportBean.setAuthUin(str2);
            }
            o20.d d86 = this.f83294d.d8();
            if (d86 != null) {
                qCircleReportBean2 = d86.f421796d;
            } else {
                qCircleReportBean2 = null;
            }
            if (qCircleReportBean2 != null) {
                FeedCloudMeta$StFeed feed2 = this.f83294d.getFeed();
                if (feed2 != null && (pBStringField = feed2.f398449id) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                qCircleReportBean2.setFeedId(str);
            }
            boolean z16 = false;
            if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                z16 = true;
            }
            if (z16) {
                QLog.d("QFSCommentRecPicBar", 1, "[exposeRecyclerViewItem] firstPos: " + findFirstVisibleItemPosition + ", lastPos: " + findLastVisibleItemPosition);
                if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
                    return;
                }
                while (true) {
                    RecyclerView.LayoutManager layoutManager3 = recyclerView.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager3, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    View findViewByPosition = ((LinearLayoutManager) layoutManager3).findViewByPosition(findFirstVisibleItemPosition);
                    if (findViewByPosition != null) {
                        Object tag = findViewByPosition.getTag(-5);
                        if (tag instanceof StrategyImage) {
                            StrategyImage strategyImage = (StrategyImage) tag;
                            if (!this.mHasExposePic.contains(strategyImage.getPath())) {
                                QLog.d("QFSCommentRecPicBar", 1, "[exposeRecyclerViewItem] expose index: " + findFirstVisibleItemPosition);
                                this.mHasExposePic.add(strategyImage.getPath());
                                ak akVar = ak.f83788a;
                                o20.d d87 = this.f83294d.d8();
                                if (d87 != null) {
                                    qCircleReportBean3 = d87.f421796d;
                                } else {
                                    qCircleReportBean3 = null;
                                }
                                akVar.e(findViewByPosition, findFirstVisibleItemPosition, strategyImage, qCircleReportBean3, true);
                                if (strategyImage.getStrategy() == 2) {
                                    ac.f83765a.c(E(), strategyImage.getId());
                                }
                            }
                        }
                        QLog.d("QFSCommentRecPicBar", 1, "[exposeRecyclerViewItem] has already expose");
                    }
                    if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                        findFirstVisibleItemPosition++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private final void C() {
        if (this.mHasExposePic.isEmpty()) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.abovebar.e
                @Override // java.lang.Runnable
                public final void run() {
                    QFSCommentRecPicBar.D(QFSCommentRecPicBar.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(QFSCommentRecPicBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSCommentRecPicBar", 1, "[firstExposeRecPic] first expose");
        RecyclerView recyclerView = this$0.mRecommendPicRecyclerView;
        if (recyclerView != null) {
            this$0.B(recyclerView);
        }
    }

    private final String E() {
        String str;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feed = this.f83294d.getFeed();
        if (feed != null && (pBStringField = feed.subCate) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String F() {
        String str;
        o20.d d85 = this.f83294d.d8();
        if (d85 != null) {
            str = d85.a();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void H(SimpleBaseEvent event) {
        if (event instanceof QFSRecPicStateEvent) {
            QFSRecPicStateEvent qFSRecPicStateEvent = (QFSRecPicStateEvent) event;
            if (qFSRecPicStateEvent.getState() == 2) {
                List<StrategyImage> G = QFSCommentRecPicClusterHelper.f83716a.G(qFSRecPicStateEvent.getFeedId());
                if (RFSafeListUtils.isEmpty(G)) {
                    W(false, true);
                    return;
                }
                s20.b bVar = this.mRecPicAdapter;
                if (bVar != null) {
                    bVar.addData(G);
                }
                C();
                if (this.userClose) {
                    QLog.d("QFSCommentRecPicBar", 1, "[handleCandidatePicUpdateEvent] user close, can not open.");
                } else if (y()) {
                    this.autoShow = true;
                    QLog.d("QFSCommentRecPicBar", 1, "[handleCandidatePicUpdateEvent] auto open.");
                    com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(getContextHashCode(), getGroup());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0037, code lost:
    
        if (r2 != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I(List<Embedding> embeddings) {
        int collectionSizeOrDefault;
        int i3;
        int i16;
        int i17;
        Object obj;
        float f16;
        int collectionSizeOrDefault2;
        float[] floatArray;
        boolean z16;
        boolean endsWith$default;
        a aVar = this.f83294d;
        int i18 = 2;
        if (aVar instanceof u) {
            String originStr = ((u) aVar).j0();
            Intrinsics.checkNotNullExpressionValue(originStr, "originStr");
            if (l.a(originStr).length() >= z.f83900a.l().getTriggerCount()) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(originStr, "@", false, 2, null);
            }
            QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
            String feedId = i();
            Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
            qFSCommentRecPicClusterHelper.X(feedId);
            return;
        }
        Object[] objArr = new Object[1];
        List<Embedding> list = embeddings;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Embedding) it.next()).pipeline_id);
        }
        objArr[0] = arrayList;
        QLog.d("QFSCommentRecPicBar", 1, objArr);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Embedding embedding : embeddings) {
            PredefinedPipeline predefinedPipeline = embedding.pipeline_id;
            String hashId = embedding.model_input_hash;
            if (predefinedPipeline == null) {
                i16 = -1;
            } else {
                i16 = b.f83280a[predefinedPipeline.ordinal()];
            }
            if (i16 != 1) {
                if (i16 != i18) {
                    i17 = 5;
                } else {
                    i17 = 6;
                }
            } else {
                i17 = 4;
            }
            int i19 = i17;
            Iterator<T> it5 = z.f83900a.q().iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (((QFSPipelineConfig) obj).getPipelineId() == predefinedPipeline.getValue()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            QFSPipelineConfig qFSPipelineConfig = (QFSPipelineConfig) obj;
            if (qFSPipelineConfig != null) {
                f16 = qFSPipelineConfig.getThreshold();
            } else {
                f16 = 68.0f;
            }
            float f17 = f16;
            List<Double> list2 = embedding.value;
            Intrinsics.checkNotNullExpressionValue(list2, "embedding.value");
            List<Double> list3 = list2;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it6 = list3.iterator();
            while (it6.hasNext()) {
                arrayList4.add(Float.valueOf((float) ((Double) it6.next()).doubleValue()));
            }
            floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList4);
            String feedId2 = i();
            Intrinsics.checkNotNullExpressionValue(feedId2, "feedId");
            Intrinsics.checkNotNullExpressionValue(hashId, "hashId");
            arrayList2.add(new QFSCommentRecPicClusterHelper.StrategyConfig(feedId2, i19, floatArray, f17, hashId));
            i18 = 2;
        }
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper2 = QFSCommentRecPicClusterHelper.f83716a;
        List<QFSRecPicInfo> I = qFSCommentRecPicClusterHelper2.I();
        if (!I.isEmpty() && !arrayList2.isEmpty()) {
            ArrayList arrayList5 = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            List<StrategyImage> N = qFSCommentRecPicClusterHelper2.N(I, arrayList2);
            arrayList5.addAll(N);
            QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "input text match cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms, match size: " + N.size());
            Iterator it7 = arrayList2.iterator();
            int i26 = 0;
            while (it7.hasNext()) {
                int i27 = i26 + 1;
                it7.next();
                List<StrategyImage> list4 = N;
                if ((list4 instanceof Collection) && list4.isEmpty()) {
                    i3 = 0;
                } else {
                    Iterator<T> it8 = list4.iterator();
                    i3 = 0;
                    while (it8.hasNext()) {
                        if (Intrinsics.areEqual(((StrategyImage) it8.next()).b().get("hashId"), embeddings.get(i26).model_input_hash) && (i3 = i3 + 1) < 0) {
                            CollectionsKt__CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                String str = embeddings.get(i26).model_input_hash;
                Intrinsics.checkNotNullExpressionValue(str, "embeddings[i].model_input_hash");
                arrayList3.add(new InputClusterBean(str, embeddings.get(i26).pipeline_id.getValue(), i3));
                i26 = i27;
            }
            if (arrayList5.isEmpty()) {
                QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper3 = QFSCommentRecPicClusterHelper.f83716a;
                String feedId3 = i();
                Intrinsics.checkNotNullExpressionValue(feedId3, "feedId");
                qFSCommentRecPicClusterHelper3.X(feedId3);
                return;
            }
            this.autoShow = !this.isShowBar;
            QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper4 = QFSCommentRecPicClusterHelper.f83716a;
            String feedId4 = i();
            Intrinsics.checkNotNullExpressionValue(feedId4, "feedId");
            qFSCommentRecPicClusterHelper4.x(feedId4, arrayList5);
            ak.f83788a.l(arrayList3);
            return;
        }
        String feedId5 = i();
        Intrinsics.checkNotNullExpressionValue(feedId5, "feedId");
        qFSCommentRecPicClusterHelper2.X(feedId5);
        QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "[handleInferTextResult] strategyList size: " + arrayList2.size());
    }

    private final void J() {
        if (QFSCommentRecStickersBar.L) {
            QLog.d("QFSCommentRecPicBar", 1, "[handleInput] sticker is analysing. ");
            return;
        }
        a aVar = this.f83294d;
        if (aVar instanceof u) {
            String originStr = ((u) aVar).j0();
            Intrinsics.checkNotNullExpressionValue(originStr, "originStr");
            String a16 = l.a(originStr);
            int length = a16.length();
            z zVar = z.f83900a;
            if (length < zVar.l().getTriggerCount()) {
                QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
                String feedId = i();
                Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
                qFSCommentRecPicClusterHelper.X(feedId);
                return;
            }
            QLog.d("QFSCommentRecPicBar", 1, "[afterTextChanged] request, text: " + a16);
            if (af.t(this.f83296f) >= 0) {
                QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper2 = QFSCommentRecPicClusterHelper.f83716a;
                String feedId2 = i();
                Intrinsics.checkNotNullExpressionValue(feedId2, "feedId");
                qFSCommentRecPicClusterHelper2.X(feedId2);
                return;
            }
            if (Math.abs(a16.length() - this.lastReqTxt.length()) < zVar.l().getTriggerStep()) {
                QLog.d("QFSCommentRecPicBar", 1, "[handleInput] too few char. ");
            } else {
                this.inferViewModel.X1(a16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(QFSCommentRecPicBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J();
    }

    private final void L(SimpleBaseEvent event) {
        if ((event instanceof QFSRecPicStateEvent) && ((QFSRecPicStateEvent) event).getState() == 3) {
            this.autoShow = true;
            this.userClose = false;
            com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(getContextHashCode(), getGroup());
        }
    }

    private final void M(SimpleBaseEvent event) {
        if (event instanceof QFSRecPicStateEvent) {
            QFSRecPicStateEvent qFSRecPicStateEvent = (QFSRecPicStateEvent) event;
            if (qFSRecPicStateEvent.getState() == 1) {
                this.isFirstOpenPermission = true;
                List<StrategyImage> G = QFSCommentRecPicClusterHelper.f83716a.G(qFSRecPicStateEvent.getFeedId());
                if (RFSafeListUtils.isEmpty(G)) {
                    W(false, true);
                    return;
                }
                s20.b bVar = this.mRecPicAdapter;
                if (bVar != null) {
                    bVar.addData(G);
                }
            }
        }
    }

    private final void N() {
        View view;
        View view2;
        View view3;
        if (this.hasInflate) {
            z();
            return;
        }
        this.hasInflate = true;
        ViewStub viewStub = (ViewStub) this.f83295e.findViewById(R.id.f361213p);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.mContainer = inflate;
        QFSCommentRecPicLoadingView qFSCommentRecPicLoadingView = (QFSCommentRecPicLoadingView) inflate.findViewById(R.id.efs);
        this.mLoadingView = qFSCommentRecPicLoadingView;
        View view4 = null;
        if (qFSCommentRecPicLoadingView != null) {
            view = qFSCommentRecPicLoadingView.findViewById(R.id.d56);
        } else {
            view = null;
        }
        this.mHelpBtn = view;
        View findViewById = inflate.findViewById(R.id.f247409y);
        this.mPicContainer = findViewById;
        if (findViewById != null) {
            view2 = findViewById.findViewById(R.id.d56);
        } else {
            view2 = null;
        }
        this.mHelpBtn2 = view2;
        View view5 = this.mPicContainer;
        if (view5 != null) {
            view3 = view5.findViewById(R.id.jo9);
        } else {
            view3 = null;
        }
        this.mTitleTv = view3;
        View view6 = this.mPicContainer;
        if (view6 != null) {
            view4 = view6.findViewById(R.id.d_k);
        }
        this.mIconIv = view4;
        this.mRecommendPicRecyclerView = (RecyclerView) inflate.findViewById(R.id.i4m);
        this.mRecPicCloseBtn = inflate.findViewById(R.id.az_);
        z();
        QFSCommentRecPicLoadingView qFSCommentRecPicLoadingView2 = this.mLoadingView;
        if (qFSCommentRecPicLoadingView2 != null) {
            qFSCommentRecPicLoadingView2.setOnCloseClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.abovebar.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    QFSCommentRecPicBar.O(QFSCommentRecPicBar.this, view7);
                }
            });
        }
        View view7 = this.mRecPicCloseBtn;
        if (view7 != null) {
            view7.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.abovebar.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view8) {
                    QFSCommentRecPicBar.P(QFSCommentRecPicBar.this, view8);
                }
            });
        }
        View view8 = this.mHelpBtn;
        if (view8 != null) {
            view8.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.abovebar.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view9) {
                    QFSCommentRecPicBar.Q(QFSCommentRecPicBar.this, view9);
                }
            });
        }
        View view9 = this.mHelpBtn2;
        if (view9 != null) {
            view9.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.abovebar.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view10) {
                    QFSCommentRecPicBar.R(QFSCommentRecPicBar.this, view10);
                }
            });
        }
        RecyclerView recyclerView = this.mRecommendPicRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(h(), 0, false));
        }
        s20.b bVar = new s20.b(this);
        this.mRecPicAdapter = bVar;
        RecyclerView recyclerView2 = this.mRecommendPicRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(bVar);
        }
        U();
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(QFSCommentRecPicBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W(false, false);
        com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(this$0.getContextHashCode(), this$0.getGroup());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(QFSCommentRecPicBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.userClose = true;
        this$0.A();
        if (this$0.X()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSRecPicStateEvent(7, null, 2, null));
        }
        this$0.W(false, false);
        com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(this$0.getContextHashCode(), this$0.getGroup());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(QFSCommentRecPicBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCustomDialog.j0(this$0.h());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(QFSCommentRecPicBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCustomDialog.j0(this$0.h());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S() {
        LiveData<UIStateData<List<Embedding>>> Q1 = this.inferViewModel.Q1();
        final Function1<UIStateData<List<? extends Embedding>>, Unit> function1 = new Function1<UIStateData<List<? extends Embedding>>, Unit>() { // from class: com.tencent.biz.qqcircle.comment.abovebar.QFSCommentRecPicBar$initInferObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends Embedding>> uIStateData) {
                invoke2((UIStateData<List<Embedding>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<Embedding>> uIStateData) {
                int state = uIStateData.getState();
                if (state == 2 || state == 3) {
                    QFSCommentRecPicBar qFSCommentRecPicBar = QFSCommentRecPicBar.this;
                    List<Embedding> data = uIStateData.getData();
                    Intrinsics.checkNotNullExpressionValue(data, "it.data");
                    qFSCommentRecPicBar.I(data);
                }
            }
        };
        Q1.observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.comment.abovebar.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentRecPicBar.T(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void U() {
        RecyclerView recyclerView = this.mRecommendPicRecyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new c());
        }
    }

    private final void V() {
        if (aa.f83750a.n()) {
            QLog.d("QFSCommentRecPicBar", 1, "[registerTextWatcher] not allow input cluster. ");
        } else {
            this.f83296f.addTextChangedListener(new d());
        }
    }

    private final boolean X() {
        View view = this.mPicContainer;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private final void Y(boolean show) {
        int dip2px;
        View view = this.mContainer;
        if (view != null) {
            if (show) {
                dip2px = 0;
            } else {
                dip2px = DisplayUtil.dip2px(h(), 5.0f);
            }
            view.setPadding(view.getPaddingLeft(), dip2px, view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    private final void Z() {
        int i3;
        int i16;
        boolean E = aa.f83750a.E(this.f83294d.R4().activity);
        View view = this.mIconIv;
        int i17 = 0;
        if (view != null) {
            if (E) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            view.setVisibility(i16);
        }
        View view2 = this.mHelpBtn2;
        if (view2 != null) {
            if (E) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
        View view3 = this.mTitleTv;
        if (view3 != null) {
            if (!E) {
                i17 = 8;
            }
            view3.setVisibility(i17);
        }
        Y(E);
    }

    private final boolean y() {
        boolean z16 = this.isShowBar;
        if (!z16 && this.isFirstOpenPermission) {
            return true;
        }
        if (!z16 && this.f83294d.R4().canAutoOpenRecPicBar) {
            return true;
        }
        boolean z17 = com.tencent.biz.qqcircle.immersive.manager.e.a().getGroupActivatingElement(getContextHashCode(), getGroup()) instanceof QFSCommentRecStickersBar;
        if (this.autoShow && !QFSCommentRecStickersBar.L && !z17) {
            QLog.d("QFSCommentRecPicBar", 1, "[canAutoOpen] showSticker: false");
            return true;
        }
        return false;
    }

    private final void z() {
        int i3;
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
        String i16 = i();
        Intrinsics.checkNotNullExpressionValue(i16, "getFeedId()");
        List<StrategyImage> G = qFSCommentRecPicClusterHelper.G(i16);
        QFSCommentRecPicLoadingView qFSCommentRecPicLoadingView = this.mLoadingView;
        int i17 = 0;
        if (qFSCommentRecPicLoadingView != null) {
            if (RFSafeListUtils.isEmpty(G)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            qFSCommentRecPicLoadingView.setVisibility(i3);
        }
        View view = this.mPicContainer;
        if (view != null) {
            if (RFSafeListUtils.isEmpty(G)) {
                i17 = 8;
            }
            view.setVisibility(i17);
        }
        Z();
    }

    @Nullable
    public final QCircleReportBean G() {
        o20.d d85 = this.f83294d.d8();
        if (d85 != null) {
            return d85.f421796d;
        }
        return null;
    }

    public final void W(boolean show, boolean notify) {
        float f16;
        QLog.d("QFSCommentRecPicBar", 4, new Throwable("[setRecPicBarVisible] show: " + show), new Object[0]);
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
        String feedId = i();
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        boolean isEmpty = RFSafeListUtils.isEmpty(qFSCommentRecPicClusterHelper.G(feedId));
        Context h16 = h();
        if (isEmpty) {
            f16 = 40.0f;
        } else {
            f16 = 134.0f;
        }
        g(this.mContainer, DisplayUtil.dip2px(h16, f16), show, new e(show, notify));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSRecPicStateEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 103;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (this.f83294d.Of()) {
            return false;
        }
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
        String feedId = i();
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        if (RFSafeListUtils.isEmpty(qFSCommentRecPicClusterHelper.G(feedId)) || this.userClose) {
            return false;
        }
        if (!this.autoShow && !this.f83294d.R4().isShowRecPicBar) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.comment.abovebar.b
    public void j() {
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
        String feedId = i();
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        qFSCommentRecPicClusterHelper.X(feedId);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        N();
        W(true, false);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        W(false, false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        H(event);
        M(event);
        L(event);
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/qqcircle/comment/abovebar/QFSCommentRecPicBar$d", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            RFWThreadManager.getUIHandler().removeCallbacks(QFSCommentRecPicBar.this.handleInputRunnable);
            RFWThreadManager.getUIHandler().postDelayed(QFSCommentRecPicBar.this.handleInputRunnable, 50L);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            QFSCommentRecPicBar.this.lastReqTxt = l.a(String.valueOf(s16));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
