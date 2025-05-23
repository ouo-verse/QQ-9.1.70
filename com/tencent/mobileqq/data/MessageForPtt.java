package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.aw;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import localpb.richMsg.RichMsg$PttRec;
import org.json.JSONArray;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$Ptt;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes10.dex */
public class MessageForPtt extends MessageForRichText implements c {
    public static final int PTT_SIZE_ANIM_START = -2;
    public static final int PTT_SIZE_RECV_ERROR = -4;
    public static final int PTT_SIZE_SATUTS_ERROR = -1;
    public static final int PTT_SIZE_UI_SEND = -3;
    public static final int STT_ABLE = 1;
    public static final int STT_DONE = 2;
    public static final int STT_EMPTY = 0;
    public static final int STT_FAIL = 3;
    private static final String TAG = "PttMsg";
    public static final int VIPFLAG_NONE = 0;
    public static final int VIPFLAG_SVIP = 2;
    public static final int VIPFLAG_VIP = 1;
    public JSONArray atInfo;
    public int busiType;
    public boolean c2cViaOffline;

    @notColumn
    public long estimatedSize;
    public long extFlag;
    public long fileSize;
    public long groupFileID;
    public boolean isReadPtt;

    @notColumn
    public boolean isResend;
    public int itemType;
    public int longPttVipFlag;

    @notColumn
    public String mInputContent;
    public String md5;
    public int msgVia;
    public float playProgress;
    public int sampleRate;
    public boolean sendFromvoiceChangePanelFlag;
    public String storageSource;

    @notColumn
    private volatile com.tencent.mobileqq.stt.shard.a sttResult;
    public String sttText;
    public String timeStr;
    public String url;
    public String urlAtServer;
    public int voiceChangeFlag;
    public int voiceLength;
    public int voiceRedPacketFlag;
    public int voiceType;
    public int[] waveformArray;
    public boolean expandStt = true;
    public int autoToText = 0;
    public int sttAbility = 0;
    public int isReport = 0;
    public String groupFileKeyStr = null;
    public int subVersion = 5;
    public String directUrl = "";
    public String fullLocalPath = "";

    @notColumn
    public float playSpeedPos = com.tencent.mobileqq.qqaudio.audioplayer.sonic.a.f262196a;
    public long msgRecTime = 0;
    public long msgTime = 0;

    public static String getMsgFilePath(int i3, String str) {
        return ((IMessageForPttInnerApi) QRoute.api(IMessageForPttInnerApi.class)).getMsgFilePath(i3, str);
    }

