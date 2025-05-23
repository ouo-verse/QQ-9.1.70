package com.tencent.oskplayer.proxy;

import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.util.ContentTypeFixer;
import com.tencent.oskplayer.util.Fixer;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoRequest {
    private static final int CANCEL_STATE_END_SUCCESS = 3;
    private static final int CANCEL_STATE_IDLE = 0;
    private static final int CANCEL_STATE_PROCCEED = 2;
    private static final int CANCEL_STATE_START = 1;
    private static AtomicInteger SEQ_NUM = new AtomicInteger(10000);
    private static final int STOPPED_REASON_CANCEL = 1;
    public static final int STOPPED_REASON_NORMAL = 16;
    public static final int STOPPED_REASON_OTHER = 257;
    public static final int STOPPED_REASON_THREAD_INTERRUPT = 256;
    private static final int STOPPED_REASON_UNSET = 0;
    private int downloadedBytes;
    private HttpHeader httpHeader;
    private boolean isCacheEnabled;
    private boolean isStopped;
    private VideoCancelListener mVideoCancelListener;
    private String preferredContentType;
    private long rangeEnd;
    private long rangeStart;
    private String requestMethod;
    private int sentBytes;
    private String sourceUrl;
    private Future<?> task;
    private String uuid;
    private String videoKey;
    private String TAG = "VideoRequest";
    private int stoppedReason = 0;
    private int mPrority = -1;
    private int cancelState = 0;
    private long totalLength = -1;
    private String extraLogTag = "";
    private String dataSourceType = "-1";
    private FileType fileType = FileType.UNKNOWN;
    private final Object stateLock = new Object();
    private int contentFormatFlag = 0;
    private int mSeqNum = SEQ_NUM.incrementAndGet();
    private long mStartTime = System.currentTimeMillis();

    private boolean checkCancelState(int i3) {
        boolean z16;
        synchronized (this.stateLock) {
            if (this.cancelState == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    private void enterCancelStartState() {
        if (transCancelState(0, 1)) {
            VideoCancelListener videoCancelListener = this.mVideoCancelListener;
            if (videoCancelListener != null) {
                videoCancelListener.onVideoCancelStart(this);
            }
            if (PlayerConfig.g().isDebugVersion()) {
                PlayerUtils.log(3, getLogTag(), this + "cancel start");
            }
        }
    }

    private boolean transCancelState(int i3, int i16) {
        synchronized (this.stateLock) {
            if (this.cancelState == i3) {
                this.cancelState = i16;
                return true;
            }
            PlayerUtils.log(5, getLogTag(), String.format(Locale.getDefault(), "transState error, current %d, condition %d, newState %d", Integer.valueOf(this.cancelState), Integer.valueOf(i3), Integer.valueOf(i16)));
            return false;
        }
    }

    public void cancel(boolean z16, VideoCancelListener videoCancelListener) {
        this.mVideoCancelListener = videoCancelListener;
        cancel(z16);
    }

    public void enterCancelProceedState() {
        if (transCancelState(1, 2)) {
            VideoCancelListener videoCancelListener = this.mVideoCancelListener;
            if (videoCancelListener != null) {
                videoCancelListener.onVideoCancelProceed(this, 100);
            }
            if (PlayerConfig.g().isDebugVersion()) {
                PlayerUtils.log(3, getLogTag(), this + "cancel proceeding");
            }
        }
    }

    public void enterCancelSuccessState() {
        if (transCancelState(2, 3)) {
            VideoCancelListener videoCancelListener = this.mVideoCancelListener;
            if (videoCancelListener != null) {
                videoCancelListener.onVideoCancelSuccess(this);
            }
            if (PlayerConfig.g().isDebugVersion()) {
                PlayerUtils.log(3, getLogTag(), this + "cancel success");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getContentFormatFlag() {
        return this.contentFormatFlag;
    }

    public Fixer<Map<String, List<String>>> getContentTypeFixer() {
        return new ContentTypeFixer(this.preferredContentType, getLogTag());
    }

    public String getDataSourceType() {
        return this.dataSourceType;
    }

    public synchronized int getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public HttpHeader getExtraHeader() {
        return this.httpHeader;
    }

    public synchronized FileType getFileType() {
        return this.fileType;
    }

    public String getLogTag() {
        return this.extraLogTag + this.TAG;
    }

    public int getPrority() {
        return this.mPrority;
    }

    public long getRangeEnd() {
        return this.rangeEnd;
    }

    public long getRangeStart() {
        return this.rangeStart;
    }

    public synchronized int getSentBytes() {
        return this.sentBytes;
    }

    public int getSeqNum() {
        return this.mSeqNum;
    }

    public String getSourceUrl() {
        return this.sourceUrl;
    }

    public synchronized String getSpeedInfo() {
        String videoRequest;
        float currentTimeMillis;
        videoRequest = toString();
        currentTimeMillis = ((float) (this.sentBytes * 1000)) / ((float) ((System.currentTimeMillis() - this.mStartTime) * 1024));
        return (((videoRequest + ", startTime=" + this.mStartTime) + ", sentBytes=" + this.sentBytes) + ", totalLength=" + this.totalLength) + ", downloadSpeedKBs=" + currentTimeMillis;
    }

    public synchronized long getTotalLength() {
        return this.totalLength;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getVideoKey() {
        return this.videoKey;
    }

    public boolean isCacheEnabled() {
        return this.isCacheEnabled;
    }

    public boolean isCancelProcceed() {
        return checkCancelState(2);
    }

    public boolean isHeadRequest() {
        String str = this.requestMethod;
        if (str != null && str.toLowerCase().equals("head")) {
            return true;
        }
        return false;
    }

    public boolean isIdle() {
        return checkCancelState(0);
    }

    public void setCacheEnabled(boolean z16) {
        this.isCacheEnabled = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setContentFormatFlag(int i3) {
        this.contentFormatFlag = i3;
    }

    public void setDataSourceType(String str) {
        this.dataSourceType = str;
    }

    public synchronized void setDownloadedBytes(int i3) {
        this.downloadedBytes = i3;
    }

    public void setExtraHeader(HttpHeader httpHeader) {
        this.httpHeader = httpHeader;
    }

    public void setIsStopped(boolean z16) {
        this.isStopped = z16;
    }

    public void setLogTag(String str) {
        this.extraLogTag = str;
    }

    public void setPreferredContentType(String str) {
        this.preferredContentType = str;
    }

    public void setPrority(int i3) {
        this.mPrority = i3;
    }

    public void setRangeEnd(long j3) {
        this.rangeEnd = j3;
    }

    public void setRangeStart(long j3) {
        this.rangeStart = j3;
    }

    public void setRequestMethod(String str) {
        this.requestMethod = str;
    }

    public void setSourceUrl(String str) {
        this.sourceUrl = str;
        this.videoKey = PlayerUtils.parseVideoKey(str);
    }

    public void setStoppedReason(int i3) {
        int i16 = this.stoppedReason;
        if ((i16 & i3) == 0) {
            this.stoppedReason = i16 + i3;
        }
    }

    public void setTask(Future<?> future) {
        this.task = future;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public boolean shouldCancel() {
        return checkCancelState(1);
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.toString());
        sb5.append("{sourceUrl=");
        sb5.append(this.sourceUrl);
        sb5.append(",seq=");
        sb5.append(this.mSeqNum);
        sb5.append(",uuid=");
        sb5.append(getUuid());
        sb5.append(",priority=");
        sb5.append(getPrority());
        sb5.append(",requestProperty=");
        HttpHeader httpHeader = this.httpHeader;
        String str2 = "null";
        if (httpHeader == null) {
            str = "null";
        } else {
            str = httpHeader.toString();
        }
        sb5.append(str);
        sb5.append(",range=[");
        sb5.append(getRangeStart());
        sb5.append(",");
        sb5.append(getRangeEnd());
        sb5.append("],preferredContentType=");
        sb5.append(this.preferredContentType);
        sb5.append(",cancelState=");
        sb5.append(this.cancelState);
        sb5.append(",task=");
        Future<?> future = this.task;
        if (future != null) {
            str2 = future.toString();
        }
        sb5.append(str2);
        sb5.append("}");
        return sb5.toString();
    }

    public synchronized void updateInfo(long j3, FileType fileType) {
        this.totalLength = j3;
        this.fileType = fileType;
        if (fileType.equals(FileType.VIDEO_MP4)) {
            this.contentFormatFlag |= 8;
        }
    }

    public synchronized void updateSentBytes(int i3) {
        this.sentBytes += i3;
    }

    public void cancel(VideoCancelListener videoCancelListener) {
        cancel(true, videoCancelListener);
    }

    public void cancel() {
        cancel(true);
    }

    public void cancel(boolean z16) {
        if (this.task != null) {
            enterCancelStartState();
            setStoppedReason(1);
            this.task.cancel(z16);
        }
    }
}
