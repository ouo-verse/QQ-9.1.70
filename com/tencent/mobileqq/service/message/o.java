package com.tencent.mobileqq.service.message;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.tencent.ark.open.ArkUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb$ResvAttr;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.ah;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ax;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAioGift;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.guild.temp.api.IGuildFileTempApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletGdtAdApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.ae;
import com.tencent.mobileqq.troop.utils.bf;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.zplan.model.ZPlanHeadEffectFlag;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;
import localpb.richMsg.RichMsg$PicRec;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg$ActivityGiftInfo;
import tencent.im.msg.hummer.resv.ResvAttrForGiftMsg$ResvAttr;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.hummer.resv.source_msg$CommentRefer;
import tencent.im.msg.hummer.resv.source_msg$ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb$ResvAttr;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb$ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb$ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype13;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype14;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype16;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype19;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype20;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype23;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype3;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype33;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype8;
import tencent.im.msg.im_msg_body$ArkAppElem;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$DeliverGiftMsg;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$GroupPubAccountInfo;
import tencent.im.msg.im_msg_body$LightAppElem;
import tencent.im.msg.im_msg_body$MarketFace;
import tencent.im.msg.im_msg_body$MarketTrans;
import tencent.im.msg.im_msg_body$NotOnlineImage;
import tencent.im.msg.im_msg_body$RichMsg;
import tencent.im.msg.im_msg_body$SourceMsg;
import tencent.im.msg.im_msg_body$Text;
import tencent.im.msg.im_msg_body$TipsInfo;
import tencent.im.msg.im_msg_body$TransElem;
import tencent.im.msg.obj_msg$ObjMsg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class o extends v {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    protected WeakReference<QQAppInterface> f286319b;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public MessageForReplyText.SourceMsgInfo f286320a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f286321b;

        /* renamed from: c, reason: collision with root package name */
        public String f286322c;

        /* renamed from: d, reason: collision with root package name */
        public AtTroopMemberInfo f286323d;

        /* renamed from: e, reason: collision with root package name */
        public String f286324e;

        /* renamed from: f, reason: collision with root package name */
        public ArrayList<AtTroopMemberInfo> f286325f;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends y {
        static IPatchRedirector $redirector_;

        b(AppRuntime appRuntime, StringBuilder sb5, long j3, com.tencent.mobileqq.troop.data.c cVar, ArrayList<AtTroopMemberInfo> arrayList, AtTroopMemberInfo atTroopMemberInfo, AtTroopMemberInfo atTroopMemberInfo2, byte[] bArr, StringBuilder sb6, boolean z16, im_msg_body$Elem im_msg_body_elem, long j16) {
            super(appRuntime, sb5, j3, cVar, arrayList, atTroopMemberInfo, atTroopMemberInfo2, bArr, sb6, z16, im_msg_body_elem, j16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, o.this, appRuntime, sb5, Long.valueOf(j3), cVar, arrayList, atTroopMemberInfo, atTroopMemberInfo2, bArr, sb6, Boolean.valueOf(z16), im_msg_body_elem, Long.valueOf(j16));
            }
        }

        private boolean k() {
            int i3;
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType: bankcode_ctrlinfo;\n");
            }
            byte[] byteArray = this.f286362k.bankcode_ctrl_info.get().toByteArray();
            byte b16 = byteArray[0];
            byte b17 = byteArray[byteArray.length - 1];
            if (b16 == 40 && b17 == 41) {
                if (ByteBuffer.wrap(byteArray, 2, 2).getShort() != 29786 || (i3 = ByteBuffer.wrap(byteArray, 4, 2).getShort()) <= 0) {
                    return true;
                }
                byte[] bArr = new byte[i3];
                this.f286359h = bArr;
                System.arraycopy(byteArray, 6, bArr, 0, i3);
                return false;
            }
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType: bankcode_ctrlinfo buffer error;\n");
            }
            return true;
        }

        private void l() {
            int convertToLocal;
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType:Face;\n");
            }
            if (!this.f286362k.f435954face.get().index.has() || (convertToLocal = QQSysFaceUtil.convertToLocal(this.f286362k.f435954face.get().index.get())) < 0) {
                return;
            }
            this.f286360i.append((char) 20);
            this.f286360i.append((char) convertToLocal);
        }

        private void m() {
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType:NewSysFaceMsg;\n");
            }
            this.f286360i.append(o.this.G1(this.f286362k.common_elem.get()));
        }

        private void n() {
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType:OnlineImage;\n");
            }
            this.f286360i.append(BaseApplication.getContext().getString(R.string.cnv));
        }

        private void o() {
            if (QLog.isColorLevel()) {
                this.f286352a.append("elemType:small_emoji;\n");
            }
            if (!this.f286362k.small_emoji.get().packIdSum.has()) {
                return;
            }
            int i3 = (this.f286362k.small_emoji.get().packIdSum.get() & SupportMenu.CATEGORY_MASK) >> 16;
            int i16 = this.f286362k.small_emoji.get().packIdSum.get() & 65535;
            char[] k3 = com.tencent.mobileqq.emosm.e.k(i3, i16);
            if (this.f286362k.small_emoji.get().imageType.has() && (65535 & this.f286362k.small_emoji.get().imageType.get()) == 2) {
                k3[3] = '\u01ff';
                if (QLog.isColorLevel()) {
                    QLog.d("MessagePBElemDecoder", 2, "get apng epid = " + i3 + " eid = " + i16);
                }
            }
            this.f286360i.append((char) 20);
            this.f286360i.append(k3[3]);
            this.f286360i.append(k3[2]);
            this.f286360i.append(k3[1]);
            this.f286360i.append(k3[0]);
            this.f286361j = true;
        }

        @Override // com.tencent.mobileqq.service.message.y
        protected void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f286362k.f435954face.has()) {
                l();
                return;
            }
            if (this.f286362k.small_emoji.has()) {
                o();
                return;
            }
            if (has()) {
                n();
                return;
            }
            if (this.f286362k.bankcode_ctrl_info.has()) {
                k();
            } else if (this.f286362k.common_elem.has() && 33 == this.f286362k.common_elem.uint32_service_type.get()) {
                m();
            }
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f286319b = new WeakReference<>((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
        }
    }

    private void A(im_msg_body$DeliverGiftMsg im_msg_body_delivergiftmsg, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, MessageForDeliverGiftTips messageForDeliverGiftTips) {
        bf bfVar = (bf) i1().getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
        if (bfVar == null) {
            return;
        }
        TroopTipsEntity troopTipsEntity = new TroopTipsEntity();
        messageForDeliverGiftTips.grayTipsEntity = troopTipsEntity;
        troopTipsEntity.isSupportImage = true;
        troopTipsEntity.troopUin = String.valueOf(msg_comm_msg.msg_head.group_info.group_code.get());
        TroopTipsEntity troopTipsEntity2 = messageForDeliverGiftTips.grayTipsEntity;
        troopTipsEntity2.optContent = messageForDeliverGiftTips.grayTipContent;
        bfVar.a(troopTipsEntity2);
        messageForDeliverGiftTips.f203106msg = messageForDeliverGiftTips.grayTipsEntity.optContent;
        boolean z16 = messageForDeliverGiftTips instanceof MessageForTroopGift;
        if (z16) {
            MessageForTroopGift messageForTroopGift = (MessageForTroopGift) messageForDeliverGiftTips;
            messageForTroopGift.bagId = im_msg_body_delivergiftmsg.bytes_to_all_gift_id.get().toStringUtf8();
            messageForTroopGift.title = im_msg_body_delivergiftmsg.bytes_stmessage_title.get().toStringUtf8();
            messageForTroopGift.subtitle = im_msg_body_delivergiftmsg.bytes_stmessage_subtitle.get().toStringUtf8();
            messageForTroopGift.message = im_msg_body_delivergiftmsg.bytes_stmessage_message.get().toStringUtf8();
            messageForTroopGift.giftPicId = im_msg_body_delivergiftmsg.uint32_stmessage_giftpicid.get();
            messageForTroopGift.comefrom = im_msg_body_delivergiftmsg.bytes_stmessage_comefrom.get().toStringUtf8();
            messageForTroopGift.exflag = im_msg_body_delivergiftmsg.uint32_stmessage_exflag.get();
            if (im_msg_body_delivergiftmsg.bytes_stmessage_gifturl.has()) {
                messageForTroopGift.giftUrl = im_msg_body_delivergiftmsg.bytes_stmessage_gifturl.get().toStringUtf8();
            }
        }
        if (TextUtils.isEmpty(messageForDeliverGiftTips.summary)) {
            messageForDeliverGiftTips.summary = messageForDeliverGiftTips.f203106msg;
        }
        TroopTipsEntity troopTipsEntity3 = messageForDeliverGiftTips.grayTipsEntity;
        if (troopTipsEntity3.highlightNum != 0) {
            bf.h(messageForDeliverGiftTips, troopTipsEntity3.highlightItems);
        }
        if (z16) {
            ((MessageForTroopGift) messageForDeliverGiftTips).prewrite();
        }
        if (i1().getCurrentAccountUin() != null) {
            if (i1().getCurrentAccountUin().equals(messageForDeliverGiftTips.receiverUin + "")) {
                String str = messageForDeliverGiftTips.remindBrief;
                if (str != null) {
                    messageForDeliverGiftTips.saveExtInfoToExtStr(MessageForDeliverGiftTips.MESSAGERECORD_EXTSTR_TYPE, str.split("#")[0]);
                }
                list.add(messageForDeliverGiftTips);
            }
        }
        String str2 = messageForDeliverGiftTips.remindBrief;
        if (str2 != null && str2.split("#").length > 1) {
            messageForDeliverGiftTips.saveExtInfoToExtStr(MessageForDeliverGiftTips.MESSAGERECORD_EXTSTR_TYPE, messageForDeliverGiftTips.remindBrief.split("#")[1]);
        }
        list.add(messageForDeliverGiftTips);
    }

    private void A0(List<MessageRecord> list, msg_comm$Msg msg_comm_msg, im_msg_body$TransElem im_msg_body_transelem, byte[] bArr) {
        FileManagerEntity fileManagerEntity;
        int size = im_msg_body_transelem.elem_value.get().size();
        int i3 = 0;
        int i16 = 0;
        while (size > 3) {
            int i17 = i16 + 1;
            if (i16 <= 100) {
                byte b16 = bArr[i3];
                int shortData = PkgTools.getShortData(bArr, i3 + 1);
                int i18 = shortData + 3;
                size -= i18;
                int i19 = i18 + i3;
                if (b16 == 1) {
                    byte[] bArr2 = new byte[shortData];
                    PkgTools.copyData(bArr2, 0, bArr, i3 + 3, shortData);
                    try {
                        obj_msg$ObjMsg mergeFrom = new obj_msg$ObjMsg().mergeFrom(bArr2);
                        if (mergeFrom.uint32_msg_type.get() == 6) {
                            TroopFileData troopFileData = new TroopFileData();
                            troopFileData.fileUrl = new String(mergeFrom.msg_content_info.get(0).msg_file.bytes_file_path.get().toByteArray());
                            troopFileData.bisID = mergeFrom.msg_content_info.get(0).msg_file.uint32_bus_id.get();
                            troopFileData.fileName = mergeFrom.msg_content_info.get(0).msg_file.str_file_name.get();
                            troopFileData.lfileSize = mergeFrom.msg_content_info.get(0).msg_file.uint64_file_size.get();
                            troopFileData.lastTime = mergeFrom.msg_content_info.get(0).msg_file.int64_dead_time.get();
                            troopFileData.sha1 = new String(mergeFrom.msg_content_info.get(0).msg_file.bytes_file_sha1.get().toByteArray());
                            troopFileData.md5 = new String(mergeFrom.msg_content_info.get(0).msg_file.bytes_file_md5.get().toByteArray());
                            troopFileData.uuid = UUID.nameUUIDFromBytes(troopFileData.fileUrl.getBytes()).toString();
                            if (mergeFrom.msg_content_info.get(0).msg_file.bytes_ext.has()) {
                                try {
                                    JSONObject jSONObject = new JSONObject(mergeFrom.msg_content_info.get(0).msg_file.bytes_ext.get().toStringUtf8());
                                    troopFileData.width = jSONObject.optInt("width");
                                    troopFileData.height = jSONObject.optInt("height");
                                    troopFileData.duration = jSONObject.optInt("duration");
                                    troopFileData.yybApkPackageName = jSONObject.optString("yyb_apk_package_name_key");
                                    troopFileData.yybApkName = jSONObject.optString("yyb_apk_name_key");
                                    troopFileData.yybApkIconUrl = jSONObject.optString("yyb_apk_icon_url_key");
                                } catch (Exception unused) {
                                }
                            }
                            String str = new String(mergeFrom.bytes_title.get().toByteArray());
                            troopFileData.dspFileName = str;
                            troopFileData.dspFileName = FileManagerUtil.getFileName(str);
                            troopFileData.dspFileSize = new String(mergeFrom.rpt_bytes_abstact.get(0).toByteArray());
                            ae.b(msg_comm_msg.msg_head.group_info.group_code.get()).c(i1(), troopFileData.fileUrl, troopFileData);
                            StringBuilder sb5 = new StringBuilder("decodePBMshElems==>");
                            sb5.append(troopFileData.toString());
                            com.tencent.mobileqq.troop.data.t H = TroopFileTransferManager.O(i1(), msg_comm_msg.msg_head.group_info.group_code.get()).H(troopFileData.fileUrl);
                            if (H != null) {
                                fileManagerEntity = i1().getFileManagerDataCenter().D(H.f294989w);
                                if (fileManagerEntity != null) {
                                    fileManagerEntity.lastTime = troopFileData.lastTime;
                                }
                            } else {
                                fileManagerEntity = null;
                            }
                            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) q.d(MessageRecord.MSG_TYPE_TROOP_OBJ_MSG);
                            messageForTroopFile.msgtype = MessageRecord.MSG_TYPE_TROOP_OBJ_MSG;
                            messageForTroopFile.f203106msg = HardCodeUtil.qqStr(R.string.o38);
                            try {
                                messageForTroopFile.msgData = MessagePkgUtils.getBytesFromObject(troopFileData);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                            messageForTroopFile.parse();
                            list.add(messageForTroopFile);
                            if (fileManagerEntity != null) {
                                i1().getMessageFacade().Y0(msg_comm_msg.msg_head.group_info.group_code.get() + "", 1, fileManagerEntity.structMsgSeq, messageForTroopFile.msgData);
                                sb5.append("|updateMsgContentByUniseq, msgSeq:");
                                sb5.append(fileManagerEntity.structMsgSeq);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("MessagePBElemDecoder", 2, "<TroopFile> " + sb5.toString());
                                return;
                            }
                            return;
                        }
                    } catch (Exception unused2) {
                        continue;
                    }
                }
                i16 = i17;
                i3 = i19;
            } else {
                return;
            }
        }
    }

    private void A1(List<MessageRecord> list, boolean z16, boolean z17, StringBuilder sb5) {
        if (sb5.length() > 0 && !z16 && !z17) {
            MessageForText messageForText = (MessageForText) q.d(-1000);
            messageForText.msgtype = -1000;
            messageForText.f203106msg = sb5.toString();
            list.add(messageForText);
            sb5.delete(0, sb5.length());
        }
    }

    private void B(im_msg_body$DeliverGiftMsg im_msg_body_delivergiftmsg, MessageForDeliverGiftTips messageForDeliverGiftTips) {
        if (!im_msg_body_delivergiftmsg.bytes_receiver_name.has()) {
            return;
        }
        messageForDeliverGiftTips.receiverName = im_msg_body_delivergiftmsg.bytes_receiver_name.get().toStringUtf8();
    }

    private void B0(List<MessageRecord> list) {
        String string = BaseApplication.getContext().getString(R.string.cnv);
        MessageForText messageForText = (MessageForText) q.d(-1000);
        messageForText.msgtype = -1000;
        messageForText.f203106msg = string;
        list.add(messageForText);
    }

    private boolean B1(im_msg_body$CustomFace im_msg_body_customface) {
        if (im_msg_body_customface != null) {
            return true;
        }
        return false;
    }

    private void C(im_msg_body$DeliverGiftMsg im_msg_body_delivergiftmsg, MessageForDeliverGiftTips messageForDeliverGiftTips) {
        if (im_msg_body_delivergiftmsg.bytes_receiver_pic.has()) {
            messageForDeliverGiftTips.receiverHead = im_msg_body_delivergiftmsg.bytes_receiver_pic.get().toStringUtf8();
        }
    }

    private boolean C1(im_msg_body$Elem im_msg_body_elem) {
        if (im_msg_body_elem != null) {
            return im_msg_body_elem.hc_flash_pic.has();
        }
        return false;
    }

    private void D(im_msg_body$DeliverGiftMsg im_msg_body_delivergiftmsg, MessageForDeliverGiftTips messageForDeliverGiftTips) {
        if (!im_msg_body_delivergiftmsg.bytes_pb_reserve.has()) {
            return;
        }
        ResvAttrForGiftMsg$ResvAttr resvAttrForGiftMsg$ResvAttr = new ResvAttrForGiftMsg$ResvAttr();
        try {
            resvAttrForGiftMsg$ResvAttr.mergeFrom(im_msg_body_delivergiftmsg.bytes_pb_reserve.get().toByteArray());
            messageForDeliverGiftTips.sendScore = resvAttrForGiftMsg$ResvAttr.int32_send_score.get();
            messageForDeliverGiftTips.recvScore = resvAttrForGiftMsg$ResvAttr.int32_recv_score.get();
            if (resvAttrForGiftMsg$ResvAttr.bytes_charm_heroism.has()) {
                messageForDeliverGiftTips.charmHeroism = resvAttrForGiftMsg$ResvAttr.bytes_charm_heroism.get().toStringUtf8();
            }
            messageForDeliverGiftTips.btFlag = resvAttrForGiftMsg$ResvAttr.uint32_button_flag.get();
            messageForDeliverGiftTips.objColor = resvAttrForGiftMsg$ResvAttr.uint32_obj_color.get();
            if (resvAttrForGiftMsg$ResvAttr.activity_gift_info.has()) {
                ResvAttrForGiftMsg$ActivityGiftInfo resvAttrForGiftMsg$ActivityGiftInfo = resvAttrForGiftMsg$ResvAttr.activity_gift_info.get();
                messageForDeliverGiftTips.is_activity_gift = resvAttrForGiftMsg$ActivityGiftInfo.is_activity_gift.get();
                messageForDeliverGiftTips.activity_text_color = resvAttrForGiftMsg$ActivityGiftInfo.text_color.get();
                messageForDeliverGiftTips.activity_text = resvAttrForGiftMsg$ActivityGiftInfo.text.get();
                messageForDeliverGiftTips.activity_url = resvAttrForGiftMsg$ActivityGiftInfo.url.get();
            } else {
                messageForDeliverGiftTips.is_activity_gift = 0;
            }
            messageForDeliverGiftTips.animationType = resvAttrForGiftMsg$ResvAttr.uint32_animation_type.get();
            if (resvAttrForGiftMsg$ResvAttr.msg_interact_gift.has()) {
                messageForDeliverGiftTips.interactId = resvAttrForGiftMsg$ResvAttr.msg_interact_gift.bytes_interact_id.get().toStringUtf8();
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private MessageForPic D1(msg_comm$Msg msg_comm_msg, boolean z16, CustomFaceExtPb$ResvAttr customFaceExtPb$ResvAttr) {
        if (z16) {
            MessageForPic messageForPic = (MessageForPic) q.d(MessageRecord.MSG_TYPE_TROOP_EFFECT_PIC);
            messageForPic.msgtype = MessageRecord.MSG_TYPE_TROOP_EFFECT_PIC;
            ((MessageForTroopEffectPic) messageForPic).effectId = customFaceExtPb$ResvAttr.msg_image_show.get().int32_product_id.get();
            messageForPic.frienduin = String.valueOf(msg_comm_msg.msg_head.get().group_info.group_code.get());
            messageForPic.istroop = 1;
            AIOAnimationControlManager aIOAnimationControlManager = (AIOAnimationControlManager) i1().getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
            if (aIOAnimationControlManager != null) {
                aIOAnimationControlManager.j((AIOAnimationControlManager.h) messageForPic, false);
                return messageForPic;
            }
            return messageForPic;
        }
        MessageForPic messageForPic2 = (MessageForPic) q.d(-2000);
        messageForPic2.msgtype = -2000;
        return messageForPic2;
    }

    private void E(MessageForDeliverGiftTips messageForDeliverGiftTips) {
        String str;
        int indexOf;
        if (messageForDeliverGiftTips.summary != null && (str = messageForDeliverGiftTips.rcvName) != null && str.length() > 0) {
            Pattern compile = Pattern.compile(HardCodeUtil.qqStr(R.string.f172183o35));
            String str2 = messageForDeliverGiftTips.f203106msg;
            if (!messageForDeliverGiftTips.isToAll() && messageForDeliverGiftTips.f203106msg.startsWith("[") && (indexOf = messageForDeliverGiftTips.f203106msg.indexOf("]")) != -1 && indexOf < messageForDeliverGiftTips.f203106msg.length()) {
                str2 = messageForDeliverGiftTips.f203106msg.substring(indexOf + 1);
            }
            Matcher matcher = compile.matcher(str2);
            if (!matcher.find()) {
                return;
            }
            String group = matcher.group();
            int indexOf2 = str2.indexOf(group);
            int lastIndexOf = str2.lastIndexOf(group);
            if (indexOf2 > 0 && lastIndexOf == indexOf2) {
                messageForDeliverGiftTips.senderName = str2.substring(0, indexOf2);
            }
        }
    }

    @NonNull
    private CustomFaceExtPb$ResvAttr E1(im_msg_body$CustomFace im_msg_body_customface) {
        CustomFaceExtPb$ResvAttr customFaceExtPb$ResvAttr = new CustomFaceExtPb$ResvAttr();
        try {
            customFaceExtPb$ResvAttr.mergeFrom(im_msg_body_customface.bytes_pb_reserve.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return customFaceExtPb$ResvAttr;
    }

    private void F(im_msg_body$DeliverGiftMsg im_msg_body_delivergiftmsg, MessageForDeliverGiftTips messageForDeliverGiftTips) {
        if (!(messageForDeliverGiftTips instanceof MessageForTroopGift)) {
            return;
        }
        MessageForTroopGift messageForTroopGift = (MessageForTroopGift) messageForDeliverGiftTips;
        messageForTroopGift.bagId = im_msg_body_delivergiftmsg.bytes_to_all_gift_id.get().toStringUtf8();
        messageForTroopGift.title = im_msg_body_delivergiftmsg.bytes_stmessage_title.get().toStringUtf8();
        messageForTroopGift.subtitle = im_msg_body_delivergiftmsg.bytes_stmessage_subtitle.get().toStringUtf8();
        messageForTroopGift.message = im_msg_body_delivergiftmsg.bytes_stmessage_message.get().toStringUtf8();
        messageForTroopGift.giftPicId = im_msg_body_delivergiftmsg.uint32_stmessage_giftpicid.get();
        messageForTroopGift.comefrom = im_msg_body_delivergiftmsg.bytes_stmessage_comefrom.get().toStringUtf8();
        messageForTroopGift.exflag = im_msg_body_delivergiftmsg.uint32_stmessage_exflag.get();
        if (im_msg_body_delivergiftmsg.bytes_stmessage_gifturl.has()) {
            messageForTroopGift.giftUrl = im_msg_body_delivergiftmsg.bytes_stmessage_gifturl.get().toStringUtf8();
        }
        messageForTroopGift.prewrite();
    }

    @Nullable
    private MessageForReplyText G(AtTroopMemberInfo atTroopMemberInfo, List<MessageRecord> list, aa aaVar, com.tencent.mobileqq.troop.data.c cVar, MessageForReplyText messageForReplyText) {
        if (TextUtils.isEmpty(messageForReplyText.mSourceMsgInfo.mAnonymousNickName) && atTroopMemberInfo != null) {
            String str = "";
            if (list.size() <= 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("zivonchen", 2, "");
                    return messageForReplyText;
                }
                return messageForReplyText;
            }
            MessageRecord messageRecord = list.get(0);
            if (!(messageRecord instanceof MessageForText)) {
                if (QLog.isColorLevel()) {
                    QLog.w("zivonchen", 2, "replytext \u5185\u5bb9\u4e3a\u7a7a\uff0c\u6709\u56de\u590d\u6d88\u606f\uff0c\u4f46\u7b2c\u4e00\u4e2a\u6d88\u606f\u4f53\u4e0d\u662f\u6587\u672c\u6d88\u606f");
                    return messageForReplyText;
                }
                return messageForReplyText;
            }
            MessageForReplyText messageForReplyText2 = (MessageForReplyText) q.d(MessageRecord.MSG_TYPE_REPLY_TEXT);
            MessageRecord.copyMessageRecordBaseField(messageForReplyText2, messageRecord);
            MessageRecord.copyMessageRecordStatusField(messageForReplyText2, messageRecord);
            messageForReplyText2.atInfoList = messageForReplyText.atInfoList;
            String str2 = messageRecord.f203106msg;
            messageForReplyText2.f203106msg = str2;
            messageForReplyText2.mSourceMsgInfo = messageForReplyText.mSourceMsgInfo;
            messageForReplyText2.msgtype = MessageRecord.MSG_TYPE_REPLY_TEXT;
            if (!TextUtils.isEmpty(str2)) {
                int length = messageForReplyText2.f203106msg.length();
                short s16 = atTroopMemberInfo.textLen;
                short s17 = atTroopMemberInfo.startPos;
                if (length >= s16 + s17) {
                    String str3 = messageForReplyText2.f203106msg;
                    messageForReplyText2.f203106msg = "";
                    if (s17 > 0) {
                        messageForReplyText2.f203106msg = str3.substring(0, s17);
                    }
                    int i3 = atTroopMemberInfo.startPos + atTroopMemberInfo.textLen;
                    int i16 = i3 + 1;
                    if (i16 < str3.length()) {
                        str = str3.substring(i3, i16);
                    }
                    if (str.equals(" ")) {
                        messageForReplyText2.f203106msg += str3.substring(i16);
                    } else {
                        messageForReplyText2.f203106msg += str3.substring(i3);
                    }
                    if (atTroopMemberInfo.isIncludingMe(i1().getLongAccountUin()) && aaVar.f286172b == null && cVar != null) {
                        cVar.f294893c.k(25, -1L, 0L);
                    }
                }
            }
            list.remove(0);
            list.add(0, messageForReplyText2);
            return null;
        }
        return messageForReplyText;
    }

    private void G0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, String str, int i3, hummer_commelem$MsgElemInfo_servtype14 hummer_commelem_msgeleminfo_servtype14) throws InvalidProtocolBufferMicroException {
        if (i3 == 0) {
            H0(list, list2, sb5, msg_comm_msg, cVar, str, hummer_commelem_msgeleminfo_servtype14);
        }
    }

    private void H(MessageForReplyText.SourceMsgInfo sourceMsgInfo, MessageForReplyText messageForReplyText) {
        int parseInt;
        try {
            messageForReplyText.extLong |= 1;
            messageForReplyText.mSourceMsgInfo = sourceMsgInfo;
            if (sourceMsgInfo.getSourceMsg() != null) {
                messageForReplyText.setSourceMessageRecord(sourceMsgInfo.unPackSourceMsg(i1()));
                if (messageForReplyText.getSourceMessage() != null && FileManagerUtil.isMessageRecordOfFile(messageForReplyText.getSourceMessage())) {
                    String extInfoFromExtStr = messageForReplyText.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
                    ChatMessage changeRealChatMessage = FileManagerUtil.changeRealChatMessage((ChatMessage) messageForReplyText.getSourceMessage());
                    QFileUtils.k(i1(), changeRealChatMessage, messageForReplyText.getSourceMessage());
                    if (!TextUtils.isEmpty(extInfoFromExtStr) && changeRealChatMessage != null && ((parseInt = Integer.parseInt(extInfoFromExtStr)) == 1 || parseInt == 2)) {
                        QLog.i("MessagePBElemDecoder<QFile>", 1, "decode mix inner reply file msg, msg uniseq[" + changeRealChatMessage.uniseq + "]");
                        FileManagerUtil.getFileRecordForMultiMsg(i1(), changeRealChatMessage.uniseq, changeRealChatMessage.frienduin, changeRealChatMessage.istroop, (ChatMessage) messageForReplyText.getSourceMessage());
                    }
                }
            }
            messageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(sourceMsgInfo)));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + e16.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, String str, hummer_commelem$MsgElemInfo_servtype14 hummer_commelem_msgeleminfo_servtype14) {
        String str2;
        MessageForArkFlashChat messageForArkFlashChat;
        if (!((FlashChatManager) i1().getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).u()) {
            m(list, list2, sb5, msg_comm_msg, cVar);
            return;
        }
        boolean z16 = true;
        if (!ArkUtil.isDeviceSupportArkMsg()) {
            QLog.i("FlashChat", 1, "decodePBMsgElems_FlashChat is false, ignore msg.");
            return;
        }
        if (hummer_commelem_msgeleminfo_servtype14.uint32_id.has() && hummer_commelem_msgeleminfo_servtype14.reserve_Info.has()) {
            int i3 = hummer_commelem_msgeleminfo_servtype14.uint32_id.get();
            String stringUtf8 = hummer_commelem_msgeleminfo_servtype14.reserve_Info.get().toStringUtf8();
            if (!hummer_commelem_msgeleminfo_servtype14.reserve_Info.has()) {
                QLog.i("flashchat", 1, "ecodePBMsgElems_FlashChat, reserve_Info not exist.");
                return;
            }
            byte[] byteArray = hummer_commelem_msgeleminfo_servtype14.reserve_Info.get().toByteArray();
            if (byteArray.length <= 0) {
                QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat, reserve_Info empty.");
                return;
            }
            byte[] i16 = com.tencent.mobileqq.structmsg.k.i(byteArray, -1);
            if (i16 != null && i16.length > 0) {
                try {
                    str2 = new String(i16, "UTF-8");
                } catch (Exception unused) {
                    QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat convert failed");
                }
                ArkFlashChatMessage arkFlashChatMessage = new ArkFlashChatMessage();
                arkFlashChatMessage.fromAppXml(str2);
                arkFlashChatMessage.appResId = i3;
                arkFlashChatMessage.promptText = str;
                messageForArkFlashChat = (MessageForArkFlashChat) q.d(MessageRecord.MSG_TYPE_FLASH_CHAT);
                messageForArkFlashChat.msgtype = MessageRecord.MSG_TYPE_FLASH_CHAT;
                messageForArkFlashChat.msgData = arkFlashChatMessage.toBytes();
                messageForArkFlashChat.parse();
                if (TextUtils.isEmpty(messageForArkFlashChat.ark_app_message.appName) && !TextUtils.isEmpty(messageForArkFlashChat.ark_app_message.appView)) {
                    list2.add(messageForArkFlashChat);
                } else {
                    QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat not valid..");
                    z16 = false;
                }
                QLog.d("flashchat", 2, "decodePBMsgElems_FlashChat id = " + i3 + ", reserveInfo = " + stringUtf8 + ", arkData = " + str2);
                if (z16) {
                    m(list, list2, sb5, msg_comm_msg, cVar);
                    return;
                }
                return;
            }
            QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat empty.");
            str2 = null;
            ArkFlashChatMessage arkFlashChatMessage2 = new ArkFlashChatMessage();
            arkFlashChatMessage2.fromAppXml(str2);
            arkFlashChatMessage2.appResId = i3;
            arkFlashChatMessage2.promptText = str;
            messageForArkFlashChat = (MessageForArkFlashChat) q.d(MessageRecord.MSG_TYPE_FLASH_CHAT);
            messageForArkFlashChat.msgtype = MessageRecord.MSG_TYPE_FLASH_CHAT;
            messageForArkFlashChat.msgData = arkFlashChatMessage2.toBytes();
            messageForArkFlashChat.parse();
            if (TextUtils.isEmpty(messageForArkFlashChat.ark_app_message.appName)) {
            }
            QLog.i("flashchat", 1, "decodePBMsgElems_FlashChat not valid..");
            z16 = false;
            QLog.d("flashchat", 2, "decodePBMsgElems_FlashChat id = " + i3 + ", reserveInfo = " + stringUtf8 + ", arkData = " + str2);
            if (z16) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0322  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H1(im_msg_body$Elem im_msg_body_elem, im_msg_body$NotOnlineImage im_msg_body_notonlineimage, List<MessageRecord> list, StringBuilder sb5, msg_comm$Msg msg_comm_msg) {
        im_msg_body$NotOnlineImage im_msg_body_notonlineimage2;
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        String str;
        String stringUtf8;
        int i19;
        int i26;
        String str2;
        int i27;
        int i28;
        int i29;
        byte[] byteArray;
        BaseApplication.getContext().getString(R.string.cnv);
        if (im_msg_body_notonlineimage != null) {
            im_msg_body_notonlineimage2 = im_msg_body_notonlineimage;
            z16 = true;
        } else {
            if (im_msg_body_elem != null) {
                im_msg_body_notonlineimage2 = im_msg_body_elem.not_online_image.get();
            } else {
                im_msg_body_notonlineimage2 = null;
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElems_OfflineMsg hasComFlashPic=" + z16);
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:NotOnlineImage;\n hasComFlashPic=" + z16);
        }
        if (im_msg_body_notonlineimage2 == null) {
            QLog.d("flash", 2, "offlineImg null");
            return;
        }
        int i36 = im_msg_body_notonlineimage2.file_len.get();
        int i37 = im_msg_body_notonlineimage2.img_type.get();
        if (QLog.isColorLevel()) {
            QLog.d("MessagePBElemDecoder", 2, "[NotOnlineImage] file_len=" + i36);
            QLog.d("MessagePBElemDecoder", 2, "[NotOnlineImage] imgType=" + i37);
        }
        im_msg_body_notonlineimage2.flag.get().toByteArray();
        String str3 = im_msg_body_notonlineimage2.str_thumb_url.get();
        String str4 = im_msg_body_notonlineimage2.str_400_url.get();
        int i38 = im_msg_body_notonlineimage2.uint32_thumb_width.get();
        int i39 = im_msg_body_notonlineimage2.uint32_thumb_height.get();
        if (QLog.isColorLevel()) {
            QLog.d("MessagePBElemDecoder", 2, "[NotOnlineImage] ThumbWidth=" + i38 + ",ThumbHeight=" + i39);
        }
        if (im_msg_body_notonlineimage2.uint32_file_id.has()) {
            i3 = im_msg_body_notonlineimage2.uint32_file_id.get();
        } else {
            i3 = 0;
        }
        String str5 = im_msg_body_notonlineimage2.str_big_url.get();
        String str6 = im_msg_body_notonlineimage2.str_orig_url.get();
        int i46 = im_msg_body_notonlineimage2.pic_width.get();
        int i47 = im_msg_body_notonlineimage2.pic_height.get();
        int i48 = im_msg_body_notonlineimage2.uint32_show_len.get();
        int i49 = im_msg_body_notonlineimage2.uint32_download_len.get();
        if (QLog.isDevelopLevel()) {
            i17 = i39;
            StringBuilder sb6 = new StringBuilder();
            i18 = i3;
            sb6.append("MessageProtoCodec.decodePBMsgElems(): showLen ");
            sb6.append(i48);
            sb6.append(", downloadLen ");
            sb6.append(i49);
            sb6.append(", fileLen ");
            sb6.append(i36);
            i16 = i49;
            QLog.d("peak_pgjpeg", 4, sb6.toString());
        } else {
            i16 = i49;
            i17 = i39;
            i18 = i3;
        }
        int i56 = im_msg_body_notonlineimage2.original.get();
        if (im_msg_body_notonlineimage2.res_id.has()) {
            stringUtf8 = im_msg_body_notonlineimage2.res_id.get().toStringUtf8();
        } else if (im_msg_body_notonlineimage2.download_path.has()) {
            stringUtf8 = im_msg_body_notonlineimage2.download_path.get().toStringUtf8();
        } else {
            str = null;
            if (str == null && !str.equals("")) {
                if (im_msg_body_notonlineimage2.pic_md5.has() && (byteArray = im_msg_body_notonlineimage2.pic_md5.get().toByteArray()) != null) {
                    i19 = i56;
                    if (byteArray.length > 0) {
                        str2 = HexUtil.bytes2HexStr(byteArray);
                        i26 = i38;
                        long j3 = i36;
                        int i57 = i16;
                        String str7 = str2;
                        String str8 = str;
                        int i58 = i18;
                        i27 = i19;
                        String makeTransFileProtocolData = TransfileUtile.makeTransFileProtocolData(str, j3, 1, false, str8, str7, "picplatform", str3, str4, str5, str6, i27, 0);
                        RichMsg$PicRec richMsg$PicRec = new RichMsg$PicRec();
                        richMsg$PicRec.localPath.set(str8);
                        richMsg$PicRec.size.set(j3);
                        richMsg$PicRec.type.set(1);
                        richMsg$PicRec.isRead.set(false);
                        richMsg$PicRec.uuid.set(str8);
                        richMsg$PicRec.md5.set(str7);
                        richMsg$PicRec.serverStorageSource.set("picplatform");
                        richMsg$PicRec.thumbMsgUrl.set(str3);
                        richMsg$PicRec.bigthumbMsgUrl.set(str4);
                        richMsg$PicRec.uint32_thumb_width.set(i26);
                        richMsg$PicRec.uint32_thumb_height.set(i17);
                        richMsg$PicRec.uint32_width.set(i46);
                        richMsg$PicRec.uint32_height.set(i47);
                        if (im_msg_body_notonlineimage2.uint32_file_id.has()) {
                            richMsg$PicRec.groupFileID.set(i58);
                        }
                        richMsg$PicRec.bigMsgUrl.set(str5);
                        richMsg$PicRec.rawMsgUrl.set(str6);
                        richMsg$PicRec.fileSizeFlag.set(i27);
                        richMsg$PicRec.uiOperatorFlag.set(0);
                        richMsg$PicRec.version.set(5);
                        richMsg$PicRec.isReport.set(0);
                        if (QLog.isColorLevel()) {
                            sb5.append("content:");
                            sb5.append(makeTransFileProtocolData);
                            sb5.append("\n");
                        }
                        if (i27 != 1) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MessagePBElemDecoder", 2, "[NotOnlineImage] showLen =" + i48 + ",downloadLen = " + i57 + ",raw photo msg,clear progressjpg info!");
                            }
                            i29 = 0;
                            i28 = 0;
                        } else {
                            i28 = i57;
                            i29 = i48;
                        }
                        richMsg$PicRec.uint32_show_len.set(i29);
                        richMsg$PicRec.uint32_download_len.set(i28);
                        richMsg$PicRec.uint32_image_type.set(i37);
                        if (im_msg_body_notonlineimage2.bytes_pb_reserve.has()) {
                            richMsg$PicRec.bytes_pb_reserved.set(im_msg_body_notonlineimage2.bytes_pb_reserve.get());
                        }
                        MessageForPic messageForPic = (MessageForPic) q.d(-2000);
                        if (z16) {
                            ((IPicFlash) QRoute.api(IPicFlash.class)).setFlashPicFlag(messageForPic, false);
                        }
                        messageForPic.msgtype = -2000;
                        messageForPic.msgData = richMsg$PicRec.toByteArray();
                        messageForPic.parse();
                        list.add(messageForPic);
                        return;
                    }
                } else {
                    i19 = i56;
                }
                i26 = i38;
                str2 = "";
                long j36 = i36;
                int i572 = i16;
                String str72 = str2;
                String str82 = str;
                int i582 = i18;
                i27 = i19;
                String makeTransFileProtocolData2 = TransfileUtile.makeTransFileProtocolData(str, j36, 1, false, str82, str72, "picplatform", str3, str4, str5, str6, i27, 0);
                RichMsg$PicRec richMsg$PicRec2 = new RichMsg$PicRec();
                richMsg$PicRec2.localPath.set(str82);
                richMsg$PicRec2.size.set(j36);
                richMsg$PicRec2.type.set(1);
                richMsg$PicRec2.isRead.set(false);
                richMsg$PicRec2.uuid.set(str82);
                richMsg$PicRec2.md5.set(str72);
                richMsg$PicRec2.serverStorageSource.set("picplatform");
                richMsg$PicRec2.thumbMsgUrl.set(str3);
                richMsg$PicRec2.bigthumbMsgUrl.set(str4);
                richMsg$PicRec2.uint32_thumb_width.set(i26);
                richMsg$PicRec2.uint32_thumb_height.set(i17);
                richMsg$PicRec2.uint32_width.set(i46);
                richMsg$PicRec2.uint32_height.set(i47);
                if (im_msg_body_notonlineimage2.uint32_file_id.has()) {
                }
                richMsg$PicRec2.bigMsgUrl.set(str5);
                richMsg$PicRec2.rawMsgUrl.set(str6);
                richMsg$PicRec2.fileSizeFlag.set(i27);
                richMsg$PicRec2.uiOperatorFlag.set(0);
                richMsg$PicRec2.version.set(5);
                richMsg$PicRec2.isReport.set(0);
                if (QLog.isColorLevel()) {
                }
                if (i27 != 1) {
                }
                richMsg$PicRec2.uint32_show_len.set(i29);
                richMsg$PicRec2.uint32_download_len.set(i28);
                richMsg$PicRec2.uint32_image_type.set(i37);
                if (im_msg_body_notonlineimage2.bytes_pb_reserve.has()) {
                }
                MessageForPic messageForPic2 = (MessageForPic) q.d(-2000);
                if (z16) {
                }
                messageForPic2.msgtype = -2000;
                messageForPic2.msgData = richMsg$PicRec2.toByteArray();
                messageForPic2.parse();
                list.add(messageForPic2);
                return;
            }
            if (QLog.isColorLevel()) {
                sb5.append("serverPath is null or empty string : " + str);
            }
            msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
            long j16 = msg_comm_msghead.msg_seq.get();
            long j17 = msg_comm_msghead.msg_uid.get();
            long j18 = msg_comm_msghead.msg_time.get();
            long j19 = msg_comm_msghead.from_uin.get();
            long j26 = msg_comm_msghead.to_uin.get();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", String.valueOf(10002));
            hashMap.put("fromUin", String.valueOf(j19));
            hashMap.put("toUin", String.valueOf(j26));
            hashMap.put("msgSeq", String.valueOf(j16));
            hashMap.put(AppConstants.Key.COLUMN_MSG_UID, String.valueOf(j17));
            hashMap.put("msgtime", String.valueOf(j18));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(i1().getCurrentAccountUin(), StatisticCollector.MESSAGE_EVENT, false, 0L, 0L, hashMap, "");
        }
        str = stringUtf8;
        if (str == null) {
        }
        if (QLog.isColorLevel()) {
        }
        msg_comm$MsgHead msg_comm_msghead2 = msg_comm_msg.msg_head.get();
        long j162 = msg_comm_msghead2.msg_seq.get();
        long j172 = msg_comm_msghead2.msg_uid.get();
        long j182 = msg_comm_msghead2.msg_time.get();
        long j192 = msg_comm_msghead2.from_uin.get();
        long j262 = msg_comm_msghead2.to_uin.get();
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("param_FailCode", String.valueOf(10002));
        hashMap2.put("fromUin", String.valueOf(j192));
        hashMap2.put("toUin", String.valueOf(j262));
        hashMap2.put("msgSeq", String.valueOf(j162));
        hashMap2.put(AppConstants.Key.COLUMN_MSG_UID, String.valueOf(j172));
        hashMap2.put("msgtime", String.valueOf(j182));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(i1().getCurrentAccountUin(), StatisticCollector.MESSAGE_EVENT, false, 0L, 0L, hashMap2, "");
    }

    private void I(msg_comm$Msg msg_comm_msg, long j3, boolean z16) {
        if (!z16) {
            return;
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) i1().getRuntimeService(ITroopInfoService.class, "");
        if (!msg_comm_msg.msg_head.group_info.has()) {
            return;
        }
        long j16 = msg_comm_msg.msg_head.group_info.group_code.get();
        if (iTroopInfoService.findTroopInfo(String.valueOf(j16)) == null) {
            return;
        }
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateAssociatePubAccount(String.valueOf(j16), j3);
        i1().getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER).notifyUI(com.tencent.mobileqq.troop.onlinepush.api.b.TYPE_NOTIFY_UPDATE_TITLE_BTN_CALL, true, new Object[]{Long.valueOf(j16)});
    }

    private int I0(im_msg_body$CommonElem im_msg_body_commonelem) {
        if (im_msg_body_commonelem.uint32_business_type.has()) {
            return im_msg_body_commonelem.uint32_business_type.get();
        }
        return 0;
    }

    @Nullable
    private im_msg_body$GeneralFlags J(List<im_msg_body$Elem> list) {
        im_msg_body$GeneralFlags im_msg_body_generalflags = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.general_flags.has()) {
                im_msg_body_generalflags = im_msg_body_elem.general_flags.get();
            }
        }
        return im_msg_body_generalflags;
    }

    @Nullable
    private im_msg_body$CommonElem J0(List<im_msg_body$Elem> list) {
        im_msg_body$CommonElem im_msg_body_commonelem = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.common_elem.has()) {
                im_msg_body_commonelem = im_msg_body_elem.common_elem.get();
            }
        }
        return im_msg_body_commonelem;
    }

    @Nullable
    private im_msg_body$GroupPubAccountInfo K(List<im_msg_body$Elem> list) {
        im_msg_body$GroupPubAccountInfo im_msg_body_grouppubaccountinfo = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.group_pub_acc_info.has() && im_msg_body_elem.group_pub_acc_info.uint64_pub_account.has()) {
                im_msg_body_grouppubaccountinfo = im_msg_body_elem.group_pub_acc_info.get();
            }
        }
        return im_msg_body_grouppubaccountinfo;
    }

    private void L(List<im_msg_body$Elem> list, PAMessage pAMessage) {
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.elem_flags2.has() && im_msg_body_elem.elem_flags2.get().uint64_msg_id.has()) {
                pAMessage.mMsgId = im_msg_body_elem.elem_flags2.get().uint64_msg_id.get();
            }
        }
    }

    private void N(long j3, Boolean bool, long j16, MessageForStructing messageForStructing) {
        if (AppConstants.NEW_KANDIAN_UIN_LONGVALUE == j16 || AppConstants.KANDIAN_SUBSCRIBE_UIN_LONGVALUE == j16 || AppConstants.WEISHI_UIN_LONGVALUE == j16 || AppConstants.KANDIAN_DAILY_UIN_LONGVALUE == j16) {
            AbsStructMsg absStructMsg = messageForStructing.structingMsg;
            if (absStructMsg instanceof AbsShareMsg) {
                ((AbsShareMsg) absStructMsg).clearItems();
                messageForStructing.extInt = 1;
                messageForStructing.extLong = 1;
                if (QLog.isColorLevel()) {
                    QLog.d("MessagePBElemDecoder", 2, "decode structMsg form XIN_KANDIAN, items = " + ((AbsShareMsg) messageForStructing.structingMsg).getStructMsgItemLists().size());
                }
            }
        }
    }

    private boolean O(List<MessageRecord> list, im_msg_body$GeneralFlags im_msg_body_generalflags, im_msg_body$Text im_msg_body_text, MessageForStructing messageForStructing, long j3) {
        MessageForTroopPobing messageForTroopPobing = (MessageForTroopPobing) q.d(MessageRecord.MSG_TYPE_TROOP_NEWER_POBING);
        messageForTroopPobing.msgtype = MessageRecord.MSG_TYPE_TROOP_NEWER_POBING;
        StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) messageForStructing.structingMsg;
        if (TextUtils.isEmpty(structMsgForGeneralShare.mCompatibleText) && im_msg_body_text != null && im_msg_body_text.str.has()) {
            structMsgForGeneralShare.mCompatibleText = im_msg_body_text.str.get().toStringUtf8();
        }
        if (im_msg_body_generalflags != null && im_msg_body_generalflags.bytes_pb_reserve.has()) {
            try {
                generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                generalflags_resvattr.mergeFrom(im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
                if (generalflags_resvattr.uint32_troop_pobing_template.has() && generalflags_resvattr.uint32_troop_pobing_template.get() > 0) {
                    structMsgForGeneralShare.pobingTemplateId = generalflags_resvattr.uint32_troop_pobing_template.get();
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("MessagePBElemDecoder", 1, "decode uint32_troop_pobing_template fail: ", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessagePBElemDecoder", 2, "uint32_troop_pobing_template: " + structMsgForGeneralShare.pobingTemplateId);
        }
        messageForTroopPobing.structingMsg = structMsgForGeneralShare;
        messageForTroopPobing.doPrewrite();
        messageForTroopPobing.doParse();
        if (TextUtils.isEmpty(structMsgForGeneralShare.mCompatibleText)) {
            messageForTroopPobing.doParse();
            structMsgForGeneralShare.mCompatibleText = MessageForTroopPobing.buildCompatibleText();
            messageForTroopPobing.doPrewrite();
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqstory.share", 2, "recv storyMsg, mCompatibleText isEmpty, rebuild:" + structMsgForGeneralShare.mCompatibleText);
            }
        }
        list.add(messageForTroopPobing);
        messageForStructing.structingMsg = null;
        new com.tencent.mobileqq.statistics.q(i1()).i("dc00899").a("Grp_AIO").f("newman_join").d("exp_obj").b(j3 + "").g();
        new com.tencent.mobileqq.statistics.q(i1()).i("dc00899").a("Grp_AIO").f("newman_join").d("exp_welcome").b(j3 + "", "", "" + TroopUtils.c(i1(), String.valueOf(j3))).g();
        return true;
    }

    private boolean P(msg_comm$Msg msg_comm_msg) {
        int i3;
        if (msg_comm_msg.msg_head.c2c_tmp_msg_head.service_type.has() && ((i3 = msg_comm_msg.msg_head.c2c_tmp_msg_head.service_type.get()) == 129 || i3 == 140 || i3 == 142)) {
            return true;
        }
        return false;
    }

    private boolean Q(List<MessageRecord> list, long j3, MessageForStructing messageForStructing) {
        MessageForVIPDonate u16;
        MessageForQQWalletMsg createQQWalletMsg;
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        if (!(absStructMsg instanceof StructMsgForGeneralShare)) {
            return false;
        }
        String str = ((StructMsgForGeneralShare) absStructMsg).mWarningTips;
        if (!TextUtils.isEmpty(str)) {
            messageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", str);
        }
        if (((StructMsgForGeneralShare) messageForStructing.structingMsg).isPayMessage()) {
            messageForStructing.saveExtInfoToExtStr("pa_pay_message", "1");
        }
        String str2 = ((StructMsgForGeneralShare) messageForStructing.structingMsg).mPARedPacket;
        if (!TextUtils.isEmpty(str2) && (createQQWalletMsg = MessageForQQWalletMsg.createQQWalletMsg(str2, i1().getCurrentAccountUin())) != null) {
            list.add(createQQWalletMsg);
            return true;
        }
        AbsStructMsg absStructMsg2 = messageForStructing.structingMsg;
        if (absStructMsg2.mMsgServiceID == 74) {
            String str3 = ((StructMsgForGeneralShare) absStructMsg2).mVipDonateStr;
            if (!TextUtils.isEmpty(str3) && (u16 = u(str3, String.valueOf(j3).equals(i1().getCurrentAccountUin()))) != null) {
                list.add(u16);
                return true;
            }
        }
        return false;
    }

    private long R(List<MessageRecord> list, msg_comm$Msg msg_comm_msg, long j3, MessageForStructing messageForStructing) {
        if (QLog.isColorLevel()) {
            QLog.d(NearbyFlowerManager.class.getSimpleName(), 2, "Received flower message");
        }
        return j3;
    }

    private void S(im_msg_body$GeneralFlags im_msg_body_generalflags, MessageForStructing messageForStructing, boolean z16) {
        if (z16 || messageForStructing.structingMsg.sourceAccoutType != 0) {
            messageForStructing.saveExtInfoToExtStr("accostType", String.valueOf(AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA));
            if (TextUtils.isEmpty(messageForStructing.structingMsg.mMsgBrief) || messageForStructing.structingMsg.mEmptyMsgBriefModified) {
                messageForStructing.structingMsg.mMsgBrief = AbsStructMsg.PA_DEFAULT_MSG_BRIEF;
            }
            ((IQWalletGdtAdApi) QRoute.api(IQWalletGdtAdApi.class)).handlePubTailMsg(im_msg_body_generalflags, messageForStructing);
        }
    }

    private void S0(im_msg_body$GeneralFlags im_msg_body_generalflags, List<MessageRecord> list) {
        boolean z16 = false;
        String str = null;
        if (im_msg_body_generalflags != null && im_msg_body_generalflags.bytes_pb_reserve.has()) {
            try {
                generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                generalflags_resvattr.mergeFrom(im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
                if (generalflags_resvattr.bytes_kpl_info.has() && generalflags_resvattr.bytes_kpl_info.has()) {
                    z16 = true;
                    str = generalflags_resvattr.bytes_kpl_info.get().toStringUtf8();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(KplRoleInfo.KPL_TAG, 2, "parse proto catch exception about kpl");
                }
                e16.printStackTrace();
            }
        }
        if (z16) {
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext()) {
                it.next().saveExtInfoToExtStr(KplRoleInfo.MSG_EXT_KEY, "Y");
            }
            if (QLog.isColorLevel()) {
                QLog.d(KplRoleInfo.KPL_TAG, 2, "resv a kpl pic message !");
            }
            KplHelper.handleKplFlag(i1(), str);
        }
    }

    private void T(List<im_msg_body$Elem> list, MessageForStructing messageForStructing) {
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (it.hasNext() && !r1(messageForStructing, it.next())) {
        }
    }

    private void T0(List<MessageRecord> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, byte[] bArr, com.tencent.mobileqq.troop.data.c cVar, AtTroopMemberInfo atTroopMemberInfo) {
        boolean z16;
        byte[] bArr2;
        boolean z17 = false;
        if (list.size() > 1) {
            Iterator<MessageRecord> it = list.iterator();
            int i3 = 0;
            boolean z18 = false;
            while (it.hasNext()) {
                int i16 = it.next().msgtype;
                if ((i16 == -1000 || i16 == -1049) && !z18) {
                    i3++;
                    z18 = true;
                } else if (i16 == -2000) {
                    i3++;
                }
                if (i3 >= 2) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (msg_comm_msg.msg_head.from_uin.has()) {
            long j3 = msg_comm_msg.msg_head.from_uin.get();
            if (TextUtils.equals(i1().getCurrentAccountUin(), Long.toString(j3)) || (cVar != null && cVar.f294892b == 10014 && TextUtils.equals(((IGPSService) i1().getRuntimeService(IGPSService.class, "")).getSelfTinyId(), Long.toString(j3)))) {
                z17 = true;
            }
        }
        if (z16) {
            ArrayList arrayList = new ArrayList();
            Iterator<MessageRecord> it5 = list.iterator();
            while (true) {
                bArr2 = null;
                if (!it5.hasNext()) {
                    break;
                }
                MessageRecord next = it5.next();
                int i17 = next.msgtype;
                if (i17 != -1000 && i17 != -1049 && i17 != -2000) {
                    if (arrayList.size() > 0) {
                        if (!z17) {
                            bArr2 = bArr;
                        }
                        list2.add(p.G(arrayList, bArr2, cVar));
                        arrayList.clear();
                    }
                    list2.add(next);
                } else {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                if (!z17) {
                    bArr2 = bArr;
                }
                MessageRecord G = p.G(arrayList, bArr2, cVar);
                list2.add(G);
                ((MessageForMixedMsg) G).mAtInfo = atTroopMemberInfo;
                arrayList.clear();
                return;
            }
            return;
        }
        if (bArr == null) {
            list2.addAll(list);
            return;
        }
        for (MessageRecord messageRecord : list) {
            if ((messageRecord instanceof MessageForText) && !z17) {
                messageRecord.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.bytes2HexStr(bArr));
            }
            list2.add(messageRecord);
        }
    }

    private void U(List<im_msg_body$Elem> list, MessageForStructing messageForStructing) {
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.life_online.has() && im_msg_body_elem.life_online.get().uint32_report.has() && im_msg_body_elem.life_online.get().uint32_report.get() == 1 && im_msg_body_elem.life_online.get().uint64_unique_id.has()) {
                messageForStructing.structingMsg.msgId = im_msg_body_elem.life_online.get().uint64_unique_id.get();
            }
        }
    }

    private void U0(List<im_msg_body$Elem> list, StringBuilder sb5, AtTroopMemberInfo atTroopMemberInfo, List<MessageRecord> list2, aa aaVar, com.tencent.mobileqq.troop.data.c cVar) {
        MessageForReplyText.SourceMsgInfo I1 = I1(list, sb5);
        if (I1 == null) {
            return;
        }
        MessageForReplyText messageForReplyText = (MessageForReplyText) q.d(MessageRecord.MSG_TYPE_REPLY_TEXT);
        H(I1, messageForReplyText);
        MessageForReplyText G = G(atTroopMemberInfo, list2, aaVar, cVar, messageForReplyText);
        if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "sb.length == 0");
        }
        if (G != null) {
            list2.add(0, G);
        }
    }

    private void V(MessageForStructing messageForStructing) {
        String f16 = f1(messageForStructing);
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007238", "0X8007238", 0, 0, f16, "", "", "");
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8007238", "", f16, "", "", "");
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        absStructMsg.mMsgActionData = v(absStructMsg.mMsgActionData);
    }

    private boolean W(List<MessageRecord> list, im_msg_body$Text im_msg_body_text, MessageForStructing messageForStructing) {
        if (com.tencent.biz.qqstory.base.b.c()) {
            MessageForQQStory messageForQQStory = (MessageForQQStory) q.d(MessageRecord.MSG_TYPE_QQSTORY);
            messageForQQStory.msgtype = MessageRecord.MSG_TYPE_QQSTORY;
            StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) messageForStructing.structingMsg;
            if (TextUtils.isEmpty(structMsgForGeneralShare.mCompatibleText) && im_msg_body_text != null && im_msg_body_text.str.has()) {
                structMsgForGeneralShare.mCompatibleText = im_msg_body_text.str.get().toStringUtf8();
            }
            messageForQQStory.structingMsg = structMsgForGeneralShare;
            messageForQQStory.doPrewrite();
            if (TextUtils.isEmpty(structMsgForGeneralShare.mCompatibleText)) {
                messageForQQStory.doParse();
                structMsgForGeneralShare.mCompatibleText = MessageForQQStory.buildCompatibleText(messageForQQStory.authorName, messageForQQStory.brief, messageForQQStory.srcName);
                messageForQQStory.doPrewrite();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.qqstory.share", 2, "recv storyMsg, mCompatibleText isEmpty, rebuild:" + structMsgForGeneralShare.mCompatibleText);
                }
            }
            list.add(messageForQQStory);
            messageForStructing.structingMsg = null;
            return true;
        }
        messageForStructing.structingMsg = null;
        if (im_msg_body_text != null) {
            im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(com.tencent.biz.qqstory.base.b.a()));
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.share", 2, "recv storyMsg, isSDKAPISupportStory==false, txtMsg==null");
            return false;
        }
        return false;
    }

    private void X(MessageForStructing messageForStructing) {
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        if (absStructMsg instanceof StructMsgForGeneralShare) {
            StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) absStructMsg;
            bt2.a.a().f(structMsgForGeneralShare.animResId, null);
            bt2.a.a().e(structMsgForGeneralShare.atMembers);
        }
    }

    private boolean Y(List<MessageRecord> list, im_msg_body$Text im_msg_body_text, MessageForStructing messageForStructing) {
        MessageForTribeShortVideo messageForTribeShortVideo = (MessageForTribeShortVideo) q.d(MessageRecord.MSG_TYPE_TRIBE_SHORT_VIDEO);
        messageForTribeShortVideo.msgtype = MessageRecord.MSG_TYPE_TRIBE_SHORT_VIDEO;
        StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) messageForStructing.structingMsg;
        if (TextUtils.isEmpty(structMsgForGeneralShare.mCompatibleText) && im_msg_body_text != null && im_msg_body_text.str.has()) {
            structMsgForGeneralShare.mCompatibleText = im_msg_body_text.str.get().toStringUtf8();
        }
        messageForTribeShortVideo.structingMsg = structMsgForGeneralShare;
        messageForTribeShortVideo.doPrewrite();
        if (TextUtils.isEmpty(structMsgForGeneralShare.mCompatibleText)) {
            messageForTribeShortVideo.doParse();
            structMsgForGeneralShare.mCompatibleText = MessageForTribeShortVideo.buildCompatibleText();
            messageForTribeShortVideo.doPrewrite();
            if (QLog.isColorLevel()) {
                QLog.d("MessagePBElemDecoder", 2, "recv shortVideoMsg, mCompatibleText isEmpty, rebuild:" + structMsgForGeneralShare.mCompatibleText);
            }
        }
        list.add(messageForTribeShortVideo);
        messageForStructing.structingMsg = null;
        return true;
    }

    private boolean Z(List<MessageRecord> list, byte[] bArr, MessageForStructing messageForStructing, long j3, int i3) {
        MessageForTroopFee messageForTroopFee = (MessageForTroopFee) q.d(MessageRecord.MSG_TYPE_TROOP_FEE);
        MessageForTroopFee decodeMsgFromXmlBuff = MessageForTroopFee.decodeMsgFromXmlBuff(i1(), i3, j3, bArr, -1);
        if (decodeMsgFromXmlBuff != null) {
            messageForTroopFee.copyFrom(decodeMsgFromXmlBuff);
        }
        messageForTroopFee.msgtype = MessageRecord.MSG_TYPE_TROOP_FEE;
        messageForTroopFee.f203106msg = messageForTroopFee.getSummaryMsg();
        messageForTroopFee.msgData = messageForTroopFee.getBytes();
        list.add(messageForTroopFee);
        messageForStructing.structingMsg = null;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_FEE, 2, "Troop Fee has decode suceess" + messageForTroopFee.getSummaryMsg());
            return true;
        }
        return true;
    }

    private boolean a0(List<MessageRecord> list, MessageForStructing messageForStructing) {
        MessageForTroopSign messageForTroopSign = (MessageForTroopSign) q.d(MessageRecord.MSG_TYPE_TROOP_SIGN);
        messageForTroopSign.msgtype = MessageRecord.MSG_TYPE_TROOP_SIGN;
        StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) messageForStructing.structingMsg;
        messageForTroopSign.structingMsg = structMsgForGeneralShare;
        messageForTroopSign.f203106msg = structMsgForGeneralShare.mMsgBrief;
        messageForTroopSign.doPrewrite();
        list.add(messageForTroopSign);
        messageForStructing.structingMsg = null;
        return true;
    }

    private void a1(List<MessageRecord> list, msg_comm$Msg msg_comm_msg, im_msg_body$TransElem im_msg_body_transelem, byte[] bArr, com.tencent.mobileqq.service.message.a aVar) {
        int size = im_msg_body_transelem.elem_value.get().size();
        int i3 = 0;
        int i16 = 0;
        while (size > 3) {
            int i17 = i16 + 1;
            if (i16 <= 100) {
                byte b16 = bArr[i3];
                int shortData = PkgTools.getShortData(bArr, i3 + 1);
                int i18 = shortData + 3;
                size -= i18;
                int i19 = i18 + i3;
                if (b16 == 1) {
                    byte[] bArr2 = new byte[shortData];
                    PkgTools.copyData(bArr2, 0, bArr, i3 + 3, shortData);
                    try {
                        obj_msg$ObjMsg mergeFrom = new obj_msg$ObjMsg().mergeFrom(bArr2);
                        if (mergeFrom.uint32_msg_type.get() == 6) {
                            MessageForFile messageForFile = (MessageForFile) q.d(-2005);
                            ((IGuildFileTempApi) QRoute.api(IGuildFileTempApi.class)).handleGuildFileMsg(i1(), mergeFrom, messageForFile, msg_comm_msg, aVar);
                            list.add(messageForFile);
                            return;
                        }
                    } catch (Exception unused) {
                    }
                }
                i16 = i17;
                i3 = i19;
            } else {
                return;
            }
        }
    }

    private boolean b0(List<MessageRecord> list, byte[] bArr, long j3, int i3) {
        MessageForStarLeague decodeMsgFromXmlBuff = MessageForStarLeague.decodeMsgFromXmlBuff(i1(), i3, j3, bArr, -1);
        if (decodeMsgFromXmlBuff != null) {
            decodeMsgFromXmlBuff.msgData = decodeMsgFromXmlBuff.getBytes();
            decodeMsgFromXmlBuff.f203106msg = decodeMsgFromXmlBuff.getSummaryMsg();
            list.add(decodeMsgFromXmlBuff);
            return true;
        }
        return true;
    }

    private void b1(List<im_msg_body$Elem> list, List<MessageRecord> list2, msg_comm$Msg msg_comm_msg, im_msg_body$TransElem im_msg_body_transelem, im_msg_body$GeneralFlags im_msg_body_generalflags, int i3, byte[] bArr) {
        if (i3 != 3) {
            if (i3 != 16) {
                if (i3 == 24) {
                    A0(list2, msg_comm_msg, im_msg_body_transelem, bArr);
                    return;
                }
                return;
            }
            w0(list, list2, msg_comm_msg, im_msg_body_generalflags, bArr);
            return;
        }
        B0(list2);
    }

    private boolean c0(List<im_msg_body$Elem> list, MessageForStructing messageForStructing, String str) {
        String str2;
        String str3;
        String str4;
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessagePBElemDecoder", 2, "decodePBMsgElems_RichMsg longMsgResId=", str);
        }
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            str2 = "";
            if (!it.hasNext()) {
                str3 = "";
                break;
            }
            im_msg_body$Elem next = it.next();
            if (next.pub_acc_info.has()) {
                if (next.pub_acc_info.string_long_msg_url.get() == null) {
                    str4 = "";
                } else {
                    str4 = next.pub_acc_info.string_long_msg_url.get();
                }
                ByteStringMicro byteStringMicro = next.pub_acc_info.bytes_download_key.get();
                if (byteStringMicro != null) {
                    str2 = StructLongMessageDownloadProcessor.bytesToHexString(byteStringMicro.toByteArray());
                }
                String str5 = str2;
                str2 = str4;
                str3 = str5;
            }
        }
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3) || StringUtil.isEmpty(str)) {
            return false;
        }
        messageForStructing.saveExtInfoToExtStr("pub_long_msg_url", str2);
        messageForStructing.saveExtInfoToExtStr("pub_long_msg_download_key", str3);
        messageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", str);
        return true;
    }

    private void d0(msg_comm$Msg msg_comm_msg, byte[] bArr, MessageForStructing messageForStructing, String str, boolean z16, ab abVar) {
        int length;
        if (abVar.f286173a == 1008 && QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("msgId=uniseq:");
            sb5.append(messageForStructing.uniseq);
            sb5.append(", serviceType(Pa-129,140,142):");
            sb5.append(msg_comm_msg.msg_head.get().c2c_tmp_msg_head.get().service_type.get());
            sb5.append(", xmlContentLength:");
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            sb5.append(length);
            sb5.append(", longMsgResId:");
            sb5.append(str);
            sb5.append(", isPaNewLongMsg:");
            sb5.append(z16);
            QLog.d(StructLongMessageDownloadProcessor.PA_OLD_LONG_MSG_TAG, 2, sb5.toString());
        }
    }

    @NonNull
    private String e0(ByteStringMicro byteStringMicro) {
        if (byteStringMicro != null) {
            return byteStringMicro.toStringUtf8();
        }
        return "";
    }

    private byte[] f0(im_msg_body$GeneralFlags im_msg_body_generalflags, byte[] bArr, MessageForStructing messageForStructing, long j3, int i3, String str, boolean z16, ab abVar) {
        int i16;
        byte[] bArr2 = bArr;
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("MessagePBElemDecoder", 2, "begin getEmptyGeneralStructMsg");
            }
            messageForStructing.structingMsg = (StructMsgForGeneralShare) com.tencent.mobileqq.structmsg.i.c();
        } else if (bArr2 != null && bArr2.length != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MessagePBElemDecoder", 2, "begin getStructMsgFromXmlBuff: type=", Integer.valueOf(i3), ", code=", Long.valueOf(j3));
            }
            byte[] c16 = a23.a.c(bArr, im_msg_body_generalflags, -1);
            if (c16 != null) {
                bArr2 = c16;
                i16 = 0;
            } else {
                i16 = -1;
            }
            messageForStructing.structingMsg = com.tencent.mobileqq.structmsg.i.f(i1(), i3, j3, bArr2, i16);
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "StructMsg = " + messageForStructing.structingMsg);
            }
        } else if (abVar.f286173a == 1008 && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(StructLongMessageDownloadProcessor.PA_OLD_LONG_MSG_TAG, 2, "msgId=uniseq:" + messageForStructing.uniseq + ", begin getEmptyGeneralStructMsg for PA oldLongMsg!");
            }
            messageForStructing.structingMsg = (StructMsgForGeneralShare) com.tencent.mobileqq.structmsg.i.c();
            messageForStructing.saveExtInfoToExtStr("pub_old_long_msg", "1");
            messageForStructing.saveExtInfoToExtStr("pub_long_msg_resid", str);
            messageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
        }
        return bArr2;
    }

    @NotNull
    private String f1(MessageForStructing messageForStructing) {
        String str;
        if (TextUtils.isEmpty(messageForStructing.structingMsg.mMsgUrl)) {
            return "";
        }
        try {
            str = Uri.parse(messageForStructing.structingMsg.mMsgUrl).getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
        } catch (Exception e16) {
            e16.printStackTrace();
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private byte[] g0(im_msg_body$RichMsg im_msg_body_richmsg) {
        if (im_msg_body_richmsg.bytes_template_1.has()) {
            return im_msg_body_richmsg.bytes_template_1.get().toByteArray();
        }
        return null;
    }

    private void h0(boolean z16, int i3, ChatMessage chatMessage) {
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("MessagePBElemDecoder", 2, "decodePBMsgElems, isBlessMsg: true ,updateFlag: " + i3);
            }
            boolean z17 = true;
            chatMessage.isBlessMsg = true;
            if (i3 > -1) {
                if ((i3 & 1) != 1) {
                    z17 = false;
                }
                chatMessage.needUpdateMsgTag = z17;
            }
        }
    }

    private static PAMessage h1(String str) {
        return (PAMessage) ((IPublicAccountMessageUtil) QRoute.api(IPublicAccountMessageUtil.class)).fromXML(str);
    }

    private int i0(List<im_msg_body$Elem> list) {
        int i3 = -1;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.bless_msg.has() && im_msg_body_elem.bless_msg.uint32_msg_type.get() == 1 && im_msg_body_elem.bless_msg.uint32_ex_flag.has()) {
                i3 = im_msg_body_elem.bless_msg.uint32_ex_flag.get();
            }
        }
        return i3;
    }

    public static byte[] j1(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                byte[] bArr2 = new byte[1024];
                while (!inflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                }
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e17) {
                e17.printStackTrace();
                byteArrayOutputStream.close();
            }
            inflater.end();
            return bArr;
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e18) {
                e18.printStackTrace();
            }
            throw th5;
        }
    }

    private boolean k0(List<im_msg_body$Elem> list) {
        boolean z16 = false;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.bless_msg.has() && im_msg_body_elem.bless_msg.uint32_msg_type.get() == 1) {
                z16 = true;
            }
        }
        return z16;
    }

    private void k1(im_msg_body$GeneralFlags im_msg_body_generalflags, boolean z16, String str, List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, boolean z17) {
        String s16 = s(list, list2, false);
        MessageForArkApp messageForArkApp = (MessageForArkApp) q.d(MessageRecord.MSG_TYPE_ARK_APP);
        messageForArkApp.msgtype = MessageRecord.MSG_TYPE_ARK_APP;
        if (s16 != null) {
            messageForArkApp.compatibleMsg = s16;
        }
        if (im_msg_body_generalflags != null && im_msg_body_generalflags.bytes_pb_reserve.has()) {
            try {
                generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                generalflags_resvattr.mergeFrom(im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
                if (generalflags_resvattr.bytes_oac_msg_extend.has()) {
                    messageForArkApp.saveExtInfoToExtStr(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND, generalflags_resvattr.bytes_oac_msg_extend.get().toStringUtf8());
                }
                if (generalflags_resvattr.uint32_service_msg_type.has()) {
                    String optString = new JSONObject(str).optString("appid");
                    if (!TextUtils.isEmpty(optString)) {
                        messageForArkApp.saveExtInfoToExtStr("appid", optString);
                    }
                }
            } catch (Throwable th5) {
                QLog.e("MessagePBElemDecoder", 2, "decodePBMsgElems_ArkApp() parse generalflags error! " + QLog.getStackTraceString(th5));
            }
        }
        ArkAppMessage arkAppMessage = new ArkAppMessage();
        arkAppMessage.fromAppXml(str);
        arkAppMessage.updateMultiInfo("", messageForArkApp.uniseq);
        messageForArkApp.msgData = arkAppMessage.toBytes();
        messageForArkApp.parse();
        boolean z18 = true;
        if (!TextUtils.isEmpty(messageForArkApp.ark_app_message.appName) && !TextUtils.isEmpty(messageForArkApp.ark_app_message.appView)) {
            if (z17) {
                messageForArkApp.saveExtInfoToExtStr("zplan_head_effect_msg_flag", ZPlanHeadEffectFlag.NOT_READ.toString());
            }
            list2.add(messageForArkApp);
        } else {
            QLog.i("MessagePBElemDecoder", 1, "decode msg, ark message is not valid..");
            z18 = z16;
        }
        if (!z18) {
            m(list, list2, sb5, msg_comm_msg, cVar);
        }
        m1(list, messageForArkApp, msg_comm_msg, cVar);
    }

    private void l0(im_msg_body$GeneralFlags im_msg_body_generalflags, ChatMessage chatMessage) {
        boolean z16 = false;
        String str = null;
        if (im_msg_body_generalflags != null && im_msg_body_generalflags.bytes_pb_reserve.has()) {
            try {
                generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                generalflags_resvattr.mergeFrom(im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
                if (generalflags_resvattr.bytes_kpl_info.has()) {
                    z16 = true;
                    str = generalflags_resvattr.bytes_kpl_info.get().toStringUtf8();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(KplRoleInfo.KPL_TAG, 2, "parse proto catch exception about kpl");
                }
                e16.printStackTrace();
            }
        }
        if (z16) {
            chatMessage.saveExtInfoToExtStr(KplRoleInfo.MSG_EXT_KEY, "Y");
            if (QLog.isColorLevel()) {
                QLog.d(KplRoleInfo.KPL_TAG, 2, "resv a kpl text message !");
            }
            KplHelper.handleKplFlag(i1(), str);
        }
    }

    private void l1(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, MessageForAioGift messageForAioGift) {
        im_msg_body$Elem im_msg_body_elem;
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body_elem = it.next();
                if (im_msg_body_elem.text.has()) {
                    break;
                }
            } else {
                im_msg_body_elem = null;
                break;
            }
        }
        o1(messageForAioGift, msg_comm_msg, cVar, im_msg_body_elem);
    }

    private boolean m0(im_msg_body$GeneralFlags im_msg_body_generalflags) {
        if (im_msg_body_generalflags != null && (im_msg_body_generalflags.long_text_flag.get() == 2 || im_msg_body_generalflags.long_text_flag.get() == 1 || (com.tencent.mobileqq.multimsg.i.l() && im_msg_body_generalflags.long_text_flag.get() == 3))) {
            if (!QLog.isColorLevel()) {
                return true;
            }
            QLog.d("MessagePBElemDecoder", 2, "decodePBMsgElems_Text, longTextFlag: true");
            return true;
        }
        return false;
    }

    private void m1(List<im_msg_body$Elem> list, MessageForArkApp messageForArkApp, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        im_msg_body$Elem im_msg_body_elem;
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body_elem = it.next();
                if (im_msg_body_elem.text.has()) {
                    break;
                }
            } else {
                im_msg_body_elem = null;
                break;
            }
        }
        if (im_msg_body_elem != null && t1(messageForArkApp)) {
            o1(messageForArkApp, msg_comm_msg, cVar, im_msg_body_elem);
        }
    }

    private int n0(List<im_msg_body$Elem> list) {
        int i3 = 0;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.elem_flags2.has() && im_msg_body_elem.elem_flags2.uint32_msg_rpt_cnt.has()) {
                i3 = im_msg_body_elem.elem_flags2.uint32_msg_rpt_cnt.get();
            }
        }
        return i3;
    }

    private boolean n1(List<MessageRecord> list, boolean z16, MessageForStructing messageForStructing, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        ArrayList<AbsStructMsgElement> arrayList;
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("MessagePBElemDecoder", 2, "decodePBMsgElems_RichMsg need to pull longtextmsg!");
            }
            try {
                if (messageForStructing.structingMsg instanceof AbsShareMsg) {
                    ChatMessage chatMessage = (ChatMessage) q.d(MessageRecord.MSG_TYPE_STRUCT_LONG_TEXT);
                    chatMessage.saveExtInfoToExtStr("long_text_recv_state", "3");
                    chatMessage.saveExtInfoToExtStr("long_text_msg_resid", messageForStructing.structingMsg.mResid);
                    if (com.tencent.mobileqq.multimsg.i.l() && im_msg_body_generalflags != null && im_msg_body_generalflags.long_text_flag.get() == 3) {
                        chatMessage.saveExtInfoToExtStr("msg_expired", "1");
                    }
                    List<AbsStructMsgElement> structMsgItemLists = ((AbsShareMsg) messageForStructing.structingMsg).getStructMsgItemLists();
                    if (structMsgItemLists != null) {
                        for (AbsStructMsgElement absStructMsgElement : structMsgItemLists) {
                            if ((absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a) && (arrayList = ((com.tencent.mobileqq.structmsg.a) absStructMsgElement).U0) != null) {
                                Iterator<AbsStructMsgElement> it = arrayList.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        AbsStructMsgElement next = it.next();
                                        if (next instanceof StructMsgItemTitle) {
                                            chatMessage.f203106msg = ((StructMsgItemTitle) next).t();
                                            if (QLog.isDevelopLevel()) {
                                                QLog.d("MessagePBElemDecoder", 2, "longtextmsg getMsg from structMsg msg:" + chatMessage.f203106msg);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    list.add(chatMessage);
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MessagePBElemDecoder", 2, "absShareMsg is null");
                    return false;
                }
                return false;
            } catch (Exception e16) {
                QLog.d("MessagePBElemDecoder", 1, "failed to pull longtextmsg exception!", e16);
                return false;
            }
        }
        return false;
    }

    private void o0(int i3, ChatMessage chatMessage) {
        if (i3 > 0) {
            chatMessage.setRepeatCount(i3);
            if (QLog.isColorLevel()) {
                QLog.d("MessagePBElemDecoder", 2, "MessageForText ====> repeatCount = " + chatMessage.getRepeatCount());
            }
        }
    }

    private void o1(ChatMessage chatMessage, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, im_msg_body$Elem im_msg_body_elem) {
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        ArrayList<AtTroopMemberInfo> arrayList = new ArrayList<>();
        AtTroopMemberInfo atTroopMemberInfo = new AtTroopMemberInfo();
        AtTroopMemberInfo atTroopMemberInfo2 = new AtTroopMemberInfo();
        if (chatMessage != null && msg_comm_msg != null && cVar != null && im_msg_body_elem != null) {
            p(sb5, msg_comm_msg.msg_head.msg_seq.get(), cVar, arrayList, atTroopMemberInfo, atTroopMemberInfo2, null, sb6, false, im_msg_body_elem, msg_comm_msg.msg_head.msg_time.get()).i();
            if (!arrayList.isEmpty()) {
                com.tencent.mobileqq.troop.text.a.n(cVar.f294892b, arrayList, chatMessage);
            }
        }
    }

    private void p0(int i3, ChatMessage chatMessage) {
        if (chatMessage instanceof RecommendCommonMessage) {
            chatMessage.saveExtInfoToExtStr("ark_text_analysis_flag", String.valueOf(i3));
        }
    }

    private void q0(ChatMessage chatMessage) {
        if (chatMessage instanceof MessageForText) {
            ((ITroopRobotService) i1().getRuntimeService(ITroopRobotService.class, "all")).preProcessMessageMoreDetail(chatMessage);
        }
    }

    private Boolean q1(List<im_msg_body$Elem> list) {
        if (list != null && !list.isEmpty()) {
            for (im_msg_body$Elem im_msg_body_elem : list) {
                if (im_msg_body_elem.market_trans.has() || im_msg_body_elem.rich_msg.has()) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    private void r0(String str, ChatMessage chatMessage) {
        if (!TextUtils.isEmpty(str)) {
            chatMessage.saveExtInfoToExtStr("small_description", str);
        }
    }

    private boolean r1(MessageForStructing messageForStructing, im_msg_body$Elem im_msg_body_elem) {
        if (im_msg_body_elem.not_online_image.has()) {
            im_msg_body$NotOnlineImage im_msg_body_notonlineimage = im_msg_body_elem.not_online_image.get();
            StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) messageForStructing.structingMsg;
            structMsgForImageShare.thumbHeight = im_msg_body_notonlineimage.uint32_thumb_height.get();
            structMsgForImageShare.thumbWidth = im_msg_body_notonlineimage.uint32_thumb_width.get();
            structMsgForImageShare.width = im_msg_body_notonlineimage.pic_width.get();
            structMsgForImageShare.height = im_msg_body_notonlineimage.pic_height.get();
            structMsgForImageShare.thumbUrl = im_msg_body_notonlineimage.str_thumb_url.get();
            structMsgForImageShare.bigUrl = im_msg_body_notonlineimage.str_big_url.get();
            structMsgForImageShare.rawUrl = im_msg_body_notonlineimage.str_orig_url.get();
            if (im_msg_body_elem.not_online_image.bytes_pb_reserve.has()) {
                try {
                    NotOnlineImageExtPb$ResvAttr notOnlineImageExtPb$ResvAttr = new NotOnlineImageExtPb$ResvAttr();
                    notOnlineImageExtPb$ResvAttr.mergeFrom(im_msg_body_elem.not_online_image.bytes_pb_reserve.get().toByteArray());
                    structMsgForImageShare.mImageBizType = notOnlineImageExtPb$ResvAttr.uint32_image_biz_type.get();
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
            }
            return true;
        }
        if (im_msg_body_elem.custom_face.has()) {
            im_msg_body$CustomFace im_msg_body_customface = im_msg_body_elem.custom_face.get();
            StructMsgForImageShare structMsgForImageShare2 = (StructMsgForImageShare) messageForStructing.structingMsg;
            structMsgForImageShare2.thumbHeight = im_msg_body_customface.uint32_thumb_height.get();
            structMsgForImageShare2.thumbWidth = im_msg_body_customface.uint32_thumb_width.get();
            structMsgForImageShare2.width = im_msg_body_customface.uint32_width.get();
            structMsgForImageShare2.height = im_msg_body_customface.uint32_height.get();
            structMsgForImageShare2.rawUrl = im_msg_body_customface.str_orig_url.get();
            structMsgForImageShare2.thumbUrl = im_msg_body_customface.str_thumb_url.get();
            structMsgForImageShare2.bigUrl = im_msg_body_customface.str_big_url.get();
            structMsgForImageShare2.rawUrl = im_msg_body_customface.str_orig_url.get();
            if (im_msg_body_elem.custom_face.bytes_pb_reserve.has()) {
                try {
                    CustomFaceExtPb$ResvAttr customFaceExtPb$ResvAttr = new CustomFaceExtPb$ResvAttr();
                    customFaceExtPb$ResvAttr.mergeFrom(im_msg_body_elem.custom_face.bytes_pb_reserve.get().toByteArray());
                    structMsgForImageShare2.mImageBizType = customFaceExtPb$ResvAttr.uint32_image_biz_type.get();
                } catch (InvalidProtocolBufferMicroException e17) {
                    e17.printStackTrace();
                }
            }
            return true;
        }
        return false;
    }

    @Nullable
    private String s0(List<im_msg_body$Elem> list) {
        String str = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.text.has() && im_msg_body_elem.text.str.has()) {
                String stringUtf8 = im_msg_body_elem.text.str.get().toStringUtf8();
                if (stringUtf8.startsWith("[") && stringUtf8.endsWith("]")) {
                    str = HexUtil.bytes2HexStr(im_msg_body_elem.text.str.get().toByteArray());
                } else {
                    str = "";
                }
            }
        }
        return str;
    }

    private boolean s1(MessageForStructing messageForStructing) {
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        int i3 = absStructMsg.mMsgServiceID;
        if ((i3 == 83 || i3 == 108 || i3 == 114 || i3 == 116) && !TextUtils.isEmpty(absStructMsg.mMsgActionData)) {
            return true;
        }
        return false;
    }

    private int t0(List<im_msg_body$Elem> list) {
        int i3 = 0;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.text.has() && im_msg_body_elem.text.bytes_pb_reserve.has()) {
                try {
                    TextMsgExtPb$ResvAttr textMsgExtPb$ResvAttr = new TextMsgExtPb$ResvAttr();
                    textMsgExtPb$ResvAttr.mergeFrom(im_msg_body_elem.text.bytes_pb_reserve.get().toByteArray());
                    if (textMsgExtPb$ResvAttr.text_analysis_result.has()) {
                        i3 = textMsgExtPb$ResvAttr.text_analysis_result.get();
                    }
                } catch (Exception e16) {
                    QLog.e("MessagePBElemDecoder", 1, "parse TextMsgExtPb.ResvAttr error, ", e16);
                }
            }
        }
        return i3;
    }

    private boolean t1(MessageForArkApp messageForArkApp) {
        if (messageForArkApp == null) {
            return false;
        }
        return messageForArkApp.ark_app_message.appName.equals("com.tencent.channel.gift");
    }

    public static MessageForVIPDonate u(String str, boolean z16) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        if (TextUtils.isEmpty(str)) {
            QLog.e("MessagePBElemDecoder", 1, "content is empty ");
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessagePBElemDecoder", 2, "createVIPDonateMsg: msg = " + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            MessageForVIPDonate messageForVIPDonate = (MessageForVIPDonate) q.d(MessageRecord.MSG_TYPE_VIP_DONATE);
            messageForVIPDonate.msgtype = MessageRecord.MSG_TYPE_VIP_DONATE;
            VIPDonateMsg vIPDonateMsg = new VIPDonateMsg();
            if (jSONObject.has("title")) {
                str2 = jSONObject.getString("title");
            } else {
                str2 = null;
            }
            vIPDonateMsg.title = str2;
            if (jSONObject.has("footer")) {
                str3 = jSONObject.getString("footer");
            } else {
                str3 = null;
            }
            vIPDonateMsg.footer = str3;
            if (z16) {
                if (jSONObject.has("sendsubtitle")) {
                    str7 = jSONObject.getString("sendsubtitle");
                } else {
                    str7 = null;
                }
                vIPDonateMsg.subTitle = str7;
                if (jSONObject.has("sendurl")) {
                    str8 = jSONObject.getString("sendurl");
                } else {
                    str8 = null;
                }
                vIPDonateMsg.jumpUrl = str8;
                if (jSONObject.has("sendbrief")) {
                    str9 = jSONObject.getString("sendbrief");
                } else {
                    str9 = null;
                }
                vIPDonateMsg.brief = str9;
            } else {
                if (jSONObject.has("recvsubtitle")) {
                    str4 = jSONObject.getString("recvsubtitle");
                } else {
                    str4 = null;
                }
                vIPDonateMsg.subTitle = str4;
                if (jSONObject.has("recvurl")) {
                    str5 = jSONObject.getString("recvurl");
                } else {
                    str5 = null;
                }
                vIPDonateMsg.jumpUrl = str5;
                if (jSONObject.has("recvbrief")) {
                    str6 = jSONObject.getString("recvbrief");
                } else {
                    str6 = null;
                }
                vIPDonateMsg.brief = str6;
            }
            messageForVIPDonate.donateMsg = vIPDonateMsg;
            messageForVIPDonate.f203106msg = messageForVIPDonate.getSummaryMsg();
            messageForVIPDonate.msgData = MessagePkgUtils.getBytesFromObject(vIPDonateMsg);
            if (QLog.isColorLevel()) {
                QLog.d("vipdonateMsgparse", 2, "donateMsg = " + messageForVIPDonate.donateMsg);
            }
            return messageForVIPDonate;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("MessagePBElemDecoder", 1, "vipdonate json error :json = " + str);
            return null;
        }
    }

    @Nullable
    private im_msg_body$GeneralFlags u0(List<im_msg_body$Elem> list) {
        im_msg_body$GeneralFlags im_msg_body_generalflags = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.general_flags.has()) {
                im_msg_body_generalflags = im_msg_body_elem.general_flags.get();
            }
        }
        return im_msg_body_generalflags;
    }

    public static void u1(MessageForReplyText.SourceMsgInfo sourceMsgInfo, source_msg$ResvAttr source_msg_resvattr) {
        if (source_msg_resvattr.comment_refer.has()) {
            source_msg$CommentRefer source_msg_commentrefer = source_msg_resvattr.comment_refer.get();
            sourceMsgInfo.mRootMsgSeq = source_msg_commentrefer.root_seq.get();
            sourceMsgInfo.mParentMsgSeq = source_msg_commentrefer.parent_seq.get();
            QLog.e("MessagePBElemDecoder", 1, "parseCommentReferSeq  mRootMsgSeq:" + sourceMsgInfo.mRootMsgSeq + " mReferMsgSeq:" + source_msg_commentrefer.refer_seq.get());
        }
    }

    private static String v(String str) {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        while (i16 < str.length()) {
            if (str.charAt(i16) == 20 && (i3 = i16 + 2) < str.length()) {
                int i17 = i16 + 1;
                int charAt = (((str.charAt(i17) - 'A') * 128) + str.charAt(i3)) - 65;
                if (QLog.isColorLevel()) {
                    QLog.d("MessagePBElemDecoder", 2, "faceIndex:" + charAt);
                }
                int convertToLocal = QQSysFaceUtil.convertToLocal(charAt);
                if (convertToLocal >= 0) {
                    sb5.append(str.charAt(i16));
                    sb5.append((char) convertToLocal);
                }
                i16 = i17 + 1;
            } else {
                sb5.append(str.charAt(i16));
            }
            i16++;
        }
        return sb5.toString();
    }

    @Nullable
    private im_msg_body$TransElem v0(List<im_msg_body$Elem> list) {
        im_msg_body$TransElem im_msg_body_transelem = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.trans_elem_info.has()) {
                im_msg_body_transelem = im_msg_body_elem.trans_elem_info.get();
            }
        }
        return im_msg_body_transelem;
    }

    private MessageForDeliverGiftTips w(String str, String str2, im_msg_body$DeliverGiftMsg im_msg_body_delivergiftmsg, List<MessageRecord> list, StringBuilder sb5, msg_comm$Msg msg_comm_msg) {
        if (QLog.isColorLevel()) {
            sb5.append("elemType:GiftMsg;\n");
        }
        MessageForDeliverGiftTips z16 = z(im_msg_body_delivergiftmsg);
        z16.senderName = str;
        z16.grayTipContent = im_msg_body_delivergiftmsg.bytes_gray_tip_content.get().toStringUtf8();
        z16.animationPackageId = im_msg_body_delivergiftmsg.uint32_animation_package_id.get();
        z16.animationPackageUrl = im_msg_body_delivergiftmsg.bytes_animation_package_url_a.get().toStringUtf8();
        z16.remindBrief = im_msg_body_delivergiftmsg.bytes_remind_brief.get().toStringUtf8();
        z16.giftId = im_msg_body_delivergiftmsg.uint32_gift_id.get();
        z16.giftCount = im_msg_body_delivergiftmsg.uint32_gift_count.get();
        z16.animationBrief = im_msg_body_delivergiftmsg.bytes_animation_brief.get().toStringUtf8();
        z16.senderUin = im_msg_body_delivergiftmsg.uint64_sender_uin.get();
        z16.receiverUin = im_msg_body_delivergiftmsg.uint64_receiver_uin.get();
        B(im_msg_body_delivergiftmsg, z16);
        C(im_msg_body_delivergiftmsg, z16);
        D(im_msg_body_delivergiftmsg, z16);
        z16.rcvName = str2;
        y(im_msg_body_delivergiftmsg, z16);
        A(im_msg_body_delivergiftmsg, list, msg_comm_msg, z16);
        F(im_msg_body_delivergiftmsg, z16);
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "MessageProtoCodec.decodePBMsgElems  decode send gift gray tips" + z16.f203106msg);
        }
        E(z16);
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void w0(List<im_msg_body$Elem> list, List<MessageRecord> list2, msg_comm$Msg msg_comm_msg, im_msg_body$GeneralFlags im_msg_body_generalflags, byte[] bArr) {
        String str;
        if (bArr[0] != 1) {
            return;
        }
        short shortData = PkgTools.getShortData(bArr, 1);
        byte b16 = bArr[3];
        int i3 = shortData - 1;
        byte[] bArr2 = new byte[i3];
        PkgTools.copyData(bArr2, 0, bArr, 4, i3);
        if (b16 == 1) {
            bArr2 = j1(bArr2);
        }
        PAMessage pAMessage = null;
        if (bArr2 != null) {
            try {
            } catch (Exception e16) {
                e = e16;
                str = "";
            }
            if (bArr2.length > 0) {
                str = new String(bArr2, "utf-8");
                try {
                    pAMessage = z0(list, str);
                } catch (Exception e17) {
                    e = e17;
                    e.printStackTrace();
                    if (msg_comm_msg.msg_head.from_uin.has()) {
                    }
                    if (pAMessage == null) {
                    }
                }
                if (msg_comm_msg.msg_head.from_uin.has()) {
                    long j3 = msg_comm_msg.msg_head.from_uin.get();
                    if (((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).isWeatherPA(j3 + "")) {
                        return;
                    }
                }
                if (pAMessage == null) {
                    return;
                }
                MessageForPubAccount y06 = y0(str, pAMessage);
                x0(im_msg_body_generalflags, y06);
                list2.add(y06);
                return;
            }
        }
        str = "";
        if (msg_comm_msg.msg_head.from_uin.has()) {
        }
        if (pAMessage == null) {
        }
    }

    private void x0(im_msg_body$GeneralFlags im_msg_body_generalflags, MessageForPubAccount messageForPubAccount) {
        if (im_msg_body_generalflags != null && im_msg_body_generalflags.bytes_pb_reserve.has()) {
            try {
                generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                generalflags_resvattr.mergeFrom(im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
                if (generalflags_resvattr.bytes_oac_msg_extend.has()) {
                    messageForPubAccount.saveExtInfoToExtStr(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND, generalflags_resvattr.bytes_oac_msg_extend.get().toStringUtf8());
                }
            } catch (Throwable th5) {
                QLog.e("MessagePBElemDecoder", 2, "decodePBMsgElems_TransElemInfo()-MessageForPubAccount: parse generalflags error! " + QLog.getStackTraceString(th5));
            }
        }
    }

    private boolean x1(msg_comm$Msg msg_comm_msg, boolean z16, StringBuilder sb5) {
        if (!z16) {
            return false;
        }
        sb5.append(BaseApplication.getContext().getString(R.string.cnv));
        msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
        long j3 = msg_comm_msghead.msg_seq.get();
        long j16 = msg_comm_msghead.msg_uid.get();
        long j17 = msg_comm_msghead.msg_time.get();
        long j18 = msg_comm_msghead.from_uin.get();
        long j19 = msg_comm_msghead.to_uin.get();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(10001));
        hashMap.put("fromUin", String.valueOf(j18));
        hashMap.put("toUin", String.valueOf(j19));
        hashMap.put("msgSeq", String.valueOf(j3));
        hashMap.put(AppConstants.Key.COLUMN_MSG_UID, String.valueOf(j16));
        hashMap.put("msgtime", String.valueOf(j17));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(i1().getCurrentAccountUin(), StatisticCollector.MESSAGE_EVENT, false, 0L, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElemsCustomFace isC2C");
            return true;
        }
        return true;
    }

    private void y(im_msg_body$DeliverGiftMsg im_msg_body_delivergiftmsg, MessageForDeliverGiftTips messageForDeliverGiftTips) {
        if (!im_msg_body_delivergiftmsg.bytes_comefrom_link.has()) {
            return;
        }
        messageForDeliverGiftTips.jumpUrl = im_msg_body_delivergiftmsg.bytes_comefrom_link.get().toStringUtf8();
    }

    @NonNull
    private MessageForPubAccount y0(String str, PAMessage pAMessage) {
        MessageForPubAccount messageForPubAccount = (MessageForPubAccount) q.d(MessageRecord.MSG_TYPE_PUBLIC_ACCOUNT);
        messageForPubAccount.msgtype = MessageRecord.MSG_TYPE_PUBLIC_ACCOUNT;
        messageForPubAccount.f203106msg = str;
        messageForPubAccount.mPAMessage = pAMessage;
        try {
            messageForPubAccount.msgData = ((IPublicAccountMessageUtil) QRoute.api(IPublicAccountMessageUtil.class)).toByteArray(pAMessage);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return messageForPubAccount;
    }

    @Nullable
    private im_msg_body$CustomFace y1(im_msg_body$Elem im_msg_body_elem, im_msg_body$CustomFace im_msg_body_customface, boolean z16) {
        if (im_msg_body_customface == null) {
            if (im_msg_body_elem != null) {
                if (z16) {
                    return im_msg_body_elem.hc_flash_pic.get();
                }
                return im_msg_body_elem.custom_face.get();
            }
            return null;
        }
        return im_msg_body_customface;
    }

    @NonNull
    private MessageForDeliverGiftTips z(im_msg_body$DeliverGiftMsg im_msg_body_delivergiftmsg) {
        int i3 = im_msg_body_delivergiftmsg.uint32_animation_package_id.get();
        int i16 = im_msg_body_delivergiftmsg.uint32_stmessage_exflag.get();
        if (i3 == 0 && (i16 < 1000 || i16 > 2000)) {
            MessageForDeliverGiftTips messageForDeliverGiftTips = (MessageForDeliverGiftTips) q.d(MessageRecord.MSG_TYPE_TROOP_DELIVER_GIFT);
            messageForDeliverGiftTips.msgtype = MessageRecord.MSG_TYPE_TROOP_DELIVER_GIFT;
            return messageForDeliverGiftTips;
        }
        MessageForTroopGift messageForTroopGift = (MessageForTroopGift) q.d(MessageRecord.MSG_TYPE_TROOP_DELIVER_GIFT_OBJ);
        messageForTroopGift.msgtype = MessageRecord.MSG_TYPE_TROOP_DELIVER_GIFT_OBJ;
        return messageForTroopGift;
    }

    @Nullable
    private PAMessage z0(List<im_msg_body$Elem> list, String str) {
        PAMessage h16 = h1(str);
        if (h16 == null) {
            return null;
        }
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.elem_flags2.has() && im_msg_body_elem.elem_flags2.get().uint64_msg_id.has()) {
                h16.mMsgId = im_msg_body_elem.elem_flags2.get().uint64_msg_id.get();
            }
        }
        return h16;
    }

    private void z1(boolean z16, boolean z17, MessageForPic messageForPic) {
        if (z16) {
            ax.b(messageForPic, false);
        }
        if (z17) {
            ((IPicFlash) QRoute.api(IPicFlash.class)).setFlashPicFlag(messageForPic, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, boolean z16) {
        byte[] bArr;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, list, list2, sb5, msg_comm_msg, cVar, Boolean.valueOf(z16));
            return;
        }
        im_msg_body$GeneralFlags im_msg_body_generalflags = null;
        im_msg_body$ArkAppElem im_msg_body_arkappelem = null;
        im_msg_body$LightAppElem im_msg_body_lightappelem = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.ark_app.has()) {
                im_msg_body_arkappelem = im_msg_body_elem.ark_app.get();
            }
            if (im_msg_body_elem.light_app.has()) {
                im_msg_body_lightappelem = im_msg_body_elem.light_app.get();
            }
            if (im_msg_body_elem.general_flags.has()) {
                im_msg_body_generalflags = im_msg_body_elem.general_flags.get();
            }
        }
        sb5.append("elemType:ArkApp/LightApp;\n");
        if (!ArkUtil.isDeviceSupportArkMsg()) {
            QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isDeviceSupportArkMsg is false, ignore msg.");
            if (q1(list).booleanValue()) {
                m(list, list2, sb5, msg_comm_msg, cVar);
                return;
            }
            MessageForText messageForText = (MessageForText) q.d(-1000);
            messageForText.msgtype = -1000;
            messageForText.f203106msg = BaseApplication.getContext().getString(R.string.c2c);
            list2.add(messageForText);
            return;
        }
        if (((IArkConfig) QRoute.api(IArkConfig.class)).isPANonShow()) {
            QLog.i("ArkApp", 1, "decode msg, ArkAppCenter.isPANonShow is true, ignore msg.");
            return;
        }
        if (im_msg_body_arkappelem != null) {
            if (!im_msg_body_arkappelem.bytes_data.has()) {
                QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data not exist.");
                return;
            }
            bArr = im_msg_body_arkappelem.bytes_data.get().toByteArray();
        } else if (im_msg_body_lightappelem != null) {
            if (!im_msg_body_lightappelem.bytes_data.has()) {
                QLog.i("ArkApp", 1, "decode msg, light_app.bytes_data not exist.");
                return;
            }
            bArr = im_msg_body_lightappelem.bytes_data.get().toByteArray();
        } else {
            bArr = null;
        }
        if (bArr != null && bArr.length > 0) {
            try {
                byte[] i3 = com.tencent.mobileqq.structmsg.k.i(bArr, -1);
                if (i3 != null && i3.length > 0) {
                    try {
                        str = new String(i3, "UTF-8");
                    } catch (Exception unused) {
                        QLog.i("ArkApp", 1, "decode msg, raw data cannot convert to string.");
                    }
                    if (!TextUtils.isEmpty(str)) {
                        QLog.i("ArkApp", 1, "decode msg, ark data is empty.");
                        return;
                    } else {
                        k1(im_msg_body_generalflags, false, str, list, list2, sb5, msg_comm_msg, cVar, z16);
                        return;
                    }
                }
                QLog.i("ArkApp", 1, "decode msg, raw data is empty.");
                str = null;
                if (!TextUtils.isEmpty(str)) {
                }
            } catch (IllegalArgumentException unused2) {
                QLog.w("ArkApp", 1, "decode msg, fail to uncompress, data-len=" + bArr.length);
            }
        } else {
            QLog.i("ArkApp", 1, "decode msg, ark_app.bytes_data is empty.");
        }
    }

    public void D0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        boolean z16;
        ArrayList<ArkBabyqCardInfo> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, list2, sb5, msg_comm_msg, cVar);
            return;
        }
        String str = null;
        im_msg_body$CommonElem im_msg_body_commonelem = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.common_elem.has()) {
                im_msg_body_commonelem = im_msg_body_elem.common_elem.get();
            }
        }
        e1(list);
        if (QLog.isColorLevel()) {
            QLog.d("ArkBabyq", 2, "decodePBMsgElems_ArkBabyqReply  common_lem" + im_msg_body_commonelem);
        }
        if (im_msg_body_commonelem == null) {
            return;
        }
        hummer_commelem$MsgElemInfo_servtype19 hummer_commelem_msgeleminfo_servtype19 = new hummer_commelem$MsgElemInfo_servtype19();
        try {
            hummer_commelem_msgeleminfo_servtype19.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            if (!ArkUtil.isDeviceSupportArkMsg()) {
                QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply is false, ignore msg.");
                return;
            }
            if (hummer_commelem_msgeleminfo_servtype19.bytes_data.has()) {
                hummer_commelem_msgeleminfo_servtype19.bytes_data.get().toStringUtf8();
                byte[] byteArray = hummer_commelem_msgeleminfo_servtype19.bytes_data.get().toByteArray();
                if (byteArray != null && byteArray.length > 0) {
                    byte[] i3 = com.tencent.mobileqq.structmsg.k.i(byteArray, -1);
                    if (i3 != null && i3.length > 0) {
                        try {
                            str = new String(i3, "UTF-8");
                        } catch (Exception unused) {
                            QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply convert failed");
                        }
                    } else {
                        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply empty.");
                    }
                    String s16 = s(list, list2, false);
                    MessageForArkBabyqReply messageForArkBabyqReply = (MessageForArkBabyqReply) q.d(MessageRecord.MSG_TYPE_ARK_BABYQ_REPLY);
                    messageForArkBabyqReply.msgtype = MessageRecord.MSG_TYPE_ARK_BABYQ_REPLY;
                    if (s16 != null) {
                        messageForArkBabyqReply.compatibleMsg = s16;
                    }
                    messageForArkBabyqReply.fromAppXml(str);
                    if (im_msg_body_commonelem.uint32_business_type.get() != 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    messageForArkBabyqReply.showAsBabyq = z16;
                    messageForArkBabyqReply.msgData = messageForArkBabyqReply.toBytes();
                    messageForArkBabyqReply.parse();
                    if (TextUtils.isEmpty(messageForArkBabyqReply.babyqReplyText) && !messageForArkBabyqReply.isFailed && ((arrayList = messageForArkBabyqReply.mArkBabyqReplyCardList) == null || arrayList.size() <= 0)) {
                        QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply not valid..");
                    } else {
                        list2.add(messageForArkBabyqReply);
                        z17 = true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ArkBabyq", 2, "decodePBMsgElems_ArkBabyqReply hasArkBabyQMsg = " + z17);
                    }
                    if (!z17) {
                        m(list, list2, sb5, msg_comm_msg, cVar);
                        return;
                    }
                    return;
                }
                QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply, bytes_data empty.");
                return;
            }
            QLog.i("ArkBabyq", 1, "decodePBMsgElems_ArkBabyqReply, bytes_data not exist.");
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    public void E0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, list, list2, sb5, msg_comm_msg, cVar);
            return;
        }
        String str = null;
        im_msg_body$CommonElem im_msg_body_commonelem = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.common_elem.has()) {
                im_msg_body_commonelem = im_msg_body_elem.common_elem.get();
            }
        }
        e1(list);
        if (QLog.isColorLevel()) {
            QLog.d("ArkSdkShare", 2, "decodePBMsgElems_ArkSdkApp  common_lem" + im_msg_body_commonelem);
        }
        if (im_msg_body_commonelem == null) {
            return;
        }
        hummer_commelem$MsgElemInfo_servtype20 hummer_commelem_msgeleminfo_servtype20 = new hummer_commelem$MsgElemInfo_servtype20();
        try {
            hummer_commelem_msgeleminfo_servtype20.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            if (!ArkUtil.isDeviceSupportArkMsg()) {
                QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp is false, ignore msg.");
                return;
            }
            if (hummer_commelem_msgeleminfo_servtype20.bytes_data.has()) {
                hummer_commelem_msgeleminfo_servtype20.bytes_data.get().toStringUtf8();
                byte[] byteArray = hummer_commelem_msgeleminfo_servtype20.bytes_data.get().toByteArray();
                if (byteArray != null && byteArray.length > 0) {
                    byte[] i3 = com.tencent.mobileqq.structmsg.k.i(byteArray, -1);
                    if (i3 != null && i3.length > 0) {
                        try {
                            str = new String(i3, "UTF-8");
                        } catch (Exception unused) {
                            QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp convert failed");
                        }
                    } else {
                        QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp empty.");
                    }
                    String s16 = s(list, list2, false);
                    MessageForArkApp messageForArkApp = (MessageForArkApp) q.d(MessageRecord.MSG_TYPE_ARK_SDK_SHARE);
                    messageForArkApp.msgtype = MessageRecord.MSG_TYPE_ARK_SDK_SHARE;
                    if (im_msg_body_commonelem.uint32_business_type.get() == 1) {
                        messageForArkApp.saveExtInfoToExtStr(i.f286262e, "1");
                    }
                    if (s16 != null) {
                        messageForArkApp.compatibleMsg = s16;
                    }
                    ArkAppMessage arkAppMessage = new ArkAppMessage();
                    arkAppMessage.fromAppXml(str);
                    messageForArkApp.msgData = arkAppMessage.toBytes();
                    messageForArkApp.parse();
                    if (!TextUtils.isEmpty(messageForArkApp.ark_app_message.appName) && !TextUtils.isEmpty(messageForArkApp.ark_app_message.appView)) {
                        list2.add(messageForArkApp);
                        z16 = true;
                    } else {
                        QLog.i("arksdk", 1, "decode msg, ark message is not valid..");
                    }
                    if (!z16) {
                        m(list, list2, sb5, msg_comm_msg, cVar);
                        return;
                    }
                    return;
                }
                QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp, bytes_data empty.");
                return;
            }
            QLog.i("ArkSdkShare", 1, "decodePBMsgElems_ArkSdkApp, bytes_data not exist.");
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    public void F0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, list2, sb5, msg_comm_msg, cVar);
            return;
        }
        im_msg_body$CommonElem J0 = J0(list);
        String e16 = e1(list);
        if (QLog.isColorLevel()) {
            QLog.d("MessagePBElemDecoder", 2, "decodePBMsgElems_FlashChat  common_lem" + J0 + ", text " + e16);
        }
        if (J0 == null) {
            return;
        }
        int I0 = I0(J0);
        hummer_commelem$MsgElemInfo_servtype14 hummer_commelem_msgeleminfo_servtype14 = new hummer_commelem$MsgElemInfo_servtype14();
        try {
            hummer_commelem_msgeleminfo_servtype14.mergeFrom(J0.bytes_pb_elem.get().toByteArray());
            G0(list, list2, sb5, msg_comm_msg, cVar, e16, I0, hummer_commelem_msgeleminfo_servtype14);
        } catch (InvalidProtocolBufferMicroException e17) {
            e17.printStackTrace();
        }
    }

    public MarkFaceMessage F1(im_msg_body$Elem im_msg_body_elem, List<MessageRecord> list, StringBuilder sb5, long j3) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (MarkFaceMessage) iPatchRedirector.redirect((short) 31, this, im_msg_body_elem, list, sb5, Long.valueOf(j3));
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:MarketFace;\n");
        }
        im_msg_body$MarketFace im_msg_body_marketface = im_msg_body_elem.market_face.get();
        if (im_msg_body_marketface != null) {
            MarkFaceMessage markFaceMessage = new MarkFaceMessage();
            markFaceMessage.cFaceInfo = im_msg_body_marketface.uint32_face_info.get();
            markFaceMessage.index = 0L;
            markFaceMessage.cSubType = im_msg_body_marketface.uint32_sub_type.get();
            markFaceMessage.dwMSGItemType = im_msg_body_marketface.uint32_item_type.get();
            markFaceMessage.dwTabID = im_msg_body_marketface.uint32_tab_id.get();
            markFaceMessage.sbfKey = im_msg_body_marketface.bytes_key.get().toByteArray();
            markFaceMessage.sbufID = im_msg_body_marketface.bytes_face_id.get().toByteArray();
            markFaceMessage.mediaType = im_msg_body_marketface.uint32_media_type.get();
            markFaceMessage.imageWidth = 200;
            markFaceMessage.imageHeight = 200;
            markFaceMessage.mobileparam = im_msg_body_marketface.bytes_mobileparam.get().toByteArray();
            if (im_msg_body_marketface.bytes_pb_reserve.has()) {
                markFaceMessage.resvAttr = im_msg_body_marketface.bytes_pb_reserve.get().toByteArray();
                MarketFaceExtPb$ResvAttr marketFaceExtPb$ResvAttr = new MarketFaceExtPb$ResvAttr();
                try {
                    marketFaceExtPb$ResvAttr.mergeFrom(markFaceMessage.resvAttr);
                    markFaceMessage.copywritingType = marketFaceExtPb$ResvAttr.uint32_source_type.get();
                    markFaceMessage.copywritingContent = marketFaceExtPb$ResvAttr.str_source_name.get();
                    markFaceMessage.jumpUrl = marketFaceExtPb$ResvAttr.str_source_jump_url.get();
                    markFaceMessage.beginTime = marketFaceExtPb$ResvAttr.uint32_start_time.get();
                    markFaceMessage.endTime = marketFaceExtPb$ResvAttr.uint32_end_time.get();
                    markFaceMessage.from = marketFaceExtPb$ResvAttr.str_source_type_name.get();
                    if (marketFaceExtPb$ResvAttr.uint32_emoji_type.get() == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    markFaceMessage.isAPNG = z16;
                    if (marketFaceExtPb$ResvAttr.uint32_has_ip_product.get() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    markFaceMessage.hasIpProduct = z17;
                    if (marketFaceExtPb$ResvAttr.uint32_voice_item_height_arr.has()) {
                        markFaceMessage.voicePrintItems = marketFaceExtPb$ResvAttr.uint32_voice_item_height_arr.get();
                    }
                    if (marketFaceExtPb$ResvAttr.str_back_color.has()) {
                        markFaceMessage.backColor = marketFaceExtPb$ResvAttr.str_back_color.get();
                    }
                    if (marketFaceExtPb$ResvAttr.str_volume_color.has()) {
                        markFaceMessage.volumeColor = marketFaceExtPb$ResvAttr.str_volume_color.get();
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("MessagePBElemDecoder", 1, "mergeFrom resvAttr error e = " + e16);
                }
            }
            if (QLog.isColorLevel()) {
                sb5.append(" mediaType = ");
                sb5.append(markFaceMessage.mediaType);
                sb5.append("\n");
            }
            if (im_msg_body_marketface.bytes_face_name.has()) {
                String stringUtf8 = im_msg_body_marketface.bytes_face_name.get().toStringUtf8();
                if (!TextUtils.isEmpty(stringUtf8) && stringUtf8.length() > 1 && stringUtf8.charAt(0) == '[' && stringUtf8.charAt(stringUtf8.length() - 1) == ']') {
                    markFaceMessage.faceName = stringUtf8.substring(1, stringUtf8.length() - 1);
                } else {
                    markFaceMessage.faceName = stringUtf8;
                }
            }
            MessageForMarketFace messageForMarketFace = (MessageForMarketFace) q.d(-2007);
            messageForMarketFace.msgtype = -2007;
            messageForMarketFace.f203106msg = "it is marketface";
            messageForMarketFace.mMarkFaceMessage = markFaceMessage;
            byte[] bArr = markFaceMessage.mobileparam;
            if (bArr != null && bArr.length > 0) {
                ReportController.o(i1(), "CliOper", "", "", "MbJieshou", "MbXiaoxi", 0, 0, "", "", "", "");
            }
            try {
                messageForMarketFace.msgData = MessagePkgUtils.getBytesFromObject(markFaceMessage);
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            list.add(messageForMarketFace);
            return markFaceMessage;
        }
        return null;
    }

    public String G1(im_msg_body$CommonElem im_msg_body_commonelem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this, (Object) im_msg_body_commonelem);
        }
        if (im_msg_body_commonelem == null || !im_msg_body_commonelem.bytes_pb_elem.has()) {
            return "";
        }
        try {
            hummer_commelem$MsgElemInfo_servtype33 hummer_commelem_msgeleminfo_servtype33 = new hummer_commelem$MsgElemInfo_servtype33();
            hummer_commelem_msgeleminfo_servtype33.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            if (hummer_commelem_msgeleminfo_servtype33.bytes_text.has()) {
                hummer_commelem_msgeleminfo_servtype33.bytes_text.get().toStringUtf8();
            }
            int convertToLocal = QQSysFaceUtil.convertToLocal(hummer_commelem_msgeleminfo_servtype33.uint32_index.get());
            if (convertToLocal < 0) {
                return "";
            }
            return QQSysFaceUtil.getFaceString(convertToLocal);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public MessageForReplyText.SourceMsgInfo I1(List<im_msg_body$Elem> list, StringBuilder sb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (MessageForReplyText.SourceMsgInfo) iPatchRedirector.redirect((short) 34, (Object) this, (Object) list, (Object) sb5);
        }
        im_msg_body$SourceMsg im_msg_body_sourcemsg = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.src_msg.has()) {
                im_msg_body_sourcemsg = im_msg_body_elem.src_msg.get();
                if (im_msg_body_sourcemsg.bytes_src_msg.has()) {
                    break;
                }
            }
        }
        if (im_msg_body_sourcemsg == null || !im_msg_body_sourcemsg.elems.has()) {
            return null;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:SrcMsg;\n");
        }
        List<im_msg_body$Elem> list2 = im_msg_body_sourcemsg.elems.get();
        MessageForReplyText.SourceMsgInfo sourceMsgInfo = new MessageForReplyText.SourceMsgInfo();
        sourceMsgInfo.mSourceMsgSeq = im_msg_body_sourcemsg.uint32_orig_seqs.get(0).intValue();
        sourceMsgInfo.mSourceMsgText = e1(list2);
        sourceMsgInfo.mSourceMsgTime = im_msg_body_sourcemsg.uint32_time.get();
        sourceMsgInfo.mSourceMsgSenderUin = im_msg_body_sourcemsg.uint64_sender_uin.get();
        if (im_msg_body_sourcemsg.bytes_troop_name.has()) {
            sourceMsgInfo.mSourceMsgTroopName = im_msg_body_sourcemsg.bytes_troop_name.get().toStringUtf8();
        } else {
            sourceMsgInfo.mSourceMsgTroopName = null;
        }
        sourceMsgInfo.mSourceMsgToUin = im_msg_body_sourcemsg.uint64_to_uin.get();
        sourceMsgInfo.mSourceSummaryFlag = im_msg_body_sourcemsg.uint32_flag.get();
        for (im_msg_body$Elem im_msg_body_elem2 : list2) {
            if (im_msg_body_elem2.anon_group_msg.has()) {
                sourceMsgInfo.mAnonymousNickName = im_msg_body_elem2.anon_group_msg.get().str_anon_nick.get().toStringUtf8();
            }
        }
        if (im_msg_body_sourcemsg.uint32_type.has()) {
            sourceMsgInfo.mType = im_msg_body_sourcemsg.uint32_type.get();
        }
        if (im_msg_body_sourcemsg.bytes_richMsg.has()) {
            sourceMsgInfo.mRichMsg = im_msg_body_sourcemsg.bytes_richMsg.get().toStringUtf8();
        }
        if (im_msg_body_sourcemsg.bytes_pb_reserve.has()) {
            source_msg$ResvAttr source_msg_resvattr = new source_msg$ResvAttr();
            try {
                source_msg_resvattr.mergeFrom(im_msg_body_sourcemsg.bytes_pb_reserve.get().toByteArray());
                if (source_msg_resvattr.uint32_ori_msgtype.has()) {
                    sourceMsgInfo.oriMsgType = source_msg_resvattr.uint32_ori_msgtype.get();
                }
                if (source_msg_resvattr.uint64_orig_uids.has() && !source_msg_resvattr.uint64_orig_uids.isEmpty()) {
                    sourceMsgInfo.origUid = source_msg_resvattr.uint64_orig_uids.get(0).longValue();
                }
                if (source_msg_resvattr.bytes_guild_nick.has()) {
                    sourceMsgInfo.origNickName = source_msg_resvattr.bytes_guild_nick.get().toStringUtf8();
                }
                u1(sourceMsgInfo, source_msg_resvattr);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
        if (im_msg_body_sourcemsg.bytes_src_msg.has()) {
            sourceMsgInfo.setSourceMsgByte(im_msg_body_sourcemsg.bytes_src_msg.get().toByteArray());
        }
        return sourceMsgInfo;
    }

    public a J1(List<im_msg_body$Elem> list, StringBuilder sb5, long j3, com.tencent.mobileqq.troop.data.c cVar, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (a) iPatchRedirector.redirect((short) 21, this, list, sb5, Long.valueOf(j3), cVar, Long.valueOf(j16));
        }
        a aVar = new a();
        aVar.f286320a = I1(list, sb5);
        aa aaVar = new aa();
        ArrayList<Object> arrayList = aaVar.f286171a;
        ArrayList<AtTroopMemberInfo> arrayList2 = new ArrayList<>(2);
        StringBuilder t16 = t(null, list, sb5, j3, cVar, aaVar, arrayList2, j16);
        if (arrayList2.size() > 0) {
            aVar.f286325f = arrayList2;
        }
        AtTroopMemberInfo atTroopMemberInfo = null;
        if (arrayList != null && arrayList.size() == 2) {
            if (arrayList.get(0) != null) {
                atTroopMemberInfo = (AtTroopMemberInfo) arrayList.get(0);
            }
            if (arrayList.get(1) != null) {
                aVar.f286321b = (byte[]) arrayList.get(1);
            }
        }
        if (t16.length() > 0 && aVar.f286320a != null) {
            aVar.f286322c = t16.toString();
            if (TextUtils.isEmpty(aVar.f286320a.mAnonymousNickName) && atTroopMemberInfo != null && !TextUtils.isEmpty(aVar.f286322c)) {
                int length = aVar.f286322c.length();
                short s16 = atTroopMemberInfo.textLen;
                short s17 = atTroopMemberInfo.startPos;
                if (length >= s16 + s17) {
                    aVar.f286323d = atTroopMemberInfo;
                    String str = aVar.f286322c;
                    String str2 = "";
                    aVar.f286322c = "";
                    if (s17 > 0) {
                        aVar.f286322c = str.substring(0, s17);
                    }
                    int i3 = atTroopMemberInfo.startPos + atTroopMemberInfo.textLen;
                    int i16 = i3 + 1;
                    if (i16 < str.length()) {
                        str2 = str.substring(i3, i16);
                    }
                    if (str2.equals(" ")) {
                        aVar.f286322c += str.substring(i16);
                    } else {
                        aVar.f286322c += str.substring(i3);
                    }
                    short s18 = atTroopMemberInfo.startPos;
                    aVar.f286324e = str.substring(s18, atTroopMemberInfo.textLen + s18);
                    if (atTroopMemberInfo.isIncludingMe(i1().getLongAccountUin()) && aaVar.f286172b == null) {
                        cVar.f294893c.k(25, -1L, 0L);
                    }
                }
            }
        }
        return aVar;
    }

    public void K0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, boolean z16) {
        im_msg_body$Elem im_msg_body_elem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, list, list2, sb5, msg_comm_msg, Boolean.valueOf(z16));
            return;
        }
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body_elem = it.next();
                if (im_msg_body_elem.hc_flash_pic.has()) {
                    break;
                }
            } else {
                im_msg_body_elem = null;
                break;
            }
        }
        im_msg_body$Elem im_msg_body_elem2 = im_msg_body_elem;
        if (im_msg_body_elem2 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:FlashPic;\n");
        }
        v1(im_msg_body_elem2, null, list2, sb5, msg_comm_msg, z16);
    }

    public void L0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, boolean z16) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, list, list2, sb5, msg_comm_msg, Boolean.valueOf(z16));
            return;
        }
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.common_elem.has()) {
                    im_msg_body_commonelem = next.common_elem.get();
                    break;
                }
            } else {
                im_msg_body_commonelem = null;
                break;
            }
        }
        if (im_msg_body_commonelem == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "decodePBMsgElems_FlashPicCommen isC2C=" + z16);
        }
        if (QLog.isColorLevel()) {
            sb5.append("ELEM_FlashPicCommen;\n");
        }
        hummer_commelem$MsgElemInfo_servtype3 hummer_commelem_msgeleminfo_servtype3 = new hummer_commelem$MsgElemInfo_servtype3();
        try {
            hummer_commelem_msgeleminfo_servtype3.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            if (!z16) {
                if (hummer_commelem_msgeleminfo_servtype3.flash_troop_pic.has()) {
                    v1(null, hummer_commelem_msgeleminfo_servtype3.flash_troop_pic.get(), list2, sb5, msg_comm_msg, z16);
                }
            } else if (hummer_commelem_msgeleminfo_servtype3.flash_c2c_pic.has()) {
                H1(null, hummer_commelem_msgeleminfo_servtype3.flash_c2c_pic.get(), list2, sb5, msg_comm_msg);
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    public void M0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, list, list2, sb5, msg_comm_msg, cVar);
            return;
        }
        MessageForAioGift messageForAioGift = new MessageForAioGift();
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) != null && list.get(i3).common_elem.has() && list.get(i3).common_elem.bytes_pb_elem.has()) {
                    messageForAioGift.msgData = list.get(i3).common_elem.bytes_pb_elem.get().toByteArray();
                    messageForAioGift.msgtype = MessageRecord.MSG_TYPE_GUILD_GIFT;
                    messageForAioGift.parse();
                    list2.add(messageForAioGift);
                    l1(list, msg_comm_msg, cVar, messageForAioGift);
                }
            }
        }
    }

    public void N0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, list2, sb5, msg_comm_msg, cVar, Boolean.valueOf(z16));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (QLog.isColorLevel()) {
            sb5.append("elemType:MarketFace;\n");
        }
        MarkFaceMessage markFaceMessage = null;
        loop0: while (true) {
            boolean z17 = false;
            for (im_msg_body$Elem im_msg_body_elem : list) {
                if (im_msg_body_elem.market_face.has()) {
                    if (!arrayList.isEmpty()) {
                        Q0(arrayList, list2, sb5, msg_comm_msg, cVar, z16);
                        arrayList.clear();
                    }
                    markFaceMessage = F1(im_msg_body_elem, list2, sb5, msg_comm_msg.msg_body.get().rich_text.get().attr.get().time.get());
                    z17 = true;
                } else if (z17 && im_msg_body_elem.text.has() && markFaceMessage != null) {
                    String stringUtf8 = im_msg_body_elem.text.get().str.get().toStringUtf8();
                    markFaceMessage.faceName = stringUtf8;
                    if (stringUtf8.charAt(0) == '[') {
                        String str = markFaceMessage.faceName;
                        if (str.charAt(str.length() - 1) == ']') {
                            String str2 = markFaceMessage.faceName;
                            markFaceMessage.faceName = str2.substring(1, str2.length() - 1);
                        }
                    }
                    try {
                        list2.get(list2.size() - 1).msgData = MessagePkgUtils.getBytesFromObject(markFaceMessage);
                    } catch (Exception e16) {
                        QLog.e(MessageForMarketFace.TAG, 1, "decodePBMsgElems_MarketFace: ", e16);
                    }
                    if (QLog.isColorLevel()) {
                        sb5.append("filter the text expalin:");
                        sb5.append(im_msg_body_elem.text.get().str.get());
                        sb5.append("\n");
                    }
                } else {
                    arrayList.add(im_msg_body_elem);
                }
            }
            break loop0;
        }
        if (!arrayList.isEmpty()) {
            Q0(arrayList, list2, sb5, msg_comm_msg, cVar, z16);
            arrayList.clear();
        }
    }

    public void O0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, list, list2, sb5);
            return;
        }
        im_msg_body$MarketTrans im_msg_body_markettrans = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.market_trans.has()) {
                im_msg_body_markettrans = im_msg_body_elem.market_trans.get();
            }
        }
        if (im_msg_body_markettrans == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:MarketTrans;\n");
        }
        AbsStructMsg g16 = com.tencent.mobileqq.structmsg.i.g(im_msg_body_markettrans.bytes_xml.get().toByteArray(), im_msg_body_markettrans.int32_flag.get());
        if (g16 == null) {
            if (QLog.isColorLevel()) {
                sb5.append("c2cMsgContent.data:null;\n");
            }
            s(list, list2, true);
            return;
        }
        for (im_msg_body$Elem im_msg_body_elem2 : list) {
            if (im_msg_body_elem2.life_online.has() && im_msg_body_elem2.life_online.get().uint32_report.has() && im_msg_body_elem2.life_online.get().uint32_report.get() == 1 && im_msg_body_elem2.life_online.get().uint64_unique_id.has()) {
                g16.msgId = im_msg_body_elem2.life_online.get().uint64_unique_id.get();
            }
        }
        String s16 = s(list, list2, false);
        if (s16 != null) {
            g16.mCompatibleText = s16;
        }
        MessageForStructing messageForStructing = (MessageForStructing) q.d(MessageRecord.MSG_TYPE_STRUCT_MSG);
        messageForStructing.msgtype = MessageRecord.MSG_TYPE_STRUCT_MSG;
        messageForStructing.f203106msg = "MarketTrans";
        messageForStructing.structingMsg = g16;
        messageForStructing.msgData = g16.getBytes();
        list2.add(messageForStructing);
    }

    public boolean P0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, boolean z16, com.tencent.mobileqq.troop.data.c cVar) {
        String str;
        String stringUtf8;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, list, list2, sb5, msg_comm_msg, Boolean.valueOf(z16), cVar)).booleanValue();
        }
        if (z16) {
            if (i1().getLongAccountUin() == msg_comm_msg.msg_head.to_uin.get()) {
                str = msg_comm_msg.msg_head.from_uin.get() + "";
            } else {
                str = msg_comm_msg.msg_head.to_uin.get() + "";
            }
        } else if (cVar != null) {
            str = cVar.f294891a;
        } else {
            str = msg_comm_msg.msg_head.to_uin.get() + "";
        }
        String str2 = str;
        im_msg_body$CommonElem im_msg_body_commonelem = null;
        String str3 = null;
        String str4 = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.pub_group.has()) {
                str3 = im_msg_body_elem.pub_group.bytes_nickname.get().toStringUtf8();
            }
            if (im_msg_body_elem.text.has() && (stringUtf8 = im_msg_body_elem.text.get().str.get().toStringUtf8()) != null && stringUtf8.startsWith("@")) {
                str4 = stringUtf8.substring(1);
            }
            if (im_msg_body_elem.common_elem.has()) {
                im_msg_body_commonelem = im_msg_body_elem.common_elem;
            }
        }
        if (im_msg_body_commonelem == null) {
            return false;
        }
        hummer_commelem$MsgElemInfo_servtype8 hummer_commelem_msgeleminfo_servtype8 = new hummer_commelem$MsgElemInfo_servtype8();
        try {
            hummer_commelem_msgeleminfo_servtype8.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            if (QLog.isColorLevel()) {
                sb5.append("elemType:GiftMsg;\n");
            }
            MessageForDeliverGiftTips w3 = w(str3, str4, hummer_commelem_msgeleminfo_servtype8.wifi_deliver_gift_msg, list2, sb5, msg_comm_msg);
            w3.frienduin = str2;
            w3.isFromNearby = true;
            AIOAnimationControlManager aIOAnimationControlManager = (AIOAnimationControlManager) i1().getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
            if (aIOAnimationControlManager != null) {
                aIOAnimationControlManager.n(w3);
            }
            return true;
        } catch (InvalidProtocolBufferMicroException unused) {
            return false;
        }
    }

    public void Q0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, boolean z16) {
        AtTroopMemberInfo atTroopMemberInfo;
        AtTroopMemberInfo atTroopMemberInfo2;
        ArrayList arrayList;
        int i3;
        aa aaVar;
        ArrayList<AtTroopMemberInfo> arrayList2;
        msg_comm$Msg msg_comm_msg2 = msg_comm_msg;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 1;
        int i17 = 2;
        int i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, list, list2, sb5, msg_comm_msg2, cVar, Boolean.valueOf(z16));
            return;
        }
        StringBuilder sb6 = new StringBuilder("");
        aa aaVar2 = new aa();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<AtTroopMemberInfo> arrayList4 = new ArrayList<>(2);
        byte[] bArr = null;
        StringBuilder sb7 = sb6;
        ArrayList<AtTroopMemberInfo> arrayList5 = arrayList4;
        int i19 = 0;
        im_msg_body$GeneralFlags im_msg_body_generalflags = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.custom_face.has()) {
                if (sb7.length() > 0) {
                    MessageForText messageForText = (MessageForText) q.d(-1000);
                    messageForText.msgtype = -1000;
                    messageForText.f203106msg = sb7.toString();
                    messageForText.atInfoList = arrayList5;
                    arrayList5 = new ArrayList<>(i17);
                    arrayList3.add(messageForText);
                    sb7.delete(i18, sb7.length());
                }
                w1(im_msg_body_elem, null, arrayList3, sb5, msg_comm_msg, z16, cVar);
                arrayList = arrayList3;
                i3 = i18;
                aaVar = aaVar2;
                arrayList5 = arrayList5;
                im_msg_body_generalflags = im_msg_body_generalflags;
                sb7 = sb7;
            } else {
                im_msg_body$GeneralFlags im_msg_body_generalflags2 = im_msg_body_generalflags;
                StringBuilder sb8 = sb7;
                if (im_msg_body_elem.not_online_image.has()) {
                    if (sb8.length() > 0) {
                        MessageForText messageForText2 = (MessageForText) q.d(-1000);
                        messageForText2.msgtype = -1000;
                        messageForText2.f203106msg = sb8.toString();
                        messageForText2.atInfoList = arrayList5;
                        arrayList5 = new ArrayList<>(i17);
                        arrayList3.add(messageForText2);
                        sb7 = sb8;
                        sb7.delete(i18, sb8.length());
                    } else {
                        sb7 = sb8;
                    }
                    H1(im_msg_body_elem, null, arrayList3, sb5, msg_comm_msg);
                    arrayList = arrayList3;
                    i3 = i18;
                    aaVar = aaVar2;
                } else {
                    sb7 = sb8;
                    if (ah.d(im_msg_body_elem).booleanValue()) {
                        if (i19 != 0) {
                            i19 = i18;
                            im_msg_body_generalflags = im_msg_body_generalflags2;
                        } else {
                            if (im_msg_body_elem.small_emoji.has()) {
                                i19 = i16;
                            }
                            ArrayList arrayList6 = new ArrayList();
                            arrayList6.add(im_msg_body_elem);
                            long j3 = msg_comm_msg2.msg_head.msg_seq.get();
                            long j16 = msg_comm_msg2.msg_head.msg_time.get();
                            arrayList2 = arrayList5;
                            arrayList = arrayList3;
                            i3 = i18;
                            aaVar = aaVar2;
                            sb7 = t(sb7, arrayList6, sb5, j3, cVar, aaVar2, arrayList2, j16);
                        }
                    } else {
                        arrayList2 = arrayList5;
                        arrayList = arrayList3;
                        i3 = i18;
                        aaVar = aaVar2;
                        if (im_msg_body_elem.general_flags.has()) {
                            im_msg_body_generalflags = im_msg_body_elem.general_flags.get();
                            arrayList5 = arrayList2;
                        }
                    }
                    arrayList5 = arrayList2;
                }
                im_msg_body_generalflags = im_msg_body_generalflags2;
            }
            i18 = i3;
            arrayList3 = arrayList;
            aaVar2 = aaVar;
            i16 = 1;
            i17 = 2;
            msg_comm_msg2 = msg_comm_msg;
        }
        im_msg_body$GeneralFlags im_msg_body_generalflags3 = im_msg_body_generalflags;
        ArrayList<AtTroopMemberInfo> arrayList7 = arrayList5;
        ArrayList arrayList8 = arrayList3;
        int i26 = i18;
        aa aaVar3 = aaVar2;
        if (sb7.length() > 0) {
            MessageForText messageForText3 = (MessageForText) q.d(-1000);
            messageForText3.msgtype = -1000;
            messageForText3.f203106msg = sb7.toString();
            messageForText3.atInfoList = arrayList7;
            if (cVar != null) {
                com.tencent.mobileqq.troop.text.a.n(cVar.f294892b, arrayList7, messageForText3);
            }
            arrayList8.add(messageForText3);
            sb7.delete(i26, sb7.length());
        }
        ArrayList<Object> arrayList9 = aaVar3.f286171a;
        if (arrayList9 != null && arrayList9.size() == 2) {
            if (arrayList9.get(i26) != null) {
                atTroopMemberInfo2 = (AtTroopMemberInfo) arrayList9.get(i26);
            } else {
                atTroopMemberInfo2 = null;
            }
            if (arrayList9.get(1) != null) {
                bArr = (byte[]) arrayList9.get(1);
            }
            atTroopMemberInfo = atTroopMemberInfo2;
        } else {
            atTroopMemberInfo = null;
        }
        U0(list, sb5, atTroopMemberInfo, arrayList8, aaVar3, cVar);
        R0(im_msg_body_generalflags3, arrayList8);
        S0(im_msg_body_generalflags3, arrayList8);
        T0(arrayList8, msg_comm_msg, list2, bArr, cVar, atTroopMemberInfo);
    }

    public void V0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, list, list2, sb5);
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:PokeEmoMsg;\n");
        }
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.common_elem.has()) {
                    im_msg_body_commonelem = next.common_elem.get();
                    break;
                }
            } else {
                im_msg_body_commonelem = null;
                break;
            }
        }
        if (im_msg_body_commonelem == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeEmoMsg null commomElem!");
                return;
            }
            return;
        }
        MessageForPokeEmo messageForPokeEmo = new MessageForPokeEmo();
        messageForPokeEmo.msgtype = MessageRecord.MSG_TYPE_POKE_EMO_MSG;
        if (im_msg_body_commonelem.bytes_pb_elem.has()) {
            hummer_commelem$MsgElemInfo_servtype23 hummer_commelem_msgeleminfo_servtype23 = new hummer_commelem$MsgElemInfo_servtype23();
            try {
                hummer_commelem_msgeleminfo_servtype23.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
                messageForPokeEmo.pokeemoId = hummer_commelem_msgeleminfo_servtype23.uint32_face_type.get();
                messageForPokeEmo.pokeemoPressCount = hummer_commelem_msgeleminfo_servtype23.uint32_face_bubble_count.get();
                messageForPokeEmo.summary = hummer_commelem_msgeleminfo_servtype23.bytes_face_summary.get().toStringUtf8();
                if (hummer_commelem_msgeleminfo_servtype23.msg_yellow_face.has()) {
                    int i3 = hummer_commelem_msgeleminfo_servtype23.msg_yellow_face.get().uint32_index.get();
                    messageForPokeEmo.emoIndex = i3;
                    String prueFaceDescription = QQSysFaceUtil.getPrueFaceDescription(QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.convertToLocal(i3)));
                    messageForPokeEmo.emoString = prueFaceDescription;
                    messageForPokeEmo.emoCompat = prueFaceDescription;
                }
                messageForPokeEmo.initMsg();
            } catch (Exception e16) {
                QLog.d("PokeEmoMsg", 1, "decodePBMsgElems_PokeEmoMsg exception!", e16);
            }
        }
        list2.add(messageForPokeEmo);
        if (QLog.isColorLevel()) {
            QLog.d("PokeEmoMsg", 2, "decodePbElems, common_elem type 23, pokeemoId:" + messageForPokeEmo.pokeemoId + " ,pokeemoPressCount:" + messageForPokeEmo.pokeemoPressCount);
        }
    }

    public void W0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        Iterator<im_msg_body$Elem> it;
        char c16;
        char c17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 16;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, list, list2, sb5, msg_comm_msg, cVar);
            return;
        }
        im_msg_body$GroupPubAccountInfo K = K(list);
        im_msg_body$GeneralFlags J = J(list);
        if (K == null) {
            return;
        }
        long j3 = K.uint64_pub_account.get();
        MessageForPubAccount messageForPubAccount = (MessageForPubAccount) q.d(MessageRecord.MSG_TYPE_PUBLIC_ACCOUNT);
        messageForPubAccount.msgtype = MessageRecord.MSG_TYPE_PUBLIC_ACCOUNT;
        messageForPubAccount.associatePubAccUin = j3;
        StringBuilder sb6 = new StringBuilder("");
        Iterator<im_msg_body$Elem> it5 = list.iterator();
        boolean z16 = false;
        PAMessage pAMessage = null;
        while (it5.hasNext()) {
            im_msg_body$Elem next = it5.next();
            if (next.text.has() && next.text.str.has()) {
                messageForPubAccount.f203106msg = sb6.toString();
                PAMessage pAMessage2 = new PAMessage();
                pAMessage2.f203110msg = sb6.toString();
                messageForPubAccount.msgData = ((IPublicAccountMessageUtil) QRoute.api(IPublicAccountMessageUtil.class)).toByteArray(pAMessage2);
                pAMessage = pAMessage2;
            } else if (next.trans_elem_info.has()) {
                im_msg_body$TransElem im_msg_body_transelem = next.trans_elem_info.get();
                int i16 = im_msg_body_transelem.elem_type.get();
                byte[] byteArray = im_msg_body_transelem.elem_value.get().toByteArray();
                if (i16 != i3) {
                    sb5.append("PubAccount Message type is not 16.\n");
                } else {
                    if (byteArray != null && byteArray.length != 0) {
                        if (byteArray[0] == 1) {
                            short shortData = PkgTools.getShortData(byteArray, 1);
                            c17 = 3;
                            byte b16 = byteArray[3];
                            int i17 = shortData - 1;
                            it = it5;
                            byte[] bArr = new byte[i17];
                            c16 = 4;
                            PkgTools.copyData(bArr, 0, byteArray, 4, i17);
                            if (b16 == 1) {
                                bArr = j1(bArr);
                            }
                            if (bArr != null) {
                                try {
                                    if (bArr.length > 0) {
                                        String str = new String(bArr, "utf-8");
                                        sb6.append(str);
                                        pAMessage = h1(str);
                                    }
                                } catch (Exception unused) {
                                    sb5.append("PubAccount Message parse decodeContext.mPamag exception.\n");
                                }
                            }
                            z16 = true;
                        } else {
                            it = it5;
                            c16 = 4;
                            c17 = 3;
                        }
                        x0(J, messageForPubAccount);
                    } else {
                        it = it5;
                        c16 = 4;
                        c17 = 3;
                        sb5.append("transElemByte is null or transElemByte.length == 0\n");
                    }
                    it5 = it;
                    i3 = 16;
                }
            }
            it = it5;
            c16 = 4;
            c17 = 3;
            it5 = it;
            i3 = 16;
        }
        PAMessage pAMessage3 = pAMessage;
        if (pAMessage3 != null) {
            L(list, pAMessage3);
            messageForPubAccount.mPAMessage = pAMessage3;
            messageForPubAccount.msgData = ((IPublicAccountMessageUtil) QRoute.api(IPublicAccountMessageUtil.class)).toByteArray(pAMessage3);
        }
        boolean z17 = z16;
        I(msg_comm_msg, j3, z17);
        list2.add(messageForPubAccount);
        if (!z17) {
            m(list, list2, sb5, msg_comm_msg, cVar);
        }
    }

    public void X0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, list, list2, sb5, msg_comm_msg, cVar);
            return;
        }
        a J1 = J1(list, sb5, msg_comm_msg.msg_head.msg_seq.get(), cVar, msg_comm_msg.msg_head.msg_time.get());
        MessageForReplyText.SourceMsgInfo sourceMsgInfo = J1.f286320a;
        if (sourceMsgInfo == null) {
            QLog.e("MessagePBElemDecoder", 1, "context.sourceMsgInfo is null");
        }
        if (J1.f286322c != null) {
            ChatMessage chatMessage = (ChatMessage) q.d(MessageRecord.MSG_TYPE_REPLY_TEXT);
            chatMessage.f203106msg = J1.f286322c;
            MessageForReplyText messageForReplyText = (MessageForReplyText) chatMessage;
            try {
                messageForReplyText.extLong |= 1;
                if (sourceMsgInfo != null && sourceMsgInfo.getSourceMsg() != null) {
                    messageForReplyText.setSourceMessageRecord(sourceMsgInfo.unPackSourceMsg(i1()));
                    if (messageForReplyText.getSourceMessage() != null && FileManagerUtil.isMessageRecordOfFile(messageForReplyText.getSourceMessage())) {
                        String extInfoFromExtStr = messageForReplyText.getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
                        ChatMessage changeRealChatMessage = FileManagerUtil.changeRealChatMessage((ChatMessage) messageForReplyText.getSourceMessage());
                        QFileUtils.k(i1(), changeRealChatMessage, messageForReplyText.getSourceMessage());
                        if (!TextUtils.isEmpty(extInfoFromExtStr) && changeRealChatMessage != null && ((parseInt = Integer.parseInt(extInfoFromExtStr)) == 1 || parseInt == 2)) {
                            QLog.i("MessagePBElemDecoder<QFile>", 1, "decode reply file msg, msg uniseq[" + changeRealChatMessage.uniseq + "]");
                            FileManagerUtil.getFileRecordForMultiMsg(i1(), changeRealChatMessage.uniseq, changeRealChatMessage.frienduin, changeRealChatMessage.istroop, (ChatMessage) messageForReplyText.getSourceMessage());
                        }
                    }
                }
                String bytes2HexStr = HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(sourceMsgInfo));
                messageForReplyText.mSourceMsgInfo = sourceMsgInfo;
                messageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", bytes2HexStr);
                if (QLog.isColorLevel()) {
                    QLog.d("SendMsgBtn", 2, "reply:" + messageForReplyText + " sourceMsg=" + messageForReplyText.getSourceMessage());
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + e16.getMessage());
                }
            }
            byte[] bArr = J1.f286321b;
            if (bArr != null) {
                chatMessage.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.bytes2HexStr(bArr));
            }
            ArrayList<AtTroopMemberInfo> arrayList = J1.f286325f;
            if (arrayList != null) {
                com.tencent.mobileqq.troop.text.a.n(cVar.f294892b, arrayList, chatMessage);
            }
            list2.add(chatMessage);
            if (QLog.isColorLevel()) {
                QLog.d("MessagePBElemDecoder", 2, "reply msgRand = " + s.e(chatMessage.msgUid) + ", msgUid = " + chatMessage.msgUid);
            }
        }
    }

    public void Y0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5) {
        im_msg_body$TipsInfo im_msg_body_tipsinfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, list, list2, sb5);
            return;
        }
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.tips_info.has()) {
                    im_msg_body_tipsinfo = next.tips_info.get();
                    break;
                }
            } else {
                im_msg_body_tipsinfo = null;
                break;
            }
        }
        if (im_msg_body_tipsinfo == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:TipsInfo;\n");
        }
        MessageForIncompatibleGrayTips messageForIncompatibleGrayTips = (MessageForIncompatibleGrayTips) q.d(MessageRecord.MSG_TYPE_INCOMPATIBLE_GRAY_TIPS);
        if (messageForIncompatibleGrayTips.parseTextXML(im_msg_body_tipsinfo.text.get()).booleanValue()) {
            list2.add(messageForIncompatibleGrayTips);
        } else if (QLog.isColorLevel()) {
            sb5.append("TipsInfo parse failed;\n");
        }
    }

    public void Z0(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, list, list2, sb5, msg_comm_msg, aVar);
            return;
        }
        im_msg_body$TransElem v06 = v0(list);
        im_msg_body$GeneralFlags u06 = u0(list);
        if (v06 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:TransElemInfo;\n");
        }
        int i3 = v06.elem_type.get();
        if (QLog.isColorLevel()) {
            sb5.append("transElemType:");
            sb5.append(i3);
            sb5.append(";\n");
        }
        byte[] byteArray = v06.elem_value.get().toByteArray();
        if (byteArray.length == 0) {
            sb5.append("transElemByte is null or transElemByte.length == 0\n");
        } else if (aVar != null && aVar.f286163r == 10014) {
            a1(list2, msg_comm_msg, v06, byteArray, aVar);
        } else {
            b1(list, list2, msg_comm_msg, v06, u06, i3, byteArray);
        }
    }

    @Override // com.tencent.mobileqq.service.message.v
    protected void b(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, im_msg_body$GeneralFlags im_msg_body_generalflags, boolean z16, MessageRecord messageRecord) {
        String str;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, list, list2, sb5, msg_comm_msg, cVar, im_msg_body_generalflags, Boolean.valueOf(z16), messageRecord);
            return;
        }
        if (!(messageRecord instanceof MessageForStructing)) {
            return;
        }
        MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
        if (messageForStructing.structingMsg == null) {
            if (QLog.isColorLevel()) {
                sb5.append("c2cMsgContent.data:null;\n");
            }
            n(list, list2, sb5, msg_comm_msg, cVar);
            return;
        }
        String str2 = null;
        if (im_msg_body_generalflags != null && im_msg_body_generalflags.bytes_pb_reserve.has()) {
            try {
                generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                generalflags_resvattr.mergeFrom(im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
                if (generalflags_resvattr.bytes_kpl_info.has() && generalflags_resvattr.bytes_kpl_info.has()) {
                    str = generalflags_resvattr.bytes_kpl_info.get().toStringUtf8();
                    z17 = true;
                } else {
                    str = null;
                    z17 = false;
                }
                if (generalflags_resvattr.bytes_oac_msg_extend.has()) {
                    messageForStructing.saveExtInfoToExtStr(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND, generalflags_resvattr.bytes_oac_msg_extend.get().toStringUtf8());
                }
                str2 = str;
                z18 = z17;
            } catch (Exception e16) {
                QLog.d(KplRoleInfo.KPL_TAG, 1, "parse proto catch exception about kpl");
                e16.printStackTrace();
            }
        }
        if (z18) {
            messageForStructing.saveExtInfoToExtStr(KplRoleInfo.MSG_EXT_KEY, "Y");
            if (QLog.isColorLevel()) {
                QLog.d(KplRoleInfo.KPL_TAG, 2, "resv a kpl struct message !");
            }
            KplHelper.handleKplFlag(i1(), str2);
        }
        if (n1(list2, z16, messageForStructing, im_msg_body_generalflags)) {
            return;
        }
        list2.add(messageForStructing);
    }

    public void c1(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5) {
        String stringUtf8;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, list, list2, sb5);
            return;
        }
        im_msg_body$Text im_msg_body_text = null;
        im_msg_body$CommonElem im_msg_body_commonelem = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.common_elem.has()) {
                im_msg_body_commonelem = im_msg_body_elem.common_elem.get();
                if (im_msg_body_text != null) {
                    break;
                }
            } else if (im_msg_body_elem.text.has()) {
                im_msg_body_text = im_msg_body_elem.text.get();
                if (im_msg_body_commonelem != null) {
                    break;
                }
            } else {
                continue;
            }
        }
        if (im_msg_body_commonelem == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:TroopStory;\n");
        }
        hummer_commelem$MsgElemInfo_servtype16 hummer_commelem_msgeleminfo_servtype16 = new hummer_commelem$MsgElemInfo_servtype16();
        try {
            hummer_commelem_msgeleminfo_servtype16.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            int i3 = hummer_commelem_msgeleminfo_servtype16.ctr_version.get();
            if (i3 > 1) {
                return;
            }
            MessageForTroopStory messageForTroopStory = (MessageForTroopStory) q.d(MessageRecord.MSG_TYPE_TROOP_STORY);
            messageForTroopStory.uid = hummer_commelem_msgeleminfo_servtype16.uid.get();
            messageForTroopStory.unionId = hummer_commelem_msgeleminfo_servtype16.unionID.get().toStringUtf8();
            messageForTroopStory.storyId = hummer_commelem_msgeleminfo_servtype16.storyID.get().toStringUtf8();
            messageForTroopStory.md5 = hummer_commelem_msgeleminfo_servtype16.md5.get().toStringUtf8();
            messageForTroopStory.thumbUrl = hummer_commelem_msgeleminfo_servtype16.thumbUrl.get().toStringUtf8();
            messageForTroopStory.doodleUrl = hummer_commelem_msgeleminfo_servtype16.doodleUrl.get().toStringUtf8();
            messageForTroopStory.videoWidth = hummer_commelem_msgeleminfo_servtype16.videoWidth.get();
            messageForTroopStory.videoHeight = hummer_commelem_msgeleminfo_servtype16.videoHeight.get();
            messageForTroopStory.sourceName = hummer_commelem_msgeleminfo_servtype16.sourceName.get().toStringUtf8();
            messageForTroopStory.sourceActionType = hummer_commelem_msgeleminfo_servtype16.sourceActionType.get().toStringUtf8();
            messageForTroopStory.sourceActionData = hummer_commelem_msgeleminfo_servtype16.sourceActionData.get().toStringUtf8();
            if (im_msg_body_text == null) {
                stringUtf8 = "";
            } else {
                stringUtf8 = im_msg_body_text.str.get().toStringUtf8();
            }
            messageForTroopStory.compatibleText = stringUtf8;
            messageForTroopStory.ctrVersion = i3;
            messageForTroopStory.f203106msg = MessageForTroopStory.MSG_CONTENT;
            messageForTroopStory.serial();
            list2.add(messageForTroopStory);
            if (QLog.isDevelopLevel()) {
                QLog.d("TroopStory", 4, messageForTroopStory.toDebugString());
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    public void d1(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, list, list2, sb5, msg_comm_msg, cVar, aVar, Boolean.valueOf(z16));
        } else {
            MessageForQQWalletMsg.decodePBMsgElemWalletMsg(this, i1(), list, list2, sb5, msg_comm_msg, cVar, aVar, z16);
        }
    }

    public String e1(List<im_msg_body$Elem> list) {
        int convertToLocal;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this, (Object) list);
        }
        StringBuilder sb5 = new StringBuilder("");
        int size = list.size();
        boolean z16 = false;
        for (int i3 = 0; i3 < size; i3++) {
            im_msg_body$Elem im_msg_body_elem = list.get(i3);
            if (im_msg_body_elem.text.has()) {
                if (z16) {
                    z16 = false;
                } else {
                    QLog.isColorLevel();
                    sb5.length();
                    im_msg_body$Text im_msg_body_text = im_msg_body_elem.text.get();
                    if (im_msg_body_text.str.has()) {
                        sb5.append(s.c(im_msg_body_text.str.get().toStringUtf8(), false));
                    }
                }
            } else if (im_msg_body_elem.f435954face.has()) {
                QLog.isColorLevel();
                if (im_msg_body_elem.f435954face.get().index.has() && (convertToLocal = QQSysFaceUtil.convertToLocal(im_msg_body_elem.f435954face.get().index.get())) >= 0) {
                    sb5.append((char) 20);
                    sb5.append((char) convertToLocal);
                }
            } else if (im_msg_body_elem.small_emoji.has()) {
                QLog.isColorLevel();
                if (im_msg_body_elem.small_emoji.get().packIdSum.has()) {
                    int i16 = (im_msg_body_elem.small_emoji.get().packIdSum.get() & SupportMenu.CATEGORY_MASK) >> 16;
                    int i17 = im_msg_body_elem.small_emoji.get().packIdSum.get() & 65535;
                    char[] k3 = com.tencent.mobileqq.emosm.e.k(i16, i17);
                    if (im_msg_body_elem.small_emoji.get().imageType.has() && (im_msg_body_elem.small_emoji.get().imageType.get() & 65535) == 2) {
                        k3[3] = '\u01ff';
                        if (QLog.isColorLevel()) {
                            QLog.d("MessagePBElemDecoder", 2, "get apng epid = " + i16 + " eid = " + i17);
                        }
                    }
                    sb5.append((char) 20);
                    sb5.append(k3[3]);
                    sb5.append(k3[2]);
                    z16 = true;
                    sb5.append(k3[1]);
                    sb5.append(k3[0]);
                }
            } else if (im_msg_body_elem.common_elem.has() && 33 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
                QLog.isColorLevel();
                sb5.append(G1(im_msg_body_elem.common_elem.get()));
            }
        }
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.service.message.v
    protected t g(im_msg_body$RichMsg im_msg_body_richmsg, List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (t) iPatchRedirector.redirect((short) 13, this, im_msg_body_richmsg, list, msg_comm_msg, im_msg_body_generalflags);
        }
        String e06 = e0(im_msg_body_richmsg.bytes_msg_resid.get());
        long j3 = msg_comm_msg.msg_head.to_uin.get();
        int i3 = msg_comm_msg.msg_head.msg_type.get();
        MessageForStructing messageForStructing = new MessageForStructing();
        byte[] g06 = g0(im_msg_body_richmsg);
        messageForStructing.msgtype = MessageRecord.MSG_TYPE_STRUCT_MSG;
        boolean c06 = c0(list, messageForStructing, e06);
        ab j16 = com.tencent.mobileqq.service.message.codec.decoder.k.j(msg_comm_msg, i1());
        d0(msg_comm_msg, g06, messageForStructing, e06, c06, j16);
        M(im_msg_body_generalflags, messageForStructing);
        return new t(messageForStructing, f0(im_msg_body_generalflags, g06, messageForStructing, j3, i3, e06, c06, j16));
    }

    protected ChatMessage g1(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, ArrayList<Object> arrayList, com.tencent.mobileqq.troop.data.c cVar, ArrayList<AtTroopMemberInfo> arrayList2, long j3, boolean z16, String str, String str2, boolean z17, long j16, String str3, boolean z18, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ChatMessage) iPatchRedirector.redirect((short) 24, this, list, msg_comm_msg, arrayList, cVar, arrayList2, Long.valueOf(j3), Boolean.valueOf(z16), str, str2, Boolean.valueOf(z17), Long.valueOf(j16), str3, Boolean.valueOf(z18), im_msg_body_generalflags);
        }
        if (z17) {
            MessageForFoldMsg messageForFoldMsg = new MessageForFoldMsg();
            messageForFoldMsg.init(z16, str, str2, j3, true);
            return messageForFoldMsg;
        }
        if (z18) {
            ChatMessage chatMessage = (ChatMessage) q.d(MessageRecord.MSG_TYPE_STRUCT_LONG_TEXT);
            chatMessage.saveExtInfoToExtStr("long_text_recv_state", "1");
            chatMessage.removeExtInfoToExtStr("long_text_msg_resid");
            return chatMessage;
        }
        if (j16 != 0) {
            MessageForWantGiftMsg messageForWantGiftMsg = new MessageForWantGiftMsg();
            messageForWantGiftMsg.wantGiftSenderUin = j16;
            messageForWantGiftMsg.saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, j16 + "");
            messageForWantGiftMsg.msgtype = MessageRecord.MSG_TYPE_TROOP_WANT_GIFT_MSG;
            return messageForWantGiftMsg;
        }
        ChatMessage j17 = super.j(list, msg_comm_msg, arrayList, cVar, arrayList2);
        if (cVar != null && arrayList2 != null) {
            com.tencent.mobileqq.troop.text.a.n(cVar.f294892b, arrayList2, j17);
        }
        if (str3 != null) {
            j17.saveExtInfoToExtStr(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND, str3);
        }
        return j17;
    }

    @Override // com.tencent.mobileqq.service.message.v
    protected boolean h(List<im_msg_body$Elem> list, List<MessageRecord> list2, msg_comm$Msg msg_comm_msg, im_msg_body$GeneralFlags im_msg_body_generalflags, im_msg_body$Text im_msg_body_text, byte[] bArr, long j3, MessageRecord messageRecord, long j16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, list, list2, msg_comm_msg, im_msg_body_generalflags, im_msg_body_text, bArr, Long.valueOf(j3), messageRecord, Long.valueOf(j16), Integer.valueOf(i3))).booleanValue();
        }
        if (!(messageRecord instanceof MessageForStructing)) {
            return false;
        }
        MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
        if (messageForStructing.structingMsg == null) {
            return false;
        }
        long j17 = j3;
        if (Q(list2, j17, messageForStructing)) {
            return true;
        }
        boolean P = P(msg_comm_msg);
        S(im_msg_body_generalflags, messageForStructing, P);
        U(list, messageForStructing);
        if (QLog.isColorLevel()) {
            QLog.d("MessagePBElemDecoder", 2, "decodePBMsgElems_RichMsg serviceId" + messageForStructing.structingMsg.mMsgServiceID);
        }
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        int i16 = absStructMsg.mMsgServiceID;
        if (i16 == 37) {
            return true;
        }
        if (i16 == 499) {
            return Z(list2, bArr, messageForStructing, j16, i3);
        }
        if (i16 == 52) {
            j17 = R(list2, msg_comm_msg, j3, messageForStructing);
        } else if (i16 == 80 && (absStructMsg instanceof StructMsgForGeneralShare)) {
            if (W(list2, im_msg_body_text, messageForStructing)) {
                return true;
            }
        } else {
            if (i16 == 118 && (absStructMsg instanceof StructMsgForGeneralShare)) {
                return Y(list2, im_msg_body_text, messageForStructing);
            }
            if (i16 == 104 && (absStructMsg instanceof StructMsgForGeneralShare)) {
                return O(list2, im_msg_body_generalflags, im_msg_body_text, messageForStructing, j16);
            }
            if (i16 == 90 && (absStructMsg instanceof StructMsgForGeneralShare)) {
                return a0(list2, messageForStructing);
            }
            if (s1(messageForStructing)) {
                V(messageForStructing);
            } else {
                AbsStructMsg absStructMsg2 = messageForStructing.structingMsg;
                int i17 = absStructMsg2.mMsgServiceID;
                if ((i17 == 5 || i17 == 137) && (absStructMsg2 instanceof StructMsgForImageShare)) {
                    T(list, messageForStructing);
                } else if (i17 == 106) {
                    X(messageForStructing);
                } else if (i17 == 126) {
                    return b0(list2, bArr, j16, i3);
                }
            }
        }
        N(msg_comm_msg.msg_head.msg_time.get(), Boolean.valueOf(P), j17, messageForStructing);
        AbsStructMsg absStructMsg3 = messageForStructing.structingMsg;
        if (absStructMsg3 != null) {
            absStructMsg3.mCompatibleText = s(list, list2, false);
            messageForStructing.msgData = messageForStructing.structingMsg.getBytes();
        }
        return false;
    }

    public QQAppInterface i1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QQAppInterface qQAppInterface = this.f286319b.get();
        if (qQAppInterface == null) {
            QQAppInterface qQAppInterface2 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            this.f286319b = new WeakReference<>(qQAppInterface2);
            QLog.i("MessagePBElemDecoder", 1, "getQQAppInterface == null");
            return qQAppInterface2;
        }
        return qQAppInterface;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b6  */
    @Override // com.tencent.mobileqq.service.message.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ChatMessage j(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, ArrayList<Object> arrayList, com.tencent.mobileqq.troop.data.c cVar, ArrayList<AtTroopMemberInfo> arrayList2) {
        byte[] bArr;
        String str;
        boolean z16;
        String str2;
        long j3;
        long j16;
        boolean z17;
        String str3;
        boolean z18;
        String str4;
        long j17;
        String str5;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ChatMessage) iPatchRedirector.redirect((short) 23, this, list, msg_comm_msg, arrayList, cVar, arrayList2);
        }
        im_msg_body$GeneralFlags k3 = k(list);
        boolean k06 = k0(list);
        int i06 = i0(list);
        int n06 = n0(list);
        String s06 = s0(list);
        int t06 = t0(list);
        String str6 = null;
        if (arrayList != null && arrayList.size() == 2 && arrayList.get(1) != null) {
            bArr = (byte[]) arrayList.get(1);
        } else {
            bArr = null;
        }
        long j18 = 0;
        if (k3 != null) {
            if (k3.bytes_pb_reserve.has()) {
                try {
                    generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                    generalflags_resvattr.mergeFrom(k3.bytes_pb_reserve.get().toByteArray());
                    if (generalflags_resvattr.redbag_msg_sender_uin.has()) {
                        try {
                            j17 = generalflags_resvattr.redbag_msg_sender_uin.get();
                            z18 = true;
                        } catch (Exception e16) {
                            e = e16;
                            z18 = true;
                            j16 = 0;
                            QLog.e("msgFold", 1, "prase ResvAttr error, ", e);
                            str4 = null;
                            if (!z18) {
                            }
                            if (z18) {
                            }
                            str3 = str5;
                            ChatMessage g16 = g1(list, msg_comm_msg, arrayList, cVar, arrayList2, j3, z16, str6, str2, z17, j16, str3, m0(k3), k3);
                            q0(g16);
                            l(msg_comm_msg, bArr, g16);
                            j0(k3, g16);
                            h0(k06, i06, g16);
                            o0(n06, g16);
                            l0(k3, g16);
                            r0(str, g16);
                            if (cVar != null) {
                            }
                            p0(t06, g16);
                            return g16;
                        }
                    } else {
                        j17 = 0;
                        z18 = false;
                    }
                    try {
                        if (generalflags_resvattr.want_gift_sender_uin.has()) {
                            j18 = generalflags_resvattr.want_gift_sender_uin.get();
                        }
                        if (generalflags_resvattr.bytes_oac_msg_extend.has()) {
                            str4 = generalflags_resvattr.bytes_oac_msg_extend.get().toStringUtf8();
                        } else {
                            str4 = null;
                        }
                        long j19 = j18;
                        j18 = j17;
                        j16 = j19;
                    } catch (Exception e17) {
                        e = e17;
                        long j26 = j18;
                        j18 = j17;
                        j16 = j26;
                        QLog.e("msgFold", 1, "prase ResvAttr error, ", e);
                        str4 = null;
                        if (!z18) {
                            j18 = k3.uint64_uin.get();
                            if (QLog.isColorLevel()) {
                            }
                            z18 = true;
                        }
                        if (z18) {
                        }
                        str3 = str5;
                        ChatMessage g162 = g1(list, msg_comm_msg, arrayList, cVar, arrayList2, j3, z16, str6, str2, z17, j16, str3, m0(k3), k3);
                        q0(g162);
                        l(msg_comm_msg, bArr, g162);
                        j0(k3, g162);
                        h0(k06, i06, g162);
                        o0(n06, g162);
                        l0(k3, g162);
                        r0(str, g162);
                        if (cVar != null) {
                        }
                        p0(t06, g162);
                        return g162;
                    }
                } catch (Exception e18) {
                    e = e18;
                    j16 = 0;
                    z18 = false;
                }
            } else {
                str4 = null;
                j16 = 0;
                z18 = false;
            }
            if (!z18 && k3.uint64_uin.has()) {
                j18 = k3.uint64_uin.get();
                if (QLog.isColorLevel()) {
                    QLog.d("msgFold", 2, "from old version");
                }
                z18 = true;
            }
            if (z18) {
                if (k3.uint32_prp_fold.get() == 1) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                String stringUtf8 = k3.bytes_rp_id.get().toStringUtf8();
                String stringUtf82 = k3.bytes_rp_index.get().toStringUtf8();
                boolean c16 = com.tencent.mobileqq.managers.g.c(i1());
                if (com.tencent.mobileqq.managers.g.d(i1()) && (!TextUtils.isEmpty(stringUtf8) || (!TextUtils.isEmpty(stringUtf82) && c16))) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (QLog.isColorLevel()) {
                    z16 = false;
                    str = s06;
                    str5 = str4;
                    QLog.d("msgFold", 2, String.format("Recv, recv foldMsg, redBagSender: %s, foldFlag: %s, redBagId: %s, index: %s, foldSwitch: %s, isValidFoldMsg: %s", Long.valueOf(j18), Boolean.valueOf(z19), stringUtf8, stringUtf82, Boolean.valueOf(com.tencent.mobileqq.managers.g.d(i1())), Boolean.valueOf(z26)));
                } else {
                    str5 = str4;
                    str = s06;
                    z16 = false;
                }
                if (!String.valueOf(msg_comm_msg.msg_head.from_uin.get()).equals(i1().getCurrentAccountUin())) {
                    z16 = z19;
                }
                str2 = stringUtf82;
                z17 = z26;
                str6 = stringUtf8;
                j3 = j18;
            } else {
                str5 = str4;
                str = s06;
                z16 = false;
                str2 = null;
                j3 = j18;
                z17 = false;
            }
            str3 = str5;
        } else {
            str = s06;
            z16 = false;
            str2 = null;
            j3 = 0;
            j16 = 0;
            z17 = false;
            str3 = null;
        }
        ChatMessage g1622 = g1(list, msg_comm_msg, arrayList, cVar, arrayList2, j3, z16, str6, str2, z17, j16, str3, m0(k3), k3);
        q0(g1622);
        l(msg_comm_msg, bArr, g1622);
        j0(k3, g1622);
        h0(k06, i06, g1622);
        o0(n06, g1622);
        l0(k3, g1622);
        r0(str, g1622);
        if (cVar != null || cVar.f294892b != 10014) {
            p0(t06, g1622);
        }
        return g1622;
    }

    @Override // com.tencent.mobileqq.service.message.v
    protected y p(StringBuilder sb5, long j3, com.tencent.mobileqq.troop.data.c cVar, ArrayList<AtTroopMemberInfo> arrayList, AtTroopMemberInfo atTroopMemberInfo, AtTroopMemberInfo atTroopMemberInfo2, byte[] bArr, StringBuilder sb6, boolean z16, im_msg_body$Elem im_msg_body_elem, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (y) iPatchRedirector.redirect((short) 20, this, sb5, Long.valueOf(j3), cVar, arrayList, atTroopMemberInfo, atTroopMemberInfo2, bArr, sb6, Boolean.valueOf(z16), im_msg_body_elem, Long.valueOf(j16));
        }
        return new b(i1(), sb5, j3, cVar, arrayList, atTroopMemberInfo, atTroopMemberInfo2, bArr, sb6, z16, im_msg_body_elem, j16);
    }

    public void p1(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, StringBuilder sb5) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, list, msg_comm_msg, sb5);
            return;
        }
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.common_elem.has()) {
                    im_msg_body_commonelem = next.common_elem.get();
                    break;
                }
            } else {
                im_msg_body_commonelem = null;
                break;
            }
        }
        if (im_msg_body_commonelem == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessagePBElemDecoder", 2, "QQ 18 Parse msg found common_lem elemType = UpdateStrangerAvatar;\n");
        }
        hummer_commelem$MsgElemInfo_servtype13 hummer_commelem_msgeleminfo_servtype13 = new hummer_commelem$MsgElemInfo_servtype13();
        try {
            hummer_commelem_msgeleminfo_servtype13.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            if (hummer_commelem_msgeleminfo_servtype13.uint32_sys_head_id.has() && hummer_commelem_msgeleminfo_servtype13.uint32_head_flag.has()) {
                int i3 = hummer_commelem_msgeleminfo_servtype13.uint32_sys_head_id.get();
                int i16 = hummer_commelem_msgeleminfo_servtype13.uint32_head_flag.get();
                if (QLog.isColorLevel()) {
                    QLog.d("MessagePBElemDecoder", 2, "QQ 18 elemType:UpdateStrangerAvatar system id = " + i3 + ", headType = " + i16);
                }
                String valueOf = String.valueOf(msg_comm_msg.msg_head.get().from_uin.get());
                com.tencent.mobileqq.app.utils.b bVar = (com.tencent.mobileqq.app.utils.b) i1().getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
                if (bVar != null && bVar.h()) {
                    bVar.j(valueOf, i3, i16);
                }
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
    }

    public void v1(im_msg_body$Elem im_msg_body_elem, im_msg_body$CustomFace im_msg_body_customface, List<MessageRecord> list, StringBuilder sb5, msg_comm$Msg msg_comm_msg, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, im_msg_body_elem, im_msg_body_customface, list, sb5, msg_comm_msg, Boolean.valueOf(z16));
        } else {
            w1(im_msg_body_elem, im_msg_body_customface, list, sb5, msg_comm_msg, z16, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0320  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w1(im_msg_body$Elem im_msg_body_elem, im_msg_body$CustomFace im_msg_body_customface, List<MessageRecord> list, StringBuilder sb5, msg_comm$Msg msg_comm_msg, boolean z16, com.tencent.mobileqq.troop.data.c cVar) {
        int i3;
        int i16;
        int i17;
        o oVar;
        CustomFaceExtPb$ResvAttr customFaceExtPb$ResvAttr;
        msg_comm$Msg msg_comm_msg2;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, im_msg_body_elem, im_msg_body_customface, list, sb5, msg_comm_msg, Boolean.valueOf(z16), cVar);
            return;
        }
        boolean C1 = C1(im_msg_body_elem);
        boolean B1 = B1(im_msg_body_customface);
        if (QLog.isColorLevel()) {
            sb5.append("elemType:CustomFace: isC2C:");
            sb5.append(z16);
            sb5.append(";\n");
        }
        StringBuilder sb6 = new StringBuilder();
        if (x1(msg_comm_msg, z16, sb6)) {
            return;
        }
        A1(list, C1, B1, sb6);
        im_msg_body$CustomFace y16 = y1(im_msg_body_elem, im_msg_body_customface, C1);
        if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "parsePBMsgElemsCustomFace hasComFlashPic=" + B1);
        }
        if (y16 == null) {
            QLog.d("MessagePBElemDecoder", 2, "parsePBMsgElemsCustomFace customface is null");
            return;
        }
        String str = y16.str_file_path.get();
        String str2 = y16.str_big_url.get();
        String str3 = y16.str_orig_url.get();
        String str4 = y16.str_thumb_url.get();
        String str5 = y16.str_400_url.get();
        int i18 = y16.uint32_thumb_width.get();
        int i19 = y16.uint32_thumb_height.get();
        if (QLog.isColorLevel()) {
            QLog.d("MessagePBElemDecoder", 2, "[CustomFace] ThumbWidth=" + i18 + ",ThumbHeight=" + i19 + "downURLBigThum400=" + str5);
        }
        int i26 = y16.uint32_show_len.get();
        int i27 = y16.uint32_download_len.get();
        long j3 = y16.uint32_file_id.get() & 4294967295L;
        long j16 = y16.uint32_size.get() & 4294967295L;
        int i28 = y16.image_type.get();
        if (QLog.isColorLevel()) {
            StringBuilder sb7 = new StringBuilder();
            i3 = i18;
            sb7.append("[CustomFace] uint32_size=");
            sb7.append(j16);
            QLog.d("MessagePBElemDecoder", 2, sb7.toString());
            QLog.d("MessagePBElemDecoder", 2, "[CustomFace] imgType=" + i28);
        } else {
            i3 = i18;
        }
        if (QLog.isDevelopLevel()) {
            i16 = i28;
            QLog.d("peak_pgjpeg", 4, "MessageProtoCodec.decodePBMsgElems(): showLen " + i26 + ", downloadLen " + i27 + ", fileLen " + j16);
        } else {
            i16 = i28;
        }
        byte[] byteArray = y16.bytes_md5.get().toByteArray();
        byte[] byteArray2 = y16.bytes_signature.get().toByteArray();
        byte[] byteArray3 = y16.bytes_flag.get().toByteArray();
        int i29 = (int) (y16.uint32_width.get() & 4294967295L);
        int i36 = (int) (y16.uint32_height.get() & 4294967295L);
        String bytes2HexStr = HexUtil.bytes2HexStr(byteArray);
        HexUtil.bytes2HexStr(byteArray2);
        HexUtil.bytes2HexStr(byteArray3);
        int i37 = y16.uint32_origin.get();
        String makeTransFileProtocolData = TransfileUtile.makeTransFileProtocolData(str, 0L, 1, false, str, bytes2HexStr, "picplatform", str4, str5, str2, str3, i37, 0);
        RichMsg$PicRec richMsg$PicRec = new RichMsg$PicRec();
        richMsg$PicRec.localPath.set(str);
        richMsg$PicRec.size.set(j16);
        richMsg$PicRec.type.set(1);
        richMsg$PicRec.isRead.set(false);
        richMsg$PicRec.uuid.set(str);
        richMsg$PicRec.groupFileID.set(j3);
        if (bytes2HexStr != null) {
            richMsg$PicRec.md5.set(bytes2HexStr);
        }
        richMsg$PicRec.serverStorageSource.set("picplatform");
        richMsg$PicRec.thumbMsgUrl.set(str4);
        richMsg$PicRec.bigthumbMsgUrl.set(str5);
        richMsg$PicRec.uint32_thumb_width.set(i3);
        richMsg$PicRec.uint32_thumb_height.set(i19);
        richMsg$PicRec.uint32_width.set(i29);
        richMsg$PicRec.uint32_height.set(i36);
        richMsg$PicRec.bigMsgUrl.set(str2);
        richMsg$PicRec.rawMsgUrl.set(str3);
        richMsg$PicRec.fileSizeFlag.set(0);
        richMsg$PicRec.uiOperatorFlag.set(0);
        richMsg$PicRec.version.set(5);
        richMsg$PicRec.isReport.set(0);
        richMsg$PicRec.fileSizeFlag.set(i37);
        if (i37 == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("MessagePBElemDecoder", 2, "[customFace] showLen =" + i26 + ",downloadLen = " + i27 + ",raw photo msg,clear progressjpg info!");
            }
            i17 = 0;
            i27 = 0;
        } else {
            i17 = i26;
        }
        richMsg$PicRec.uint32_show_len.set(i17);
        richMsg$PicRec.uint32_download_len.set(i27);
        richMsg$PicRec.enableEnc.set(true);
        richMsg$PicRec.uint32_image_type.set(i16);
        if (QLog.isColorLevel()) {
            sb5.append("protocolStr:");
            sb5.append(makeTransFileProtocolData);
            sb5.append("\n");
        }
        if (y16.bytes_pb_reserve.has()) {
            richMsg$PicRec.bytes_pb_reserved.set(y16.bytes_pb_reserve.get());
        }
        if (y16.bytes_pb_reserve.has()) {
            oVar = this;
            customFaceExtPb$ResvAttr = oVar.E1(y16);
            if (customFaceExtPb$ResvAttr.msg_image_show.has()) {
                z17 = true;
                msg_comm_msg2 = msg_comm_msg;
                MessageForPic D1 = oVar.D1(msg_comm_msg2, z17, customFaceExtPb$ResvAttr);
                oVar.z1(C1, B1, D1);
                if (cVar != null) {
                    D1.istroop = cVar.f294892b;
                }
                D1.msgData = richMsg$PicRec.toByteArray();
                D1.parse();
                list.add(D1);
                sb6.delete(0, sb6.length());
            }
        } else {
            oVar = this;
            customFaceExtPb$ResvAttr = null;
        }
        msg_comm_msg2 = msg_comm_msg;
        z17 = false;
        MessageForPic D12 = oVar.D1(msg_comm_msg2, z17, customFaceExtPb$ResvAttr);
        oVar.z1(C1, B1, D12);
        if (cVar != null) {
        }
        D12.msgData = richMsg$PicRec.toByteArray();
        D12.parse();
        list.add(D12);
        sb6.delete(0, sb6.length());
    }

    public boolean x(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, list, list2, sb5, msg_comm_msg)).booleanValue();
        }
        Iterator<im_msg_body$Elem> it = list.iterator();
        im_msg_body$Elem im_msg_body_elem = null;
        String str = null;
        String str2 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            im_msg_body$Elem next = it.next();
            if (next.deliver_gift_msg.has()) {
                im_msg_body_elem = next;
                break;
            }
            if (next.pub_group.has()) {
                str = next.pub_group.bytes_nickname.get().toStringUtf8();
            }
            if (next.text.has()) {
                String stringUtf8 = next.text.get().str.get().toStringUtf8();
                if (stringUtf8.startsWith("@")) {
                    str2 = stringUtf8.substring(1);
                }
            }
        }
        if (im_msg_body_elem == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:GiftMsg;\n");
        }
        MessageForDeliverGiftTips w3 = w(str, str2, im_msg_body_elem.deliver_gift_msg, list2, sb5, msg_comm_msg);
        Intent intent = new Intent("tencent.video.q2v.VideoSendGift");
        intent.putExtra("data", im_msg_body_elem.deliver_gift_msg.toByteArray());
        intent.putExtra("troopUin", w3.grayTipsEntity.troopUin);
        intent.putExtra("shmsgSeq", msg_comm_msg.msg_head.msg_seq.get());
        intent.putExtra("senderName", w3.senderName);
        intent.putExtra("rcvName", w3.rcvName);
        i1().getApp().sendBroadcast(intent);
        return true;
    }

    private void M(im_msg_body$GeneralFlags im_msg_body_generalflags, MessageForStructing messageForStructing) {
    }

    private void R0(im_msg_body$GeneralFlags im_msg_body_generalflags, List<MessageRecord> list) {
    }

    private void j0(im_msg_body$GeneralFlags im_msg_body_generalflags, ChatMessage chatMessage) {
    }
}
