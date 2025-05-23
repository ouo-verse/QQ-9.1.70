package com.tencent.biz.troop.file;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.haoliyou.JumpShareUtils;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.util.URLUtil;
import ef0.c;
import ef0.d;
import ef0.f;
import ef0.h;
import ef0.i;
import ef0.j;
import ef0.k;
import ef0.l;
import ef0.m;
import ef0.n;
import ef0.o;
import ef0.p;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import msf.msgsvc.msg_ctrl$MsgCtrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qb1.g;
import tencent.im.cs.group_file_common.group_file_common$FeedsInfo;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$DeleteFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$DownloadFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$MoveFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$ReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$UploadFileReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7$CreateFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7$DeleteFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7$RenameFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7$ReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$GetFileCountReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$GetFileInfoReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$GetFileListReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$GetFilePreviewReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$GetSpaceReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$ReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9$CopyToReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9$FeedsReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9$ReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9$TransFileReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.biz.troop.file.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0982a implements e.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f96840d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f96841e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f96842f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f96843h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f96844i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ b f96845m;

        C0982a(List list, String str, FileManagerEntity fileManagerEntity, QQAppInterface qQAppInterface, int i3, b bVar) {
            this.f96840d = list;
            this.f96841e = str;
            this.f96842f = fileManagerEntity;
            this.f96843h = qQAppInterface;
            this.f96844i = i3;
            this.f96845m = bVar;
        }

        @Override // com.tencent.mobileqq.troop.utils.e.a
        public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
            StringBuilder sb5;
            FileManagerEntity fileManagerEntity;
            this.f96840d.clear();
            if (jSONObject != null) {
                try {
                    if (!jSONObject.isNull("dirs")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("dirs");
                        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                            ZipFilePresenter.f fVar = new ZipFilePresenter.f();
                            fVar.f208516a = true;
                            fVar.f208518c = jSONArray.getString(i16);
                            this.f96840d.add(fVar);
                        }
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            if (jSONObject != null && !jSONObject.isNull("files")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("files");
                for (int i17 = 0; i17 < jSONArray2.length(); i17++) {
                    ZipFilePresenter.f fVar2 = new ZipFilePresenter.f();
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i17);
                    fVar2.f208518c = jSONObject2.getString("filename");
                    fVar2.f208517b = jSONObject2.getLong("size");
                    if (this.f96841e.equals("/")) {
                        sb5 = new StringBuilder();
                        sb5.append("/");
                        sb5.append(fVar2.f208518c);
                    } else {
                        sb5 = new StringBuilder();
                        sb5.append(this.f96841e);
                        sb5.append("/");
                        sb5.append(fVar2.f208518c);
                    }
                    String sb6 = sb5.toString();
                    UUID nameUUIDFromBytes = UUID.nameUUIDFromBytes((this.f96842f.strTroopFilePath + this.f96841e + fVar2.f208518c).getBytes());
                    String c16 = com.tencent.mobileqq.troop.filemanager.e.c(this.f96842f.strTroopFilePath);
                    if (c16 == null || c16.length() == 0) {
                        c16 = "0";
                    }
                    UUID nameUUIDFromBytes2 = UUID.nameUUIDFromBytes((c16 + this.f96841e + fVar2.f208518c).getBytes());
                    TroopFileTransferManager O = TroopFileTransferManager.O(this.f96843h, this.f96842f.TroopUin);
                    t I = O.I(nameUUIDFromBytes);
                    if (I != null) {
                        fileManagerEntity = FileManagerUtil.newEntityByTroopFileInfo(I);
                        FileManagerEntity fileManagerEntity2 = this.f96842f;
                        fileManagerEntity.zipFilePath = fileManagerEntity2.strTroopFilePath;
                        fileManagerEntity.zipInnerPath = sb6;
                        fileManagerEntity.isZipInnerFile = true;
                        fileManagerEntity.zipType = this.f96844i;
                        fileManagerEntity.selfUin = fileManagerEntity2.selfUin;
                    } else {
                        t I2 = O.I(nameUUIDFromBytes2);
                        if (I2 != null) {
                            fileManagerEntity = FileManagerUtil.newEntityByTroopFileInfo(I2);
                            FileManagerEntity fileManagerEntity3 = this.f96842f;
                            fileManagerEntity.zipFilePath = fileManagerEntity3.strTroopFilePath;
                            fileManagerEntity.zipInnerPath = sb6;
                            fileManagerEntity.isZipInnerFile = true;
                            fileManagerEntity.zipType = this.f96844i;
                            fileManagerEntity.selfUin = fileManagerEntity3.selfUin;
                        } else {
                            FileManagerEntity fileManagerEntity4 = new FileManagerEntity();
                            fileManagerEntity4.fileName = fVar2.f208518c;
                            fileManagerEntity4.fileSize = fVar2.f208517b;
                            fileManagerEntity4.nSessionId = FileManagerUtil.genSessionId().longValue();
                            fileManagerEntity4.strTroopFilePath = nameUUIDFromBytes.toString();
                            fileManagerEntity4.strTroopFileID = nameUUIDFromBytes.toString();
                            fileManagerEntity4.zipInnerPath = sb6;
                            FileManagerEntity fileManagerEntity5 = this.f96842f;
                            fileManagerEntity4.selfUin = fileManagerEntity5.selfUin;
                            fileManagerEntity4.peerUin = fileManagerEntity5.peerUin;
                            fileManagerEntity4.peerType = fileManagerEntity5.peerType;
                            fileManagerEntity4.busId = fileManagerEntity5.busId;
                            fileManagerEntity4.cloudType = 4;
                            fileManagerEntity4.isZipInnerFile = true;
                            fileManagerEntity4.zipFilePath = fileManagerEntity5.strTroopFilePath;
                            fileManagerEntity4.zipType = this.f96844i;
                            fileManagerEntity4.TroopUin = fileManagerEntity5.TroopUin;
                            this.f96843h.getFileManagerProxy().x(fileManagerEntity4);
                            fileManagerEntity = fileManagerEntity4;
                        }
                    }
                    fileManagerEntity.isZipInnerFile = true;
                    fVar2.f208519d = fileManagerEntity.nSessionId;
                    this.f96840d.add(fVar2);
                }
            }
            b bVar = this.f96845m;
            if (bVar != null) {
                bVar.a(this.f96840d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a(List<ZipFilePresenter.f> list);
    }

    public static void a(QQAppInterface qQAppInterface, g gVar) {
        if (qQAppInterface != null && gVar != null) {
            ((ITroopFileProtoReqMgr) qQAppInterface.getRuntimeService(ITroopFileProtoReqMgr.class, "")).cancelRequest(gVar);
        }
    }

    public static void b(QQAppInterface qQAppInterface, long j3, String str, String str2, ef0.b bVar) {
        if (j3 != 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            oidb_0x6d7$CreateFolderReqBody oidb_0x6d7_createfolderreqbody = new oidb_0x6d7$CreateFolderReqBody();
            oidb_0x6d7_createfolderreqbody.str_parent_folder_id.set(str);
            oidb_0x6d7_createfolderreqbody.str_folder_name.set(str2);
            oidb_0x6d7_createfolderreqbody.uint32_app_id.set(3);
            oidb_0x6d7_createfolderreqbody.uint64_group_code.set(j3);
            oidb_0x6d7$ReqBody oidb_0x6d7_reqbody = new oidb_0x6d7$ReqBody();
            oidb_0x6d7_reqbody.create_folder_req.set(oidb_0x6d7_createfolderreqbody);
            ProtoUtils.j(qQAppInterface, bVar, oidb_0x6d7_reqbody.toByteArray(), "OidbSvc.0x6d7_0", 1751, 0);
        }
    }

    public static void c(QQAppInterface qQAppInterface, long j3, int i3, String str, String str2, int i16, int i17, c cVar) {
        if (j3 != 0 && !TextUtils.isEmpty(str)) {
            oidb_0x6d6$DeleteFileReqBody oidb_0x6d6_deletefilereqbody = new oidb_0x6d6$DeleteFileReqBody();
            oidb_0x6d6_deletefilereqbody.uint32_bus_id.set(i3);
            oidb_0x6d6_deletefilereqbody.str_file_id.set(str);
            oidb_0x6d6_deletefilereqbody.uint32_app_id.set(3);
            oidb_0x6d6_deletefilereqbody.uint64_group_code.set(j3);
            oidb_0x6d6_deletefilereqbody.str_parent_folder_id.set(str2);
            if (i16 != 0) {
                oidb_0x6d6_deletefilereqbody.uint32_msgdb_seq.set(i16);
            }
            if (i17 != 0) {
                oidb_0x6d6_deletefilereqbody.uint32_msg_rand.set(i17);
            }
            oidb_0x6d6$ReqBody oidb_0x6d6_reqbody = new oidb_0x6d6$ReqBody();
            oidb_0x6d6_reqbody.delete_file_req.set(oidb_0x6d6_deletefilereqbody);
            Bundle bundle = new Bundle();
            bundle.putString("fileId", str);
            ProtoUtils.k(qQAppInterface, cVar, oidb_0x6d6_reqbody.toByteArray(), "OidbSvc.0x6d6_3", 1750, 3, bundle);
        }
    }

    public static void d(QQAppInterface qQAppInterface, long j3, String str, d dVar) {
        if (j3 != 0 && !TextUtils.isEmpty(str)) {
            oidb_0x6d7$DeleteFolderReqBody oidb_0x6d7_deletefolderreqbody = new oidb_0x6d7$DeleteFolderReqBody();
            oidb_0x6d7_deletefolderreqbody.str_folder_id.set(str);
            oidb_0x6d7_deletefolderreqbody.uint32_app_id.set(3);
            oidb_0x6d7_deletefolderreqbody.uint64_group_code.set(j3);
            oidb_0x6d7$ReqBody oidb_0x6d7_reqbody = new oidb_0x6d7$ReqBody();
            oidb_0x6d7_reqbody.delete_folder_req.set(oidb_0x6d7_deletefolderreqbody);
            ProtoUtils.j(qQAppInterface, dVar, oidb_0x6d7_reqbody.toByteArray(), "OidbSvc.0x6d7_1", 1751, 1);
        }
    }

    public static void e(QQAppInterface qQAppInterface, long j3, ef0.e eVar) {
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileProtocol", 4, "getFileCount" + j3);
        }
        oidb_0x6d8$GetFileCountReqBody oidb_0x6d8_getfilecountreqbody = new oidb_0x6d8$GetFileCountReqBody();
        oidb_0x6d8_getfilecountreqbody.uint64_group_code.set(j3);
        oidb_0x6d8_getfilecountreqbody.uint32_app_id.set(3);
        oidb_0x6d8_getfilecountreqbody.uint32_bus_id.set(0);
        Bundle bundle = new Bundle();
        bundle.putLong("troopUin", j3);
        oidb_0x6d8$ReqBody oidb_0x6d8_reqbody = new oidb_0x6d8$ReqBody();
        oidb_0x6d8_reqbody.group_file_cnt_req.set(oidb_0x6d8_getfilecountreqbody);
        ProtoUtils.k(qQAppInterface, eVar, oidb_0x6d8_reqbody.toByteArray(), "OidbSvc.0x6d8_1", 1752, 2, bundle);
    }

    public static void f(QQAppInterface qQAppInterface, long j3, int i3, int i16, int i17, int i18, int i19, String str, int i26, long j16, ArrayList<Long> arrayList, int i27, ByteStringMicro byteStringMicro, f fVar) {
        g(qQAppInterface, j3, i3, i16, i17, i18, i19, str, i26, j16, arrayList, i27, i26 == 2 || i26 == 3 || i26 == 5, byteStringMicro, fVar);
    }

    public static void g(QQAppInterface qQAppInterface, long j3, int i3, int i16, int i17, int i18, int i19, String str, int i26, long j16, ArrayList<Long> arrayList, int i27, boolean z16, ByteStringMicro byteStringMicro, f fVar) {
        boolean z17 = i27 == 0;
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileProtocol", 4, "getFileList" + j3 + ",reqFor:" + i16 + ",reqFrom:" + i18 + ",count:" + i17 + ",firstPage:" + z17);
        }
        oidb_0x6d8$GetFileListReqBody oidb_0x6d8_getfilelistreqbody = new oidb_0x6d8$GetFileListReqBody();
        oidb_0x6d8_getfilelistreqbody.uint32_all_file_count.set(i3);
        oidb_0x6d8_getfilelistreqbody.uint32_file_count.set(i17);
        oidb_0x6d8_getfilelistreqbody.uint32_req_from.set(i18);
        oidb_0x6d8_getfilelistreqbody.uint64_group_code.set(j3);
        oidb_0x6d8_getfilelistreqbody.uint32_app_id.set(3);
        oidb_0x6d8_getfilelistreqbody.str_folder_id.set(str);
        oidb_0x6d8_getfilelistreqbody.uint32_sort_by.set(i19);
        oidb_0x6d8_getfilelistreqbody.uint32_filter_code.set(i26);
        oidb_0x6d8_getfilelistreqbody.uint64_uin.set(j16);
        if (arrayList != null) {
            oidb_0x6d8_getfilelistreqbody.uint64_filter_uin_list.set(arrayList);
        }
        oidb_0x6d8_getfilelistreqbody.uint32_start_index.set(i27);
        if (byteStringMicro == null) {
            oidb_0x6d8_getfilelistreqbody.bytes_context.set(ByteStringMicro.copyFromUtf8(""));
        } else {
            oidb_0x6d8_getfilelistreqbody.bytes_context.set(byteStringMicro);
        }
        if (z16) {
            oidb_0x6d8_getfilelistreqbody.uint32_show_onlinedoc_folder.set(0);
        } else {
            oidb_0x6d8_getfilelistreqbody.uint32_show_onlinedoc_folder.set(1);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("troopUin", j3);
        bundle.putInt("reqFor", i16);
        bundle.putInt("reqFrom", i18);
        bundle.putBoolean("isFirstPage", z17);
        bundle.putString("parentFileId", str);
        bundle.putLong("uin_filter", j16);
        bundle.putSerializable("uin_filter_list", arrayList);
        oidb_0x6d8$ReqBody oidb_0x6d8_reqbody = new oidb_0x6d8$ReqBody();
        oidb_0x6d8_reqbody.file_list_info_req.set(oidb_0x6d8_getfilelistreqbody);
        ProtoUtils.k(qQAppInterface, fVar, oidb_0x6d8_reqbody.toByteArray(), "OidbSvc.0x6d8_1", 1752, 1, bundle);
    }

    public static g h(QQAppInterface qQAppInterface, long j3, String str, int i3, ef0.g gVar) {
        String str2;
        String str3;
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileProtocol", 4, "getFilePreviewList" + j3 + ",filePath:" + str + ",busId:" + i3);
        }
        oidb_0x6d8$GetFilePreviewReqBody oidb_0x6d8_getfilepreviewreqbody = new oidb_0x6d8$GetFilePreviewReqBody();
        oidb_0x6d8_getfilepreviewreqbody.uint64_group_code.set(j3);
        oidb_0x6d8_getfilepreviewreqbody.uint32_app_id.set(3);
        oidb_0x6d8_getfilepreviewreqbody.uint32_bus_id.set(i3);
        PBStringField pBStringField = oidb_0x6d8_getfilepreviewreqbody.str_file_id;
        if (str != null) {
            str2 = str;
        } else {
            str2 = "";
        }
        pBStringField.set(str2);
        if (TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getFilePreviewList, filePath is ");
            if (str == null) {
                str3 = "null";
            } else {
                str3 = GlobalUtil.DEF_STRING;
            }
            sb5.append(str3);
            QLog.w("TroopFileProtocol", 1, sb5.toString());
        }
        oidb_0x6d8$ReqBody oidb_0x6d8_reqbody = new oidb_0x6d8$ReqBody();
        oidb_0x6d8_reqbody.file_preview_req.set(oidb_0x6d8_getfilepreviewreqbody);
        return x(qQAppInterface, gVar, oidb_0x6d8_reqbody.toByteArray(), "OidbSvc.0x6d8_4", 1752, 4, null);
    }

    public static void i(QQAppInterface qQAppInterface, long j3, h hVar) {
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileProtocol", 4, "getFileSpace" + j3);
        }
        oidb_0x6d8$GetSpaceReqBody oidb_0x6d8_getspacereqbody = new oidb_0x6d8$GetSpaceReqBody();
        oidb_0x6d8_getspacereqbody.uint64_group_code.set(j3);
        oidb_0x6d8_getspacereqbody.uint32_app_id.set(3);
        Bundle bundle = new Bundle();
        bundle.putLong("troopUin", j3);
        oidb_0x6d8$ReqBody oidb_0x6d8_reqbody = new oidb_0x6d8$ReqBody();
        oidb_0x6d8_reqbody.group_space_req.set(oidb_0x6d8_getspacereqbody);
        ProtoUtils.b(qQAppInterface, hVar, oidb_0x6d8_reqbody.toByteArray(), "OidbSvc.0x6d8_3", 1752, 3, bundle);
    }

    private static String j(TroopFileTransferManager.Item item) {
        File file;
        String str;
        if (!ZhuoXusManager.instance().isSendFileQRCodeOpen()) {
            if (QLog.isColorLevel()) {
                QLog.i("IMG_FILE", 1, "choushane false!");
            }
            return "";
        }
        String str2 = item.strQRUrl;
        if (str2 != null) {
            return str2;
        }
        if (com.tencent.biz.qqstory.utils.d.k(item.middleThumbnailFile)) {
            file = new File(item.middleThumbnailFile);
            str = "mid";
        } else if (com.tencent.biz.qqstory.utils.d.k(item.largeThumbnailFile)) {
            file = new File(item.largeThumbnailFile);
            str = "larg";
        } else {
            return null;
        }
        Pair<StringBuilder, StringBuilder> qRCodeResult = JumpShareUtils.getQRCodeResult(BaseApplication.getContext(), file);
        if (qRCodeResult != null) {
            item.strQRUrl = ((StringBuilder) qRCodeResult.first).toString();
            if (QLog.isDevelopLevel()) {
                QLog.i("IMG_FILE_QR", 1, "reqFeeds getImageUrl success:" + item.strQRUrl + " use:" + str);
            }
            return item.strQRUrl;
        }
        return "";
    }

    public static void k(QQAppInterface qQAppInterface, String str, String str2, String str3, int i3, String str4, String str5, FileManagerEntity fileManagerEntity, b bVar) {
        com.tencent.mobileqq.troop.utils.f fVar = new com.tencent.mobileqq.troop.utils.f("http://" + str + ":" + str2 + "/ftn_compress_list/rkey=" + str3 + "&filetype=" + i3 + "&path=" + URLUtil.encodeUrl(str4) + ContainerUtils.FIELD_DELIMITER, "GET", new C0982a(new ArrayList(), str4, fileManagerEntity, qQAppInterface, i3, bVar), 1000, null);
        Bundle bundle = new Bundle();
        bundle.putString("version", ah.P());
        bundle.putString("Cookie", str5);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("BUNDLE", bundle);
        hashMap.put("CONTEXT", qQAppInterface.getApp().getApplicationContext());
        fVar.b(hashMap);
    }

    public static void l(QQAppInterface qQAppInterface, long j3, int i3, String str, String str2, String str3, j jVar) {
        if (j3 == 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || str2.equals(str3)) {
            return;
        }
        oidb_0x6d6$MoveFileReqBody oidb_0x6d6_movefilereqbody = new oidb_0x6d6$MoveFileReqBody();
        oidb_0x6d6_movefilereqbody.uint32_bus_id.set(i3);
        oidb_0x6d6_movefilereqbody.str_file_id.set(str);
        oidb_0x6d6_movefilereqbody.uint32_app_id.set(3);
        oidb_0x6d6_movefilereqbody.uint64_group_code.set(j3);
        oidb_0x6d6_movefilereqbody.str_parent_folder_id.set(str2);
        oidb_0x6d6_movefilereqbody.str_dest_folder_id.set(str3);
        oidb_0x6d6$ReqBody oidb_0x6d6_reqbody = new oidb_0x6d6$ReqBody();
        oidb_0x6d6_reqbody.move_file_req.set(oidb_0x6d6_movefilereqbody);
        ProtoUtils.j(qQAppInterface, jVar, oidb_0x6d6_reqbody.toByteArray(), "OidbSvc.0x6d6_5", 1750, 5);
    }

    public static void m(QQAppInterface qQAppInterface, long j3, int i3, String str, i iVar) {
        if (qQAppInterface != null && j3 != 0 && !TextUtils.isEmpty(str)) {
            oidb_0x6d8$GetFileInfoReqBody oidb_0x6d8_getfileinforeqbody = new oidb_0x6d8$GetFileInfoReqBody();
            oidb_0x6d8_getfileinforeqbody.uint64_group_code.set(j3);
            oidb_0x6d8_getfileinforeqbody.uint32_app_id.set(3);
            oidb_0x6d8_getfileinforeqbody.uint32_bus_id.set(i3);
            oidb_0x6d8_getfileinforeqbody.str_file_id.set(str);
            oidb_0x6d8$ReqBody oidb_0x6d8_reqbody = new oidb_0x6d8$ReqBody();
            oidb_0x6d8_reqbody.file_info_req.set(oidb_0x6d8_getfileinforeqbody);
            ProtoUtils.j(qQAppInterface, iVar, oidb_0x6d8_reqbody.toByteArray(), "OidbSvc.0x6d8_0", 1752, 0);
        }
    }

    public static void n(QQAppInterface qQAppInterface, long j3, String str, String str2, k kVar) {
        if (j3 != 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            oidb_0x6d7$RenameFolderReqBody oidb_0x6d7_renamefolderreqbody = new oidb_0x6d7$RenameFolderReqBody();
            oidb_0x6d7_renamefolderreqbody.str_folder_id.set(str);
            oidb_0x6d7_renamefolderreqbody.str_new_folder_name.set(str2);
            oidb_0x6d7_renamefolderreqbody.uint32_app_id.set(3);
            oidb_0x6d7_renamefolderreqbody.uint64_group_code.set(j3);
            oidb_0x6d7$ReqBody oidb_0x6d7_reqbody = new oidb_0x6d7$ReqBody();
            oidb_0x6d7_reqbody.rename_folder_req.set(oidb_0x6d7_renamefolderreqbody);
            Bundle bundle = new Bundle();
            bundle.putString("folderId", str);
            bundle.putString("folderName", str2);
            ProtoUtils.k(qQAppInterface, kVar, oidb_0x6d7_reqbody.toByteArray(), "OidbSvc.0x6d7_2", 1751, 2, bundle);
        }
    }

    public static void o(QQAppInterface qQAppInterface, long j3, int i3, String str, long j16, int i16, Bundle bundle, l lVar) {
        oidb_0x6d9$CopyToReqBody oidb_0x6d9_copytoreqbody = new oidb_0x6d9$CopyToReqBody();
        oidb_0x6d9_copytoreqbody.uint32_app_id.set(3);
        oidb_0x6d9_copytoreqbody.uint64_group_code.set(j3);
        oidb_0x6d9_copytoreqbody.uint64_dst_uin.set(j16);
        oidb_0x6d9_copytoreqbody.uint32_src_bus_id.set(i3);
        oidb_0x6d9_copytoreqbody.str_src_file_id.set(str);
        oidb_0x6d9_copytoreqbody.uint32_dst_bus_id.set(i16);
        oidb_0x6d9$ReqBody oidb_0x6d9_reqbody = new oidb_0x6d9$ReqBody();
        oidb_0x6d9_reqbody.copy_to_req.set(oidb_0x6d9_copytoreqbody);
        ProtoUtils.k(qQAppInterface, lVar, oidb_0x6d9_reqbody.toByteArray(), "OidbSvc.0x6d9_2", 1753, 2, bundle);
    }

    public static void p(QQAppInterface qQAppInterface, boolean z16, long j3, TroopFileTransferManager.Item item, long j16, long j17, l lVar) {
        if (j3 != 0 && item != null) {
            oidb_0x6d9$CopyToReqBody oidb_0x6d9_copytoreqbody = new oidb_0x6d9$CopyToReqBody();
            oidb_0x6d9_copytoreqbody.uint32_app_id.set(3);
            if (z16) {
                oidb_0x6d9_copytoreqbody.uint64_group_code.set(j3);
            } else {
                oidb_0x6d9_copytoreqbody.uint64_group_code.set(item.ForwardTroopuin);
            }
            oidb_0x6d9_copytoreqbody.uint64_dst_uin.set(j16);
            oidb_0x6d9_copytoreqbody.uint32_src_bus_id.set(item.ForwardBusId);
            if (!TextUtils.isEmpty(item.ForwardPath)) {
                oidb_0x6d9_copytoreqbody.str_src_file_id.set(item.ForwardPath);
            }
            oidb_0x6d9_copytoreqbody.uint32_dst_bus_id.set(item.BusId);
            oidb_0x6d9$ReqBody oidb_0x6d9_reqbody = new oidb_0x6d9$ReqBody();
            oidb_0x6d9_reqbody.copy_to_req.set(oidb_0x6d9_copytoreqbody);
            Bundle bundle = new Bundle();
            bundle.putLong("troopUin", j3);
            bundle.putString("itemKey", item.Id.toString());
            bundle.putLong("sessionId", j17);
            if (item.BusId == 25) {
                ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).startSave2Weiyun();
            }
            ProtoUtils.k(qQAppInterface, lVar, oidb_0x6d9_reqbody.toByteArray(), "OidbSvc.0x6d9_2", 1753, 2, bundle);
        }
    }

    public static g q(QQAppInterface qQAppInterface, long j3, TroopFileTransferManager.Item item, int i3, boolean z16, boolean z17, m mVar) {
        boolean z18;
        if (j3 != 0 && item != null) {
            int fileType = FileManagerUtil.getFileType(q.j(item.FileName));
            oidb_0x6d6$DownloadFileReqBody oidb_0x6d6_downloadfilereqbody = new oidb_0x6d6$DownloadFileReqBody();
            oidb_0x6d6_downloadfilereqbody.uint32_bus_id.set(item.BusId);
            oidb_0x6d6_downloadfilereqbody.uint32_app_id.set(3);
            oidb_0x6d6_downloadfilereqbody.uint64_group_code.set(j3);
            oidb_0x6d6_downloadfilereqbody.str_file_id.set(item.FilePath);
            PBBoolField pBBoolField = oidb_0x6d6_downloadfilereqbody.bool_thumbnail_req;
            if (i3 != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            pBBoolField.set(z18);
            oidb_0x6d6_downloadfilereqbody.bool_preview_req.set(z16);
            if (fileType == 2) {
                if (z17) {
                    oidb_0x6d6_downloadfilereqbody.uint32_src.set(1);
                } else {
                    oidb_0x6d6_downloadfilereqbody.uint32_src.set(0);
                }
                if (i3 != 0) {
                    oidb_0x6d6_downloadfilereqbody.bool_thumbnail_req.set(false);
                    oidb_0x6d6_downloadfilereqbody.bool_preview_req.set(true);
                } else {
                    oidb_0x6d6_downloadfilereqbody.bool_thumbnail_req.set(false);
                    oidb_0x6d6_downloadfilereqbody.bool_preview_req.set(false);
                }
            }
            oidb_0x6d6_downloadfilereqbody.uint32_url_type.set(0);
            Bundle bundle = new Bundle();
            bundle.putString("itemKey", item.Id.toString());
            bundle.putLong("troopUin", j3);
            bundle.putInt("thumbNail", i3);
            bundle.putBoolean("isPreview", z16);
            oidb_0x6d6$ReqBody oidb_0x6d6_reqbody = new oidb_0x6d6$ReqBody();
            oidb_0x6d6_reqbody.download_file_req.set(oidb_0x6d6_downloadfilereqbody);
            return x(qQAppInterface, mVar, oidb_0x6d6_reqbody.toByteArray(), "OidbSvc.0x6d6_2", 1750, 2, bundle);
        }
        return null;
    }

    public static void r(QQAppInterface qQAppInterface, long j3, int i3, String str, int i16, int i17, int i18, int i19, boolean z16, Bundle bundle, n nVar) {
        s(qQAppInterface, j3, i3, str, i16, i17, i18, i19, z16, bundle, null, nVar);
    }

    private static void s(QQAppInterface qQAppInterface, long j3, int i3, String str, int i16, int i17, int i18, int i19, boolean z16, Bundle bundle, msg_ctrl$MsgCtrl msg_ctrl_msgctrl, n nVar) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("TroopFileProtocol", 1, "reqFeeds error.filePath is null ");
            return;
        }
        group_file_common$FeedsInfo group_file_common_feedsinfo = new group_file_common$FeedsInfo();
        group_file_common_feedsinfo.str_file_id.set(str);
        group_file_common_feedsinfo.uint32_bus_id.set(i3);
        group_file_common_feedsinfo.uint32_msg_random.set(i16);
        if (z16) {
            group_file_common_feedsinfo.uint32_feed_flag.set(1);
            if (i16 == 0) {
                group_file_common_feedsinfo.uint32_msg_random.set(Math.abs(new Random().nextInt()));
            }
        } else {
            group_file_common_feedsinfo.uint32_feed_flag.set(3);
        }
        if (msg_ctrl_msgctrl != null) {
            group_file_common_feedsinfo.msg_ctrl.set(msg_ctrl_msgctrl);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (bundle.containsKey("yyb_apk_package_name_key")) {
                jSONObject.put("yyb_apk_package_name_key", bundle.getString("yyb_apk_package_name_key"));
            }
            if (bundle.containsKey("yyb_apk_name_key")) {
                jSONObject.put("yyb_apk_name_key", bundle.getString("yyb_apk_name_key"));
            }
            if (bundle.containsKey("yyb_apk_icon_url_key")) {
                jSONObject.put("yyb_apk_icon_url_key", bundle.getString("yyb_apk_icon_url_key"));
            }
            if (i17 != 0 && i18 != 0) {
                jSONObject.put("width", i17);
                jSONObject.put("height", i18);
                jSONObject.put("duration", i19);
            }
            if (jSONObject.length() > 0) {
                group_file_common_feedsinfo.bytes_ext.set(ByteStringMicro.copyFromUtf8(jSONObject.toString()));
            }
            if (bundle.containsKey("key_from_scene")) {
                group_file_common_feedsinfo.uint32_file_from_scene.set(bundle.getInt("key_from_scene"));
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        oidb_0x6d9$FeedsReqBody oidb_0x6d9_feedsreqbody = new oidb_0x6d9$FeedsReqBody();
        oidb_0x6d9_feedsreqbody.uint32_app_id.set(3);
        oidb_0x6d9_feedsreqbody.uint64_group_code.set(j3);
        oidb_0x6d9_feedsreqbody.rpt_feeds_info_list.add(group_file_common_feedsinfo);
        oidb_0x6d9$ReqBody oidb_0x6d9_reqbody = new oidb_0x6d9$ReqBody();
        oidb_0x6d9_reqbody.feeds_info_req.set(oidb_0x6d9_feedsreqbody);
        ProtoUtils.k(qQAppInterface, nVar, oidb_0x6d9_reqbody.toByteArray(), "OidbSvc.0x6d9_4", 1753, 4, bundle);
    }

    public static void t(QQAppInterface qQAppInterface, long j3, TroopFileTransferManager.Item item, n nVar) {
        if (j3 != 0 && item != null) {
            QLog.i("TroopFileProtocol", 1, "reqFeeds, waterTest.");
            Bundle bundle = new Bundle();
            bundle.putString("itemKey", item.Id.toString());
            bundle.putLong("troopUin", j3);
            bundle.putString("fileId", item.FilePath);
            QLog.i("TroopFileProtocol", 1, "reqFeeds, waterTest.pkgName[" + item.yybApkPackageName + "]");
            if (!TextUtils.isEmpty(item.yybApkPackageName)) {
                bundle.putString("yyb_apk_package_name_key", item.yybApkPackageName);
            }
            if (!TextUtils.isEmpty(item.yybApkName)) {
                bundle.putString("yyb_apk_name_key", item.yybApkName);
            }
            if (!TextUtils.isEmpty(item.yybApkIconUrl)) {
                bundle.putString("yyb_apk_icon_url_key", item.yybApkIconUrl);
            }
            int i3 = item.fromScene;
            if (i3 != 0) {
                bundle.putInt("key_from_scene", i3);
            }
            s(qQAppInterface, j3, item.BusId, item.FilePath, item.RandomNum, item.width, item.height, item.duration, true, bundle, JumpShareUtils.getMsgCtrl(item.LocalFile, item.width, item.height, j(item)), nVar);
        }
    }

    public static void u(QQAppInterface qQAppInterface, long j3, com.tencent.mobileqq.troop.data.n nVar, o oVar) {
        if (j3 != 0 && nVar != null) {
            oidb_0x6d9$TransFileReqBody oidb_0x6d9_transfilereqbody = new oidb_0x6d9$TransFileReqBody();
            oidb_0x6d9_transfilereqbody.uint32_app_id.set(3);
            oidb_0x6d9_transfilereqbody.uint64_group_code.set(j3);
            oidb_0x6d9_transfilereqbody.uint32_bus_id.set(nVar.f294919e);
            oidb_0x6d9_transfilereqbody.str_file_id.set(nVar.f294916b);
            Bundle bundle = new Bundle();
            bundle.putLong("troopUin", j3);
            bundle.putString("fileId", nVar.f294916b);
            oidb_0x6d9$ReqBody oidb_0x6d9_reqbody = new oidb_0x6d9$ReqBody();
            oidb_0x6d9_reqbody.trans_file_req.set(oidb_0x6d9_transfilereqbody);
            ProtoUtils.k(qQAppInterface, oVar, oidb_0x6d9_reqbody.toByteArray(), "OidbSvc.0x6d9_0", 1753, 0, bundle);
        }
    }

    public static g v(QQAppInterface qQAppInterface, long j3, TroopFileTransferManager.Item item, p pVar) {
        if (j3 != 0 && item != null) {
            Bundle bundle = new Bundle();
            bundle.putString("itemKey", item.Id.toString());
            bundle.putLong("troopUin", j3);
            bundle.putBoolean("bExtfTransfer", item.bExtfTransfer);
            return w(qQAppInterface, j3, item.FileName, item.LocalFile, item.ProgressTotal, item.isFromAIO, item.Md5, item.Sha, item.Sha3, item.BusId, item.mParentId, bundle, pVar);
        }
        return null;
    }

    public static g w(QQAppInterface qQAppInterface, long j3, String str, String str2, long j16, boolean z16, byte[] bArr, byte[] bArr2, String str3, int i3, String str4, Bundle bundle, p pVar) {
        oidb_0x6d6$UploadFileReqBody oidb_0x6d6_uploadfilereqbody = new oidb_0x6d6$UploadFileReqBody();
        oidb_0x6d6_uploadfilereqbody.uint32_bus_id.set(i3);
        oidb_0x6d6_uploadfilereqbody.uint32_app_id.set(3);
        oidb_0x6d6_uploadfilereqbody.uint64_group_code.set(j3);
        oidb_0x6d6_uploadfilereqbody.bytes_md5.set(ByteStringMicro.copyFrom(bArr));
        oidb_0x6d6_uploadfilereqbody.bytes_sha.set(ByteStringMicro.copyFrom(bArr2));
        if (str3 != null) {
            oidb_0x6d6_uploadfilereqbody.bytes_sha3.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str3)));
        }
        if (TextUtils.isEmpty(str4)) {
            oidb_0x6d6_uploadfilereqbody.str_parent_folder_id.set("/");
        } else {
            oidb_0x6d6_uploadfilereqbody.str_parent_folder_id.set(str4);
        }
        oidb_0x6d6_uploadfilereqbody.str_file_name.set(str);
        oidb_0x6d6_uploadfilereqbody.str_local_path.set(str2);
        oidb_0x6d6_uploadfilereqbody.uint32_entrance.set(z16 ? 5 : 4);
        oidb_0x6d6_uploadfilereqbody.uint64_file_size.set(j16);
        if (bundle != null ? bundle.getBoolean("bExtfTransfer", false) : false) {
            oidb_0x6d6_uploadfilereqbody.bool_support_multi_upload.set(true);
        }
        oidb_0x6d6$ReqBody oidb_0x6d6_reqbody = new oidb_0x6d6$ReqBody();
        oidb_0x6d6_reqbody.upload_file_req.set(oidb_0x6d6_uploadfilereqbody);
        return x(qQAppInterface, pVar, oidb_0x6d6_reqbody.toByteArray(), "OidbSvc.0x6d6_0", 1750, 0, bundle);
    }

    private static g x(QQAppInterface qQAppInterface, ProtoUtils.TroopProtocolObserver troopProtocolObserver, byte[] bArr, String str, int i3, int i16, Bundle bundle) {
        if (qQAppInterface == null) {
            return null;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        g createProtoReq = ((ITroopFileProtoReqMgr) qQAppInterface.getRuntimeService(ITroopFileProtoReqMgr.class, "")).createProtoReq();
        createProtoReq.a(str);
        createProtoReq.d(oidb_sso_oidbssopkg.toByteArray());
        createProtoReq.b(bundle);
        createProtoReq.c(troopProtocolObserver);
        ((ITroopFileProtoReqMgr) qQAppInterface.getRuntimeService(ITroopFileProtoReqMgr.class, "")).sendProtoRequest(createProtoReq);
        return createProtoReq;
    }
}
