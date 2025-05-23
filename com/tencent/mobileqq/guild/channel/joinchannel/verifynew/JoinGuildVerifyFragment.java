package com.tencent.mobileqq.guild.channel.joinchannel.verifynew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyViewModel;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.SoftKeyboardStateHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;
import vp1.db;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyFragment;", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/BaseJoinGuildFragment;", "", "guildId", "", "Mh", "Lh", "initView", "initData", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lvp1/db;", BdhLogUtil.LogTag.Tag_Conn, "Lvp1/db;", "binding", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyViewModel;", "D", "Lkotlin/Lazy;", "Dh", "()Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyViewModel;", "viewModel", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a;", "E", "Ch", "()Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a;", "adapter", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpParam", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "G", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "joinGuildSetting", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "H", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", "I", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", "keyboardHelper", "<init>", "()V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class JoinGuildVerifyFragment extends BaseJoinGuildFragment {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private db binding;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private JumpGuildParam jumpParam;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private IGProJoinGuildSetting joinGuildSetting;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask reportTask;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private SoftKeyboardStateHelper keyboardHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpParam", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "joinGuildSetting", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "Lvh2/bv;", "resultCallback", "", "a", "", "ERROR_CODE_PARAM_ERROR", "I", "", "GUILD_JOIN_ADD_GUILD_OPTION", "Ljava/lang/String;", "GUILD_JOIN_PARAMS", "RESULT_EXTRA_CODE", "RESULT_EXTRA_JOIN_RESULT", "RESULT_EXTRA_MSG", "RESULT_EXTRA_SECURITY_INFO", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull JumpGuildParam jumpParam, @Nullable IGProJoinGuildSetting joinGuildSetting, @NotNull IPerformanceReportTask reportTask, @NotNull bv resultCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(jumpParam, "jumpParam");
            Intrinsics.checkNotNullParameter(reportTask, "reportTask");
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            Intent intent = new Intent();
            intent.putExtra("guild_join_params", (Parcelable) jumpParam);
            intent.putExtra("guild_join_add_guild_option", joinGuildSetting);
            qw1.b.r(intent, reportTask);
            if (context instanceof Activity) {
                QPublicFragmentActivity.start(context, intent, JoinGuildVerifyFragment.class);
            } else {
                intent.addFlags(268435456);
                QPublicFragmentActivity.start(BaseApplication.getContext(), intent, JoinGuildVerifyFragment.class);
            }
            com.tencent.mobileqq.guild.channel.joinchannel.b.a(resultCallback);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f215023d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JoinGuildVerifyFragment f215024e;

        public b(View view, JoinGuildVerifyFragment joinGuildVerifyFragment) {
            this.f215023d = view;
            this.f215024e = joinGuildVerifyFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                this.f215024e.Dh().k();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyFragment$c", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollVertically", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends LinearLayoutManager {
        c(Context context) {
            super(context, 1, false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            boolean z16;
            boolean z17;
            boolean z18;
            IGProJoinGuildSetting iGProJoinGuildSetting = JoinGuildVerifyFragment.this.joinGuildSetting;
            if (iGProJoinGuildSetting != null && iGProJoinGuildSetting.getOptionType() == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                IGProJoinGuildSetting iGProJoinGuildSetting2 = JoinGuildVerifyFragment.this.joinGuildSetting;
                if (iGProJoinGuildSetting2 != null && iGProJoinGuildSetting2.getOptionType() == 6) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    IGProJoinGuildSetting iGProJoinGuildSetting3 = JoinGuildVerifyFragment.this.joinGuildSetting;
                    if (iGProJoinGuildSetting3 != null && iGProJoinGuildSetting3.getOptionType() == 7) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
    }

    public JoinGuildVerifyFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<JoinGuildVerifyViewModel>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final JoinGuildVerifyViewModel invoke() {
                return (JoinGuildVerifyViewModel) JoinGuildVerifyFragment.this.getViewModel(JoinGuildVerifyViewModel.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyFragment$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(JoinGuildVerifyFragment.this.Dh());
            }
        });
        this.adapter = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a Ch() {
        return (a) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JoinGuildVerifyViewModel Dh() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (JoinGuildVerifyViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(JoinGuildVerifyFragment this$0, View view) {
        View currentFocus;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null && (currentFocus = activity.getCurrentFocus()) != null) {
            Object systemService = activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(JoinGuildVerifyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Lh() {
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        db dbVar = this.binding;
        if (dbVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dbVar = null;
        }
        iGuildDTReportApi.setElementClickParams(dbVar.f442873e.findViewById(R.id.j6n), "em_sgrp_auditcheck_acess", null);
    }

    private final void Mh(String guildId) {
        VideoReport.addToDetectionWhitelist(getActivity());
        db dbVar = this.binding;
        db dbVar2 = null;
        if (dbVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dbVar = null;
        }
        VideoReport.setPageId(dbVar.getRoot(), "pg_sgrp_auditcheck");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("sgrp_channel_id", guildId);
        db dbVar3 = this.binding;
        if (dbVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dbVar2 = dbVar3;
        }
        VideoReport.setPageParams(dbVar2.getRoot(), new PageParams(hashMap));
    }

    private final void initData() {
        JumpGuildParam jumpGuildParam;
        Serializable serializable;
        IPerformanceReportTask iPerformanceReportTask;
        Bundle arguments = getArguments();
        if (arguments != null) {
            jumpGuildParam = (JumpGuildParam) arguments.getParcelable("guild_join_params");
        } else {
            jumpGuildParam = null;
        }
        this.jumpParam = jumpGuildParam;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            serializable = arguments2.getSerializable("guild_join_add_guild_option");
        } else {
            serializable = null;
        }
        this.joinGuildSetting = (IGProJoinGuildSetting) serializable;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            iPerformanceReportTask = qw1.b.g(arguments3, null, 1, null);
        } else {
            iPerformanceReportTask = null;
        }
        this.reportTask = iPerformanceReportTask;
        Dh().g2(this.reportTask);
        MutableLiveData<List<wf1.b>> U1 = Dh().U1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends wf1.b>, Unit> function1 = new Function1<List<? extends wf1.b>, Unit>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends wf1.b> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends wf1.b> it) {
                a Ch;
                ArrayList arrayList = new ArrayList();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.addAll(it);
                Ch = JoinGuildVerifyFragment.this.Ch();
                Ch.setItems(arrayList);
            }
        };
        U1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                JoinGuildVerifyFragment.Eh(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> Z1 = Dh().Z1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyFragment$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                db dbVar;
                dbVar = JoinGuildVerifyFragment.this.binding;
                if (dbVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dbVar = null;
                }
                QUIButton qUIButton = dbVar.f442873e;
                Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.submitBtn");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qUIButton.setVisibility(it.booleanValue() ? 0 : 8);
            }
        };
        Z1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                JoinGuildVerifyFragment.Fh(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> a26 = Dh().a2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyFragment$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean enable) {
                db dbVar;
                db dbVar2;
                Intrinsics.checkNotNullExpressionValue(enable, "enable");
                db dbVar3 = null;
                if (enable.booleanValue()) {
                    dbVar2 = JoinGuildVerifyFragment.this.binding;
                    if (dbVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        dbVar3 = dbVar2;
                    }
                    dbVar3.f442873e.o();
                    return;
                }
                dbVar = JoinGuildVerifyFragment.this.binding;
                if (dbVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    dbVar3 = dbVar;
                }
                dbVar3.f442873e.setBackgroundDisabled();
            }
        };
        a26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                JoinGuildVerifyFragment.Gh(Function1.this, obj);
            }
        });
        MutableLiveData<JoinGuildVerifyViewModel.JoinResult> X1 = Dh().X1();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final JoinGuildVerifyFragment$initData$4 joinGuildVerifyFragment$initData$4 = new Function1<JoinGuildVerifyViewModel.JoinResult, Unit>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyFragment$initData$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JoinGuildVerifyViewModel.JoinResult joinResult) {
                invoke2(joinResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JoinGuildVerifyViewModel.JoinResult joinResult) {
                bv b16 = com.tencent.mobileqq.guild.channel.joinchannel.b.b();
                if (b16 != null) {
                    b16.a(joinResult.getResult(), joinResult.getErrorMsg(), joinResult.getSecurity(), joinResult.getJoinGuildsRest());
                }
            }
        };
        X1.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                JoinGuildVerifyFragment.Hh(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> c26 = Dh().c2();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<Integer, Unit> function14 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyFragment$initData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                if (num != null && num.intValue() == 2) {
                    JoinGuildVerifyFragment.this.onBackEvent();
                }
            }
        };
        c26.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                JoinGuildVerifyFragment.Ih(Function1.this, obj);
            }
        });
        if (this.jumpParam != null && this.joinGuildSetting != null) {
            JoinGuildVerifyViewModel Dh = Dh();
            JumpGuildParam jumpGuildParam2 = this.jumpParam;
            Intrinsics.checkNotNull(jumpGuildParam2);
            IGProJoinGuildSetting iGProJoinGuildSetting = this.joinGuildSetting;
            Intrinsics.checkNotNull(iGProJoinGuildSetting);
            Dh.d2(jumpGuildParam2, iGProJoinGuildSetting);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "error param jumpParam:" + this.jumpParam + " joinGuildSetting:" + this.joinGuildSetting;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.join.verify.JoinGuildVerifyFragment", 1, (String) it.next(), null);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void initView() {
        db dbVar = this.binding;
        db dbVar2 = null;
        if (dbVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dbVar = null;
        }
        dbVar.f442872d.setAdapter(Ch());
        db dbVar3 = this.binding;
        if (dbVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dbVar3 = null;
        }
        c cVar = new c(dbVar3.f442872d.getContext());
        db dbVar4 = this.binding;
        if (dbVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dbVar4 = null;
        }
        dbVar4.f442872d.setLayoutManager(cVar);
        db dbVar5 = this.binding;
        if (dbVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dbVar5 = null;
        }
        dbVar5.f442872d.setItemAnimator(null);
        db dbVar6 = this.binding;
        if (dbVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dbVar2 = dbVar6;
        }
        QUIButton qUIButton = dbVar2.f442873e;
        Intrinsics.checkNotNullExpressionValue(qUIButton, "binding.submitBtn");
        qUIButton.setOnClickListener(new b(qUIButton, this));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        Window window;
        super.initWindowStyleAndAnimation(activity);
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a9, code lost:
    
        if (r0 == null) goto L31;
     */
    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onBackEvent() {
        IPerformanceReportTask iPerformanceReportTask;
        Integer num;
        bv b16 = com.tencent.mobileqq.guild.channel.joinchannel.b.b();
        JoinGuildVerifyViewModel.JoinResult lastRequestResult = Dh().getLastRequestResult();
        Integer num2 = null;
        if (lastRequestResult != null) {
            if (b16 == null && !com.tencent.mobileqq.guild.channel.joinchannel.g.f214997a.a(lastRequestResult.getResult())) {
                QQToastUtil.showQQToast(0, lastRequestResult.getErrorMsg());
            } else if (b16 != null) {
                b16.a(lastRequestResult.getResult(), lastRequestResult.getErrorMsg(), lastRequestResult.getSecurity(), lastRequestResult.getJoinGuildsRest());
            }
            Intent intent = new Intent();
            intent.putExtra("RESULT_EXTRA_CODE", lastRequestResult.getResult());
            intent.putExtra("RESULT_EXTRA_MSG", lastRequestResult.getErrorMsg());
            intent.putExtra("RESuLT_EXTRA_SECURITY_INFO", lastRequestResult.getSecurity());
            if (getQBaseActivity() != null) {
                getQBaseActivity().setResult(-1, intent);
            }
            IPerformanceReportTask iPerformanceReportTask2 = this.reportTask;
            if (iPerformanceReportTask2 != null) {
                iPerformanceReportTask2.setResultCode(lastRequestResult.getResult());
            }
            IPerformanceReportTask iPerformanceReportTask3 = this.reportTask;
            if (iPerformanceReportTask3 != null) {
                iPerformanceReportTask3.setResultMsg(lastRequestResult.getErrorMsg());
            }
            IPerformanceReportTask iPerformanceReportTask4 = this.reportTask;
            if (iPerformanceReportTask4 != null) {
                IGProJoinGuildSetting iGProJoinGuildSetting = this.joinGuildSetting;
                if (iGProJoinGuildSetting != null) {
                    num = Integer.valueOf(iGProJoinGuildSetting.getOptionType());
                } else {
                    num = null;
                }
                iPerformanceReportTask4.setParam("join_option", String.valueOf(num));
            }
            IPerformanceReportTask iPerformanceReportTask5 = this.reportTask;
            if (iPerformanceReportTask5 != null) {
                iPerformanceReportTask = iPerformanceReportTask5.report();
            } else {
                iPerformanceReportTask = null;
            }
        }
        if (getQBaseActivity() != null) {
            getQBaseActivity().setResult(0, new Intent());
        }
        IPerformanceReportTask iPerformanceReportTask6 = this.reportTask;
        if (iPerformanceReportTask6 != null) {
            iPerformanceReportTask6.setResultCode(1000L);
        }
        IPerformanceReportTask iPerformanceReportTask7 = this.reportTask;
        if (iPerformanceReportTask7 != null) {
            iPerformanceReportTask7.setResultMsg("canceled");
        }
        IPerformanceReportTask iPerformanceReportTask8 = this.reportTask;
        if (iPerformanceReportTask8 != null) {
            IGProJoinGuildSetting iGProJoinGuildSetting2 = this.joinGuildSetting;
            if (iGProJoinGuildSetting2 != null) {
                num2 = Integer.valueOf(iGProJoinGuildSetting2.getOptionType());
            }
            iPerformanceReportTask8.setParam("join_option", String.valueOf(num2));
        }
        IPerformanceReportTask iPerformanceReportTask9 = this.reportTask;
        if (iPerformanceReportTask9 != null) {
            iPerformanceReportTask9.report();
        }
        InputMethodUtil.hide(getActivity());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        db g16 = db.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.binding = g16;
        db dbVar = null;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            db dbVar2 = this.binding;
            if (dbVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dbVar2 = null;
            }
            dbVar2.f442874f.setFitsSystemWindows(true);
            db dbVar3 = this.binding;
            if (dbVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dbVar3 = null;
            }
            dbVar3.f442874f.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
            ph();
        }
        db dbVar4 = this.binding;
        if (dbVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dbVar4 = null;
        }
        dbVar4.f442871c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinGuildVerifyFragment.Jh(JoinGuildVerifyFragment.this, view);
            }
        });
        db dbVar5 = this.binding;
        if (dbVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dbVar5 = null;
        }
        SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(dbVar5.getRoot());
        softKeyboardStateHelper.addSoftKeyboardStateListener(new d());
        this.keyboardHelper = softKeyboardStateHelper;
        db dbVar6 = this.binding;
        if (dbVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dbVar = dbVar6;
        }
        LinearLayout root = dbVar.getRoot();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (com.tencent.mobileqq.guild.channel.joinchannel.b.b() != null) {
            Logger.f235387a.d().w("Guild.join.verify.JoinGuildVerifyFragment", 1, "onDestroy unused callback.");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        db dbVar = this.binding;
        db dbVar2 = null;
        if (dbVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dbVar = null;
        }
        dbVar.f442874f.setBackgroundColor(view.getResources().getColor(R.color.qui_common_bg_bottom_standard));
        db dbVar3 = this.binding;
        if (dbVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dbVar2 = dbVar3;
        }
        dbVar2.f442870b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                JoinGuildVerifyFragment.Kh(JoinGuildVerifyFragment.this, view2);
            }
        });
        initData();
        initView();
        JumpGuildParam jumpGuildParam = this.jumpParam;
        if (jumpGuildParam != null) {
            String str = jumpGuildParam.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "it.guildId");
            Mh(str);
            Lh();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyFragment$d", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            SimpleEventBus.getInstance().dispatchEvent(new OnKeyboardClosedEvent(""));
        }

        @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        }
    }
}
