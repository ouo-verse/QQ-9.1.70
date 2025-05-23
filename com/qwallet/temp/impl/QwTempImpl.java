package com.qwallet.temp.impl;

import android.os.Bundle;
import com.qwallet.temp.IQwTemp;
import com.qwallet.temp.ITroopGagMgr;
import com.tencent.av.ui.funchat.record.a;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.impl.d;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import d4.e;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QwTempImpl implements IQwTemp {
    private static final String TAG = "QwTempImpl";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements a.InterfaceC0762a {
        a() {
        }

        @Override // com.tencent.av.ui.funchat.record.a.InterfaceC0762a
        public void onError(int i3) {
            if (QLog.isColorLevel()) {
                QLog.i(QwTempImpl.TAG, 1, "convertMp3ToPcm onError " + i3);
            }
        }

        @Override // com.tencent.av.ui.funchat.record.a.InterfaceC0762a
        public void onFinish(String str) {
            if (QLog.isColorLevel()) {
                QLog.i(QwTempImpl.TAG, 1, "convertMp3ToPcm onFinish " + str);
            }
        }

        @Override // com.tencent.av.ui.funchat.record.a.InterfaceC0762a
        public void onStart(String str) {
            if (QLog.isColorLevel()) {
                QLog.i(QwTempImpl.TAG, 1, "convertMp3ToPcm onStart " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$uploadPtt$0(MessageForPtt messageForPtt, e eVar, BaseQQAppInterface baseQQAppInterface, p pVar, String str, int i3, int i16) {
        Bundle bundle = new Bundle();
        bundle.putInt("DiyTextId", messageForPtt.vipBubbleDiyTextId);
        eVar.a(baseQQAppInterface, pVar.f179555d, pVar.f179557e, str, messageForPtt.uniseq, false, i3, i16, true, 0, 5, true, messageForPtt.vipSubBubbleId, bundle, null, null, false, messageForPtt, 0);
    }

    @Override // com.qwallet.temp.IQwTemp
    public int AIOUtils$getLifeConst(String str) {
        if (str.equalsIgnoreCase("AIO_ON_NEWINTENT")) {
            return 1;
        }
        if (str.equalsIgnoreCase("AIO_ON_CTEATE")) {
            return 2;
        }
        if (str.equalsIgnoreCase("AIO_ON_RESUEME")) {
            return 4;
        }
        if (str.equalsIgnoreCase("AIO_ON_START")) {
            return 3;
        }
        if (str.equalsIgnoreCase("AIO_ON_PAUSE")) {
            return 5;
        }
        if (str.equalsIgnoreCase("AIO_ON_STOP")) {
            return 6;
        }
        if (str.equalsIgnoreCase("AIO_ON_FINISH")) {
            return 7;
        }
        if (str.equalsIgnoreCase("AIO_AFTER_FINISH")) {
            return 8;
        }
        return str.equalsIgnoreCase("AIO_ON_DESTROY") ? 9 : 1;
    }

    @Override // com.qwallet.temp.IQwTemp
    public String ContactUtils$getBuddyName(AppRuntime appRuntime, String str, boolean z16) {
        return ac.g(appRuntime, str, z16);
    }

    @Override // com.qwallet.temp.IQwTemp
    public String ContactUtils$getDateNickName(AppInterface appInterface, String str) {
        return ac.j(appInterface, str);
    }

    @Override // com.qwallet.temp.IQwTemp
    public boolean isUinSilencedInTroop(String str) {
        AppRuntime peekAppRuntime;
        if (MobileQQ.sProcessId == 1 && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            return ((ITroopGagMgr) peekAppRuntime.getRuntimeService(ITroopGagMgr.class, "")).isMySelfSilent(str);
        }
        return false;
    }

    @Override // com.qwallet.temp.IQwTemp
    public void mixSong(byte[] bArr, String str, String str2, RecordParams.RecorderParam recorderParam, String str3) {
        com.tencent.av.ui.funchat.record.a aVar = new com.tencent.av.ui.funchat.record.a(recorderParam.f307255d, 16, 1);
        aVar.d(new a());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            aVar.a(str, str3);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "convertMp3ToPcm decode exception:" + th5, th5);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "mp3 to pcm time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // com.qwallet.temp.IQwTemp
    public e newIChatActivityFacadeTemp() {
        return new com.qwallet.temp.impl.a();
    }

    @Override // com.qwallet.temp.IQwTemp
    public long uploadPtt(final p pVar, final String str, final int i3, final int i16) {
        final e newIChatActivityFacadeTemp = newIChatActivityFacadeTemp();
        final BaseQQAppInterface n3 = d.n();
        final MessageForPtt b16 = newIChatActivityFacadeTemp.b(n3, str, pVar, -2, i16);
        b16.voiceRedPacketFlag = 2;
        ThreadManagerV2.excute(new Runnable() { // from class: com.qwallet.temp.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                QwTempImpl.lambda$uploadPtt$0(MessageForPtt.this, newIChatActivityFacadeTemp, n3, pVar, str, i3, i16);
            }
        }, 128, null, false);
        return b16.uniseq;
    }

    @Override // com.qwallet.temp.IQwTemp
    public List<WebViewPlugin> getQWalletJsPlugins() {
        return Arrays.asList((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletPayJsPlugin(), (WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getPayJsPlugin(), (WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletCommonJsPlugin(), (WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletBluetoothJsPlugin(), (WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQQApiPlugin(), (WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getUIApiPlugin(), (WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getDataApiPlugin(), (WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getVasCommonJsPlugin(), (WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletCommonHbJsPlugin(), (WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getSensorAPIJavaScript(), (WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getMediaApiPlugin(), (WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getQWalletMixJsPlugin(), ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).getQWalletJSPlugin());
    }

    @Override // com.qwallet.temp.IQwTemp
    public void mediaPlayer_doStop(boolean z16, AppRuntime appRuntime) {
        MediaPlayerManager mediaPlayerManager;
        if (appRuntime == null || !(appRuntime instanceof QQAppInterface) || (mediaPlayerManager = (MediaPlayerManager) ((QQAppInterface) appRuntime).getManager(QQManagerFactory.MGR_MEDIA_PLAYER)) == null) {
            return;
        }
        mediaPlayerManager.D(z16);
    }
}
