package com.tencent.mobileqq.shortvideo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.msg.api.IConfessMsgUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.peak.PeakConstants;
import mqq.app.MobileQQ;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends b {
    public a(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
    }

    private int y(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 3000) {
            return 2;
        }
        return 3;
    }

    private void z(MessageForShortVideo messageForShortVideo) {
        if (messageForShortVideo == null) {
            return;
        }
        int i3 = messageForShortVideo.istroop;
        if (i3 == 0) {
            messageForShortVideo.fileType = 6;
            return;
        }
        if (i3 == 3000) {
            messageForShortVideo.fileType = 17;
        } else if (i3 == 1) {
            messageForShortVideo.fileType = 9;
        } else if (i3 == 10014) {
            messageForShortVideo.fileType = 67;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03c6  */
    @Override // xq2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p f(Object obj, v vVar) {
        boolean z16;
        long j3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        boolean z17;
        int i37;
        int i38;
        boolean z18;
        int i39;
        int i46;
        boolean z19;
        int i47;
        int i48;
        boolean z26;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        int y16;
        int i65;
        boolean z27;
        if (obj == null) {
            com.tencent.mobileqq.pic.f.e("AioShortVideoOperator", this.f287786h, "createShortVideoForwardInfo", "input == null");
            return null;
        }
        if (vVar == null) {
            com.tencent.mobileqq.pic.f.e("AioShortVideoOperator", this.f287786h, "createShortVideoForwardInfo", "ShortVideoReq == null");
            return null;
        }
        boolean z28 = obj instanceof Intent;
        String str30 = "0";
        if (z28) {
            Intent intent = (Intent) obj;
            String stringExtra = intent.getStringExtra("uin");
            String stringExtra2 = intent.getStringExtra("troop_uin");
            int intExtra = intent.getIntExtra("uintype", -1);
            String stringExtra3 = intent.getStringExtra(ShortVideoConstants.FROM_UIN);
            int intExtra2 = intent.getIntExtra(ShortVideoConstants.FROM_UIN_TYPE, -1);
            String stringExtra4 = intent.getStringExtra(ShortVideoConstants.FROM_SESSION_UIN);
            intent.getIntExtra(ShortVideoConstants.FROM_BUSI_TYPE, -1);
            int intExtra3 = intent.getIntExtra(ShortVideoConstants.FILE_SEND_SIZE, 0);
            int intExtra4 = intent.getIntExtra(ShortVideoConstants.FILE_SEND_DURATION, -1);
            String stringExtra5 = intent.getStringExtra("file_send_path");
            String stringExtra6 = intent.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH);
            String stringExtra7 = intent.getStringExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5);
            String stringExtra8 = intent.getStringExtra(ShortVideoConstants.FILE_SHORTVIDEO_LOCAL_MD5);
            int intExtra5 = intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, 0);
            int intExtra6 = intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, 0);
            String stringExtra9 = intent.getStringExtra(ShortVideoConstants.THUMBFILE_MD5);
            String stringExtra10 = intent.getStringExtra(ShortVideoConstants.FILE_SOURCE);
            String stringExtra11 = intent.getStringExtra(ShortVideoConstants.FILE_UUID);
            String stringExtra12 = intent.getStringExtra("file_name");
            int intExtra7 = intent.getIntExtra(ShortVideoConstants.FILE_FORMAT, 2);
            int intExtra8 = intent.getIntExtra(ShortVideoConstants.FILE_THUMB_SIZE, 0);
            boolean booleanExtra = intent.getBooleanExtra(ShortVideoConstants.SUPPORT_PROGRESSIVE, false);
            int intExtra9 = intent.getIntExtra(ShortVideoConstants.FILE_WIDTH, 0);
            int intExtra10 = intent.getIntExtra(ShortVideoConstants.FILE_HEIGHT, 0);
            str16 = intent.getStringExtra(ShortVideoConstants.HOT_VIDEO_ICON);
            str17 = intent.getStringExtra(ShortVideoConstants.HOT_VIDEO_TITLE);
            str18 = intent.getStringExtra(ShortVideoConstants.HOT_VIDEO_URL);
            str19 = intent.getStringExtra(ShortVideoConstants.HOT_VIDEO_ICON_SUB);
            int intExtra11 = intent.getIntExtra(ShortVideoConstants.SPECIAL_VIDEO_TYPE, 0);
            int intExtra12 = intent.getIntExtra(ShortVideoConstants.MSG_TAIL_TYPE, 0);
            long longExtra = intent.getLongExtra(ShortVideoConstants.FROM_MSG_UNISEQ, 0L);
            boolean booleanExtra2 = intent.getBooleanExtra(ShortVideoConstants.KEY_STORY_VIDEO_TO_RECENT, false);
            if (intent.getIntExtra("forward_source_business_type", -1) == 100200) {
                z27 = true;
            } else {
                z27 = false;
            }
            String stringExtra13 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
            boolean z29 = z27;
            String stringExtra14 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
            int intExtra13 = intent.getIntExtra(ShortVideoConstants.SOURCE_VIDEO_CODEC_FORMAT, -1);
            j3 = longExtra;
            i46 = intExtra12;
            z18 = booleanExtra2;
            i16 = intExtra;
            str8 = stringExtra5;
            str10 = stringExtra8;
            str7 = stringExtra10;
            str15 = stringExtra11;
            str5 = stringExtra9;
            i48 = intExtra7;
            i36 = intExtra8;
            z17 = booleanExtra;
            i37 = intExtra9;
            i38 = intExtra10;
            i39 = intExtra11;
            i29 = intExtra2;
            z19 = z29;
            str11 = stringExtra14;
            i28 = 0;
            i47 = 0;
            z16 = z28;
            i26 = intExtra13;
            str2 = "0";
            str13 = "";
            i3 = intExtra3;
            str6 = stringExtra7;
            str30 = stringExtra2;
            i18 = intExtra6;
            str4 = stringExtra3;
            str12 = stringExtra13;
            i27 = 0;
            i17 = intExtra4;
            str = stringExtra;
            i19 = intExtra5;
            str14 = stringExtra12;
            str3 = stringExtra4;
            str9 = stringExtra6;
        } else if (obj instanceof MessageForShortVideo) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) obj;
            String str31 = messageForShortVideo.frienduin;
            int i66 = messageForShortVideo.istroop;
            int i67 = messageForShortVideo.videoFileSize;
            int i68 = messageForShortVideo.videoFileTime;
            str8 = messageForShortVideo.videoFileName;
            str9 = j.l(messageForShortVideo.thumbMD5, "jpg");
            String str32 = messageForShortVideo.md5;
            str10 = messageForShortVideo.mLocalMd5;
            int i69 = messageForShortVideo.thumbWidth;
            int i75 = messageForShortVideo.thumbHeight;
            String str33 = messageForShortVideo.thumbMD5;
            String str34 = messageForShortVideo.fileSource;
            String str35 = messageForShortVideo.uuid;
            int i76 = messageForShortVideo.videoFileFormat;
            int i77 = messageForShortVideo.thumbFileSize;
            int i78 = messageForShortVideo.fromChatType;
            int i79 = messageForShortVideo.toChatType;
            int i85 = messageForShortVideo.busiType;
            String c16 = j.c(messageForShortVideo);
            i28 = i85;
            boolean z36 = messageForShortVideo.supportProgressive;
            int i86 = messageForShortVideo.fileWidth;
            int i87 = messageForShortVideo.fileHeight;
            int i88 = messageForShortVideo.specialVideoType;
            int i89 = messageForShortVideo.msgTailType;
            long j16 = messageForShortVideo.uniseq;
            boolean z37 = messageForShortVideo.isStoryVideo;
            if (messageForShortVideo.checkIsHotVideo()) {
                str20 = messageForShortVideo.hotVideoIconUrl;
                z26 = z37;
                str21 = messageForShortVideo.hotVideoTitle;
                str22 = messageForShortVideo.hotVideoUrl;
                str23 = messageForShortVideo.hotVideoSubIconUrl;
            } else {
                z26 = z37;
                str20 = "";
                str21 = str20;
                str22 = str21;
                str23 = str22;
            }
            String str36 = messageForShortVideo.templateId;
            str5 = str33;
            i48 = i76;
            i36 = i77;
            i47 = i79;
            str4 = c16;
            z17 = z36;
            i37 = i86;
            i38 = i87;
            i39 = i88;
            i46 = i89;
            j3 = j16;
            z18 = z26;
            str17 = str21;
            str18 = str22;
            str19 = str23;
            i29 = -1;
            z19 = false;
            str11 = messageForShortVideo.templateName;
            str16 = str20;
            str13 = "";
            i16 = i66;
            str7 = str34;
            str15 = str35;
            i27 = i78;
            i17 = i68;
            str12 = str36;
            str14 = str8;
            str2 = "0";
            str3 = str2;
            str30 = str31;
            i19 = i69;
            i26 = messageForShortVideo.sourceVideoCodecFormat;
            str6 = str32;
            i18 = i75;
            z16 = z28;
            i3 = i67;
            str = str30;
        } else {
            z16 = z28;
            j3 = 0;
            str = "0";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = "";
            str6 = str5;
            str7 = str6;
            str8 = str7;
            str9 = str8;
            str10 = str9;
            str11 = str10;
            str12 = str11;
            str13 = str12;
            str14 = str13;
            str15 = str14;
            str16 = str15;
            str17 = str16;
            str18 = str17;
            str19 = str18;
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            i19 = 0;
            i26 = -1;
            i27 = 0;
            i28 = 0;
            i29 = -1;
            i36 = 0;
            z17 = false;
            i37 = 0;
            i38 = 0;
            z18 = false;
            i39 = 0;
            i46 = 0;
            z19 = false;
            i47 = 0;
            i48 = 2;
        }
        if (TextUtils.isEmpty(str6)) {
            com.tencent.mobileqq.pic.f.e(vVar.f288267h, vVar.f288266f, "createShortVideoForwardInfo", "md5 shouldn't be empty ");
            return null;
        }
        p pVar = new p();
        pVar.f288043f = str;
        pVar.f288204r = str8;
        pVar.f288205s = str9;
        pVar.f288041d = i16;
        pVar.f288044g = str30;
        pVar.f288208v = i3;
        pVar.f288209w = i17;
        pVar.f288047j = str6;
        pVar.f288048k = str10;
        pVar.f288206t = i19;
        pVar.f288207u = i18;
        pVar.f288211y = vVar.f288264d;
        pVar.f288210x = obj;
        pVar.f288049l = str5;
        pVar.f288212z = str7;
        pVar.f288039b = str15;
        pVar.A = str14;
        pVar.B = i48;
        pVar.C = i36;
        pVar.F = z17;
        pVar.G = i37;
        pVar.H = i38;
        pVar.D = str4;
        if (str3 != null) {
            str24 = str3;
        } else {
            str24 = str2;
        }
        pVar.E = str24;
        pVar.R = j3;
        pVar.S = z18;
        if (str16 == null) {
            str25 = str13;
        } else {
            str25 = str16;
        }
        pVar.J = str25;
        if (str17 == null) {
            str26 = str13;
        } else {
            str26 = str17;
        }
        pVar.L = str26;
        if (str18 == null) {
            str27 = str13;
        } else {
            str27 = str18;
        }
        pVar.M = str27;
        if (str19 == null) {
            str28 = str13;
        } else {
            str28 = str19;
        }
        pVar.K = str28;
        pVar.N = i39;
        pVar.O = i46;
        if (2 == vVar.f288265e) {
            i49 = 0;
            pVar.P = 0;
            str29 = str13;
            pVar.Q = str29;
        } else {
            str29 = str13;
            i49 = 0;
        }
        pVar.T = z19;
        pVar.U = str12;
        pVar.V = str11;
        if (z16) {
            i56 = i29;
            i27 = y(i56);
            y16 = y(i16);
        } else {
            i56 = i29;
            if (obj instanceof MessageForShortVideo) {
                i57 = i47;
                if (i57 == -1) {
                    y16 = y(i16);
                }
            } else {
                i57 = i47;
            }
            i58 = i57;
            i59 = i27;
            if (i56 != 1008) {
                i49 = 1007;
                i65 = i28;
            } else {
                int i95 = vVar.f288265e;
                i65 = 2;
                if (2 == i95) {
                    i49 = 1;
                    i65 = 1;
                } else if (3 == i95) {
                    i49 = 2;
                } else {
                    if (5 == i95) {
                        i49 = i28;
                    }
                    i65 = i49;
                }
            }
            pVar.f288200n = i59;
            pVar.f288201o = i58;
            pVar.f288202p = i49;
            pVar.f288203q = i65;
            pVar.f288050m = i26;
            com.tencent.mobileqq.pic.f.c(vVar.f288267h, vVar.f288266f, "createShortVideoForwardInfo", str29 + pVar.c());
            return pVar;
        }
        i59 = i27;
        i58 = y16;
        if (i56 != 1008) {
        }
        pVar.f288200n = i59;
        pVar.f288201o = i58;
        pVar.f288202p = i49;
        pVar.f288203q = i65;
        pVar.f288050m = i26;
        com.tencent.mobileqq.pic.f.c(vVar.f288267h, vVar.f288266f, "createShortVideoForwardInfo", str29 + pVar.c());
        return pVar;
    }

    @Override // com.tencent.mobileqq.pic.ad
    public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
        com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "attachRichText2Msg", "");
        MessageRecord messageRecord = this.f287788m;
        if (messageRecord instanceof MessageForRichText) {
            ((MessageForRichText) messageRecord).richText = im_msg_body_richtext;
        }
        return messageRecord;
    }

    @Override // xq2.b
    public aa i(Object obj, v vVar) {
        String str;
        String str2;
        long j3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        int i3;
        int i16;
        int i17;
        long j16;
        String str16;
        int i18;
        int i19;
        boolean z16;
        int i26;
        int i27;
        boolean z17;
        boolean z18;
        int i28;
        int i29;
        boolean z19;
        String str17;
        int i36;
        boolean z26;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        if (obj == null) {
            com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "createShortVideoUploadInfo", "unknow obj");
            return null;
        }
        String str24 = "";
        if (obj instanceof Intent) {
            Intent intent = (Intent) obj;
            String stringExtra = intent.getStringExtra("uin");
            String stringExtra2 = intent.getStringExtra("troop_uin");
            int intExtra = intent.getIntExtra("uintype", 1003);
            j3 = intent.getLongExtra(ShortVideoConstants.FILE_SEND_SIZE, 0L);
            int intExtra2 = intent.getIntExtra(ShortVideoConstants.FILE_SEND_BUSINESS_TYPE, 0);
            int intExtra3 = intent.getIntExtra(ShortVideoConstants.FILE_SEND_DURATION, -1);
            String stringExtra3 = intent.getStringExtra("file_send_path");
            String stringExtra4 = intent.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH);
            String stringExtra5 = intent.getStringExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5);
            int intExtra4 = intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, 0);
            int intExtra5 = intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, 0);
            String stringExtra6 = intent.getStringExtra(ShortVideoConstants.THUMBFILE_MD5);
            String stringExtra7 = intent.getStringExtra(ShortVideoConstants.FILE_SOURCE);
            String stringExtra8 = intent.getStringExtra(ShortVideoConstants.FILE_VIDEO_SOURCE_DIR);
            boolean booleanExtra = intent.getBooleanExtra(ShortVideoConstants.SUPPORT_PROGRESSIVE, false);
            int intExtra6 = intent.getIntExtra(ShortVideoConstants.FILE_WIDTH, 0);
            int intExtra7 = intent.getIntExtra(ShortVideoConstants.FILE_HEIGHT, 0);
            boolean booleanExtra2 = intent.getBooleanExtra(ShortVideoConstants.SV_MEDIACODEC_ENCODE_ENABLE, false);
            String stringExtra9 = intent.getStringExtra(ShortVideoConstants.HOT_VIDEO_ICON);
            String stringExtra10 = intent.getStringExtra(ShortVideoConstants.HOT_VIDEO_TITLE);
            String stringExtra11 = intent.getStringExtra(ShortVideoConstants.HOT_VIDEO_URL);
            String stringExtra12 = intent.getStringExtra(ShortVideoConstants.HOT_VIDEO_ICON_SUB);
            String stringExtra13 = intent.getStringExtra(ShortVideoConstants.FILE_UUID);
            long longExtra = intent.getLongExtra(ShortVideoConstants.FILE_THUMB_SIZE, 0L);
            int intExtra8 = intent.getIntExtra(ShortVideoConstants.SPECIAL_VIDEO_TYPE, 0);
            String stringExtra14 = intent.getStringExtra(ShortVideoConstants.HOT_VIDEO_NAME);
            int intExtra9 = intent.getIntExtra(ShortVideoConstants.MSG_TAIL_TYPE, 0);
            boolean booleanExtra3 = intent.getBooleanExtra(ShortVideoConstants.FILE_RAW_SIZE, false);
            String stringExtra15 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
            z19 = booleanExtra3;
            str2 = stringExtra2;
            i36 = intExtra;
            i28 = intExtra8;
            str17 = stringExtra;
            i17 = intExtra4;
            z16 = booleanExtra;
            i26 = intExtra6;
            i27 = intExtra7;
            z18 = booleanExtra2;
            str14 = stringExtra9;
            i29 = intExtra9;
            i19 = -1;
            z17 = false;
            str8 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
            str10 = stringExtra14;
            str5 = stringExtra5;
            i18 = intExtra2;
            j16 = longExtra;
            i16 = intExtra5;
            str4 = stringExtra7;
            str15 = stringExtra8;
            str12 = stringExtra11;
            str11 = stringExtra12;
            str16 = stringExtra13;
            i3 = intExtra3;
            str = "createShortVideoUploadInfo";
            str6 = stringExtra3;
            str7 = "";
            str3 = stringExtra4;
            str24 = stringExtra6;
            str13 = stringExtra10;
            str9 = stringExtra15;
        } else if (!(obj instanceof MessageForShortVideo)) {
            str = "createShortVideoUploadInfo";
            str2 = "0";
            j3 = 0;
            str3 = "";
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            str8 = str7;
            str9 = str8;
            str10 = str9;
            str11 = str10;
            str12 = str11;
            str13 = str12;
            str14 = str13;
            str15 = str14;
            i3 = 0;
            i16 = 0;
            i17 = 0;
            j16 = -1;
            str16 = null;
            i18 = 0;
            i19 = -1;
            z16 = false;
            i26 = 0;
            i27 = 0;
            z17 = false;
            z18 = false;
            i28 = 0;
            i29 = 0;
            z19 = false;
            str17 = str2;
            i36 = 0;
        } else {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) obj;
            str17 = messageForShortVideo.frienduin;
            int i37 = messageForShortVideo.istroop;
            long j17 = messageForShortVideo.videoFileSize;
            int i38 = vVar.f288265e;
            int i39 = messageForShortVideo.videoFileTime;
            str6 = messageForShortVideo.videoFileName;
            String l3 = j.l(messageForShortVideo.thumbMD5, "jpg");
            String str25 = messageForShortVideo.md5;
            i17 = messageForShortVideo.thumbWidth;
            int i46 = messageForShortVideo.thumbHeight;
            String str26 = messageForShortVideo.thumbMD5;
            String str27 = messageForShortVideo.fileSource;
            String str28 = messageForShortVideo.mVideoFileSourceDir;
            boolean z27 = messageForShortVideo.supportProgressive;
            int i47 = messageForShortVideo.fileWidth;
            int i48 = messageForShortVideo.fileHeight;
            boolean z28 = messageForShortVideo.syncToStory;
            boolean z29 = messageForShortVideo.mediacodecEncode;
            if (messageForShortVideo.checkIsHotVideo()) {
                z26 = z29;
                str18 = messageForShortVideo.hotVideoIconUrl;
                str19 = messageForShortVideo.hotVideoTitle;
                str20 = messageForShortVideo.hotVideoUrl;
                str21 = messageForShortVideo.hotVideoSubIconUrl;
                str22 = messageForShortVideo.videoFileName;
                str23 = messageForShortVideo.uuid;
            } else {
                z26 = z29;
                str18 = "";
                str19 = str18;
                str20 = str19;
                str21 = str20;
                str22 = str21;
                str23 = null;
            }
            int i49 = messageForShortVideo.specialVideoType;
            int i56 = messageForShortVideo.msgTailType;
            boolean z36 = messageForShortVideo.sendRawVideo;
            String str29 = messageForShortVideo.templateId;
            str8 = messageForShortVideo.templateName;
            i19 = messageForShortVideo.sourceVideoCodecFormat;
            str2 = str17;
            i36 = i37;
            i3 = i39;
            str4 = str27;
            z16 = z27;
            i26 = i47;
            i27 = i48;
            z17 = z28;
            z18 = z26;
            str13 = str19;
            str12 = str20;
            str11 = str21;
            str10 = str22;
            i28 = i49;
            i29 = i56;
            z19 = z36;
            i18 = i38;
            j3 = j17;
            str14 = str18;
            str15 = str28;
            str16 = str23;
            str = "createShortVideoUploadInfo";
            str5 = str25;
            str3 = l3;
            i16 = i46;
            j16 = -1;
            str7 = "";
            str24 = str26;
            str9 = str29;
        }
        aa aaVar = new aa();
        aaVar.f288043f = str17;
        aaVar.f287745n = str6;
        aaVar.f287746o = str3;
        aaVar.f288041d = i36;
        aaVar.f288044g = str2;
        aaVar.f287749r = (int) j3;
        aaVar.f287750s = i3;
        aaVar.f288047j = str5;
        aaVar.f287747p = i17;
        aaVar.f287748q = i16;
        aaVar.f287752u = vVar.f288264d;
        aaVar.f287751t = obj;
        aaVar.f288049l = str24;
        aaVar.f287754w = str4;
        aaVar.f287753v = str15;
        aaVar.f288040c = i18;
        aaVar.f287756y = z16;
        aaVar.f287757z = i26;
        aaVar.A = i27;
        aaVar.N = z17;
        aaVar.B = z18;
        aaVar.F = str14;
        aaVar.H = str13;
        aaVar.I = str12;
        aaVar.G = str11;
        aaVar.f288039b = str16;
        aaVar.L = j16;
        aaVar.K = i28;
        aaVar.J = str10;
        aaVar.M = i29;
        aaVar.Q = z19;
        aaVar.S = str9;
        aaVar.T = str8;
        aaVar.f288050m = i19;
        com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, str, str7);
        return aaVar;
    }

    @Override // xq2.b
    public void k(BaseQQAppInterface baseQQAppInterface) {
        this.f287783d = baseQQAppInterface;
    }

    @Override // xq2.b
    public MessageRecord l(aa aaVar) {
        MessageForShortVideo messageForShortVideo;
        String str;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        if (aaVar.C) {
            messageForShortVideo = (MessageForShortVideo) ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createSendMSg_BlessPTV(this.f287783d, aaVar.f288043f, aaVar.f288044g, aaVar.f288041d);
            if (messageForShortVideo == null) {
                return null;
            }
            messageForShortVideo.subBusiType = 1;
            messageForShortVideo.videoFileName = aaVar.f287745n;
        } else if (aaVar.D) {
            messageForShortVideo = (MessageForShortVideo) ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createSendMSg_ShortVideo(this.f287783d, aaVar.f288043f, aaVar.f288044g, aaVar.f288041d);
            if (messageForShortVideo == null) {
                return null;
            }
            messageForShortVideo.subBusiType = 0;
            messageForShortVideo.hotVideoIconUrl = aaVar.F;
            messageForShortVideo.hotVideoTitle = aaVar.H;
            messageForShortVideo.hotVideoUrl = aaVar.I;
            messageForShortVideo.hotVideoSubIconUrl = aaVar.G;
            String str3 = aaVar.J;
            messageForShortVideo.videoFileName = str3;
            messageForShortVideo.videoAttr = 0;
            messageForShortVideo.videoKandianType = 0;
            if (str3 == null || str3.length() == 0) {
                StringBuilder sb5 = new StringBuilder();
                String str4 = aaVar.f288047j;
                if (str4 != null && str4.length() != 0) {
                    str = aaVar.f288047j;
                } else {
                    str = "HotVideo";
                }
                sb5.append(str);
                sb5.append(".mp4");
                messageForShortVideo.videoFileName = sb5.toString();
            }
        } else if (7 == aaVar.f288040c) {
            messageForShortVideo = (MessageForShortVideo) ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createSendMSg_VideoEmoticon(this.f287783d, aaVar.f288043f, aaVar.f288044g, aaVar.f288041d);
            if (messageForShortVideo == null) {
                return null;
            }
            messageForShortVideo.subBusiType = 0;
            messageForShortVideo.videoFileName = aaVar.f287745n;
        } else {
            messageForShortVideo = (MessageForShortVideo) ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createSendMSg_ShortVideo(this.f287783d, aaVar.f288043f, aaVar.f288044g, aaVar.f288041d);
            if (messageForShortVideo == null) {
                return null;
            }
            messageForShortVideo.subBusiType = 0;
            messageForShortVideo.videoFileName = aaVar.f287745n;
        }
        messageForShortVideo.specialVideoType = aaVar.K;
        messageForShortVideo.msgTailType = aaVar.M;
        messageForShortVideo.redBagType = aaVar.O;
        messageForShortVideo.shortVideoId = aaVar.P;
        if (aaVar.f288039b == null) {
            aaVar.f288039b = "";
        }
        messageForShortVideo.uuid = aaVar.f288039b;
        if (aaVar.f288047j == null) {
            aaVar.f288047j = "";
        }
        messageForShortVideo.md5 = aaVar.f288047j;
        messageForShortVideo.videoFileFormat = 2;
        messageForShortVideo.videoFileSize = aaVar.f287749r;
        messageForShortVideo.videoFileTime = aaVar.f287750s;
        messageForShortVideo.thumbWidth = aaVar.f287747p;
        messageForShortVideo.thumbHeight = aaVar.f287748q;
        messageForShortVideo.mThumbFilePath = aaVar.f287746o;
        messageForShortVideo.mVideoFileSourceDir = aaVar.f287753v;
        messageForShortVideo.videoFileStatus = 999;
        messageForShortVideo.videoFileProgress = 0;
        messageForShortVideo.extraflag = 32772;
        messageForShortVideo.thumbMD5 = aaVar.f288049l;
        String str5 = aaVar.f287754w;
        if (str5 == null || str5.length() == 0) {
            aaVar.f287754w = "camera";
        }
        messageForShortVideo.fileSource = aaVar.f287754w;
        messageForShortVideo.lastModified = 0L;
        messageForShortVideo.mediacodecEncode = aaVar.B;
        z(messageForShortVideo);
        if (aaVar.f288041d == 1008) {
            messageForShortVideo.busiType = 1007;
        } else {
            int i3 = aaVar.f288040c;
            if (2 == i3) {
                messageForShortVideo.busiType = 1;
            } else if (3 == i3) {
                messageForShortVideo.busiType = 2;
            } else if (7 == i3) {
                messageForShortVideo.busiType = 1021;
            } else {
                messageForShortVideo.busiType = 0;
            }
        }
        if (messageForShortVideo.istroop == 10014) {
            int i16 = messageForShortVideo.busiType;
            if (i16 == 1) {
                messageForShortVideo.subBusiType = 4602;
            } else if (i16 == 0) {
                messageForShortVideo.subBusiType = 4601;
            }
            messageForShortVideo.busiType = 4601;
            messageForShortVideo.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
            ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(messageForShortVideo, ((IGPSService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getGuildIdOf(messageForShortVideo.frienduin));
        }
        int i17 = aaVar.f288041d;
        if (i17 == 0) {
            ((IConfessMsgUtil) QRoute.api(IConfessMsgUtil.class)).bindC2CFirstMsgConfessInfo(this.f287783d, messageForShortVideo, aaVar.f288043f);
        } else if (i17 == 1) {
            ((IConfessMsgUtil) QRoute.api(IConfessMsgUtil.class)).bindGroupFirstMsgConfessInfo(this.f287783d, messageForShortVideo, aaVar.f288043f);
        }
        messageForShortVideo.fromChatType = -1;
        messageForShortVideo.toChatType = -1;
        messageForShortVideo.uiOperatorFlag = 1;
        messageForShortVideo.supportProgressive = aaVar.f287756y;
        messageForShortVideo.fileWidth = aaVar.f287757z;
        messageForShortVideo.fileHeight = aaVar.A;
        boolean z16 = aaVar.N;
        messageForShortVideo.syncToStory = z16;
        String str6 = com.tencent.mobileqq.service.message.i.f286271n;
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        messageForShortVideo.saveExtInfoToExtStr(str6, str2);
        boolean z17 = aaVar.Q;
        messageForShortVideo.sendRawVideo = z17;
        if (z17) {
            messageForShortVideo.saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.C, "1");
        }
        if (messageForShortVideo.busiType == 2) {
            messageForShortVideo.f203106msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
        } else {
            messageForShortVideo.f203106msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
        }
        if (!TextUtils.isEmpty(aaVar.S)) {
            messageForShortVideo.templateId = aaVar.S;
            messageForShortVideo.templateName = aaVar.T;
        }
        messageForShortVideo.serial();
        aaVar.f288045h = messageForShortVideo.uniseq;
        com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "packmsg", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
        com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "packMsg", "mr: " + messageForShortVideo.toLogString() + "-" + messageForShortVideo.toString());
        return messageForShortVideo;
    }

    @Override // xq2.b
    public void n(v vVar) {
        this.f287784e = vVar;
    }

    @Override // xq2.b
    public void o(String str) {
        this.f287786h = str;
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void r(ad.a aVar) {
        com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "updateMsg", "resut:" + aVar);
        if (aVar != null) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) this.f287788m;
            messageForShortVideo.videoFileSize = (int) aVar.f258601e;
            messageForShortVideo.uuid = aVar.f258602f;
            messageForShortVideo.md5 = aVar.f258603g;
            messageForShortVideo.thumbFileSize = (int) aVar.f258605i;
            messageForShortVideo.videoAttr = aVar.f258606j;
            messageForShortVideo.videoKandianType = aVar.f258607k;
            messageForShortVideo.serial();
            IMessageFacade iMessageFacade = (IMessageFacade) this.f287783d.getRuntimeService(IMessageFacade.class);
            if (iMessageFacade != null) {
                MessageRecord messageRecord = this.f287788m;
                iMessageFacade.updateMsgContentByUniseq(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, messageForShortVideo.msgData);
            }
        }
    }

    @Override // xq2.b
    public MessageRecord s(p pVar) {
        long currentTimeMillis = System.currentTimeMillis();
        MessageForShortVideo messageForShortVideo = (MessageForShortVideo) ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createSendMSg_ShortVideo(this.f287783d, pVar.f288043f, pVar.f288044g, pVar.f288041d);
        if (messageForShortVideo == null) {
            return null;
        }
        messageForShortVideo.videoFileName = pVar.f288204r;
        String str = "";
        if (pVar.f288039b == null) {
            pVar.f288039b = "";
        }
        messageForShortVideo.uuid = pVar.f288039b;
        if (pVar.f288047j == null) {
            pVar.f288047j = "";
        }
        messageForShortVideo.md5 = pVar.f288047j;
        messageForShortVideo.mLocalMd5 = pVar.f288048k;
        messageForShortVideo.videoFileName = pVar.A;
        messageForShortVideo.videoFileFormat = pVar.B;
        messageForShortVideo.videoFileSize = pVar.f288208v;
        messageForShortVideo.videoFileTime = pVar.f288209w;
        messageForShortVideo.thumbWidth = pVar.f288206t;
        messageForShortVideo.thumbHeight = pVar.f288207u;
        messageForShortVideo.videoFileStatus = 999;
        messageForShortVideo.videoFileProgress = 0;
        int i3 = pVar.f288041d;
        if (i3 == 0) {
            messageForShortVideo.fileType = 6;
        } else if (i3 == 3000) {
            messageForShortVideo.fileType = 17;
        } else if (i3 == 1) {
            messageForShortVideo.fileType = 9;
        } else if (i3 == 10014) {
            messageForShortVideo.fileType = 67;
        }
        messageForShortVideo.thumbMD5 = pVar.f288049l;
        if (pVar.f288212z == null) {
            pVar.f288212z = "";
        }
        messageForShortVideo.fileSource = pVar.f288212z;
        messageForShortVideo.lastModified = 0L;
        messageForShortVideo.thumbFileSize = pVar.C;
        int i16 = pVar.f288203q;
        messageForShortVideo.busiType = i16;
        messageForShortVideo.fromChatType = pVar.f288200n;
        messageForShortVideo.toChatType = pVar.f288201o;
        messageForShortVideo.uiOperatorFlag = 2;
        messageForShortVideo.supportProgressive = pVar.F;
        messageForShortVideo.fileWidth = pVar.G;
        messageForShortVideo.fileHeight = pVar.H;
        if (i16 == 2) {
            messageForShortVideo.f203106msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
        } else {
            messageForShortVideo.f203106msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
        }
        String str2 = pVar.J;
        if (str2 == null) {
            str2 = "";
        }
        messageForShortVideo.hotVideoIconUrl = str2;
        String str3 = pVar.L;
        if (str3 == null) {
            str3 = "";
        }
        messageForShortVideo.hotVideoTitle = str3;
        String str4 = pVar.M;
        if (str4 == null) {
            str4 = "";
        }
        messageForShortVideo.hotVideoUrl = str4;
        String str5 = pVar.K;
        if (str5 != null) {
            str = str5;
        }
        messageForShortVideo.hotVideoSubIconUrl = str;
        messageForShortVideo.specialVideoType = pVar.N;
        messageForShortVideo.msgTailType = pVar.O;
        messageForShortVideo.redBagType = pVar.P;
        messageForShortVideo.shortVideoId = pVar.Q;
        messageForShortVideo.isStoryVideo = pVar.S;
        if (!TextUtils.isEmpty(pVar.U)) {
            messageForShortVideo.templateId = pVar.U;
            messageForShortVideo.templateName = pVar.V;
        }
        if (messageForShortVideo.istroop == 10014) {
            int i17 = messageForShortVideo.busiType;
            if (i17 == 1) {
                messageForShortVideo.subBusiType = 4602;
            } else if (i17 == 0) {
                messageForShortVideo.subBusiType = 4601;
            }
            messageForShortVideo.busiType = 4601;
        }
        messageForShortVideo.sourceVideoCodecFormat = pVar.f288050m;
        messageForShortVideo.serial();
        pVar.f288045h = messageForShortVideo.uniseq;
        com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "packForwardMsg", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
        com.tencent.mobileqq.pic.f.c(this.f287787i, this.f287786h, "packForwardMsg", "mr: " + messageForShortVideo.toString());
        return messageForShortVideo;
    }

    @Override // xq2.b
    public void setLogTag(String str) {
        this.f287787i = str;
    }

    public a() {
    }
}
