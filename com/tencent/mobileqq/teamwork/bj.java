package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.AVDecodeError;

/* compiled from: P */
/* loaded from: classes18.dex */
public class bj {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f292096a;

    /* renamed from: b, reason: collision with root package name */
    private ag f292097b;

    /* renamed from: c, reason: collision with root package name */
    private AbsStructMsg f292098c;

    /* renamed from: d, reason: collision with root package name */
    private MessageForStructing f292099d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends ag {
        a() {
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void a(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            super.a(teamWorkFileImportInfo);
            if (teamWorkFileImportInfo.f292080i0 != bj.this.f292098c.uniseq) {
                return;
            }
            bj.this.f292099d.saveExtInfoToExtStr("errorString", bj.this.h(teamWorkFileImportInfo.T));
            bj.this.f292099d.saveExtInfoToExtStr("retCode", String.valueOf(teamWorkFileImportInfo.T));
            bj.this.f292096a.getMsgCache().G1(bj.this.f292099d.frienduin, bj.this.f292099d.istroop, bj.this.f292099d.uniseq);
            bj.this.f292096a.removeObserver(bj.this.f292097b);
            bj.this.f292096a.getMessageFacade().a1(bj.this.f292099d.frienduin, bj.this.f292099d.istroop, bj.this.f292099d.uniseq, AppConstants.Key.COLUMN_EXT_STR, bj.this.f292099d.extStr);
            bj.this.f292096a.getMessageFacade().Z0(bj.this.f292099d.frienduin, bj.this.f292099d.istroop, bj.this.f292099d.uniseq, 32768, -1);
            QLog.i("TeamWorkSender", 1, bj.this.f292098c.uniseq + " import file faild");
            bj.this.f292096a.getFileManagerNotifyCenter().b(true, 3, null);
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void e(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            if (teamWorkFileImportInfo.f292080i0 != bj.this.f292098c.uniseq) {
                return;
            }
            bj.this.f292096a.removeObserver(bj.this.f292097b);
            bj.this.f292098c.mMsgUrl = str;
            bj.this.f292099d.structingMsg.mMsgUrl = str;
            bj.this.f292099d.msgData = bj.this.f292098c.getBytes();
            bj.this.f292098c.removeFlag(1);
            bj.this.f292098c.removeFlag(2);
            bj.this.f292096a.getMessageFacade().E0(bj.this.f292099d, null, false);
            QLog.i("TeamWorkSender", 1, "start import file success");
            if (QLog.isColorLevel()) {
                QLog.i("TeamWorkSender", 1, "msg uniseq : " + bj.this.f292098c.uniseq + " import success, url:" + str);
            }
        }
    }

    public bj(QQAppInterface qQAppInterface) {
        this.f292096a = qQAppInterface;
        j();
        this.f292096a.addObserver(this.f292097b);
    }

    private TeamWorkFileImportInfo f(FileManagerEntity fileManagerEntity) {
        TeamWorkFileImportInfo teamWorkFileImportInfo = new TeamWorkFileImportInfo();
        teamWorkFileImportInfo.f292077h = fileManagerEntity.getFilePath();
        teamWorkFileImportInfo.f292074f = fileManagerEntity.fileName;
        teamWorkFileImportInfo.R = fileManagerEntity.nFileType;
        teamWorkFileImportInfo.K = false;
        teamWorkFileImportInfo.J = 4;
        teamWorkFileImportInfo.f292078h0 = fileManagerEntity.fileSize;
        teamWorkFileImportInfo.f292070d = fileManagerEntity.peerType;
        teamWorkFileImportInfo.f292072e = fileManagerEntity.peerUin;
        teamWorkFileImportInfo.F = String.valueOf(fileManagerEntity.TroopUin);
        teamWorkFileImportInfo.D = fileManagerEntity.busId;
        teamWorkFileImportInfo.C = fileManagerEntity.strTroopFilePath;
        teamWorkFileImportInfo.f292079i = fileManagerEntity.uniseq;
        if (fileManagerEntity.status != 16) {
            teamWorkFileImportInfo.I = true;
        }
        return teamWorkFileImportInfo;
    }

    private TeamWorkFileImportInfo g(String str) {
        TeamWorkFileImportInfo teamWorkFileImportInfo = new TeamWorkFileImportInfo();
        teamWorkFileImportInfo.f292077h = str;
        teamWorkFileImportInfo.f292074f = FileManagerUtil.getFileName(str);
        teamWorkFileImportInfo.R = FileManagerUtil.getFileType(str);
        teamWorkFileImportInfo.K = false;
        teamWorkFileImportInfo.J = 4;
        teamWorkFileImportInfo.f292078h0 = FileManagerUtil.getFileSizes(str);
        teamWorkFileImportInfo.I = false;
        return teamWorkFileImportInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(int i3) {
        HardCodeUtil.qqStr(R.string.u18);
        switch (i3) {
            case AVDecodeError.AUDIO_DATA_DECODE_FINISH /* -116 */:
            case -106:
                return HardCodeUtil.qqStr(R.string.f172762u12);
            case AVDecodeError.JNI_BITMAP_STRIDE_ERR /* -115 */:
            case -113:
            case -112:
                return HardCodeUtil.qqStr(R.string.u08);
            case AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR /* -114 */:
                return HardCodeUtil.qqStr(R.string.u1q);
            case -111:
                return HardCodeUtil.qqStr(R.string.u0n);
            case -110:
                return HardCodeUtil.qqStr(R.string.f172765u15);
            case AVDecodeError.VIDEO_DECODE_A_ERR /* -109 */:
            case -105:
            case -104:
            default:
                return HardCodeUtil.qqStr(R.string.u0k);
            case AVDecodeError.VIDEO_DECODE_V_ERR /* -108 */:
                return HardCodeUtil.qqStr(R.string.u1h);
            case -107:
                return HardCodeUtil.qqStr(R.string.f172758u03);
            case -103:
                return HardCodeUtil.qqStr(R.string.f172764u14);
            case -102:
            case -101:
            case -100:
                return HardCodeUtil.qqStr(R.string.u0a);
        }
    }

    private AbsStructMsg i(Context context, String str) {
        String qqStr;
        String str2;
        String fileName = FileManagerUtil.getFileName(str);
        String j3 = com.tencent.mobileqq.filemanager.util.q.j(str);
        if (ITeamWorkUtils.FILE_WORD_XLS.indexOf(j3) < 0) {
            QLog.e("TeamWorkSender", 1, str + " is not docs support file");
            return null;
        }
        if (".doc|.docx".contains(j3)) {
            qqStr = HardCodeUtil.qqStr(R.string.u1_);
            str2 = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.u16);
            str2 = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
        }
        Intent intent = new Intent();
        intent.putExtra("key_flag_from_plugin", true);
        intent.setClass(context, ForwardRecentActivity.class);
        intent.putExtra("isFromShare", true);
        intent.putExtra("forward_type", 1001);
        intent.putExtra("pluginName", "web_share");
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 95);
        intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str2);
        intent.putExtra(IPublicAccountJavascriptInterface.KEY_PUB_UIN, "");
        intent.putExtra("struct_uin", "");
        if (fileName != null && fileName.length() > 45) {
            fileName = fileName.substring(0, 45) + "\u2026";
        }
        intent.putExtra("title", fileName);
        if (qqStr != null && qqStr.length() > 60) {
            qqStr = qqStr.substring(0, 60) + "\u2026";
        }
        intent.putExtra("desc", qqStr);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str2);
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION, "web");
        intent.putExtra("req_share_id", -1L);
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "web");
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL, ITeamWorkUtils.DOCS_LIST_WEB_URL);
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, ITeamWorkUtils.DOCS_SOURCE_ICON_URL);
        intent.putExtra("app_name", HardCodeUtil.qqStr(R.string.u1s));
        intent.putExtra(AppConstants.Key.SHARE_BRIEF, context.getString(R.string.f171308dy0, fileName));
        return com.tencent.mobileqq.structmsg.i.e(intent.getExtras());
    }

    private void j() {
        this.f292097b = new a();
    }

    private void k(AbsStructMsg absStructMsg, TeamWorkFileImportInfo teamWorkFileImportInfo, String str, int i3) {
        String str2;
        String currentAccountUin = this.f292096a.getCurrentAccountUin();
        int i16 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i16 + 1;
        long j3 = i16;
        QQAppInterface qQAppInterface = this.f292096a;
        if (TextUtils.isEmpty(str)) {
            str2 = currentAccountUin;
        } else {
            str2 = str;
        }
        MessageForStructing A = com.tencent.mobileqq.service.message.q.A(qQAppInterface, currentAccountUin, str, str2, i3, j3, absStructMsg);
        this.f292099d = A;
        teamWorkFileImportInfo.f292080i0 = A.uniseq;
        l(A, teamWorkFileImportInfo);
        MessageForStructing messageForStructing = this.f292099d;
        messageForStructing.issend = 1;
        messageForStructing.extraflag = 32772;
        absStructMsg.addFlag(1);
        absStructMsg.addFlag(2);
        this.f292096a.getMsgCache().L(this.f292099d, 0);
        this.f292096a.getMessageFacade().c(this.f292099d, currentAccountUin);
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) this.f292096a.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
        if (!TextUtils.isEmpty(iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo))) {
            iTeamWorkFileImportHandler.getUrlFromConvertedMap(teamWorkFileImportInfo);
        }
        if (!iTeamWorkFileImportHandler.isFileImporting(teamWorkFileImportInfo)) {
            iTeamWorkFileImportHandler.addFileImportJob(teamWorkFileImportInfo);
            QLog.i("TeamWorkSender", 1, "start import file:" + this.f292099d.uniseq);
            if (QLog.isColorLevel()) {
                QLog.i("TeamWorkSender", 1, "start Import File: " + teamWorkFileImportInfo.f292074f);
            }
        }
    }

    private void l(MessageRecord messageRecord, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        messageRecord.saveExtInfoToExtStr(WadlProxyConsts.PARAM_FILENAME, teamWorkFileImportInfo.f292074f);
        messageRecord.saveExtInfoToExtStr("filePath", teamWorkFileImportInfo.f292077h);
        messageRecord.saveExtInfoToExtStr("peerUin", teamWorkFileImportInfo.f292072e);
        String str = teamWorkFileImportInfo.C;
        if (str == null) {
            str = "";
        }
        messageRecord.saveExtInfoToExtStr("troopFilePath", str);
        messageRecord.saveExtInfoToExtStr("troopUin", teamWorkFileImportInfo.F);
        messageRecord.saveExtInfoToExtStr("entranceFrom", String.valueOf(teamWorkFileImportInfo.J));
        messageRecord.saveExtInfoToExtStr("fileImportType", String.valueOf(teamWorkFileImportInfo.f292076g0));
        messageRecord.saveExtInfoToExtStr("fileSize", String.valueOf(teamWorkFileImportInfo.f292078h0));
        messageRecord.saveExtInfoToExtStr("isFromAIO", String.valueOf(teamWorkFileImportInfo.K));
        messageRecord.saveExtInfoToExtStr("isMessageConvert", String.valueOf(teamWorkFileImportInfo.P));
        messageRecord.saveExtInfoToExtStr("isNeedDownLoadUrl", String.valueOf(teamWorkFileImportInfo.I));
        messageRecord.saveExtInfoToExtStr("isOpenTeamWork", String.valueOf(teamWorkFileImportInfo.M));
        messageRecord.saveExtInfoToExtStr("isUserClick", String.valueOf(teamWorkFileImportInfo.N));
        messageRecord.saveExtInfoToExtStr("msgUniseq", String.valueOf(teamWorkFileImportInfo.f292079i));
        messageRecord.saveExtInfoToExtStr("nFileType", String.valueOf(teamWorkFileImportInfo.R));
        messageRecord.saveExtInfoToExtStr("nSessionId", String.valueOf(teamWorkFileImportInfo.f292084m));
        messageRecord.saveExtInfoToExtStr("peerType", String.valueOf(teamWorkFileImportInfo.f292070d));
        messageRecord.saveExtInfoToExtStr("troopFileBusId", String.valueOf(teamWorkFileImportInfo.D));
        messageRecord.saveExtInfoToExtStr("structUniseq", String.valueOf(teamWorkFileImportInfo.f292080i0));
        messageRecord.saveExtInfoToExtStr("strSendUin", teamWorkFileImportInfo.W);
        messageRecord.saveExtInfoToExtStr("import_file_message_flag", "import_file_message_flag_value");
    }

    public void m(FileManagerEntity fileManagerEntity, String str, String str2, int i3) {
        this.f292098c = i(BaseActivity.sTopActivity, fileManagerEntity.fileName);
        TeamWorkFileImportInfo f16 = f(fileManagerEntity);
        AbsStructMsg absStructMsg = this.f292098c;
        if (absStructMsg != null) {
            k(absStructMsg, f16, str2, i3);
            FileManagerReporter.addData("0X800942C");
        }
    }

    public void n(String str, String str2, String str3, int i3) {
        this.f292098c = i(BaseActivity.sTopActivity, FileManagerUtil.getFileName(str));
        TeamWorkFileImportInfo g16 = g(str);
        g16.f292070d = i3;
        g16.f292072e = str3;
        AbsStructMsg absStructMsg = this.f292098c;
        if (absStructMsg != null) {
            k(absStructMsg, g16, str3, i3);
            FileManagerReporter.addData("0X800942C");
        }
    }
}
