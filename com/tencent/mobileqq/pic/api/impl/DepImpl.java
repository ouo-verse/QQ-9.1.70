package com.tencent.mobileqq.pic.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.haoliyou.JumpShareUtils;
import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager;
import msf.msgsvc.msg_ctrl$MsgCtrl;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DepImpl implements IDep {
    static IPatchRedirector $redirector_;

    public DepImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IDep
    public void addWaitingEssenceMsg(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3));
        } else {
            ((TroopEssenceMsgManager) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).x(str, j3);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IDep
    public void bindAnonymousInfo(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord);
        } else {
            com.tencent.biz.anonymous.a.h().a(messageRecord);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IDep
    public void consumeAllThumbsInPendingQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        ShortVideoPreDownloader shortVideoPreDownloader = (ShortVideoPreDownloader) ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER);
        if (shortVideoPreDownloader != null) {
            shortVideoPreDownloader.c();
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IDep
    public void fillStickInfo(MessageForPic messageForPic, PicMessageExtraData picMessageExtraData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageForPic, (Object) picMessageExtraData);
            return;
        }
        StickerInfo stickerInfo = picMessageExtraData.stickerInfo;
        if (stickerInfo != null) {
            messageForPic.saveExtInfoToExtStr("sticker_info", stickerInfo.toJsonString());
        }
        if (!TextUtils.isEmpty(messageForPic.getExtInfoFromExtStr("sticker_info"))) {
            EmojiStickerManager.z(messageForPic, null);
            EmojiStickerManager.k().s(messageForPic);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IDep
    public msg_ctrl$MsgCtrl getMsgCtrlForPicMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (msg_ctrl$MsgCtrl) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return JumpShareUtils.getMsgCtrlForPicMsg(str);
    }

    @Override // com.tencent.mobileqq.pic.api.IDep
    public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf getPicDownEncryptConf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return FMTSrvAddrProvider.getInstance().getPicDownEncryptConf();
    }

    @Override // com.tencent.mobileqq.pic.api.IDep
    public String getServerConfigValue(AppInterface appInterface, ServerConfigManager.ConfigType configType, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, appInterface, configType, str);
        }
        return ((QQAppInterface) appInterface).getServerConfigValue(ServerConfigManager.ConfigType.common, str);
    }

    @Override // com.tencent.mobileqq.pic.api.IDep
    public String getZhituText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ZhituManager.I((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).C();
    }

    @Override // com.tencent.mobileqq.pic.api.IDep
    public void reportEmotionPicMonitor(MessageRecord messageRecord, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, messageRecord, str, Boolean.valueOf(z16));
            return;
        }
        if (com.tencent.mobileqq.core.util.a.i(messageRecord)) {
            EmoticonOperateReport.reportAIOEmoticonMonitorReceiveStatus("0", 3);
            i3 = 3;
        } else if (com.tencent.mobileqq.core.util.a.f(messageRecord)) {
            EmoticonOperateReport.reportAIOEmoticonMonitorReceiveStatus("0", 2);
        } else {
            z17 = false;
            i3 = 0;
        }
        if (z17) {
            if (str == null) {
                str = "0";
            }
            String str2 = null;
            if (z16) {
                String str3 = str;
                str = null;
                str2 = str3;
            }
            EmoticonOperateReport.reportAIOEmoticonMonitor(str, str2, i3);
        }
    }
}
