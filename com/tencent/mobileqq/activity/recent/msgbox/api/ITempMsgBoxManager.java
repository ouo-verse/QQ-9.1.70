package com.tencent.mobileqq.activity.recent.msgbox.api;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes10.dex */
public interface ITempMsgBoxManager extends IRuntimeService {
    boolean configContains(int i3);

    List<RecentUser> getMsgBoxRecentUsers();

    boolean isBelongToFilterBox(String str, int i3);

    boolean isBelongToMsgBox(String str, int i3);

    boolean isMsgBoxRead();

    boolean msgBoxSwitch();

    void setMsgBoxRead(boolean z16);

    void updateIsTop(String str, int i3, boolean z16);
}
