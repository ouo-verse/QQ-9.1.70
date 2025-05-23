package com.tencent.mobileqq.transfile.quic.open;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QuicReq {
    static IPatchRedirector $redirector_;
    public int mBussinessId;
    public DownloadListener mDownloadListener;
    public long mExcuteTime;
    public int mFec;
    public Map<String, String> mHeaders;
    public String mIp;
    public boolean mIsIpv6;
    public boolean mIsQuicEncryption;
    public String mPath;
    public int mPort;
    public String mRttHost;
    public String mSavePath;
    public String mTempPath;
    public int mTimeOut;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        int mBussinessId;
        DownloadListener mDownloadListener;
        int mFec;
        Map<String, String> mHeaders;
        String mIp;
        boolean mIsIpv6;
        boolean mIsQuicEncryption;
        String mPath;
        int mPort;
        String mRttHost;
        String mSavePath;
        String mTempPath;
        int mTimeOut;

        public Builder(String str, int i3, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, str3);
                return;
            }
            this.mTimeOut = 10000;
            this.mIp = str;
            this.mPort = i3;
            this.mPath = str2;
            this.mSavePath = str3;
        }

        public Builder addHeader(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) str2);
            }
            if (str != null && str2 != null) {
                if (this.mHeaders == null) {
                    this.mHeaders = new LinkedHashMap();
                }
                this.mHeaders.put(str, str2);
                if (QLog.isColorLevel()) {
                    QLog.d("quic", 4, "key: " + str + " value: " + str2);
                }
                return this;
            }
            QLog.e("quic", 4, "key/value is null. key: " + str + " value: " + str2);
            return this;
        }

        public QuicReq build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QuicReq) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new QuicReq(this);
        }

        public Builder businessId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.mBussinessId = i3;
            if (QLog.isColorLevel()) {
                QLog.d("quic", 4, "bussinessId: " + i3);
            }
            return this;
        }

        public Builder fec(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            this.mFec = i3;
            if (QLog.isColorLevel()) {
                QLog.d("quic", 4, "fec: " + i3);
            }
            return this;
        }

        public Builder isIpv6(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, z16);
            }
            this.mIsIpv6 = z16;
            if (QLog.isColorLevel()) {
                QLog.d("quic", 4, "isIpv6: " + z16);
            }
            return this;
        }

        public Builder isQuicEncryption(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.mIsQuicEncryption = z16;
            if (QLog.isColorLevel()) {
                QLog.d("quic", 4, "isQuicEncryption: " + z16);
            }
            return this;
        }

        public Builder listener(DownloadListener downloadListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) downloadListener);
            }
            this.mDownloadListener = downloadListener;
            return this;
        }

        public Builder path(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.mPath = str;
            return this;
        }

        public Builder rttHost(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.mRttHost = str;
            return this;
        }

        public Builder savePath(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.mSavePath = str;
            return this;
        }

        public Builder tempPath(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.mTempPath = str;
            return this;
        }

        public Builder timeOut(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, i3);
            }
            if (this.mTimeOut <= 0) {
                return this;
            }
            this.mTimeOut = i3;
            if (QLog.isColorLevel()) {
                QLog.d("quic", 4, "mTimeOut: " + i3);
            }
            return this;
        }
    }

    QuicReq(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.mTimeOut = 10000;
        this.mPath = builder.mPath;
        this.mSavePath = builder.mSavePath;
        this.mTempPath = builder.mTempPath;
        this.mIsQuicEncryption = builder.mIsQuicEncryption;
        this.mHeaders = builder.mHeaders;
        this.mDownloadListener = builder.mDownloadListener;
        this.mBussinessId = builder.mBussinessId;
        this.mFec = builder.mFec;
        this.mTimeOut = builder.mTimeOut;
        this.mIp = builder.mIp;
        this.mPort = builder.mPort;
        this.mIsIpv6 = builder.mIsIpv6;
        this.mRttHost = builder.mRttHost;
    }
}
