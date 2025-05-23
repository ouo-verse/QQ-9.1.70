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
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class y extends z {

    /* renamed from: c, reason: collision with root package name */
    FileManagerEntity f292442c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.app.d f292443d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends com.tencent.mobileqq.filemanager.app.d {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.d
        protected void j(boolean z16, long j3, String str, String str2, ByteStringMicro byteStringMicro, boolean z17, String str3, short s16, String str4, List<String> list, int i3, String str5, String str6, String str7, long j16, Bundle bundle) {
            boolean z18;
            boolean z19;
            JSONObject jSONObject = new JSONObject();
            boolean z26 = false;
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.i("TeamWorkFileImportForH5", 2, "---onUpdateGetOfflineDownloadInfo retCode: " + j3 + ",retMsg: " + str + ",strCookie: " + str2 + ",strIP: " + str3 + ",port: " + ((int) s16));
                }
                StringBuilder sb5 = new StringBuilder("http://");
                sb5.append(str3);
                sb5.append(":");
                sb5.append((int) s16);
                sb5.append(str4);
                if (z17) {
                    sb5.append("&isthumb=0");
                }
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(0, sb5.toString());
                    jSONObject.put(CoverDBCacheData.URLS, jSONArray);
                    jSONObject.put("filename", str5);
                    jSONObject.put("cookie", str2);
                    jSONObject.put("bUseMediaPlatform", z17);
                    z19 = true;
                } catch (Exception e16) {
                    QLog.e("TeamWorkFileImportForH5", 2, "onUpdateGetOfflineDownloadInfo exception: " + e16.toString());
                    z19 = false;
                }
                z18 = z19;
            } else {
                QLog.e("TeamWorkFileImportForH5", 1, "---onUpdateGetOfflineDownloadInfo retCode: " + j3 + ",fileName: " + str5 + ProvinceSelectorView.NAME_NO_SELECT_PROFILE);
                z18 = false;
            }
            try {
                y yVar = y.this;
                if (yVar.f292442c != null) {
                    if (!z18) {
                        jSONObject.put("filename", yVar.f292445a.f292074f);
                    }
                    String b16 = b.b(y.this.f292445a);
                    jSONObject.put("filetype", 1);
                    if (b16 == null) {
                        b16 = y.this.f292442c.Uuid;
                    }
                    jSONObject.put(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, b16);
                    jSONObject.put("md5", y.this.f292442c.strFileMd5);
                    jSONObject.put(WidgetCacheLunarData.SHA, y.this.f292442c.strFileSHA);
                    jSONObject.put(MediaDBValues.FILESIZE, y.this.f292442c.fileSize);
                    if (y.this.f292442c.bSend) {
                        jSONObject.put("ownertype", 1);
                    } else {
                        jSONObject.put("ownertype", 2);
                    }
                    z26 = true;
                }
            } catch (Exception e17) {
                QLog.e("TeamWorkFileImportForH5", 2, "put fileid exception: " + e17.toString());
            }
            if (!z26 && !z18) {
                y.this.a(true);
            } else {
                y yVar2 = y.this;
                yVar2.f292446b.fileImportFromUrlForH5(jSONObject, yVar2.f292445a, yVar2.hashCode());
            }
        }
    }

    public y(TeamWorkFileImportInfo teamWorkFileImportInfo, QQAppInterface qQAppInterface) {
        super(teamWorkFileImportInfo, qQAppInterface);
        this.f292443d = new a();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    @Override // com.tencent.mobileqq.teamwork.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(AppInterface appInterface) {
        boolean z16;
        TeamWorkFileImportInfo teamWorkFileImportInfo = this.f292445a;
        if (teamWorkFileImportInfo != null && (appInterface instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (teamWorkFileImportInfo.I && !TextUtils.isEmpty(teamWorkFileImportInfo.f292072e)) {
                QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f292445a;
                MessageRecord w06 = messageFacade.w0(teamWorkFileImportInfo2.f292072e, teamWorkFileImportInfo2.f292070d, teamWorkFileImportInfo2.f292079i);
                if (w06 != null && (w06 instanceof MessageForFile)) {
                    this.f292442c = FileManagerUtil.getFileManagerEntityByMsgFile(qQAppInterface, (MessageForFile) w06);
                } else {
                    this.f292442c = qQAppInterface.getFileManagerDataCenter().M(this.f292445a.f292084m);
                }
                FileManagerEntity fileManagerEntity = this.f292442c;
                if (fileManagerEntity != null && !TextUtils.isEmpty(fileManagerEntity.Uuid)) {
                    FileTransferHandler fileTransferHandler = qQAppInterface.getFileTransferHandler();
                    FileManagerEntity fileManagerEntity2 = this.f292442c;
                    fileTransferHandler.H(fileManagerEntity2.Uuid, fileManagerEntity2.fileIdCrc, fileManagerEntity2.bSend, false, this.f292443d);
                    z16 = true;
                    if (!z16) {
                        TeamWorkFileImportInfo teamWorkFileImportInfo3 = this.f292445a;
                        teamWorkFileImportInfo3.I = false;
                        this.f292446b.fileImportFromLocalFileForH5(teamWorkFileImportInfo3);
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
