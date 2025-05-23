package com.tencent.mobileqq.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.service.message.i;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.pb.client.ClientMessageModel$VideoEmojiInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import localpb.richMsg.RichMsg$VideoFile;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForVideoEmoticon extends MessageForShortVideo {
    private static final String TAG = "MessageForVideoEmoticon";
    public String homepageUrl;

    @Nullable
    @notColumn
    public transient Boolean showGuideBubble;
    public String srcDesc;
    public int srcType;

    @Nullable
    @notColumn
    public transient String thumbOriginUrl;
    public String videoIconUrl;
    public String videoOther;

    protected void deserializeVideoEmoticonInfo(byte[] bArr) {
        if (bArr == null) {
            QLog.e(TAG, 1, "deserializeVideoEmoticonInfo error, videoEmoticonDataBuf is null!");
            return;
        }
        ClientMessageModel$VideoEmojiInfo clientMessageModel$VideoEmojiInfo = new ClientMessageModel$VideoEmojiInfo();
        try {
            clientMessageModel$VideoEmojiInfo.mergeFrom(bArr);
            this.srcType = clientMessageModel$VideoEmojiInfo.uint32_src_type.get();
            this.srcDesc = clientMessageModel$VideoEmojiInfo.bytes_src_desc.get().toStringUtf8();
            this.homepageUrl = clientMessageModel$VideoEmojiInfo.bytes_homepage_url.get().toStringUtf8();
            this.videoIconUrl = clientMessageModel$VideoEmojiInfo.bytes_icon_url.get().toStringUtf8();
            this.videoOther = clientMessageModel$VideoEmojiInfo.bytes_video_other.get().toString(StandardCharsets.ISO_8859_1.name());
            if (clientMessageModel$VideoEmojiInfo.uint32_video_width.get() > 0 && clientMessageModel$VideoEmojiInfo.uint32_video_height.get() > 0) {
                this.fileWidth = clientMessageModel$VideoEmojiInfo.uint32_video_width.get();
                this.fileHeight = clientMessageModel$VideoEmojiInfo.uint32_video_height.get();
            }
            if (clientMessageModel$VideoEmojiInfo.uint32_thumb_img_width.get() > 0 && clientMessageModel$VideoEmojiInfo.uint32_thumb_img_height.get() > 0) {
                this.thumbWidth = clientMessageModel$VideoEmojiInfo.uint32_thumb_img_width.get();
                this.thumbHeight = clientMessageModel$VideoEmojiInfo.uint32_thumb_img_height.get();
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[deserializeVideoEmoticonInfo] success! srcDesc=", this.srcDesc);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[deserializeVideoEmoticonInfo] videoEmojiInfo error! ", th5);
        }
    }

    protected void deserializeVideoFileInfo(byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z16 = true;
        if (bArr == null) {
            QLog.e(TAG, 1, "deserializeVideoFileInfo error, videoFileInfoBuf is null!");
            return;
        }
        RichMsg$VideoFile richMsg$VideoFile = new RichMsg$VideoFile();
        int i3 = 0;
        try {
            richMsg$VideoFile.mergeFrom(bArr);
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
        }
    }

    @Override // com.tencent.mobileqq.data.MessageForShortVideo, com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            VideoEmoticonMessage videoEmoticonMessage = (VideoEmoticonMessage) MessagePkgUtils.getObjectFromBytes(this.msgData);
            deserializeVideoFileInfo(videoEmoticonMessage.videoFileDataBuf);
            deserializeVideoEmoticonInfo(videoEmoticonMessage.videoEmoticonDataBuf);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "doParse error! ", th5);
        }
        if ("1".equals(getExtInfoFromExtStr(i.f286271n))) {
            this.syncToStory = true;
        } else {
            this.syncToStory = false;
        }
        this.sendRawVideo = "1".equals(getExtInfoFromExtStr(i.C));
    }

    @NonNull
    protected ClientMessageModel$VideoEmojiInfo getSerialVideoEmojiInfo() {
        ClientMessageModel$VideoEmojiInfo clientMessageModel$VideoEmojiInfo = new ClientMessageModel$VideoEmojiInfo();
        clientMessageModel$VideoEmojiInfo.uint32_src_type.set(this.srcType);
        if (!TextUtils.isEmpty(this.srcDesc)) {
            clientMessageModel$VideoEmojiInfo.bytes_src_desc.set(ByteStringMicro.copyFromUtf8(this.srcDesc));
        }
        if (!TextUtils.isEmpty(this.homepageUrl)) {
            clientMessageModel$VideoEmojiInfo.bytes_homepage_url.set(ByteStringMicro.copyFromUtf8(this.homepageUrl));
        }
        if (!TextUtils.isEmpty(this.videoIconUrl)) {
            clientMessageModel$VideoEmojiInfo.bytes_icon_url.set(ByteStringMicro.copyFromUtf8(this.videoIconUrl));
        }
        if (!TextUtils.isEmpty(this.videoOther)) {
            clientMessageModel$VideoEmojiInfo.bytes_video_other.set(ByteStringMicro.copyFrom(this.videoOther.getBytes(StandardCharsets.ISO_8859_1)));
        }
        return clientMessageModel$VideoEmojiInfo;
    }

    @Override // com.tencent.mobileqq.data.MessageForShortVideo, com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        if (TextUtils.isEmpty(this.f203106msg)) {
            return HardCodeUtil.qqStr(R.string.f209505fl);
        }
        return this.f203106msg;
    }

    @Override // com.tencent.mobileqq.data.MessageForShortVideo
    public void serial() {
        synchronized (this) {
            try {
                RichMsg$VideoFile serialPB = getSerialPB();
                ClientMessageModel$VideoEmojiInfo serialVideoEmojiInfo = getSerialVideoEmojiInfo();
                VideoEmoticonMessage videoEmoticonMessage = new VideoEmoticonMessage();
                videoEmoticonMessage.videoFileDataBuf = serialPB.toByteArray();
                videoEmoticonMessage.videoEmoticonDataBuf = serialVideoEmojiInfo.toByteArray();
                this.msgData = MessagePkgUtils.getBytesFromObject(videoEmoticonMessage);
            } finally {
            }
        }
    }

    @Override // com.tencent.mobileqq.data.MessageForShortVideo
    public String toLogString() {
        boolean isSendFromLocal = isSendFromLocal();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\nMessageForVideoEmoticon");
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
}
