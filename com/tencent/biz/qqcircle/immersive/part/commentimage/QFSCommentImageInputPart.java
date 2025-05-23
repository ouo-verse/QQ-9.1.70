package com.tencent.biz.qqcircle.immersive.part.commentimage;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSAddFakeCommentOrReplyEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StReply;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0018`\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInputPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/qqcircle/events/QCircleCommentUpdateEvent;", "", "E9", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "getLogTag", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "d", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "currentInfo", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageViewModel;", "e", "Lkotlin/Lazy;", "C9", "()Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageViewModel;", "viewModel", "com/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInputPart$a", "f", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInputPart$a;", "inputWindowListener", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSCommentImageInputPart extends com.tencent.biz.qqcircle.immersive.part.u implements SimpleEventReceiver<QCircleCommentUpdateEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSCommentImageInfo currentInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a inputWindowListener;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInputPart$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            QFSCommentImageInputPart.this.F9(3);
        }
    }

    public QFSCommentImageInputPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSCommentImageViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageInputPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSCommentImageViewModel invoke() {
                return (QFSCommentImageViewModel) QFSCommentImageInputPart.this.getViewModel(QFSCommentImageViewModel.class);
            }
        });
        this.viewModel = lazy;
        this.inputWindowListener = new a();
    }

    private final QFSCommentImageViewModel C9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (QFSCommentImageViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void E9() {
        com.tencent.biz.qqcircle.utils.z.b(getActivity(), 2, new b(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_SHARE_SAVE), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(int clickType) {
        String str;
        String tag = getTAG();
        QFSCommentImageInfo qFSCommentImageInfo = this.currentInfo;
        if (qFSCommentImageInfo != null) {
            str = qFSCommentImageInfo.l();
        } else {
            str = null;
        }
        QLog.d(tag, 1, "[showCommentInputWindow] id=" + str);
        QFSCommentImageInfo qFSCommentImageInfo2 = this.currentInfo;
        if (qFSCommentImageInfo2 != null) {
            if (qFSCommentImageInfo2.j() == null) {
                QLog.e(getTAG(), 1, "[showCommentInputWindow] invalid feed");
                return;
            }
            QFSFeedCommentInfo qFSFeedCommentInfo = new QFSFeedCommentInfo(qFSCommentImageInfo2.j(), qFSCommentImageInfo2.getStComment(), qFSCommentImageInfo2.getStReply(), qFSCommentImageInfo2.m());
            QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
            qFSCommentInputWindowConfig.commentInfo = qFSFeedCommentInfo;
            qFSCommentInputWindowConfig.activity = getActivity();
            qFSCommentInputWindowConfig.isFullScreen = false;
            qFSCommentInputWindowConfig.isShowAiComment = false;
            qFSCommentInputWindowConfig.isAllowAiComment = false;
            if (clickType != 1) {
                if (clickType != 2) {
                    if (clickType == 3) {
                        qFSCommentInputWindowConfig.isShowHalfScreenPicPanel = true;
                    }
                } else {
                    qFSCommentInputWindowConfig.isShowEmoji = true;
                }
            } else {
                qFSCommentInputWindowConfig.needShowAt = true;
            }
            qFSCommentInputWindowConfig.needShowPublishIcon = true;
            qFSCommentInputWindowConfig.inputListener = this.inputWindowListener;
            QFSCommentHelper.L().w0(qFSCommentInputWindowConfig);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QCircleCommentUpdateEvent>> getEventClass() {
        ArrayList<Class<QCircleCommentUpdateEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QCircleCommentUpdateEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "showCommentInputWindow";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        Integer num;
        int i3;
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "action_show_input_window")) {
            if (args instanceof Integer) {
                num = (Integer) args;
            } else {
                num = null;
            }
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            if (i3 == 3) {
                E9();
            } else {
                F9(i3);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        LiveData<QFSCommentImageInfo> Q1 = C9().Q1();
        QFSBaseFragment hostFragment = getHostFragment();
        final Function1<QFSCommentImageInfo, Unit> function1 = new Function1<QFSCommentImageInfo, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageInputPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSCommentImageInfo qFSCommentImageInfo) {
                invoke2(qFSCommentImageInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QFSCommentImageInfo qFSCommentImageInfo) {
                QFSCommentImageInputPart.this.currentInfo = qFSCommentImageInfo;
            }
        };
        Q1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentImageInputPart.D9(Function1.this, obj);
            }
        });
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QCircleCommentUpdateEvent) {
            int i3 = ((QCircleCommentUpdateEvent) event).eventStatus;
            if (i3 != 5) {
                if (i3 == 10) {
                    QCircleToast.v(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f188793xn), 0);
                    return;
                }
                return;
            }
            QCircleToast.v(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f188803xo), 0);
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInputPart$a", "Lcom/tencent/biz/qqcircle/utils/QFSCommentHelper$b;", "Lfeedcloud/FeedCloudMeta$StReply;", "stReply", "Lo20/d;", "commentReportBean", "", "b", "Lfeedcloud/FeedCloudMeta$StComment;", "stComment", "c", "", "relocationType", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements QFSCommentHelper.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void b(@Nullable FeedCloudMeta$StReply stReply, @Nullable o20.d commentReportBean) {
            String str;
            FeedCloudMeta$StComment feedCloudMeta$StComment;
            QFSCommentImageInfo qFSCommentImageInfo = QFSCommentImageInputPart.this.currentInfo;
            FeedCloudMeta$StReply feedCloudMeta$StReply = null;
            if (qFSCommentImageInfo != null) {
                str = qFSCommentImageInfo.getFeedId();
            } else {
                str = null;
            }
            QFSCommentImageInfo qFSCommentImageInfo2 = QFSCommentImageInputPart.this.currentInfo;
            if (qFSCommentImageInfo2 != null) {
                feedCloudMeta$StComment = qFSCommentImageInfo2.getStComment();
            } else {
                feedCloudMeta$StComment = null;
            }
            QFSAddFakeCommentOrReplyEvent qFSAddFakeCommentOrReplyEvent = new QFSAddFakeCommentOrReplyEvent(str, feedCloudMeta$StComment, stReply, 0);
            qFSAddFakeCommentOrReplyEvent.setDtPageId(QCircleDaTongConstant.PageId.PG_XSJ_LARGE_PIC_PAGE);
            QFSCommentImageInfo qFSCommentImageInfo3 = QFSCommentImageInputPart.this.currentInfo;
            if (qFSCommentImageInfo3 != null) {
                feedCloudMeta$StReply = qFSCommentImageInfo3.getStReply();
            }
            qFSAddFakeCommentOrReplyEvent.targetReply = feedCloudMeta$StReply;
            SimpleEventBus.getInstance().dispatchEvent(qFSAddFakeCommentOrReplyEvent);
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void a(int relocationType) {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentHelper.b
        public void c(@Nullable FeedCloudMeta$StComment stComment, @Nullable o20.d commentReportBean) {
        }
    }
}
