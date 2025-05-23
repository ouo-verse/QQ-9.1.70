package com.tencent.biz.qqcircle.immersive.datacardcover.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.datacardcover.fragment.QFSPersonalCoverFeedSelectFragment;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverBlurView;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverSelectLayout;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.data.QCircleFeedCoverBean;
import com.tencent.mobileqq.qcircle.api.event.QFSSetCoverFeedEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$SingleProfileCardInfo;
import j40.SetCoverResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 S2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0016J\u001a\u0010#\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010$\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0012\u0010)\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030+0*H\u0016R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R#\u0010?\u001a\n :*\u0004\u0018\u000109098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR#\u0010P\u001a\n :*\u0004\u0018\u00010L0L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010<\u001a\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/part/QFSPersonalCoverUploadPart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Lfeedcloud/FeedCloudRead$SingleProfileCardInfo;", "V9", "", "initViewModel", "", "message", "X9", "S9", "", "Q9", "isChecked", "Z9", "Lcom/tencent/mobileqq/qcircle/api/event/QFSSetCoverFeedEvent;", "event", "R9", "Lcom/tencent/mobileqq/qcircle/api/data/QCircleFeedCoverBean;", "I9", "W9", "L9", "Y9", "N9", "eventId", "itemName", "H9", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartPause", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverSelectLayout;", "d", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverSelectLayout;", "selectLayout", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverBlurView;", "e", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverBlurView;", "blurView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvConfirm", "Landroid/app/Dialog;", "kotlin.jvm.PlatformType", tl.h.F, "Lkotlin/Lazy;", "J9", "()Landroid/app/Dialog;", "loadingDialog", "Lfeedcloud/FeedCloudMeta$StFeed;", "i", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lfeedcloud/FeedCloudRead$SingleProfileCardInfo;", "mProfileCardInfo", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mLaunchFrom", "D", "profileType", "Lj40/a;", "E", "K9", "()Lj40/a;", "viewModel", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverUploadPart extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String mLaunchFrom;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String profileType;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QFSPersonalCoverSelectLayout selectLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QFSPersonalCoverBlurView blurView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvConfirm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingDialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FeedCloudMeta$StFeed feed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudRead$SingleProfileCardInfo mProfileCardInfo;

    public QFSPersonalCoverUploadPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverUploadPart$loadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Dialog invoke() {
                Context context = QFSPersonalCoverUploadPart.this.getContext();
                Context context2 = QFSPersonalCoverUploadPart.this.getContext();
                return LoadingUtil.showLoadingDialog(context, context2 != null ? context2.getString(R.string.f189393z_) : null, true);
            }
        });
        this.loadingDialog = lazy;
        this.profileType = "0";
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<j40.a>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverUploadPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final j40.a invoke() {
                QFSPersonalCoverUploadPart qFSPersonalCoverUploadPart = QFSPersonalCoverUploadPart.this;
                return (j40.a) qFSPersonalCoverUploadPart.getViewModel(qFSPersonalCoverUploadPart.getPartHost(), "", j40.a.class);
            }
        });
        this.viewModel = lazy2;
    }

    private final void H9(String eventId, String itemName) {
        boolean z16;
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_SUPER_SHOW_POP);
        if (itemName != null && itemName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            params.put("xsj_item_name", itemName);
        }
        QCircleReportBean reportBean = getReportBean();
        if (reportBean != null) {
            params.put("xsj_custom_pgid", reportBean.getDtPageId());
        }
        VideoReport.reportEvent(eventId, params);
    }

    private final QCircleFeedCoverBean I9() {
        QCircleFeedCoverBean qCircleFeedCoverBean = new QCircleFeedCoverBean();
        QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout = this.selectLayout;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
        if (qFSPersonalCoverSelectLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
            qFSPersonalCoverSelectLayout = null;
        }
        qCircleFeedCoverBean.qcircleCoverY = qFSPersonalCoverSelectLayout.getYPercent();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.feed;
        if (feedCloudMeta$StFeed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed2 = null;
        }
        qCircleFeedCoverBean.qcircleFeedId = feedCloudMeta$StFeed2.f398449id.get();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.feed;
        if (feedCloudMeta$StFeed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed3 = null;
        }
        qCircleFeedCoverBean.qcircleFeedPosterUin = feedCloudMeta$StFeed3.poster.f398463id.get();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed4 = this.feed;
        if (feedCloudMeta$StFeed4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed4 = null;
        }
        qCircleFeedCoverBean.qcircleVideoCoverUrl = feedCloudMeta$StFeed4.cover.picUrl.get();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed5 = this.feed;
        if (feedCloudMeta$StFeed5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed5 = null;
        }
        qCircleFeedCoverBean.qcircleVideoUrl = feedCloudMeta$StFeed5.video.playUrl.get();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed6 = this.feed;
        if (feedCloudMeta$StFeed6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed6 = null;
        }
        qCircleFeedCoverBean.qcircleVideoHeight = feedCloudMeta$StFeed6.video.height.get();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed7 = this.feed;
        if (feedCloudMeta$StFeed7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        } else {
            feedCloudMeta$StFeed = feedCloudMeta$StFeed7;
        }
        qCircleFeedCoverBean.qcircleVideoWidth = feedCloudMeta$StFeed.video.width.get();
        qCircleFeedCoverBean.launchFrom = this.mLaunchFrom;
        return qCircleFeedCoverBean;
    }

    private final Dialog J9() {
        return (Dialog) this.loadingDialog.getValue();
    }

    private final j40.a K9() {
        return (j40.a) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        J9().dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean N9() {
        boolean z16;
        String str;
        String str2;
        boolean z17;
        FeedCloudRead$SingleProfileCardInfo feedCloudRead$SingleProfileCardInfo = this.mProfileCardInfo;
        if (feedCloudRead$SingleProfileCardInfo == null) {
            return false;
        }
        PBStringField pBStringField = feedCloudRead$SingleProfileCardInfo.tips_word;
        if (pBStringField != null && (str2 = pBStringField.get()) != null) {
            Intrinsics.checkNotNullExpressionValue(str2, "get()");
            if (str2.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (z16) {
                    return false;
                }
                Activity activity = getActivity();
                PBStringField pBStringField2 = feedCloudRead$SingleProfileCardInfo.tips_word;
                if (pBStringField2 != null) {
                    str = pBStringField2.get();
                } else {
                    str = null;
                }
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, (String) null, str, com.tencent.biz.qqcircle.utils.h.a(R.string.cancel), com.tencent.biz.qqcircle.utils.h.a(R.string.f184863n1), new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.m
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        QFSPersonalCoverUploadPart.P9(QFSPersonalCoverUploadPart.this, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.n
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        QFSPersonalCoverUploadPart.O9(QFSPersonalCoverUploadPart.this, dialogInterface, i3);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026))\n                    })");
                createCustomDialog.show();
                H9("ev_xsj_abnormal_imp", null);
                return true;
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(QFSPersonalCoverUploadPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9("ev_xsj_abnormal_clck", com.tencent.biz.qqcircle.utils.h.a(R.string.cancel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QFSPersonalCoverUploadPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j40.a K9 = this$0.K9();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.feed;
        QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout = null;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed = null;
        }
        QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout2 = this$0.selectLayout;
        if (qFSPersonalCoverSelectLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
        } else {
            qFSPersonalCoverSelectLayout = qFSPersonalCoverSelectLayout2;
        }
        K9.P1(feedCloudMeta$StFeed, qFSPersonalCoverSelectLayout.getYPercent());
        dialogInterface.dismiss();
        this$0.H9("ev_xsj_abnormal_clck", com.tencent.biz.qqcircle.utils.h.a(R.string.f184863n1));
    }

    private final boolean Q9() {
        boolean z16;
        boolean z17;
        FeedCloudRead$SingleProfileCardInfo feedCloudRead$SingleProfileCardInfo = this.mProfileCardInfo;
        if (feedCloudRead$SingleProfileCardInfo == null) {
            return false;
        }
        PBEnumField pBEnumField = feedCloudRead$SingleProfileCardInfo.card_cover_type;
        if (pBEnumField != null && pBEnumField.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        PBBoolField pBBoolField = feedCloudRead$SingleProfileCardInfo.setting_status;
        if (pBBoolField != null && pBBoolField.get()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return false;
        }
        return true;
    }

    private final void R9(QFSSetCoverFeedEvent event) {
        SimpleEventBus.getInstance().dispatchEvent(event);
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        QCircleInitBean qCircleInitBean;
        boolean z16;
        String str;
        QFSPersonalCoverFeedSelectFragment.Companion companion = QFSPersonalCoverFeedSelectFragment.INSTANCE;
        boolean b16 = companion.b(this.profileType);
        boolean Q9 = Q9();
        boolean z17 = true;
        QLog.d("QFSPersonalCoverUploadPart", 1, "notifySetResult, isMyProfile: " + b16 + ", needUpdateZPlanEntrance:" + Q9);
        if (b16) {
            Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
            if (serializableExtra instanceof QCircleInitBean) {
                qCircleInitBean = (QCircleInitBean) serializableExtra;
            } else {
                qCircleInitBean = null;
            }
            Intrinsics.checkNotNull(qCircleInitBean);
            HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
            if (schemeAttrs != null && (str = schemeAttrs.get(QCircleSchemeAttr.CoverFeed.SOURCE_TYPE)) != null && str.equals("1")) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i40.c cVar = i40.c.f407182a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                cVar.a(context, companion.a());
            } else {
                z17 = false;
            }
            R9(new QFSSetCoverFeedEvent(I9(), z17));
        } else {
            i40.c cVar2 = i40.c.f407182a;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            cVar2.a(context2, companion.a());
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.o
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPersonalCoverUploadPart.T9(QFSPersonalCoverUploadPart.this);
                }
            }, 1000L);
        }
        if (Q9) {
            Z9(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(QFSPersonalCoverUploadPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9(new QFSSetCoverFeedEvent(this$0.I9(), false, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QFSPersonalCoverUploadPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final FeedCloudRead$SingleProfileCardInfo V9(QCircleInitBean initBean) {
        boolean z16;
        byte[] busiInfoData = initBean.getBusiInfoData();
        boolean z17 = false;
        if (busiInfoData != null) {
            if (busiInfoData.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            }
        }
        if (z17) {
            try {
                byte[] busiInfoData2 = initBean.getBusiInfoData();
                if (busiInfoData2 == null) {
                    return null;
                }
                FeedCloudRead$SingleProfileCardInfo feedCloudRead$SingleProfileCardInfo = new FeedCloudRead$SingleProfileCardInfo();
                feedCloudRead$SingleProfileCardInfo.mergeFrom(busiInfoData2);
                feedCloudRead$SingleProfileCardInfo.setHasFlag(true);
                return feedCloudRead$SingleProfileCardInfo;
            } catch (Exception e16) {
                QLog.e("QFSPersonalCoverUploadPart", 1, "[parseProfileCardInfo] e:" + e16);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9() {
        J9().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(String message) {
        QCircleToast.o(message, 0);
    }

    private final void Y9() {
        if (!N9()) {
            j40.a K9 = K9();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
            QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout = null;
            if (feedCloudMeta$StFeed == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
                feedCloudMeta$StFeed = null;
            }
            QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout2 = this.selectLayout;
            if (qFSPersonalCoverSelectLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
            } else {
                qFSPersonalCoverSelectLayout = qFSPersonalCoverSelectLayout2;
            }
            K9.P1(feedCloudMeta$StFeed, qFSPersonalCoverSelectLayout.getYPercent());
        }
    }

    private final void Z9(boolean isChecked) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            AccessibleDetail zplanAccessibleDetail = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).getZplanAccessibleDetail(1004L, peekAppRuntime.getLongAccountUin());
            if (zplanAccessibleDetail != null) {
                zplanAccessibleDetail.settingPass = isChecked ? 1 : 0;
                QLog.i("QFSPersonalCoverUploadPart", 1, "updateProfileCardZPlanEntranceForCache detail:" + zplanAccessibleDetail + ", isChecked:" + isChecked);
                ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).updateCache(zplanAccessibleDetail);
            }
        }
    }

    private final void initViewModel() {
        LiveData<SetCoverResult> L1 = K9().L1();
        Fragment hostFragment = getHostFragment();
        final Function1<SetCoverResult, Unit> function1 = new Function1<SetCoverResult, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverUploadPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SetCoverResult setCoverResult) {
                invoke2(setCoverResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SetCoverResult setCoverResult) {
                if (setCoverResult.c()) {
                    QFSPersonalCoverUploadPart.this.W9();
                    return;
                }
                if (setCoverResult.d()) {
                    QFSPersonalCoverUploadPart.this.L9();
                    QFSPersonalCoverUploadPart.this.X9(setCoverResult.getMessage());
                    QFSPersonalCoverUploadPart.this.S9();
                } else if (setCoverResult.b()) {
                    QFSPersonalCoverUploadPart.this.L9();
                    QFSPersonalCoverUploadPart.this.X9(setCoverResult.getMessage());
                }
            }
        };
        L1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalCoverUploadPart.M9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleConfigChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCoverUploadPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f54452f9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qfs_select_layout)");
        this.selectLayout = (QFSPersonalCoverSelectLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f34320yu);
        QFSPersonalCoverBlurView qFSPersonalCoverBlurView = (QFSPersonalCoverBlurView) findViewById2;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        TextView textView = null;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            feedCloudMeta$StFeed = null;
        }
        qFSPersonalCoverBlurView.setFeed(feedCloudMeta$StFeed);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<QF\u2026  setFeed(feed)\n        }");
        this.blurView = qFSPersonalCoverBlurView;
        View findViewById3 = rootView.findViewById(R.id.f56012jg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.qfs_tv_confirm)");
        TextView textView2 = (TextView) findViewById3;
        this.tvConfirm = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPersonalCoverUploadPart.U9(QFSPersonalCoverUploadPart.this, view);
            }
        });
        i40.b bVar = i40.b.f407181a;
        TextView textView3 = this.tvConfirm;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvConfirm");
        } else {
            textView = textView3;
        }
        bVar.a(textView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        QCircleInitBean qCircleInitBean;
        String str;
        Integer num;
        PBBoolField pBBoolField;
        PBEnumField pBEnumField;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        Serializable serializableExtra = activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
        Boolean bool = null;
        if (serializableExtra instanceof QCircleInitBean) {
            qCircleInitBean = (QCircleInitBean) serializableExtra;
        } else {
            qCircleInitBean = null;
        }
        Intrinsics.checkNotNull(qCircleInitBean);
        FeedCloudMeta$StFeed feed = qCircleInitBean.getFeed();
        Intrinsics.checkNotNullExpressionValue(feed, "it.feed");
        this.feed = feed;
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (schemeAttrs != null) {
            str = schemeAttrs.get(QCircleSchemeAttr.CoverFeed.PROFILE_TYPE);
        } else {
            str = null;
        }
        if (str == null) {
            str = "0";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "it.schemeAttrs?.get(QCir\u2026OFILE_TYPE) ?: MY_PROFILE");
        }
        this.profileType = str;
        this.mProfileCardInfo = V9(qCircleInitBean);
        this.mLaunchFrom = qCircleInitBean.getLaunchFrom();
        SimpleEventBus.getInstance().registerReceiver(this);
        String str2 = this.profileType;
        FeedCloudRead$SingleProfileCardInfo feedCloudRead$SingleProfileCardInfo = this.mProfileCardInfo;
        if (feedCloudRead$SingleProfileCardInfo != null && (pBEnumField = feedCloudRead$SingleProfileCardInfo.card_cover_type) != null) {
            num = Integer.valueOf(pBEnumField.get());
        } else {
            num = null;
        }
        FeedCloudRead$SingleProfileCardInfo feedCloudRead$SingleProfileCardInfo2 = this.mProfileCardInfo;
        if (feedCloudRead$SingleProfileCardInfo2 != null && (pBBoolField = feedCloudRead$SingleProfileCardInfo2.setting_status) != null) {
            bool = Boolean.valueOf(pBBoolField.get());
        }
        QLog.d("QFSPersonalCoverUploadPart", 1, "onPartCreate, profileType: " + str2 + ", coverType:" + num + ", coverSetStatus:" + bool);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        L9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        QFSPersonalCoverSelectLayout qFSPersonalCoverSelectLayout;
        if ((event instanceof QCircleConfigChangeEvent) && (qFSPersonalCoverSelectLayout = this.selectLayout) != null) {
            if (qFSPersonalCoverSelectLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectLayout");
                qFSPersonalCoverSelectLayout = null;
            }
            qFSPersonalCoverSelectLayout.l();
        }
    }
}
