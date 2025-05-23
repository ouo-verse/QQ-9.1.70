package com.tencent.mobileqq.teamwork.api.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm$C2CTmpMsgHead;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$NotOnlineFile;
import tencent.im.oidb.cmd0x857.TroopTips0x857$TroopFormGrayTipsInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119$MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkUtilsTempImpl implements ITeamWorkUtilsTemp {
    private static final String TAG = "TeamWorkUtils";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class ProcessTDFileScheduler {

        /* renamed from: c, reason: collision with root package name */
        private static ProcessTDFileScheduler f291733c;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<AppInterface> f291734a;

        /* renamed from: b, reason: collision with root package name */
        private ConcurrentLinkedQueue<MessageRecord> f291735b = new ConcurrentLinkedQueue<>();

        ProcessTDFileScheduler(AppInterface appInterface) {
            this.f291734a = new WeakReference<>(appInterface);
        }

        public static ProcessTDFileScheduler b(AppInterface appInterface) {
            if (f291733c == null) {
                synchronized (ProcessTDFileScheduler.class) {
                    if (f291733c == null) {
                        f291733c = new ProcessTDFileScheduler(appInterface);
                    }
                }
            }
            f291733c.f291734a = new WeakReference<>(appInterface);
            return f291733c;
        }

        public void c() {
            final AppInterface appInterface;
            if (this.f291735b.size() <= 0 || (appInterface = this.f291734a.get()) == null || !(appInterface instanceof QQAppInterface) || ((QQAppInterface) appInterface).mAutomator.getInActionLoginB() != 1) {
                return;
            }
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsTempImpl.ProcessTDFileScheduler.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = ProcessTDFileScheduler.this.f291735b.iterator();
                    while (it.hasNext()) {
                        ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).tryProcessTDDocMessageRecord((MessageRecord) it.next(), appInterface);
                        it.remove();
                    }
                }
            }, null, true);
        }

        public void d(MessageRecord messageRecord) {
            JSONObject jSONObject;
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            if (messageRecord == null) {
                return;
            }
            if (messageRecord instanceof MessageForStructing) {
                MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
                AbsStructMsg absStructMsg = messageForStructing.structingMsg;
                if (absStructMsg != null && !TextUtils.isEmpty(absStructMsg.mMsgUrl) && com.tencent.mobileqq.filemanager.data.e.g(messageForStructing.structingMsg.mMsgUrl)) {
                    this.f291735b.add(messageRecord);
                    return;
                }
                return;
            }
            if (messageRecord instanceof MessageForArkApp) {
                MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
                String str = messageForArkApp.ark_app_message.metaList;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    if ("com.tencent.miniapp_01".equals(messageForArkApp.ark_app_message.appName)) {
                        if (jSONObject2.has("detail_1") && (optJSONObject2 = jSONObject2.optJSONObject("detail_1")) != null) {
                            String optString = optJSONObject2.optString("appid");
                            String optString2 = optJSONObject2.optString("qqdocurl");
                            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && ((optString.equals(ITeamWorkUtils.TENCENT_DOC_MIMI_APPID) || optString.equals(ITeamWorkUtils.TROOP_FORM_MIMI_APPID)) && com.tencent.mobileqq.filemanager.data.e.g(optString2))) {
                                this.f291735b.add(messageRecord);
                            }
                        }
                    } else if ("com.tencent.miniapp".equals(messageForArkApp.ark_app_message.appName)) {
                        if (jSONObject2.has("detail") && (optJSONObject = jSONObject2.optJSONObject("detail")) != null) {
                            String optString3 = optJSONObject.optString("appid");
                            String optString4 = optJSONObject.optString("qqdocurl");
                            if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && ((optString3.equals(ITeamWorkUtils.TENCENT_DOC_MIMI_APPID) || optString3.equals(ITeamWorkUtils.TROOP_FORM_MIMI_APPID)) && com.tencent.mobileqq.filemanager.data.e.g(optString4))) {
                                this.f291735b.add(messageRecord);
                            }
                        }
                    } else if ("com.tencent.structmsg".equals(messageForArkApp.ark_app_message.appName) && jSONObject2.has("news") && (jSONObject = jSONObject2.getJSONObject("news")) != null) {
                        String optString5 = jSONObject.optString("appid");
                        String optString6 = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && optString5.equals(String.valueOf(ITeamWorkUtils.DOCS_APPID)) && com.tencent.mobileqq.filemanager.data.e.g(optString6)) {
                            this.f291735b.add(messageRecord);
                        }
                    }
                    return;
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(com.tencent.mobileqq.teamwork.t.f292405j, 2, e16.getMessage());
                        return;
                    }
                    return;
                }
            }
            if ((messageRecord instanceof MessageForText) && com.tencent.mobileqq.filemanager.data.e.g(((MessageForText) messageRecord).f203106msg)) {
                this.f291735b.add(messageRecord);
            }
        }
    }

    private static String getTroopFormGrayContent(AppInterface appInterface, String str, String str2) {
        String H;
        if (appInterface == null || !(appInterface instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        QLog.d(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "troopFormLog getTroopFormGrayContent =." + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Matcher matcher = Pattern.compile(ITeamWorkUtils.TROOP_FORM_GREY_PATTERN).matcher(str);
        int i3 = 0;
        boolean z16 = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String substring = str.substring(start + 1, end);
            String substring2 = str.substring(i3, start);
            int i16 = end + 1;
            spannableStringBuilder.append((CharSequence) substring2);
            try {
                JSONObject jSONObject = new JSONObject(substring);
                if (jSONObject.has("uin")) {
                    String string = jSONObject.getString("uin");
                    String currentAccountUin = appInterface.getCurrentAccountUin();
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str2, string, null, TAG);
                            if (troopMemberInfoSync != null) {
                                H = troopMemberInfoSync.nickInfo.getShowName();
                            } else {
                                H = string;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            e.printStackTrace();
                            i3 = i16;
                        }
                    } else {
                        H = com.tencent.mobileqq.utils.ac.H(qQAppInterface, string);
                    }
                    if (!TextUtils.isEmpty(currentAccountUin) && currentAccountUin.equals(string) && !z16) {
                        H = ITeamWorkUtils.TROOP_FORM_GREY_NICKNAME;
                        z16 = true;
                    }
                    spannableStringBuilder.append((CharSequence) H);
                } else if (jSONObject.has("text") && jSONObject.has(ITeamWorkUtils.TROOP_FORM_GREY_TAG_LINK) && jSONObject.getString(ITeamWorkUtils.TROOP_FORM_GREY_TAG_LINK).equals("1")) {
                    String string2 = jSONObject.getString("text");
                    if (!TextUtils.isEmpty(string2)) {
                        spannableStringBuilder.append((CharSequence) string2);
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
            i3 = i16;
        }
        if (i3 != str.length()) {
            spannableStringBuilder.append(str.subSequence(i3, str.length()));
        }
        return spannableStringBuilder.toString();
    }

    private String getUin() {
        AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return peekAppRuntime.getAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processTDDocFileUrl$0(String str, String[] strArr, String str2, String[] strArr2, ChatMessage chatMessage, QQAppInterface qQAppInterface, Object obj) {
        if (!(obj instanceof JSONObject)) {
            return;
        }
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (jSONObject.getInt("retcode") == 0) {
                TencentDocData tencentDocData = new TencentDocData();
                TencentDocData.obtainFromJsonObject(jSONObject, null, tencentDocData);
                tencentDocData.docUrl = str;
                if (strArr[0] == null) {
                    strArr[0] = str2;
                }
                if (!TextUtils.isEmpty(strArr[0])) {
                    tencentDocData.sendUin = Long.parseLong(strArr[0]);
                }
                if (strArr2[0] == null) {
                    strArr2[0] = str2;
                }
                tencentDocData.aioTime = System.currentTimeMillis() / 1000;
                ArrayList arrayList = new ArrayList();
                arrayList.add(tencentDocData);
                for (ChatMessage chatMessage2 : createChatMsgListFromTencentDocs(arrayList, str2, strArr2[0])) {
                    if (chatMessage != null) {
                        chatMessage2.istroop = chatMessage.istroop;
                    }
                    tdDocMessageRecordSaveToFMDB(chatMessage2, qQAppInterface);
                }
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, th5, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryProcessTDDocMessageRecord$1(StructMsgForGeneralShare structMsgForGeneralShare, MessageForStructing messageForStructing, AppInterface appInterface, Object obj) {
        if (!(obj instanceof JSONObject)) {
            return;
        }
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (jSONObject.getInt("retcode") == 0) {
                structMsgForGeneralShare.mContentTitle = (String) ((JSONObject) jSONObject.get("doc_meta")).get("title");
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private void tdDocMessageRecordSaveToFMDB(MessageRecord messageRecord, AppInterface appInterface) {
        final MessageForStructing messageForStructing;
        AbsStructMsg absStructMsg;
        String str;
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            final QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if ((messageRecord instanceof MessageForStructing) && (absStructMsg = (messageForStructing = (MessageForStructing) messageRecord).structingMsg) != null && !TextUtils.isEmpty(absStructMsg.mMsgUrl)) {
                if (QLog.isColorLevel()) {
                    QLog.d(com.tencent.mobileqq.teamwork.t.f292405j, 2, "tencentdoc also need insert into fm db");
                }
                final msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
                msg_comm_msg.msg_head.set(new msg_comm$MsgHead());
                msg_comm_msg.msg_head.get().msg_uid.set(messageForStructing.longMsgId);
                msg_comm_msg.msg_head.get().msg_time.set((int) messageForStructing.time);
                String str2 = messageForStructing.senderuin;
                if (str2 != null && (str = messageForStructing.frienduin) != null && messageForStructing.selfuin != null) {
                    if (str2.equals(str)) {
                        msg_comm_msg.msg_head.get().from_uin.set(Long.parseLong(messageForStructing.senderuin));
                        msg_comm_msg.msg_head.get().to_uin.set(Long.parseLong(messageForStructing.selfuin));
                    } else {
                        msg_comm_msg.msg_head.get().from_uin.set(Long.parseLong(messageForStructing.senderuin));
                        msg_comm_msg.msg_head.get().to_uin.set(Long.parseLong(messageForStructing.frienduin));
                    }
                }
                if (messageForStructing.istroop == 1) {
                    msg_comm_msg.msg_head.get().c2c_tmp_msg_head.set(new msg_comm$C2CTmpMsgHead());
                    msg_comm_msg.msg_head.get().c2c_tmp_msg_head.get().service_type.set(1);
                    if (messageForStructing.frienduin != null) {
                        msg_comm_msg.msg_head.get().c2c_tmp_msg_head.get().group_code.set(Long.parseLong(messageForStructing.frienduin));
                    }
                }
                msg_comm_msg.msg_head.get().msg_seq.set((short) messageForStructing.msgseq);
                final im_msg_body$NotOnlineFile im_msg_body_notonlinefile = new im_msg_body$NotOnlineFile();
                im_msg_body_notonlinefile.uint32_file_type.set(0);
                im_msg_body_notonlinefile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(messageForStructing.structingMsg.mMsgUrl));
                im_msg_body_notonlinefile.uint64_file_size.set(0L);
                im_msg_body_notonlinefile.uint32_subcmd.set(1);
                AbsStructMsg absStructMsg2 = messageForStructing.structingMsg;
                if (absStructMsg2 instanceof StructMsgForGeneralShare) {
                    StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) absStructMsg2;
                    if (TextUtils.isEmpty(structMsgForGeneralShare.mContentCover)) {
                        structMsgForGeneralShare.mContentCover = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTDDocFileThumbUrl(structMsgForGeneralShare.mMsgUrl);
                    }
                    if (!TextUtils.isEmpty(structMsgForGeneralShare.mContentTitle)) {
                        im_msg_body_notonlinefile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(structMsgForGeneralShare.mContentTitle));
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(AppConstants.Key.STRUCT_MSG_SERVICE_ID, structMsgForGeneralShare.mMsgServiceID);
                        jSONObject.put(AppConstants.Key.STRUCT_MSG_BYTES, Base64.encodeToString(structMsgForGeneralShare.getBytes(), 0));
                        jSONObject.put(AppConstants.Key.STRUCT_MSG_UNISEQ, messageRecord.uniseq);
                        jSONObject.put("accostType", structMsgForGeneralShare.sourceAccoutType);
                    } catch (JSONException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(com.tencent.mobileqq.teamwork.t.f292405j, 2, e16.getMessage());
                        }
                    }
                    im_msg_body_notonlinefile.bytes_note.set(ByteStringMicro.copyFromUtf8(structMsgForGeneralShare.mContentCover));
                    im_msg_body_notonlinefile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(jSONObject.toString().getBytes()));
                }
                FileManagerProxy fileManagerProxy = qQAppInterface.getFileManagerProxy();
                if (fileManagerProxy != null) {
                    for (FileManagerEntity fileManagerEntity : new ArrayList(fileManagerProxy.t())) {
                        String str3 = fileManagerEntity.Uuid;
                        if (str3 != null && str3.equalsIgnoreCase(messageForStructing.structingMsg.mMsgUrl)) {
                            fileManagerEntity.srvTime = messageForStructing.time * 1000;
                            fileManagerEntity.bDelInFM = false;
                            qQAppInterface.getFileManagerDataCenter().f0(fileManagerEntity);
                            return;
                        }
                    }
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsTempImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FileTransferHandler fileTransferHandler = qQAppInterface.getFileTransferHandler();
                        MessageHandler msgHandler = qQAppInterface.getMsgHandler();
                        ArrayList arrayList = new ArrayList();
                        msg_comm$Msg msg_comm_msg2 = msg_comm_msg;
                        im_msg_body$NotOnlineFile im_msg_body_notonlinefile2 = im_msg_body_notonlinefile;
                        MessageForStructing messageForStructing2 = messageForStructing;
                        fileTransferHandler.V(msgHandler, arrayList, msg_comm_msg2, im_msg_body_notonlinefile2, messageForStructing2.frienduin, false, false, messageForStructing2.vipBubbleID, messageForStructing2.vipBubbleDiyTextId, null);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void addTeamWorkGrayTips(AppInterface appInterface, String str, int i3, long j3, long j16, String str2, String str3) {
        MessageForUniteGrayTip messageForUniteGrayTip;
        com.tencent.mobileqq.graytip.g gVar;
        int i16;
        int i17;
        int O;
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            DocsGrayTipsInfo paseDocsGrayTipsInfoFromJson = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).paseDocsGrayTipsInfoFromJson(str2, str, str3);
            if (paseDocsGrayTipsInfoFromJson != null) {
                QLog.i(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "addTeamWorkGrayTips. docsGrayTipsInfo = " + paseDocsGrayTipsInfoFromJson.toString());
                ta1.p pVar = new ta1.p();
                if (!TextUtils.isEmpty(paseDocsGrayTipsInfoFromJson.f291466f) && Integer.valueOf(paseDocsGrayTipsInfoFromJson.f291466f).intValue() == 1) {
                    if (i3 == 1) {
                        int b16 = pVar.b();
                        QLog.i(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "addTeamWorkGrayTips. groupFlag = " + b16);
                        if (b16 == 0) {
                            return;
                        }
                        int N = ea.N(appInterface.getApp(), appInterface.getCurrentAccountUin()) + 1;
                        int c16 = pVar.c();
                        QLog.i(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "addTeamWorkGrayTips. groupShowedCount = " + N + ", groupShowCount = " + c16);
                        if (N > c16) {
                            return;
                        } else {
                            ea.F2(appInterface.getApp(), appInterface.getCurrentAccountUin(), N);
                        }
                    } else {
                        if (pVar.a() == 0 || (O = ea.O(appInterface.getApp(), appInterface.getCurrentAccountUin()) + 1) > pVar.d()) {
                            return;
                        }
                        ea.G2(appInterface.getApp(), appInterface.getCurrentAccountUin(), O);
                        QLog.d(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 2, "yunying gray tip showed count = " + O);
                    }
                }
                MessageForUniteGrayTip messageForUniteGrayTip2 = new MessageForUniteGrayTip();
                if (i3 == 1) {
                    messageForUniteGrayTip = messageForUniteGrayTip2;
                    com.tencent.mobileqq.graytip.g gVar2 = new com.tencent.mobileqq.graytip.g(str, appInterface.getCurrentAccountUin(), paseDocsGrayTipsInfoFromJson.f291468i, 1, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 3276802, j16);
                    messageForUniteGrayTip.shmsgseq = j3 + 1;
                    gVar = gVar2;
                } else {
                    messageForUniteGrayTip = messageForUniteGrayTip2;
                    gVar = new com.tencent.mobileqq.graytip.g(str, appInterface.getCurrentAccountUin(), paseDocsGrayTipsInfoFromJson.f291468i, 0, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 3276802, j16);
                }
                Bundle bundle = new Bundle();
                bundle.putInt("key_action", 33);
                bundle.putString("textColor", "#40A0FF");
                bundle.putString("key_action_DATA", str2 + "@#@" + String.valueOf(messageForUniteGrayTip.uniseq));
                bundle.putString("key_a_action_DATA", str3);
                bundle.putString("troop_mem_uin", str);
                int[] a16 = paseDocsGrayTipsInfoFromJson.a();
                gVar.b(a16[0], a16[1], bundle);
                QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
                messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
                com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip);
                if ("1".equals(paseDocsGrayTipsInfoFromJson.f291467h)) {
                    if (i3 == 1) {
                        i17 = 1;
                    } else {
                        i17 = 0;
                    }
                    ReportController.o(null, "CliOper", "", "", "0X80095F2", "0X80095F2", i17, 0, "", "", "", "");
                } else if ("2".equals(paseDocsGrayTipsInfoFromJson.f291467h)) {
                    if (i3 == 1) {
                        i16 = 1;
                    } else {
                        i16 = 0;
                    }
                    ReportController.o(null, "CliOper", "", "", "0X80095F1", "0X80095F1", i16, 0, "", "", "", "");
                }
                if (paseDocsGrayTipsInfoFromJson.P.equals(com.tencent.mobileqq.teamwork.t.f292407l)) {
                    ReportController.o(appInterface, "dc00898", "", "", "0X8009C78", "0X8009C78", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            QLog.e(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "addTeamWorkGrayTips. docsGrayTipsInfo is null.");
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void configHistoryTabEmptyTips(TextView textView, View.OnClickListener onClickListener) {
        if (textView == null) {
            return;
        }
        ta1.c cVar = new ta1.c();
        String b16 = cVar.b();
        String a16 = cVar.a();
        if (TextUtils.isEmpty(a16)) {
            textView.setText(b16);
            return;
        }
        int indexOf = b16.indexOf(a16);
        if (indexOf < 0) {
            textView.setText(cVar.b());
            return;
        }
        int length = a16.length() + indexOf;
        if (length > b16.length()) {
            length = b16.length();
        }
        int parseColor = Color.parseColor("#4D94FF");
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{Color.parseColor("#804D94FF"), parseColor});
        SpannableString spannableString = new SpannableString(b16);
        spannableString.setSpan(new DatingCommentTextView.a(onClickListener, colorStateList), indexOf, length, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        textView.setFocusable(false);
        textView.setClickable(false);
        textView.setLongClickable(false);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public List<ChatMessage> createChatMsgListFromTencentDocs(List<TencentDocData> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (com.tencent.mobileqq.teamwork.b.e(list)) {
            for (TencentDocData tencentDocData : list) {
                MessageForStructing messageForStructing = new MessageForStructing();
                messageForStructing.structingMsg = new StructMsgForGeneralShare();
                messageForStructing.senderuin = String.valueOf(tencentDocData.sendUin);
                messageForStructing.selfuin = str;
                messageForStructing.frienduin = str2;
                messageForStructing.issend = 1;
                messageForStructing.msgtype = MessageRecord.MSG_TYPE_STRUCT_MSG;
                messageForStructing.time = tencentDocData.aioTime;
                AbsStructMsg absStructMsg = messageForStructing.structingMsg;
                ((StructMsgForGeneralShare) absStructMsg).mMsgAction = tencentDocData.action;
                ((StructMsgForGeneralShare) absStructMsg).mSourceAction = tencentDocData.sourceAction;
                ((StructMsgForGeneralShare) absStructMsg).mMsgServiceID = tencentDocData.serviceId;
                ((StructMsgForGeneralShare) absStructMsg).mContentCover = tencentDocData.docIcon;
                ((StructMsgForGeneralShare) absStructMsg).mContentSummary = tencentDocData.summary;
                ((StructMsgForGeneralShare) absStructMsg).mContentTitle = tencentDocData.getTitle();
                AbsStructMsg absStructMsg2 = messageForStructing.structingMsg;
                ((StructMsgForGeneralShare) absStructMsg2).mSourceIcon = tencentDocData.icon;
                ((StructMsgForGeneralShare) absStructMsg2).mSourceName = tencentDocData.sourceName;
                ((StructMsgForGeneralShare) absStructMsg2).mMsgBrief = tencentDocData.getBriefDes(BaseApplication.getContext());
                AbsStructMsg absStructMsg3 = messageForStructing.structingMsg;
                ((StructMsgForGeneralShare) absStructMsg3).mSourceUrl = tencentDocData.url;
                ((StructMsgForGeneralShare) absStructMsg3).mSourceAppid = tencentDocData.appid;
                ((StructMsgForGeneralShare) absStructMsg3).mMsgUrl = tencentDocData.docUrl;
                com.tencent.mobileqq.structmsg.view.u uVar = new com.tencent.mobileqq.structmsg.view.u();
                uVar.C(0);
                com.tencent.mobileqq.structmsg.view.c cVar = new com.tencent.mobileqq.structmsg.view.c(((StructMsgForGeneralShare) messageForStructing.structingMsg).mContentCover);
                cVar.W0 = com.tencent.mobileqq.structmsg.view.c.Y0;
                uVar.m(cVar);
                uVar.m(new StructMsgItemTitle(((StructMsgForGeneralShare) messageForStructing.structingMsg).mContentTitle));
                uVar.m(new com.tencent.mobileqq.structmsg.view.ap(((StructMsgForGeneralShare) messageForStructing.structingMsg).mContentSummary));
                ((StructMsgForGeneralShare) messageForStructing.structingMsg).mStructMsgItemLists.add(uVar);
                arrayList.add(messageForStructing);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void forwardTencentDoc(Activity activity, FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity != null && fileManagerEntity.bombData != null) {
            try {
                Intent intent = new Intent();
                intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
                com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
                aVar.o(new String(fileManagerEntity.bombData));
                Bundle a16 = QQCustomArkDialog.b.a(aVar.d(), aVar.e(), aVar.f(), aVar.c(), aVar.m(), com.tencent.mobileqq.ark.f.c(), null, null);
                a16.putString("forward_ark_app_name", aVar.d());
                a16.putString("forward_ark_app_view", aVar.e());
                a16.putString("forward_ark_biz_src", aVar.f());
                a16.putString(AppConstants.Key.FORWARD_ARK_APP_DESC, aVar.a());
                a16.putString("forward_ark_app_ver", aVar.c());
                a16.putString("forward_ark_app_meta", aVar.m());
                a16.putString("forward_ark_app_prompt", aVar.n());
                a16.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, aVar.g());
                intent.putExtra("forward_type", 27);
                intent.putExtra("is_ark_display_share", true);
                intent.putExtras(a16);
                ForwardBaseOption.startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentActivity.class, 21, -1, "");
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "forwardRecentFileRecord. tencentDoc ark msg forward exception: " + e16);
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("forward_type", -1);
                    bundle.putString(AppConstants.Key.FORWARD_TEXT, String.format("\u3010\u817e\u8baf\u6587\u6863\u3011\u9080\u8bf7\u4f60\u4e00\u8d77\u67e5\u770b\u6587\u6863\u300a%s\u300b\n%s", fileManagerEntity.fileName, fileManagerEntity.Uuid));
                    Intent intent2 = new Intent();
                    intent2.putExtras(bundle);
                    intent2.putExtra("isFromShare", true);
                    RouteUtils.startActivityForResult(activity, intent2, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
                    return;
                } catch (Exception e17) {
                    QLog.e(TAG, 1, "forwardRecentFileRecord. tencentDoc text msg forward exception: " + e17);
                    return;
                }
            }
        }
        QLog.i(TAG, 1, "forwardRecentFileRecord. tencentDoc data is null");
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public String getTroopFormGrayParameter(AppInterface appInterface, String str, int i3) {
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (i3 == 1) {
                return "groupid=" + str + "&groupname=" + com.tencent.mobileqq.imcore.proxy.utils.a.b(qQAppInterface, str, false) + "&uinType=" + i3;
            }
            if (i3 == 0) {
                return "groupid=" + str + "&groupname=" + com.tencent.mobileqq.utils.ac.H(qQAppInterface, str) + "&uinType=" + i3;
            }
            return "";
        }
        return null;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void insertTroopFormGrayTips(AppInterface appInterface, MessageMicro messageMicro, final String str) {
        final int indexOf;
        if (appInterface == null || !(appInterface instanceof QQAppInterface)) {
            return;
        }
        final QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        if (messageMicro != null && (messageMicro instanceof TroopTips0x857$TroopFormGrayTipsInfo)) {
            TroopTips0x857$TroopFormGrayTipsInfo troopTips0x857$TroopFormGrayTipsInfo = (TroopTips0x857$TroopFormGrayTipsInfo) messageMicro;
            QLog.i(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "troopFormLog insertTroopFormGrayTips troop = " + troopTips0x857$TroopFormGrayTipsInfo.toString());
            final String string = appInterface.getApp().getString(com.tencent.mobileqq.R.string.i6p);
            final String stringUtf8 = troopTips0x857$TroopFormGrayTipsInfo.bytes_opt_bytes_url.get().toStringUtf8();
            String str2 = troopTips0x857$TroopFormGrayTipsInfo.uint64_writer_uin.get() + "";
            String str3 = troopTips0x857$TroopFormGrayTipsInfo.uint64_creator_uin.get() + "";
            String stringUtf82 = troopTips0x857$TroopFormGrayTipsInfo.bytes_rich_content.get().toStringUtf8();
            QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips url = " + stringUtf8);
            QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips writerUin = " + str2);
            QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips creatorUin = " + str3);
            QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips context = " + stringUtf82);
            QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips creator_nick = " + troopTips0x857$TroopFormGrayTipsInfo.bytes_creator_nick.get().toStringUtf8());
            String currentUin = appInterface.getCurrentUin();
            if (TextUtils.isEmpty(stringUtf82) || TextUtils.isEmpty(currentUin)) {
                return;
            }
            if (currentUin.equals(str2) || currentUin.equals(str3)) {
                final String troopFormGrayContent = getTroopFormGrayContent(qQAppInterface, stringUtf82, str);
                QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips tips = " + troopFormGrayContent);
                QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips troopUin = " + str);
                if (TextUtils.isEmpty(troopFormGrayContent) || (indexOf = troopFormGrayContent.indexOf(string)) == -1) {
                    return;
                }
                new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsTempImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(10);
                        String str4 = str;
                        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str4, str4, troopFormGrayContent, 1, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 3276804, com.tencent.mobileqq.service.message.e.K0());
                        Bundle bundle = new Bundle();
                        bundle.putInt("key_action", 42);
                        bundle.putString("key_action_DATA", TeamWorkUtilsTempImpl.this.getTroopFormGrayParameter(qQAppInterface, str, 1));
                        bundle.putString("key_a_action_DATA", stringUtf8);
                        int i3 = indexOf;
                        gVar.b(i3, string.length() + i3, bundle);
                        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
                        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
                        com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip);
                        ReportController.o(qQAppInterface, "dc00898", "", str, "0X8009FD0", "0X8009FD0", 0, 0, "", "", "", "");
                    }
                }).start();
                return;
            }
            return;
        }
        QLog.e(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "troopFormLog insertTroopFormGrayTips Info is null.");
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public boolean isTencentDocsAssistantEnable(AppInterface appInterface) {
        ITeamWorkHandler iTeamWorkHandler = (ITeamWorkHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER);
        if (iTeamWorkHandler != null) {
            return iTeamWorkHandler.getEnableTencentDocsAssistant();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void onGetGroupAuthDocsGrayTipsInfo(AppInterface appInterface, Context context, MqqHandler mqqHandler, boolean z16, Object[] objArr) {
        MessageRecord P;
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            try {
                DocsGrayTipsInfo docsGrayTipsInfo = (DocsGrayTipsInfo) objArr[0];
                String str = (String) objArr[1];
                long longValue = ((Long) objArr[2]).longValue();
                if (appInterface.getApp().getString(com.tencent.mobileqq.R.string.hyn).equals(str)) {
                    QQMessageFacade messageFacade = ((QQAppInterface) appInterface).getMessageFacade();
                    if (messageFacade != null && (P = messageFacade.P(docsGrayTipsInfo.f291464d, 1, longValue)) != null && (P instanceof MessageForUniteGrayTip)) {
                        MessageForUniteGrayTip messageForUniteGrayTip = (MessageForUniteGrayTip) P;
                        com.tencent.mobileqq.graytip.g gVar = messageForUniteGrayTip.tipParam;
                        if (gVar != null) {
                            gVar.d();
                        }
                        messageForUniteGrayTip.updateUniteGrayTipMsg((QQAppInterface) appInterface, str);
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putLong("messageUniseq", P.uniseq);
                        message.setData(bundle);
                        message.what = 80;
                        message.arg1 = 0;
                        mqqHandler.sendMessage(message);
                    }
                } else {
                    QQToast.makeText(context, str, 0).show();
                }
                QLog.i(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " onGetGroupAuth  isSuccess = " + z16 + " tips =" + str);
            } catch (Exception e16) {
                QLog.e(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " onGetGroupAuth  exception = " + e16.toString());
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void onGetUserAuthDocsGrayTipsInfo(AppInterface appInterface, Context context, MqqHandler mqqHandler, boolean z16, Object[] objArr) {
        MessageRecord P;
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            try {
                DocsGrayTipsInfo docsGrayTipsInfo = (DocsGrayTipsInfo) objArr[0];
                String str = (String) objArr[1];
                long longValue = ((Long) objArr[2]).longValue();
                if (appInterface.getApp().getString(com.tencent.mobileqq.R.string.hyn).equals(str)) {
                    QQMessageFacade messageFacade = ((QQAppInterface) appInterface).getMessageFacade();
                    if (messageFacade != null && (P = messageFacade.P(docsGrayTipsInfo.f291464d, 0, longValue)) != null && (P instanceof MessageForUniteGrayTip)) {
                        MessageForUniteGrayTip messageForUniteGrayTip = (MessageForUniteGrayTip) P;
                        com.tencent.mobileqq.graytip.g gVar = messageForUniteGrayTip.tipParam;
                        if (gVar != null) {
                            gVar.d();
                        }
                        messageForUniteGrayTip.updateUniteGrayTipMsg((QQAppInterface) appInterface, str);
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putLong("messageUniseq", P.uniseq);
                        message.setData(bundle);
                        message.what = 80;
                        message.arg1 = 0;
                        mqqHandler.sendMessage(message);
                    }
                } else {
                    QQToast.makeText(context, str, 0).show();
                }
                QLog.i(com.tencent.mobileqq.teamwork.t.f292405j, 2, " onGetUserAuth  isSuccess = " + z16 + " tips =" + str);
            } catch (Exception e16) {
                QLog.e(com.tencent.mobileqq.teamwork.t.f292405j, 2, " onGetUserAuth  exception = " + e16.toString());
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void onSetGroupAuthDocsGrayTipsInfo(AppInterface appInterface, Context context, MqqHandler mqqHandler, boolean z16, Object[] objArr) {
        MessageRecord P;
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            try {
                QLog.i(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " onSetGroupAuth  isSuccess = " + z16);
                DocsGrayTipsInfo docsGrayTipsInfo = (DocsGrayTipsInfo) objArr[0];
                String str = (String) objArr[1];
                long longValue = ((Long) objArr[2]).longValue();
                if (z16) {
                    QQMessageFacade messageFacade = ((QQAppInterface) appInterface).getMessageFacade();
                    if (messageFacade != null && (P = messageFacade.P(docsGrayTipsInfo.f291464d, 1, longValue)) != null && (P instanceof MessageForUniteGrayTip)) {
                        MessageForUniteGrayTip messageForUniteGrayTip = (MessageForUniteGrayTip) P;
                        com.tencent.mobileqq.graytip.g gVar = messageForUniteGrayTip.tipParam;
                        if (gVar != null) {
                            gVar.d();
                        }
                        messageForUniteGrayTip.updateUniteGrayTipMsg((QQAppInterface) appInterface, str);
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putLong("messageUniseq", P.uniseq);
                        message.setData(bundle);
                        message.what = 80;
                        message.arg1 = 0;
                        mqqHandler.sendMessage(message);
                        return;
                    }
                    return;
                }
                QQToast.makeText(context, str, 0).show();
            } catch (Exception e16) {
                QLog.e(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " onSetGroupAuth  exception  = " + e16.toString());
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void onSetUserAuthDocsGrayTipsInfo(AppInterface appInterface, Context context, MqqHandler mqqHandler, boolean z16, Object[] objArr) {
        MessageRecord P;
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            try {
                QLog.i(com.tencent.mobileqq.teamwork.t.f292405j, 2, " onSetUserAuth  isSuccess = " + z16);
                DocsGrayTipsInfo docsGrayTipsInfo = (DocsGrayTipsInfo) objArr[0];
                String str = (String) objArr[1];
                long longValue = ((Long) objArr[2]).longValue();
                if (z16) {
                    QQMessageFacade messageFacade = ((QQAppInterface) appInterface).getMessageFacade();
                    if (messageFacade != null && (P = messageFacade.P(docsGrayTipsInfo.f291464d, 0, longValue)) != null && (P instanceof MessageForUniteGrayTip)) {
                        MessageForUniteGrayTip messageForUniteGrayTip = (MessageForUniteGrayTip) P;
                        com.tencent.mobileqq.graytip.g gVar = messageForUniteGrayTip.tipParam;
                        if (gVar != null) {
                            gVar.d();
                        }
                        messageForUniteGrayTip.updateUniteGrayTipMsg((QQAppInterface) appInterface, str);
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putLong("messageUniseq", P.uniseq);
                        message.setData(bundle);
                        message.what = 80;
                        message.arg1 = 0;
                        mqqHandler.sendMessage(message);
                        return;
                    }
                    return;
                }
                QQToast.makeText(context, str, 0).show();
            } catch (Exception e16) {
                QLog.e(com.tencent.mobileqq.teamwork.t.f292405j, 1, " onSetUserAuth  exception  = " + e16.toString());
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void openTroopTemplatePreviewUrlWithCheck(AppInterface appInterface, Activity activity, int i3, String str, long j3, long j16, long j17) {
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            String i16 = QFileUtils.i((QQAppInterface) appInterface, j3);
            if (!TextUtils.isEmpty(i16)) {
                QQToast.makeText(activity, i16, 0).show();
            } else {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).openGroupPadTemplateListUrl(appInterface, activity, i3, str, j3, j16);
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void processTDDocFileUrl(String str) {
        processTDDocFileUrl(str, null);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void sendDocCooperationShare(AppInterface appInterface, Activity activity, TencentDocData tencentDocData, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        boolean z16;
        boolean z17;
        String qqStr;
        Class<?> cls;
        if (appInterface != null && (appInterface instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            ta1.l c16 = TencentDocLocalCooperationProcessor.c();
            if (c16 != null) {
                z16 = c16.b(teamWorkFileImportInfo.f292074f);
            } else {
                z16 = false;
            }
            int i3 = teamWorkFileImportInfo.f292070d;
            if ((i3 == 1 || i3 == 0 || i3 == 3000) && TextUtils.isEmpty(teamWorkFileImportInfo.f292071d0)) {
                z17 = true;
            } else {
                z17 = false;
            }
            Intent intent = new Intent();
            intent.putExtra("key_flag_from_plugin", true);
            intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHOW_DIRECT_SHARE_TIPS, true);
            intent.putExtra("forward_type", 1001);
            intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 95);
            intent.putExtra("pluginName", "web_share");
            intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, tencentDocData.docIcon);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(appInterface.getCurrentNickname());
            sb5.append(HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.u0u));
            if (z16) {
                qqStr = HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.u0l);
            } else {
                qqStr = HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.u0y);
            }
            sb5.append(qqStr);
            sb5.append("\u300a");
            sb5.append(tencentDocData.title);
            sb5.append("\u300b");
            String sb6 = sb5.toString();
            if (sb6 != null && sb6.length() > 45) {
                sb6 = sb6.substring(0, 45) + "\u2026";
            }
            intent.putExtra("title", sb6);
            String str = tencentDocData.summary;
            if (str != null && str.length() > 60) {
                str = str.substring(0, 60) + "\u2026";
            }
            intent.putExtra("desc", str);
            intent.putExtra("detail_url", tencentDocData.docUrl);
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION, "web");
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "web");
            intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, ITeamWorkUtils.DOCS_SOURCE_ICON_URL);
            intent.putExtra("app_name", activity.getString(com.tencent.mobileqq.R.string.hz5));
            intent.putExtra(AppConstants.Key.SHARE_SOURCE_URL, ITeamWorkUtils.DOCS_LIST_URL);
            intent.putExtra("forward _key_nojump", true);
            AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(intent.getExtras());
            if (e16 != null) {
                intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e16.getBytes());
                if (z17) {
                    intent.putExtra("uintype", teamWorkFileImportInfo.f292070d);
                    intent.putExtra("uin", teamWorkFileImportInfo.f292072e);
                    intent.putExtra("troop_uin", teamWorkFileImportInfo.f292072e);
                    intent.putExtra("uinname", com.tencent.mobileqq.utils.ac.Q(qQAppInterface, teamWorkFileImportInfo.f292072e, teamWorkFileImportInfo.f292070d));
                }
                StringBuilder sb7 = new StringBuilder(HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tzv));
                int i16 = teamWorkFileImportInfo.f292070d;
                if (i16 != 1 && i16 != 3000) {
                    if (i16 == 0) {
                        sb7.append("\u597d\u53cb");
                    }
                } else {
                    sb7.append("\u7fa4\u6210\u5458");
                }
                if (z16) {
                    sb7.append("\u4e00\u8d77\u7f16\u8f91\u6587\u6863\uff1a");
                } else {
                    sb7.append("\u4e00\u8d77\u67e5\u770b\u6587\u6863\uff1a");
                }
                intent.putExtra(AppConstants.Key.KEY_SEND_TIPS, sb7.toString());
                if (!z17) {
                    lr2.a.j(null, "0X800A5A1");
                } else {
                    lr2.a.j(null, "0X800A5A2");
                }
                if (z17) {
                    cls = DirectForwardActivity.class;
                } else {
                    cls = ForwardRecentActivity.class;
                }
                intent.setClass(activity, cls);
                activity.startActivityForResult(intent, 2864);
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void sendTDoc2Chat(AppInterface appInterface, FileManagerEntity fileManagerEntity, String str, String str2, int i3) {
        String str3;
        int i16;
        if (!(appInterface instanceof QQAppInterface)) {
            QLog.e(TAG, 2, "app is not QQAppInterface, return");
            return;
        }
        String str4 = fileManagerEntity.fileName;
        if (str4 != null && str4.length() > 45) {
            str4 = str4.substring(0, 45) + "\u2026";
        }
        if (i3 == 0) {
            str3 = str2;
            i16 = 1;
        } else if (i3 == 1) {
            str3 = str;
            i16 = 2;
        } else if (i3 == 6000) {
            i16 = 8;
            str3 = str2;
        } else {
            str3 = str;
            i16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "send tencent doc to chat, recvUin: " + str + ", recvUid: " + str2 + ", peerType: " + i3);
        }
        String format = String.format("\u3010\u817e\u8baf\u6587\u6863\u3011\u9080\u8bf7\u4f60\u4e00\u8d77\u67e5\u770b\u6587\u6863\u300a%s\u300b\n%s", str4, fileManagerEntity.Uuid);
        if (fileManagerEntity.bombData != null && i3 != 6000) {
            try {
                com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
                aVar.o(new String(fileManagerEntity.bombData));
                ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).sendArk(str3, i16, aVar);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "send ark exception: " + e16);
                }
                ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).sendText(str3, i16, format);
                return;
            }
        }
        ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).sendText(str3, i16, format);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void setTencentDocsAssitantEnable(AppInterface appInterface, boolean z16) {
        ea.D2(appInterface.getApp(), appInterface.getCurrentUin(), AppConstants.Preferences.TENCENT_DOCS_CONFIG_ENABLE_ASSISTANT, z16);
        ITeamWorkHandler iTeamWorkHandler = (ITeamWorkHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER);
        if (iTeamWorkHandler != null) {
            iTeamWorkHandler.setEnableTencentDocsAssistant(z16);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void tryAddTDFileMessageRecord(AppInterface appInterface, MessageRecord messageRecord) {
        ProcessTDFileScheduler b16 = ProcessTDFileScheduler.b(appInterface);
        b16.d(messageRecord);
        b16.c();
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void tryProcessTDDocMessageRecord(MessageRecord messageRecord, final AppInterface appInterface) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (messageRecord != null && appInterface != null) {
            if (messageRecord instanceof MessageForStructing) {
                final MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
                AbsStructMsg absStructMsg = messageForStructing.structingMsg;
                if (absStructMsg != null && !TextUtils.isEmpty(absStructMsg.mMsgUrl) && com.tencent.mobileqq.filemanager.data.e.g(messageForStructing.structingMsg.mMsgUrl)) {
                    AbsStructMsg absStructMsg2 = messageForStructing.structingMsg;
                    if (absStructMsg2 instanceof StructMsgForGeneralShare) {
                        final StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) absStructMsg2;
                        TeamWorkHandlerUtils.l(structMsgForGeneralShare.mMsgUrl, messageForStructing.selfuin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.ar
                            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                            public final void a(Object obj) {
                                TeamWorkUtilsTempImpl.this.lambda$tryProcessTDDocMessageRecord$1(structMsgForGeneralShare, messageForStructing, appInterface, obj);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            if (messageRecord instanceof MessageForArkApp) {
                MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
                String str = messageForArkApp.ark_app_message.metaList;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    if ("com.tencent.miniapp_01".equals(messageForArkApp.ark_app_message.appName)) {
                        if (jSONObject2.has("detail_1") && (optJSONObject2 = jSONObject2.optJSONObject("detail_1")) != null) {
                            String optString = optJSONObject2.optString("qqdocurl");
                            if (!TextUtils.isEmpty(optString) && com.tencent.mobileqq.filemanager.data.e.g(optString)) {
                                processTDDocFileUrl(optString.split("&url=")[0], messageForArkApp);
                            }
                        }
                    } else if ("com.tencent.miniapp".equals(messageForArkApp.ark_app_message.appName)) {
                        if (jSONObject2.has("detail") && (optJSONObject = jSONObject2.optJSONObject("detail")) != null) {
                            String optString2 = optJSONObject.optString("qqdocurl");
                            if (!TextUtils.isEmpty(optString2) && com.tencent.mobileqq.filemanager.data.e.g(optString2)) {
                                processTDDocFileUrl(optString2.split("&url=")[0], messageForArkApp);
                            }
                        }
                    } else if ("com.tencent.structmsg".equals(messageForArkApp.ark_app_message.appName) && jSONObject2.has("news") && (jSONObject = jSONObject2.getJSONObject("news")) != null) {
                        String optString3 = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
                        if (!TextUtils.isEmpty(optString3) && com.tencent.mobileqq.filemanager.data.e.g(optString3)) {
                            processTDDocFileUrl(optString3, messageForArkApp);
                        }
                    }
                    return;
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(com.tencent.mobileqq.teamwork.t.f292405j, 2, e16.getMessage());
                        return;
                    }
                    return;
                }
            }
            if (messageRecord instanceof MessageForText) {
                ChatMessage chatMessage = (MessageForText) messageRecord;
                if (com.tencent.mobileqq.filemanager.data.e.g(chatMessage.f203106msg)) {
                    processTDDocFileUrl(chatMessage.f203106msg, chatMessage);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void processTDDocFileUrl(final String str, final ChatMessage chatMessage) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final String[] strArr = {null};
        final String[] strArr2 = {null};
        if (chatMessage != null) {
            strArr[0] = chatMessage.senderuin;
            strArr2[0] = chatMessage.frienduin;
        }
        final QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
        final String uin = getUin();
        if (uin != null) {
            TeamWorkHandlerUtils.l(str, uin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.aq
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    TeamWorkUtilsTempImpl.this.lambda$processTDDocFileUrl$0(str, strArr, uin, strArr2, chatMessage, qQAppInterface, obj);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
    public void insertTroopFormGrayTips(final AppInterface appInterface, MessageMicro messageMicro) {
        final int indexOf;
        if (appInterface == null || !(appInterface instanceof QQAppInterface)) {
            return;
        }
        final QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        if (messageMicro != null && (messageMicro instanceof SubMsgType0x119$MsgBody)) {
            SubMsgType0x119$MsgBody subMsgType0x119$MsgBody = (SubMsgType0x119$MsgBody) messageMicro;
            QLog.i(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "troopFormLog insertTroopFormGrayTips c2c = " + subMsgType0x119$MsgBody.toString());
            final String string = appInterface.getApp().getString(com.tencent.mobileqq.R.string.i6p);
            final String stringUtf8 = subMsgType0x119$MsgBody.bytes_opt_bytes_url.get().toStringUtf8();
            final String str = subMsgType0x119$MsgBody.uint64_writer_uin.get() + "";
            final String str2 = subMsgType0x119$MsgBody.uint64_creator_uin.get() + "";
            String stringUtf82 = subMsgType0x119$MsgBody.bytes_rich_content.get().toStringUtf8();
            QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips url = " + stringUtf8);
            QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips writerUin = " + str);
            QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips creatorUin = " + str2);
            QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips context = " + stringUtf82);
            QLog.i(TAG, 1, "troopFormLog insertTroopFormGrayTips creator_nick = " + subMsgType0x119$MsgBody.bytes_creator_nick.get().toStringUtf8());
            final String currentUin = appInterface.getCurrentUin();
            if (TextUtils.isEmpty(stringUtf82) || TextUtils.isEmpty(currentUin)) {
                return;
            }
            if (currentUin.equals(str) || currentUin.equals(str2)) {
                final String troopFormGrayContent = getTroopFormGrayContent(qQAppInterface, stringUtf82, "");
                if (TextUtils.isEmpty(troopFormGrayContent) || (indexOf = troopFormGrayContent.indexOf(string)) == -1) {
                    return;
                }
                new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsTempImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        String str3;
                        String str4;
                        String str5;
                        Process.setThreadPriority(10);
                        if (currentUin.equals(str)) {
                            str3 = str2;
                        } else {
                            str3 = str;
                        }
                        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str3, appInterface.getCurrentUin(), troopFormGrayContent, 0, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 3276804, com.tencent.mobileqq.service.message.e.K0());
                        Bundle bundle = new Bundle();
                        bundle.putInt("key_action", 42);
                        bundle.putString("key_a_action_DATA", stringUtf8);
                        TeamWorkUtilsTempImpl teamWorkUtilsTempImpl = TeamWorkUtilsTempImpl.this;
                        QQAppInterface qQAppInterface2 = qQAppInterface;
                        if (currentUin.equals(str)) {
                            str4 = str2;
                        } else {
                            str4 = str;
                        }
                        bundle.putString("key_action_DATA", teamWorkUtilsTempImpl.getTroopFormGrayParameter(qQAppInterface2, str4, 0));
                        int i3 = indexOf;
                        gVar.b(i3, string.length() + i3, bundle);
                        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
                        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
                        com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip);
                        QQAppInterface qQAppInterface3 = qQAppInterface;
                        if (currentUin.equals(str)) {
                            str5 = str2;
                        } else {
                            str5 = str;
                        }
                        ReportController.o(qQAppInterface3, "dc00898", "", str5, "0X8009FD0", "0X8009FD0", 0, 0, "", "", "", "");
                    }
                }).start();
                return;
            }
            return;
        }
        QLog.e(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, "troopFormLog insertTroopFormGrayTipsInfo is null.");
    }
}
