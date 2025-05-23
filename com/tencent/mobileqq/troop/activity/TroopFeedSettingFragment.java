package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.aio.adapter.api.IGuildTroopApi;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildPermissionService;
import com.tencent.widget.QMultiImageTextView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001KB\u0007\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\u001a\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0014J&\u0010 \u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0012\u0010$\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0018\u0010/\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00104\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/troop/activity/TroopFeedSettingFragment;", "Lcom/tencent/mobileqq/fragment/IphoneTitleBarFragment;", "Landroid/view/View$OnClickListener;", "", "Bh", "", "switchOpen", "Nh", "", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Mh", "Oh", "Eh", "Fh", "Hh", "isSuccess", OcrConfig.CHINESE, "showDialog", "Landroid/view/View;", "root", "Jh", "Ih", "isClick", "view", "Gh", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "initView", "Ah", "p0", NodeProps.ON_CLICK, "onBackEvent", "beforeFinish", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mTroopUin", "D", "mGuildId", "E", "Ljava/lang/Integer;", "mOldPermission", UserInfo.SEX_FEMALE, "mNewPermission", "G", "Ljava/lang/Boolean;", "mOldSwitchOpen", "H", "Landroid/view/View;", "mPermissionTextV", "I", "mPermissionTextV2", "Lcom/tencent/mobileqq/widget/QFormSimpleItem;", "J", "Lcom/tencent/mobileqq/widget/QFormSimpleItem;", "mPermissionAllV", "K", "mPermissionAdminV", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "L", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "mSwitchItem", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "M", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mDialog", "<init>", "()V", "N", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopFeedSettingFragment extends IphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String mTroopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String mGuildId;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Integer mOldPermission;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Integer mNewPermission;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Boolean mOldSwitchOpen;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View mPermissionTextV;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View mPermissionTextV2;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private QFormSimpleItem mPermissionAllV;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private QFormSimpleItem mPermissionAdminV;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private FormSwitchItem mSwitchItem;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private QQCustomDialog mDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/activity/TroopFeedSettingFragment$a;", "", "", "FEED_OPTION_ADMIN", "I", "FEED_OPTION_ALL", "", IGuildFeedConfigAPi.PARAM_GUILD_ID, "Ljava/lang/String;", "PARAM_OPTION_SELECTED", "PARAM_OPTION_SWITCH", "PARAM_UIN", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.activity.TroopFeedSettingFragment$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61989);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopFeedSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void Bh() {
        FormSwitchItem formSwitchItem;
        boolean isNeedHideTroopGuildEntrance = ((IGuildTroopApi) QRoute.api(IGuildTroopApi.class)).isNeedHideTroopGuildEntrance();
        if (Intrinsics.areEqual(this.mOldSwitchOpen, Boolean.TRUE) && isNeedHideTroopGuildEntrance && (formSwitchItem = this.mSwitchItem) != null) {
            formSwitchItem.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopFeedSettingFragment", 2, "initSwitchVisibility mOldSwitchOpen:" + this.mOldSwitchOpen + " remoteConfigValue:" + isNeedHideTroopGuildEntrance);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(TroopFeedSettingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showDialog();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(TroopFeedSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
        int i3;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Oh();
        FormSwitchItem formSwitchItem = this$0.mSwitchItem;
        if (formSwitchItem != null) {
            this$0.Nh(formSwitchItem.isChecked());
            HashMap hashMap = new HashMap();
            if (formSwitchItem.isChecked()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            hashMap.put("sgrp_switch_type", Integer.valueOf(i3));
            VideoReport.setElementId(formSwitchItem, "em_sgrp_group_forum_switch");
            VideoReport.reportEvent("dt_clck", formSwitchItem, hashMap);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final boolean Eh() {
        return !Intrinsics.areEqual(this.mNewPermission, this.mOldPermission);
    }

    private final boolean Fh() {
        Boolean bool;
        FormSwitchItem formSwitchItem = this.mSwitchItem;
        if (formSwitchItem != null) {
            bool = Boolean.valueOf(formSwitchItem.isChecked());
        } else {
            bool = null;
        }
        return !Intrinsics.areEqual(bool, this.mOldSwitchOpen);
    }

    private final void Gh(boolean isClick, View view) {
        String str;
        VideoReport.setElementId(view, "em_sgrp_pop_save_btn");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        if (Fh()) {
            FormSwitchItem formSwitchItem = this.mSwitchItem;
            boolean z16 = false;
            int i3 = 1;
            if (formSwitchItem != null && formSwitchItem.isChecked()) {
                z16 = true;
            }
            if (!z16) {
                i3 = 2;
            }
            hashMap.put("sgrp_op_result", Integer.valueOf(i3));
        } else {
            hashMap.put("sgrp_op_result", 3);
        }
        if (isClick) {
            str = "dt_clck";
        } else {
            str = "dt_imp";
        }
        VideoReport.reportEvent(str, view, hashMap);
    }

    private final void Hh() {
        final AppRuntime peekAppRuntime;
        if (this.mGuildId != null && NetworkUtil.isNetworkAvailable()) {
            boolean Eh = Eh();
            final boolean Fh = Fh();
            QLog.i("TroopFeedSettingFragment", 1, "isPermissionChanged: " + Eh + ", mOldPermission: " + this.mOldPermission + ", isSwitchChanged: " + Fh);
            if (Eh && this.mNewPermission != null) {
                AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime2 == null) {
                    return;
                }
                ITroopGuildPermissionService iTroopGuildPermissionService = (ITroopGuildPermissionService) peekAppRuntime2.getRuntimeService(ITroopGuildPermissionService.class, "");
                String str = this.mGuildId;
                Intrinsics.checkNotNull(str);
                Integer num = this.mNewPermission;
                Intrinsics.checkNotNull(num);
                iTroopGuildPermissionService.setTroopFeedTalkPermission(str, num.intValue(), new Function1<Boolean, Unit>(Fh) { // from class: com.tencent.mobileqq.troop.activity.TroopFeedSettingFragment$save$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ boolean $bIsSwitchChanged;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$bIsSwitchChanged = Fh;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, TroopFeedSettingFragment.this, Boolean.valueOf(Fh));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        Integer num2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, z16);
                            return;
                        }
                        if (z16) {
                            TroopFeedSettingFragment troopFeedSettingFragment = TroopFeedSettingFragment.this;
                            num2 = troopFeedSettingFragment.mNewPermission;
                            troopFeedSettingFragment.mOldPermission = num2;
                        }
                        if (this.$bIsSwitchChanged) {
                            return;
                        }
                        TroopFeedSettingFragment.this.zh(z16);
                    }
                });
            }
            if (!Fh || this.mSwitchItem == null || this.mTroopUin == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                return;
            }
            FormSwitchItem formSwitchItem = this.mSwitchItem;
            Intrinsics.checkNotNull(formSwitchItem);
            final boolean isChecked = formSwitchItem.isChecked();
            ITroopGuildPermissionService iTroopGuildPermissionService2 = (ITroopGuildPermissionService) peekAppRuntime.getRuntimeService(ITroopGuildPermissionService.class, "");
            String str2 = this.mGuildId;
            Intrinsics.checkNotNull(str2);
            String str3 = this.mTroopUin;
            Intrinsics.checkNotNull(str3);
            iTroopGuildPermissionService2.setTroopFeedSwitch(str2, str3, isChecked, new Function1<Boolean, Unit>(isChecked, peekAppRuntime) { // from class: com.tencent.mobileqq.troop.activity.TroopFeedSettingFragment$save$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ AppRuntime $app;
                final /* synthetic */ boolean $switchOpen;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$switchOpen = isChecked;
                    this.$app = peekAppRuntime;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, TroopFeedSettingFragment.this, Boolean.valueOf(isChecked), peekAppRuntime);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    String str4;
                    String str5;
                    String str6;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, z16);
                        return;
                    }
                    if (z16) {
                        TroopFeedSettingFragment.this.mOldSwitchOpen = Boolean.valueOf(this.$switchOpen);
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("key_force_restart", true);
                        FragmentActivity activity = TroopFeedSettingFragment.this.getActivity();
                        if (activity != null) {
                            AppRuntime appRuntime = this.$app;
                            TroopFeedSettingFragment troopFeedSettingFragment = TroopFeedSettingFragment.this;
                            ITroopInfoService iTroopInfoService = (ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "");
                            str4 = troopFeedSettingFragment.mTroopUin;
                            Intrinsics.checkNotNull(str4);
                            TroopInfo findTroopInfo = iTroopInfoService.findTroopInfo(str4);
                            String troopDisplayName = findTroopInfo != null ? findTroopInfo.getTroopDisplayName() : null;
                            String str7 = troopDisplayName == null ? "" : troopDisplayName;
                            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
                            Context applicationContext = activity.getApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(applicationContext, "it.applicationContext");
                            str5 = troopFeedSettingFragment.mTroopUin;
                            Intrinsics.checkNotNull(str5);
                            str6 = troopFeedSettingFragment.mTroopUin;
                            Intrinsics.checkNotNull(str6);
                            iAIOStarterApi.navigateToAIO(applicationContext, 2, str5, str7, Long.parseLong(str6), bundle);
                        }
                    }
                    TroopFeedSettingFragment.this.zh(z16);
                }
            });
            return;
        }
        if (getActivity() != null) {
            QQToast.makeText(getActivity(), 1, getString(R.string.f180133a9), 0).show();
        }
    }

    private final void Ih() {
        int i3;
        if (this.mTroopUin != null && this.mGuildId != null) {
            VideoReport.addToDetectionWhitelist(getActivity());
            View mContentView = ((IphoneTitleBarFragment) this).mContentView;
            Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
            Jh(mContentView);
            QFormSimpleItem qFormSimpleItem = this.mPermissionAllV;
            if (qFormSimpleItem != null) {
                VideoReport.setElementId(qFormSimpleItem, "em_sgrp_channel_forum_publishright_all");
                VideoReport.setElementExposePolicy(qFormSimpleItem, ExposurePolicy.REPORT_NONE);
            }
            QFormSimpleItem qFormSimpleItem2 = this.mPermissionAdminV;
            if (qFormSimpleItem2 != null) {
                VideoReport.setElementId(qFormSimpleItem2, "em_sgrp_channel_forum_publishright_manager");
                VideoReport.setElementExposePolicy(qFormSimpleItem2, ExposurePolicy.REPORT_NONE);
            }
            FormSwitchItem formSwitchItem = this.mSwitchItem;
            if (formSwitchItem != null) {
                VideoReport.setElementId(formSwitchItem, "em_sgrp_group_forum_switch");
                VideoReport.setElementExposePolicy(formSwitchItem, ExposurePolicy.REPORT_NONE);
                HashMap hashMap = new HashMap();
                if (formSwitchItem.isChecked()) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                hashMap.put("sgrp_switch_type", Integer.valueOf(i3));
                VideoReport.reportEvent("dt_imp", formSwitchItem, hashMap);
            }
        }
    }

    private final void Jh(View root) {
        VideoReport.setPageId(root, "pg_group_set_forum");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("group_id", this.mTroopUin);
        ITroopGuildApi iTroopGuildApi = (ITroopGuildApi) QRoute.api(ITroopGuildApi.class);
        String str = this.mTroopUin;
        Intrinsics.checkNotNull(str);
        hashMap.put("group_uin_type", Integer.valueOf(iTroopGuildApi.getTroopGuildRole(str)));
        hashMap.put("sgrp_channel_id", this.mGuildId);
        ITroopGuildApi iTroopGuildApi2 = (ITroopGuildApi) QRoute.api(ITroopGuildApi.class);
        String str2 = this.mGuildId;
        Intrinsics.checkNotNull(str2);
        hashMap.put("sgrp_sub_channel_id", iTroopGuildApi2.getTroopFeedChannelId(str2));
        VideoReport.setPageParams(root, new PageParams(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(TroopFeedSettingFragment this$0, DialogInterface dialogInterface, int i3) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Hh();
        QQCustomDialog qQCustomDialog = this$0.mDialog;
        if (qQCustomDialog != null) {
            textView = qQCustomDialog.getBtnight();
        } else {
            textView = null;
        }
        this$0.Gh(true, textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(TroopFeedSettingFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.onBackEvent();
    }

    private final void Mh(int permission) {
        QMultiImageTextView qMultiImageTextView;
        QMultiImageTextView qMultiImageTextView2;
        QMultiImageTextView qMultiImageTextView3;
        this.mNewPermission = Integer.valueOf(permission);
        QMultiImageTextView qMultiImageTextView4 = null;
        if (permission != 1) {
            if (permission != 2) {
                QFormSimpleItem qFormSimpleItem = this.mPermissionAllV;
                if (qFormSimpleItem != null) {
                    qMultiImageTextView3 = qFormSimpleItem.getRightTextView();
                } else {
                    qMultiImageTextView3 = null;
                }
                if (qMultiImageTextView3 != null) {
                    qMultiImageTextView3.setVisibility(8);
                }
                QFormSimpleItem qFormSimpleItem2 = this.mPermissionAdminV;
                if (qFormSimpleItem2 != null) {
                    qMultiImageTextView4 = qFormSimpleItem2.getRightTextView();
                }
                if (qMultiImageTextView4 != null) {
                    qMultiImageTextView4.setVisibility(8);
                    return;
                }
                return;
            }
            QFormSimpleItem qFormSimpleItem3 = this.mPermissionAllV;
            if (qFormSimpleItem3 != null) {
                qMultiImageTextView2 = qFormSimpleItem3.getRightTextView();
            } else {
                qMultiImageTextView2 = null;
            }
            if (qMultiImageTextView2 != null) {
                qMultiImageTextView2.setVisibility(8);
            }
            QFormSimpleItem qFormSimpleItem4 = this.mPermissionAdminV;
            if (qFormSimpleItem4 != null) {
                qMultiImageTextView4 = qFormSimpleItem4.getRightTextView();
            }
            if (qMultiImageTextView4 != null) {
                qMultiImageTextView4.setVisibility(0);
                return;
            }
            return;
        }
        QFormSimpleItem qFormSimpleItem5 = this.mPermissionAllV;
        if (qFormSimpleItem5 != null) {
            qMultiImageTextView = qFormSimpleItem5.getRightTextView();
        } else {
            qMultiImageTextView = null;
        }
        if (qMultiImageTextView != null) {
            qMultiImageTextView.setVisibility(0);
        }
        QFormSimpleItem qFormSimpleItem6 = this.mPermissionAdminV;
        if (qFormSimpleItem6 != null) {
            qMultiImageTextView4 = qFormSimpleItem6.getRightTextView();
        }
        if (qMultiImageTextView4 != null) {
            qMultiImageTextView4.setVisibility(8);
        }
    }

    private final void Nh(boolean switchOpen) {
        if (switchOpen) {
            QFormSimpleItem qFormSimpleItem = this.mPermissionAllV;
            if (qFormSimpleItem != null) {
                qFormSimpleItem.setVisibility(0);
            }
            QFormSimpleItem qFormSimpleItem2 = this.mPermissionAdminV;
            if (qFormSimpleItem2 != null) {
                qFormSimpleItem2.setVisibility(0);
            }
            View view = this.mPermissionTextV;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.mPermissionTextV2;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        QFormSimpleItem qFormSimpleItem3 = this.mPermissionAllV;
        if (qFormSimpleItem3 != null) {
            qFormSimpleItem3.setVisibility(8);
        }
        QFormSimpleItem qFormSimpleItem4 = this.mPermissionAdminV;
        if (qFormSimpleItem4 != null) {
            qFormSimpleItem4.setVisibility(8);
        }
        View view3 = this.mPermissionTextV;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.mPermissionTextV2;
        if (view4 != null) {
            view4.setVisibility(8);
        }
    }

    private final void Oh() {
        if (!Eh() && !Fh()) {
            setRightViewTextDisable(0);
        } else {
            setRightViewTextDisable(1);
        }
    }

    private final void showDialog() {
        Window window;
        View decorView;
        TextView textView;
        QQCustomDialog qQCustomDialog = this.mDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230, (String) null, getString(R.string.f180113a7), getString(R.string.f180143a_), getString(R.string.f180153aa), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.activity.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopFeedSettingFragment.Kh(TroopFeedSettingFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.activity.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopFeedSettingFragment.Lh(TroopFeedSettingFragment.this, dialogInterface, i3);
            }
        });
        this.mDialog = createCustomDialog;
        if (createCustomDialog != null && (window = createCustomDialog.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            Jh(decorView);
            QQCustomDialog qQCustomDialog2 = this.mDialog;
            if (qQCustomDialog2 != null) {
                textView = qQCustomDialog2.getBtnight();
            } else {
                textView = null;
            }
            Gh(false, textView);
        }
        QQCustomDialog qQCustomDialog3 = this.mDialog;
        if (qQCustomDialog3 != null) {
            qQCustomDialog3.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh(boolean isSuccess) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            if (isSuccess) {
                QQToast.makeText(getActivity(), 2, getString(R.string.f180163ab), 0).show();
            } else {
                QQToast.makeText(getActivity(), 1, getString(R.string.f180133a9), 0).show();
            }
        }
        if (getBaseActivity() != null) {
            getBaseActivity().finish();
        }
    }

    public final void Ah() {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            this.mTroopUin = intent.getStringExtra("PARAM_UIN");
            this.mGuildId = intent.getStringExtra(IGuildFeedConfigAPi.PARAM_GUILD_ID);
            this.mOldPermission = Integer.valueOf(intent.getIntExtra("PARAM_OPTION_SELECTED", -1));
            this.mOldSwitchOpen = Boolean.valueOf(intent.getBooleanExtra("PARAM_OPTION_SWITCH", true));
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.beforeFinish();
        Intent intent = new Intent();
        intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_PERMISSION, this.mOldPermission);
        intent.putExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_SWITCH, this.mOldSwitchOpen);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
            return;
        }
        super.doOnCreateView(inflater, container, savedInstanceState);
        Ah();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.fzl;
    }

    public final void initView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Context context = getContext();
        if (context != null) {
            setTitle(context.getString(R.string.f180093a5));
            setRightButtonText(context.getString(R.string.f180153aa), new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.activity.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopFeedSettingFragment.Ch(TroopFeedSettingFragment.this, view);
                }
            });
            setRightViewTextDisable(0);
            if (getRightTextView() != null) {
                getRightTextView().setBackground(null);
            }
        }
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.v3j);
        this.mSwitchItem = formSwitchItem;
        if (formSwitchItem != null) {
            formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.activity.l
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    TroopFeedSettingFragment.Dh(TroopFeedSettingFragment.this, compoundButton, z16);
                }
            });
        }
        this.mPermissionTextV = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f2402080);
        this.mPermissionTextV2 = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f2403081);
        QFormSimpleItem qFormSimpleItem = (QFormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f237507_);
        this.mPermissionAllV = qFormSimpleItem;
        if (qFormSimpleItem != null) {
            qFormSimpleItem.setOnClickListener(this);
        }
        QFormSimpleItem qFormSimpleItem2 = this.mPermissionAllV;
        if (qFormSimpleItem2 != null) {
            qFormSimpleItem2.setTag(1);
        }
        QFormSimpleItem qFormSimpleItem3 = (QFormSimpleItem) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f2374079);
        this.mPermissionAdminV = qFormSimpleItem3;
        if (qFormSimpleItem3 != null) {
            qFormSimpleItem3.setOnClickListener(this);
        }
        QFormSimpleItem qFormSimpleItem4 = this.mPermissionAdminV;
        if (qFormSimpleItem4 != null) {
            qFormSimpleItem4.setTag(2);
        }
        Integer num = this.mOldPermission;
        if (num != null) {
            Mh(num.intValue());
        }
        Boolean bool = this.mOldSwitchOpen;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            FormSwitchItem formSwitchItem2 = this.mSwitchItem;
            if (formSwitchItem2 != null) {
                formSwitchItem2.setChecked(booleanValue);
            }
            Nh(booleanValue);
        }
        Ih();
        Bh();
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (!Eh() && !Fh()) {
            return super.onBackEvent();
        }
        showDialog();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View p06) {
        EventCollector.getInstance().onViewClickedBefore(p06);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) p06);
        } else if (p06 != null) {
            Object tag = p06.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            Mh(((Integer) tag).intValue());
            Oh();
            VideoReport.reportEvent("dt_clck", p06, null);
        }
        EventCollector.getInstance().onViewClicked(p06);
    }
}