    public void buileDefaultWaveform() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "buileDefaultWaveform");
        }
        int[] iArr = new int[34];
        Random random = new Random(System.currentTimeMillis());
        for (int i3 = 0; i3 < 34; i3++) {
            iArr[i3] = random.nextInt(55) + 20;
        }
        this.waveformArray = iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:171:0x031f  */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        boolean z16;
        boolean z17;
        String[] split;
        long j3;
        int i3;
        int i16;
        int i17;
        int i18;
        String str;
        String str2;
        long j16;
        int i19;
        int i26;
        try {
            RichMsg$PttRec richMsg$PttRec = new RichMsg$PttRec();
            boolean z18 = true;
            try {
                richMsg$PttRec = richMsg$PttRec.mergeFrom(this.msgData);
                z16 = true;
            } catch (Exception e16) {
                e16.printStackTrace();
                z16 = false;
            }
            if (z16) {
                this.url = richMsg$PttRec.localPath.get();
                this.fileSize = richMsg$PttRec.size.get();
                this.itemType = richMsg$PttRec.type.get();
                this.isReadPtt = richMsg$PttRec.isRead.get();
                this.urlAtServer = richMsg$PttRec.uuid.get();
                this.sttAbility = richMsg$PttRec.pttFlag.get();
                this.md5 = richMsg$PttRec.md5.get();
                this.storageSource = richMsg$PttRec.serverStorageSource.get();
                this.subVersion = richMsg$PttRec.version.get();
                this.isReport = richMsg$PttRec.isReport.get();
                this.groupFileID = richMsg$PttRec.groupFileID.get();
                this.sttText = richMsg$PttRec.sttText.get();
                this.longPttVipFlag = richMsg$PttRec.longPttVipFlag.get();
                if (richMsg$PttRec.expandStt.has()) {
                    z18 = richMsg$PttRec.expandStt.get();
                }
                this.expandStt = z18;
                if (richMsg$PttRec.group_file_key.has()) {
                    this.groupFileKeyStr = richMsg$PttRec.group_file_key.get();
                }
                long j17 = 0;
                if (richMsg$PttRec.msgTime.has()) {
                    j3 = richMsg$PttRec.msgTime.get();
                } else {
                    j3 = 0;
                }
                this.msgTime = j3;
                if (richMsg$PttRec.msgRecTime.has()) {
                    j17 = richMsg$PttRec.msgRecTime.get();
                }
                this.msgRecTime = j17;
                if (richMsg$PttRec.voiceType.has()) {
                    i3 = richMsg$PttRec.voiceType.get();
                } else {
                    i3 = 0;
                }
                this.voiceType = i3;
                if (richMsg$PttRec.voiceLength.has()) {
                    i16 = richMsg$PttRec.voiceLength.get();
                } else {
                    i16 = 0;
                }
                this.voiceLength = i16;
                if (richMsg$PttRec.voiceChangeFlag.has()) {
                    i17 = richMsg$PttRec.voiceChangeFlag.get();
                } else {
                    i17 = 0;
                }
                this.voiceChangeFlag = i17;
                if (richMsg$PttRec.busiType.has()) {
                    i18 = richMsg$PttRec.busiType.get();
                } else {
                    i18 = 0;
                }
                this.busiType = i18;
                if (!richMsg$PttRec.directUrl.has()) {
                    str = "";
                } else {
                    str = richMsg$PttRec.directUrl.get();
                }
                this.directUrl = str;
                if (!richMsg$PttRec.fullLocalPath.has()) {
                    str2 = "";
                } else {
                    str2 = richMsg$PttRec.fullLocalPath.get();
                }
                this.fullLocalPath = str2;
                if (richMsg$PttRec.extFlag.has()) {
                    j16 = richMsg$PttRec.extFlag.get();
                } else {
                    j16 = -1;
                }
                this.extFlag = j16;
                if (richMsg$PttRec.redpack_type.has()) {
                    i19 = richMsg$PttRec.redpack_type.get();
                } else {
                    i19 = 0;
                }
                this.voiceRedPacketFlag = i19;
                if (richMsg$PttRec.autototext_voice.has()) {
                    i26 = richMsg$PttRec.autototext_voice.get();
                } else {
                    i26 = 0;
                }
                this.autoToText = i26;
                ArrayList<AtTroopMemberInfo> arrayList = this.atInfoList;
                if (arrayList != null && !arrayList.isEmpty()) {
                    this.atInfo = new JSONArray();
                    Iterator<AtTroopMemberInfo> it = this.atInfoList.iterator();
                    while (it.hasNext()) {
                        this.atInfo.put(it.next().uin);
                    }
                } else {
                    try {
                        String extInfoFromExtStr = getExtInfoFromExtStr("is_to_robot");
                        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                            this.mRobotFlag = Integer.parseInt(extInfoFromExtStr);
                        }
                        String extInfoFromExtStr2 = getExtInfoFromExtStr("at_robot_info");
                        if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                            this.atInfo = new JSONArray(extInfoFromExtStr2);
                        }
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                }
                String extInfoFromExtStr3 = getExtInfoFromExtStr("wave_form");
                if (extInfoFromExtStr3 != null && extInfoFromExtStr3.length() > 0) {
                    try {
                        JSONArray jSONArray = new JSONArray(extInfoFromExtStr3);
                        int length = jSONArray.length();
                        int[] iArr = new int[length];
                        for (int i27 = 0; i27 < length; i27++) {
                            iArr[i27] = jSONArray.getInt(i27);
                        }
                        this.waveformArray = iArr;
                        return;
                    } catch (Throwable th5) {
                        QLog.e(getClass().getName(), 2, "get wave from jason error", th5);
                        return;
                    }
                }
                int[] iArr2 = this.waveformArray;
                if (iArr2 == null || iArr2.length == 0) {
                    buileDefaultWaveform();
                    return;
                }
                return;
            }
            if (this.f203106msg == null) {
                try {
                    if (this.versionCode > 0) {
                        this.f203106msg = new String(this.msgData, "UTF-8");
                    }
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
            this.subVersion = 0;
            String str3 = this.f203106msg;
            if (str3 != null && this.msgtype == -1031) {
                this.f203106msg = com.tencent.mobileqq.utils.c.a(str3).f24895msg;
                z17 = true;
            } else {
                z17 = false;
            }
            String str4 = this.f203106msg;
            if (str4 != null && str4.length() > 0 && this.f203106msg.charAt(0) == 22 && (split = this.f203106msg.split("\\|")) != null) {
                if (split.length > 0) {
                    this.url = split[0].trim();
                } else {
                    this.url = "";
                }
                if (z17) {
                    this.urlAtServer = this.url;
                }
                if (split.length > 1) {
                    try {
                        this.fileSize = Long.valueOf(split[1]).longValue();
                    } catch (Exception unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d(getClass().getName(), 2, "java.lang.NumberFormatException: Invalid long: " + split[1] + " msg byte " + aw.a(this.f203106msg));
                        }
                    }
                }
                if (split.length > 2) {
                    try {
                        this.itemType = Integer.parseInt(split[2]);
                    } catch (Exception unused2) {
                        if (QLog.isColorLevel()) {
                            QLog.d(getClass().getName(), 2, "java.lang.NumberFormatException: Invalid int: " + split[2] + " msg byte " + aw.a(this.f203106msg));
                        }
                    }
                }
                if (split.length > 3) {
                    if (Integer.valueOf(split[3].trim()).intValue() == 0) {
                        z18 = false;
                    }
                    this.isReadPtt = z18;
                } else {
                    this.isReadPtt = true;
                }
                if (split.length > 4) {
                    this.urlAtServer = split[4];
                    return;
                }
                return;
            }
            if (this.f203106msg == null) {
                this.url = "";
                this.urlAtServer = "";
                return;
            }
            return;
        } catch (Throwable th6) {
            if (this.f203106msg == null) {
            }
            th6.printStackTrace();
        }
        if (this.f203106msg == null) {
            this.url = "";
            this.urlAtServer = "";
        }
        th6.printStackTrace();
    }

    public String getLocalFilePath() {
        return getLocalFilePath(this.voiceType, this.url);
    }

    public String getLocalFilePathWithoutReplaceSuffix() {
        return getLocalFilePath(0, this.url);
    }

    public im_msg_body$RichText getRichText() {
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body$Ptt im_msg_body_ptt = new im_msg_body$Ptt();
        if (TextUtils.isEmpty(this.md5)) {
            try {
                this.md5 = com.tencent.qqprotect.singleupdate.a.d(new File(getLocalFilePath()));
                serial();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        int i3 = this.istroop;
        if (i3 != 1 && i3 != 3000) {
            im_msg_body_ptt.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.md5 + ".amr"));
            im_msg_body_ptt.uint32_file_type.set(4);
            im_msg_body_ptt.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.urlAtServer));
            im_msg_body_ptt.uint32_file_size.set((int) this.fileSize);
            im_msg_body_ptt.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.md5)));
            im_msg_body_ptt.bytes_reserve.set(ByteStringMicro.copyFrom(((IMessageForPttUtilsApi) QRoute.api(IMessageForPttUtilsApi.class)).c2cConstructPTTExtraInfo(this)));
            im_msg_body_ptt.bytes_down_para.set(ByteStringMicro.copyFromUtf8(this.directUrl));
            im_msg_body$GeneralFlags im_msg_body_generalflags = new im_msg_body$GeneralFlags();
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            if (this.waveformArray != null) {
                generalflags_resvattr.bytes_pb_ptt_waveform.set(ByteStringMicro.copyFrom(((IMessageForPttUtilsApi) QRoute.api(IMessageForPttUtilsApi.class)).changeWaveformToPb(this.waveformArray)));
                im_msg_body_generalflags.bytes_pb_reserve.set(ByteStringMicro.copyFrom(generalflags_resvattr.toByteArray()));
            }
            im_msg_body_elem.general_flags.set(im_msg_body_generalflags);
        } else {
            im_msg_body_ptt.uint32_file_type.set(4);
            im_msg_body_ptt.uint32_file_id.set((int) this.groupFileID);
            im_msg_body_ptt.uint32_file_size.set((int) this.fileSize);
            im_msg_body_ptt.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.md5)));
            String str = this.urlAtServer;
            if (str != null) {
                im_msg_body_ptt.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(str));
                im_msg_body_ptt.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.urlAtServer));
            } else {
                im_msg_body_ptt.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.md5 + ".amr"));
            }
            im_msg_body_ptt.uint32_format.set(this.voiceType);
            im_msg_body_ptt.uint32_time.set(this.voiceLength);
            im_msg_body_ptt.bytes_down_para.set(ByteStringMicro.copyFromUtf8(this.directUrl));
            String str2 = this.groupFileKeyStr;
            if (str2 != null) {
                im_msg_body_ptt.bytes_group_file_key.set(ByteStringMicro.copyFromUtf8(str2));
            }
            im_msg_body_ptt.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((IMessageForPttUtilsApi) QRoute.api(IMessageForPttUtilsApi.class)).groupConstructPTTExtraInfo(this)));
            im_msg_body$GeneralFlags im_msg_body_generalflags2 = new im_msg_body$GeneralFlags();
            generalflags$ResvAttr generalflags_resvattr2 = new generalflags$ResvAttr();
            if (this.waveformArray != null) {
                generalflags_resvattr2.bytes_pb_ptt_waveform.set(ByteStringMicro.copyFrom(((IMessageForPttUtilsApi) QRoute.api(IMessageForPttUtilsApi.class)).changeWaveformToPb(this.waveformArray)));
                im_msg_body_generalflags2.bytes_pb_reserve.set(ByteStringMicro.copyFrom(generalflags_resvattr2.toByteArray()));
            }
            im_msg_body_elem.general_flags.set(im_msg_body_generalflags2);
        }
        im_msg_body_richtext.ptt.set(im_msg_body_ptt);
        im_msg_body_richtext.elems.add(im_msg_body_elem);
        return im_msg_body_richtext;
    }

    public synchronized com.tencent.mobileqq.stt.shard.a getSttResult() {
        if (this.sttResult == null) {
            this.sttResult = new com.tencent.mobileqq.stt.shard.a();
        }
        return this.sttResult;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return ((IMessageForPttInnerApi) QRoute.api(IMessageForPttInnerApi.class)).getSummaryMsg(this.sttText, this.sttAbility);
    }

    public boolean hasSttTxt() {
        return ((IMessageForPttInnerApi) QRoute.api(IMessageForPttInnerApi.class)).hasSttTxt(this.sttText, this.sttAbility);
    }

    public boolean isReady() {
        long j3 = this.fileSize;
        if (j3 <= 0 && j3 != -3 && j3 != -1) {
            return false;
        }
        return true;
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

    public void serial() {
        if (this.versionCode < 3) {
            this.subVersion = 0;
        }
        RichMsg$PttRec richMsg$PttRec = new RichMsg$PttRec();
        PBStringField pBStringField = richMsg$PttRec.localPath;
        String str = this.url;
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        richMsg$PttRec.size.set(this.fileSize);
        richMsg$PttRec.type.set(this.itemType);
        richMsg$PttRec.isRead.set(this.isReadPtt);
        PBStringField pBStringField2 = richMsg$PttRec.uuid;
        String str2 = this.urlAtServer;
        if (str2 == null) {
            str2 = "";
        }
        pBStringField2.set(str2);
        PBStringField pBStringField3 = richMsg$PttRec.md5;
        String str3 = this.md5;
        if (str3 == null) {
            str3 = "";
        }
        pBStringField3.set(str3);
        PBStringField pBStringField4 = richMsg$PttRec.serverStorageSource;
        String str4 = this.storageSource;
        if (str4 == null) {
            str4 = "";
        }
        pBStringField4.set(str4);
        richMsg$PttRec.version.set(this.subVersion);
        richMsg$PttRec.isReport.set(this.isReport);
        richMsg$PttRec.pttFlag.set(this.sttAbility);
        richMsg$PttRec.groupFileID.set(this.groupFileID);
        PBStringField pBStringField5 = richMsg$PttRec.sttText;
        String str5 = this.sttText;
        if (str5 == null) {
            str5 = "";
        }
        pBStringField5.set(str5);
        richMsg$PttRec.longPttVipFlag.set(this.longPttVipFlag);
        richMsg$PttRec.expandStt.set(this.expandStt);
        String str6 = this.groupFileKeyStr;
        if (str6 != null) {
            richMsg$PttRec.group_file_key.set(str6);
        }
        richMsg$PttRec.msgTime.set(this.msgTime);
        richMsg$PttRec.msgRecTime.set(this.msgRecTime);
        richMsg$PttRec.voiceType.set(this.voiceType);
        richMsg$PttRec.voiceLength.set(Utils.O(this.voiceLength));
        richMsg$PttRec.voiceChangeFlag.set(this.voiceChangeFlag);
        richMsg$PttRec.busiType.set(this.busiType);
        richMsg$PttRec.directUrl.set(this.directUrl);
        richMsg$PttRec.fullLocalPath.set(this.fullLocalPath);
        richMsg$PttRec.extFlag.set(this.extFlag);
        richMsg$PttRec.redpack_type.set(this.voiceRedPacketFlag);
        richMsg$PttRec.autototext_voice.set(this.autoToText);
        try {
            this.msgData = richMsg$PttRec.toByteArray();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        saveExtInfoToExtStr("is_to_robot", this.mRobotFlag + "");
        JSONArray jSONArray = this.atInfo;
        if (jSONArray != null) {
            saveExtInfoToExtStr("at_robot_info", jSONArray.toString());
        }
        int[] iArr = this.waveformArray;
        if (iArr != null && iArr.length > 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i3 : this.waveformArray) {
                jSONArray2.put(i3);
            }
            saveExtInfoToExtStr("wave_form", jSONArray2.toString());
        }
    }

    public static String getLocalFilePath(int i3, String str) {
        return ((IMessageForPttInnerApi) QRoute.api(IMessageForPttInnerApi.class)).getLocalFilePath(i3, str);
    }
}
