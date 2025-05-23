package com.tencent.mobileqq.troop.homework.notice.detail.part;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.ColorNickTextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.troop.homework.notice.list.event.HWNoticeListUpdateEvent;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.ConfirmGroupSchoolNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.ConfirmGroupSchoolNoticeRsp;
import com.tencent.qqnt.kernel.nativeinterface.IConfirmGroupSchoolNoticeCallback;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001fR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010&\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/part/HWDetailConfirmPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/qqnt/kernel/nativeinterface/IConfirmGroupSchoolNoticeCallback;", "Lcom/tencent/mobileqq/troop/homework/notice/detail/data/a;", "confirmedInfo", "", "K9", "M9", "", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "errCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/ConfirmGroupSchoolNoticeRsp;", "rsp", "onResult", "Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/a;", "d", "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/a;", "viewModel", "e", "F9", "()Ljava/lang/String;", "troopUin", "f", "E9", "noticeId", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "button", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "confirmedInfoLayout", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "confirmedAvatarView", "Lcom/tencent/mobileqq/qqui/widget/ColorNickTextView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqui/widget/ColorNickTextView;", "confirmedNickNameTextView", "D", "confirmedDateTextView", "<init>", "()V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWDetailConfirmPart extends Part implements IConfirmGroupSchoolNoticeCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private ColorNickTextView confirmedNickNameTextView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView confirmedDateTextView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy noticeId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView button;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewGroup confirmedInfoLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView confirmedAvatarView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/part/HWDetailConfirmPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailConfirmPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53018);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWDetailConfirmPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.a>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailConfirmPart$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDetailConfirmPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    HWDetailConfirmPart hWDetailConfirmPart = HWDetailConfirmPart.this;
                    Intent intent = hWDetailConfirmPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.troop.homework.notice.detail.g.a(hWDetailConfirmPart, intent);
                }
            });
            this.viewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailConfirmPart$troopUin$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDetailConfirmPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    String stringExtra = HWDetailConfirmPart.this.getActivity().getIntent().getStringExtra("TROOP_UIN");
                    return stringExtra == null ? "0" : stringExtra;
                }
            });
            this.troopUin = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailConfirmPart$noticeId$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDetailConfirmPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    String stringExtra = HWDetailConfirmPart.this.getActivity().getIntent().getStringExtra("NOTICE_ID");
                    return stringExtra == null ? "0" : stringExtra;
                }
            });
            this.noticeId = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final String E9() {
        return (String) this.noticeId.getValue();
    }

    private final String F9() {
        return (String) this.troopUin.getValue();
    }

    private final com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.a G9() {
        return (com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.a) this.viewModel.getValue();
    }

    private final boolean H9(com.tencent.mobileqq.troop.homework.notice.detail.data.a confirmedInfo) {
        if (confirmedInfo.a() != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(int i3, HWDetailConfirmPart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            QQToast.makeText(this$0.getActivity(), 2, "\u786e\u8ba4\u6210\u529f", 0).show();
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String noticeId = this$0.E9();
            Intrinsics.checkNotNullExpressionValue(noticeId, "noticeId");
            simpleEventBus.dispatchEvent(new HWNoticeListUpdateEvent.NoticeConfirmed(noticeId));
            Activity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        QQToast.makeText(this$0.getContext(), 1, "\u786e\u8ba4\u5931\u8d25", 0).show();
        QLog.e("HWDetailConfirmPart", 1, "Failure on confirm, errCode: " + i3 + ", errMsg: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(com.tencent.mobileqq.troop.homework.notice.detail.data.a confirmedInfo) {
        TextView textView;
        TextView textView2 = null;
        if (H9(confirmedInfo)) {
            TextView textView3 = this.button;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("button");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility(8);
            return;
        }
        TextView textView4 = this.button;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            textView4 = null;
        }
        textView4.setVisibility(0);
        TextView textView5 = this.button;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            textView5 = null;
        }
        textView5.setText(getContext().getString(R.string.f2339978r));
        TextView textView6 = this.button;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            textView6 = null;
        }
        textView6.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.lwy));
        TextView textView7 = this.button;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            textView7 = null;
        }
        textView7.setTextColor(getContext().getColor(R.color.qui_button_text_primary_default));
        TextView textView8 = this.button;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            textView8 = null;
        }
        textView8.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HWDetailConfirmPart.L9(HWDetailConfirmPart.this, view);
            }
        });
        com.tencent.mobileqq.troop.homework.notice.report.a aVar = com.tencent.mobileqq.troop.homework.notice.report.a.f297331a;
        TextView textView9 = this.button;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            textView = null;
        } else {
            textView = textView9;
        }
        h.a.m(aVar, textView, "em_group_confirm_btn", ExposurePolicy.REPORT_NONE, null, null, null, 56, null);
        TextView textView10 = this.button;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
        } else {
            textView2 = textView10;
        }
        aVar.f(textView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(HWDetailConfirmPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        r groupSchoolService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupSchoolService();
        if (groupSchoolService != null) {
            String E9 = this$0.E9();
            String troopUin = this$0.F9();
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
            groupSchoolService.confirmGroupSchoolNotice(new ConfirmGroupSchoolNoticeReq(E9, Long.parseLong(troopUin)), this$0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [android.view.ViewGroup] */
    public final void M9(com.tencent.mobileqq.troop.homework.notice.detail.data.a confirmedInfo) {
        TextView textView = null;
        if (!H9(confirmedInfo)) {
            ?? r85 = this.confirmedInfoLayout;
            if (r85 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmedInfoLayout");
            } else {
                textView = r85;
            }
            textView.setVisibility(8);
            return;
        }
        ViewGroup viewGroup = this.confirmedInfoLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmedInfoLayout");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
        QQProAvatarView qQProAvatarView = this.confirmedAvatarView;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmedAvatarView");
            qQProAvatarView = null;
        }
        qQProAvatarView.x(1, confirmedInfo.b(), null);
        TextView textView2 = this.confirmedDateTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmedDateTextView");
        } else {
            textView = textView2;
        }
        textView.setText(new SimpleDateFormat("MM\u6708dd\u65e5HH:mm\u5df2\u786e\u8ba4").format(new Date(confirmedInfo.a() * 1000)));
        HWNoticeUtils hWNoticeUtils = HWNoticeUtils.f297171a;
        String b16 = confirmedInfo.b();
        String troopUin = F9();
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        hWNoticeUtils.e(b16, troopUin, "HWDetailConfirmPart", new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailConfirmPart$updateConfirmedInfoUI$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWDetailConfirmPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String nickName) {
                ColorNickTextView colorNickTextView;
                ColorNickTextView colorNickTextView2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) nickName);
                    return;
                }
                Intrinsics.checkNotNullParameter(nickName, "nickName");
                SpannableString spannableStringFromColorNickText = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(nickName, 12);
                colorNickTextView = HWDetailConfirmPart.this.confirmedNickNameTextView;
                ColorNickTextView colorNickTextView3 = null;
                if (colorNickTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("confirmedNickNameTextView");
                    colorNickTextView = null;
                }
                colorNickTextView.setText(spannableStringFromColorNickText);
                IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                colorNickTextView2 = HWDetailConfirmPart.this.confirmedNickNameTextView;
                if (colorNickTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("confirmedNickNameTextView");
                } else {
                    colorNickTextView3 = colorNickTextView2;
                }
                iChatSettingForTroopApi.setColorText(peekAppRuntime, colorNickTextView3, spannableStringFromColorNickText);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f72793rt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.remind_confirm_btn)");
        this.button = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.u4l);
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        viewGroup.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Vi\u2026ity = View.GONE\n        }");
        this.confirmedInfoLayout = viewGroup;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmedInfoLayout");
            viewGroup = null;
        }
        View findViewById3 = viewGroup.findViewById(R.id.a2o);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "confirmedInfoLayout.findViewById(R.id.avatar)");
        this.confirmedAvatarView = (QQProAvatarView) findViewById3;
        ViewGroup viewGroup3 = this.confirmedInfoLayout;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmedInfoLayout");
            viewGroup3 = null;
        }
        View findViewById4 = viewGroup3.findViewById(R.id.f9d);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "confirmedInfoLayout.findViewById(R.id.nick_name)");
        this.confirmedNickNameTextView = (ColorNickTextView) findViewById4;
        ViewGroup viewGroup4 = this.confirmedInfoLayout;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmedInfoLayout");
        } else {
            viewGroup2 = viewGroup4;
        }
        View findViewById5 = viewGroup2.findViewById(R.id.bdk);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "confirmedInfoLayout.findViewById(R.id.date)");
        this.confirmedDateTextView = (TextView) findViewById5;
        LiveData<com.tencent.mobileqq.troop.homework.notice.detail.data.a> L1 = G9().L1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.notice.detail.data.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.notice.detail.data.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailConfirmPart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDetailConfirmPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.notice.detail.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.notice.detail.data.a confirmedInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) confirmedInfo);
                    return;
                }
                HWDetailConfirmPart hWDetailConfirmPart = HWDetailConfirmPart.this;
                Intrinsics.checkNotNullExpressionValue(confirmedInfo, "confirmedInfo");
                hWDetailConfirmPart.K9(confirmedInfo);
                HWDetailConfirmPart.this.M9(confirmedInfo);
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWDetailConfirmPart.I9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IConfirmGroupSchoolNoticeCallback
    public void onResult(final int errCode, @Nullable final String errMsg, @Nullable ConfirmGroupSchoolNoticeRsp rsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(errCode), errMsg, rsp);
        } else {
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.b
                @Override // java.lang.Runnable
                public final void run() {
                    HWDetailConfirmPart.J9(errCode, this, errMsg);
                }
            });
        }
    }
}
