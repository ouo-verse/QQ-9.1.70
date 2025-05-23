package com.tencent.weiyun.uploader;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.uploader.IUploader;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadRequest {
    static IPatchRedirector $redirector_;
    private Object mBusinessData;
    private int mChannelCount;
    private final String mCheckKey;
    private final String mFileId;
    private final IUploader.IUploadListener mListener;
    private final String mPath;
    private final String mRequestKey;
    private final String mServerIp;
    private final String mServerName;
    private final int mServerPort;
    private final String mSha;
    private final long mSize;
    private final String[] mSliceSha;
    private long[] mStatisticTimes;
    private final long mUin;
    private final long mUploadedSize;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private Object businessData;
        private int channelCount;
        private String checkKey;
        private String fileId;
        private IUploader.IUploadListener listener;
        private String path;
        private String requestKey;
        private String serverIp;
        private String serverName;
        private int serverPort;
        private String sha;
        private long size;
        private String[] sliceSha;
        private long[] statisticTimes;
        private long uin;
        private long uploadedSize;

        /* synthetic */ Builder(UploadRequest uploadRequest, AnonymousClass1 anonymousClass1) {
            this(uploadRequest);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
                return;
            }
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) uploadRequest, (Object) anonymousClass1);
        }

        public UploadRequest build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (UploadRequest) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            if (!TextUtils.isEmpty(this.path)) {
                if (!TextUtils.isEmpty(this.fileId)) {
                    if (this.uin != 0 && !TextUtils.isEmpty(this.sha) && !TextUtils.isEmpty(this.checkKey) && (!TextUtils.isEmpty(this.serverName) || !TextUtils.isEmpty(this.serverIp))) {
                        if (TextUtils.isEmpty(this.requestKey)) {
                            this.requestKey = this.fileId;
                        }
                        return new UploadRequest(this, null);
                    }
                    throw new IllegalStateException("uin, sha, checkKey, serverName or serverIp is invalid.");
                }
                throw new IllegalStateException("fileId is empty");
            }
            throw new IllegalStateException("path is empty");
        }

        public Builder businessData(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, obj);
            }
            this.businessData = obj;
            return this;
        }

        public Builder channelCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, i3);
            }
            this.channelCount = i3;
            return this;
        }

        public Builder checkKey(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            }
            this.checkKey = str;
            return this;
        }

        public Builder fileId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            }
            this.fileId = str;
            return this;
        }

        public Builder listener(IUploader.IUploadListener iUploadListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) iUploadListener);
            }
            this.listener = iUploadListener;
            return this;
        }

        public Builder path(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.path = str;
            return this;
        }

        public Builder requestKey(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.requestKey = str;
            return this;
        }

        public Builder serverIp(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            }
            this.serverIp = str;
            return this;
        }

        public Builder serverName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            }
            this.serverName = str;
            return this;
        }

        public Builder serverPort(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, i3);
            }
            this.serverPort = i3;
            return this;
        }

        public Builder sha(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.sha = str;
            return this;
        }

        public Builder size(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, j3);
            }
            this.size = j3;
            return this;
        }

        public Builder sliceSha(String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) strArr);
            }
            this.sliceSha = strArr;
            return this;
        }

        public Builder statisticTime(long j3, long j16, long j17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            }
            this.statisticTimes = new long[]{j3, j16, j17};
            return this;
        }

        public Builder uin(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
            this.uin = j3;
            return this;
        }

        public Builder uploadedSize(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, j3);
            }
            this.uploadedSize = j3;
            return this;
        }

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        Builder(UploadRequest uploadRequest) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uploadRequest);
                return;
            }
            this.requestKey = uploadRequest.mRequestKey;
            this.listener = uploadRequest.mListener;
            this.uin = uploadRequest.mUin;
            this.path = uploadRequest.mPath;
            this.sha = uploadRequest.mSha;
            this.sliceSha = uploadRequest.mSliceSha;
            this.size = uploadRequest.mSize;
            this.uploadedSize = uploadRequest.mUploadedSize;
            this.fileId = uploadRequest.mFileId;
            this.checkKey = uploadRequest.mCheckKey;
            this.serverName = uploadRequest.mServerName;
            this.serverIp = uploadRequest.mServerIp;
            this.serverPort = uploadRequest.mServerPort;
            this.channelCount = uploadRequest.mChannelCount;
            this.businessData = uploadRequest.mBusinessData;
            this.statisticTimes = uploadRequest.mStatisticTimes;
        }
    }

    /* synthetic */ UploadRequest(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this, (Object) builder, (Object) anonymousClass1);
    }

    public Object businessData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mBusinessData;
    }

    public int channelCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.mChannelCount;
    }

    public String checkKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mCheckKey;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UploadRequest)) {
            return false;
        }
        UploadRequest uploadRequest = (UploadRequest) obj;
        String str = this.mRequestKey;
        if (str == null ? uploadRequest.mRequestKey != null : !str.equals(uploadRequest.mRequestKey)) {
            return false;
        }
        IUploader.IUploadListener iUploadListener = this.mListener;
        IUploader.IUploadListener iUploadListener2 = uploadRequest.mListener;
        if (iUploadListener != null) {
            return iUploadListener.equals(iUploadListener2);
        }
        if (iUploadListener2 == null) {
            return true;
        }
        return false;
    }

    public String fileId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mFileId;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        String str = this.mRequestKey;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        IUploader.IUploadListener iUploadListener = this.mListener;
        if (iUploadListener != null) {
            i16 = iUploadListener.hashCode();
        }
        return i17 + i16;
    }

    public IUploader.IUploadListener listener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IUploader.IUploadListener) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mListener;
    }

    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Builder) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new Builder(this, null);
    }

    public String path() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mPath;
    }

    public String requestKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mRequestKey;
    }

    public String serverIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mServerIp;
    }

    public String serverName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mServerName;
    }

    public int serverPort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.mServerPort;
    }

    public String sha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mSha;
    }

    public long size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.mSize;
    }

    public String[] sliceSha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mSliceSha;
    }

    public long[] statisticTimes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (long[]) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mStatisticTimes;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "UploadRequest{requestKey='" + this.mRequestKey + "', listener=" + this.mListener + ", uin=" + this.mUin + ", path='" + this.mPath + "', sha='" + this.mSha + "', size=" + this.mSize + ", uploadedSize=" + this.mUploadedSize + ", fileId='" + this.mFileId + "', checkKey='" + this.mCheckKey + "', serverName='" + this.mServerName + "', serverIp='" + this.mServerIp + "', serverPort=" + this.mServerPort + ", channelCount=" + this.mChannelCount + ", businessData=" + this.mBusinessData + '}';
    }

    public long uin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.mUin;
    }

    public long uploadedSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.mUploadedSize;
    }

    UploadRequest(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.mRequestKey = builder.requestKey;
        this.mListener = builder.listener;
        this.mUin = builder.uin;
        this.mPath = builder.path;
        this.mSha = builder.sha;
        this.mSliceSha = builder.sliceSha;
        this.mSize = builder.size;
        this.mUploadedSize = builder.uploadedSize;
        this.mFileId = builder.fileId;
        this.mCheckKey = builder.checkKey;
        this.mServerName = builder.serverName;
        this.mServerIp = builder.serverIp;
        this.mServerPort = builder.serverPort;
        this.mChannelCount = builder.channelCount;
        this.mBusinessData = builder.businessData;
        this.mStatisticTimes = builder.statisticTimes;
    }
}
