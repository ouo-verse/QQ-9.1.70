package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.qqcircle.manager.diffres.beans.QFSCommentFeedbackResPackage;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.event.QFSRemoveFeedbackCardEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0014J\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u001a\u0010\u001d\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0006H\u0014R\u0018\u0010 \u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/QFSCommentFeedbackItemView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleBaseWidgetView;", "", "", "q0", "n0", "", "level", "Landroid/view/View;", "view", "", "elementId", "m0", "l0", "r0", "o0", "", "isRealFeedBack", "s0", "Landroid/content/Context;", "context", "viewType", "initView", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "setFeed", "getLayoutId", "p0", "p1", "bindData", "d", "Lfeedcloud/FeedCloudMeta$StFeed;", "mFeed", "", "Lcom/airbnb/lottie/LottieAnimationView;", "e", "Ljava/util/List;", "mLottieAnimViewList", "f", "Landroid/view/View;", "mCloseBtn", tl.h.F, "Z", "mHasClick", "<init>", "(Landroid/content/Context;)V", "i", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSCommentFeedbackItemView extends QCircleBaseWidgetView<Object> {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final List<String> f83201m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mFeed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<LottieAnimationView> mLottieAnimViewList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mCloseBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mHasClick;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{QFSCommentFeedbackResPackage.VERY_UNSATISFIED_STATIC_PNG, QFSCommentFeedbackResPackage.UNSATISFIED_STATIC_PNG, QFSCommentFeedbackResPackage.GENERAL_STATIC_PNG, QFSCommentFeedbackResPackage.SATISFIED_STATIC_PNG, QFSCommentFeedbackResPackage.VERY_SATISFIED_STATIC_PNG});
        f83201m = listOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSCommentFeedbackItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l0() {
        String str;
        String str2;
        PBStringField pBStringField;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        VideoReport.setElementId(this, QCircleDaTongConstant.ElementId.EM_XSJ_CMT_ATMOSPHERE_FEEDBACK_CARD);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        String str3 = null;
        if (feedCloudMeta$StFeed != null && (pBStringField3 = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField3.get();
        } else {
            str = null;
        }
        VideoReport.setElementReuseIdentifier(this, str + "_em_xsj_cmt_atmosphere_feedback_card");
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this, ClickPolicy.REPORT_NONE);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.mFeed;
        if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) != null && (pBStringField2 = feedCloudMeta$StUser.f398463id) != null) {
            str2 = pBStringField2.get();
        } else {
            str2 = null;
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.mFeed;
        if (feedCloudMeta$StFeed3 != null && (pBStringField = feedCloudMeta$StFeed3.f398449id) != null) {
            str3 = pBStringField.get();
        }
        params.put("xsj_feed_id", str3);
        VideoReport.setElementParams(this, params);
    }

    private final void m0(int level, View view, String elementId) {
        String str;
        PBStringField pBStringField;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField2;
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        if (Intrinsics.areEqual(elementId, QCircleDaTongConstant.ElementId.EM_XSJ_SATISFACTION_LEVEL)) {
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(QCircleDaTongConstant.ElementParamKey.XSJ_LEVEL, Integer.valueOf(level + 1));
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        String str2 = null;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null && (pBStringField2 = feedCloudMeta$StUser.f398463id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.mFeed;
        if (feedCloudMeta$StFeed2 != null && (pBStringField = feedCloudMeta$StFeed2.f398449id) != null) {
            str2 = pBStringField.get();
        }
        params.put("xsj_feed_id", str2);
        VideoReport.setElementParams(view, params);
    }

    private final void n0() {
        q0();
        List<LottieAnimationView> list = this.mLottieAnimViewList;
        if (list != null) {
            Iterator<LottieAnimationView> it = list.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int i16 = i3 + 1;
                Object parent = it.next().getParent();
                if (parent instanceof ViewGroup) {
                    m0(i3, (View) parent, QCircleDaTongConstant.ElementId.EM_XSJ_SATISFACTION_LEVEL);
                }
                i3 = i16;
            }
        }
        View view = this.mCloseBtn;
        if (view != null) {
            m0(0, view, QCircleDaTongConstant.ElementId.EM_XSJ_CMT_ATMOSPHERE_FEEDBACK_CLOSE);
        }
    }

    private final void o0() {
        View view = this.mCloseBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QFSCommentFeedbackItemView.p0(QFSCommentFeedbackItemView.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(QFSCommentFeedbackItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s0(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q0() {
        if (this.mLottieAnimViewList == null) {
            ArrayList arrayList = new ArrayList();
            this.mLottieAnimViewList = arrayList;
            View findViewById = findViewById(R.id.dor);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.item1)");
            arrayList.add(findViewById);
            List<LottieAnimationView> list = this.mLottieAnimViewList;
            if (list != 0) {
                View findViewById2 = findViewById(R.id.doy);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.item2)");
                list.add(findViewById2);
            }
            List<LottieAnimationView> list2 = this.mLottieAnimViewList;
            if (list2 != 0) {
                View findViewById3 = findViewById(R.id.f165845dp4);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.item3)");
                list2.add(findViewById3);
            }
            List<LottieAnimationView> list3 = this.mLottieAnimViewList;
            if (list3 != 0) {
                View findViewById4 = findViewById(R.id.dp_);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.item4)");
                list3.add(findViewById4);
            }
            List<LottieAnimationView> list4 = this.mLottieAnimViewList;
            if (list4 != 0) {
                View findViewById5 = findViewById(R.id.dpa);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.item5)");
                list4.add(findViewById5);
            }
        }
    }

    private final void r0() {
        List<LottieAnimationView> list = this.mLottieAnimViewList;
        if (list != null) {
            int i3 = 0;
            for (LottieAnimationView lottieAnimationView : list) {
                int i16 = i3 + 1;
                String b16 = com.tencent.biz.qqcircle.helpers.h.a().b(f83201m.get(i3));
                QLog.d("QFSCommentFeedbackItemView", 1, "[initStaticIcon] " + b16);
                QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(b16).setTargetView(lottieAnimationView).setRequestWidth(DisplayUtil.dip2px(getContext(), 36.0f)).setRequestHeight(DisplayUtil.dip2px(getContext(), 36.0f)).setLoadingDrawableColor(0));
                i3 = i16;
            }
        }
    }

    private final void s0(boolean isRealFeedBack) {
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        QFSRemoveFeedbackCardEvent qFSRemoveFeedbackCardEvent = new QFSRemoveFeedbackCardEvent(isRealFeedBack);
        qFSRemoveFeedbackCardEvent.mHashCode = getContext().hashCode();
        simpleEventBus.dispatchEvent(qFSRemoveFeedbackCardEvent);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g9q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(@Nullable Context context, int viewType) {
        super.initView(context, viewType);
        View findViewById = findViewById(R.id.az7);
        this.mCloseBtn = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        q0();
        o0();
        r0();
    }

    public final void setFeed(@NotNull FeedCloudMeta$StFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.mHasClick = false;
        this.mFeed = feed;
        l0();
        n0();
        com.tencent.biz.qqcircle.helpers.g.f84619a.e();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(@Nullable Object p06, int p16) {
    }
}
