package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.feed.event.ShowSharePanelEvent;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J(\u0010\u0019\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017\u0018\u00010\u0016j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017\u0018\u0001`\u0018H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R$\u00100\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00107\u001a\u0002018BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u0010:\u001a\u00020\u001e8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/biz/qqcircle/bizparts/QFSPolymerizationBaseSharePart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "F9", "I9", "Lcom/tencent/biz/qqcircle/beans/QCircleShareInfo;", "shareInfo", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lqqcircle/QQCircleFeedBase$StFeedListBusiRspData;", "busiRspData", "E9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/qqcircle/beans/QCirclePolymerizationBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QCirclePolymerizationBean;", "mInitBean", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mIvShare", "Lcom/tencent/biz/qqcircle/viewmodels/QCirclePolymerizationViewModel;", "f", "Lcom/tencent/biz/qqcircle/viewmodels/QCirclePolymerizationViewModel;", "mViewModel", "Lfeedcloud/FeedCloudMeta$StShare;", tl.h.F, "Lfeedcloud/FeedCloudMeta$StShare;", "mShareInfo", "i", "Lqqcircle/QQCircleFeedBase$StFeedListBusiRspData;", "B9", "()Lqqcircle/QQCircleFeedBase$StFeedListBusiRspData;", "setMBusiRspData", "(Lqqcircle/QQCircleFeedBase$StFeedListBusiRspData;)V", "mBusiRspData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mShareType", "C9", "()I", "shareStyleType", "D9", "()Landroid/widget/ImageView;", "shareView", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCirclePolymerizationBean;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class QFSPolymerizationBaseSharePart extends b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    protected QCirclePolymerizationBean mInitBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvShare;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QCirclePolymerizationViewModel mViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StShare mShareInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQCircleFeedBase$StFeedListBusiRspData mBusiRspData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mShareType;

    public QFSPolymerizationBaseSharePart(@NotNull QCirclePolymerizationBean mInitBean) {
        Intrinsics.checkNotNullParameter(mInitBean, "mInitBean");
        this.mInitBean = mInitBean;
    }

    private final void A9(QCircleShareInfo shareInfo) {
        if (shareInfo != null && this.mInitBean.getPoiInfo() != null) {
            shareInfo.gpsInfo = this.mInitBean.getPoiInfo().gps.get();
            shareInfo.tagName = this.mInitBean.getPolymerizationName();
        }
    }

    private final int C9() {
        int polymerizationType = this.mInitBean.getPolymerizationType();
        if (polymerizationType == 4) {
            return 4;
        }
        if (polymerizationType != 7) {
            if (polymerizationType != 16) {
                return 0;
            }
            return 5;
        }
        return 3;
    }

    private final void F9() {
        int polymerizationType = this.mInitBean.getPolymerizationType();
        if (polymerizationType != 7) {
            if (polymerizationType != 16) {
                if (polymerizationType != 20) {
                    if (polymerizationType == 63) {
                        this.mShareType = 8;
                        return;
                    }
                    return;
                }
                this.mShareType = 6;
                return;
            }
            this.mShareType = 5;
            return;
        }
        this.mShareType = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(QFSPolymerizationBaseSharePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void I9() {
        FeedCloudMeta$StShare feedCloudMeta$StShare = this.mShareInfo;
        if (feedCloudMeta$StShare == null) {
            return;
        }
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        qCircleShareInfo.type = this.mShareType;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed.share.set(feedCloudMeta$StShare);
        qCircleShareInfo.feed = feedCloudMeta$StFeed;
        qCircleShareInfo.feedBlockData = new e30.b(feedCloudMeta$StFeed);
        if (this.mShareType == 4) {
            QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData = this.mBusiRspData;
            if (qQCircleFeedBase$StFeedListBusiRspData == null) {
                return;
            }
            qCircleShareInfo.tagId = qQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo.tagId.get();
            qCircleShareInfo.tagName = qQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo.tagName.get();
            boolean contains = qQCircleFeedBase$StFeedListBusiRspData.opMask.get().contains(2);
            qCircleShareInfo.isShowReport = contains;
            if (contains) {
                QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(feedCloudMeta$StShare.poster.f398463id.get()).setActionType(6).setSubActionType(5).setThrActionType(1).setExt6(qQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo.tagName.get()));
            }
        }
        qCircleShareInfo.shareStyleType = C9();
        qCircleShareInfo.extraTypeInfo = this.mInitBean.getExtraTypeInfo();
        qCircleShareInfo.polymerizationName = this.mInitBean.getPolymerizationName();
        qCircleShareInfo.feedTagPageFromType = this.mInitBean.getFeedTagPageFromType();
        qCircleShareInfo.source = 11;
        A9(qCircleShareInfo);
        broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: B9, reason: from getter */
    public final QQCircleFeedBase$StFeedListBusiRspData getMBusiRspData() {
        return this.mBusiRspData;
    }

    @NotNull
    protected abstract ImageView D9();

    /* JADX INFO: Access modifiers changed from: protected */
    public void E9(@Nullable QQCircleFeedBase$StFeedListBusiRspData busiRspData) {
        String str;
        int i3;
        if (busiRspData == null) {
            return;
        }
        this.mBusiRspData = busiRspData;
        int polymerizationType = this.mInitBean.getPolymerizationType();
        if (polymerizationType != 4) {
            if (polymerizationType != 7) {
                if (polymerizationType != 16) {
                    if (polymerizationType != 20) {
                        if (polymerizationType != 63) {
                            str = "";
                        } else {
                            this.mShareInfo = busiRspData.hotTagData.hotTagsInfo.shareInfo.get();
                            str = busiRspData.hotTagData.hotTagsInfo.title.get();
                            Intrinsics.checkNotNullExpressionValue(str, "busiRspData.hotTagData.hotTagsInfo.title.get()");
                        }
                    } else {
                        this.mShareInfo = busiRspData.fashionCopyPageData.shareInfo.get();
                        str = busiRspData.fashionCopyPageData.pageDesc.get();
                        Intrinsics.checkNotNullExpressionValue(str, "busiRspData.fashionCopyPageData.pageDesc.get()");
                    }
                } else {
                    this.mShareInfo = busiRspData.gpsPageData.shareInfo.get();
                    str = busiRspData.gpsPageData.poiName.get();
                    Intrinsics.checkNotNullExpressionValue(str, "busiRspData.gpsPageData.poiName.get()");
                }
            } else {
                this.mShareInfo = busiRspData.tagPageData.tagInfo.shareInfo.get();
                str = busiRspData.tagPageData.tagInfo.tagName.get();
                Intrinsics.checkNotNullExpressionValue(str, "busiRspData.tagPageData.tagInfo.tagName.get()");
            }
        } else {
            this.mShareInfo = busiRspData.schoolPageData.shareInfo.get();
            str = busiRspData.schoolPageData.schoolName.get();
            Intrinsics.checkNotNullExpressionValue(str, "busiRspData.schoolPageData.schoolName.get()");
        }
        this.mInitBean.setPolymerizationName(str);
        ImageView imageView = this.mIvShare;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvShare");
            imageView = null;
        }
        if (QCirclePluginGlobalInfo.H()) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        imageView.setVisibility(i3);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @Nullable
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ShowSharePanelEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        ImageView D9 = D9();
        this.mIvShare = D9;
        ImageView imageView = null;
        if (D9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvShare");
            D9 = null;
        }
        D9.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.bizparts.br
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPolymerizationBaseSharePart.G9(QFSPolymerizationBaseSharePart.this, view);
            }
        });
        ViewModel viewModel = getViewModel(QCirclePolymerizationViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QCirclePoly\u2026ionViewModel::class.java)");
        QCirclePolymerizationViewModel qCirclePolymerizationViewModel = (QCirclePolymerizationViewModel) viewModel;
        this.mViewModel = qCirclePolymerizationViewModel;
        if (qCirclePolymerizationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qCirclePolymerizationViewModel = null;
        }
        MutableLiveData<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> mutableLiveData = qCirclePolymerizationViewModel.P;
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>, Unit> function1 = new Function1<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>, Unit>() { // from class: com.tencent.biz.qqcircle.bizparts.QFSPolymerizationBaseSharePart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
                if (uIStateData != null) {
                    QFSPolymerizationBaseSharePart.this.E9(uIStateData.getData());
                }
            }
        };
        mutableLiveData.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.bizparts.bs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPolymerizationBaseSharePart.H9(Function1.this, obj);
            }
        });
        F9();
        ImageView imageView2 = this.mIvShare;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvShare");
            imageView2 = null;
        }
        VideoReport.setElementId(imageView2, "em_xsj_share_button");
        ImageView imageView3 = this.mIvShare;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvShare");
        } else {
            imageView = imageView3;
        }
        VideoReport.setElementParams(imageView, new QCircleDTParamBuilder().buildElementParams());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(simpleBaseEvent, "simpleBaseEvent");
        if (simpleBaseEvent instanceof ShowSharePanelEvent) {
            I9();
        }
    }
}
