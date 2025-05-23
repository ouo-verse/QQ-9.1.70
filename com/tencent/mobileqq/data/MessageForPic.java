package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.multimsg.api.IMultiMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pic.ReportInfo;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicValue;
import com.tencent.mobileqq.pic.k;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.t;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.i;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import localpb.richMsg.RichMsg$ForwardExtra;
import localpb.richMsg.RichMsg$PicRec;
import mqq.app.MobileQQ;
import msf.msgsvc.msg_ctrl$MsgCtrl;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb$ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb$ResvAttr;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$NotOnlineImage;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes10.dex */
public class MessageForPic extends MessageForRichText implements t, Parcelable {
    public static final String CHECK_IMAGE_TYPE = "check_image_type";
    public static final Parcelable.Creator<MessageForPic> CREATOR = new a();
    private static final String TAG = "MessageForPic";
    public static int defaultSuMsgId = -1;
    public String SpeedInfo;
    public String actMsgContentValue;
    public String action;
    public String bigMsgUrl;
    public String bigThumbMsgUrl;
    public int busiType;
    public int fileSizeFlag;
    public long groupFileID;
    public long height;
    public int imageType;
    public boolean isInMixedMsg;
    public boolean isMixed;
    public boolean isRead;
    public boolean isShareAppActionMsg;
    public String localUUID;
    public int mCurrlength;
    public int mDownloadLength;
    public long mPresendTransferedSize;
    public int mShowLength;
    public String md5;

