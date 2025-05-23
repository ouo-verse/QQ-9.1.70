package com.tencent.mobileqq.guild.mainframe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u001a\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010'\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010+\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020\u000bH\u0016\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildRecycledMainFragment;", "Lcom/tencent/mobileqq/guild/mainframe/AbsGuildMainFragment;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "th", "qh", "xh", "", "tabChanged", "wh", "vh", "yh", "rh", "gg", "isSwitchAccount", "md", "uh", "ph", "isInMultiWindowMode", "onMultiWindowModeChanged", "Landroid/os/Bundle;", "extra", "handleJumpAction", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "isPlayAnim", "guildCenterPanelInOrOut", "height", "onPostThemeChanged", "setTabHeight", "guildTab", "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildUnreadCntService$b;", "tabUnreadCntInfo", "onTabChanged", "Landroid/view/View;", "view", "onGuildTabClick", "", "source", NodeProps.VISIBLE, "changeGuildFacadeVisible", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRecycledMainFragment extends AbsGuildMainFragment {
    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public boolean ph() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public boolean uh() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void gg() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void qh() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void rh() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void xh() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void yh() {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void handleJumpAction(@Nullable Bundle extra) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void md(boolean isSwitchAccount) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onGuildTabClick(@Nullable View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onPostThemeChanged(int height) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void setTabHeight(int height) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void vh(boolean tabChanged) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void wh(boolean tabChanged) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void changeGuildFacadeVisible(@Nullable String source, boolean visible) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void guildCenterPanelInOrOut(int showType, boolean isPlayAnim) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onTabChanged(boolean guildTab, @Nullable IGuildUnreadCntService.b tabUnreadCntInfo) {
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void th(int requestCode, int resultCode, @Nullable Intent data) {
    }
}
