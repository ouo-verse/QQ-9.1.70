package com.tencent.mobileqq.setting.generalSetting.subChatSetting;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.aio.DoutuConfParser;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment;
import com.tencent.mobileqq.settings.message.ao;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dr;
import com.tencent.mobileqq.vas.qqmc.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import com.tencent.qqnt.doutu.api.IDoutuService;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.util.URLUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 @2\u00020\u0001:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?JH\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\b\b\u0000\u0010\u0003*\u00020\u0002\"\b\b\u0001\u0010\u0005*\u00020\u0004*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\f\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\f\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0002J\u000e\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0002J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0012\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010'\u001a\u00020\bH\u0016J\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(\u00a2\u0006\u0004\b*\u0010+R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00104R\u0018\u00108\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00104R\u001a\u0010=\u001a\u00020\u001a8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/setting/generalSetting/subChatSetting/SubChatSettingFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lkotlin/Function0;", "", "onExpo", "vi", "Lcom/tencent/mobileqq/widget/listitem/a;", "mi", "", "li", "Ai", "ai", "zi", "Zh", "xi", "Yh", "di", "bi", "Di", "hi", "Vh", "", "switchId", "isChecked", SensorJsPlugin.SENSOR_INTERVAL_UI, "ti", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Wh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Xh", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/setting/generalSetting/subChatSetting/SubChatSettingVM;", "J", "Lkotlin/Lazy;", "ki", "()Lcom/tencent/mobileqq/setting/generalSetting/subChatSetting/SubChatSettingVM;", "subChatSettingVM", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "K", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "sVipPayDialog", "pttAutoTipsDialog", "M", "experiencePttAutoDialog", "N", "Ljava/lang/String;", "getPAGE_ID", "()Ljava/lang/String;", "PAGE_ID", "<init>", "()V", "P", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SubChatSettingFragment extends BaseSettingFragment {

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy subChatSettingVM;

    /* renamed from: K, reason: from kotlin metadata */
    private QQCustomDialog sVipPayDialog;

    /* renamed from: L, reason: from kotlin metadata */
    private QQCustomDialog pttAutoTipsDialog;

    /* renamed from: M, reason: from kotlin metadata */
    private QQCustomDialog experiencePttAutoDialog;

    /* renamed from: N, reason: from kotlin metadata */
    private final String PAGE_ID;

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/setting/generalSetting/subChatSetting/SubChatSettingFragment$b", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "view", "", "position", "", "", "payloads", "", "P", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends x<x.b.d, x.c.f> {
        b(x.b.d dVar, x.c.f fVar) {
            super(dVar, fVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
        /* renamed from: P */
        public void F(QUISingleLineListItem view, int position, List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            super.F(view, position, payloads);
            TextView textView = (TextView) view.findViewById(R.id.f66203a0);
            if (textView != null) {
                textView.setContentDescription(BaseApplication.getContext().getString(R.string.d4x) + " vip\u4f1a\u5458\u53ef\u7528");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
        /* renamed from: Q */
        public QUISingleLineListItem H(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            QUISingleLineListItem H = super.H(parent);
            if (QVipAutoPttConfig.INSTANCE.getStage() > 1) {
                ImageView imageView = new ImageView(parent.getContext());
                imageView.setImageResource(R.drawable.num);
                imageView.setContentDescription("SVIP");
                FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(-2, -2);
                layoutParams.b(0.0f);
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = ViewUtils.dpToPx(4.0f);
                imageView.setLayoutParams(layoutParams);
                H.c(imageView);
            }
            return H;
        }
    }

    public SubChatSettingFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SubChatSettingVM>() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment$subChatSettingVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SubChatSettingVM invoke() {
                return (SubChatSettingVM) SubChatSettingFragment.this.getViewModel(SubChatSettingVM.class);
            }
        });
        this.subChatSettingVM = lazy;
        this.PAGE_ID = "pg_bas_chat";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ai() {
        if (getActivity() == null || requireActivity().isFinishing() || requireActivity().isDestroyed()) {
            return;
        }
        ai();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 0, HardCodeUtil.qqStr(R.string.js7), HardCodeUtil.qqStr(R.string.jsa), R.string.d2d, R.string.d2e, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SubChatSettingFragment.Bi(SubChatSettingFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SubChatSettingFragment.Ci(SubChatSettingFragment.this, dialogInterface, i3);
            }
        });
        this.sVipPayDialog = createCustomDialog;
        if (createCustomDialog != null) {
            try {
                createCustomDialog.show();
            } catch (Exception e16) {
                QLog.e("SubChatSettingFragment", 1, "showSVipPayDialog error:", e16);
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aid", "mvip.n.a.zdzwz");
        ki().e2("window", "open", "4", 101, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(SubChatSettingFragment this$0, DialogInterface dialogInterface, int i3) {
        String replace$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("vip_ptt.SubChatSettingFragment", 1, "click pay for auto ptt");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        String payUrl = QVipAutoPttConfig.INSTANCE.getPayUrl();
        if (!TextUtils.isEmpty(payUrl)) {
            replace$default = StringsKt__StringsJVMKt.replace$default(payUrl, "{aid}", "mvip.n.a.zdzwz", false, 4, (Object) null);
            dr.h(activity, replace$default);
        } else {
            dr.h(activity, "https://h5.vip.qq.com/p/pay/index?_wv=524289&_fv=0&type=!svip&aid=mvip.n.a.zdzwz");
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("aid", "mvip.n.a.zdzwz");
        this$0.ki().e2("window", "open", "4", 102, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci(SubChatSettingFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.ki().e2("window", "cancel", "4", 102, null);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Di() {
        if (!com.tencent.mobileqq.flashchat.e.d(Wh()).n(Wh()) || SimpleUIUtil.getSimpleUISwitch()) {
            return null;
        }
        boolean l3 = com.tencent.mobileqq.flashchat.e.d(Wh()).l();
        ui("em_bas_text_visual", l3);
        String string = getString(R.string.f242947vy);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.zhitu_switch_new)");
        return new x(new x.b.d(string), new x.c.f(l3, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SubChatSettingFragment.Ei(SubChatSettingFragment.this, compoundButton, z16);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ei(SubChatSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.flashchat.e.d(this$0.Wh()).q(z16, this$0.Wh());
        ao.a(this$0.Wh(), "0X800B87E", z16);
        this$0.ti("em_bas_text_visual", z16);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Vh() {
        IAssistedChatApi iAssistedChatApi = (IAssistedChatApi) QRoute.api(IAssistedChatApi.class);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        LifecycleOwner hostLifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner, "hostLifecycleOwner");
        return iAssistedChatApi.getAIServiceSettingConfig(requireActivity, hostLifecycleOwner, false, this.PAGE_ID, new Function1<com.tencent.mobileqq.widget.listitem.a<?>, Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment$aiServiceConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.a<?> aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.widget.listitem.a<?> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QUIListItemAdapter th5 = SubChatSettingFragment.this.th();
                if (th5 != null) {
                    th5.l0(it);
                }
            }
        });
    }

    private final void Yh() {
        QQCustomDialog qQCustomDialog = this.experiencePttAutoDialog;
        if (qQCustomDialog == null || !qQCustomDialog.isShowing()) {
            return;
        }
        qQCustomDialog.dismiss();
    }

    private final void Zh() {
        QQCustomDialog qQCustomDialog = this.pttAutoTipsDialog;
        if (qQCustomDialog == null || !qQCustomDialog.isShowing()) {
            return;
        }
        qQCustomDialog.dismiss();
    }

    private final void ai() {
        QQCustomDialog qQCustomDialog = this.sVipPayDialog;
        if (qQCustomDialog == null || !qQCustomDialog.isShowing()) {
            return;
        }
        qQCustomDialog.dismiss();
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> bi() {
        final IDoutuService iDoutuService;
        QQAppInterface Wh = Wh();
        if (Wh == null || (iDoutuService = (IDoutuService) Wh.getRuntimeService(IDoutuService.class)) == null) {
            return null;
        }
        QQAppInterface Wh2 = Wh();
        if (Wh2 != null) {
            iDoutuService.setApp(Wh2);
        }
        if (!iDoutuService.isDoutuConfigOpen()) {
            return null;
        }
        boolean isDoutuSettingOpen = iDoutuService.isDoutuSettingOpen();
        ui("em_bas_battle_chart", isDoutuSettingOpen);
        String string = getString(R.string.zt_);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.doutu_switch_new)");
        return vi(new x(new x.b.d(string), new x.c.f(isDoutuSettingOpen, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SubChatSettingFragment.ci(IDoutuService.this, this, compoundButton, z16);
            }
        })), new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment$doutuSwitchConfig$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ReportController.y(SubChatSettingFragment.this.Wh(), "0X800B81B");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(IDoutuService doutuService, SubChatSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(doutuService, "$doutuService");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        doutuService.updateDoutuSetting(z16);
        ao.a(this$0.Wh(), "0X800B87F", z16);
        this$0.ti("em_bas_battle_chart", z16);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> di() {
        IStickerRecManager iStickerRecManager;
        QQAppInterface Wh = Wh();
        final boolean z16 = false;
        if (Wh != null && (iStickerRecManager = (IStickerRecManager) Wh.getRuntimeService(IStickerRecManager.class)) != null && iStickerRecManager.isEmotionRecSettingOpen()) {
            z16 = true;
        }
        ui("em_bas_emoji_recommendation", z16);
        String string = getString(R.string.zv6);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.emotion_switch_new)");
        final x xVar = new x(new x.b.d(string), new x.c.f(z16, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.k
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                SubChatSettingFragment.ei(SubChatSettingFragment.this, compoundButton, z17);
            }
        }));
        vi(xVar, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment$emotionRecSwitchConfig$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ReportController.y(SubChatSettingFragment.this.Wh(), "0X800B819");
            }
        });
        ((x.c.f) xVar.O()).b(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.l
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                SubChatSettingFragment.fi(z16, view);
            }
        });
        MutableLiveData<Boolean> T1 = ki().T1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment$emotionRecSwitchConfig$2$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                x.c.f O = xVar.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(xVar);
                }
            }
        };
        T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubChatSettingFragment.gi(Function1.this, obj);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(SubChatSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        String str;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ki().i2(z16);
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("current_state", str));
        VideoReport.setElementParams(compoundButton, mapOf);
        this$0.ti("em_bas_emoji_recommendation", z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(boolean z16, View it) {
        String str;
        Map mapOf;
        Intrinsics.checkNotNullParameter(it, "it");
        VideoReport.setElementId(it, "em_bas_emoji_recommendation");
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("current_state", str));
        VideoReport.setElementParams(it, mapOf);
        VideoReport.setElementExposePolicy(it, ExposurePolicy.REPORT_FIRST);
        VideoReport.setElementClickPolicy(it, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> hi() {
        boolean l3 = com.tencent.mobileqq.flashchat.e.d(Wh()).l();
        String string = getString(R.string.hfj);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.set_enterkey_send)");
        x xVar = new x(new x.b.d(string), new x.c.f(l3, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.n
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SubChatSettingFragment.ii(SubChatSettingFragment.this, compoundButton, z16);
            }
        }));
        ((x.c.f) xVar.O()).f(SettingCloneUtil.readValue((Context) getActivity(), (String) null, getString(R.string.cyo), AppConstants.QQSETTING_ENTER_SENDMSG_KEY, false));
        ((x.c.f) xVar.O()).h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SubChatSettingFragment.ji(SubChatSettingFragment.this, compoundButton, z16);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(SubChatSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.flashchat.e.d(this$0.Wh()).q(z16, this$0.Wh());
        ao.a(this$0.Wh(), "0X800B87E", z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(SubChatSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ao.a(this$0.Wh(), "0X800B874", z16);
        SettingCloneUtil.writeValue(this$0.getActivity(), (String) null, this$0.getString(R.string.cyo), AppConstants.QQSETTING_ENTER_SENDMSG_KEY, z16);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeBool(AppConstants.QQSETTING_ENTER_SENDMSG_KEY, z16);
    }

    private final SubChatSettingVM ki() {
        Object value = this.subChatSettingVM.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-subChatSettingVM>(...)");
        return (SubChatSettingVM) value;
    }

    private final boolean li() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        String string = arguments.getString("jump_source");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return TextUtils.equals(URLUtil.getArgumentsFromURL(string).get("busiid"), "audiototext");
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> mi() {
        ui("em_bas_voice_messages_to_text", ki().d2());
        String string = BaseApplication.getContext().getString(R.string.d4x);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R.string.ptt_auto_change)");
        final b bVar = new b(new x.b.d(string), new x.c.f(ki().d2(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.q
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SubChatSettingFragment.si(SubChatSettingFragment.this, compoundButton, z16);
            }
        }));
        vi(bVar, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment$pttAutoChangeConfig$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ReportController.y(SubChatSettingFragment.this.Wh(), "0X800B820");
            }
        });
        MutableLiveData<Boolean> U1 = ki().U1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment$pttAutoChangeConfig$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                x.c.f O = SubChatSettingFragment.b.this.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.f(it.booleanValue());
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(SubChatSettingFragment.b.this);
                }
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubChatSettingFragment.oi(Function1.this, obj);
            }
        });
        MutableLiveData<CharSequence> W1 = ki().W1();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<CharSequence, Unit> function12 = new Function1<CharSequence, Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment$pttAutoChangeConfig$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
                invoke2(charSequence);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CharSequence it) {
                x.b.d K = SubChatSettingFragment.b.this.K();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                K.b(it);
                QUIListItemAdapter th5 = this.th();
                if (th5 != null) {
                    th5.l0(SubChatSettingFragment.b.this);
                }
            }
        };
        W1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubChatSettingFragment.pi(Function1.this, obj);
            }
        });
        MutableLiveData<Unit> a26 = ki().a2();
        LifecycleOwner lifecycleOwner3 = getLifecycleOwner();
        final Function1<Unit, Unit> function13 = new Function1<Unit, Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment$pttAutoChangeConfig$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                SubChatSettingFragment.this.zi();
            }
        };
        a26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubChatSettingFragment.qi(Function1.this, obj);
            }
        });
        MutableLiveData<Unit> Z1 = ki().Z1();
        LifecycleOwner lifecycleOwner4 = getLifecycleOwner();
        final Function1<Unit, Unit> function14 = new Function1<Unit, Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment$pttAutoChangeConfig$1$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                SubChatSettingFragment.this.Ai();
            }
        };
        Z1.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubChatSettingFragment.ri(Function1.this, obj);
            }
        });
        MutableLiveData<Unit> X1 = ki().X1();
        LifecycleOwner lifecycleOwner5 = getLifecycleOwner();
        final Function1<Unit, Unit> function15 = new Function1<Unit, Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment$pttAutoChangeConfig$1$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                SubChatSettingFragment.this.xi();
            }
        };
        X1.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubChatSettingFragment.ni(Function1.this, obj);
            }
        });
        ki().m2(li());
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0() {
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(DoutuConfParser.INSTANCE.a());
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101220");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void si(SubChatSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ki().j2(z16);
        ao.a(this$0.Wh(), "0X800B884", z16);
        if (VasUtil.getSignedService(this$0.Wh()).getVipStatus().isVip()) {
            str = "vip";
        } else if (VasUtil.getSignedService(this$0.Wh()).getVipStatus().isSVip()) {
            str = "svip";
        } else {
            str = "normal";
        }
        String str2 = str;
        this$0.ti("em_bas_voice_messages_to_text", z16);
        ReportController.o(this$0.Wh(), "dc00898", "", "", "", "0X800A415", z16 ? 1 : 2, 0, "", "", "", str2);
    }

    private final void ti(String switchId, boolean isChecked) {
        com.tencent.qqnt.notification.report.h.z(this.PAGE_ID, switchId, Boolean.valueOf(isChecked), null, null, 24, null);
    }

    private final void ui(String switchId, boolean isChecked) {
        com.tencent.qqnt.notification.report.h.D(this.PAGE_ID, switchId, Boolean.valueOf(isChecked), null, null, 24, null);
    }

    private final <L extends x.b, R extends x.c> x<L, R> vi(x<L, R> xVar, final Function0<Unit> function0) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.i
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                SubChatSettingFragment.wi(Ref.BooleanRef.this, function0, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(Ref.BooleanRef firstExpo, Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(firstExpo, "$firstExpo");
        Intrinsics.checkNotNullParameter(it, "it");
        if (firstExpo.element) {
            firstExpo.element = false;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xi() {
        if (getActivity() == null || requireActivity().isFinishing() || requireActivity().isDestroyed()) {
            return;
        }
        Yh();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), HardCodeUtil.qqStr(R.string.f211705lj), HardCodeUtil.qqStr(R.string.f211695li), null, "\u597d\u7684", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SubChatSettingFragment.yi(SubChatSettingFragment.this, dialogInterface, i3);
            }
        }, null);
        this.experiencePttAutoDialog = createCustomDialog;
        if (createCustomDialog != null) {
            try {
                createCustomDialog.show();
            } catch (Exception e16) {
                QLog.e("SubChatSettingFragment", 1, "showExperiencePttAutoDialog error:", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(SubChatSettingFragment this$0, DialogInterface dialog, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this$0.ki().U1().postValue(Boolean.TRUE);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zi() {
        QQAppInterface Wh;
        if (getActivity() == null || requireActivity().isFinishing() || requireActivity().isDestroyed() || (Wh = Wh()) == null) {
            return;
        }
        QVipConfigManager.setBoolean(Wh, QVipConfigManager.KEY_BOOLEAN_HAVE_SHOW_PTT_TIP, true);
        Zh();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 0, (String) null, HardCodeUtil.qqStr(R.string.jsb), 0, R.string.hkf, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
        this.pttAutoTipsDialog = createCustomDialog;
        if (createCustomDialog != null) {
            try {
                createCustomDialog.show();
            } catch (Exception e16) {
                QLog.e("SubChatSettingFragment", 1, "showPttAutoTipDialog error:", e16);
            }
        }
    }

    public final QQAppInterface Wh() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.setting.generalSetting.subChatSetting.j
            @Override // java.lang.Runnable
            public final void run() {
                SubChatSettingFragment.onCreate$lambda$0();
            }
        }, 16, null, false);
        com.tencent.qqnt.notification.report.h.q(this.PAGE_ID, null, 2, null);
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ai();
        Zh();
        Yh();
        com.tencent.qqnt.notification.report.h.u(this.PAGE_ID, null, 2, null);
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String string = getString(R.string.f169954u);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.QQS_chat)");
        setTitle(string);
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] Xh = Xh();
            th5.t0((Group[]) Arrays.copyOf(Xh, Xh.length));
        }
    }

    public final Group[] Xh() {
        List mutableListOf;
        List filterNotNull;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(mi(), di(), bi(), Di(), hi(), Vh());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
    }
}
