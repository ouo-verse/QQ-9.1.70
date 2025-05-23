package com.tencent.mobileqq.qqlive.sail.ui.follow;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.sail.base.c;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.timi.game.liveroom.impl.room.anchor.UserSelfSendMsgEvent;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import lj4.a;
import lj4.d;
import mt3.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 32\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0003J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0003J\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001e0\u001dH\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/follow/QQLiveFollowGuidePart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/liveroom/impl/room/anchor/UserSelfSendMsgEvent;", "", "oa", "", "from", "wa", "sa", "Landroid/app/Dialog;", "pa", "qa", "ra", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "ta", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "U9", "V9", "Lfp4/c;", "msgInfo", "onPush", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "e", "Landroid/app/Dialog;", "dialog", "Lkotlinx/coroutines/Job;", "f", "Lkotlinx/coroutines/Job;", "showDialogJob", "", h.F, "Z", "shouldShowGuide", "Lcom/tencent/mobileqq/qqlive/sail/ui/clearscreen/a;", "i", "Lkotlin/Lazy;", "va", "()Lcom/tencent/mobileqq/qqlive/sail/ui/clearscreen/a;", "clearScreenViewModel", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveFollowGuidePart extends c implements g, SimpleEventReceiver<UserSelfSendMsgEvent> {
    static IPatchRedirector $redirector_;
    private static final int C;
    private static final int D;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog dialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job showDialogJob;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean shouldShowGuide;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy clearScreenViewModel;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/follow/QQLiveFollowGuidePart$a;", "", "", "DIALOG_HEIGHT_IN_PORTRAIT", "I", "DIALOG_WIDTH_IN_LANDSCAPE", "FROM_SEND_GIFT", "FROM_SEND_MSG", "FROM_STAY", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.follow.QQLiveFollowGuidePart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/follow/QQLiveFollowGuidePart$b", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements IQQLiveFollowCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveFollowGuidePart.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveFollowGuidePart", "fillData|follow", "follow fail, errCode=" + errCode + ", errMsg=" + errMsg);
            Dialog dialog = QQLiveFollowGuidePart.this.dialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|QQLiveFollowGuidePart", "fillData|follow", "follow success");
            Dialog dialog = QQLiveFollowGuidePart.this.dialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51873);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        C = wi2.c.b(244);
        D = wi2.c.b(224);
    }

    public QQLiveFollowGuidePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.follow.QQLiveFollowGuidePart$clearScreenViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFollowGuidePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) QQLiveFollowGuidePart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.clearScreenViewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void oa() {
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        Job job = this.showDialogJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        lj4.a.b();
        f F9 = F9();
        if (F9 != null) {
            F9.e(this);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Dialog pa(int from) {
        if (getContext().getResources().getConfiguration().orientation == 1) {
            return ra(from);
        }
        return qa(from);
    }

    @SuppressLint({"InflateParams"})
    private final Dialog qa(int from) {
        WindowManager.LayoutParams attributes;
        WindowManager.LayoutParams layoutParams = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hsv, (ViewGroup) null);
        ta(inflate, from);
        ReportDialog reportDialog = new ReportDialog(getContext(), R.style.a0h);
        reportDialog.requestWindowFeature(1);
        reportDialog.setContentView(inflate);
        reportDialog.setCanceledOnTouchOutside(true);
        Window window = reportDialog.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.gravity = 5;
            attributes.width = C;
            attributes.height = -1;
            layoutParams = attributes;
        }
        Window window2 = reportDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
        return reportDialog;
    }

    @SuppressLint({"InflateParams"})
    private final Dialog ra(int from) {
        WindowManager.LayoutParams attributes;
        WindowManager.LayoutParams layoutParams = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hsu, (ViewGroup) null);
        ta(inflate, from);
        ReportDialog reportDialog = new ReportDialog(getContext(), R.style.a0f);
        reportDialog.requestWindowFeature(1);
        reportDialog.setContentView(inflate);
        reportDialog.setCanceledOnTouchOutside(true);
        Window window = reportDialog.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = D;
            layoutParams = attributes;
        }
        Window window2 = reportDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
        return reportDialog;
    }

    private final void sa(int from) {
        Job job = this.showDialogJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        this.showDialogJob = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenResumed(new QQLiveFollowGuidePart$doShowDialog$1(from, this, null));
    }

    private final void ta(View rootView, int from) {
        ImageView imageView;
        TextView textView;
        TextView textView2 = null;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.snr);
        } else {
            imageView = null;
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(A9()).setTargetView(imageView));
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.soq);
        }
        if (textView2 != null) {
            textView2.setText(B9());
        }
        if (rootView != null && (textView = (TextView) rootView.findViewById(R.id.vcn)) != null) {
            RFWTypefaceUtil.setNumberTypeface(textView, false);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.follow.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQLiveFollowGuidePart.ua(QQLiveFollowGuidePart.this, view);
                }
            });
            QQLiveDaTongParams qQLiveDaTongParams = new QQLiveDaTongParams();
            qQLiveDaTongParams.s(String.valueOf(from));
            com.tencent.mobileqq.qqlive.sail.report.a.f272382a.b(textView, true, null, "em_qqlive_focus_page", qQLiveDaTongParams.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(QQLiveFollowGuidePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.R9()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveFollowGuidePart", "fillData|follow", "no in room");
        } else {
            TGLiveFollowManager.f377684a.h(null, this$0.C9(), this$0.H9(), new b());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a va() {
        Object value = this.clearScreenViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-clearScreenViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.clearscreen.a) value;
    }

    private final void wa(final int from) {
        if (!this.shouldShowGuide) {
            return;
        }
        if (TGLiveFollowManager.f377684a.n(C9())) {
            QLog.d("Audience|QQLiveFollowGuidePart", 1, "tryShowGuide already followed");
            return;
        }
        QLog.d("Audience|QQLiveFollowGuidePart", 1, "tryShowGuide from=" + from);
        if (lj4.a.a()) {
            lj4.a.d(new a.InterfaceC10728a() { // from class: com.tencent.mobileqq.qqlive.sail.ui.follow.a
                @Override // lj4.a.InterfaceC10728a
                public final void show() {
                    QQLiveFollowGuidePart.xa(QQLiveFollowGuidePart.this, from);
                }
            });
        } else {
            sa(from);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(QQLiveFollowGuidePart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        lj4.a.b();
        this$0.sa(i3);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.U9();
        f F9 = F9();
        if (F9 != null) {
            if (!d.f414903a.i(F9.getRoomId())) {
                QLog.d("Audience|QQLiveFollowGuidePart", 1, "onEnterRoom shouldShowGuide false");
                return;
            }
            F9.p(167, this);
            F9.p(235, this);
            SimpleEventBus.getInstance().registerReceiver(this);
            wa(0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Audience|QQLiveFollowGuidePart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.V9();
            oa();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<UserSelfSendMsgEvent>> getEventClass() {
        ArrayList<Class<UserSelfSendMsgEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UserSelfSendMsgEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            oa();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        e m3 = com.tencent.mobileqq.qqlive.sail.push.a.m(msgInfo);
        if (m3 != null && m3.f417554e == M9()) {
            wa(1);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
        } else if ((event instanceof UserSelfSendMsgEvent) && ((UserSelfSendMsgEvent) event).getRoomId() == H9()) {
            wa(2);
        }
    }
}
