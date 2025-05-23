package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.common.util.g;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalPublishConfigSelectedEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalPublishOnGetConfigEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalSquareRefreshEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishResult;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.viewmodel.QQStrangerSignalPublishViewModel;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.ModelExtKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenImmersiveFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import g82.a;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import tl.h;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 I2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0001JB\u000f\u0012\u0006\u0010,\u001a\u00020\u0002\u00a2\u0006\u0004\bG\u0010HJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001a\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J$\u0010'\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060%0$j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060%`&H\u0016R\u001a\u0010,\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/part/QQStrangerSignalPublishBottomPart;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/QQStrangerSignalBasePart;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/viewmodel/QQStrangerSignalPublishViewModel;", "Lg82/a;", "", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;", DownloadInfo.spKey_Config, "", "partnerAdjPosition", "", "O9", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/b;", "result", "N9", "", "signalExpire", "K9", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/event/QQStrangerSignalPublishConfigSelectedEvent;", "event", "J9", "P9", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "state", "L9", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/viewmodel/QQStrangerSignalPublishViewModel;", "I9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/viewmodel/QQStrangerSignalPublishViewModel;", "viewModel", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "publishExpireTipsView", "f", "Landroid/view/View;", "publishBtnView", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", h.F, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "floatingView", "i", "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;", "selectedSignalConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "Landroid/app/Dialog;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Dialog;", "loadingDialog", "", "D", "Lkotlin/Lazy;", "H9", "()Z", "notifyRefreshSignalSquare", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/viewmodel/QQStrangerSignalPublishViewModel;)V", "E", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalPublishBottomPart extends QQStrangerSignalBasePart<QQStrangerSignalPublishViewModel, g82.a, Object> implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private Dialog loadingDialog;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy notifyRefreshSignalSquare;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final QQStrangerSignalPublishViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView publishExpireTipsView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View publishBtnView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenImmersiveFloatingView floatingView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private SignalPB$SignalConfig selectedSignalConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int partnerAdjPosition;

    public QQStrangerSignalPublishBottomPart(QQStrangerSignalPublishViewModel viewModel) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.partnerAdjPosition = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part.QQStrangerSignalPublishBottomPart$notifyRefreshSignalSquare$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Intent intent;
                Activity activity = QQStrangerSignalPublishBottomPart.this.getActivity();
                boolean z16 = true;
                if (activity != null && (intent = activity.getIntent()) != null) {
                    z16 = intent.getBooleanExtra("key_notify_refresh_signal_square_after_publish", true);
                }
                return Boolean.valueOf(z16);
            }
        });
        this.notifyRefreshSignalSquare = lazy;
    }

    private final void G9() {
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            this.loadingDialog = null;
        }
    }

    private final boolean H9() {
        return ((Boolean) this.notifyRefreshSignalSquare.getValue()).booleanValue();
    }

    private final void J9(QQStrangerSignalPublishConfigSelectedEvent event) {
        this.selectedSignalConfig = event.getConfig();
        this.partnerAdjPosition = event.getPartnerPosition();
    }

    private final void K9(long signalExpire) {
        TextView textView = this.publishExpireTipsView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishExpireTipsView");
            textView = null;
        }
        textView.setText(textView.getContext().getString(R.string.f169686x14, String.valueOf(signalExpire / 3600)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(QQStrangerSignalPublishBottomPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SignalPB$SignalConfig signalPB$SignalConfig = this$0.selectedSignalConfig;
        if (signalPB$SignalConfig != null) {
            if (!g.b(this$0.getContext())) {
                QQToastUtil.showQQToast(0, R.string.x16);
                return;
            }
            int i3 = this$0.partnerAdjPosition;
            if (i3 < 0 || i3 >= signalPB$SignalConfig.partner_adjs.size()) {
                return;
            }
            this$0.P9();
            this$0.A9().R1(signalPB$SignalConfig, signalPB$SignalConfig.partner_adjs.get(this$0.partnerAdjPosition).partner_adj_id.get());
            this$0.O9(signalPB$SignalConfig, this$0.partnerAdjPosition);
        }
    }

    private final void N9(QQStrangerSignalPublishResult result) {
        G9();
        if (result.getIsSuccess()) {
            SignalPlazaSvrPB$SignalInfo signalInfo = result.getSignalInfo();
            QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = null;
            QLog.i("QQStrangerSignalPublishBottomPart", 1, "[onSignalPublishResult] signalInfo: " + (signalInfo != null ? ModelExtKt.A(signalInfo) : null));
            QQToastUtil.showQQToast(2, R.string.x18);
            if (H9()) {
                SimpleEventBus.getInstance().dispatchEvent(QQStrangerSignalSquareRefreshEvent.INSTANCE);
            }
            com.tencent.mobileqq.matchfriend.reborn.content.signal.b.f244871a.d(result.getSignalInfo(), true);
            QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2 = this.floatingView;
            if (qUSHalfScreenImmersiveFloatingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            } else {
                qUSHalfScreenImmersiveFloatingView = qUSHalfScreenImmersiveFloatingView2;
            }
            qUSHalfScreenImmersiveFloatingView.t();
            return;
        }
        QQToastUtil.showQQToast(1, R.string.f169687x15);
    }

    private final void O9(SignalPB$SignalConfig config, int partnerAdjPosition) {
        View view = this.publishBtnView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishBtnView");
            view = null;
        }
        VideoReport.setElementId(view, "em_kl_publish_sign_btn");
        View view2 = this.publishBtnView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishBtnView");
            view2 = null;
        }
        VideoReport.setElementParam(view2, "kl_adjective_id", String.valueOf(config.partner_id.get()));
        View view3 = this.publishBtnView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishBtnView");
            view3 = null;
        }
        VideoReport.setElementParam(view3, "kl_company_type_id", String.valueOf(config.partner_adjs.get(partnerAdjPosition).partner_adj_id.get()));
        View view4 = this.publishBtnView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishBtnView");
            view4 = null;
        }
        VideoReport.setElementClickPolicy(view4, ClickPolicy.REPORT_NONE);
        View view5 = this.publishBtnView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishBtnView");
            view5 = null;
        }
        VideoReport.setElementExposePolicy(view5, ExposurePolicy.REPORT_NONE);
        View view6 = this.publishBtnView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishBtnView");
            view6 = null;
        }
        VideoReport.setElementEndExposePolicy(view6, EndExposurePolicy.REPORT_NONE);
        View view7 = this.publishBtnView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishBtnView");
            view7 = null;
        }
        VideoReport.reportEvent("clck", view7, null);
    }

    private final void P9() {
        if (this.loadingDialog == null) {
            Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(getContext(), 1, true);
            this.loadingDialog = showOnlyLoadingImageDialog;
            if (showOnlyLoadingImageDialog != null) {
                showOnlyLoadingImageDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part.b
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        QQStrangerSignalPublishBottomPart.Q9(QQStrangerSignalPublishBottomPart.this, dialogInterface);
                    }
                });
            }
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QQStrangerSignalPublishBottomPart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this$0.floatingView;
        if (qUSHalfScreenImmersiveFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView = null;
        }
        qUSHalfScreenImmersiveFloatingView.t();
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart
    /* renamed from: I9, reason: from getter and merged with bridge method [inline-methods] */
    public QQStrangerSignalPublishViewModel A9() {
        return this.viewModel;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart
    /* renamed from: L9, reason: merged with bridge method [inline-methods] */
    public void B9(g82.a state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof a.QQStrangerUpdatePublishState) {
            N9(((a.QQStrangerUpdatePublishState) state).getResult());
        } else {
            super.B9(state);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.opn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026nger_signal_publish_tips)");
        this.publishExpireTipsView = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.opd);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026anger_signal_publish_btn)");
        this.publishBtnView = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishBtnView");
            findViewById2 = null;
        }
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerSignalPublishBottomPart.M9(QQStrangerSignalPublishBottomPart.this, view);
            }
        });
        View findViewById3 = rootView.findViewById(R.id.ojs);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.floating_view)");
        this.floatingView = (QUSHalfScreenImmersiveFloatingView) findViewById3;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        G9();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QQStrangerSignalPublishOnGetConfigEvent) {
            K9(((QQStrangerSignalPublishOnGetConfigEvent) event).getSignalExpire());
        } else if (event instanceof QQStrangerSignalPublishConfigSelectedEvent) {
            J9((QQStrangerSignalPublishConfigSelectedEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerSignalPublishOnGetConfigEvent.class, QQStrangerSignalPublishConfigSelectedEvent.class);
        return arrayListOf;
    }
}
