package com.tencent.mobileqq.data;

import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.service.message.i;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.shortvideo.n;
import com.tencent.mobileqq.utils.FileUtils;
import localpb.richMsg.RichMsg$VideoFile;
import tencent.im.msg.hummer.resv.videoFile$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$VideoFile;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForShortVideo extends MessageForRichText implements Parcelable {
    public static final Parcelable.Creator<MessageForShortVideo> CREATOR = new a();
    public static final int EXTRA_FLAG_FORWARD = 2;
    public static final int EXTRA_FLAG_UPLOAD = 1;
    public static final int PREDOWNLOADED = 0;
    public static final int REPEAT_PLAY = 1;
    public static final int VIDEO_FORMAT_AFS = 7;
    public static final int VIDEO_FORMAT_AVI = 1;
    public static final int VIDEO_FORMAT_MKV = 4;
    public static final int VIDEO_FORMAT_MOD = 9;
    public static final int VIDEO_FORMAT_MOV = 8;
    public static final int VIDEO_FORMAT_MP4 = 2;
    public static final int VIDEO_FORMAT_MTS = 11;
    public static final int VIDEO_FORMAT_RM = 6;
    public static final int VIDEO_FORMAT_RMVB = 5;
    public static final int VIDEO_FORMAT_TS = 10;
    public static final int VIDEO_FORMAT_WMV = 3;
    public static int defaultSuMsgId = -1;
    public int binarySet;
    public int busiType;
    public int fileHeight;
    public String fileSource;
    public int fileType;
    public int fileWidth;
    public int forwardID;
    public long lastModified;
    public String mLocalMd5;
    public boolean mPreUpload;
    public Runnable mShowProgressTask;
    public String mThumbFilePath;
    public String mVideoFileSourceDir;
    public String md5;
    public boolean mediacodecEncode;
    public int progress;
    public Runnable progressTask;
    public int subBusiType;
    public boolean supportProgressive;
    public int thumbFileSize;
    public int thumbHeight;
    public String thumbMD5;
    public int thumbWidth;
    public int transferedSize;
    public int uiOperatorFlag;
    public String uuid;
    public int videoAttr;
    public int videoFileFormat;
    public String videoFileName;
    public int videoFileProgress;
    public int videoFileSize;
    public int videoFileStatus;
    public int videoFileTime;
    public int videoKandianType;
    public int fromChatType = -1;
    public int toChatType = -1;
    public boolean collectFromForward = false;
    public boolean syncToStory = false;
    public String hotVideoIconUrl = "";
    public String hotVideoTitle = "";
    public String hotVideoUrl = "";
    public String hotVideoSubIconUrl = "";
    public int specialVideoType = 0;
    public int msgTailType = 0;
    public int redBagType = 0;
    public String shortVideoId = "";
    public int redBagStat = 0;
    public boolean isAllowAutoDown = true;
    public boolean sendRawVideo = false;
    public boolean isPause = false;
    public boolean isStoryVideo = false;
    public String templateId = "";
    public String templateName = "";
    public int embedVideo = 0;
    public int sourceVideoCodecFormat = -1;
    public String originVideoMd5 = "";
    public int subMsgId = defaultSuMsgId;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<MessageForShortVideo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageForShortVideo createFromParcel(Parcel parcel) {
            boolean z16;
            boolean z17;
            boolean z18;
            MessageForShortVideo messageForShortVideo = new MessageForShortVideo();
            messageForShortVideo.uniseq = parcel.readLong();
            messageForShortVideo.istroop = parcel.readInt();
            messageForShortVideo.selfuin = parcel.readString();
            messageForShortVideo.frienduin = parcel.readString();
            messageForShortVideo.senderuin = parcel.readString();
            messageForShortVideo.uuid = parcel.readString();
            messageForShortVideo.md5 = parcel.readString();
            messageForShortVideo.videoFileName = parcel.readString();
            messageForShortVideo.videoFileSize = parcel.readInt();
            messageForShortVideo.videoFileFormat = parcel.readInt();
            messageForShortVideo.videoFileTime = parcel.readInt();
            messageForShortVideo.thumbWidth = parcel.readInt();
            messageForShortVideo.thumbHeight = parcel.readInt();
            messageForShortVideo.videoFileStatus = parcel.readInt();
            messageForShortVideo.videoFileProgress = parcel.readInt();
            messageForShortVideo.fileType = parcel.readInt();
            messageForShortVideo.thumbMD5 = parcel.readString();
            messageForShortVideo.fileSource = parcel.readString();
            messageForShortVideo.lastModified = parcel.readLong();
            messageForShortVideo.thumbFileSize = parcel.readInt();
            messageForShortVideo.busiType = parcel.readInt();
            messageForShortVideo.fromChatType = parcel.readInt();
            messageForShortVideo.toChatType = parcel.readInt();
            messageForShortVideo.uiOperatorFlag = parcel.readInt();
            messageForShortVideo.mVideoFileSourceDir = parcel.readString();
            boolean z19 = true;
            if (parcel.readByte() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            messageForShortVideo.supportProgressive = z16;
            messageForShortVideo.fileWidth = parcel.readInt();
            messageForShortVideo.fileHeight = parcel.readInt();
            messageForShortVideo.transferedSize = parcel.readInt();
            messageForShortVideo.subBusiType = parcel.readInt();
            messageForShortVideo.videoAttr = parcel.readInt();
            messageForShortVideo.binarySet = parcel.readInt();
            if (parcel.readByte() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            messageForShortVideo.mediacodecEncode = z17;
            messageForShortVideo.hotVideoIconUrl = parcel.readString();
            messageForShortVideo.hotVideoSubIconUrl = parcel.readString();
            messageForShortVideo.hotVideoTitle = parcel.readString();
            messageForShortVideo.hotVideoUrl = parcel.readString();
            messageForShortVideo.specialVideoType = parcel.readInt();
            messageForShortVideo.msgTailType = parcel.readInt();
            messageForShortVideo.redBagType = parcel.readInt();
            messageForShortVideo.shortVideoId = parcel.readString();
            messageForShortVideo.redBagStat = parcel.readInt();
            if (parcel.readByte() != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            messageForShortVideo.syncToStory = z18;
            messageForShortVideo.videoKandianType = parcel.readInt();
            if (parcel.readByte() == 0) {
                z19 = false;
            }
            messageForShortVideo.sendRawVideo = z19;
            messageForShortVideo.templateId = parcel.readString();
            messageForShortVideo.templateName = parcel.readString();
            return messageForShortVideo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageForShortVideo[] newArray(int i3) {
            return new MessageForShortVideo[i3];
        }
    }

    public boolean checkForward() {
        int i3;
        int i16;
        if (this.istroop == 9501) {
            return false;
        }
        if (isSendFromLocal()) {
            if ((this.uiOperatorFlag == 2 && ((i16 = this.videoFileStatus) == 5002 || i16 == 5001)) || (i3 = this.videoFileStatus) == 998 || i3 == 1005 || this.extraflag == 32768 || (i3 == 1004 && this.busiType == 0)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean checkIsDanceVideo() {
        if (this.specialVideoType == 2) {
            return true;
        }
        return false;
    }

    @TargetApi(9)
    public boolean checkIsHotVideo() {
        if (this.specialVideoType == 1) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        String str5;
        String str6;
        int i16;
        RichMsg$VideoFile richMsg$VideoFile = new RichMsg$VideoFile();
        try {
            richMsg$VideoFile.mergeFrom(this.msgData);
            z16 = true;
        } catch (Exception e16) {
            e16.printStackTrace();
            z16 = false;
        }
        if (z16) {
            this.videoFileName = richMsg$VideoFile.bytes_file_name.get().toStringUtf8();
            this.uuid = richMsg$VideoFile.bytes_file_uuid.get().toStringUtf8();
            this.md5 = HexUtil.bytes2HexStr(richMsg$VideoFile.bytes_file_md5.get().toByteArray());
            this.mLocalMd5 = HexUtil.bytes2HexStr(richMsg$VideoFile.bytes_local_file_md5.get().toByteArray());
            this.videoFileFormat = richMsg$VideoFile.uint32_file_format.get();
            this.videoFileSize = richMsg$VideoFile.uint32_file_size.get();
            this.videoFileTime = richMsg$VideoFile.uint32_file_time.get();
            this.thumbWidth = richMsg$VideoFile.uint32_thumb_width.get();
            this.thumbHeight = richMsg$VideoFile.uint32_thumb_height.get();
            this.videoFileStatus = richMsg$VideoFile.uint32_file_status.get();
            this.videoFileProgress = richMsg$VideoFile.uint32_file_progress.get();
            this.fileType = richMsg$VideoFile.uint32_file_type.get();
            this.thumbMD5 = HexUtil.bytes2HexStr(richMsg$VideoFile.bytes_thumb_file_md5.get().toByteArray());
            this.fileSource = richMsg$VideoFile.bytes_source.get().toStringUtf8();
            this.lastModified = richMsg$VideoFile.file_lastmodified.get();
            this.thumbFileSize = richMsg$VideoFile.uint32_thumb_file_size.get();
            this.busiType = richMsg$VideoFile.uint32_busi_type.get();
            this.fromChatType = richMsg$VideoFile.uin32_from_chat_type.get();
            this.toChatType = richMsg$VideoFile.uin32_to_chat_type.get();
            this.uiOperatorFlag = richMsg$VideoFile.uin32_uiOperatorFlag.get();
            this.mVideoFileSourceDir = richMsg$VideoFile.bytes_video_file_source_dir.get().toStringUtf8();
            this.supportProgressive = richMsg$VideoFile.bool_support_progressive.get();
            this.fileWidth = richMsg$VideoFile.uint32_file_width.get();
            this.fileHeight = richMsg$VideoFile.uint32_file_height.get();
            this.transferedSize = richMsg$VideoFile.uint32_transfered_size.get();
            this.subBusiType = richMsg$VideoFile.uint32_sub_busi_type.get();
            this.videoAttr = richMsg$VideoFile.uint32_video_attr.get();
            this.videoKandianType = richMsg$VideoFile.uint32_long_video_kandian_type.get();
            this.binarySet = richMsg$VideoFile.uint32_video_binary_set.get();
            this.mediacodecEncode = richMsg$VideoFile.bool_is_mediacodec_encode.get();
            String str7 = "";
            if (!richMsg$VideoFile.bytes_hotvideo_icon.has()) {
                str = "";
            } else {
                str = richMsg$VideoFile.bytes_hotvideo_icon.get().toStringUtf8();
            }
            this.hotVideoIconUrl = str;
            if (!richMsg$VideoFile.bytes_hotvideo_title.has()) {
                str2 = "";
            } else {
                str2 = richMsg$VideoFile.bytes_hotvideo_title.get().toStringUtf8();
            }
            this.hotVideoTitle = str2;
            if (!richMsg$VideoFile.bytes_hotvideo_url.has()) {
                str3 = "";
            } else {
                str3 = richMsg$VideoFile.bytes_hotvideo_url.get().toStringUtf8();
            }
            this.hotVideoUrl = str3;
            if (!richMsg$VideoFile.bytes_hotvideo_icon_sub.has()) {
                str4 = "";
            } else {
                str4 = richMsg$VideoFile.bytes_hotvideo_icon_sub.get().toStringUtf8();
            }
            this.hotVideoSubIconUrl = str4;
            if (richMsg$VideoFile.uint32_special_video_type.has()) {
                i3 = richMsg$VideoFile.uint32_special_video_type.get();
            } else {
                i3 = 0;
            }
            this.specialVideoType = i3;
            this.msgTailType = richMsg$VideoFile.uint32_msg_tail_type.get();
            this.redBagType = richMsg$VideoFile.uint32_red_envelope_type.get();
            if (!richMsg$VideoFile.bytes_shortVideoId.has()) {
                str5 = "";
            } else {
                str5 = richMsg$VideoFile.bytes_shortVideoId.get().toStringUtf8();
            }
            this.shortVideoId = str5;
            this.redBagStat = richMsg$VideoFile.red_envelope_pay_stat.get();
            this.isStoryVideo = richMsg$VideoFile.bool_story_video_send_to_recent.get();
            if (!richMsg$VideoFile.bytes_camera_video_templateid.has()) {
                str6 = "";
            } else {
                str6 = richMsg$VideoFile.bytes_camera_video_templateid.get().toStringUtf8();
            }
            this.templateId = str6;
            if (richMsg$VideoFile.bytes_camera_video_templatename.has()) {
                str7 = richMsg$VideoFile.bytes_camera_video_templatename.get().toStringUtf8();
            }
            this.templateName = str7;
            this.embedVideo = richMsg$VideoFile.uint32_embed_video.get();
            if (richMsg$VideoFile.uint32_source_codec_format.has()) {
                i16 = richMsg$VideoFile.uint32_source_codec_format.get();
            } else {
                i16 = -1;
            }
            this.sourceVideoCodecFormat = i16;
        }
        if ("1".equals(getExtInfoFromExtStr(i.f286271n))) {
            this.syncToStory = true;
        } else {
            this.syncToStory = false;
        }
        this.sendRawVideo = "1".equals(getExtInfoFromExtStr(i.C));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String formatToPeople(int i3) {
        switch (i3) {
            case 1:
                return FileUtils.FILE_TYPE_AVI;
            case 2:
                return "mp4";
            case 3:
                return FileUtils.FILE_TYPE_WMV;
            case 4:
                return "mkv";
            case 5:
                return "rmvb";
            case 6:
                return MsfCmdConfig.CMD_DELETE_FILE;
            case 7:
                return "afs";
            case 8:
                return FileUtils.FILE_TYPE_MOV;
            case 9:
                return "mod";
            case 10:
                return "ts";
            case 11:
                return "mts";
            default:
                return "no";
        }
    }

    public byte getBitValue(int i3) {
        return (byte) ((this.binarySet >> i3) & 1);
    }

    public byte[] getBytes() {
        prewrite();
        return this.msgData;
    }

    public n getDownloadInfo(int i3) {
        n nVar = new n();
        nVar.f288040c = i3;
        nVar.f288045h = this.uniseq;
        nVar.f288041d = this.istroop;
        nVar.f288042e = this.selfuin;
        nVar.f288043f = this.frienduin;
        nVar.f288044g = this.senderuin;
        nVar.f288039b = this.uuid;
        nVar.f288047j = this.md5;
        int i16 = this.videoFileTime;
        nVar.f288191o = this.videoFileFormat;
        nVar.f288190n = i16;
        nVar.f288049l = this.thumbMD5;
        return nVar;
    }

    public String getMd5() {
        if (!TextUtils.isEmpty(this.md5)) {
            return this.md5;
        }
        return this.mLocalMd5;
    }

    public im_msg_body$RichText getRichText() {
        int i3 = this.busiType;
        if (i3 == 0) {
            return parseMessageForVideo(this);
        }
        if (i3 == 1) {
            return parseMessageForVideo(this);
        }
        if (i3 == 2) {
            return parseMessageForVideo(this);
        }
        return null;
    }

    public RichMsg$VideoFile getSerialPB() {
        RichMsg$VideoFile richMsg$VideoFile = new RichMsg$VideoFile();
        richMsg$VideoFile.setHasFlag(true);
        PBBytesField pBBytesField = richMsg$VideoFile.bytes_file_name;
        String str = this.videoFileName;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        pBBytesField.set(ByteStringMicro.copyFromUtf8(str));
        PBBytesField pBBytesField2 = richMsg$VideoFile.bytes_file_md5;
        String str3 = this.md5;
        if (str3 == null) {
            str3 = "";
        }
        pBBytesField2.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str3)));
        PBBytesField pBBytesField3 = richMsg$VideoFile.bytes_local_file_md5;
        String str4 = this.mLocalMd5;
        if (str4 == null) {
            str4 = "";
        }
        pBBytesField3.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str4)));
        PBBytesField pBBytesField4 = richMsg$VideoFile.bytes_file_uuid;
        String str5 = this.uuid;
        if (str5 == null) {
            str5 = "";
        }
        pBBytesField4.set(ByteStringMicro.copyFromUtf8(str5));
        richMsg$VideoFile.uint32_file_format.set(this.videoFileFormat);
        richMsg$VideoFile.uint32_file_size.set(this.videoFileSize);
        richMsg$VideoFile.uint32_file_time.set(this.videoFileTime);
        richMsg$VideoFile.uint32_thumb_width.set(this.thumbWidth);
        richMsg$VideoFile.uint32_thumb_height.set(this.thumbHeight);
        richMsg$VideoFile.uint32_file_status.set(this.videoFileStatus);
        richMsg$VideoFile.uint32_file_progress.set(this.videoFileProgress);
        richMsg$VideoFile.uint32_file_type.set(this.fileType);
        PBBytesField pBBytesField5 = richMsg$VideoFile.bytes_thumb_file_md5;
        String str6 = this.thumbMD5;
        if (str6 == null) {
            str6 = "";
        }
        pBBytesField5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str6)));
        PBBytesField pBBytesField6 = richMsg$VideoFile.bytes_source;
        String str7 = this.fileSource;
        if (str7 == null) {
            str7 = "";
        }
        pBBytesField6.set(ByteStringMicro.copyFromUtf8(str7));
        richMsg$VideoFile.file_lastmodified.set(this.lastModified);
        richMsg$VideoFile.uint32_thumb_file_size.set(this.thumbFileSize);
        richMsg$VideoFile.uint32_busi_type.set(this.busiType);
        richMsg$VideoFile.uin32_from_chat_type.set(this.fromChatType);
        richMsg$VideoFile.uin32_to_chat_type.set(this.toChatType);
        richMsg$VideoFile.uin32_uiOperatorFlag.set(this.uiOperatorFlag);
        PBBytesField pBBytesField7 = richMsg$VideoFile.bytes_video_file_source_dir;
        String str8 = this.mVideoFileSourceDir;
        if (str8 == null) {
            str8 = "";
        }
        pBBytesField7.set(ByteStringMicro.copyFromUtf8(str8));
        richMsg$VideoFile.bool_support_progressive.set(this.supportProgressive);
        richMsg$VideoFile.uint32_file_width.set(this.fileWidth);
        richMsg$VideoFile.uint32_file_height.set(this.fileHeight);
        richMsg$VideoFile.uint32_transfered_size.set(this.transferedSize);
        richMsg$VideoFile.uint32_sub_busi_type.set(this.subBusiType);
        richMsg$VideoFile.uint32_video_attr.set(this.videoAttr);
        richMsg$VideoFile.uint32_long_video_kandian_type.set(this.videoKandianType);
        richMsg$VideoFile.uint32_video_binary_set.set(this.binarySet);
        richMsg$VideoFile.bool_is_mediacodec_encode.set(this.mediacodecEncode);
        richMsg$VideoFile.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(this.hotVideoTitle));
        richMsg$VideoFile.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(this.hotVideoUrl));
        richMsg$VideoFile.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(this.hotVideoIconUrl));
        richMsg$VideoFile.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(this.hotVideoSubIconUrl));
        richMsg$VideoFile.uint32_special_video_type.set(this.specialVideoType);
        richMsg$VideoFile.uint32_msg_tail_type.set(this.msgTailType);
        richMsg$VideoFile.uint32_red_envelope_type.set(this.redBagType);
        String str9 = this.shortVideoId;
        if (str9 != null) {
            richMsg$VideoFile.bytes_shortVideoId.set(ByteStringMicro.copyFromUtf8(str9));
        }
        richMsg$VideoFile.red_envelope_pay_stat.set(this.redBagStat);
        richMsg$VideoFile.bool_story_video_send_to_recent.set(this.isStoryVideo);
        PBBytesField pBBytesField8 = richMsg$VideoFile.bytes_camera_video_templateid;
        String str10 = this.templateId;
        if (str10 == null) {
            str10 = "";
        }
        pBBytesField8.set(ByteStringMicro.copyFromUtf8(str10));
        PBBytesField pBBytesField9 = richMsg$VideoFile.bytes_camera_video_templatename;
        String str11 = this.templateName;
        if (str11 != null) {
            str2 = str11;
        }
        pBBytesField9.set(ByteStringMicro.copyFromUtf8(str2));
        richMsg$VideoFile.uint32_embed_video.set(this.embedVideo);
        richMsg$VideoFile.uint32_source_codec_format.set(this.sourceVideoCodecFormat);
        return richMsg$VideoFile;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        if (TextUtils.isEmpty(this.f203106msg)) {
            return HardCodeUtil.qqStr(R.string.o29);
        }
        return this.f203106msg;
    }

    public boolean isCancelStatus() {
        if (this.videoFileStatus == 1004) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public boolean needVipBubble() {
        return false;
    }

    public im_msg_body$RichText parseMessageForVideo(MessageForShortVideo messageForShortVideo) {
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.video_file.set(parseMsgBodyVideoFile(messageForShortVideo));
        im_msg_body_richtext.elems.add(im_msg_body_elem);
        return im_msg_body_richtext;
    }

    public im_msg_body$VideoFile parseMsgBodyVideoFile(MessageForShortVideo messageForShortVideo) {
        im_msg_body$VideoFile im_msg_body_videofile = new im_msg_body$VideoFile();
        im_msg_body_videofile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.videoFileName));
        im_msg_body_videofile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(messageForShortVideo.md5)));
        im_msg_body_videofile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.uuid));
        im_msg_body_videofile.uint32_file_format.set(messageForShortVideo.videoFileFormat);
        im_msg_body_videofile.uint32_file_size.set(messageForShortVideo.videoFileSize);
        im_msg_body_videofile.uint32_file_time.set(messageForShortVideo.videoFileTime);
        im_msg_body_videofile.uint32_thumb_width.set(messageForShortVideo.thumbWidth);
        im_msg_body_videofile.uint32_thumb_height.set(messageForShortVideo.thumbHeight);
        im_msg_body_videofile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(messageForShortVideo.thumbMD5)));
        im_msg_body_videofile.bytes_source.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.fileSource));
        im_msg_body_videofile.uint32_thumb_file_size.set(messageForShortVideo.thumbFileSize);
        im_msg_body_videofile.uint32_busi_type.set(messageForShortVideo.busiType);
        im_msg_body_videofile.uint32_from_chat_type.set(messageForShortVideo.fromChatType);
        im_msg_body_videofile.uint32_to_chat_type.set(messageForShortVideo.toChatType);
        im_msg_body_videofile.bool_support_progressive.set(messageForShortVideo.supportProgressive);
        im_msg_body_videofile.uint32_file_width.set(messageForShortVideo.fileWidth);
        im_msg_body_videofile.uint32_file_height.set(messageForShortVideo.fileHeight);
        im_msg_body_videofile.uint32_sub_busi_type.set(messageForShortVideo.subBusiType);
        im_msg_body_videofile.uint32_video_attr.set(messageForShortVideo.videoAttr);
        videoFile$ResvAttr videofile_resvattr = new videoFile$ResvAttr();
        videofile_resvattr.uint32_msg_tail_type.set(messageForShortVideo.msgTailType);
        videofile_resvattr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoIconUrl));
        videofile_resvattr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoTitle));
        videofile_resvattr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoUrl));
        videofile_resvattr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoSubIconUrl));
        videofile_resvattr.uint32_special_video_type.set(messageForShortVideo.specialVideoType);
        videofile_resvattr.uint32_long_video_kandian_type.set(messageForShortVideo.videoKandianType);
        videofile_resvattr.uint32_source_codec_format.set(messageForShortVideo.sourceVideoCodecFormat);
        videofile_resvattr.bytes_original_video_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(messageForShortVideo.originVideoMd5)));
        im_msg_body_videofile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(videofile_resvattr.toByteArray()));
        return im_msg_body_videofile;
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

    public void serial() {
        synchronized (this) {
            this.msgData = getSerialPB().toByteArray();
        }
    }

    public void setBitValue(int i3, byte b16) {
        byte b17 = (byte) (1 << i3);
        if (b16 > 0) {
            this.binarySet = b17 | this.binarySet;
        } else {
            this.binarySet = (~b17) & this.binarySet;
        }
    }

    public String toLogString() {
        boolean isSendFromLocal = isSendFromLocal();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\nMessageForShortVideo");
        sb5.append(" isLocalSend:");
        sb5.append(isSendFromLocal);
        sb5.append(" busiType:");
        sb5.append(this.busiType);
        sb5.append("\n |-");
        sb5.append("uniseq:");
        sb5.append(this.uniseq);
        sb5.append(",(uuid:");
        sb5.append(this.uuid);
        sb5.append(")");
        sb5.append("\n |-");
        sb5.append("videoFile");
        sb5.append("(");
        sb5.append(formatToPeople(this.videoFileFormat));
        sb5.append("):");
        sb5.append(this.videoFileName);
        sb5.append("\n |-");
        sb5.append("md5:");
        sb5.append(this.md5);
        sb5.append("(local:");
        sb5.append(this.mLocalMd5);
        sb5.append(")");
        sb5.append("\n |-");
        sb5.append("videoFileSize:");
        sb5.append(this.videoFileSize);
        sb5.append("\n |-");
        sb5.append("isLocalSend:");
        sb5.append(isSendFromLocal);
        sb5.append("\n |-");
        sb5.append("videoFileName:");
        sb5.append(this.videoFileName);
        sb5.append("\n |-");
        sb5.append("mVideoFileSourceDir:");
        sb5.append(this.mVideoFileSourceDir);
        sb5.append("\n |-");
        sb5.append("fileType:");
        sb5.append(j.b(this.fileType));
        sb5.append("\n |-");
        sb5.append("videoFileStatus:");
        sb5.append(j.a(this.videoFileStatus));
        sb5.append("\n |-");
        sb5.append("videoFileProgress:");
        sb5.append(this.videoFileProgress);
        sb5.append("\n |-");
        sb5.append("mThumbFile");
        sb5.append("(");
        sb5.append(this.thumbWidth + "*" + this.thumbHeight);
        sb5.append("):");
        sb5.append(this.mThumbFilePath);
        sb5.append("\n |-");
        sb5.append("thumbMD5:");
        sb5.append(this.thumbMD5);
        sb5.append("\n |-");
        sb5.append("thumbFileSize:");
        sb5.append(this.thumbFileSize);
        sb5.append("\n |-");
        sb5.append("mPreUpload:");
        sb5.append(this.mPreUpload);
        sb5.append("\n |-");
        sb5.append("FromTo:");
        sb5.append(this.fromChatType);
        sb5.append(" to ");
        sb5.append(this.toChatType);
        sb5.append(" uiOperatorFlag:");
        sb5.append(this.uiOperatorFlag);
        sb5.append("\n |-");
        sb5.append("uiOperatorFlag:");
        sb5.append(this.uiOperatorFlag);
        sb5.append("\n |-");
        sb5.append("supportProgressive:");
        sb5.append(this.supportProgressive);
        sb5.append("\n |-");
        sb5.append("fileWidth:");
        sb5.append(this.fileWidth);
        sb5.append("\n |-");
        sb5.append("fileHeight:");
        sb5.append(this.fileHeight);
        sb5.append("\n |-");
        sb5.append("transferedSize:");
        sb5.append(this.transferedSize);
        sb5.append("\n |-");
        sb5.append("subBusiType:");
        sb5.append(this.subBusiType);
        sb5.append("\n |-");
        sb5.append("videoAttr:");
        sb5.append(this.videoAttr);
        sb5.append("\n |-");
        sb5.append("videoKandianType:");
        sb5.append(this.videoKandianType);
        sb5.append("\n |-");
        sb5.append("binarySet:");
        sb5.append(this.binarySet);
        sb5.append("\n |-");
        sb5.append("mediacodecEncode:");
        sb5.append(this.mediacodecEncode);
        sb5.append("\n |-");
        sb5.append("hotVideoIconUrl:");
        sb5.append(this.hotVideoIconUrl);
        sb5.append("\n |-");
        sb5.append("hotVideoTitle:");
        sb5.append(this.hotVideoTitle);
        sb5.append("\n |-");
        sb5.append("hotVideoUrl:");
        sb5.append(this.hotVideoUrl);
        sb5.append("\n |-");
        sb5.append("hotVideoSubIconUrl:");
        sb5.append(this.hotVideoSubIconUrl);
        sb5.append("\n |-");
        sb5.append("specialVideoType:");
        sb5.append(this.specialVideoType);
        sb5.append("\n |-");
        sb5.append("uint32_msg_tail_type");
        sb5.append(this.msgTailType);
        sb5.append("\n |-");
        sb5.append("redbagType");
        sb5.append(this.redBagType);
        sb5.append("\n |-");
        sb5.append("shortVideoId");
        sb5.append(this.shortVideoId);
        sb5.append("\n |-");
        sb5.append("redBagStat");
        sb5.append(this.redBagStat);
        sb5.append("\n |-");
        sb5.append("sendRawVideo");
        sb5.append(this.sendRawVideo);
        sb5.append("\n |-");
        sb5.append("isStoryVideo");
        sb5.append(this.isStoryVideo);
        sb5.append("\n |-");
        sb5.append("templateId");
        sb5.append(this.templateId);
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public String toString() {
        return toLogString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.uniseq);
        parcel.writeInt(this.istroop);
        parcel.writeString(this.selfuin);
        parcel.writeString(this.frienduin);
        parcel.writeString(this.senderuin);
        parcel.writeString(this.uuid);
        parcel.writeString(this.md5);
        parcel.writeString(this.videoFileName);
        parcel.writeInt(this.videoFileSize);
        parcel.writeInt(this.videoFileFormat);
        parcel.writeInt(this.videoFileTime);
        parcel.writeInt(this.thumbWidth);
        parcel.writeInt(this.thumbHeight);
        parcel.writeInt(this.videoFileStatus);
        parcel.writeInt(this.videoFileProgress);
        parcel.writeInt(this.fileType);
        parcel.writeString(this.thumbMD5);
        parcel.writeString(this.fileSource);
        parcel.writeLong(this.lastModified);
        parcel.writeInt(this.thumbFileSize);
        parcel.writeInt(this.busiType);
        parcel.writeInt(this.fromChatType);
        parcel.writeInt(this.toChatType);
        parcel.writeInt(this.uiOperatorFlag);
        parcel.writeString(this.mVideoFileSourceDir);
        parcel.writeByte(this.supportProgressive ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.fileWidth);
        parcel.writeInt(this.fileHeight);
        parcel.writeInt(this.transferedSize);
        parcel.writeInt(this.subBusiType);
        parcel.writeInt(this.videoAttr);
        parcel.writeInt(this.binarySet);
        parcel.writeByte(this.mediacodecEncode ? (byte) 1 : (byte) 0);
        parcel.writeString(this.hotVideoIconUrl);
        parcel.writeString(this.hotVideoSubIconUrl);
        parcel.writeString(this.hotVideoTitle);
        parcel.writeString(this.hotVideoUrl);
        parcel.writeInt(this.specialVideoType);
        parcel.writeInt(this.msgTailType);
        parcel.writeInt(this.redBagType);
        parcel.writeString(this.shortVideoId);
        parcel.writeInt(this.redBagStat);
        parcel.writeByte(this.syncToStory ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.videoKandianType);
        parcel.writeByte(this.sendRawVideo ? (byte) 1 : (byte) 0);
        parcel.writeString(this.templateId);
        parcel.writeString(this.templateName);
    }
}
