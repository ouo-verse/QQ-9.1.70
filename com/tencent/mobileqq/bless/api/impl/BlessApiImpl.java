package com.tencent.mobileqq.bless.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.home.impl.a;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.SendTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.i;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.g;
import com.tencent.mobileqq.shortvideo.l;
import com.tencent.mobileqq.shortvideo.v;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BlessApiImpl implements IBlessApi {
    static IPatchRedirector $redirector_;

    public BlessApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void clearEditingWordings(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) appInterface);
        } else {
            ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).s();
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void clearUinListToSend(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) appInterface);
        } else {
            ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).t();
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public Object createShortVideoUploadInfo(Object obj, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return iPatchRedirector.redirect((short) 25, (Object) this, obj, obj2);
        }
        return l.c(obj, (v) obj2);
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getAvailableSendCount(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInterface)).intValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).z();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getAvailableUinCount(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) appInterface)).intValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).A();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getBlessManager_TYPE_PIC_Value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getBlessManager_TYPE_PTV_Value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getBlessManager_TYPE_TEXT_Value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getBlessManager_TYPE_UNKNOW_Value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getBlessManager_UPDATE_MSGTAB_NUM_Value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return 10;
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public Object getBlessReportParams(AppInterface appInterface, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return iPatchRedirector.redirect((short) 37, this, appInterface, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).E(i3, i16);
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void getEncodeQualityParamForSendTask(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) intent);
        } else {
            SendTask.a(intent);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public Object getPtvMessage(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return iPatchRedirector.redirect((short) 16, (Object) this, (Object) appInterface);
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).Q();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public String getPtvUrlByUuid(AppInterface appInterface, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, this, appInterface, str, str2);
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).R(str, str2);
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getSVBusiUtil_BUSI_TYPE_SHORTVIDEO_PTV_Value() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getTotalSendLimit(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appInterface)).intValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).Y();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getTotalUinLimit(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) appInterface)).intValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).a0();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public ArrayList<String> getUinListToSend(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).b0();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getWebAvailableSendCount(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface)).intValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).e0();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getWebAvailableUinCount(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appInterface)).intValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).f0();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getWebTotalSendLimit(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) appInterface)).intValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).h0();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public int getWebTotalUinLimit(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) appInterface)).intValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).i0();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void gotoSplashActivity(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, activity, Boolean.valueOf(z16));
            return;
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(activity);
        aliasIntent.putExtra("tab_index", a.f183038a);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.putExtra(i.f286265h, z16);
        aliasIntent.setFlags(67108864);
        activity.startActivity(aliasIntent);
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public boolean isSearchable(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) appInterface)).booleanValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).t0();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public boolean isUinBlessed(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) str)).booleanValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).w0(str);
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public boolean isUinListToSendChangedOnMem(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) appInterface)).booleanValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).x0();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public boolean isVideoSoLibLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return ShortVideoUtils.isVideoSoLibLoaded();
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public boolean isWebUinSended(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface, (Object) str)).booleanValue();
        }
        return ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).z0(str);
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void launchForShortVideoBusiManager(Object obj, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, obj, (Object) appInterface);
        } else {
            l.e((v) obj, (QQAppInterface) appInterface);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void loadShortVideoSo(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) appInterface);
        } else {
            ShortVideoUtils.loadShortVideoSo(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void openWebBlessActivity(AppInterface appInterface, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) appInterface, (Object) context);
        } else {
            ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).B0(context);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void preConnect(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) appInterface);
        } else {
            appInterface.getHwEngine().preConnect();
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void realStartEncode(Context context, String str, String str2, String str3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, context, str, str2, str3, Boolean.valueOf(z16), obj);
            return;
        }
        EncodeVideoTask encodeVideoTask = new EncodeVideoTask(context, str3, z16, new EncodeVideoTask.d(str, str2, null, 0, 0));
        encodeVideoTask.I((g) obj);
        encodeVideoTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void reportSendResult(AppInterface appInterface, ArrayList<String> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, appInterface, arrayList, Integer.valueOf(i3));
        } else {
            ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).D0(arrayList, i3);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void saveSendWording(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) appInterface, (Object) str);
        } else {
            ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).H0(str);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void saveUinListToSend(AppInterface appInterface, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) appInterface, (Object) list);
        } else {
            ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).J0(list);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void sendBlessMsg(AppInterface appInterface, Object obj, ArrayList<String> arrayList, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, appInterface, obj, arrayList, obj2);
        } else {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            qQAppInterface.getMessageFacade().d2(qQAppInterface, (MessageRecord) obj, arrayList, (ChatActivityFacade.a) obj2);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void sendBlessTextMsg(AppInterface appInterface, String str, ArrayList<String> arrayList, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, appInterface, str, arrayList, obj);
        } else {
            ChatActivityFacade.E0((QQAppInterface) appInterface, str, arrayList, (ChatActivityFacade.a) obj);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void setCodecParam(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            CodecParam.mRecordFrames = i3;
            CodecParam.mRecordTime = i16;
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void setPtvMessage(AppInterface appInterface, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) appInterface, obj);
        } else {
            ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).L0((MessageForShortVideo) obj);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public void setUinListToSendChangedOnMen(AppInterface appInterface, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, appInterface, Boolean.valueOf(z16));
        } else {
            ((BlessManager) ((QQAppInterface) appInterface).getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).N0(z16);
        }
    }

    @Override // com.tencent.mobileqq.bless.api.IBlessApi
    public boolean stopSendingShortVideo(AppInterface appInterface, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, appInterface, str, Long.valueOf(j3))).booleanValue();
        }
        return com.tencent.mobileqq.video.a.c((QQAppInterface) appInterface, str, j3);
    }
}
