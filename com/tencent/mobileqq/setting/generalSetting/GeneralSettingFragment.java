package com.tencent.mobileqq.setting.generalSetting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.n;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.ScreenShotActivityModule;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.cardcontainer.data.CardContainerSwitchState;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.setting.generalSetting.subChatSetting.SubChatSettingFragment;
import com.tencent.mobileqq.setting.generalSetting.subRichMediaSetting.SubRichMediaSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.migration.NTMsgMigrationManager;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 `2\u00020\u0001:\u0001aB\u0007\u00a2\u0006\u0004\b^\u0010_J\u000e\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0002J\u000e\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\f\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\f\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\f\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\f\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\f\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0003J\u000e\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002JH\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\"\b\b\u0000\u0010\u0019*\u00020\u0018\"\b\b\u0001\u0010\u001b*\u00020\u001a*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002JT\u0010)\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0\u001c2\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020!2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002J\u0018\u0010-\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\nH\u0002J(\u00100\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020*2\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010.H\u0002J(\u00101\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020*2\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010.H\u0002J\u0018\u00102\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\nH\u0002J\b\u00104\u001a\u0004\u0018\u000103J\u0012\u00107\u001a\u00020\u001e2\b\u00106\u001a\u0004\u0018\u000105H\u0016J\b\u00108\u001a\u00020\u001eH\u0016J\u001a\u0010;\u001a\u00020\u001e2\u0006\u0010:\u001a\u0002092\b\u00106\u001a\u0004\u0018\u000105H\u0016J\b\u0010<\u001a\u00020\u001eH\u0016J\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00050=2\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b>\u0010?J\u000e\u0010A\u001a\u00020*2\u0006\u0010@\u001a\u00020#R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR(\u0010N\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR(\u0010Q\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010I\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR\"\u0010X\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010]\u001a\u00020*8\u0006X\u0086D\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/setting/generalSetting/GeneralSettingFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Th", "Ih", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Sh", "Lh", "ri", "li", "", "isFirst", "Rh", "fi", "Mh", "gi", "Vh", "ti", "Nh", "Jh", "hi", "si", "Xh", "Uh", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "L", "Lcom/tencent/mobileqq/widget/listitem/x$c;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lkotlin/Function0;", "", "onExpo", "mi", "", "leftText", "", "leftIcon", "rightText", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "oi", "", "switchId", "isChecked", "ci", "", "eventParams", "bi", "Zh", "Yh", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Hh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onDestroyView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", "Ph", "(Z)[Lcom/tencent/mobileqq/widget/listitem/Group;", "resId", "ei", "Lcom/tencent/mobileqq/setting/generalSetting/i;", "J", "Lkotlin/Lazy;", "Wh", "()Lcom/tencent/mobileqq/setting/generalSetting/i;", "generalSettingVM", "K", "Lcom/tencent/mobileqq/widget/listitem/a;", "getFontSizeConfig", "()Lcom/tencent/mobileqq/widget/listitem/a;", "setFontSizeConfig", "(Lcom/tencent/mobileqq/widget/listitem/a;)V", "fontSizeConfig", "getScreenShotConfig", "setScreenShotConfig", "screenShotConfig", "M", "I", "getReportTime", "()I", "setReportTime", "(I)V", "reportTime", "N", "Ljava/lang/String;", "getPAGE_ID", "()Ljava/lang/String;", "PAGE_ID", "<init>", "()V", "P", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class GeneralSettingFragment extends BaseSettingFragment {

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy generalSettingVM;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.a<?> fontSizeConfig;

    /* renamed from: L, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.a<?> screenShotConfig;

    /* renamed from: M, reason: from kotlin metadata */
    private int reportTime;

    /* renamed from: N, reason: from kotlin metadata */
    private final String PAGE_ID;

    public GeneralSettingFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<i>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$generalSettingVM$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i invoke() {
                return (i) GeneralSettingFragment.this.getViewModel(i.class);
            }
        });
        this.generalSettingVM = lazy;
        this.PAGE_ID = "pg_bas_general_purpose";
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Ih() {
        if (n.e() || !Wh().M1()) {
            return null;
        }
        if (this.reportTime == 0) {
            di(this, "em_bas_home_page_bottom_navigation_bar_settings", null, 2, null);
        }
        return oi(ei(R.string.f170635zg0), R.drawable.qui_chat_settings, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$bottomTabConfig$1
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
                FragmentActivity activity = GeneralSettingFragment.this.getActivity();
                if (activity != null) {
                    Intent intent = new Intent();
                    intent.putExtra("KEY_ENTRANCE", "VALUE_QQ_ASSISTANT_SETTING");
                    ((ISettingApi) QRoute.api(ISettingApi.class)).startBottomTabSettingPage(activity, intent);
                }
                ReportController.o(GeneralSettingFragment.this.Hh(), "CliOper", "", "", "bottom_tab", "entrance_clk", 0, 0, "2", "", "", "");
                GeneralSettingFragment.ai(GeneralSettingFragment.this, "em_bas_home_page_bottom_navigation_bar_settings", null, 2, null);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$bottomTabConfig$2
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
                ReportController.o(null, "dc00898", "", "", TabDataHelper.VALUE_SETTING_ENTRANCE_REPORT, TabDataHelper.VALUE_SETTING_ENTRANCE_REPORT, 0, 0, "2", "", "", "");
                ReportController.o(GeneralSettingFragment.this.Hh(), "CliOper", "", "", "bottom_tab", "entrance_exp", 0, 0, "", "", "", "");
            }
        });
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Jh() {
        String str;
        QRouteApi api = QRoute.api(ICardContainerSwitchApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ICardContainerSwitchApi::class.java)");
        final ICardContainerSwitchApi iCardContainerSwitchApi = (ICardContainerSwitchApi) api;
        if (!iCardContainerSwitchApi.remoteShowCardContainerSwitch() || !iCardContainerSwitchApi.getLocalCardContainerSwitchShowingState()) {
            return null;
        }
        CardContainerSwitchState remoteCardContainerSwitchState = iCardContainerSwitchApi.getRemoteCardContainerSwitchState();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        CardContainerSwitchState cardContainerSwitchState = CardContainerSwitchState.OFF;
        if (remoteCardContainerSwitchState != cardContainerSwitchState) {
            str = "1";
        } else {
            str = "2";
        }
        linkedHashMap.put("status", str);
        if (this.reportTime == 0) {
            bi("em_bas_container_switch", linkedHashMap);
        }
        return new x(new x.b.C8996b(ei(R.string.ziq), R.drawable.qui_subscription), new x.c.f(remoteCardContainerSwitchState != cardContainerSwitchState, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GeneralSettingFragment.Kh(ICardContainerSwitchApi.this, this, compoundButton, z16);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(ICardContainerSwitchApi switchApi, GeneralSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(switchApi, "$switchApi");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            switchApi.setRemoteCardContainerSwitchState(CardContainerSwitchState.ON);
        } else {
            switchApi.setRemoteCardContainerSwitchState(CardContainerSwitchState.OFF);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        linkedHashMap.put("status", str);
        this$0.Zh("em_bas_container_switch", linkedHashMap);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Lh() {
        if (this.reportTime == 0) {
            di(this, "em_bas_chat_history_management", null, 2, null);
        }
        return oi(ei(R.string.zk7), R.drawable.qui_time, "\u5907\u4efd\u3001\u8fc1\u79fb", new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$chatHistorySettingModeConfig$1
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
                if (GeneralSettingFragment.this.getActivity() != null) {
                    GeneralSettingFragment generalSettingFragment = GeneralSettingFragment.this;
                    Intent intent = new Intent();
                    intent.putExtra("set_display_type", 1);
                    Context it12 = generalSettingFragment.getContext();
                    if (it12 != null) {
                        ISettingApi iSettingApi = (ISettingApi) QRoute.api(ISettingApi.class);
                        Intrinsics.checkNotNullExpressionValue(it12, "it1");
                        iSettingApi.startChatHistorySettingPage(it12, intent);
                    }
                }
                GeneralSettingFragment.ai(GeneralSettingFragment.this, "em_bas_chat_history_management", null, 2, null);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$chatHistorySettingModeConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Mh() {
        if (this.reportTime == 0) {
            di(this, "em_bas_chat_button", null, 2, null);
        }
        return oi(ei(R.string.f169954u), R.drawable.qui_message, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$chatModeConfig$1
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
                FragmentActivity activity = GeneralSettingFragment.this.getActivity();
                if (activity != null) {
                    QPublicFragmentActivity.start(activity, new Intent(), SubChatSettingFragment.class);
                }
                GeneralSettingFragment.ai(GeneralSettingFragment.this, "em_bas_chat_button", null, 2, null);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$chatModeConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Nh() {
        if (!Wh().getIsShowColorNoteRecentSwitch()) {
            return null;
        }
        if (this.reportTime == 0) {
            ci("em_bas_recently_viewed_content_automatically_adds_color_tabs", Wh().getColorNoteSwitchValue());
        }
        return new x(new x.b.C8996b(ei(R.string.bs7), R.drawable.qui_caiqian_on), new x.c.f(Wh().getColorNoteSwitchValue(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GeneralSettingFragment.Oh(GeneralSettingFragment.this, compoundButton, z16);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(GeneralSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQAppInterface Hh = this$0.Hh();
        String currentUin = Hh != null ? Hh.getCurrentUin() : null;
        if (currentUin == null) {
            currentUin = "";
        }
        ((IColorNoteController) QRoute.api(IColorNoteController.class)).setRecentlyViewedSwitch(MobileQQ.sMobileQQ.getAppRuntime(currentUin), z16);
        if (!z16) {
            new ColorNoteCurd().r(null);
        }
        ((IColorNoteController) QRoute.api(IColorNoteController.class)).dispatchRecentViewSwitchChanged(z16);
        this$0.Yh("em_bas_recently_viewed_content_automatically_adds_color_tabs", z16);
    }

    private final Group Sh() {
        List mutableListOf;
        List filterNotNull;
        String ei5 = ei(R.string.f2043952s);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Th(), Ih());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group(ei5, "", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Th() {
        if (this.reportTime == 0) {
            di(this, "em_bas_font_size", null, 2, null);
        }
        x<x.b.d, x.c.g> oi5 = oi(ei(R.string.hfn), R.drawable.qui_typeface, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$fontSizeModeConfig$1
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
                FragmentActivity activity = GeneralSettingFragment.this.getActivity();
                if (activity != null) {
                    GeneralSettingFragment generalSettingFragment = GeneralSettingFragment.this;
                    activity.startActivity(new Intent(activity, (Class<?>) FontSettingActivity.class));
                    ReportController.y(generalSettingFragment.Hh(), "0X800B86F");
                }
                ReportController.y(GeneralSettingFragment.this.Hh(), "0X800B87B");
                GeneralSettingFragment.ai(GeneralSettingFragment.this, "em_bas_font_size", null, 2, null);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$fontSizeModeConfig$2
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
                ReportController.y(GeneralSettingFragment.this.Hh(), "0X800B817");
            }
        });
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.fontCfg.name(), "-1");
        Intrinsics.checkNotNullExpressionValue(featureValue, "api(IDPCApi::class.java)\u2026er.FONT_SWITCHER_DEFAULT)");
        if (QLog.isColorLevel()) {
            QLog.d(QPublicBaseFragment.TAG, 2, "current fontSetting dpcValue=" + featureValue);
        }
        if (ElderModeManager.j()) {
            oi5.p(false);
        } else if (Intrinsics.areEqual("1", featureValue) && FontSettingManager.isDisplayMetricNoAnswer()) {
            oi5.p(true);
        } else if (Intrinsics.areEqual("0", featureValue)) {
            oi5.p(false);
            QQAppInterface Hh = Hh();
            FontSettingManager.revert2SystemDensity(Hh != null ? Hh.getApplicationContext() : null);
        } else if (FontSettingManager.isSupportDevice()) {
            oi5.p(true);
        } else {
            oi5.p(false);
            QQAppInterface Hh2 = Hh();
            FontSettingManager.revert2SystemDensity(Hh2 != null ? Hh2.getApplicationContext() : null);
        }
        this.fontSizeConfig = oi5;
        return oi5;
    }

    private final Group Uh() {
        List mutableListOf;
        List filterNotNull;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Xh(), Jh(), Nh(), hi(), si());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group("\u5176\u4ed6", "", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Vh() {
        if (this.reportTime == 0) {
            di(this, "em_bas_interactive_identification", null, 2, null);
        }
        return oi(ei(R.string.f2042852h), R.drawable.qui_medals, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$friendsInteractionModeConfig$1
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
                if (GeneralSettingFragment.this.getActivity() != null) {
                    GeneralSettingFragment generalSettingFragment = GeneralSettingFragment.this;
                    ISettingApi iSettingApi = (ISettingApi) QRoute.api(ISettingApi.class);
                    QBaseActivity qBaseActivity = generalSettingFragment.getQBaseActivity();
                    Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
                    iSettingApi.startPrivacyInteractionSettingPage(qBaseActivity, new Intent());
                }
                GeneralSettingFragment.ai(GeneralSettingFragment.this, "em_bas_interactive_identification", null, 2, null);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$friendsInteractionModeConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    private final i Wh() {
        Object value = this.generalSettingVM.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-generalSettingVM>(...)");
        return (i) value;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Xh() {
        if (((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch()) {
            return pi(this, "\u8f85\u52a9\u529f\u80fd", R.drawable.qui_tuning, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$messageListPluginConfig$1
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
                    FragmentActivity activity = GeneralSettingFragment.this.getActivity();
                    if (activity != null) {
                        ((IMsgListPluginApi) QRoute.api(IMsgListPluginApi.class)).startMsgListPluginSettingPage(activity, new Intent());
                    }
                }
            }, null, 16, null);
        }
        return null;
    }

    private final void Yh(String switchId, boolean isChecked) {
        com.tencent.qqnt.notification.report.h.z(this.PAGE_ID, switchId, Boolean.valueOf(isChecked), null, null, 24, null);
    }

    private final void Zh(String switchId, Map<String, String> eventParams) {
        com.tencent.qqnt.notification.report.h.y(this.PAGE_ID, switchId, null, null, eventParams);
    }

    private final void bi(String switchId, Map<String, String> eventParams) {
        com.tencent.qqnt.notification.report.h.C(this.PAGE_ID, switchId, null, null, eventParams);
    }

    private final void ci(String switchId, boolean isChecked) {
        com.tencent.qqnt.notification.report.h.D(this.PAGE_ID, switchId, Boolean.valueOf(isChecked), null, null, 24, null);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> gi() {
        if (this.reportTime == 0) {
            di(this, "em_bas_pictures_videos_files_calls", null, 2, null);
        }
        return oi(ei(R.string.f2042652f), R.drawable.qui_image, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$richMediaSettingModeConfig$1
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
                FragmentActivity activity = GeneralSettingFragment.this.getActivity();
                if (activity != null) {
                    QPublicFragmentActivity.start(activity, new Intent(), SubRichMediaSettingFragment.class);
                }
                GeneralSettingFragment.ai(GeneralSettingFragment.this, "em_bas_pictures_videos_files_calls", null, 2, null);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$richMediaSettingModeConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> hi() {
        com.tencent.mobileqq.widget.listitem.a<?> aVar = this.screenShotConfig;
        if (aVar != null) {
            return aVar;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.setting.generalSetting.c
            @Override // java.lang.Runnable
            public final void run() {
                GeneralSettingFragment.ii(GeneralSettingFragment.this);
            }
        }, 16, null, true);
        return this.screenShotConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, mqq.app.AppActivity, java.lang.Object, com.tencent.mobileqq.app.QBaseActivity] */
    public static final void ii(final GeneralSettingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAdded()) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? qBaseActivity = this$0.getQBaseActivity();
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "getQBaseActivity()");
            objectRef.element = qBaseActivity;
            Intrinsics.checkNotNullExpressionValue(qBaseActivity.getAppRuntime(), "activity.appRuntime");
            final boolean readValue = SettingCloneUtil.readValue((Context) objectRef.element, (String) null, HardCodeUtil.qqStr(R.string.cyv), AppConstants.QQSETTING_SCREENSHOT_KEY, false);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.setting.generalSetting.e
                @Override // java.lang.Runnable
                public final void run() {
                    GeneralSettingFragment.ji(GeneralSettingFragment.this, readValue, objectRef);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(final GeneralSettingFragment this$0, boolean z16, final Ref.ObjectRef activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.ci("em_bas_screenshot_sharing", z16);
        this$0.screenShotConfig = new x(new x.b.C8996b("\u6447\u52a8\u624b\u673a\u622a\u5c4f", R.drawable.qui_share_screen_phone), new x.c.f(z16, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.generalSetting.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                GeneralSettingFragment.ki(Ref.ObjectRef.this, this$0, compoundButton, z17);
            }
        }));
        this$0.reportTime++;
        QUIListItemAdapter th5 = this$0.th();
        if (th5 != null) {
            Group[] Ph = this$0.Ph(false);
            th5.t0((Group[]) Arrays.copyOf(Ph, Ph.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void ki(Ref.ObjectRef activity, GeneralSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingCloneUtil.writeValue((Context) activity.element, (String) null, "\u5f00\u542f\u622a\u5c4f\u529f\u80fd", AppConstants.QQSETTING_SCREENSHOT_KEY, z16);
        ScreenShotActivityModule screenShotActivityModule = (ScreenShotActivityModule) ((QBaseActivity) activity.element).getModule(ScreenShotActivityModule.class);
        if (z16) {
            screenShotActivityModule.turnOnShake();
        } else {
            screenShotActivityModule.turnOffShake();
        }
        this$0.Yh("em_bas_screenshot_sharing", z16);
    }

    private final Group li() {
        List mutableListOf;
        List filterNotNull;
        String ei5 = ei(R.string.f2043052j);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Lh(), ri());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group(ei5, "", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    private final <L extends x.b, R extends x.c> x<L, R> mi(x<L, R> xVar, final Function0<Unit> function0) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.generalSetting.f
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GeneralSettingFragment.ni(Ref.BooleanRef.this, function0, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(Ref.BooleanRef firstExpo, Function0 function0, View it) {
        Intrinsics.checkNotNullParameter(firstExpo, "$firstExpo");
        Intrinsics.checkNotNullParameter(it, "it");
        if (firstExpo.element) {
            firstExpo.element = false;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private final x<x.b.d, x.c.g> oi(CharSequence leftText, int leftIcon, CharSequence rightText, final Function0<Unit> onClick, final Function0<Unit> onExpo) {
        x.b dVar;
        if (leftIcon != 0) {
            dVar = new x.b.C8996b(leftText, leftIcon);
        } else {
            dVar = new x.b.d(leftText);
        }
        x<x.b.d, x.c.g> xVar = new x<>(dVar, new x.c.g(rightText, true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.generalSetting.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GeneralSettingFragment.qi(Function0.this, view);
            }
        });
        mi(xVar, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$singleLineConfig$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Function0<Unit> function0 = onExpo;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        return xVar;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ri() {
        if (this.reportTime == 0) {
            di(this, "em_bas_storage_space", null, 2, null);
        }
        return oi(ei(R.string.f171522iz2), R.drawable.qui_storage, ei(R.string.f228646ua), new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$storageSpaceModeConfig$1
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
                if (GeneralSettingFragment.this.getActivity() != null) {
                    GeneralSettingFragment generalSettingFragment = GeneralSettingFragment.this;
                    QQAppInterface Hh = generalSettingFragment.Hh();
                    String currentUin = Hh != null ? Hh.getCurrentUin() : null;
                    if (currentUin == null) {
                        currentUin = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(currentUin, "app()?.currentUin ?: \"\"");
                    }
                    AppRuntime appRuntime = MobileQQ.sMobileQQ.getAppRuntime(currentUin);
                    NTMsgMigrationManager a16 = NTMsgMigrationManager.INSTANCE.a();
                    FragmentActivity requireActivity = generalSettingFragment.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    a16.i0(requireActivity, appRuntime);
                }
                GeneralSettingFragment.ai(GeneralSettingFragment.this, "em_bas_storage_space", null, 2, null);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$storageSpaceModeConfig$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> si() {
        IZPlanAccessibleHelper iZPlanAccessibleHelper = (IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class);
        QQAppInterface Hh = Hh();
        if (!iZPlanAccessibleHelper.isZplanAccessibleWithoutSetting(Constant.FROM_ID_START_ACTIVITY, Hh != null ? Hh.getLongAccountUin() : 0L)) {
            return null;
        }
        if (this.reportTime == 0) {
            di(this, "em_bas_super_qq_show_image_display", null, 2, null);
        }
        return pi(this, "\u8d85\u7ea7QQ\u79c0\u5f62\u8c61\u5c55\u793a", R.drawable.qui_super_qq_show, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$superQQShowModeConfig$1
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
                FragmentActivity activity = GeneralSettingFragment.this.getActivity();
                if (activity != null) {
                    GeneralSettingFragment generalSettingFragment = GeneralSettingFragment.this;
                    ((IZPlanApi) QRoute.api(IZPlanApi.class)).startAvatarSettingActivity(activity, "setting_me");
                    GeneralSettingFragment.ai(generalSettingFragment, "em_bas_super_qq_show_image_display", null, 2, null);
                }
            }
        }, null, 16, null);
    }

    private final Group ti(boolean isFirst) {
        List mutableListOf;
        List filterNotNull;
        String ei5 = ei(R.string.f2043752q);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Rh(isFirst), fi(isFirst), Mh(), gi(), Vh());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group(ei5, "", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }

    public final QQAppInterface Hh() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        return null;
    }

    public final String ei(int resId) {
        String string = BaseApplication.context.getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        return string;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Wh().P1();
        com.tencent.qqnt.notification.report.h.q(this.PAGE_ID, null, 2, null);
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.tencent.qqnt.notification.report.h.u(this.PAGE_ID, null, 2, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Wh().onResume();
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getActivity();
        setTitle(ei(R.string.frw));
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] Qh = Qh(this, false, 1, null);
            th5.t0((Group[]) Arrays.copyOf(Qh, Qh.length));
        }
    }

    public final Group[] Ph(boolean isFirst) {
        return new Group[]{Sh(), li(), ti(isFirst), Uh()};
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Rh(boolean isFirst) {
        if (isFirst) {
            di(this, "em_bas_double_tap_action", null, 2, null);
        }
        return oi(ei(R.string.f173152sd), R.drawable.qui_avatar, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$doubleTapAvatarConfig$1
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
                if (VasUtil.getTempApi().isCanOpenHippyPage(HippyQQConstants.ModuleName.QQ_GXH_NUDGE_MALL)) {
                    VasUtil.getTempApi().openHippyPageWithConfig(HippyQQConstants.ModuleName.QQ_GXH_NUDGE_MALL, "");
                } else {
                    FragmentActivity activity = GeneralSettingFragment.this.getActivity();
                    if (activity != null) {
                        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", "https://zb.vip.qq.com/v2/pages/nudgeMall?_wv=2");
                        activity.startActivity(intent);
                    }
                }
                GeneralSettingFragment.ai(GeneralSettingFragment.this, "em_bas_double_tap_action", null, 2, null);
                ReportController.y(GeneralSettingFragment.this.Hh(), "0X800B87B");
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$doubleTapAvatarConfig$2
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
                ReportController.y(GeneralSettingFragment.this.Hh(), "0X800B817");
            }
        });
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> fi(boolean isFirst) {
        if (isFirst) {
            di(this, "em_bas_customize_withdrawal_message", null, 2, null);
        }
        return oi(ei(R.string.f2043352m), R.drawable.qui_recall, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$revokeMsgConfig$1
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
                FragmentActivity activity = GeneralSettingFragment.this.getActivity();
                if (activity != null) {
                    com.tencent.mobileqq.graytip.a.b(activity, "2");
                }
                ReportController.y(GeneralSettingFragment.this.Hh(), "0X800B87C");
                GeneralSettingFragment.ai(GeneralSettingFragment.this, "em_bas_customize_withdrawal_message", null, 2, null);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.setting.generalSetting.GeneralSettingFragment$revokeMsgConfig$2
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
                ReportController.y(GeneralSettingFragment.this.Hh(), "0X800B818");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ Group[] Qh(GeneralSettingFragment generalSettingFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return generalSettingFragment.Ph(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ai(GeneralSettingFragment generalSettingFragment, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        generalSettingFragment.Zh(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void di(GeneralSettingFragment generalSettingFragment, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        generalSettingFragment.bi(str, map);
    }

    static /* synthetic */ x pi(GeneralSettingFragment generalSettingFragment, CharSequence charSequence, int i3, CharSequence charSequence2, Function0 function0, Function0 function02, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            charSequence2 = "";
        }
        return generalSettingFragment.oi(charSequence, i17, charSequence2, (i16 & 8) != 0 ? null : function0, (i16 & 16) != 0 ? null : function02);
    }
}
