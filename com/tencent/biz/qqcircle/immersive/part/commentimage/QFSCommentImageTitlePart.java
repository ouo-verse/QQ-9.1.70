package com.tencent.biz.qqcircle.immersive.part.commentimage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.comment.emoji.QFSCommentEmojiOperationManager;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager;
import com.tencent.biz.qqcircle.events.QFSCommentLocateEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StReply;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0007*\u0002.2\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u001c\u0010\u0019\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageTitlePart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/qqcircle/download/QCircleRichMediaDownLoadManager$e;", "", "K9", "", MiniChatConstants.MINI_APP_LANDSCAPE, "G9", "M9", "O9", "F9", "H9", "Landroid/view/View;", "view", "", "text", "I9", "msg", "R9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onBackEvent", "action", "", "args", "handleBroadcastMessage", "getLogTag", "success", "onStatusChange", "", "progress", "onProgress", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "d", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "titleBar", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "e", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageInfo;", "currentImageInfo", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageViewModel;", "f", "Lkotlin/Lazy;", "J9", "()Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageViewModel;", "viewModel", "com/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageTitlePart$b", tl.h.F, "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageTitlePart$b;", "titleRightAction", "com/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageTitlePart$a", "i", "Lcom/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageTitlePart$a;", "storagePermissionsListener", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSCommentImageTitlePart extends com.tencent.biz.qqcircle.immersive.part.u implements QCircleRichMediaDownLoadManager.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUISecNavBar titleBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSCommentImageInfo currentImageInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b titleRightAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a storagePermissionsListener;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageTitlePart$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            String str;
            String feedId;
            QFSCommentImageTitlePart.this.broadcastMessage("rich_media_download_show", null);
            QCircleRichMediaDownLoadManager.d dVar = new QCircleRichMediaDownLoadManager.d();
            QFSCommentImageInfo qFSCommentImageInfo = QFSCommentImageTitlePart.this.currentImageInfo;
            String str2 = "";
            if (qFSCommentImageInfo == null || (str = qFSCommentImageInfo.h()) == null) {
                str = "";
            }
            QFSCommentImageInfo qFSCommentImageInfo2 = QFSCommentImageTitlePart.this.currentImageInfo;
            if (qFSCommentImageInfo2 != null && (feedId = qFSCommentImageInfo2.getFeedId()) != null) {
                str2 = feedId;
            }
            dVar.h(str, 1, str2);
            dVar.g(QFSCommentImageTitlePart.this);
            QCircleRichMediaDownLoadManager.g().f(dVar);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\f"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/commentimage/QFSCommentImageTitlePart$b", "Lcom/tencent/biz/qui/quisecnavbar/a;", "Landroid/view/View;", "view", "", "a", "", "getDrawable", "()I", "drawable", "d", "drawableInTransparent", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends com.tencent.biz.qui.quisecnavbar.a {
        b() {
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            QFSCommentImageTitlePart.this.O9();
            VideoReport.setElementId(view, "em_xsj_more_button");
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("clck", view, null);
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public int d() {
            return R.drawable.qui_more_icon_white;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            return R.drawable.qui_more_icon_white;
        }
    }

    public QFSCommentImageTitlePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSCommentImageViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageTitlePart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSCommentImageViewModel invoke() {
                return (QFSCommentImageViewModel) QFSCommentImageTitlePart.this.getViewModel(QFSCommentImageViewModel.class);
            }
        });
        this.viewModel = lazy;
        this.titleRightAction = new b();
        this.storagePermissionsListener = new a();
    }

    private final void F9() {
        Unit unit;
        String errMsg = com.tencent.biz.qqcircle.utils.h.a(R.string.f188913xz);
        QFSCommentImageInfo qFSCommentImageInfo = this.currentImageInfo;
        if (qFSCommentImageInfo != null) {
            if (!qFSCommentImageInfo.e()) {
                QLog.w(getTAG(), 1, "[doAddEmoji] can not add emoji");
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                R9(errMsg);
            } else {
                new QFSCommentEmojiOperationManager(qFSCommentImageInfo.i(), getContext()).e();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[doAddEmoji] invalid info");
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            R9(errMsg);
        }
    }

    private final void G9(boolean isLandscape) {
        QUISecNavBar qUISecNavBar = this.titleBar;
        if (qUISecNavBar != null) {
            if (!isLandscape) {
                qUISecNavBar.d(this.titleRightAction);
            }
            qUISecNavBar.setAutoAdaptTransparent(true);
            qUISecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left_icon_white);
            QFSBaseFragment hostFragment = getHostFragment();
            Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
            qUISecNavBar.S(hostFragment);
            qUISecNavBar.setTitleAlpha(0.0f);
            qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageTitlePart$doInitView$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View view, @NotNull BaseAction baseAction) {
                    Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(baseAction, "<anonymous parameter 1>");
                    Activity activity = QFSCommentImageTitlePart.this.getActivity();
                    if (activity != null) {
                        activity.onBackPressed();
                    }
                }
            });
        }
    }

    private final void H9() {
        Unit unit;
        String errMsg = com.tencent.biz.qqcircle.utils.h.a(R.string.f182953hv);
        QFSCommentImageInfo qFSCommentImageInfo = this.currentImageInfo;
        if (qFSCommentImageInfo != null) {
            if (!qFSCommentImageInfo.f()) {
                QLog.w(getTAG(), 1, "[doSaveImage] can not save");
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                R9(errMsg);
            } else {
                com.tencent.biz.qqcircle.utils.z.b(getActivity(), 2, this.storagePermissionsListener, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_SHARE_SAVE), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[doSaveImage] invalid info");
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            R9(errMsg);
        }
    }

    private final void I9(View view, String text) {
        if (view != null) {
            Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_TASK_OPERATION_BUTTON);
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_LARGE_PIC_PAGE);
            params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_TASK_OPERATION_BUTTON);
            params.put("xsj_item_name", text);
            VideoReport.reportEvent("ev_xsj_abnormal_clck", view, params);
        }
    }

    private final QFSCommentImageViewModel J9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (QFSCommentImageViewModel) value;
    }

    private final void K9() {
        LiveData<QFSCommentImageInfo> Q1 = J9().Q1();
        QFSBaseFragment hostFragment = getHostFragment();
        final Function1<QFSCommentImageInfo, Unit> function1 = new Function1<QFSCommentImageInfo, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.QFSCommentImageTitlePart$initObserver$1
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
                QFSCommentImageTitlePart.this.currentImageInfo = qFSCommentImageInfo;
            }
        };
        Q1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentImageTitlePart.L9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void M9() {
        String str;
        PBStringField pBStringField;
        QFSCommentImageInfo qFSCommentImageInfo = this.currentImageInfo;
        if (qFSCommentImageInfo != null) {
            String feedId = qFSCommentImageInfo.getFeedId();
            String str2 = qFSCommentImageInfo.getStComment().f398447id.get();
            FeedCloudMeta$StReply stReply = qFSCommentImageInfo.getStReply();
            if (stReply != null && (pBStringField = stReply.f398460id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSCommentLocateEvent(feedId, str2, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QFSCommentImageTitlePart this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("rich_media_download_dimiss", null);
        if (z16) {
            QCircleToast.v(QCircleToast.f91646f, com.tencent.biz.qqcircle.utils.h.a(R.string.f182963hw), 0);
        } else {
            String msg2 = com.tencent.biz.qqcircle.utils.h.a(R.string.f182953hv);
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            this$0.R9(msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9() {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton(new ActionMenuItem(com.tencent.biz.qqcircle.utils.h.a(R.string.f194974dc), 100, 0), 0);
        actionSheet.addButton(new ActionMenuItem(com.tencent.biz.qqcircle.utils.h.a(R.string.f1901641c), 101, 0), 0);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.ac
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                QFSCommentImageTitlePart.P9(ActionSheet.this, this, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSCommentImageTitlePart.Q9(QFSCommentImageTitlePart.this, actionSheet, view);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(ActionSheet actionSheet, QFSCommentImageTitlePart this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionMenuItem actionMenuItem = actionSheet.getActionMenuItem(i3);
        if (actionMenuItem != null) {
            int i16 = actionMenuItem.action;
            if (i16 == 100) {
                String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f194974dc);
                Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qfs_save_pic)");
                this$0.I9(view, a16);
                actionSheet.dismiss();
                this$0.H9();
                return;
            }
            if (i16 == 101) {
                String a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f1901641c);
                Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qfs_fav_emoji)");
                this$0.I9(view, a17);
                actionSheet.dismiss();
                this$0.F9();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QFSCommentImageTitlePart this$0, ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.cancel)");
        this$0.I9(view, a16);
        actionSheet.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R9(String msg2) {
        QCircleToast.v(QCircleToast.f91645e, msg2, 0);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSCommentImageTitlePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "1")) {
            H9();
            return;
        }
        if (Intrinsics.areEqual(action, "2")) {
            F9();
            return;
        }
        QLog.w(getTAG(), 1, "[handleBroadcastMessage] invalid action: " + action);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        M9();
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, 0);
            return true;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        QUISecNavBar qUISecNavBar;
        boolean z16;
        Intent intent;
        super.onInitView(rootView);
        Integer num = null;
        if (rootView != null) {
            qUISecNavBar = (QUISecNavBar) rootView.findViewById(R.id.f360813l);
        } else {
            qUISecNavBar = null;
        }
        this.titleBar = qUISecNavBar;
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            num = Integer.valueOf(intent.getIntExtra("orientation_type_flag", -1));
        }
        if (num != null && num.intValue() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        G9(z16);
        K9();
    }

    @Override // com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.e
    public void onProgress(int progress) {
        broadcastMessage("rich_meida_download_progress", Integer.valueOf(progress));
    }

    @Override // com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.e
    public void onStatusChange(final boolean success) {
        if (success) {
            broadcastMessage("rich_meida_download_progress", 100);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.commentimage.ae
            @Override // java.lang.Runnable
            public final void run() {
                QFSCommentImageTitlePart.N9(QFSCommentImageTitlePart.this, success);
            }
        }, 20L);
    }
}
