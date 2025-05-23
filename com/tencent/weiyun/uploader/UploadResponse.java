package com.tencent.weiyun.uploader;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadResponse {
    static IPatchRedirector $redirector_;
    private int mCode;
    private long mCurrentSize;
    private String mErrMsg;
    private final UploadRequest mRequest;
    private long mSpeed;
    private long mTotalSize;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;
        private int code;
        private long currentSize;
        private String errMsg;
        private UploadRequest request;
        private long speed;
        private long totalSize;

        /* synthetic */ Builder(UploadResponse uploadResponse, AnonymousClass1 anonymousClass1) {
            this(uploadResponse);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                return;
            }
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) uploadResponse, (Object) anonymousClass1);
        }

        public UploadResponse build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (UploadResponse) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            if (this.request != null) {
                return new UploadResponse(this, null);
            }
            throw new IllegalStateException("request == null");
        }

        public Builder code(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.code = i3;
            return this;
        }

        public Builder currentSize(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, j3);
            }
            this.currentSize = j3;
            return this;
        }

        public Builder errMsg(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.errMsg = str;
            return this;
        }

        public Builder request(UploadRequest uploadRequest) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uploadRequest);
            }
            this.request = uploadRequest;
            return this;
        }

        public Builder speed(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, j3);
            }
            this.speed = j3;
            return this;
        }

        public Builder totalSize(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
            this.totalSize = j3;
            return this;
        }

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.code = 0;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        Builder(UploadResponse uploadResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uploadResponse);
                return;
            }
            this.request = uploadResponse.mRequest;
            this.code = uploadResponse.mCode;
            this.errMsg = uploadResponse.mErrMsg;
            this.totalSize = uploadResponse.mTotalSize;
            this.currentSize = uploadResponse.mCurrentSize;
            this.speed = uploadResponse.mSpeed;
        }
    }

    /* synthetic */ UploadResponse(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) builder, (Object) anonymousClass1);
    }

    public int code() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mCode;
    }

    public long currentSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.mCurrentSize;
    }

    public String errMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mErrMsg;
    }

    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Builder) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new Builder(this, null);
    }

    public UploadRequest request() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UploadRequest) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mRequest;
    }

    public long speed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.mSpeed;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "UploadResponse{code=" + this.mCode + ", errMsg='" + this.mErrMsg + "'}";
    }

    public long totalSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.mTotalSize;
    }

    UploadResponse(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.mRequest = builder.request;
        this.mCode = builder.code;
        this.mErrMsg = builder.errMsg;
        this.mTotalSize = builder.totalSize;
        this.mCurrentSize = builder.currentSize;
        this.mSpeed = builder.speed;
    }
}
