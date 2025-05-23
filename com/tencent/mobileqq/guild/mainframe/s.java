package com.tencent.mobileqq.guild.mainframe;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;

/* compiled from: P */
/* loaded from: classes14.dex */
public interface s {
    void changeGuildFacadeVisible(String str, boolean z16);

    void guildCenterPanelInOrOut(int i3, boolean z16);

    void handleJumpAction(Bundle bundle);

    void onGuildTabClick(View view);

    void onPostThemeChanged(int i3);

    void onTabChanged(boolean z16, IGuildUnreadCntService.b bVar);

    void setTabHeight(int i3);
}
