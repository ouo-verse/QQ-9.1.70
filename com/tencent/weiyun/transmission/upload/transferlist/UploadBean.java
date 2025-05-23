package com.tencent.weiyun.transmission.upload.transferlist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadBean {
    static IPatchRedirector $redirector_;
    public String batchDesc;
    public String batchId;
    public long batchIndex;
    public long batchTotal;
    public String cloudDirName;
    public int compressFlag;
    public long curSize;
    public long duration;
    public int errorCode;
    public String errorMsg;
    public String fileId;
    public String fileName;
    public long fileSize;
    public String fileVersion;
    public String groupRootDirKey;
    public String groupUid;
    public long height;

    /* renamed from: id, reason: collision with root package name */
    public long f384463id;
    public long insertTime;
    public double latitude;
    public long localModified;
    public String localPath;
    public double longitude;
    public String pDirKey;
    public String sha;
    public int state;
    public long takenTime;
    public String thumbUri;
    public long totalSize;
    public String uid;
    public long width;

    public UploadBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
