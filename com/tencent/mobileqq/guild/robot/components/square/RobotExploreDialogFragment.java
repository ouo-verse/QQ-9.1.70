package com.tencent.mobileqq.guild.robot.components.square;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.bs;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProQueryGlobalRobotSubscriptionReq;
import com.tencent.qqnt.kernel.nativeinterface.GProQueryGlobalRobotSubscriptionRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProSubscribeGlobalRobotReq;
import com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQueryGuildGlobalRobotSubscriptionCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.dh;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u00012\u00020\u00022\u00020\u0003:\u00016B\u0011\u0012\b\b\u0002\u0010&\u001a\u00020!\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010+\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\r0\r0'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/robot/components/square/RobotExploreDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/guild/widget/GuildSwitchButton$a;", "", "wh", "Kh", "Jh", "Dh", "yh", "Ah", "xh", "vh", "", "isChecked", "Gh", "Bh", "Ch", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/widget/GuildSwitchButton;", "onCheckedChanged", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "D", "Landroidx/lifecycle/MutableLiveData;", "isEnableGlobal", "E", "Z", "isGuildOwner", "Lvp1/dh;", UserInfo.SEX_FEMALE, "Lvp1/dh;", "binding", "<init>", "(Ljava/lang/String;)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class RobotExploreDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener, GuildSwitchButton.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> isEnableGlobal;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isGuildOwner;

    /* renamed from: F, reason: from kotlin metadata */
    private dh binding;

    public RobotExploreDialogFragment() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void Ah() {
        vh();
        xh();
    }

    private final void Bh() {
        ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).openRobotFaqPage(getContext(), this.guildId);
        dismiss();
    }

    private final void Ch() {
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).addGuildByShareUrl(getContext(), bs.j());
        dismiss();
    }

    private final void Dh() {
        ac g16 = sx1.f.g();
        if (g16 != null) {
            g16.queryGuildGlobalRobotSubscription(new GProQueryGlobalRobotSubscriptionReq("global_robot", MiscKt.l(this.guildId)), new IQueryGuildGlobalRobotSubscriptionCallback() { // from class: com.tencent.mobileqq.guild.robot.components.square.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IQueryGuildGlobalRobotSubscriptionCallback
                public final void onQueryGuildGlobalRobotSubscription(int i3, String str, GProQueryGlobalRobotSubscriptionRsp gProQueryGlobalRobotSubscriptionRsp) {
                    RobotExploreDialogFragment.Eh(RobotExploreDialogFragment.this, i3, str, gProQueryGlobalRobotSubscriptionRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(final RobotExploreDialogFragment this$0, int i3, String str, final GProQueryGlobalRobotSubscriptionRsp gProQueryGlobalRobotSubscriptionRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && gProQueryGlobalRobotSubscriptionRsp != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.robot.components.square.e
                @Override // java.lang.Runnable
                public final void run() {
                    RobotExploreDialogFragment.Fh(RobotExploreDialogFragment.this, gProQueryGlobalRobotSubscriptionRsp);
                }
            });
            return;
        }
        QLog.e("RobotExploreDialogFragment", 1, "queryGuildGlobalRobotSubscription| result=" + i3 + ", errMsg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(RobotExploreDialogFragment this$0, GProQueryGlobalRobotSubscriptionRsp gProQueryGlobalRobotSubscriptionRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isEnableGlobal.setValue(Boolean.valueOf(!gProQueryGlobalRobotSubscriptionRsp.subscriptions.isEmpty()));
    }

    private final void Gh(final boolean isChecked) {
        ac g16 = sx1.f.g();
        if (g16 != null) {
            g16.subscribeGuildGlobalRobot(new GProSubscribeGlobalRobotReq("global_robot", MiscKt.l(this.guildId), isChecked), new IGProRobotSimpleResultCallback() { // from class: com.tencent.mobileqq.guild.robot.components.square.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback
                public final void onResult(int i3, String str) {
                    RobotExploreDialogFragment.Hh(isChecked, this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(final boolean z16, final RobotExploreDialogFragment this$0, final int i3, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.robot.components.square.g
            @Override // java.lang.Runnable
            public final void run() {
                RobotExploreDialogFragment.Ih(i3, str, z16, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(int i3, String str, boolean z16, RobotExploreDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            QLog.e("RobotExploreDialogFragment", 1, "subscribeGuildGlobalRobot|result=" + i3 + ", errMsg=" + str + ", switch=" + z16);
            aa.d(R.string.f1521119i);
            return;
        }
        aa.h(HardCodeUtil.qqStr(R.string.f156431k7));
        this$0.isEnableGlobal.setValue(Boolean.valueOf(z16));
    }

    private final void Jh() {
        Dh();
    }

    private final void Kh() {
        boolean z16;
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        IGProGuildInfo guildInfo = ((IGPSService) runtimeService).getGuildInfo(this.guildId);
        if (guildInfo == null) {
            return;
        }
        if (guildInfo.getUserType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isGuildOwner = z16;
    }

    private final void vh() {
        int roundToInt;
        int roundToInt2;
        roundToInt = MathKt__MathJVMKt.roundToInt(bi.d() * 0.04f);
        dh dhVar = this.binding;
        dh dhVar2 = null;
        if (dhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dhVar = null;
        }
        dhVar.f442897b.setPadding(roundToInt, 0, roundToInt, 0);
        roundToInt2 = MathKt__MathJVMKt.roundToInt((((bi.d() - roundToInt) - QQGuildUIUtil.f(12.0f)) / 2) * 1.29f);
        dh dhVar3 = this.binding;
        if (dhVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dhVar3 = null;
        }
        ImageView imageView = dhVar3.f442900e;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.faqImage");
        v.i("https://downv6.qq.com/innovate/guild/i_am_developer.png", imageView);
        dh dhVar4 = this.binding;
        if (dhVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dhVar4 = null;
        }
        ViewGroup.LayoutParams layoutParams = dhVar4.f442899d.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.height = roundToInt2;
        dh dhVar5 = this.binding;
        if (dhVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dhVar5 = null;
        }
        dhVar5.f442899d.setLayoutParams(layoutParams2);
        dh dhVar6 = this.binding;
        if (dhVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dhVar6 = null;
        }
        ImageView imageView2 = dhVar6.f442903h;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.feedbackImage");
        v.i("https://downv6.qq.com/innovate/guild/i_am_guild_owner.png", imageView2);
        dh dhVar7 = this.binding;
        if (dhVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dhVar7 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = dhVar7.f442902g.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        layoutParams4.height = roundToInt2;
        dh dhVar8 = this.binding;
        if (dhVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dhVar8 = null;
        }
        dhVar8.f442902g.setLayoutParams(layoutParams4);
        dh dhVar9 = this.binding;
        if (dhVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dhVar9 = null;
        }
        dhVar9.f442899d.setOnClickListener(this);
        dh dhVar10 = this.binding;
        if (dhVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dhVar2 = dhVar10;
        }
        dhVar2.f442902g.setOnClickListener(this);
    }

    private final void wh() {
        Kh();
        Jh();
        yh();
    }

    private final void xh() {
        dh dhVar = null;
        if (this.isGuildOwner) {
            dh dhVar2 = this.binding;
            if (dhVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dhVar2 = null;
            }
            dhVar2.f442906k.setVisibility(0);
            dh dhVar3 = this.binding;
            if (dhVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dhVar3 = null;
            }
            dhVar3.f442908m.setVisibility(0);
            dh dhVar4 = this.binding;
            if (dhVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dhVar4 = null;
            }
            dhVar4.f442905j.setVisibility(0);
        } else {
            dh dhVar5 = this.binding;
            if (dhVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dhVar5 = null;
            }
            dhVar5.f442906k.setVisibility(8);
            dh dhVar6 = this.binding;
            if (dhVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dhVar6 = null;
            }
            dhVar6.f442908m.setVisibility(8);
            dh dhVar7 = this.binding;
            if (dhVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dhVar7 = null;
            }
            dhVar7.f442905j.setVisibility(8);
        }
        dh dhVar8 = this.binding;
        if (dhVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dhVar = dhVar8;
        }
        dhVar.f442904i.setOnCheckedChangeListener(this);
    }

    private final void yh() {
        MutableLiveData<Boolean> mutableLiveData = this.isEnableGlobal;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.robot.components.square.RobotExploreDialogFragment$bindObserver$1
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
                dh dhVar;
                dhVar = RobotExploreDialogFragment.this.binding;
                if (dhVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dhVar = null;
                }
                GuildSwitchButton guildSwitchButton = dhVar.f442904i;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildSwitchButton.setCheckedOnly(it.booleanValue());
            }
        };
        mutableLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.robot.components.square.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotExploreDialogFragment.zh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.guild.widget.GuildSwitchButton.a
    public void onCheckedChanged(@NotNull GuildSwitchButton view, boolean isChecked) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.vqj) {
            Gh(isChecked);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.v0n) {
            Bh();
        } else if (id5 == R.id.v4_) {
            Ch();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        dh g16 = dh.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        dh dhVar = this.binding;
        if (dhVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dhVar = null;
        }
        ViewParent parent = dhVar.getRoot().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        wh();
        Ah();
    }

    public RobotExploreDialogFragment(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.isEnableGlobal = new MutableLiveData<>(Boolean.FALSE);
    }

    public /* synthetic */ RobotExploreDialogFragment(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "0" : str);
    }
}
