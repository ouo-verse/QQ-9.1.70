package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$DownloadFileRspBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ae extends z {

    /* renamed from: c, reason: collision with root package name */
    FileManagerEntity f291600c;

    /* renamed from: d, reason: collision with root package name */
    private ef0.m f291601d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends ef0.m {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0156 A[Catch: Exception -> 0x0182, TryCatch #0 {Exception -> 0x0182, blocks: (B:37:0x010c, B:17:0x0115, B:19:0x0156, B:20:0x016a), top: B:36:0x010c }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // ef0.m
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(boolean z16, int i3, oidb_0x6d6$DownloadFileRspBody oidb_0x6d6_downloadfilerspbody, Bundle bundle) {
            boolean z17;
            FileManagerEntity fileManagerEntity;
            JSONObject jSONObject = new JSONObject();
            boolean z18 = false;
            if (z16) {
                if (oidb_0x6d6_downloadfilerspbody != null) {
                    int i16 = oidb_0x6d6_downloadfilerspbody.int32_ret_code.get();
                    if (i16 == 0) {
                        String bytes2HexStr = HexUtil.bytes2HexStr(oidb_0x6d6_downloadfilerspbody.bytes_cookie_val.get().toByteArray());
                        if (bytes2HexStr != null) {
                            bytes2HexStr = bytes2HexStr.toLowerCase();
                        }
                        String str = oidb_0x6d6_downloadfilerspbody.str_download_ip.get();
                        String bytes2HexStr2 = HexUtil.bytes2HexStr(oidb_0x6d6_downloadfilerspbody.bytes_download_url.get().toByteArray());
                        if (QLog.isColorLevel()) {
                            QLog.i("TeamWorkFileImportJobForGroup", 2, "---onReqDownloadFileResult success ,ip: " + str + ",param: " + bytes2HexStr2);
                        }
                        try {
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(0, "http://" + str + "/ftn_handler/" + bytes2HexStr2 + "/?fname=" + HexUtil.string2HexString(ae.this.f292445a.C));
                            jSONObject.put(CoverDBCacheData.URLS, jSONArray);
                            jSONObject.put("filename", ae.this.f292445a.f292074f);
                            jSONObject.put("cookie", "FTN5K=" + bytes2HexStr);
                            z17 = true;
                        } catch (Exception e16) {
                            QLog.e("TeamWorkFileImportJobForGroup", 1, "onReqDownloadFileResult json exception: " + e16.toString());
                        }
                        if (!z17) {
                            try {
                                jSONObject.put("filename", ae.this.f292445a.f292074f);
                            } catch (Exception e17) {
                                QLog.e("TeamWorkFileImportJobForGroup", 2, "put fileid exception: " + e17.toString());
                            }
                        }
                        jSONObject.put("filetype", 3);
                        jSONObject.put(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, ae.this.f292445a.C);
                        jSONObject.put("businesstype", ae.this.f292445a.D);
                        jSONObject.put("groupuin", Long.valueOf(ae.this.f292445a.f292072e));
                        jSONObject.put("importoption", ae.this.f292445a.Y);
                        fileManagerEntity = ae.this.f291600c;
                        if (fileManagerEntity != null) {
                            jSONObject.put("md5", fileManagerEntity.strFileMd5);
                            jSONObject.put(WidgetCacheLunarData.SHA, ae.this.f291600c.strFileSHA);
                        }
                        jSONObject.put(MediaDBValues.FILESIZE, ae.this.f292445a.f292078h0);
                        TeamWorkFileImportInfo teamWorkFileImportInfo = ae.this.f292445a;
                        teamWorkFileImportInfo.f292067a0 = teamWorkFileImportInfo.C;
                        teamWorkFileImportInfo.f292068b0 = 3;
                        z18 = true;
                        if ((!z18 || z17) && u.b(jSONObject) && ae.this.d(jSONObject)) {
                            ae aeVar = ae.this;
                            aeVar.f292446b.fileImportFromUrl(jSONObject, aeVar.f292445a, aeVar.hashCode());
                        } else {
                            ae.this.a(true);
                            return;
                        }
                    }
                    QLog.e("TeamWorkFileImportJobForGroup", 1, "onReqDownloadFileResult retCode: " + i16);
                }
            } else {
                QLog.e("TeamWorkFileImportJobForGroup", 1, "onReqDownloadFileResult errorCode: " + i3);
            }
            z17 = false;
            if (!z17) {
            }
            jSONObject.put("filetype", 3);
            jSONObject.put(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, ae.this.f292445a.C);
            jSONObject.put("businesstype", ae.this.f292445a.D);
            jSONObject.put("groupuin", Long.valueOf(ae.this.f292445a.f292072e));
            jSONObject.put("importoption", ae.this.f292445a.Y);
            fileManagerEntity = ae.this.f291600c;
            if (fileManagerEntity != null) {
            }
            jSONObject.put(MediaDBValues.FILESIZE, ae.this.f292445a.f292078h0);
            TeamWorkFileImportInfo teamWorkFileImportInfo2 = ae.this.f292445a;
            teamWorkFileImportInfo2.f292067a0 = teamWorkFileImportInfo2.C;
            teamWorkFileImportInfo2.f292068b0 = 3;
            z18 = true;
            if (!z18) {
            }
            ae aeVar2 = ae.this;
            aeVar2.f292446b.fileImportFromUrl(jSONObject, aeVar2.f292445a, aeVar2.hashCode());
        }
    }

    public ae(TeamWorkFileImportInfo teamWorkFileImportInfo, QQAppInterface qQAppInterface) {
        super(teamWorkFileImportInfo, qQAppInterface);
        this.f291601d = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(JSONObject jSONObject) {
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("groupuin")) || TextUtils.isEmpty(jSONObject.optString("businesstype"))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008f  */
    @Override // com.tencent.mobileqq.teamwork.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(AppInterface appInterface) {
        boolean z16;
        TeamWorkFileImportInfo teamWorkFileImportInfo = this.f292445a;
        if (teamWorkFileImportInfo != null && (appInterface instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (teamWorkFileImportInfo.I) {
                z16 = true;
                if (teamWorkFileImportInfo.f292070d == 1 && !TextUtils.isEmpty(teamWorkFileImportInfo.C)) {
                    TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f292445a;
                    if (teamWorkFileImportInfo2.D != 0 && !TextUtils.isEmpty(teamWorkFileImportInfo2.f292072e)) {
                        com.tencent.mobileqq.troop.data.n nVar = new com.tencent.mobileqq.troop.data.n();
                        nVar.f294915a = UUID.nameUUIDFromBytes(this.f292445a.C.getBytes());
                        TeamWorkFileImportInfo teamWorkFileImportInfo3 = this.f292445a;
                        nVar.f294916b = teamWorkFileImportInfo3.C;
                        nVar.f294917c = teamWorkFileImportInfo3.f292074f;
                        nVar.f294919e = teamWorkFileImportInfo3.D;
                        TroopFileTransferManager.Item item = new TroopFileTransferManager.Item(nVar);
                        TeamWorkFileImportInfo teamWorkFileImportInfo4 = this.f292445a;
                        item.FileName = teamWorkFileImportInfo4.f292074f;
                        com.tencent.biz.troop.file.a.q(qQAppInterface, Long.valueOf(teamWorkFileImportInfo4.f292072e).longValue(), item, 0, false, false, this.f291601d);
                        FileManagerEntity M = qQAppInterface.getFileManagerDataCenter().M(this.f292445a.f292084m);
                        this.f291600c = M;
                        if (M == null) {
                            FileManagerDataCenter fileManagerDataCenter = qQAppInterface.getFileManagerDataCenter();
                            TeamWorkFileImportInfo teamWorkFileImportInfo5 = this.f292445a;
                            this.f291600c = fileManagerDataCenter.E(teamWorkFileImportInfo5.f292079i, teamWorkFileImportInfo5.f292072e, teamWorkFileImportInfo5.f292070d);
                        }
                        if (!z16) {
                            TeamWorkFileImportInfo teamWorkFileImportInfo6 = this.f292445a;
                            teamWorkFileImportInfo6.I = false;
                            this.f292446b.fileImportFromLocalFile(teamWorkFileImportInfo6);
                        }
                        this.f292446b.addToFileImportingMap(this.f292445a);
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
            this.f292446b.addToFileImportingMap(this.f292445a);
        }
    }
}
