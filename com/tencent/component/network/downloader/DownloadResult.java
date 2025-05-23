package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.open.base.http.HttpBaseUtil;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class DownloadResult implements Parcelable {
    public static final Parcelable.Creator<DownloadResult> CREATOR = new Parcelable.Creator<DownloadResult>() { // from class: com.tencent.component.network.downloader.DownloadResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadResult createFromParcel(Parcel parcel) {
            return new DownloadResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadResult[] newArray(int i3) {
            return new DownloadResult[i3];
        }
    };
    private Content mContent;
    private String mDescInfo;
    private String mDetailDownloadInfo;
    private String mPath;
    private Process mProcess;
    private DownloadReport mReport;
    private Status mStatus;
    private String mUrl;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class Content implements Parcelable {
        public static final Parcelable.Creator<Content> CREATOR = new Parcelable.Creator<Content>() { // from class: com.tencent.component.network.downloader.DownloadResult.Content.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Content createFromParcel(Parcel parcel) {
                return new Content(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Content[] newArray(int i3) {
                return new Content[i3];
            }
        };
        public String clientip;
        public Object content;
        public String encoding;
        public boolean isGzip;
        public String lastModified;
        public long length;
        public String md5;
        public boolean noCache;
        public long realsize;
        public String redirectUrl;
        public int retCode;
        public long size;
        public String type;

        Content() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void reset() {
            this.type = null;
            this.encoding = null;
            this.length = 0L;
            this.size = 0L;
            this.realsize = -1L;
            this.noCache = false;
            this.content = null;
            this.clientip = null;
            this.lastModified = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            if (parcel == null) {
                return;
            }
            parcel.writeString(this.type);
            parcel.writeString(this.encoding);
            parcel.writeLong(this.length);
            parcel.writeLong(this.size);
            parcel.writeLong(this.realsize);
            parcel.writeInt(this.noCache ? 1 : 0);
            parcel.writeString(this.clientip);
            parcel.writeString(this.lastModified);
        }

        public Content(Parcel parcel) {
            if (parcel == null) {
                return;
            }
            this.type = parcel.readString();
            this.encoding = parcel.readString();
            this.length = parcel.readLong();
            this.size = parcel.readLong();
            this.realsize = parcel.readLong();
            this.noCache = parcel.readInt() == 1;
            this.clientip = parcel.readString();
            this.lastModified = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class Process implements Parcelable {
        public static final Parcelable.Creator<Process> CREATOR = new Parcelable.Creator<Process>() { // from class: com.tencent.component.network.downloader.DownloadResult.Process.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Process createFromParcel(Parcel parcel) {
                return new Process(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Process[] newArray(int i3) {
                return new Process[i3];
            }
        };
        public long duration;
        public long endTime;
        public long startTime;
        public long startTimestamp;
        public long totalDuration;

        Process() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.duration = 0L;
        }

        public void setDuration(long j3, long j16) {
            this.startTime = j3;
            this.endTime = j16;
            this.duration = j16 - j3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            if (parcel == null) {
                return;
            }
            parcel.writeLong(this.startTime);
            parcel.writeLong(this.endTime);
            parcel.writeLong(this.duration);
        }

        public Process(Parcel parcel) {
            if (parcel == null) {
                return;
            }
            this.startTime = parcel.readLong();
            this.endTime = parcel.readLong();
            this.duration = parcel.readLong();
        }
    }

    public DownloadResult(String str) {
        this.mStatus = new Status();
        this.mProcess = new Process();
        this.mContent = new Content();
        AssertUtil.assertTrue(!TextUtils.isEmpty(str));
        this.mUrl = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Content getContent() {
        return this.mContent;
    }

    public String getDescInfo() {
        return this.mDescInfo;
    }

    public String getDetailDownloadInfo() {
        return this.mDetailDownloadInfo;
    }

    public String getPath() {
        return this.mPath;
    }

    public Process getProcess() {
        return this.mProcess;
    }

    public DownloadReport getReport() {
        return this.mReport;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public void reset() {
        this.mStatus.reset();
        this.mProcess.reset();
        this.mContent.reset();
    }

    public final void setDescInfo(String str) {
        this.mDescInfo = str;
    }

    public final void setDetailDownloadInfo(String str) {
        this.mDetailDownloadInfo = str;
    }

    public final void setPath(String str) {
        this.mPath = str;
    }

    public final void setReport(DownloadReport downloadReport) {
        this.mReport = downloadReport;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.mUrl);
        parcel.writeString(this.mPath);
        parcel.writeParcelable(this.mStatus, 0);
        parcel.writeParcelable(this.mProcess, 0);
        parcel.writeParcelable(this.mContent, 0);
        parcel.writeString(this.mDescInfo);
        parcel.writeString(this.mDetailDownloadInfo);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class Status implements Parcelable {
        public static final Parcelable.Creator<Status> CREATOR = new Parcelable.Creator<Status>() { // from class: com.tencent.component.network.downloader.DownloadResult.Status.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Status createFromParcel(Parcel parcel) {
                return new Status(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Status[] newArray(int i3) {
                return new Status[i3];
            }
        };
        public static final int REASON_FAIL_CONTENT = 5;
        public static final int REASON_FAIL_EXCEPTION = 4;
        public static final int REASON_FAIL_META = 7;
        public static final int REASON_FAIL_NETWORK = 3;
        public static final int REASON_FAIL_NETWORK_UNAVAILABLE = 6;
        public static final int REASON_FAIL_NONE = 0;
        public static final int REASON_FAIL_SIZE_TOO_LARGE = 8;
        public static final int REASON_FAIL_STORAGE = 2;
        public static final int REASON_FAIL_UNKNOWN = 1;
        public static final int STATE_CANCELED = 4;
        public static final int STATE_FAILED = 2;
        public static final int STATE_RETRYING = 3;
        public static final int STATE_SUCCEED = 1;
        public String detailDownloadInfo;
        public int exception2Code;
        public Throwable failException;
        public int failReason;
        public int httpStatus;
        public int state;

        public Status() {
            this.state = 2;
            this.failReason = 1;
            this.failException = null;
            this.exception2Code = 0;
            this.detailDownloadInfo = "";
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getErrorMessage() {
            int i3 = this.failReason;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 != 8) {
                                    return "";
                                }
                                return "download size too large";
                            }
                            return HttpBaseUtil.NetworkUnavailableException.ERROR_INFO;
                        }
                        return "content type error";
                    }
                    return "download exception";
                }
                return "response error";
            }
            return "storage limit";
        }

        public Throwable getFailException() {
            if (isFailed()) {
                return this.failException;
            }
            return null;
        }

        public int getFailReason() {
            if (isFailed()) {
                return this.failReason;
            }
            return 0;
        }

        public boolean isFailed() {
            if (this.state == 2) {
                return true;
            }
            return false;
        }

        public final boolean isRetrying() {
            if (this.state == 3) {
                return true;
            }
            return false;
        }

        public boolean isSucceed() {
            if (this.state == 1) {
                return true;
            }
            return false;
        }

        public final void reset() {
            this.state = 2;
            this.failReason = 1;
            this.failException = null;
            this.exception2Code = 0;
            this.httpStatus = 0;
        }

        public final void setFailed(int i3) {
            this.state = 2;
            this.failReason = i3;
        }

        final void setRetrying() {
            this.state = 3;
        }

        public final void setSucceed() {
            this.state = 1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            if (parcel == null) {
                return;
            }
            parcel.writeInt(this.state);
            parcel.writeInt(this.failReason);
            parcel.writeInt(this.httpStatus);
            parcel.writeInt(this.exception2Code);
        }

        public final void setFailed(Throwable th5) {
            this.state = 2;
            this.failReason = 4;
            this.failException = th5;
            this.exception2Code = ImageDownloadReporter.getRetCodeFrom(th5, 0);
        }

        public Status(Parcel parcel) {
            this.state = 2;
            this.failReason = 1;
            this.failException = null;
            this.exception2Code = 0;
            this.detailDownloadInfo = "";
            if (parcel == null) {
                return;
            }
            this.state = parcel.readInt();
            this.failReason = parcel.readInt();
            this.httpStatus = parcel.readInt();
            this.exception2Code = parcel.readInt();
        }
    }

    public DownloadResult(Parcel parcel) {
        this.mStatus = new Status();
        this.mProcess = new Process();
        this.mContent = new Content();
        if (parcel == null) {
            return;
        }
        this.mUrl = parcel.readString();
        this.mPath = parcel.readString();
        this.mStatus = (Status) parcel.readParcelable(Status.class.getClassLoader());
        this.mProcess = (Process) parcel.readParcelable(Process.class.getClassLoader());
        this.mContent = (Content) parcel.readParcelable(Content.class.getClassLoader());
        this.mDescInfo = parcel.readString();
        this.mDetailDownloadInfo = parcel.readString();
    }
}
