package com.tencent.weiyun.transmission.upload;

import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.uploader.IUploader;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadJobContext implements Comparable<UploadJobContext> {
    static IPatchRedirector $redirector_;
    private volatile long mBirthTime;
    private volatile boolean mCanceled;
    private UploadNative.CanceledFlag mCanceledFlag;
    private long mDbId;
    private final UploadFile mFile;
    private String mFileVersion;
    private volatile boolean mIgnoreNetLimit;
    private final String mJobOwnerUid;
    private final Set<UploadManager.IUploadStatusListener> mListeners;
    private volatile boolean mPriority;
    private volatile int mRank;
    private UploadRequest mRequest;
    private final StatisticsTimes mStatisticsTimes;
    private final StatusInfo mStatusInfo;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public final class StatisticsTimes {
        static IPatchRedirector $redirector_;
        private long calShaEndTime;
        private long calShaStartTime;
        private long compressEndTime;
        private long compressStartTime;
        private long fetchUrlEndTime;
        private long fetchUrlStartTime;

        StatisticsTimes() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UploadJobContext.this);
                return;
            }
            this.fetchUrlEndTime = 0L;
            this.fetchUrlStartTime = 0L;
            this.calShaEndTime = 0L;
            this.calShaStartTime = 0L;
            this.compressEndTime = 0L;
            this.compressStartTime = 0L;
        }

        public long[] getStatisticsTimes() {
            long j3;
            long j16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (long[]) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            long[] jArr = new long[3];
            long j17 = this.compressEndTime;
            long j18 = this.compressStartTime;
            long j19 = 0;
            if (j17 <= j18) {
                j3 = 0;
            } else {
                j3 = j17 - j18;
            }
            jArr[0] = j3;
            long j26 = this.calShaEndTime;
            long j27 = this.calShaStartTime;
            if (j26 <= j27) {
                j16 = 0;
            } else {
                j16 = j26 - j27;
            }
            jArr[1] = j16;
            long j28 = this.fetchUrlEndTime;
            long j29 = this.fetchUrlStartTime;
            if (j28 > j29) {
                j19 = j28 - j29;
            }
            jArr[2] = j19;
            return jArr;
        }

        public void onCalShaEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                this.calShaEndTime = System.currentTimeMillis();
            }
        }

        public void onCalShaStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.calShaStartTime = System.currentTimeMillis();
            }
        }

        public void onCompressEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.compressEndTime = System.currentTimeMillis();
            }
        }

        public void onCompressStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.compressStartTime = System.currentTimeMillis();
            }
        }

        public void onFetchUrlEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                this.fetchUrlEndTime = System.currentTimeMillis();
            }
        }

        public void onFetchUrlStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                this.fetchUrlStartTime = System.currentTimeMillis();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class StatusInfo implements Cloneable {
        static IPatchRedirector $redirector_ = null;
        public static final int STATE_COMPRESSING = 2;
        public static final int STATE_FAILED = 6;
        public static final int STATE_INIT = 0;
        public static final int STATE_RUNNING = 3;
        public static final int STATE_SUCCESS = 5;
        public static final int STATE_SUSPEND = 4;
        public static final int STATE_WAIT = 1;
        public long adSpeed;
        public boolean autoBackupFlag;
        public long currSize;
        public int errorCode;
        public String errorMsg;
        public long exSpeed;
        public String fileId;
        public String filePath;
        public String fileVersion;
        public UploadJobContext jobContext;
        public long speed;
        public volatile int state;
        public long totalSize;

        public StatusInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.state = 0;
            this.errorCode = 0;
            this.errorMsg = "";
            this.totalSize = 0L;
            this.currSize = 0L;
            this.speed = 0L;
            this.exSpeed = 0L;
            this.adSpeed = 0L;
            this.filePath = "";
            this.fileId = "";
            this.fileVersion = "";
            this.autoBackupFlag = false;
        }

        public boolean canRestart() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.state == 0 || this.state == 6 || this.state == 4) {
                return true;
            }
            if (this.state == 1 && ((i3 = this.errorCode) == 1810003 || i3 == 1810004)) {
                return true;
            }
            return false;
        }

        public boolean canRunning() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (this.state == 1 && (i3 = this.errorCode) != 1810003 && i3 != 1810004) {
                return true;
            }
            return false;
        }

        public boolean canSuspend() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.state == 0 || this.state == 1 || this.state == 2 || this.state == 3) {
                return true;
            }
            return false;
        }

        public boolean isCompressing() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            if (this.state == 2) {
                return true;
            }
            return false;
        }

        public boolean waitingNet() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            if (this.state == 1 && ((i3 = this.errorCode) == 1810003 || i3 == 1810004)) {
                return true;
            }
            return false;
        }

        public boolean waitingNetError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
            }
            if (i3 != 1810003 && i3 != 1810004) {
                return false;
            }
            return true;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public StatusInfo m292clone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (StatusInfo) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            try {
                return (StatusInfo) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }

    UploadJobContext(String str, UploadFile uploadFile, StatusInfo statusInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, uploadFile, statusInfo);
            return;
        }
        this.mJobOwnerUid = str;
        this.mFile = uploadFile;
        this.mStatusInfo = statusInfo;
        this.mListeners = Collections.newSetFromMap(new WeakHashMap());
        this.mStatisticsTimes = new StatisticsTimes();
        this.mCanceledFlag = new UploadNative.CanceledFlag(false);
    }

    public static UploadJobContext createInstance(String str, UploadFile uploadFile, StatusInfo statusInfo) {
        if (!TextUtils.isEmpty(str) && uploadFile != null && statusInfo != null) {
            return new UploadJobContext(str, uploadFile, statusInfo);
        }
        throw new IllegalArgumentException("The params jobOwnerUid, file, destDirKey and statusInfo should be valid.");
    }

    public void addListener(UploadManager.IUploadStatusListener iUploadStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) iUploadStatusListener);
        } else if (iUploadStatusListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.add(iUploadStatusListener);
            }
        }
    }

    public void addListeners(Collection<UploadManager.IUploadStatusListener> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) collection);
        } else if (collection != null) {
            synchronized (this.mListeners) {
                this.mListeners.addAll(collection);
            }
        }
    }

    public long birthTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.mBirthTime;
    }

    public StatusInfo cloneStatusInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (StatusInfo) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.mStatusInfo.m292clone();
    }

    public void createUploadRequest(UploadFile.UploadServerInfo uploadServerInfo, IUploader.IUploadListener iUploadListener) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) uploadServerInfo, (Object) iUploadListener);
            return;
        }
        if (uploadServerInfo == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("report", "Weiyun-Report");
        hashMap.put("uid", this.mJobOwnerUid);
        hashMap.put("db_id", Long.toString(dbId()));
        hashMap.put("file_name", this.mFile.fileName);
        hashMap.put("p_dir_key", this.mFile.pDirKey);
        hashMap.put("file_id", uploadServerInfo.fileId);
        hashMap.put(WidgetCacheLunarData.SHA, this.mFile.sha);
        if (uploadServerInfo.fileExist) {
            uploadServerInfo.checkKey = GlobalUtil.DEF_STRING;
            uploadServerInfo.serverName = GlobalUtil.DEF_STRING;
            uploadServerInfo.serverIp = GlobalUtil.DEF_STRING;
        }
        String str3 = this.mJobOwnerUid;
        if (str3 == null) {
            str3 = "";
        }
        int length = str3.length();
        int i3 = 0;
        int i16 = -1;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (i16 == -1) {
                if (Character.isDigit(str3.charAt(i3))) {
                    i16 = i3;
                }
            } else if (!Character.isDigit(str3.charAt(i3))) {
                length = i3;
                break;
            }
            i3++;
        }
        if (i16 > -1 && length > i16) {
            str = str3.substring(i16, length);
        } else {
            str = "0";
        }
        UploadRequest.Builder builder = new UploadRequest.Builder();
        if (TextUtils.isEmpty(uploadServerInfo.fileId)) {
            str2 = this.mFile.localPath + this.mFile.pDirKey;
        } else {
            str2 = uploadServerInfo.fileId;
        }
        UploadRequest.Builder uploadedSize = builder.requestKey(str2).listener(iUploadListener).uin(Long.parseLong(str)).fileId(uploadServerInfo.fileId).checkKey(uploadServerInfo.checkKey).serverName(uploadServerInfo.serverName).serverIp(uploadServerInfo.serverIp).serverPort(uploadServerInfo.serverPort).channelCount(uploadServerInfo.channelCount).businessData(hashMap).uploadedSize(this.mStatusInfo.currSize);
        long[] statisticsTimes = this.mStatisticsTimes.getStatisticsTimes();
        uploadedSize.statisticTime(statisticsTimes[0], statisticsTimes[1], statisticsTimes[2]);
        if (TextUtils.isEmpty(this.mFile.compressedPath)) {
            uploadedSize.path(this.mFile.localPath).sha(this.mFile.sha).sliceSha(this.mFile.sliceSha).size(this.mFile.fileSize);
        } else {
            uploadedSize.path(this.mFile.compressedPath).sha(this.mFile.compressedSha).sliceSha(this.mFile.compressedSliceSha).size(this.mFile.compressedSize);
        }
        this.mRequest = uploadedSize.build();
    }

    public long dbId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
        }
        return this.mDbId;
    }

    public UploadFile file() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (UploadFile) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mFile;
    }

    public String fileVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mFileVersion;
    }

    public UploadNative.CanceledFlag getCanceledFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (UploadNative.CanceledFlag) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mCanceledFlag;
    }

    public void increaseRank() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mRank++;
        }
    }

    public boolean isCanceled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.mCanceled;
    }

    public boolean isIgnoreNetLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.mIgnoreNetLimit;
    }

    public boolean isPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.mPriority;
    }

    public Set<UploadManager.IUploadStatusListener> listeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Set) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        Set<UploadManager.IUploadStatusListener> newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        synchronized (this.mListeners) {
            newSetFromMap.addAll(this.mListeners);
        }
        return newSetFromMap;
    }

    public void removeListener(UploadManager.IUploadStatusListener iUploadStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) iUploadStatusListener);
        } else if (iUploadStatusListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.remove(iUploadStatusListener);
            }
        }
    }

    public void resetRank() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mRank = 0;
        }
    }

    public void setBirthTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.mBirthTime = j3;
        }
    }

    public void setCanceled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.mCanceled = z16;
            this.mCanceledFlag.setCanceled(z16);
        }
    }

    public void setDbId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.mDbId = j3;
        }
    }

    public void setFileVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.mFileVersion = str;
        }
    }

    public void setIgnoreNetLimit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.mIgnoreNetLimit = z16;
        }
    }

    public void setPriority(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mPriority = z16;
        }
    }

    public StatisticsTimes statisticsTimes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (StatisticsTimes) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mStatisticsTimes;
    }

    public StatusInfo statusInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (StatusInfo) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.mStatusInfo;
    }

    public String uid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mJobOwnerUid;
    }

    public UploadRequest uploadRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (UploadRequest) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mRequest;
    }

    @Override // java.lang.Comparable
    public int compareTo(UploadJobContext uploadJobContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this, (Object) uploadJobContext)).intValue();
        }
        boolean canRunning = this.mStatusInfo.canRunning();
        boolean canRunning2 = uploadJobContext.mStatusInfo.canRunning();
        if (canRunning && !canRunning2) {
            return -1;
        }
        if (!canRunning && canRunning2) {
            return 1;
        }
        if (!canRunning && !canRunning2) {
            return 0;
        }
        if (this.mRank > uploadJobContext.mRank) {
            return -1;
        }
        if (this.mRank < uploadJobContext.mRank) {
            return 1;
        }
        if (this.mPriority && !uploadJobContext.mPriority) {
            return -1;
        }
        if (!this.mPriority && uploadJobContext.mPriority) {
            return 1;
        }
        if (this.mBirthTime < uploadJobContext.mBirthTime) {
            return -1;
        }
        return this.mBirthTime > uploadJobContext.mBirthTime ? 1 : 0;
    }
}
