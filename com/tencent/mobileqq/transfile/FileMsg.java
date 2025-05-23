package com.tencent.mobileqq.transfile;

import KQQFS.VerifyCode;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class FileMsg {
    static IPatchRedirector $redirector_ = null;
    public static final String DYNAMIC_EMO_EXT = "gif";
    public static final String FILE_PHOTO_DIR = "photo/";
    public static final String FILE_PTT_DIR = "ptt/";
    public static final int LOG_EVENT_FLOW_DOWN = 4;
    public static final int LOG_EVENT_FLOW_UP = 3;
    public static final int LOG_EVENT_RETRY = 2;
    public static final int LOG_EVENT_SERVER_EXIST = 5;
    public static final int LOG_EVENT_SIGNAL_SIG_FINISH = 0;
    public static final int LOG_EVENT_SIGNAL_URL_FINISH = 1;
    public static final long MAGIC_TIME = 612345;
    public static final int RESULT_CODE_0X211_CCMSG_ERROR = 90460;
    public static final int RESULT_CODE_A9_NAME_NULL = 90451;
    public static final int RESULT_CODE_A9_OFLINE_UUID_NULL = 9081;
    public static final int RESULT_CODE_CONECTION_TIMEOUT = 4606;
    public static final int RESULT_CODE_DECODE_RESP_ERROR = 9045;
    public static final int RESULT_CODE_FAIL_BUT_NOT_SET_REASON = 9001;
    public static final int RESULT_CODE_FILEIO = 9003;
    public static final int RESULT_CODE_GETFILEMD5ERROR = 9041;
    public static final int RESULT_CODE_GROUP_REDIRECT_ERROR = 9011;
    public static final int RESULT_CODE_HTTPDECODE_EXCEPTION = 9023;
    public static final int RESULT_CODE_HTTP_SERVER_404_ERROR = 9024;
    public static final int RESULT_CODE_HTTP_SERVER_4XX_ERROR = 9060;
    public static final int RESULT_CODE_HTTP_SERVER_5XX_ERROR = 9061;
    public static final int RESULT_CODE_HTTP_SERVER_CONNECT_EXCEPTION = 9052;
    public static final int RESULT_CODE_HTTP_SERVER_NO_ROUTER = 9053;
    public static final int RESULT_CODE_HTTP_SERVER_OTHER = 9032;
    public static final int RESULT_CODE_HTTP_SERVER_PORT_UNREACH = 9054;
    public static final int RESULT_CODE_HTTP_SERVER_RANG_ERROR = 9009;
    public static final int RESULT_CODE_HTTP_SERVER_READ_TIME_OUT = 8;
    public static final int RESULT_CODE_HTTP_SERVER_SAFE_404_ERROR = 9035;
    public static final int RESULT_CODE_HTTP_SERVER_SOCKET_EXCEPTION = 9057;
    public static final int RESULT_CODE_MD5_COMPARE_ERROR = 9082;
    public static final int RESULT_CODE_MSF_TIMEOUT = 9043;
    public static final int RESULT_CODE_MSG_HANDLER_ERROR = 9006;
    public static final int RESULT_CODE_NO_NETWORK = 9004;
    public static final int RESULT_CODE_NO_SIG = 9008;
    public static final int RESULT_CODE_PARAM_ERROR = 9005;
    public static final int RESULT_CODE_RECV_LESS_THAN_EXPECTED = 9015;
    public static final int RESULT_CODE_SDCARDNOSPACE = 9040;
    public static final int RESULT_CODE_SENDFILENOTEXIST = 9042;
    public static final int RESULT_CODE_UNKONW_ERROR = 9001;
    public static final int RESULT_CODE_URL_FORM_EXCEPTION = 9048;
    public static final int RESULT_CODE_WY_OFLINE_UUID_NULL = 9080;
    public static final int RETRY_HTTP_FAIL = 1;
    public static final int RETRY_SIGNAL_FAIL = 0;
    public static final int RETRY_STREAM_OUT_OF_ORDER = 2;
    public static String RichTag = null;
    public static final int STATUS_FILE_EXPIRED = 5002;
    public static final int STATUS_FILE_TRANSFERING = 5000;
    public static final int STATUS_FILE_UNEXSIT = 5003;
    public static final int STATUS_FILE_UNSAFE = 5001;
    public static final int STATUS_FORWARD_WAIT = 4001;
    public static final int STATUS_PAUSE = 1006;
    public static final int STATUS_PLAY_RECV_PROCESS_KILL = 2009;
    public static final int STATUS_PTT_VOICE_CHANGING = 7000;
    public static final int STATUS_RECV_CANCEL = 2004;
    public static final int STATUS_RECV_ERROR = 2005;
    public static final int STATUS_RECV_FINISHED = 2003;
    public static final int STATUS_RECV_PAUSE = 2007;
    public static final int STATUS_RECV_PREPARED = 2008;
    public static final int STATUS_RECV_PROCESS = 2002;
    public static final int STATUS_RECV_REQUEST = 2000;
    public static final int STATUS_RECV_SPACE_ERROR = 2006;
    public static final int STATUS_RECV_START = 2001;
    public static final int STATUS_SEND_AND_SAVE_FINISHED = 1008;
    public static final int STATUS_SEND_CANCEL = 1004;
    public static final int STATUS_SEND_COMPRESS = 998;
    public static final int STATUS_SEND_ERROR = 1005;
    public static final int STATUS_SEND_FINISHED = 1003;
    public static final int STATUS_SEND_PREPARE = 999;
    public static final int STATUS_SEND_PROCESS = 1002;
    public static final int STATUS_SEND_REQUEST = 1000;
    public static final int STATUS_SEND_START = 1001;
    public static final int STATUS_UPLOAD_FINISHED = 1007;
    public static final int STATUS_VERIFY_ERROR = 3002;
    public static final int STATUS_VERIFY_REQUIRE = 3000;
    public static final int STATUS_VERIFY_SUCCESS = 3001;
    public static final int TRANSFILE_TYPE_ASSISTANT = 327697;
    public static final int TRANSFILE_TYPE_BASE_DYNAMIC_AVATAR_BIG = 36;
    public static final int TRANSFILE_TYPE_BASE_DYNAMIC_AVATAR_MEDIUM = 37;
    public static final int TRANSFILE_TYPE_BASE_DYNAMIC_AVATAR_SMALL = 38;
    public static final int TRANSFILE_TYPE_BASE_STATIC_AVATAR = 48;
    public static final int TRANSFILE_TYPE_BDH_COMMON_UP = 24;
    public static final int TRANSFILE_TYPE_BULUO_AUDIO_SILK = 25;
    public static final int TRANSFILE_TYPE_C2B_UPLOAD_FILE = 34;
    public static final int TRANSFILE_TYPE_CIRCLE = 131077;
    public static final int TRANSFILE_TYPE_EXTEND_FRIEND_AVATAR = 68;
    public static final int TRANSFILE_TYPE_EXTEND_FRIEND_PHOTO_WALL = 67;
    public static final int TRANSFILE_TYPE_EXTEND_FRIEND_SOUND = 23;
    public static final int TRANSFILE_TYPE_FILE = 0;
    public static final int TRANSFILE_TYPE_FRESH_NEWS_PHOTO = 21;
    public static final int TRANSFILE_TYPE_FRIEND_AVATAR = 22;
    public static final int TRANSFILE_TYPE_HOMEWORK_AUDIO_SILK = 65;
    public static final int TRANSFILE_TYPE_JS_PTT = 32;
    public static final int TRANSFILE_TYPE_LIGHT_VIDEO = 327689;
    public static final int TRANSFILE_TYPE_MAP = 65536;
    public static final int TRANSFILE_TYPE_MULTIMSG = 131078;
    public static final int TRANSFILE_TYPE_NEARBY_ALUMNI = 131080;
    public static final int TRANSFILE_TYPE_NEARBY_AUTH_THUMB = 64;
    public static final int TRANSFILE_TYPE_NEARBY_DYNAMIC_AVATAR_BIG = 39;
    public static final int TRANSFILE_TYPE_NEARBY_DYNAMIC_AVATAR_MEDIUM = 40;
    public static final int TRANSFILE_TYPE_NEARBY_DYNAMIC_AVATAR_SMALL = 41;
    public static final int TRANSFILE_TYPE_NEARBY_PEOPLE_PHOTO_WALL = 8;
    public static final int TRANSFILE_TYPE_OCR = 57;
    public static final int TRANSFILE_TYPE_PA_AUDIO = 33;
    public static final int TRANSFILE_TYPE_PERSONALITY_LABEL_PHOTO_WALL = 56;
    public static final int TRANSFILE_TYPE_PIC = 1;
    public static final int TRANSFILE_TYPE_PIC_EMO = 65538;
    public static final int TRANSFILE_TYPE_PIC_THUMB = 65537;
    public static final int TRANSFILE_TYPE_PISMA = 49;
    public static final int TRANSFILE_TYPE_PROFILE_COVER = 35;
    public static final int TRANSFILE_TYPE_PTT = 2;
    public static final int TRANSFILE_TYPE_PTT_SILK_SLICE_TO_TEXT = 327699;
    public static final int TRANSFILE_TYPE_PTT_SLICE_TO_TEXT = 327696;
    public static final int TRANSFILE_TYPE_QQHEAD_PIC = 131074;
    public static final int TRANSFILE_TYPE_RAWPIC = 131075;
    public static final int TRANSFILE_TYPE_SCRIBBLE_DATA = 262153;
    public static final int TRANSFILE_TYPE_SHARE_PIC_TO_WX = 66;
    public static final int TRANSFILE_TYPE_SHORT_VIDEO_C2C = 6;
    public static final int TRANSFILE_TYPE_SHORT_VIDEO_DEVICE = 19;
    public static final int TRANSFILE_TYPE_SHORT_VIDEO_DISUSS = 17;
    public static final int TRANSFILE_TYPE_SHORT_VIDEO_FORWARD = 20;
    public static final int TRANSFILE_TYPE_SHORT_VIDEO_GUILD = 67;
    public static final int TRANSFILE_TYPE_SHORT_VIDEO_THUMB_C2C = 7;
    public static final int TRANSFILE_TYPE_SHORT_VIDEO_THUMB_DISUSS = 18;
    public static final int TRANSFILE_TYPE_SHORT_VIDEO_THUMB_GUILD = 68;
    public static final int TRANSFILE_TYPE_SHORT_VIDEO_THUMB_TROOP = 16;
    public static final int TRANSFILE_TYPE_SHORT_VIDEO_TROOP = 9;
    public static final int TRANSFILE_TYPE_SM_LONGMESSAGE = 131079;
    public static final int TRANSFILE_TYPE_STAR_PHOTO = 50;
    public static final int TRANSFILE_TYPE_STAR_PHOTO_THUMBNAIL = 51;
    public static final int TRANSFILE_TYPE_STRUCT_SHARE = 52;
    public static final int TRANSFILE_TYPE_THEME = 131072;
    public static final int TRANSFILE_TYPE_TRIBE_UGC_VIDEO = 327681;
    public static final int TRANSFILE_TYPE_TROOP_EFFECT_PIC = 55;
    public static final int TRANSFILE_TYPE_UFDOWNLOAD_FILE = 5;
    public static final int TRANSFILE_TYPE_URL = 131076;
    public static final int TRANSFILE_TYPE_VIDEO = 3;
    public static final int TRANSFILE_TYPE_VOICE_SEARCH_SILK = 53;
    public static final int TRANSFILE_TYPE_ZPLAN_CDN_AVATAR = 71;
    public static final int TRANSFILE_TYPE_ZPLAN_CDN_IMAGE = 70;
    public static final int TRANSFILE_TYPE_ZPLAN_CDN_MOD = 72;
    public static final int TRANSFILE_TYPE_ZPLAN_UGC_DYEING = 327698;
    public static final int TRANSFILE_TYPE_ZPLAN_USER_IMAGE = 69;
    public static final int TYPE_RECV = 1;
    public static final int TYPE_RECV_ONLINE = 2;
    public static final int TYPE_SEND = 0;
    public static final int UIN_BUDDY = 0;
    public static final int UIN_DISCUSS = 2;
    public static final int UIN_TROOP = 1;
    static String[] actionTagArr;
    public static String defaultTag;
    static String[] fileTypeTagArray;
    private static String[] logDesc;
    public int actionType;
    public long appShareID;
    public String appShareUrl;
    public byte[] bdhExtendInfo;
    public String bigDownUrl;
    public int commandId;
    public String compressUrl;
    public HttpMsg curRequest;
    private int currPofSendStream;
    public String domain;
    public String downDomain;
    public long endTime;
    public int errorCode;
    public String errorMessage;
    public File file;
    public long fileID;
    public String fileKey;
    public String fileMd5;
    public String filePath;
    public long fileSize;
    public int fileType;
    public String fileUrl;
    public String forwardTaskKey;
    public String friendUin;
    public int isRead;
    public boolean isStreamMode;
    public int lastStatus;
    public byte[] localFileMd5;
    public String logTag;
    public long mSecMsgId;
    public long mSubMsgId;
    public String mUin;
    public String msgImageData;
    public String msgTime;
    public String orgiDownUrl;
    public String peerUin;
    public int picScale;
    public long picThumbSize;
    public BaseTransProcessor processor;
    public boolean processorDoReportSelf;
    public int pttSlicePos;
    public String pttSliceText;
    public OutputStream revStream;
    public String selfUin;
    public InputStream sendStream;
    public String serverPath;
    public long startTime;
    public int status;
    public StepTransInfo stepMsgDirecDown;
    public StepBaseInfo stepNotify;
    public StepBaseInfo stepSig;
    public StepTransInfo stepTrans;
    public StepBaseInfo stepUrl;
    public long stepUrlCost;
    public String suffixType;
    public String thumbDownUrl;
    public String thumbPath;
    public String thumbUrl;
    public String tmpFilePath;
    public byte[] transferData;
    public long transferedSize;
    public String uKey;
    public int uinType;
    public long uniseq;
    public String[] urls;
    public byte[] userInfo;
    public String uuidPath;
    public VerifyCode verifyCode;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class StepBaseInfo {
        static IPatchRedirector $redirector_;
        public long detailErrCode;
        public int errCode;
        public String errDesc;
        public int failTryCount;
        public long finishTime;
        public boolean isReported;
        public boolean result;
        public int retryCount;
        public long startTime;
        public int successTryCount;

        public StepBaseInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.result = true;
            this.startTime = 0L;
            this.finishTime = 0L;
            this.errCode = 9001;
            this.errDesc = "";
            this.isReported = false;
            this.retryCount = 1;
            this.successTryCount = 0;
            this.failTryCount = 0;
            this.detailErrCode = Long.MAX_VALUE;
        }

        public String getStepReportInfo(int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            sb5.append("_");
            if (this.result) {
                if (this.startTime > 0) {
                    sb5.append("1");
                } else {
                    sb5.append("-1");
                }
                sb5.append("_");
            } else {
                sb5.append("0");
                sb5.append("_");
            }
            if (!(this instanceof StepTransInfo) && !this.result && (i16 = this.successTryCount) > 0) {
                this.failTryCount += i16;
                this.successTryCount = 0;
            }
            sb5.append(this.successTryCount);
            sb5.append("_");
            sb5.append(this.failTryCount);
            sb5.append("_");
            sb5.append(this.finishTime - this.startTime);
            return sb5.toString();
        }

        public long getTimeElapsed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            long j3 = this.startTime;
            if (j3 != 0) {
                long j16 = this.finishTime;
                if (j16 != 0) {
                    return j16 - j3;
                }
            }
            if (j3 == 0 && this.finishTime == 0) {
                return 0L;
            }
            return FileMsg.MAGIC_TIME;
        }

        public void reset() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            this.result = true;
            this.startTime = 0L;
            this.finishTime = 0L;
            this.errCode = 9001;
            this.errDesc = "";
            this.isReported = false;
            this.retryCount = 1;
            this.successTryCount = 0;
            this.failTryCount = 0;
            this.detailErrCode = Long.MAX_VALUE;
        }

        public boolean shouldReport() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.startTime == 0 && this.finishTime == 0) {
                return false;
            }
            return true;
        }

        public String toJson() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            if (shouldReport()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("{");
                sb5.append("result:" + this.result);
                sb5.append(",elapsed:" + getTimeElapsed());
                sb5.append(",errCode:" + this.errCode);
                sb5.append(",retryCount:" + this.retryCount);
                if (this.detailErrCode != Long.MAX_VALUE) {
                    sb5.append(",detailError:" + this.detailErrCode);
                }
                sb5.append("}");
                return sb5.toString();
            }
            return "{}";
        }

        public String toReportJson() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            if (shouldReport()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("{");
                sb5.append("elapsed:" + getTimeElapsed());
                sb5.append(",tryCount:" + this.retryCount);
                sb5.append("}");
                return sb5.toString();
            }
            return "{}";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "result:" + this.result + " startTime:" + this.startTime + " finishTime:" + this.finishTime + " errCode:" + this.errCode;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class StepTransInfo extends StepBaseInfo {
        static IPatchRedirector $redirector_;
        public String actualUrl;
        public long contentSize;
        public HashMap<String, String> extraInfo;
        public String firstIp;
        public long flowDown;
        public long flowUp;
        public int httpRespCode;
        public boolean isBigChannel;
        public boolean isStream;
        public String lastUseIp;
        public String respHeader;
        public boolean serverExist;

        public StepTransInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.serverExist = false;
            this.flowUp = 0L;
            this.flowDown = 0L;
            this.contentSize = 0L;
            this.isStream = false;
            this.httpRespCode = 0;
            this.isBigChannel = false;
            this.extraInfo = new HashMap<>();
        }

        @Override // com.tencent.mobileqq.transfile.FileMsg.StepBaseInfo
        public String toJson() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (shouldReport()) {
                long j3 = this.flowUp + this.flowDown;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("{");
                sb5.append("result:" + this.result);
                sb5.append(",elapsed:" + getTimeElapsed());
                sb5.append(",errCode:" + this.errCode);
                sb5.append(",retryCount:" + this.retryCount);
                sb5.append(",flow:" + j3);
                sb5.append(",isStream:" + this.isStream);
                sb5.append(",httpCode:" + this.httpRespCode);
                sb5.append(",serverExist:" + this.serverExist);
                sb5.append(",isBigChannel:" + this.isBigChannel);
                if (this.detailErrCode != Long.MAX_VALUE) {
                    sb5.append(",detailError:" + this.detailErrCode);
                }
                sb5.append(",firstIp:" + this.firstIp);
                sb5.append(",lastUseIp:" + this.lastUseIp);
                sb5.append(",respHeader:" + this.respHeader);
                sb5.append("}");
                return sb5.toString();
            }
            return "{}";
        }

        @Override // com.tencent.mobileqq.transfile.FileMsg.StepBaseInfo
        public String toReportJson() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            if (shouldReport()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("{");
                sb5.append("elapsed:" + getTimeElapsed());
                sb5.append(",tryCount:" + this.retryCount);
                sb5.append("}");
                return sb5.toString();
            }
            return "{}";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38218);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        actionTagArr = new String[]{"up", "down", "down"};
        fileTypeTagArray = new String[]{"file", "pic", "ptt", "video", "map", "thumbpic", "emo", "multimsg"};
        logDesc = new String[]{"LogEventSignalSigFinish", "LogEventSignalUrlFinish", "LogEventRetry", "LogEventFlowUp", "LogEventFlowDown"};
        defaultTag = "defaultTag";
        RichTag = "richfile";
    }

    public FileMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.actionType = -1;
        this.fileType = -1;
        this.status = -1;
        this.lastStatus = -1;
        this.processorDoReportSelf = false;
        this.fileKey = "";
        this.filePath = "";
        this.thumbPath = "";
        this.tmpFilePath = "";
        this.revStream = null;
        this.processor = null;
        this.peerUin = "";
        this.selfUin = "";
        this.msgTime = "";
        this.stepSig = new StepBaseInfo();
        this.stepUrl = new StepBaseInfo();
        this.stepNotify = new StepBaseInfo();
        this.stepTrans = new StepTransInfo();
        this.stepMsgDirecDown = new StepTransInfo();
        this.logTag = defaultTag;
        this.uinType = -1;
        this.currPofSendStream = 0;
        this.isStreamMode = false;
        this.appShareUrl = "";
        this.appShareID = 0L;
        this.startTime = System.currentTimeMillis();
    }

    public static synchronized String getTransFileDateTime() {
        String format;
        synchronized (FileMsg.class) {
            try {
                LockMethodProxy.sleep(10L);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            format = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
        }
        return format;
    }

    private void openSendFile(String str) throws FileNotFoundException {
        this.sendStream = new FileInputStream(str);
    }

    public void closeInputStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        try {
            InputStream inputStream = this.sendStream;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        this.sendStream = null;
    }

    public void closeOutputStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        try {
            OutputStream outputStream = this.revStream;
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("8pic", 2, "exception io FileMsg, " + e16.toString());
            }
            e16.printStackTrace();
        }
        this.revStream = null;
    }

    public OutputStream getReceiveStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (OutputStream) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (this.revStream == null) {
            try {
                if (this.fileType == 0) {
                    this.revStream = new FileOutputStream(this.filePath, true);
                } else {
                    this.revStream = new FileOutputStream(this.filePath);
                }
            } catch (FileNotFoundException unused) {
            }
        }
        return this.revStream;
    }

    public byte[] getSendStreamSlice(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (byte[]) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        InputStream inputStream = this.sendStream;
        this.transferData = new byte[i16];
        if (i3 == 0) {
            try {
                inputStream = resetSendStream();
            } catch (Exception unused) {
                this.transferData = null;
            }
        }
        int i17 = this.currPofSendStream;
        if (i3 > i17) {
            inputStream.skip(i3 - i17);
        } else if (i3 < i17) {
            inputStream = resetSendStream();
            inputStream.skip(i3);
        }
        this.currPofSendStream = i3;
        inputStream.read(this.transferData, 0, i16);
        this.currPofSendStream += i16;
        return this.transferData;
    }

    public void logEvent(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 5) {
                        this.stepTrans.serverExist = true;
                        return;
                    }
                    return;
                } else {
                    this.stepTrans.flowDown += i16;
                    return;
                }
            }
            this.stepTrans.flowUp += i16;
            return;
        }
        this.stepTrans.retryCount++;
    }

    public InputStream resetSendStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (InputStream) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        try {
            this.sendStream = new FileInputStream(this.filePath);
        } catch (FileNotFoundException unused) {
            this.sendStream = null;
        }
        return this.sendStream;
    }

    public void setActionType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.actionType = i3;
        }
    }

    public void setFileId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.uniseq = j3;
        }
    }

    public void setFileKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.fileKey = str;
        }
    }

    public void setFilePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            return;
        }
        try {
            this.filePath = str;
            File file = new File(str);
            this.file = file;
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (this.actionType == 0 && this.sendStream == null) {
                if (this.file.exists()) {
                    this.fileSize = this.file.length();
                    if (str.contains(".")) {
                        this.suffixType = str.substring(str.lastIndexOf(".")).toLowerCase();
                    }
                }
                this.sendStream = new FileInputStream(str);
                return;
            }
            if (this.revStream == null) {
                if (this.fileType == 0) {
                    this.revStream = new FileOutputStream(str, true);
                } else {
                    this.revStream = new FileOutputStream(str);
                }
            }
        } catch (FileNotFoundException unused) {
            this.filePath = null;
        }
    }

    public void setFileType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.fileType = i3;
        }
    }

    public void setFileUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.fileUrl = str;
        }
    }

    public void setPicScale(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.picScale = i3;
        }
    }

    public void setRcvStream(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            return;
        }
        try {
            if (this.revStream == null) {
                if (this.fileType == 0) {
                    this.revStream = new FileOutputStream(str, true);
                } else {
                    this.revStream = new FileOutputStream(str);
                }
            }
        } catch (FileNotFoundException unused) {
            this.filePath = null;
        }
    }

    public void setServerPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.serverPath = str;
        }
    }

    public FileMsg(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, Integer.valueOf(i3));
            return;
        }
        this.actionType = -1;
        this.fileType = -1;
        this.status = -1;
        this.lastStatus = -1;
        this.processorDoReportSelf = false;
        this.fileKey = "";
        this.filePath = "";
        this.thumbPath = "";
        this.tmpFilePath = "";
        this.revStream = null;
        this.processor = null;
        this.peerUin = "";
        this.selfUin = "";
        this.msgTime = "";
        this.stepSig = new StepBaseInfo();
        this.stepUrl = new StepBaseInfo();
        this.stepNotify = new StepBaseInfo();
        this.stepTrans = new StepTransInfo();
        this.stepMsgDirecDown = new StepTransInfo();
        this.logTag = defaultTag;
        this.uinType = -1;
        this.currPofSendStream = 0;
        this.isStreamMode = false;
        this.appShareUrl = "";
        this.appShareID = 0L;
        try {
            this.startTime = System.currentTimeMillis();
            this.mUin = str;
            this.actionType = i3;
            if (str2 == null) {
                return;
            }
            if (i3 == 0) {
                this.filePath = str2;
                File file = new File(this.filePath);
                this.file = file;
                if (file.exists()) {
                    this.fileSize = this.file.length();
                    int lastIndexOf = str2.lastIndexOf(".");
                    if (lastIndexOf >= 0 && lastIndexOf < str2.length()) {
                        this.suffixType = str2.substring(lastIndexOf).toLowerCase();
                    }
                }
                openSendFile(str2);
                return;
            }
            this.serverPath = str2;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
