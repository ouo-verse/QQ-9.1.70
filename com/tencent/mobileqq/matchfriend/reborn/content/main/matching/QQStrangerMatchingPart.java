package com.tencent.mobileqq.matchfriend.reborn.content.main.matching;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchingPart;
import com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl.GrayCtrl$GameInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 `2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001aB\u0007\u00a2\u0006\u0004\b^\u0010_J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00160\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\"\u0010*\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0002J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+2\u0006\u0010'\u001a\u00020&H\u0002J\u001d\u0010.\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020&H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u000eH\u0002J\b\u00103\u001a\u00020\u0006H\u0002J\b\u00104\u001a\u00020\u0006H\u0002J\b\u00105\u001a\u00020\u0006H\u0002R\u0018\u00108\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010=\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010<R\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00107R\u0018\u0010J\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010<R\u0018\u0010L\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010<R\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010Z\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchingPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/content/Intent;", "newIntent", "onNewIntent", "", "onBackEvent", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Ljava/lang/Runnable;", "runnable", "runOnActivityUiThread", "P9", "Lcom/tencent/trpcprotocol/kuolie/gray_ctrl/gray_ctrl/GrayCtrl$GameInfo;", "info", "N9", "Y9", "L9", "ba", "X9", "aa", "Landroid/widget/ImageView;", "view", "", "url", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "W9", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "pagImageView", "M9", "J9", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "O9", "intent", "I9", "K9", "U9", "V9", "d", "Landroid/view/View;", "mMatchAreaLayout", "e", "mMatchChatView", "f", "Landroid/widget/ImageView;", "mMatchChatFgView", tl.h.F, "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "mMatchChatPagView", "i", "mMatchChatBgView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/i;", "mMatchChatHelper", BdhLogUtil.LogTag.Tag_Conn, "mMatchVoiceView", "D", "mMatchVoiceFgView", "E", "mMatchVoiceBgView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/ak;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/ak;", "mMatchVoiceHelper", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "mMatchChatTipsView", "Ll82/e;", "H", "Ll82/e;", "matchChatGuideElement", "I", "Z", "showMatchChatPagAnim", "J", "firstOnLayoutAdded", "<init>", "()V", "K", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMatchingPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: K, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int L = 20;
    private static boolean M;

    /* renamed from: C, reason: from kotlin metadata */
    private View mMatchVoiceView;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mMatchVoiceFgView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mMatchVoiceBgView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mMatchChatTipsView;

    /* renamed from: H, reason: from kotlin metadata */
    private l82.e matchChatGuideElement;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mMatchAreaLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mMatchChatView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mMatchChatFgView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private VasPagImageView mMatchChatPagView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mMatchChatBgView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final i mMatchChatHelper = new i();

    /* renamed from: F, reason: from kotlin metadata */
    private final ak mMatchVoiceHelper = new ak();

    /* renamed from: I, reason: from kotlin metadata */
    private boolean showMatchChatPagAnim = true;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean firstOnLayoutAdded = true;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\bR\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchingPart$a;", "", "Landroid/content/Context;", "context", "", "b", "", "remainPlayTime", "I", "e", "()I", "setRemainPlayTime", "(I)V", "matchChatEnable", "Z", "d", "()Z", "f", "(Z)V", "", "REPORT_ELE_ENTRY", "Ljava/lang/String;", "REPORT_ELE_ENTRY_TYPE", "REPORT_ENTRY_TYPE_CHAT", "REPORT_ENTRY_TYPE_VOICE", "sourceIdImmediateMatch", "sourceIdVoiceMatch", "tag", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchingPart$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerJumpHomePageEvent());
        }

        @JvmStatic
        public final boolean b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (e() > 0) {
                return true;
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, "\u4eca\u65e5\u5339\u914d\u6b21\u6570\u5df2\u7528\u5c3d", "\u5feb\u53bb\u540c\u9891\u5e7f\u573a\u627e\u540c\u597d\u5427", (String) null, "\u53bb\u770b\u770b", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.aq
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQStrangerMatchingPart.Companion.c(dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null);
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026                 }, null)");
            createCustomDialog.show();
            ViewGroup rootView = createCustomDialog.getRootView();
            if (rootView == null) {
                return false;
            }
            VideoReport.setElementId(rootView, "em_kl_new_home_page_limit_win");
            Activity activity = context instanceof Activity ? (Activity) context : null;
            View findViewById = activity != null ? activity.findViewById(R.id.opc) : null;
            if (findViewById == null) {
                return false;
            }
            VideoReport.setLogicParent(rootView, findViewById);
            VideoReport.setElementParam(rootView, "kl_new_home_window_type", 2);
            VideoReport.reportEvent("dt_imp", rootView, new HashMap());
            return false;
        }

        public final boolean d() {
            return QQStrangerMatchingPart.M;
        }

        public final int e() {
            return QQStrangerMatchingPart.L;
        }

        public final void f(boolean z16) {
            QQStrangerMatchingPart.M = z16;
        }

        Companion() {
        }
    }

    private final void I9(Intent intent) {
        boolean z16 = false;
        int intExtra = intent.getIntExtra("key_action_type", 0);
        QLog.d("QQStrangerMatchingPart", 1, "checkAutoStartMatch actionType=" + intExtra);
        if (intExtra != 1) {
            if (intExtra != 2) {
                return;
            }
            View view = this.mMatchVoiceView;
            if (view != null && view.getVisibility() == 0) {
                z16 = true;
            }
            if (!z16 || QQStrangerGuestHelper.f245363a.b(getContext())) {
                return;
            }
            this.mMatchVoiceHelper.start();
            return;
        }
        View view2 = this.mMatchChatView;
        if (view2 != null && view2.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            Companion companion = INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (!companion.b(context) || QQStrangerGuestHelper.f245363a.b(getContext())) {
                return;
            }
            this.mMatchChatHelper.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object J9(String str, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QQPicLoader.f201806a.d().download(Option.obtainDownloadOption().setUrl(str), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchingPart$download$2$1
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QLog.d("QQStrangerMatchingPart", 1, "download onStateChange " + loadState + " option:" + option);
                if (loadState == LoadState.STATE_DOWNLOAD_SUCCESS) {
                    cancellableContinuationImpl.resume(QQPicLoader.f201806a.d().getPicLocalPath(option), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchingPart$download$2$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                } else if (loadState == LoadState.STATE_DOWNLOAD_FAILED) {
                    cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchingPart$download$2$1.2
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final void K9() {
        View view = this.mMatchChatView;
        if (view != null) {
            VideoReport.setElementId(view, "em_kl_new_home_page_entrance");
            VideoReport.setElementParam(view, "kl_new_entrance_id", 1);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        }
        View view2 = this.mMatchVoiceView;
        if (view2 != null) {
            VideoReport.setElementId(view2, "em_kl_new_home_page_entrance");
            VideoReport.setElementParam(view2, "kl_new_entrance_id", 2);
            VideoReport.setElementClickPolicy(view2, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view2, ExposurePolicy.REPORT_ALL);
        }
    }

    private final void L9() {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        l82.e eVar = new l82.e(activity, this.mMatchChatView, new Function2<VasPagImageView, String, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchingPart$initElement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(VasPagImageView vasPagImageView, String str) {
                invoke2(vasPagImageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(VasPagImageView pagImageView, String url) {
                Intrinsics.checkNotNullParameter(pagImageView, "pagImageView");
                Intrinsics.checkNotNullParameter(url, "url");
                QQStrangerMatchingPart.this.M9(pagImageView, url);
            }
        });
        this.matchChatGuideElement = eVar;
        m82.a aVar = m82.a.f416439a;
        aVar.b().addElement(eVar);
        aVar.b().notifyGroupActivate(eVar, RFWOrderElementManager.OrderMode.WAIT_MODE, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(VasPagImageView pagImageView, String url) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        IPartHost partHost = getPartHost();
        if (partHost == null || (lifecycleOwner = partHost.getLifecycleOwner()) == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        CorountineFunKt.e(lifecycleScope, "QQStrangerMatchingPart", Boolean.FALSE, null, null, new QQStrangerMatchingPart$loadPag$1(this, url, pagImageView, null), 12, null);
    }

    private final void N9(GrayCtrl$GameInfo info) {
        QLog.i("QQStrangerMatchingPart", 1, "onGetMatchChatEntranceInfo,remain_times=" + info.play_time.get());
        L = info.play_time.get();
        Y9();
    }

    private final void O9(GrayCtrl$GameInfo info) {
        QLog.i("QQStrangerMatchingPart", 1, "onGetMatchVoiceEntranceInfo,max_loading_times=" + info.max_loading_time.get());
    }

    private final void P9(View rootView) {
        super.onInitView(rootView);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f158728ni);
        this.mMatchAreaLayout = rootView.findViewById(R.id.oom);
        i iVar = this.mMatchChatHelper;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        iVar.A(activity);
        ak akVar = this.mMatchVoiceHelper;
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        akVar.M(activity2);
        this.mMatchChatView = rootView.findViewById(R.id.oou);
        this.mMatchChatFgView = (ImageView) rootView.findViewById(R.id.oow);
        this.mMatchChatPagView = (VasPagImageView) rootView.findViewById(R.id.ooy);
        this.mMatchChatBgView = (ImageView) rootView.findViewById(R.id.oov);
        View view = this.mMatchChatView;
        RoundRelativeLayout roundRelativeLayout = view instanceof RoundRelativeLayout ? (RoundRelativeLayout) view : null;
        if (roundRelativeLayout != null) {
            roundRelativeLayout.f316195e = dimensionPixelSize;
        }
        if (view != null) {
            com.tencent.mobileqq.matchfriend.reborn.utils.r.c(view, 0.0f, 1, null);
        }
        View view2 = this.mMatchChatView;
        if (view2 != null) {
            view2.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.an
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    QQStrangerMatchingPart.Q9(QQStrangerMatchingPart.this, view3);
                }
            }, 1, null)));
        }
        this.mMatchChatTipsView = (TextView) rootView.findViewById(R.id.ooz);
        this.mMatchVoiceView = rootView.findViewById(R.id.f163173op2);
        this.mMatchVoiceFgView = (ImageView) rootView.findViewById(R.id.f163175op4);
        this.mMatchVoiceBgView = (ImageView) rootView.findViewById(R.id.f163174op3);
        View view3 = this.mMatchVoiceView;
        RoundRelativeLayout roundRelativeLayout2 = view3 instanceof RoundRelativeLayout ? (RoundRelativeLayout) view3 : null;
        if (roundRelativeLayout2 != null) {
            roundRelativeLayout2.f316195e = dimensionPixelSize;
        }
        if (view3 != null) {
            com.tencent.mobileqq.matchfriend.reborn.utils.r.c(view3, 0.0f, 1, null);
        }
        View view4 = this.mMatchVoiceView;
        if (view4 != null) {
            view4.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(1000, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.ao
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    QQStrangerMatchingPart.R9(QQStrangerMatchingPart.this, view5);
                }
            })));
        }
        Y9();
        aa();
        ba();
        L9();
        K9();
        if (this.firstOnLayoutAdded) {
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.ap
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerMatchingPart.S9(QQStrangerMatchingPart.this);
                }
            }, 500L);
        }
        this.firstOnLayoutAdded = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QQStrangerMatchingPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion companion = INSTANCE;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (companion.b(context)) {
            this$0.mMatchChatHelper.start();
        }
        this$0.U9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QQStrangerMatchingPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mMatchVoiceHelper.start();
        this$0.V9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QQStrangerMatchingPart this$0) {
        Intent intent;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        this$0.I9(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(QQStrangerMatchingPart this$0, Ref.BooleanRef hasMatchChat, Ref.BooleanRef hasMatchVoice) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hasMatchChat, "$hasMatchChat");
        Intrinsics.checkNotNullParameter(hasMatchVoice, "$hasMatchVoice");
        View view = this$0.mMatchChatView;
        int i3 = 0;
        if (view != null) {
            view.setVisibility(hasMatchChat.element ? 0 : 8);
        }
        View view2 = this$0.mMatchVoiceView;
        if (view2 != null) {
            view2.setVisibility(hasMatchVoice.element ? 0 : 8);
        }
        View view3 = this$0.mMatchAreaLayout;
        if (view3 == null) {
            return;
        }
        if (!hasMatchChat.element && !hasMatchVoice.element) {
            i3 = 8;
        }
        view3.setVisibility(i3);
    }

    private final void U9() {
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_entrance_id", 1);
        VideoReport.reportEvent("dt_clck", this.mMatchChatView, hashMap);
    }

    private final void V9() {
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_entrance_id", 2);
        VideoReport.reportEvent("dt_clck", this.mMatchVoiceView, hashMap);
    }

    private final void W9(ImageView view, String url, Drawable defaultDrawable) {
        Option loadingDrawable = Option.obtain().setTargetView(view).setUrl(url).setLoadingDrawable(defaultDrawable == null ? new ColorDrawable(0) : defaultDrawable);
        if (defaultDrawable == null) {
            defaultDrawable = new ColorDrawable(0);
        }
        Option option = loadingDrawable.setFailDrawable(defaultDrawable);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, null);
    }

    private final void X9() {
        if (this.showMatchChatPagAnim) {
            ImageView imageView = this.mMatchChatFgView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            VasPagImageView vasPagImageView = this.mMatchChatPagView;
            if (vasPagImageView != null) {
                vasPagImageView.setVisibility(0);
                M9(vasPagImageView, "https://downv6.qq.com/extendfriend/qqstranger_match_chat_entry.pag");
                return;
            }
            return;
        }
        VasPagImageView vasPagImageView2 = this.mMatchChatPagView;
        if (vasPagImageView2 != null) {
            vasPagImageView2.setVisibility(8);
        }
        ImageView imageView2 = this.mMatchChatFgView;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        ImageView imageView3 = this.mMatchChatFgView;
        if (imageView3 != null) {
            W9(imageView3, "https://downv6.qq.com/extendfriend/qqstranger_match_chat_fg.png", null);
        }
    }

    private final void Y9() {
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.am
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerMatchingPart.Z9(QQStrangerMatchingPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(QQStrangerMatchingPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("\u4eca\u65e5\u5269\u4f59%s\u6b21", Arrays.copyOf(new Object[]{Integer.valueOf(L)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        if (L <= 0) {
            format = "\u4eca\u65e5\u6682\u65e0\u5339\u914d\u6b21\u6570";
        }
        TextView textView = this$0.mMatchChatTipsView;
        if (textView != null) {
            textView.setText(format);
        }
        l82.e eVar = this$0.matchChatGuideElement;
        if (eVar != null) {
            eVar.g(format);
        }
    }

    private final void aa() {
        ImageView imageView = this.mMatchChatBgView;
        if (imageView != null) {
            W9(imageView, "https://downv6.qq.com/extendfriend/kl_immediate_match_bg.png", ContextCompat.getDrawable(getContext(), R.drawable.g2e));
        }
        ImageView imageView2 = this.mMatchVoiceBgView;
        if (imageView2 != null) {
            W9(imageView2, "https://downv6.qq.com/extendfriend/kl_voice_match_bg.png", ContextCompat.getDrawable(getContext(), R.drawable.g3o));
        }
    }

    private final void ba() {
        X9();
        ImageView imageView = this.mMatchVoiceFgView;
        if (imageView != null) {
            W9(imageView, "https://downv6.qq.com/extendfriend/qqstranger_match_voice_fg_9060.png", null);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QQStrangerGameInfoUpdateEvent.class);
        arrayList.add(QQStrangerMatchLayoutCreateEvent.class);
        arrayList.add(QQStrangerMatchChatSuccessEvent.class);
        arrayList.add(QQStrangerMatchVoiceDismissLoadingEvent.class);
        arrayList.add(QQStrangerShowMatchChatAnimEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        boolean k3 = !this.mMatchChatHelper.j() ? this.mMatchChatHelper.k() : false;
        if (!this.mMatchVoiceHelper.t()) {
            k3 = k3 || this.mMatchVoiceHelper.u();
        }
        if (k3) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent newIntent) {
        super.onNewIntent(newIntent);
        if (newIntent != null) {
            I9(newIntent);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.mMatchChatHelper.n();
        this.mMatchVoiceHelper.y();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        l82.e eVar = this.matchChatGuideElement;
        if (eVar != null) {
            m82.a.f416439a.b().inactivateElement((IOrderElement) eVar, false);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QQStrangerGameInfoUpdateEvent) {
            Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("gameInfos");
            List<GrayCtrl$GameInfo> list = a16 instanceof List ? (List) a16 : null;
            if (list == null) {
                return;
            }
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            for (GrayCtrl$GameInfo grayCtrl$GameInfo : list) {
                int i3 = grayCtrl$GameInfo.game_id.get();
                if (i3 == 1) {
                    booleanRef.element = true;
                    M = true;
                    N9(grayCtrl$GameInfo);
                } else if (i3 == 2) {
                    booleanRef2.element = true;
                    O9(grayCtrl$GameInfo);
                }
            }
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.al
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerMatchingPart.T9(QQStrangerMatchingPart.this, booleanRef, booleanRef2);
                }
            });
            return;
        }
        if (event instanceof QQStrangerMatchLayoutCreateEvent) {
            P9(((QQStrangerMatchLayoutCreateEvent) event).getRootView());
            return;
        }
        if (event instanceof QQStrangerMatchChatSuccessEvent) {
            L--;
            Y9();
            QLog.i("QQStrangerMatchingPart", 1, "receive QQStrangerMatchChatSuccessEvent, times -1");
            return;
        }
        if (event instanceof QQStrangerMatchVoiceDismissLoadingEvent) {
            QLog.i("QQStrangerMatchingPart", 1, "receive QQStrangerMatchVoiceDismissLoadingEvent.");
            try {
                this.mMatchVoiceHelper.n();
                this.mMatchVoiceHelper.q();
                return;
            } catch (Exception e16) {
                QLog.e("QQStrangerMatchingPart", 1, "QQStrangerMatchVoiceDismissLoadingEvent error", e16);
                return;
            }
        }
        if (event instanceof QQStrangerShowMatchChatAnimEvent) {
            QQStrangerShowMatchChatAnimEvent qQStrangerShowMatchChatAnimEvent = (QQStrangerShowMatchChatAnimEvent) event;
            if (qQStrangerShowMatchChatAnimEvent.getShow() == this.showMatchChatPagAnim) {
                return;
            }
            this.showMatchChatPagAnim = qQStrangerShowMatchChatAnimEvent.getShow();
            X9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean runOnActivityUiThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.run();
            return true;
        }
        return super.runOnActivityUiThread(runnable);
    }
}
