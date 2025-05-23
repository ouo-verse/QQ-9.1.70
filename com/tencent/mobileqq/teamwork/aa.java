package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aa extends z {

    /* renamed from: c, reason: collision with root package name */
    FileManagerEntity f291594c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.app.d f291595d;

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
                    QLog.i("TeamWorkFileImportJobForC2C", 2, "---onUpdateGetOfflineDownloadInfo retCode: " + j3 + ",retMsg: " + str + ",strCookie: " + str2 + ",strIP: " + str3 + ",port: " + ((int) s16));
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
                    QLog.e("TeamWorkFileImportJobForC2C", 2, "onUpdateGetOfflineDownloadInfo exception: " + e16.toString());
                    z19 = false;
                }
                z18 = z19;
            } else {
                QLog.e("TeamWorkFileImportJobForC2C", 1, "---onUpdateGetOfflineDownloadInfo retCode: " + j3 + ",fileName: " + str5 + ProvinceSelectorView.NAME_NO_SELECT_PROFILE);
                z18 = false;
            }
            try {
                aa aaVar = aa.this;
                if (aaVar.f291594c != null) {
                    if (!z18) {
                        jSONObject.put("filename", aaVar.f292445a.f292074f);
                    }
                    jSONObject.put("filetype", 1);
                    jSONObject.put(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, aa.this.f291594c.Uuid);
                    jSONObject.put("md5", aa.this.f291594c.strFileMd5);
                    jSONObject.put(WidgetCacheLunarData.SHA, aa.this.f291594c.strFileSHA);
                    jSONObject.put(MediaDBValues.FILESIZE, aa.this.f291594c.fileSize);
                    String str8 = aa.this.f292445a.W;
                    if (str8 != null) {
                        jSONObject.put("senderuin", str8);
                    }
                    aa aaVar2 = aa.this;
                    TeamWorkFileImportInfo teamWorkFileImportInfo = aaVar2.f292445a;
                    FileManagerEntity fileManagerEntity = aaVar2.f291594c;
                    teamWorkFileImportInfo.f292067a0 = fileManagerEntity.Uuid;
                    teamWorkFileImportInfo.f292068b0 = 1;
                    if (fileManagerEntity.bSend) {
                        jSONObject.put("ownertype", 1);
                    } else {
                        jSONObject.put("ownertype", 2);
                    }
                    jSONObject.put("importoption", aa.this.f292445a.Y);
                    z26 = true;
                }
            } catch (Exception e17) {
                QLog.e("TeamWorkFileImportJobForC2C", 2, "put fileid exception: " + e17.toString());
            }
            if ((z26 || z18) && u.b(jSONObject) && aa.this.d(jSONObject)) {
                aa aaVar3 = aa.this;
                aaVar3.f292446b.fileImportFromUrl(jSONObject, aaVar3.f292445a, aaVar3.hashCode());
            } else {
                aa.this.a(true);
            }
        }
    }

    public aa(TeamWorkFileImportInfo teamWorkFileImportInfo, QQAppInterface qQAppInterface) {
        super(teamWorkFileImportInfo, qQAppInterface);
        this.f291595d = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return !TextUtils.isEmpty(jSONObject.optString("ownertype"));
    }

    public static JSONObject e(Object obj, AppInterface appInterface) {
        if (!(obj instanceof TeamWorkFileImportInfo) || !(appInterface instanceof QQAppInterface)) {
            return null;
        }
        TeamWorkFileImportInfo teamWorkFileImportInfo = (TeamWorkFileImportInfo) obj;
        FileManagerEntity E = ((QQAppInterface) appInterface).getFileManagerDataCenter().E(teamWorkFileImportInfo.f292079i, teamWorkFileImportInfo.f292072e, teamWorkFileImportInfo.f292070d);
        if (E == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("filetype", 1);
            jSONObject.put(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, E.Uuid);
            jSONObject.put("md5", E.strFileMd5);
            jSONObject.put(WidgetCacheLunarData.SHA, E.strFileSHA);
            jSONObject.put(MediaDBValues.FILESIZE, E.fileSize);
        } catch (Exception e16) {
            QLog.e("TeamWorkFileImportJobForC2C", 2, "queryFileEntityInfo exception: " + e16.toString());
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
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
                FileManagerEntity M = qQAppInterface.getFileManagerDataCenter().M(this.f292445a.f292084m);
                this.f291594c = M;
                if (M == null) {
                    FileManagerDataCenter fileManagerDataCenter = qQAppInterface.getFileManagerDataCenter();
                    TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f292445a;
                    this.f291594c = fileManagerDataCenter.E(teamWorkFileImportInfo2.f292079i, teamWorkFileImportInfo2.f292072e, teamWorkFileImportInfo2.f292070d);
                }
                FileManagerEntity fileManagerEntity = this.f291594c;
                if (fileManagerEntity != null && !TextUtils.isEmpty(fileManagerEntity.Uuid)) {
                    FileTransferHandler fileTransferHandler = qQAppInterface.getFileTransferHandler();
                    FileManagerEntity fileManagerEntity2 = this.f291594c;
                    fileTransferHandler.H(fileManagerEntity2.Uuid, fileManagerEntity2.fileIdCrc, fileManagerEntity2.bSend, false, this.f291595d);
                    z16 = true;
                    if (!z16) {
                        TeamWorkFileImportInfo teamWorkFileImportInfo3 = this.f292445a;
                        teamWorkFileImportInfo3.I = false;
                        this.f292446b.fileImportFromLocalFile(teamWorkFileImportInfo3);
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