    @RecordForTest
    public msg_ctrl$MsgCtrl msgCtrl;
    public int msgVia;
    public int ntChatType;
    public String ntPeerUid;
    public String path;
    public PicMessageExtraData picExtraData;
    public int picExtraFlag;
    public Object picExtraObject;
    public int previewed;
    public String rawMsgUrl;
    public ReportInfo reportInfo;
    public MsgRecordParams rootMsgRecordParams;
    public String serverStoreSource;
    public long shareAppID;
    public long size;
    public long subTypeId;
    public int thumbHeight;
    public String thumbMsgUrl;
    public int thumbWidth;
    public ThumbWidthHeightDP thumbWidthHeightDP;
    public int type;
    public String uuid;
    public long width;
    public Map<p, Integer> forwardId = new HashMap();
    public boolean isDownStatusReady = false;
    public int subMsgId = defaultSuMsgId;
    public int isReport = 0;
    public int subVersion = 5;
    public int preDownState = -1;
    public int preDownNetworkType = -1;
    public long DSKey = 0;
    public int mNotPredownloadReason = 0;
    public int subThumbWidth = -1;
    public int subThumbHeight = -1;
    public int aiofileType = -1;
    public int subMsgType = -1;
    public boolean bEnableEnc = false;
    public int thumbSize = -1;
    public boolean isBlessPic = false;
    public boolean sync2Story = false;
    public boolean isQzonePic = false;
    public boolean isStoryPhoto = false;
    public long replyRealSourceMsgId = -1;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<MessageForPic> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageForPic createFromParcel(Parcel parcel) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            MessageForPic messageForPic = new MessageForPic();
            messageForPic.path = parcel.readString();
            messageForPic.size = parcel.readLong();
            messageForPic.type = parcel.readInt();
            boolean z26 = false;
            if (parcel.readInt() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            messageForPic.isRead = z16;
            messageForPic.uuid = parcel.readString();
            messageForPic.groupFileID = parcel.readLong();
            messageForPic.md5 = parcel.readString();
            messageForPic.serverStoreSource = parcel.readString();
            messageForPic.thumbMsgUrl = parcel.readString();
            messageForPic.bigThumbMsgUrl = parcel.readString();
            messageForPic.thumbWidth = parcel.readInt();
            messageForPic.thumbHeight = parcel.readInt();
            messageForPic.bigMsgUrl = parcel.readString();
            messageForPic.rawMsgUrl = parcel.readString();
            messageForPic.fileSizeFlag = parcel.readInt();
            messageForPic.picExtraFlag = parcel.readInt();
            if (parcel.readInt() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            messageForPic.isMixed = z17;
            if (parcel.readInt() == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            messageForPic.isShareAppActionMsg = z18;
            messageForPic.action = parcel.readString();
            messageForPic.shareAppID = parcel.readLong();
            messageForPic.actMsgContentValue = parcel.readString();
            messageForPic.localUUID = parcel.readString();
            messageForPic.subMsgId = parcel.readInt();
            messageForPic.isReport = parcel.readInt();
            messageForPic.subVersion = parcel.readInt();
            messageForPic.busiType = parcel.readInt();
            messageForPic.width = parcel.readLong();
            messageForPic.height = parcel.readLong();
            messageForPic.imageType = parcel.readInt();
            messageForPic.frienduin = parcel.readString();
            messageForPic.selfuin = parcel.readString();
            messageForPic.senderuin = parcel.readString();
            messageForPic.istroop = parcel.readInt();
            messageForPic.versionCode = parcel.readInt();
            messageForPic.uniseq = parcel.readLong();
            messageForPic.issend = parcel.readInt();
            messageForPic.time = parcel.readLong();
            messageForPic.msgtype = parcel.readInt();
            messageForPic.preDownState = parcel.readInt();
            messageForPic.preDownNetworkType = parcel.readInt();
            messageForPic.previewed = parcel.readInt();
            messageForPic.mNotPredownloadReason = parcel.readInt();
            messageForPic.reportInfo = (ReportInfo) parcel.readParcelable(ReportInfo.class.getClassLoader());
            if (parcel.readByte() != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            messageForPic.sync2Story = z19;
            if (parcel.readInt() == 1) {
                z26 = true;
            }
            messageForPic.isQzonePic = z26;
            return messageForPic;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageForPic[] newArray(int i3) {
            return new MessageForPic[i3];
        }
    }

    public boolean checkGif() {
        int i3 = this.imageType;
        if (i3 != 3 && i3 != 2000) {
            return false;
        }
        return true;
    }

    public void checkType() {
        File file;
        if (this.imageType == 0 && !isSendFromLocal() && TextUtils.isEmpty(getExtInfoFromExtStr(CHECK_IMAGE_TYPE)) && (file = AbsDownloader.getFile(((IPicHelper) QRoute.api(IPicHelper.class)).getURL(this, 1, (String) null).toString())) != null) {
            if (GifDrawable.isGifFile(file)) {
                this.imageType = 2000;
                updateMessage();
            }
            saveExtInfoToExtStr(CHECK_IMAGE_TYPE, String.valueOf(true));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        boolean z16;
        boolean z17;
        String str;
        int i3;
        RichMsg$ForwardExtra richMsg$ForwardExtra;
        RichMsg$PicRec richMsg$PicRec = new RichMsg$PicRec();
        try {
            richMsg$PicRec.mergeFrom(this.msgData);
            z16 = true;
        } catch (Exception e16) {
            e16.printStackTrace();
            z16 = false;
        }
        if (z16) {
            this.path = richMsg$PicRec.localPath.get();
            this.size = richMsg$PicRec.size.get();
            this.type = richMsg$PicRec.type.get();
            this.isRead = richMsg$PicRec.isRead.get();
            this.uuid = richMsg$PicRec.uuid.get();
            this.groupFileID = richMsg$PicRec.groupFileID.get();
            this.md5 = richMsg$PicRec.md5.get();
            this.serverStoreSource = richMsg$PicRec.serverStorageSource.get();
            if (this.istroop != 10014) {
                this.thumbMsgUrl = richMsg$PicRec.thumbMsgUrl.get();
                this.bigThumbMsgUrl = richMsg$PicRec.bigthumbMsgUrl.get();
            }
            this.thumbWidth = richMsg$PicRec.uint32_thumb_width.get();
            this.thumbHeight = richMsg$PicRec.uint32_thumb_height.get();
            this.width = richMsg$PicRec.uint32_width.get();
            this.height = richMsg$PicRec.uint32_height.get();
            this.imageType = richMsg$PicRec.uint32_image_type.get();
            this.bigMsgUrl = richMsg$PicRec.bigMsgUrl.get();
            this.rawMsgUrl = richMsg$PicRec.rawMsgUrl.get();
            this.isReport = richMsg$PicRec.isReport.get();
            this.subVersion = richMsg$PicRec.version.get();
            this.picExtraFlag = richMsg$PicRec.uiOperatorFlag.get();
            this.fileSizeFlag = richMsg$PicRec.fileSizeFlag.get();
            this.localUUID = richMsg$PicRec.localUUID.get();
            this.preDownState = richMsg$PicRec.preDownState.get();
            this.preDownNetworkType = richMsg$PicRec.preDownNetwork.get();
            this.previewed = richMsg$PicRec.previewed.get();
            this.mShowLength = richMsg$PicRec.uint32_show_len.get();
            this.mDownloadLength = richMsg$PicRec.uint32_download_len.get();
            this.mCurrlength = richMsg$PicRec.uint32_current_len.get();
            this.mNotPredownloadReason = richMsg$PicRec.notPredownloadReason.get();
            this.bEnableEnc = richMsg$PicRec.enableEnc.get();
            this.isStoryPhoto = richMsg$PicRec.bool_story_pic_send_to_recent.get();
            if (richMsg$PicRec.fowardInfo.has() && (richMsg$ForwardExtra = richMsg$PicRec.fowardInfo.get()) != null) {
                PicFowardDbRecordData picFowardDbRecordData = new PicFowardDbRecordData();
                picFowardDbRecordData.fowardOrgId = richMsg$ForwardExtra.foward_orgId.get();
                picFowardDbRecordData.fowardOrgUin = richMsg$ForwardExtra.foward_orgUin.get();
                picFowardDbRecordData.fowardOrgUinType = richMsg$ForwardExtra.foward_orgUinType.get();
                picFowardDbRecordData.fowardOrgFileSizeType = richMsg$ForwardExtra.foward_orgFileSizeType.get();
                picFowardDbRecordData.fowardOrgUrl = richMsg$ForwardExtra.foward_orgUrl.get();
                picFowardDbRecordData.fowardThumbPath = richMsg$ForwardExtra.foward_thumbPath.get();
                this.picExtraObject = picFowardDbRecordData;
            }
            if (richMsg$PicRec.bytes_pb_reserved.has() && this.picExtraData == null) {
                byte[] byteArray = richMsg$PicRec.bytes_pb_reserved.get().toByteArray();
                try {
                    if (this.istroop == 0) {
                        NotOnlineImageExtPb$ResvAttr notOnlineImageExtPb$ResvAttr = new NotOnlineImageExtPb$ResvAttr();
                        notOnlineImageExtPb$ResvAttr.mergeFrom(byteArray);
                        this.picExtraData = new PicMessageExtraData(notOnlineImageExtPb$ResvAttr);
                    } else {
                        CustomFaceExtPb$ResvAttr customFaceExtPb$ResvAttr = new CustomFaceExtPb$ResvAttr();
                        customFaceExtPb$ResvAttr.mergeFrom(byteArray);
                        this.picExtraData = new PicMessageExtraData(customFaceExtPb$ResvAttr);
                    }
                } catch (InvalidProtocolBufferMicroException e17) {
                    e17.printStackTrace();
                }
            }
        } else {
            if (this.f203106msg == null) {
                try {
                    if (this.versionCode > 0) {
                        this.f203106msg = new String(this.msgData, "UTF-8");
                    }
                } catch (Exception e18) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, e18.getMessage());
                    }
                }
            }
            boolean h16 = com.tencent.mobileqq.utils.c.h(this.msgtype);
            this.isShareAppActionMsg = h16;
            if (!h16 && (i3 = this.msgtype) != -3001 && i3 != -30002 && i3 != -30003 && i3 != -1032) {
                z17 = false;
            } else {
                z17 = true;
            }
            this.isMixed = z17;
            if (z17) {
                MsgBody a16 = com.tencent.mobileqq.utils.c.a(this.f203106msg);
                this.action = a16.action;
                this.shareAppID = a16.shareAppID;
                this.actMsgContentValue = a16.actMsgContentValue;
                str = a16.f24895msg;
            } else {
                str = this.f203106msg;
            }
            ((IPicHelper) QRoute.api(IPicHelper.class)).parseDbMsgOldVersion(this, str);
            this.subVersion = 0;
        }
        this.mIsParsed = true;
        ((IPicValue) QRoute.api(IPicValue.class)).fillStickInfo(this);
        if ("1".equals(getExtInfoFromExtStr(i.f286270m))) {
            this.sync2Story = true;
        } else {
            this.sync2Story = false;
        }
        this.isQzonePic = "1".equals(getExtInfoFromExtStr(i.f286275r));
    }

    public String getFilePath(String str) {
        if (isSendFromLocal()) {
            v picUploadInfo = getPicUploadInfo();
            picUploadInfo.I = str;
            return picUploadInfo.d();
        }
        k picDownloadInfo = getPicDownloadInfo();
        picDownloadInfo.I = str;
        return picDownloadInfo.d();
    }

    public int getNTRootChatType() {
        MsgRecordParams msgRecordParams = this.rootMsgRecordParams;
        if (msgRecordParams != null) {
            return msgRecordParams.a();
        }
        return this.ntChatType;
    }

    public long getNTRootMsgId() {
        MsgRecordParams msgRecordParams = this.rootMsgRecordParams;
        if (msgRecordParams != null) {
            return msgRecordParams.b();
        }
        return this.uniseq;
    }

    public String getNTRootPeerUid() {
        MsgRecordParams msgRecordParams = this.rootMsgRecordParams;
        if (msgRecordParams != null) {
            return msgRecordParams.e();
        }
        return this.ntPeerUid;
    }

    @Override // com.tencent.mobileqq.pic.t
    public k getPicDownloadInfo() {
        k kVar = new k();
        kVar.f258712f = this.busiType;
        kVar.D = this.uniseq;
        processSessionInfo(kVar);
        kVar.S = this.time;
        kVar.K = this.uuid;
        kVar.J = this.md5;
        kVar.L = this.groupFileID;
        kVar.M = this.thumbMsgUrl;
        kVar.Q = this.bigThumbMsgUrl;
        kVar.N = this.bigMsgUrl;
        kVar.P = this.rawMsgUrl;
        kVar.f258724a0 = this.subMsgId;
        boolean z16 = this.isMixed;
        kVar.V = z16;
        if (z16) {
            kVar.X = this.action;
            kVar.Z = this.actMsgContentValue;
            kVar.Y = this.shareAppID;
        }
        kVar.R = this.fileSizeFlag;
        kVar.E = this.extraflag;
        kVar.F = this.picExtraObject;
        kVar.G = this.subVersion;
        kVar.f258711e = this.localUUID;
        kVar.U = this.size;
        kVar.f258729f0 = this.bEnableEnc;
        if (this.reportInfo == null) {
            this.reportInfo = new ReportInfo();
        }
        kVar.f258728e0 = this.reportInfo;
        return kVar;
    }

    public PicElement getPicElement() {
        Object obj = this.extObj;
        if (obj instanceof MsgElement) {
            return ((MsgElement) obj).getPicElement();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pic.t
    public v getPicUploadInfo() {
        v vVar = new v();
        vVar.f258712f = this.busiType;
        vVar.D = this.uniseq;
        vVar.f258713h = this.istroop;
        vVar.f258715m = this.frienduin;
        vVar.f258714i = this.selfuin;
        vVar.C = this.senderuin;
        vVar.J = this.md5;
        vVar.K = this.path;
        vVar.L = this.thumbMsgUrl;
        vVar.E = this.picExtraFlag;
        vVar.F = this.picExtraObject;
        vVar.f258711e = this.localUUID;
        vVar.G = this.subVersion;
        vVar.f258815a0 = (int) this.width;
        vVar.f258816b0 = (int) this.height;
        vVar.f258817c0 = (int) this.size;
        vVar.f258819e0 = this.imageType;
        return vVar;
    }

    public ReportInfo getReportInfo() {
        if (this.reportInfo == null) {
            this.reportInfo = new ReportInfo();
        }
        return this.reportInfo;
    }

    public im_msg_body$RichText getRichText() {
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        int i3 = this.istroop;
        if (i3 != 1 && i3 != 3000) {
            im_msg_body$NotOnlineImage im_msg_body_notonlineimage = new im_msg_body$NotOnlineImage();
            im_msg_body_notonlineimage.file_len.set((int) this.size);
            im_msg_body_notonlineimage.img_type.set(this.imageType);
            im_msg_body_notonlineimage.str_thumb_url.set(this.thumbMsgUrl);
            im_msg_body_notonlineimage.str_400_url.set(this.bigThumbMsgUrl);
            im_msg_body_notonlineimage.uint32_thumb_width.set(this.thumbWidth);
            im_msg_body_notonlineimage.uint32_thumb_height.set(this.thumbHeight);
            im_msg_body_notonlineimage.uint32_file_id.set((int) this.groupFileID);
            im_msg_body_notonlineimage.str_big_url.set(this.bigMsgUrl);
            im_msg_body_notonlineimage.str_orig_url.set(this.rawMsgUrl);
            im_msg_body_notonlineimage.pic_width.set((int) this.width);
            im_msg_body_notonlineimage.pic_height.set((int) this.height);
            im_msg_body_notonlineimage.uint32_show_len.set(this.mShowLength);
            im_msg_body_notonlineimage.uint32_download_len.set(this.mDownloadLength);
            im_msg_body_notonlineimage.original.set(this.fileSizeFlag);
            im_msg_body_notonlineimage.pic_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.md5)));
            if (TextUtils.isEmpty(this.uuid)) {
                String str = this.md5;
                if (str == null) {
                    str = "";
                }
                this.uuid = str;
            }
            im_msg_body_notonlineimage.res_id.set(ByteStringMicro.copyFromUtf8(this.uuid));
            PicMessageExtraData picMessageExtraData = this.picExtraData;
            if (picMessageExtraData != null) {
                im_msg_body_notonlineimage.bytes_pb_reserve.set(ByteStringMicro.copyFrom(picMessageExtraData.getOfflineImageResvAttr().get().toByteArray()), true);
            }
            im_msg_body_elem.not_online_image.set(im_msg_body_notonlineimage);
        } else {
            im_msg_body$CustomFace im_msg_body_customface = new im_msg_body$CustomFace();
            String str2 = this.uuid;
            if (str2 != null) {
                im_msg_body_customface.str_file_path.set(str2);
            } else {
                im_msg_body_customface.str_file_path.set(this.md5);
            }
            im_msg_body_customface.str_big_url.set(this.bigMsgUrl);
            im_msg_body_customface.str_orig_url.set(this.rawMsgUrl);
            im_msg_body_customface.str_thumb_url.set(this.thumbMsgUrl);
            im_msg_body_customface.str_400_url.set(this.bigThumbMsgUrl);
            im_msg_body_customface.uint32_thumb_width.set(this.thumbWidth);
            im_msg_body_customface.uint32_thumb_height.set(this.thumbHeight);
            im_msg_body_customface.uint32_show_len.set(this.mShowLength);
            im_msg_body_customface.uint32_download_len.set(this.mDownloadLength);
            im_msg_body_customface.uint32_file_id.set((int) this.groupFileID);
            im_msg_body_customface.uint32_size.set((int) this.size);
            im_msg_body_customface.image_type.set(this.imageType);
            im_msg_body_customface.bytes_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.md5)));
            im_msg_body_customface.uint32_width.set((int) this.width);
            im_msg_body_customface.uint32_height.set((int) this.height);
            im_msg_body_customface.uint32_origin.set(this.fileSizeFlag);
            PicMessageExtraData picMessageExtraData2 = this.picExtraData;
            if (picMessageExtraData2 != null) {
                im_msg_body_customface.bytes_pb_reserve.set(ByteStringMicro.copyFrom(picMessageExtraData2.getCustomFaceResvAttr().get().toByteArray()), true);
            }
            im_msg_body_elem.custom_face.set(im_msg_body_customface);
        }
        im_msg_body_richtext.elems.add(im_msg_body_elem);
        return im_msg_body_richtext;
    }

    public RichMsg$PicRec getSerialPB() {
        RichMsg$PicRec richMsg$PicRec = new RichMsg$PicRec();
        richMsg$PicRec.setHasFlag(true);
        PBStringField pBStringField = richMsg$PicRec.localPath;
        String str = this.path;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        richMsg$PicRec.size.set(this.size);
        richMsg$PicRec.type.set(this.type);
        richMsg$PicRec.isRead.set(this.isRead);
        PBStringField pBStringField2 = richMsg$PicRec.uuid;
        String str3 = this.uuid;
        if (str3 == null) {
            str3 = "";
        }
        pBStringField2.set(str3);
        richMsg$PicRec.groupFileID.set(this.groupFileID);
        PBStringField pBStringField3 = richMsg$PicRec.md5;
        String str4 = this.md5;
        if (str4 == null) {
            str4 = "";
        }
        pBStringField3.set(str4);
        PBStringField pBStringField4 = richMsg$PicRec.serverStorageSource;
        String str5 = this.serverStoreSource;
        if (str5 == null) {
            str5 = "";
        }
        pBStringField4.set(str5);
        PBStringField pBStringField5 = richMsg$PicRec.thumbMsgUrl;
        String str6 = this.thumbMsgUrl;
        if (str6 == null) {
            str6 = "";
        }
        pBStringField5.set(str6);
        PBStringField pBStringField6 = richMsg$PicRec.bigthumbMsgUrl;
        String str7 = this.bigThumbMsgUrl;
        if (str7 == null) {
            str7 = "";
        }
        pBStringField6.set(str7);
        richMsg$PicRec.uint32_thumb_width.set(this.thumbWidth);
        richMsg$PicRec.uint32_thumb_height.set(this.thumbHeight);
        richMsg$PicRec.uint32_width.set((int) this.width);
        richMsg$PicRec.uint32_height.set((int) this.height);
        richMsg$PicRec.uint32_image_type.set(this.imageType);
        PBStringField pBStringField7 = richMsg$PicRec.bigMsgUrl;
        String str8 = this.bigMsgUrl;
        if (str8 == null) {
            str8 = "";
        }
        pBStringField7.set(str8);
        PBStringField pBStringField8 = richMsg$PicRec.rawMsgUrl;
        String str9 = this.rawMsgUrl;
        if (str9 == null) {
            str9 = "";
        }
        pBStringField8.set(str9);
        richMsg$PicRec.uiOperatorFlag.set(this.picExtraFlag);
        richMsg$PicRec.version.set(this.subVersion);
        richMsg$PicRec.isReport.set(this.isReport);
        richMsg$PicRec.fileSizeFlag.set(this.fileSizeFlag);
        PBStringField pBStringField9 = richMsg$PicRec.localUUID;
        String str10 = this.localUUID;
        if (str10 == null) {
            str10 = "";
        }
        pBStringField9.set(str10);
        richMsg$PicRec.preDownState.set(this.preDownState);
        richMsg$PicRec.preDownNetwork.set(this.preDownNetworkType);
        richMsg$PicRec.previewed.set(this.previewed);
        richMsg$PicRec.enableEnc.set(this.bEnableEnc);
        richMsg$PicRec.uint32_show_len.set(this.mShowLength);
        richMsg$PicRec.uint32_download_len.set(this.mDownloadLength);
        richMsg$PicRec.uint32_current_len.set(this.mCurrlength);
        richMsg$PicRec.notPredownloadReason.set(this.mNotPredownloadReason);
        Object obj = this.picExtraObject;
        if (obj != null && (obj instanceof PicFowardDbRecordData)) {
            PicFowardDbRecordData picFowardDbRecordData = (PicFowardDbRecordData) obj;
            RichMsg$ForwardExtra richMsg$ForwardExtra = richMsg$PicRec.fowardInfo.get();
            richMsg$ForwardExtra.foward_orgId.set(picFowardDbRecordData.fowardOrgId);
            PBStringField pBStringField10 = richMsg$ForwardExtra.foward_orgUin;
            String str11 = picFowardDbRecordData.fowardOrgUin;
            if (str11 == null) {
                str11 = "";
            }
            pBStringField10.set(str11);
            richMsg$ForwardExtra.foward_orgUinType.set(picFowardDbRecordData.fowardOrgUinType);
            richMsg$ForwardExtra.foward_orgFileSizeType.set(picFowardDbRecordData.fowardOrgFileSizeType);
            PBStringField pBStringField11 = richMsg$ForwardExtra.foward_orgUrl;
            String str12 = picFowardDbRecordData.fowardOrgUrl;
            if (str12 == null) {
                str12 = "";
            }
            pBStringField11.set(str12);
            PBStringField pBStringField12 = richMsg$ForwardExtra.foward_thumbPath;
            String str13 = picFowardDbRecordData.fowardThumbPath;
            if (str13 != null) {
                str2 = str13;
            }
            pBStringField12.set(str2);
            richMsg$PicRec.fowardInfo.setHasFlag(true);
        }
        PicMessageExtraData picMessageExtraData = this.picExtraData;
        if (picMessageExtraData != null) {
            if (this.istroop == 0) {
                richMsg$PicRec.bytes_pb_reserved.set(ByteStringMicro.copyFrom(picMessageExtraData.getOfflineImageResvAttr().get().toByteArray()), true);
            } else {
                richMsg$PicRec.bytes_pb_reserved.set(ByteStringMicro.copyFrom(picMessageExtraData.getCustomFaceResvAttr().get().toByteArray()), true);
            }
        }
        richMsg$PicRec.bool_story_pic_send_to_recent.set(this.isStoryPhoto);
        return richMsg$PicRec;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        String msgSummaryForAnimationPic = ((IPicHelper) QRoute.api(IPicHelper.class)).getMsgSummaryForAnimationPic(this);
        if (msgSummaryForAnimationPic != null) {
            return msgSummaryForAnimationPic;
        }
        return HardCodeUtil.qqStr(R.string.f172174o22);
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        serial();
    }

    public void processSessionInfo(k kVar) {
        com.tencent.mobileqq.multimsg.api.a multiMsgValue = ((IMultiMsg) QRoute.api(IMultiMsg.class)).getMultiMsgValue();
        Object obj = multiMsgValue.f251591d;
        boolean z16 = multiMsgValue.f251588a;
        if (this.isMultiMsg && !z16) {
            if (obj != null) {
                kVar.f258713h = multiMsgValue.f251589b;
            } else if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "currentSessionInfo is null while isMultiMsg is true");
            }
        } else {
            kVar.f258713h = this.istroop;
        }
        kVar.f258714i = this.selfuin;
        if (this.isMultiMsg) {
            try {
                kVar.f258714i = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
            } catch (Exception unused) {
            }
        }
        if (this.isMultiMsg && !z16) {
            if (obj != null) {
                kVar.f258715m = multiMsgValue.f251590c;
            } else if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "currentSessionInfo is null while isMultiMsg is true");
            }
        } else {
            kVar.f258715m = this.frienduin;
        }
        if (this.istroop == 10014) {
            PicMessageExtraData picMessageExtraData = this.picExtraData;
            if (picMessageExtraData != null) {
                kVar.f258725b0 = picMessageExtraData.mDownloadIndex;
            }
            kVar.C = getExtInfoFromExtStr(IGuildMessageUtilsApi.GUILD_ID_EXT_STR);
        }
    }

    public void serial() {
        boolean z16;
        int i3;
        boolean h16 = com.tencent.mobileqq.utils.c.h(this.msgtype);
        this.isShareAppActionMsg = h16;
        if (!h16 && (i3 = this.msgtype) != -3001 && i3 != -30002 && i3 != -30003 && i3 != -1032) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.isMixed = z16;
        if (z16) {
            this.msgData = this.f203106msg.getBytes();
            return;
        }
        if (this.versionCode < 3) {
            this.subVersion = 0;
        }
        this.msgData = getSerialPB().toByteArray();
    }

    public String toLogString() {
        return "path:" + this.path + ",uuid:" + this.uuid + ",md5:" + this.md5 + ",size:" + this.size + ",groupFileID:" + this.groupFileID;
    }

    public void updateMessage() {
        if (this.subMsgId == defaultSuMsgId) {
            try {
                this.msgData = getSerialPB().toByteArray();
                ((IMessageFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.frienduin, this.istroop, this.uniseq, this.msgData);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public void updateMsgExtFiled() {
        try {
            ((IMessageFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "")).updateMsgFieldByUniseq(this.frienduin, this.istroop, this.uniseq, AppConstants.Key.COLUMN_EXT_STR, this.extStr);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.path);
        parcel.writeLong(this.size);
        parcel.writeInt(this.type);
        parcel.writeInt(this.isRead ? 1 : 0);
        parcel.writeString(this.uuid);
        parcel.writeLong(this.groupFileID);
        parcel.writeString(this.md5);
        parcel.writeString(this.serverStoreSource);
        parcel.writeString(this.thumbMsgUrl);
        parcel.writeString(this.bigThumbMsgUrl);
        parcel.writeInt(this.thumbWidth);
        parcel.writeInt(this.thumbHeight);
        parcel.writeString(this.bigMsgUrl);
        parcel.writeString(this.rawMsgUrl);
        parcel.writeInt(this.fileSizeFlag);
        parcel.writeInt(this.picExtraFlag);
        parcel.writeInt(this.isMixed ? 1 : 0);
        parcel.writeInt(this.isShareAppActionMsg ? 1 : 0);
        parcel.writeString(this.action);
        parcel.writeLong(this.shareAppID);
        parcel.writeString(this.actMsgContentValue);
        parcel.writeString(this.localUUID);
        parcel.writeInt(this.subMsgId);
        parcel.writeInt(this.isReport);
        parcel.writeInt(this.subVersion);
        parcel.writeInt(this.busiType);
        parcel.writeLong(this.width);
        parcel.writeLong(this.height);
        parcel.writeInt(this.imageType);
        parcel.writeString(this.frienduin);
        parcel.writeString(this.selfuin);
        parcel.writeString(this.senderuin);
        parcel.writeInt(this.istroop);
        parcel.writeInt(this.versionCode);
        parcel.writeLong(this.uniseq);
        parcel.writeInt(this.issend);
        parcel.writeLong(this.time);
        parcel.writeInt(this.msgtype);
        parcel.writeInt(this.preDownState);
        parcel.writeInt(this.preDownNetworkType);
        parcel.writeInt(this.previewed);
        parcel.writeInt(this.mNotPredownloadReason);
        parcel.writeParcelable(this.reportInfo, i3);
        parcel.writeByte(this.sync2Story ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.isQzonePic ? 1 : 0);
    }
}
