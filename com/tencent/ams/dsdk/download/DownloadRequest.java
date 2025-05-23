package com.tencent.ams.dsdk.download;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadRequest {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_MAX_RETRY_COUNT = 3;
    private Executor mDownloadExecutor;
    private String mExtendInfo;
    private String mFileMd5;
    private String mFolder;
    private int mMaxRetryCount;
    private String mName;
    private String mUrl;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private Executor mDownloadExecutor;
        private String mExtendInfo;
        private String mFileMd5;
        private String mFolder;
        private int mMaxRetryCount;
        private String mName;
        private String mUrl;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private String getName() {
            String substring;
            if (TextUtils.isEmpty(this.mName) && !TextUtils.isEmpty(this.mUrl)) {
                int indexOf = this.mUrl.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                if (indexOf == -1) {
                    substring = this.mUrl;
                } else {
                    substring = this.mUrl.substring(0, indexOf);
                }
                if (!TextUtils.isEmpty(substring)) {
                    this.mName = substring.substring(substring.lastIndexOf("/") + 1);
                }
            }
            return this.mName;
        }

        public DownloadRequest build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (DownloadRequest) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return new DownloadRequest(this.mUrl, this.mFileMd5, this.mFolder, getName(), this.mMaxRetryCount, this.mExtendInfo, this.mDownloadExecutor, null);
        }

        public Builder setDownloadExecutor(Executor executor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) executor);
            }
            this.mDownloadExecutor = executor;
            return this;
        }

        public Builder setExtendInfo(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.mExtendInfo = str;
            return this;
        }

        public Builder setFileMd5(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.mFileMd5 = str;
            return this;
        }

        public Builder setFolder(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.mFolder = str;
            return this;
        }

        public Builder setMaxRetryCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.mMaxRetryCount = i3;
            return this;
        }

        public Builder setName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.mName = str;
            return this;
        }

        public Builder setUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.mUrl = str;
            return this;
        }
    }

    /* synthetic */ DownloadRequest(String str, String str2, String str3, String str4, int i3, String str5, Executor executor, AnonymousClass1 anonymousClass1) {
        this(str, str2, str3, str4, i3, str5, executor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, this, str, str2, str3, str4, Integer.valueOf(i3), str5, executor, anonymousClass1);
    }

    public Executor getDownloadExecutor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Executor) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mDownloadExecutor;
    }

    public String getExtendInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mExtendInfo;
    }

    public String getFileMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mFileMd5;
    }

    public String getFolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mFolder;
    }

    public int getMaxRetryCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mMaxRetryCount;
    }

    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mName;
    }

    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mUrl;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "DownloadRequest{url='" + this.mUrl + "', md5='" + this.mFileMd5 + "', folder='" + this.mFolder + "', name='" + this.mName + "', maxRetryCount='" + this.mMaxRetryCount + "', extendInfo='" + this.mExtendInfo + "'}";
    }

    DownloadRequest(String str, String str2, String str3, String str4, int i3, String str5, Executor executor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, Integer.valueOf(i3), str5, executor);
            return;
        }
        this.mMaxRetryCount = 3;
        this.mUrl = str;
        this.mFileMd5 = str2;
        this.mFolder = str3;
        this.mName = str4;
        this.mMaxRetryCount = i3 <= 0 ? 3 : i3;
        this.mExtendInfo = str5;
        this.mDownloadExecutor = executor;
    }
}
