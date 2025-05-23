package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.wx.voice.vad.WXVadSeg;
import java.io.OutputStream;
import tencent.im.cs.cmd0x388.cmd0x388$StoreFileInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TransferRequest {
    static IPatchRedirector $redirector_;
    public boolean bEnableEnc;
    public int chatType;
    public int delayShowProgressTimeInMs;
    public Object extraObject;
    public boolean isJubaoMsgType;
    public boolean isQzonePic;
    public boolean isShareImageByServer;
    public int mBusiType;
    public boolean mCanSendMsg;
    public int mCommandId;
    public int mDbRecVersion;
    public String mDisplayOutFilePath;
    public com.tencent.mobileqq.pic.c mDownCallBack;
    public int mDownMode;
    public byte[] mExtentionInfo;
    public Object mExtraObj;
    public long mFastForwardFileSize;
    public int mFastForwardHeight;
    public int mFastForwardWidth;
    public int mFileType;
    public long mGroupFileID;
    public String mGroupFileKeyStr;
    public boolean mIsFastForward;
    public boolean mIsOnlyGetUrl;
    public boolean mIsPresend;
    public boolean mIsPttPreSend;
    public boolean mIsSecSnapChatPic;
    public boolean mIsSelfSend;
    public boolean mIsUp;
    private String mKey;
    public String mLocalPath;
    public String mMd5;
    public long mMsgTime;
    public boolean mNeedReport;
    public OutputStream mOut;
    public String mOutFilePath;
    public String mPeerUin;
    public int mPicSendSource;
    public int mPrioty;
    public boolean mPttCompressFinish;
    public int mPttUploadPanel;
    public MessageRecord mRec;
    public boolean mReqVideoSubtitle;
    public int mRequestDisplayLength;
    public int mRequestLength;
    public int mRequestOffset;
    public TransferResult mResult;
    public String mRichTag;
    public long mSecMsgId;
    public String mSecondId;
    public String mSelfUin;
    public String mServerPath;
    public int mSourceVideoCodecFormat;
    public long mSubMsgId;
    public boolean mSupportRangeBreakDown;
    public int mTargetVideoCodecFormat;
    public String mThumbMd5;
    public String mThumbPath;
    public int mUinType;
    public long mUniseq;
    public ad mUpCallBack;
    public int multiMsgType;
    public boolean myPresendInvalid;
    public boolean needSendMsg;
    public int pcmForVadNum;
    public String pcmForVadPath;
    public int pcmForVadPos;
    public PhotoSendParams photoSendParams;
    public String resIdStr;
    public cmd0x388$StoreFileInfo storeFileInfo;
    public byte[] toSendData;
    public int upMsgBusiType;
    public boolean useOutputstream;
    public WXVadSeg vadSeg;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class AppInfo {
        static IPatchRedirector $redirector_;
        public String packName;
        public String sourceIconBig;
        public String sourceIconSmall;
        public String sourceName;
        public String sourceUrl;
        public int status;

        public AppInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class AppShare {
        static IPatchRedirector $redirector_;
        public long mAppShareID;
        public String mShareUrl;

        public AppShare() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mAppShareID:" + this.mAppShareID);
            sb5.append(",mShareUrl:" + this.mShareUrl);
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class PicDownExtraInfo {
        static IPatchRedirector $redirector_;
        public URLDrawableHandler mHandler;
        public int mStartDownOffset;
        public String mUrlFromMsg;

        public PicDownExtraInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mUrlFromMsg:" + this.mUrlFromMsg);
            sb5.append(",mStartDownOffset:" + this.mStartDownOffset);
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class PicUpExtraInfo {
        static IPatchRedirector $redirector_;
        public boolean mIsRaw;
        public boolean mIsShareAppPic;
        public AppShare mShareAppInfo;
        public int mUinType;

        public PicUpExtraInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mUinType:" + this.mUinType);
            sb5.append(",mIsRaw:" + this.mIsRaw);
            sb5.append(",mIsShareAppPic:" + this.mIsShareAppPic);
            sb5.append(",mShareAppInfo:{" + this.mShareAppInfo + "}");
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class PttDownExtraInfo {
        static IPatchRedirector $redirector_;
        public int mFromType;
        public int mLayer;

        public PttDownExtraInfo(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.mFromType = i3;
                this.mLayer = i16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class ShareExtraInfo {
        static IPatchRedirector $redirector_;
        public long appId;
        public AppInfo appInfo;
        public String audioUrl;
        public boolean enableServerSendMsg;
        public int forwardType;
        public String imageUrl;
        public int imageUrlStatus;
        public String pkgName;
        public int serviceType;
        public int shortUrlStatus;
        public String summary;
        public String targetUrl;
        public String title;

        public ShareExtraInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public TransferRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mRichTag = "";
        this.isJubaoMsgType = false;
        this.mIsSelfSend = false;
        this.useOutputstream = true;
        this.mSupportRangeBreakDown = false;
        this.mDbRecVersion = 5;
        this.needSendMsg = true;
        this.mPrioty = 1;
        this.mRec = null;
        this.mNeedReport = true;
        this.mIsOnlyGetUrl = false;
        this.mIsFastForward = false;
        this.myPresendInvalid = false;
        this.mPttCompressFinish = false;
        this.bEnableEnc = false;
        this.isQzonePic = false;
        this.mKey = null;
    }

    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String str = this.mKey;
        if (str == null) {
            return this.mPeerUin + "_" + this.mFileType + "_" + this.mUniseq + "_" + this.mSubMsgId;
        }
        return str;
    }

    public String getKeyForTransfer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mPeerUin + this.mUniseq;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("TransferRequest\n");
        sb5.append("mUniseq=" + this.mUniseq);
        sb5.append(",mMd5=" + this.mMd5);
        sb5.append(",mIsIp=" + this.mIsUp);
        sb5.append(",mUinType=" + this.mUinType);
        sb5.append(",mFileType=" + this.mFileType);
        sb5.append(",mSelfUin=" + this.mSelfUin);
        sb5.append(",mPeerUin=" + this.mPeerUin);
        sb5.append(",mSecondId=" + this.mSecondId);
        sb5.append(",mServerPath=" + this.mServerPath);
        sb5.append(",mLocalPath=" + this.mLocalPath);
        sb5.append(",mBusiType=" + this.mBusiType);
        sb5.append(",mGroupFileID=" + this.mGroupFileID);
        sb5.append(",mExtraObj={" + this.mExtraObj + "}");
        StringBuilder sb6 = new StringBuilder();
        sb6.append(",mPrioty=");
        sb6.append(this.mPrioty);
        sb5.append(sb6.toString());
        sb5.append(",mLogicCallBack=" + this.mUpCallBack);
        sb5.append(",bEnableEnc=" + this.bEnableEnc);
        sb5.append(",isQzonePic=" + this.isQzonePic);
        sb5.append(",pcmForVadPath=" + this.pcmForVadPath);
        return sb5.toString();
    }
}
