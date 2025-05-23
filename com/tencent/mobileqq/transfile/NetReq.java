package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class NetReq {
    static IPatchRedirector $redirector_ = null;
    public static final int PRIOTY_HIGH = 0;
    public static final int PRIOTY_LOW = 2;
    public static final int PRIOTY_NORMAL = 1;
    public boolean bAcceptNegativeContentLength;
    public int mBusiProtoType;
    public INetEngineListener mCallback;
    public boolean mCanPrintUrl;
    public int mContinuErrorLimit;
    public int mContinueConnReusedErrorLimit;
    public long mDelayTime;
    public long mEndDownOffset;
    public long mExcuteTimeLimit;
    public NetFailedListener mFailedListener;
    public int mFileType;
    public HostParseToIp mHostParseToIp;
    public boolean mIsNetChgAsError;
    public boolean mIsRenameInEngine;
    public String mKey;
    public String mMsgId;
    public String mOutPath;
    public OutputStream mOutStream;
    public int mPrioty;
    public Object mPrivate;
    public HashMap<String, String> mReqProperties;
    public NetResp mResp;
    public byte[] mSendData;
    public List<ServerAddr> mServerList;
    public long mStartDownOffset;
    public boolean mSupportBreakResume;
    public String mTempPath;
    public boolean mUseByteArrayPool;
    public boolean mUseRaf;
    private Object mUserData;
    public long taskStartTime;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface HostParseToIp {
        List<ServerAddr> getIpByHost(String str);
    }

    public NetReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mStartDownOffset = 0L;
        this.mEndDownOffset = 0L;
        this.mIsRenameInEngine = true;
        this.mDelayTime = 0L;
        this.mExcuteTimeLimit = 480000L;
        this.mContinuErrorLimit = 8;
        this.mContinueConnReusedErrorLimit = 5;
        this.mIsNetChgAsError = false;
        this.mPrioty = 1;
        this.mResp = null;
        this.mCanPrintUrl = true;
        this.bAcceptNegativeContentLength = true;
        this.mUseByteArrayPool = false;
        this.mKey = null;
        this.taskStartTime = -1L;
        this.mReqProperties = new HashMap<>();
    }

    public long getTaskCostTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        if (this.taskStartTime > 0) {
            return SystemClock.uptimeMillis() - this.taskStartTime;
        }
        return -1L;
    }

    public synchronized Object getUserData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mUserData;
    }

    public boolean isWriteToFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.mOutPath != null) {
            return true;
        }
        return false;
    }

    public boolean isWriteToStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.mOutStream != null) {
            return true;
        }
        return false;
    }

    public boolean saveRecvDataInTransLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.mOutPath == null && this.mOutStream == null) {
            return false;
        }
        return true;
    }

    public synchronized void setUserData(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
        } else {
            this.mUserData = obj;
        }
    }
}
