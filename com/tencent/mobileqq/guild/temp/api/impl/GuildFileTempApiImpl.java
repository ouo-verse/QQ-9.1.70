package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.Activity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.guild.file.k;
import com.tencent.mobileqq.guild.file.v;
import com.tencent.mobileqq.guild.temp.api.IGuildFileTempApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import org.json.JSONObject;
import tencent.im.msg.obj_msg$ObjMsg;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildFileTempApiImpl implements IGuildFileTempApi {
    private static final String TAG = "GuildFileTempApiImpl";

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFileTempApi
    public Object getNewGuildFileDownloader(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        return new com.tencent.mobileqq.guild.file.c((QQAppInterface) baseQQAppInterface, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFileTempApi
    public Object getNewGuildFileModel(BaseQQAppInterface baseQQAppInterface, Activity activity, Object obj, int i3) {
        return new k((QQAppInterface) baseQQAppInterface, activity, (List) obj, i3);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFileTempApi
    public Object getNewVideoForGuild(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        return new v((QQAppInterface) baseQQAppInterface, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildFileTempApi
    public void handleGuildFileMsg(BaseQQAppInterface baseQQAppInterface, Object obj, MessageForFile messageForFile, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar) {
        obj_msg$ObjMsg obj_msg_objmsg = (obj_msg$ObjMsg) obj;
        com.tencent.mobileqq.guild.file.a aVar2 = new com.tencent.mobileqq.guild.file.a();
        aVar2.f224368b = String.valueOf(aVar.f286338a);
        aVar2.f224367a = String.valueOf(aVar.f286169x);
        aVar2.f224377k = new String(obj_msg_objmsg.msg_content_info.get(0).msg_file.bytes_file_path.get().toByteArray());
        aVar2.f224371e = obj_msg_objmsg.msg_content_info.get(0).msg_file.uint32_bus_id.get();
        aVar2.f224375i = obj_msg_objmsg.msg_content_info.get(0).msg_file.str_file_name.get();
        aVar2.f224376j = obj_msg_objmsg.msg_content_info.get(0).msg_file.uint64_file_size.get();
        aVar2.f224379m = obj_msg_objmsg.msg_content_info.get(0).msg_file.int64_dead_time.get();
        aVar2.f224373g = new String(obj_msg_objmsg.msg_content_info.get(0).msg_file.bytes_file_sha1.get().toByteArray());
        aVar2.f224374h = new String(obj_msg_objmsg.msg_content_info.get(0).msg_file.bytes_file_md5.get().toByteArray());
        if (obj_msg_objmsg.msg_content_info.get(0).msg_file.bytes_ext.has()) {
            try {
                JSONObject jSONObject = new JSONObject(obj_msg_objmsg.msg_content_info.get(0).msg_file.bytes_ext.get().toStringUtf8());
                aVar2.f224380n = jSONObject.optInt("width");
                aVar2.f224381o = jSONObject.optInt("height");
                aVar2.f224382p = jSONObject.optInt("duration");
                aVar2.f224383q = jSONObject.optString("yyb_apk_package_name_key");
                aVar2.f224384r = jSONObject.optString("yyb_apk_name_key");
                aVar2.f224385s = jSONObject.optString("yyb_apk_icon_url_key");
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16.toString());
            }
        }
        String str = new String(obj_msg_objmsg.bytes_title.get().toByteArray());
        aVar2.f224370d = str;
        aVar2.f224370d = FileManagerUtil.getFileName(str);
        aVar2.f224369c = new String(obj_msg_objmsg.rpt_bytes_abstact.get(0).toByteArray());
        com.tencent.mobileqq.guild.file.e.c().d((QQAppInterface) baseQQAppInterface, messageForFile, msg_comm_msg, aVar2, aVar);
    }
}
