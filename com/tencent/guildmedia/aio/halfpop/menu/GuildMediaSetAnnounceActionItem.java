package com.tencent.guildmedia.aio.halfpop.menu;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.halfpop.RoundAngleLinearLayout;
import com.tencent.guild.aio.halfpop.menu.SetChosenActionItem;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildmedia.aio.halfpop.menu.GuildMediaSetAnnounceActionItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.EssenceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vn0.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001cB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b`\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guildmedia/aio/halfpop/menu/GuildMediaSetAnnounceActionItem;", "Lcom/tencent/guild/aio/halfpop/menu/SetChosenActionItem;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "", "V", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "J", "", "U", ExifInterface.LATITUDE_SOUTH, "T", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "t", "Landroid/view/View;", "view", UserInfo.SEX_FEMALE, "L", ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "j", "a", "SetDialog", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaSetAnnounceActionItem extends SetChosenActionItem {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guildmedia/aio/halfpop/menu/GuildMediaSetAnnounceActionItem$SetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "", "onStart", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "Lkotlin/Function0;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "getSetAnnounce", "()Lkotlin/jvm/functions/Function0;", "setAnnounce", "Lvn0/m;", "D", "Lvn0/m;", "binding", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class SetDialog extends BottomSheetDialogFragment {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final Function0<Unit> setAnnounce;

        /* renamed from: D, reason: from kotlin metadata */
        private m binding;

        public SetDialog(@NotNull Function0<Unit> setAnnounce) {
            Intrinsics.checkNotNullParameter(setAnnounce, "setAnnounce");
            this.setAnnounce = setAnnounce;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void rh(SetDialog this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setAnnounce.invoke();
            this$0.dismissAllowingStateLoss();
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void sh(SetDialog this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.dismissAllowingStateLoss();
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
        @NotNull
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
            Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
            Window window = onCreateDialog.getWindow();
            if (window != null) {
                window.setDimAmount(0.5f);
                window.setBackgroundDrawableResource(R.drawable.lvj);
            }
            return onCreateDialog;
        }

        @Override // androidx.fragment.app.Fragment
        @NotNull
        public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            m g16 = m.g(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
            this.binding = g16;
            m mVar = null;
            if (g16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                g16 = null;
            }
            g16.getRoot().setBackgroundResource(R.drawable.guild_media_aio_msgmenu_bg_dark);
            m mVar2 = this.binding;
            if (mVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                mVar2 = null;
            }
            mVar2.f441978c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.halfpop.menu.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildMediaSetAnnounceActionItem.SetDialog.rh(GuildMediaSetAnnounceActionItem.SetDialog.this, view);
                }
            });
            m mVar3 = this.binding;
            if (mVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                mVar3 = null;
            }
            mVar3.f441977b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.halfpop.menu.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildMediaSetAnnounceActionItem.SetDialog.sh(GuildMediaSetAnnounceActionItem.SetDialog.this, view);
                }
            });
            m mVar4 = this.binding;
            if (mVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                mVar = mVar4;
            }
            RoundAngleLinearLayout root = mVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
            return root;
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onStart() {
            View view;
            Window window;
            super.onStart();
            Dialog dialog = getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                view = window.findViewById(R.id.ugk);
            } else {
                view = null;
            }
            if (view != null) {
                view.setBackground(null);
            }
        }
    }

    public GuildMediaSetAnnounceActionItem() {
        super(new t.ItemData(R.drawable.guild_menu_icon_media_announce, R.string.f1648326w), "pg_sgrp_avchannel_aio");
    }

    private final HashMap<String, Object> J(GuildMsgItem data) {
        String str;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        int i3;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (R()) {
            str = "pg_sgrp_avchannel_announcement_detail";
        } else {
            str = "pg_sgrp_avchannel_aio";
        }
        hashMap.put("dt_pgid", str);
        if (U(data)) {
            hashMap.put("eid", "em_sgrp_remove_announcement");
        } else {
            hashMap.put("eid", "em_sgrp_set_announcement");
        }
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        hashMap.put("sgrp_channel_id", com.tencent.guild.aio.util.a.g(g16));
        AIOParam g17 = h().g();
        Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
        hashMap.put("sgrp_sub_channel_id", com.tencent.guild.aio.util.a.b(g17));
        HashMap hashMap2 = new HashMap();
        AIOParam g18 = h().g();
        Intrinsics.checkNotNullExpressionValue(g18, "aioContext.aioParam");
        hashMap2.put("sgrp_channel_id", com.tencent.guild.aio.util.a.g(g18));
        AIOParam g19 = h().g();
        Intrinsics.checkNotNullExpressionValue(g19, "aioContext.aioParam");
        hashMap2.put("sgrp_sub_channel_id", com.tencent.guild.aio.util.a.b(g19));
        if (R()) {
            hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, 1);
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            ArrayList<IGProTopMsg> arrayList = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            } else {
                iRuntimeService = null;
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null) {
                AIOParam g26 = h().g();
                Intrinsics.checkNotNullExpressionValue(g26, "aioContext.aioParam");
                IGProChannelInfo channelInfo = iGPSService.getChannelInfo(com.tencent.guild.aio.util.a.g(g26));
                if (channelInfo != null) {
                    arrayList = channelInfo.getTopMsgList();
                }
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            hashMap2.put("sgrp_announcement_state", Integer.valueOf(i3 ^ 1));
        }
        hashMap.put("cur_pg", hashMap2);
        return hashMap;
    }

    private final long Q(GuildMsgItem data) {
        GrayTipElement grayTipElement;
        EssenceElement essenceElement;
        MsgElement firstTypeElement = data.getFirstTypeElement(8);
        if (firstTypeElement != null && (grayTipElement = firstTypeElement.grayTipElement) != null && (essenceElement = grayTipElement.essenceElement) != null) {
            return essenceElement.msgSeq;
        }
        return 0L;
    }

    private final boolean R() {
        return Intrinsics.areEqual(h().g().n(), com.tencent.guildmedia.aio.factory.b.class.getName());
    }

    private final boolean S(GuildMsgItem data) {
        if (data.getViewType() == 51) {
            return true;
        }
        return false;
    }

    private final boolean T(GuildMsgItem data) {
        ArrayList<IGProTopMsg> topMsgList;
        Object lastOrNull;
        if (!S(data)) {
            return false;
        }
        long Q = Q(data);
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        IGProChannelInfo c16 = com.tencent.guild.aio.util.a.c(g16);
        if (c16 != null && (topMsgList = c16.getTopMsgList()) != null) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) topMsgList);
            IGProTopMsg iGProTopMsg = (IGProTopMsg) lastOrNull;
            if (iGProTopMsg == null) {
                return false;
            }
            long topMsgSeq = iGProTopMsg.getTopMsgSeq();
            if (topMsgSeq <= 0 || Q != topMsgSeq) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final boolean U(GuildMsgItem data) {
        if (!R() && !T(data)) {
            return false;
        }
        return true;
    }

    private final void V(GuildMsgItem data) {
        long msgSeq;
        if (!NetworkUtil.isNetworkAvailable(h().c().getContext())) {
            QQToast.makeText(j().getHostContext(), HardCodeUtil.qqStr(R.string.f153141ba), 0).show();
            return;
        }
        eo0.c value = K().getValue();
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = h().g();
        Intrinsics.checkNotNullExpressionValue(g18, "aioContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g18);
        if (S(data)) {
            msgSeq = Q(data);
        } else {
            msgSeq = data.getMsgSeq();
        }
        value.e(g17, b16, msgSeq);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.SetChosenActionItem, com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        VideoReport.reportEvent("clck", p().f441955d, J(data));
        j().o8();
        if (U(data)) {
            V(data);
            return;
        }
        FragmentManager childFragmentManager = h().c().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "aioContext.fragment.childFragmentManager");
        new SetDialog(new Function0<Unit>() { // from class: com.tencent.guildmedia.aio.halfpop.menu.GuildMediaSetAnnounceActionItem$onItemClick$1
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
                GuildMediaSetAnnounceActionItem.this.L();
            }
        }).show(childFragmentManager, "LiveMediaSetAnnounceActionItem.SetDialog");
    }

    @Override // com.tencent.guild.aio.halfpop.menu.SetChosenActionItem
    public void L() {
        if (!NetworkUtil.isNetworkAvailable(h().c().getContext())) {
            String qqStr = HardCodeUtil.qqStr(R.string.f153061b3);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.guild.\u2026ild_resp_announce_no_net)");
            QQToast.makeText(j().getHostContext(), qqStr, 0).show();
            return;
        }
        eo0.c value = K().getValue();
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        if (value.c(com.tencent.guild.aio.util.a.b(g16), i().getMsgSeq())) {
            String qqStr2 = HardCodeUtil.qqStr(R.string.f141070fo);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.guild.\u2026nel_announce_already_set)");
            QQToast.makeText(j().getHostContext(), qqStr2, 0).show();
            return;
        }
        K().getValue().l(i(), 1);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.SetChosenActionItem, com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.a
    /* renamed from: s */
    public void o(@NotNull GuildMsgItem data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        boolean U = U(data);
        if (U) {
            p().f441955d.setText(R.string.f1648426x);
            p().f441953b.setBackground(ie0.a.f().o(v(), R.drawable.qui_sign_out, R.color.qui_common_icon_white, 1002));
        } else {
            p().f441955d.setText(getItemInfo().getItemTitleRes());
            p().f441953b.setBackgroundResource(getItemInfo().getLeftDrawableRes());
        }
        if (U) {
            str = "em_sgrp_remove_announcement";
        } else {
            str = "em_sgrp_set_announcement";
        }
        HashMap<String, Object> J = J(data);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(p().f441955d, str, J);
        VideoReport.reportEvent("imp", p().f441955d, J);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.SetChosenActionItem, com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.isWalletMsg() || !vs0.a.g(data)) {
            return false;
        }
        if (S(data) && !T(data)) {
            return false;
        }
        return vs0.a.f(h());
    }
}
