package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ac extends z {

    /* renamed from: c, reason: collision with root package name */
    FileManagerEntity f291597c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.app.d f291598d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends com.tencent.mobileqq.filemanager.app.d {
        a() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(11:1|(10:3|(1:5)|6|7|8|9|10|11|(3:(1:14)|15|16)|(2:27|28)(2:20|21))(1:35)|34|10|11|(0)|(0)|23|25|27|28) */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0142, code lost:
        
            r4 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0143, code lost:
        
            com.tencent.qphone.base.util.QLog.e("TeamWorkFileImportJobForDisc", 2, "put fileid exception: " + r4.toString());
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x00d9  */
        @Override // com.tencent.mobileqq.filemanager.app.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void a(boolean z16, long j3, String str, String str2, String str3, int i3, String str4, String str5, int i16, long j16, Bundle bundle) {
            boolean z17;
            ac acVar;
            JSONObject jSONObject = new JSONObject();
            boolean z18 = false;
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.i("TeamWorkFileImportJobForDisc", 2, "---OnDiscDownloadInfo retCode: " + j3 + ",retMsg: " + str + ",strCookie: " + str5 + ",host: " + str3 + ",port: " + i3);
                }
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(0, "http://" + str3 + ":" + i3 + "/ftn_handler/" + str4);
                    jSONObject.put(CoverDBCacheData.URLS, jSONArray);
                    jSONObject.put("filename", ac.this.f292445a.f292074f);
                    jSONObject.put("cookie", str5);
                    z17 = true;
                } catch (Exception e16) {
                    QLog.e("TeamWorkFileImportJobForDisc", 2, "OnDiscDownloadInfo exception: " + e16.toString());
                }
                acVar = ac.this;
                if (acVar.f291597c != null) {
                    if (!z17) {
                        jSONObject.put("filename", acVar.f292445a.f292074f);
                    }
                    jSONObject.put("filetype", 2);
                    jSONObject.put(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, ac.this.f291597c.Uuid);
                    jSONObject.put("discussuin", Long.valueOf(ac.this.f291597c.peerUin));
                    jSONObject.put("md5", ac.this.f291597c.strFileMd5);
                    jSONObject.put(WidgetCacheLunarData.SHA, ac.this.f291597c.strFileSHA);
                    jSONObject.put("importoption", ac.this.f292445a.Y);
                    jSONObject.put(MediaDBValues.FILESIZE, ac.this.f291597c.fileSize);
                    ac acVar2 = ac.this;
                    TeamWorkFileImportInfo teamWorkFileImportInfo = acVar2.f292445a;
                    teamWorkFileImportInfo.f292067a0 = acVar2.f291597c.Uuid;
                    teamWorkFileImportInfo.f292068b0 = 2;
                    z18 = true;
                }
                if ((!z18 || z17) && u.b(jSONObject) && ac.this.d(jSONObject)) {
                    ac acVar3 = ac.this;
                    acVar3.f292446b.fileImportFromUrl(jSONObject, acVar3.f292445a, acVar3.hashCode());
                } else {
                    ac.this.a(true);
                    return;
                }
            }
            QLog.e("TeamWorkFileImportJobForDisc", 1, "---OnDiscDownloadInfo retCode: " + j3 + ",fileName: " + ac.this.f292445a.f292074f + ProvinceSelectorView.NAME_NO_SELECT_PROFILE);
            z17 = false;
            acVar = ac.this;
            if (acVar.f291597c != null) {
            }
            if (!z18) {
            }
            ac acVar32 = ac.this;
            acVar32.f292446b.fileImportFromUrl(jSONObject, acVar32.f292445a, acVar32.hashCode());
        }
    }

    public ac(TeamWorkFileImportInfo teamWorkFileImportInfo, QQAppInterface qQAppInterface) {
        super(teamWorkFileImportInfo, qQAppInterface);
        this.f291598d = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return !TextUtils.isEmpty(jSONObject.optString("discussuin"));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    @Override // com.tencent.mobileqq.teamwork.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(AppInterface appInterface) {
        boolean z16;
        TeamWorkFileImportInfo teamWorkFileImportInfo = this.f292445a;
        if (teamWorkFileImportInfo != null && (appInterface instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (teamWorkFileImportInfo.I && teamWorkFileImportInfo.f292070d == 3000 && !TextUtils.isEmpty(teamWorkFileImportInfo.f292072e)) {
                QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f292445a;
                MessageRecord w06 = messageFacade.w0(teamWorkFileImportInfo2.f292072e, teamWorkFileImportInfo2.f292070d, teamWorkFileImportInfo2.f292079i);
                if (w06 != null && (w06 instanceof MessageForFile)) {
                    this.f291597c = FileManagerUtil.getFileManagerEntityByMsgFile(qQAppInterface, (MessageForFile) w06);
                }
                if (this.f291597c == null) {
                    FileManagerDataCenter fileManagerDataCenter = qQAppInterface.getFileManagerDataCenter();
                    TeamWorkFileImportInfo teamWorkFileImportInfo3 = this.f292445a;
                    this.f291597c = fileManagerDataCenter.E(teamWorkFileImportInfo3.f292079i, teamWorkFileImportInfo3.f292072e, teamWorkFileImportInfo3.f292070d);
                }
                FileManagerEntity fileManagerEntity = this.f291597c;
                if (fileManagerEntity != null && !TextUtils.isEmpty(fileManagerEntity.Uuid) && !TextUtils.isEmpty(this.f291597c.peerUin)) {
                    FileTransferHandler fileTransferHandler = qQAppInterface.getFileTransferHandler();
                    FileManagerEntity fileManagerEntity2 = this.f291597c;
                    fileTransferHandler.F(fileManagerEntity2.nSessionId, fileManagerEntity2.fileName, Long.parseLong(fileManagerEntity2.peerUin), this.f291597c.Uuid, this.f291598d);
                    z16 = true;
                    if (!z16) {
                        TeamWorkFileImportInfo teamWorkFileImportInfo4 = this.f292445a;
                        teamWorkFileImportInfo4.I = false;
                        this.f292446b.fileImportFromLocalFile(teamWorkFileImportInfo4);
                    }
                    this.f292446b.addToFileImportingMap(this.f292445a);
                }
            }
            z16 = false;
            if (!z16) {
            }
            this.f292446b.addToFileImportingMap(this.f292445a);
        }
    }
}
