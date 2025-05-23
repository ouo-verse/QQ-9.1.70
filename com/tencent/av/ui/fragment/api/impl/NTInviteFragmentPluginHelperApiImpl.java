package com.tencent.av.ui.fragment.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import com.tencent.av.ui.fragment.api.INTInviteFragmentPluginHelperApi;
import com.tencent.av.ui.fragment.invite.dav.VideoInviteBaseFragment;
import com.tencent.av.ui.fragment.invite.dav.a;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public class NTInviteFragmentPluginHelperApiImpl implements INTInviteFragmentPluginHelperApi {
    private WeakReference<VideoInviteBaseFragment> mNTFragment;

    @Override // com.tencent.av.ui.fragment.api.INTInviteFragmentPluginHelperApi
    public Fragment init(Activity activity, boolean z16) {
        a aVar = new a();
        aVar.c(activity);
        VideoInviteBaseFragment a16 = aVar.a(z16);
        this.mNTFragment = new WeakReference<>(a16);
        return a16;
    }

    @Override // com.tencent.av.ui.fragment.api.INTInviteFragmentPluginHelperApi
    public void onBackPressed() {
        WeakReference<VideoInviteBaseFragment> weakReference = this.mNTFragment;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mNTFragment.get().onBackPressed();
    }

    @Override // com.tencent.av.ui.fragment.api.INTInviteFragmentPluginHelperApi
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        WeakReference<VideoInviteBaseFragment> weakReference = this.mNTFragment;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.mNTFragment.get().onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.av.ui.fragment.api.INTInviteFragmentPluginHelperApi
    public void onNewIntent(Intent intent) {
        WeakReference<VideoInviteBaseFragment> weakReference = this.mNTFragment;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mNTFragment.get().onNewIntent(intent);
    }
}
