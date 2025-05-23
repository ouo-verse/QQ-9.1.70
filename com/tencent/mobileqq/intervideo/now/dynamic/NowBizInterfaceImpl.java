package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import com.tencent.intervideo.nowproxy.ability.ExtSdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBizAbilityImpl;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.IHostCallback;
import com.tencent.qqinterface.NowBizInterface;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NowBizInterfaceImpl implements NowBizInterface {
    private static final String TAG = "NowBizInterfaceImpl";
    SdkBizAbilityImpl bizImpl = SdkBizAbilityImpl.getInstance();

    @Override // com.tencent.qqinterface.NowBizInterface
    public void doActionResult(long j3, String str) {
        SdkBizAbilityImpl.getInstance().onDoActionResult(j3, str);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public Bitmap getCoverImg(String str) {
        return ExtSdkBizAbilityImpl.getInstance().getCoverImg(str);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public ExecutorService getFixedThreadPool(int i3) {
        return this.bizImpl.getFixedThreadPool(i3);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void getRecordInfo(Bundle bundle, CommonCallback<Bundle> commonCallback) {
        this.bizImpl.getRecordInfo(bundle, commonCallback);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public boolean isNowLivePushEnable() {
        return ExtSdkBizAbilityImpl.getInstance().isNowLivePushEnable();
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void notifyCoreAction(Bundle bundle) {
        ExtSdkBizAbilityImpl.getInstance().notifyCoreAction(bundle);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void onLiveOverIsInstalled(boolean z16) {
        Log.d("Login_Exception", "getLiveOverPluginState--from-pm---onLiveOverIsInstalled=" + z16);
        ExtSdkBizAbilityImpl.getInstance().onLiveOverIsInstalled(z16);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void onLoginExpired(int i3) {
        Log.e("Login_Exception", "onLoginExpired----------");
        this.bizImpl.onLoginExpired(i3);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void onNoLogin() {
        Log.e("Login_Exception", "onNoLogin----------");
        this.bizImpl.onNoLogin();
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void onPluginActivityLifecycleEvent(Bundle bundle) {
        ExtSdkBizAbilityImpl.getInstance().onActivityLifecycle(bundle);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void openLiveHall() {
        ExtSdkBizAbilityImpl.getInstance().openLiveHall();
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void openNowLivePushSetting(CommonCallback commonCallback) {
        ExtSdkBizAbilityImpl.getInstance().openNowLivePlushSetting(commonCallback);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void openPayPage(Bundle bundle, CommonCallback commonCallback) {
        ExtSdkBizAbilityImpl.getInstance().openPayPage(bundle, commonCallback);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void openPhoneAuthPage() {
        ExtSdkBizAbilityImpl.getInstance().openPhoneAuthPage();
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void openWxMiniProgram(String str) {
        ExtSdkBizAbilityImpl.getInstance().openWxMiniProgram(str);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void queryPhoneAuthState() {
        ExtSdkBizAbilityImpl.getInstance().queryPhoneAuthState();
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void reportWelfareTask(String str, String str2) {
        ExtSdkBizAbilityImpl.getInstance().reportWelfareTask(str, str2);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void setBizIntent(Intent intent) {
        ExtSdkBizAbilityImpl.getInstance().setBizIntent(intent);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void setHostCallback(IHostCallback iHostCallback) {
        this.bizImpl.setHostCallBack(iHostCallback);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void share(Bundle bundle) {
        ExtSdkBizAbilityImpl.getInstance().share(bundle);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void shareToQQ(Bundle bundle) {
        this.bizImpl.shareToQQ(bundle);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void showBiuComponent(Bundle bundle) {
        this.bizImpl.jumpToKandianBiu(bundle);
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void onEnterRoom(Bundle bundle) {
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void onFirstFrameShow(Bundle bundle) {
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void onRoomActivityOnCreate(Bundle bundle) {
    }

    @Override // com.tencent.qqinterface.NowBizInterface
    public void reportData(Bundle bundle) {
    }
}
