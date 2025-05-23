package com.tencent.mobileqq.guild.channel.managev2.item.arrowform;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ISlowModeInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002JB\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\rH\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/ChannelSlowModeViewModel;", "Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/ISlowModeInfo;", "mode", "", "v", "", "code", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "", "msg", HippyTKDListViewAdapter.X, "Landroid/view/View;", "originView", "curKey", "", "list", "title", "Lkotlin/Function1;", NodeProps.ON_CLICK, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/widget/ActionSheet;", "actionSheet", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "itemView", "index", "y", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "permissionInfo", "r", "view", "p", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ChannelSlowModeViewModel extends h {
    /* JADX WARN: Multi-variable type inference failed */
    private final void A(View originView, int curKey, final List<? extends ISlowModeInfo> list, int title, final Function1<? super ISlowModeInfo, Unit> onClick) {
        boolean z16;
        Dialog createDialog = ActionSheetHelper.createDialog(((ChannelSettingMviContext) getMContext()).c().getContext(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(title);
        actionSheet.addCancelButton(R.string.f140850f3);
        for (ISlowModeInfo iSlowModeInfo : list) {
            String slowModeText = iSlowModeInfo.getSlowModeText();
            if (iSlowModeInfo.getSlowModeKey() == curKey) {
                z16 = true;
            } else {
                z16 = false;
            }
            actionSheet.addRadioButton(slowModeText, z16);
        }
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.arrowform.j
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ChannelSlowModeViewModel.B(ActionSheet.this, onClick, list, view, i3);
            }
        });
        actionSheet.show();
        z(originView, actionSheet);
        ChannelSettingUtils.f215196a.m(actionSheet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ActionSheet actionSheet, Function1 onClick, List list, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        Intrinsics.checkNotNullParameter(list, "$list");
        actionSheet.dismiss();
        onClick.invoke(list.get(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void v(ISlowModeInfo mode) {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).setChannelSlowMode(((ChannelSettingMviContext) getMContext()).getParams().getChannelId(), mode.getSlowModeKey(), new cd() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.arrowform.i
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                ChannelSlowModeViewModel.w(ChannelSlowModeViewModel.this, i3, str, iGProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ChannelSlowModeViewModel this$0, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x(i3, iGProSecurityResult, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(int code, IGProSecurityResult security, String msg2) {
        boolean z16 = true;
        if (code == 0 && ch.p(security)) {
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("Guild.mnr.ChannelSettingArrowFormBaseViewModel", 1, "slowMode modify code=0 msg=" + msg2 + " security=" + security);
            }
            QQToastUtil.showQQToast(2, R.string.f141900hx);
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "slowMode modify code=" + code + " msg=" + msg2 + " security=" + security;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.mnr.ChannelSettingArrowFormBaseViewModel", 1, (String) it.next(), null);
        }
        FragmentActivity activity = ((ChannelSettingMviContext) getMContext()).c().getActivity();
        if (activity == null || activity.isFinishing()) {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        SecurityTipHelperKt.F(((ChannelSettingMviContext) getMContext()).c().getContext(), code, msg2, security, HardCodeUtil.qqStr(R.string.f141910hy), null, 32, null);
    }

    private final void y(View originView, View itemView, int index) {
        VideoReport.setElementId(itemView, "em_sgrp_slowmode_type");
        VideoReport.setElementParam(itemView, "sgrp_role_slowmode_type", Integer.valueOf(index));
        VideoReport.setLogicParent(itemView, originView);
        VideoReport.setElementClickPolicy(itemView, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(itemView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(itemView, EndExposurePolicy.REPORT_ALL);
    }

    private final void z(View originView, ActionSheet actionSheet) {
        SparseArray<View> radioButtonArray = actionSheet.getRadioButtonArray();
        if (radioButtonArray == null) {
            return;
        }
        int size = radioButtonArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = radioButtonArray.get(i3);
            if (view != null) {
                y(originView, view, i3);
            }
        }
        VideoReport.traverseExposure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void p(@NotNull View view) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        IGProChannelInfo channelInfo = ((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo();
        ArrayList<ISlowModeInfo> gProSlowModeInfoList = channelInfo.getGProSlowModeInfoList();
        if (gProSlowModeInfoList != null && !gProSlowModeInfoList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("SlowModeClick withNothingToChoose. return!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.mnr.ChannelSettingArrowFormBaseViewModel", 1, (String) it.next(), null);
            }
            QQToastUtil.showQQToast(R.string.f155831ik);
            return;
        }
        if (channelInfo.getType() == 1) {
            int slowModeKey = channelInfo.getSlowModeKey();
            ArrayList<ISlowModeInfo> gProSlowModeInfoList2 = channelInfo.getGProSlowModeInfoList();
            Intrinsics.checkNotNullExpressionValue(gProSlowModeInfoList2, "channelInfo.gProSlowModeInfoList");
            A(view, slowModeKey, gProSlowModeInfoList2, R.string.f156901lg, new ChannelSlowModeViewModel$handleItemClick$2(this));
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void q(@NotNull ChannelSettingMviContext context) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        IGProChannelInfo channelInfo = context.getParams().getChannelInfo();
        int slowModeKey = channelInfo.getSlowModeKey();
        ArrayList<ISlowModeInfo> gProSlowModeInfoList = channelInfo.getGProSlowModeInfoList();
        String str = null;
        if (gProSlowModeInfoList != null) {
            Iterator<T> it = gProSlowModeInfoList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((ISlowModeInfo) obj).getSlowModeKey() == slowModeKey) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ISlowModeInfo iSlowModeInfo = (ISlowModeInfo) obj;
            if (iSlowModeInfo != null) {
                str = iSlowModeInfo.getSlowModeText();
            }
        }
        if (str == null) {
            str = "";
        }
        updateUI(new ChannelSettingUIState.SettingItemDescUIState(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void r(@NotNull dx permissionInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(permissionInfo, "permissionInfo");
        if (((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo().getType() == 1) {
            z16 = permissionInfo.a(20010);
        } else {
            z16 = false;
        }
        updateUI(new ChannelSettingUIState.SettingItemEnableUIState(z16));
    }
}
