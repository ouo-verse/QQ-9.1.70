package com.tencent.mobileqq.guild.channel.managev2.item.arrowform;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingUIState;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR(\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u000e0\u000e0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/m;", "Lcom/tencent/mobileqq/guild/channel/managev2/item/arrowform/h;", "", "mode", "", "v", "Landroid/view/View;", "view", HippyTKDListViewAdapter.X, "originView", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "y", "itemView", "", "elementId", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "permissionInfo", "r", "p", "", "f", "Ljava/util/List;", "modeTypes", "", "kotlin.jvm.PlatformType", tl.h.F, "Ljava/util/Map;", "publishModes", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class m extends h {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> modeTypes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, String> publishModes;

    public m() {
        List<Integer> listOf;
        Map<Integer, String> mapOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{3, 1, 2});
        this.modeTypes = listOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, HardCodeUtil.qqStr(R.string.f145390rc)), TuplesKt.to(3, HardCodeUtil.qqStr(R.string.f145390rc)), TuplesKt.to(1, HardCodeUtil.qqStr(R.string.f145370ra)), TuplesKt.to(2, HardCodeUtil.qqStr(R.string.f145380rb)));
        this.publishModes = mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(m this$0, View view, ActionSheet actionSheet, View view2, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        this$0.x(view);
        this$0.v(this$0.modeTypes.get(i3).intValue());
        actionSheet.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v(int mode) {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).updateForumChannelSortMode(((ChannelSettingMviContext) getMContext()).getParams().getGuildId(), ((ChannelSettingMviContext) getMContext()).getParams().getChannelId(), mode, new cd() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.arrowform.l
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                m.w(i3, str, iGProSecurityResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "sortMode modify code=" + i3 + " msg=" + str + " security=" + iGProSecurityResult;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.mnr.ChannelSettingArrowFormBaseViewModel", 1, (String) it.next(), null);
            }
            QQToastUtil.showQQToast(R.string.f145330r7);
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger2.d().d("Guild.mnr.ChannelSettingArrowFormBaseViewModel", 1, "sortMode modify code=0 msg=" + str + " security=" + iGProSecurityResult);
        }
        QQToastUtil.showQQToast(R.string.f145340r8);
    }

    private final void x(View view) {
        ChannelSettingUtils.j(view, "em_sgrp_sub_channel_set_forumsort", null, 4, null);
    }

    private final void y(View originView, ActionSheet actionSheet) {
        SparseArray<View> radioButtonArray = actionSheet.getRadioButtonArray();
        if (radioButtonArray == null) {
            return;
        }
        int size = radioButtonArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = radioButtonArray.get(i3);
            if (view != null) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            z(originView, view, "em_sgrp_sub_channel_set_forumsort_hot");
                        }
                    } else {
                        z(originView, view, "em_sgrp_sub_channel_set_forumsort_comment");
                    }
                } else {
                    z(originView, view, "em_sgrp_sub_channel_set_forumsort_publish");
                }
            }
        }
        VideoReport.traverseExposure();
    }

    private final void z(View originView, View itemView, String elementId) {
        VideoReport.setElementId(itemView, elementId);
        VideoReport.setLogicParent(itemView, originView);
        VideoReport.setElementClickPolicy(itemView, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(itemView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(itemView, EndExposurePolicy.REPORT_ALL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void p(@NotNull final View view) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        IGProChannelInfo channelInfo = ((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo();
        Dialog createDialog = ActionSheetHelper.createDialog(((ChannelSettingMviContext) getMContext()).c().getContext(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(HardCodeUtil.qqStr(R.string.f145430rg));
        actionSheet.addCancelButton(R.string.f140850f3);
        Iterator<T> it = this.modeTypes.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            String str = this.publishModes.get(Integer.valueOf(intValue));
            if (intValue == channelInfo.getForumSortMode()) {
                z16 = true;
            } else {
                z16 = false;
            }
            actionSheet.addRadioButton(str, z16);
        }
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.channel.managev2.item.arrowform.k
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view2, int i3) {
                m.u(m.this, view, actionSheet, view2, i3);
            }
        });
        actionSheet.show();
        y(view, actionSheet);
        ChannelSettingUtils.f215196a.m(actionSheet);
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void q(@NotNull ChannelSettingMviContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = this.publishModes.get(Integer.valueOf(context.getParams().getChannelInfo().getForumSortMode()));
        if (str == null) {
            str = "";
        }
        updateUI(new ChannelSettingUIState.SettingItemDescUIState(str));
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.item.arrowform.h
    public void r(@NotNull dx permissionInfo) {
        Intrinsics.checkNotNullParameter(permissionInfo, "permissionInfo");
        updateUI(new ChannelSettingUIState.SettingItemEnableUIState(permissionInfo.a(20011)));
    }
}
