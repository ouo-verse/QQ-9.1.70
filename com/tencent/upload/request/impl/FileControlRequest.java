package com.tencent.upload.request.impl;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.DumpBussinessReq;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.stEnvironment;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.request.UploadRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileControlRequest extends UploadRequest {
    static IPatchRedirector $redirector_;
    private String mAppid;
    private int mAsyUpload;
    private byte[] mBizReq;
    private CheckType mCheckType;
    private String mChecksum;
    private Map<Integer, DumpBussinessReq> mDumpReq;
    private Map<String, String> mExtend_info;
    private long mFileLength;
    private UploadModel mModel;
    private boolean mNeedCheck;
    private boolean mNeedIpRedirect;
    private String mSession;
    private stEnvironment mStEnv;
    private AuthToken mToken;
    private String mUin;

    public FileControlRequest(String str, String str2, AuthToken authToken, String str3, CheckType checkType, long j3, stEnvironment stenvironment, UploadModel uploadModel, String str4, boolean z16, boolean z17, int i3, Map<Integer, DumpBussinessReq> map, Map<String, String> map2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, authToken, str3, checkType, Long.valueOf(j3), stenvironment, uploadModel, str4, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), map, map2);
            return;
        }
        this.mUin = str;
        this.mAppid = str2;
        this.mToken = authToken;
        this.mChecksum = str3;
        this.mCheckType = checkType;
        this.mFileLength = j3;
        this.mStEnv = stenvironment;
        this.mModel = uploadModel;
        this.mSession = str4;
        this.mNeedIpRedirect = z16;
        this.mNeedCheck = z17;
        this.mAsyUpload = i3;
        this.mDumpReq = map;
        this.mExtend_info = map2;
    }

    @Override // com.tencent.upload.request.UploadRequest
    public JceStruct createJceRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JceStruct) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        FileControlReq fileControlReq = new FileControlReq();
        fileControlReq.uin = this.mUin;
        fileControlReq.appid = this.mAppid;
        fileControlReq.token = this.mToken;
        fileControlReq.file_len = this.mFileLength;
        fileControlReq.env = this.mStEnv;
        fileControlReq.model = this.mModel.value();
        fileControlReq.biz_req = this.mBizReq;
        fileControlReq.session = this.mSession;
        fileControlReq.need_ip_redirect = this.mNeedIpRedirect;
        fileControlReq.check_type = this.mCheckType.value();
        fileControlReq.checksum = this.mChecksum;
        if (this.mNeedCheck) {
            fileControlReq.check_type = this.mCheckType.value();
        }
        fileControlReq.asy_upload = this.mAsyUpload;
        fileControlReq.dumpReq = this.mDumpReq;
        fileControlReq.extend_info = this.mExtend_info;
        return fileControlReq;
    }

    public long getFileDataLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.mFileLength;
    }

    public void setExtraParam(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        } else {
            this.mBizReq = bArr;
        }
    }

    @Override // com.tencent.upload.request.UploadRequest
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "taskId=" + getTaskId() + " reqId=" + getRequestId() + " cmd=" + getCmdId() + " mUin=" + this.mUin + " mAppid=" + this.mAppid + " mChecksum=" + this.mChecksum + " mCheckType=" + this.mCheckType + " mFileLength=" + this.mFileLength + " mModel=" + this.mModel + " mSession=" + this.mSession + " mNeedIpRedirect=" + this.mNeedIpRedirect;
    }
}
