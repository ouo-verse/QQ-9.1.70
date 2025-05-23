package com.tencent.mobileqq.guild.channel.managev2.item.delete;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMsgIntent;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.b;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0018H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/delete/ChannelDeleteViewModel;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingBaseVM;", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "permissionInfo", "", "D", "Landroid/view/View;", "view", "u", "", "checkSelect", "y", BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, "v", "type", HippyTKDListViewAdapter.X, "w", "", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "l", "Lcom/tencent/mobileqq/guild/channel/managev2/b;", "t", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ChannelDeleteViewModel extends ChannelSettingBaseVM {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void A(final ChannelDeleteViewModel this$0, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            QQToastUtil.showQQToast(2, R.string.f141390gj);
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d(FrameworkVM.TAG, 1, "requestDeleteChannel success " + ((ChannelSettingMviContext) this$0.getMContext()).getParams().getChannelId() + " " + ((ChannelSettingMviContext) this$0.getMContext()).getParams().getChannelInfo().getApplicationId());
            }
            Function0.b(500, new Runnable() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.delete.d
                @Override // java.lang.Runnable
                public final void run() {
                    ChannelDeleteViewModel.B(ChannelDeleteViewModel.this);
                }
            });
            return;
        }
        this$0.s();
        SecurityTipHelperKt.F(((ChannelSettingMviContext) this$0.getMContext()).c().getContext(), i3, str, iGProSecurityResult, HardCodeUtil.qqStr(R.string.f141910hy), null, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void B(ChannelDeleteViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = ((ChannelSettingMviContext) this$0.getMContext()).c().getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C() {
        if (((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getType() != 2) {
            return;
        }
        si1.a.f433837a.b(((ChannelSettingMviContext) getMContext()).getParams().getGuildId(), ((ChannelSettingMviContext) getMContext()).getParams().getChannelId(), 1);
    }

    private final void D(dx permissionInfo) {
        updateUI(new ChannelSettingUIState.SettingItemEnableUIState(permissionInfo.a(20002)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        if (((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getType() != 2) {
            return;
        }
        si1.a.f433837a.a(((ChannelSettingMviContext) getMContext()).getParams().getGuildId(), ((ChannelSettingMviContext) getMContext()).getParams().getChannelId(), 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u(final View view) {
        boolean z16;
        List emptyList;
        Boolean bool;
        Pair pair;
        boolean z17 = false;
        if (((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getType() == 7) {
            String guildId = ((ChannelSettingMviContext) getMContext()).getParams().getGuildId();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            boolean contains = emptyList.contains(guildId);
            r rVar = r.f214743a;
            String str = "";
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(guildId);
            if (guildInfo != null) {
                bool = Boolean.valueOf(guildInfo.isMovePostSection());
            } else {
                bool = null;
            }
            if (contains) {
                pair = TuplesKt.to(Boolean.TRUE, "HardCode");
            } else if (bool == null) {
                pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
            } else {
                pair = TuplesKt.to(bool, "GuildInfo");
            }
            GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
            String str2 = guildDebugUtils.e().get(guildId);
            if (str2 != null) {
                str = str2;
            }
            Intrinsics.checkNotNullExpressionValue(str, "newFeedSquareResults.get(guildId) ?: \"\"");
            String pair2 = pair.toString();
            if (!Intrinsics.areEqual(str, pair2)) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + guildId + MsgSummary.STR_COLON + pair2);
                }
                guildDebugUtils.e().put(guildId, pair2);
            }
            if (((Boolean) pair.getFirst()).booleanValue()) {
                w(view);
                x(view, 1);
                x(view, 2);
                x(view, 4);
                FragmentActivity activity = ((ChannelSettingMviContext) getMContext()).c().getActivity();
                if (((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getOperationType() == 1) {
                    z17 = true;
                }
                GuildDeleteBoardConfirmDialog.e(activity, z17, ((ChannelSettingMviContext) getMContext()).getParams().getGuildId(), ((ChannelSettingMviContext) getMContext()).getParams().getChannelId(), new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.delete.ChannelDeleteViewModel$handleItemClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        if (i3 != 2) {
                            ChannelDeleteViewModel.this.y(i3 == 1 ? 0 : 1);
                        }
                        ChannelDeleteViewModel.this.v(view, i3);
                    }
                });
                return;
            }
        }
        w(view);
        x(view, 3);
        x(view, 4);
        C();
        FragmentActivity activity2 = ((ChannelSettingMviContext) getMContext()).c().getActivity();
        if (((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getOperationType() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        GuildDeleteSubChannelConfirmDialog.i(activity2, z16, ((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo(), ((ChannelSettingMviContext) getMContext()).getParams().getGuildId(), ((ChannelSettingMviContext) getMContext()).getParams().getChannelId(), view, new kotlin.jvm.functions.Function0<Unit>() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.delete.ChannelDeleteViewModel$handleItemClick$2
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
                ChannelDeleteViewModel.z(ChannelDeleteViewModel.this, 0, 1, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(View view, int checkSelect) {
        int i3;
        Map mapOf;
        if (checkSelect == 2) {
            i3 = checkSelect + 2;
        } else {
            i3 = checkSelect + 1;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", Integer.valueOf(i3)));
        ChannelSettingUtils.i(view, "em_sgrp_delete_panel", mapOf);
    }

    private final void w(View view) {
        ChannelSettingUtils.j(view, "em_sgrp_delete_btn", null, 4, null);
    }

    private final void x(View view, int type) {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", Integer.valueOf(type)));
        ChannelSettingUtils.g(view, "em_sgrp_delete_panel", mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void y(int checkSelect) {
        BusinessHandler businessHandler = ch.l().getBusinessHandler(QQGuildHandler.class.getName());
        if (businessHandler == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("getBusinessHandler isNull ");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(FrameworkVM.TAG, 1, (String) it.next(), null);
            }
            QQToastUtil.showQQToast(1, R.string.f141910hy);
            return;
        }
        ((QQGuildHandler) businessHandler).N2(((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo(), checkSelect, new cd() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.delete.c
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                ChannelDeleteViewModel.A(ChannelDeleteViewModel.this, i3, str, iGProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void z(ChannelDeleteViewModel channelDeleteViewModel, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        channelDeleteViewModel.y(i3);
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM
    public void l(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof ChannelSettingMsgIntent.PermissionChange) {
            D(((ChannelSettingMsgIntent.PermissionChange) intent).getPermissionInfo());
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM
    @NotNull
    public List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(ChannelSettingMsgIntent.PermissionChange.class).getQualifiedName());
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.guild.channel.managev2.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.C7685b) {
            u(((b.C7685b) intent).getView());
        }
    }
}
