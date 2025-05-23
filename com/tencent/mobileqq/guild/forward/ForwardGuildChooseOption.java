package com.tencent.mobileqq.guild.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ForwardGuildChooseOption extends ForwardBaseOption {
    public ForwardGuildChooseOption(Intent intent) {
        super(intent);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null && !Utils.J(recentUser.uin) && recentUser.getType() == 10014) {
                arrayList.add(recentUser);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean handleDialog() {
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean needSendMessage() {
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        if (bundle != null) {
            this.mExtraData.putAll(bundle);
        }
        realForwardTo(true);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onPause() {
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onResume() {
    }
}
