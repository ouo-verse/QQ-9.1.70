package com.tencent.aelight.camera.entry.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aelight.camera.ae.flashshow.WinkCaptureFragment;
import com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.magicstudio.ImageCreationFragment;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioLogicFragment;
import com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment;
import com.tencent.mobileqq.wink.magicstudio.WinkMagicStudioResultFragment;
import com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioSettingFragment;
import gq.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECameraLauncherImpl implements IAECameraLauncher {
    private int getFragmentContainerViewId(FragmentActivity fragmentActivity) {
        return fragmentActivity instanceof WinkHomeActivity ? R.id.rxr : R.id.ckj;
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public boolean isCameraResReady() {
        return c.b();
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public boolean isFlashCameraResReady() {
        return c.h();
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public void launchAECameraUnit(Activity activity, int i3, Bundle bundle) {
        c.p(activity, i3, bundle);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public void launchMagicStudioResultFragment(FragmentActivity fragmentActivity, Bundle bundle) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction addToBackStack = supportFragmentManager.beginTransaction().add(getFragmentContainerViewId(fragmentActivity), WinkMagicStudioResultFragment.INSTANCE.a(bundle), "AIGCImgSelect").addToBackStack("AIGCImgSelect");
        Fragment findFragmentById = supportFragmentManager.findFragmentById(getFragmentContainerViewId(fragmentActivity));
        if (findFragmentById != null) {
            addToBackStack.hide(findFragmentById);
        }
        addToBackStack.commitAllowingStateLoss();
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public void winkLaunchAIGCImgCreateFragment(FragmentActivity fragmentActivity, Bundle bundle) {
        FragmentTransaction beginTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        if (fragmentActivity instanceof WinkHomeActivity) {
            beginTransaction.replace(getFragmentContainerViewId(fragmentActivity), ImageCreationFragment.th(bundle), "AIGCImgCreate");
        } else {
            beginTransaction.add(getFragmentContainerViewId(fragmentActivity), ImageCreationFragment.th(bundle), "AIGCImgCreate");
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public Fragment winkLaunchAIGCLogicFragment(FragmentActivity fragmentActivity) {
        MagicStudioLogicFragment magicStudioLogicFragment = new MagicStudioLogicFragment();
        fragmentActivity.getSupportFragmentManager().beginTransaction().add(magicStudioLogicFragment, "AIGC_LOGIC").commitAllowingStateLoss();
        return magicStudioLogicFragment;
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public void winkLaunchAIGCMultiSelectFragment(FragmentActivity fragmentActivity, Bundle bundle) {
        FragmentTransaction addToBackStack = fragmentActivity.getSupportFragmentManager().beginTransaction().add(getFragmentContainerViewId(fragmentActivity), MultiSelectFragment.ri(bundle), "AIGCImgSelect").addToBackStack("AIGCImgSelect");
        Fragment findFragmentById = fragmentActivity.getSupportFragmentManager().findFragmentById(getFragmentContainerViewId(fragmentActivity));
        if (findFragmentById != null) {
            addToBackStack.hide(findFragmentById);
        }
        addToBackStack.commitAllowingStateLoss();
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public void winkLaunchAIGCSettingFragment(FragmentActivity fragmentActivity, String str) {
        fragmentActivity.getSupportFragmentManager().beginTransaction().add(getFragmentContainerViewId(fragmentActivity), WinkQZoneMagicStudioSettingFragment.INSTANCE.a(str), "MAGIC_STUDIO_SETTING").addToBackStack("MAGIC_STUDIO_SETTING").commitAllowingStateLoss();
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public boolean isCameraResReady(IAEMultiDownloadCallBack iAEMultiDownloadCallBack) {
        return c.c(iAEMultiDownloadCallBack);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public boolean isFlashCameraResReady(String str, boolean z16) {
        return c.i(str, z16);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public boolean isCameraResReady(String str) {
        return c.d(str);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public void launchAEMultiCamera(Context context, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        c.r(context, bundle);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public void winkLaunchAECameraFragment(FragmentActivity fragmentActivity, Bundle bundle) {
        String string = bundle != null ? bundle.getString("camera_fragment_tag") : null;
        fragmentActivity.getSupportFragmentManager().beginTransaction().add(getFragmentContainerViewId(fragmentActivity), new WinkCaptureFragment(bundle), string).addToBackStack(string).commitAllowingStateLoss();
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public void winkLaunchAECameraFragmentForAIGCHB(FragmentActivity fragmentActivity, Bundle bundle) {
        String string = bundle != null ? bundle.getString("camera_fragment_tag") : null;
        fragmentActivity.getSupportFragmentManager().beginTransaction().add(android.R.id.content, new WinkCaptureFragment(bundle), string).addToBackStack(string).commitAllowingStateLoss();
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraLauncher
    public void winkLaunchAECameraFragmentForMagicStudio(FragmentActivity fragmentActivity, Bundle bundle) {
        fragmentActivity.getSupportFragmentManager().beginTransaction().add(getFragmentContainerViewId(fragmentActivity), new WinkCaptureFragment(bundle), bundle != null ? bundle.getString("camera_fragment_tag") : null).commitAllowingStateLoss();
    }
}
