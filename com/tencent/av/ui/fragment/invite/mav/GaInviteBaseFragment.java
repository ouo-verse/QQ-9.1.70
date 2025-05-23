package com.tencent.av.ui.fragment.invite.mav;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class GaInviteBaseFragment extends QPublicBaseFragment {
    public long getGroupId() {
        return 0L;
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        return false;
    }

    public int qh() {
        return 0;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
    }

    public void ph(View view) {
    }

    public void onBackPressed() {
    }
}
