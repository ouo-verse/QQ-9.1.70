package com.tencent.av.ui.fragment.api.impl;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi;
import com.tencent.av.ui.fragment.invite.mav.GaInviteBaseFragment;
import com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment;
import com.tencent.av.ui.fragment.invite.mav.NTGaInviteFragment;
import com.tencent.av.ui.fragment.invite.mav.NTMultiIncomingCallsFragment;
import com.tencent.av.ui.o;
import com.tencent.av.ui.part.invite.multi.GaInviteHeadNamePart;
import com.tencent.mobileqq.theme.ThemeConstants;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public class NTGaInviteFragmentPluginHelperApiImpl implements INTGaInviteFragmentPluginHelperApi {
    private static final String TAG = "NTGaInviteFragmentPluginHelperApiImpl";
    GaInviteHeadNamePart.GetGaFaceRunnable mGetGaFace = null;
    private WeakReference<GaInviteBaseFragment> mNTFragment;

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public void btnOnClick(View view) {
        WeakReference<GaInviteBaseFragment> weakReference = this.mNTFragment;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mNTFragment.get().ph(view);
    }

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public long getGroupId() {
        WeakReference<GaInviteBaseFragment> weakReference = this.mNTFragment;
        if (weakReference == null || weakReference.get() == null) {
            return 0L;
        }
        return this.mNTFragment.get().getGroupId();
    }

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public int getUinType() {
        WeakReference<GaInviteBaseFragment> weakReference = this.mNTFragment;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return this.mNTFragment.get().qh();
    }

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public boolean isShowing() {
        return NTMultiIncomingCallsFragment.isShowing();
    }

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public void onBackPressed() {
        WeakReference<GaInviteBaseFragment> weakReference = this.mNTFragment;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mNTFragment.get().onBackPressed();
    }

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        WeakReference<GaInviteBaseFragment> weakReference = this.mNTFragment;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.mNTFragment.get().onKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public void onNewIntent(Intent intent) {
        WeakReference<GaInviteBaseFragment> weakReference = this.mNTFragment;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mNTFragment.get().onNewIntent(intent);
    }

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public Intent setIntentFrom(Intent intent, String str) {
        return intent.putExtra(ThemeConstants.THEME_DIY_BG_FROM_SUFFIX, str);
    }

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public void stopRefreshGaFaceUI() {
        GaInviteHeadNamePart.GetGaFaceRunnable getGaFaceRunnable = this.mGetGaFace;
        if (getGaFaceRunnable != null) {
            getGaFaceRunnable.cancel();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public String genGroupName(AppRuntime appRuntime, TextView textView, int i3, int i16, String str, long[] jArr) {
        return NTGaInviteBaseFragment.sh((VideoAppInterface) appRuntime, textView, i3, i16, str, jArr);
    }

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public void refreshGaFaceUI(String str, String str2, AppRuntime appRuntime, int i3, int i16, long j3, long j16, o oVar) {
        if (this.mGetGaFace == null) {
            this.mGetGaFace = new GaInviteHeadNamePart.GetGaFaceRunnable(str2, (VideoAppInterface) appRuntime, i3, i16, j3, j16, oVar);
        }
        this.mGetGaFace.a(str);
    }

    @Override // com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi
    public Fragment init(boolean z16) {
        if (z16) {
            this.mNTFragment = new WeakReference<>(new NTMultiIncomingCallsFragment());
        } else {
            this.mNTFragment = new WeakReference<>(new NTGaInviteFragment());
        }
        return this.mNTFragment.get();
    }
}
