package com.tencent.mobileqq.vas;

import android.graphics.Color;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.IVasEmojiManager;
import com.tencent.mobileqq.emoticon.api.IEmoticonFromGroupManagerService;
import com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.panel.FontBubbleManager;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.profilecard.VasTipsData;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.pb.profilecard.VaProfileGate$GetClmTipRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ao implements Manager {
    public FontBubbleManager C;
    public TroopKeywordManager D;
    private a E = new a();

    /* renamed from: d, reason: collision with root package name */
    public QQAppInterface f308427d;

    /* renamed from: e, reason: collision with root package name */
    public IVasEmojiManager f308428e;

    /* renamed from: f, reason: collision with root package name */
    public VasFaceManager f308429f;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.mobileqq.emosm.favroaming.l f308430h;

    /* renamed from: i, reason: collision with root package name */
    public ProfileCardManager f308431i;

    /* renamed from: m, reason: collision with root package name */
    public f f308432m;

    public ao(QQAppInterface qQAppInterface) {
        this.f308427d = qQAppInterface;
        this.f308428e = ((IVasEmojiManagerService) QRoute.api(IVasEmojiManagerService.class)).createVasEmojiManager(qQAppInterface);
        this.f308429f = new VasFaceManager(qQAppInterface);
        this.f308430h = ((IEmoticonFromGroupManagerService) QRoute.api(IEmoticonFromGroupManagerService.class)).createEmoticonFromGroupManager(qQAppInterface);
        this.f308431i = new ProfileCardManager(qQAppInterface);
        this.f308432m = new f(qQAppInterface);
        this.C = new FontBubbleManager(qQAppInterface);
        this.D = new TroopKeywordManager(qQAppInterface, qQAppInterface.getEntityManagerFactory().createEntityManager());
        c(qQAppInterface);
    }

    public static VasTipsData b(VaProfileGate$GetClmTipRsp vaProfileGate$GetClmTipRsp) {
        String str;
        String str2;
        int i3;
        String str3;
        int i16;
        String str4;
        String str5;
        String str6;
        String str7;
        try {
            String str8 = "";
            if (!vaProfileGate$GetClmTipRsp.pic_icon.has()) {
                str = "";
            } else {
                str = vaProfileGate$GetClmTipRsp.pic_icon.get();
            }
            if (!vaProfileGate$GetClmTipRsp.content_text.has()) {
                str2 = "";
            } else {
                str2 = vaProfileGate$GetClmTipRsp.content_text.get();
            }
            if (vaProfileGate$GetClmTipRsp.content_text_color.has()) {
                i3 = Color.parseColor(vaProfileGate$GetClmTipRsp.content_text_color.get());
            } else {
                i3 = -16777216;
            }
            if (!vaProfileGate$GetClmTipRsp.button_text.has()) {
                str3 = "";
            } else {
                str3 = vaProfileGate$GetClmTipRsp.button_text.get();
            }
            if (vaProfileGate$GetClmTipRsp.button_text_color.has()) {
                i16 = Color.parseColor(vaProfileGate$GetClmTipRsp.button_text_color.get());
            } else {
                i16 = -16777216;
            }
            if (!vaProfileGate$GetClmTipRsp.button_bg.has()) {
                str4 = "";
            } else {
                str4 = vaProfileGate$GetClmTipRsp.button_bg.get();
            }
            if (!vaProfileGate$GetClmTipRsp.pic_bg.has()) {
                str5 = "";
            } else {
                str5 = vaProfileGate$GetClmTipRsp.pic_bg.get();
            }
            if (!vaProfileGate$GetClmTipRsp.url.has()) {
                str6 = "";
            } else {
                str6 = vaProfileGate$GetClmTipRsp.url.get();
            }
            if (!vaProfileGate$GetClmTipRsp.clm_param.has()) {
                str7 = "";
            } else {
                str7 = vaProfileGate$GetClmTipRsp.clm_param.get();
            }
            if (vaProfileGate$GetClmTipRsp.pic_bg_diy.has()) {
                str8 = vaProfileGate$GetClmTipRsp.pic_bg_diy.get();
            }
            return new VasTipsData(str, str2, i3, str3, i16, str4, str5, str6, str7, str8);
        } catch (Exception e16) {
            if (!AppSetting.isDebugVersion()) {
                QLog.e("VasExtensionManager", 1, "parse error " + e16);
                return null;
            }
            throw e16;
        }
    }

    public static boolean f() {
        if (TMSManager.e().d()) {
            if (NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) == 0) {
                TMSManager.e().l(null, false);
            } else {
                QLog.d("KC.TMSManager", 1, "can only query in mobile connection");
            }
            return true;
        }
        QLog.d("KC.TMSManager", 1, "tms can not work");
        return false;
    }

    public boolean a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        long decodeLong = VipMMKV.getCommon(peekAppRuntime.getCurrentUin()).decodeLong("qq_level_notice_data_flag", 0L);
        if (System.currentTimeMillis() <= decodeLong && decodeLong != 0) {
            return false;
        }
        return true;
    }

    protected void c(QQAppInterface qQAppInterface) {
        try {
            AppNetConnInfo.registerConnectionChangeReceiver(qQAppInterface.getApp(), this.E);
        } catch (Error unused) {
        }
    }

    public VasTipsData d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        VasTipsData vasTipsData = (VasTipsData) VipMMKV.getCommon(peekAppRuntime.getCurrentUin()).decodeParcelable("qq_level_notice_data", VasTipsData.class, null);
        e(null);
        return vasTipsData;
    }

    public void e(VasTipsData vasTipsData) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        VipMMKV.getCommon(peekAppRuntime.getCurrentUin()).encodeParcelable("qq_level_notice_data", vasTipsData);
    }

    public void g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        VipMMKV.getCommon(peekAppRuntime.getCurrentUin()).encodeLong("qq_level_notice_data_flag", System.currentTimeMillis() + 86400);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        AppNetConnInfo.unregisterNetInfoHandler(this.E);
        this.f308429f.onDestroy();
        this.D.j();
        this.f308432m.onDestroy();
        this.C.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a implements INetInfoHandler {
        a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            ao.f();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            ao.f();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
        }
    }
}
